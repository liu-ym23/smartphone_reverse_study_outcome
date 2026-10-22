package com.smt.obric.appstore.domain.app;

import android.content.Context;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c0;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlin.text.Regex;
import kotlin.text.o;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f18037a = null;

    static {
        f18037a = new l();
    }

    public l() {
    }

    public final AppInfo a(String r49, long r50, long r52, int r54, String r55, String r56, long r57, long r59, Long r61, String r62) {
        q.g(r49, "extraInfo");
        q.g(r56, "downloadUrl");
        if (o.r(r49) == false) goto L6;
        com.bytedanceos.common.toolbox.j.p("[AppStatus] DownloadInfo.toAppInfo error. SDK ERROR??? empty DownloadInfo.extraInfo, downloadId=" + r50 + ", extraInfo=" + r49 + TokenParser.SP);
        return new AppInfo();
    L6:
        List<String> r10 = new Regex("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n").split(r49, 0);
        if (r10.isEmpty() == true) goto L15;
        ListIterator<String> r11 = r10.listIterator(r10.size());
    L10:
        if (r11.hasPrevious() == false) goto L15;
        if (r11.previous().length() == 0) goto L10;
        List r12 = b0.u0(r10, r11.nextIndex() + 1);
    L16:
        String[] r13 = (String[]) r12.toArray(new String[0]);
        int r14 = r13.length;
        if (r14 < 2) goto L19;
        String r15 = r13[1];
    L21:
        if (r14 < 3) goto L23;
        String r16 = r13[2];
    L25:
        if (r14 < 4) goto L27;
        String r17 = r13[3];
        String r410 = "";
    L29:
        if (r14 < 5) goto L31;
        int r18 = c0.b(r13[4]);
    L33:
        if (r14 < 6) goto L35;
        boolean r19 = Boolean.parseBoolean(r13[5]);
    L37:
        if (r14 < 7) goto L39;
        String r110 = r13[6];
    L41:
        if (r14 < 8) goto L43;
        String r20 = r13[7];
    L45:
        if (r14 < 9) goto L48;
        float r21 = Float.parseFloat(r13[8]);
    L47:
        float r22 = r21;
        if (r14 < 10) goto L52;
        int r23 = c0.b(r13[9]);
    L54:
        if (r14 < 11) goto L56;
        int r24 = c0.b(r13[10]);
    L58:
        if (r14 < 12) goto L60;
        String r25 = r13[11];
    L61:
        long r26 = 0;
        if (r14 < 13) goto L64;
        long r30 = c0.c(r13[12]);
    L66:
        if (r14 < 14) goto L68;
        String r28 = r13[13];
    L70:
        if (r14 < 15) goto L72;
        boolean r29 = Boolean.parseBoolean(r13[14]);
    L74:
        if (r14 < 16) goto L76;
        String r32 = r13[15];
    L78:
        if (r14 < 17) goto L80;
        String r33 = r13[16];
    L82:
        if (r14 < 18) goto L84;
        String r27 = r13[17];
    L86:
        if (r14 < 19) goto L88;
        String r34 = r13[18];
    L90:
        if (r14 < 20) goto L92;
        boolean r35 = Boolean.parseBoolean(r13[19]);
    L94:
        if (r14 < 21) goto L96;
        String r36 = r13[20];
    L98:
        if (r14 < 22) goto L100;
        String r37 = r13[21];
    L102:
        if (r14 < 23) goto L104;
        String r38 = r13[22];
    L106:
        if (r14 < 24) goto L108;
        String r39 = r13[23];
    L110:
        if (r14 < 25) goto L112;
        String r40 = r13[24];
    L114:
        if (r14 < 26) goto L116;
        int r41 = c0.b(r13[25]);
    L118:
        if (r14 < 27) goto L120;
        String r42 = r13[26];
    L122:
        if (r14 < 28) goto L124;
        String r43 = r13[27];
    L126:
        if (r14 < 29) goto L128;
        boolean r44 = Boolean.parseBoolean(r13[28]);
    L130:
        if (r14 < 30) goto L132;
        String r45 = r13[29];
    L134:
        if (r14 < 31) goto L137;
        String r111 = r13[30];
    L138:
        if (r14 < 32) goto L141;
        String r46 = r13[31];
    L140:
        String r47 = r27;
        if (r14 < 33) goto L145;
        String r31 = r13[32];
    L147:
        if (r57 > 0) goto L149;
    L157:
        double r112 = 0.0d;
    L158:
        if (r61 == null) goto L160;
        r26 = r61.longValue();
    L160:
        long r48 = r26;
        String r51 = BaseApplication.c().getPackageName();
        String r411 = r31;
        AppInfo r53 = new AppInfo();
        r53.downloadId = r50;
        r53.appName = r17;
        r53.appState = r18;
        r53.appPackageName = r15;
        r53.appSource = r16;
        r53.appDownloadUrl = r56;
        r53.mIsNeedGms = r19;
        if (r54 == 8) goto L163;
    L166:
        r53.downloadStatus = r54;
    L167:
        r53.downloadFilePath = r55;
        r53.downloadTotalBytes = r57;
        r53.downloadCurrentBytes = r59;
        r53.downloadProgress = r112;
        r53.pauseCode = r48;
        r53.appIcon = r110;
        r53.appCategoryName = r20;
        r53.appScores = r22;
        r53.mAppType = r23;
        r53.appVersionCode = r24;
        r53.appVersionName = r25;
        r53.appBytes = r30;
        r53.trackerInfo = r28;
        r53.isAutoDownload = r29;
        r53.mDiffMD5 = r33;
        r53.mDiffDownloadUrl = r47;
        r53.notifyPkgName = r51;
        r53.setFrom(r32);
        if (r62 == null) goto L172;
        Long r58 = kotlin.text.n.i(r62);
        if (r58 == null) goto L172;
        long r60 = r58.longValue();
    L173:
        r53.downloadTime = r60;
        r53.recmd_brief = r34;
        r53.mIsPushReservation = r35;
        r53.mTitle = r36;
        r53.mSubtitle = r37;
        r53.mOnlineTime = r38;
        r53.mAdDsp = r39;
        r53.mAdExtra = r40;
        r53.mRetryNum = r41;
        r53.mMemUrl = r42;
        r53.mDmUrl = r43;
        r53.mIsDownloadApk = r44;
        r53.fileMd5 = r45;
        r53.traceId = r111;
        Integer r63 = kotlin.text.n.g(r46);
        if (r63 == null) goto L176;
    L175:
        int r113 = r63.intValue();
    L180:
        r53.mUpdateModel = r113;
        Integer r64 = kotlin.text.n.g(r411);
        if (r64 == null) goto L183;
        int r65 = r64.intValue();
    L184:
        r53.installMode = r65;
        AppInfo r66 = BaseApplication.c().b().u(r53.appPackageName);
        if (r66 == null) goto L192;
        r53.timeDownloadEnqueue = r66.timeDownloadEnqueue;
        if (TextUtils.isEmpty(r53.fileMd5) == true) goto L189;
    L191:
        r53.appId = r66.appId;
        r53.mUpdateModel = r66.mUpdateModel;
        r53.mSysAppAutoUpdateTaskId = r66.mSysAppAutoUpdateTaskId;
        goto L192
    L189:
        if (TextUtils.equals(r53.appDownloadUrl, r66.appDownloadUrl) == false) goto L191;
        r53.fileMd5 = r66.fileMd5;
    L192:
        r53.debugODownloadState = (int) r52;
        return r53;
    L183:
        r65 = AppInstallMode.c.f17964a.getOrdinal();
        goto L184
    L176:
        r63 = m.a(r16);
        if (r63 != null) goto L175;
        r113 = 0;
    L172:
        com.bytedanceos.common.toolbox.j.p("[AppStatus] DownloadInfo.toAppInfo error. !!!SDK ERROR!!! DownloadInfo.lastModifiedTime stringToLong err, val=" + r62);
        r60 = System.currentTimeMillis();
        goto L173
    L163:
        if (r53.appState != 512) goto L166;
        r53.downloadStatus = 512;
        goto L167
    L149:
        if (r59 <= 0) goto L157;
        double r67 = new BigDecimal((r59 / r57) * ((double) 100)).setScale(0, 4).doubleValue();
        r112 = 0.0d;
        if (r67 < 0.0d) goto L158;
        if (r67 <= 100.0d) goto L156;
        r112 = 100.0d;
        goto L158
    L156:
        r112 = r67;
        goto L158
    L145:
        r31 = r410;
        goto L147
    L141:
        r46 = r410;
        goto L140
    L137:
        r111 = r410;
        goto L138
    L132:
        r45 = r410;
        goto L134
    L128:
        r44 = false;
        goto L130
    L124:
        r43 = r410;
        goto L126
    L120:
        r42 = r410;
        goto L122
    L116:
        r41 = 0;
        goto L118
    L112:
        r40 = r410;
        goto L114
    L108:
        r39 = r410;
        goto L110
    L104:
        r38 = r410;
        goto L106
    L100:
        r37 = r410;
        goto L102
    L96:
        r36 = r410;
        goto L98
    L92:
        r35 = false;
        goto L94
    L88:
        r34 = r410;
        goto L90
    L84:
        r27 = r410;
        goto L86
    L80:
        r33 = r410;
        goto L82
    L76:
        r32 = r410;
        goto L78
    L72:
        r29 = false;
        goto L74
    L68:
        r28 = r410;
        goto L70
    L64:
        r30 = 0;
        goto L66
    L60:
        r25 = r410;
        goto L61
    L56:
        r24 = 0;
        goto L58
    L52:
        r23 = 0;
        goto L54
    L48:
        r21 = 0.0f;
        goto L47
    L43:
        r20 = r410;
        goto L45
    L39:
        r110 = r410;
        goto L41
    L35:
        r19 = false;
        goto L37
    L31:
        r18 = 0;
        goto L33
    L27:
        r410 = "";
        r17 = r410;
        goto L29
    L23:
        r16 = "";
        goto L25
    L19:
        r15 = "";
    L15:
        r12 = t.i();
        goto L16
    }

    public final String b(Context r10, com.smt.obric.appstore.domain.app.entity.a r11) {
        q.g(r10, "context");
        q.g(r11, ServerElements.INFO);
        String r12 = r11.g();
        if (r12 != null) goto L6;
        return "";
    L6:
        return r12;
    }

    public final String c(com.smt.obric.appstore.domain.app.entity.a r10, boolean r11) {
        q.g(r10, ServerElements.INFO);
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.E());
        r12.append("_");
        r12.append(r10.J());
        if (r11 == false) goto L5;
        r12.append("_bak.apk");
    L6:
        String r13 = r12.toString();
        q.f(r13, "toString(...)");
        return r13;
    L5:
        r12.append(".apk");
        goto L6
    }
}
