package com.bytedance.android.livesdk.ec.adapter.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ec/adapter/api/Scene;", "", "LIVE", "SHOP", "DETAIL", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Scene extends Enum<Scene> {
    public static final Scene DETAIL = null;
    public static final Scene LIVE = null;
    public static final Scene SHOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f123295a = null;

    static {
        Scene r100 = new Scene("LIVE", 0);
        LIVE = r100;
        Scene r101 = new Scene("SHOP", 1);
        SHOP = r101;
        Scene r102 = new Scene("DETAIL", 2);
        DETAIL = r102;
        f123295a = new Scene[]{r100, r101, r102};
    }

    public static Scene valueOf(String r100) {
        return (Scene) a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f123295a.clone();
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
