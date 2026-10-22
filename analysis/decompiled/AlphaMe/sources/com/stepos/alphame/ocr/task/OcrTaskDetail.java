package com.stepos.alphame.ocr.task;

import android.os.IBinder;
import android.text.TextUtils;
import com.stepos.alphame.ocr.decoder.OcrDecoder;
import com.stepos.alphame.utils.Consts;

/* loaded from: classes.dex */
public class OcrTaskDetail extends OcrTask {
    public String bitmapPath;
    public String bitmapType;
    public IBinder clientBinder;
    public long contentVersion;

    public OcrTaskDetail(OcrDecoder ocrDecoder) {
        super(ocrDecoder);
        this.bitmapType = "";
        this.bitmapPath = "";
        this.contentVersion = 0L;
    }

    public String requestKey() {
        if (!TextUtils.isEmpty(this.bitmapPath)) {
            return this.bitmapPath + Consts.SPLITTER_DETAIL + this.bitmapType + Consts.SPLITTER_DETAIL + this.contentVersion;
        }
        if (this.clientBinder == null) {
            return "task@" + System.identityHashCode(this);
        }
        return "binder@" + System.identityHashCode(this.clientBinder) + Consts.SPLITTER_DETAIL + this.bitmapType + Consts.SPLITTER_DETAIL + this.contentVersion;
    }

    public OcrTaskDetail(OcrDecoder ocrDecoder, String str) {
        super(ocrDecoder);
        this.bitmapType = "";
        this.contentVersion = 0L;
        this.bitmapPath = str;
    }

    public OcrTaskDetail(OcrDecoder ocrDecoder, String str, IBinder iBinder) {
        super(ocrDecoder);
        this.bitmapType = "";
        this.contentVersion = 0L;
        this.bitmapPath = str;
        this.clientBinder = iBinder;
    }

    public OcrTaskDetail(OcrDecoder ocrDecoder, String str, long j4) {
        super(ocrDecoder);
        this.bitmapType = "";
        this.bitmapPath = str;
        this.contentVersion = j4;
    }

    public OcrTaskDetail(OcrDecoder ocrDecoder, String str, String str2, long j4) {
        super(ocrDecoder);
        this.bitmapPath = str;
        this.bitmapType = str2;
        this.contentVersion = j4;
    }
}
