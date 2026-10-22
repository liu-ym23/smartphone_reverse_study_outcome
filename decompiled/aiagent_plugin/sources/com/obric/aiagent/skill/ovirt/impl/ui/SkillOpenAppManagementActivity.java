package com.obric.aiagent.skill.ovirt.impl.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.n;
import com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillOpenAppManagementActivity extends AppCompatActivity implements n {
    private static final a Companion = null;
    private static final long DEFAULT_SESSION_TTL_SECONDS = 1800;
    private static final String FLOW_CREATE_APP = "configCreateApp";
    private static final String FLOW_LOGIN = "login";
    private static final String SIDECAR_AUTH_ACTIVITY = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity";
    private static final String TAG = "SkillOpenAppManagement";
    private String activeSessionId;
    private ca authJob;
    private com.obric.aiagent.skill.ovirt.impl.b.c binding;
    private com.obric.aiagent.skill.credentials.api.g completedSessionEnv;
    private boolean createAppCompletedInActiveFlow;

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {BDAbstractUpload.KeyIsSocketConnectTimeout}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity$deleteTemporaryApp$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f21468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f21470d;

        b(ISkillCredentialService r3, SkillOpenAppManagementActivity r4, d.c.d<? super b> r5) {
            ISkillCredentialService r6 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            SkillOpenAppManagementActivity r7 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21468b = r6;
            this.f21469c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f21468b, this.f21469c, r6);
            r0.f21470d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21467a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r5);     // Catch: Throwable -> L15
            Object r6 = ((d.n) ZeusTransformUtils.preCheckCast(r5, d.n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L15
        L13:
            Object r7 = d.n.f(d.n.g(r6));     // Catch: Throwable -> L15
        L17:
            SkillOpenAppManagementActivity r4 = this.f21469c;
            Throwable r8 = d.n.c(r7);
            if (r8 == null) goto L21;
            SkillOpenAppManagementActivity.access$logFailure(r4, "delete temporary credential app failed", r8);
        L21:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r5);
            am r9 = (am) ZeusTransformUtils.preCheckCast(this.f21470d, am.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r10 = this.f21468b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            ISkillCredentialService.b r11 = r10.getApps();     // Catch: Throwable -> L15
            com.obric.aiagent.skill.credentials.api.f r3 = com.obric.aiagent.skill.credentials.api.f.f18949a;     // Catch: Throwable -> L15
            this.f21467a = 1;     // Catch: Throwable -> L15
            r6 = r11.c(r3, this);     // Catch: Throwable -> L15
            if (r6 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            r7 = d.n.f(o.a(th));
            goto L17
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {BDAbstractUpload.KeyIsCustomHttpHeaders, BDNetworkSpeedTest.KeyIsIntelligentTestResult, 441, 443, 452}, d = "loadStatus", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21475e;
        int f;

        c(SkillOpenAppManagementActivity r3, d.c.d<? super c> r4) {
            SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21475e = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21474d = r3;
            this.f |= Integer.MIN_VALUE;
            return SkillOpenAppManagementActivity.access$loadStatus(this.f21475e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {379, 384, 392}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity$logout$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f21478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f21479d;

        d(SkillOpenAppManagementActivity r3, ISkillCredentialService r4, d.c.d<? super d> r5) {
            SkillOpenAppManagementActivity r6 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r7 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21477b = r6;
            this.f21478c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f21477b, this.f21478c, r6);
            r0.f21479d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21476a;
            boolean r6 = false;
            com.obric.aiagent.skill.ovirt.impl.b.c r7 = null;
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r12);
            Object r13 = ((d.n) ZeusTransformUtils.preCheckCast(r12, d.n.class, "com.obric.aiagent.plugin")).a();
        L48:
            if (d.n.b(r13) == false) goto L50;
        L62:
            Throwable r14 = d.n.c(r13);
            if (r14 == null) goto L65;
            SkillOpenAppManagementActivity.access$logFailure(this.f21477b, "delete sidecar app on logout failed", r14);
        L66:
            com.obric.aiagent.skill.ovirt.impl.b.c r11 = SkillOpenAppManagementActivity.access$getBinding$p(this.f21477b);
            if (r11 != null) goto L69;
            d.h.b.o.c("binding");
        L70:
            r7.g.setEnabled(true);
            return x.f38692a;
        L69:
            r7 = r11;
            goto L70
        L65:
            ILogDepend.Companion.w(SkillOpenAppManagementActivity.TAG, "delete sidecar app on logout failed");
            goto L66
        L50:
            if (d.n.b(r13) == false) goto L52;
            Object r2 = null;
        L53:
            com.obric.aiagent.skill.credentials.api.h r3 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L56;
        L58:
            if (r6 == false) goto L62;
            this.f21477b.finish();
            return x.f38692a;
        L56:
            if (r3.a() != true) goto L58;
            r6 = true;
            goto L58
        L52:
            r2 = r13;
            goto L53
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r12);
            Object r15 = ((d.n) ZeusTransformUtils.preCheckCast(r12, d.n.class, "com.obric.aiagent.plugin")).a();
        L31:
            if (d.n.b(r15) == false) goto L33;
        L72:
            Throwable r16 = d.n.c(r15);
            if (r16 == null) goto L75;
            SkillOpenAppManagementActivity.access$logFailure(this.f21477b, "logout sidecar account failed", r16);
        L76:
            com.obric.aiagent.skill.ovirt.impl.b.c r17 = SkillOpenAppManagementActivity.access$getBinding$p(this.f21477b);
            if (r17 != null) goto L79;
            d.h.b.o.c("binding");
        L80:
            r7.g.setEnabled(true);
            return x.f38692a;
        L79:
            r7 = r17;
            goto L80
        L75:
            ILogDepend.Companion.w(SkillOpenAppManagementActivity.TAG, "logout sidecar account failed");
            goto L76
        L33:
            if (d.n.b(r15) == false) goto L35;
            Object r4 = null;
        L36:
            com.obric.aiagent.skill.credentials.api.h r5 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L39;
        L41:
            boolean r8 = false;
        L42:
            if (r8 == false) goto L72;
            ISkillCredentialService.b r18 = this.f21478c.getApps();
            com.obric.aiagent.skill.credentials.api.f r9 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.h>> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21476a = 3;
            r13 = r18.c(r9, r10);
            if (r13 != r0) goto L48;
            return r0;
        L39:
            if (r5.a() != true) goto L41;
            r8 = true;
            goto L42
        L35:
            r4 = r15;
            goto L36
        L11:
            o.a(r12);     // Catch: Throwable -> L13
            Object r19 = ((d.n) ZeusTransformUtils.preCheckCast(r12, d.n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L13
        L21:
            Object r110 = d.n.f(d.n.g(r19));     // Catch: Throwable -> L13
        L24:
            SkillOpenAppManagementActivity r20 = this.f21477b;
            Throwable r111 = d.n.c(r110);
            if (r111 == null) goto L27;
            SkillOpenAppManagementActivity.access$logFailure(r20, "end sidecar session on logout failed", r111);
        L27:
            ISkillCredentialService.a r112 = this.f21478c.getAccount();
            com.obric.aiagent.skill.credentials.api.f r21 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.h>> r113 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21476a = 2;
            r15 = r112.a(r21, r113);
            if (r15 != r0) goto L31;
            return r0;
        L15:
            o.a(r12);
            am r114 = (am) ZeusTransformUtils.preCheckCast(this.f21479d, am.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.credentials.api.g r115 = SkillOpenAppManagementActivity.access$getCompletedSessionEnv$p(this.f21477b);
            SkillOpenAppManagementActivity.access$setCompletedSessionEnv$p(this.f21477b, null);
            if (r115 == null) goto L27;
            ISkillCredentialService r22 = this.f21478c;
            d.n.a r116 = d.n.f38560a;     // Catch: Throwable -> L13
            ISkillCredentialService.d r23 = r22.getSessions();     // Catch: Throwable -> L13
            String r117 = r115.a();     // Catch: Throwable -> L13
            this.f21476a = 1;     // Catch: Throwable -> L13
            r19 = r23.a(r117, this);     // Catch: Throwable -> L13
            if (r19 != r0) goto L21;
            return r0;
        L13:
            th = move-exception;
            d.n.a r24 = d.n.f38560a;
            r110 = d.n.f(o.a(th));
            goto L24
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {498, 499}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity$refreshStatus$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f21482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21483d;

        e(ISkillCredentialService r3, SkillOpenAppManagementActivity r4, d.c.d<? super e> r5) {
            ISkillCredentialService r6 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            SkillOpenAppManagementActivity r7 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21482c = r6;
            this.f21483d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f21482c, this.f21483d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21481b;
            com.obric.aiagent.skill.ovirt.impl.b.c r3 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.obric.aiagent.skill.credentials.api.a r2 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(this.f21480a, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
            o.a(r11);
            Object r12 = ((d.n) ZeusTransformUtils.preCheckCast(r11, d.n.class, "com.obric.aiagent.plugin")).a();
        L21:
            if (d.n.b(r12) == false) goto L23;
            r12 = null;
        L23:
            com.obric.aiagent.skill.credentials.api.b r13 = (com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin");
            String r4 = "";
            if (r2 == null) goto L36;
            com.obric.aiagent.skill.credentials.api.b r5 = r2.a();
            if (r5 == null) goto L36;
            com.obric.aiagent.skill.credentials.api.i r6 = r5.b();
            if (r6 == null) goto L36;
            String r7 = r6.b();
            if (r7 == null) goto L36;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L35;
            r7 = null;
        L35:
            if (r7 == null) goto L36;
        L43:
            if (r2 == null) goto L53;
            com.obric.aiagent.skill.credentials.api.b r8 = r2.a();
            if (r8 == null) goto L53;
            String r9 = r8.a();
            if (r9 == null) goto L53;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L52;
            r9 = null;
        L52:
            if (r9 == null) goto L53;
        L67:
            r4 = r9;
        L68:
            ILogDepend.Companion r10 = ILogDepend.Companion;
            StringBuilder r14 = new StringBuilder().append("refreshStatus loggedIn=");
            if (r2 == null) goto L71;
            Boolean r15 = d.c.b.a.b.a(r2.b());
        L72:
            StringBuilder r16 = r14.append(r15).append(" statusApp=");
            if (r2 == null) goto L75;
            com.obric.aiagent.skill.credentials.api.b r17 = r2.a();
        L76:
            int r18 = 0;
            if (r17 == null) goto L79;
            boolean r19 = true;
        L80:
            StringBuilder r20 = r16.append(r19).append(" configuredApp=");
            if (r13 == null) goto L83;
            boolean r110 = true;
        L84:
            r10.i(SkillOpenAppManagementActivity.TAG, r20.append(r110).append(" accountNamePresent=").append(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))).append(" appIdPresent=").append(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))).toString());
            SkillOpenAppManagementActivity.access$renderCredentialItems(this.f21483d, r7, r4);
            com.obric.aiagent.skill.ovirt.impl.b.c r111 = SkillOpenAppManagementActivity.access$getBinding$p(this.f21483d);
            if (r111 != null) goto L87;
            d.h.b.o.c("binding");
            r111 = null;
        L87:
            r111.f.setEnabled(true);
            com.obric.aiagent.skill.ovirt.impl.b.c r112 = SkillOpenAppManagementActivity.access$getBinding$p(this.f21483d);
            if (r112 != null) goto L90;
            d.h.b.o.c("binding");
            r112 = null;
        L90:
            OButton r113 = r112.g;
            if (r2 != null) goto L93;
        L95:
            boolean r21 = false;
        L96:
            if (r21 == false) goto L98;
        L103:
            r113.setVisibility(r18);
            com.obric.aiagent.skill.ovirt.impl.b.c r114 = SkillOpenAppManagementActivity.access$getBinding$p(this.f21483d);
            if (r114 != null) goto L106;
            d.h.b.o.c("binding");
        L107:
            r3.g.setEnabled(true);
            return x.f38692a;
        L106:
            r3 = r114;
            goto L107
        L98:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L103;
            if (SkillOpenAppManagementActivity.access$getCompletedSessionEnv$p(this.f21483d) != null) goto L103;
            r18 = 8;
            goto L103
        L93:
            if (r2.b() != true) goto L95;
            r21 = true;
            goto L96
        L83:
            r110 = false;
            goto L84
        L79:
            r19 = false;
            goto L80
        L75:
            r17 = null;
            goto L76
        L71:
            r15 = null;
        L53:
            if (r13 == null) goto L59;
            r9 = r13.a();
            if (r9 == null) goto L59;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L59;
        L60:
            if (r9 != null) goto L67;
            com.obric.aiagent.skill.credentials.api.g r22 = SkillOpenAppManagementActivity.access$getCompletedSessionEnv$p(this.f21483d);
            if (r22 == null) goto L64;
            r9 = r22.c();
        L65:
            if (r9 != null) goto L67;
        L64:
            r9 = null;
        L59:
            r9 = null;
        L36:
            if (r13 == null) goto L40;
            com.obric.aiagent.skill.credentials.api.i r23 = r13.b();
            if (r23 == null) goto L40;
            r7 = r23.b();
        L41:
            if (r7 != null) goto L43;
            r7 = "";
        L40:
            r7 = null;
            goto L41
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r11);
            Object r115 = ((d.n) ZeusTransformUtils.preCheckCast(r11, d.n.class, "com.obric.aiagent.plugin")).a();
        L14:
            if (d.n.b(r115) == false) goto L16;
            r115 = null;
        L16:
            com.obric.aiagent.skill.credentials.api.a r116 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r115, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
            ISkillCredentialService.b r24 = this.f21482c.getApps();
            com.obric.aiagent.skill.credentials.api.f r25 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.b>> r26 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21480a = r116;
            this.f21481b = 2;
            Object r27 = r24.a(r25, r26);
            if (r27 != r0) goto L19;
            return r0;
        L19:
            r2 = r116;
            r12 = r27;
            goto L21
        L10:
            o.a(r11);
            ISkillCredentialService.a r117 = this.f21482c.getAccount();
            com.obric.aiagent.skill.credentials.api.f r28 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.a>> r29 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21481b = 1;
            r115 = r117.b(r28, r29);
            if (r115 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {299}, d = "resetConfiguredApp", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21488e;

        f(SkillOpenAppManagementActivity r3, d.c.d<? super f> r4) {
            SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21487d = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21486c = r3;
            this.f21488e |= Integer.MIN_VALUE;
            return SkillOpenAppManagementActivity.access$resetConfiguredApp(this.f21487d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {174, 182}, d = "runCreateAppAndLoginFlow", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21493e;
        int f;

        g(SkillOpenAppManagementActivity r3, d.c.d<? super g> r4) {
            SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21493e = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21492d = r3;
            this.f |= Integer.MIN_VALUE;
            return SkillOpenAppManagementActivity.access$runCreateAppAndLoginFlow(this.f21493e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {200, 196, 212, 217, 213}, d = "runCreateAppFlow", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21498e;
        Object f;
        Object g;
        Object h;
        boolean i;
        /* synthetic */ Object j;
        final /* synthetic */ SkillOpenAppManagementActivity k;
        int l;

        h(SkillOpenAppManagementActivity r3, d.c.d<? super h> r4) {
            SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.j = r3;
            this.l |= Integer.MIN_VALUE;
            return SkillOpenAppManagementActivity.access$runCreateAppFlow(this.k, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM, 229, 246, 247, 259, 255}, d = "runLoginFlow", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21503e;
        Object f;
        Object g;
        Object h;
        boolean i;
        /* synthetic */ Object j;
        final /* synthetic */ SkillOpenAppManagementActivity k;
        int l;

        i(SkillOpenAppManagementActivity r3, d.c.d<? super i> r4) {
            SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.j = r3;
            this.l |= Integer.MIN_VALUE;
            return SkillOpenAppManagementActivity.access$runLoginFlow(this.k, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    static final class j<T> implements kotlinx.coroutines.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f21506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f21508e;

        /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
        @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {287}, d = "emit", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity$runSidecarAuthFlow$2")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f21509a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f21510b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ j<T> f21511c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f21512d;

            /* JADX WARN: Multi-variable type inference failed */
            a(j<? super T> r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21511c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f21510b = r3;
                this.f21512d |= Integer.MIN_VALUE;
                return this.f21511c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        j(SkillOpenAppManagementActivity r3, String r4, d.h.a.a<x> r5, String r6, ISkillCredentialService r7) {
            SkillOpenAppManagementActivity r8 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r10 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r7, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            this.f21504a = r8;
            this.f21505b = r4;
            this.f21506c = r9;
            this.f21507d = r6;
            this.f21508e = r10;
        }

        public final Object a(com.obric.aiagent.skill.credentials.api.c r6, d.c.d<? super x> r7) {
            com.obric.aiagent.skill.credentials.api.c r8 = (com.obric.aiagent.skill.credentials.api.c) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.aiagent.skill.credentials.api.c.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if ((r0.f21512d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f21512d -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f21510b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f21512d;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            j<T> this = (j) ZeusTransformUtils.preCheckCast(r0.f21509a, j.class, "com.obric.aiagent.plugin");
            o.a(r10);
            ((d.n) ZeusTransformUtils.preCheckCast(r10, d.n.class, "com.obric.aiagent.plugin")).a();
        L33:
            SkillOpenAppManagementActivity.access$setCreateAppCompletedInActiveFlow$p(this.f21504a, true);
        L35:
            return x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            o.a(r10);
            if (SkillOpenAppManagementActivity.access$isActiveSession(this.f21504a, this.f21505b) == true) goto L19;
            return x.f38692a;
        L19:
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.credentials.api.c.b.class) == false) goto L25;
            d.h.a.a<x> r11 = this.f21506c;
            if (r11 == null) goto L23;
            r11.invoke();
        L23:
            SkillOpenAppManagementActivity.access$showVerificationUrl(this.f21504a, this.f21505b, ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().b(), ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().a());
            goto L35
        L25:
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.credentials.api.c.a.class) == false) goto L39;
            if (((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().a() == false) goto L37;
            if (d.h.b.o.a(this.f21507d, SkillOpenAppManagementActivity.FLOW_CREATE_APP) == false) goto L35;
            ISkillCredentialService.b r12 = this.f21508e.getApps();
            com.obric.aiagent.skill.credentials.api.f r13 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            r0.f21509a = this;
            r0.f21512d = 1;
            if (r12.a(r13, r0) != r2) goto L33;
            return r2;
        L37:
            throw new com.obric.aiagent.skill.credentials.api.e(((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a());
        L39:
            throw new d.k();
        L7:
            r0 = new a(this, r9);
            goto L8
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a((com.obric.aiagent.skill.credentials.api.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.credentials.api.c.class, "com.obric.aiagent.plugin"), r5);
        }
    }

    /* JADX INFO: compiled from: SkillOpenAppManagementActivity.kt */
    @d.c.b.a.f(b = "SkillOpenAppManagementActivity.kt", c = {120, 128, 138}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillOpenAppManagementActivity$startCreateAppAndLogin$1")
    static final class k extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillOpenAppManagementActivity f21514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f21515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21516d;

        k(SkillOpenAppManagementActivity r3, ISkillCredentialService r4, String r5, d.c.d<? super k> r6) {
            SkillOpenAppManagementActivity r7 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r8 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21514b = r7;
            this.f21515c = r8;
            this.f21516d = r5;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f21514b, this.f21515c, this.f21516d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r2 = d.c.a.b.a();
            int r3 = this.f21513a;
            boolean r8 = true;
            if (r3 == 0) goto L19;
            if (r3 == 1) goto L13;
            if (r3 == 2) goto L12;
            if (r3 != 3) goto L10;
            o.a(r17);     // Catch: Throwable -> L15 CancellationException -> L17
            Object r0 = ((d.n) ZeusTransformUtils.preCheckCast(r17, d.n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L15 CancellationException -> L17
        L48:
            o.a(r0);     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity.access$setCompletedSessionEnv$p(this.f21514b, (com.obric.aiagent.skill.credentials.api.g) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.credentials.api.g.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity.access$setCreateAppCompletedInActiveFlow$p(this.f21514b, false);     // Catch: Throwable -> L15 CancellationException -> L17
            com.obric.aiagent.skill.credentials.api.m.f18996a.b(this.f21516d, (n) ZeusTransformUtils.preCheckCast(this.f21514b, n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity.access$setActiveSessionId$p(this.f21514b, null);     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity.access$setAuthJob$p(this.f21514b, null);     // Catch: Throwable -> L15 CancellationException -> L17
            com.obric.aiagent.skill.credentials.api.m.f18996a.a(this.f21516d);     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity.access$refreshStatus(this.f21514b);     // Catch: Throwable -> L15 CancellationException -> L17
        L64:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r17);     // Catch: Throwable -> L15 CancellationException -> L17
        L41:
            if (SkillOpenAppManagementActivity.access$isActiveSession(this.f21514b, this.f21516d) == false) goto L43;
        L45:
            ISkillCredentialService.d r10 = this.f21515c.getSessions();     // Catch: Throwable -> L15 CancellationException -> L17
            com.obric.aiagent.skill.credentials.api.f r11 = com.obric.aiagent.skill.credentials.api.f.f18949a;     // Catch: Throwable -> L15 CancellationException -> L17
            d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.g>> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 CancellationException -> L17
            this.f21513a = 3;     // Catch: Throwable -> L15 CancellationException -> L17
            r0 = r10.a(r11, "lark-cli", SkillOpenAppManagementActivity.DEFAULT_SESSION_TTL_SECONDS, r15);     // Catch: Throwable -> L15 CancellationException -> L17
            if (r0 != r2) goto L48;
            return r2;
        L43:
            return x.f38692a;
        L13:
            Object r4 = r17;
            o.a(r17);     // Catch: Throwable -> L15 CancellationException -> L17
        L23:
            com.obric.aiagent.skill.credentials.api.a r5 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 CancellationException -> L17
            if (r5.a() != null) goto L26;
            boolean r12 = true;
        L27:
            ILogDepend.Companion r13 = ILogDepend.Companion;     // Catch: Throwable -> L15 CancellationException -> L17
            StringBuilder r14 = new StringBuilder().append("start open app auth preflight configuredApp=");     // Catch: Throwable -> L15 CancellationException -> L17
            if (r5.a() == null) goto L30;
            boolean r16 = true;
        L31:
            StringBuilder r18 = r14.append(r16).append(" loggedIn=").append(r5.b()).append(" requiresAppSetup=");     // Catch: Throwable -> L15 CancellationException -> L17
            if (r12 == false) goto L34;
            boolean r19 = true;
        L35:
            r13.i(SkillOpenAppManagementActivity.TAG, r18.append(r19).toString());     // Catch: Throwable -> L15 CancellationException -> L17
            if (r5.b() == true) goto L44;
            SkillOpenAppManagementActivity r1 = this.f21514b;     // Catch: Throwable -> L15 CancellationException -> L17
            ISkillCredentialService r6 = this.f21515c;     // Catch: Throwable -> L15 CancellationException -> L17
            String r110 = this.f21516d;     // Catch: Throwable -> L15 CancellationException -> L17
            d.c.d r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 CancellationException -> L17
            this.f21513a = 2;     // Catch: Throwable -> L15 CancellationException -> L17
            if (SkillOpenAppManagementActivity.access$runCreateAppAndLoginFlow(r1, r6, r110, r111) != r2) goto L41;
            return r2;
        L44:
            ILogDepend.Companion.i(SkillOpenAppManagementActivity.TAG, "skip open app auth flow because account is already logged in");     // Catch: Throwable -> L15 CancellationException -> L17
            goto L45
        L34:
            r19 = false;
            goto L35
        L30:
            r16 = false;
            goto L31
        L26:
            r12 = false;
            goto L27
        L19:
            o.a(r17);
            SkillOpenAppManagementActivity.access$renderRunning(this.f21514b);     // Catch: Throwable -> L15 CancellationException -> L17
            SkillOpenAppManagementActivity r7 = this.f21514b;     // Catch: Throwable -> L15 CancellationException -> L17
            ISkillCredentialService r112 = this.f21515c;     // Catch: Throwable -> L15 CancellationException -> L17
            d.c.d r113 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 CancellationException -> L17
            this.f21513a = 1;     // Catch: Throwable -> L15 CancellationException -> L17
            r4 = SkillOpenAppManagementActivity.access$loadStatus(r7, r112, r113);     // Catch: Throwable -> L15 CancellationException -> L17
            if (r4 != r2) goto L23;
            return r2;
        L17:
            e = move-exception;
            throw e;
        L15:
            th = move-exception;
            SkillOpenAppManagementActivity.access$logFailure(this.f21514b, "sidecar auth flow failed", th);
            if (SkillOpenAppManagementActivity.access$getCreateAppCompletedInActiveFlow$p(this.f21514b) == true) goto L53;
        L55:
            r8 = false;
        L56:
            SkillOpenAppManagementActivity.access$setCreateAppCompletedInActiveFlow$p(this.f21514b, false);
            String r9 = SkillOpenAppManagementActivity.access$getActiveSessionId$p(this.f21514b);
            if (r9 == null) goto L59;
            SkillOpenAppManagementActivity r20 = this.f21514b;
            com.obric.aiagent.skill.credentials.api.m.f18996a.a(r9);
            com.obric.aiagent.skill.credentials.api.m.f18996a.b(r9, (n) ZeusTransformUtils.preCheckCast(r20, n.class, "com.obric.aiagent.plugin"));
        L59:
            SkillOpenAppManagementActivity.access$setActiveSessionId$p(this.f21514b, null);
            SkillOpenAppManagementActivity.access$setAuthJob$p(this.f21514b, null);
            if (r8 == false) goto L62;
            SkillOpenAppManagementActivity.access$deleteTemporaryApp(this.f21514b);
        L62:
            SkillOpenAppManagementActivity r21 = this.f21514b;
            String r22 = r21.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_config_feishu_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_config_feishu_failed"));
            d.h.b.o.c(r22, "getString(...)");
            SkillOpenAppManagementActivity.access$renderError(r21, r22);
            goto L64
        L53:
            if (SkillOpenAppManagementActivity.access$getCompletedSessionEnv$p(this.f21514b) != null) goto L55;
            goto L55
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$0Ggbl5n8cSjd4KAge4IvUaHh-e4, reason: not valid java name */
    public static /* synthetic */ void m365lambda$0Ggbl5n8cSjd4KAge4IvUaHhe4(SkillOpenAppManagementActivity r0, View r1) {
        setupContent$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$FSkven23HF9xkyTLa3zn0_n82gs(SkillOpenAppManagementActivity r0) {
        onClosed$lambda$10(r0);
    }

    /* JADX INFO: renamed from: lambda$JLFCt2RVF1oG-lH5RQKNol1PAek, reason: not valid java name */
    public static /* synthetic */ void m366lambda$JLFCt2RVF1oGlH5RQKNol1PAek(SkillOpenAppManagementActivity r0, View r1) {
        setupTitleBar$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ x lambda$MK6NVoNpSb2l4IqH00EefQe_dg8(z.a r0) {
        return runCreateAppFlow$lambda$7(r0);
    }

    public static /* synthetic */ void lambda$VbT7Y45E3uQ1H3qIKSyoYkg9wQg(SkillOpenAppManagementActivity r0, View r1) {
        setupContent$lambda$6(r0, r1);
    }

    public static /* synthetic */ x lambda$kndoBuUfEzLQEv__q0Dle0biizQ(z.a r0) {
        return runLoginFlow$lambda$8(r0);
    }

    public SkillOpenAppManagementActivity() {
    }

    public static final /* synthetic */ Object access$cleanupConfiguredAppAfterPreflightConflict(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, String r4, Throwable r5, d.c.d r6) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).cleanupConfiguredAppAfterPreflightConflict((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$deleteTemporaryApp(SkillOpenAppManagementActivity r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).deleteTemporaryApp();
    }

    public static final /* synthetic */ String access$getActiveSessionId$p(SkillOpenAppManagementActivity r2) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).activeSessionId;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.b.c access$getBinding$p(SkillOpenAppManagementActivity r2) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.credentials.api.g access$getCompletedSessionEnv$p(SkillOpenAppManagementActivity r2) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).completedSessionEnv;
    }

    public static final /* synthetic */ boolean access$getCreateAppCompletedInActiveFlow$p(SkillOpenAppManagementActivity r2) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).createAppCompletedInActiveFlow;
    }

    public static final /* synthetic */ boolean access$isActiveSession(SkillOpenAppManagementActivity r2, String r3) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).isActiveSession(r3);
    }

    public static final /* synthetic */ Object access$loadStatus(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, d.c.d r4) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).loadStatus((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$logFailure(SkillOpenAppManagementActivity r2, String r3, Throwable r4) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).logFailure(r3, r4);
    }

    public static final /* synthetic */ void access$logout(SkillOpenAppManagementActivity r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).logout();
    }

    public static final /* synthetic */ void access$refreshStatus(SkillOpenAppManagementActivity r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).refreshStatus();
    }

    public static final /* synthetic */ void access$renderCredentialItems(SkillOpenAppManagementActivity r2, String r3, String r4) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).renderCredentialItems(r3, r4);
    }

    public static final /* synthetic */ void access$renderError(SkillOpenAppManagementActivity r2, String r3) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).renderError(r3);
    }

    public static final /* synthetic */ void access$renderRunning(SkillOpenAppManagementActivity r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).renderRunning();
    }

    public static final /* synthetic */ Object access$resetConfiguredApp(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, String r4, d.c.d r5) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).resetConfiguredApp((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runCreateAppAndLoginFlow(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, String r4, d.c.d r5) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).runCreateAppAndLoginFlow((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runCreateAppFlow(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, String r4, boolean r5, d.c.d r6) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).runCreateAppFlow((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runLoginFlow(SkillOpenAppManagementActivity r2, ISkillCredentialService r3, String r4, boolean r5, d.c.d r6) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).runLoginFlow((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runSidecarAuthFlow(SkillOpenAppManagementActivity r9, ISkillCredentialService r10, String r11, String r12, kotlinx.coroutines.b.h r13, d.h.a.a r14, d.c.d r15) {
        return ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r9, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).runSidecarAuthFlow((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r10, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r11, r12, (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r13, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$setActiveSessionId$p(SkillOpenAppManagementActivity r2, String r3) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).activeSessionId = r3;
    }

    public static final /* synthetic */ void access$setAuthJob$p(SkillOpenAppManagementActivity r2, ca r3) {
        SkillOpenAppManagementActivity r4 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        r4.authJob = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setCompletedSessionEnv$p(SkillOpenAppManagementActivity r2, com.obric.aiagent.skill.credentials.api.g r3) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).completedSessionEnv = r3;
    }

    public static final /* synthetic */ void access$setCreateAppCompletedInActiveFlow$p(SkillOpenAppManagementActivity r2, boolean r3) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).createAppCompletedInActiveFlow = r3;
    }

    public static final /* synthetic */ void access$showVerificationUrl(SkillOpenAppManagementActivity r2, String r3, String r4, String r5) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).showVerificationUrl(r3, r4, r5);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        com.obric.aiagent.skill.ovirt.impl.ui.b.a((AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.c r6 = com.obric.aiagent.skill.ovirt.impl.b.c.a(getLayoutInflater());
        d.h.b.o.c(r6, "inflate(...)");
        this.binding = r6;
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = null;
        if (r6 != null) goto L5;
        d.h.b.o.c("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.b(), View.class, "com.obric.aiagent.plugin"));
        setupTitleBar();
        setupContent();
        com.obric.aiagent.skill.ovirt.impl.b.c r7 = this.binding;
        if (r7 != null) goto L8;
        d.h.b.o.c("binding");
        r7 = null;
    L8:
        LinearLayout r8 = r7.f21122b;
        d.h.b.o.c(r8, "contentContainer");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        if (r0 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        OFloatingTitleBar r2 = r1.i;
        d.h.b.o.c(r2, "titleBar");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r9, r2);
        refreshStatus();
        return;
    L11:
        r1 = r0;
        goto L12
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        resetAuthFlow();
        super.onDestroy();
    }

    private final void setupTitleBar() {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.i;
        r1.setFloatingTransitionEnabled(true);
        OFloatingTitleBar.removeAllStartAction$default(r1, false, 1, null);
        OFloatingTitleBar.removeAllEndAction$default(r1, false, 1, null);
        r1.setCenterTitle(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_management_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_management_title"));
        OFloatingTitleBar.addStartAction$default(r1, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillOpenAppManagementActivity$JLFCt2RVF1oGlH5RQKNol1PAek(this), 2, null);
        r1.removeCenterCustomView();
        r1.showCenterCustomView(false);
    }

    private static final void setupTitleBar$lambda$1$lambda$0(SkillOpenAppManagementActivity r1, View r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void setupContent() {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.c r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f21124d;
        r1.setCardType(0);
        OCardListItem.setCardPosition$default(r1, 1, false, 2, null);
        r1.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_account_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_account_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        r1.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        r1.showSubTitle(false);
        r1.showTailIcon(false);
        com.obric.aiagent.skill.ovirt.impl.b.c r3 = this.binding;
        if (r3 != null) goto L8;
        d.h.b.o.c("binding");
        r3 = null;
    L8:
        OCardListItem r4 = r3.f21125e;
        r4.setCardType(0);
        OCardListItem.setCardPosition$default(r4, 3, false, 2, null);
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_app_id_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_app_id_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        r4.showSubTitle(false);
        r4.showTailIcon(false);
        com.obric.aiagent.skill.ovirt.impl.b.c r5 = this.binding;
        if (r5 != null) goto L11;
        d.h.b.o.c("binding");
        r5 = null;
    L11:
        OCardListItem r6 = r5.f;
        r6.setCardType(0);
        OCardListItem.setCardPosition$default(r6, 0, false, 2, null);
        r6.showSubTitle(false);
        r6.setDefaultTailIcon(0);
        r6.showTailIcon(true);
        r6.setOnContentClickListener(new $$Lambda$SkillOpenAppManagementActivity$0Ggbl5n8cSjd4KAge4IvUaHhe4(this));
        com.obric.aiagent.skill.ovirt.impl.b.c r7 = this.binding;
        if (r7 != null) goto L14;
        d.h.b.o.c("binding");
        r7 = null;
    L14:
        r7.f21123c.setVisibility(8);
        com.obric.aiagent.skill.ovirt.impl.b.c r8 = this.binding;
        if (r8 != null) goto L17;
        d.h.b.o.c("binding");
    L18:
        r2.g.setOnClickListener(new $$Lambda$SkillOpenAppManagementActivity$VbT7Y45E3uQ1H3qIKSyoYkg9wQg(this));
        return;
    L17:
        r2 = r8;
        goto L18
    }

    private static final void setupContent$lambda$5$lambda$4(SkillOpenAppManagementActivity r1, View r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).startCreateAppAndLogin();
    }

    private static final void setupContent$lambda$6(SkillOpenAppManagementActivity r1, View r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).showLogoutConfirm();
    }

    private final void startCreateAppAndLogin() {
        ISkillCredentialService r0 = ISkillCredentialService.Companion.a();
        if (r0 != null) goto L6;
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_credentials_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_credentials_unavailable"));
        d.h.b.o.c(r1, "getString(...)");
        renderError(r1);
        return;
    L6:
        resetAuthFlow();
        this.createAppCompletedInActiveFlow = false;
        String r2 = UUID.randomUUID().toString();
        d.h.b.o.c(r2, "toString(...)");
        this.activeSessionId = r2;
        com.obric.aiagent.skill.credentials.api.m.f18996a.a(r2, (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.aiagent.plugin"));
        this.authJob = kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new k(this, r0, r2, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object runCreateAppAndLoginFlow(ISkillCredentialService r7, String r8, d.c.d<? super x> r9) {
        ISkillCredentialService r10 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r7, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r11, g.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f21492d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r12);
    L27:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.f21491c, String.class, "com.obric.aiagent.plugin");
        r10 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r0.f21490b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity this = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r0.f21489a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r12);
    L20:
        if (this.isActiveSession(r8) == false) goto L22;
        r0.f21489a = null;
        r0.f21490b = null;
        r0.f21491c = null;
        r0.f = 2;
        if (this.runLoginFlow(r10, r8, false, r0) != r2) goto L27;
        return r2;
    L22:
        return x.f38692a;
    L16:
        o.a(r12);
        r0.f21489a = this;
        r0.f21490b = r10;
        r0.f21491c = r8;
        r0.f = 1;
        if (runCreateAppFlow(r10, r8, true, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new g(this, r11);
        goto L8
    }

    private final Object runCreateAppFlow(ISkillCredentialService r20, String r21, boolean r22, d.c.d<? super x> r23) {
        SkillOpenAppManagementActivity r1 = this;
        String r2 = r21;
        ISkillCredentialService r3 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r20, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L7;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if ((r6.l & Integer.MIN_VALUE) == 0) goto L7;
        r6.l -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.j;
        Object r15 = d.c.a.b.a();
        int r8 = r6.l;
        if (r8 == 0) goto L30;
        if (r8 == 1) goto L25;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L19;
        if (r8 == 4) goto L18;
        if (r8 != 5) goto L17;
        o.a(r7);
    L73:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r6.f21497d, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.f21496c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r10 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21495b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21494a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);
        SkillOpenAppManagementActivity r11 = r0;
        String r12 = r9;
        ISkillCredentialService r13 = r10;
        String r14 = r4;
        Object r16 = null;
    L69:
        kotlinx.coroutines.b.h r17 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        r6.f21494a = r16;
        r6.f21495b = r16;
        r6.f21496c = r16;
        r6.f21497d = r16;
        r6.l = 5;
        if (runSidecarAuthFlow$default(r11, r13, r12, r14, r17, null, r6, 16, null) != r15) goto L73;
        return r15;
    L19:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r6.f21496c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r19 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21495b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r24 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21494a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);
        ISkillCredentialService r25 = r19;
        r2 = r18;
        r16 = null;
    L65:
        ISkillCredentialService.b r26 = r25.getApps();
        com.obric.aiagent.skill.credentials.api.f r27 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r6.f21494a = r24;
        r6.f21495b = r25;
        r6.f21496c = r2;
        r6.f21497d = FLOW_CREATE_APP;
        r6.l = 4;
        r7 = r26.b(r27, r6);
        if (r7 != r15) goto L68;
        return r15;
    L68:
        r12 = r2;
        r13 = r25;
        r14 = FLOW_CREATE_APP;
        r11 = r24;
        goto L69
    L20:
        boolean r28 = r6.i;
        z.a r29 = (z.a) ZeusTransformUtils.preCheckCast(r6.f21497d, z.a.class, "com.obric.aiagent.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r6.f21496c, String.class, "com.obric.aiagent.plugin");
        r25 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21495b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r31 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21494a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L23
    L23:
        e = e;
        final z.a r32 = r29;
        r2 = r30;
        SkillOpenAppManagementActivity r110 = r31;
        boolean r33 = r28;
        r16 = null;
    L56:
        if (r33 == true) goto L58;
    L74:
        throw e;
    L58:
        if (r32.f38499a == true) goto L74;
        if (com.obric.aiagent.skill.credentials.api.d.a(e.a()) == false) goto L74;
        ILogDepend.Companion.w(TAG, "recover create app conflict code=" + e.a().b() + " subtype=" + e.a().c());
        r6.f21494a = r110;
        r6.f21495b = r25;
        r6.f21496c = r2;
        r6.f21497d = r16;
        r6.f21498e = r16;
        r6.f = r16;
        r6.g = r16;
        r6.h = r16;
        r6.l = 3;
        if (r110.resetConfiguredApp(r25, "create app recovery", r6) != r15) goto L64;
        return r15;
    L64:
        r24 = r110;
        goto L65
    L25:
        boolean r34 = r6.i;
        String r35 = (String) ZeusTransformUtils.preCheckCast(r6.h, String.class, "com.obric.aiagent.plugin");
        String r36 = (String) ZeusTransformUtils.preCheckCast(r6.g, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r37 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r38 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21498e, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        z.a r111 = (z.a) ZeusTransformUtils.preCheckCast(r6.f21497d, z.a.class, "com.obric.aiagent.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r6.f21496c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r39 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21495b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r110 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21494a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L28
        Object r40 = r7;
        r32 = r111;
        String r113 = r35;
        r2 = r112;
        r33 = r34;
        r1 = r110;
        ISkillCredentialService r114 = r39;
        ISkillCredentialService r41 = r37;
        SkillOpenAppManagementActivity r42 = r38;
        String r43 = r36;
    L77:
        kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r44 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r40, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        d.h.a.a<x> r115 = new $$Lambda$SkillOpenAppManagementActivity$MK6NVoNpSb2l4IqH00EefQe_dg8(r32);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f21494a = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f21495b = r114;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f21496c = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f21497d = r32;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f21498e = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.f = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.g = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.h = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.i = r33;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.l = 2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L46
        r16 = null;
        if (r42.runSidecarAuthFlow(r41, r43, r113, r44, r115, r6) != r15) goto L73;
        return r15;
    L44:
        e = e;
    L50:
        r25 = r114;
        r110 = r1;
    L46:
        e = e;
        r16 = null;
    L48:
        e = e;
        r16 = null;
    L28:
        e = e;
        r33 = r34;
        r25 = r39;
        r16 = null;
        r32 = r111;
        r2 = r112;
        goto L56
    L30:
        o.a(r7);
        r32 = new z.a();
        ISkillCredentialService.b r45 = r3.getApps();     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        com.obric.aiagent.skill.credentials.api.f r46 = com.obric.aiagent.skill.credentials.api.f.f18949a;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f21494a = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f21495b = r3;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f21496c = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f21497d = r32;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f21498e = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.f = r3;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.g = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        r6.h = FLOW_CREATE_APP;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L53
        boolean r47 = r22;
        r6.i = r47;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L51
        r6.l = 1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L51
        r40 = r45.b(r46, r6);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L51
        if (r40 != r15) goto L36;
        return r15;
    L36:
        r42 = r1;
        r43 = r2;
        r114 = r3;
        r113 = FLOW_CREATE_APP;
        r33 = r47;
        r41 = r114;
    L51:
        e = e;
    L55:
        r16 = null;
        r110 = this;
        r25 = r3;
        r33 = r47;
    L53:
        e = e;
        r47 = r22;
    L7:
        r6 = new h(r1, r5);
        goto L8
    }

    private static final x runCreateAppFlow$lambda$7(z.a r1) {
        r1.f38499a = true;
        return x.f38692a;
    }

    private final Object runLoginFlow(ISkillCredentialService r20, String r21, boolean r22, d.c.d<? super x> r23) {
        SkillOpenAppManagementActivity r1 = this;
        String r2 = r21;
        ISkillCredentialService r3 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r20, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L7;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if ((r6.l & Integer.MIN_VALUE) == 0) goto L7;
        r6.l -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.j;
        Object r15 = d.c.a.b.a();
        switch(r6.l) {
            case 0: goto L27;
            case 1: goto L21;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        o.a(r7);
    L77:
        return x.f38692a;
    L13:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r6.f21502d, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.f21501c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r9 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21500b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21499a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);
        SkillOpenAppManagementActivity r10 = r0;
        String r11 = r4;
        String r12 = r8;
        ISkillCredentialService r13 = r9;
        Object r14 = null;
    L73:
        kotlinx.coroutines.b.h r16 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        r6.f21499a = r14;
        r6.f21500b = r14;
        r6.f21501c = r14;
        r6.f21502d = r14;
        r6.l = 6;
        if (runSidecarAuthFlow$default(r10, r13, r12, r11, r16, null, r6, 16, null) != r15) goto L77;
        return r15;
    L14:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r6.f21501c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r18 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21500b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r19 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21499a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);
        ISkillCredentialService r110 = r18;
        r2 = r17;
        r14 = null;
    L66:
        if (r19.isActiveSession(r2) == false) goto L68;
        ISkillCredentialService.a r24 = r110.getAccount();
        com.obric.aiagent.skill.credentials.api.f r25 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        List<String> r26 = d.a.p.b();
        r6.f21499a = r19;
        r6.f21500b = r110;
        r6.f21501c = r2;
        r6.f21502d = FLOW_LOGIN;
        r6.l = 5;
        r7 = r24.a(r25, r26, r6);
        if (r7 != r15) goto L72;
        return r15;
    L72:
        r10 = r19;
        r12 = r2;
        r13 = r110;
        r11 = FLOW_LOGIN;
        goto L73
    L68:
        return x.f38692a;
    L15:
        String r27 = (String) ZeusTransformUtils.preCheckCast(r6.f21501c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r28 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21500b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r19 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21499a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r110 = r28;
        r2 = r27;
        r14 = null;
    L62:
        r6.f21499a = r19;
        r6.f21500b = r110;
        r6.f21501c = r2;
        r6.l = 4;
        if (r19.runCreateAppFlow(r110, r2, false, r6) != r15) goto L66;
        return r15;
    L16:
        boolean r29 = r6.i;
        z.a r30 = (z.a) ZeusTransformUtils.preCheckCast(r6.f21502d, z.a.class, "com.obric.aiagent.plugin");
        String r31 = (String) ZeusTransformUtils.preCheckCast(r6.f21501c, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r32 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21500b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r33 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21499a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L19
    L19:
        e = e;
        final z.a r34 = r30;
        r2 = r31;
        r110 = r32;
        SkillOpenAppManagementActivity r111 = r33;
        boolean r35 = r29;
    L26:
        r14 = null;
    L53:
        if (r35 == true) goto L55;
    L78:
        throw e;
    L55:
        if (r34.f38499a == true) goto L78;
        if (com.obric.aiagent.skill.credentials.api.d.a(e.a()) == false) goto L78;
        ILogDepend.Companion.w(TAG, "recover login configured app conflict code=" + e.a().b() + " subtype=" + e.a().c());
        r6.f21499a = r111;
        r6.f21500b = r110;
        r6.f21501c = r2;
        r6.f21502d = r14;
        r6.f21503e = r14;
        r6.f = r14;
        r6.g = r14;
        r6.h = r14;
        r6.l = 3;
        if (r111.resetConfiguredApp(r110, "login recovery", r6) != r15) goto L61;
        return r15;
    L61:
        r19 = r111;
        goto L62
    L21:
        boolean r36 = r6.i;
        String r37 = (String) ZeusTransformUtils.preCheckCast(r6.h, String.class, "com.obric.aiagent.plugin");
        String r38 = (String) ZeusTransformUtils.preCheckCast(r6.g, String.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r39 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r40 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21503e, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        z.a r41 = (z.a) ZeusTransformUtils.preCheckCast(r6.f21502d, z.a.class, "com.obric.aiagent.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r6.f21501c, String.class, "com.obric.aiagent.plugin");
        r110 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f21500b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r111 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r6.f21499a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L24
        Object r42 = r7;
        r34 = r41;
        String r43 = r38;
        r35 = r36;
        r1 = r111;
        ISkillCredentialService r113 = r110;
        String r114 = r37;
        r2 = r112;
        ISkillCredentialService r44 = r39;
        SkillOpenAppManagementActivity r45 = r40;
    L87:
        kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r115 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r42, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        d.h.a.a<x> r46 = new $$Lambda$SkillOpenAppManagementActivity$kndoBuUfEzLQEv__q0Dle0biizQ(r34);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f21499a = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f21500b = r113;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f21501c = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f21502d = r34;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f21503e = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.f = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.g = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.h = null;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.i = r35;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L45
        r6.l = 2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L43
        r14 = null;
        if (r45.runSidecarAuthFlow(r44, r43, r114, r115, r46, r6) != r15) goto L77;
        return r15;
    L41:
        e = e;
    L47:
        r111 = r1;
        r110 = r113;
    L43:
        e = e;
        r14 = null;
    L45:
        e = e;
        r14 = null;
    L24:
        e = e;
        r35 = r36;
        r34 = r41;
        r2 = r112;
        goto L26
    L27:
        o.a(r7);
        r34 = new z.a();
        ISkillCredentialService.a r47 = r3.getAccount();     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        com.obric.aiagent.skill.credentials.api.f r48 = com.obric.aiagent.skill.credentials.api.f.f18949a;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        List<String> r49 = d.a.p.b();     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f21499a = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f21500b = r3;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f21501c = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f21502d = r34;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f21503e = r1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.f = r3;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.g = r2;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        r6.h = FLOW_LOGIN;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L50
        boolean r50 = r22;
        r6.i = r50;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r6.l = 1;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        r42 = r47.a(r48, r49, r6);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L48
        if (r42 != r15) goto L33;
        return r15;
    L33:
        r45 = r1;
        r44 = r3;
        r113 = r44;
        r35 = r50;
        r114 = FLOW_LOGIN;
        r43 = r2;
    L48:
        e = e;
    L52:
        r14 = null;
        r111 = this;
        r110 = r3;
        r35 = r50;
    L50:
        e = e;
        r50 = r22;
        goto L52
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r6 = new i(r1, r5);
        goto L8
    }

    private static final x runLoginFlow$lambda$8(z.a r1) {
        r1.f38499a = true;
        return x.f38692a;
    }

    static /* synthetic */ Object runSidecarAuthFlow$default(SkillOpenAppManagementActivity r9, ISkillCredentialService r10, String r11, String r12, kotlinx.coroutines.b.h r13, d.h.a.a r14, d.c.d r15, int r16, Object r17) {
        SkillOpenAppManagementActivity r2 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r9, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r3 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r10, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r6 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r13, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L6;
        r0 = null;
    L6:
        return r2.runSidecarAuthFlow(r3, r11, r12, r6, r0, r8);
    }

    private final Object runSidecarAuthFlow(ISkillCredentialService r9, String r10, String r11, kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r12, d.h.a.a<x> r13, d.c.d<? super x> r14) {
        ISkillCredentialService r7 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r9, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.h r15 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r12, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = r15.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new j(this, r10, r5, r11, r7), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r16);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return x.f38692a;
    }

    private final Object resetConfiguredApp(ISkillCredentialService r6, String r7, d.c.d<? super x> r8) {
        ISkillCredentialService r9 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r6, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        if ((r0.f21488e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21488e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f21486c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21488e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f21485b, String.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity this = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r0.f21484a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r11);
        Object r12 = ((d.n) ZeusTransformUtils.preCheckCast(r11, d.n.class, "com.obric.aiagent.plugin")).a();
    L17:
        Throwable r13 = d.n.c(r12);
        if (r13 != null) goto L25;
        com.obric.aiagent.skill.credentials.api.h r5 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
        if (r5.a() == true) goto L22;
        ILogDepend.Companion.w(TAG, r7 + " delete configured app rejected code=" + r5.b() + " type=" + r5.getType() + " subtype=" + r5.c());
        throw new com.obric.aiagent.skill.credentials.api.e(r5);
    L22:
        return x.f38692a;
    L25:
        this.logFailure(r7 + " delete configured app failed", r13);
        throw r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        ISkillCredentialService.b r14 = r9.getApps();
        com.obric.aiagent.skill.credentials.api.f r15 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f21484a = this;
        r0.f21485b = r7;
        r0.f21488e = 1;
        r12 = r14.c(r15, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new f(this, r10);
        goto L8
    }

    private final void showVerificationUrl(String r5, String r6, String r7) {
        if (com.obric.aiagent.skill.credentials.api.m.f18996a.a(r5, r6, r7) == true) goto L9;
        AppCompatActivity r0 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = this.binding;
        if (r1 != null) goto L7;
        d.h.b.o.c("binding");
        r1 = null;
    L7:
        OFloatingTitleBar r2 = r1.i;
        d.h.b.o.c(r2, "titleBar");
        Intent r4 = new Intent().setClassName(getPackageName(), SIDECAR_AUTH_ACTIVITY).putExtra(SidecarAuthActivity.EXTRA_URL, r6).putExtra(SidecarAuthActivity.EXTRA_FLOW_ID, r7).putExtra(SidecarAuthActivity.EXTRA_SESSION_ID, r5);
        d.h.b.o.c(r4, "putExtra(...)");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r0, r2, r4);
        return;
    }

    @Override // com.obric.aiagent.skill.credentials.api.n
    public void onClosed(String r2) {
        d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        if (d.h.b.o.a(r2, this.activeSessionId) == true) goto L5;
        return;
    L5:
        if (this.authJob == null) goto L10;
        runOnUiThread(new $$Lambda$SkillOpenAppManagementActivity$FSkven23HF9xkyTLa3zn0_n82gs(this));
        return;
    }

    private static final void onClosed$lambda$10(SkillOpenAppManagementActivity r2) {
        ((SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin")).resetAuthFlow();
    }

    private final void showLogoutConfirm() {
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_logout_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_logout_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_logout_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_logout_confirm")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_feishu_logout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_feishu_logout"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r14 = com.obric.oui.dialog.v2.alert.a.a(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null);
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_dialog_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_dialog_cancel"));
        d.h.b.o.c(r0, "getString(...)");
        com.obric.oui.dialog.v2.alert.a.b(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null).h();
    }

    private final void logout() {
        ISkillCredentialService r0 = ISkillCredentialService.Companion.a();
        if (r0 != null) goto L6;
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_credentials_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_credentials_unavailable"));
        d.h.b.o.c(r1, "getString(...)");
        renderError(r1);
        return;
    L6:
        com.obric.aiagent.skill.ovirt.impl.b.c r2 = this.binding;
        if (r2 != null) goto L9;
        d.h.b.o.c("binding");
        r2 = null;
    L9:
        r2.g.setEnabled(false);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r0, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void resetAuthFlow() {
        if (this.createAppCompletedInActiveFlow == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        ca r3 = this.authJob;
        if (r3 == null) goto L11;
        ca.a.a(r3, null, 1, null);
    L11:
        this.authJob = null;
        String r1 = this.activeSessionId;
        if (r1 == null) goto L14;
        com.obric.aiagent.skill.credentials.api.m.f18996a.b(r1, (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.aiagent.plugin"));
    L14:
        this.activeSessionId = null;
        this.createAppCompletedInActiveFlow = false;
        if (r0 == false) goto L18;
        deleteTemporaryApp();
        return;
    L18:
        return;
    L5:
        if (this.completedSessionEnv != null) goto L7;
        r0 = true;
        goto L8
    }

    private final void deleteTemporaryApp() {
        ISkillCredentialService r0 = ISkillCredentialService.Companion.a();
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r0, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object loadStatus(ISkillCredentialService r24, d.c.d<? super com.obric.aiagent.skill.credentials.api.a> r25) {
        SkillOpenAppManagementActivity r0 = this;
        ISkillCredentialService r2 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r24, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f21474d;
        Object r7 = d.c.a.b.a();
        int r8 = r5.f;
        if (r8 == 0) goto L22;
        if (r8 == 1) goto L21;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L19;
        if (r8 == 4) goto L18;
        if (r8 != 5) goto L17;
        r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r5.f21471a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L43:
        return r0.noConfiguredAppStatus();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r5.f21471a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L54:
        return r0.noConfiguredAppStatus();
    L19:
        com.obric.aiagent.skill.credentials.api.b r1 = (com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r5.f21473c, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin");
        r2 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r5.f21472b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SkillOpenAppManagementActivity r3 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r5.f21471a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r6);
        Object r9 = ((d.n) ZeusTransformUtils.preCheckCast(r6, d.n.class, "com.obric.aiagent.plugin")).a();
        com.obric.aiagent.skill.credentials.api.b r16 = r1;
        r0 = r3;
    L35:
        Throwable r10 = d.n.c(r9);
        if (r10 != null) goto L49;
        com.obric.aiagent.skill.credentials.api.a r15 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        if (r15.b() == true) goto L45;
        ILogDepend.Companion.w(TAG, "loadStatus resets configured app without login");
        r5.f21471a = r0;
        r5.f21472b = null;
        r5.f21473c = null;
        r5.f = 5;
        if (r0.resetConfiguredApp(r2, "app without login", r5) != r7) goto L43;
        return r7;
    L45:
        if (r15.a() != null) goto L64;
        ILogDepend.Companion.w(TAG, "loadStatus preserves configured app missing from status");
        return com.obric.aiagent.skill.credentials.api.a.a(r15, r16, false, null, null, null, 30, null);
    L64:
        return r15;
    L49:
        if (r0.isAppConfigurationConflict(r10) == false) goto L55;
        r5.f21471a = r0;
        r5.f21472b = null;
        r5.f21473c = null;
        r5.f = 4;
        if (r0.cleanupConfiguredAppAfterPreflightConflict(r2, "status", r10, r5) != r7) goto L54;
        return r7;
    L55:
        throw r10;
    L20:
        r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r5.f21471a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L62:
        return r0.noConfiguredAppStatus();
    L21:
        r2 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r5.f21472b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r0 = (SkillOpenAppManagementActivity) ZeusTransformUtils.preCheckCast(r5.f21471a, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        o.a(r6);
        Object r11 = ((d.n) ZeusTransformUtils.preCheckCast(r6, d.n.class, "com.obric.aiagent.plugin")).a();
    L25:
        Throwable r12 = d.n.c(r11);
        if (r12 != null) goto L57;
        com.obric.aiagent.skill.credentials.api.b r13 = (com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L31;
        ILogDepend.Companion.i(TAG, "loadStatus no configured lark app");
        return r0.noConfiguredAppStatus();
    L31:
        ISkillCredentialService.a r14 = r2.getAccount();
        com.obric.aiagent.skill.credentials.api.f r17 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r5.f21471a = r0;
        r5.f21472b = r2;
        r5.f21473c = r13;
        r5.f = 3;
        r9 = r14.b(r17, r5);
        if (r9 != r7) goto L34;
        return r7;
    L34:
        r16 = r13;
        goto L35
    L57:
        if (r0.isAppConfigurationConflict(r12) == false) goto L63;
        r5.f21471a = r0;
        r5.f21472b = null;
        r5.f = 2;
        if (r0.cleanupConfiguredAppAfterPreflightConflict(r2, "getConfiguredApp", r12, r5) != r7) goto L62;
        return r7;
    L63:
        throw r12;
    L22:
        o.a(r6);
        ISkillCredentialService.b r18 = r2.getApps();
        com.obric.aiagent.skill.credentials.api.f r19 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r5.f21471a = r0;
        r5.f21472b = r2;
        r5.f = 1;
        r11 = r18.a(r19, r5);
        if (r11 != r7) goto L25;
        return r7;
    L7:
        r5 = new c(r0, r4);
        goto L8
    }

    private final Object cleanupConfiguredAppAfterPreflightConflict(ISkillCredentialService r5, String r6, Throwable r7, d.c.d<? super x> r8) {
        ISkillCredentialService r9 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r11 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L8;
        com.obric.aiagent.skill.credentials.api.h r12 = r11.a();
    L9:
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("loadStatus recover app conflict method=").append(r6).append(" code=");
        if (r12 == null) goto L12;
        Integer r3 = r12.b();
    L13:
        StringBuilder r4 = r1.append(r3).append(" subtype=");
        if (r12 == null) goto L16;
        r2 = r12.c();
    L16:
        r0.w(TAG, r4.append(r2).toString());
        Object r13 = resetConfiguredApp(r9, "preflight " + r6, r10);
        if (r13 != d.c.a.b.a()) goto L20;
        return r13;
    L20:
        return x.f38692a;
    L12:
        r3 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    private final boolean isAppConfigurationConflict(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r1 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L12;
        com.obric.aiagent.skill.credentials.api.h r3 = r1.a();
        if (r3 != null) goto L11;
        return false;
    L11:
        return com.obric.aiagent.skill.credentials.api.d.a(r3);
    L12:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    private final com.obric.aiagent.skill.credentials.api.a noConfiguredAppStatus() {
        return new com.obric.aiagent.skill.credentials.api.a(null, false, d.a.p.b(), null, null);
    }

    private final void refreshStatus() {
        ISkillCredentialService r0 = ISkillCredentialService.Companion.a();
        if (r0 != null) goto L6;
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_credentials_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_credentials_unavailable"));
        d.h.b.o.c(r1, "getString(...)");
        renderError(r1);
        return;
    L6:
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r0, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void renderRunning() {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f.setEnabled(false);
        renderCredentialItems("", "");
        com.obric.aiagent.skill.ovirt.impl.b.c r4 = this.binding;
        if (r4 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.g.setVisibility(8);
        return;
    L8:
        r1 = r4;
        goto L9
    }

    static /* synthetic */ void renderIdle$default(SkillOpenAppManagementActivity r1, String r2, int r3, Object r4) {
        SkillOpenAppManagementActivity r5 = (SkillOpenAppManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillOpenAppManagementActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        r5.renderIdle(r2);
    }

    private final void renderIdle(String r6) {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f.setEnabled(true);
        renderCredentialItems("", "");
        com.obric.aiagent.skill.ovirt.impl.b.c r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        r2.g.setVisibility(8);
        com.obric.aiagent.skill.ovirt.impl.b.c r5 = this.binding;
        if (r5 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        r1.g.setEnabled(true);
        if (r6 == null) goto L16;
        ILogDepend.Companion.i(TAG, "render idle notice: " + r6);
        return;
    L16:
        return;
    L11:
        r1 = r5;
        goto L12
    }

    private final void renderError(String r5) {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f.setEnabled(true);
        renderCredentialItems("", "");
        com.obric.aiagent.skill.ovirt.impl.b.c r4 = this.binding;
        if (r4 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.g.setVisibility(8);
        if (IAppContext.Companion.isDebug() == false) goto L12;
        ILogDepend.Companion.w(TAG, "render error: " + r5);
        return;
    L12:
        ILogDepend.Companion.w(TAG, "render error");
        return;
    L8:
        r1 = r4;
        goto L9
    }

    private final void renderCredentialItems(String r6, String r7) {
        com.obric.aiagent.skill.ovirt.impl.b.c r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f21124d.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.c r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        r2.f21124d.showSubTitle(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")));
        com.obric.aiagent.skill.ovirt.impl.b.c r8 = this.binding;
        if (r8 != null) goto L11;
        d.h.b.o.c("binding");
        r8 = null;
    L11:
        r8.f21125e.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.c r5 = this.binding;
        if (r5 != null) goto L14;
        d.h.b.o.c("binding");
    L15:
        r1.f21125e.showSubTitle(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")));
        return;
    L14:
        r1 = r5;
        goto L15
    }

    private final boolean isActiveSession(String r3) {
        if (d.h.b.o.a(r3, this.activeSessionId) == false) goto L13;
        ca r2 = this.authJob;
        if (r2 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L13;
        return true;
    L7:
        if (r2.b() != true) goto L9;
        r4 = true;
    L13:
        return false;
    }

    private final void logFailure(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.w(TAG, r2);
    }
}
