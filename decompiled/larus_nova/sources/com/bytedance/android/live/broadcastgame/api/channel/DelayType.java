package com.bytedance.android.live.broadcastgame.api.channel;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/channel/DelayType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NO_DELAY", "DELAY_FLOW_STREAM", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DelayType extends Enum<DelayType> {
    public static final a Companion = null;
    public static final DelayType DELAY_FLOW_STREAM = null;
    public static final DelayType NO_DELAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DelayType[] f59286a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcastgame.api.channel.DelayType$a] */
    static {
        DelayType r100 = new DelayType("NO_DELAY", 0, 0);
        NO_DELAY = r100;
        DelayType r101 = new DelayType("DELAY_FLOW_STREAM", 1, 1);
        DELAY_FLOW_STREAM = r101;
        f59286a = new DelayType[]{r100, r101};
        Companion = new a();
    }

    public static DelayType valueOf(String r100) {
        return (DelayType) r27.a.a(DelayType.class, r100);
    }

    public static DelayType[] values() {
        return (DelayType[]) f59286a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DelayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
