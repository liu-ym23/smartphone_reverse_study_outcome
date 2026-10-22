package com.bytedance.android.live.revenue.platform.interacteffect.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/interacteffect/api/Scene;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GIFT", "ATMOSPHERE", "UNKNOWN", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Scene extends Enum<Scene> {
    public static final Scene ATMOSPHERE = null;
    public static final a Companion = null;
    public static final Scene GIFT = null;
    public static final Scene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f91481a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revenue.platform.interacteffect.api.Scene$a] */
    static {
        Scene r100 = new Scene("GIFT", 0, 100);
        GIFT = r100;
        Scene r101 = new Scene("ATMOSPHERE", 1, 101);
        ATMOSPHERE = r101;
        Scene r102 = new Scene("UNKNOWN", 2, -1);
        UNKNOWN = r102;
        f91481a = new Scene[]{r100, r101, r102};
        Companion = new a();
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f91481a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Scene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
