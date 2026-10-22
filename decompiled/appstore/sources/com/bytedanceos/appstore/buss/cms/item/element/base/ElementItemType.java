package com.bytedanceos.appstore.buss.cms.item.element.base;

import l7.a;
import l7.b;
import l7.c;
import l7.d;
import l7.e;
import l7.f;
import l7.g;
import l7.h;

/* JADX INFO: loaded from: classes2.dex */
public final enum ElementItemType extends Enum<ElementItemType> {
    private static final /* synthetic */ ElementItemType[] $VALUES = null;
    public static final ElementItemType BLOCK = null;
    public static final ElementItemType CAROUSEL_BANNER = null;
    public static final ElementItemType FIRST_VER_SQUARE_APP = null;
    public static final ElementItemType HOR_APP = null;
    public static final ElementItemType HOR_RECT_APP = null;
    public static final ElementItemType PAGE_TITLE = null;
    public static final ElementItemType SMALL_BANNER = null;
    public static final ElementItemType VER_RECT_APP = null;
    public static final ElementItemType VIDEO_APP = null;
    private final Class item;

    private static /* synthetic */ ElementItemType[] $values() {
        return new ElementItemType[]{CAROUSEL_BANNER, BLOCK, SMALL_BANNER, HOR_RECT_APP, PAGE_TITLE, HOR_APP, VER_RECT_APP, VIDEO_APP, FIRST_VER_SQUARE_APP};
    }

    static {
        CAROUSEL_BANNER = new ElementItemType("CAROUSEL_BANNER", 0, b.class);
        BLOCK = new ElementItemType("BLOCK", 1, a.class);
        SMALL_BANNER = new ElementItemType("SMALL_BANNER", 2, f.class);
        HOR_RECT_APP = new ElementItemType("HOR_RECT_APP", 3, e.class);
        PAGE_TITLE = new ElementItemType("PAGE_TITLE", 4, n7.f.class);
        HOR_APP = new ElementItemType("HOR_APP", 5, d.class);
        VER_RECT_APP = new ElementItemType("VER_RECT_APP", 6, g.class);
        VIDEO_APP = new ElementItemType("VIDEO_APP", 7, h.class);
        FIRST_VER_SQUARE_APP = new ElementItemType("FIRST_VER_SQUARE_APP", 8, c.class);
        $VALUES = $values();
    }

    private ElementItemType(String r10, int r11, Class r12) {
        super(r10, r11);
        this.item = r12;
    }

    public static ElementItemType valueOf(String r10) {
        return (ElementItemType) Enum.valueOf(ElementItemType.class, r10);
    }

    public static ElementItemType[] values() {
        return (ElementItemType[]) $VALUES.clone();
    }

    public Class getItem() {
        return this.item;
    }
}
