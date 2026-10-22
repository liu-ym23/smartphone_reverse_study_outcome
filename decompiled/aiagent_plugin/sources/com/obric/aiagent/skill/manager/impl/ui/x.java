package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.da;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillCreateFlowController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20846a = null;
    private static final bb q = null;
    private static final com.obric.aiagent.skill.manager.api.o r = null;
    private static final com.obric.aiagent.skill.manager.api.o s = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f20847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<ISkillManagerService> f20848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.am f20849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.am f20850e;
    private final d.h.a.b<String, d.x> f;
    private OSheet g;
    private d.h.a.a<d.x> h;
    private OSimpleFormDialog i;
    private com.obric.aiagent.skill.manager.impl.cf j;
    private b k;
    private long l;
    private final com.obric.aiagent.skill.manager.impl.au m;
    private final az n;
    private final ai o;
    private final v p;

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f20851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f20852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final bc f20853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicReference<c> f20854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private kotlinx.coroutines.ca f20855e;
        private StatusDialog f;
        private OAlertDialog g;
        private kotlinx.coroutines.w<d.x> h;
        private d.h.a.a<d.x> i;
        private d.h.a.a<d.x> j;

        public b(long r3, d r5, bc r6) {
            bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r6, bc.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "type");
            d.h.b.o.e(r7, "submission");
            this.f20851a = r3;
            this.f20852b = r5;
            this.f20853c = r7;
            this.f20854d = new AtomicReference(c.f20856a);
        }

        public final long a() {
            return this.f20851a;
        }

        public final d getType() {
            return this.f20852b;
        }

        public final bc b() {
            return this.f20853c;
        }

        public final AtomicReference<c> c() {
            return this.f20854d;
        }

        public final void a(kotlinx.coroutines.ca r3) {
            this.f20855e = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
        }

        public final kotlinx.coroutines.ca d() {
            return this.f20855e;
        }

        public final void a(StatusDialog r1) {
            this.f = r1;
        }

        public final StatusDialog e() {
            return this.f;
        }

        public final void a(OAlertDialog r1) {
            this.g = r1;
        }

        public final OAlertDialog f() {
            return this.g;
        }

        public final void a(kotlinx.coroutines.w<d.x> r3) {
            this.h = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        }

        public final kotlinx.coroutines.w<d.x> g() {
            return this.h;
        }

        public final void a(d.h.a.a<d.x> r3) {
            this.i = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        public final void b(d.h.a.a<d.x> r3) {
            this.j = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20856a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f20857b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f20858c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f20859d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f20860e = null;
        public static final c f = null;
        private static final /* synthetic */ c[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f20856a, f20857b, f20858c, f20859d, f20860e, f};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20856a = new c("ACTIVE", 0);
            f20857b = new c("CONFIRMING_STOP", 1);
            f20858c = new c("SUCCEEDED", 2);
            f20859d = new c("FAILED", 3);
            f20860e = new c("CANCELLED", 4);
            f = new c("FINISHED", 5);
            c[] r0 = a();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f20861a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f20862b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ d[] f20863c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f20864d = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f20861a, f20862b};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20861a = new d("CREATE", 0);
            f20862b = new d("IMPORT", 1);
            d[] r0 = a();
            f20863c = r0;
            f20864d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f20863c.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f20866b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20865a, r6.f20865a) == true) goto L12;
            return false;
        L12:
            if (this.f20866b == r6.f20866b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20865a.hashCode() * 31) + Boolean.hashCode(this.f20866b);
        }

        public String toString() {
            return "ImportTextPreview(text=" + this.f20865a + ", truncated=" + this.f20866b + ')';
        }

        public e(String r2, boolean r3) {
            d.h.b.o.e(r2, "text");
            this.f20865a = r2;
            this.f20866b = r3;
        }

        public final String a() {
            return this.f20865a;
        }

        public final boolean b() {
            return this.f20866b;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20867a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20868b = null;

        static {
            int[] r0 = new int[aj.values().length];
            r0[aj.f20529b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L30:
            r0[aj.f20530c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L38:
            r0[aj.f20531d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            f20867a = r0;
            int[] r1 = new int[c.values().length];
            r1[c.f20856a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            r1[c.f20857b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L40:
            r1[c.f20858c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L26:
            r1[c.f20859d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            r1[c.f20860e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L28:
            r1[c.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L15:
            f20868b = r1;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$failGeneration$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f20870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f20871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<b, com.obric.aiagent.skill.manager.api.u.a, d.x> f20872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.u.a f20873e;

        g(x r3, b r4, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.u.a, d.x> r5, com.obric.aiagent.skill.manager.api.u.a r6, d.c.d<? super g> r7) {
            d.h.a.m<b, com.obric.aiagent.skill.manager.api.u.a, d.x> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20870b = r3;
            this.f20871c = r4;
            this.f20872d = r8;
            this.f20873e = r6;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f20870b, this.f20871c, this.f20872d, this.f20873e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f20869a != 0) goto L10;
            d.o.a(r2);
            b r3 = x.c(this.f20870b);
            b r0 = this.f20871c;
            if (r3 != r0) goto L8;
            this.f20872d.invoke(r0, this.f20873e);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.m<aj, at, d.x> {
        h(Object r8) {
            super(2, r8, x.class, "handleFileStateChanged", "handleFileStateChanged(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Lcom/obric/aiagent/skill/manager/impl/ui/SkillFormFileState;)V", 0);
        }

        public final void a(aj r3, at r4) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(aj r3, at r4) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.impl.cf, d.x> {
        i(Object r8) {
            super(1, r8, x.class, "handleImportPackageReady", "handleImportPackageReady(Lcom/obric/aiagent/skill/manager/impl/SkillImportDraft;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.impl.cf r3) {
            d.h.b.o.e(r3, "p0");
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.impl.cf r3) {
            a((com.obric.aiagent.skill.manager.impl.cf) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.cf.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class j extends d.h.b.l implements d.h.a.m<aj, com.obric.aiagent.skill.manager.impl.cb, d.x> {
        j(Object r8) {
            super(2, r8, x.class, "handleFormFileReady", "handleFormFileReady(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Lcom/obric/aiagent/skill/manager/impl/SkillFormDraft;)V", 0);
        }

        public final void a(aj r3, com.obric.aiagent.skill.manager.impl.cb r4) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(aj r3, com.obric.aiagent.skill.manager.impl.cb r4) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (com.obric.aiagent.skill.manager.impl.cb) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.impl.cb.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.q<aj, String, Throwable, d.x> {
        k(Object r8) {
            super(3, r8, x.class, "handleFileFailure", "handleFileFailure(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
        }

        public final void a(aj r3, String r4, Throwable r5) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r5, "p2");
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(aj r3, String r4, Throwable r5) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.q<bb, String, bc, d.x> {
        l(Object r8) {
            super(3, r8, x.class, "submitCreateSkillForm", "submitCreateSkillForm(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFormSnapshot;Ljava/lang/String;Lcom/obric/aiagent/skill/manager/impl/ui/SkillFormSubmission;)V", 0);
        }

        public final void a(bb r3, String r4, bc r5) {
            bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r6, "p2");
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3, r4, r6);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(bb r3, String r4, bc r5) {
            a((bb) ZeusTransformUtils.preCheckCast(r3, bb.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (bc) ZeusTransformUtils.preCheckCast(r5, bc.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class m extends d.h.b.l implements d.h.a.a<d.x> {
        m(Object r8) {
            super(0, r8, x.class, "showImportSkillLinkDialog", "showImportSkillLinkDialog()V", 0);
        }

        public final void a() {
            x.d((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class n extends d.h.b.l implements d.h.a.a<d.x> {
        n(Object r8) {
            super(0, r8, x.class, "showCreateSkillFormSheet", "showCreateSkillFormSheet()V", 0);
        }

        public final void a() {
            x.e((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    /* synthetic */ class o extends d.h.b.l implements d.h.a.a<d.x> {
        o(Object r8) {
            super(0, r8, x.class, "completeImportSkillLink", "completeImportSkillLink()V", 0);
        }

        public final void a() {
            x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$startGeneration$1$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f20875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f20876c;

        p(x r3, b r4, d.c.d<? super p> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20875b = r3;
            this.f20876c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f20875b, this.f20876c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f20874a != 0) goto L7;
            d.o.a(r2);
            x.a(this.f20875b, this.f20876c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {704}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$startGeneration$job$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>>, Object> f20878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f20879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f20880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<b, com.obric.aiagent.skill.manager.api.u.a, d.x> f20881e;
        final /* synthetic */ d.h.a.m<b, com.obric.aiagent.skill.manager.api.e, d.x> f;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.x$q$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillCreateFlowController.kt */
        @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$startGeneration$job$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20882a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f20883b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f20884c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ d.h.a.m<b, com.obric.aiagent.skill.manager.api.e, d.x> f20885d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> f20886e;

            AnonymousClass1(x r3, b r4, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.e, d.x> r5, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r6, d.c.d<? super AnonymousClass1> r7) {
                d.h.a.m<b, com.obric.aiagent.skill.manager.api.e, d.x> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r9 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20883b = r3;
                this.f20884c = r4;
                this.f20885d = r8;
                this.f20886e = r9;
                super(2, r10);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20883b, this.f20884c, this.f20885d, this.f20886e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20882a != 0) goto L10;
                d.o.a(r4);
                b r5 = x.c(this.f20883b);
                b r0 = this.f20884c;
                if (r5 != r0) goto L8;
                this.f20885d.invoke(r0, (com.obric.aiagent.skill.manager.api.e) ((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(this.f20886e, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a());
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        q(d.h.a.b<? super d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>>, ? extends Object> r3, b r4, x r5, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.u.a, d.x> r6, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.e, d.x> r7, d.c.d<? super q> r8) {
            d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>>, Object> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.a.m<b, com.obric.aiagent.skill.manager.api.u.a, d.x> r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.h.a.m<b, com.obric.aiagent.skill.manager.api.e, d.x> r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20878b = r9;
            this.f20879c = r4;
            this.f20880d = r5;
            this.f20881e = r10;
            this.f = r11;
            super(2, r12);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f20878b, this.f20879c, this.f20880d, this.f20881e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f20877a;
            if (r2 == 0) goto L13;
            if (r2 != 1) goto L12;
            d.o.a(r17);     // Catch: Exception -> L7 CancellationException -> L9
            Object r3 = r17;
        L17:
            com.obric.aiagent.skill.manager.api.u r9 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L21;
            this.f20879c.c().set(c.f20858c);     // Catch: Exception -> L7 CancellationException -> L9
            kotlinx.coroutines.i.a(x.b(this.f20880d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20880d, this.f20879c, this.f, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L7 CancellationException -> L9
        L27:
            return d.x.f38692a;
        L21:
            if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L24;
            x.a(this.f20880d, this.f20879c, (com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"), this.f20881e);     // Catch: Exception -> L7 CancellationException -> L9
            goto L27
        L24:
            throw new d.k();     // Catch: Exception -> L7 CancellationException -> L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r17);
            d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>>, Object> r4 = this.f20878b;     // Catch: Exception -> L7 CancellationException -> L9
            this.f20877a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r3 = r4.invoke(this);     // Catch: Exception -> L7 CancellationException -> L9
            if (r3 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            ee.f19808a.a("SkillManager", "Skill generation failed", "Skill generation failed id=" + this.f20879c.a() + " type=" + this.f20879c.getType(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            x.a(this.f20880d, this.f20879c, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.q, false, "ui_generation_failed", null, 10, null), this.f20881e);
            goto L27
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {570}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$submitCreateSkillForm$1")
    static final class r extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bb f20888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f20890d;

        r(bb r3, ISkillManagerService r4, String r5, d.c.d<? super r> r6) {
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20888b = r3;
            this.f20889c = r7;
            this.f20890d = r5;
            super(1, r8);
        }

        public final Object a(d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r3) {
            return ((r) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f20888b, this.f20889c, this.f20890d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20887a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            a("SkillManager", "Create skill submit started: nameLength=" + this.f20888b.a().length() + ", bodyLength=" + this.f20888b.c().length());
            ISkillManagerService r9 = this.f20889c;
            com.obric.aiagent.skill.manager.api.m r2 = new com.obric.aiagent.skill.manager.api.m(this.f20888b.a(), this.f20888b.b(), this.f20888b.c(), this.f20890d);
            com.obric.aiagent.skill.manager.api.o r3 = x.c();
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20887a = 1;
            r8 = r9.createSkill(r2, r3, r4);
            if (r8 != r0) goto L11;
            return r0;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    /* JADX INFO: compiled from: SkillCreateFlowController.kt */
    @d.c.b.a.f(b = "SkillCreateFlowController.kt", c = {636}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCreateFlowController$submitImportSkillForm$1")
    static final class s extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bb f20892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.impl.cf f20893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f20895e;

        s(bb r3, com.obric.aiagent.skill.manager.impl.cf r4, ISkillManagerService r5, String r6, d.c.d<? super s> r7) {
            ISkillManagerService r8 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20892b = r3;
            this.f20893c = r4;
            this.f20894d = r8;
            this.f20895e = r6;
            super(1, r9);
        }

        public final Object a(d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r3) {
            return ((s) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f20892b, this.f20893c, this.f20894d, this.f20895e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20891a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            ee.f19808a.b("SkillManager", "Import skill submit started nameLength=" + this.f20892b.a().length() + ", bodyLength=" + this.f20893c.d().c().length() + ", previewLength=" + this.f20892b.c().length(), "Import skill submit started: fileName=" + this.f20893c.a() + ", nameLength=" + this.f20892b.a().length() + ", bodyLength=" + this.f20893c.d().c().length() + ", previewLength=" + this.f20892b.c().length());
            ISkillManagerService r12 = this.f20894d;
            com.obric.aiagent.skill.manager.api.d r2 = new com.obric.aiagent.skill.manager.api.d(this.f20893c.b(), this.f20895e, false, null, 12, null);
            com.obric.aiagent.skill.manager.api.o r3 = x.d();
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20891a = 1;
            r11 = r12.importSkill(r2, r3, r4);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$-b3Bzi30-Uz79SLUldyur5kWgcY, reason: not valid java name */
    public static /* synthetic */ d.x m348lambda$b3Bzi30Uz79SLUldyur5kWgcY(String r0) {
        return a(r0);
    }

    public static /* synthetic */ d.x lambda$0KAxUeLt75AR2WIkRochmBLmYDw(x r0, b r1, bc r2, com.obric.aiagent.skill.manager.api.u.a r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$1ieEGslB6yHkKzSBYBXSPpFgdAA(com.obric.aiagent.skill.manager.impl.cf r0, bc r1, x r2, b r3, com.obric.aiagent.skill.manager.api.u.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ d.x lambda$3QghwKAv1KVUmfumUETF8jfYNMw(x r0) {
        return g(r0);
    }

    public static /* synthetic */ d.x lambda$4KAT2fgIS23qhYLoYFVXSwb4NH0(x r0) {
        return j(r0);
    }

    public static /* synthetic */ void lambda$5znCshaBbMbewe6jqNGKR6sTs28(x r0, OSheet r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$6L0GyuztxkBlxVnSmY7MVlxazSg(x r0, d.h.b.z.f r1, d.h.a.a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$9tuijD_InXmQVB3chkBlamFiFr8(x r0) {
        return o(r0);
    }

    public static /* synthetic */ void lambda$Cp8dh0o_GvDUAjt7A0VJn8k0Jeg(x r0, OSimpleFormDialog r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Ed6mH1xAKSg-BnrfkZtz6D2vNiQ, reason: not valid java name */
    public static /* synthetic */ d.x m349lambda$Ed6mH1xAKSgBnrfkZtz6D2vNiQ(x r0, b r1, com.obric.aiagent.skill.manager.api.u.a r2, com.obric.aiagent.skill.manager.impl.cf r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$EoVMTUmCrgEr__dpj68RDFbvh_I(x r0) {
        return i(r0);
    }

    public static /* synthetic */ d.x lambda$EtS5InnAoNV3xXBJ0IB3uRMyT88(Throwable r0) {
        return a(r0);
    }

    public static /* synthetic */ d.x lambda$FTDde0ReU044dOjW2yiqAQszEp4(x r0, b r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$H-icP_vV__bHR_KYGzYKXzHVID0, reason: not valid java name */
    public static /* synthetic */ d.x m350lambda$HicP_vV__bHR_KYGzYKXzHVID0(x r0) {
        return l(r0);
    }

    public static /* synthetic */ d.x lambda$HLElyWdlyeabM7Q980zKVr1XqBA(x r0, com.obric.aiagent.skill.manager.impl.cf r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ d.x lambda$IDzv64hXbWXgRQZrWC9dXasiByI(x r0, String r1, com.obric.aiagent.skill.manager.impl.cf r2, b r3, com.obric.aiagent.skill.manager.api.e r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ d.x lambda$Is1Q6_CqTHSWfI0Nda6WphD4ulw(x r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$Jcz_GCahoMBK2xqCw-EdpbVyCZ0, reason: not valid java name */
    public static /* synthetic */ d.x m351lambda$Jcz_GCahoMBK2xqCwEdpbVyCZ0(x r0) {
        return f(r0);
    }

    public static /* synthetic */ d.x lambda$MNFt96VKE2cd4EWEZGHgYh0yj7Y(x r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$MmOK71KFtodrfwyv_0oO30x_HjE(x r0, com.obric.aiagent.skill.manager.impl.cf r1, bb r2, String r3, bc r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$PrgYjlGSU1r5tOmPAYck9sOyyRc(x r0, d.h.b.z.f r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$QE2w6UmrUb8l3ISwf6x9n_ZGgqQ(x r0, String r1, b r2, com.obric.aiagent.skill.manager.api.e r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$RDnER6SuivdruDeH_YWyGgOdzF4(x r0, b r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ d.x lambda$Sv9NORFVHzWlc6ppqAUghNyxJOY(b r0, x r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$WtgPyPT6PKN4bEf1BMHiEjPoNrk(x r0) {
        return k(r0);
    }

    public static /* synthetic */ d.x lambda$XfC4XCpdvVqFhYqM3d0D7PY_eMk(x r0) {
        return q(r0);
    }

    public static /* synthetic */ d.x lambda$YDp2_RXNTeToOXYvRQDsOUngHvk(x r0) {
        return m(r0);
    }

    /* JADX INFO: renamed from: lambda$_2sa8-oYZhP2o9_Fd0p6GRpyAKg, reason: not valid java name */
    public static /* synthetic */ d.x m352lambda$_2sa8oYZhP2o9_Fd0p6GRpyAKg(b r0, d.h.a.a r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cRXNTnU6lDtqraGHQOmMT_-BkH4, reason: not valid java name */
    public static /* synthetic */ d.x m353lambda$cRXNTnU6lDtqraGHQOmMT_BkH4(x r0, b r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ void lambda$cRmM9oKCKVwUFrl4WQQB2aBULnY(OSheet r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$dQ6aSHjXOtBm73laNBALOHCeW8k() {
        return i();
    }

    public static /* synthetic */ d.x lambda$hSdWdRTq2iXwT3aIKQRo_ISWBkc(x r0, bc r1, b r2, com.obric.aiagent.skill.manager.api.u.a r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$j9y324-Rb-pl2TNvCqaBgYhygAI, reason: not valid java name */
    public static /* synthetic */ void m354lambda$j9y324Rbpl2TNvCqaBgYhygAI(x r0, d.h.b.z.f r1, View r2) {
        c(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$mNETPqXkaej29FM94M8Y9AWj1NE(x r0, b r1, String r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$rfg2ExdT2w3yHG_feyaBoP4AFXs(x r0) {
        return n(r0);
    }

    public static /* synthetic */ d.x lambda$ttMbmWffVeYeQZD6_9zfj6tstYw(x r0) {
        return p(r0);
    }

    public static /* synthetic */ void lambda$uyQ6pbIFUvnx2NmdbjR_COEcuN8(x r0, d.h.b.z.f r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$v4I-D6OEqiszo5ZO3lk_LuYIiHE, reason: not valid java name */
    public static /* synthetic */ d.x m355lambda$v4ID6OEqiszo5ZO3lk_LuYIiHE(x r0, OInputLayout r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$yn-yAGmAVmz6Ix_2Af_H2NuBicM, reason: not valid java name */
    public static /* synthetic */ d.x m356lambda$ynyAGmAVmz6Ix_2Af_H2NuBicM(com.obric.aiagent.skill.manager.impl.cb r0, Throwable r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$zf7Cbt9CcshUSIvtRV8NXlqQ4Tk(x r0, b r1, com.obric.aiagent.skill.manager.api.u.a r2, com.obric.aiagent.skill.manager.impl.cf r3) {
        return a(r0, r1, r2, r3);
    }

    public x(FragmentActivity r20, d.h.a.a<? extends ISkillManagerService> r21, kotlinx.coroutines.am r22, kotlinx.coroutines.am r23, d.h.a.b<? super String, d.x> r24) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r20, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a<ISkillManagerService> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r15 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r22, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r14 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r23, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "activity");
        d.h.b.o.e(r3, "skillManagerProvider");
        d.h.b.o.e(r15, "ioScope");
        d.h.b.o.e(r14, "mainScope");
        d.h.b.o.e(r4, "onSkillCreated");
        this.f20847b = r1;
        this.f20848c = r3;
        this.f20849d = r15;
        this.f20850e = r14;
        this.f = r4;
        com.obric.aiagent.skill.manager.impl.au r13 = com.obric.aiagent.skill.manager.impl.au.f19522a.a((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin"));
        this.m = r13;
        this.n = new az(r1, null, 2, null);
        this.o = new ai(r1, r15, r14, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.preCheckCast(new k(this), d.h.a.q.class, "com.obric.aiagent.plugin"), null, null, 384, null);
        this.p = new v(r1, r13, r15, r14, new $$Lambda$x$MNFt96VKE2cd4EWEZGHgYh0yj7Y(this), $$Lambda$x$EtS5InnAoNV3xXBJ0IB3uRMyT88.INSTANCE, null, null, 192, null);
    }

    public static final /* synthetic */ void a(x r0) {
        r0.f();
    }

    public static final /* synthetic */ void a(x r0, com.obric.aiagent.skill.manager.impl.cf r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(x r0, aj r1, com.obric.aiagent.skill.manager.impl.cb r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(x r0, aj r1, at r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(x r0, aj r1, String r2, Throwable r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(x r2, bb r3, String r4, bc r5) {
        r2.a(r3, r4, (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(x r0, b r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(x r2, b r3, com.obric.aiagent.skill.manager.api.u.a r4, d.h.a.m r5) {
        r2.a(r3, r4, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.am b(x r0) {
        return r0.f20850e;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.o c() {
        return r;
    }

    public static final /* synthetic */ b c(x r0) {
        return r0.k;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.o d() {
        return s;
    }

    public static final /* synthetic */ void d(x r0) {
        r0.e();
    }

    public static final /* synthetic */ void e(x r0) {
        r0.g();
    }

    private static final d.x a(x r1, String r2) {
        d.h.b.o.e(r2, "coverUrl");
        r1.n.a(r2);
        return d.x.f38692a;
    }

    private static final d.x a(Throwable r3) {
        d.h.b.o.e(r3, "throwable");
        ee.f19808a.a("SkillManager", "Skill cover import failed", "Skill cover import failed", r3);
        return d.x.f38692a;
    }

    public final void a() {
        h();
        this.p.c();
        this.o.a();
        this.n.a();
        this.h = null;
        a(true);
        OSheet r1 = this.g;
        this.g = null;
        if (r1 == null) goto L5;
        r1.dismiss();
    L5:
        com.obric.aiagent.skill.manager.impl.cf r2 = this.j;
        if (r2 == null) goto L8;
        r2.e();
    L8:
        this.j = null;
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [T, com.obric.oui.sheet.v2.OSheet, java.lang.Object] */
    public final void b() {
        this.h = null;
        OSheet r2 = this.g;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        View r1 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.f20847b, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.sheet_skill_create_method, "layout", "sheet_skill_create_method"), null, false, "com.obric.aiagent.plugin");
        final d.h.b.z.f r3 = new d.h.b.z.f();
        com.obric.aiagent.skill.manager.api.al r4 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        boolean r6 = com.obric.aiagent.skill.manager.impl.bs.f19588a.b(r4);
        boolean r7 = com.obric.aiagent.skill.manager.impl.bs.f19588a.a(r4);
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.create_skill_method_import_file, DbHelper.COL_ID, "create_skill_method_import_file")), OCardListItem.class, "com.obric.aiagent.plugin");
        OCardListItem r10 = (OCardListItem) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.create_skill_method_import_link, DbHelper.COL_ID, "create_skill_method_import_link")), OCardListItem.class, "com.obric.aiagent.plugin");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.create_skill_method_custom, DbHelper.COL_ID, "create_skill_method_custom")), OCardListItem.class, "com.obric.aiagent.plugin");
        int r11 = 8;
        if (r6 == false) goto L8;
        int r12 = 0;
    L9:
        r8.setVisibility(r12);
        if (r6 == true) goto L12;
    L14:
        int r5 = 8;
    L15:
        r10.setVisibility(r5);
        if (r7 == false) goto L18;
        r11 = 0;
    L18:
        r9.setVisibility(r11);
        a(d.a.p.b(new OCardListItem[]{r8, r10, r9}));
        r8.setOnContentClickListener(new $$Lambda$x$uyQ6pbIFUvnx2NmdbjR_COEcuN8(this, r3));
        r10.setOnContentClickListener(new $$Lambda$x$PrgYjlGSU1r5tOmPAYck9sOyyRc(this, r3));
        r9.setOnContentClickListener(new $$Lambda$x$j9y324Rbpl2TNvCqaBgYhygAI(this, r3));
        final ?? r13 = new OSheet((Context) ZeusTransformUtils.preCheckCast(this.f20847b, Context.class, "com.obric.aiagent.plugin"), 0, 0, false, false, 30, null);
        r13.setHeightMode(OSheet.c.f36216b);
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36213d, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_create_method_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_create_method_title")), null, null, null, false, null, new $$Lambda$x$cRmM9oKCKVwUFrl4WQQB2aBULnY(r13), null, null, null, null, null, null, 16156, null);
        r13.setBodyView(r1);
        r13.setCanceledOnTouchOutside(true);
        r13.setOnDismissListener(new $$Lambda$x$5znCshaBbMbewe6jqNGKR6sTs28(this, r13));
        r3.f38504a = r13;
        this.g = (OSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OSheet.class, "com.obric.aiagent.plugin");
        bh.a((OSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OSheet.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (r4.z() == false) goto L14;
        r5 = 0;
        goto L15
    L8:
        r12 = 8;
        goto L9
    }

    private static final void a(final x r2, final d.h.b.z.f r3, View r4) {
        b("SkillManager", "Create method selected: import_file");
        r2.o.a(aj.f20529b, new $$Lambda$x$6L0GyuztxkBlxVnSmY7MVlxazSg(r2, r3));
    }

    private static final d.x a(x r2, d.h.b.z.f r3, d.h.a.a r4) {
        d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "openPicker");
        r2.a((OSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OSheet.class, "com.obric.aiagent.plugin"), r5);
        return d.x.f38692a;
    }

    private static final void b(x r2, d.h.b.z.f r3, View r4) {
        b("SkillManager", "Create method selected: import_link");
        if (a(r2, null, 1, null) == null) goto L6;
        r2.a((OSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OSheet.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new m(r2), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void c(x r2, d.h.b.z.f r3, View r4) {
        b("SkillManager", "Create method selected: custom");
        r2.h = (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(r2), d.h.a.a.class, "com.obric.aiagent.plugin");
        OSheet r5 = (OSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OSheet.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.dismiss();
        return;
    }

    private static final void a(OSheet r0, View r1) {
        r0.dismiss();
    }

    private static final void a(x r2, OSheet r3, DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r2.g != r3) goto L8;
        r2.g = null;
        d.h.a.a<d.x> r6 = r2.h;
        r2.h = null;
        if (r6 == null) goto L9;
        r6.invoke();
        return;
    L9:
        return;
    }

    private final void a(List<? extends OCardListItem> r9) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r8.iterator();
    L3:
        boolean r2 = true;
        if (r11.hasNext() == false) goto L11;
        Object r1 = r11.next();
        if (((OCardListItem) ZeusTransformUtils.preCheckCast(r1, OCardListItem.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L3;
        r10.add(r1);
        goto L3
    L11:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L13:
        if (r13.hasNext() == false) goto L27;
        Object r4 = r13.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L17;
        d.a.p.c();
    L17:
        OCardListItem r6 = (OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.aiagent.plugin");
        if (r12.size() != 1) goto L20;
        int r7 = 0;
    L26:
        OCardListItem.setCardPosition$default(r6, r7, false, 2, null);
        r3 = r5;
        goto L13
    L20:
        if (r3 != 0) goto L23;
        r7 = 1;
        goto L26
    L23:
        if (r3 != d.a.p.b(r12)) goto L25;
        r7 = 3;
        goto L26
    L25:
        r7 = 2;
        goto L26
    }

    private final void e() {
        a(this, false, 1, null);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(this.f20847b, Context.class, "com.obric.aiagent.plugin");
        String r6 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_import_link_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_import_link_dialog_title"));
        d.h.b.o.c(r6, "getString(...)");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        OSimpleFormDialog.b r17 = new OSimpleFormDialog.b(true, false, new $$Lambda$x$v4ID6OEqiszo5ZO3lk_LuYIiHE(this), 2, null);
        OSimpleFormDialog.b r11 = new OSimpleFormDialog.b(false, false, null, 6, null);
        String r7 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_import_link_dialog_complete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_import_link_dialog_complete"));
        d.h.b.o.c(r7, "getString(...)");
        OBaseDialog.a r12 = new OBaseDialog.a(r7, (d.h.a.a) ZeusTransformUtils.preCheckCast(new o(this), d.h.a.a.class, "com.obric.aiagent.plugin"), null, 4, null);
        String r8 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_cancel"));
        d.h.b.o.c(r8, "getString(...)");
        final OSimpleFormDialog r2 = new OSimpleFormDialog(r3, new OSimpleFormDialog.c(r9, r10, r17, r11, r12, new OBaseDialog.a(r8, new $$Lambda$x$Jcz_GCahoMBK2xqCwEdpbVyCZ0(this), null, 4, null)));
        r2.setAutoDismiss(false);
        r2.getPositiveButton().setEnabled(false);
        OInputLayout r1 = r2.getInputView1();
        if (r1 == null) goto L7;
        OEditText r4 = r1.getVInput();
        if (r4 == null) goto L7;
        r4.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new SkillCreateFlowController$showImportSkillLinkDialog$dialog$4$1(r2), TextWatcher.class, "com.obric.aiagent.plugin"));
    L7:
        r2.setOnDismissListener(new $$Lambda$x$Cp8dh0o_GvDUAjt7A0VJn8k0Jeg(this, r2));
        this.i = r2;
        r2.show();
    }

    private static final d.x a(x r3, OInputLayout r4) {
        d.h.b.o.e(r4, "inputLayout");
        r4.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r3.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_import_link_dialog_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_import_link_dialog_hint")), CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setInputType(17);
        return d.x.f38692a;
    }

    private static final d.x f(x r3) {
        a(r3, false, 1, null);
        return d.x.f38692a;
    }

    private static final void a(x r2, OSimpleFormDialog r3, DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r2.i != r3) goto L6;
        r2.i = null;
        return;
    }

    private final void f() {
        OSimpleFormDialog r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        OInputLayout r1 = r0.getInputView1();
        if (r1 == null) goto L12;
        CharSequence r2 = r1.getText();
        if (r2 == null) goto L12;
        String r3 = r2.toString();
        if (r3 == null) goto L12;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L13:
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        r0.getPositiveButton().setEnabled(false);
        return;
    L22:
        ISkillManagerService r9 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(this.f20848c.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r6 = a(r9);
        if (r6 != null) goto L26;
        return;
    L26:
        if (com.obric.aiagent.skill.manager.impl.ui.r.f20808a.a((Context) ZeusTransformUtils.preCheckCast(this.f20847b, Context.class, "com.obric.aiagent.plugin"), r9, r6.a(), this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_import_link_chat_prompt, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_import_link_chat_prompt"), new Object[]{r4}), $$Lambda$x$b3Bzi30Uz79SLUldyur5kWgcY.INSTANCE) == false) goto L29;
        com.obric.aiagent.skill.manager.impl.u.f20167a.a(r4);
        a(this, false, 1, null);
        return;
    L29:
        return;
    L18:
        r5 = false;
    L12:
        r4 = null;
        goto L13
    }

    private static final d.x a(String r3) {
        d.h.b.o.e(r3, "message");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        ee.f19808a.c("SkillManager", "Open Skill Installer chat failed", "Open Skill Installer chat failed: " + r3);
    L6:
        return d.x.f38692a;
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.e a(x r1, ISkillManagerService r2, int r3, Object r4) {
        ISkillManagerService r5 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r2, ISkillManagerService.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(r1.f20848c.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r5);
    }

    private final com.obric.aiagent.skill.manager.api.e a(ISkillManagerService r6) {
        ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r6, ISkillManagerService.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L16;
        com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r8 = r7.getInstalledSkills();
        if (r8 == null) goto L16;
        List r9 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r8), List.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L16;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        Object r2 = r10.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), "skill-installer") == false) goto L10;
    L15:
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    L17:
        if (r11 != null) goto L21;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20847b, Activity.class, "com.obric.aiagent.plugin"), cm.a.h);
        return null;
    L21:
        if (com.obric.aiagent.skill.manager.impl.az.a(r11) == false) goto L25;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20847b, Activity.class, "com.obric.aiagent.plugin"), cm.a.m);
        return null;
    L25:
        if (r11.l() == true) goto L28;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20847b, Activity.class, "com.obric.aiagent.plugin"), cm.a.i);
        return null;
    L28:
        return r11;
    L14:
        r2 = null;
    L16:
        r11 = null;
        goto L17
    }

    static /* synthetic */ void a(x r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    private final void a(boolean r3) {
        OSimpleFormDialog r0 = this.i;
        this.i = null;
        if (r3 == false) goto L6;
        if (r0 == null) goto L9;
        r0.originDismiss();
        return;
    L9:
        return;
    L6:
        if (r0 == null) goto L11;
        r0.dismiss();
        return;
    }

    private final void a(OSheet r3, d.h.a.a<d.x> r4) {
        d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L9:
        r5.invoke();
        return;
    L5:
        if (this.g != r3) goto L9;
        this.h = r5;
        r3.dismiss();
    }

    public final boolean a(int r2, int r3, Intent r4) {
        if (this.p.a(r2, r3, r4) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.o.a(r2, r3, r4) == true) goto L8;
        return false;
    }

    private final void a(aj r2, at r3) {
        int r4 = f.f20867a[r2.ordinal()];
        if (r4 != 1) goto L5;
        this.n.b(r3);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.n.a(r3);
        return;
    L7:
        if (r4 != 3) goto L10;
        return;
    L10:
        throw new d.k();
    }

    private final void a(com.obric.aiagent.skill.manager.impl.cf r14) {
        ao r0 = ao.f20546a.b();
        bg<bb> r1 = q.b(new com.obric.aiagent.skill.manager.impl.cb(r14.a(), r14.d().e(), r14.d().b(), r14.d().c()), r0);
        if (ZeusTransformUtils.instanceOf(r1, bg.a.class) == false) goto L6;
        r14.e();
        a(aj.f20529b, r14.a(), (Throwable) ZeusTransformUtils.preCheckCast(new be(((bg.a) ZeusTransformUtils.preCheckCast(r1, bg.a.class, "com.obric.aiagent.plugin")).a(), r0), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        d.h.b.o.a(r1, "null cannot be cast to non-null type com.obric.aiagent.skill.manager.impl.ui.SkillFormValidationResult.Valid<com.obric.aiagent.skill.manager.impl.ui.SkillFormSnapshot>");
        bb r2 = (bb) ZeusTransformUtils.preCheckCast(((bg.b) ZeusTransformUtils.preCheckCast(r1, bg.b.class, "com.obric.aiagent.plugin")).a(), bb.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.impl.cf r3 = com.obric.aiagent.skill.manager.impl.cf.a(r14, null, null, null, da.a(r14.d(), null, r2.b(), r2.c(), r2.a(), null, 17, null), 7, null);
        ee.f19808a.b("SkillManager", "Import file preview ready nameLength=" + r2.a().length(), "Import file preview ready: fileName=" + r14.a() + ", nameLength=" + r2.a().length());
        b(r3);
    }

    private final void a(aj r2, final com.obric.aiagent.skill.manager.impl.cb r3) {
        if (r2 == aj.f20530c) goto L5;
        return;
    L5:
        this.n.a(r3, new $$Lambda$x$ynyAGmAVmz6Ix_2Af_H2NuBicM(r3));
    }

    private static final d.x a(com.obric.aiagent.skill.manager.impl.cb r3, Throwable r4) {
        d.h.b.o.e(r4, "throwable");
        ee.f19808a.a("SkillManager", "Create form file validation failed", "Create form file validation failed: fileName=" + r3.a(), r4);
        return d.x.f38692a;
    }

    private final void a(aj r6, String r7, Throwable r8) {
        com.obric.aiagent.skill.manager.impl.bt r0 = com.obric.aiagent.skill.manager.impl.bv.a(r8);
        ee.f19808a.a("SkillManager", "Skill file parse failed target=" + r6 + " reason=" + r0.a(), "Skill file parse failed: target=" + r6 + ", fileName=" + r7 + ", reason=" + r0.a(), r8);
        int r9 = f.f20867a[r6.ordinal()];
        if (r9 != 1) goto L5;
        a(r7, r0);
        return;
    L5:
        if (r9 != 2) goto L7;
        return;
    L7:
        if (r9 != 3) goto L10;
        return;
    L10:
        throw new d.k();
    }

    private final void b(final com.obric.aiagent.skill.manager.impl.cf r24) {
        com.obric.aiagent.skill.manager.impl.cf r2 = this.j;
        this.j = r24;
        com.obric.aiagent.skill.manager.api.al r3 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        e r4 = a(r24.d().b(), r3.g());
        e r5 = a(r24.d().c(), r3.h());
        ax r7 = ax.f20583b;
        String r8 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_create, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_create"));
        d.h.b.o.c(r8, "getString(...)");
        bb r9 = new bb(r24.d().e(), r4.a(), r5.a());
        ao r10 = ao.f20546a.b();
        Integer r6 = Integer.valueOf(r3.g());
        ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        Integer r11 = null;
        if (r4.b() == true) goto L6;
        r6 = null;
    L6:
        Integer r12 = Integer.valueOf(r3.h());
        ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r5.b() == false) goto L9;
        r11 = r12;
    L9:
        ay r13 = new ay(r7, r8, r9, r10, new aw(r6, r11), new am(null, true, new $$Lambda$x$3QghwKAv1KVUmfumUETF8jfYNMw(this), 1, null), bd.f20630a.b(), (as) ZeusTransformUtils.preCheckCast(new as.b(aq.f20553a, av.f20576a, (at) ZeusTransformUtils.preCheckCast(new at.d(r24.a()), at.class, "com.obric.aiagent.plugin"), new $$Lambda$x$Is1Q6_CqTHSWfI0Nda6WphD4ulw(this), null, 16, null), as.class, "com.obric.aiagent.plugin"), ap.f20550b, false, new $$Lambda$x$EoVMTUmCrgEr__dpj68RDFbvh_I(this), new $$Lambda$x$HLElyWdlyeabM7Q980zKVr1XqBA(this, r24), new $$Lambda$x$MmOK71KFtodrfwyv_0oO30x_HjE(this, r24), 512, null);
        if (this.n.b(r13) == true) goto L12;
        this.n.a(r13);
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (d.h.b.o.a(r2.c(), r24.c()) == true) goto L18;
        r2.e();
        return;
    }

    private static final d.x g(x r0) {
        r0.p.a();
        return d.x.f38692a;
    }

    private static final d.x h(x r3) {
        ai.a(r3.o, aj.f20529b, null, 2, null);
        return d.x.f38692a;
    }

    private static final d.x i(x r1) {
        r1.o.a(aj.f20529b);
        return d.x.f38692a;
    }

    private static final d.x b(x r1, com.obric.aiagent.skill.manager.impl.cf r2) {
        r1.p.c();
        if (r1.j != r2) goto L6;
        r1.j = null;
        r2.e();
    L6:
        return d.x.f38692a;
    }

    private static final d.x a(x r2, com.obric.aiagent.skill.manager.impl.cf r3, bb r4, String r5, bc r6) {
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r6, bc.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "values");
        d.h.b.o.e(r5, "coverUrl");
        d.h.b.o.e(r7, "submission");
        r2.a(r4, r5, r3, r7);
        return d.x.f38692a;
    }

    static /* synthetic */ void a(x r0, String r1, com.obric.aiagent.skill.manager.impl.bt r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.j.f19602a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    L5:
        r0.a(r1, r2);
    }

    private final void a(String r24, com.obric.aiagent.skill.manager.impl.bt r25) {
        com.obric.aiagent.skill.manager.impl.cf r1 = this.j;
        this.j = null;
        ax r4 = ax.f20583b;
        String r5 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_create, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_create"));
        d.h.b.o.c(r5, "getString(...)");
        ay r2 = new ay(r4, r5, q, ao.f20546a.b(), null, new am(null, false, $$Lambda$x$dQ6aSHjXOtBm73laNBALOHCeW8k.INSTANCE, 1, null), bd.f20630a.b(), (as) ZeusTransformUtils.preCheckCast(new as.b(aq.f20553a, av.f20576a, (at) ZeusTransformUtils.preCheckCast(new at.a(r24, r25), at.class, "com.obric.aiagent.plugin"), new $$Lambda$x$4KAT2fgIS23qhYLoYFVXSwb4NH0(this), null, 16, null), as.class, "com.obric.aiagent.plugin"), ap.f20550b, false, new $$Lambda$x$WtgPyPT6PKN4bEf1BMHiEjPoNrk(this), new $$Lambda$x$HicP_vV__bHR_KYGzYKXzHVID0(this), null, 4624, null);
        if (this.n.b(r2) == true) goto L5;
        this.n.a(r2);
    L5:
        if (r1 == null) goto L8;
        r1.e();
        return;
    }

    private static final d.x i() {
        return d.x.f38692a;
    }

    private static final d.x j(x r3) {
        ai.a(r3.o, aj.f20529b, null, 2, null);
        return d.x.f38692a;
    }

    private static final d.x k(x r1) {
        r1.o.a(aj.f20529b);
        return d.x.f38692a;
    }

    private static final d.x l(x r0) {
        r0.p.c();
        return d.x.f38692a;
    }

    private final void g() {
        az r1 = this.n;
        ax r3 = ax.f20582a;
        String r4 = this.f20847b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_create, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_create"));
        d.h.b.o.c(r4, "getString(...)");
        r1.a(new ay(r3, r4, q, ao.f20546a.a(), null, new am(null, true, new $$Lambda$x$YDp2_RXNTeToOXYvRQDsOUngHvk(this), 1, null), bd.f20630a.a(), (as) ZeusTransformUtils.preCheckCast(new as.b(aq.f20554b, av.f20577b, (at) ZeusTransformUtils.preCheckCast(at.b.f20570a, at.class, "com.obric.aiagent.plugin"), new $$Lambda$x$rfg2ExdT2w3yHG_feyaBoP4AFXs(this), new $$Lambda$x$9tuijD_InXmQVB3chkBlamFiFr8(this)), as.class, "com.obric.aiagent.plugin"), null, false, new $$Lambda$x$ttMbmWffVeYeQZD6_9zfj6tstYw(this), new $$Lambda$x$XfC4XCpdvVqFhYqM3d0D7PY_eMk(this), (d.h.a.q) ZeusTransformUtils.preCheckCast(new l(this), d.h.a.q.class, "com.obric.aiagent.plugin"), 784, null));
    }

    private static final d.x m(x r0) {
        r0.p.a();
        return d.x.f38692a;
    }

    private static final d.x n(x r3) {
        ai.a(r3.o, aj.f20530c, null, 2, null);
        return d.x.f38692a;
    }

    private static final d.x o(x r1) {
        r1.o.a(aj.f20530c);
        return d.x.f38692a;
    }

    private static final d.x p(x r1) {
        r1.p.b();
        r1.o.a(aj.f20530c);
        return d.x.f38692a;
    }

    private static final d.x q(x r1) {
        r1.p.c();
        r1.o.a(aj.f20530c);
        return d.x.f38692a;
    }

    private final void a(bb r9, final String r10, bc r11) {
        final bc r3 = (bc) ZeusTransformUtils.wrapperContextForParams(r11, bc.class, "com.obric.aiagent.plugin");
        ISkillManagerService r12 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(this.f20848c.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L6;
        x r8 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");
        a("SkillManager", "Create skill form blocked: skillManager=null");
        r3.f();
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r8.f20847b, Activity.class, "com.obric.aiagent.plugin"), cm.a.k);
        return;
    L6:
        a(r3, d.f20861a, (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(r9, r12, r10, null), d.h.a.b.class, "com.obric.aiagent.plugin"), new $$Lambda$x$QE2w6UmrUb8l3ISwf6x9n_ZGgqQ(this, r10), new $$Lambda$x$hSdWdRTq2iXwT3aIKQRo_ISWBkc(this, r3));
    }

    private static final d.x a(x r3, String r4, b r5, com.obric.aiagent.skill.manager.api.e r6) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        d.h.b.o.e(r6, "created");
        r3.p.a(r4);
        ee.f19808a.b("SkillManager", "Create skill submit completed", "Create skill submit completed: slug=" + r6.a());
        r3.a(r5, r6.a());
        return d.x.f38692a;
    }

    private static final d.x a(final x r2, bc r3, final b r4, final com.obric.aiagent.skill.manager.api.u.a r5) {
        final bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, SensitiveType.SESSION);
        d.h.b.o.e(r5, "failure");
        a("SkillManager", "Create skill submit failed: code=" + r5.a());
        r2.a(r4, new $$Lambda$x$0KAxUeLt75AR2WIkRochmBLmYDw(r2, r4, r6, r5));
        return d.x.f38692a;
    }

    private static final d.x a(x r2, b r3, bc r4, com.obric.aiagent.skill.manager.api.u.a r5) {
        bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r4, bc.class, "com.obric.aiagent.plugin");
        r2.c(r3);
        r6.f();
        cm r7 = cm.f20758a;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r2.f20847b, Activity.class, "com.obric.aiagent.plugin");
        cm.a r9 = cl.a(r5);
        if (r9 != null) goto L5;
        r9 = cm.a.k;
    L5:
        r7.a(r8, r9);
        return d.x.f38692a;
    }

    private final void a(bb r11, final String r12, final com.obric.aiagent.skill.manager.impl.cf r13, bc r14) {
        final bc r3 = (bc) ZeusTransformUtils.wrapperContextForParams(r14, bc.class, "com.obric.aiagent.plugin");
        ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(this.f20848c.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        x r10 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");
        ee.f19808a.c("SkillManager", "Import skill form blocked: skillManager=null", "Import skill form blocked: skillManager=null, fileName=" + r13.a());
        r3.f();
        return;
    L6:
        a(r3, d.f20862b, (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(r11, r13, r7, r12, null), d.h.a.b.class, "com.obric.aiagent.plugin"), new $$Lambda$x$IDzv64hXbWXgRQZrWC9dXasiByI(this, r12, r13), new $$Lambda$x$1ieEGslB6yHkKzSBYBXSPpFgdAA(r13, r3, this));
    }

    private static final d.x a(x r2, String r3, com.obric.aiagent.skill.manager.impl.cf r4, b r5, com.obric.aiagent.skill.manager.api.e r6) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        d.h.b.o.e(r6, "imported");
        r2.p.a(r3);
        ee.f19808a.b("SkillManager", "Import skill submit completed", "Import skill submit completed: slug=" + r6.a() + ", fileName=" + r4.a());
        r2.a(r5, r6.a());
        return d.x.f38692a;
    }

    private static final d.x a(final com.obric.aiagent.skill.manager.impl.cf r4, bc r5, final x r6, final b r7, final com.obric.aiagent.skill.manager.api.u.a r8) {
        bc r9 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, SensitiveType.SESSION);
        d.h.b.o.e(r8, "failure");
        ee.f19808a.c("SkillManager", "Import skill submit failed code=" + r8.a(), "Import skill submit failed: fileName=" + r4.a() + ", code=" + r8.a());
        r9.a(new $$Lambda$x$Ed6mH1xAKSgBnrfkZtz6D2vNiQ(r6, r7, r8, r4));
        r9.d();
        return d.x.f38692a;
    }

    private static final d.x b(final x r1, final b r2, final com.obric.aiagent.skill.manager.api.u.a r3, final com.obric.aiagent.skill.manager.impl.cf r4) {
        r1.a(r2, new $$Lambda$x$zf7Cbt9CcshUSIvtRV8NXlqQ4Tk(r1, r2, r3, r4));
        return d.x.f38692a;
    }

    private static final d.x a(x r1, b r2, com.obric.aiagent.skill.manager.api.u.a r3, com.obric.aiagent.skill.manager.impl.cf r4) {
        r1.c(r2);
        cm.a r5 = cl.a(r3);
        if (r5 == null) goto L5;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r1.f20847b, Activity.class, "com.obric.aiagent.plugin"), r5);
    L7:
        return d.x.f38692a;
    L5:
        a(r1, r4.a(), null, 2, null);
        goto L7
    }

    private final void a(bc r17, d r18, d.h.a.b<? super d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>>, ? extends Object> r19, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.e, d.x> r20, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.u.a, d.x> r21) {
        bc r0 = (bc) ZeusTransformUtils.wrapperContextForParams(r17, bc.class, "com.obric.aiagent.plugin");
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.m.class, "com.obric.aiagent.plugin");
        if (this.k == null) goto L6;
        a("SkillManager", "Skill generation rejected: another session is active");
        r0.f();
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20847b, Activity.class, "com.obric.aiagent.plugin"), cm.a.k);
        return;
    L6:
        long r2 = this.l + 1;
        this.l = r2;
        final b r9 = new b(r2, r18, r0);
        this.k = r9;
        kotlinx.coroutines.ca r3 = kotlinx.coroutines.i.a(this.f20849d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r1, r9, this, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r9.a(r3);
        r3.a_(new $$Lambda$x$Sv9NORFVHzWlc6ppqAUghNyxJOY(r9, this));
    }

    private static final d.x a(b r7, x r8, Throwable r9) {
        if (r7.c().get() != c.f20860e) goto L6;
        kotlinx.coroutines.i.a(r8.f20850e, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L6:
        return d.x.f38692a;
    }

    private final void a(b r13, com.obric.aiagent.skill.manager.api.u.a r14, d.h.a.m<? super b, ? super com.obric.aiagent.skill.manager.api.u.a, d.x> r15) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.m.class, "com.obric.aiagent.plugin");
        if (r13.c().get() != c.f20860e) goto L5;
        return;
    L5:
        r13.c().set(c.f20859d);
        kotlinx.coroutines.i.a(this.f20850e, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r13, r5, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(b r2) {
        kotlinx.coroutines.w<d.x> r1 = r2.g();
        r2.a(null);
        if (r1 == null) goto L6;
        r1.a(d.x.f38692a);
        return;
    }

    private final void b(final b r3) {
        if (this.k == r3) goto L5;
        return;
    L5:
        r3.b().a(new $$Lambda$x$RDnER6SuivdruDeH_YWyGgOdzF4(this, r3));
        r3.b().d();
    }

    private static final d.x c(final x r1, final b r2) {
        r1.a(r2, new $$Lambda$x$cRXNTnU6lDtqraGHQOmMT_BkH4(r1, r2));
        return d.x.f38692a;
    }

    private static final d.x b(x r0, b r1) {
        r0.c(r1);
        return d.x.f38692a;
    }

    private final void a(final b r3, final String r4) {
        r3.b().a(new $$Lambda$x$mNETPqXkaej29FM94M8Y9AWj1NE(this, r3, r4));
        r3.b().d();
    }

    private static final d.x b(final x r1, final b r2, final String r3) {
        r1.a(r2, new $$Lambda$x$FTDde0ReU044dOjW2yiqAQszEp4(r1, r2, r3));
        return d.x.f38692a;
    }

    private static final d.x a(x r0, b r1, String r2) {
        r0.c(r1);
        r0.f.invoke(r2);
        return d.x.f38692a;
    }

    private final void a(final b r3, d.h.a.a<d.x> r4) {
        final d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        b(r3, new $$Lambda$x$_2sa8oYZhP2o9_Fd0p6GRpyAKg(r3, r5));
    }

    private static final d.x c(b r2, d.h.a.a r3) {
        d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        r2.a(r4);
        StatusDialog r0 = r2.e();
        if (r0 != null) goto L5;
    L8:
        r2.a(null);
        r4.invoke();
    L10:
        return d.x.f38692a;
    L5:
        if (r0.isShowing() == false) goto L8;
        r0.dismiss();
        goto L10
    }

    private final void b(b r2, d.h.a.a<d.x> r3) {
        d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        OAlertDialog r4 = r2.f();
        if (r4 != null) goto L5;
    L8:
        r2.b(null);
        r1.invoke();
        return;
    L5:
        if (r4.isShowing() == false) goto L8;
        r2.b(r1);
        r4.dismiss();
    }

    private final void c(b r4) {
        if (this.k != r4) goto L5;
        this.k = null;
    L5:
        r4.c().set(c.f);
        r4.a(null);
        r4.a(null);
        r4.a(null);
        a(r4);
        r4.a(null);
        r4.b(null);
    }

    private final void h() {
        b r0 = this.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (d(r0) == false) goto L10;
        a(r0);
        kotlinx.coroutines.ca r1 = r0.d();
        if (r1 == null) goto L10;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L10:
        r0.a(null);
        r0.b(null);
        OAlertDialog r2 = r0.f();
        r0.a(null);
        if (r2 == null) goto L13;
        r2.dismiss();
    L13:
        StatusDialog r3 = r0.e();
        r0.a(null);
        if (r3 == null) goto L16;
        r3.originDismiss();
    L16:
        this.k = null;
    }

    private final boolean d(b r3) {
    L2:
        c r2 = (c) ZeusTransformUtils.preCheckCast(r3.c().get(), c.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        int r0 = -1;
    L6:
        switch(r0) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L8;
        };
    L12:
        if (r3.c().compareAndSet(r2, c.f20860e) == false) goto L2;
        return true;
    L8:
        throw new d.k();
    L9:
        return false;
    L5:
        r0 = f.f20868b[r2.ordinal()];
        goto L6
    }

    static {
        f20846a = new a(null);
        q = new bb("", "", "");
        r = new com.obric.aiagent.skill.manager.api.o(com.obric.aiagent.skill.manager.api.p.g, null, 2, null);
        s = new com.obric.aiagent.skill.manager.api.o(com.obric.aiagent.skill.manager.api.p.f19294e, null, 2, null);
    }

    private final e a(String r2, int r3) {
        if (r2.length() <= r3) goto L5;
        if (r3 > 0) goto L8;
    L12:
        String r4 = r2.substring(0, r3);
        d.h.b.o.c(r4, "substring(...)");
        return new e(r4, true);
    L8:
        if (Character.isHighSurrogate(r2.charAt(r3 - 1)) == false) goto L12;
        if (Character.isLowSurrogate(r2.charAt(r3)) == false) goto L12;
        r3 = r3 - 1;
        goto L12
    L5:
        return new e(r2, false);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
