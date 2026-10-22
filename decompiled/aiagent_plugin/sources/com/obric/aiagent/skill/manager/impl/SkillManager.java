package com.obric.aiagent.skill.manager.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.ttnet.ITTNetFileTransfer;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillManager implements ISkillManagerService {
    public static final b Companion = null;
    private static final long ORPHAN_STALE_MILLIS = 86400000;
    private final d.f appContext$delegate;
    private final d.f cliUpdateRepository$delegate;
    private final cw configStore;
    private final d.f coverStore$delegate;
    private final Object createLock;
    private final d.h.a.a<String> currentUserNameProvider;
    private final d.f decisionStore$delegate;
    private final d.f existencePolicyRemoteSource$delegate;
    private final d.f fileStore$delegate;
    private final d.f installedSkillRegistry$delegate;
    private final d.f loadHooks$delegate;
    private final d.f metadataStore$delegate;
    private final d.h.a.a<Long> nowMillis;
    private final d.f obricManifestReader$delegate;
    private final d.f persistentRepository$delegate;
    private final d.f shopRepository$delegate;
    private final d.f signingRefreshCoordinator$delegate;
    private final d.f signingRepository$delegate;
    private final d.f signingScope$delegate;
    private final d.f skillUpdateCoordinator$delegate;
    private final Object startLock;
    private volatile boolean started;
    private final Object[] storeInstallLocks;
    private final d.f storeMetadataRefreshCoordinator$delegate;
    private final d.f trackingReporter$delegate;

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f19332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.i f19333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f19334c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19332a, r6.f19332a) == true) goto L12;
            return false;
        L12:
            if (this.f19333b == r6.f19333b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19334c, r6.f19334c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f19332a.hashCode() * 31) + this.f19333b.hashCode()) * 31;
            Integer r2 = this.f19334c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "ApplyCommit(skill=" + this.f19332a + ", changeType=" + this.f19333b + ", previousVersion=" + this.f19334c + ')';
        }

        public a(com.obric.aiagent.skill.manager.api.e r2, com.obric.aiagent.skill.manager.api.i r3, Integer r4) {
            d.h.b.o.e(r2, "skill");
            d.h.b.o.e(r3, "changeType");
            this.f19332a = r2;
            this.f19333b = r3;
            this.f19334c = r4;
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f19332a;
        }

        public final com.obric.aiagent.skill.manager.api.i b() {
            return this.f19333b;
        }

        public final com.obric.aiagent.skill.manager.api.l a(com.obric.aiagent.skill.manager.api.e r8, com.obric.aiagent.skill.manager.api.r r9) {
            d.h.b.o.e(r8, "skill");
            if (this.f19333b == com.obric.aiagent.skill.manager.api.i.f19264c) goto L5;
            boolean r1 = true;
        L7:
            return new com.obric.aiagent.skill.manager.api.l(r1, this.f19333b, r8, this.f19334c, r9);
        L5:
            r1 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class aa extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final aa f19335a = null;

        static {
            f19335a = new aa();
        }

        aa() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {1383}, d = "prepareInstalledSkillProjection", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class ab extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillManager f19339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19340e;

        ab(SkillManager r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19339d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19338c = r3;
            this.f19340e |= Integer.MIN_VALUE;
            return this.f19339d.prepareInstalledSkillProjection((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class ac extends d.h.b.l implements d.h.a.b<File, d.x> {
        ac(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.ag.class, "releaseSkillProjectionPackage", "releaseSkillProjectionPackage(Ljava/io/File;)V", 0);
        }

        public final void a(File r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.manager.impl.ag) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ag.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(File r3) {
            a((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {1215}, d = "refreshModificationSecurityOrThrow", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class ad extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillManager f19344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19345e;

        ad(SkillManager r3, d.c.d<? super ad> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19344d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19343c = r3;
            this.f19345e |= Integer.MIN_VALUE;
            return SkillManager.access$refreshModificationSecurityOrThrow(this.f19344d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {2554}, d = "refreshSkillSignatures$impl_release", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class ae extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillManager f19349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19350e;

        ae(SkillManager r3, d.c.d<? super ae> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19349d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19348c = r3;
            this.f19350e |= Integer.MIN_VALUE;
            return this.f19349d.refreshSkillSignatures$impl_release(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {2822}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManager$scheduleDefaultStoreSkillBootstrap$1")
    static final class af extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f19352b;

        af(SkillManager r3, d.c.d<? super af> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19352b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((af) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), af.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new af(this.f19352b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19351a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r12);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            com.obric.aiagent.skill.manager.api.al r13 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
            if (br.f19586a.c() == true) goto L20;
        L75:
            SkillManager.access$logInfo(this.f19352b, "Default Store Skill bootstrap skipped by config", "Default Store Skill bootstrap skipped by config: skillEnabled=" + r13.w() + ", automaticMaintenanceEnabled=" + r13.D());
            return d.x.f38692a;
        L20:
            if (r13.D() == false) goto L75;
            com.obric.aiagent.skill.manager.api.r r2 = com.obric.aiagent.skill.manager.api.r.n;
            com.obric.aiagent.skill.manager.api.u r3 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(SkillManager.access$getShopRepository(this.f19352b).c()), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25 CancellationException -> L73
        L28:
            if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L68;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L31:
            if (r15.hasNext() == false) goto L35;
            Object r5 = r15.next();
            if (bl.f19568a.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a()) == false) goto L31;
            r4.add(r5);
            goto L31
        L35:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.manager.api.r r6 = com.obric.aiagent.skill.manager.api.r.o;
            com.obric.aiagent.skill.manager.api.u r7 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.c.b.a.b.a(SkillManager.access$reconcileBuiltinStoreSkillRemovability(this.f19352b, r16))), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38 CancellationException -> L65
        L41:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L60;
            SkillManager.access$logInfo(this.f19352b, "Default Store Skill removability reconciled updated=" + ((Number) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue(), "Default Store Skill removability reconciled: builtin=" + r16.size() + ", updated=" + ((Number) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue());
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            SkillManager r11 = this.f19352b;
            Iterator r18 = r17.iterator();
        L44:
            if (r18.hasNext() == false) goto L58;
            com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
            String r8 = r9.a();
            if (br.f19586a.c() == false) goto L47;
            com.obric.aiagent.skill.manager.api.u r10 = SkillManager.access$installStoreSkill(r11, r8, r9.d(), com.obric.aiagent.skill.manager.api.au.f19235b, null, r9, d.c.b.a.b.a(false));
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.b.class) == true) goto L51;
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L56;
            SkillManager.access$logWarning(r11, "Default Store Skill reconciliation failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Default Store Skill reconciliation failed: slug=" + r8 + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() + ", retryable=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b());
            goto L44
        L56:
            throw new d.k();
        L51:
            com.obric.aiagent.skill.manager.api.av r19 = (com.obric.aiagent.skill.manager.api.av) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.av.class, "com.obric.aiagent.plugin");
            SkillManager.access$logInfo(r11, "Default Store Skill reconciliation completed change=" + r19.a() + ", enabled=" + r19.b().l(), "Default Store Skill reconciliation completed: slug=" + r8 + ", version=" + r19.b().j() + ", change=" + r19.a() + ", enabled=" + r19.b().l());
            goto L44
        L47:
            SkillManager.access$logInfo(r11, "Default Store Skill bootstrap stopped by feature gate", "Default Store Skill bootstrap stopped by feature gate: slug=" + r8);
            return d.x.f38692a;
        L58:
            return d.x.f38692a;
        L60:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L64;
            SkillManager.access$logWarning(this.f19352b, "Default Store Skill removability reconciliation failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Default Store Skill removability reconciliation failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() + ", retryable=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b());
            return d.x.f38692a;
        L64:
            throw new d.k();
        L65:
            e = move-exception;
            throw e;
        L38:
            e = move-exception;
            com.obric.aiagent.skill.manager.api.u.a r20 = dm.a(e, "default_store_skill_reconcile_removable", r6);
            dm.a("default_store_skill_reconcile_removable", r20.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r7 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r20, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            goto L41
        L68:
            if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L72;
            SkillManager.access$logWarning(this.f19352b, "Default Store Skill builtin list failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Default Store Skill builtin list failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() + ", retryable=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b());
            return d.x.f38692a;
        L72:
            throw new d.k();
        L73:
            e = move-exception;
            throw e;
        L25:
            e = move-exception;
            com.obric.aiagent.skill.manager.api.u.a r21 = dm.a(e, "default_store_skill_list_builtin", r2);
            dm.a("default_store_skill_list_builtin", r21.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r3 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r21, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            goto L28
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r12);
            AutoActionFoundation r110 = AutoActionFoundation.INSTANCE;     // Catch: Exception -> L7 CancellationException -> L9
            d.c.d<? super d.x> r22 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            this.f19351a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            if (r110.suspendUntilReady(r22) != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            SkillManager.access$logFailure(this.f19352b, "Default Store Skill bootstrap foundation wait failed", "Default Store Skill bootstrap foundation wait failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {3200}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManager$scheduleSignatureRefresh$1")
    static final class ag extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f19354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19355c;

        ag(SkillManager r3, String r4, d.c.d<? super ag> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19354b = r3;
            this.f19355c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ag) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ag.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ag(this.f19354b, this.f19355c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19353a;
            boolean r2 = true;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r7);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            com.obric.aiagent.skill.manager.api.u r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L35;
            com.obric.aiagent.skill.manager.api.an r9 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(d.a.p.l(((com.obric.aiagent.skill.manager.api.ao) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.ao.class, "com.obric.aiagent.plugin")).a()), com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (r9 == null) goto L41;
            if (r9.b() == com.obric.aiagent.skill.manager.api.am.g) goto L26;
            r2 = false;
        L26:
            if (r2 == true) goto L29;
            r9 = null;
        L29:
            if (r9 == null) goto L41;
            SkillManager r3 = this.f19354b;     // Catch: Exception -> L7 CancellationException -> L9
            StringBuilder r4 = new StringBuilder().append("Skill signing refresh failed: slug=").append(this.f19355c).append(", error=");     // Catch: Exception -> L7 CancellationException -> L9
            String r10 = r9.c();     // Catch: Exception -> L7 CancellationException -> L9
            if (r10 != null) goto L33;
            r10 = "";
        L33:
            SkillManager.access$logWarning(r3, "Skill signing refresh failed", r4.append(r10).toString());     // Catch: Exception -> L7 CancellationException -> L9
        L41:
            return d.x.f38692a;
        L35:
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L38;
            SkillManager.access$logWarning(this.f19354b, "Skill signing refresh failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Skill signing refresh failed: slug=" + this.f19355c + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L7 CancellationException -> L9
            goto L41
        L38:
            throw new d.k();     // Catch: Exception -> L7 CancellationException -> L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r7);
            SkillManager r11 = this.f19354b;     // Catch: Exception -> L7 CancellationException -> L9
            com.obric.aiagent.skill.manager.api.ap r5 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.ap.b(d.a.ax.a(this.f19355c)), com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            aw r6 = aw.f19532c;     // Catch: Exception -> L7 CancellationException -> L9
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            this.f19353a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r7 = r11.refreshSkillSignatures$impl_release(r5, r6, r12);     // Catch: Exception -> L7 CancellationException -> L9
            if (r7 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            SkillManager.access$logFailure(this.f19354b, "Scheduled Skill signing refresh escaped result boundary", "Scheduled Skill signing refresh escaped result boundary: slug=" + this.f19355c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L41
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManager$scheduleStartupCleanup$1")
    static final class ah extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f19357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19358c;

        ah(SkillManager r3, String r4, d.c.d<? super ah> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19357b = r3;
            this.f19358c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ah) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ah.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ah(this.f19357b, this.f19358c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            d.c.a.b.a();
            if (this.f19356a != 0) goto L15;
            d.o.a(r24);
            ea r14 = new ea(dy.o, SkillManager.access$getTrackingReporter(this.f19357b), null, 0, this.f19358c, 0, false, 108, null);
            at r0 = au.a(SkillManager.access$getCoverStore(this.f19357b), SkillManager.access$getMetadataStore(this.f19357b).b(), SkillManager.ORPHAN_STALE_MILLIS, 0, 4, null);     // Catch: Exception -> L7 CancellationException -> L11
            SkillManager.access$finishBackgroundCleanup(this.f19357b, r14, "cover", "cover_delete", r0.a(), r0.b());     // Catch: Exception -> L7 CancellationException -> L11
        L10:
            return d.x.f38692a;
        L11:
            e = move-exception;
            ea.a(r14, dz.f19793c, null, null, null, null, null, dw.n, "cover_delete", d.c.b.a.b.a(false), d.c.b.a.b.a(false), SkillManager.access$backgroundCleanupDimensions(this.f19357b, "cover", 0, 0), 62, null);
            throw e;
        L7:
            e = move-exception;
            ea.a(r14, dz.f19792b, null, null, null, null, null, dw.i, "cover_delete", d.c.b.a.b.a(true), d.c.b.a.b.a(false), SkillManager.access$backgroundCleanupDimensions(this.f19357b, "cover", 0, 0), 62, null);
            SkillManager.access$logFailure(this.f19357b, "Skill cover cleanup failed during initialization", "Skill cover cleanup failed during initialization", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L10
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManager$scheduleStartupCleanup$2")
    static final class ai extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f19360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19361c;

        ai(SkillManager r3, String r4, d.c.d<? super ai> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19360b = r3;
            this.f19361c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ai) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ai.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ai(this.f19360b, this.f19361c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            d.c.a.b.a();
            if (this.f19359a != 0) goto L15;
            d.o.a(r25);
            ea r15 = new ea(dy.o, SkillManager.access$getTrackingReporter(this.f19360b), null, 0, this.f19361c, 0, false, 108, null);
            cg r16 = cg.f19656a;     // Catch: Exception -> L7 CancellationException -> L11
            File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(SkillManager.access$getAppContext(this.f19360b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir();     // Catch: Exception -> L7 CancellationException -> L11
            d.h.b.o.c(r0, "getCacheDir(...)");     // Catch: Exception -> L7 CancellationException -> L11
            ch r1 = cg.a(r16, r0, SkillManager.ORPHAN_STALE_MILLIS, 0, 4, null);     // Catch: Exception -> L7 CancellationException -> L11
            SkillManager.access$finishBackgroundCleanup(this.f19360b, r15, "import_temp", "import_temp_delete", r1.a(), r1.b());     // Catch: Exception -> L7 CancellationException -> L11
        L10:
            return d.x.f38692a;
        L11:
            e = move-exception;
            ea.a(r15, dz.f19793c, null, null, null, null, null, dw.n, "import_temp_delete", d.c.b.a.b.a(false), d.c.b.a.b.a(false), SkillManager.access$backgroundCleanupDimensions(this.f19360b, "import_temp", 0, 0), 62, null);
            throw e;
        L7:
            e = move-exception;
            ea.a(r15, dz.f19792b, null, null, null, null, null, dw.i, "import_temp_delete", d.c.b.a.b.a(true), d.c.b.a.b.a(false), SkillManager.access$backgroundCleanupDimensions(this.f19360b, "import_temp", 0, 0), 62, null);
            SkillManager.access$logFailure(this.f19360b, "Skill import temporary directory cleanup failed during initialization", "Skill import temporary directory cleanup failed during initialization", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L10
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class aj extends d.h.b.l implements d.h.a.m<String, Boolean, com.obric.aiagent.skill.manager.api.e> {
        aj(Object r8) {
            super(2, r8, com.obric.aiagent.skill.manager.impl.v.class, "setEnabled", "setEnabled(Ljava/lang/String;Z)Lcom/obric/aiagent/skill/manager/api/Skill;", 0);
        }

        public final com.obric.aiagent.skill.manager.api.e a(String r3, boolean r4) {
            d.h.b.o.e(r3, "p0");
            return ((com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin")).a(r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ com.obric.aiagent.skill.manager.api.e invoke(String r3, Boolean r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class ak extends d.h.b.l implements d.h.a.m<com.obric.aiagent.skill.manager.api.e, Boolean, d.x> {
        ak(Object r8) {
            super(2, r8, hd.class, "reportItemSwitch", "reportItemSwitch(Lcom/obric/aiagent/skill/manager/api/Skill;Z)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.api.e r3, boolean r4) {
            d.h.b.o.e(r3, "p0");
            ((hd) ZeusTransformUtils.preCheckCast(this.receiver, hd.class, "com.obric.aiagent.plugin")).a(r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.api.e r3, Boolean r4) {
            a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class al extends d.h.b.l implements d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> {
        al(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.v.class, "findSkill", "findSkill(Ljava/lang/String;)Lcom/obric/aiagent/skill/manager/api/Skill;", 0);
        }

        public final com.obric.aiagent.skill.manager.api.e a(String r3) {
            d.h.b.o.e(r3, "p0");
            return ((com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin")).b(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.aiagent.skill.manager.api.e invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class am extends d.h.b.l implements d.h.a.q<com.obric.aiagent.skill.manager.api.e, aw, d.c.d<? super com.obric.aiagent.skill.manager.api.an>, Object> {
        am(Object r8) {
            super(3, r8, gm.class, "refresh", "refresh(Lcom/obric/aiagent/skill/manager/api/Skill;Lcom/obric/aiagent/skill/manager/impl/SkillDecisionRefreshSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(com.obric.aiagent.skill.manager.api.e r3, aw r4, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r5) {
            d.c.d<? super com.obric.aiagent.skill.manager.api.an> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return ((gm) ZeusTransformUtils.preCheckCast(this.receiver, gm.class, "com.obric.aiagent.plugin")).a(r3, r4, r6);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.manager.api.e r3, aw r4, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r5) {
            return a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), (aw) ZeusTransformUtils.preCheckCast(r4, aw.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class an extends d.h.b.l implements d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> {
        an(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.v.class, "findSkill", "findSkill(Ljava/lang/String;)Lcom/obric/aiagent/skill/manager/api/Skill;", 0);
        }

        public final com.obric.aiagent.skill.manager.api.e a(String r3) {
            d.h.b.o.e(r3, "p0");
            return ((com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin")).b(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.aiagent.skill.manager.api.e invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class ao extends d.h.b.l implements d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> {
        ao(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.v.class, "findSkill", "findSkill(Ljava/lang/String;)Lcom/obric/aiagent/skill/manager/api/Skill;", 0);
        }

        public final com.obric.aiagent.skill.manager.api.e a(String r3) {
            d.h.b.o.e(r3, "p0");
            return ((com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin")).b(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.aiagent.skill.manager.api.e invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class ap extends d.h.b.l implements d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> {
        ap(Object r8) {
            super(1, r8, ft.class, "searchSkillPresentationBySlug", "searchSkillPresentationBySlug(Ljava/lang/String;)Lcom/obric/aiagent/skill/manager/api/Skill;", 0);
        }

        public final com.obric.aiagent.skill.manager.api.e a(String r3) {
            d.h.b.o.e(r3, "p0");
            return ((ft) ZeusTransformUtils.preCheckCast(this.receiver, ft.class, "com.obric.aiagent.plugin")).c(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.aiagent.skill.manager.api.e invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ String a(b r0) {
            return r0.a();
        }

        private final String a() {
            if (com.obric.aiagent.utils.shared_state.b.f22344a.a() == true) goto L7;
            return null;
        L7:
            return com.obric.aiagent.utils.shared_state.b.f22344a.c();
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class c extends IllegalArgumentException {
        public c(String r3) {
            d.h.b.o.e(r3, "reason");
            super("Invalid Obric package: " + r3);
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class d extends IllegalStateException {
        public d() {
            super("Required CLI package is missing");
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class e implements com.obric.aiagent.skill.manager.api.aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.aiagent.skill.manager.api.ac> f19362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<com.obric.aiagent.skill.manager.api.ad> f19363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.ae f19364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.h.a.b<File, d.x> f19365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicBoolean f19366e;

        public e(List<com.obric.aiagent.skill.manager.api.ac> r3, List<com.obric.aiagent.skill.manager.api.ad> r4, com.obric.aiagent.skill.manager.api.ae r5, d.h.a.b<? super File, d.x> r6) {
            List<com.obric.aiagent.skill.manager.api.ac> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<com.obric.aiagent.skill.manager.api.ad> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.a.b<File, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "items");
            d.h.b.o.e(r8, "failures");
            d.h.b.o.e(r5, "metrics");
            d.h.b.o.e(r9, "release");
            this.f19362a = r7;
            this.f19363b = r8;
            this.f19364c = r5;
            this.f19365d = r9;
            this.f19366e = new AtomicBoolean(false);
        }

        @Override // com.obric.aiagent.skill.manager.api.aa
        public List<com.obric.aiagent.skill.manager.api.ac> a() {
            return this.f19362a;
        }

        @Override // com.obric.aiagent.skill.manager.api.aa
        public List<com.obric.aiagent.skill.manager.api.ad> b() {
            return this.f19363b;
        }

        @Override // com.obric.aiagent.skill.manager.api.aa
        public com.obric.aiagent.skill.manager.api.ae c() {
            return this.f19364c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f19366e.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L7:
            if (r0.hasNext() == false) goto L16;
            com.obric.aiagent.skill.manager.api.ac r1 = (com.obric.aiagent.skill.manager.api.ac) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.skill.manager.api.ac.class, "com.obric.aiagent.plugin");
            this.f19365d.invoke(r1.b());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (IAppContext.Companion.isDebug() == true) goto L14;
            ILogDepend.Companion.w("SkillManager", "Projection package release failed");
            goto L7
        L14:
            ILogDepend.Companion.w("SkillManager", "Projection package release failed", th);
            goto L7
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.aiagent.skill.manager.api.ab> f19367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19368b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19367a, r6.f19367a) == true) goto L12;
            return false;
        L12:
            if (this.f19368b == r6.f19368b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19367a.hashCode() * 31) + Integer.hashCode(this.f19368b);
        }

        public String toString() {
            return "SkillCliResolution(tools=" + this.f19367a + ", missingCount=" + this.f19368b + ')';
        }

        public f(List<com.obric.aiagent.skill.manager.api.ab> r3, int r4) {
            List<com.obric.aiagent.skill.manager.api.ab> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "tools");
            this.f19367a = r5;
            this.f19368b = r4;
        }

        public final List<com.obric.aiagent.skill.manager.api.ab> a() {
            return this.f19367a;
        }

        public final int b() {
            return this.f19368b;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f19369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f19370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f19371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f19372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19373e;
        private int f;
        private int g;
        private int h;
        private int i;

        public g() {
        }

        public final void a(long r1) {
            this.f19369a = r1;
        }

        public final void b(long r1) {
            this.f19370b = r1;
        }

        public final void c(long r1) {
            this.f19371c = r1;
        }

        public final void a(int r1) {
            this.f19372d = r1;
        }

        public final void b(int r1) {
            this.f19373e = r1;
        }

        public final int a() {
            return this.f;
        }

        public final void c(int r1) {
            this.f = r1;
        }

        public final int b() {
            return this.g;
        }

        public final void d(int r1) {
            this.g = r1;
        }

        public final int c() {
            return this.h;
        }

        public final void e(int r1) {
            this.h = r1;
        }

        public final int d() {
            return this.i;
        }

        public final void f(int r1) {
            this.i = r1;
        }

        public final com.obric.aiagent.skill.manager.api.ae e() {
            return new com.obric.aiagent.skill.manager.api.ae(this.f19369a, this.f19370b, this.f19371c, this.f19372d, this.f19373e, this.f, this.g, this.h, this.i);
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f19374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.w f19375b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19374a, r6.f19374a) == true) goto L12;
            return false;
        L12:
            if (this.f19375b == r6.f19375b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19374a.hashCode() * 31) + this.f19375b.hashCode();
        }

        public String toString() {
            return "WebPackageInstallCommit(skill=" + this.f19374a + ", changeType=" + this.f19375b + ')';
        }

        public h(com.obric.aiagent.skill.manager.api.e r2, com.obric.aiagent.skill.manager.api.w r3) {
            d.h.b.o.e(r2, "skill");
            d.h.b.o.e(r3, "changeType");
            this.f19374a = r2;
            this.f19375b = r3;
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f19374a;
        }

        public final com.obric.aiagent.skill.manager.api.w b() {
            return this.f19375b;
        }

        public final com.obric.aiagent.skill.manager.api.y a(com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.api.r r4) {
            d.h.b.o.e(r3, "skill");
            return new com.obric.aiagent.skill.manager.api.y(true, this.f19375b, r3, r4);
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    public /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19376a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19377b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f19378c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f19379d = null;

        static {
            int[] r0 = new int[ec.values().length];
            r0[ec.f19804a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[ec.f19805b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L6:
            f19376a = r0;
            int[] r1 = new int[com.obric.aiagent.skill.manager.api.am.values().length];
            r1[com.obric.aiagent.skill.manager.api.am.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L49:
            r1[com.obric.aiagent.skill.manager.api.am.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L9:
            f19377b = r1;
            int[] r2 = new int[com.obric.aiagent.skill.manager.api.j.values().length];
            r2[com.obric.aiagent.skill.manager.api.j.f19267a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L41:
            r2[com.obric.aiagent.skill.manager.api.j.f19268b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L12:
            f19378c = r2;
            int[] r3 = new int[aq.values().length];
            r3[aq.f19506b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L43:
            r3[aq.f19507c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L33:
            r3[aq.f19508d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L45:
            r3[aq.f19509e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L35:
            r3[aq.f19505a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L18:
            f19379d = r3;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {1101}, d = "applySkillChange", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f19383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SkillManager f19384e;
        int f;

        j(SkillManager r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19384e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19383d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f19384e.applySkillChange(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.a<d.x> {
        k(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.a<d.x> {
        l(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {1143, 1178}, d = "applyStagedSkillChange", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f19389e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ SkillManager i;
        int j;

        m(SkillManager r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return SkillManager.access$applyStagedSkillChange(this.i, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class n extends d.h.b.l implements d.h.a.a<d.x> {
        n(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class o extends d.h.b.l implements d.h.a.a<String> {
        o(Object r8) {
            super(0, r8, b.class, "currentDoubaoNickName", "currentDoubaoNickName()Ljava/lang/String;", 0);
        }

        public final String a() {
            return b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class p extends d.h.b.l implements d.h.a.b<String, Boolean> {
        p(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.ag.class, "deleteSkill", "deleteSkill(Ljava/lang/String;)Z", 0);
        }

        public final Boolean a(String r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(((com.obric.aiagent.skill.manager.impl.ag) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ag.class, "com.obric.aiagent.plugin")).c(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class q extends d.h.b.l implements d.h.a.b<String, Boolean> {
        q(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.v.class, "removeInstalledSkill", "removeInstalledSkill(Ljava/lang/String;)Z", 0);
        }

        public final Boolean a(String r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(((com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin")).a(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class r extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> {
        r(Object r8) {
            super(1, r8, hd.class, "reportSkillDelete", "reportSkillDelete(Lcom/obric/aiagent/skill/manager/api/Skill;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.api.e r3) {
            d.h.b.o.e(r3, "p0");
            ((hd) ZeusTransformUtils.preCheckCast(this.receiver, hd.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.api.e r3) {
            a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {2760}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManager$ensureReadyInternal$1$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f19391b;

        s(SkillManager r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19391b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f19391b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19390a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r7);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            com.obric.aiagent.skill.manager.api.u r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L23;
            a("SkillManager", "Startup Skill signing refresh failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L7 CancellationException -> L9
        L23:
            return d.x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r7);
            SkillManager r9 = this.f19391b;     // Catch: Exception -> L7 CancellationException -> L9
            com.obric.aiagent.skill.manager.api.ap r2 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.ap.a.f19210a, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            aw r4 = aw.f19531b;     // Catch: Exception -> L7 CancellationException -> L9
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            this.f19390a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r7 = r9.refreshSkillSignatures$impl_release(r2, r4, r5);     // Catch: Exception -> L7 CancellationException -> L9
            if (r7 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            SkillManager.access$logFailure(this.f19391b, "Startup Skill signing refresh escaped result boundary", "Startup Skill signing refresh escaped result boundary", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L23
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class t extends d.h.b.l implements d.h.a.a<d.x> {
        t(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {861}, d = "installSkillPackage", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class u extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f19396e;
        /* synthetic */ Object f;
        final /* synthetic */ SkillManager g;
        int h;

        u(SkillManager r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.installSkillPackage(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class v extends d.h.b.l implements d.h.a.a<d.x> {
        v(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    /* synthetic */ class w extends d.h.b.l implements d.h.a.a<d.x> {
        w(Object r8) {
            super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
        }

        public final void a() {
            kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED}, d = "installStagedSkillPackage", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class x extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillManager f19400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19401e;

        x(SkillManager r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19400d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f19399c = r7;
            this.f19401e |= Integer.MIN_VALUE;
            return SkillManager.access$installStagedSkillPackage(this.f19400d, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {1990}, d = "loadSkill", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class y extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillManager f19404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19405d;

        y(SkillManager r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19404c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19403b = r3;
            this.f19405d |= Integer.MIN_VALUE;
            return this.f19404c.loadSkill(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManager.kt */
    @d.c.b.a.f(b = "SkillManager.kt", c = {2069}, d = "loadSkillInternal", e = "com.obric.aiagent.skill.manager.impl.SkillManager")
    static final class z extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f19410e;
        /* synthetic */ Object f;
        final /* synthetic */ SkillManager g;
        int h;

        z(SkillManager r3, d.c.d<? super z> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return SkillManager.access$loadSkillInternal(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$0DKu0klZ-RdpCTCk1GYMnMOV9Ug, reason: not valid java name */
    public static /* synthetic */ Context m259lambda$0DKu0klZRdpCTCk1GYMnMOV9Ug() {
        return appContext_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$20o5lvRxPvKtnI-vwYztrztLwJw, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.api.u m260lambda$20o5lvRxPvKtnIvwYztrztLwJw(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1, hg r2, com.obric.aiagent.skill.manager.impl.ao r3) {
        return skillUpdateCoordinator_delegate$lambda$19$lambda$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.w lambda$4NRRmHuV5UwtEFYZ6x8_UZjsiI4() {
        return decisionStore_delegate$lambda$8();
    }

    /* JADX INFO: renamed from: lambda$4pY43hQ9Osou9uXPFaRY1aAE-yk, reason: not valid java name */
    public static /* synthetic */ d.x m261lambda$4pY43hQ9Osou9uXPFaRY1aAEyk(SkillManager r0, eg r1) {
        return signingRepository_delegate$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ gt lambda$4y98K2eHZkuchv84UgbXt7hEWgs(SkillManager r0) {
        return storeMetadataRefreshCoordinator_delegate$lambda$21(r0);
    }

    /* JADX INFO: renamed from: lambda$59-h7eniBfcV1T_uUzwKW956Xsg, reason: not valid java name */
    public static /* synthetic */ gm m262lambda$59h7eniBfcV1T_uUzwKW956Xsg(SkillManager r0) {
        return signingRepository_delegate$lambda$13(r0);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.p lambda$AglxVMgQaFzLCwUICtXN2zz1tDw(SkillManager r0) {
        return cliUpdateRepository_delegate$lambda$14(r0);
    }

    public static /* synthetic */ Boolean lambda$CtZ8mRLsfDMFm8rwDksgOVKaTes(com.obric.aiagent.skill.manager.api.k r0, SkillManager r1) {
        return applyStagedSkillChange$lambda$42(r0, r1);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$HLttwXn5vAN541vACIi5YNgkxtw(SkillManager r0, com.obric.aiagent.skill.manager.api.d r1, d.h.a.a r2, com.obric.aiagent.skill.manager.api.e r3) {
        return importSkillInternal$lambda$63$lambda$62(r0, r1, r2, r3);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$Hmkg1etarJg7KzCxN7ji8N3Ix5s(SkillManager r0, d.h.a.a r1, com.obric.aiagent.skill.manager.api.e r2) {
        return createSkillInternal$lambda$31$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.ac lambda$LgQ05XC97BDohl6UbiOa_wX63rc(SkillManager r0) {
        return obricManifestReader_delegate$lambda$5(r0);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$MLojPRv2ZVW2fgyZuPZvLq2NyJc(SkillManager r0, cf r1, d.h.a.a r2, com.obric.aiagent.skill.manager.api.e r3) {
        return applyCreatedOVirtPackage$lambda$49(r0, r1, r2, r3);
    }

    public static /* synthetic */ kotlinx.coroutines.am lambda$OP3t6rYrNC1xkF1XniOgvebZ_mE() {
        return signingScope_delegate$lambda$15();
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.v lambda$PfWWs2CK2RO4U_z5WJhfwXVAvag(SkillManager r0) {
        return installedSkillRegistry_delegate$lambda$9(r0);
    }

    /* JADX INFO: renamed from: lambda$PvFegETy4UO9D_z-4DSBkn-fDxI, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.b m263lambda$PvFegETy4UO9D_z4DSBknfDxI(SkillManager r0) {
        return fileStore_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$QGoo4BdKdv0LgKFM3IOCY-55AG8, reason: not valid java name */
    public static /* synthetic */ hf m264lambda$QGoo4BdKdv0LgKFM3IOCY55AG8(SkillManager r0) {
        return skillUpdateCoordinator_delegate$lambda$19(r0);
    }

    public static /* synthetic */ fx lambda$RMxQVl9kcfVO63ZAiGEE1ls7ukc(SkillManager r0) {
        return signingRefreshCoordinator_delegate$lambda$16(r0);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$TPf8Wo2Ay1pPtC_iPct3P99Dzk8(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return storeMetadataRefreshCoordinator_delegate$lambda$21$lambda$20(r0, r1);
    }

    public static /* synthetic */ Boolean lambda$Tt_jn64k3Uv4XTBmXLFgYmoImMY(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return commitNewLocalSkill$lambda$64(r0, r1);
    }

    public static /* synthetic */ Boolean lambda$XSvc5bjM0jKOtARE5r3PgHieR1g(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return commitUpdatedLocalSkill$lambda$65(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Yk01sy7bhkxqIvgKl-tUDgoOpmw, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e m265lambda$Yk01sy7bhkxqIvgKltUDgoOpmw(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return skillUpdateCoordinator_delegate$lambda$19$lambda$17(r0, r1);
    }

    public static /* synthetic */ au lambda$_E40cheoOumKT9usS3NxXl3Z5yE(SkillManager r0) {
        return coverStore_delegate$lambda$3(r0);
    }

    public static /* synthetic */ d.x lambda$fSzR8ldGEc2CEUDN_8DrTGYK3dE(SkillManager r0, gj r1) {
        return signingRepository_delegate$lambda$13$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ic3pN-X9_VN3O-HUhmCOdEr3Blg, reason: not valid java name */
    public static /* synthetic */ ft m266lambda$ic3pNX9_VN3OHUhmCOdEr3Blg() {
        return shopRepository_delegate$lambda$7();
    }

    public static /* synthetic */ hd lambda$ik2RFMpH3ygDnFWCPm0o7gekYHQ() {
        return trackingReporter_delegate$lambda$10();
    }

    public static /* synthetic */ fo lambda$myx3byTnRuSkPVPydNvCb8M9d4s() {
        return existencePolicyRemoteSource_delegate$lambda$4();
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.ai lambda$ouaYyckhy0wVeqZtWsI69GyZDGI(SkillManager r0) {
        return metadataStore_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$rhWl2-tDO8oP_VOP_rGNMei8wBE, reason: not valid java name */
    public static /* synthetic */ Boolean m267lambda$rhWl2tDO8oP_VOP_rGNMei8wBE(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return installSkillInternal$lambda$28(r0, r1);
    }

    public static /* synthetic */ List lambda$rhsHDplEeWptF_fatmNMgyw4xHY(SkillManager r0) {
        return loadHooks_delegate$lambda$22(r0);
    }

    /* JADX INFO: renamed from: lambda$s4HPJHBoQJedMNl24VtZkp-RxPQ, reason: not valid java name */
    public static /* synthetic */ boolean m268lambda$s4HPJHBoQJedMNl24VtZkpRxPQ(com.obric.aiagent.skill.manager.api.e r0) {
        return reconcileBuiltinStoreSkillRemovability$lambda$96(r0);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$shsbYf970M3Xy8T73GDkheBIokE(SkillManager r0, cf r1, d.h.a.a r2, com.obric.aiagent.skill.manager.api.e r3) {
        return installStagedSkillPackage$lambda$39$lambda$38(r0, r1, r2, r3);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.ag lambda$znfoaWQjgLoY_GcHM25sBeWYfxc(SkillManager r0) {
        return persistentRepository_delegate$lambda$6(r0);
    }

    public SkillManager() {
        this.appContext$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$0DKu0klZRdpCTCk1GYMnMOV9Ug.INSTANCE);
        this.fileStore$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$PvFegETy4UO9D_z4DSBknfDxI(this));
        this.metadataStore$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$ouaYyckhy0wVeqZtWsI69GyZDGI(this));
        this.coverStore$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$_E40cheoOumKT9usS3NxXl3Z5yE(this));
        this.nowMillis = (d.h.a.a) ZeusTransformUtils.preCheckCast(aa.f19335a, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.currentUserNameProvider = (d.h.a.a) ZeusTransformUtils.preCheckCast(new o(Companion), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.existencePolicyRemoteSource$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$myx3byTnRuSkPVPydNvCb8M9d4s.INSTANCE);
        this.obricManifestReader$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$LgQ05XC97BDohl6UbiOa_wX63rc(this));
        this.persistentRepository$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$znfoaWQjgLoY_GcHM25sBeWYfxc(this));
        this.shopRepository$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$ic3pNX9_VN3OHUhmCOdEr3Blg.INSTANCE);
        this.decisionStore$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$4NRRmHuV5UwtEFYZ6x8_UZjsiI4.INSTANCE);
        this.installedSkillRegistry$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$PfWWs2CK2RO4U_z5WJhfwXVAvag(this));
        this.trackingReporter$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$ik2RFMpH3ygDnFWCPm0o7gekYHQ.INSTANCE);
        this.signingRepository$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$59h7eniBfcV1T_uUzwKW956Xsg(this));
        this.cliUpdateRepository$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$AglxVMgQaFzLCwUICtXN2zz1tDw(this));
        this.configStore = cw.f19708a;
        this.signingScope$delegate = d.g.a(d.j.f38505a, $$Lambda$SkillManager$OP3t6rYrNC1xkF1XniOgvebZ_mE.INSTANCE);
        this.signingRefreshCoordinator$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$RMxQVl9kcfVO63ZAiGEE1ls7ukc(this));
        this.skillUpdateCoordinator$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$QGoo4BdKdv0LgKFM3IOCY55AG8(this));
        this.storeMetadataRefreshCoordinator$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$4y98K2eHZkuchv84UgbXt7hEWgs(this));
        this.loadHooks$delegate = d.g.a(d.j.f38505a, new $$Lambda$SkillManager$rhsHDplEeWptF_fatmNMgyw4xHY(this));
        this.startLock = new Object();
        this.createLock = new Object();
        Object[] r1 = new Object[16];
        int r2 = 0;
    L3:
        if (r2 >= 16) goto L5;
        r1[r2] = new Object();
        r2 = r2 + 1;
        goto L3
    L5:
        this.storeInstallLocks = r1;
    }

    public static final /* synthetic */ Object access$applyStagedSkillChange(SkillManager r2, com.obric.aiagent.skill.manager.api.k r3, cf r4, d.h.a.a r5, d.c.d r6) {
        return r2.applyStagedSkillChange(r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Map access$backgroundCleanupDimensions(SkillManager r0, String r1, int r2, int r3) {
        return r0.backgroundCleanupDimensions(r1, r2, r3);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.e access$createSkillInternal(SkillManager r2, com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.api.o r4, d.h.a.a r5) {
        return r2.createSkillInternal(r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ File access$downloadSkillPackage(SkillManager r0, String r1, long r2) {
        return r0.downloadSkillPackage(r1, r2);
    }

    public static final /* synthetic */ void access$finishBackgroundCleanup(SkillManager r0, ea r1, String r2, String r3, int r4, int r5) {
        r0.finishBackgroundCleanup(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Context access$getAppContext(SkillManager r2) {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ au access$getCoverStore(SkillManager r0) {
        return r0.getCoverStore();
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.impl.v access$getInstalledSkillRegistry(SkillManager r0) {
        return r0.getInstalledSkillRegistry();
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.impl.ai access$getMetadataStore(SkillManager r0) {
        return r0.getMetadataStore();
    }

    public static final /* synthetic */ ft access$getShopRepository(SkillManager r0) {
        return r0.getShopRepository();
    }

    public static final /* synthetic */ fx access$getSigningRefreshCoordinator(SkillManager r0) {
        return r0.getSigningRefreshCoordinator();
    }

    public static final /* synthetic */ hd access$getTrackingReporter(SkillManager r0) {
        return r0.getTrackingReporter();
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.e access$importSkillInternal(SkillManager r2, com.obric.aiagent.skill.manager.api.d r3, com.obric.aiagent.skill.manager.api.o r4, d.h.a.a r5) {
        return r2.importSkillInternal(r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$installStagedSkillPackage(SkillManager r8, cf r9, String r10, com.obric.aiagent.skill.manager.api.q r11, d.h.a.a r12, d.c.d r13) {
        return r8.installStagedSkillPackage(r9, r10, r11, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.u access$installStoreSkill(SkillManager r0, String r1, String r2, com.obric.aiagent.skill.manager.api.au r3, com.obric.aiagent.skill.manager.impl.ao r4, com.obric.aiagent.skill.manager.api.e r5, Boolean r6) {
        return r0.installStoreSkill(r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ Object access$loadSkillInternal(SkillManager r2, String r3, String r4, ct r5, d.c.d r6) {
        return r2.loadSkillInternal(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$logFailure(SkillManager r0, String r1, String r2, Throwable r3) {
        r0.logFailure(r1, r2, r3);
    }

    public static final /* synthetic */ void access$logInfo(SkillManager r0, String r1, String r2) {
        r0.logInfo(r1, r2);
    }

    public static final /* synthetic */ void access$logWarning(SkillManager r0, String r1, String r2) {
        r0.logWarning(r1, r2);
    }

    public static final /* synthetic */ Object access$prepareInstalledSkillProjectionInternal(SkillManager r2, g r3, d.c.d r4) {
        return r2.prepareInstalledSkillProjectionInternal(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ int access$reconcileBuiltinStoreSkillRemovability(SkillManager r2, List r3) {
        return r2.reconcileBuiltinStoreSkillRemovability((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$refreshModificationSecurityOrThrow(SkillManager r2, com.obric.aiagent.skill.manager.api.k r3, dh r4, d.c.d r5) {
        return r2.refreshModificationSecurityOrThrow(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Context getAppContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.appContext$delegate.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context appContext_delegate$lambda$0() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.manager.impl.b getFileStore() {
        return (com.obric.aiagent.skill.manager.impl.b) ZeusTransformUtils.preCheckCast(this.fileStore$delegate.b(), com.obric.aiagent.skill.manager.impl.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.b fileStore_delegate$lambda$1(SkillManager r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "<get-appContext>(...)");
        return new com.obric.aiagent.skill.manager.impl.b(r4);
    }

    private final com.obric.aiagent.skill.manager.impl.ai getMetadataStore() {
        return (com.obric.aiagent.skill.manager.impl.ai) ZeusTransformUtils.preCheckCast(this.metadataStore$delegate.b(), com.obric.aiagent.skill.manager.impl.ai.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.ai metadataStore_delegate$lambda$2(SkillManager r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "<get-appContext>(...)");
        return new com.obric.aiagent.skill.manager.impl.ai(r4);
    }

    private final au getCoverStore() {
        return (au) ZeusTransformUtils.preCheckCast(this.coverStore$delegate.b(), au.class, "com.obric.aiagent.plugin");
    }

    private static final au coverStore_delegate$lambda$3(SkillManager r3) {
        au.a r0 = au.f19522a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "<get-appContext>(...)");
        return r0.a(r4);
    }

    private final fo getExistencePolicyRemoteSource() {
        return (fo) ZeusTransformUtils.preCheckCast(this.existencePolicyRemoteSource$delegate.b(), fo.class, "com.obric.aiagent.plugin");
    }

    private static final fo existencePolicyRemoteSource_delegate$lambda$4() {
        return new fo(null, 1, null);
    }

    private final com.obric.aiagent.skill.manager.impl.ac getObricManifestReader() {
        return (com.obric.aiagent.skill.manager.impl.ac) ZeusTransformUtils.preCheckCast(this.obricManifestReader$delegate.b(), com.obric.aiagent.skill.manager.impl.ac.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.ac obricManifestReader_delegate$lambda$5(SkillManager r3) {
        return new com.obric.aiagent.skill.manager.impl.ac((ca) ZeusTransformUtils.preCheckCast(r3.getFileStore(), ca.class, "com.obric.aiagent.plugin"), null, 2, null);
    }

    private final com.obric.aiagent.skill.manager.impl.ag getPersistentRepository() {
        return (com.obric.aiagent.skill.manager.impl.ag) ZeusTransformUtils.preCheckCast(this.persistentRepository$delegate.b(), com.obric.aiagent.skill.manager.impl.ag.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.ag persistentRepository_delegate$lambda$6(SkillManager r11) {
        File r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir();
        d.h.b.o.c(r2, "getCacheDir(...)");
        return new com.obric.aiagent.skill.manager.impl.ag(r2, (ca) ZeusTransformUtils.preCheckCast(r11.getFileStore(), ca.class, "com.obric.aiagent.plugin"), (df) ZeusTransformUtils.preCheckCast(r11.getMetadataStore(), df.class, "com.obric.aiagent.plugin"), r11.getObricManifestReader(), null, r11.nowMillis, null, 80, null);
    }

    private final ft getShopRepository() {
        return (ft) ZeusTransformUtils.preCheckCast(this.shopRepository$delegate.b(), ft.class, "com.obric.aiagent.plugin");
    }

    private static final ft shopRepository_delegate$lambda$7() {
        return new ft();
    }

    private final com.obric.aiagent.skill.manager.impl.w getDecisionStore() {
        return (com.obric.aiagent.skill.manager.impl.w) ZeusTransformUtils.preCheckCast(this.decisionStore$delegate.b(), com.obric.aiagent.skill.manager.impl.w.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.w decisionStore_delegate$lambda$8() {
        return new com.obric.aiagent.skill.manager.impl.w();
    }

    private final com.obric.aiagent.skill.manager.impl.v getInstalledSkillRegistry() {
        return (com.obric.aiagent.skill.manager.impl.v) ZeusTransformUtils.preCheckCast(this.installedSkillRegistry$delegate.b(), com.obric.aiagent.skill.manager.impl.v.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.v installedSkillRegistry_delegate$lambda$9(SkillManager r8) {
        return new com.obric.aiagent.skill.manager.impl.v((df) ZeusTransformUtils.preCheckCast(r8.getMetadataStore(), df.class, "com.obric.aiagent.plugin"), (eh) ZeusTransformUtils.preCheckCast(r8.getDecisionStore(), eh.class, "com.obric.aiagent.plugin"), null, null, 12, null);
    }

    private final hd getTrackingReporter() {
        return (hd) ZeusTransformUtils.preCheckCast(this.trackingReporter$delegate.b(), hd.class, "com.obric.aiagent.plugin");
    }

    private static final hd trackingReporter_delegate$lambda$10() {
        return new hd(null, null, null, 7, null);
    }

    private final gm getSigningRepository() {
        return (gm) ZeusTransformUtils.preCheckCast(this.signingRepository$delegate.b(), gm.class, "com.obric.aiagent.plugin");
    }

    private static final gm signingRepository_delegate$lambda$13(final SkillManager r17) {
        File r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir();
        d.h.b.o.c(r1, "getCacheDir(...)");
        return new gm(r1, (gh) ZeusTransformUtils.preCheckCast(r17.getPersistentRepository(), gh.class, "com.obric.aiagent.plugin"), (gc) ZeusTransformUtils.preCheckCast(new fe(), gc.class, "com.obric.aiagent.plugin"), (gk) ZeusTransformUtils.preCheckCast(r17.getMetadataStore(), gk.class, "com.obric.aiagent.plugin"), (eh) ZeusTransformUtils.preCheckCast(r17.getDecisionStore(), eh.class, "com.obric.aiagent.plugin"), (cz) ZeusTransformUtils.preCheckCast(new gb(null, null, 3, null), cz.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillManager$fSzR8ldGEc2CEUDN_8DrTGYK3dE(r17), new $$Lambda$SkillManager$4pY43hQ9Osou9uXPFaRY1aAEyk(r17), null, null, r17.getTrackingReporter(), null, 2816, null);
    }

    private static final d.x signingRepository_delegate$lambda$13$lambda$11(SkillManager r1, gj r2) {
        d.h.b.o.e(r2, "record");
        r1.publishSigningState(r2.a(), r2.b());
        return d.x.f38692a;
    }

    private static final d.x signingRepository_delegate$lambda$13$lambda$12(SkillManager r1, eg r2) {
        d.h.b.o.e(r2, "decision");
        r1.publishSigningState(r2.a(), r2.b());
        return d.x.f38692a;
    }

    private final void publishSigningState(String r5, int r6) {
        com.obric.aiagent.skill.manager.api.e r0 = getInstalledSkillRegistry().b(r5);
        if (r0 == null) goto L6;
        com.obric.aiagent.skill.manager.api.aj r1 = r0.i();
        if (r1 == null) goto L6;
    L7:
        com.obric.aiagent.skill.manager.api.e r7 = getInstalledSkillRegistry().a(r5, r6);
        if (r7 == null) goto L11;
        com.obric.aiagent.skill.manager.api.aj r2 = r7.i();
        if (r2 == null) goto L11;
    L12:
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.j() == r6) goto L16;
        return;
    L16:
        if (en.a(r1) == false) goto L18;
        return;
    L18:
        if (en.a(r2) == false) goto L24;
        getTrackingReporter().b(r7, resolveFileDownloaded(r7.a()));
        return;
    L24:
        return;
    L11:
        r2 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.c.f19187a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L6:
        r1 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.c.f19187a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private final com.obric.aiagent.skill.manager.impl.p getCliUpdateRepository() {
        return (com.obric.aiagent.skill.manager.impl.p) ZeusTransformUtils.preCheckCast(this.cliUpdateRepository$delegate.b(), com.obric.aiagent.skill.manager.impl.p.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.impl.p cliUpdateRepository_delegate$lambda$14(SkillManager r9) {
        return new com.obric.aiagent.skill.manager.impl.p(new com.obric.aiagent.skill.manager.impl.k(new File(r9.getFileStore().a(), "cli"), null, null, 6, null), (com.obric.aiagent.skill.manager.impl.h) ZeusTransformUtils.preCheckCast(new fj(new fe()), com.obric.aiagent.skill.manager.impl.h.class, "com.obric.aiagent.plugin"), null, (com.obric.aiagent.skill.manager.impl.m) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.a.f19429a, com.obric.aiagent.skill.manager.impl.m.class, "com.obric.aiagent.plugin"), null, 20, null);
    }

    private final kotlinx.coroutines.am getSigningScope() {
        return (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.signingScope$delegate.b(), kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
    }

    private static final kotlinx.coroutines.am signingScope_delegate$lambda$15() {
        return kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    private final fx getSigningRefreshCoordinator() {
        return (fx) ZeusTransformUtils.preCheckCast(this.signingRefreshCoordinator$delegate.b(), fx.class, "com.obric.aiagent.plugin");
    }

    private static final fx signingRefreshCoordinator_delegate$lambda$16(SkillManager r7) {
        return new fx((d.h.a.b) ZeusTransformUtils.preCheckCast(new al(r7.getInstalledSkillRegistry()), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.preCheckCast(new am(r7.getSigningRepository()), d.h.a.q.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    private final hf getSkillUpdateCoordinator() {
        return (hf) ZeusTransformUtils.preCheckCast(this.skillUpdateCoordinator$delegate.b(), hf.class, "com.obric.aiagent.plugin");
    }

    private static final hf skillUpdateCoordinator_delegate$lambda$19(final SkillManager r11) {
        return new hf((d.h.a.b) ZeusTransformUtils.preCheckCast(new an(r11.getInstalledSkillRegistry()), d.h.a.b.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillManager$Yk01sy7bhkxqIvgKltUDgoOpmw(r11), new $$Lambda$SkillManager$20o5lvRxPvKtnIvwYztrztLwJw(r11), r11.getObricManifestReader(), r11.getCliUpdateRepository(), r11.getTrackingReporter(), null, 64, null);
    }

    private static final com.obric.aiagent.skill.manager.api.e skillUpdateCoordinator_delegate$lambda$19$lambda$17(SkillManager r1, com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "skill");
        com.obric.aiagent.skill.manager.api.e r3 = r1.getPersistentRepository().a(r2);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3;
    }

    private static final com.obric.aiagent.skill.manager.api.u skillUpdateCoordinator_delegate$lambda$19$lambda$18(SkillManager r10, com.obric.aiagent.skill.manager.api.e r11, hg r12, com.obric.aiagent.skill.manager.impl.ao r13) {
        d.h.b.o.e(r11, "skill");
        d.h.b.o.e(r12, "reason");
        return cy.a(installStoreSkill$default(r10, r11.a(), r11.d(), r12.b(), r13, null, null, 48, null));
    }

    private final gt getStoreMetadataRefreshCoordinator() {
        return (gt) ZeusTransformUtils.preCheckCast(this.storeMetadataRefreshCoordinator$delegate.b(), gt.class, "com.obric.aiagent.plugin");
    }

    private static final gt storeMetadataRefreshCoordinator_delegate$lambda$21(final SkillManager r10) {
        return new gt((d.h.a.b) ZeusTransformUtils.preCheckCast(new ao(r10.getInstalledSkillRegistry()), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new ap(r10.getShopRepository()), d.h.a.b.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillManager$TPf8Wo2Ay1pPtC_iPct3P99Dzk8(r10), 0, null, r10.getTrackingReporter(), 24, null);
    }

    private static final com.obric.aiagent.skill.manager.api.e storeMetadataRefreshCoordinator_delegate$lambda$21$lambda$20(SkillManager r2, com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "remote");
        com.obric.aiagent.skill.manager.api.e r0 = r2.getInstalledSkillRegistry().b(r3.a());
        if (r0 != null) goto L5;
        return null;
    L5:
        com.obric.aiagent.skill.manager.api.e r4 = gu.a(r0, r3);
        if (r4 != null) goto L9;
        return null;
    L9:
        if (d.h.b.o.a(r4, r0) == false) goto L12;
        return r0;
    L12:
        return r2.getInstalledSkillRegistry().a(r4);
    }

    private final List<cr> getLoadHooks() {
        return (List) ZeusTransformUtils.preCheckCast(this.loadHooks$delegate.b(), List.class, "com.obric.aiagent.plugin");
    }

    private static final List loadHooks_delegate$lambda$22(SkillManager r1) {
        return d.a.p.a(new com.obric.aiagent.skill.manager.impl.ae(r1.getObricManifestReader()));
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> getInstalledSkills() {
        com.obric.aiagent.skill.manager.api.u r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L6;
        return r0;
    L6:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(getInstalledSkillRegistry().a().c(), Iterable.class, "com.obric.aiagent.plugin"))), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>>> observeInstalledSkills() {
        com.obric.aiagent.skill.manager.api.u r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L6;
        return r0;
    L6:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(getInstalledSkillRegistry().a()), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> installSkill(String r2, String r3) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "shortDescription");
        return installSkill(r2, r3, com.obric.aiagent.skill.manager.api.au.f19234a);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> installSkill(String r11, String r12, com.obric.aiagent.skill.manager.api.au r13) {
        d.h.b.o.e(r11, "slug");
        d.h.b.o.e(r12, "shortDescription");
        d.h.b.o.e(r13, "entry");
        return cy.a(installStoreSkill$default(this, r11, r12, r13, null, null, null, 48, null));
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.av> installStoreSkill(String r11, com.obric.aiagent.skill.manager.api.au r12) {
        d.h.b.o.e(r11, "slug");
        d.h.b.o.e(r12, "entry");
        return installStoreSkill$default(this, r11, "", r12, null, null, null, 48, null);
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.u installStoreSkill$default(SkillManager r9, String r10, String r11, com.obric.aiagent.skill.manager.api.au r12, com.obric.aiagent.skill.manager.impl.ao r13, com.obric.aiagent.skill.manager.api.e r14, Boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        com.obric.aiagent.skill.manager.api.e r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        Boolean r8 = null;
    L11:
        return r9.installStoreSkill(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    private final com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.av> installStoreSkill(String r5, String r6, com.obric.aiagent.skill.manager.api.au r7, com.obric.aiagent.skill.manager.impl.ao r8, com.obric.aiagent.skill.manager.api.e r9, Boolean r10) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        if (r8 != null) goto L8;
    L11:
        if (r9 != null) goto L13;
    L16:
        com.obric.aiagent.skill.manager.api.u r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L19;
        return r0;
    L19:
        com.obric.aiagent.skill.manager.api.r r1 = com.obric.aiagent.skill.manager.api.r.n;
        Object r2 = storeInstallLock(r5);     // Catch: Exception -> L28 CancellationException -> L31
        monitor-enter(r2);     // Catch: Exception -> L28 CancellationException -> L31
        bl.f19568a.b(r5);     // Catch: Throwable -> L25
        com.obric.aiagent.skill.manager.api.av r4 = installSkillInternal(r5, r6, r7, r8, r9, r10);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Exception -> L28 CancellationException -> L31
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r4), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L28 CancellationException -> L31
    L31:
        e = move-exception;
        throw e;
    L28:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r11 = dm.a(e, "install", r1);
        dm.a("install", r11.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L13:
        if (d.h.b.o.a(r9.a(), r5) == true) goto L16;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install", false, "presentation_slug_mismatch", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L8:
        if (d.h.b.o.a(r8.a().a(), r5) == true) goto L11;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install", false, "detail_slug_mismatch", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L5:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install", false, "blank_slug", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final Object storeInstallLock(String r2) {
        int r3 = r2.hashCode() & Integer.MAX_VALUE;
        Object[] r1 = this.storeInstallLocks;
        return r1[r3 % r1.length];
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.av installSkillInternal$default(SkillManager r9, String r10, String r11, com.obric.aiagent.skill.manager.api.au r12, com.obric.aiagent.skill.manager.impl.ao r13, com.obric.aiagent.skill.manager.api.e r14, Boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        com.obric.aiagent.skill.manager.impl.ao r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        com.obric.aiagent.skill.manager.api.e r7 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        Boolean r8 = null;
    L15:
        return r9.installSkillInternal(r10, r11, r12, r6, r7, r8);
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    private final com.obric.aiagent.skill.manager.api.av installSkillInternal(String r43, String r44, com.obric.aiagent.skill.manager.api.au r45, com.obric.aiagent.skill.manager.impl.ao r46, com.obric.aiagent.skill.manager.api.e r47, Boolean r48) {
        bl.f19568a.b(r43);
        long r22 = SystemClock.elapsedRealtime();
        String r8 = eb.a();
        ea r38 = new ea(dy.f19786a, getTrackingReporter(), r8, 0, null, r22, false, 88, null);
        com.obric.aiagent.skill.manager.api.e r11 = getInstalledSkillRegistry().b(r43);     // Catch: Exception -> L165 CancellationException -> L168
        if (r11 != null) goto L6;
    L10:
        if (r46 == null) goto L176;
        com.obric.aiagent.skill.manager.impl.ao r2 = r46;
    L21:
        if (r47 == null) goto L177;
        com.obric.aiagent.skill.manager.api.e r0 = r47;
    L29:
        if (r0 != null) goto L31;
        r0 = r11;
    L31:
        if (r0 == null) goto L34;
        com.obric.aiagent.skill.manager.api.e r1 = gu.a(r2.a(), r0);     // Catch: Exception -> L16 CancellationException -> L18
        if (r1 == null) goto L34;
    L35:
        com.obric.aiagent.skill.manager.api.e r9 = r1;
        boolean r3 = getPersistentRepository().b(r9.a());     // Catch: Exception -> L155 CancellationException -> L158
        if (r11 != null) goto L42;
        if (r3 == false) goto L42;
        ea.a(r38, dz.f19792b, r9, null, null, null, null, dw.f19778c, "local_state_conflict", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw new cd(r9.a(), ce.f19647a);
    L42:
        StringBuilder r4 = new StringBuilder().append("Install skill requested alreadyInstalled=");
        if (r11 == null) goto L45;
        boolean r5 = true;
    L46:
        String r6 = r4.append(r5).append(", existedInFileStore=").append(r3).toString();
        StringBuilder r7 = new StringBuilder().append("Install skill requested: slug=").append(r43).append(", alreadyInstalled=");
        if (r11 == null) goto L49;
        boolean r10 = true;
    L50:
        logInfo(r6, r7.append(r10).append(", existedInFileStore=").append(r3).toString());
        com.obric.aiagent.skill.manager.api.aq r12 = r9.g();
        if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L53;
        com.obric.aiagent.skill.manager.api.aq.e r13 = (com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin");
    L54:
        if (r13 != null) goto L56;
        fp r14 = new fp(fq.f19910c, null, 2, null);
        ea.a(r38, dz.f19792b, r9, null, null, null, null, dw.f19776a, "source_validate", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw r14;
    L56:
        if (r11 == null) goto L81;
        int r15 = i.f19376a[hj.f20114a.a(r11.j(), r9.j()).ordinal()];     // Catch: Exception -> L74 CancellationException -> L77
        if (r15 != 1) goto L60;
        com.obric.aiagent.skill.manager.api.e r16 = gu.a(r11, r9);     // Catch: Exception -> L74 CancellationException -> L77
        if (r16 == null) goto L68;
        r11 = r16;
    L68:
        if (r48 == null) goto L72;
        com.obric.aiagent.skill.manager.api.e r17 = com.obric.aiagent.skill.manager.api.e.a(r11, null, null, null, null, null, null, null, null, null, 0, null, false, r48.booleanValue(), null, null, null, null, 126975, null);     // Catch: Exception -> L74 CancellationException -> L77
        if (r17 == null) goto L72;
        r11 = r17;
    L72:
        com.obric.aiagent.skill.manager.api.e r18 = getInstalledSkillRegistry().a(r11);     // Catch: Exception -> L74 CancellationException -> L77
        ea.a(r38, dz.f19791a, r18, null, null, null, null, null, null, false, false, d.a.ao.a(new d.m[]{d.s.a("business_result", "up_to_date"), d.s.a("target_version", Integer.valueOf(r9.j())), d.s.a("local_file_present", Boolean.valueOf(r3)), d.s.a("entry_source", r45.a())}), 252, null);     // Catch: Exception -> L74 CancellationException -> L77
        logInfo("Install skill skipped already installed", "Install skill skipped: slug=" + r9.a() + ", version=" + r9.j() + " already installed");     // Catch: Exception -> L74 CancellationException -> L77
        return new com.obric.aiagent.skill.manager.api.av(com.obric.aiagent.skill.manager.api.at.f19231c, r18);
    L60:
        if (r15 != 2) goto L63;
        d.x r19 = d.x.f38692a;     // Catch: Exception -> L74 CancellationException -> L77
        goto L81
    L63:
        throw new d.k();     // Catch: Exception -> L74 CancellationException -> L77
    L77:
        e = move-exception;
        ea.a(r38, dz.f19793c, r9, null, null, null, null, dw.n, "version_check", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw e;
    L74:
        e = move-exception;
        dw r31 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r38, dz.f19792b, r9, null, null, null, null, r31, "version_check", Boolean.valueOf(eb.a(r31)), false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw e;
    L81:
        if (r3 == false) goto L83;
        cp r20 = cp.f19690b;
    L84:
        gs r21 = new gs(r20, r9.j());
        final com.obric.aiagent.skill.manager.api.e r49 = r9;
        cl r23 = new cl(com.obric.aiagent.skill.manager.api.q.f, r9.b(), r43, null, r21, r8, r45.a(), 8, null);
        File r24 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), "shop_skill_" + r49.a() + '_' + System.nanoTime() + ".zip");
        com.obric.aiagent.skill.manager.impl.ap r25 = getShopRepository().a(r49.a(), r49.j(), r24);     // Catch: Throwable -> L135 Exception -> L137 CancellationException -> L143
        dz r26 = dz.f19791a;     // Catch: Throwable -> L135 Exception -> L137 CancellationException -> L143
        d.m[] r27 = new d.m[5];     // Catch: Throwable -> L135 Exception -> L137 CancellationException -> L143
        r27[0] = d.s.a("business_result", "downloaded");     // Catch: Throwable -> L135 Exception -> L137 CancellationException -> L143
        r27[1] = d.s.a("install_type", r21.a().a());     // Catch: Throwable -> L135 Exception -> L137 CancellationException -> L143
        Object r28 = "target_version";
        char r29 = 2;
        r27[2] = d.s.a(r28, Integer.valueOf(r49.j()));     // Catch: Exception -> L127 CancellationException -> L129 Throwable -> L135
        int r30 = 3;
        r27[3] = d.s.a("download_bytes", Long.valueOf(r25.b()));     // Catch: Exception -> L123 CancellationException -> L125 Throwable -> L135
        r27[4] = d.s.a("entry_source", r45.a());     // Catch: Exception -> L123 CancellationException -> L125 Throwable -> L135
        ea.a(r38, r26, r49, null, null, null, null, null, null, false, false, d.a.ao.a(r27), 252, null);     // Catch: Exception -> L123 CancellationException -> L125 Throwable -> L135
        co r32 = co.f19684a.a(r23, getTrackingReporter(), new $$Lambda$SkillManager$rhWl2tDO8oP_VOP_rGNMei8wBE(this, r49));     // Catch: Throwable -> L135
        com.obric.aiagent.skill.manager.impl.ag r33 = getPersistentRepository();     // Catch: Exception -> L120 Throwable -> L135
        String r34 = r49.a();     // Catch: Exception -> L120 Throwable -> L135
        int r210 = r25.a();     // Catch: Exception -> L120 Throwable -> L135
        if (r48 == null) goto L97;
        boolean r35 = r48.booleanValue();     // Catch: Exception -> L120 Throwable -> L135
    L96:
        boolean r36 = r35;
    L103:
        com.obric.aiagent.skill.manager.api.e r37 = r33.a(r34, r24, com.obric.aiagent.skill.manager.api.e.a(r49, null, null, null, null, null, null, null, null, null, r210, null, false, r36, null, null, null, null, 126463, null));     // Catch: Exception -> L120 Throwable -> L135
        com.obric.aiagent.skill.manager.api.e r39 = gu.a(r37, r49);     // Catch: Exception -> L120 Throwable -> L135
        if (r39 == null) goto L107;
        r37 = r39;
    L107:
        r32.b(r37);     // Catch: Exception -> L120 Throwable -> L135
        com.obric.aiagent.skill.manager.api.e r40 = getInstalledSkillRegistry().a(r37);     // Catch: Exception -> L120 Throwable -> L135
        r32.c(r40);     // Catch: Exception -> L120 Throwable -> L135
        if (r11 != null) goto L110;
        getTrackingReporter().a(r40, resolveFileDownloaded(r40.a()));     // Catch: Exception -> L120 Throwable -> L135
    L111:
        logInfo("Install skill completed enabled=" + r40.l() + ", removable=" + r40.m(), "Install skill completed: slug=" + r40.a() + ", source=" + r40.g() + ", enabled=" + r40.l() + ", removable=" + r40.m());     // Catch: Exception -> L120 Throwable -> L135
        if (r11 != null) goto L114;
        com.obric.aiagent.skill.manager.api.at r41 = com.obric.aiagent.skill.manager.api.at.f19229a;     // Catch: Exception -> L120 Throwable -> L135
    L115:
        com.obric.aiagent.skill.manager.api.av r42 = new com.obric.aiagent.skill.manager.api.av(r41, r40);     // Catch: Exception -> L120 Throwable -> L135
    L117:
        if (r24.exists() == false) goto L119;
        r24.delete();
    L119:
        return r42;
    L114:
        r41 = com.obric.aiagent.skill.manager.api.at.f19230b;     // Catch: Exception -> L120 Throwable -> L135
        goto L115
    L110:
        getTrackingReporter().b(r40, resolveFileDownloaded(r40.a()));     // Catch: Exception -> L120 Throwable -> L135
        goto L111
    L97:
        if (r11 == null) goto L99;
        Boolean r110 = Boolean.valueOf(r11.m());     // Catch: Exception -> L120 Throwable -> L135
    L100:
        if (r110 == null) goto L102;
        r35 = r110.booleanValue();     // Catch: Exception -> L120 Throwable -> L135
        goto L96
    L102:
        r36 = true;
        goto L103
    L99:
        r110 = null;
    L120:
        e = move-exception;
        r32.a(cj.f19667c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L135
        throw e;     // Catch: Throwable -> L135
    L125:
        e = e;
        r49 = r49;
    L147:
        dz r211 = dz.f19793c;     // Catch: Throwable -> L135
        dw r310 = dw.n;     // Catch: Throwable -> L135
        d.m[] r50 = new d.m[r30];     // Catch: Throwable -> L135
        r50[0] = d.s.a("install_type", r21.a().a());     // Catch: Throwable -> L135
        r50[1] = d.s.a(r28, Integer.valueOf(r49.j()));     // Catch: Throwable -> L135
        r50[r29] = d.s.a("entry_source", r45.a());     // Catch: Throwable -> L135
        ea.a(r38, r211, r49, null, null, null, null, r310, "transfer", false, false, d.a.ao.a(r50), 60, null);     // Catch: Throwable -> L135
        throw e;     // Catch: Throwable -> L135
    L123:
        e = e;
        r49 = r49;
    L141:
        dw r311 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L135
        dz r212 = dz.f19792b;     // Catch: Throwable -> L135
        Boolean r312 = Boolean.valueOf(eb.a(r311));     // Catch: Throwable -> L135
        d.m[] r51 = new d.m[r30];     // Catch: Throwable -> L135
        r51[0] = d.s.a("install_type", r21.a().a());     // Catch: Throwable -> L135
        r51[1] = d.s.a(r28, Integer.valueOf(r49.j()));     // Catch: Throwable -> L135
        r51[r29] = d.s.a("entry_source", r45.a());     // Catch: Throwable -> L135
        ea.a(r38, r212, r49, null, null, null, null, r311, "transfer", r312, false, d.a.ao.a(r51), 60, null);     // Catch: Throwable -> L135
        throw e;     // Catch: Throwable -> L135
    L129:
        e = e;
        r49 = r49;
    L146:
        r30 = 3;
    L127:
        e = e;
        r49 = r49;
    L140:
        r30 = 3;
        goto L141
    L133:
        e = e;
    L145:
        r29 = 2;
    L131:
        e = e;
    L139:
        r29 = 2;
        goto L140
    L135:
        th = move-exception;
        if (r24.exists() == false) goto L152;
        r24.delete();
    L152:
        throw th;
    L143:
        e = e;
        r28 = "target_version";
    L137:
        e = e;
        r28 = "target_version";
        goto L139
    L83:
        r20 = cp.f19689a;
        goto L84
    L53:
        r13 = null;
        goto L54
    L49:
        r10 = false;
        goto L50
    L45:
        r5 = false;
        goto L46
    L158:
        e = move-exception;
        ea.a(r38, dz.f19793c, r9, null, null, null, null, dw.n, "local_state_probe", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw e;
    L155:
        e = move-exception;
        dw r313 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r38, dz.f19792b, r9, null, null, null, null, r313, "local_state_probe", Boolean.valueOf(eb.a(r313)), false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw e;
    L34:
        r1 = com.obric.aiagent.skill.manager.api.e.a(r2.a(), null, null, null, r44, null, null, null, null, null, 0, null, false, false, null, null, null, null, 131063, null);     // Catch: Exception -> L16 CancellationException -> L18
        goto L35
    L177:
        r0 = getShopRepository().c(r43);     // Catch: Exception -> L24 CancellationException -> L26
    L26:
        e = move-exception;
        throw e;     // Catch: Exception -> L16 CancellationException -> L18
    L24:
        e = move-exception;
        logFailure("Install Store Skill presentation search failed", "Install Store Skill presentation search failed: slug=" + r43, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L16 CancellationException -> L18
        r0 = null;
        goto L29
    L176:
        com.obric.aiagent.skill.manager.impl.ao r52 = getShopRepository().a(r43);     // Catch: Exception -> L16 CancellationException -> L18
        if (r52 == null) goto L15;
        r2 = r52;
        goto L21
    L15:
        throw new ha();     // Catch: Exception -> L16 CancellationException -> L18
    L18:
        e = move-exception;
        ea.a(r38, dz.f19793c, null, r43, null, null, null, dw.n, "skill_detail", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 58, null);
        throw e;
    L16:
        e = move-exception;
        dw r53 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r38, dz.f19792b, null, r43, null, null, null, r53, "skill_detail", Boolean.valueOf(eb.a(r53)), false, d.a.ao.a(d.s.a("entry_source", r45.a())), 58, null);
        throw e;
    L6:
        if (ZeusTransformUtils.instanceOf(r11.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L10;
        ea.a(r38, dz.f19792b, r11, null, null, null, null, dw.f19778c, "source_conflict", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 60, null);
        throw new cd(r11.a(), ce.f19647a);
    L168:
        e = move-exception;
        ea.a(r38, dz.f19793c, null, r43, null, null, null, dw.n, "installed_lookup", false, false, d.a.ao.a(d.s.a("entry_source", r45.a())), 58, null);
        throw e;
    L165:
        e = move-exception;
        dw r54 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r38, dz.f19792b, null, r43, null, null, null, r54, "installed_lookup", Boolean.valueOf(eb.a(r54)), false, d.a.ao.a(d.s.a("entry_source", r45.a())), 58, null);
        throw e;
    }

    private static final Boolean installSkillInternal$lambda$28(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return r0.resolveFileDownloaded(r1.a());
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object createSkill(com.obric.aiagent.skill.manager.api.m r7, com.obric.aiagent.skill.manager.api.o r8, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.u<d.x> r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L5;
        return r0;
    L5:
        com.obric.aiagent.skill.manager.api.r r2 = com.obric.aiagent.skill.manager.api.r.o;
        d.c.g r11 = r10.getContext();     // Catch: Exception -> L8 CancellationException -> L11
    L15:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(access$createSkillInternal(this, cy.a(r7.a(), r7.b(), r7.c(), r7.d()), r8, (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(r11), d.h.a.a.class, "com.obric.aiagent.plugin"))), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L11:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r12 = dm.a(e, "create", r2);
        dm.a("create", r12.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.manager.api.e createSkillInternal(com.obric.aiagent.skill.manager.api.e r10, com.obric.aiagent.skill.manager.api.o r11, d.h.a.a<d.x> r12) {
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(this.currentUserNameProvider.invoke(), String.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        cm r2 = cy.a(r11, r13);
        logInfo("Create skill requested entry=" + r11.a() + ", nameLength=" + r10.b().length() + ", contentLength=" + r10.k().length(), "Create skill requested: source=" + ((com.obric.aiagent.skill.manager.api.aq.b) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.aiagent.skill.manager.api.aq.b.class, "com.obric.aiagent.plugin")).a() + ", entry=" + r11.a() + ", nameLength=" + r10.b().length() + ", contentLength=" + r10.k().length());
        Object r14 = this.createLock;
        monitor-enter(r14);
        com.obric.aiagent.skill.manager.api.e r15 = commitNewLocalSkill$default(this, cy.a(r10, cv.a(db.a(db.f19721a, r10.k(), 0, 2, null), com.obric.aiagent.skill.manager.api.al.f19195a.a().c()), (com.obric.aiagent.skill.manager.api.aq.b) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.aiagent.skill.manager.api.aq.b.class, "com.obric.aiagent.plugin")), r2, cj.f19668d, r4, false, new $$Lambda$SkillManager$Hmkg1etarJg7KzCxN7ji8N3Ix5s(this, r4), 16, null);     // Catch: Throwable -> L11
        monitor-exit(r14);
        logInfo("Create skill completed enabled=" + r15.l(), "Create skill completed: slug=" + r15.a() + ", source=" + r15.g() + ", enabled=" + r15.l());
        return r15;
    L11:
        th = move-exception;
        throw th;
    }

    private static final com.obric.aiagent.skill.manager.api.e createSkillInternal$lambda$31$lambda$30(SkillManager r2, d.h.a.a r3, com.obric.aiagent.skill.manager.api.e r4) {
        d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "candidate");
        return r2.getPersistentRepository().a(r4, r5);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object importSkill(com.obric.aiagent.skill.manager.api.d r5, com.obric.aiagent.skill.manager.api.o r6, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.u<d.x> r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L5;
        return r0;
    L5:
        com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.d> r9 = validatePreparedImportMetadata(r5, r6);
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L16;
        com.obric.aiagent.skill.manager.api.d r10 = (com.obric.aiagent.skill.manager.api.d) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.r r2 = com.obric.aiagent.skill.manager.api.r.o;
    L22:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(access$importSkillInternal(this, r10, r6, (d.h.a.a) ZeusTransformUtils.preCheckCast(new t(r8.getContext()), d.h.a.a.class, "com.obric.aiagent.plugin"))), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L13:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r11 = dm.a(e, "import", r2);
        dm.a("import", r11.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L19;
        return r9;
    L19:
        throw new d.k();
    }

    private final com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.d> validatePreparedImportMetadata(com.obric.aiagent.skill.manager.api.d r10, com.obric.aiagent.skill.manager.api.o r11) {
        com.obric.aiagent.skill.manager.api.b r9 = r10.d();
        boolean r1 = true;
        if (r11.a() != com.obric.aiagent.skill.manager.api.p.f19290a) goto L5;
        boolean r12 = true;
    L6:
        if (r9 != null) goto L10;
        r1 = false;
    L10:
        if (r12 != r1) goto L12;
        if (r9 == null) goto L15;
        String r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9.a().a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "import", false, "blank_app_function_package_name", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L21:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(com.obric.aiagent.skill.manager.api.d.a(r10, null, null, false, r9.a(com.obric.aiagent.skill.manager.api.a.a(r9.a(), r13, null, 2, null)), 7, null)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L15:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r10), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L12:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "import", false, "invalid_app_function_import_info", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.obric.aiagent.skill.manager.impl.by] */
    /* JADX WARN: Type inference failed for: r16v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r4v7 */
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
    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object installSkillPackage(com.obric.aiagent.skill.manager.api.x r24, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.y>> r25) {
        SkillManager r7 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, u.class) == false) goto L7;
        u r1 = (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        u r6 = r1;
        Object r2 = r6.f;
        Object r9 = d.c.a.b.a();
        int r3 = r6.h;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        cf r4 = (cf) ZeusTransformUtils.preCheckCast(r6.f19396e, cf.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r5 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r6.f19395d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.r r8 = (com.obric.aiagent.skill.manager.api.r) ZeusTransformUtils.preCheckCast(r6.f19394c, com.obric.aiagent.skill.manager.api.r.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.f19393b, String.class, "com.obric.aiagent.plugin");
        SkillManager r11 = (SkillManager) ZeusTransformUtils.preCheckCast(r6.f19392a, SkillManager.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14
        String r21 = "Web Skill download cleanup failed: file=";
        String r22 = "Web Skill download cleanup failed";
    L116:
        com.obric.aiagent.skill.manager.api.y r12 = (com.obric.aiagent.skill.manager.api.y) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        r4.e();     // Catch: Throwable -> L82
        File r13 = (File) ZeusTransformUtils.preCheckCast(r5.f38504a, File.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L80 CancellationException -> L111
        if (r13 != null) goto L74;
    L78:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r12), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L74:
        if (r13.exists() == false) goto L78;
        if (r13.delete() == true) goto L78;
        access$logWarning(r11, r22, r21 + r13.getName());     // Catch: Exception -> L80 CancellationException -> L111
    L80:
        e = e;
        com.obric.aiagent.skill.manager.api.r r14 = r8;
        String r15 = r10;
    L113:
        com.obric.aiagent.skill.manager.api.u.a r16 = dm.a(e, r15, r14);
        dm.a(r15, r16.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L82:
        th = th;
        String r17 = r21;
        String r18 = r22;
        d.h.b.z.f r19 = r5;
        r14 = r8;
        r15 = r10;
        r7 = r11;
    L101:
        File r20 = (File) ZeusTransformUtils.preCheckCast(r19.f38504a, File.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L109 CancellationException -> L111
        if (r20 != null) goto L104;
    L108:
        throw th;     // Catch: Exception -> L109 CancellationException -> L111
    L109:
        e = e;
        goto L113
    L104:
        if (r20.exists() == false) goto L108;
        if (r20.delete() == true) goto L108;
        access$logWarning(r7, r18, r17 + r20.getName());     // Catch: Exception -> L109 CancellationException -> L111
    L84:
        th = th;
        r17 = r21;
        r18 = r22;
        r7 = r11;
    L118:
        r4.e();     // Catch: Throwable -> L90
        throw th;     // Catch: Throwable -> L90
    L90:
        th = th;
        r19 = r5;
        r14 = r8;
        r15 = r10;
    L14:
        th = th;
        r7 = r11;
        r17 = "Web Skill download cleanup failed: file=";
        r18 = "Web Skill download cleanup failed";
        goto L118
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r2);
        com.obric.aiagent.skill.manager.api.u<d.x> r23 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r23, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L21;
        return r23;
    L21:
        String r26 = cy.a(r24.b());
        if (r26 != null) goto L26;
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install_skill_package", false, "source_url_invalid", null, 20, null);
    L26:
        if (cy.b(r24.d()) == true) goto L30;
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install_skill_package", false, "expected_sha256_invalid", null, 20, null);
    L30:
        if (cy.a(r24.c()) == false) goto L32;
        com.obric.aiagent.skill.manager.api.z r27 = r24.a();
        File r28 = null;
        if (ZeusTransformUtils.instanceOf(r27, com.obric.aiagent.skill.manager.api.z.a.class) == false) goto L36;
        com.obric.aiagent.skill.manager.api.z.a r29 = (com.obric.aiagent.skill.manager.api.z.a) ZeusTransformUtils.preCheckCast(r27, com.obric.aiagent.skill.manager.api.z.a.class, "com.obric.aiagent.plugin");
    L37:
        if (r29 == null) goto L39;
        r28 = r29.a();
    L39:
        if (r28 != null) goto L41;
    L46:
        r15 = "install_skill_package";
        r14 = com.obric.aiagent.skill.manager.api.r.o;
        d.c.d r30 = (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L109 CancellationException -> L111
        d.c.g r31 = r6.getContext();     // Catch: Exception -> L109 CancellationException -> L111
        com.obric.aiagent.skill.manager.api.al r32 = com.obric.aiagent.skill.manager.api.al.f19195a.a();     // Catch: Exception -> L109 CancellationException -> L111
        r19 = new d.h.b.z.f();     // Catch: Exception -> L109 CancellationException -> L111
        com.obric.aiagent.skill.manager.api.z r33 = r24.a();     // Catch: Throwable -> L99
        if (ZeusTransformUtils.instanceOf(r33, com.obric.aiagent.skill.manager.api.z.a.class) == false) goto L53;
        ?? r34 = ((com.obric.aiagent.skill.manager.api.z.a) ZeusTransformUtils.preCheckCast(r33, com.obric.aiagent.skill.manager.api.z.a.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L99
    L51:
        ?? r110 = r34;
        kotlinx.coroutines.ce.b(r31);     // Catch: Throwable -> L99
        String r35 = r24.d();     // Catch: Throwable -> L99
        if (r35 == null) goto L63;
        if (d.h.b.o.a(cy.a(r110), r35) == true) goto L63;
        throw new dq();     // Catch: Throwable -> L99
    L63:
        r21 = "Web Skill download cleanup failed: file=";
        r22 = "Web Skill download cleanup failed";
        cf r111 = by.f19630a.a(r110, "skill.zip", new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(access$getAppContext(this), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), new StringBuilder().append("skill_package_install_").append(System.currentTimeMillis()).append('_').append(System.nanoTime()).toString()), bx.f19625a.a(r32), (d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r31), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L92
        com.obric.aiagent.skill.manager.api.q r36 = r24.c();     // Catch: Throwable -> L86
        d.h.a.a r37 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r31), d.h.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
        r6.f19392a = r7;     // Catch: Throwable -> L86
        r6.f19393b = "install_skill_package";     // Catch: Throwable -> L86
        r6.f19394c = r14;     // Catch: Throwable -> L86
        r6.f19395d = r19;     // Catch: Throwable -> L86
        r6.f19396e = r111;     // Catch: Throwable -> L86
        r6.h = 1;     // Catch: Throwable -> L86
        r2 = access$installStagedSkillPackage(this, r111, r26, r36, r37, r6);     // Catch: Throwable -> L86
        if (r2 != r9) goto L68;
        return r9;
    L68:
        r11 = r7;
        r4 = r111;
        r10 = "install_skill_package";
        r8 = r14;
        r5 = r19;
    L86:
        th = th;
        r17 = r21;
        r18 = r22;
        r4 = r111;
        r10 = "install_skill_package";
        r8 = r14;
        r5 = r19;
    L92:
        th = th;
        r17 = r21;
        r18 = r22;
        goto L101
    L53:
        if (ZeusTransformUtils.instanceOf(r33, com.obric.aiagent.skill.manager.api.z.b.class) == false) goto L94;
        ?? r38 = access$downloadSkillPackage(r7, ((com.obric.aiagent.skill.manager.api.z.b) ZeusTransformUtils.preCheckCast(r33, com.obric.aiagent.skill.manager.api.z.b.class, "com.obric.aiagent.plugin")).a(), r32.k());     // Catch: Throwable -> L99
        r19.f38504a = r38;     // Catch: Throwable -> L99
        r34 = r38;
        goto L51
    L94:
        r17 = "Web Skill download cleanup failed: file=";
        r18 = "Web Skill download cleanup failed";
    L97:
        th = th;
        goto L101
    L96:
        throw new d.k();     // Catch: Throwable -> L97
    L99:
        th = th;
        r17 = "Web Skill download cleanup failed: file=";
        r18 = "Web Skill download cleanup failed";
    L111:
        e = move-exception;
        throw e;
    L41:
        if (r28.isFile() == false) goto L45;
        String r39 = r28.getName();
        d.h.b.o.c(r39, "getName(...)");
        if (d.o.o.c(r39, ".zip", true) == true) goto L46;
    L45:
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install_skill_package", false, "package_file_invalid", null, 20, null);
    L36:
        r29 = null;
        goto L37
    L32:
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "install_skill_package", false, "install_method_invalid", null, 20, null);
    L7:
        r1 = new u(r7, r0);
        goto L8
    }

    private final File downloadSkillPackage(String r18, long r19) {
        File r1 = File.createTempFile("skill_package_download_", ".zip", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir());     // Catch: IOException -> L20
        ITTNetFileTransfer r2 = (ITTNetFileTransfer) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNetFileTransfer.class), ITTNetFileTransfer.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L22;
        SkillManager r0 = (SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin");
        r1.delete();
        throw new Cdo();
    L22:
        d.h.b.o.a(r1);     // Catch: Exception -> L15
        com.obric.aiagent.ttnet.l r3 = r2.downloadToFile(new com.obric.aiagent.ttnet.i(r18, r1, d.a.ao.a(d.s.a("Accept", "application/zip, application/octet-stream")), 10000, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, Long.valueOf(r19), com.obric.aiagent.ttnet.m.f22288b, 5, true, true));     // Catch: Exception -> L15
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.ttnet.l.b.class) == false) goto L10;
        return r1;
    L10:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.ttnet.l.a.class) == false) goto L14;
        r1.delete();     // Catch: Exception -> L15
        throw new dn(((com.obric.aiagent.ttnet.l.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.ttnet.l.a.class, "com.obric.aiagent.plugin")).a(), Long.valueOf(r19), ((com.obric.aiagent.ttnet.l.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.ttnet.l.a.class, "com.obric.aiagent.plugin")).b());     // Catch: Exception -> L15
    L14:
        throw new d.k();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        r1.delete();
        throw e;
    L21:
        throw new dn(com.obric.aiagent.ttnet.k.g, Long.valueOf(r19), null, 4, null);
    }

    private final Object installStagedSkillPackage(final cf r20, String r21, com.obric.aiagent.skill.manager.api.q r22, d.h.a.a<d.x> r23, d.c.d<? super com.obric.aiagent.skill.manager.api.y> r24) {
        final d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, x.class) == false) goto L7;
        x r1 = (x) ZeusTransformUtils.preCheckCast(r0, x.class, "com.obric.aiagent.plugin");
        if ((r1.f19401e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f19401e -= Integer.MIN_VALUE;
    L8:
        x r2 = r1;
        Object r3 = r2.f19399c;
        Object r9 = d.c.a.b.a();
        int r4 = r2.f19401e;
        boolean r10 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r2.f19398b, h.class, "com.obric.aiagent.plugin");
        SkillManager r7 = (SkillManager) ZeusTransformUtils.preCheckCast(r2.f19397a, SkillManager.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L44:
        com.obric.aiagent.skill.manager.api.u r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.r r11 = null;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L48;
        com.obric.aiagent.skill.manager.api.r r12 = ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a();
    L70:
        com.obric.aiagent.skill.manager.api.e r13 = r7.getInstalledSkillRegistry().b(r6.a().a());
        if (r13 != null) goto L73;
        r13 = r6.a();
    L73:
        if (r12 != null) goto L82;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.i().a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L77;
    L80:
        if (r10 == false) goto L84;
        r11 = com.obric.aiagent.skill.manager.api.r.n;
    L84:
        return r6.a(r13, r11);
    L77:
        if (d.o.o.d(r14) == true) goto L80;
        r10 = false;
        goto L80
    L82:
        r11 = r12;
        goto L84
    L48:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L86;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.ao) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.ao.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L51:
        if (r15.hasNext() == false) goto L55;
        Object r16 = r15.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin")).a(), r6.a().a()) == false) goto L51;
    L56:
        com.obric.aiagent.skill.manager.api.an r17 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L59;
        com.obric.aiagent.skill.manager.api.am r18 = r17.b();
    L61:
        if (r18 != null) goto L63;
        int r19 = -1;
    L64:
        if (r19 == (-1)) goto L69;
        if (r19 == 1) goto L69;
        if (r19 == 2) goto L69;
        r12 = null;
    L69:
        r12 = com.obric.aiagent.skill.manager.api.r.n;
        goto L70
    L63:
        r19 = i.f19377b[r18.ordinal()];
        goto L64
    L59:
        r18 = null;
        goto L61
    L55:
        r16 = null;
        goto L56
    L86:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        Object r110 = this.createLock;
        monitor-enter(r110);
        r5.invoke();     // Catch: Throwable -> L87
        String r25 = cv.a(r20.d(), com.obric.aiagent.skill.manager.api.al.f19195a.a().e());     // Catch: Throwable -> L87
        com.obric.aiagent.skill.manager.api.e r26 = findInstalledIdentityConflict(r25, r20.d().a(), r20.d().e());     // Catch: Throwable -> L87
        if (r26 != null) goto L19;
        com.obric.aiagent.skill.manager.api.o r27 = new com.obric.aiagent.skill.manager.api.o(cy.c(r22), r21);     // Catch: Throwable -> L87
        String r28 = (String) ZeusTransformUtils.preCheckCast(this.currentUserNameProvider.invoke(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
        if (r28 != null) goto L28;
        r28 = "";
    L28:
        cm<? extends com.obric.aiagent.skill.manager.api.aq> r29 = cy.b(r27, r28);     // Catch: Throwable -> L87
        r6 = new h(commitNewLocalSkill(cy.a(cy.a(new com.obric.aiagent.skill.manager.api.d(r20.b(), null, false, null, 14, null)), r25, r29.a()), r29, cj.f, r5, false, new $$Lambda$SkillManager$shsbYf970M3Xy8T73GDkheBIokE(this, r20, r5)), com.obric.aiagent.skill.manager.api.w.f19318a);     // Catch: Throwable -> L87
    L29:
        monitor-exit(r110);
        if (r6.b() == com.obric.aiagent.skill.manager.api.w.f19318a) goto L90;
    L40:
        com.obric.aiagent.skill.manager.api.ap r30 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.ap.b(d.a.ax.a(r6.a().a())), com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        aw r31 = aw.f19532c;
        r2.f19397a = this;
        r2.f19398b = r6;
        r2.f19401e = 1;
        r3 = refreshSkillSignatures$impl_release(r30, r31, r2);
        if (r3 != r9) goto L43;
        return r9;
    L43:
        r7 = this;
        goto L44
    L90:
        gm.a(getSigningRepository(), r6.a(), cy.b(r22), null, 4, null);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        logFailure("Web Skill scan trigger persistence failed", "Web Skill scan trigger persistence failed: slug=" + r6.a().a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.manager.api.e r32 = getInstalledSkillRegistry().b(r6.a().a());
        if (r32 != null) goto L39;
        r32 = r6.a();
    L39:
        return r6.a(r32, com.obric.aiagent.skill.manager.api.r.o);
    L19:
        if (cy.a(r26) == false) goto L24;
        if (getPersistentRepository().a(r26.a(), r20.b()) == false) goto L24;
        r6 = new h(r26, com.obric.aiagent.skill.manager.api.w.f19319b);     // Catch: Throwable -> L87
    L24:
        throw new cd(r26.a(), conflictField(r26, r25, r20.d().a()));     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        throw th;
    L7:
        r1 = new x(this, r0);
        goto L8
    }

    private static final com.obric.aiagent.skill.manager.api.e installStagedSkillPackage$lambda$39$lambda$38(SkillManager r7, cf r8, d.h.a.a r9, com.obric.aiagent.skill.manager.api.e r10) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "candidate");
        return com.obric.aiagent.skill.manager.impl.ag.a(r7.getPersistentRepository(), r8.b(), r10, false, r4, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object applySkillChange(com.obric.aiagent.skill.manager.api.k r14, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.l>> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r16, j.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f19383d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        cf r13 = (cf) ZeusTransformUtils.preCheckCast(r0.f19382c, cf.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.r r18 = (com.obric.aiagent.skill.manager.api.r) ZeusTransformUtils.preCheckCast(r0.f19381b, com.obric.aiagent.skill.manager.api.r.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.f19380a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L14
    L32:
        com.obric.aiagent.skill.manager.api.l r19 = (com.obric.aiagent.skill.manager.api.l) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.manager.api.l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r13.e();     // Catch: Exception -> L38 CancellationException -> L43
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r19), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        Throwable th = th;
    L36:
        r13.e();     // Catch: Exception -> L38 CancellationException -> L43
        throw th;     // Catch: Exception -> L38 CancellationException -> L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r17);
        com.obric.aiagent.skill.manager.api.u<d.x> r110 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r110, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L22;
        return r110;
    L22:
        if (r14.b().isFile() == false) goto L46;
        String r111 = r14.b().getName();
        d.h.b.o.c(r111, "getName(...)");
        if (d.o.o.c(r111, ".zip", true) == false) goto L46;
        String r112 = "apply_skill_change";
        com.obric.aiagent.skill.manager.api.r r5 = com.obric.aiagent.skill.manager.api.r.o;
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40 CancellationException -> L43
        d.c.g r7 = r0.getContext();     // Catch: Exception -> L40 CancellationException -> L43
        File r10 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(access$getAppContext(this), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), "skill_apply_" + System.currentTimeMillis() + '_' + System.nanoTime());     // Catch: Exception -> L40 CancellationException -> L43
        by r8 = by.f19630a;     // Catch: Exception -> L40 CancellationException -> L43
        File r9 = r14.b();     // Catch: Exception -> L40 CancellationException -> L43
        String r11 = r14.b().getName();     // Catch: Exception -> L40 CancellationException -> L43
        d.h.b.o.c(r11, "getName(...)");     // Catch: Exception -> L40 CancellationException -> L43
        cf r4 = r8.a(r9, r11, r10, bx.f19625a.a(com.obric.aiagent.skill.manager.api.al.f19195a.a()), (d.h.a.a) ZeusTransformUtils.preCheckCast(new l(r7), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L40 CancellationException -> L43
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(r7), d.h.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        r0.f19380a = "apply_skill_change";     // Catch: Throwable -> L34
        r0.f19381b = r5;     // Catch: Throwable -> L34
        r0.f19382c = r4;     // Catch: Throwable -> L34
        r0.f = 1;     // Catch: Throwable -> L34
        Object r113 = access$applyStagedSkillChange(this, r14, r4, r12, r0);     // Catch: Throwable -> L34
        if (r113 != r2) goto L31;
        return r2;
    L31:
        r17 = r113;
        r13 = r4;
    L34:
        th = move-exception;
        th = th;
        r13 = r4;
    L40:
        e = e;
    L41:
        com.obric.aiagent.skill.manager.api.u.a r114 = dm.a(e, r112, r5);
        dm.a(r112, r114.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r114, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L46:
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "apply_skill_change", false, "package_file_invalid", null, 20, null);
    L43:
        e = move-exception;
        throw e;
    L38:
        e = e;
        r5 = r14;
        r112 = r0;
    L7:
        r0 = new j(this, r16);
        goto L8
    }

    private final Object applyStagedSkillChange(final com.obric.aiagent.skill.manager.api.k r25, cf r26, d.h.a.a<d.x> r27, d.c.d<? super com.obric.aiagent.skill.manager.api.l> r28) {
        final SkillManager r1 = this;
        cf r3 = r26;
        d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, m.class) == false) goto L7;
        m r7 = (m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.aiagent.plugin");
        if ((r7.j & Integer.MIN_VALUE) == 0) goto L7;
        r7.j -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.h;
        Object r9 = d.c.a.b.a();
        int r10 = r7.j;
        boolean r11 = true;
        com.obric.aiagent.skill.manager.api.r r12 = null;
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r7.f19386b, a.class, "com.obric.aiagent.plugin");
        SkillManager r0 = (SkillManager) ZeusTransformUtils.preCheckCast(r7.f19385a, SkillManager.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L70:
        com.obric.aiagent.skill.manager.api.u r5 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L74;
        r12 = ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a();
    L93:
        com.obric.aiagent.skill.manager.api.e r13 = r0.getInstalledSkillRegistry().b(r2.a().a());
        if (r13 != null) goto L97;
        r13 = r2.a();
    L97:
        return r2.a(r13, r12);
    L74:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L99;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.ao) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.ao.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L77:
        if (r14.hasNext() == false) goto L81;
        Object r15 = r14.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin")).a(), r2.a().a()) == false) goto L77;
    L82:
        com.obric.aiagent.skill.manager.api.an r16 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L93;
        if (r16.b() == com.obric.aiagent.skill.manager.api.am.g) goto L88;
        r11 = false;
    L88:
        if (r11 == true) goto L91;
        r16 = null;
    L91:
        if (r16 == null) goto L93;
        r12 = com.obric.aiagent.skill.manager.api.r.n;
        goto L93
    L81:
        r15 = null;
        goto L82
    L99:
        throw new d.k();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        co r17 = (co) ZeusTransformUtils.preCheckCast(r7.g, co.class, "com.obric.aiagent.plugin");
        cj r18 = (cj) ZeusTransformUtils.preCheckCast(r7.f, cj.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.q r19 = (com.obric.aiagent.skill.manager.api.q) ZeusTransformUtils.preCheckCast(r7.f19389e, com.obric.aiagent.skill.manager.api.q.class, "com.obric.aiagent.plugin");
        r4 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r7.f19388d, d.h.a.a.class, "com.obric.aiagent.plugin");
        cf r20 = (cf) ZeusTransformUtils.preCheckCast(r7.f19387c, cf.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.k r110 = (com.obric.aiagent.skill.manager.api.k) ZeusTransformUtils.preCheckCast(r7.f19386b, com.obric.aiagent.skill.manager.api.k.class, "com.obric.aiagent.plugin");
        SkillManager r21 = (SkillManager) ZeusTransformUtils.preCheckCast(r7.f19385a, SkillManager.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Exception -> L18 CancellationException -> L20
        com.obric.aiagent.skill.manager.api.q r22 = r19;
        r3 = r20;
    L54:
        a r23 = r21.commitStagedSkillChange(r110, r3, r4);     // Catch: Exception -> L18 CancellationException -> L20
        co r111 = r17;
        r1 = r21;
    L117:
        r111.a(r23.a());     // Catch: CancellationException -> L42 Exception -> L106
        if (r23.b() != com.obric.aiagent.skill.manager.api.i.f19264c) goto L64;
        com.obric.aiagent.skill.manager.api.e r24 = r1.getInstalledSkillRegistry().b(r23.a().a());
        if (r24 != null) goto L63;
        r24 = r23.a();
    L63:
        return r23.a(r24, null);
    L64:
        ep r29 = cy.b(r22);
        r1.getSigningRepository().a(r23.a(), r29, r111.a());     // Catch: Exception -> L100
        com.obric.aiagent.skill.manager.api.ap r30 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.ap.b(d.a.ax.a(r23.a().a())), com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        aw r31 = aw.f19532c;
        r7.f19385a = r1;
        r7.f19386b = r23;
        r7.f19387c = null;
        r7.f19388d = null;
        r7.f19389e = null;
        r7.f = null;
        r7.g = null;
        r7.j = 2;
        r8 = r1.refreshSkillSignatures$impl_release(r30, r31, r7);
        if (r8 != r9) goto L69;
        return r9;
    L69:
        r0 = r1;
        r2 = r23;
    L100:
        e = move-exception;
        r1.logFailure("Apply Skill scan trigger persistence failed", "Apply Skill scan trigger persistence failed: slug=" + r23.a().a() + ", trigger=" + r29.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.manager.api.e r32 = r1.getInstalledSkillRegistry().b(r23.a().a());
        if (r32 != null) goto L105;
        r32 = r23.a();
    L105:
        return r23.a(r32, com.obric.aiagent.skill.manager.api.r.o);
    L106:
        e = e;
    L41:
        r17 = r111;
    L109:
        r17.a(r18, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw e;
    L20:
        e = e;
    L111:
        r17.b();
        throw e;
    L18:
        e = e;
        goto L109
    L22:
        d.o.a(r8);
        int r33 = i.f19378c[r25.a().ordinal()];
        if (r33 == 1) goto L28;
        if (r33 != 2) goto L27;
        com.obric.aiagent.skill.manager.api.q r34 = com.obric.aiagent.skill.manager.api.q.f19297c;
    L29:
        r22 = r34;
        int r35 = i.f19378c[r25.a().ordinal()];
        if (r35 == 1) goto L35;
        if (r35 != 2) goto L34;
        cj r36 = cj.f19669e;
    L36:
        cj r37 = r36;
        r111 = co.f19684a.a(new cl(r22, r26.d().e(), r25.c(), null, null, null, null, 120, null), getTrackingReporter(), new $$Lambda$SkillManager$CtZ8mRLsfDMFm8rwDksgOVKaTes(r25, r1));
        r23 = r1.commitStagedSkillChange(r25, r3, r4);     // Catch: Exception -> L39 CancellationException -> L42 dh -> L44
        r18 = r37;
    L44:
        e = move-exception;
        if (r25.a() == com.obric.aiagent.skill.manager.api.j.f19268b) goto L49;
        throw e;     // Catch: Exception -> L39 CancellationException -> L42
    L49:
        if (bg.a(e.a()) == false) goto L124;
        r7.f19385a = r1;     // Catch: Exception -> L39 CancellationException -> L42
        r7.f19386b = r25;     // Catch: Exception -> L39 CancellationException -> L42
        r7.f19387c = r3;     // Catch: Exception -> L39 CancellationException -> L42
        r7.f19388d = r4;     // Catch: Exception -> L39 CancellationException -> L42
        r7.f19389e = r22;     // Catch: Exception -> L39 CancellationException -> L42
        r7.f = r37;     // Catch: Exception -> L39 CancellationException -> L42
        r7.g = r111;     // Catch: Exception -> L39 CancellationException -> L42
        r7.j = 1;     // Catch: Exception -> L39 CancellationException -> L42
        if (r1.refreshModificationSecurityOrThrow(r25, e, r7) != r9) goto L53;
        return r9;
    L53:
        r21 = r1;
        r110 = r25;
        r18 = r37;
        r17 = r111;
        goto L54
    L124:
        throw e;     // Catch: Exception -> L39 CancellationException -> L42
    L42:
        e = e;
        r17 = r111;
    L39:
        e = e;
        r18 = r37;
        goto L41
    L34:
        throw new d.k();
    L35:
        r36 = cj.f19668d;
        goto L36
    L27:
        throw new d.k();
    L28:
        r34 = com.obric.aiagent.skill.manager.api.q.f19296b;
    L7:
        r7 = new m(r1, r6);
        goto L8
    }

    private static final Boolean applyStagedSkillChange$lambda$42(com.obric.aiagent.skill.manager.api.k r0, SkillManager r1) {
        String r2 = r0.c();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r1.resolveFileDownloaded(r2);
    }

    private final a commitStagedSkillChange(com.obric.aiagent.skill.manager.api.k r4, cf r5, d.h.a.a<d.x> r6) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        Object r0 = this.createLock;
        monitor-enter(r0);
        r7.invoke();     // Catch: Throwable -> L14
        com.obric.aiagent.skill.manager.api.j r1 = r4.a();     // Catch: Throwable -> L14
        int r2 = i.f19378c[r1.ordinal()];     // Catch: Throwable -> L14
        if (r2 != 1) goto L7;
        a r3 = applyCreatedOVirtPackage(r5, r7);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r3;
    L7:
        if (r2 != 2) goto L10;
        r3 = applyUpdatedOVirtPackage(r4, r5);     // Catch: Throwable -> L14
        goto L12
    L10:
        throw new d.k();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private final Object refreshModificationSecurityOrThrow(com.obric.aiagent.skill.manager.api.k r7, dh r8, d.c.d<? super d.x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ad.class) == false) goto L7;
        ad r0 = (ad) ZeusTransformUtils.preCheckCast(r10, ad.class, "com.obric.aiagent.plugin");
        if ((r0.f19345e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19345e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f19343c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19345e;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.f19342b, String.class, "com.obric.aiagent.plugin");
        r8 = (dh) ZeusTransformUtils.preCheckCast(r0.f19341a, dh.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L34:
        com.obric.aiagent.skill.manager.api.u r12 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.manager.api.u.a.class) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L63;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.ao) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.ao.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L40:
        if (r13.hasNext() == false) goto L44;
        Object r14 = r13.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin")).a(), r6) == false) goto L40;
        r4 = r14;
    L44:
        com.obric.aiagent.skill.manager.api.an r15 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L61;
        if (r15.b() == com.obric.aiagent.skill.manager.api.am.f) goto L59;
        if (gn.a(r15) == true) goto L57;
        if (r15.b() == com.obric.aiagent.skill.manager.api.am.g) goto L55;
        return d.x.f38692a;
    L55:
        throw new dh(di.f19747e, r6, r8.b());
    L57:
        throw new dh(di.f19746d, r6, r8.b());
    L59:
        throw new dl();
    L61:
        throw new dh(di.f19747e, r6, r8.b());
    L63:
        throw new d.k();
    L65:
        throw new dh(di.f19747e, r6, r8.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        String r16 = r7.c();
        if (r16 == null) goto L17;
        String r17 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L18:
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L66;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L25;
    L28:
        boolean r19 = true;
    L29:
        if (r19 == true) goto L70;
        com.obric.aiagent.skill.manager.api.ap r20 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.ap.b(d.a.ax.a(r17)), com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        aw r5 = aw.f19534e;
        r0.f19341a = r8;
        r0.f19342b = r17;
        r0.f19345e = 1;
        r11 = refreshSkillSignatures$impl_release(r20, r5, r0);
        if (r11 != r2) goto L33;
        return r2;
    L33:
        r6 = r17;
        goto L34
    L70:
        throw r8;
    L25:
        if (d.o.o.d(r18) == true) goto L28;
        r19 = false;
        goto L29
    L66:
        throw r8;
    L17:
        r17 = null;
    L7:
        r0 = new ad(this, r10);
        goto L8
    }

    private final a applyCreatedOVirtPackage(final cf r26, d.h.a.a<d.x> r27) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r6 = cv.a(r26.d(), com.obric.aiagent.skill.manager.api.al.f19195a.a().c());
        com.obric.aiagent.skill.manager.api.e r3 = findInstalledIdentityConflict(r6, r26.d().a(), r26.d().e());
        if (r3 != null) goto L5;
        String r7 = r26.d().e();
        String r8 = r26.d().b();
        com.obric.aiagent.skill.manager.api.ar r5 = com.obric.aiagent.skill.manager.api.ar.f19224c;
        String r12 = (String) ZeusTransformUtils.preCheckCast(this.currentUserNameProvider.invoke(), String.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        com.obric.aiagent.skill.manager.api.e r4 = getInstalledSkillRegistry().a(new com.obric.aiagent.skill.manager.api.e(r6, r7, r8, null, null, null, (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.b(r5, r12), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), null, (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.d.f19189a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin"), 0, d.f.k.a(new File(r26.b(), "SKILL.md"), null, 1, null), true, true, null, null, null, null, 123576, null), new $$Lambda$SkillManager$MLojPRv2ZVW2fgyZuPZvLq2NyJc(this, r26, r0));
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L18
        ((SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin")).getTrackingReporter().a(r4, true);     // Catch: Throwable -> L18
        Object r2 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L18
    L20:
        Throwable r9 = d.n.c(r2);
        if (r9 == null) goto L24;
        logFailure("Apply Skill create tracking failed", "Apply Skill create tracking failed: slug=" + r4.a(), r9);
    L24:
        return new a(r4, com.obric.aiagent.skill.manager.api.i.f19262a, null);
    L18:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L20
    L5:
        if (ZeusTransformUtils.instanceOf(r3.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L11;
        if (getPersistentRepository().a(r3.a(), r26.b()) == false) goto L11;
        return new a(r3, com.obric.aiagent.skill.manager.api.i.f19264c, Integer.valueOf(r3.j()));
    L11:
        throw new cd(r3.a(), conflictField(r3, r6, r26.d().a()));
    }

    private static final com.obric.aiagent.skill.manager.api.e applyCreatedOVirtPackage$lambda$49(SkillManager r2, cf r3, d.h.a.a r4, com.obric.aiagent.skill.manager.api.e r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "normalized");
        return r2.getPersistentRepository().a(r3.b(), r5, r6);
    }

    private final a applyUpdatedOVirtPackage(com.obric.aiagent.skill.manager.api.k r4, cf r5) {
        String r6 = r4.c();
        if (r6 == null) goto L5;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L6:
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        com.obric.aiagent.skill.manager.api.e r8 = getInstalledSkillRegistry().b(r7);
        if (r8 == null) goto L25;
        if (ZeusTransformUtils.instanceOf(r8.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L23;
        com.obric.aiagent.skill.manager.impl.x r9 = getPersistentRepository().a(r5.b(), r8);
        com.obric.aiagent.skill.manager.api.e r10 = getInstalledSkillRegistry().a(r9.a());
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L15
        ((SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin")).getTrackingReporter().b(r10, true);     // Catch: Throwable -> L15
        Object r0 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r2 = d.n.c(r0);
        if (r2 == null) goto L21;
        logFailure("Apply Skill update tracking failed", "Apply Skill update tracking failed: slug=" + r10.a(), r2);
    L21:
        return new a(r10, com.obric.aiagent.skill.manager.api.i.f19263b, Integer.valueOf(r9.b()));
    L15:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r0 = d.n.f(d.o.a(th));
        goto L17
    L23:
        throw new dk();
    L25:
        throw new dl();
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object prepareInstalledSkillProjection(d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.aa>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L7;
        ab r0 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin");
        if ((r0.f19340e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19340e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f19338c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19340e;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        com.obric.aiagent.skill.manager.api.r r7 = (com.obric.aiagent.skill.manager.api.r) ZeusTransformUtils.preCheckCast(r0.f19337b, com.obric.aiagent.skill.manager.api.r.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.f19336a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Exception -> L14 CancellationException -> L16
    L28:
    L40:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r10), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        e = e;
    L32:
        com.obric.aiagent.skill.manager.api.u.a r11 = dm.a(e, r1, r7);
        dm.a(r1, r11.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r10);
        g r12 = new g();
        long r5 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.manager.api.u<d.x> r4 = ensureReadyInternal();
        r12.a(eb.a(r5));
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L23;
        return r4;
    L23:
        com.obric.aiagent.skill.manager.api.r r6 = com.obric.aiagent.skill.manager.api.r.p;
        d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19336a = "skill_projection_prepare";     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19337b = r6;     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19340e = 1;     // Catch: CancellationException -> L16 Exception -> L30
        r10 = access$prepareInstalledSkillProjectionInternal(this, r12, r0);     // Catch: CancellationException -> L16 Exception -> L30
        if (r10 != r2) goto L27;
        return r2;
    L27:
        r1 = "skill_projection_prepare";
        r7 = r6;
    L30:
        e = e;
        r1 = "skill_projection_prepare";
        r7 = r6;
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new ab(this, r9);
        goto L8
    }

    private final Object prepareInstalledSkillProjectionInternal(g r17, d.c.d<? super com.obric.aiagent.skill.manager.api.aa> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtime();
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.al r8 = com.obric.aiagent.skill.manager.api.al.f19195a.a();     // Catch: Throwable -> L88
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(getInstalledSkillRegistry().a().c(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L88
    L5:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();     // Catch: Throwable -> L88
        if (bl.f19568a.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a()) == false) goto L5;
        r10.add(r12);     // Catch: Throwable -> L88
        goto L5
    L9:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L88
    L11:
        if (r15.hasNext() == false) goto L15;
        Object r16 = r15.next();     // Catch: Throwable -> L88
        if (bs.f19588a.a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r8) == true) goto L11;
        r14.add(r16);     // Catch: Throwable -> L88
        goto L11
    L15:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        r17.a(r19.size());     // Catch: Throwable -> L88
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L88
    L17:
        if (r110.hasNext() == false) goto L26;
        com.obric.aiagent.skill.manager.api.e r111 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r110.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        com.obric.aiagent.skill.manager.api.f r112 = com.obric.aiagent.skill.manager.api.g.f19256a.a(r111, r8.w());     // Catch: Throwable -> L88
        if (d.h.b.o.a(r112, com.obric.aiagent.skill.manager.api.f.a.f19254a) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r112, com.obric.aiagent.skill.manager.api.f.b.class) == false) goto L25;
        r17.c(r17.a() + 1);     // Catch: Throwable -> L88
        logDebug("Skill projection skipped reason=" + ((com.obric.aiagent.skill.manager.api.f.b) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.skill.manager.api.f.b.class, "com.obric.aiagent.plugin")).a().a(), "Skill projection skipped: slug=" + r111.a() + ", reason=" + ((com.obric.aiagent.skill.manager.api.f.b) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.skill.manager.api.f.b.class, "com.obric.aiagent.plugin")).a().a());     // Catch: Throwable -> L88
        goto L17
    L25:
        throw new d.k();     // Catch: Throwable -> L88
    L20:
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(r111);     // Catch: Throwable -> L88
        goto L17
    L26:
        r17.b(r1.size());     // Catch: Throwable -> L88
        r17.b(eb.a(r6));
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r20 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        long r113 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L78
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L75
    L31:
        if (r21.hasNext() == false) goto L73;
        com.obric.aiagent.skill.manager.api.e r114 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        r17.d(r17.b() + 1);     // Catch: Throwable -> L75
        File r115 = null;
        r115 = getPersistentRepository().d(r114.a());     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
        com.obric.aiagent.skill.manager.impl.ab r2 = getObricManifestReader().a(r115, r114.a());     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
        if (d.h.b.o.a(r2, com.obric.aiagent.skill.manager.impl.ab.b.f19436a) == false) goto L38;
        List<String> r3 = d.a.p.b();     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
    L40:
        f r4 = resolveCliTools(r114.a(), r3);     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
        if (r4.b() > 0) goto L46;
        r17.f(r17.d() + r4.a().size());     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
        Iterator r116 = r21;
        ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).add(new com.obric.aiagent.skill.manager.api.ac(r114.a(), r115, r4.a()));     // Catch: Exception -> L53 CancellationException -> L69 Throwable -> L75
    L68:
        r21 = r116;
    L53:
        e = e;
    L57:
        r17.e(r17.c() + 1);     // Catch: Throwable -> L75
        if (r115 == null) goto L60;
        getPersistentRepository().a(r115);     // Catch: Throwable -> L75
    L60:
        logFailure("Skill projection preparation failed", "Skill projection preparation failed: slug=" + r114.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L75
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        String r117 = r114.a();     // Catch: Throwable -> L75
        if (ZeusTransformUtils.instanceOf(e, c.class) == false) goto L64;
        String r5 = "invalid_obric_package";
    L67:
        r22.add(new com.obric.aiagent.skill.manager.api.ad(r117, r5));     // Catch: Throwable -> L75
        goto L68
    L64:
        if (ZeusTransformUtils.instanceOf(e, d.class) == false) goto L66;
        r5 = "required_cli_missing";
        goto L67
    L66:
        r5 = "host_staging_failed";
        goto L67
    L46:
        throw new d();     // Catch: Exception -> L53 CancellationException -> L69 Throwable -> L75
    L38:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.impl.ab.c.class) == false) goto L48;
        r3 = ((com.obric.aiagent.skill.manager.impl.ab.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.impl.ab.c.class, "com.obric.aiagent.plugin")).b().b();     // Catch: Exception -> L55 CancellationException -> L69 Throwable -> L75
        goto L40
    L48:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.impl.ab.a.class) == false) goto L52;
        throw new c(((com.obric.aiagent.skill.manager.impl.ab.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.impl.ab.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L53 CancellationException -> L69 Throwable -> L75
    L52:
        throw new d.k();     // Catch: Exception -> L53 CancellationException -> L69 Throwable -> L75
    L69:
        e = move-exception;
        if (0 == 0) goto L72;
        getPersistentRepository().a(null);     // Catch: Throwable -> L75
    L72:
        throw e;     // Catch: Throwable -> L75
    L55:
        e = e;
        r116 = r21;
        goto L57
    L73:
        r17.c(eb.a(r113));     // Catch: Throwable -> L78
        logInfo("Skill projection preparation settled installed=" + r19.size() + ", rejected=" + r17.a() + ", prepared=" + r7.size(), "Skill projection preparation settled: installed=" + r19.size() + ", rejected=" + r17.a() + ", prepared=" + r7.size());     // Catch: Throwable -> L78
        return new e(r7, r20, r17.e(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new ac(getPersistentRepository()), d.h.a.b.class, "com.obric.aiagent.plugin"));
    L75:
        th = move-exception;
        r17.c(eb.a(r113));     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L81:
        if (r23.hasNext() == false) goto L87;
        getPersistentRepository().a(((com.obric.aiagent.skill.manager.api.ac) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.aiagent.skill.manager.api.ac.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        d.a.a(th, th);
        goto L81
    L87:
        throw th;
    L88:
        th = move-exception;
        r17.b(eb.a(r6));
        throw th;
    }

    private final com.obric.aiagent.skill.manager.api.e importSkillInternal(final com.obric.aiagent.skill.manager.api.d r10, com.obric.aiagent.skill.manager.api.o r11, d.h.a.a<d.x> r12) {
        final d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(this.currentUserNameProvider.invoke(), String.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        cm<? extends com.obric.aiagent.skill.manager.api.aq> r2 = cy.b(r11, r13);
        com.obric.aiagent.skill.manager.api.e r14 = cy.a(r10);
        logInfo("Import skill package requested entry=" + r11.a() + ", isUpdate=" + r10.c() + ", nameLength=" + r14.b().length() + ", contentLength=" + r14.k().length(), "Import skill package requested: packageDir=" + r10.a().getName() + ", source=" + r2.a().a() + ", entry=" + r11.a() + ", isUpdate=" + r10.c() + ", nameLength=" + r14.b().length() + ", contentLength=" + r14.k().length());
        Object r15 = this.createLock;
        monitor-enter(r15);
        com.obric.aiagent.skill.manager.api.e r0 = getInstalledSkillRegistry().b(r14.a());     // Catch: Throwable -> L27
        if (r10.c() == false) goto L13;
        if (r0 != null) goto L13;
        throw new dl();     // Catch: Throwable -> L27
    L13:
        com.obric.aiagent.skill.manager.api.b r1 = r10.d();     // Catch: Throwable -> L27
        if (r1 == null) goto L16;
        com.obric.aiagent.skill.manager.api.a r3 = r1.a();     // Catch: Throwable -> L27
    L17:
        if (r3 != null) goto L19;
        com.obric.aiagent.skill.manager.api.aq r5 = r2.a();     // Catch: Throwable -> L27
    L20:
        com.obric.aiagent.skill.manager.api.e r6 = cy.a(r14, r5, r3, r0);     // Catch: Throwable -> L27
        d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r7 = new $$Lambda$SkillManager$HLttwXn5vAN541vACIi5YNgkxtw(this, r10, r4);     // Catch: Throwable -> L27
        if (r10.c() == false) goto L23;
        com.obric.aiagent.skill.manager.api.e r16 = commitUpdatedLocalSkill(r6, r2, cj.f, r4, r7);     // Catch: Throwable -> L27
    L24:
        monitor-exit(r15);
        logInfo("Import skill package completed enabled=" + r16.l(), "Import skill package completed: slug=" + r16.a() + ", source=" + r16.g() + ", enabled=" + r16.l());
        return r16;
    L23:
        r16 = commitNewLocalSkill$default(this, r6, r2, cj.f, r4, false, r7, 16, null);     // Catch: Throwable -> L27
        goto L24
    L19:
        r5 = (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aq.a.f19212a, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        goto L20
    L16:
        r3 = null;
    L27:
        th = move-exception;
        throw th;
    }

    private static final com.obric.aiagent.skill.manager.api.e importSkillInternal$lambda$63$lambda$62(SkillManager r2, com.obric.aiagent.skill.manager.api.d r3, d.h.a.a r4, com.obric.aiagent.skill.manager.api.e r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "normalized");
        return r2.getPersistentRepository().a(r3.a(), r5, r3.c(), r6);
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.e commitNewLocalSkill$default(SkillManager r9, com.obric.aiagent.skill.manager.api.e r10, cm r11, cj r12, d.h.a.a r13, boolean r14, d.h.a.b r15, int r16, Object r17) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L5;
        boolean r7 = true;
    L7:
        return r9.commitNewLocalSkill(r10, r11, r12, r6, r7, r8);
    L5:
        r7 = r14;
        goto L7
    }

    private final com.obric.aiagent.skill.manager.api.e commitNewLocalSkill(final com.obric.aiagent.skill.manager.api.e r19, cm<? extends com.obric.aiagent.skill.manager.api.aq> r20, cj r21, d.h.a.a<d.x> r22, boolean r23, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r24) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        co r3 = co.f19684a.a(new cl(r20.b(), r19.b(), r19.a(), r20.c(), null, null, null, 112, null), getTrackingReporter(), new $$Lambda$SkillManager$Tt_jn64k3Uv4XTBmXLFgYmoImMY(this, r19));
        r2.invoke();     // Catch: Exception -> L7 CancellationException -> L10
        com.obric.aiagent.skill.manager.api.e r1 = getInstalledSkillRegistry().a(r19, r4);     // Catch: Exception -> L7 CancellationException -> L10
        r3.a(r1);     // Catch: Exception -> L7 CancellationException -> L10
        getTrackingReporter().a(r1, resolveFileDownloaded(r1.a()));     // Catch: Exception -> L7 CancellationException -> L10
        if (r23 == false) goto L6;
        scheduleSignatureRefresh(r1, r20.d(), r3.a());     // Catch: Exception -> L7 CancellationException -> L10
    L6:
        return r1;
    L10:
        e = move-exception;
        r3.b();
        throw e;
    L7:
        e = move-exception;
        r3.a(r21, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw e;
    }

    private static final Boolean commitNewLocalSkill$lambda$64(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return r0.resolveFileDownloaded(r1.a());
    }

    private final com.obric.aiagent.skill.manager.api.e commitUpdatedLocalSkill(final com.obric.aiagent.skill.manager.api.e r19, cm<? extends com.obric.aiagent.skill.manager.api.aq> r20, cj r21, d.h.a.a<d.x> r22, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r23) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.b.class, "com.obric.aiagent.plugin");
        co r3 = co.f19684a.a(new cl(r20.b(), r19.b(), r19.a(), r20.c(), null, null, null, 112, null), getTrackingReporter(), new $$Lambda$SkillManager$XSvc5bjM0jKOtARE5r3PgHieR1g(this, r19));
        r2.invoke();     // Catch: Exception -> L5 CancellationException -> L8
        com.obric.aiagent.skill.manager.api.e r1 = getInstalledSkillRegistry().b(r19, r4);     // Catch: Exception -> L5 CancellationException -> L8
        r3.a(r1);     // Catch: Exception -> L5 CancellationException -> L8
        getTrackingReporter().b(r1, resolveFileDownloaded(r1.a()));     // Catch: Exception -> L5 CancellationException -> L8
        scheduleSignatureRefresh(r1, r20.d(), r3.a());     // Catch: Exception -> L5 CancellationException -> L8
        return r1;
    L8:
        e = move-exception;
        r3.b();
        throw e;
    L5:
        e = move-exception;
        r3.a(r21, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw e;
    }

    private static final Boolean commitUpdatedLocalSkill$lambda$65(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1) {
        return r0.resolveFileDownloaded(r1.a());
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> saveSkill(com.obric.aiagent.skill.manager.api.e r20) {
        d.h.b.o.e(r20, "skill");
        com.obric.aiagent.skill.manager.api.u r2 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L5;
        return r2;
    L5:
        String r3 = r20.a();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.obric.aiagent.skill.manager.api.e r7 = getInstalledSkillRegistry().b(r3);
        if (r7 == null) goto L12;
        List<bf> r4 = changedPerformanceEditFields(r7, r20);
        if (r4.isEmpty() == false) goto L23;
        com.obric.aiagent.skill.manager.api.r r5 = com.obric.aiagent.skill.manager.api.r.o;
    L51:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(saveSkillInternal(r20, null)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L21:
        e = move-exception;
        throw e;
    L18:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r1 = dm.a(e, "save", r5);
        dm.a("save", r1.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L23:
        ea r6 = new ea(dy.f19789d, getTrackingReporter(), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        Map r8 = d.a.ao.a(new d.m[]{d.s.a("edit_field", eb.a((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"))), d.s.a("old_version", Integer.valueOf(r7.j()))});
        di r9 = bg.a(r7.i());
        if (r9 == null) goto L28;
        com.obric.aiagent.skill.manager.api.u.a r0 = dm.a("save", r9);
        ea.a(r6, dz.f19795e, r7, null, null, null, null, eb.a(r0), "security_check", Boolean.valueOf(r0.b()), null, r8, 572, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L28:
        if (az.c(r7) == true) goto L31;
        com.obric.aiagent.skill.manager.api.u.a r10 = dm.a(com.obric.aiagent.skill.manager.api.r.f19303d, "save", false, "source_not_editable", null, 20, null);
        ea.a(r6, dz.f19795e, r7, null, null, null, null, eb.a(r10), "source_check", Boolean.valueOf(r10.b()), null, r8, 572, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L31:
        com.obric.aiagent.skill.manager.api.r r11 = com.obric.aiagent.skill.manager.api.r.o;
        com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r12 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(saveSkillInternal(r20, r6.a())), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34 CancellationException -> L45
    L37:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L40;
        ea.a(r6, dz.f19791a, (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, null, null, d.a.ao.a(r8, d.s.a("new_version", Integer.valueOf(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).j()))), DownloadErrorCode.ERROR_THREAD_INTERRUPT, null);
    L42:
        return r12;
    L40:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L44;
        ea.a(r6, dz.f19792b, r7, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "persist_or_registry", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, r8, 572, null);
        goto L42
    L44:
        throw new d.k();
    L45:
        e = move-exception;
        throw e;
    L34:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r13 = dm.a(e, "save", r11);
        dm.a("save", r13.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r12 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L37
    L12:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19301b, "save", false, "not_installed", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L8:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "save", false, "blank_slug", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.manager.api.e saveSkillInternal(com.obric.aiagent.skill.manager.api.e r24, String r25) {
        logInfo("Save skill requested contentLength=" + r24.k().length(), "Save skill requested: slug=" + r24.a() + ", contentLength=" + r24.k().length());
        com.obric.aiagent.skill.manager.api.e r1 = getInstalledSkillRegistry().b(r24.a());
        if (r1 == null) goto L25;
        bg.c(r1);
        bg.a(r1);
        com.obric.aiagent.skill.manager.api.e r2 = getInstalledSkillRegistry().a(getPersistentRepository().b(com.obric.aiagent.skill.manager.api.e.a(r24, r1.a(), null, null, null, null, null, r1.g(), null, r1.i(), 0, null, r1.l(), r1.m(), null, null, null, null, 124606, null)));
        boolean r4 = true;
        if (r2.j() == r1.j()) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        getTrackingReporter().b(r2, resolveFileDownloaded(r2.a()));
        if (az.b(r2) == false) goto L12;
        scheduleSignatureRefresh(r2, ep.k, r25);
    L12:
        StringBuilder r5 = new StringBuilder().append("Save skill completed enabled=").append(r2.l()).append(", resign=");
        if (az.b(r2) == false) goto L16;
        if (r3 == false) goto L16;
        boolean r7 = true;
    L17:
        String r6 = r5.append(r7).toString();
        StringBuilder r8 = new StringBuilder().append("Save skill completed: slug=").append(r2.a()).append(", source=").append(r2.g()).append(", enabled=").append(r2.l()).append(", resign=");
        if (az.b(r2) == false) goto L21;
        if (r3 == false) goto L21;
    L22:
        logInfo(r6, r8.append(r4).toString());
        return r2;
    L21:
        r4 = false;
    L16:
        r7 = false;
        goto L17
    L7:
        r3 = false;
        goto L8
    L25:
        throw new IllegalArgumentException("Installed skill not found: " + r24.a());
    }

    private final List<bf> changedPerformanceEditFields(com.obric.aiagent.skill.manager.api.e r5, com.obric.aiagent.skill.manager.api.e r6) {
        List r4 = d.a.p.a();
        if (d.h.b.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString()) == true) goto L6;
        r4.add(bf.f19556a);
    L6:
        if (d.h.b.o.a(r5.c(), r6.c()) == true) goto L9;
        r4.add(bf.f19557b);
    L9:
        if (d.h.b.o.a(r5.k(), r6.k()) == true) goto L12;
        r4.add(bf.f19558c);
    L12:
        return d.a.p.a(r4);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> saveSkillCover(String r19, String r20) {
        d.h.b.o.e(r19, "slug");
        d.h.b.o.e(r20, "coverUrl");
        com.obric.aiagent.skill.manager.api.u r2 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L6;
        return r2;
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.obric.aiagent.skill.manager.api.e r6 = getInstalledSkillRegistry().b(r19);
        if (r6 != null) goto L14;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19301b, "save_cover", false, "not_installed", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        if (d.h.b.o.a(r6.f(), r20) == true) goto L16;
        ea r3 = new ea(dy.p, getTrackingReporter(), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        di r4 = bg.a(r6.i());
        if (r4 == null) goto L22;
        com.obric.aiagent.skill.manager.api.u.a r0 = dm.a("save_cover", r4);
        ea.a(r3, dz.f19795e, r6, null, null, null, null, eb.a(r0), "security_check", null, null, null, 1852, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L22:
        if (ZeusTransformUtils.instanceOf(r6.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == true) goto L25;
        com.obric.aiagent.skill.manager.api.u.a r1 = dm.a(com.obric.aiagent.skill.manager.api.r.f19303d, "save_cover", false, "source_not_editable", null, 20, null);
        ea.a(r3, dz.f19795e, r6, null, null, null, null, eb.a(r1), "source_check", null, null, null, 1852, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L25:
        com.obric.aiagent.skill.manager.api.r r5 = com.obric.aiagent.skill.manager.api.r.o;
        com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r7 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(saveSkillCoverInternal(r19, r20)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28 CancellationException -> L39
    L31:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L34;
        ea.a(r3, dz.f19791a, (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, null, null, null, 2044, null);
    L36:
        return r7;
    L34:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L38;
        ea.a(r3, dz.f19792b, r6, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "persist_or_registry", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, null, 1596, null);
        goto L36
    L38:
        throw new d.k();
    L39:
        e = move-exception;
        throw e;
    L28:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r8 = dm.a(e, "save_cover", r5);
        dm.a("save_cover", r8.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r7 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L31
    L16:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r6), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L8:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "save_cover", false, "blank_slug", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.manager.api.e saveSkillCoverInternal(String r3, String r4) {
        logInfo("Save skill cover requested", "Save skill cover requested: slug=" + r3);
        com.obric.aiagent.skill.manager.api.e r0 = getInstalledSkillRegistry().b(r3);
        if (r0 == null) goto L7;
        bg.c(r0);
        bg.b(r0);
        com.obric.aiagent.skill.manager.api.e r5 = getInstalledSkillRegistry().a(getPersistentRepository().a(r0.a(), r4));
        logInfo("Save skill cover completed", "Save skill cover completed: slug=" + r5.a() + ", source=" + r5.g() + ", version=" + r5.j());
        return r5;
    L7:
        throw new IllegalArgumentException("Installed skill not found: " + r3);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object loadSkill(String r18, String r19, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.c>> r20) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, y.class) == false) goto L7;
        y r3 = (y) ZeusTransformUtils.preCheckCast(r1, y.class, "com.obric.aiagent.plugin");
        if ((r3.f19405d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f19405d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f19403b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f19405d;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        ct r6 = (ct) ZeusTransformUtils.preCheckCast(r3.f19402a, ct.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Exception -> L14 CancellationException -> L16
        ct r10 = r6;
    L60:
        com.obric.aiagent.skill.manager.api.u r0 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44 CancellationException -> L46
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L29;
        r10.a(((com.obric.aiagent.skill.manager.api.c) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.c.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L44 CancellationException -> L46
        ct.a(r10, dz.f19791a, null, null, null, 12, null);     // Catch: Exception -> L44 CancellationException -> L46
    L41:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L29:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L43;
        if (((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() != com.obric.aiagent.skill.manager.api.r.j) goto L33;
    L38:
        dz r7 = dz.f19795e;     // Catch: Exception -> L44 CancellationException -> L46
    L39:
        ct.a(r10, r7, null, (com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"), null, 10, null);     // Catch: Exception -> L44 CancellationException -> L46
        goto L41
    L33:
        if (((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() == com.obric.aiagent.skill.manager.api.r.f19304e) goto L38;
        if (((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() == com.obric.aiagent.skill.manager.api.r.f19302c) goto L38;
        r7 = dz.f19792b;     // Catch: Exception -> L44 CancellationException -> L46
        goto L39
    L43:
        throw new d.k();     // Catch: Exception -> L44 CancellationException -> L46
    L46:
        e = e;
    L54:
        ct.a(r10, dz.f19793c, null, null, dw.n, 6, null);
        throw e;
    L44:
        e = e;
        r6 = r10;
    L50:
        ct.a(r6, dz.f19792b, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 6, null);
        throw e;
    L16:
        e = e;
        r10 = r6;
    L14:
        e = e;
        goto L50
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r2);
        ct r8 = new ct(getTrackingReporter(), r18, r19, 0, 8, null);
        r3.f19402a = r8;     // Catch: Exception -> L48 CancellationException -> L52
        r3.f19405d = 1;     // Catch: Exception -> L48 CancellationException -> L52
        Object r9 = loadSkillInternal(r18, r19, r8, r3);     // Catch: Exception -> L48 CancellationException -> L52
        if (r9 != r4) goto L24;
        return r4;
    L24:
        r10 = r8;
        r2 = r9;
        goto L60
    L52:
        e = e;
        r10 = r8;
    L48:
        e = e;
        r6 = r8;
    L7:
        r3 = new y(this, r1);
        goto L8
    }

    private final Object loadSkillInternal(String r49, String r50, ct r51, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.c>> r52) {
        String r1 = r49;
        String r2 = r50;
        ct r3 = r51;
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r52, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, z.class) == false) goto L7;
        z r7 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
        if ((r7.h & Integer.MIN_VALUE) == 0) goto L7;
        r7.h -= Integer.MIN_VALUE;
    L8:
        z r14 = r7;
        Object r6 = r14.f;
        Object r8 = d.c.a.b.a();
        int r9 = r14.h;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        long r0 = r14.f19410e;
        ct r4 = (ct) ZeusTransformUtils.preCheckCast(r14.f19409d, ct.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r14.f19408c, String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r14.f19407b, String.class, "com.obric.aiagent.plugin");
        SkillManager r12 = (SkillManager) ZeusTransformUtils.preCheckCast(r14.f19406a, SkillManager.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        long r13 = r0;
        Object r15 = r6;
        r1 = r11;
        r3 = r4;
        r2 = r10;
    L36:
        hi r16 = (hi) ZeusTransformUtils.preCheckCast(r15, hi.class, "com.obric.aiagent.plugin");
        r3.a("skill_update_duration_ms", r13);
        com.obric.aiagent.skill.manager.api.e r17 = r16.a();
        r3.a(r17);
        String r18 = r16.c().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r18, "toLowerCase(...)");
        r3.a("skill_update_result", r18);
        if (r16.c() != ar.f19514e) goto L39;
        boolean r19 = true;
    L40:
        r3.a("skill_update_fallback_used", d.c.b.a.b.a(r19));
        dw r20 = r16.h();
        if (r20 == null) goto L47;
        r3.a("skill_update_error_code", r20.a());
        com.obric.aiagent.skill.manager.api.u.a r110 = r16.g();
        if (r110 == null) goto L45;
        boolean r21 = r110.b();
    L46:
        r3.a("skill_update_retryable", d.c.b.a.b.a(r21));
        d.x r22 = d.x.f38692a;
        goto L47
    L45:
        r21 = eb.a(r20);
    L47:
        r3.a("cli_refresh_escaped_failure", d.c.b.a.b.a(r16.f()));
        dw r23 = r16.i();
        if (r23 == null) goto L50;
        r3.a("cli_refresh_error_code", r23.a());
        d.x r24 = d.x.f38692a;
    L50:
        r3.a("skill_version_before", d.c.b.a.b.a(r16.b()));
        r3.a("skill_version_after", d.c.b.a.b.a(r17.j()));
        com.obric.aiagent.skill.manager.impl.ab r25 = r16.d();
        if (ZeusTransformUtils.instanceOf(r25, com.obric.aiagent.skill.manager.impl.ab.c.class) == false) goto L53;
        com.obric.aiagent.skill.manager.impl.ab.c r26 = (com.obric.aiagent.skill.manager.impl.ab.c) ZeusTransformUtils.preCheckCast(r25, com.obric.aiagent.skill.manager.impl.ab.c.class, "com.obric.aiagent.plugin");
    L54:
        if (r26 == null) goto L56;
        boolean r111 = true;
    L57:
        r3.a("is_obric_package", d.c.b.a.b.a(r111));
        if (r26 == null) goto L62;
        com.obric.aiagent.skill.manager.impl.aa r27 = r26.b();
        if (r27 == null) goto L62;
        List<String> r28 = r27.b();
    L63:
        if (r28 != null) goto L65;
        r28 = d.a.p.b();
    L65:
        r3.a("required_cli_count", d.c.b.a.b.a(r28.size()));
        com.obric.aiagent.skill.manager.impl.ab r112 = r16.d();
        if (ZeusTransformUtils.instanceOf(r112, com.obric.aiagent.skill.manager.impl.ab.a.class) == false) goto L70;
        r12.logWarning("Load skill blocked reason=invalid_obric_package", "Load skill blocked: slug=" + r1 + ", reason=invalid_obric_package:" + ((com.obric.aiagent.skill.manager.impl.ab.a) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.skill.manager.impl.ab.a.class, "com.obric.aiagent.plugin")).a());
        return dm.a(com.obric.aiagent.skill.manager.api.r.l, "load", false, "invalid_obric_package", null, 20, null);
    L70:
        if (ZeusTransformUtils.instanceOf(r112, com.obric.aiagent.skill.manager.impl.ab.c.class) == false) goto L72;
    L76:
        r3.a(r12.loadCliPerformanceDimensions(r16));
        r3.a("metadata_hook");
        long r113 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.manager.api.r r114 = com.obric.aiagent.skill.manager.api.r.l;
        com.obric.aiagent.skill.manager.api.u r29 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r12.runBeforeLoadHooks(r17, r2)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L79 CancellationException -> L191
    L81:
        r3.a("metadata_hook_duration_ms", r113);
        if (ZeusTransformUtils.instanceOf(r29, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L187;
        com.obric.aiagent.skill.manager.api.e r115 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r29, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r115 != null) goto L88;
        ((SkillManager) ZeusTransformUtils.preCheckCast(r12, SkillManager.class, "com.obric.aiagent.plugin")).logWarning("Load skill blocked reason=load_hook", r13 + r1 + ", reason=load_hook");
        return dm.a(com.obric.aiagent.skill.manager.api.r.l, "load", false, "load_hook_rejected", null, 20, null);
    L88:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r115.k(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L91;
        r12.logWarning("Load skill blocked reason=empty_content", r13 + r1 + ", reason=empty_content");
        return dm.a(com.obric.aiagent.skill.manager.api.r.l, "load", false, "empty_content", null, 20, null);
    L91:
        r3.a("cli_resolve");
        long r30 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.manager.api.r r116 = com.obric.aiagent.skill.manager.api.r.p;
        com.obric.aiagent.skill.manager.api.u r31 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r12.resolveCliTools(r115.a(), r28)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L94 CancellationException -> L184
    L96:
        String r32 = "fail";
        if (ZeusTransformUtils.instanceOf(r31, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L179;
        f r33 = (f) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r31, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), f.class, "com.obric.aiagent.plugin");
        r3.a("cli_resolve_duration_ms", r30);
        r3.a("missing_required_cli_count", d.c.b.a.b.a(r33.b()));
        if (r33.b() <= 0) goto L102;
        r3.a("cli_resolution_result", "missing");
        return dm.a(com.obric.aiagent.skill.manager.api.r.p, "load", true, "required_cli_missing", null, 16, null);
    L102:
        r3.a("cli_resolution_result", "success");
        List<com.obric.aiagent.skill.manager.api.ab> r34 = r33.a();
        if (r16.f() == true) goto L130;
        com.obric.aiagent.skill.manager.impl.l r35 = r16.e();
        if (r35 == null) goto L107;
        List<com.obric.aiagent.skill.manager.impl.q> r36 = r35.a();
    L108:
        if (r36 != null) goto L110;
        r36 = d.a.p.b();
    L110:
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r37, Collection.class) == true) goto L113;
    L115:
        Iterator r38 = r37.iterator();
    L117:
        if (r38.hasNext() == false) goto L114;
        com.obric.aiagent.skill.manager.impl.q r39 = (com.obric.aiagent.skill.manager.impl.q) ZeusTransformUtils.preCheckCast(r38.next(), com.obric.aiagent.skill.manager.impl.q.class, "com.obric.aiagent.plugin");
        if (r39.a() != com.obric.aiagent.skill.manager.impl.n.f20135c) goto L121;
    L124:
        boolean r117 = true;
    L125:
        if (r117 == false) goto L117;
        boolean r118 = true;
    L127:
        if (r118 == true) goto L130;
        boolean r119 = false;
    L131:
        if (r119 == true) goto L133;
    L135:
        boolean r120 = false;
    L136:
        r3.a("cli_fallback_used", d.c.b.a.b.a(r120));
        r3.a("load_session_hook_result", "delegated");
        r3.a("usage_persist");
        long r121 = SystemClock.elapsedRealtime();
        Long r40 = r12.getInstalledSkillRegistry().a(r115.a(), ((Number) ZeusTransformUtils.preCheckCast(r12.nowMillis.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L139
    L141:
        r3.a("usage_persist_duration_ms", r121);
        if (r40 == null) goto L145;
        r32 = "success";
    L145:
        r3.a("usage_persist_result", r32);
        if (r40 != null) goto L148;
        r40 = r115.o();
    L148:
        com.obric.aiagent.skill.manager.api.e r41 = com.obric.aiagent.skill.manager.api.e.a(r115, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, r40, null, null, 114687, null);
        r3.a("projected_path");
        long r122 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.manager.api.r r42 = com.obric.aiagent.skill.manager.api.r.p;
        com.obric.aiagent.skill.manager.api.u r43 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r12.projectedSkillDirFor(r41.a())), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L151 CancellationException -> L176
    L154:
        if (ZeusTransformUtils.instanceOf(r43, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L172;
        String r44 = (String) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r43, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), String.class, "com.obric.aiagent.plugin");
        r3.a("projected_path_duration_ms", r122);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r44, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L158;
        StringBuilder r45 = new StringBuilder().append("Load skill completed: slug=").append(r115.a()).append(", taskId=");
        if (r2 != null) goto L162;
        r2 = "";
    L162:
        CharSequence r46 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r46) == false) goto L165;
        r46 = "-";
    L165:
        r12.logInfo("Load skill completed", r45.append((String) ZeusTransformUtils.preCheckCast(r46, String.class, "com.obric.aiagent.plugin")).toString());
        Iterable r47 = (Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.aiagent.plugin");
        Collection r48 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r47, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r53 = r47.iterator();
    L167:
        if (r53.hasNext() == false) goto L170;
        r48.add(((com.obric.aiagent.skill.manager.api.ab) ZeusTransformUtils.preCheckCast(r53.next(), com.obric.aiagent.skill.manager.api.ab.class, "com.obric.aiagent.plugin")).a());
        goto L167
    L170:
        return new com.obric.aiagent.skill.manager.api.u.b(new com.obric.aiagent.skill.manager.api.c(r41, r44, (List) ZeusTransformUtils.preCheckCast(r48, List.class, "com.obric.aiagent.plugin")));
    L158:
        return dm.a(com.obric.aiagent.skill.manager.api.r.p, "load", true, "projected_dir_unavailable", null, 16, null);
    L172:
        if (ZeusTransformUtils.instanceOf(r43, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L175;
        return r43;
    L175:
        throw new d.k();
    L176:
        e = move-exception;
        throw e;
    L151:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r54 = dm.a(e, "load_projected_dir", r42);
        dm.a("load_projected_dir", r54.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r43 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r54, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L139:
        e = move-exception;
        r12.logFailure("Load skill usage timestamp failed", "Load skill usage timestamp failed: slug=" + r115.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r40 = null;
        goto L141
    L133:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L135;
        r120 = true;
        goto L136
    L121:
        if (r39.a() == com.obric.aiagent.skill.manager.impl.n.f20136d) goto L124;
        r117 = false;
    L114:
        r118 = false;
        goto L127
    L113:
        if (((Collection) ZeusTransformUtils.preCheckCast(r37, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L115;
    L107:
        r36 = null;
    L130:
        r119 = true;
        goto L131
    L179:
        if (ZeusTransformUtils.instanceOf(r31, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L183;
        r3.a("cli_resolve_duration_ms", r30);
        r3.a("cli_resolution_result", "fail");
        return r31;
    L183:
        throw new d.k();
    L184:
        e = move-exception;
        throw e;
    L94:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r55 = dm.a(e, "load_cli_resolve", r116);
        dm.a("load_cli_resolve", r55.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r31 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r55, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L96
    L187:
        if (ZeusTransformUtils.instanceOf(r29, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L190;
        return r29;
    L190:
        throw new d.k();
    L191:
        e = move-exception;
        throw e;
    L79:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r123 = dm.a(e, "load_hook", r114);
        dm.a("load_hook", r123.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r29 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r123, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L81
    L72:
        if (d.h.b.o.a(r112, com.obric.aiagent.skill.manager.impl.ab.b.f19436a) == true) goto L76;
        throw new d.k();
    L62:
        r28 = null;
        goto L63
    L56:
        r111 = false;
        goto L57
    L53:
        r26 = null;
        goto L54
    L39:
        r19 = false;
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        r3.a("input");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        r3.a("initialize");
        long r56 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.manager.api.u<d.x> r57 = ensureReadyInternal();
        r3.a("initialize_duration_ms", r56);
        if (ZeusTransformUtils.instanceOf(r57, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L21;
        return r57;
    L21:
        StringBuilder r58 = new StringBuilder().append("Load skill requested: slug=").append(r1).append(", taskId=");
        if (r2 != null) goto L24;
        String r59 = "";
    L25:
        CharSequence r60 = (CharSequence) ZeusTransformUtils.preCheckCast(r59, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r60) == false) goto L28;
        r60 = "-";
    L28:
        logDebug("Load skill requested", r58.append((String) ZeusTransformUtils.preCheckCast(r60, String.class, "com.obric.aiagent.plugin")).toString());
        r3.a("lookup");
        com.obric.aiagent.skill.manager.api.e r61 = getInstalledSkillRegistry().b(r1);
        if (r61 != null) goto L32;
        ((SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin")).logWarning("Load skill blocked reason=not_installed", "Load skill blocked: slug=" + r1 + ", reason=not_installed");
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19301b, "load", false, "not_installed", null, 20, null);
    L32:
        r3.a(r61);
        r3.a("enabled", d.c.b.a.b.a(r61.l()));
        r3.a("security_status", eb.a(r61.i()));
        r3.a("skill_update");
        long r124 = SystemClock.elapsedRealtime();
        hf r62 = getSkillUpdateCoordinator();
        hg r63 = hg.f20101a;
        boolean r125 = com.obric.aiagent.skill.manager.api.al.f19195a.a().D();
        r14.f19406a = this;
        r14.f19407b = r1;
        r14.f19408c = r2;
        r14.f19409d = r3;
        r14.f19410e = r124;
        r14.h = 1;
        Object r64 = hf.a(r62, r61, r63, r125, null, null, r14, 24, null);
        if (r64 != r8) goto L35;
        return r8;
    L35:
        r13 = r124;
        r12 = this;
        r15 = r64;
        goto L36
    L24:
        r59 = r2;
        goto L25
    L17:
        return dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "load", false, "blank_slug", null, 20, null);
    L7:
        r7 = new z(this, r5);
        goto L8
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public OSkillManagerConfig getSkillManagerConfig() {
        return this.configStore.a();
    L4:
        e = move-exception;
        logFailure("Get Skill Manager config failed; returning safe defaults", "Get Skill Manager config failed; returning safe defaults", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new OSkillManagerConfig(new Bundle());
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public boolean setSkillManagerConfigValues(Bundle r3) {
        d.h.b.o.e(r3, "values");
        return this.configStore.a(r3);
    L5:
        e = move-exception;
        logFailure("Set Skill Manager config failed", "Set Skill Manager config failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public String getSkillManagerStatus(String r6) {
        d.h.b.o.e(r6, "key");
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Exception -> L9
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L13;
        logSkillManagerStatusUnavailable("Get skill manager status ignored blank key");     // Catch: Exception -> L9
        return "";
    L13:
        return br.f19586a.a(r2);
    L9:
        e = move-exception;
        logFailure("Get Skill Manager status failed", "Get Skill Manager status failed: key=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return "";
    }

    private final void logSkillManagerStatusUnavailable(String r2) {
        ILogDepend.Companion r1 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == true) goto L6;
        r2 = "Skill manager status unavailable";
    L6:
        r1.w("SkillManager", r2);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<d.x> setSkillEnabled(String r35, boolean r36) {
        d.h.b.o.e(r35, "slug");
        com.obric.aiagent.skill.manager.api.u<d.x> r0 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L6;
        return r0;
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.obric.aiagent.skill.manager.api.e r21 = getInstalledSkillRegistry().b(r35);
        if (r21 != null) goto L14;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19301b, "set_enabled", false, "not_installed", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        if (r21.l() == r36) goto L16;
        ea r33 = new ea(dy.m, getTrackingReporter(), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        Map r22 = d.a.ao.a(d.s.a("target_enabled", Boolean.valueOf(r36)));
        if (r36 == true) goto L20;
    L23:
        if (r36 == true) goto L25;
    L28:
        com.obric.aiagent.skill.manager.api.r r4 = com.obric.aiagent.skill.manager.api.r.o;
        setSkillEnabledInternal(r35, r36);     // Catch: Exception -> L31 CancellationException -> L45
        com.obric.aiagent.skill.manager.api.u<d.x> r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31 CancellationException -> L45
    L34:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L40;
        dz r23 = dz.f19791a;
        com.obric.aiagent.skill.manager.api.e r2 = getInstalledSkillRegistry().b(r35);
        if (r2 != null) goto L38;
        r2 = com.obric.aiagent.skill.manager.api.e.a(r21, null, null, null, null, null, null, null, null, null, 0, null, r36, false, null, null, null, null, 129023, null);
    L38:
        ea.a(r33, r23, r2, null, null, null, null, null, null, null, null, r22, DownloadErrorCode.ERROR_THREAD_INTERRUPT, null);
    L42:
        return r1;
    L40:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L44;
        ea.a(r33, dz.f19792b, r21, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "registry_persist", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, r22, 572, null);
        goto L42
    L44:
        throw new d.k();
    L45:
        e = move-exception;
        throw e;
    L31:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r5 = dm.a(e, "set_enabled", r4);
        dm.a("set_enabled", r5.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L34
    L25:
        if (getInstalledSkillRegistry().d(r35) == true) goto L28;
        com.obric.aiagent.skill.manager.api.u.a r3 = dm.a(com.obric.aiagent.skill.manager.api.r.k, "set_enabled", false, "enable_limit", null, 20, null);
        ea.a(r33, dz.f19795e, r21, null, null, null, null, eb.a(r3), "enable_limit", null, null, r22, 828, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L20:
        if (az.a(r21) == false) goto L23;
        com.obric.aiagent.skill.manager.api.u.a r6 = dm.a(com.obric.aiagent.skill.manager.api.r.j, "set_enabled", false, "security_failed", null, 20, null);
        ea.a(r33, dz.f19795e, r21, null, null, null, null, eb.a(r6), "security_check", null, null, r22, 828, null);
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L16:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L8:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "set_enabled", false, "blank_slug", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final void setSkillEnabledInternal(String r7, boolean r8) {
        logInfo("Set skill enabled requested enabled=" + r8, "Set skill enabled requested: slug=" + r7 + ", enabled=" + r8);
        com.obric.aiagent.skill.manager.api.e r0 = getInstalledSkillRegistry().b(r7);
        if (r0 == null) goto L17;
        if (r0.l() != r8) goto L8;
        logInfo("Set skill enabled skipped already enabled=" + r8, "Set skill enabled skipped: slug=" + r7 + " already enabled=" + r8);
        return;
    L8:
        if (r8 == true) goto L10;
    L14:
        com.obric.aiagent.skill.manager.api.e r1 = cy.a(r0, r8, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aj(getInstalledSkillRegistry()), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ak(getTrackingReporter()), d.h.a.m.class, "com.obric.aiagent.plugin"));
        getTrackingReporter().b(r1, resolveFileDownloaded(r1.a()));
        logInfo("Set skill enabled completed enabled=" + r8, "Set skill enabled completed: slug=" + r7 + ", enabled=" + r8);
        return;
    L10:
        if (az.a(r0) == false) goto L14;
        throw new em(r7);
    L17:
        throw new IllegalArgumentException("Skill not found: " + r7);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public com.obric.aiagent.skill.manager.api.u<d.x> deleteSkill(String r18) {
        d.h.b.o.e(r18, "slug");
        com.obric.aiagent.skill.manager.api.u<d.x> r1 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L6;
        return r1;
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.obric.aiagent.skill.manager.api.e r5 = getInstalledSkillRegistry().b(r18);
        if (r5 != null) goto L14;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19301b, "delete", false, "not_installed", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        if (r5.m() == false) goto L16;
        ea r3 = new ea(dy.n, getTrackingReporter(), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        com.obric.aiagent.skill.manager.api.r r4 = com.obric.aiagent.skill.manager.api.r.o;
        com.obric.aiagent.skill.manager.api.u<d.x> r0 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(deleteSkillInternal(r18, r3)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20 CancellationException -> L31
    L23:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L26;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L26:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L30;
        ea.a(r3, dz.f19792b, r5, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "persistent_or_registry", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, null, 1596, null);
        return r0;
    L30:
        throw new d.k();
    L31:
        e = move-exception;
        throw e;
    L20:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r6 = dm.a(e, "delete", r4);
        dm.a("delete", r6.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r0 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        goto L23
    L16:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19303d, "delete", false, "non_removable", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L8:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(com.obric.aiagent.skill.manager.api.r.f19300a, "delete", false, "blank_slug", null, 20, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final ax deleteSkillInternal(String r18, ea r19) {
        logInfo("Delete skill requested", "Delete skill requested: slug=" + r18);
        com.obric.aiagent.skill.manager.api.e r2 = getInstalledSkillRegistry().b(r18);
        if (r2 == null) goto L29;
        if (r2.m() == false) goto L27;
        ax r1 = ay.a(r2, (d.h.a.b) ZeusTransformUtils.preCheckCast(new p(getPersistentRepository()), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new q(getInstalledSkillRegistry()), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(getTrackingReporter()), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r1.c() == false) goto L10;
        getTrackingReporter().c(r2, resolveFileDownloaded(r2.a()));
        getSigningRepository().a(r2.a());
        getSigningRepository().b(r2.a());
    L10:
        if (r1.c() == false) goto L13;
        getCoverStore().a(r2.f());
    L13:
        if (r1.a() == true) goto L15;
    L17:
        dz r3 = dz.f19794d;
    L18:
        dz r4 = r3;
        if (r1.a() == true) goto L21;
    L23:
        String r5 = "persistent_or_registry";
    L24:
        ea.a(r19, r4, r2, null, null, null, null, null, r5, null, null, d.a.ao.a(new d.m[]{d.s.a("deleted_files", Boolean.valueOf(r1.a())), d.s.a("removed_registry", Boolean.valueOf(r1.b()))}), 892, null);
        logInfo("Delete skill completed deletedFiles=" + r1.a() + ", removedState=" + r1.b(), "Delete skill completed: slug=" + r2.a() + ", deletedFiles=" + r1.a() + ", removedState=" + r1.b());
        return r1;
    L21:
        if (r1.b() == false) goto L23;
        r5 = null;
        goto L24
    L15:
        if (r1.b() == false) goto L17;
        r3 = dz.f19791a;
        goto L18
    L27:
        throw new IllegalStateException("Installed Skill '" + r18 + "' is marked as non-removable and cannot be deleted.");
    L29:
        throw new IllegalArgumentException("Installed skill not found: " + r18);
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillManagerService
    public Object refreshSkillSignatures(com.obric.aiagent.skill.manager.api.ap r3, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r4) {
        com.obric.aiagent.skill.manager.api.ap r5 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return refreshSkillSignatures$impl_release(r5, aw.f19530a, r6);
    }

    public final Object refreshSkillSignatures$impl_release(com.obric.aiagent.skill.manager.api.ap r8, aw r9, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r10) {
        com.obric.aiagent.skill.manager.api.ap r11 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ae.class) == false) goto L7;
        ae r0 = (ae) ZeusTransformUtils.preCheckCast(r12, ae.class, "com.obric.aiagent.plugin");
        if ((r0.f19350e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19350e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f19348c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19350e;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        com.obric.aiagent.skill.manager.api.r r7 = (com.obric.aiagent.skill.manager.api.r) ZeusTransformUtils.preCheckCast(r0.f19347b, com.obric.aiagent.skill.manager.api.r.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f19346a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L14 CancellationException -> L16
    L28:
    L40:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(r13), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L14:
        e = e;
    L32:
        com.obric.aiagent.skill.manager.api.u.a r15 = dm.a(e, r14, r7);
        dm.a(r14, r15.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r13);
        com.obric.aiagent.skill.manager.api.u<d.x> r16 = ensureReadyInternal();
        if (ZeusTransformUtils.instanceOf(r16, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L23;
        return r16;
    L23:
        com.obric.aiagent.skill.manager.api.r r4 = com.obric.aiagent.skill.manager.api.r.n;
        d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Exception -> L30
        fx r6 = access$getSigningRefreshCoordinator(this);     // Catch: CancellationException -> L16 Exception -> L30
        List<com.obric.aiagent.skill.manager.api.e> r17 = (List) ZeusTransformUtils.preCheckCast(access$getInstalledSkillRegistry(this).a().c(), List.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19346a = "refresh_signatures";     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19347b = r4;     // Catch: CancellationException -> L16 Exception -> L30
        r0.f19350e = 1;     // Catch: CancellationException -> L16 Exception -> L30
        Object r18 = r6.a(r11, r17, r9, r0);     // Catch: CancellationException -> L16 Exception -> L30
        if (r18 != r2) goto L27;
        return r2;
    L27:
        r14 = "refresh_signatures";
        r13 = r18;
        r7 = r4;
    L30:
        e = e;
        r14 = "refresh_signatures";
        r7 = r4;
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new ae(this, r12);
        goto L8
    }

    public final Object refreshSkillForDetail$impl_release(com.obric.aiagent.skill.manager.api.e r22, com.obric.aiagent.skill.manager.impl.ao r23, d.h.a.a<d.x> r24, d.c.d<? super hi> r25) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super hi> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(ensureReadyInternal(), com.obric.aiagent.skill.manager.api.u.a.class) == true) goto L5;
        com.obric.aiagent.skill.manager.api.e r0 = getInstalledSkillRegistry().b(r22.a());
        if (r0 != null) goto L9;
        com.obric.aiagent.skill.manager.api.e r3 = r22;
    L11:
        return getSkillUpdateCoordinator().a(r3, hg.f20102b, com.obric.aiagent.skill.manager.api.al.f19195a.a().D(), r23, r7, r8);
    L9:
        r3 = r0;
        goto L11
    L5:
        return new hi(r22, r22.j(), ar.f19514e, getObricManifestReader().a(r22.a()), null, false, null, null, null, 496, null);
    }

    public final Object refreshInstalledStoreMetadata$impl_release(Set<String> r4, d.c.d<? super gx> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        d.c.d<? super gx> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(ensureReadyInternal(), com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L11;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r3.iterator();
    L6:
        if (r9.hasNext() == false) goto L9;
        r8.add(new gw((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"), gv.f20056e));
        goto L6
    L9:
        return new gx((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"));
    L11:
        return getStoreMetadataRefreshCoordinator().a(r6, r7);
    }

    private final Map<String, Object> loadCliPerformanceDimensions(hi r15) {
        if (r15.c() == ar.f19511b) goto L5;
        com.obric.aiagent.skill.manager.impl.ab r14 = r15.d();
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.manager.impl.ab.c.class) == false) goto L9;
        com.obric.aiagent.skill.manager.impl.ab.c r16 = (com.obric.aiagent.skill.manager.impl.ab.c) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.manager.impl.ab.c.class, "com.obric.aiagent.plugin");
    L10:
        if (r16 == null) goto L16;
        com.obric.aiagent.skill.manager.impl.aa r17 = r16.b();
        if (r17 == null) goto L16;
        List<String> r18 = r17.b();
        if (r18 == null) goto L16;
        int r19 = r18.size();
    L17:
        if (r19 == 0) goto L19;
        com.obric.aiagent.skill.manager.impl.l r110 = r15.e();
        if (r110 == null) goto L23;
        Map<String, Object> r111 = eb.a(r110);
        return d.a.ao.a(r111, d.s.a("cli_refresh_result", d.a.ao.b(r111, "business_result")));
    L23:
        return d.a.ao.a(new d.m[]{d.s.a("cli_refresh_result", "fail"), d.s.a("cli_package_count", 0), d.s.a("updated_count", 0), d.s.a("up_to_date_count", 0), d.s.a("failed_count", 1)});
    L19:
        return d.a.ao.a(new d.m[]{d.s.a("cli_refresh_result", "not_required"), d.s.a("cli_package_count", 0), d.s.a("updated_count", 0), d.s.a("up_to_date_count", 0), d.s.a("failed_count", 0)});
    L16:
        r19 = 0;
        goto L17
    L9:
        r16 = null;
        goto L10
    L5:
        return d.a.ao.a(new d.m[]{d.s.a("cli_refresh_result", "skipped_by_config"), d.s.a("cli_package_count", 0), d.s.a("updated_count", 0), d.s.a("up_to_date_count", 0), d.s.a("failed_count", 0)});
    }

    private final com.obric.aiagent.skill.manager.api.u<d.x> ensureReadyInternal() {
        aq r0 = br.f19586a.b();
        if (r0 == aq.f19505a) goto L7;
        com.obric.aiagent.skill.manager.api.r r3 = com.obric.aiagent.skill.manager.api.r.m;
        String r6 = r0.name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r6, "toLowerCase(...)");
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(dm.a(r3, "manager_access", false, r6, toFailureDetail(r0), 4, null), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L7:
        if (this.started == true) goto L9;
        Object r2 = this.startLock;
        monitor-enter(r2);
    L51:
        th = move-exception;
        throw th;
    L13:
        if (this.started == false) goto L15;
        com.obric.aiagent.skill.manager.api.u<d.x> r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
    L45:
        monitor-exit(r2);
        return r1;
    L15:
        ea r17 = new ea(dy.l, getTrackingReporter(), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);     // Catch: Throwable -> L51
        Set<String> r4 = bl.f19568a.a((bn) ZeusTransformUtils.preCheckCast(getExistencePolicyRemoteSource(), bn.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
        boolean r15 = com.obric.aiagent.skill.manager.api.al.f19195a.a().D();     // Catch: Throwable -> L51
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L51
        com.obric.aiagent.skill.manager.api.r r7 = com.obric.aiagent.skill.manager.api.r.o;     // Catch: Throwable -> L51
        bk r8 = purgeDisallowedSkills(r4);     // Catch: Exception -> L18 CancellationException -> L49 Throwable -> L51
        logInfo("Disallowed Skill startup cleanup completed count=" + r8.a().size() + ", changed=" + r8.b() + ", incomplete=" + r8.c(), "Disallowed Skill startup cleanup completed: blocked=" + d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")) + ", changed=" + r8.b() + ", incomplete=" + r8.c());     // Catch: Exception -> L18 CancellationException -> L49 Throwable -> L51
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(getPersistentRepository().a(r15)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18 CancellationException -> L49 Throwable -> L51
    L21:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L43;
        List<com.obric.aiagent.skill.manager.api.e> r9 = (List) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        long r10 = eb.a(r5);     // Catch: Throwable -> L51
        long r11 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L51
        com.obric.aiagent.skill.manager.api.r r12 = com.obric.aiagent.skill.manager.api.r.o;     // Catch: Throwable -> L51
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(getInstalledSkillRegistry().a(r9)), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25 CancellationException -> L40 Throwable -> L51
    L28:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L30;
        ea.a(r17, dz.f19792b, null, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "registry_restore", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, d.a.ao.a(new d.m[]{d.s.a("metadata_load_duration_ms", Long.valueOf(r10)), d.s.a("registry_restore_duration_ms", Long.valueOf(eb.a(r11))), d.s.a("loaded_skill_count", Integer.valueOf(r9.size()))}), 574, null);     // Catch: Throwable -> L51
        goto L45
    L30:
        long r13 = eb.a(r11);     // Catch: Throwable -> L51
        this.started = true;     // Catch: Throwable -> L51
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("SkillManager", "Loaded " + r9.size() + " installed skills");     // Catch: Throwable -> L51
        ea.a(r17, dz.f19791a, null, null, null, null, null, null, null, false, false, d.a.ao.a(new d.m[]{d.s.a("metadata_load_duration_ms", Long.valueOf(r10)), d.s.a("registry_restore_duration_ms", Long.valueOf(r13)), d.s.a("loaded_skill_count", Integer.valueOf(r9.size()))}), 254, null);     // Catch: Throwable -> L51
        if (r15 == false) goto L33;
        scheduleStartupCleanup(r17.a());     // Catch: Throwable -> L51
    L34:
        if (r15 == false) goto L36;
        kotlinx.coroutines.i.a(getSigningScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L51
    L37:
        if (r15 == false) goto L39;
        scheduleDefaultStoreSkillBootstrap();     // Catch: Throwable -> L51
    L39:
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        goto L45
    L36:
        logInfo("Startup Skill signing refresh skipped by config", "Startup AllInstalled Skill signing refresh skipped by config");     // Catch: Throwable -> L51
        goto L37
    L33:
        logInfo("Skill cover cleanup skipped by config", "Skill cover cleanup skipped by config during initialization");     // Catch: Throwable -> L51
        logInfo("Skill import temporary directory cleanup skipped by config", "Skill import temporary directory cleanup skipped by config during initialization");     // Catch: Throwable -> L51
    L40:
        e = move-exception;
        throw e;     // Catch: Throwable -> L51
    L25:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r14 = dm.a(e, "initialize_publish", r12);     // Catch: Throwable -> L51
        dm.a("initialize_publish", r14.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        goto L28
    L43:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L48;
        ea.a(r17, dz.f19792b, null, null, null, null, null, eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")), "metadata_load", Boolean.valueOf(((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).b()), null, d.a.ao.a(d.s.a("metadata_load_duration_ms", Long.valueOf(eb.a(r5)))), 574, null);     // Catch: Throwable -> L51
        goto L45
    L48:
        throw new d.k();     // Catch: Throwable -> L51
    L49:
        e = move-exception;
        throw e;     // Catch: Throwable -> L51
    L18:
        e = move-exception;
        com.obric.aiagent.skill.manager.api.u.a r16 = dm.a(e, "initialize_load", r7);     // Catch: Throwable -> L51
        dm.a("initialize_load", r16.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
        r1 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        goto L21
    L9:
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(d.x.f38692a), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    }

    private final bk purgeDisallowedSkills(Set<String> r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
        if (r11.isEmpty() == true) goto L5;
        Object r0 = this.createLock;
        monitor-enter(r0);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L30
    L10:
        if (r13.hasNext() == false) goto L26;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Object r3 = storeInstallLock(r2);     // Catch: Throwable -> L30
        monitor-enter(r3);     // Catch: Throwable -> L30
        com.obric.aiagent.skill.manager.api.e r4 = getInstalledSkillRegistry().c(r2);     // Catch: Throwable -> L23
        bp r5 = (bp) ZeusTransformUtils.preCheckCast(d.a.p.o(getPersistentRepository().a(d.a.ax.a(r2))), bp.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        boolean r6 = getInstalledSkillRegistry().a(r2);     // Catch: Throwable -> L23
        getSigningRepository().a(r2);     // Catch: Throwable -> L23
        getSigningRepository().b(r2);     // Catch: Throwable -> L23
        if (r4 != null) goto L16;
        r4 = r5.a();     // Catch: Throwable -> L23
    L16:
        if (r4 != null) goto L18;
    L20:
        bj r7 = new bj(r5, r6);     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L30
        r1.add(r7);     // Catch: Throwable -> L30
        goto L10
    L18:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.f(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L20;
        getCoverStore().a(r4.f());     // Catch: Throwable -> L23
        goto L20
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L26:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        monitor-exit(r0);
        return new bk(r9);
    L30:
        th = move-exception;
        throw th;
    L5:
        return new bk(d.a.p.b());
    }

    private final void scheduleDefaultStoreSkillBootstrap() {
        kotlinx.coroutines.i.a(getSigningScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new af(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final int reconcileBuiltinStoreSkillRemovability(List<com.obric.aiagent.skill.manager.api.e> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a());
        goto L4
    L6:
        HashSet r10 = (HashSet) ZeusTransformUtils.preCheckCast(r0, HashSet.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        Iterator r2 = d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(getInstalledSkillRegistry().a().c(), Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$SkillManager$s4HPJHBoQJedMNl24VtZkpRxPQ.INSTANCE).a();
    L8:
        if (r2.hasNext() == false) goto L14;
        com.obric.aiagent.skill.manager.api.e r3 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        boolean r4 = !r10.contains(r3.a());
        if (r3.m() == r4) goto L8;
        if (getInstalledSkillRegistry().b(r3.a(), r4) == false) goto L8;
        r1 = r1 + 1;
        goto L8
    L14:
        return r1;
    }

    private static final boolean reconcileBuiltinStoreSkillRemovability$lambda$96(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "skill");
        return ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.e.class);
    }

    private final void scheduleStartupCleanup(String r15) {
        kotlinx.coroutines.i.a(getSigningScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ah(this, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(getSigningScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ai(this, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void finishBackgroundCleanup(ea r20, String r21, String r22, int r23, int r24) {
        if (r24 != 0) goto L6;
        dz r4 = dz.f19791a;
    L5:
        dz r6 = r4;
        String r5 = null;
        if (r24 <= 0) goto L12;
        dw r12 = dw.i;
    L13:
        boolean r7 = true;
        if (r24 <= 0) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L19;
        r5 = r22;
    L19:
        if (r24 > 0) goto L22;
        r7 = false;
    L22:
        ea.a(r20, r6, null, null, null, null, null, r12, r5, Boolean.valueOf(r7), false, backgroundCleanupDimensions(r21, r23, r24), 62, null);
        if (r24 <= 0) goto L26;
        logWarning("Some stale Skill cleanup targets could not be deleted", "Some stale Skill cleanup targets could not be deleted: target=" + r21 + ", failedCount=" + r24);
        return;
    L26:
        return;
    L16:
        r14 = false;
        goto L17
    L12:
        r12 = null;
        goto L13
    L6:
        if (r23 <= 0) goto L8;
        r4 = dz.f19794d;
        goto L5
    L8:
        r4 = dz.f19792b;
        goto L5
    }

    private final Map<String, Object> backgroundCleanupDimensions(String r2, int r3, int r4) {
        return d.a.ao.a(new d.m[]{d.s.a("cleanup_target", r2), d.s.a("deleted_count", Integer.valueOf(r3)), d.s.a("failed_count", Integer.valueOf(r4))});
    }

    private final String projectedSkillDirFor(String r6) {
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L23;
        boolean r2 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L7;
        return "";
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L28;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L10:
        if (r0 >= r7.length()) goto L15;
        if (d.o.a.a(r7.charAt(r0)) == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        r2 = true;
    L15:
        if (r2 == false) goto L17;
        return "";
    L17:
        if (d.h.b.o.a(r5, ".") == false) goto L19;
        return "";
    L19:
        if (d.h.b.o.a(r5, DownloadConstants.VULNERABILITY_PATH) == false) goto L22;
        return "";
    L22:
        return "~/.agents/skills/" + r5;
    L28:
        return "";
    L23:
        return "";
    }

    private final com.obric.aiagent.skill.manager.api.e findInstalledIdentityConflict(String r7, String r8, String r9) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(getInstalledSkillRegistry().a().c(), List.class, "com.obric.aiagent.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        Object r4 = null;
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r7) == false) goto L3;
    L9:
        com.obric.aiagent.skill.manager.api.e r10 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L12;
        return r10;
    L12:
        String r11 = cu.f19706a.b(r8);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r12.hasNext() == false) goto L22;
        Object r2 = r12.next();
        String r5 = installedPackageName((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L18;
        String r6 = cu.f19706a.b(r5);
    L20:
        if (d.h.b.o.a(r6, r11) == false) goto L14;
    L23:
        com.obric.aiagent.skill.manager.api.e r13 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L26;
        return r13;
    L26:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L28:
        if (r14.hasNext() == false) goto L33;
        Object r15 = r14.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).b(), r9) == false) goto L28;
        r4 = r15;
    L33:
        return (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    L18:
        r6 = null;
        goto L20
    L22:
        r2 = null;
        goto L23
    L8:
        r3 = null;
        goto L9
    }

    private final String installedPackageName(com.obric.aiagent.skill.manager.api.e r7) {
        String r0 = r7.k();
        Object r3 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L21;
        return null;
    L21:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L10
        SkillManager r2 = (SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Object r4 = d.n.f(db.a(db.f19721a, r0, 0, 2, null).a());     // Catch: Throwable -> L10
    L12:
        Throwable r5 = d.n.c(r4);
        if (r5 == null) goto L16;
        logFailure("Installed Skill package name could not be read", "Installed Skill package name could not be read: slug=" + r7.a(), r5);
    L16:
        if (d.n.b(r4) == true) goto L20;
        r3 = r4;
    L20:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L10:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L12
    }

    private final ce conflictField(com.obric.aiagent.skill.manager.api.e r2, String r3, String r4) {
        if (d.h.b.o.a(r2.a(), r3) == true) goto L5;
        String r1 = installedPackageName(r2);
        if (r1 == null) goto L13;
        if (d.h.b.o.a(cu.f19706a.b(r1), cu.f19706a.b(r4)) == false) goto L13;
        return ce.f19648b;
    L13:
        return ce.f19649c;
    L5:
        return ce.f19647a;
    }

    static /* synthetic */ void scheduleSignatureRefresh$default(SkillManager r0, com.obric.aiagent.skill.manager.api.e r1, ep r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.scheduleSignatureRefresh(r1, r2, r3);
    }

    private final void scheduleSignatureRefresh(com.obric.aiagent.skill.manager.api.e r8, ep r9, String r10) {
        getSigningRepository().a(r8, r9, r10);     // Catch: Exception -> L5
    L7:
        kotlinx.coroutines.i.a(getSigningScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ag(this, r8.a(), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        e = move-exception;
        logFailure("Skill signing trigger persistence failed trigger=" + r9.a(), "Skill signing trigger persistence failed: slug=" + r8.a() + ", trigger=" + r9.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    private final com.obric.aiagent.skill.manager.api.e runBeforeLoadHooks(com.obric.aiagent.skill.manager.api.e r4, String r5) {
        Iterator<cr> r3 = getLoadHooks().iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        cq r6 = ((cr) ZeusTransformUtils.preCheckCast(r3.next(), cr.class, "com.obric.aiagent.plugin")).a(r4, r5);
        if (ZeusTransformUtils.instanceOf(r6, cq.b.class) == false) goto L9;
        r4 = ((cq.b) ZeusTransformUtils.preCheckCast(r6, cq.b.class, "com.obric.aiagent.plugin")).a();
        goto L4
    L9:
        if (d.h.b.o.a(r6, cq.a.f19694a) == false) goto L13;
        return null;
    L13:
        throw new d.k();
    L14:
        return r4;
    }

    private final f resolveCliTools(String r7, List<String> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
        int r2 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        File r4 = getCliUpdateRepository().a(r3);
        if (r4 != null) goto L8;
        r2 = r2 + 1;
        logWarning("Required CLI package missing", "Required CLI package missing: slug=" + r7 + ", name=" + r3);
        com.obric.aiagent.skill.manager.api.ab r5 = null;
    L9:
        if (r5 == null) goto L4;
        r0.add(r5);
        goto L4
    L8:
        r5 = new com.obric.aiagent.skill.manager.api.ab(r3, r4);
        goto L9
    L12:
        return new f((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), r2);
    }

    private final Boolean resolveFileDownloaded(String r6) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r2 = d.n.f(Boolean.valueOf(((SkillManager) ZeusTransformUtils.preCheckCast(this, SkillManager.class, "com.obric.aiagent.plugin")).getPersistentRepository().b(r6)));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = d.n.c(r2);
        if (r3 == null) goto L11;
        logFailure("Skill canonical file state probe failed", "Skill canonical file state probe failed: slug=" + r6, r3);
    L11:
        if (d.n.b(r2) == false) goto L14;
        r2 = null;
    L14:
        return (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void logDebug(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("SkillManager", r1);
    }

    private final void logInfo(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("SkillManager", r1);
    }

    private final void logWarning(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("SkillManager", r1);
    }

    private final void logFailure(String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SkillManager", r3, r4);
        return;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("SkillManager", r2);
    }

    private final com.obric.aiagent.skill.manager.api.s toFailureDetail(aq r2) {
        int r1 = i.f19379d[r2.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L21;
        if (r1 == 4) goto L20;
        if (r1 == 5) goto L20;
        throw new d.k();
    L20:
        return new com.obric.aiagent.skill.manager.api.s(com.obric.aiagent.skill.manager.api.t.f19311d, "Skill availability could not be confirmed");
    L21:
        return new com.obric.aiagent.skill.manager.api.s(com.obric.aiagent.skill.manager.api.t.f19310c, "The OVirt capability is unavailable on this device");
    L22:
        return new com.obric.aiagent.skill.manager.api.s(com.obric.aiagent.skill.manager.api.t.f19309b, "The user Skill extension switch is disabled");
    L19:
        return new com.obric.aiagent.skill.manager.api.s(com.obric.aiagent.skill.manager.api.t.f19308a, "The Skill feature is disabled");
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_SkillManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
