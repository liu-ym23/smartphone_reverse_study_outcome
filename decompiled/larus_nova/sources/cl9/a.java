package cl9;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j27.a {

    /* JADX INFO: renamed from: cl9.a$a, reason: collision with other inner class name */
    public static final class C0457a {
    }

    static {
    }

    @Override // j27.a
    public final void c() {
    }

    @Override // j27.a
    public final Application b() {
        Context r100 = Mira.getAppContext();
        if ((r100 instanceof Application) == true) goto L7;
        return null;
    L7:
        return (Application) r100;
    }

    public a() {
    }

    @Override // j27.a
    public final String a(byte[] r100) {
        Intrinsics.checkNotNullParameter("https://security.snssdk.com/api/plugin/config/v2/", "pluginConfigServerUrl");
        Intrinsics.checkNotNullParameter(r100, "localPluginInfoBytes");
        Intrinsics.checkNotNullParameter("application/json; charset=utf-8", "contentType");
        String r101 = null;
        ISecPrivacyService.f326368a.getClass();     // Catch: Throwable -> L31
        ISecPrivacyService r102 = ISecPrivacyService.a.a();     // Catch: Throwable -> L31
        boolean r103 = false;
        if (r102 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == true) goto L11;
    L34:
        return r101;
    L11:
        if (TextUtils.isEmpty(o.f365780a.getDeviceId()) == true) goto L34;
        if (r100.length != 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        return null;
    L19:
        if (TextUtils.isEmpty("https://security.snssdk.com/api/plugin/config/v2/") == false) goto L21;
    L30:
        return null;
    L21:
        if ("application/json; charset=utf-8".length() != 0) goto L23;
        r103 = true;
    L23:
        if (r103 == true) goto L30;
        Uri.Builder r106 = UriProtector.parse("https://security.snssdk.com/api/plugin/config/v2/").buildUpon();     // Catch: Throwable -> L31
        r106.appendQueryParameter("host_abi", Mira.getHostAbi());     // Catch: Throwable -> L31
        String r107 = ita.i.b(33554432, r106.build().toString(), r100, NetworkUtils.CompressType.GZIP, "application/json; charset=utf-8");     // Catch: Throwable -> L31
        FLogger.f375446a.i("FlowMorpheusAdapter", "plugin config request return result:" + r107);     // Catch: Throwable -> L28
        return r107;
    L28:
        Throwable th10 = th;
        r101 = r107;
    L33:
        FLogger.f375446a.e("FlowMorpheusAdapter", "", th10);
        goto L34
    L15:
        r105 = false;
        goto L16
    L6:
        if (r102.h() != true) goto L8;
        r104 = true;
    L31:
        th = move-exception;
        th10 = th;
        goto L33
    }

    @Override // j27.a
    public final void d(Map r100) {
        FLogger.f375446a.i("FlowMorpheusAdapter", "plugin download event:morpheus_download_process:" + r100);
    }

    @Override // j27.a
    public final void e(l27.b r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginConfig");
        if (r100.f507140m != 0) goto L6;
        r100.f507140m = 1;
        return;
    }
}
