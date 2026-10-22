package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.autogui.common.api.platform.system.CoarseLocationInfo;
import com.obric.autogui.common.api.platform.system.IAutoActionLocationApi;
import com.obric.autogui.tools.api.IImageXApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploadManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    private static final String TAG = "UploadManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f23777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.a.d<com.obric.autoaction.app.launcherpage.donation.model.a> f23778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.obric.autoaction.app.launcherpage.donation.model.a> f23779c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.obric.autoaction.app.launcherpage.donation.model.a> f23780d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final am f23781e = null;
    private static com.obric.autoaction.app.launcherpage.donation.model.a f;
    private static final w<com.obric.autoaction.app.launcherpage.donation.model.a> g = null;
    private static final CopyOnWriteArrayList<com.obric.autoaction.app.launcherpage.donation.model.a> h = null;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.m$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadManager.kt */
    @d.c.b.a.f(b = "UploadManager.kt", c = {47, 49}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadManager$1")
    static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23783b;

        AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0089 -> B:7:0x001d). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23783b;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            kotlinx.coroutines.a.f r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f23782a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L7:
            kotlinx.coroutines.a.f r10 = r2;
        L12:
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23782a = r10;
            this.f23783b = 1;
            Object r4 = r10.a(r3);
            if (r4 != r0) goto L15;
            return r0;
        L15:
            r2 = r10;
            r9 = r4;
        L17:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L22;
            com.obric.autoaction.app.launcherpage.donation.model.a r11 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
            m.f().remove(r11);
            m r5 = m.f23777a;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23782a = r2;
            this.f23783b = 2;
            if (m.a(r5, r11, r6) != r0) goto L7;
            return r0;
        L22:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f23782a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            o.a(r9);
            goto L17
        L11:
            o.a(r9);
            r10 = m.e().g();
            goto L12
        }
    }

    /* JADX INFO: compiled from: UploadManager.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23785b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class C0537a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0537a f23786a = null;

            static {
                f23786a = new C0537a();
            }

            private C0537a() {
                int r1 = 3;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_accepted, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_accepted"), null);
            }
        }

        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f23787a = null;

            static {
                f23787a = new b();
            }

            private b() {
                int r1 = 5;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_payed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_payed"), null);
            }
        }

        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f23788a = null;

            static {
                f23788a = new c();
            }

            private c() {
                int r1 = 4;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_rejected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_rejected"), null);
            }
        }

        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f23789a = null;

            static {
                f23789a = new d();
            }

            private d() {
                int r1 = 1;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_upload_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_upload_failed"), null);
            }
        }

        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f23790a = null;

            static {
                f23790a = new e();
            }

            private e() {
                int r1 = 2;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_uploaded, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_uploaded"), null);
            }
        }

        /* JADX INFO: compiled from: UploadManager.kt */
        public static final class f extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f23791a = null;

            static {
                f23791a = new f();
            }

            private f() {
                int r1 = 0;
                super(r1, ZeusTransformUtils.mapRes(R.string.status_uploading, WsChannelMultiProcessSharedProvider.STRING_TYPE, "status_uploading"), null);
            }
        }

        public /* synthetic */ a(int r1, int r2, d.h.b.h r3) {
            this(r1, r2);
        }

        private a(int r1, int r2) {
            this.f23784a = r1;
            this.f23785b = r2;
        }

        public final int a() {
            return this.f23784a;
        }

        public final int b() {
            return this.f23785b;
        }
    }

    /* JADX INFO: compiled from: UploadManager.kt */
    @d.c.b.a.f(b = "UploadManager.kt", c = {196}, d = "getLocation", e = "com.obric.autoaction.app.launcherpage.donation.UploadManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f23794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23795d;

        b(m r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23794c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23793b = r3;
            this.f23795d |= Integer.MIN_VALUE;
            return m.a(this.f23794c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UploadManager.kt */
    @d.c.b.a.f(b = "UploadManager.kt", c = {66}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadManager$reUploadTask$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.donation.model.a f23797b;

        c(com.obric.autoaction.app.launcherpage.donation.model.a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23797b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23797b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23796a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            w<com.obric.autoaction.app.launcherpage.donation.model.a> r7 = m.f23777a.a();
            com.obric.autoaction.app.launcherpage.donation.model.a r2 = this.f23797b;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23796a = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: UploadManager.kt */
    @d.c.b.a.f(b = "UploadManager.kt", c = {108, BDImageUploader.MessageIsPreHeatResultUsed, 129, 134, 177}, d = "uploadTask", e = "com.obric.autoaction.app.launcherpage.donation.UploadManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f23800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f23801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f23802e;
        final /* synthetic */ m f;
        int g;

        d(m r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23802e = r3;
            this.g |= Integer.MIN_VALUE;
            return m.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ CharSequence lambda$jcRAZ2leKEHGFMdtqNqxTqUYgxM(String r0) {
        return b(r0);
    }

    private m() {
    }

    public static final /* synthetic */ Object a(m r2, Context r3, d.c.d r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(m r2, com.obric.autoaction.app.launcherpage.donation.model.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d e() {
        return f23778b;
    }

    public static final /* synthetic */ CopyOnWriteArrayList f() {
        return f23779c;
    }

    static {
        f23777a = new m();
        f23778b = kotlinx.coroutines.a.g.a(Integer.MAX_VALUE, null, null, 6, null);
        f23779c = new CopyOnWriteArrayList();
        f23780d = new CopyOnWriteArrayList();
        am r6 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f23781e = r6;
        g = ad.a(0, 0, null, 6, null);
        h = new CopyOnWriteArrayList();
        kotlinx.coroutines.i.a(r6, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final w<com.obric.autoaction.app.launcherpage.donation.model.a> a() {
        return g;
    }

    public final CopyOnWriteArrayList<com.obric.autoaction.app.launcherpage.donation.model.a> b() {
        return h;
    }

    public final void a(com.obric.autoaction.app.launcherpage.donation.model.a r1) {
        d.h.b.o.e(r1, "task");
        f23779c.add(r1);
        f23778b.a_(r1);
    }

    public final void a(String r10) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f23780d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin")).a(), r10) == false) goto L4;
        com.obric.autoaction.app.launcherpage.donation.model.a r11 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L16;
        f23780d.remove(r11);
        r11.a(a.f.f23791a.a());
        a(r11);
        kotlinx.coroutines.i.a(an.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L16:
        return;
    L12:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final List<com.obric.autoaction.app.launcherpage.donation.model.a> c() {
        List<com.obric.autoaction.app.launcherpage.donation.model.a> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.donation.model.a r0 = f;
        if (r0 == null) goto L5;
        r3.add(r0);
    L5:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(h, Collection.class, "com.obric.aiagent.plugin"));
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(f23779c, Collection.class, "com.obric.aiagent.plugin"));
        return r3;
    }

    public final List<com.obric.autoaction.app.launcherpage.donation.model.a> d() {
        return (List) ZeusTransformUtils.preCheckCast(f23780d, List.class, "com.obric.aiagent.plugin");
    }

    public final a a(int r2) {
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L27;
        if (r2 == 2) goto L26;
        if (r2 == 3) goto L25;
        if (r2 == 4) goto L24;
        if (r2 == 5) goto L23;
        return (a) ZeusTransformUtils.preCheckCast(a.e.f23790a, a.class, "com.obric.aiagent.plugin");
    L23:
        return (a) ZeusTransformUtils.preCheckCast(a.b.f23787a, a.class, "com.obric.aiagent.plugin");
    L24:
        return (a) ZeusTransformUtils.preCheckCast(a.c.f23788a, a.class, "com.obric.aiagent.plugin");
    L25:
        return (a) ZeusTransformUtils.preCheckCast(a.C0537a.f23786a, a.class, "com.obric.aiagent.plugin");
    L26:
        return (a) ZeusTransformUtils.preCheckCast(a.e.f23790a, a.class, "com.obric.aiagent.plugin");
    L27:
        return (a) ZeusTransformUtils.preCheckCast(a.d.f23789a, a.class, "com.obric.aiagent.plugin");
    L21:
        return (a) ZeusTransformUtils.preCheckCast(a.f.f23791a, a.class, "com.obric.aiagent.plugin");
    }

    private final Object a(com.obric.autoaction.app.launcherpage.donation.model.a r28, d.c.d<? super x> r29) {
        m r1 = this;
        com.obric.autoaction.app.launcherpage.donation.model.a r2 = r28;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f23802e;
        Object r12 = d.c.a.b.a();
        int r6 = r5.g;
        if (r6 == 0) goto L38;
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L28;
        if (r6 == 3) goto L23;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L17;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r5.f23798a, m.class, "com.obric.aiagent.plugin");
        o.a(r4);
        com.obric.autoaction.app.launcherpage.donation.model.a r7 = null;
    L190:
        f = r7;
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        com.obric.autoaction.app.launcherpage.donation.model.a r8 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23799b, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        m r9 = (m) ZeusTransformUtils.preCheckCast(r5.f23798a, m.class, "com.obric.aiagent.plugin");
        o.a(r4);     // Catch: Throwable -> L21
        r2 = r8;
        r1 = r9;
    L149:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r10 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r10.a() == true) goto L153;
        com.obric.autogui.tools.api.net.b r11 = r10.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L179
        r11.b();     // Catch: Throwable -> L179
        Loog.INSTANCE.e(TAG, "uploadTask failed: " + r11.getType());     // Catch: Throwable -> L179
        return x.f38692a;
    L153:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r10.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r10.a() == false) goto L174;
        if (r13 == null) goto L174;
        Loog.INSTANCE.d(TAG, "upload resp " + r13);     // Catch: Throwable -> L179
        JSONObject r14 = new JSONObject(r13);     // Catch: Throwable -> L179
        if (r14.optInt(MonitorConstants.CODE) != 0) goto L173;
        JSONObject r15 = r14.optJSONObject("data");     // Catch: Throwable -> L179
        if (r15 == null) goto L171;
        long r16 = r15.optLong("upload_time");     // Catch: Throwable -> L179
        JSONArray r17 = r15.optJSONArray(MonitorConstants.URLS);     // Catch: Throwable -> L179
        if (r17 == null) goto L169;
        if (r17.length() != r2.d().size()) goto L169;
        Loog.INSTANCE.d(TAG, "uploadTask success, urls.size: " + d.c.b.a.b.a(r17.length()));     // Catch: Throwable -> L179
        int r18 = r2.d().size();     // Catch: Throwable -> L179
        int r19 = 0;
    L165:
        if (r19 >= r18) goto L167;
        ((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r2.d().get(r19), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).a(r17.optString(r19));     // Catch: Throwable -> L179
        r19 = r19 + 1;     // Catch: Throwable -> L179
        goto L165
    L167:
        r2.a(r16);     // Catch: Throwable -> L179
    L169:
        throw new IllegalStateException("uploadTask failed, urls.size not equal to operations.size".toString());     // Catch: Throwable -> L179
    L171:
        throw new IllegalStateException("uploadTask failed, data is null".toString());     // Catch: Throwable -> L179
    L173:
        throw new IllegalStateException("uploadTask failed".toString());     // Catch: Throwable -> L179
    L174:
        Object r20 = d.n.f(x.f38692a);     // Catch: Throwable -> L179
    L181:
        Throwable r21 = d.n.c(r20);
        if (r21 == null) goto L185;
        Loog.INSTANCE.e(TAG, "uploadTask failed, taskId: " + r2.a(), r21);
        r2.a(a.d.f23789a.a());
        f23780d.add(r2);
    L185:
        if (d.n.a(r20) == false) goto L187;
        x r22 = (x) ZeusTransformUtils.preCheckCast(r20, x.class, "com.obric.aiagent.plugin");
        r2.a(a.e.f23790a.a());
        h.add(r2);
    L187:
        w<com.obric.autoaction.app.launcherpage.donation.model.a> r23 = g;
        r5.f23798a = r1;
        r7 = null;
        r5.f23799b = null;
        r5.f23800c = null;
        r5.f23801d = null;
        r5.g = 5;
        if (r23.emit(r2, r5) != r12) goto L190;
        return r12;
    L21:
        th = th;
        r2 = r8;
        r1 = r9;
    L180:
        d.n.a r24 = d.n.f38560a;
        r20 = d.n.f(o.a(th));
        goto L181
    L23:
        com.obric.autoaction.app.launcherpage.donation.model.a r25 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23801d, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r5.f23800c, String.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.donation.model.a r27 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23799b, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        m r30 = (m) ZeusTransformUtils.preCheckCast(r5.f23798a, m.class, "com.obric.aiagent.plugin");
        o.a(r4);     // Catch: Throwable -> L26
        com.obric.autoaction.app.launcherpage.donation.model.a r31 = r25;
        r1 = r30;
        String r32 = r26;
        r2 = r27;
        Object r33 = r4;
    L143:
        r31.a((String) ZeusTransformUtils.preCheckCast(r33, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L179
        String r34 = r32;
    L144:
        JSONObject r35 = r2.j();     // Catch: Throwable -> L179
        com.obric.autogui.tools.api.net.a r36 = com.obric.autogui.tools.a.a.f31480a.a();     // Catch: Throwable -> L179
        if (r36 == null) goto L176;
        String r37 = com.obric.aiagent.product.a.a.f18769a.a("auto_action/api/donation/answer?uid=" + r34);     // Catch: Throwable -> L179
        Map<String, String> r38 = ao.a(s.a(DownloadHelper.CONTENT_TYPE, "application/json"));     // Catch: Throwable -> L179
        String r39 = r35.toString();     // Catch: Throwable -> L179
        d.h.b.o.c(r39, "toString(...)");     // Catch: Throwable -> L179
        r5.f23798a = r1;     // Catch: Throwable -> L179
        r5.f23799b = r2;     // Catch: Throwable -> L179
        r5.f23800c = null;     // Catch: Throwable -> L179
        r5.f23801d = null;     // Catch: Throwable -> L179
        r5.g = 4;     // Catch: Throwable -> L179
        r4 = r36.a(r37, r38, r39, 60000, r5);     // Catch: Throwable -> L179
        if (r4 != r12) goto L149;
        return r12;
    L176:
        throw new IllegalStateException("obtainHttpClient failed".toString());     // Catch: Throwable -> L179
    L26:
        th = th;
        r2 = r27;
        r1 = r30;
        goto L180
    L28:
        com.obric.autoaction.app.launcherpage.donation.model.a r40 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23801d, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        String r41 = (String) ZeusTransformUtils.preCheckCast(r5.f23800c, String.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.donation.model.a r42 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23799b, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        m r110 = (m) ZeusTransformUtils.preCheckCast(r5.f23798a, m.class, "com.obric.aiagent.plugin");
        o.a(r4);     // Catch: Throwable -> L31
        com.obric.autoaction.app.launcherpage.donation.model.a r43 = r40;
        r1 = r110;
        String r44 = r41;
        r2 = r42;
        Object r45 = r4;
    L126:
        Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast(r45, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Collection r47 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r46, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Iterator r48 = r46.iterator();     // Catch: Throwable -> L179
    L128:
        if (r48.hasNext() == false) goto L130;
        r47.add(((OpenableAppInfo) ZeusTransformUtils.preCheckCast(r48.next(), OpenableAppInfo.class, "com.obric.aiagent.plugin")).getAppLabel());     // Catch: Throwable -> L179
        goto L128
    L130:
        r43.a((List) ZeusTransformUtils.preCheckCast(r47, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L179
        r34 = r44;
    L131:
        CharSequence r49 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.i(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r49 != null) goto L134;
    L137:
        boolean r111 = true;
    L138:
        if (r111 == false) goto L144;
        m r50 = f23777a;     // Catch: Throwable -> L179
        Context r51 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        r5.f23798a = r1;     // Catch: Throwable -> L179
        r5.f23799b = r2;     // Catch: Throwable -> L179
        r5.f23800c = r34;     // Catch: Throwable -> L179
        r5.f23801d = r2;     // Catch: Throwable -> L179
        r5.g = 3;     // Catch: Throwable -> L179
        Object r52 = r50.a(r51, r5);     // Catch: Throwable -> L179
        if (r52 != r12) goto L142;
        return r12;
    L142:
        r33 = r52;
        r32 = r34;
        r31 = r2;
        goto L143
    L134:
        if (r49.length() == 0) goto L137;
        r111 = false;
    L31:
        th = th;
        r2 = r42;
        r1 = r110;
        goto L180
    L33:
        String r53 = (String) ZeusTransformUtils.preCheckCast(r5.f23800c, String.class, "com.obric.aiagent.plugin");
        r2 = (com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r5.f23799b, com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin");
        m r54 = (m) ZeusTransformUtils.preCheckCast(r5.f23798a, m.class, "com.obric.aiagent.plugin");
        o.a(r4);     // Catch: Throwable -> L36
        r34 = r53;
        r1 = r54;
    L100:
        List r55 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
    L102:
        Loog r56 = Loog.INSTANCE;     // Catch: Throwable -> L179
        StringBuilder r57 = new StringBuilder().append("uploadTask success, ");     // Catch: Throwable -> L179
        if (r55 == null) goto L105;
        String r112 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r55, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$m$jcRAZ2leKEHGFMdtqNqxTqUYgxM.INSTANCE, 31, null);     // Catch: Throwable -> L179
    L106:
        r56.d(TAG, r57.append(r112).toString());     // Catch: Throwable -> L179
        if (r55 == null) goto L114;
        int r58 = r2.d().size();     // Catch: Throwable -> L179
        int r59 = 0;
        int r113 = 0;
    L109:
        if (r59 >= r58) goto L114;
        if (((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r2.d().get(r59), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).b() == null) goto L113;
        ((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r2.d().get(r59), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).c((String) ZeusTransformUtils.preCheckCast(r55.get(r113), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L179
        r113 = r113 + 1;     // Catch: Throwable -> L179
    L113:
        r59 = r59 + 1;     // Catch: Throwable -> L179
    L114:
        Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(r2.h(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r60 != null) goto L117;
    L120:
        boolean r61 = true;
    L121:
        if (r61 == false) goto L131;
        AOPackagesTools r62 = AOPackagesTools.INSTANCE;     // Catch: Throwable -> L179
        Context r63 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        r5.f23798a = r1;     // Catch: Throwable -> L179
        r5.f23799b = r2;     // Catch: Throwable -> L179
        r5.f23800c = r34;     // Catch: Throwable -> L179
        r5.f23801d = r2;     // Catch: Throwable -> L179
        r5.g = 2;     // Catch: Throwable -> L179
        Object r64 = r62.getOpenableApps(r63, r5);     // Catch: Throwable -> L179
        if (r64 != r12) goto L125;
        return r12;
    L125:
        r45 = r64;
        r44 = r34;
        r43 = r2;
        goto L126
    L117:
        if (r60.isEmpty() == true) goto L120;
        r61 = false;
        goto L121
    L105:
        r112 = null;
    L36:
        th = th;
        r1 = r54;
        goto L180
    L38:
        o.a(r4);
        d.n.a r65 = d.n.f38560a;     // Catch: Throwable -> L179
        f = r2;     // Catch: Throwable -> L179
        r2.a(a.f.f23791a.a());     // Catch: Throwable -> L179
        LoggedInUserInfo r66 = AOPlatformTools.INSTANCE.account().acquireUserInfo().getUserInfo();     // Catch: Throwable -> L179
        if (r66 == null) goto L42;
        r34 = r66.getUserId();     // Catch: Throwable -> L179
    L43:
        CharSequence r67 = (CharSequence) ZeusTransformUtils.preCheckCast(r34, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r67 != null) goto L46;
    L49:
        boolean r68 = true;
    L50:
        if (r68 == true) goto L178;
        Iterable r69 = (Iterable) ZeusTransformUtils.preCheckCast(r28.d(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Collection r70 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Iterator r71 = r69.iterator();     // Catch: Throwable -> L179
    L53:
        if (r71.hasNext() == false) goto L61;
        Object r114 = r71.next();     // Catch: Throwable -> L179
        if (((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r114, com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).b() == null) goto L57;
        boolean r72 = true;
    L58:
        if (r72 == false) goto L53;
        r70.add(r114);     // Catch: Throwable -> L179
        goto L53
    L57:
        r72 = false;
        goto L58
    L61:
        Iterable r73 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r70, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (ZeusTransformUtils.instanceOf(r73, Collection.class) == true) goto L64;
    L66:
        Iterator r74 = r73.iterator();     // Catch: Throwable -> L179
    L68:
        if (r74.hasNext() == false) goto L78;
        CharSequence r75 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r74.next(), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).e(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r75 != null) goto L72;
    L75:
        boolean r76 = true;
    L76:
        if (r76 == false) goto L68;
        boolean r77 = true;
    L79:
        if (r77 == false) goto L114;
        Iterable r78 = (Iterable) ZeusTransformUtils.preCheckCast(r28.d(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Collection r79 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Iterator r80 = r78.iterator();     // Catch: Throwable -> L179
    L82:
        if (r80.hasNext() == false) goto L89;
        Object r81 = r80.next();     // Catch: Throwable -> L179
        if (((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r81, com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).b() == null) goto L86;
        boolean r115 = true;
    L87:
        if (r115 == false) goto L82;
        r79.add(r81);     // Catch: Throwable -> L179
        goto L82
    L86:
        r115 = false;
        goto L87
    L89:
        List r82 = (List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r82, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L114;
        IImageXApi r83 = (IImageXApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IImageXApi.class), IImageXApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        if (r83 == null) goto L101;
        Iterable r84 = (Iterable) ZeusTransformUtils.preCheckCast(r82, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Collection r85 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r84, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        Iterator r86 = r84.iterator();     // Catch: Throwable -> L179
    L95:
        if (r86.hasNext() == false) goto L97;
        Bitmap r116 = ((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r86.next(), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L179
        d.h.b.o.a(r116);     // Catch: Throwable -> L179
        r85.add(r116);     // Catch: Throwable -> L179
        goto L95
    L97:
        List<Bitmap> r87 = (List) ZeusTransformUtils.preCheckCast(r85, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L179
        r5.f23798a = r1;     // Catch: Throwable -> L179
        r5.f23799b = r2;     // Catch: Throwable -> L179
        r5.f23800c = r34;     // Catch: Throwable -> L179
        r5.g = 1;     // Catch: Throwable -> L179
        r4 = r83.uploadImages(r87, r5);     // Catch: Throwable -> L179
        if (r4 != r12) goto L100;
        return r12;
    L101:
        r55 = null;
        goto L102
    L72:
        if (r75.length() == 0) goto L75;
        r76 = false;
    L78:
        r77 = false;
        goto L79
    L64:
        if (((Collection) ZeusTransformUtils.preCheckCast(r73, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L66;
    L178:
        throw new IllegalStateException("uploadTask failed, uid is empty".toString());     // Catch: Throwable -> L179
    L46:
        if (r67.length() == 0) goto L49;
        r68 = false;
        goto L50
    L42:
        r34 = null;
    L179:
        th = th;
    L7:
        r5 = new d(r1, r3);
        goto L8
    }

    private static final CharSequence b(String r2) {
        d.h.b.o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final Object a(Context r12, d.c.d<? super String> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f23795d & Integer.MIN_VALUE) == 0) goto L7;
        r15.f23795d -= Integer.MIN_VALUE;
    L8:
        b r6 = r15;
        Object r16 = r6.f23793b;
        Object r17 = d.c.a.b.a();
        int r0 = r6.f23795d;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.f23792a, String.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L37:
        com.obric.autogui.common.d r18 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r18.g() == true) goto L41;
        Loog.INSTANCE.d(TAG, "getLocation failed, location is null");
        return r11;
    L41:
        CoarseLocationInfo r19 = (CoarseLocationInfo) ZeusTransformUtils.preCheckCast(r18.a(), CoarseLocationInfo.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L48;
        String r110 = r19.getRepresentation();
        if (r110 != null) goto L47;
        return r11;
    L47:
        return r110;
    L48:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        IAutoActionPlatformStrategyApi r1 = AOPlatformTools.INSTANCE.platformStrategy();
        Boolean r4 = null;
        if (r1 == null) goto L17;
        IAutoActionPlatformStrategyApi.SensitiveOpStrategy r2 = r1.checkSensitiveOp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), SensitiveOperation.ACCESS_FOR_COARSE_LOCATION);
    L18:
        boolean r5 = false;
        if (r2 != null) goto L21;
    L23:
        if (r5 == true) goto L29;
        Loog r111 = Loog.INSTANCE;
        StringBuilder r112 = new StringBuilder().append("getLocation failed, isAllowed: ");
        if (r2 == null) goto L27;
        r4 = d.c.b.a.b.a(r2.isAllowed());
    L27:
        r111.d(TAG, r112.append(r4).toString());
        return SensitiveType.UNKNOWN;
    L29:
        IAutoActionLocationApi r7 = AOPlatformTools.INSTANCE.location();
        if (r7 != null) goto L33;
        m r113 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "getLocation failed, locationApi is null");
        return SensitiveType.UNKNOWN;
    L33:
        r6.f23792a = SensitiveType.UNKNOWN;
        r6.f23795d = 1;
        Object r114 = IAutoActionLocationApi.DefaultImpls.acquireCoarseLocation$default(r7, r3, false, false, r6, 6, null);
        if (r114 != r17) goto L36;
        return r17;
    L36:
        r16 = r114;
        r11 = SensitiveType.UNKNOWN;
        goto L37
    L21:
        if (r2.isAllowed() != true) goto L23;
        r5 = true;
        goto L23
    L17:
        r2 = null;
    L7:
        r15 = new b(this, r14);
        goto L8
    }
}
