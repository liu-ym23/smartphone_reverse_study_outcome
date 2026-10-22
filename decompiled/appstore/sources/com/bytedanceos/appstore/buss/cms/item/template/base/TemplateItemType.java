package com.bytedanceos.appstore.buss.cms.item.template.base;

import com.obric.appstore.network.entity.template.ElementArrayEntity;
import n7.a;
import n7.b;
import n7.c;
import n7.d;
import n7.e;
import n7.g;
import n7.h;
import n7.i;

/* JADX INFO: loaded from: classes2.dex */
public final enum TemplateItemType extends Enum<TemplateItemType> {
    private static final /* synthetic */ TemplateItemType[] $VALUES = null;
    public static final TemplateItemType BLOCK_GRID = null;
    public static final TemplateItemType CAROUSEL_BANNER_LIST = null;
    public static final TemplateItemType HOR_APP_GRID = null;
    public static final TemplateItemType HOR_RECT_APP_GRID = null;
    public static final TemplateItemType SMALL_BANNER_GRID = null;
    public static final TemplateItemType VER_RECT_APP_GRID = null;
    public static final TemplateItemType VER_SQUARE_APP_GRID = null;
    public static final TemplateItemType VIDEO_APP_GRID = null;
    private final Class item;
    private final String name;

    private static /* synthetic */ TemplateItemType[] $values() {
        return new TemplateItemType[]{CAROUSEL_BANNER_LIST, BLOCK_GRID, SMALL_BANNER_GRID, HOR_RECT_APP_GRID, HOR_APP_GRID, VER_RECT_APP_GRID, VIDEO_APP_GRID, VER_SQUARE_APP_GRID};
    }

    static {
        CAROUSEL_BANNER_LIST = new TemplateItemType("CAROUSEL_BANNER_LIST", 0, "big_banner_rotation_list", b.class);
        BLOCK_GRID = new TemplateItemType("BLOCK_GRID", 1, "block_grid", a.class);
        SMALL_BANNER_GRID = new TemplateItemType("SMALL_BANNER_GRID", 2, "little_banner_list", g.class);
        HOR_RECT_APP_GRID = new TemplateItemType("HOR_RECT_APP_GRID", 3, "rect_app_matrix", e.class);
        HOR_APP_GRID = new TemplateItemType("HOR_APP_GRID", 4, ElementArrayEntity.Key.APP_MATRIX, d.class);
        VER_RECT_APP_GRID = new TemplateItemType("VER_RECT_APP_GRID", 5, "vertical_app_list", h.class);
        VIDEO_APP_GRID = new TemplateItemType("VIDEO_APP_GRID", 6, "app_video_list", i.class);
        VER_SQUARE_APP_GRID = new TemplateItemType("VER_SQUARE_APP_GRID", 7, "lkp_first_ver_square_app_grid", c.class);
        $VALUES = $values();
    }

    private TemplateItemType(String r10, int r11, String r12, Class r13) {
        super(r10, r11);
        this.name = r12;
        this.item = r13;
    }

    public static TemplateItemType valueOf(String r10) {
        return (TemplateItemType) Enum.valueOf(TemplateItemType.class, r10);
    }

    public static TemplateItemType[] values() {
        return (TemplateItemType[]) $VALUES.clone();
    }

    public Class getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }
}
