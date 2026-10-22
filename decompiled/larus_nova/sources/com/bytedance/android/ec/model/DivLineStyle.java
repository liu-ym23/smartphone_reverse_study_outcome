package com.bytedance.android.ec.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/DivLineStyle;", "", "", "style", "I", "getStyle", "()I", "SOLID_LINE", "DOTTED_LINE", "CHARACTER_LINE", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum DivLineStyle extends Enum<DivLineStyle> {
    public static final DivLineStyle CHARACTER_LINE = null;
    public static final DivLineStyle DOTTED_LINE = null;
    public static final DivLineStyle SOLID_LINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DivLineStyle[] f47850a = null;
    private final int style;

    static {
        DivLineStyle r100 = new DivLineStyle("SOLID_LINE", 0, 0);
        SOLID_LINE = r100;
        DivLineStyle r101 = new DivLineStyle("DOTTED_LINE", 1, 1);
        DOTTED_LINE = r101;
        DivLineStyle r102 = new DivLineStyle("CHARACTER_LINE", 2, 2);
        CHARACTER_LINE = r102;
        f47850a = new DivLineStyle[]{r100, r101, r102};
    }

    public static DivLineStyle valueOf(String r100) {
        return (DivLineStyle) r27.a.a(DivLineStyle.class, r100);
    }

    public static DivLineStyle[] values() {
        return (DivLineStyle[]) f47850a.clone();
    }

    public final int getStyle() {
        return this.style;
    }

    public DivLineStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }
}
