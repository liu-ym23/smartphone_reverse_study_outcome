package com.bytedance.android.gamecp.business.download.multichannel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/multichannel/LaunchType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SCHEMA_SCHEMA", "SCHEMA_PACKAGE", "NO_SCHEMA", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LaunchType extends Enum<LaunchType> {
    public static final LaunchType NO_SCHEMA = null;
    public static final LaunchType SCHEMA_PACKAGE = null;
    public static final LaunchType SCHEMA_SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchType[] f52813a = null;
    private final String type;

    static {
        LaunchType r100 = new LaunchType("SCHEMA_SCHEMA", 0, "1");
        SCHEMA_SCHEMA = r100;
        LaunchType r101 = new LaunchType("SCHEMA_PACKAGE", 1, "2");
        SCHEMA_PACKAGE = r101;
        LaunchType r102 = new LaunchType("NO_SCHEMA", 2, "3");
        NO_SCHEMA = r102;
        f52813a = new LaunchType[]{r100, r101, r102};
    }

    public static LaunchType valueOf(String r100) {
        return (LaunchType) r27.a.a(LaunchType.class, r100);
    }

    public static LaunchType[] values() {
        return (LaunchType[]) f52813a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public LaunchType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
