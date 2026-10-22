package com.bytedance.android.ec.window.base.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/ElementAlignment;", "", "", "type", "I", "getType", "()I", "LEADING", "CENTER", "TRAILING", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ElementAlignment extends Enum<ElementAlignment> {
    public static final ElementAlignment CENTER = null;
    public static final ElementAlignment LEADING = null;
    public static final ElementAlignment TRAILING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementAlignment[] f49452a = null;
    private final int type;

    static {
        ElementAlignment r100 = new ElementAlignment("LEADING", 0, 0);
        LEADING = r100;
        ElementAlignment r101 = new ElementAlignment("CENTER", 1, 1);
        CENTER = r101;
        ElementAlignment r102 = new ElementAlignment("TRAILING", 2, 2);
        TRAILING = r102;
        f49452a = new ElementAlignment[]{r100, r101, r102};
    }

    public static ElementAlignment valueOf(String r100) {
        return (ElementAlignment) r27.a.a(ElementAlignment.class, r100);
    }

    public static ElementAlignment[] values() {
        return (ElementAlignment[]) f49452a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ElementAlignment(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
