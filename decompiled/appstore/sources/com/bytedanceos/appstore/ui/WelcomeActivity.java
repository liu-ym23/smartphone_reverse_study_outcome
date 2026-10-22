package com.bytedanceos.appstore.ui;

import android.webkit.URLUtil;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.bytedanceos.common.ui.FirstRecommendAppsActivity;
import com.bytedanceos.common.utils.j;
import com.obric.appstore.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WelcomeActivity extends FirstRecommendAppsActivity {
    public WelcomeActivity() {
    }

    @Override // com.bytedanceos.common.ui.FirstRecommendAppsActivity
    public void createNetworkPromptDialog() {
        ConfirmDialog.newInstance(25, true, null).show(getFragmentManager(), "allow_access_net");
    }

    @Override // com.bytedanceos.common.ui.FirstRecommendAppsActivity
    public void downloadApp(AppInfo r10, boolean r11, boolean r12) {
        String r13 = r10.appPackageName;
        if (com.bytedanceos.appstore.datacache.a.N0().b0(r13) == false) goto L8;
        if (com.bytedanceos.appstore.datacache.a.N0().U(r13) == true) goto L8;
        return;
    L8:
        if (com.bytedanceos.appstore.datacache.a.N0().X(r13) == false) goto L10;
        return;
    L10:
        if (r11 == false) goto L13;
        com.bytedanceos.appstore.datacache.a.N0().h(r10);
        e0.e(R.string.wifi_auto_download);
        return;
    L13:
        if (com.bytedanceos.appstore.datacache.a.N0().c0(r13) == false) goto L16;
        j.c(this, r10, r12);
        return;
    L16:
        if (URLUtil.isNetworkUrl(r10.appDownloadUrl) == false) goto L18;
        r10.trackerInfo = getAppInfoTag(r10);
        j.a(this, r10, r12);
        return;
    L18:
        e0.e(R.string.download_error_url);
    }

    @Override // com.bytedanceos.common.ui.FirstRecommendAppsActivity
    public long getDownloadedAppsSize(List r10) {
        return com.bytedanceos.appstore.datacache.a.N0().y(r10);
    }

    @Override // com.bytedanceos.common.ui.FirstRecommendAppsActivity
    public Class getMainActivityClass() {
        return MainActivity.class;
    }

    @Override // com.bytedanceos.common.ui.FirstRecommendAppsActivity
    public void setLastDay(int r10, boolean r11) {
        if (r10 != 0) goto L5;
        com.bytedanceos.common.toolbox.j.a("not need to set today");
        return;
    L5:
        if (2 != r10) goto L7;
        com.bytedanceos.appstore.utils.a.z(r11, true);
        return;
    L7:
        if (1 != r10) goto L12;
        com.bytedanceos.appstore.utils.a.z(r11, false);
        return;
    }
}
