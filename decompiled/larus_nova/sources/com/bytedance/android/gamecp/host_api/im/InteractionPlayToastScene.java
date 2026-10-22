package com.bytedance.android.gamecp.host_api.im;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/im/InteractionPlayToastScene;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InteractionPlayDefaultToast", "InteractionPlayMinorHealthToast", "InteractionPlayAppNotSupportToast", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractionPlayToastScene extends Enum<InteractionPlayToastScene> {
    public static final a Companion = null;
    public static final InteractionPlayToastScene InteractionPlayAppNotSupportToast = null;
    public static final InteractionPlayToastScene InteractionPlayDefaultToast = null;
    public static final InteractionPlayToastScene InteractionPlayMinorHealthToast = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPlayToastScene[] f57364a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        InteractionPlayToastScene r100 = new InteractionPlayToastScene("InteractionPlayDefaultToast", 0, 0);
        InteractionPlayDefaultToast = r100;
        InteractionPlayToastScene r101 = new InteractionPlayToastScene("InteractionPlayMinorHealthToast", 1, 1);
        InteractionPlayMinorHealthToast = r101;
        InteractionPlayToastScene r102 = new InteractionPlayToastScene("InteractionPlayAppNotSupportToast", 2, 2);
        InteractionPlayAppNotSupportToast = r102;
        f57364a = new InteractionPlayToastScene[]{r100, r101, r102};
        Companion = new a();
    }

    public static InteractionPlayToastScene valueOf(String r100) {
        return (InteractionPlayToastScene) r27.a.a(InteractionPlayToastScene.class, r100);
    }

    public static InteractionPlayToastScene[] values() {
        return (InteractionPlayToastScene[]) f57364a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public InteractionPlayToastScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
