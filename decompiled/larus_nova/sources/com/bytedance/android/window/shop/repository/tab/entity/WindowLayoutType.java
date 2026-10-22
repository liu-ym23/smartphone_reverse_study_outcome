package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "", "", "isSingleColumn", "isDoubleColumn", "isNewLayout", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SINGLECOLUMN", "DOUBLECOLUMN", "SINGLECOLUMN_V2", "DOUBLECOLUMN_V2", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLayoutType extends Enum<WindowLayoutType> {
    public static final a Companion = null;
    public static final WindowLayoutType DOUBLECOLUMN = null;
    public static final WindowLayoutType DOUBLECOLUMN_V2 = null;
    public static final WindowLayoutType SINGLECOLUMN = null;
    public static final WindowLayoutType SINGLECOLUMN_V2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLayoutType[] f189506a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static WindowLayoutType a(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
        L12:
            return null;
        L10:
            if (r100.intValue() != 2) goto L12;
            return WindowLayoutType.DOUBLECOLUMN;
        L5:
            if (r100.intValue() != 1) goto L7;
            return WindowLayoutType.SINGLECOLUMN;
        }

        public static WindowLayoutType b(Integer r100) {
            WindowLayoutType r101 = WindowLayoutType.SINGLECOLUMN;
            int r102 = r101.getType();
            if (r100 != null) goto L6;
        L8:
            WindowLayoutType r103 = WindowLayoutType.DOUBLECOLUMN;
            int r104 = r103.getType();
            if (r100 != null) goto L12;
        L14:
            WindowLayoutType r105 = WindowLayoutType.SINGLECOLUMN_V2;
            int r106 = r105.getType();
            if (r100 != null) goto L18;
        L20:
            WindowLayoutType r107 = WindowLayoutType.DOUBLECOLUMN_V2;
            int r108 = r107.getType();
            if (r100 != null) goto L24;
        L26:
            return null;
        L24:
            if (r100.intValue() != r108) goto L26;
            return r107;
        L18:
            if (r100.intValue() != r106) goto L20;
            return r105;
        L12:
            if (r100.intValue() != r104) goto L14;
            return r103;
        L6:
            if (r100.intValue() != r102) goto L8;
            return r101;
        }
    }

    static {
        WindowLayoutType r100 = new WindowLayoutType("SINGLECOLUMN", 0, 0);
        SINGLECOLUMN = r100;
        WindowLayoutType r101 = new WindowLayoutType("DOUBLECOLUMN", 1, 1);
        DOUBLECOLUMN = r101;
        WindowLayoutType r102 = new WindowLayoutType("SINGLECOLUMN_V2", 2, 2);
        SINGLECOLUMN_V2 = r102;
        WindowLayoutType r103 = new WindowLayoutType("DOUBLECOLUMN_V2", 3, 3);
        DOUBLECOLUMN_V2 = r103;
        f189506a = new WindowLayoutType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static WindowLayoutType valueOf(String r100) {
        return (WindowLayoutType) r27.a.a(WindowLayoutType.class, r100);
    }

    public static WindowLayoutType[] values() {
        return (WindowLayoutType[]) f189506a.clone();
    }

    public final boolean isDoubleColumn() {
        if (this != DOUBLECOLUMN) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBLECOLUMN_V2) goto L8;
        return false;
    }

    public final boolean isNewLayout() {
        if (this != SINGLECOLUMN_V2) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBLECOLUMN_V2) goto L8;
        return false;
    }

    public final boolean isSingleColumn() {
        if (this != SINGLECOLUMN) goto L5;
    L8:
        return true;
    L5:
        if (this == SINGLECOLUMN_V2) goto L8;
        return false;
    }

    public final int getType() {
        return this.type;
    }

    public WindowLayoutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
