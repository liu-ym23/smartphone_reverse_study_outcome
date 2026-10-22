package com.obric.autogui.resourcemanage;

import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadBean.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DownloadBean {
    public static final a Companion = null;
    public static final int ERROR_EXCEPTION = 5;
    public static final int ERROR_NET_OFF = 1;
    public static final int ERROR_NO_DATA = 4;
    public static final int ERROR_RESPONSE_EMPTY = 2;
    public static final int ERROR_RESPONSE_INTERCEPT = 3;
    public static final int ERROR_SHOULD_NOT_DOWNLOAD = 6;
    private final String extraInfo;
    private final int mApiVersionMax;
    private final int mApiVersionMin;
    private final List<String> mBackupUrlList;
    private final String mCustomMsg;
    private final int mErrorCode;
    private final int mFlag;
    private final long mFollowId;
    private final String mMd5;
    private final String mPackageName;
    private final String mUrl;
    private final int mVersionCode;

    /* JADX INFO: compiled from: DownloadBean.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final DownloadBean a(JSONObject r18) {
            d.h.b.o.e(r18, "pluginObject");
            String r8 = r18.optString("url");
            List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            JSONArray r2 = r18.optJSONArray("backup_urls");
            if (r2 != null) goto L5;
        L12:
            long r4 = r18.optLong(DbHelper.COL_ID);
            String r6 = r18.optString("sdk_pkg");
            int r7 = r18.optInt("sdk_ver_code");
            int r9 = r18.optInt("flag", 2);
            String r10 = r18.optString("md5");
            String r11 = r18.optString("plugin_info");
            if (r1.isEmpty() == false) goto L16;
            r1 = null;
        L16:
            return new DownloadBean(0, r4, r6, r7, r8, r9, r10, r11, r1, 0, Integer.MAX_VALUE, r18.optString("custom_msg"));
        L5:
            if (r2.length() <= 0) goto L12;
            int r5 = 0;
            int r12 = r2.length();
        L7:
            if (r5 >= r12) goto L12;
            String r13 = r2.getString(r5);
            if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L11;
            d.h.b.o.a(r13);
            r1.add(r13);
        L11:
            r5 = r5 + 1;
            goto L7
        }
    }

    static {
        Companion = new a(null);
    }

    public DownloadBean() {
        this(0, 0, null, 0, null, 0, null, null, null, 0, 0, null, 4095, null);
    }

    public static /* synthetic */ DownloadBean copy$default(DownloadBean r14, int r15, long r16, String r18, int r19, String r20, int r21, String r22, String r23, List r24, int r25, int r26, String r27, int r28, Object r29) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        if ((r28 & 1) == 0) goto L5;
        int r3 = r14.mErrorCode;
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r4 = r14.mFollowId;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = r14.mPackageName;
    L15:
        if ((r28 & 8) == 0) goto L17;
        int r7 = r14.mVersionCode;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r8 = r14.mUrl;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r9 = r14.mFlag;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r10 = r14.mMd5;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r11 = r14.extraInfo;
    L35:
        if ((r28 & 256) == 0) goto L38;
        r2 = r14.mBackupUrlList;
    L38:
        if ((r28 & 512) == 0) goto L40;
        int r12 = r14.mApiVersionMin;
    L42:
        if ((r28 & 1024) == 0) goto L44;
        int r13 = r14.mApiVersionMax;
    L46:
        if ((r28 & 2048) == 0) goto L48;
        String r1 = r14.mCustomMsg;
    L50:
        return r14.copy(r3, r4, r6, r7, r8, r9, r10, r11, r2, r12, r13, r1);
    L48:
        r1 = r27;
        goto L50
    L44:
        r13 = r26;
        goto L46
    L40:
        r12 = r25;
        goto L42
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public static final DownloadBean fromJson(JSONObject r1) {
        return Companion.a(r1);
    }

    public final int component1() {
        return this.mErrorCode;
    }

    public final int component10() {
        return this.mApiVersionMin;
    }

    public final int component11() {
        return this.mApiVersionMax;
    }

    public final String component12() {
        return this.mCustomMsg;
    }

    public final long component2() {
        return this.mFollowId;
    }

    public final String component3() {
        return this.mPackageName;
    }

    public final int component4() {
        return this.mVersionCode;
    }

    public final String component5() {
        return this.mUrl;
    }

    public final int component6() {
        return this.mFlag;
    }

    public final String component7() {
        return this.mMd5;
    }

    public final String component8() {
        return this.extraInfo;
    }

    public final List<String> component9() {
        return this.mBackupUrlList;
    }

    public final DownloadBean copy(int r16, long r17, String r19, int r20, String r21, int r22, String r23, String r24, List<String> r25, int r26, int r27, String r28) {
        return new DownloadBean(r16, r17, r19, r20, r21, r22, r23, r24, (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin"), r26, r27, r28);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, DownloadBean.class) == true) goto L8;
        return false;
    L8:
        DownloadBean r10 = (DownloadBean) ZeusTransformUtils.preCheckCast(r9, DownloadBean.class, "com.obric.aiagent.plugin");
        if (this.mErrorCode == r10.mErrorCode) goto L12;
        return false;
    L12:
        if (this.mFollowId == r10.mFollowId) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.mPackageName, r10.mPackageName) == true) goto L18;
        return false;
    L18:
        if (this.mVersionCode == r10.mVersionCode) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.mUrl, r10.mUrl) == true) goto L24;
        return false;
    L24:
        if (this.mFlag == r10.mFlag) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.mMd5, r10.mMd5) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.extraInfo, r10.extraInfo) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.mBackupUrlList, r10.mBackupUrlList) == true) goto L36;
        return false;
    L36:
        if (this.mApiVersionMin == r10.mApiVersionMin) goto L39;
        return false;
    L39:
        if (this.mApiVersionMax == r10.mApiVersionMax) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.mCustomMsg, r10.mCustomMsg) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.mErrorCode) * 31) + Long.hashCode(this.mFollowId)) * 31;
        String r1 = this.mPackageName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.mVersionCode)) * 31;
        String r5 = this.mUrl;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.mFlag)) * 31;
        String r8 = this.mMd5;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.extraInfo;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<String> r14 = this.mBackupUrlList;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((r13 + r15) * 31) + Integer.hashCode(this.mApiVersionMin)) * 31) + Integer.hashCode(this.mApiVersionMax)) * 31;
        String r17 = this.mCustomMsg;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DownloadBean(mErrorCode=").append(this.mErrorCode).append(", mFollowId=").append(this.mFollowId).append(", mPackageName=").append(this.mPackageName).append(", mVersionCode=").append(this.mVersionCode).append(", mUrl=").append(this.mUrl).append(", mFlag=").append(this.mFlag).append(", mMd5=").append(this.mMd5).append(", extraInfo=").append(this.extraInfo).append(", mBackupUrlList=").append(this.mBackupUrlList).append(", mApiVersionMin=").append(this.mApiVersionMin).append(", mApiVersionMax=").append(this.mApiVersionMax).append(", mCustomMsg=");
        r0.append(this.mCustomMsg).append(')');
        return r0.toString();
    }

    public DownloadBean(int r3, long r4, String r6, int r7, String r8, int r9, String r10, String r11, List<String> r12, int r13, int r14, String r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        this.mErrorCode = r3;
        this.mFollowId = r4;
        this.mPackageName = r6;
        this.mVersionCode = r7;
        this.mUrl = r8;
        this.mFlag = r9;
        this.mMd5 = r10;
        this.extraInfo = r11;
        this.mBackupUrlList = r16;
        this.mApiVersionMin = r13;
        this.mApiVersionMax = r14;
        this.mCustomMsg = r15;
    }

    public /* synthetic */ DownloadBean(int r15, long r16, String r18, int r19, String r20, int r21, String r22, String r23, List r24, int r25, int r26, String r27, int r28, d.h.b.h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if ((r28 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r4 = 0;
    L10:
        String r7 = null;
        if ((r28 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r28 & 256) == 0) goto L38;
        r1 = null;
    L38:
        if ((r28 & 512) != 0) goto L42;
        r3 = r25;
    L42:
        if ((r28 & 1024) == 0) goto L44;
        int r13 = Integer.MAX_VALUE;
    L46:
        if ((r28 & 2048) != 0) goto L49;
        r7 = r27;
    L49:
        this(r2, r4, r6, r8, r9, r10, r11, r12, r1, r3, r13, r7);
        return;
    L44:
        r13 = r26;
        goto L46
    L33:
        r12 = r23;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L10
    L5:
        r2 = r15;
        goto L7
    }

    public final int getMErrorCode() {
        return this.mErrorCode;
    }

    public final long getMFollowId() {
        return this.mFollowId;
    }

    public final String getMPackageName() {
        return this.mPackageName;
    }

    public final int getMVersionCode() {
        return this.mVersionCode;
    }

    public final String getMUrl() {
        return this.mUrl;
    }

    public final int getMFlag() {
        return this.mFlag;
    }

    public final String getMMd5() {
        return this.mMd5;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final List<String> getMBackupUrlList() {
        return this.mBackupUrlList;
    }

    public final int getMApiVersionMin() {
        return this.mApiVersionMin;
    }

    public final int getMApiVersionMax() {
        return this.mApiVersionMax;
    }

    public final String getMCustomMsg() {
        return this.mCustomMsg;
    }

    public final boolean isUnInstall() {
        if (this.mFlag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isRevert() {
        if (this.mFlag != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hasResult() {
        if (this.mErrorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isValid() {
        if (this.mErrorCode == 0) goto L5;
        return false;
    L5:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mPackageName, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return false;
    L14:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mUrl, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
        return false;
    L23:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mMd5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L26;
    L29:
        boolean r5 = true;
    L30:
        if (r5 == false) goto L33;
        return false;
    L33:
        if (this.mVersionCode > 0) goto L36;
        return false;
    L36:
        if (d.a.p.b(new Integer[]{0, 1, 2, 3}).contains(Integer.valueOf(this.mFlag)) == true) goto L38;
        return false;
    L38:
        return true;
    L26:
        if (r4.length() == 0) goto L29;
        r5 = false;
        goto L30
    L17:
        if (r2.length() == 0) goto L20;
        r3 = false;
        goto L21
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final boolean shouldDownload() {
        if (isValid() == true) goto L5;
    L9:
        return false;
    L5:
        if (isUnInstall() == true) goto L9;
        if (isRevert() == true) goto L9;
        return true;
    }
}
