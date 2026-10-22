package com.bytedance.android.live.broadcast.xplay;

import b10.b;
import b10.c;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/xplay/XplayMessageType;", "", "", "messageKey", "Ljava/lang/String;", "getMessageKey", "()Ljava/lang/String;", "Ljava/lang/Class;", "La10/a;", "messageType", "Ljava/lang/Class;", "getMessageType", "()Ljava/lang/Class;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "CO_HOST_GAME_STATUS", "CO_HOST_GAME_QUIT", "CO_HOST_CHANGE_SCREEN", "XPLAY_SWITCH_GUIDE_PLAYER", "XPLAY_INTERACT_CUSTOM", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum XplayMessageType extends Enum<XplayMessageType> {
    public static final XplayMessageType CO_HOST_CHANGE_SCREEN = null;
    public static final XplayMessageType CO_HOST_GAME_QUIT = null;
    public static final XplayMessageType CO_HOST_GAME_STATUS = null;
    public static final a Companion = null;
    public static final XplayMessageType UNKNOWN = null;
    public static final XplayMessageType XPLAY_INTERACT_CUSTOM = null;
    public static final XplayMessageType XPLAY_SWITCH_GUIDE_PLAYER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayMessageType[] f59225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, XplayMessageType> f59226b = null;
    private final String messageKey;
    private final Class<? extends a10.a> messageType;

    public static final class a {
        public a() {
        }
    }

    static {
        int r100 = 0;
        XplayMessageType r101 = new XplayMessageType("UNKNOWN", 0, "unknown", a10.a.class);
        UNKNOWN = r101;
        XplayMessageType r102 = new XplayMessageType("CO_HOST_GAME_STATUS", 1, "game_status", c.class);
        CO_HOST_GAME_STATUS = r102;
        XplayMessageType r103 = new XplayMessageType("CO_HOST_GAME_QUIT", 2, "game_quit", b.class);
        CO_HOST_GAME_QUIT = r103;
        XplayMessageType r104 = new XplayMessageType("CO_HOST_CHANGE_SCREEN", 3, "screen", b10.a.class);
        CO_HOST_CHANGE_SCREEN = r104;
        XplayMessageType r105 = new XplayMessageType("XPLAY_SWITCH_GUIDE_PLAYER", 4, "anchor_guide", a10.b.class);
        XPLAY_SWITCH_GUIDE_PLAYER = r105;
        XplayMessageType r106 = new XplayMessageType("XPLAY_INTERACT_CUSTOM", 5, "interact_custom", a10.c.class);
        XPLAY_INTERACT_CUSTOM = r106;
        f59225a = new XplayMessageType[]{r101, r102, r103, r104, r105, r106};
        Companion = new a();
        XplayMessageType[] r107 = values();
        LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r107.length), 16));
        int r109 = r107.length;
    L3:
        if (r100 >= r109) goto L5;
        XplayMessageType r110 = r107[r100];
        r108.put(r110.messageKey, r110);
        r100 = r100 + 1;
        goto L3
    L5:
        f59226b = r108;
    }

    public static XplayMessageType valueOf(String r100) {
        return (XplayMessageType) r27.a.a(XplayMessageType.class, r100);
    }

    public static XplayMessageType[] values() {
        return (XplayMessageType[]) f59225a.clone();
    }

    public static final /* synthetic */ Map access$getTypeMap$cp() {
        return f59226b;
    }

    public final String getMessageKey() {
        return this.messageKey;
    }

    public final Class<? extends a10.a> getMessageType() {
        return this.messageType;
    }

    public XplayMessageType(String r100, int r101, String r102, Class r103) {
        super(r100, r101);
        this.messageKey = r102;
        this.messageType = r103;
    }
}
