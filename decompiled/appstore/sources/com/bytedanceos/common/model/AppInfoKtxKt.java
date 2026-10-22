package com.bytedanceos.common.model;

import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/common/model/AppInfo;", "Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;", "installMode", "Lhe/a;", "newDomainEntity", "(Lcom/bytedanceos/common/model/AppInfo;Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;)Lhe/a;", "appstorecommon_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AppInfoKtxKt {
    @Deprecated(message = "")
    @NotNull
    public static final he.a newDomainEntity(@NotNull AppInfo r38, @NotNull AppInstallMode r39) {
        q.g(r38, "<this>");
        q.g(r39, "installMode");
        String r10 = r38.appId;
        String r11 = r38.getAppPackageName();
        if (r11 != null) goto L5;
        String r12 = "";
    L6:
        String r13 = r38.appName;
        if (r13 != null) goto L9;
        String r14 = "";
    L10:
        String r15 = r38.appVersionName;
        if (r15 != null) goto L13;
        String r16 = "";
    L14:
        long r17 = r38.appVersionCode;
        String r18 = r38.appDownloadUrl;
        List<String> r19 = r38.appDownloadUrlBackups;
        long r110 = r38.appBytes;
        String r20 = r38.appIcon;
        if (r20 != null) goto L17;
        r20 = "";
    L17:
        String r21 = r38.fileMd5;
        if (r21 != null) goto L20;
        String r111 = "";
    L21:
        String r22 = r38.obricPreloadApkFilePath;
        String r23 = r38.appDeveloper;
        if (r23 != null) goto L24;
        String r112 = "";
    L25:
        String r24 = r38.appDeveloperId;
        if (r24 != null) goto L28;
        String r113 = "";
    L29:
        String r25 = r38.appBrief;
        if (r25 != null) goto L32;
        String r114 = "";
    L33:
        List<String> r26 = r38.appScreenSnaps;
        if (r26 != null) goto L36;
        r26 = null;
    L36:
        List<String> r27 = r26;
        float r28 = r38.appScores;
        String r29 = r38.mCategoryId;
        if (r29 != null) goto L39;
        String r210 = "";
    L40:
        String r30 = r38.secondCategoryId;
        if (r30 != null) goto L43;
        String r211 = "";
    L44:
        int r31 = r38.mAppVideoType;
        String r32 = r38.mAppVideoImage;
        String r33 = r38.mAppVideoUrl;
        String r34 = r38.privacyAgreementUrl;
        String r35 = r38.mOnlineTime;
        String r36 = r38.mTitle;
        String r37 = r38.mSubtitle;
        String r40 = r38.appSource;
        String r310 = q8.a.a(r38, r39.getOrdinal());
        String r41 = r38.sha256;
        if (r41 != null) goto L47;
        String r311 = "";
    L49:
        return new he.a(0, r10, r12, r14, r16, r17, r18, r19, Long.valueOf(r110), r20, r111, r22, r112, r113, r114, r27, Float.valueOf(r28), r210, r211, Integer.valueOf(r31), r32, r33, r34, r35, r36, r37, r40, Boolean.valueOf(r38.isBanner), r310, r311);
    L47:
        r311 = r41;
        goto L49
    L43:
        r211 = r30;
        goto L44
    L39:
        r210 = r29;
        goto L40
    L32:
        r114 = r25;
        goto L33
    L28:
        r113 = r24;
        goto L29
    L24:
        r112 = r23;
        goto L25
    L20:
        r111 = r21;
        goto L21
    L13:
        r16 = r15;
        goto L14
    L9:
        r14 = r13;
        goto L10
    L5:
        r12 = r11;
        goto L6
    }

    public static /* synthetic */ he.a newDomainEntity$default(AppInfo r10, AppInstallMode r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = AppInstallMode.c.f17964a;
    L6:
        return newDomainEntity(r10, r11);
    }
}
