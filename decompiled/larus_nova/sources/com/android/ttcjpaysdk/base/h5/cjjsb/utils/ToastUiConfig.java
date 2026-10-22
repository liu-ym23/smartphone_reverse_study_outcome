package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "", "iconSize", "", "msgTextSize", "iconBottomMargin", "toastHPadding", "toastVPadding", "onlyTextToastHPadding", "onlyTextToastVPadding", "toastWidth", "toastHeight", "toastMinWidth", "toastMinHeight", "(IIIIIIIIIII)V", "getIconBottomMargin", "()I", "getIconSize", "getMsgTextSize", "getOnlyTextToastHPadding", "getOnlyTextToastVPadding", "getToastHPadding", "getToastHeight", "getToastMinHeight", "getToastMinWidth", "getToastVPadding", "getToastWidth", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastUiConfig {
    private final int iconBottomMargin;
    private final int iconSize;
    private final int msgTextSize;
    private final int onlyTextToastHPadding;
    private final int onlyTextToastVPadding;
    private final int toastHPadding;
    private final int toastHeight;
    private final int toastMinHeight;
    private final int toastMinWidth;
    private final int toastVPadding;
    private final int toastWidth;

    public ToastUiConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null);
    }

    public final int getIconBottomMargin() {
        return this.iconBottomMargin;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getMsgTextSize() {
        return this.msgTextSize;
    }

    public final int getOnlyTextToastHPadding() {
        return this.onlyTextToastHPadding;
    }

    public final int getOnlyTextToastVPadding() {
        return this.onlyTextToastVPadding;
    }

    public final int getToastHPadding() {
        return this.toastHPadding;
    }

    public final int getToastHeight() {
        return this.toastHeight;
    }

    public final int getToastMinHeight() {
        return this.toastMinHeight;
    }

    public final int getToastMinWidth() {
        return this.toastMinWidth;
    }

    public final int getToastVPadding() {
        return this.toastVPadding;
    }

    public final int getToastWidth() {
        return this.toastWidth;
    }

    public ToastUiConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111) {
        this.iconSize = r100;
        this.msgTextSize = r101;
        this.iconBottomMargin = r102;
        this.toastHPadding = r103;
        this.toastVPadding = r104;
        this.onlyTextToastHPadding = r105;
        this.onlyTextToastVPadding = r106;
        this.toastWidth = r107;
        this.toastHeight = r108;
        this.toastMinWidth = r110;
        this.toastMinHeight = r111;
    }

    public /* synthetic */ ToastUiConfig(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210, int r211, int r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = 32;
    L7:
        if ((r213 & 2) == 0) goto L9;
        int r101 = 14;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r102 = 15;
    L14:
        int r103 = 20;
        if ((r213 & 8) == 0) goto L17;
        int r104 = 20;
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r105 = 20;
    L23:
        if ((r213 & 32) != 0) goto L27;
        r103 = r115;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r106 = 10;
    L30:
        int r107 = -2;
        if ((r213 & 128) == 0) goto L33;
        int r108 = -2;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r107 = r210;
    L39:
        if ((r213 & 512) == 0) goto L41;
        int r118 = 190;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        int r109 = 105;
    L46:
        this(r100, r101, r102, r104, r105, r103, r106, r108, r107, r118, r109);
        return;
    L45:
        r109 = r212;
        goto L46
    L41:
        r118 = r211;
        goto L43
    L33:
        r108 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L30
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
