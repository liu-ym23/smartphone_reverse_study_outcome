package com.stepos.alphame.ocr;

import com.stepos.alphame.ocr.OcrEngine;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OcrEngine f11182b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11183c;

    public /* synthetic */ a(OcrEngine ocrEngine, Object obj, int i4) {
        this.f11181a = i4;
        this.f11182b = ocrEngine;
        this.f11183c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i4 = this.f11181a;
        OcrEngine ocrEngine = this.f11182b;
        Object obj = this.f11183c;
        switch (i4) {
            case 0:
                OcrEngine.runRecognizeWithTask$lambda$17(ocrEngine, (OcrEngine.PendingOcr) obj);
                break;
            default:
                OcrEngine.releaseModelIfQuiet$lambda$16(ocrEngine, (String) obj);
                break;
        }
    }
}
