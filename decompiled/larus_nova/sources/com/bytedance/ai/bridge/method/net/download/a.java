package com.bytedance.ai.bridge.method.net.download;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.method.net.core.IHostNetworkRuntimeApi;
import com.bytedance.ai.bridge.network.AbsDownloadFileMethodIDL;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.RequestContext;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.a0;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f35641c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f35642d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CoroutineScope f35643e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f35644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<f, Map<String, b>> f35645b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$a, reason: collision with other inner class name */
    public static final class C0691a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f35647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e3.d f35649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppletFileManager f35650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f35651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, String> f35652g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f35653h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f35654i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final IHostNetworkDepend f35655j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final f3.h<AbsDownloadFileMethodIDL.b> f35656k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final h f35657l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public i f35658m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Long f35659n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Long f35660o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Job f35661p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f35662q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ a f35663r;

        public final String b() {
            Intrinsics.checkNotNullParameter("downloadFile:fail abort", "message");
            return (String) this.f35657l.a(new com.bytedance.ai.bridge.method.net.download.b(this));
        }

        public final String g() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            Object r101 = Result.m9449constructorimpl(new URI(this.f35651f).getHost());     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r101) == false) goto L9;
            r101 = null;
        L9:
            String r102 = (String) r101;
            if (r102 != null) goto L15;
            return "unknown";
        L15:
            return r102;
        L4:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final com.bytedance.ai.file.a c(final Call<TypedInput> r100) {
            return (com.bytedance.ai.file.a) this.f35657l.a(new com.bytedance.ai.bridge.method.net.download.h(this, r100));
        }

        public final void d(final d r100) {
            this.f35657l.execute(new com.bytedance.ai.bridge.method.net.download.c(this, r100));
        }

        public final void f(List<? extends c> r210) {
            a r100 = this.f35663r;
            Iterator<T> r101 = r210.iterator();
        L4:
            if (r101.hasNext() == false) goto L119;
            c r102 = (c) r101.next();
            if (Intrinsics.areEqual(r102, c.m.f35679a) == true) goto L7;
            boolean r103 = false;
            if (Intrinsics.areEqual(r102, c.g.f35671a) == true) goto L10;
            if (Intrinsics.areEqual(r102, c.l.f35678a) == true) goto L47;
            if ((r102 instanceof c.d) == true) goto L50;
            if ((r102 instanceof c.C0692a) == true) goto L53;
            if ((r102 instanceof c.k) == true) goto L56;
            if ((r102 instanceof c.j) == true) goto L63;
            if (Intrinsics.areEqual(r102, c.h.f35672a) == true) goto L66;
            if ((r102 instanceof c.C0693c) == true) goto L87;
            if ((r102 instanceof c.b) == true) goto L94;
            if ((r102 instanceof c.i) == true) goto L110;
            if ((r102 instanceof c.e) == true) goto L113;
            if ((r102 instanceof c.f) == false) goto L118;
            com.bytedance.ai.utils.g.f37637a.w("AppletDownloadFileManager", this.f35662q + ' ' + ((c.f) r102).f35670a);
            goto L4
        L118:
            throw new NoWhenBranchMatchedException();
        L113:
            com.bytedance.ai.utils.g.f37637a.i("AppletDownloadFileManager", this.f35662q + ' ' + ((c.e) r102).f35669a);
            goto L4
        L110:
            c.i r104 = (c.i) r102;
            com.bytedance.ai.monitor.b.b("flow_applet_download_file_success", new k(r104.f35673a, r104.f35674b, this));
            goto L4
        L94:
            e r105 = ((c.b) r102).f35665a;
            if (r105.f35699b != null) goto L100;
            if (r105.f35700c != null) goto L100;
            f3.h.a.a(this.f35656k, a.e(this.f35663r, r105.f35698a), null, null, 14);
        L100:
            f3.h<AbsDownloadFileMethodIDL.b> r106 = this.f35656k;
            String r107 = a.e(this.f35663r, r105.f35698a);
            Intrinsics.checkNotNullParameter(AbsDownloadFileMethodIDL.b.class, "<this>");
            AbsDownloadFileMethodIDL.b r108 = (AbsDownloadFileMethodIDL.b) k3.c.a(AbsDownloadFileMethodIDL.b.class);
            Integer r109 = r105.f35699b;
            if (r109 == null) goto L103;
            int r110 = r109.intValue();
        L104:
            r108.setStatusCode(r110);
            Map<String, String> r111 = r105.f35700c;
            if (r111 != null) goto L107;
            r111 = MapsKt.emptyMap();
        L107:
            r108.setHeader(r111);
            Unit r112 = Unit.INSTANCE;
            f3.h.a.a(r106, r107, null, r108.toJson(), 6);
            goto L4
        L103:
            r110 = -1;
            goto L104
        L87:
            c.C0693c r113 = (c.C0693c) r102;
            g r114 = r113.f35666a;
            j r115 = r113.f35667b;
            Intrinsics.checkNotNullParameter(AbsDownloadFileMethodIDL.b.class, "<this>");
            AbsDownloadFileMethodIDL.b r116 = (AbsDownloadFileMethodIDL.b) k3.c.a(AbsDownloadFileMethodIDL.b.class);
            r116.setStatusCode(r115.f35722a);
            r116.setHeader(r115.f35723b);
            if (r114.f35705b == false) goto L90;
            r116.setFilePath(r114.f35704a.a());
        L91:
            f3.h.a.b(this.f35656k, r116);
            goto L4
        L90:
            r116.setTempFilePath(r114.f35704a.a());
            goto L91
        L66:
            String r117 = this.f35646a;
            f r118 = this.f35647b;
            Object r119 = r100.f35644a;
            monitor-enter(r119);
            Map r120 = (Map) ((LinkedHashMap) r100.f35645b).get(r118);     // Catch: Throwable -> L82
            if (r120 == null) goto L70;
            if (r120.get(r117) != this) goto L74;
            r120.remove(r117);     // Catch: Throwable -> L82
            if (r120.isEmpty() == false) goto L79;
            r100.f35645b.remove(r118);     // Catch: Throwable -> L82
        L79:
            Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L82
            monitor-exit(r119);
            goto L4
        L74:
            monitor-exit(r119);
            goto L4
        L70:
            monitor-exit(r119);
        L82:
            th = move-exception;
            throw th;
        L63:
            e3.d r122 = this.f35649d;
            String r123 = this.f35646a;
            Map<String, String> r124 = ((c.j) r102).f35675a;
            Regex r125 = a.f35641c;
            r100.getClass();
            Lazy r126 = com.bytedance.ai.applet.base.gson.e.f34515a;
            r122.a("downloadFileHeadersReceived", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadTaskId", r123), TuplesKt.to("downloadTaskID", r123), TuplesKt.to("header", r124)})));
            goto L4
        L56:
            e3.d r127 = this.f35649d;
            String r128 = this.f35646a;
            c.k r129 = (c.k) r102;
            long r130 = r129.f35676a;
            long r131 = r129.f35677b;
            Regex r132 = a.f35641c;
            r100.getClass();
            if (r131 <= 0) goto L59;
            int r133 = (int) RangesKt.coerceIn((100 * r130) / r131, 0, 100);
        L60:
            Lazy r134 = com.bytedance.ai.applet.base.gson.e.f34515a;
            r127.a("downloadProgressUpdate", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadTaskId", r128), TuplesKt.to("downloadTaskID", r128), TuplesKt.to("progress", Integer.valueOf(r133)), TuplesKt.to("totalBytesWritten", Long.valueOf(r130)), TuplesKt.to("totalBytesExpectedToWrite", Long.valueOf(r131))})));
            goto L4
        L59:
            r133 = 0;
            goto L60
        L53:
            ((c.C0692a) r102).f35664a.cancel();
            goto L4
        L50:
            BuildersKt.launch$default(a.f35643e, null, null, new AppletDownloadFileManager$DownloadTask$executeTransport$1(this, ((c.d) r102).f35668a, null), 3, null);
            goto L4
        L47:
            BuildersKt.launch$default(a.f35643e, null, null, new AppletDownloadFileManager$DownloadTask$startTransport$1(this, this.f35663r, null), 3, null);
            goto L4
        L10:
            a r135 = this.f35663r;
            AppletFileManager r136 = this.f35650e;
            String r137 = this.f35654i;
            Regex r138 = a.f35641c;
            r135.getClass();
            Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L29
            if (r137 != null) goto L14;
        L17:
            boolean r140 = true;
        L18:
            if (r140 == false) goto L20;
            r136.getClass();     // Catch: Throwable -> L29
            com.bytedance.ai.file.a r141 = r136.e(new PolarisFileWrapper(r136.f36579e, "download_" + System.currentTimeMillis() + '_' + UUID.randomUUID()));     // Catch: Throwable -> L29
        L27:
            Object r142 = Result.m9449constructorimpl(r141);     // Catch: Throwable -> L29
        L32:
            if (Result.m9456isSuccessimpl(r142) == false) goto L39;
            com.bytedance.ai.file.a r143 = (com.bytedance.ai.file.a) r142;
            String r144 = this.f35654i;
            if (r144 != null) goto L36;
        L37:
            r103 = true;
        L38:
            d(new d.i(new g(r143, !r103)));
            goto L39
        L36:
            if (StringsKt.isBlank(r144) == false) goto L38;
        L39:
            a r145 = this.f35663r;
            Throwable r146 = Result.m9452exceptionOrNullimpl(r142);
            if (r146 == null) goto L4;
            String r147 = r146.getMessage();
            if (r147 != null) goto L44;
            r147 = "invalid filePath";
        L44:
            d(new d.h(a.e(r145, r147)));
            goto L4
        L20:
            int r148 = com.bytedance.ai.file.a.f36590b;     // Catch: Throwable -> L29
            r141 = com.bytedance.ai.file.a.C0704a.a(r137);     // Catch: Throwable -> L29
            if (r141.c() == true) goto L27;
            if (r141.b() == true) goto L27;
            throw AppletFileError.InvalidUri.INSTANCE;     // Catch: Throwable -> L29
        L14:
            if (StringsKt.isBlank(r137) == true) goto L17;
            r140 = false;
        L29:
            th = move-exception;
            Result.Companion r149 = Result.Companion;
            r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L32
        L7:
            BuildersKt.launch$default(a.f35643e, null, null, new AppletDownloadFileManager$DownloadTask$validateDomain$1(this, this.f35663r, null), 3, null);
            goto L4
        }

        public final List<c> h(d r110) {
            i r100 = this.f35658m;
            i.e r101 = i.e.f35718b;
            if (r100 == r101) goto L5;
        L17:
            i.h r102 = i.h.f35721b;
            if (r100 == r102) goto L20;
        L22:
            c.C0692a r103 = null;
            if (r100 == r102) goto L25;
        L27:
            i.c r104 = i.c.f35715b;
            if (r100 == r104) goto L30;
        L32:
            if (r100 == r104) goto L34;
        L36:
            boolean r105 = r100 instanceof i.f;
            if (r105 == true) goto L39;
        L41:
            i.g r106 = i.g.f35720b;
            if (r100 == r106) goto L44;
        L46:
            boolean r107 = r100 instanceof i.b;
            if (r107 == true) goto L49;
        L53:
            if (r107 == true) goto L55;
        L68:
            if (r107 == true) goto L70;
        L74:
            if (r107 == true) goto L76;
        L85:
            boolean r108 = r100 instanceof i.d;
            if (r108 == true) goto L88;
        L93:
            if (r108 == true) goto L95;
        L99:
            boolean r109 = r100 instanceof i.C0697a;
            if (r109 == true) goto L102;
        L110:
            if (r108 == true) goto L112;
        L114:
            if (r107 == true) goto L116;
        L118:
            if (r109 == false) goto L123;
            if ((r110 instanceof d.c) == false) goto L123;
            this.f35658m = r106;
            return k(((d.c) r110).f35682a, r100.f35710a, new c.C0692a(((i.C0697a) r100).f35712c));
        L123:
            if ((r110 instanceof d.l) == false) goto L126;
            if (r105 == false) goto L126;
            this.f35658m = r106;
            return k(((d.l) r110).f35693a, r100.f35710a, null);
        L126:
            boolean r111 = r110 instanceof d.C0694a;
            if (r111 == false) goto L133;
            if (r100 == r101) goto L132;
            if (r100 == r102) goto L132;
            if (r100 == r104) goto L132;
            if (r105 == false) goto L133;
        L132:
            this.f35658m = r106;
            return j(((d.C0694a) r110).f35680a, r100.f35710a, null);
        L133:
            if (r111 == false) goto L136;
            if (r107 == false) goto L136;
            this.f35658m = r106;
            return j(((d.C0694a) r110).f35680a, r100.f35710a, ((i.b) r100).f35714c);
        L136:
            if (r111 == false) goto L139;
            if (r108 == false) goto L139;
            this.f35658m = r106;
            return j(((d.C0694a) r110).f35680a, r100.f35710a, ((i.d) r100).f35717c);
        L139:
            if (r111 == false) goto L144;
            if (r109 == true) goto L181;
            if (r100 != r106) goto L144;
        L181:
            return CollectionsKt.emptyList();
        L144:
            if (r110 != d.j.f35691a) goto L158;
            if (r100 == r106) goto L158;
            if (r109 == true) goto L158;
            this.f35658m = r106;
            if (r107 == false) goto L150;
            Call<TypedInput> r112 = ((i.b) r100).f35714c;
        L153:
            e r113 = new e("downloadFile:fail timeout", null, null);
            String r114 = r100.f35710a;
            if (r112 == null) goto L182;
            r103 = new c.C0692a(r112);
        L182:
            return k(r113, r114, r103);
        L150:
            if (r108 == false) goto L152;
            r112 = ((i.d) r100).f35717c;
            goto L153
        L152:
            r112 = null;
        L158:
            return CollectionsKt.emptyList();
        L116:
            if ((r110 instanceof d.c) == false) goto L118;
            this.f35658m = r106;
            return k(((d.c) r110).f35682a, r100.f35710a, new c.C0692a(((i.b) r100).f35714c));
        L112:
            if ((r110 instanceof d.c) == false) goto L114;
            this.f35658m = r106;
            return k(((d.c) r110).f35682a, r100.f35710a, new c.C0692a(((i.d) r100).f35717c));
        L102:
            if ((r110 instanceof d.C0695d) == false) goto L110;
            this.f35658m = r106;
            Long r115 = this.f35660o;
            long r116 = 0;
            if (r115 == null) goto L106;
            r116 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r115.longValue(), 0);
        L106:
            ArrayList r117 = new ArrayList();
            d.C0695d r118 = (d.C0695d) r110;
            j r119 = r118.f35683a;
            c.k r120 = i(r119.f35724c, r119.f35725d, true);
            if (r120 == null) goto L109;
            r117.add(r120);
        L109:
            r117.add(new c.e("success statusCode=" + r118.f35683a.f35722a + " bytes=" + r118.f35683a.f35724c + " duration=" + r116));
            r117.add(new c.i(r118.f35683a, r116));
            r117.add(c.h.f35672a);
            r117.add(new c.C0693c(((i.C0697a) r100).f35711b, r118.f35683a));
        L171:
            return r117;
        L95:
            if ((r110 instanceof d.b) == false) goto L99;
            i.d r121 = (i.d) r100;
            Call<TypedInput> r122 = r121.f35717c;
            if (r122 != ((d.b) r110).f35681a) goto L99;
            this.f35658m = new i.C0697a(r121.f35716b, r122);
            return CollectionsKt.listOf(new c.e("commit acquired phase=commit"));
        L88:
            if ((r110 instanceof d.l) == false) goto L93;
            this.f35658m = r106;
            d.l r123 = (d.l) r110;
            e r124 = r123.f35693a;
            String r125 = r100.f35710a;
            Call<TypedInput> r126 = r123.f35694b;
            if (r126 == null) goto L172;
            r103 = new c.C0692a(r126);
        L172:
            return k(r124, r125, r103);
        L76:
            if ((r110 instanceof d.l) == false) goto L85;
            this.f35658m = r106;
            r117 = new ArrayList();
            d.l r127 = (d.l) r110;
            Map<String, String> r128 = r127.f35693a.f35700c;
            if (r128 == null) goto L80;
            r117.add(new c.j(r128));
        L80:
            e r129 = r127.f35693a;
            String r130 = r100.f35710a;
            Call<TypedInput> r131 = r127.f35694b;
            if (r131 == null) goto L83;
            r103 = new c.C0692a(r131);
        L83:
            CollectionsKt.addAll(r117, k(r129, r130, r103));
            goto L171
        L70:
            if ((r110 instanceof d.k) == false) goto L74;
            i.b r132 = (i.b) r100;
            Call<TypedInput> r133 = r132.f35714c;
            if (r133 != ((d.k) r110).f35692a) goto L74;
            this.f35658m = new i.d(r132.f35713b, r133);
            return CollectionsKt.emptyList();
        L55:
            if ((r110 instanceof d.e) == false) goto L68;
            d.e r134 = (d.e) r110;
            long r135 = r134.f35684a;
            if (r135 > 209715200) goto L67;
            long r136 = r134.f35685b;
            if (r136 > 209715200) goto L67;
            c.k r137 = i(r135, r136, false);
            if (r137 == null) goto L64;
            List<c> r138 = CollectionsKt.listOf(r137);
        L65:
            if (r138 == null) goto L168;
            return r138;
        L168:
            return CollectionsKt.emptyList();
        L64:
            r138 = null;
        L67:
            this.f35658m = r106;
            return k(new e("downloadFile:fail size exceeds 200MB", null, null), r100.f35710a, new c.C0692a(((i.b) r100).f35714c));
        L49:
            if ((r110 instanceof d.f) == false) goto L53;
            d.f r139 = (d.f) r110;
            if (((i.b) r100).f35714c != r139.f35686a) goto L53;
            return CollectionsKt.listOf(new c.j(r139.f35687b));
        L44:
            if ((r110 instanceof d.m) == false) goto L46;
            return CollectionsKt.listOf(new c.C0692a(((d.m) r110).f35695a));
        L39:
            if ((r110 instanceof d.m) == false) goto L41;
            d.m r140 = (d.m) r110;
            this.f35658m = new i.b(((i.f) r100).f35719b, r140.f35695a);
            return CollectionsKt.listOf(new c.d(r140.f35695a));
        L34:
            if ((r110 instanceof d.h) == false) goto L36;
            this.f35658m = i.g.f35720b;
            return k(new e(((d.h) r110).f35689a, null, null), r100.f35710a, null);
        L30:
            if ((r110 instanceof d.i) == false) goto L32;
            this.f35658m = new i.f(((d.i) r110).f35690a);
            return CollectionsKt.listOf(new c[]{new c.e("transport start phase=transport host=".concat(g())), c.l.f35678a});
        L25:
            if ((r110 instanceof d.o) == false) goto L27;
            this.f35658m = i.g.f35720b;
            return k(new e(((d.o) r110).f35697a, null, null), r100.f35710a, null);
        L20:
            if (r110 != d.n.f35696a) goto L22;
            this.f35658m = i.c.f35715b;
            return CollectionsKt.listOf(c.g.f35671a);
        L5:
            if (r110 != d.g.f35688a) goto L17;
            this.f35658m = i.h.f35721b;
            c[] r141 = new c[2];
            StringBuilder r142 = new StringBuilder("start phase=validating host=");
            r142.append(g());
            r142.append(" timeoutMs=");
            r142.append(this.f35653h);
            r142.append(" target=");
            String r143 = this.f35654i;
            if (r143 != null) goto L9;
        L12:
            boolean r144 = true;
        L13:
            if (r144 == false) goto L15;
            String r145 = "temporary";
        L16:
            r142.append(r145);
            r141[0] = new c.e(r142.toString());
            r141[1] = c.m.f35679a;
            return CollectionsKt.listOf(r141);
        L15:
            r145 = "explicit";
            goto L16
        L9:
            if (StringsKt.isBlank(r143) == true) goto L12;
            r144 = false;
            goto L13
        }

        public final boolean a(final Call<TypedInput> r100, final Map<String, String> r101) {
            return ((Boolean) this.f35657l.a(new com.bytedance.ai.bridge.method.net.download.g(this, r100, r101))).booleanValue();
        }

        public static List j(String r100, String r101, Call r102) {
            List r103 = CollectionsKt.mutableListOf(new c[]{new c.e("cancel phase=" + r101)});
            if (r102 == null) goto L5;
            r103.add(new c.C0692a(r102));
        L5:
            List r104 = r103;
            r104.add(c.h.f35672a);
            r104.add(new c.b(new e(r100, null, null)));
            return r103;
        }

        public static List k(e r100, String r110, c r111) {
            c[] r101 = new c[1];
            StringBuilder r102 = new StringBuilder("failure phase=");
            r102.append(r110);
            r102.append(" statusCode=");
            Integer r112 = r100.f35699b;
            if (r112 == null) goto L5;
            int r113 = r112.intValue();
        L6:
            r102.append(r113);
            r102.append(" reason=");
            String r103 = r100.f35698a;
            r102.append(StringsKt.take(a.f35641c.replace(StringsKt.replace$default(r103, '\n', ' ', false, 4, null), "<url>"), 256));
            r101[0] = new c.f(r102.toString());
            List r114 = CollectionsKt.mutableListOf(r101);
            if (r111 == null) goto L9;
            r114.add(r111);
        L9:
            List r115 = r114;
            r115.add(c.h.f35672a);
            r115.add(new c.b(r100));
            return r114;
        L5:
            r113 = -1;
            goto L6
        }

        public final void e(Call<TypedInput> r100, boolean r101, e r102) {
            if (r101 == false) goto L4;
            d(new d.c(r102));
            return;
        L4:
            d(new d.l(r102, r100));
        }

        public final c.k i(long r100, long r101, boolean r110) {
            Long r102 = this.f35659n;
            if (r102 != null) goto L5;
        L7:
            if (r102 == null) goto L9;
            long r103 = r102.longValue();
        L10:
            long r104 = r100 - r103;
            if (r110 == false) goto L13;
        L15:
            this.f35659n = Long.valueOf(r100);
            return new c.k(r100, r101);
        L13:
            if (r104 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) goto L15;
            return null;
        L9:
            r103 = 0;
            goto L10
        L5:
            if (r100 > r102.longValue()) goto L7;
            return null;
        }

        public b(a r100, String r101, f r102, String r103, e3.d r104, AppletFileManager r105, String r106, Map<String, String> r107, long r110, String r111, IHostNetworkDepend r112, f3.h<AbsDownloadFileMethodIDL.b> r113) {
            Intrinsics.checkNotNullParameter(r101, "downloadTaskId");
            Intrinsics.checkNotNullParameter(r102, "ownerKey");
            Intrinsics.checkNotNullParameter(r103, "containerType");
            Intrinsics.checkNotNullParameter(r104, "bridgeContext");
            Intrinsics.checkNotNullParameter(r105, "fileManager");
            Intrinsics.checkNotNullParameter(r106, "url");
            Intrinsics.checkNotNullParameter(r107, "headers");
            Intrinsics.checkNotNullParameter(r112, "hostNetworkDepend");
            Intrinsics.checkNotNullParameter(r113, "callback");
            this.f35663r = r100;
            this.f35646a = r101;
            this.f35647b = r102;
            this.f35648c = r103;
            this.f35649d = r104;
            this.f35650e = r105;
            this.f35651f = r106;
            this.f35652g = r107;
            this.f35653h = r110;
            this.f35654i = r111;
            this.f35655j = r112;
            this.f35656k = r113;
            this.f35657l = new h(a.f35642d);
            this.f35658m = i.e.f35718b;
            this.f35662q = "[AppletDownload] applet=" + r102.f35702a + " containerType=" + r103 + " task=" + r101;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$c$a, reason: collision with other inner class name */
        public static final class C0692a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35664a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0692a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35664a, ((C0692a) r100).f35664a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35664a.hashCode();
            }

            public final String toString() {
                return "CancelTransport(call=" + this.f35664a + ')';
            }

            public C0692a(Call<TypedInput> r100) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                this.f35664a = r100;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f35665a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35665a, ((b) r100).f35665a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35665a.hashCode();
            }

            public final String toString() {
                return "CompleteFailure(failure=" + this.f35665a + ')';
            }

            public b(e r100) {
                Intrinsics.checkNotNullParameter(r100, "failure");
                this.f35665a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$c$c, reason: collision with other inner class name */
        public static final class C0693c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final g f35666a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final j f35667b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0693c) == true) goto L8;
                return false;
            L8:
                C0693c r101 = (C0693c) r100;
                if (Intrinsics.areEqual(this.f35666a, r101.f35666a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35667b, r101.f35667b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f35666a.hashCode() * 31) + this.f35667b.hashCode();
            }

            public final String toString() {
                return "CompleteSuccess(target=" + this.f35666a + ", result=" + this.f35667b + ')';
            }

            public C0693c(g r100, j r101) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                Intrinsics.checkNotNullParameter(r101, "result");
                this.f35666a = r100;
                this.f35667b = r101;
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35668a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35668a, ((d) r100).f35668a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35668a.hashCode();
            }

            public final String toString() {
                return "ExecuteTransport(call=" + this.f35668a + ')';
            }

            public d(Call<TypedInput> r100) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                this.f35668a = r100;
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f35669a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35669a, ((e) r100).f35669a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35669a.hashCode();
            }

            public final String toString() {
                return "LogInfo(message=" + this.f35669a + ')';
            }

            public e(String r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                this.f35669a = r100;
            }
        }

        public static final class f extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f35670a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35670a, ((f) r100).f35670a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35670a.hashCode();
            }

            public final String toString() {
                return "LogWarning(message=" + this.f35670a + ')';
            }

            public f(String r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                this.f35670a = r100;
            }
        }

        public static final class g extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f35671a = null;

            static {
                f35671a = new g();
            }

            public g() {
            }
        }

        public static final class h extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final h f35672a = null;

            static {
                f35672a = new h();
            }

            public h() {
            }
        }

        public static final class i extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final j f35673a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f35674b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof i) == true) goto L8;
                return false;
            L8:
                i r101 = (i) r100;
                if (Intrinsics.areEqual(this.f35673a, r101.f35673a) == true) goto L12;
                return false;
            L12:
                if (this.f35674b == r101.f35674b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f35673a.hashCode() * 31;
                long r101 = this.f35674b;
                return r100 + ((int) (r101 ^ (r101 >>> 32)));
            }

            public final String toString() {
                return "ReportSuccess(result=" + this.f35673a + ", duration=" + this.f35674b + ')';
            }

            public i(j r100, long r101) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f35673a = r100;
                this.f35674b = r101;
            }
        }

        public static final class j extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Map<String, String> f35675a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof j) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35675a, ((j) r100).f35675a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35675a.hashCode();
            }

            public final String toString() {
                return "SendHeaders(headers=" + this.f35675a + ')';
            }

            public j(Map<String, String> r100) {
                Intrinsics.checkNotNullParameter(r100, "headers");
                this.f35675a = r100;
            }
        }

        public static final class k extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f35676a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f35677b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof k) == true) goto L8;
                return false;
            L8:
                k r101 = (k) r100;
                if (this.f35676a == r101.f35676a) goto L12;
                return false;
            L12:
                if (this.f35677b == r101.f35677b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f35676a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f35677b;
                return r101 + ((int) (r102 ^ (r102 >>> 32)));
            }

            public final String toString() {
                return "SendProgress(written=" + this.f35676a + ", total=" + this.f35677b + ')';
            }

            public k(long r100, long r101) {
                this.f35676a = r100;
                this.f35677b = r101;
            }
        }

        public static final class l extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final l f35678a = null;

            static {
                f35678a = new l();
            }

            public l() {
            }
        }

        public static final class m extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final m f35679a = null;

            static {
                f35679a = new m();
            }

            public m() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$d$a, reason: collision with other inner class name */
        public static final class C0694a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f35680a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0694a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35680a, ((C0694a) r100).f35680a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35680a.hashCode();
            }

            public final String toString() {
                return "Cancel(message=" + this.f35680a + ')';
            }

            public C0694a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                this.f35680a = r100;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35681a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35681a, ((b) r100).f35681a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35681a.hashCode();
            }

            public final String toString() {
                return "CommitRequested(call=" + this.f35681a + ')';
            }

            public b(Call<TypedInput> r100) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                this.f35681a = r100;
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f35682a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35682a, ((c) r100).f35682a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35682a.hashCode();
            }

            public final String toString() {
                return "FileMoveFailed(failure=" + this.f35682a + ')';
            }

            public c(e r100) {
                Intrinsics.checkNotNullParameter(r100, "failure");
                this.f35682a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$d$d, reason: collision with other inner class name */
        public static final class C0695d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final j f35683a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0695d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35683a, ((C0695d) r100).f35683a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35683a.hashCode();
            }

            public final String toString() {
                return "FileMoveSucceeded(result=" + this.f35683a + ')';
            }

            public C0695d(j r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f35683a = r100;
            }
        }

        public static final class e extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f35684a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f35685b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L8;
                return false;
            L8:
                e r101 = (e) r100;
                if (this.f35684a == r101.f35684a) goto L12;
                return false;
            L12:
                if (this.f35685b == r101.f35685b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f35684a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f35685b;
                return r101 + ((int) (r102 ^ (r102 >>> 32)));
            }

            public final String toString() {
                return "Progress(written=" + this.f35684a + ", total=" + this.f35685b + ')';
            }

            public e(long r100, long r101) {
                this.f35684a = r100;
                this.f35685b = r101;
            }
        }

        public static final class f extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35686a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Map<String, String> f35687b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L8;
                return false;
            L8:
                f r101 = (f) r100;
                if (Intrinsics.areEqual(this.f35686a, r101.f35686a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35687b, r101.f35687b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f35686a.hashCode() * 31) + this.f35687b.hashCode();
            }

            public final String toString() {
                return "ResponseAccepted(call=" + this.f35686a + ", headers=" + this.f35687b + ')';
            }

            public f(Call<TypedInput> r100, Map<String, String> r101) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(r101, "headers");
                this.f35686a = r100;
                this.f35687b = r101;
            }
        }

        public static final class g extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f35688a = null;

            static {
                f35688a = new g();
            }

            public g() {
            }
        }

        public static final class h extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f35689a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof h) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35689a, ((h) r100).f35689a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35689a.hashCode();
            }

            public final String toString() {
                return "TargetPreparationFailed(message=" + this.f35689a + ')';
            }

            public h(String r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                this.f35689a = r100;
            }
        }

        public static final class i extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final g f35690a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof i) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35690a, ((i) r100).f35690a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35690a.hashCode();
            }

            public final String toString() {
                return "TargetPrepared(target=" + this.f35690a + ')';
            }

            public i(g r100) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                this.f35690a = r100;
            }
        }

        public static final class j extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final j f35691a = null;

            static {
                f35691a = new j();
            }

            public j() {
            }
        }

        public static final class k extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35692a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof k) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35692a, ((k) r100).f35692a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35692a.hashCode();
            }

            public final String toString() {
                return "TransportCompleted(call=" + this.f35692a + ')';
            }

            public k(Call<TypedInput> r100) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                this.f35692a = r100;
            }
        }

        public static final class l extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f35693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Call<TypedInput> f35694b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof l) == true) goto L8;
                return false;
            L8:
                l r101 = (l) r100;
                if (Intrinsics.areEqual(this.f35693a, r101.f35693a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35694b, r101.f35694b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f35693a.hashCode() * 31;
                Call<TypedInput> r101 = this.f35694b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "TransportFailed(failure=" + this.f35693a + ", call=" + this.f35694b + ')';
            }

            public l(e r100, Call<TypedInput> r101) {
                Intrinsics.checkNotNullParameter(r100, "failure");
                this.f35693a = r100;
                this.f35694b = r101;
            }
        }

        public static final class m extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Call<TypedInput> f35695a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof m) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35695a, ((m) r100).f35695a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35695a.hashCode();
            }

            public final String toString() {
                return "TransportStarted(call=" + this.f35695a + ')';
            }

            public m(Call<TypedInput> r100) {
                Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
                this.f35695a = r100;
            }
        }

        public static final class n extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final n f35696a = null;

            static {
                f35696a = new n();
            }

            public n() {
            }
        }

        public static final class o extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f35697a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof o) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35697a, ((o) r100).f35697a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35697a.hashCode();
            }

            public final String toString() {
                return "WhitelistRejected(message=" + this.f35697a + ')';
            }

            public o(String r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                this.f35697a = r100;
            }
        }

        public d() {
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f35699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f35700c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f35698a, r101.f35698a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35699b, r101.f35699b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f35700c, r101.f35700c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f35698a.hashCode() * 31;
            Integer r101 = this.f35699b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Map<String, String> r105 = this.f35700c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Failure(message=" + this.f35698a + ", statusCode=" + this.f35699b + ", headers=" + this.f35700c + ')';
        }

        public e(String r100, Integer r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f35698a = r100;
            this.f35699b = r101;
            this.f35700c = r102;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f35701c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f35703b;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$f$a, reason: collision with other inner class name */
        public static final class C0696a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f35702a, r101.f35702a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35703b, r101.f35703b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f35702a.hashCode() * 31) + this.f35703b.hashCode();
        }

        public final String toString() {
            return "OwnerKey(appletId=" + this.f35702a + ", containerId=" + this.f35703b + ')';
        }

        public f(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r101, "containerId");
            this.f35702a = r100;
            this.f35703b = r101;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ai.file.a f35704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f35705b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f35704a, r101.f35704a) == true) goto L12;
            return false;
        L12:
            if (this.f35705b == r101.f35705b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f35704a.hashCode() * 31;
            if (this.f35705b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "PreparedTarget(file=" + this.f35704a + ", isExplicit=" + this.f35705b + ')';
        }

        public g(com.bytedance.ai.file.a r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "file");
            this.f35704a = r100;
            this.f35705b = r101;
        }
    }

    public static final class h implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f35706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayDeque<Runnable> f35707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ThreadLocal<Boolean> f35708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f35709d;

        public final void b() {
            ArrayDeque<Runnable> r100 = this.f35707b;
            monitor-enter(r100);
            Runnable r101 = this.f35707b.pollFirst();     // Catch: Throwable -> L10
            this.f35709d = r101;     // Catch: Throwable -> L10
            if (r101 == null) goto L7;
            this.f35706a.execute(r101);     // Catch: Throwable -> L10
        L7:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r100);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public h(Executor r100) {
            Intrinsics.checkNotNullParameter(r100, "executor");
            this.f35706a = r100;
            this.f35707b = new ArrayDeque();
            this.f35708c = new ThreadLocal();
        }

        public final <T> T a(final Function0<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            if (Intrinsics.areEqual(this.f35708c.get(), Boolean.TRUE) == true) goto L5;
            FutureTask r101 = new FutureTask(new m(r100));
            execute(r101);
            return (T) r101.get();
        L5:
            return r100.invoke();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(final Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "command");
            ArrayDeque<Runnable> r101 = this.f35707b;
            monitor-enter(r101);
            this.f35707b.addLast(new l(this, r100));     // Catch: Throwable -> L12
            if (this.f35709d != null) goto L9;
            Runnable r102 = this.f35707b.pollFirst();     // Catch: Throwable -> L12
            this.f35709d = r102;     // Catch: Throwable -> L12
            if (r102 == null) goto L9;
            this.f35706a.execute(r102);     // Catch: Throwable -> L12
        L9:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r101);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35710a;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$i$a, reason: collision with other inner class name */
        public static final class C0697a extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final g f35711b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Call<TypedInput> f35712c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0697a) == true) goto L8;
                return false;
            L8:
                C0697a r101 = (C0697a) r100;
                if (Intrinsics.areEqual(this.f35711b, r101.f35711b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35712c, r101.f35712c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f35711b.hashCode() * 31) + this.f35712c.hashCode();
            }

            public final String toString() {
                return "Committing(target=" + this.f35711b + ", call=" + this.f35712c + ')';
            }

            public C0697a(g r100, Call<TypedInput> r101) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_CALL);
                super("committing");
                this.f35711b = r100;
                this.f35712c = r101;
            }
        }

        public static final class b extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final g f35713b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Call<TypedInput> f35714c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f35713b, r101.f35713b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35714c, r101.f35714c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f35713b.hashCode() * 31) + this.f35714c.hashCode();
            }

            public final String toString() {
                return "Downloading(target=" + this.f35713b + ", call=" + this.f35714c + ')';
            }

            public b(g r100, Call<TypedInput> r101) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_CALL);
                super("downloading");
                this.f35713b = r100;
                this.f35714c = r101;
            }
        }

        public static final class c extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f35715b = null;

            static {
                f35715b = new c();
            }

            public c() {
                super("preparing");
            }
        }

        public static final class d extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final g f35716b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Call<TypedInput> f35717c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L8;
                return false;
            L8:
                d r101 = (d) r100;
                if (Intrinsics.areEqual(this.f35716b, r101.f35716b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f35717c, r101.f35717c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f35716b.hashCode() * 31) + this.f35717c.hashCode();
            }

            public final String toString() {
                return "ProcessingResult(target=" + this.f35716b + ", call=" + this.f35717c + ')';
            }

            public d(g r100, Call<TypedInput> r101) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_CALL);
                super("processingResult");
                this.f35716b = r100;
                this.f35717c = r101;
            }
        }

        public static final class e extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f35718b = null;

            static {
                f35718b = new e();
            }

            public e() {
                super("registered");
            }
        }

        public static final class f extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final g f35719b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f35719b, ((f) r100).f35719b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f35719b.hashCode();
            }

            public final String toString() {
                return "Starting(target=" + this.f35719b + ')';
            }

            public f(g r100) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                super("starting");
                this.f35719b = r100;
            }
        }

        public static final class g extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g f35720b = null;

            static {
                f35720b = new g();
            }

            public g() {
                super("terminal");
            }
        }

        public static final class h extends i {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final h f35721b = null;

            static {
                f35721b = new h();
            }

            public h() {
                super("validating");
            }
        }

        public i(String r100) {
            this.f35710a = r100;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f35723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f35724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f35725d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f35722a == r101.f35722a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35723b, r101.f35723b) == true) goto L15;
            return false;
        L15:
            if (this.f35724c == r101.f35724c) goto L18;
            return false;
        L18:
            if (this.f35725d == r101.f35725d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f35722a * 31) + this.f35723b.hashCode()) * 31;
            long r101 = this.f35724c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f35725d;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "SuccessResult(statusCode=" + this.f35722a + ", headers=" + this.f35723b + ", downloadedBytes=" + this.f35724c + ", expectedBytes=" + this.f35725d + ')';
        }

        public j(int r100, Map<String, String> r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r101, "headers");
            this.f35722a = r100;
            this.f35723b = r101;
            this.f35724c = r102;
            this.f35725d = r103;
        }
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    static {
        f35641c = new Regex("https?://\\S+", RegexOption.IGNORE_CASE);
        f35642d = TTExecutors.getNormalExecutor();
        f35643e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        Object r100 = this.f35644a;
        monitor-enter(r100);
        Collection r101 = ((LinkedHashMap) this.f35645b).values();     // Catch: Throwable -> L15
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L8;
        CollectionsKt.addAll(r102, ((Map) r103.next()).values());     // Catch: Throwable -> L15
        goto L6
    L8:
        ((LinkedHashMap) this.f35645b).clear();     // Catch: Throwable -> L15
        monitor-exit(r100);
        Iterator r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((b) r104.next()).b();
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f35644a = new Object();
        this.f35645b = new LinkedHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final void i(e3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        int r101 = f.f35701c;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        a0 r102 = r100.getContainerContext();
        List r103 = null;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r102, "containerContext");
        String r104 = r102.getAppletId();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        f r105 = new f(r104, r102.getContainerId());
    L9:
        if (r105 != null) goto L11;
        return;
    L11:
        Object r106 = this.f35644a;
        monitor-enter(r106);
        Map<String, b> r107 = this.f35645b.remove(r105);     // Catch: Throwable -> L26
        if (r107 == null) goto L18;
        Collection<b> r108 = r107.values();     // Catch: Throwable -> L26
        if (r108 == null) goto L18;
        r103 = CollectionsKt.toList(r108);     // Catch: Throwable -> L26
    L18:
        if (r103 != null) goto L20;
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
    L20:
        monitor-exit(r106);
        Iterator r109 = r103.iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        ((b) r109.next()).b();
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    L8:
        r105 = null;
        goto L9
    }

    public static final long c(a r100, Map r101) {
        r100.getClass();
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals((String) ((Map.Entry) r103).getKey(), "content-length", true) == false) goto L4;
    L9:
        Map.Entry r104 = (Map.Entry) r103;
        if (r104 == null) goto L16;
        String r105 = (String) r104.getValue();
        if (r105 == null) goto L16;
        Long r106 = StringsKt.toLongOrNull(r105);
        if (r106 == null) goto L16;
        return r106.longValue();
    L16:
        return -1;
    L8:
        r103 = null;
        goto L9
    }

    public static final String e(a r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L9:
        r101 = "downloadFile failed";
    L11:
        if (StringsKt.startsWith$default(r101, "downloadFile:fail", false, 2, null) == false) goto L14;
        return r101;
    L14:
        return "downloadFile:fail ".concat(r101);
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L11;
        goto L9
    }

    public static void j(String r100, String r101, String r102, String r103) {
        com.bytedance.ai.utils.g.f37637a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r100 + " containerType=" + r101 + " task=" + r102 + " reason=" + r103);
    }

    public static final Call b(a r100, String r110, Map r111, long r112, IHostNetworkDepend r113) {
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        android.util.Pair<String, String> r102 = UrlUtils.parseUrl(new UrlBuilder(r110).build(), r101);
        String r114 = (String) r102.first;
        String r103 = (String) r102.second;
        RequestContext r104 = new RequestContext();
        r104.timeout_connect = r112;
        r104.timeout_read = r112;
        r104.timeout_write = r112;
        r104.force_handle_response = true;
        r104.followRedirectInternal = false;
        Boolean r105 = Boolean.FALSE;
        Map<String, ? extends Object> r115 = MapsKt.mapOf(new Pair[]{TuplesKt.to("isCustomizedCookie", r105), TuplesKt.to("needAddCommonParams", r105)});
        Intrinsics.checkNotNull(r114);
        IAppletRetrofit r116 = r113.createRetrofit(r114, false, r115);
        if (r116 == null) goto L31;
        IHostNetworkRuntimeApi r106 = (IHostNetworkRuntimeApi) r116.create(IHostNetworkRuntimeApi.class);
        if (r106 == null) goto L32;
        ArrayList r107 = new ArrayList();
        Iterator r117 = r111.entrySet().iterator();
    L8:
        if (r117.hasNext() == false) goto L25;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r119 = (String) r118.getKey();
        String r120 = (String) r118.getValue();
        String r121 = StringsKt.trim(r119).toString();
        String r108 = r121.toLowerCase(Locale.ROOT);
        if ((!StringsKt.isBlank(r121)) == true) goto L12;
    L21:
        Header r109 = null;
    L22:
        if (r109 == null) goto L8;
        r107.add(r109);
        goto L8
    L12:
        if (r120.length() <= 0) goto L14;
        boolean r122 = true;
    L15:
        if (r122 == false) goto L21;
        if (Intrinsics.areEqual(r108, AppConstants.BUNDLE_REFERER) == true) goto L21;
        if (Intrinsics.areEqual(r108, "user-agent") == true) goto L21;
        r109 = new Header(r121, r120);
        goto L22
    L14:
        r122 = false;
        goto L15
    L25:
        return r106.streamGet(false, -1, r103, r101, r107, r104);
    L32:
        return null;
    L31:
        return null;
    }

    public final String f(e3.d r210, String r211, Map<String, ? extends Object> r212, Long r213, String r214, String r215, f3.h<AbsDownloadFileMethodIDL.b> r310) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r211, "url");
        Intrinsics.checkNotNullParameter(r215, "downloadTaskId");
        Intrinsics.checkNotNullParameter(r310, "callback");
        a0 r100 = r210.getContainerContext();
        if (r100 != null) goto L6;
        j("unknown", "unknown", r215, "bridge context is unavailable");
        return "downloadFile:fail bridge context is unavailable";
    L6:
        int r101 = f.f35701c;
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        String r102 = r100.getAppletId();
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        f r110 = new f(r102, r100.getContainerId());
        String r111 = r100.getContainerType().getTypeName();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(new URI(r211));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = null;
    L17:
        URI r105 = (URI) r104;
        if (r105 == null) goto L22;
        String r106 = r105.getScheme();
        if (r106 == null) goto L22;
        String r107 = r106.toLowerCase(Locale.ROOT);
    L24:
        if (Intrinsics.areEqual(r107, "https") == true) goto L27;
        j(r110.f35702a, r111, r215, "url is invalid");
        return "downloadFile:fail url is invalid";
    L27:
        String r108 = r110.f35702a;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r109 = AppletAppManagerService.b(r108);
        if (r109 == null) goto L30;
        AppletFileManager r112 = r109.J();
    L31:
        if (r112 != null) goto L34;
        j(r110.f35702a, r111, r215, "file manager is unavailable");
        return "downloadFile:fail file manager is unavailable";
    L34:
        if (r212 != null) goto L36;
        Map<String, ? extends Object> r113 = MapsKt.emptyMap();
    L37:
        ArrayList r114 = new ArrayList();
        Iterator<Map.Entry<String, ? extends Object>> r115 = r113.entrySet().iterator();
    L38:
        boolean r116 = false;
        if (r115.hasNext() == false) goto L70;
        Map.Entry<String, ? extends Object> r117 = r115.next();
        String r118 = r117.getKey();
        Object r119 = r117.getValue();
        String r120 = StringsKt.trim(r118).toString();
        if (r119 != null) goto L44;
        String r121 = "";
    L60:
        if (StringsKt.isBlank(r120) == false) goto L62;
    L67:
        Pair r122 = null;
    L68:
        if (r122 == null) goto L38;
        r114.add(r122);
        goto L38
    L62:
        if (r121.length() != 0) goto L64;
        r116 = true;
    L64:
        if (r116 == true) goto L67;
        r122 = TuplesKt.to(r120, r121);
        goto L68
    L44:
        if ((r119 instanceof String) == false) goto L47;
        r121 = (String) r119;
        goto L60
    L47:
        if ((r119 instanceof Number) == false) goto L49;
    L58:
        r121 = r119.toString();
        goto L60
    L49:
        if ((r119 instanceof Boolean) == true) goto L58;
        if ((r119 instanceof Map) == false) goto L55;
        r121 = new JSONObject((Map) r119).toString();
        goto L60
    L55:
        if ((r119 instanceof List) == false) goto L57;
        r121 = new JSONArray((Collection) r119).toString();
        goto L60
    L57:
        r121 = r119.toString();
        goto L60
    L70:
        Map r123 = MapsKt.toMap(r114);
        if (r213 != null) goto L73;
    L81:
        long r124 = 60000;
    L82:
        long r125 = r124;
        IHostNetworkDepend r126 = r4.a.f535976c;
        if (r126 != null) goto L85;
        r126 = new b4.a();
    L85:
        b r127 = new b(this, r215, r110, r111, r210, r112, r211, r123, r125, r214, r126, r310);
        Object r128 = this.f35644a;
        monitor-enter(r128);
        Map r129 = (Map) ((LinkedHashMap) this.f35645b).get(r110);     // Catch: Throwable -> L115
        if (r129 == null) goto L92;
        String r130 = r215;
        if (r129.containsKey(r130) != true) goto L93;
        boolean r131 = true;
    L94:
        if (r131 == false) goto L99;
        com.bytedance.ai.utils.g.f37637a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r110.f35702a + " containerType=" + r111 + " task=" + r130 + " reason=duplicate");     // Catch: Throwable -> L115
        monitor-exit(r128);
        return "downloadFile:fail downloadTaskId already exists";
    L99:
        Iterator r132 = ((LinkedHashMap) this.f35645b).values().iterator();     // Catch: Throwable -> L115
        int r133 = 0;
    L101:
        if (r132.hasNext() == false) goto L104;
        r133 = r133 + ((Map) r132.next()).size();     // Catch: Throwable -> L115
        goto L101
    L104:
        if (r133 < 10) goto L108;
        com.bytedance.ai.utils.g.f37637a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r110.f35702a + " containerType=" + r111 + " task=" + r130 + " reason=task_limit limit=10");     // Catch: Throwable -> L115
        monitor-exit(r128);
        return "downloadFile:fail exceed max download connection count 10";
    L108:
        LinkedHashMap r134 = (LinkedHashMap) this.f35645b;     // Catch: Throwable -> L115
        Object r135 = r134.get(r110);     // Catch: Throwable -> L115
        if (r135 != null) goto L111;
        r135 = new LinkedHashMap();     // Catch: Throwable -> L115
        r134.put(r110, r135);     // Catch: Throwable -> L115
    L111:
        ((Map) r135).put(r130, r127);     // Catch: Throwable -> L115
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L115
        monitor-exit(r128);
        long r137 = SystemClock.elapsedRealtime();
        r127.f35660o = Long.valueOf(r137);
        r127.f35661p = BuildersKt.launch$default(f35643e, null, null, new AppletDownloadFileManager$DownloadTask$start$1(r137 + r127.f35653h, r127, null), 3, null);
        r127.d(d.g.f35688a);
        return null;
    L93:
        r131 = false;
        goto L94
    L92:
        r130 = r215;
    L115:
        th = move-exception;
        throw th;
    L73:
        if (r213.longValue() <= 0) goto L75;
        boolean r138 = true;
    L76:
        if (r138 == false) goto L78;
        Long r139 = r213;
    L79:
        if (r139 == null) goto L81;
        r124 = RangesKt.coerceAtMost(r139.longValue(), 300000);
        goto L82
    L78:
        r139 = null;
        goto L79
    L75:
        r138 = false;
        goto L76
    L36:
        r113 = r212;
        goto L37
    L30:
        r112 = null;
    L22:
        r107 = null;
    L12:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
