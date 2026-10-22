package com.bytedance.android.livesdk.utils;

import com.larus.dora.api.model.FlowDoraWifiScene;

/* JADX INFO: loaded from: classes11.dex */
public final enum V3Utils$TYPE extends Enum<V3Utils$TYPE> {
    public static final V3Utils$TYPE CLICK = null;
    public static final V3Utils$TYPE CORE = null;
    public static final V3Utils$TYPE OTHER = null;
    public static final V3Utils$TYPE PV = null;
    public static final V3Utils$TYPE SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ V3Utils$TYPE[] f158808a = null;
    private String mType;

    static {
        V3Utils$TYPE r100 = new V3Utils$TYPE("CORE", 0, "core");
        CORE = r100;
        V3Utils$TYPE r101 = new V3Utils$TYPE("SHOW", 1, "show");
        SHOW = r101;
        V3Utils$TYPE r102 = new V3Utils$TYPE("PV", 2, "pv");
        PV = r102;
        V3Utils$TYPE r103 = new V3Utils$TYPE(FlowDoraWifiScene.OTHER, 3, "other");
        OTHER = r103;
        V3Utils$TYPE r104 = new V3Utils$TYPE("CLICK", 4, "click");
        CLICK = r104;
        f158808a = new V3Utils$TYPE[]{r100, r101, r102, r103, r104};
    }

    public static V3Utils$TYPE[] values() {
        return (V3Utils$TYPE[]) f158808a.clone();
    }

    public String getType() {
        return this.mType;
    }

    public static /* synthetic */ String access$000(V3Utils$TYPE r100) {
        return r100.mType;
    }

    public static V3Utils$TYPE valueOf(String r100) {
        return (V3Utils$TYPE) r27.a.a(V3Utils$TYPE.class, r100);
    }

    public V3Utils$TYPE(String r100, int r101, String r102) {
        super(r100, r101);
        this.mType = r102;
    }
}
