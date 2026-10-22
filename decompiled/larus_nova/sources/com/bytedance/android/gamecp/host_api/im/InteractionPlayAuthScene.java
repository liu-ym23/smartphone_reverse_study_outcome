package com.bytedance.android.gamecp.host_api.im;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/im/InteractionPlayAuthScene;", "", "", "scene", "J", "getScene", "()J", "InteractionPlayDefaultAuth", "InteractionPlayExchangeAuth", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractionPlayAuthScene extends Enum<InteractionPlayAuthScene> {
    public static final InteractionPlayAuthScene InteractionPlayDefaultAuth = null;
    public static final InteractionPlayAuthScene InteractionPlayExchangeAuth = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPlayAuthScene[] f57363a = null;
    private final long scene;

    static {
        InteractionPlayAuthScene r100 = new InteractionPlayAuthScene("InteractionPlayDefaultAuth", 0, 0);
        InteractionPlayDefaultAuth = r100;
        InteractionPlayAuthScene r101 = new InteractionPlayAuthScene("InteractionPlayExchangeAuth", 1, 1);
        InteractionPlayExchangeAuth = r101;
        f57363a = new InteractionPlayAuthScene[]{r100, r101};
    }

    public static InteractionPlayAuthScene valueOf(String r100) {
        return (InteractionPlayAuthScene) a.a(InteractionPlayAuthScene.class, r100);
    }

    public static InteractionPlayAuthScene[] values() {
        return (InteractionPlayAuthScene[]) f57363a.clone();
    }

    public final long getScene() {
        return this.scene;
    }

    public InteractionPlayAuthScene(String r100, int r101, long r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
