package com.obric.aiagent.skill.manager.impl;

import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.keva.KevaImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.ttnet.ITTNetFileTransfer;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fe implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f19871b;

    /* JADX INFO: compiled from: SkillShopApiClient.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillShopApiClient.kt */
    @d.c.b.a.f(b = "SkillShopApiClient.kt", c = {435, 445, 450}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillShopApiClient$executeJsonRequest$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f19875d;

        b(String r3, String r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19873b = r3;
            this.f19874c = r4;
            this.f19875d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f19873b, this.f19874c, this.f19875d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f19872a;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L12;
            if (r2 == 2) goto L11;
            if (r2 != 3) goto L10;
            d.o.a(r15);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L38:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r14 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L40:
            if (r14.a() == false) goto L47;
            String r16 = (String) ZeusTransformUtils.preCheckCast(r14.c(), String.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r16 == null) goto L45;
            return r16;
        L45:
            throw new fp(fq.f19910c, null, 2, null);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L47:
            throw new fp(fq.f19909b, null, 2, null);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r15);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L29:
            r14 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            goto L40
        L12:
            d.o.a(r15);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L22:
            com.obric.autogui.tools.api.net.a r8 = com.obric.autogui.tools.a.a.f31480a.a();     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r8 == null) goto L51;
            Map<String, String> r17 = d.a.ao.a(new d.m[]{d.s.a("Accept", "application/json"), d.s.a("X-Tenant-Key", "omni")});     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            String r3 = this.f19873b;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (d.h.b.o.a(r3, "GET") == false) goto L31;
            String r0 = this.f19874c;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            this.f19872a = 2;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            r15 = r8.a(r0, r17, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r4);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r15 != r1) goto L29;
            return r1;
        L31:
            if (d.h.b.o.a(r3, "POST") == false) goto L49;
            String r5 = this.f19874c;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            Map<String, String> r10 = d.a.ao.a(r17, d.a.ao.a(new d.m[]{d.s.a(DownloadHelper.CONTENT_TYPE, "application/json"), d.s.a("X-Tt-Trace", "1")}));     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            String r18 = this.f19875d;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r18 != null) goto L35;
            r18 = "";
        L35:
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            this.f19872a = 3;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            r15 = r8.a(r5, r10, r18, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r13);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r15 != r1) goto L38;
            return r1;
        L49:
            throw new IllegalArgumentException("Unsupported SkillShop http method: " + this.f19873b);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L51:
            throw new fp(fq.f19908a, null, 2, null);     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
        L18:
            d.o.a(r15);
            AutoActionFoundation r19 = AutoActionFoundation.INSTANCE;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            this.f19872a = 1;     // Catch: fp -> L14 CancellationException -> L16 Exception -> L52
            if (r19.suspendUntilReady(r6) != r1) goto L22;
            return r1;
        L14:
            e = move-exception;
            throw e;
        L16:
            e = move-exception;
            throw e;
        L53:
            throw new fp(fq.f19909b, null, 2, null);
        }
    }

    static {
        f19870a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$tijS0iq6ocRxxt96den9O-9Pn38, reason: not valid java name */
    public static /* synthetic */ CharSequence m284lambda$tijS0iq6ocRxxt96den9O9Pn38(fe r0, Map.Entry r1) {
        return a(r0, r1);
    }

    public fe() {
        this.f19871b = new Gson();
    }

    public final Collection<String> a() {
        fv<?> r0 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/skill-existence-policy", d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getDisallowedSkillSlugs$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r0, "GetSkillExistencePolicy");
        bm r4 = (bm) ZeusTransformUtils.preCheckCast(r0.c(), bm.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        List<String> r5 = r4.a();
    L6:
        if (r5 != null) goto L9;
        r5 = d.a.p.b();
    L9:
        return (Collection) ZeusTransformUtils.preCheckCast(d.a.p.k((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
    L5:
        r5 = null;
        goto L6
    }

    public final List<fi> b() {
        fv<?> r0 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/categories", d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getCategories$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r0, "GetCategories");
        List<fi> r4 = (List) ZeusTransformUtils.preCheckCast(r0.c(), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        return r4;
    L5:
        return d.a.p.b();
    }

    public final List<fh> c() {
        fv<?> r0 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/banners", d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getBanners$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r0, "GetBanners");
        fg r4 = (fg) ZeusTransformUtils.preCheckCast(r0.c(), fg.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        List<fh> r5 = r4.a();
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return d.a.p.b();
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ fr a(fe r9, String r10, String r11, Boolean r12, Boolean r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        Boolean r5 = null;
    L11:
        if ((r16 & 8) == 0) goto L13;
        Boolean r6 = null;
    L15:
        return r9.a(r10, r4, r5, r6, r14, r15);
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }

    public final fr a(String r8, String r9, Boolean r10, Boolean r11, int r12, int r13) {
        boolean r0 = false;
        if (r12 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L36;
        if (r13 <= 0) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L34;
        Map r1 = d.a.ao.a();
        r1.put("page", String.valueOf(r12));
        r1.put("pageSize", String.valueOf(r13));
        if (r8 != null) goto L13;
    L18:
        if (r9 != null) goto L20;
    L25:
        if (r10 == null) goto L27;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r1.put("isFeatured", String.valueOf(r10.booleanValue())), String.class, "com.obric.aiagent.plugin");
    L27:
        if (r11 == null) goto L29;
        r1.put("isBuiltin", String.valueOf(r11.booleanValue()));
    L29:
        d.x r15 = d.x.f38692a;
        fv<?> r16 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/skills", d.a.ao.a(r1), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getSkills$response$2(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r16, "GetSkills");
        fr r7 = (fr) ZeusTransformUtils.preCheckCast(r16.c(), fr.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L32;
        return r7;
    L32:
        return new fr(null, 0, r12, r13, 3, null);
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r9 = null;
    L23:
        if (r9 == null) goto L25;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r1.put("keyword", r9), String.class, "com.obric.aiagent.plugin");
        goto L25
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L18;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r1.put("categoryId", r8), String.class, "com.obric.aiagent.plugin");
        goto L18
    L34:
        throw new IllegalArgumentException("Skill shop page size must be positive.".toString());
    L36:
        throw new IllegalArgumentException("Skill shop page must be positive.".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final fm a(String r5) {
        d.h.b.o.e(r5, "slug");
        fv<?> r6 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/skills/" + g(r5), d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getSkillDetail$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        if (r6.a() != 40400) goto L5;
        return null;
    L5:
        a(r6, "GetSkillDetail");
        fm r4 = (fm) ZeusTransformUtils.preCheckCast(r6.c(), fm.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        return r4;
    L9:
        throw new fp(fq.f19910c, null, 2, null);
    }

    public final fk b(String r5) {
        d.h.b.o.e(r5, "slug");
        fv<?> r6 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/collections/" + g(r5), d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getCollectionDetail$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r6, "GetCollectionDetail");
        return (fk) ZeusTransformUtils.preCheckCast(r6.c(), fk.class, "com.obric.aiagent.plugin");
    }

    public final ap a(String r6, int r7, File r8) {
        d.h.b.o.e(r6, "slug");
        d.h.b.o.e(r8, "destination");
        String r9 = "/assistant/skills_store/api/v1/skills/" + g(r6) + "/download";
        Map r0 = d.a.ao.a();
        r0.put(DBHelper.BATTERY_COL_SOURCE, "doubao");
        r0.put("version", Integer.valueOf(r7));
        d.x r1 = d.x.f38692a;
        fv<?> r10 = (fv) ZeusTransformUtils.preCheckCast(b(r9, d.a.ao.a(r0), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$downloadSkillZip$response$2(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        a(r10, "DownloadSkill");
        fn r11 = (fn) ZeusTransformUtils.preCheckCast(r10.c(), fn.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        int r12 = hj.f20114a.a(r7, r11.b());     // Catch: IllegalArgumentException -> L16
        String r13 = r11.a();
        if (r13 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L15;
        return new ap(r12, a(r13, r8, "application/zip,*/*", "Skill package download").b());
    L15:
        throw new fp(fq.f19910c, null, 2, null);
    L16:
        e = move-exception;
        throw new fp(fq.f19910c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L20:
        throw new fp(fq.f19910c, null, 2, null);
    }

    public final f c(String r10) {
        d.h.b.o.e(r10, "name");
        fv<?> r0 = (fv) ZeusTransformUtils.preCheckCast(a("/assistant/skills_store/api/v1/cli-binaries/" + g(r10) + "/versions/latest/download", d.a.ao.b(), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getLatestCliBinaryDownload$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (IAppContext.Companion.isDebug() == false) goto L8;
        StringBuilder r1 = new StringBuilder().append("CLI latest api response: name=").append(h(r10)).append(", code=").append(r0.a()).append(", msg=").append(h(r0.b())).append(", hasData=");
        if (r0.c() == null) goto L7;
        r2 = true;
    L7:
        a("SkillManager", r1.append(r2).toString());
    L12:
        a(r0, "GetLatestCliBinaryDownload");
        f r3 = (f) ZeusTransformUtils.preCheckCast(r0.c(), f.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L20;
        if (IAppContext.Companion.isDebug() == false) goto L17;
        a("SkillManager", "CLI latest response: name=" + h(r10) + ", version=" + h(r3.b()) + ", status=" + h(r3.c()) + ", filename=" + h(r3.d()) + ", fileSize=" + r3.e() + ", hasDownloadUrl=" + (!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"))));
    L18:
        return r3;
    L17:
        a("SkillManager", "CLI latest response: fileSize=" + r3.e() + ", hasDownloadUrl=" + (!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"))));
        goto L18
    L20:
        throw new IllegalStateException("GetLatestCliBinaryDownload returned empty data.");
    L8:
        StringBuilder r4 = new StringBuilder().append("CLI latest api response: code=").append(r0.a()).append(", hasData=");
        if (r0.c() == null) goto L11;
        r2 = true;
    L11:
        a("SkillManager", r4.append(r2).toString());
        goto L12
    }

    public final long a(String r7, File r8) {
        d.h.b.o.e(r7, "downloadUrl");
        d.h.b.o.e(r8, "destination");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        fe r2 = (fe) ZeusTransformUtils.preCheckCast(this, fe.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r3 = d.n.f(new URI(r7));     // Catch: Throwable -> L5
    L7:
        String r4 = null;
        if (d.n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        URI r5 = (URI) ZeusTransformUtils.preCheckCast(r3, URI.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L13;
        String r6 = r5.getScheme();
    L14:
        boolean r9 = true;
        if (d.o.o.a(r6, "https", true) == false) goto L27;
        if (r5 == null) goto L18;
        r4 = r5.getHost();
    L18:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L27;
    L28:
        if (r9 == false) goto L32;
        return a(r7, r8, "application/octet-stream,*/*", "CLI package download").b();
    L32:
        throw new IllegalArgumentException("CLI package download requires HTTPS.".toString());
    L21:
        if (d.o.o.d(r0) == true) goto L24;
        r10 = false;
    L27:
        r9 = false;
        goto L28
    L13:
        r6 = null;
    L5:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public gr a(String r7, long r8) {
        d.h.b.o.e(r7, "filename");
        boolean r0 = false;
        fv<?> r9 = (fv) ZeusTransformUtils.preCheckCast(b("/assistant/skills_store/api/v1/skill-signing/upload-token", d.a.ao.a(new d.m[]{d.s.a("filename", r7), d.s.a("fileSize", Long.valueOf(r8))}), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$createSkillSigningUploadToken$response$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
        gr r10 = (gr) ZeusTransformUtils.preCheckCast(r9.c(), gr.class, "com.obric.aiagent.plugin");
        StringBuilder r1 = new StringBuilder().append("hasData=");
        if (r10 == null) goto L5;
        boolean r4 = true;
    L6:
        String r2 = r1.append(r4).toString();
        StringBuilder r3 = new StringBuilder().append("hasData=");
        if (r10 == null) goto L9;
        boolean r5 = true;
    L10:
        StringBuilder r6 = r3.append(r5).append(", hasUploadUrl=");
        if (r10 == null) goto L17;
        String r11 = r10.a();
        if (r11 == null) goto L17;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L17;
        boolean r12 = true;
    L18:
        StringBuilder r13 = r6.append(r12).append(", hasObjectKey=");
        if (r10 == null) goto L25;
        String r14 = r10.c();
        if (r14 == null) goto L25;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L25;
        boolean r15 = true;
    L26:
        StringBuilder r16 = r13.append(r15).append(", hasCredentials=");
        if (r10 == null) goto L29;
        gq r17 = r10.b();
    L30:
        if (r17 == null) goto L32;
        r0 = true;
    L32:
        StringBuilder r18 = r16.append(r0).append(", credentialExpiredTime=");
        if (r10 == null) goto L39;
        gq r19 = r10.b();
        if (r19 == null) goto L39;
        Long r20 = r19.a();
        if (r20 == null) goto L39;
        long r21 = r20.longValue();
    L40:
        a(r9, "CreateUploadToken", r2, r18.append(r21).toString());
        a(r9, "CreateSkillSigningUploadToken");
        if (r10 == null) goto L44;
        return r10;
    L44:
        throw new IllegalStateException("CreateSkillSigningUploadToken returned empty data.");
    L39:
        r21 = -1;
        goto L40
    L29:
        r17 = null;
    L25:
        r15 = false;
    L17:
        r12 = false;
        goto L18
    L9:
        r5 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public void b(String r14, File r15) {
        d.h.b.o.e(r14, "uploadUrl");
        d.h.b.o.e(r15, "packageFile");
        com.obric.aiagent.ttnet.l.b r13 = a(d().putFile(new com.obric.aiagent.ttnet.j(r14, r15, "application/zip", d.a.ao.a(d.s.a("Accept", "application/json,*/*")), 10000, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS)), "Skill signing package upload");
        StringBuilder r16 = new StringBuilder().append("Skill signing package upload response: httpCode=").append(r13.a()).append(", fileSize=").append(r13.b()).append(", ttLogId=");
        String r17 = r13.c();
        if (r17 != null) goto L5;
        r17 = "-";
    L5:
        a("SkillManager", r16.append(r17).toString());
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public gp a(String r20, Map<String, String> r21) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "objectKey");
        d.h.b.o.e(r2, "clientContext");
        boolean r4 = false;
        fv<JsonElement> r1 = c("/assistant/skills_store/api/v1/skill-signing/tasks", d.a.ao.a(new d.m[]{d.s.a("objectKey", r20), d.s.a("clientContext", r2)}));
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r1.c(), JsonElement.class, "com.obric.aiagent.plugin");
        gp r6 = null;
        if (r5 != null) goto L5;
    L12:
        StringBuilder r3 = new StringBuilder().append("hasData=");
        if (r6 == null) goto L15;
        r4 = true;
    L15:
        String r7 = r3.append(r4).toString();
        if (r6 == null) goto L19;
        String r8 = a(r6);
        if (r8 == null) goto L19;
    L20:
        a(r1, "CreateTask", r7, r8);
        a(r1, "CreateSkillSigningTask");
        if (r6 == null) goto L24;
        return r6;
    L24:
        throw new IllegalStateException("CreateSkillSigningTask returned empty data.");
    L19:
        r8 = "hasData=false";
        goto L20
    L5:
        if (r5.isJsonNull() == false) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L12;
        gp r9 = (gp) ZeusTransformUtils.preCheckCast(this.f19871b.fromJson(r5, gp.class), gp.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L12;
        String r10 = this.f19871b.toJson(r5);
        d.h.b.o.c(r10, "toJson(...)");
        r6 = gp.a(r9, null, null, null, null, null, null, null, null, r10, 255, null);
        goto L12
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public gp d(String r19) {
        d.h.b.o.e(r19, DBDefinition.TASK_ID);
        fv<JsonElement> r2 = b("/assistant/skills_store/api/v1/skill-signing/tasks/" + g(r19), d.a.ao.b());
        JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r2.c(), JsonElement.class, "com.obric.aiagent.plugin");
        gp r4 = null;
        if (r3 != null) goto L5;
    L12:
        StringBuilder r5 = new StringBuilder().append("hasData=");
        if (r4 == null) goto L15;
        boolean r6 = true;
    L16:
        String r7 = r5.append(r6).toString();
        if (r4 == null) goto L20;
        String r8 = a(r4);
        if (r8 == null) goto L20;
    L21:
        a(r2, "GetTask", r7, r8);
        a(r2, "GetSkillSigningTask");
        if (r4 == null) goto L25;
        return r4;
    L25:
        throw new IllegalStateException("GetSkillSigningTask returned empty data.");
    L20:
        r8 = "hasData=false, requestedTaskId=" + r19;
        goto L21
    L15:
        r6 = false;
        goto L16
    L5:
        if (r3.isJsonNull() == false) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L12;
        gp r9 = (gp) ZeusTransformUtils.preCheckCast(this.f19871b.fromJson(r3, gp.class), gp.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L12;
        String r15 = this.f19871b.toJson(r3);
        d.h.b.o.c(r15, "toJson(...)");
        r4 = gp.a(r9, null, null, null, null, null, null, null, null, r15, 255, null);
        goto L12
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public ge e(String r12) {
        d.h.b.o.e(r12, "manifestId");
        fv<JsonElement> r0 = b("/assistant/skills_store/api/v1/skill-signing/manifests/" + g(r12), d.a.ao.b());
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.c(), JsonElement.class, "com.obric.aiagent.plugin");
        ge r2 = null;
        if (r1 != null) goto L5;
    L12:
        StringBuilder r3 = new StringBuilder().append("hasData=");
        if (r2 == null) goto L15;
        boolean r4 = true;
    L16:
        String r5 = r3.append(r4).toString();
        if (r2 == null) goto L20;
        String r6 = a(r2);
        if (r6 == null) goto L20;
    L21:
        a(r0, "GetManifest", r5, r6);
        a(r0, "GetSkillSigningManifest");
        if (r2 == null) goto L25;
        return r2;
    L25:
        throw new IllegalStateException("GetSkillSigningManifest returned empty data.");
    L20:
        r6 = "hasData=false, requestedManifestId=" + r12;
        goto L21
    L15:
        r4 = false;
        goto L16
    L5:
        if (r1.isJsonNull() == false) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        ge r7 = (ge) ZeusTransformUtils.preCheckCast(this.f19871b.fromJson(r1, ge.class), ge.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L12;
        String r8 = this.f19871b.toJson(r1);
        d.h.b.o.c(r8, "toJson(...)");
        r2 = ge.a(r7, null, null, null, r8, 7, null);
        goto L12
    }

    @Override // com.obric.aiagent.skill.manager.impl.gc
    public ef f(String r6) {
        d.h.b.o.e(r6, DBDefinition.TASK_ID);
        fv<JsonElement> r0 = b("/assistant/skills_store/api/v1/skill-signing/tasks/" + g(r6) + "/decision", d.a.ao.b());
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.c(), JsonElement.class, "com.obric.aiagent.plugin");
        ef r2 = null;
        if (r1 != null) goto L5;
    L10:
        StringBuilder r3 = new StringBuilder().append("hasData=");
        if (r2 == null) goto L13;
        boolean r4 = true;
    L14:
        String r5 = r3.append(r4).toString();
        if (r2 == null) goto L18;
        String r7 = a(r2);
        if (r7 == null) goto L18;
    L19:
        a(r0, "GetSkillScanDecision", r5, r7);
        a(r0, "GetSkillScanDecision");
        if (r2 == null) goto L23;
        return r2;
    L23:
        throw new IllegalStateException("GetSkillScanDecision returned empty data.");
    L18:
        r7 = "hasData=false, requestedTaskId=" + h(r6);
        goto L19
    L13:
        r4 = false;
        goto L14
    L5:
        if (r1.isJsonNull() == false) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r2 = (ef) ZeusTransformUtils.preCheckCast(this.f19871b.fromJson(r1, ef.class), ef.class, "com.obric.aiagent.plugin");
        goto L10
    }

    private final <T> T a(String r3, Map<String, String> r4, TypeToken<T> r5) {
        return (T) a(a("GET", d(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin")), null), r5);
    }

    private final fv<JsonElement> b(String r3, Map<String, String> r4) {
        return (fv) ZeusTransformUtils.preCheckCast(a(a("GET", d(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin")), null), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$getRaw$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
    }

    private final <T> T b(String r3, Map<String, ? extends Object> r4, TypeToken<T> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return (T) a(a("POST", d(r3, d.a.ao.b()), this.f19871b.toJson(r6)), r5);
    }

    private final fv<JsonElement> c(String r3, Map<String, ? extends Object> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return (fv) ZeusTransformUtils.preCheckCast(a(a("POST", d(r3, d.a.ao.b()), this.f19871b.toJson(r5)), (TypeToken) ZeusTransformUtils.preCheckCast(new SkillShopApiClient$postRaw$1(), TypeToken.class, "com.obric.aiagent.plugin")), fv.class, "com.obric.aiagent.plugin");
    }

    private final <T> T a(String r3, TypeToken<T> r4) {
        T r2 = (T) this.f19871b.fromJson(r3, r4.getType());
        if (r2 == null) goto L7;
        return r2;
    L7:
        throw new fp(fq.f19910c, null, 2, null);     // Catch: JsonParseException -> L8 fp -> L10
    L10:
        e = move-exception;
        throw e;
    L9:
        throw new fp(fq.f19910c, null, 2, null);
    }

    private final String a(String r4, String r5, String r6) {
        return (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r4, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.ttnet.l.b a(String r19, File r20, String r21, String r22) {
        return a(d().downloadToFile(new com.obric.aiagent.ttnet.i(r19, r20, d.a.ao.a(d.s.a("Accept", r21)), 10000, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, null, null, 0, false, false, 992, null)), r22);
    }

    private final ITTNetFileTransfer d() {
        ITTNetFileTransfer r2 = (ITTNetFileTransfer) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNetFileTransfer.class), ITTNetFileTransfer.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new Cdo();
    }

    private final com.obric.aiagent.ttnet.l.b a(com.obric.aiagent.ttnet.l r7, String r8) {
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.ttnet.l.b.class) == false) goto L7;
        return (com.obric.aiagent.ttnet.l.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.ttnet.l.b.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.ttnet.l.a.class) == false) goto L11;
        throw new dn(((com.obric.aiagent.ttnet.l.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.ttnet.l.a.class, "com.obric.aiagent.plugin")).a(), null, ((com.obric.aiagent.ttnet.l.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.ttnet.l.a.class, "com.obric.aiagent.plugin")).b(), 2, null);
    L11:
        throw new d.k();
    }

    private final String d(String r12, Map<String, String> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r14);
        r0.put("device_platform", "android");
        Set r15 = r0.entrySet();
        d.h.b.o.c(r15, "<get-entries>(...)");
        String r16 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("&", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$fe$tijS0iq6ocRxxt96den9O9Pn38(this), 30, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return e() + r12;
    L9:
        return e() + r12 + '?' + r16;
    L5:
        r1 = false;
        goto L6
    }

    private static final CharSequence a(fe r3, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<destruct>");
        Object r0 = r5.getKey();
        d.h.b.o.c(r0, "component1(...)");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        Object r6 = r5.getValue();
        d.h.b.o.c(r6, "component2(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.g(r1) + '=' + r3.g((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String g(String r1) {
        String r0 = URLEncoder.encode(r1, StandardCharsets.UTF_8.name());
        d.h.b.o.c(r0, "encode(...)");
        return r0;
    }

    private final void a(fv<?> r4, String r5) {
        if (r4.a() != 0) goto L5;
        return;
    L5:
        if (IAppContext.Companion.isDebug() == false) goto L7;
        b("SkillManager", r5 + " failed: code=" + r4.a() + ", msg=" + h(r4.b()));
    L9:
        throw new fp(fq.f19910c, null, 2, null);
    L7:
        b("SkillManager", r5 + " failed: code=" + r4.a());
        goto L9
    }

    private final void a(fv<?> r6, String r7, String r8, String r9) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", "Skill signing api response: api=" + r7 + ", code=" + r6.a() + ", msg=" + h(r6.b()) + ", " + r9);
        return;
    L5:
        a("SkillManager", "Skill signing api response: api=" + r7 + ", code=" + r6.a() + ", " + r8);
    }

    private final String a(gp r6) {
        StringBuilder r0 = new StringBuilder().append("taskId=");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = "-";
        if (d.o.o.d(r1) == false) goto L5;
        r1 = "-";
    L5:
        StringBuilder r2 = r0.append((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin")).append(", status=");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r3) == true) goto L10;
        r4 = r3;
    L10:
        return r2.append((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).append(", manifestId=").append(h(r6.c())).append(", errorCode=").append(h(r6.d())).append(", errorMessage=").append(h(r6.e())).toString();
    }

    private final String a(ge r7) {
        JsonElement r0 = r7.b();
        StringBuilder r1 = new StringBuilder().append("manifestId=");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r2) == false) goto L5;
        r2 = "-";
    L5:
        StringBuilder r3 = r1.append((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).append(", hasSignedManifest=");
        boolean r4 = false;
        if (r0 == null) goto L8;
        boolean r5 = true;
    L9:
        StringBuilder r6 = r3.append(r5).append(", hasSigningPayload=");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L12;
    L13:
        r4 = true;
    L15:
        return r6.append(!r4).append(", decision=").append(h(a(r0, new String[]{"decision_action", "decisionAction", "security_decision", "securityDecision", "decision"}))).append(", riskResult=").append(h(a(r0, new String[]{"risk_result", "riskResult"}))).append(", status=").append(h(a(r0, new String[]{"status"}))).toString();
    L12:
        if (d.o.o.d(r8) == false) goto L15;
    L8:
        r5 = false;
        goto L9
    }

    private final String a(ef r3) {
        StringBuilder r2 = new StringBuilder().append("scanId=").append(h(r3.a())).append(", scanStatus=").append(h(r3.b())).append(", decisionAction=").append(h(r3.d())).append(", riskScore=");
        Object r4 = r3.c();
        if (r4 != null) goto L6;
        r4 = "-";
    L6:
        return r2.append(r4).toString();
    }

    private final String a(JsonElement r7, String... r8) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (r7.isJsonObject() == false) goto L14;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r8.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r8.length;
    L7:
        if (r1 >= r3) goto L10;
        String r4 = r8[r1].toLowerCase(Locale.ROOT);
        d.h.b.o.c(r4, "toLowerCase(...)");
        r0.add(r4);
        r1 = r1 + 1;
        goto L7
    L10:
        return a(r7, d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
    L14:
        return null;
    }

    private final String a(JsonElement r8, Set<String> r9) {
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        if (r8.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r11 = r8.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> r0 = r11.entrySet();
        d.h.b.o.c(r0, "entrySet(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r4);
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r6 = (JsonElement) ZeusTransformUtils.preCheckCast(r4.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r5);
        String r7 = r5.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r7, "toLowerCase(...)");
        if (r10.contains(r7) == false) goto L7;
        if (r6.isJsonPrimitive() == false) goto L7;
        return r6.getAsString();
    L14:
        Set<Map.Entry<String, JsonElement>> r12 = r11.entrySet();
        d.h.b.o.c(r12, "entrySet(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L42;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r2.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        boolean r14 = false;
        if (r3.isJsonObject() == false) goto L21;
        d.h.b.o.a(r3);
        String r15 = a(r3, r10);
    L35:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L38;
    L39:
        r14 = true;
    L40:
        if (r14 == true) goto L16;
        return r15;
    L38:
        if (d.o.o.d(r16) == false) goto L40;
    L21:
        if (r3.isJsonArray() == false) goto L34;
        Iterator<JsonElement> r17 = r3.getAsJsonArray().iterator();
        d.h.b.o.c(r17, "iterator(...)");
        String r18 = null;
    L24:
        if (r17.hasNext() == false) goto L33;
        JsonElement r19 = (JsonElement) ZeusTransformUtils.preCheckCast(r17.next(), JsonElement.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r19);
        r18 = a(r19, r10);
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L28;
    L31:
        boolean r21 = true;
    L32:
        if (r21 == true) goto L24;
    L28:
        if (d.o.o.d(r20) == true) goto L31;
        r21 = false;
    L33:
        r15 = r18;
        goto L35
    L34:
        r15 = null;
        goto L35
    L42:
        return null;
    }

    private final String h(String r3) {
        if (r3 == null) goto L13;
        String r2 = new d.o.k("https?://\\S+").a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), "<redacted-url>");
        if (r2 == null) goto L13;
        String r4 = d.o.o.e(r2, 300);
        if (r4 == null) goto L13;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        return r4;
    L13:
        return "-";
    }

    private final String e() {
        if (com.obric.aiagent.skill.manager.api.al.f19195a.a().C() == false) goto L5;
        return "http://oassistant-skills-store-boe.byted.org";
    L5:
        return "https://oassistant-skills-store.obriccloud.com";
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
