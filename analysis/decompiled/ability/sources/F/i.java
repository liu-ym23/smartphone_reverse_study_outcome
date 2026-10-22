package F;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import ca.AbstractC0897f;
import com.stepos.aiengine.model.IDownloader;
import f5.InterfaceC1435a;
import g1.AbstractC1451a;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes2.dex */
public class i implements d, u1.c, IDownloader, g2.c, v1.c, com.apm.insight.d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile i f514a;

    public static final void w(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @Override // v1.c
    public int a() {
        return 5;
    }

    @Override // v1.c
    public int b() {
        return 80;
    }

    @Override // u1.c
    public boolean c(Context context) {
        return AbstractC0897f.h(context);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
    }

    @Override // F.d
    public void cover(WebView webView, String str, String str2, String str3) {
    }

    @Override // F.d
    public void d(WebView webView, int i) {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
    }

    @Override // F.d
    public void e(WebView webView) {
    }

    @Override // F.d
    public void f(WebView webView, String str, boolean z10) {
    }

    @Override // F.d
    public void g(WebView webView, String str, boolean z10) {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public ParcelFileDescriptor getFileDescriptor() {
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public Uri getFileUri() {
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getProgress() {
        return 0;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        return 0;
    }

    @Override // F.d
    public void h() {
    }

    @Override // F.d
    public void i(WebView webView, Set set) {
    }

    public void j(String str, String str2) {
        if (AbstractC1451a.f4467a) {
            Log.e(str, str2);
        }
    }

    @Override // F.d
    public boolean k(WebView webView) {
        return false;
    }

    @Override // F.d
    public void l(WebView webView, String str) {
    }

    @Override // F.d
    public void m(WebView webView) {
    }

    @Override // F.d
    public void n(WebView webView, String str) {
    }

    @Override // F.d
    public void o(WebView webView, String str, String str2, String str3, String str4) {
    }

    @Override // F.d
    public void p(WebView webView, String str) {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
    }

    @Override // F.d
    public void q(WebView webView, String str, String str2, String str3, String str4, String str5) {
    }

    public void r(String str, String str2, Throwable th) {
        if (AbstractC1451a.f4467a) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, InterfaceC1435a callback) {
        k.f(id, "id");
        k.f(callback, "callback");
    }

    @Override // F.d
    public void report(WebView webView) {
    }

    @Override // F.d
    public void reportDirectly(WebView webView, String str, String str2) {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
    }

    @Override // F.d
    public void s(WebView webView, String str, int i, String str2) {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
    }

    @Override // F.d
    public void t(WebView webView, String str, String str2, String str3, String str4) {
    }

    @Override // F.d
    public void u() {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        k.f(id, "id");
    }

    @Override // F.d
    public void v(WebView webView) {
    }

    public com.stepos.ability.manager.cache.a x(Context context) {
        com.stepos.ability.manager.cache.a aVar;
        k.f(context, "context");
        com.stepos.ability.manager.cache.a aVar2 = com.stepos.ability.manager.cache.a.f;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = com.stepos.ability.manager.cache.a.f;
            if (aVar == null) {
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                aVar = new com.stepos.ability.manager.cache.a(applicationContext);
                com.stepos.ability.manager.cache.a.f = aVar;
            }
        }
        return aVar;
    }
}
