package com.android.ttcjpaysdk.base.router;

import android.app.Activity;
import android.content.Intent;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.caijing.sdk.infra.base.api.router.CJHostRouterMonitorService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004H\u0002J4\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/router/CJRouteOutMonitorUtils;", "", "()V", "CERT_ID_ALIPAY", "", "CERT_ID_CLOUD_UNION_PAY", "CERT_ID_REQUEST_PERMISSION", "CERT_ID_SYSTEM_SETTINGS", "CERT_ID_UNKNOWN_TARGET", "CERT_ID_WXPAY", "injectRouteOutCertIdToIntent", "", "certId", "intent", "Landroid/content/Intent;", "needMonitor", "", "notifyRouteOutCertId", "bizReportParams", "", "bindActivity", "Landroid/app/Activity;", "removeNotifiedRouteOutCertId", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJRouteOutMonitorUtils {
    public static final String CERT_ID_ALIPAY = "31044866";
    public static final String CERT_ID_CLOUD_UNION_PAY = "41489154";
    public static final String CERT_ID_REQUEST_PERMISSION = "41489154";
    public static final String CERT_ID_SYSTEM_SETTINGS = "41489154";
    public static final String CERT_ID_UNKNOWN_TARGET = "41489154";
    public static final String CERT_ID_WXPAY = "131652866";
    public static final CJRouteOutMonitorUtils INSTANCE = null;

    static {
        INSTANCE = new CJRouteOutMonitorUtils();
    }

    private CJRouteOutMonitorUtils() {
    }

    public final void notifyRouteOutCertId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "certId");
        notifyRouteOutCertId$default(this, r100, null, null, 6, null);
    }

    public final void notifyRouteOutCertId(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "certId");
        notifyRouteOutCertId$default(this, r100, r101, null, 4, null);
    }

    private final boolean needMonitor(String r100) {
        JSONArray r101 = CJPaySettingsManager.getInstance().getRouteOutWhiteList();
        if (r101 == null) goto L10;
        int r102 = r101.length();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        if (Intrinsics.areEqual(JSONArrayProtectorUtils.getString(r101, r103), r100) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return false;
    L14:
        return true;
    L10:
        return true;
    }

    public final void removeNotifiedRouteOutCertId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "certId");
        a.f554342a.getClass();
        CJHostRouterMonitorService r101 = (CJHostRouterMonitorService) a.a(CJHostRouterMonitorService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (INSTANCE.needMonitor(r100) == false) goto L9;
        r101.removeNotifiedRouteOutCertId(r100);
        return;
    }

    public final void injectRouteOutCertIdToIntent(String r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "certId");
        Intrinsics.checkNotNullParameter(r101, "intent");
        a.f554342a.getClass();
        CJHostRouterMonitorService r102 = (CJHostRouterMonitorService) a.a(CJHostRouterMonitorService.class);
        if (r102 != null) goto L5;
        return;
    L5:
        if (INSTANCE.needMonitor(r100) == false) goto L9;
        r102.injectRouteOutCertIdToIntent(r100, r101);
        return;
    }

    public final void notifyRouteOutCertId(String r100, Map<String, ? extends Object> r101, Activity r102) {
        Intrinsics.checkNotNullParameter(r100, "certId");
        a.f554342a.getClass();
        CJHostRouterMonitorService r103 = (CJHostRouterMonitorService) a.a(CJHostRouterMonitorService.class);
        if (r103 != null) goto L5;
        return;
    L5:
        if (INSTANCE.needMonitor(r100) == false) goto L9;
        r103.notifyRouteOutCertId(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void notifyRouteOutCertId$default(CJRouteOutMonitorUtils r100, String r101, Map r102, Activity r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.notifyRouteOutCertId(r101, r102, r103);
    }
}
