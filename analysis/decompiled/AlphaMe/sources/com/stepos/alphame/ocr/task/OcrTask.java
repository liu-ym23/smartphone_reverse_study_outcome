package com.stepos.alphame.ocr.task;

import androidx.annotation.NonNull;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.ocr.decoder.OcrDecoder;
import com.stepos.alphame.utils.Waiter;

/* loaded from: classes.dex */
public abstract class OcrTask {
    public static final int BLOCK_SUCCESS = 1;
    private final OcrDecoder mDecoder;
    private Waiter mWaiter = null;
    private boolean mCancelled = false;

    public OcrTask(OcrDecoder ocrDecoder) {
        this.mDecoder = ocrDecoder;
    }

    public void cancel() {
        this.mCancelled = true;
    }

    public OcrDecoder getDecoder() {
        return this.mDecoder;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    public void notifyFail(int i4) {
        ActionManager.getInstance().broadcast("OCR_DETECT", new String[]{String.valueOf(0), String.valueOf(i4)});
    }

    public void notifySuccess(String str) {
        ActionManager.getInstance().broadcast("OCR_DETECT", new String[]{String.valueOf(1), str});
    }

    public void onFail(int i4) {
        Waiter waiter = this.mWaiter;
        if (waiter != null) {
            waiter.mErrorCode = i4;
            waiter.unlock();
        }
        notifyFail(i4);
    }

    public void onFutureDone(String str) {
        Waiter waiter = this.mWaiter;
        if (waiter == null) {
            notifySuccess(str);
            return;
        }
        waiter.mErrorCode = 1;
        waiter.mExtra = str;
        waiter.unlock();
    }

    public void setBlocked(Waiter waiter) {
        this.mWaiter = waiter;
    }

    @NonNull
    public String toString() {
        return "task:" + super.toString() + " decoder:" + this.mDecoder.getClass().getSimpleName();
    }
}
