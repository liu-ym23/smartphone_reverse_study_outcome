package com.bytedance.android.livesdk.performance.fwatchdog;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/performance/fwatchdog/RenderFrameOptScene;", "", "", "bit", "I", "getBit", "()I", "ENTER_ROOM", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RenderFrameOptScene extends Enum<RenderFrameOptScene> {
    public static final RenderFrameOptScene ENTER_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderFrameOptScene[] f154604a = null;
    private final int bit;

    static {
        RenderFrameOptScene r100 = new RenderFrameOptScene();
        ENTER_ROOM = r100;
        f154604a = new RenderFrameOptScene[]{r100};
    }

    public static RenderFrameOptScene valueOf(String r100) {
        return (RenderFrameOptScene) a.a(RenderFrameOptScene.class, r100);
    }

    public static RenderFrameOptScene[] values() {
        return (RenderFrameOptScene[]) f154604a.clone();
    }

    public RenderFrameOptScene() {
        super("ENTER_ROOM", 0);
        this.bit = 1;
    }

    public final int getBit() {
        return this.bit;
    }
}
