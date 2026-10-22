package com.obric.oui.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes3.dex */
public class Rect {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public Rect() {
    }

    public int width() {
        return this.right - this.left;
    }

    public int height() {
        return this.bottom - this.top;
    }
}
