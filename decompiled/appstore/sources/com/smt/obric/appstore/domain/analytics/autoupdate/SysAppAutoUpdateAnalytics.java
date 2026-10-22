package com.smt.obric.appstore.domain.analytics.autoupdate;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.AppPermissionActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/smt/obric/appstore/domain/analytics/autoupdate/SysAppAutoUpdateAnalytics;", "", "", "Lcom/bytedanceos/common/model/AppInfo;", "apps", "", "onGetUpdateInfo", "(Ljava/util/List;)V", "", AppPermissionActivity.EXTRA_APP_PKG, "onDownloadStart", "(Ljava/lang/String;)V", "onDownloadSuccess", "reason", "onDownloadFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "onInstallStart", "onInstallSucc", "onInstallFailed", "Companion", "a", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface SysAppAutoUpdateAnalytics {

    @NotNull
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f17889a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static SysAppAutoUpdateAnalytics f17890b;

        static {
            f17889a = new a();
        }

        public a() {
        }

        public final SysAppAutoUpdateAnalytics a() {
            SysAppAutoUpdateAnalytics r10 = f17890b;
            if (r10 == null) goto L5;
            return r10;
        L5:
            q.y("impl");
            return null;
        }

        public final void b(SysAppAutoUpdateAnalytics r10) {
            q.g(r10, "<set-?>");
            f17890b = r10;
        }
    }

    static {
        Companion = a.f17889a;
    }

    @NotNull
    static SysAppAutoUpdateAnalytics getImpl() {
        return Companion.a();
    }

    static void setImpl(@NotNull SysAppAutoUpdateAnalytics r10) {
        Companion.b(r10);
    }

    void onDownloadFailed(@NotNull String r10, @NotNull String r11);

    void onDownloadStart(@NotNull String r10);

    void onDownloadSuccess(@NotNull String r10);

    void onGetUpdateInfo(@NotNull List<? extends AppInfo> r10);

    void onInstallFailed(@NotNull String r10, @NotNull String r11);

    void onInstallStart(@NotNull String r10);

    void onInstallSucc(@NotNull String r10);
}
