package com.ss.bduploader;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class BDAbstractUpload {
    protected static boolean IsErrored = false;
    public static final int KeyIsBatchSessionKey = 420;
    public static final int KeyIsCustomHttpHeaders = 430;
    public static final int KeyIsDiskResumeDir = 303;
    public static final int KeyIsDiskResumeOption = 302;
    public static final int KeyIsDiskResumeUniqueKey = 301;
    public static final int KeyIsEnableNativeLog = 421;
    public static final int KeyIsRetryStatesDir = 433;
    public static final int KeyIsRetryStatesOption = 434;
    public static final int KeyIsSDKMaxRetryCount = 426;
    public static final int KeyIsSDKMaxRetryTimeout = 428;
    public static final int KeyIsSDKRetryPolicy = 427;
    public static final int KeyIsSocketConnectTimeout = 422;
    public static final int KeyIsSocketReadTimeout = 423;
    public static final int KeyIsSocketWriteTimeout = 424;
    public static final int KeyIsTotalRequestTimeout = 425;
    public static final int KeyIsXQuicLibAvailable = 429;
    public static final int SDKRetryPolicyMaxFailTime = 0;
    public static final int SDKRetryPolicyMaxRetryCount = 1;
    public static StringBuffer mErrorMsg;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public String getStringFromExtern(int r1) {
        return "";
    }

    static {
        mErrorMsg = new StringBuffer("error:");
        StringBuffer r0 = new StringBuffer("error:");
        mErrorMsg = r0;
        if (t.a(r0) == true) goto L6;
        IsErrored = true;
        return;
    }

    public BDAbstractUpload() {
        StringBuffer r1 = new StringBuffer("error:");
        mErrorMsg = r1;
        t.a(r1);
    }

    public String getDispatchByUrl(String r1, String r2) {
        if (t.g.booleanValue() == true) goto L7;
        INVOKESTATIC_com_ss_bduploader_BDAbstractUpload_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "enableDispatch is:" + t.g);
        return null;
    L7:
        return com.ss.bduploader.c.a.a().a(r1, r2);
    }

    public int doVerify(byte[][] r1, String r2, String r3) {
        return com.ss.bduploader.c.c.a(r1, r2, r3);
    }

    public String intelligentInterface(int r2, String r3) {
        INVOKESTATIC_com_ss_bduploader_BDAbstractUpload_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "IntelligentInterface:" + r2 + r3);
        return "testIntelligentInterface return";
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDAbstractUpload_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
