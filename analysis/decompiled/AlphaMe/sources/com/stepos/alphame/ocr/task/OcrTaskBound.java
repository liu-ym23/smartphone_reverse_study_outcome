package com.stepos.alphame.ocr.task;

import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.ocr.decoder.OcrDecoder;

/* loaded from: classes.dex */
public class OcrTaskBound extends OcrTask {
    private final boolean point;

    public OcrTaskBound(OcrDecoder ocrDecoder) {
        this(ocrDecoder, false);
    }

    @Override // com.stepos.alphame.ocr.task.OcrTask
    public void notifyFail(int i4) {
        if (!this.point) {
            super.notifyFail(i4);
        } else {
            ActionManager.getInstance().broadcast("OCR_DETECT", new String[]{String.valueOf(0), String.valueOf(i4), "point"});
        }
    }

    @Override // com.stepos.alphame.ocr.task.OcrTask
    public void notifySuccess(String str) {
        if (!this.point) {
            super.notifySuccess(str);
        } else {
            ActionManager.getInstance().broadcast("OCR_DETECT", new String[]{String.valueOf(1), str, "point"});
        }
    }

    public OcrTaskBound(OcrDecoder ocrDecoder, boolean z4) {
        super(ocrDecoder);
        this.point = z4;
    }
}
