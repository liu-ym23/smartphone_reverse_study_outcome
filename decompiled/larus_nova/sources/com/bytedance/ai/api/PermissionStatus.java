package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/api/PermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "TRUE", "FALSE", "APPLET_TRUE", "APPLET_FALSE", "APP_TRUE", "APP_FALSE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionStatus extends Enum<PermissionStatus> {
    public static final PermissionStatus APPLET_FALSE = null;
    public static final PermissionStatus APPLET_TRUE = null;
    public static final PermissionStatus APP_FALSE = null;
    public static final PermissionStatus APP_TRUE = null;
    public static final PermissionStatus FALSE = null;
    public static final PermissionStatus TRUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionStatus[] f33978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33979b = null;

    public static EnumEntries<PermissionStatus> getEntries() {
        return f33979b;
    }

    static {
        PermissionStatus r100 = new PermissionStatus("TRUE", 0);
        TRUE = r100;
        PermissionStatus r101 = new PermissionStatus("FALSE", 1);
        FALSE = r101;
        PermissionStatus r102 = new PermissionStatus("APPLET_TRUE", 2);
        APPLET_TRUE = r102;
        PermissionStatus r103 = new PermissionStatus("APPLET_FALSE", 3);
        APPLET_FALSE = r103;
        PermissionStatus r104 = new PermissionStatus("APP_TRUE", 4);
        APP_TRUE = r104;
        PermissionStatus r105 = new PermissionStatus("APP_FALSE", 5);
        APP_FALSE = r105;
        PermissionStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f33978a = r110;
        f33979b = EnumEntriesKt.enumEntries(r110);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) f33978a.clone();
    }

    public static PermissionStatus valueOf(String r100) {
        return (PermissionStatus) r27.a.a(PermissionStatus.class, r100);
    }

    public PermissionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
