package a05;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.debug.DebugUtils;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.deviceinfo.DeviceInfoDetector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ttnet.TTNetInit;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import eu5.i;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import otb.n;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.document.render.node.f {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicBoolean f1283r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicBoolean f1284s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f1285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f1286u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f1287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f1288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f1289x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectionService f1290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f1291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f1292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.f f1293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.d f1295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f1301l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f1302m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f1304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1305p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1306q;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f1307a = 0;

        static {
        }
    }

    /* JADX INFO: renamed from: a05.c$c, reason: collision with other inner class name */
    public static final class C0000c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f1308a = 0;

        static {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f1309a = 0;

        static {
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1310a = null;

        static {
            int[] r100 = new int[RenderStage.values().length];
            r100[RenderStage.RENDERING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[RenderStage.RENDER_CACHE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[RenderStage.RENDER_CACHE_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[RenderStage.PULL_DATA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[RenderStage.PULL_DATA_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[RenderStage.RENDER_DOC_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[RenderStage.RENDER_DOC_END.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f1310a = r100;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f1312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f1313c;

        public f(c r100, long r101, long r102) {
            this.f1311a = r100;
            this.f1312b = r101;
            this.f1313c = r102;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            String r100 = this.f1311a.f1291b.e("start_open", ILoadStallMonitor.START_TIME);
            this.f1311a.f1291b.e("start_open", "click_timestamp");
            long r101 = 0;
            if (TextUtils.isEmpty(r100) == true) goto L22;
            long r102 = this.f1312b;
            Intrinsics.checkNotNull(r100);
            long r103 = r102 - CastLongProtector.parseLong(r100);
            long r104 = vv4.g.f557388a - CastLongProtector.parseLong(r100);
            if (r104 > 0) goto L7;
            r104 = 0;
        L7:
            long r105 = vv4.g.f557390c;
            if (r105 > 0) goto L10;
            long r106 = 0;
            long r110 = 0;
            long r111 = 0;
        L11:
            vv4.g.f557390c = 0;
            long r107 = this.f1313c;
            AtomicBoolean r108 = c.f1283r;
            long r112 = r107 - 0;
            r101 = this.f1312b - r107;
            if (Intrinsics.areEqual(this.f1311a.y(), sbb.e.f541303n.getType()) == false) goto L20;
            long r109 = c.f1287v - CastLongProtector.parseLong(r100);
            long r113 = 0;
            if (r109 > 0) goto L16;
            r109 = 0;
        L16:
            long r114 = c.f1288w - c.f1287v;
            long r210 = vv4.g.f557388a - c.f1288w;
            if (r210 <= 0) goto L21;
            long r211 = r109;
            long r115 = r103;
            long r116 = r112;
            long r212 = r114;
            long r213 = r210;
        L23:
            long r117 = r101;
            long r118 = this.f1311a.w(this.f1312b);
            String r119 = d25.d.f466523j;
            if (TextUtils.isEmpty(r119) == true) goto L26;
            String r310 = r119;
            int r311 = 1;
        L27:
            JSONObject r120 = new JSONObject();
            r120.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r115);
            r120.put("cost_time_start_click", r118);
            r120.put("cost_time_webfragmentoncreate", r104);
            r120.put("cost_time_newpluginlist", r111);
            r120.put("cost_time_attchpluginlist", r106);
            r120.put("cost_time_onviewcreated", r110);
            r120.put("cost_time_loadurlstart", r116);
            r120.put("cost_time_create_ui", r117);
            long r121 = r211;
            r120.put("cost_time_containerfragmentoncreate", r121);
            long r122 = r212;
            r120.put("cost_time_loadcontentinfo", r122);
            long r123 = r213;
            r120.put("cost_time_loadcontentfragment", r123);
            r120.put("stage", "create_ui");
            r120.put("docs_result_key", "other");
            r120.put("docs_result_code", 0);
            r120.put("file_type", this.f1311a.y());
            r120.put("sub_type", this.f1311a.z());
            c r124 = this.f1311a;
            if (Intrinsics.areEqual(r124.f1297h, "") == false) goto L30;
            r124.f1297h = du5.b.g(d25.d.f466517d);
        L30:
            r120.put("file_id", r124.f1297h);
            r120.put("version_type", this.f1311a.f1294e);
            r120.put("enable_x5", this.f1311a.f1296g);
            r120.put("scm_version", ow4.a.f527057a);
            r120.put("doc_has_cache", this.f1311a.f1305p);
            r120.put("doc_from", this.f1311a.x());
            AtomicBoolean r125 = c.f1283r;
            r120.put("doc_sub_from", null);
            r120.put("open_doc_desc", null);
            this.f1311a.getClass();
            r120.put("isCoverEnabled", DocOpenConfig.f218555i ? 1 : 0);
            AtomicBoolean r126 = c.f1283r;
            r120.put("is_first_open_docs", String.valueOf(r126.get()));
            r120.put("doc_has_info_cache", c.f1289x);
            r120.put("is_version", r311);
            r120.put("edition_id", r310);
            String r127 = d25.d.d();
            if (r127 != null) goto L33;
            String r128 = "";
        L34:
            r120.put("doc_app_id", r128);
            tt5.a.h("DocReport", "***reportOpenDoc*** CreateUI create_ui: " + r120.get(HiAnalyticsConstant.BI_KEY_COST_TIME) + "    cost_time_webfragmentoncreate: " + r104 + "    cost_time_newpluginlist: " + r111 + "    cost_time_attchpluginlist: " + r106 + "    cost_time_onviewcreated: " + r110 + "    cost_time_loadurlstart: " + r116 + "    cost_time_create_ui: " + r117 + "    cost_time_cotainerfragmentoncreate: " + r121 + "    cost_time_loadcontentinfo: " + r122 + "    cost_time_loadcontentfragment: " + r123 + "    isFirstOpenDocs: " + r126.get());
            com.bytedance.ee.bear.contract.d r129 = this.f1311a.f1291b;
            int r130 = C0000c.f1308a;
            r129.a("dev_performance_stage", r120);
            return;
        L33:
            r128 = r127;
            goto L34
        L26:
            r310 = "none";
            r311 = 0;
        L21:
            r211 = r113;
            r212 = r211;
            r213 = r212;
            r115 = r103;
            r116 = r112;
            goto L23
        L20:
            r113 = 0;
            goto L21
        L10:
            long r131 = vv4.g.f557389b;
            r111 = r131 - vv4.g.f557388a;
            r106 = r105 - r131;
            AtomicBoolean r132 = c.f1283r;
            r110 = 0 - vv4.g.f557390c;
            goto L11
        L22:
            r115 = 0;
            r116 = 0;
            r104 = 0;
            r106 = 0;
            r110 = 0;
            r111 = 0;
            r211 = 0;
            r212 = 0;
            r213 = 0;
            goto L23
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1314a;

        public g(c r100) {
            this.f1314a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            String r100 = "";
            c r101 = this.f1314a;
            r101.getClass();
            String r102 = d25.d.f466523j;     // Catch: Throwable -> L20
            if (TextUtils.isEmpty(r102) == true) goto L6;
            int r103 = 1;
        L7:
            JSONObject r104 = new JSONObject();     // Catch: Throwable -> L20
            r104.put("stage", "load_url_start");     // Catch: Throwable -> L20
            r104.put("docs_result_key", "other");     // Catch: Throwable -> L20
            r104.put("docs_result_code", 0);     // Catch: Throwable -> L20
            r104.put("version_type", r101.f1294e);     // Catch: Throwable -> L20
            r104.put("file_type", r101.y());     // Catch: Throwable -> L20
            r104.put("sub_type", r101.z());     // Catch: Throwable -> L20
            r104.put("enable_x5", r101.f1296g);     // Catch: Throwable -> L20
            r104.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L20
            r104.put("doc_has_cache", r101.f1305p);     // Catch: Throwable -> L20
            r104.put("doc_from", r101.x());     // Catch: Throwable -> L20
            r104.put("doc_sub_from", null);     // Catch: Throwable -> L20
            r104.put("open_doc_desc", null);     // Catch: Throwable -> L20
            if (Intrinsics.areEqual(r101.f1297h, "") == false) goto L10;
            r101.f1297h = du5.b.g(d25.d.f466517d);     // Catch: Throwable -> L20
        L10:
            r104.put("file_id", r101.f1297h);     // Catch: Throwable -> L20
            r104.put("isCoverEnabled", DocOpenConfig.f218555i ? 1 : 0);     // Catch: Throwable -> L20
            r104.put("is_first_open_docs", String.valueOf(c.f1283r.get()));     // Catch: Throwable -> L20
            r104.put("doc_has_info_cache", c.f1289x);     // Catch: Throwable -> L20
            r104.put("is_version", r103);     // Catch: Throwable -> L20
            r104.put("edition_id", r102);     // Catch: Throwable -> L20
            String r105 = d25.d.d();     // Catch: Throwable -> L20
            if (r105 == null) goto L14;
            r100 = r105;
        L14:
            r104.put("doc_app_id", r100);     // Catch: Throwable -> L20
            String r106 = r101.f1291b.e("start_open", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L20
            if (r106 == null) goto L18;
            r104.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r101.f1303n - CastLongProtector.parseLong(r106));     // Catch: Throwable -> L20
        L18:
            tt5.a.h("DocReport", "***reportOpenDoc*** LoadUrlStart: " + r104.get(HiAnalyticsConstant.BI_KEY_COST_TIME));     // Catch: Throwable -> L20
            com.bytedance.ee.bear.contract.d r107 = r101.f1291b;     // Catch: Throwable -> L20
            int r108 = C0000c.f1308a;     // Catch: Throwable -> L20
            r107.a("dev_performance_stage", r104);     // Catch: Throwable -> L20
            return;
        L6:
            r102 = "none";
            r103 = 0;
        L20:
            th = move-exception;
            tt5.a.f("DocReport", th, false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f1283r = new AtomicBoolean(true);
        f1284s = new AtomicBoolean(true);
        Lazy<n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.b().p();
        f1286u = "";
    }

    public final void B() {
        String r100 = this.f1291b.e("wait_download_resource", ILoadStallMonitor.START_TIME);
        if (r100 != null) goto L5;
        long r101 = 0;
    L6:
        this.f1299j = r101;
        this.f1291b.c("wait_download_resource");
        return;
    L5:
        r101 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r100);
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void q() {
        String r100 = this.f1291b.e("wait_preload", ILoadStallMonitor.START_TIME);
        if (r100 != null) goto L5;
        long r101 = 0;
    L6:
        this.f1298i = r101;
        this.f1291b.c("wait_preload");
        String r102 = this.f1291b.e("wait_preload_html", "end_time");
        if (r100 == null) goto L11;
        if (r102 == null) goto L11;
        long r103 = CastLongProtector.parseLong(r102) - CastLongProtector.parseLong(r100);
    L12:
        this.f1300k = r103;
        if (r103 >= 0) goto L15;
        this.f1300k = 0;
    L15:
        this.f1291b.c("wait_preload_html");
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        r101 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r100);
        goto L6
    }

    public final String x() {
        int r100 = a05.e.f1315a;
        com.bytedance.ee.bear.document.d r101 = this.f1295f;
        String r102 = this.f1304o;
        if (r101 == null) goto L16;
        BearUrl r103 = r101.getOriginBearUrl();
        if (r103 == null) goto L17;
        String r104 = r103.f222567h;
        if (r104 != null) goto L9;
        return r102;
    L9:
        if ((!StringsKt.isBlank(r104)) == true) goto L12;
        r104 = null;
    L12:
        if (r104 != null) goto L15;
        return r102;
    L15:
        return r104;
    L17:
        return r102;
    L16:
        return r102;
    }

    public final String y() {
        int r100 = a05.e.f1315a;
        com.bytedance.ee.bear.document.d r101 = this.f1295f;
        String r102 = d25.d.f466520g;
        Intrinsics.checkNotNullParameter(r102, "legacyFileType");
        if (r101 == null) goto L16;
        BearUrl r103 = r101.getOriginBearUrl();
        if (r103 == null) goto L17;
        String r104 = r103.f222560a;
        if (r104 != null) goto L9;
        return r102;
    L9:
        if ((!StringsKt.isBlank(r104)) == true) goto L12;
        r104 = null;
    L12:
        if (r104 != null) goto L15;
        return r102;
    L15:
        return r104;
    L17:
        return r102;
    L16:
        return r102;
    }

    public final String z() {
        int r100 = a05.e.f1315a;
        com.bytedance.ee.bear.document.d r101 = this.f1295f;
        String r102 = d25.d.f466521h;
        Intrinsics.checkNotNullParameter(r102, "legacySubType");
        String r103 = null;
        if (r101 == null) goto L7;
        BearUrl r104 = r101.getOriginBearUrl();
        if (r104 == null) goto L7;
        String r105 = r104.f222560a;
    L9:
        if (Intrinsics.areEqual(r105, "wiki") == false) goto L20;
        if (r101 == null) goto L21;
        String r106 = r101.getDocumentType();
        if (r106 != null) goto L14;
        return r102;
    L14:
        if ((!StringsKt.isBlank(r106)) == false) goto L16;
        r103 = r106;
    L16:
        if (r103 != null) goto L19;
        return r102;
    L19:
        return r103;
    L21:
        return r102;
    L20:
        return r102;
    L7:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void e() {
        iu5.f.a(new f(this, System.currentTimeMillis(), this.f1303n));
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final String getFrom() {
        String r100 = x();
        if (r100 != null) goto L6;
        return "tab_other";
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final long b() {
        return this.f1303n;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final int h() {
        return this.f1305p;
    }

    public static otb.e A(WebView r100) {
        if ((r100 instanceof ChameleonWebView) == false) goto L9;
        oxb.n r101 = ((ChameleonWebView) r100).getServiceManager();
        if (r101 == null) goto L9;
        oxb.f r102 = (oxb.f) r101.a(oxb.f.class);
        if (r102 == null) goto L9;
        return r102.B();
    L9:
        return null;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void a(int r100) {
        tt5.a.h("DocReport", "reportLoginFail");
        String r101 = d25.d.f466523j;     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == true) goto L6;
        int r102 = 1;
    L7:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L12
        r103.put("stage", "pull_data");     // Catch: Throwable -> L12
        r103.put("docs_result_key", "login_fail");     // Catch: Throwable -> L12
        r103.put("docs_result_code", r100);     // Catch: Throwable -> L12
        r103.put("file_type", y());     // Catch: Throwable -> L12
        r103.put("sub_type", z());     // Catch: Throwable -> L12
        r103.put("file_id", du5.b.g(d25.d.f466517d));     // Catch: Throwable -> L12
        r103.put("version_type", this.f1294e);     // Catch: Throwable -> L12
        r103.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L12
        r103.put("doc_has_cache", this.f1305p);     // Catch: Throwable -> L12
        r103.put("doc_from", x());     // Catch: Throwable -> L12
        r103.put("doc_sub_from", null);     // Catch: Throwable -> L12
        r103.put("open_doc_desc", null);     // Catch: Throwable -> L12
        r103.put("is_first_open_docs", String.valueOf(f1283r.get()));     // Catch: Throwable -> L12
        r103.put("doc_has_info_cache", f1289x);     // Catch: Throwable -> L12
        r103.put("is_version", r102);     // Catch: Throwable -> L12
        r103.put("edition_id", r101);     // Catch: Throwable -> L12
        String r104 = d25.d.d();     // Catch: Throwable -> L12
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r103.put("doc_app_id", r104);     // Catch: Throwable -> L12
        com.bytedance.ee.bear.contract.d r105 = this.f1291b;     // Catch: Throwable -> L12
        int r106 = C0000c.f1308a;     // Catch: Throwable -> L12
        r105.a("dev_performance_stage", r103);     // Catch: Throwable -> L12
        return;
    L6:
        r101 = "none";
        r102 = 0;
    L12:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f1302m = r100;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f1301l = r100;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void k(int r100) {
        this.f1306q = r100;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void n(long r100) {
        this.f1303n = r100;
        iu5.f.a(new g(this));
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void p(int r100) {
        this.f1305p = r100;
    }

    public final void r(JSONObject r100) {
        if (Intrinsics.areEqual(r100.optString("isDocHtmlCache"), "true") == false) goto L5;
        r100.put("ssr_preload_from", this.f1302m);
    L14:
        if (Intrinsics.areEqual(r100.optString("clientvar_from"), "CACHE") == false) goto L16;
        r100.put("clientvar_preload_from", this.f1301l);
        return;
    L16:
        Map<String, Set<String>> r101 = d25.d.f466514a;
        tt5.a.b("OfflineUtils", "getClientVarUnusedReason");
        if (TextUtils.equals(d25.d.f466528o, "no_cache") == true) goto L19;
    L21:
        String r102 = d25.d.f466528o;
        if (r102 == null) goto L26;
        r100.put("clientvar_unused_reason", r102);
        return;
    L26:
        return;
    L19:
        if (d25.d.f466526m == false) goto L21;
        d25.d.f466528o = "no_memory_cache";
        goto L21
    L5:
        Map<String, Set<String>> r103 = d25.d.f466514a;
        tt5.a.b("OfflineUtils", "getSsrUnusedReason");
        if (TextUtils.equals(d25.d.f466527n, "no_cache") == true) goto L8;
    L10:
        String r104 = d25.d.f466527n;
        if (r104 == null) goto L14;
        r100.put("ssr_unused_reason", r104);
        goto L14
    L8:
        if (d25.d.f466525l == false) goto L10;
        d25.d.f466527n = "no_memory_cache";
        goto L10
    }

    public final void s(JSONObject r100) {
        r100.put("is_first_open_docs", String.valueOf(f1283r.get()));     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r101 = this.f1292c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r101.f243129d) == false) goto L5;
        String r102 = "1";
    L6:
        r100.put("cpu_core_numbers", r102);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r103 = this.f1292c.getDeviceInfo();     // Catch: Exception -> L25
        String r104 = "";
        if (TextUtils.isEmpty(r103.f243127b) == false) goto L10;
        String r105 = "";
    L11:
        r100.put("cpu_name", r105);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r106 = this.f1292c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r106.f243128c) == false) goto L14;
        String r107 = "";
    L15:
        r100.put("max_cpu_freq", r107);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r108 = this.f1292c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r108.f243130e) == false) goto L18;
        String r109 = "";
    L19:
        r100.put("total_mem", r109);     // Catch: Exception -> L25
        r100.put("tt_web_so_version_code", f1286u);     // Catch: Exception -> L25
        int r110 = d.f1309a;     // Catch: Exception -> L25
        r100.put("network_quality_type", TTNetInit.getEffectiveConnectionType());     // Catch: Exception -> L25
        r100.put("file_id", du5.b.g(d25.d.f466517d));     // Catch: Exception -> L25
        String r111 = d25.d.d();     // Catch: Exception -> L25
        if (r111 == null) goto L23;
        r104 = r111;
    L23:
        r100.put("doc_app_id", r104);     // Catch: Exception -> L25
        r100.put("is_emulator", String.valueOf(ku5.c.j()));     // Catch: Exception -> L25
        r100.put("render_process_memory", eu5.g.f(eu5.b.f474075a));     // Catch: Exception -> L25
        return;
    L18:
        r109 = r108.f243130e;     // Catch: Exception -> L25
        goto L19
    L14:
        r107 = r106.f243128c;     // Catch: Exception -> L25
        goto L15
    L10:
        r105 = r103.f243127b;     // Catch: Exception -> L25
        goto L11
    L5:
        r102 = r101.f243129d;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        tt5.a.m("DocReport", e);
    }

    public final void t(JSONObject r100) {
        int r101 = sbb.e.g(y());
        String r102 = z();
        com.bytedance.ee.bear.document.forecast.a.d(r101);
        if (r101 == 16) goto L5;
    L7:
        r100.put("interrupt_webview_preload", String.valueOf(false));
        r100.put("interrupt_template_preload", String.valueOf(DocOpenConfig.e().contains(y())));
        return;
    L5:
        if (Intrinsics.areEqual(r102, "unknown") == true) goto L7;
        com.bytedance.ee.bear.document.forecast.a.d(sbb.e.g(r102));
        goto L7
    }

    public final long w(long r100) {
        String r101 = this.f1291b.e("start_open", "click_timestamp");
        if (TextUtils.isEmpty(r101) == true) goto L15;
        long r102 = CastLongProtector.parseLong(r101);     // Catch: Exception -> L9
        if (r102 > 0) goto L8;
        return -1;
    L8:
        return r100 - r102;
    L9:
        e = move-exception;
        tt5.a.e("DocReport", "parse click timestamp error", e, false);
        return -1;
    L15:
        return -1;
    }

    public static void u(JSONObject r100, boolean r101) {
        r100.put("is_forseti_fg_on", ForsetiHelper.p());
        r100.put("is_in_forseti", r101);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final int c(DocLoadingState r100, com.bytedance.ee.bear.document.render.node.g r101) {
        int r102 = b.f1307a;
        if (r100 != DocLoadingState.INIT) goto L6;
        return 400;
    L6:
        if (r100 != DocLoadingState.WAITING_DOWNLOAD) goto L9;
        return 101;
    L9:
        if (r100 != DocLoadingState.WAITING_PRELOAD) goto L12;
        return 100;
    L12:
        if (r100 != DocLoadingState.RENDERING) goto L46;
        boolean r103 = false;
        if (r101 != null) goto L16;
    L18:
        if (r103 == false) goto L30;
        RenderStage r104 = r101.b();
        switch(e.f1310a[r104.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            default: goto L22;
        };
    L23:
        return 507;
    L24:
        return 506;
    L25:
        return 505;
    L26:
        return 504;
    L27:
        return 503;
    L28:
        return 502;
    L29:
        return 501;
    L22:
        throw new NoWhenBranchMatchedException();
    L30:
        if (r101 == null) goto L32;
        RenderStage r105 = r101.b();
    L33:
        if (r105 != null) goto L35;
        int r106 = -1;
    L36:
        switch(r106) {
            case -1: goto L46;
            case 0: goto L38;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            default: goto L38;
        };
    L39:
        return 607;
    L40:
        return 606;
    L41:
        return 605;
    L42:
        return 604;
    L43:
        return 603;
    L44:
        return 602;
    L45:
        return 601;
    L38:
        throw new NoWhenBranchMatchedException();
    L35:
        r106 = e.f1310a[r105.ordinal()];
        goto L36
    L32:
        r105 = null;
        goto L33
    L16:
        if (r101.f() != true) goto L18;
        r103 = true;
    L46:
        return 999;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void j(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        tt5.a.b("DocReport", "reportJsReady");
        JSONObject r102 = new JSONObject();
        r102.put("file_type", r100);     // Catch: Throwable -> L5
        r102.put("ordinal", -1);     // Catch: Throwable -> L5
        r102.put("stage", "js_ready");     // Catch: Throwable -> L5
        r102.put("render_process_memory", eu5.g.f(eu5.b.f474075a));     // Catch: Throwable -> L5
    L7:
        v(r102, r101);
        return;
    L5:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void l(long r100, long r101) {
        tt5.a.b("DocReport", "reportHtmlReady");
        JSONObject r102 = new JSONObject();
        r102.put("stage", "html_ready");     // Catch: Throwable -> L9
        String r103 = this.f1291b.e("load_template_gap", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        long r104 = r101 - CastLongProtector.parseLong(r103);     // Catch: Throwable -> L9
    L7:
        r102.put("load_template_gap_time", r104);     // Catch: Throwable -> L9
        r102.put("render_process_memory", eu5.g.f(eu5.b.f474075a));     // Catch: Throwable -> L9
    L11:
        v(r102, r100);
        this.f1291b.c("load_template_gap");
        return;
    L6:
        r104 = -1;
    L9:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L11
    }

    public final void v(JSONObject r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "map");
        if (r111 > 0) goto L16;
        return;
    L16:
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L13
        long r112 = r100 - r111;     // Catch: Throwable -> L13
        tt5.a.b("DocReport", "reportJsReady duration = " + r112);     // Catch: Throwable -> L13
        r110.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r112);     // Catch: Throwable -> L13
        if (f1284s.compareAndSet(true, false) == false) goto L8;
        long r101 = r100 - this.f1292c.d();     // Catch: Throwable -> L13
        long r113 = this.f1292c.d() - this.f1292c.a();     // Catch: Throwable -> L13
        long r102 = Math.max(0 - this.f1292c.a(), 0);     // Catch: Throwable -> L13
        r110.put("doc_init_trace", this.f1292c.i());     // Catch: Throwable -> L13
        r110.put("time_to_fill_pool", r102);     // Catch: Throwable -> L13
        r110.put("cost_time_preload_finish_to_doc_init", r101);     // Catch: Throwable -> L13
        r110.put("cost_time_p0_launch_to_open_doc", r101);     // Catch: Throwable -> L13
        r110.put("cost_time_app_launch_to_doc_init", r113);     // Catch: Throwable -> L13
        r110.put("cost_time_app_launch_to_open_doc", r101 + r113);     // Catch: Throwable -> L13
        this.f1292c.u();     // Catch: Throwable -> L13
    L8:
        Object r103 = null;
        r110.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).a()));     // Catch: Throwable -> L13
        Application r114 = eu5.b.f474075a;     // Catch: Throwable -> L13
        if (r114 == null) goto L11;
        r103 = r114.getSystemService("keyguard");     // Catch: Throwable -> L13
    L11:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Throwable -> L13
        r110.put("screen_status", String.valueOf(((KeyguardManager) r103).inKeyguardRestrictedInputMode()));     // Catch: Throwable -> L13
        r110.put("version_type", this.f1294e);     // Catch: Throwable -> L13
        r110.put("enable_x5", this.f1296g);     // Catch: Throwable -> L13
        r110.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L13
        com.bytedance.ee.bear.contract.d r115 = this.f1291b;     // Catch: Throwable -> L13
        int r116 = C0000c.f1308a;     // Catch: Throwable -> L13
        r115.a("dev_performance_doc_template_preload", r110);     // Catch: Throwable -> L13
        tt5.a.h("DocReport", "reportJsReady reportLoadFinish: " + r110);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public /* synthetic */ c(j r100, com.bytedance.ee.bear.contract.d r101, b0 r110, com.bytedance.ee.bear.contract.f r111, String r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void o(Map<String, ? extends Object> r210, boolean r211, int r212, String r213, boolean r214) {
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L76
        if (r210 == null) goto L6;
        JSONObject r101 = new JSONObject(r210);     // Catch: Throwable -> L76
    L7:
        r101.put("docs_result_key", "other");     // Catch: Throwable -> L76
        r101.put("docs_result_code", 0);     // Catch: Throwable -> L76
        r101.put("file_type", y());     // Catch: Throwable -> L76
        r101.put("sub_type", z());     // Catch: Throwable -> L76
        if (r211 == false) goto L10;
        Object r110 = "preload";
    L11:
        r101.put("docs_open_type", r110);     // Catch: Throwable -> L76
        r101.put("wait_preload_template_time", this.f1298i);     // Catch: Throwable -> L76
        r101.put("wait_resource_time", this.f1299j);     // Catch: Throwable -> L76
        r101.put("version_type", this.f1294e);     // Catch: Throwable -> L76
        r101.put("enable_x5", this.f1296g);     // Catch: Throwable -> L76
        r101.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L76
        r101.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L76
        r101.put("doc_has_cache", this.f1305p);     // Catch: Throwable -> L76
        r101.put("doc_from", x());     // Catch: Throwable -> L76
        r101.put("doc_sub_from", null);     // Catch: Throwable -> L76
        r101.put("open_doc_desc", null);     // Catch: Throwable -> L76
        r101.put("preload_html_enabled", 1);     // Catch: Throwable -> L76
        r101.put("app_visible", String.valueOf(this.f1293d.a()));     // Catch: Throwable -> L76
        r101.put("isLarkWebview", false);     // Catch: Throwable -> L76
        r101.put("doc_has_info_cache", f1289x);     // Catch: Throwable -> L76
        r101.put("is_version", r212);     // Catch: Throwable -> L76
        r101.put("edition_id", r213);     // Catch: Throwable -> L76
        r101.put("is_blank_webview", false);     // Catch: Throwable -> L76
        r(r101);     // Catch: Throwable -> L76
        s(r101);     // Catch: Throwable -> L76
        u(r101, r214);     // Catch: Throwable -> L76
        String r111 = this.f1291b.e("start_open", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L76
        if (r111 == null) goto L43;
        if (r210 == null) goto L16;
        Object r102 = r210.get("timestamp");     // Catch: Throwable -> L76
    L17:
        String r103 = (String) r102;     // Catch: Throwable -> L76
        if (r103 == null) goto L20;
        long r112 = CastLongProtector.parseLong(r103);     // Catch: Throwable -> L76
    L21:
        long r104 = r112;
        long r113 = r104 - CastLongProtector.parseLong(r111);     // Catch: Throwable -> L76
        r101.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r113);     // Catch: Throwable -> L76
        long r105 = w(r104);     // Catch: Throwable -> L76
        r101.put("cost_time_start_click", r105);     // Catch: Throwable -> L76
        Object r106 = this.f1291b.f(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L76
        if (r106 != null) goto L24;
        Object r107 = Long.valueOf(r113);     // Catch: Throwable -> L76
    L25:
        r101.put("time_to_visit", r107);     // Catch: Throwable -> L76
        Object r108 = this.f1291b.f(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_cost_time_click");     // Catch: Throwable -> L76
        if ((r108 instanceof Number) == false) goto L29;
        Long r114 = Long.valueOf(((Number) r108).longValue());     // Catch: Throwable -> L76
    L32:
        if (r114 == null) goto L34;
        r105 = r114.longValue();     // Catch: Throwable -> L76
    L34:
        r101.put("time_to_visit_click", r105);     // Catch: Throwable -> L76
        if (idb.f.a().isCurrentEnable("ccm.docx.open_docs_record_optimize") == false) goto L39;
        if (r106 == null) goto L39;
        r101.put("isDocHtmlCache", true);     // Catch: Throwable -> L76
    L39:
        if (f1283r.compareAndSet(true, false) == false) goto L41;
        long r109 = r100 - this.f1292c.d();     // Catch: Throwable -> L76
        long r115 = this.f1292c.d() - this.f1292c.a();     // Catch: Throwable -> L76
        r101.put("cost_time_p0_launch_to_open_doc", r109);     // Catch: Throwable -> L76
        r101.put("cost_time_app_launch_to_doc_init", r115);     // Catch: Throwable -> L76
        r101.put("cost_time_app_launch_to_open_doc", r109 + r115);     // Catch: Throwable -> L76
    L41:
        f1285t = CastLongProtector.parseLong(r111);     // Catch: Throwable -> L76
        goto L43
    L29:
        if ((r108 instanceof String) == false) goto L31;
        r114 = StringsKt.toLongOrNull((String) r108);     // Catch: Throwable -> L76
        goto L32
    L31:
        r114 = null;
        goto L32
    L24:
        r107 = r106;
        goto L25
    L20:
        r112 = System.currentTimeMillis();     // Catch: Throwable -> L76
        goto L21
    L16:
        r102 = null;
    L43:
        Object r116 = this.f1291b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_from");     // Catch: Throwable -> L76
        if (r116 == null) goto L46;
        r101.put("doc_html_cache_from", r116);     // Catch: Throwable -> L76
    L46:
        String r117 = this.f1291b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_ssrwebview_wait_preload_time");     // Catch: Throwable -> L76
        if (r117 != null) goto L49;
    L52:
        boolean r118 = true;
    L53:
        if (r118 == false) goto L55;
        r117 = "0";
    L55:
        r101.put("wait_ssrwebview_preload_time", r117);     // Catch: Throwable -> L76
        String r119 = this.f1291b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_ssrwebview_is_ready");     // Catch: Throwable -> L76
        if (r119 != null) goto L58;
    L61:
        boolean r120 = true;
    L62:
        if (r120 == false) goto L64;
        r119 = "true";
    L64:
        r101.put("ssrwebview_is_ready", r119);     // Catch: Throwable -> L76
        Object r121 = this.f1291b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_prompt_count");     // Catch: Throwable -> L76
        if (r121 == null) goto L67;
        r101.put("prompt_count", r121);     // Catch: Throwable -> L76
    L67:
        Object r122 = this.f1291b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_over_limit");     // Catch: Throwable -> L76
        if (r122 == null) goto L70;
        r101.put("prompt_get_html_over_limit", r122);     // Catch: Throwable -> L76
    L70:
        r101.put("wait_preload_html_time", this.f1300k);     // Catch: Throwable -> L76
        if (DocOpenConfig.f218559m == false) goto L73;
        int r123 = 1;
    L74:
        r101.put("load_ssr_after_preload_html", r123);     // Catch: Throwable -> L76
        t(r101);     // Catch: Throwable -> L76
        this.f1291b.c("start_open");     // Catch: Throwable -> L76
        this.f1291b.c(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE);     // Catch: Throwable -> L76
        com.bytedance.ee.bear.contract.d r124 = this.f1291b;     // Catch: Throwable -> L76
        int r125 = C0000c.f1308a;     // Catch: Throwable -> L76
        r124.a("dev_performance_doc_open_finish", r101);     // Catch: Throwable -> L76
        tt5.a.h("DocReport", "***reportOpenDoc*** Success  costtime: " + r101.opt(HiAnalyticsConstant.BI_KEY_COST_TIME) + "    map:  " + r101);     // Catch: Throwable -> L76
        return;
    L73:
        r123 = 0;
        goto L74
    L58:
        if (r119.length() == 0) goto L61;
        r120 = false;
        goto L62
    L49:
        if (r117.length() == 0) goto L52;
        r118 = false;
        goto L53
    L10:
        r110 = ChameleonOpenTracker.Stage.RENDER;
        goto L11
    L6:
        r101 = new JSONObject();     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public c(j r100, com.bytedance.ee.bear.contract.d r101, b0 r102, com.bytedance.ee.bear.contract.f r103, String r104, com.bytedance.ee.bear.document.d r105) {
        Intrinsics.checkNotNullParameter(r100, "mConnectionService");
        Intrinsics.checkNotNullParameter(r101, "mAnalyticService");
        Intrinsics.checkNotNullParameter(r102, "infoService");
        Intrinsics.checkNotNullParameter(r103, "appVisibleService");
        Intrinsics.checkNotNullParameter(r104, "versionType");
        this.f1290a = r100;
        this.f1291b = r101;
        this.f1292c = r102;
        this.f1293d = r103;
        this.f1294e = r104;
        this.f1295f = r105;
        Lazy<n> r106 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        this.f1296g = false;
        this.f1297h = "";
        this.f1301l = "unknown";
        this.f1302m = "unknown";
        this.f1304o = "tab_other";
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void g(Map<String, ? extends Object> r100, boolean r110, WebView r111, int r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r111, "webview");
    L42:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (i.b() == false) goto L6;
    L46:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  isWifiProxy");     // Catch: Throwable -> L42
        return;
    L6:
        if (i.a() == true) goto L46;
        ml5.b r101 = DebugUtils.a();     // Catch: Throwable -> L42
        Boolean r102 = Boolean.TRUE;     // Catch: Throwable -> L42
        if (((Boolean) r101.a("renderAccelerate", r102)).booleanValue() == true) goto L11;
    L44:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  Render not Open");     // Catch: Throwable -> L42
        return;
    L11:
        if (((Boolean) DebugUtils.a().a("resourceIntercept", r102)).booleanValue() == false) goto L44;
        if (TextUtils.isEmpty(d25.d.f466517d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  no token");     // Catch: Throwable -> L42
        return;
    L18:
        if (this.f1292c.getPackageName() != null) goto L20;
    L23:
        otb.e r115 = A(r111);     // Catch: Throwable -> L42
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L42
        r103.put("file_type", y());     // Catch: Throwable -> L42
        r103.put("sub_type", z());     // Catch: Throwable -> L42
        if (r110 == false) goto L26;
        String r116 = "preload";
    L27:
        r103.put("docs_open_type", r116);     // Catch: Throwable -> L42
        r103.put("wait_preload_template_time", this.f1298i);     // Catch: Throwable -> L42
        r103.put("wait_resource_time", this.f1299j);     // Catch: Throwable -> L42
        r103.put("version_type", this.f1294e);     // Catch: Throwable -> L42
        r103.put("enable_x5", this.f1296g);     // Catch: Throwable -> L42
        r103.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L42
        r103.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L42
        r103.put("doc_has_cache", this.f1305p);     // Catch: Throwable -> L42
        r103.put("doc_from", x());     // Catch: Throwable -> L42
        r103.put("doc_sub_from", null);     // Catch: Throwable -> L42
        r103.put("open_doc_desc", null);     // Catch: Throwable -> L42
        r103.put("preload_html_enabled", 1);     // Catch: Throwable -> L42
        if (r115 == null) goto L30;
        r115.getLoadingStatusCode();     // Catch: Throwable -> L42
        Long r104 = 0L;     // Catch: Throwable -> L42
    L31:
        r103.put("doc_webview_status_code", r104);     // Catch: Throwable -> L42
        r103.put("app_visible", String.valueOf(this.f1293d.a()));     // Catch: Throwable -> L42
        r103.put("isLarkWebview", false);     // Catch: Throwable -> L42
        r103.put("doc_has_info_cache", f1289x);     // Catch: Throwable -> L42
        r103.put("is_version", r112);     // Catch: Throwable -> L42
        r103.put("edition_id", r113);     // Catch: Throwable -> L42
        r103.put("is_blank_webview", false);     // Catch: Throwable -> L42
        t(r103);     // Catch: Throwable -> L42
        r(r103);     // Catch: Throwable -> L42
        s(r103);     // Catch: Throwable -> L42
        u(r103, r114);     // Catch: Throwable -> L42
        String r117 = this.f1291b.e("start_open", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L42
        if (r117 == null) goto L38;
        String r105 = (String) r100.get("timestamp");     // Catch: Throwable -> L42
        if (r105 == null) goto L37;
        r103.put(HiAnalyticsConstant.BI_KEY_COST_TIME, CastLongProtector.parseLong(r105) - CastLongProtector.parseLong(r117));     // Catch: Throwable -> L42
        goto L38
    L37:
        r103.put(HiAnalyticsConstant.BI_KEY_COST_TIME, System.currentTimeMillis() - CastLongProtector.parseLong(r117));     // Catch: Throwable -> L42
    L38:
        this.f1291b.c("start_open");     // Catch: Throwable -> L42
        this.f1291b.c(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE);     // Catch: Throwable -> L42
        com.bytedance.ee.bear.contract.d r106 = this.f1291b;     // Catch: Throwable -> L42
        int r118 = C0000c.f1308a;     // Catch: Throwable -> L42
        r106.a("dev_performance_doc_open_finish", r103);     // Catch: Throwable -> L42
        StringBuilder r107 = new StringBuilder("***reportOpenDoc*** Failed : ");     // Catch: Throwable -> L42
        r107.append(r103);     // Catch: Throwable -> L42
        r107.append("    performanceTiming:  ");     // Catch: Throwable -> L42
        if (r115 == null) goto L41;
        r115.getPerformanceTiming();     // Catch: Throwable -> L42
    L41:
        r107.append(null);     // Catch: Throwable -> L42
        tt5.a.d("DocReport", r107.toString());     // Catch: Throwable -> L42
        return;
    L30:
        r104 = null;
        goto L31
    L26:
        r116 = ChameleonOpenTracker.Stage.RENDER;
        goto L27
    L20:
        if (StringsKt.contains$default(this.f1292c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed Filter the internal test package of the debug package name");     // Catch: Throwable -> L42
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void i(int r100, boolean r101, int r110, String r111, WebView r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r112, "webview");
        otb.e r114 = A(r112);     // Catch: Throwable -> L21
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L21
        r102.put("docs_result_key", "cancel");     // Catch: Throwable -> L21
        r102.put("docs_result_code", r100);     // Catch: Throwable -> L21
        r102.put("file_type", y());     // Catch: Throwable -> L21
        r102.put("sub_type", z());     // Catch: Throwable -> L21
        if (r101 == false) goto L6;
        String r103 = "preload";
    L7:
        r102.put("docs_open_type", r103);     // Catch: Throwable -> L21
        int r104 = b.f1307a;     // Catch: Throwable -> L21
        if (r100 != 100) goto L11;
        q();     // Catch: Throwable -> L21
    L13:
        r102.put("wait_preload_template_time", this.f1298i);     // Catch: Throwable -> L21
        r102.put("wait_resource_time", this.f1299j);     // Catch: Throwable -> L21
        r102.put("version_type", this.f1294e);     // Catch: Throwable -> L21
        r102.put("enable_x5", this.f1296g);     // Catch: Throwable -> L21
        r102.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L21
        r102.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L21
        r102.put("doc_has_cache", this.f1305p);     // Catch: Throwable -> L21
        r102.put("doc_from", x());     // Catch: Throwable -> L21
        Long r105 = null;
        r102.put("doc_sub_from", null);     // Catch: Throwable -> L21
        r102.put("open_doc_desc", null);     // Catch: Throwable -> L21
        r102.put("preload_html_enabled", 1);     // Catch: Throwable -> L21
        r102.put("file_length", this.f1306q);     // Catch: Throwable -> L21
        if (r114 == null) goto L16;
        r114.getLoadingStatusCode();     // Catch: Throwable -> L21
        r105 = 0L;     // Catch: Throwable -> L21
    L16:
        r102.put("doc_webview_status_code", r105);     // Catch: Throwable -> L21
        r102.put("app_visible", String.valueOf(this.f1293d.a()));     // Catch: Throwable -> L21
        r102.put("isLarkWebview", false);     // Catch: Throwable -> L21
        r102.put("doc_has_info_cache", f1289x);     // Catch: Throwable -> L21
        r102.put("is_version", r110);     // Catch: Throwable -> L21
        r102.put("edition_id", r111);     // Catch: Throwable -> L21
        r102.put("is_blank_webview", false);     // Catch: Throwable -> L21
        r102.put("cost_time_start_click", w(System.currentTimeMillis()));     // Catch: Throwable -> L21
        t(r102);     // Catch: Throwable -> L21
        s(r102);     // Catch: Throwable -> L21
        u(r102, r113);     // Catch: Throwable -> L21
        String r106 = this.f1291b.e("start_open", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L21
        if (r106 == null) goto L19;
        r102.put(HiAnalyticsConstant.BI_KEY_COST_TIME, ((System.currentTimeMillis() - CastLongProtector.parseLong(r106)) - this.f1299j) - this.f1298i);     // Catch: Throwable -> L21
    L19:
        this.f1291b.c("start_open");     // Catch: Throwable -> L21
        this.f1291b.c(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE);     // Catch: Throwable -> L21
        com.bytedance.ee.bear.contract.d r107 = this.f1291b;     // Catch: Throwable -> L21
        int r108 = C0000c.f1308a;     // Catch: Throwable -> L21
        r107.a("dev_performance_doc_open_finish", r102);     // Catch: Throwable -> L21
        tt5.a.d("DocReport", "***reportOpenDoc*** CancelDoc : " + r102 + "    performanceTiming:  ");     // Catch: Throwable -> L21
        return;
    L11:
        if (r100 != 101) goto L13;
        B();     // Catch: Throwable -> L21
        goto L13
    L6:
        r103 = ChameleonOpenTracker.Stage.RENDER;
    L21:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void m(int r110, boolean r111, WebView r210, int r211, String r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "webview");
    L50:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (i.b() == false) goto L6;
    L54:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  isWifiProxy");     // Catch: Throwable -> L50
        return;
    L6:
        if (i.a() == true) goto L54;
        ml5.b r100 = DebugUtils.a();     // Catch: Throwable -> L50
        Boolean r101 = Boolean.TRUE;     // Catch: Throwable -> L50
        if (((Boolean) r100.a("renderAccelerate", r101)).booleanValue() == true) goto L11;
    L52:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  Render not Open");     // Catch: Throwable -> L50
        return;
    L11:
        if (((Boolean) DebugUtils.a().a("resourceIntercept", r101)).booleanValue() == false) goto L52;
        if (TextUtils.isEmpty(d25.d.f466517d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  no token");     // Catch: Throwable -> L50
        return;
    L18:
        if (this.f1292c.getPackageName() != null) goto L20;
    L23:
        otb.e r102 = A(r210);     // Catch: Throwable -> L50
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L50
        r103.put("docs_result_key", "overtime");     // Catch: Throwable -> L50
        r103.put("docs_result_code", r110);     // Catch: Throwable -> L50
        r103.put("file_type", y());     // Catch: Throwable -> L50
        r103.put("sub_type", z());     // Catch: Throwable -> L50
        if (r111 == false) goto L26;
        String r112 = "preload";
    L27:
        r103.put("docs_open_type", r112);     // Catch: Throwable -> L50
        int r113 = b.f1307a;     // Catch: Throwable -> L50
        if (r110 != 100) goto L31;
        q();     // Catch: Throwable -> L50
    L33:
        r103.put("wait_preload_template_time", this.f1298i);     // Catch: Throwable -> L50
        r103.put("wait_resource_time", this.f1299j);     // Catch: Throwable -> L50
        r103.put("version_type", this.f1294e);     // Catch: Throwable -> L50
        r103.put("enable_x5", this.f1296g);     // Catch: Throwable -> L50
        r103.put("scm_version", ow4.a.f527057a);     // Catch: Throwable -> L50
        r103.put("file_id", du5.b.g(d25.d.f466517d));     // Catch: Throwable -> L50
        r103.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L50
        r103.put("doc_has_cache", this.f1305p);     // Catch: Throwable -> L50
        r103.put("doc_from", x());     // Catch: Throwable -> L50
        r103.put("doc_sub_from", null);     // Catch: Throwable -> L50
        r103.put("open_doc_desc", null);     // Catch: Throwable -> L50
        boolean r114 = true;
        r103.put("preload_html_enabled", 1);     // Catch: Throwable -> L50
        if (r102 == null) goto L36;
        r102.getLoadingStatusCode();     // Catch: Throwable -> L50
        Long r115 = 0L;     // Catch: Throwable -> L50
    L37:
        r103.put("doc_webview_status_code", r115);     // Catch: Throwable -> L50
        int r104 = r210.getVisibility();     // Catch: Throwable -> L50
        int r105 = r210.getWindowVisibility();     // Catch: Throwable -> L50
        boolean r116 = this.f1293d.a();     // Catch: Throwable -> L50
        if (r104 != 0) goto L42;
        if (r105 != 0) goto L42;
        if (r116 == false) goto L42;
    L43:
        r103.put("app_visible", r114);     // Catch: Throwable -> L50
        r103.put("isLarkWebview", false);     // Catch: Throwable -> L50
        r103.put("doc_has_info_cache", f1289x);     // Catch: Throwable -> L50
        r103.put("is_version", r211);     // Catch: Throwable -> L50
        r103.put("edition_id", r212);     // Catch: Throwable -> L50
        r103.put("is_blank_webview", false);     // Catch: Throwable -> L50
        t(r103);     // Catch: Throwable -> L50
        s(r103);     // Catch: Throwable -> L50
        u(r103, r213);     // Catch: Throwable -> L50
        String r117 = this.f1291b.e("start_open", ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L50
        if (r117 == null) goto L46;
        r103.put(HiAnalyticsConstant.BI_KEY_COST_TIME, System.currentTimeMillis() - CastLongProtector.parseLong(r117));     // Catch: Throwable -> L50
    L46:
        this.f1291b.c("start_open");     // Catch: Throwable -> L50
        this.f1291b.c(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE);     // Catch: Throwable -> L50
        com.bytedance.ee.bear.contract.d r106 = this.f1291b;     // Catch: Throwable -> L50
        int r118 = C0000c.f1308a;     // Catch: Throwable -> L50
        r106.a("dev_performance_doc_open_finish", r103);     // Catch: Throwable -> L50
        StringBuilder r107 = new StringBuilder("***reportOpenDoc*** Overtime : ");     // Catch: Throwable -> L50
        r107.append(r103);     // Catch: Throwable -> L50
        r107.append("    performanceTiming:  ");     // Catch: Throwable -> L50
        if (r102 == null) goto L49;
        r102.getPerformanceTiming();     // Catch: Throwable -> L50
    L49:
        r107.append(null);     // Catch: Throwable -> L50
        r107.append("    visibility:  ");     // Catch: Throwable -> L50
        r107.append(r104);     // Catch: Throwable -> L50
        r107.append("    windowVisibility:  ");     // Catch: Throwable -> L50
        r107.append(r105);     // Catch: Throwable -> L50
        r107.append("    appIsVisible:  ");     // Catch: Throwable -> L50
        r107.append(r116);     // Catch: Throwable -> L50
        tt5.a.d("DocReport", r107.toString());     // Catch: Throwable -> L50
        return;
    L42:
        r114 = false;
        goto L43
    L36:
        r115 = null;
        goto L37
    L31:
        if (r110 != 101) goto L33;
        B();     // Catch: Throwable -> L50
        goto L33
    L26:
        r112 = ChameleonOpenTracker.Stage.RENDER;
        goto L27
    L20:
        if (StringsKt.contains$default(this.f1292c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime Filter the internal test package of the debug package name");     // Catch: Throwable -> L50
    }
}
