package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"convertCommonAppEntity", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/bytedanceos/common/model/AppInfo;", "toAppInfo", "app_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CommonAppEntityKt {
    @NotNull
    public static final CommonAppEntity convertCommonAppEntity(@NotNull AppInfo r10) {
        q.g(r10, "<this>");
        CommonAppEntity r11 = new CommonAppEntity();
        r11.setId(r10.appId);
        r11.setName(r10.appName);
        r11.setVersion_code(r10.appVersionCode);     // Catch: NumberFormatException -> L5
    L7:
        r11.setVersion(r10.appVersionName);
        r11.setPkg(r10.appPackageName);
        r11.setLogo(r10.appIcon);
        r11.setScores(r10.appScores);
        r11.setCategory(r10.appCategoryName);
        r11.setDownloadId(r10.downloadId);
        r11.setDefault_check(r10.default_check);
        r11.setFilesize(r10.appBytes);     // Catch: NumberFormatException -> L10
    L26:
        r11.setStatus(String.valueOf(r10.mStatus));     // Catch: NumberFormatException -> L14
    L16:
        r11.setIfgms(r10.mIsNeedGms ? 1 : 0);
        AppInfo.From r12 = r10.appFrom;
        if (r12 == null) goto L19;
        r11.setFrom(r12.mark);
    L19:
        r11.setDownload_url(r10.appDownloadUrl);
        r11.setDefault_check(r10.default_check);
        r11.addItemPosition(r10.itemPosition);
        r11.setRecmd_brief(r10.recmd_brief);
        r11.setSoft_type(r10.mAppType);
        r11.setLabel(r10.mLabels);     // Catch: NumberFormatException -> L22
    L24:
        r11.setItem(new CommonAppItem(r11, r10));
        return r11;
    L22:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @NotNull
    public static final AppInfo toAppInfo(@NotNull CommonAppEntity r10) {
        q.g(r10, "<this>");
        AppInfo r11 = new AppInfo();
        r11.appId = r10.getId();
        r11.appName = r10.getName();
        r11.fileMd5 = r10.getFilemd5();
        r11.appVersionCode = r10.getVersion_code();     // Catch: NumberFormatException -> L5
    L7:
        r11.appVersionName = r10.getVersion();
        r11.appPackageName = r10.getPkg();
        r11.appIcon = r10.getLogo();
        r11.appScores = r10.getScores();
        r11.appCategoryName = r10.getCategory();
        r11.downloadId = r10.getDownloadId();
        r11.default_check = r10.getDefault_check();
        r11.appBytes = r10.getFilesize();     // Catch: NumberFormatException -> L10
    L32:
        String r12 = r10.getStatus();     // Catch: NumberFormatException -> L14
        q.f(r12, "getStatus(...)");     // Catch: NumberFormatException -> L14
        r11.mStatus = Integer.parseInt(r12);     // Catch: NumberFormatException -> L14
    L16:
        boolean r13 = true;
        if (r10.getIfgms() == 1) goto L20;
        r13 = false;
    L20:
        r11.mIsNeedGms = r13;
        r11.appDownloadUrl = r10.getDownload_url();
        r11.itemPosition = r10.getItemPosition();
        r11.recmd_brief = r10.getRecmd_brief();
        r11.mAppType = r10.getSoft_type();
        r11.appSource = "gloable_search";
        r11.mLabels = new ArrayList(r10.getLabel());     // Catch: NumberFormatException -> L23
    L25:
        return r11;
    L23:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
