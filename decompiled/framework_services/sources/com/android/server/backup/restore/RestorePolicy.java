package com.android.server.backup.restore;

/* JADX INFO: loaded from: classes.dex */
public final enum RestorePolicy extends Enum<RestorePolicy> {
    private static final /* synthetic */ RestorePolicy[] $VALUES = null;
    public static final RestorePolicy ACCEPT = null;
    public static final RestorePolicy ACCEPT_IF_APK = null;
    public static final RestorePolicy IGNORE = null;

    private static /* synthetic */ RestorePolicy[] $values() {
        return new RestorePolicy[]{IGNORE, ACCEPT, ACCEPT_IF_APK};
    }

    private RestorePolicy(String r1, int r2) {
        super(r1, r2);
    }

    public static RestorePolicy valueOf(String name) {
        return (RestorePolicy) Enum.valueOf(RestorePolicy.class, name);
    }

    public static RestorePolicy[] values() {
        return (RestorePolicy[]) $VALUES.clone();
    }

    static {
        IGNORE = new RestorePolicy("IGNORE", 0);
        ACCEPT = new RestorePolicy("ACCEPT", 1);
        ACCEPT_IF_APK = new RestorePolicy("ACCEPT_IF_APK", 2);
        $VALUES = $values();
    }
}
