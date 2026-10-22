package com.bytedance.android.standard.tools.ui;

/* JADX INFO: loaded from: classes.dex */
public interface ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    void dismissCustomToast();

    void showCustomLongToast(int r10, String r11);

    void showCustomToast(int r10, String r11);

    void showCustomToast(int r10, String r11, int r12, int r13);

    void showCustomToast(String r10);

    void showCustomToast(String r10, int r11, int r12);
}
