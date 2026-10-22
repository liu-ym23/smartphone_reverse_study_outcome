package com.baidu.mapapi;

/* JADX INFO: loaded from: classes39.dex */
public final enum ModuleName extends Enum<ModuleName> {
    private static final /* synthetic */ ModuleName[] $VALUES = null;
    public static final ModuleName TILE_OVERLAY_MODULE = null;

    static {
        ModuleName r100 = new ModuleName("TILE_OVERLAY_MODULE", 0);
        TILE_OVERLAY_MODULE = r100;
        $VALUES = new ModuleName[]{r100};
    }

    public static ModuleName[] values() {
        return (ModuleName[]) $VALUES.clone();
    }

    public static ModuleName valueOf(String r100) {
        return (ModuleName) r27.a.a(ModuleName.class, r100);
    }

    private ModuleName(String r100, int r101) {
        super(r100, r101);
    }
}
