package com.alipay.sdk.m.x;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.m.u.k;
import com.alipay.sdk.m.u.n;
import com.bytedance.ee.bear.drive.config.fg.DriveVideoPlayConfig;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class e extends LinearLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Handler f25961m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f25962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f25963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f25964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProgressBar f25965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebView f25966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0500e f25967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f25968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f25969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f25970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.alipay.sdk.m.s.a f25971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View.OnClickListener f25972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f25973l;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f25974a;

        /* JADX INFO: renamed from: com.alipay.sdk.m.x.e$a$a, reason: collision with other inner class name */
        public class RunnableC0499a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f25975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f25976b;

            @Override // java.lang.Runnable
            public void run() {
                com_alipay_sdk_m_x_e$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_alipay_sdk_m_x_e$a$a__run$___twin___() {
                this.f25975a.setEnabled(true);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_alipay_sdk_m_x_e$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0499a r100) {
                r100.com_alipay_sdk_m_x_e$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0499a(a r100, View r101) {
                this.f25976b = r100;
                this.f25975a = r101;
            }
        }

        public a(e r100) {
            this.f25974a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            h r101 = e.a(this.f25974a);
            if (r101 == null) goto L11;
            r100.setEnabled(false);
            e.b().postDelayed(new RunnableC0499a(this, r100), 256);
            if (r100 != e.b(this.f25974a)) goto L8;
            r101.b(this.f25974a);
            return;
        L8:
            if (r100 != e.c(this.f25974a)) goto L13;
            r101.a(this.f25974a);
            return;
        L13:
            return;
        }
    }

    public class b implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f25978b;

        public b(e r100, Context r101) {
            this.f25978b = r100;
            this.f25977a = r101;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String r100, String r101, String r102, String r103, long r104) {
            Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(r100));     // Catch: Throwable -> L4
            r105.setFlags(268435456);     // Catch: Throwable -> L4
            this.f25977a.startActivity(r105);     // Catch: Throwable -> L4
            return;
        }
    }

    public class c extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f25979a;

        public c(e r100) {
            this.f25979a = r100;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r100, int r101) {
            if (C0500e.b(e.d(this.f25979a)) == true) goto L5;
            e.e(this.f25979a).setVisibility(8);
            return;
        L5:
            if (r101 <= 90) goto L8;
            e.e(this.f25979a).setVisibility(4);
            return;
        L8:
            if (e.e(this.f25979a).getVisibility() != 4) goto L10;
            e.e(this.f25979a).setVisibility(0);
        L10:
            e.e(this.f25979a).setProgress(r101);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView r100, String r101) {
            e.f(this.f25979a).c(this.f25979a, r101);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView r100, String r101, String r102, String r110, JsPromptResult r111) {
            return e.f(this.f25979a).a(this.f25979a, r101, r102, r110, r111);
        }
    }

    public class d extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f25980a;

        public d(e r100) {
            this.f25980a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            if (e.g(this.f25980a).b(this.f25980a, r101) == true) goto L6;
            super.onPageFinished(r100, r101);
            return;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            if (e.g(this.f25980a).a(this.f25980a, r101) == false) goto L5;
            return true;
        L5:
            return super.shouldOverrideUrlLoading(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            if (e.g(this.f25980a).d(this.f25980a, r101) == true) goto L6;
            super.onPageFinished(r100, r101);
            return;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
            if (e.g(this.f25980a).a(this.f25980a, r101, r102) == true) goto L6;
            super.onReceivedSslError(r100, r101, r102);
            return;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r100, int r101, String r102, String r103) {
            if (e.g(this.f25980a).a(this.f25980a, r101, r102, r103) == true) goto L6;
            super.onReceivedError(r100, r101, r102, r103);
            return;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.e$e, reason: collision with other inner class name */
    public static final class C0500e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f25982b;

        public static /* synthetic */ boolean a(C0500e r100) {
            return r100.f25981a;
        }

        public static /* synthetic */ boolean b(C0500e r100) {
            return r100.f25982b;
        }

        public C0500e(boolean r100, boolean r101) {
            this.f25981a = r100;
            this.f25982b = r101;
        }
    }

    public interface f {
        boolean a(e r100, String r101, String r102, String r103, JsPromptResult r104);

        void c(e r100, String r101);
    }

    public interface g {
        boolean a(e r100, int r101, String r102, String r103);

        boolean a(e r100, SslErrorHandler r101, SslError r102);

        boolean a(e r100, String r101);

        boolean b(e r100, String r101);

        boolean d(e r100, String r101);
    }

    public interface h {
        void a(e r100);

        void b(e r100);
    }

    static {
        f25961m = new Handler(Looper.getMainLooper());
    }

    public String getUrl() {
        return this.f25966e.getUrl();
    }

    public void a() {
        removeAllViews();
        this.f25966e.removeAllViews();
        this.f25966e.setWebViewClient(null);
        this.f25966e.setWebChromeClient(null);
        this.f25966e.destroy();
    }

    public static /* synthetic */ Handler b() {
        return f25961m;
    }

    public ImageView getBackButton() {
        return this.f25962a;
    }

    public ProgressBar getProgressbar() {
        return this.f25965d;
    }

    public ImageView getRefreshButton() {
        return this.f25964c;
    }

    public TextView getTitle() {
        return this.f25963b;
    }

    public WebView getWebView() {
        return this.f25966e;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_alipay_sdk_m_x_e_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void a(Context r110) {
        LinearLayout r100 = new LinearLayout(r110);
        r100.setBackgroundColor(-218103809);
        r100.setOrientation(0);
        r100.setGravity(16);
        if (C0500e.a(this.f25967f) == false) goto L5;
        int r101 = 0;
    L6:
        r100.setVisibility(r101);
        ImageView r102 = new ImageView(r110);
        this.f25962a = r102;
        r102.setOnClickListener(this.f25972k);
        this.f25962a.setScaleType(ImageView.ScaleType.CENTER);
        this.f25962a.setImageDrawable(k.a(k.f25860a, r110));
        this.f25962a.setPadding(a(12), 0, a(12), 0);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r100.addView(this.f25962a, r103);
        View r104 = new View(r110);
        r104.setBackgroundColor(-2500135);
        r100.addView(r104, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView r105 = new TextView(r110);
        this.f25963b = r105;
        r105.setTextColor(-15658735);
        this.f25963b.setTextSize(17.0f);
        this.f25963b.setMaxLines(1);
        this.f25963b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-1, -2);
        r106.setMargins(a(17), 0, 0, 0);
        r106.weight = 1.0f;
        r100.addView(this.f25963b, r106);
        ImageView r107 = new ImageView(r110);
        this.f25964c = r107;
        r107.setOnClickListener(this.f25972k);
        this.f25964c.setScaleType(ImageView.ScaleType.CENTER);
        this.f25964c.setImageDrawable(k.a(k.f25861b, r110));
        this.f25964c.setPadding(a(12), 0, a(12), 0);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r100.addView(this.f25964c, r111);
        addView(r100, new LinearLayout.LayoutParams(-1, a(48)));
        return;
    L5:
        r101 = 8;
        goto L6
    }

    private void b(Context r100) {
        ProgressBar r101 = new ProgressBar(r100, null, R.style.Widget.ProgressBar.Horizontal);
        this.f25965d = r101;
        r101.setProgressDrawable(r100.getResources().getDrawable(R.drawable.progress_horizontal));
        this.f25965d.setMax(100);
        this.f25965d.setBackgroundColor(-218103809);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, a(2));
        addView(this.f25965d, r102);
    }

    private void c(Context r100) {
        WebView r101 = new WebView(r100);
        this.f25966e = r101;
        r101.setVerticalScrollbarOverlay(true);
        a(this.f25966e, r100);
        WebSettings r102 = this.f25966e.getSettings();
        r102.setRenderPriority(WebSettings.RenderPriority.HIGH);
        r102.setSupportMultipleWindows(true);
        r102.setUseWideViewPort(true);
        r102.setAppCacheMaxSize(DriveVideoPlayConfig.DEFAULT_BITRATE);
        r102.setAppCachePath(r100.getCacheDir().getAbsolutePath());
        r102.setAllowFileAccess(false);
        r102.setTextSize(WebSettings.TextSize.NORMAL);
        r102.setAllowFileAccessFromFileURLs(false);
        r102.setAllowUniversalAccessFromFileURLs(false);
        r102.setAppCacheEnabled(true);
        r102.setJavaScriptEnabled(true);
        r102.setSavePassword(false);
        r102.setJavaScriptCanOpenWindowsAutomatically(true);
        r102.setCacheMode(1);
        r102.setDomStorageEnabled(true);
        r102.setAllowContentAccess(false);
        this.f25966e.setVerticalScrollbarOverlay(true);
        this.f25966e.setDownloadListener(new b(this, r100));
        this.f25966e.removeJavascriptInterface("searchBoxJavaBridge_");     // Catch: Exception -> L5
        this.f25966e.removeJavascriptInterface("accessibility");     // Catch: Exception -> L5
        this.f25966e.removeJavascriptInterface("accessibilityTraversal");     // Catch: Exception -> L5
    L7:
        Method r103 = this.f25966e.getClass().getMethod("removeJavascriptInterface", new Class[0]);     // Catch: Throwable -> L12
        if (r103 == null) goto L10;
        r103.invoke(this.f25966e, new Object[]{"searchBoxJavaBridge_"});     // Catch: Throwable -> L12
        r103.invoke(this.f25966e, new Object[]{"accessibility"});     // Catch: Throwable -> L12
        r103.invoke(this.f25966e, new Object[]{"accessibilityTraversal"});     // Catch: Throwable -> L12
    L10:
        com.alipay.sdk.m.x.c.a(this.f25966e);
        addView(this.f25966e, new LinearLayout.LayoutParams(-1, -1));
    }

    public static /* synthetic */ C0500e d(e r100) {
        return r100.f25967f;
    }

    public static /* synthetic */ ProgressBar e(e r100) {
        return r100.f25965d;
    }

    public static /* synthetic */ f f(e r100) {
        return r100.f25968g;
    }

    public static /* synthetic */ g g(e r100) {
        return r100.f25969h;
    }

    public void setChromeProxy(f r100) {
        this.f25968g = r100;
        if (r100 != null) goto L5;
        this.f25966e.setWebChromeClient(null);
        return;
    L5:
        this.f25966e.setWebChromeClient(new c(this));
    }

    public void setWebClientProxy(g r100) {
        this.f25969h = r100;
        if (r100 != null) goto L5;
        this.f25966e.setWebViewClient(null);
        return;
    L5:
        this.f25966e.setWebViewClient(new d(this));
    }

    public void setWebEventProxy(h r100) {
        this.f25970i = r100;
    }

    public static /* synthetic */ ImageView b(e r100) {
        return r100.f25962a;
    }

    public static /* synthetic */ ImageView c(e r100) {
        return r100.f25964c;
    }

    public void a(String r100) {
        this.f25966e.loadUrl(r100);
        com.alipay.sdk.m.x.c.a(this.f25966e);
    }

    private int a(int r100) {
        return (int) (r100 * this.f25973l);
    }

    public static /* synthetic */ h a(e r100) {
        return r100.f25970i;
    }

    public void a(WebView r100, Context r101) {
        String r102 = r100.getSettings().getUserAgentString();
        r100.getSettings().setUserAgentString(r102 + n.g(r101));
    }

    public void a(String r100, byte[] r101) {
        this.f25966e.postUrl(r100, r101);
    }

    public e(Context r100, com.alipay.sdk.m.s.a r101, C0500e r102) {
        this(r100, null, r101, r102);
    }

    public e(Context r100, AttributeSet r101, com.alipay.sdk.m.s.a r102, C0500e r103) {
        super(r100, r101);
        this.f25972k = new a(this);
        if (r103 != null) goto L5;
        r103 = new C0500e(false, false);
    L5:
        this.f25967f = r103;
        this.f25971j = r102;
        this.f25973l = INVOKEVIRTUAL_com_alipay_sdk_m_x_e_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        setOrientation(1);
        a(r100);
        b(r100);
        c(r100);
    }
}
