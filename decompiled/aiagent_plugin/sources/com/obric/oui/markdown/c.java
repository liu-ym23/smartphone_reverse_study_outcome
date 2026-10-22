package com.obric.oui.markdown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ttreader.tttext.lite.TTFont;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.i;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OMarkdownResourceLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.lynx.markdown.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Drawable> f35436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.oui.markdown.a f35437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f35438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f35439e;

    /* JADX INFO: compiled from: OMarkdownResourceLoader.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: OMarkdownResourceLoader.kt */
    public interface b {
        int imageRadius();

        int imageTextSpaceBottom();

        int imageTextSpaceTop();

        void loadImage(String r1);

        void onImageLoaded();

        boolean useCustomImageLoader();
    }

    /* JADX INFO: renamed from: com.obric.oui.markdown.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OMarkdownResourceLoader.kt */
    @f(b = "OMarkdownResourceLoader.kt", c = {}, d = "invokeSuspend", e = "com.obric.oui.markdown.OMarkdownResourceLoader$loadImageInternal$1")
    static final class C0960c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f35441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f35442c;

        /* JADX INFO: renamed from: com.obric.oui.markdown.c$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: OMarkdownResourceLoader.kt */
        @f(b = "OMarkdownResourceLoader.kt", c = {}, d = "invokeSuspend", e = "com.obric.oui.markdown.OMarkdownResourceLoader$loadImageInternal$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f35443a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ C0960c f35444b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bitmap f35445c;

            AnonymousClass1(C0960c r3, Bitmap r4, d.c.d r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f35444b = r3;
                this.f35445c = r4;
                super(2, r6);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                o.e(r4, "completion");
                return new AnonymousClass1(this.f35444b, this.f35445c, r4);
            }

            @Override // d.h.a.m
            public final Object invoke(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f35443a != 0) goto L7;
                d.o.a(r6);
                this.f35444b.f35441b.a(this.f35444b.f35442c, (Drawable) ZeusTransformUtils.preCheckCast(new BitmapDrawable(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.a(this.f35444b.f35441b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"), this.f35445c), Drawable.class, "com.obric.aiagent.plugin"));
                c.b(this.f35444b.f35441b).onImageLoaded();
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C0960c(c r3, String r4, d.c.d r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f35441b = r3;
            this.f35442c = r4;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            o.e(r4, "completion");
            return new C0960c(this.f35441b, this.f35442c, r4);
        }

        @Override // d.h.a.m
        public final Object invoke(am r3, d.c.d<? super x> r4) {
            return ((C0960c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0960c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f35440a != 0) goto L38;
            d.o.a(r12);
            InputStream r13 = (InputStream) ZeusTransformUtils.preCheckCast(null, InputStream.class, "com.obric.aiagent.plugin");
            HttpURLConnection r2 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(null, HttpURLConnection.class, "com.obric.aiagent.plugin");
            URLConnection r3 = a(new URL(this.f35442c));     // Catch: Throwable -> L22 Exception -> L24
            if (r3 == null) goto L21;
            HttpURLConnection r4 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r3, HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22 Exception -> L24
            r4.setDoInput(true);     // Catch: Throwable -> L16 Exception -> L18
            a(r4);     // Catch: Throwable -> L16 Exception -> L18
            r13 = r4.getInputStream();     // Catch: Throwable -> L16 Exception -> L18
            Bitmap r5 = BitmapFactory.decodeStream(r13);     // Catch: Throwable -> L16 Exception -> L18
            if (r5 == null) goto L12;
            i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r5, null), m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L16 Exception -> L18
        L12:
            if (r13 == null) goto L14;
            r13.close();
        L14:
            if (r4 == null) goto L31;
            r4.disconnect();
        L31:
            return x.f38692a;
        L18:
            e = e;
            r2 = r4;
        L25:
            a("OMarkdownResourceLoader", "Failed to fetch bitmap: " + e);     // Catch: Throwable -> L22
            if (r13 == null) goto L28;
            r13.close();
        L28:
            if (r2 == null) goto L31;
            r2.disconnect();
        L16:
            th = th;
            r2 = r4;
        L32:
            if (r13 == null) goto L34;
            r13.close();
        L34:
            if (r2 == null) goto L36;
            r2.disconnect();
        L36:
            throw th;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Throwable -> L22 Exception -> L24
        L24:
            e = e;
        L22:
            th = th;
            goto L32
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Skip({"com.obric.aiagent.okhttp"})
        public static URLConnection a(URL r4) {
            URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
            String r1 = r0.getHost();
            String r2 = r0.getPath();
            if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
            ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
            com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
            throw new IOException("[NetGuard] dropped ");
        L5:
            return r4.openConnection();
        }

        @Skip({"com.obric.aiagent.okhttp"})
        public static void a(HttpURLConnection r4) {
            if (ZeusTransformUtils.instanceOf(r4, HttpURLConnection.class) == false) goto L11;
            URL r0 = ((HttpURLConnection) ZeusTransformUtils.preCheckCast(r4, HttpURLConnection.class, "com.obric.aiagent.plugin")).getURL();
            if (r0 == null) goto L11;
            String r1 = r0.getHost();
            String r2 = r0.getPath();
            if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L11;
            ILogDepend.Companion.i("AiAgentHucConnect", "huc connect drop " + r1 + r2);
            com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
            throw new IOException("[NetGuard] dropped ");
        L11:
            r4.connect();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    static {
        f35435a = new a(null);
    }

    @Override // com.lynx.markdown.b
    public com.lynx.markdown.c a(String r1, float r2, float r3, float r4) {
        o.e(r1, "backgroundImage");
        return null;
    }

    @Override // com.lynx.markdown.b
    public TTFont a(String r1) {
        o.e(r1, "family");
        return null;
    }

    public c(Context r9, b r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r12, "delegate");
        Context r7 = ZeusTransformUtils.wrapperContext(r11, "com.obric.aiagent.plugin");
        this.f35438d = r7;
        this.f35439e = r12;
        this.f35436b = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f35437c = new com.obric.oui.markdown.a(36, 26, 0, "default-cursor", r7);
    }

    public static final /* synthetic */ Context a(c r0) {
        return r0.f35438d;
    }

    public static final /* synthetic */ b b(c r0) {
        return r0.f35439e;
    }

    @Override // com.lynx.markdown.b
    public com.lynx.markdown.d a(String r16, float r17, float r18, float r19, float r20) {
        o.e(r16, DBHelper.BATTERY_COL_SOURCE);
        Drawable r3 = (Drawable) ZeusTransformUtils.preCheckCast(this.f35436b.get(r16), Drawable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return (com.lynx.markdown.d) ZeusTransformUtils.preCheckCast(new com.obric.oui.markdown.b((Drawable) ZeusTransformUtils.preCheckCast(this.f35436b.get(r16), Drawable.class, "com.obric.aiagent.plugin"), (int) r17, (int) r18, (int) r19, a(r3, r19), this.f35439e.imageRadius(), this.f35439e.imageTextSpaceTop(), this.f35439e.imageTextSpaceBottom()), com.lynx.markdown.d.class, "com.obric.aiagent.plugin");
    L7:
        if (this.f35439e.useCustomImageLoader() == false) goto L9;
        this.f35439e.loadImage(r16);
        return null;
    L9:
        b(r16);
        return null;
    }

    @Override // com.lynx.markdown.b
    public com.lynx.markdown.e a(String r1, float r2, float r3) {
        o.e(r1, "idSelector");
        if (o.a(r1, "default-cursor") == true) goto L5;
        return null;
    L5:
        return (com.lynx.markdown.e) ZeusTransformUtils.preCheckCast(this.f35437c, com.lynx.markdown.e.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r2, Drawable r3) {
        o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        o.e(r3, "drawable");
        this.f35436b.put(r2, r3);
    }

    private final void b(String r10) {
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0960c(this, r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final int a(Drawable r1, float r2) {
        return (int) ((r2 * r1.getIntrinsicHeight()) / r1.getIntrinsicWidth());
    }
}
