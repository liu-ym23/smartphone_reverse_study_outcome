package com.bytedanceos.common.utils;

import android.text.TextUtils;
import android.util.MalformedJsonException;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    public class a implements Comparator {
        public a() {
        }

        public int a(AppEntity r10, AppEntity r11) {
            int r12 = h.a(r10.getPkg(), r10.getVersion_code());
            return h.a(r11.getPkg(), r11.getVersion_code()) - r12;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((AppEntity) r10, (AppEntity) r11);
        }
    }

    public static /* synthetic */ int a(String r10, int r11) {
        return e(r10, r11);
    }

    public static void b(AppInfo r10, List r11, int r12) {
        if (r10 == null) goto L22;
        if (r11 != null) goto L5;
        return;
    L5:
        if (BaseApplication.c().e() != 0) goto L7;
        boolean r13 = true;
    L8:
        Iterator r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L34;
        Integer r15 = (Integer) r14.next();
        if (r13 == false) goto L17;
        if (r15.intValue() == 8) goto L10;
    L17:
        if (r15.intValue() == r12) goto L18;
        if (r15.intValue() <= 0) goto L10;
        r10.mLabels.add(0, r15);
        goto L10
    L18:
        r10.mLabels.add(0, r15);
        return;
    L34:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public static AppInfo c(AppEntity r10) {
        return d(r10, null);
    }

    public static AppInfo d(AppEntity r10, String r11) {
        AppInfo r12 = new AppInfo();
        if (r10 == null) goto L32;
        r12.appId = r10.getId();
        r12.appIcon = r10.getLogo();
        r12.appName = r10.getName();
        r12.appBytes = r10.getFilesize();
        r12.appPackageName = r10.getPkg();
        r12.appCategoryName = r10.getCategory();
        r12.appVersionCode = r10.getVersion_code();
        r12.appVersionName = r10.getVersion();
        r12.appDownloadUrl = r10.getDownload_url();
        r12.fileMd5 = r10.getFilemd5();
        if (TextUtils.isEmpty(r12.appDownloadUrl) == false) goto L7;
        r12.appDownloadUrl = r10.getApkfile();
    L7:
        r12.appShareUrl = r10.getShare_download_url();
        r12.mSSTJ = r10.getSstj();
        if (TextUtils.isEmpty(r10.getFrom()) == true) goto L11;
        r12.setFrom(r10.getFrom());
    L11:
        if (TextUtils.isEmpty(r10.getOperative_type()) == true) goto L13;
        r12.setOperative(r10.getOperative_type());
    L13:
        r12.appScores = r10.getScores();
        if (TextUtils.isEmpty(r10.getSource()) == false) goto L17;
        r12.appSource = "local";
    L20:
        boolean r13 = true;
        if (r10.getIfgms() == 1) goto L24;
        r13 = false;
    L24:
        r12.mIsNeedGms = r13;
        r12.recmd_brief = r10.getRecmd_brief();
        if (r10.getSoft_type() != 0) goto L27;
        r10.setSoft_type(0);
    L27:
        r12.mAppType = r10.getSoft_type();
        b(r12, r10.getLabel(), -1);
        r12.mJsonData = h(r10, r11);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L17:
        if (TextUtils.equals(r10.getSource(), "local") == false) goto L19;
        r12.appSource = "local";
        goto L20
    L19:
        r12.appSource = AppInfo.SEARCH_SOURCE_EXTENAL;
    L32:
        return r12;
    }

    public static int e(String r10, int r11) {
        AppInfo r12 = com.bytedanceos.common.toolbox.e.M(r10);
        if (r12 != null) goto L7;
        return 2;
    L7:
        if (r11 > r12.appVersionCode) goto L9;
        return 0;
    L9:
        if (BaseApplication.c().b().U(r10) == false) goto L14;
        return 1;
    L14:
        return 0;
    }

    public static int f(Throwable r10) {
        if ((r10 instanceof MalformedJsonException) == false) goto L6;
        return 2;
    L6:
        return 1;
    }

    public static List g(List r10) {
        if (com.bytedanceos.common.toolbox.c.a(r10) == false) goto L5;
        return r10;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        AppEntity r13 = (AppEntity) r12.next();
        AppInfo r14 = com.bytedanceos.common.toolbox.e.M(r13.getPkg());
        if (r14 == null) goto L12;
        if (r13.getVersion_code() <= r14.appVersionCode) goto L7;
    L12:
        r11.add(r13);
        goto L7
    L13:
        return r11;
    }

    public static String h(AppEntity r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty(r10.getImpression()) == true) goto L6;
        r12.put(ServerElements.ADS_IMPRESSION, r10.getImpression() + r11);
    L6:
        if (TextUtils.isEmpty(r10.getClick()) == true) goto L9;
        r12.put(ServerElements.ADS_CLICK, r10.getClick() + r11);
    L9:
        if (TextUtils.isEmpty(r10.getDownload_report()) == true) goto L12;
        r12.put(ServerElements.ADS_DOWNLOAD_REPORT, r10.getDownload_report());
    L12:
        return r12.toString();
    }

    public static List i(List r10) {
        if (com.bytedanceos.common.toolbox.c.a(r10) == false) goto L5;
        return r10;
    L5:
        Collections.sort(r10, new a());
        return r10;
    }
}
