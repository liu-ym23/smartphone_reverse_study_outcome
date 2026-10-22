package com.bytedance.ai.bridge.remote.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PermissionType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ONE_TICKET_SCOPE", "RUNNING_TIME_SCOPE", "LONG_TERM_TICKET_SCOPE", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionType extends Enum<PermissionType> {
    public static final a Companion = null;
    public static final PermissionType LONG_TERM_TICKET_SCOPE = null;
    public static final PermissionType ONE_TICKET_SCOPE = null;
    public static final PermissionType RUNNING_TIME_SCOPE = null;
    public static final PermissionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionType[] f36085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36086b = null;

    public static EnumEntries<PermissionType> getEntries() {
        return f36086b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.bridge.remote.model.PermissionType$a] */
    static {
        PermissionType r100 = new PermissionType("UNKNOWN", 0);
        UNKNOWN = r100;
        PermissionType r101 = new PermissionType("ONE_TICKET_SCOPE", 1);
        ONE_TICKET_SCOPE = r101;
        PermissionType r102 = new PermissionType("RUNNING_TIME_SCOPE", 2);
        RUNNING_TIME_SCOPE = r102;
        PermissionType r103 = new PermissionType("LONG_TERM_TICKET_SCOPE", 3);
        LONG_TERM_TICKET_SCOPE = r103;
        PermissionType[] r104 = {r100, r101, r102, r103};
        f36085a = r104;
        f36086b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static PermissionType[] values() {
        return (PermissionType[]) f36085a.clone();
    }

    public static PermissionType valueOf(String r100) {
        return (PermissionType) r27.a.a(PermissionType.class, r100);
    }

    public PermissionType(String r100, int r101) {
        super(r100, r101);
    }
}
