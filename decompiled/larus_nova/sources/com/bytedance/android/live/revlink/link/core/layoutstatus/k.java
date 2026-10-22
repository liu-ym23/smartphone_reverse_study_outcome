package com.bytedance.android.live.revlink.link.core.layoutstatus;

/* JADX INFO: loaded from: classes47.dex */
public final class k {
    public static final boolean a(i r100) {
        if (r100 == null) goto L6;
        MainBackupStreamStatus r101 = r100.f98300c;
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.ordinal());
    L7:
        int r103 = MainBackupStreamStatus.MAIN_FLAG_WITH_MAIN_LINK_ID.ordinal();
        if (r102 != null) goto L11;
    L13:
        int r104 = MainBackupStreamStatus.BACKUP_FLAG_WITH_BACKUP_LINK_ID.ordinal();
        if (r102 != null) goto L17;
    L19:
        return false;
    L17:
        if (r102.intValue() != r104) goto L19;
    L18:
        return true;
    L11:
        if (r102.intValue() != r103) goto L13;
    L6:
        r102 = null;
        goto L7
    }
}
