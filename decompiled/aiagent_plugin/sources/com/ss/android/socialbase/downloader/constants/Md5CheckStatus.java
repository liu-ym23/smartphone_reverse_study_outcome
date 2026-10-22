package com.ss.android.socialbase.downloader.constants;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum Md5CheckStatus extends Enum<Md5CheckStatus> {
    private static final /* synthetic */ Md5CheckStatus[] $VALUES = null;
    public static final Md5CheckStatus INVALID_FILE_MD5_EMPTY = null;
    public static final Md5CheckStatus INVALID_FILE_NO_EXIST = null;
    public static final Md5CheckStatus INVALID_MD5_NOT_EQUALS = null;
    public static final Md5CheckStatus VALID = null;

    private Md5CheckStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static Md5CheckStatus valueOf(String r2) {
        return (Md5CheckStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(Md5CheckStatus.class, r2), Md5CheckStatus.class, "com.obric.aiagent.plugin");
    }

    public static Md5CheckStatus[] values() {
        return (Md5CheckStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Md5CheckStatus[].class, "com.obric.aiagent.plugin");
    }

    static {
        Md5CheckStatus r0 = new Md5CheckStatus("VALID", 0);
        VALID = r0;
        Md5CheckStatus r1 = new Md5CheckStatus("INVALID_FILE_NO_EXIST", 1);
        INVALID_FILE_NO_EXIST = r1;
        Md5CheckStatus r3 = new Md5CheckStatus("INVALID_FILE_MD5_EMPTY", 2);
        INVALID_FILE_MD5_EMPTY = r3;
        Md5CheckStatus r5 = new Md5CheckStatus("INVALID_MD5_NOT_EQUALS", 3);
        INVALID_MD5_NOT_EQUALS = r5;
        $VALUES = new Md5CheckStatus[]{r0, r1, r3, r5};
    }
}
