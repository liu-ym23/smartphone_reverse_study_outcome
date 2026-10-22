package androidx.webkit;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import androidx.webkit.internal.p;
import androidx.webkit.internal.q;
import androidx.webkit.internal.r;
import androidx.webkit.internal.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: WebViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f3014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f3015b = null;

    /* JADX INFO: compiled from: WebViewCompat.java */
    public interface a {
        void a(long r1);
    }

    static {
        f3014a = Uri.parse("*");
        f3015b = Uri.parse("");
    }

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        return c();
    L11:
        return null;
    L8:
        return androidx.webkit.internal.d.a();
    }

    private static PackageInfo c() {
        return (PackageInfo) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.webkit.WebViewFactory", "com.obric.aiagent.plugin").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]), PackageInfo.class, "com.obric.aiagent.plugin");
    }

    private static r a(WebView r1) {
        return new r(b(r1));
    }

    public static boolean b() {
        if (p.R.d() == false) goto L7;
        return d().b().isMultiProcessEnabled();
    L7:
        throw p.a();
    }

    public static void a(WebView r1, String r2) {
        if (p.ac.d() == false) goto L7;
        a(r1).a(r2);
        return;
    L7:
        throw p.a();
    }

    private static s d() {
        return q.a();
    }

    private static WebViewProviderBoundaryInterface b(WebView r1) {
        return d().a(r1);
    }
}
