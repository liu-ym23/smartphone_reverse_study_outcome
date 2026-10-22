package com.bytedance.ai.core.base;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/core/base/SessionType;", "", "<init>", "(Ljava/lang/String;I)V", "CHATUI", "PLAYGROUND", "DESKTOP", "DEBUG", FlowDoraWifiScene.OTHER, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    public static final SessionType CHATUI = null;
    public static final SessionType DEBUG = null;
    public static final SessionType DESKTOP = null;
    public static final SessionType OTHER = null;
    public static final SessionType PLAYGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionType[] f36138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36139b = null;

    public static EnumEntries<SessionType> getEntries() {
        return f36139b;
    }

    static {
        SessionType r100 = new SessionType("CHATUI", 0);
        CHATUI = r100;
        SessionType r101 = new SessionType("PLAYGROUND", 1);
        PLAYGROUND = r101;
        SessionType r102 = new SessionType("DESKTOP", 2);
        DESKTOP = r102;
        SessionType r103 = new SessionType("DEBUG", 3);
        DEBUG = r103;
        SessionType r104 = new SessionType(FlowDoraWifiScene.OTHER, 4);
        OTHER = r104;
        SessionType[] r105 = {r100, r101, r102, r103, r104};
        f36138a = r105;
        f36139b = EnumEntriesKt.enumEntries(r105);
    }

    public static SessionType[] values() {
        return (SessionType[]) f36138a.clone();
    }

    public static SessionType valueOf(String r100) {
        return (SessionType) r27.a.a(SessionType.class, r100);
    }

    public SessionType(String r100, int r101) {
        super(r100, r101);
    }
}
