package l6;

import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements NetworkParams.CookieShareInterceptor, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f21883g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21889f;

    public f() {
        a();
    }

    public static f c() {
        if (f21883g != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21883g != null) goto L11;
        f21883g = new f();     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f21883g;
    }

    public void a() {
        Logger.w("SyncMainProcessConfig", "Sync main process config in current process.");
        this.f21884a = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(this.f21884a);
        boolean r10 = false;
        this.f21885b = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r11 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.f21886c = r11;
        if (this.f21885b > 0) goto L5;
        if (r11 > 0) goto L5;
    L6:
        this.f21887d = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.f21888e = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.f21889f = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r12 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", Integer.MIN_VALUE);
        String r13 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
        y4.d.e().j(TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "L0_params", ""));
        if (r12 == Integer.MIN_VALUE) goto L13;
        y4.d r14 = y4.d.e();
        if (r12 <= 0) goto L11;
        r10 = true;
    L11:
        r14.c(r10);
        y4.d.e().f(r13);
        return;
    L13:
        return;
    L5:
        r6.b.d(true);
        goto L6
    }

    public final boolean b(String r10, List r11) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L5;
    L14:
        return false;
    L5:
        if (com.bytedance.common.utility.c.a(r11) == true) goto L14;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r10.endsWith((String) r12.next()) == false) goto L9;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List getShareCookie(CookieManager r10, r4.a r11, URI r12) {
        if (r12 == null) goto L38;
        if (r10 != null) goto L39;
        if (r11 == null) goto L38;
    L39:
        String r13 = r12.getHost();     // Catch: Exception -> L9
    L10:
        ArrayList r14 = new ArrayList();
        String[] r15 = this.f21884a.split(",");
        int r16 = r15.length;
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L17;
        String r18 = r15[r17];
        if (com.bytedance.common.utility.e.b(r18) == true) goto L15;
        r14.add(r18);
    L15:
        r17 = r17 + 1;
        goto L11
    L17:
        if (com.bytedance.common.utility.e.b(r13) == true) goto L38;
        if (b(r13, r14) == false) goto L38;
        ArrayList r19 = new ArrayList();
        if (r10 == null) goto L27;
        String r20 = r10.getCookie(TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (com.bytedance.common.utility.e.b(r20) == true) goto L27;
        r19.add(r20);
    L27:
        if (com.bytedance.common.utility.c.a(r19) == false) goto L46;
        if (r11 == null) goto L47;
        Map r21 = r11.get(URI.create(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L35
        if (r21 != null) goto L32;
        return r19;
    L32:
        if (r21.isEmpty() == true) goto L49;
        return (List) r21.get("Cookie");
    L49:
        return r19;
    L35:
        th = move-exception;
        th.printStackTrace();
        return r19;
    L47:
        return r19;
    L46:
        return r19;
    L9:
        r13 = null;
    L38:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List getShareCookieHostList(String r10) {
        ArrayList r11 = new ArrayList();
        String[] r12 = this.f21884a.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        String r15 = r12[r14];
        if (com.bytedance.common.utility.e.b(r15) == true) goto L7;
        r11.add(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        String r16 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (com.bytedance.common.utility.e.b(r16) == true) goto L14;
        if (b(r16, r11) == true) goto L14;
        r11.add(r16);
    L14:
        if (b(r10, r11) == false) goto L16;
        return r11;
    L16:
        return null;
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (a.N == false) goto L7;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(0);
        return false;
    L7:
        if (a.P == false) goto L11;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(8);
        return false;
    L11:
        if (a.k() == false) goto L14;
        return false;
    L14:
        if (a.M == true) goto L20;
        if (this.f21889f <= 5) goto L20;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(3);
        Logger.e("SyncMainProcessConfig", "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L23;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(6);
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        if (a.M == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) > 5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetHttpDnsConfig
    public boolean isCronetHttpDnsOpen() {
        if (a.N == false) goto L6;
        return false;
    L6:
        if (this.f21888e <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesHeaderOpen() {
        if (this.f21886c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesOpen() {
        if (this.f21885b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesPlaintextOpen() {
        if (this.f21887d <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
