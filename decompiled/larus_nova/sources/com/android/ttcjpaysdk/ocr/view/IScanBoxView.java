package com.android.ttcjpaysdk.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes39.dex */
public abstract class IScanBoxView extends View {
    public Rect getFramingRect() {
        return null;
    }

    public int getTipsLineCount() {
        return 1;
    }

    public void setBorderRadius(int r100, int r101) {
    }

    public void setScanLineBitmap(Bitmap r100) {
    }

    public abstract void showPermissionTip(boolean r100);

    public abstract void showScanBox(boolean r100);

    public abstract void showScanLine(boolean r100);

    public IScanBoxView(Context r100) {
        super(r100);
    }

    public IScanBoxView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
