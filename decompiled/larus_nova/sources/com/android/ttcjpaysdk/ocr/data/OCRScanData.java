package com.android.ttcjpaysdk.ocr.data;

import android.graphics.Rect;
import com.android.ttcjpaysdk.ocr.view.OCRCodeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/OCRScanData;", "", "data", "", "imgWidth", "", "imgHeight", "previewZoomSize", "", "scanRect", "Landroid/graphics/Rect;", "([BIIFLandroid/graphics/Rect;)V", "compressType", "scanDataHandleListener", "Lcom/android/ttcjpaysdk/ocr/view/OCRCodeView$IScanDataHandleListener;", "targetSize", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRScanData {
    public int compressType;
    public byte[] data;
    public int imgHeight;
    public int imgWidth;
    public float previewZoomSize;
    public OCRCodeView.IScanDataHandleListener scanDataHandleListener;
    public Rect scanRect;
    public int targetSize;

    public OCRScanData(byte[] r100, int r101, int r102, float r103, Rect r104) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.imgWidth = r101;
        this.imgHeight = r102;
        this.previewZoomSize = r103;
        this.scanRect = r104;
        this.targetSize = 720;
    }
}
