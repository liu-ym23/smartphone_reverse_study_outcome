package com.android.contacts.dialpad;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class DialpadOptionItem {
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_PUBLIC_NUMBER = 1;
    public static final int TYPE_VIDEO_CALL = 3;
    public String describe;
    public String detail;
    public int drawbleRes;
    public Drawable icon;
    public int type;

    public DialpadOptionItem() {
        this.type = 2;
    }

    public String toString() {
        return "describe = " + this.describe + ", detail = " + this.detail + ", drawbleRes = " + this.drawbleRes;
    }
}
