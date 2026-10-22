package com.obric.autogui.agents.vlm.models.impl;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.assistant.DoubaoInfoHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: StandardModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d implements com.obric.autogui.agents.vlm.models.a.a, com.obric.autogui.agents.vlm.models.c {
    private static final String TAG = "M-Std";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f27625b = null;
    private static final Gson h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.b f27626a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.agents.vlm.models.a.a f27627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.agents.vlm.models.a f27628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.a.o.a f27629e;
    private com.obric.autogui.agents.vlm.models.impl.a.a f;
    private com.obric.autogui.agents.vlm.models.impl.c.b g;

    /* JADX INFO: compiled from: StandardModel.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f27630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ViewHierarchyDump> f27631b;

        public static /* synthetic */ a a(a r1, e r2, List r3, int r4, Object r5) {
            List<ViewHierarchyDump> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.f27630a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.f27631b;
        L9:
            return r1.a(r2, r6);
        }

        public final a a(e r2, List<ViewHierarchyDump> r3) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r2, "screenshot");
            return new a(r2, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27630a, r6.f27630a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27631b, r6.f27631b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f27630a.hashCode() * 31;
            List<ViewHierarchyDump> r1 = this.f27631b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ActionEffectModelPageCandidate(screenshot=" + this.f27630a + ", viewTree=" + this.f27631b + ')';
        }

        public a(e r3, List<ViewHierarchyDump> r4) {
            List<ViewHierarchyDump> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "screenshot");
            this.f27630a = r3;
            this.f27631b = r5;
        }

        public final e a() {
            return this.f27630a;
        }

        public final List<ViewHierarchyDump> b() {
            return this.f27631b;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {364, 365}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$prepareStepStateParallel$2")
    static final class aa extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.m<? extends e, ? extends Boolean>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f27632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f27634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f27635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27636e;
        final /* synthetic */ com.obric.autogui.agents.a.d f;
        private /* synthetic */ Object g;

        /* JADX INFO: compiled from: StandardModel.kt */
        @d.c.b.a.f(b = "StandardModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$prepareStepStateParallel$2$imeDeferred$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27637a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f27638b;

            a(d r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27638b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super Boolean> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27638b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f27637a != 0) goto L7;
                d.o.a(r2);
                return d.c.b.a.b.a(d.a(this.f27638b));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: StandardModel.kt */
        @d.c.b.a.f(b = "StandardModel.kt", c = {358}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$prepareStepStateParallel$2$screenshotDeferred$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super e>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f27640b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27641c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.a.d f27642d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f27643e;

            b(d r3, com.obric.autogui.agents.vlm.b.C0677b r4, com.obric.autogui.agents.a.d r5, int r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27640b = r3;
                this.f27641c = r4;
                this.f27642d = r5;
                this.f27643e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super e> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f27640b, this.f27641c, this.f27642d, this.f27643e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super e> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27639a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L11:
                return r8;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                d r9 = this.f27640b;
                com.obric.autogui.agents.vlm.b.C0677b r2 = this.f27641c;
                com.obric.autogui.agents.a.d r3 = this.f27642d;
                int r4 = this.f27643e;
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27639a = 1;
                r8 = d.a(r9, r2, r3, r4, r5);
                if (r8 != r0) goto L11;
                return r0;
            }
        }

        aa(int r3, d r4, com.obric.autogui.agents.vlm.b.C0677b r5, com.obric.autogui.agents.a.d r6, d.c.d<? super aa> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27634c = r3;
            this.f27635d = r4;
            this.f27636e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.m<e, Boolean>> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            aa r11 = new aa(this.f27634c, this.f27635d, this.f27636e, this.f, r7);
            r11.g = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.m<? extends e, ? extends Boolean>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f27633b;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            long r3 = this.f27632a;
            Object r4 = this.g;
            d.o.a(r21);
            long r6 = r3;
            Object r5 = r21;
        L18:
            d.m r7 = new d.m(r4, r5);
            Loog.INSTANCE.i(d.TAG, "[PrepState][Step #" + this.f27634c + "] parallel total=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r6) + "ms");
            return r7;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r6 = this.f27632a;
            au r8 = (au) ZeusTransformUtils.preCheckCast(this.g, au.class, "com.obric.aiagent.plugin");
            d.o.a(r21);
            Object r9 = r21;
        L14:
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r9;
            this.f27632a = r6;
            this.f27633b = 2;
            r5 = r8.a(r10);
            if (r5 != r1) goto L17;
            return r1;
        L17:
            r4 = r9;
            goto L18
        L10:
            d.o.a(r21);
            am r11 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            long r12 = AOSystemTools.INSTANCE.nowTimeMillis();
            au r14 = kotlinx.coroutines.i.b(r11, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f27635d, this.f27636e, this.f, this.f27634c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
            r8 = kotlinx.coroutines.i.b(r11, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27635d, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r8;
            this.f27632a = r12;
            this.f27633b = 1;
            r9 = r14.a(r13);
            if (r9 != r1) goto L13;
            return r1;
        L13:
            r6 = r12;
            goto L14
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {381}, d = "prepareStepStateSequential", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class ab extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f27646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f27648e;
        int f;

        ab(d r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27648e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27647d = r3;
            this.f |= Integer.MIN_VALUE;
            return d.b(this.f27648e, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {682}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$releaseDiscardedModelScreenshot$1$1")
    static final class ac extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HeifScreenshotAttachment f27650b;

        ac(HeifScreenshotAttachment r3, d.c.d<? super ac> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27650b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f27650b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27649a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            this.f27650b.delete();
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            HeifScreenshotAttachment r6 = this.f27650b;
            d.c.d<? super Boolean> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27649a = 1;
            if (r6.awaitEncodingComplete(r2) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {716}, d = "resolveComputerControlApplicationAccessUiBaseline", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class ad extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f27653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27654d;

        ad(d r3, d.c.d<? super ad> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27653c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27652b = r3;
            this.f27654d |= Integer.MIN_VALUE;
            return d.b(this.f27653c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$stopMakingStep$1")
    static final class ae extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f27656b;

        ae(d r3, d.c.d<? super ae> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27656b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((ae) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f27656b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f27655a != 0) goto L10;
            d.o.a(r3);
            com.obric.autogui.agents.vlm.models.impl.a.a r2 = this.f27656b.d();
            if (r2 == null) goto L8;
            Loog.INSTANCE.w(d.TAG, "StopMaking: abandoning steps-holder: " + r2 + "; hasNext=" + r2.b());
            r2.d();
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.g f27657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f27658b;

        public final com.obric.autogui.agents.vlm.models.impl.g a() {
            return this.f27657a;
        }

        public final f b() {
            return this.f27658b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27657a, r6.f27657a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27658b, r6.f27658b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            com.obric.autogui.agents.vlm.models.impl.g r0 = this.f27657a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            f r4 = this.f27658b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "MakeStepResult(result=" + this.f27657a + ", earlyTermInfo=" + this.f27658b + ')';
        }

        public c(com.obric.autogui.agents.vlm.models.impl.g r1, f r2) {
            this.f27657a = r1;
            this.f27658b = r2;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardModel.kt */
    public static final class C0690d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.b.C0677b f27659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.c.b f27660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.request.a f27661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JsonObject f27662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f27663e;

        public final com.obric.autogui.agents.vlm.b.C0677b e() {
            return this.f27659a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0690d.class) == true) goto L8;
            return false;
        L8:
            C0690d r6 = (C0690d) ZeusTransformUtils.preCheckCast(r5, C0690d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27659a, r6.f27659a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27660b, r6.f27660b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f27661c, r6.f27661c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f27662d, r6.f27662d) == true) goto L21;
            return false;
        L21:
            if (this.f27663e == r6.f27663e) goto L23;
            return false;
        L23:
            return true;
        }

        public final com.obric.autogui.agents.vlm.models.c.b f() {
            return this.f27660b;
        }

        public final com.obric.autogui.agents.vlm.models.impl.request.a g() {
            return this.f27661c;
        }

        public final JsonObject h() {
            return this.f27662d;
        }

        public int hashCode() {
            return (((((((this.f27659a.hashCode() * 31) + this.f27660b.hashCode()) * 31) + this.f27661c.hashCode()) * 31) + this.f27662d.hashCode()) * 31) + Integer.hashCode(this.f27663e);
        }

        public String toString() {
            return "ModelInferenceContext(sessionContext=" + this.f27659a + ", preparation=" + this.f27660b + ", client=" + this.f27661c + ", body=" + this.f27662d + ", trials=" + this.f27663e + ')';
        }

        public C0690d(com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.vlm.models.c.b r4, com.obric.autogui.agents.vlm.models.impl.request.a r5, JsonObject r6, int r7) {
            com.obric.autogui.agents.vlm.models.impl.request.a r8 = (com.obric.autogui.agents.vlm.models.impl.request.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.vlm.models.impl.request.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "sessionContext");
            d.h.b.o.e(r4, "preparation");
            d.h.b.o.e(r8, "client");
            d.h.b.o.e(r6, "body");
            this.f27659a = r3;
            this.f27660b = r4;
            this.f27661c = r8;
            this.f27662d = r6;
            this.f27663e = r7;
        }

        public final com.obric.autogui.agents.vlm.b.C0677b a() {
            return this.f27659a;
        }

        public final com.obric.autogui.agents.vlm.models.c.b b() {
            return this.f27660b;
        }

        public final JsonObject c() {
            return this.f27662d;
        }

        public final void a(int r1) {
            this.f27663e = r1;
        }

        public final int d() {
            return this.f27663e;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScreenshotResult f27664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f27665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Boolean f27667d;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27664a, r10.f27664a) == true) goto L12;
            return false;
        L12:
            if (this.f27665b == r10.f27665b) goto L15;
            return false;
        L15:
            if (this.f27666c == r10.f27666c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f27667d, r10.f27667d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            ScreenshotResult r0 = this.f27664a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + Long.hashCode(this.f27665b)) * 31) + Long.hashCode(this.f27666c)) * 31;
            Boolean r4 = this.f27667d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ModelScreenshotObservation(result=" + this.f27664a + ", capturedAtMs=" + this.f27665b + ", captureElapsedMs=" + this.f27666c + ", topActivitySystemAnimationState=" + this.f27667d + ')';
        }

        public e(ScreenshotResult r1, long r2, long r4, Boolean r6) {
            this.f27664a = r1;
            this.f27665b = r2;
            this.f27666c = r4;
            this.f27667d = r6;
        }

        public final ScreenshotResult a() {
            return this.f27664a;
        }

        public final long b() {
            return this.f27665b;
        }

        public final long c() {
            return this.f27666c;
        }

        public final Boolean d() {
            return this.f27667d;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27669b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (this.f27668a == r6.f27668a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27669b, r6.f27669b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f27668a) * 31;
            String r1 = this.f27669b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TerminationInfo(reason=" + this.f27668a + ", reasonForUser=" + this.f27669b + ')';
        }

        public f(int r1, String r2) {
            this.f27668a = r1;
            this.f27669b = r2;
        }

        public final int a() {
            return this.f27668a;
        }

        public final String b() {
            return this.f27669b;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27670a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f27671b = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.values().length];
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28036b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            f27670a = r0;
            int[] r1 = new int[com.obric.autogui.agents.vlm.models.impl.request.b.b.values().length];
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28050a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L47:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28051b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28052c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L41:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28053d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L29:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28054e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L43:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L31:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L33:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L49:
            r1[com.obric.autogui.agents.vlm.models.impl.request.b.b.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L16:
            f27671b = r1;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {624, 627}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$acquireRetryModelPage$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f27675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f27676e;
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.c.b g;
        final /* synthetic */ String h;
        private /* synthetic */ Object i;

        /* JADX INFO: compiled from: StandardModel.kt */
        @d.c.b.a.f(b = "StandardModel.kt", c = {589}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$acquireRetryModelPage$2$screenshotDeferred$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super e>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f27678b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27679c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.c.b f27680d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f27681e;

            a(d r3, com.obric.autogui.agents.vlm.b.C0677b r4, com.obric.autogui.agents.vlm.models.c.b r5, String r6, d.c.d<? super a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27678b = r3;
                this.f27679c = r4;
                this.f27680d = r5;
                this.f27681e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super e> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27678b, this.f27679c, this.f27680d, this.f27681e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super e> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27677a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r10);
            L11:
                return r10;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r10);
                d r2 = this.f27678b;
                com.obric.autogui.agents.vlm.b.C0677b r11 = this.f27679c;
                String r3 = this.f27680d.a();
                com.obric.autogui.session.c.a r4 = this.f27680d.c();
                int r5 = this.f27680d.b();
                String r6 = this.f27681e;
                d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27677a = 1;
                r10 = d.a(r2, r11, r3, r4, r5, r6, r7);
                if (r10 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: StandardModel.kt */
        @d.c.b.a.f(b = "StandardModel.kt", c = {600}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$acquireRetryModelPage$2$viewTreeDeferred$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ViewHierarchyDump>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27682a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f27683b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27684c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.c.b f27685d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f27686e;

            b(d r3, com.obric.autogui.agents.vlm.b.C0677b r4, com.obric.autogui.agents.vlm.models.c.b r5, String r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27683b = r3;
                this.f27684c = r4;
                this.f27685d = r5;
                this.f27686e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super List<ViewHierarchyDump>> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f27683b, this.f27684c, this.f27685d, this.f27686e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ViewHierarchyDump>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27682a;
                if (r1 == 0) goto L13;
                if (r1 != 1) goto L12;
                d.o.a(r12);     // Catch: Exception -> L7 CancellationException -> L9
            L17:
            L24:
                return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L13:
                d.o.a(r12);
                d r5 = this.f27683b;     // Catch: Exception -> L7 CancellationException -> L9
                String r6 = this.f27684c.a().b();     // Catch: Exception -> L7 CancellationException -> L9
                com.obric.autogui.session.c.a r7 = this.f27685d.c();     // Catch: Exception -> L7 CancellationException -> L9
                int r8 = this.f27685d.b();     // Catch: Exception -> L7 CancellationException -> L9
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
                this.f27682a = 1;     // Catch: Exception -> L7 CancellationException -> L9
                r12 = d.a(r5, r6, r7, r8, true, r10);     // Catch: Exception -> L7 CancellationException -> L9
                if (r12 != r0) goto L17;
                return r0;
            L9:
                e = move-exception;
                throw e;
            L7:
                e = move-exception;
                Loog.INSTANCE.w(d.TAG, "[OAutoActionEffect] retry view tree capture failed step_id=" + com.obric.autogui.agents.a.b.a(this.f27685d.a(), 0, 1, null) + ", retry=" + this.f27686e + ", error_type=" + e.getClass().getSimpleName());
                return null;
            }
        }

        h(boolean r3, d r4, com.obric.autogui.agents.vlm.b.C0677b r5, com.obric.autogui.agents.vlm.models.c.b r6, String r7, d.c.d<? super h> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27675d = r3;
            this.f27676e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super a> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            h r12 = new h(this.f27675d, this.f27676e, this.f, this.g, this.h, r8);
            r12.i = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r22) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f27674c;
            ScreenshotResult r5 = null;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L13;
            if (r2 != 2) goto L12;
            int r3 = this.f27673b;
            e r1 = (e) ZeusTransformUtils.preCheckCast(this.f27672a, e.class, "com.obric.aiagent.plugin");
            e r4 = (e) ZeusTransformUtils.preCheckCast(this.i, e.class, "com.obric.aiagent.plugin");
            d.o.a(r22);     // Catch: Throwable -> L9
            e r6 = r4;
            Object r7 = r22;
        L33:
            List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        L37:
            return new a(r1, r8);
        L34:
            th = th;
            r4 = r6;
        L41:
            if (r3 != 0) goto L46;
            d r9 = this.f27676e;
            if (r4 == null) goto L45;
            r5 = r4.a();
        L45:
            d.a(r9, r5);
        L46:
            throw th;
        L9:
            th = th;
            goto L41
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r3 = this.f27673b;
            au r10 = (au) ZeusTransformUtils.preCheckCast(this.i, au.class, "com.obric.aiagent.plugin");
            d.o.a(r22);     // Catch: Throwable -> L16
            au r11 = r10;
            Object r12 = r22;
        L27:
            r6 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r11 != null) goto L53;
            r1 = r6;
            r8 = null;
            goto L37
        L53:
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            this.i = r6;     // Catch: Throwable -> L34
            this.f27672a = r6;     // Catch: Throwable -> L34
            this.f27673b = r3;     // Catch: Throwable -> L34
            this.f27674c = 2;     // Catch: Throwable -> L34
            r7 = r11.a(r13);     // Catch: Throwable -> L34
            if (r7 != r0) goto L32;
            return r0;
        L32:
            r1 = r6;
        L16:
            th = th;
            r4 = null;
            goto L41
        L18:
            d.o.a(r22);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.i, am.class, "com.obric.aiagent.plugin");
            au r15 = kotlinx.coroutines.i.b(r14, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27676e, this.f, this.g, this.h, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
            if (this.f27675d == false) goto L21;
            au r16 = kotlinx.coroutines.i.b(r14, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f27676e, this.f, this.g, this.h, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        L51:
            d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
            this.i = r16;     // Catch: Throwable -> L39
            this.f27673b = 0;     // Catch: Throwable -> L39
            this.f27674c = 1;     // Catch: Throwable -> L39
            r12 = r15.a(r17);     // Catch: Throwable -> L39
            if (r12 != r0) goto L26;
            return r0;
        L26:
            r11 = r16;
            r3 = 0;
        L39:
            th = th;
            r4 = null;
            r3 = 0;
            goto L41
        L21:
            r16 = null;
            goto L51
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {BDAbstractUpload.KeyIsEnableNativeLog, BDAbstractUpload.KeyIsSDKMaxRetryCount}, d = "acquireStepScreenshot", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27691e;
        Object f;
        int g;
        boolean h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ d k;
        int l;

        i(d r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.j = r8;
            this.l |= Integer.MIN_VALUE;
            return d.a(this.k, null, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {BDAbstractUpload.KeyIsRetryStatesOption, 475, 482, 497}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$acquireStepScreenshot$3")
    static final class j extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f27695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27696e;
        final /* synthetic */ String f;
        final /* synthetic */ com.obric.autogui.session.c.a g;
        final /* synthetic */ String h;
        final /* synthetic */ com.obric.autogui.agents.a.d.c i;
        final /* synthetic */ d.h.b.z.f<ScreenshotResult> j;
        final /* synthetic */ d.h.b.z.f<Boolean> k;
        final /* synthetic */ boolean l;
        final /* synthetic */ d.h.b.z.d m;
        final /* synthetic */ int n;

        j(d r3, com.obric.autogui.agents.vlm.b.C0677b r4, String r5, com.obric.autogui.session.c.a r6, String r7, com.obric.autogui.agents.a.d.c r8, d.h.b.z.f<ScreenshotResult> r9, d.h.b.z.f<Boolean> r10, boolean r11, d.h.b.z.d r12, int r13, d.c.d<? super j> r14) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27695d = r3;
            this.f27696e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
            this.j = r9;
            this.k = r10;
            this.l = r11;
            this.m = r12;
            this.n = r13;
            super(1, r15);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((j) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r17) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f27695d, this.f27696e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, r15), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v8, types: [T, com.obric.autogui.common.api.platform.display.capture.ScreenshotResult] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f27694c;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 != 4) goto L10;
            HeifScreenshotAttachment r0 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(this.f27692a, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
            d.o.a(r24);
        L55:
            d.c.b.a.b.a(r0.delete());
        L57:
            return d.c.b.a.b.a(true);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(this.f27693b, Boolean.class, "com.obric.aiagent.plugin");
            ScreenshotResult r6 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(this.f27692a, ScreenshotResult.class, "com.obric.aiagent.plugin");
            d.o.a(r24);
            ScreenshotResult r5 = r6;
            Object r7 = r24;
            Boolean r4 = r3;
        L44:
            T r8 = r4;
            ?? r9 = r5;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L58;
            Loog.INSTANCE.w(d.TAG, "event=access_ui_screenshot_rejected sessionKey=" + this.f27696e.a().a() + " stepId=" + this.f + " reason=VisualNotReady topComponent=" + r5.getTopComponent());
            IScreenshot r10 = r5.getPic();
            if (r10 == null) goto L49;
            r10.release();
        L49:
            HeifScreenshotAttachment r11 = r5.getHeifAttachment();
            if (r11 == null) goto L57;
            this.f27692a = r11;
            this.f27693b = null;
            this.f27694c = 4;
            if (r11.awaitEncodingComplete(this) != r1) goto L54;
            return r1;
        L54:
            r0 = r11;
        L58:
            IScreenshot r12 = r9.getPic();
            if (r9.getStatus() != ScreenshotResult.Status.KeyguardLocked) goto L63;
            this.j.f38504a = r9;
            this.k.f38504a = r8;
            return d.c.b.a.b.a(false);
        L63:
            if (r9.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L77;
            if (this.l == true) goto L67;
        L70:
            ComponentName r13 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L73;
        L80:
            this.j.f38504a = r9;
            this.k.f38504a = r8;
            return d.c.b.a.b.a(false);
        L73:
            if (com.obric.autogui.agents.vlm.models.a.g.c.f27257a.a(r13) == false) goto L80;
            Loog.INSTANCE.i(d.TAG, " - [SecureLayer-Vulnerability] topComponent = " + r13 + "; retrying bitmap refetch.");
            this.j.f38504a = r9;
            this.k.f38504a = r8;
            return d.c.b.a.b.a(true);
        L67:
            if (this.m.f38502a >= 2) goto L70;
            this.m.f38502a++;
            Loog.INSTANCE.i(d.TAG, " - [SecureOpenApp] screenshot still contains secure layer after OpenApp; retrying (" + this.m.f38502a + "/2).");
            this.j.f38504a = r9;
            this.k.f38504a = r8;
            return d.c.b.a.b.a(true);
        L77:
            if (r9.ok() == false) goto L83;
            if (r12 != null) goto L80;
        L83:
            return d.c.b.a.b.a(true);
        L12:
            HeifScreenshotAttachment r14 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(this.f27692a, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
            d.o.a(r24);
        L36:
            d.c.b.a.b.a(r14.delete());
        L38:
            return d.c.b.a.b.a(true);
        L13:
            Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(this.f27692a, Boolean.class, "com.obric.aiagent.plugin");
            d.o.a(r24);
            Object r16 = r24;
        L17:
            ScreenshotResult r17 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r16, ScreenshotResult.class, "com.obric.aiagent.plugin");
            com.obric.autogui.session.c.a.b(this.g, "stp_pred", "vlm_screenshot_make", 0, 4, null);
            boolean r18 = this.f27696e.a().c();
            IScreenshot r19 = r17.getPic();
            if (r19 == null) goto L20;
            AOOperatingSpace.SpaceType r110 = r19.getSpaceType();
        L21:
            boolean r111 = com.obric.autogui.agents.vlm.models.impl.k.a(r18, r110);
            Boolean r112 = d.a(this.f27695d, this.f27696e, this.f, "after_capture", r111, r17.getStatus());
            if (r111 == false) goto L24;
            Boolean r20 = com.obric.autogui.agents.vlm.models.impl.k.a(r15, r112);
        L26:
            if (com.obric.autogui.agents.b.b.a(com.obric.autogui.agents.b.b.a(this.f27696e.a()), r17.getTopComponent()) == false) goto L39;
            Loog.INSTANCE.w(d.TAG, "event=access_ui_screenshot_rejected sessionKey=" + this.f27696e.a().a() + " stepId=" + this.f + " topComponent=" + r17.getTopComponent());
            IScreenshot r21 = r17.getPic();
            if (r21 == null) goto L30;
            r21.release();
        L30:
            HeifScreenshotAttachment r22 = r17.getHeifAttachment();
            if (r22 == null) goto L38;
            this.f27692a = r22;
            this.f27694c = 2;
            if (r22.awaitEncodingComplete(this) != r1) goto L35;
            return r1;
        L35:
            r14 = r22;
            goto L36
        L39:
            r8 = r20;
            r9 = r17;
            if (com.obric.autogui.agents.b.b.a(this.f27696e.a()) == false) goto L58;
            d r113 = this.f27695d;
            com.obric.autogui.agents.a.d.c r114 = this.i;
            IScreenshot r115 = r17.getPic();
            String r23 = this.f27696e.a().a();
            String r116 = this.f;
            d.c.d r25 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27692a = r17;
            this.f27693b = r20;
            this.f27694c = 3;
            r7 = d.a(r113, r114, r115, r23, r116, r25);
            r4 = r20;
            r5 = r17;
            if (r7 != r1) goto L44;
            return r1;
        L24:
            r20 = null;
            goto L26
        L20:
            r110 = null;
            goto L21
        L14:
            d.o.a(r24);
            d r117 = this.f27695d;
            com.obric.autogui.agents.vlm.b.C0677b r118 = this.f27696e;
            r15 = d.a(r117, r118, this.f, "before_capture", r118.a().c(), null, 16, null);
            com.obric.autogui.session.c.a.a(this.g, "stp_pred", "vlm_screenshot_make", 0, 4, null);
            d r119 = this.f27695d;
            com.obric.autogui.agents.vlm.b.C0677b r120 = this.f27696e;
            String r121 = this.f;
            String r122 = this.h;
            d.c.d r26 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27692a = r15;
            this.f27694c = 1;
            r16 = d.a(r119, r120, r121, r122, r26);
            if (r16 != r1) goto L17;
            return r1;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {839}, d = "acquireViewHierarchy", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f27700d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27701e;

        k(d r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27700d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27699c = r7;
            this.f27701e |= Integer.MIN_VALUE;
            return d.a(this.f27700d, null, null, 0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {2114}, d = "addSaepPackagesIfAvailable", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f27705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27706e;

        l(d r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27705d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27704c = r3;
            this.f27706e |= Integer.MIN_VALUE;
            return d.a(this.f27705d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {2277}, d = "appendAntiFraudParams", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f27709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27710d;

        m(d r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27709c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27708b = r7;
            this.f27710d |= Integer.MIN_VALUE;
            return d.a(this.f27709c, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$appendAntiFraudParams$2")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f27712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ JsonObject f27715e;

        n(Context r3, String r4, String r5, JsonObject r6, d.c.d<? super n> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27712b = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.f27713c = r4;
            this.f27714d = r5;
            this.f27715e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f27712b, this.f27713c, this.f27714d, this.f27715e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f27711a != 0) goto L25;
            d.o.a(r11);
            if (AOPackagesTools.INSTANCE.isSystemApp(this.f27712b, this.f27713c) == false) goto L8;
            Loog.INSTANCE.i(d.TAG, "[AntiFraud] skip upload for system app: " + this.f27713c);
            return d.x.f38692a;
        L8:
            long r1 = AOSystemTools.INSTANCE.bootTimeMillis();
            String r12 = AOPackagesTools.INSTANCE.getAppSign(this.f27712b, this.f27713c);
            long r3 = AOSystemTools.INSTANCE.bootTimeMillis() - r1;
            if (r12 == null) goto L11;
            this.f27715e.addProperty("top_app_sign", r12);
        L11:
            long r2 = AOSystemTools.INSTANCE.bootTimeMillis();
            String r5 = AOPackagesTools.INSTANCE.getAppApkMd5FromCacheOnly(this.f27713c);
            long r6 = AOSystemTools.INSTANCE.bootTimeMillis() - r2;
            if (r5 == null) goto L14;
            this.f27715e.addProperty("top_app_md5", r5);
        L14:
            Loog r4 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append("[AntiFraud] ").append(this.f27713c).append(" sign_spent=").append(r3).append("ms(hasSign=");
            boolean r8 = true;
            if (r12 == null) goto L17;
            boolean r13 = true;
        L18:
            StringBuilder r14 = r7.append(r13).append("), md5_spent=").append(r6).append("ms(hasMd5=");
            if (r5 != null) goto L22;
            r8 = false;
        L22:
            r4.i(d.TAG, r14.append(r8).append(')').toString());
            com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(this.f27714d, ao.a(d.s.a("anti_fraud_sign_md5_cost_ms", d.c.b.a.b.a(r3 + r6))));
            return d.x.f38692a;
        L17:
            r13 = false;
            goto L18
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {1662, 1656}, d = "createModelRequestPageStateDigest", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f27719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f27720e;
        final /* synthetic */ d f;
        int g;

        o(d r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27720e = r3;
            this.g |= Integer.MIN_VALUE;
            return d.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {742}, d = "hasComputerControlApplicationAccessUiVisualChange", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f27725e;
        int f;

        p(d r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27725e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27724d = r7;
            this.f |= Integer.MIN_VALUE;
            return d.a(this.f27725e, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {1901, 1927, 1928, 1983, 2037, 2071, 2082}, d = "makeHyperParams$suspendImpl", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class q extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27730e;
        Object f;
        Object g;
        Object h;
        boolean i;
        int j;
        /* synthetic */ Object k;
        final /* synthetic */ d l;
        int m;

        q(d r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.k = r7;
            this.m |= Integer.MIN_VALUE;
            return d.a(this.l, null, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {2201}, d = "makeRequestBody$suspendImpl", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class r extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27735e;
        Object f;
        boolean g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ d j;
        int k;

        r(d r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.i = r3;
            this.k |= Integer.MIN_VALUE;
            return d.a(this.j, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {DownloadErrorCode.ERROR_BAD_URL, 1134}, d = "makeStep", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27739d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f27740e;
        int f;

        s(d r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27740e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27739d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f27740e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {1240, 1277, 1383, BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_USER_ADDITION, 1422, 1460, 1482, 1510, 1605}, d = "makeStepsAnew", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class t extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27744d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27745e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        int p;
        int q;
        int r;
        long s;
        long t;
        long u;
        /* synthetic */ Object v;
        final /* synthetic */ d w;
        int x;

        t(d r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.w = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.v = r3;
            this.x |= Integer.MIN_VALUE;
            return d.b(this.w, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    static final class u implements com.obric.autogui.agents.a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f27746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.c.b f27748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f27749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<a> f27750e;

        /* JADX INFO: compiled from: StandardModel.kt */
        @d.c.b.a.f(b = "StandardModel.kt", c = {1285}, d = "acquire", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$makeStepsAnew$2$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f27751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f27752b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f27753c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ u f27754d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f27755e;

            a(u r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27754d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f27753c = r3;
                this.f27755e |= Integer.MIN_VALUE;
                return this.f27754d.a(0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        u(d r1, com.obric.autogui.agents.vlm.b.C0677b r2, com.obric.autogui.agents.vlm.models.c.b r3, boolean r4, d.h.b.z.f<a> r5) {
            this.f27746a = r1;
            this.f27747b = r2;
            this.f27748c = r3;
            this.f27749d = r4;
            this.f27750e = r5;
        }

        /* JADX WARN: Type inference failed for: r11v12, types: [T, com.obric.autogui.agents.vlm.models.impl.d$a] */
        /* JADX WARN: Type inference failed for: r11v28 */
        /* JADX WARN: Type inference failed for: r11v29 */
        @Override // com.obric.autogui.agents.a.e
        public final Object a(int r10, d.c.d<? super com.obric.autogui.agents.a.d> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
            if ((r0.f27755e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f27755e -= Integer.MIN_VALUE;
        L8:
            a r7 = r0;
            Object r13 = r7.f27753c;
            Object r1 = d.c.a.b.a();
            int r2 = r7.f27755e;
            if (r2 == 0) goto L16;
            if (r2 != 1) goto L15;
            r10 = r7.f27752b;
            u this = (u) ZeusTransformUtils.preCheckCast(r7.f27751a, u.class, "com.obric.aiagent.plugin");
            d.o.a(r13);     // Catch: Exception -> L22 CancellationException -> L35
        L20:
            a r14 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L35
        L24:
            ScreenshotResult r15 = r14.a().a();
            ?? r16 = r14;
            if (r15 != null) goto L28;
            r16 = (a) ZeusTransformUtils.preCheckCast(this.f27750e.f38504a, a.class, "com.obric.aiagent.plugin");
        L28:
            ScreenshotResult r17 = r16.a().a();
            if (r17 == null) goto L34;
            d.h.b.z.f<a> r3 = this.f27750e;
            d r9 = this.f27746a;
            ScreenshotResult r4 = ((a) ZeusTransformUtils.preCheckCast(r3.f38504a, a.class, "com.obric.aiagent.plugin")).a().a();
            r3.f38504a = r16;
            if (r4 == r17) goto L34;
            d.a(r9, r4);
        L34:
            return new com.obric.autogui.agents.a.d(r16.a().a(), r16.b());
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            d.o.a(r13);
            boolean r6 = this.f27749d;     // Catch: Exception -> L22 CancellationException -> L35
            r7.f27751a = this;     // Catch: Exception -> L22 CancellationException -> L35
            r7.f27752b = r10;     // Catch: Exception -> L22 CancellationException -> L35
            r7.f27755e = 1;     // Catch: Exception -> L22 CancellationException -> L35
            r13 = d.a(this.f27746a, this.f27747b, this.f27748c, "action_effect_round_" + r10, r6, r7);     // Catch: Exception -> L22 CancellationException -> L35
            if (r13 != r1) goto L20;
            return r1;
        L35:
            e = move-exception;
            throw e;
        L22:
            e = move-exception;
            Loog.INSTANCE.w(d.TAG, "[OAutoActionEffect] model screenshot retry failed step_id=" + com.obric.autogui.agents.a.b.a(this.f27748c.a(), 0, 1, null) + ", round=" + r10 + ", error_type=" + e.getClass().getSimpleName());
            r14 = (a) ZeusTransformUtils.preCheckCast(this.f27750e.f38504a, a.class, "com.obric.aiagent.plugin");
        L7:
            r0 = new a(this, r12);
            goto L8
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {1241}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$makeStepsAnew$2$modelViewTree$1$viewTree$result$1")
    static final class v extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ViewHierarchyDump>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ au<List<ViewHierarchyDump>> f27757b;

        v(au<? extends List<ViewHierarchyDump>> r3, d.c.d<? super v> r4) {
            au<List<ViewHierarchyDump>> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27757b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ViewHierarchyDump>> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new v(this.f27757b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ViewHierarchyDump>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27756a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au<List<ViewHierarchyDump>> r6 = this.f27757b;
            d.c.d<? super List<ViewHierarchyDump>> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27756a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {1747}, d = "modelRequestTrial", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class w extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f27761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27762e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        w(d r3, d.c.d<? super w> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return d.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {954, 961, 970}, d = "prepareScreenshot", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class x extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f27767e;
        int f;

        x(d r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27767e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27766d = r3;
            this.f |= Integer.MIN_VALUE;
            return d.a(this.f27767e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {290, 292}, d = "prepareStepMaking$suspendImpl", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel")
    static final class y extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27772e;
        long f;
        boolean g;
        /* synthetic */ Object h;
        final /* synthetic */ d i;
        int j;

        y(d r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return d.a(this.i, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModel.kt */
    @d.c.b.a.f(b = "StandardModel.kt", c = {269}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModel$prepareStepMaking$viewTreeDeferred$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<List<ViewHierarchyDump>> f27774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f27775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f27776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.c.a f27777e;
        final /* synthetic */ int f;
        private /* synthetic */ Object g;

        z(kotlinx.coroutines.w<List<ViewHierarchyDump>> r3, d r4, com.obric.autogui.agents.vlm.b.C0677b r5, com.obric.autogui.session.c.a r6, int r7, d.c.d<? super z> r8) {
            kotlinx.coroutines.w<List<ViewHierarchyDump>> r9 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27774b = r9;
            this.f27775c = r4;
            this.f27776d = r5;
            this.f27777e = r6;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            z r12 = new z(this.f27774b, this.f27775c, this.f27776d, this.f27777e, this.f, r8);
            r12.g = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27773a;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            kotlinx.coroutines.w r11 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(this.g, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.o.a(r12);     // Catch: Throwable -> L8
        L17:
            Object r13 = d.n.f((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        L23:
            if (d.n.b(r13) == false) goto L25;
            r13 = null;
        L25:
            r11.a(r13);
            return d.x.f38692a;
        L8:
            Throwable th = th;
        L21:
            d.n.a r2 = d.n.f38560a;
            r13 = d.n.f(d.o.a(th));
            goto L23
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r12);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.w<List<ViewHierarchyDump>> r15 = this.f27774b;
            d r4 = this.f27775c;
            com.obric.autogui.agents.vlm.b.C0677b r3 = this.f27776d;
            com.obric.autogui.session.c.a r6 = this.f27777e;
            int r7 = this.f;
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L19
            String r8 = r3.a().b();     // Catch: Throwable -> L19
            this.g = r15;     // Catch: Throwable -> L19
            this.f27773a = 1;     // Catch: Throwable -> L19
            Object r16 = d.a(r4, r8, r6, r7, true, this);     // Catch: Throwable -> L19
            if (r16 != r0) goto L16;
            return r0;
        L16:
            r12 = r16;
            r11 = r15;
        L19:
            th = move-exception;
            th = th;
            r11 = r15;
            goto L21
        }
    }

    private static final String i() {
        return "topComponentBeforeGeneration";
    }

    public static /* synthetic */ String lambda$0DaGMYPYGL0xiXsucq_4GssvqS0(String r0, ComponentName r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$2wBTvnlg1LG87RW8Wlzqh-7kBoU, reason: not valid java name */
    public static /* synthetic */ d.x m751lambda$2wBTvnlg1LG87RW8Wlzqh7kBoU(com.obric.autogui.session.c.a r0, com.obric.autogui.agents.vlm.models.c.b r1, C0690d r2, d r3, com.obric.autogui.agents.vlm.models.impl.g r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ String lambda$FzDJgcfjNXumvQdKRGVpXhqY4yI(CharSequence r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$NyCmQ_OKmeq6G7rnxzhkNacpIPI(boolean r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$PES9QWXIjP9xhdqhS1j8zgYyXPc(ComponentName r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$PSHyJUDL33oQZrBJUf-PlmCZIuc, reason: not valid java name */
    public static /* synthetic */ String m752lambda$PSHyJUDL33oQZrBJUfPlmCZIuc(String r0, CharSequence r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$XPjVgI6n4m0alsEwtqgiLCBIBbg(String r0, ComponentName r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.d.c lambda$hrz4OCrM0GyFUnPq5zz11iPFDDw(IScreenshot r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$ox0dJWrNq28kx3Jr0S4dZeuAg4g() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$xChny9Wz-4IH6DGzYFrkp4gB7Ho, reason: not valid java name */
    public static /* synthetic */ d.x m753lambda$xChny9Wz4IH6DGzYFrkp4gB7Ho(com.obric.autogui.agents.vlm.models.impl.request.a.c r0, long r1, com.obric.autogui.agents.vlm.models.impl.f.a r3, com.obric.autogui.agents.vlm.models.impl.g r4) {
        return a(r0, r1, r3, r4);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.d.c lambda$zQLzChkMduhZ2wpgWB_Hw42OFxw(IScreenshot r0) {
        return a(r0);
    }

    @Override // com.obric.autogui.agents.vlm.models.c
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.a.d r4, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.agents.vlm.models.c.b>> r5) {
        return a(this, r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object a(com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.common.a.k r4, com.obric.autogui.agents.vlm.models.c.b r5, d.c.d<? super com.obric.autogui.common.d<JsonObject>> r6) {
        return a(this, r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object a(com.obric.autogui.agents.vlm.b.C0677b r7, com.obric.autogui.common.a.k r8, com.obric.autogui.agents.vlm.models.c.b r9, boolean r10, d.c.d<? super JsonObject> r11) {
        return a(this, r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.c
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public Object a(String r3, ScreenshotConfig r4, boolean r5, d.c.d<? super ScreenshotResult> r6) {
        return a(this, r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public Object a(String r9, AOOperatingSpace r10, boolean r11, boolean r12, d.c.d<? super ScreenshotResult> r13) {
        return a(this, r9, (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r10, AOOperatingSpace.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Boolean a(d r0, com.obric.autogui.agents.vlm.b.C0677b r1, String r2, String r3, boolean r4, ScreenshotResult.Status r5) {
        return r0.a(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object a(d r8, com.obric.autogui.agents.a.d.c r9, IScreenshot r10, String r11, String r12, d.c.d r13) {
        return r8.a(r9, (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r10, IScreenshot.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, JsonObject r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.a.d r4, int r5, d.c.d r6) {
        return r2.c(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r6, com.obric.autogui.agents.vlm.b.C0677b r7, com.obric.autogui.agents.vlm.models.c.b r8, String r9, boolean r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r7, com.obric.autogui.agents.vlm.b.C0677b r8, String r9, com.obric.autogui.session.c.a r10, int r11, String r12, d.c.d r13) {
        return r7.a(r8, r9, r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, String r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, com.obric.autogui.agents.vlm.models.c.b r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r8, String r9, Context r10, String r11, JsonObject r12, d.c.d r13) {
        return r8.a(r9, (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r6, String r7, com.obric.autogui.session.c.a r8, int r9, boolean r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, String r3, String r4, C0690d r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(d r0, ScreenshotResult r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ boolean a(d r0) {
        return r0.f();
    }

    public static final /* synthetic */ Object b(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.a.d r4, int r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.common.a.k r4, com.obric.autogui.agents.vlm.models.c.b r5, d.c.d r6) {
        return r2.c(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(d r2, com.obric.autogui.agents.vlm.b.C0677b r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public d(com.obric.autogui.agents.vlm.models.b r2) {
        d.h.b.o.e(r2, "modelType");
        this.f27626a = r2;
        this.f27629e = new com.obric.autogui.agents.a.o.a();
    }

    public final com.obric.autogui.agents.vlm.models.b c() {
        return this.f27626a;
    }

    static {
        f27625b = new b(null);
        h = com.obric.autogui.util.b.f31495a.a();
    }

    static /* synthetic */ Object a(d r5, com.obric.autogui.agents.vlm.b.C0677b r6, d.c.d<? super com.obric.autogui.common.e> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "initializing env for GPT");
        String r9 = r6.a().l().getUserTask();
        if (r9 != null) goto L7;
        return com.obric.autogui.common.e.f29014b.b("the model requires user-task to be not-null.");
    L7:
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L9;
        Loog.INSTANCE.d(TAG, "queried task [orig=" + r6.a().l().getLaunchOrigin() + "]: " + r9);
    L10:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.a.k r10 = r6.c();
        if (r10 == null) goto L13;
        float r11 = r10.n();
    L14:
        r5.f27627c = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g(r0, r11), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        r11 = 1.0f;
        goto L14
    L9:
        Loog.INSTANCE.d(TAG, "queried task");
        goto L10
    }

    private final boolean c(com.obric.autogui.agents.vlm.b.C0677b r1) {
        return r1.e();
    }

    static /* synthetic */ Object a(d r40, com.obric.autogui.agents.vlm.b.C0677b r41, com.obric.autogui.agents.a.d r42, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.agents.vlm.models.c.b>> r43) {
        com.obric.autogui.agents.vlm.b.C0677b r8 = r41;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r43, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, y.class) == false) goto L7;
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0, y.class, "com.obric.aiagent.plugin");
        if ((r1.j & Integer.MIN_VALUE) == 0) goto L7;
        r1.j -= Integer.MIN_VALUE;
    L8:
        y r11 = r1;
        Object r2 = r11.h;
        Object r12 = d.c.a.b.a();
        int r3 = r11.j;
        String r15 = "[Step #";
        String r4 = TAG;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        boolean r5 = r11.g;
        long r6 = r11.f;
        int r7 = r11.f27772e;
        au r9 = (au) ZeusTransformUtils.preCheckCast(r11.f27771d, au.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r10 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r11.f27770c, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11.f27769b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r14 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r11.f27768a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r4 = TAG;
        com.obric.autogui.session.c.a r16 = r10;
        r8 = r14;
        r15 = "[Step #";
        ScreenshotResult.Status r24 = null;
    L45:
        d.m r17 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");
    L40:
        boolean r36 = r5;
        long r18 = r6;
        com.obric.autogui.session.c.a r29 = r16;
        au r37 = r9;
    L46:
        e r19 = (e) ZeusTransformUtils.preCheckCast(r17.c(), e.class, "com.obric.aiagent.plugin");
        boolean r20 = ((Boolean) ZeusTransformUtils.preCheckCast(r17.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        ScreenshotResult r33 = r19.a();
        String r21 = r4;
        Loog.INSTANCE.d(r21, r15 + r7 + "] - prepare done (l=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r18) + "ms)");
        if (com.obric.autogui.agents.b.b.a(r8.a()) == false) goto L54;
        if (r33 == null) goto L50;
        IScreenshot r22 = r33.getPic();
    L51:
        if (r22 != null) goto L54;
        Loog.INSTANCE.e(r21, "event=access_ui_screenshot_wait_exhausted sessionKey=" + r8.a().a() + " stepId=" + r13);
        return com.obric.autogui.common.d.f29012a.a("Computer Control application-access UI screenshot is not ready.");
    L50:
        r22 = r24;
    L54:
        if (r20 == false) goto L56;
        int r110 = 4;
    L57:
        if (r33 == null) goto L59;
        ScreenshotResult.Status r23 = r33.getStatus();
    L61:
        if (r23 != ScreenshotResult.Status.ContainsSecure) goto L63;
        int r30 = r110 | 8;
    L64:
        com.obric.autogui.common.d.a r25 = com.obric.autogui.common.d.f29012a;
        long r26 = r19.b();
        return r25.a(new com.obric.autogui.agents.vlm.models.c.b(r13, r7, false, r29, r30, d.c.b.a.b.a(r26), r19.d(), r33, d.c.b.a.b.a(r19.c()), null, r36, r37, 512, null));
    L63:
        r30 = r110;
        goto L64
    L59:
        r23 = r24;
        goto L61
    L56:
        r110 = 0;
        goto L57
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r11.g;
        r6 = r11.f;
        r7 = r11.f27772e;
        r9 = (au) ZeusTransformUtils.preCheckCast(r11.f27771d, au.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r27 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r11.f27770c, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        r13 = (String) ZeusTransformUtils.preCheckCast(r11.f27769b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r111 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r11.f27768a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r4 = TAG;
        r16 = r27;
        r8 = r111;
        r15 = "[Step #";
        r24 = null;
    L39:
        r17 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");
        goto L40
    L16:
        d.o.a(r2);
        String r28 = r42.b();
        int r31 = r41.a().s();
        com.obric.autogui.session.c.a r32 = r42.c();
        Loog.INSTANCE.d(TAG, "[Step #" + r31 + "] - prepare");
        r18 = AOSystemTools.INSTANCE.nowTimeMillis();
        boolean r34 = r40.d(r41);
        if (r34 == false) goto L20;
        Loog.INSTANCE.i(TAG, "[Step #" + r31 + "] - skip screenshot, view tree and script abilities after successful Browser_Use");
    L20:
        final boolean r35 = com.obric.autogui.common.a.d.f28974a.y();
        if (r35 == true) goto L23;
    L26:
        boolean r38 = false;
    L27:
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$NyCmQ_OKmeq6G7rnxzhkNacpIPI(r35));
        if (r38 == false) goto L30;
        kotlinx.coroutines.w r39 = kotlinx.coroutines.y.a(null, 1, null);
        com.obric.autogui.session.c.a r210 = r32;
        int r211 = r31;
        r24 = null;
        int r44 = 1;
        AOThreadingTools.INSTANCE.launchIOJob((d.h.a.m) ZeusTransformUtils.preCheckCast(new z(r39, r40, r41, r210, r211, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        au r45 = (au) ZeusTransformUtils.preCheckCast(r39, au.class, "com.obric.aiagent.plugin");
    L31:
        if (r18 == 0) goto L34;
        r17 = new d.m(new e(null, AOSystemTools.INSTANCE.nowTimeMillis(), 0, null), d.c.b.a.b.a(r40.f()));
        r37 = r45;
        r36 = r34;
        r29 = r210;
        r7 = r211;
        r13 = r28;
        goto L46
    L34:
        if (com.obric.autogui.common.a.d.f28974a.z() == false) goto L41;
        r11.f27768a = r8;
        r11.f27769b = r28;
        com.obric.autogui.session.c.a r46 = r210;
        r11.f27770c = r46;
        r11.f27771d = r45;
        int r47 = r211;
        r11.f27772e = r47;
        r11.f = r18;
        r11.g = r18;
        r11.j = r44;
        Object r48 = r40.a(r8, r42, r47, r11);
        if (r48 != r12) goto L38;
        return r12;
    L38:
        r13 = r28;
        r16 = r46;
        r7 = r47;
        r2 = r48;
        r9 = r45;
        r6 = r18;
        r5 = r18;
        goto L39
    L41:
        com.obric.autogui.session.c.a r49 = r210;
        int r50 = r211;
        r11.f27768a = r8;
        r11.f27769b = r28;
        r11.f27770c = r49;
        r11.f27771d = r45;
        r11.f27772e = r50;
        r11.f = r18;
        r11.g = r18;
        r11.j = 2;
        Object r51 = r40.b(r8, r42, r50, r11);
        if (r51 != r12) goto L44;
        return r12;
    L44:
        r13 = r28;
        r16 = r49;
        r7 = r50;
        r2 = r51;
        r9 = r45;
        r6 = r18;
        r5 = r18;
        goto L45
    L30:
        r211 = r31;
        r210 = r32;
        r44 = 1;
        r24 = null;
        r45 = null;
        goto L31
    L23:
        if (r40.c(r41) == true) goto L26;
        if (r34 == true) goto L26;
        r38 = true;
    L7:
        r1 = new y(r40, r0);
        goto L8
    }

    private static final String a(boolean r2) {
        return "vlm viewtree enable=" + r2;
    }

    private final boolean d(com.obric.autogui.agents.vlm.b.C0677b r5) {
        com.obric.autogui.operator.e r4 = r5.a().r();
        com.obric.autogui.operator.b.EnumC0777b r0 = null;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.impl.g r6 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L7:
        if (r6 != null) goto L9;
        return false;
    L9:
        com.obric.autogui.operator.e.C0780e r1 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(d.a.p.j((Iterable) ZeusTransformUtils.preCheckCast(r6.Q(), Iterable.class, "com.obric.aiagent.plugin")), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        r0 = r1.a();
    L13:
        if (r0 == com.obric.autogui.operator.b.EnumC0777b.i) goto L15;
        return false;
    L15:
        com.obric.autogui.operator.g r7 = r6.t();
        if (r7 != null) goto L19;
        return false;
    L19:
        if (r7.b() == com.obric.autogui.operator.g.c.f29925d) goto L21;
        return false;
    L21:
        if (r7.a() == true) goto L25;
        return true;
    L25:
        return false;
    L5:
        r6 = null;
        goto L7
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r9, com.obric.autogui.agents.a.d r10, int r11, d.c.d<? super d.m<e, Boolean>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(r11, this, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    private final Object b(com.obric.autogui.agents.vlm.b.C0677b r8, com.obric.autogui.agents.a.d r9, int r10, d.c.d<? super d.m<e, Boolean>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ab.class) == false) goto L7;
        ab r0 = (ab) ZeusTransformUtils.preCheckCast(r12, ab.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f27647d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r7 = r0.f27646c;
        r10 = r0.f27645b;
        d r14 = (d) ZeusTransformUtils.preCheckCast(r0.f27644a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        long r5 = r7;
        d this = r14;
    L17:
        e r15 = (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin");
        boolean r16 = this.f();
        Loog.INSTANCE.i(TAG, "[PrepState][Step #" + r10 + "] sequential total=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r5) + "ms");
        return new d.m(r15, d.c.b.a.b.a(r16));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        r5 = AOSystemTools.INSTANCE.nowTimeMillis();
        r0.f27644a = this;
        r0.f27645b = r10;
        r0.f27646c = r5;
        r0.f = 1;
        r13 = c(r8, r9, r10, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new ab(this, r12);
        goto L8
    }

    private final Object c(com.obric.autogui.agents.vlm.b.C0677b r8, com.obric.autogui.agents.a.d r9, int r10, d.c.d<? super e> r11) {
        d.c.d<? super e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r8, r9.b(), r9.c(), r10, null, r6);
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r32, String r33, com.obric.autogui.session.c.a r34, int r35, String r36, d.c.d<? super e> r37) {
        d r0 = this;
        com.obric.autogui.agents.vlm.b.C0677b r1 = r32;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L7;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        if ((r5.l & Integer.MIN_VALUE) == 0) goto L7;
        r5.l -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.j;
        Object r6 = d.c.a.b.a();
        int r7 = r5.l;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        long r2 = r5.i;
        d.h.b.z.f r8 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r5.f27691e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r9 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r5.f27690d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.f27689c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r11 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27688b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.preCheckCast(r5.f27687a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        com.obric.autogui.agents.vlm.b.C0677b r13 = r11;
        String r14 = r10;
    L24:
        long r15 = d.l.n.a(AOSystemTools.INSTANCE.nowTimeMillis() - r2, 0);
        com.obric.autogui.agents.vlm.models.a r16 = new com.obric.autogui.agents.vlm.models.a(r14, 0, 0, 0, false, 30, null);
        r16.a(r15);
        r12.f27628d = r16;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r13.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.j);
        return new e((ScreenshotResult) ZeusTransformUtils.preCheckCast(r9.f38504a, ScreenshotResult.class, "com.obric.aiagent.plugin"), AOSystemTools.INSTANCE.nowTimeMillis(), r15, (Boolean) ZeusTransformUtils.preCheckCast(r8.f38504a, Boolean.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r17 = r5.h;
        int r18 = r5.g;
        d.h.b.z.d r19 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r5.f, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        r14 = (String) ZeusTransformUtils.preCheckCast(r5.f27691e, String.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r5.f27690d, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r111 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r5.f27689c, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r112 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27688b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r20 = (d) ZeusTransformUtils.preCheckCast(r5.f27687a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        boolean r113 = r17;
        int r21 = r18;
        r0 = r20;
        d.h.b.z.d r22 = r19;
        String r114 = r110;
        com.obric.autogui.session.c.a r115 = r111;
        r1 = r112;
    L20:
        com.obric.autogui.agents.a.d.c r116 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
        long r23 = AOSystemTools.INSTANCE.nowTimeMillis();
        r9 = new d.h.b.z.f();
        d.h.b.z.f r117 = new d.h.b.z.f();
        com.obric.autogui.util.a r24 = com.obric.autogui.util.a.f31488a;
        String r25 = "stp/" + r14 + "-screenshot";
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r26 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new j(r0, r1, r14, r115, r114, r116, r9, r117, r113, r22, r21, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r5.f27687a = r0;
        r5.f27688b = r1;
        r5.f27689c = r14;
        r5.f27690d = r9;
        r5.f27691e = r117;
        r5.f = null;
        r5.i = r23;
        r5.l = 2;
        if (r24.a(r25, 10, 500, r26, r5) != r6) goto L23;
        return r6;
    L23:
        r8 = r117;
        r12 = r0;
        r13 = r1;
        r2 = r23;
        goto L24
    L16:
        d.o.a(r4);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r32.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.j);
        boolean r27 = e(r32);
        d.h.b.z.d r28 = new d.h.b.z.d();
        r5.f27687a = r0;
        r5.f27688b = r1;
        r5.f27689c = r34;
        r5.f27690d = r36;
        r5.f27691e = r33;
        r5.f = r28;
        r5.g = r35;
        r5.h = r27;
        r5.l = 1;
        Object r29 = r0.b(r1, r5);
        if (r29 != r6) goto L19;
        return r6;
    L19:
        r113 = r27;
        r115 = r34;
        r22 = r28;
        r4 = r29;
        r114 = r36;
        r14 = r33;
        r21 = r35;
    L7:
        r5 = new i(r0, r3);
        goto L8
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r10, com.obric.autogui.agents.vlm.models.c.b r11, String r12, boolean r13, d.c.d<? super a> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r13, this, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r15);
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r10, String r11, e r12) {
        ScreenshotResult r0 = r12.a();
        if (r0 == null) goto L5;
        a(r10, r0);
    L5:
        ScreenshotResult.Status r1 = null;
        if (r0 == null) goto L8;
        IScreenshot r5 = r0.getPic();
    L10:
        if (r0 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L18;
        if (r5 == null) goto L18;
        this.f27629e.a(r10.a(), r5, r11, r12.c());
        return;
    L18:
        Loog r9 = Loog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("[OAutoActionEffect] white screen detection skipped session_id=").append(com.obric.autogui.agents.a.b.a(r10.a().b(), 0, 1, null)).append(", last_step_id=");
        com.obric.autogui.operator.e r13 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(d.a.p.n(r10.a().p()), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L21;
        String r14 = r13.W();
    L22:
        if (r14 != null) goto L24;
        r14 = "";
    L24:
        StringBuilder r15 = r6.append(com.obric.autogui.agents.a.b.a(r14, 0, 1, null)).append(", screenshot_step_id=").append(com.obric.autogui.agents.a.b.a(r11, 0, 1, null)).append(", reason=model_screenshot_unavailable, screenshot_status=");
        if (r0 == null) goto L27;
        r1 = r0.getStatus();
    L27:
        r9.w(TAG, r15.append(r1).append(", model_screenshot_capture_elapsed_ms=").append(r12.c()).toString());
        return;
    L21:
        r14 = null;
        goto L22
    L12:
        if (r0.ok() != true) goto L14;
        r4 = true;
        goto L15
    L8:
        r5 = null;
        goto L10
    }

    private final void a(ScreenshotResult r4) {
        if (r4 != null) goto L14;
        return;
    L14:
        IScreenshot r3 = r4.getPic();     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        r3.release();     // Catch: Exception -> L8
    L10:
        HeifScreenshotAttachment r5 = r4.getHeifAttachment();
        if (r5 == null) goto L16;
        AOThreadingTools.INSTANCE.launchIOJob((d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        return;
    L8:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] discarded model screenshot release failed error_type=" + e.getClass().getSimpleName());
        goto L10
    }

    private final Object b(com.obric.autogui.agents.vlm.b.C0677b r11, d.c.d<? super com.obric.autogui.agents.a.d.c> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ad.class) == false) goto L7;
        ad r0 = (ad) ZeusTransformUtils.preCheckCast(r13, ad.class, "com.obric.aiagent.plugin");
        if ((r0.f27654d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27654d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f27652b;
        Object r14 = d.c.a.b.a();
        int r2 = r0.f27654d;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        r11 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r0.f27651a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Throwable -> L14 CancellationException -> L16
    L58:
    L75:
        return (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r10);
        if (com.obric.autogui.agents.b.b.a(r11.a()) == true) goto L23;
        return null;
    L23:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.h(r11.a().p()), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r15.hasNext() == false) goto L42;
        Object r3 = r15.next();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r8 = false;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L29;
    L31:
        Iterator r7 = r6.iterator();
    L33:
        if (r7.hasNext() == false) goto L40;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L37;
        boolean r9 = true;
    L38:
        if (r9 == false) goto L33;
        r8 = true;
        goto L40
    L37:
        r9 = false;
    L40:
        if (r8 == false) goto L25;
    L44:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L46;
        com.obric.autogui.agents.vlm.models.impl.g r16 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L47:
        if (r16 == null) goto L51;
        com.obric.autogui.agents.vlm.models.a.a.b r17 = r16.n();
        if (r17 == null) goto L51;
        final IScreenshot r18 = r17.a();
    L52:
        if (r18 != null) goto L55;
        Loog.INSTANCE.w(TAG, "event=access_ui_visual_baseline_unavailable sessionKey=" + r11.a().a());
        return null;
    L55:
        d.h.a.a r4 = new $$Lambda$d$zQLzChkMduhZ2wpgWB_Hw42OFxw(r18);     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f27651a = r11;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f27654d = 1;     // Catch: Throwable -> L14 CancellationException -> L16
        r10 = r18.withResourcesLocked(r4, r0);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r10 != r14) goto L58;
        return r14;
    L51:
        r18 = null;
        goto L52
    L46:
        r16 = null;
        goto L47
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L42:
        r3 = null;
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "event=access_ui_visual_baseline_failed sessionKey=" + r11.a().a() + " errorType=" + th.getClass().getSimpleName());
        return null;
    L7:
        r0 = new ad(this, r13);
        goto L8
    }

    private static final com.obric.autogui.agents.a.d.c a(IScreenshot r2) {
        IScreenshot r3 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.agents.a.d.d.f26364a.a(r3.getBitmap());
    }

    private final Object a(com.obric.autogui.agents.a.d.c r21, IScreenshot r22, String r23, String r24, d.c.d<? super Boolean> r25) {
        com.obric.autogui.agents.a.d.c r1 = r21;
        final IScreenshot r0 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r22, IScreenshot.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L7;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f27724d;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f;
        boolean r9 = false;
        if (r7 == 0) goto L21;
        if (r7 != 1) goto L20;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.f27723c, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f27722b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d.c r10 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r4.f27721a, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14 CancellationException -> L17
        String r11 = r2;
        r1 = r10;
    L60:
        com.obric.autogui.agents.a.d.c r14 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L17 Throwable -> L35
        com.obric.autogui.agents.a.d.c r13 = r1;
    L45:
        if (r14 == null) goto L47;
        com.obric.autogui.agents.a.d.b r12 = com.obric.autogui.agents.a.d.a.a(com.obric.autogui.agents.a.d.a.f26351a, r13, r14, 16, null, 0, 24, null);
        if (r12.a() < 7) goto L51;
    L54:
        r9 = true;
    L55:
        Loog.INSTANCE.i(TAG, "event=access_ui_visual_check sessionKey=" + r8 + " stepId=" + r11 + " ready=" + r9 + " hamming=" + r12.a() + " changedPixelPermille=" + r12.d() + " maxBlockChangedPixelPermille=" + r12.e());
        return d.c.b.a.b.a(r9);
    L51:
        if (r12.d() >= 10) goto L54;
        if (r12.e() < 150) goto L55;
    L47:
        return d.c.b.a.b.a(false);
    L35:
        th = th;
    L16:
        String r15 = r8;
    L44:
        Loog.INSTANCE.w(TAG, "event=access_ui_visual_fingerprint_failed sessionKey=" + r15 + " stepId=" + r11 + " errorType=" + th.getClass().getSimpleName());
        r14 = null;
        r13 = r1;
        r8 = r15;
    L14:
        th = th;
        r11 = r2;
        r1 = r10;
        goto L16
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        d.o.a(r5);
        if (r1 == null) goto L59;
        if (r0 == null) goto L59;
        d.h.a.a r16 = new $$Lambda$d$hrz4OCrM0GyFUnPq5zz11iPFDDw(r0);     // Catch: CancellationException -> L17 Throwable -> L41
        r4.f27721a = r1;     // Catch: CancellationException -> L17 Throwable -> L41
        r15 = r23;
        r4.f27722b = r15;     // Catch: CancellationException -> L17 Throwable -> L39
        r11 = r24;
        r4.f27723c = r11;     // Catch: CancellationException -> L17 Throwable -> L37
        r4.f = 1;     // Catch: CancellationException -> L17 Throwable -> L37
        r5 = r0.withResourcesLocked(r16, r4);     // Catch: CancellationException -> L17 Throwable -> L37
        if (r5 != r6) goto L32;
        return r6;
    L32:
        r8 = r15;
    L37:
        th = th;
    L39:
        th = th;
    L43:
        r11 = r24;
    L41:
        th = th;
        r15 = r23;
    L59:
        return d.c.b.a.b.a(false);
    L17:
        e = move-exception;
        throw e;
    L7:
        r4 = new p(this, r3);
        goto L8
    }

    private static final com.obric.autogui.agents.a.d.c b(IScreenshot r2) {
        IScreenshot r3 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.agents.a.d.d.f26364a.a(r3.getBitmap());
    }

    static /* synthetic */ Boolean a(d r6, com.obric.autogui.agents.vlm.b.C0677b r7, String r8, String r9, boolean r10, ScreenshotResult.Status r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L7;
        r11 = null;
    L7:
        return r6.a(r7, r8, r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryTopActivitySystemAnimationState");
    }

    private final Boolean a(com.obric.autogui.agents.vlm.b.C0677b r7, String r8, String r9, boolean r10, ScreenshotResult.Status r11) {
        String r0 = null;
        if (r10 == true) goto L5;
        return null;
    L5:
        long r1 = AOSystemTools.INSTANCE.bootTimeMillis();
        Boolean r12 = AOPlatformTools.INSTANCE.special().isAutoActionTopActivityInSystemAnimation();     // Catch: Exception -> L8
    L10:
        Loog r3 = Loog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("[OAutoActionEffect] model screenshot system animation captured step_id=").append(r8).append(", phase=").append(r9).append(", screenshot_status=");
        if (r11 == null) goto L13;
        String r13 = r11.toString();
    L14:
        String r14 = "";
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        StringBuilder r15 = r6.append(r13).append(", state=");
        if (r12 == null) goto L20;
        r0 = r12.toString();
    L20:
        if (r0 == null) goto L23;
        r14 = r0;
    L23:
        StringBuilder r16 = r15.append(r14).append(", available=");
        if (r12 == null) goto L26;
        boolean r17 = true;
    L27:
        r3.i(TAG, r16.append(r17).append(", query_elapsed_ms=").append(d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r1, 0)).toString());
        return r12;
    L26:
        r17 = false;
        goto L27
    L13:
        r13 = null;
    L8:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] model screenshot system animation query failed step_id=" + r8 + ", phase=" + r9 + ", error_type=" + e.getClass().getSimpleName());
        r12 = null;
        goto L10
    }

    private final boolean f() {
        return AOPlatformTools.INSTANCE.special().isAutoImeReady();
    L4:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "the exception " + e);
        return false;
    }

    private final Object a(String r15, com.obric.autogui.session.c.a r16, int r17, boolean r18, d.c.d<? super List<ViewHierarchyDump>> r19) {
        String r0 = r15;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, k.class) == false) goto L7;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin");
        if ((r3.f27701e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f27701e -= Integer.MIN_VALUE;
    L8:
        k r7 = r3;
        Object r2 = r7.f27699c;
        Object r4 = d.c.a.b.a();
        int r5 = r7.f27701e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        com.obric.autogui.session.c.a r6 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r7.f27698b, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.f27697a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        com.obric.autogui.session.c.a r10 = r6;
        r0 = r8;
    L21:
        List r9 = (List) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a.b(r10, "stp_pred", "vlm_viewtree_make", 0, 4, null);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r0, com.obric.autogui.agents.vlm.models.omni.b.c.k);
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        if (r18 == true) goto L18;
        return null;
    L18:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r15, com.obric.autogui.agents.vlm.models.omni.b.c.k);
        Loog.INSTANCE.i(TAG, " - [Step #" + r17 + "] - prepare viewtree for vlm");
        com.obric.autogui.session.c.a.a(r16, "stp_pred", "vlm_viewtree_make", 0, 4, null);
        AOSystemTools r11 = AOSystemTools.INSTANCE;
        int r12 = AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId();
        r7.f27697a = r0;
        r10 = r16;
        r7.f27698b = r10;
        r7.f27701e = 1;
        r2 = AOSystemTools.dumpViewHierarchy$default(r11, r12, false, r7, 2, null);
        if (r2 != r4) goto L21;
        return r4;
    L7:
        r3 = new k(this, r1);
        goto L8
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r1, ScreenshotResult r2) {
        if (r2.ok() == true) goto L5;
        return;
    L5:
        if (r2.getHeifAttachment() == null) goto L13;
        com.obric.autogui.agents.vlm.models.omni.r r0 = com.obric.autogui.agents.vlm.models.omni.t.f28523a.a(r1.a().b());
        if (r0 == null) goto L12;
        r0.a(r2);
        return;
    L12:
        return;
    }

    private final boolean e(com.obric.autogui.agents.vlm.b.C0677b r5) {
        com.obric.autogui.operator.e r4 = f(r5);
        if (r4 != null) goto L6;
        return false;
    L6:
        if ((r4.M() & 8) == 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L15;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == false) goto L18;
        boolean r8 = true;
    L25:
        if (r8 == true) goto L27;
        return false;
    L27:
        Loog.INSTANCE.i(TAG, " - [SecureOpenApp] previous effective action step used secure screenshot and executed OpenApp; will stabilize next model screenshot if it is still secure.");
        return true;
    L22:
        r1 = false;
    L15:
        r8 = false;
        goto L25
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L16;
    L8:
        r0 = false;
        goto L9
    }

    private final com.obric.autogui.operator.e f(com.obric.autogui.agents.vlm.b.C0677b r4) {
        List<com.obric.autogui.operator.e> r3 = r4.a().p();
        com.obric.autogui.operator.e r5 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(d.a.p.n(r3), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        Object r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((!r5.Q().isEmpty()) == false) goto L8;
        return r5;
    L8:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.h(r3), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Object r7 = r6.next();
        if ((!((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q().isEmpty()) == false) goto L10;
        r0 = r7;
    L14:
        com.obric.autogui.operator.e r8 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        Loog.INSTANCE.i(TAG, " - [SecureOpenApp] ignored empty-operation step(s) when resolving previous action step.");
    L17:
        return r8;
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r21, String r22, String r23, d.c.d<? super ScreenshotResult> r24) {
        d r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, x.class) == false) goto L7;
        x r4 = (x) ZeusTransformUtils.preCheckCast(r2, x.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        x r10 = r4;
        Object r3 = r10.f27766d;
        Object r5 = d.c.a.b.a();
        int r6 = r10.f;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        d.o.a(r3);
    L68:
        return r3;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r3);
    L60:
        return r3;
    L17:
        ScreenshotConfig r1 = (ScreenshotConfig) ZeusTransformUtils.preCheckCast(r10.f27765c, ScreenshotConfig.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r10.f27764b, String.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.preCheckCast(r10.f27763a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        ScreenshotConfig r9 = r1;
        r0 = r8;
        Object r11 = r3;
    L45:
        ScreenshotResult r12 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r11, ScreenshotResult.class, "com.obric.aiagent.plugin");
    L47:
        if (r12 != null) goto L49;
    L54:
        Loog.INSTANCE.i(TAG, "[StartFromCurrent] prefetch missed/failed, fallback to sync acquireMDScreenshot");
        com.obric.autogui.agents.vlm.models.a.a r13 = r0.f27627c;
        if (r13 != null) goto L57;
        d.h.b.o.c("mScreenshotProvider");
        r13 = null;
    L57:
        r10.f27763a = null;
        r10.f27764b = null;
        r10.f27765c = null;
        r10.f = 2;
        r3 = r13.a(r7, r9, true, r10);
        if (r3 != r5) goto L60;
        return r5;
    L49:
        if (r12.ok() == false) goto L54;
        if (r12.getPic() == null) goto L54;
        Loog.INSTANCE.i(TAG, "[StartFromCurrent] consumed prefetched MD screenshot");
        return r12;
    L18:
        d.o.a(r3);
        String r14 = com.obric.autogui.agents.vlm.models.c.a.f27282a.a(r22);
        if (r23 == null) goto L23;
        r7 = r14 + '_' + r23;
        if (r7 == null) goto L23;
    L25:
        if (r21.i() == true) goto L61;
        Bundle r15 = r21.a().l().getTaskExtras();
        boolean r16 = false;
        if (r15 != null) goto L29;
    L31:
        boolean r17 = AutoActionAbilitiesKt.isSupported(AutoActionAbility.WmCaptureMainDisplay);
        if (r17 == true) goto L34;
        Loog.INSTANCE.w(TAG, "[StartFromCurrent] capturing MD not supported.");
    L34:
        if (r16 == false) goto L61;
        if (r17 == false) goto L61;
        if (r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L40;
        Loog.INSTANCE.i(TAG, "[StartFromCurrent] skip MainDisplay screenshot because keyguard locked");
        return new ScreenshotResult(ScreenshotResult.Status.KeyguardLocked, null, null, 0, null, null, 62, null);
    L40:
        Loog.INSTANCE.d(TAG, "[StartFromCurrent] let's do from MainDisplay!");
        r9 = new ScreenshotConfig(AssistantAbilityHelper.INSTANCE.getScreenshotExcludingPackages((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), 0.0f, null, 6, null);
        com.obric.autogui.session.d.h r18 = r21.a().k().a();
        if (r18 == null) goto L46;
        r10.f27763a = r0;
        r10.f27764b = r7;
        r10.f27765c = r9;
        r10.f = 1;
        r11 = r18.a(r10);
        if (r11 != r5) goto L45;
        return r5;
    L46:
        r12 = null;
        goto L47
    L29:
        if (r15.getBoolean("start_in_place") != true) goto L31;
        r16 = true;
    L61:
        com.obric.autogui.agents.vlm.models.a.a r19 = r0.f27627c;
        if (r19 != null) goto L64;
        d.h.b.o.c("mScreenshotProvider");
        com.obric.autogui.agents.vlm.models.a.a r20 = null;
    L65:
        r10.f = 3;
        r3 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r20, r7, null, true, true, r10, 2, null);
        if (r3 != r5) goto L68;
        return r5;
    L64:
        r20 = r19;
    L23:
        r7 = r14;
    L7:
        r4 = new x(r0, r2);
        goto L8
    }

    private final boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Object r6 = r5.getSystemService("keyguard");     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf(r6, KeyguardManager.class) == false) goto L6;
        KeyguardManager r7 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r6, KeyguardManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L7:
        boolean r8 = true;
        if (r7 != null) goto L10;
    L12:
        r8 = false;
    L13:
        Object r9 = d.n.f(Boolean.valueOf(r8));     // Catch: Throwable -> L15
    L18:
        if (d.n.b(r9) == false) goto L21;
        r9 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        if (r7.isKeyguardLocked() != true) goto L12;
    L6:
        r7 = null;
    L15:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L18
    }

    public final com.obric.autogui.agents.vlm.models.impl.a.a d() {
        return this.f;
    }

    @Override // com.obric.autogui.agents.vlm.models.c
    public final Object a(com.obric.autogui.agents.vlm.b.C0677b r18, com.obric.autogui.agents.vlm.models.c.b r19, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.operator.e>> r20) {
        com.obric.autogui.agents.vlm.b.C0677b r1 = r18;
        com.obric.autogui.agents.vlm.models.c.b r2 = r19;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, s.class) == false) goto L7;
        s r5 = (s) ZeusTransformUtils.preCheckCast(r3, s.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f27739d;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ComponentName r0 = (ComponentName) ZeusTransformUtils.preCheckCast(r5.f27738c, ComponentName.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.g r8 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r5.f27737b, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        r2 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27736a, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L71:
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.g r10 = r8;
    L73:
        ScreenshotResult r11 = r2.g();
        if (r11 == null) goto L76;
        IScreenshot r12 = r11.getPic();
    L77:
        r10.a(r12, r0, r9);
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L80;
        com.obric.autogui.agents.vlm.models.a.b r13 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L81:
        if (r13 == null) goto L83;
        String r14 = r13.f();
    L84:
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("[MakeStep] exit success stepId=").append(r2.a()).append(", actionType=");
        if (r14 != null) goto L87;
        r14 = r10.getClass().getSimpleName();
    L87:
        r15.i(TAG, r16.append(r14).toString());
        return com.obric.autogui.common.d.f29012a.a(r10);
    L83:
        r14 = null;
        goto L84
    L80:
        r13 = null;
        goto L81
    L76:
        r12 = null;
        goto L77
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (ComponentName) ZeusTransformUtils.preCheckCast(r5.f27738c, ComponentName.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r17 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27737b, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r21 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27736a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r2 = r17;
        r1 = r21;
    L29:
        c r22 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        r10 = r22.a();
        f r23 = r22.b();
        Loog r110 = Loog.INSTANCE;
        StringBuilder r111 = new StringBuilder().append("[MakeStep] after performMakeStep stepId=").append(r2.a()).append(", hasStep=");
        if (r10 == null) goto L32;
        boolean r24 = true;
    L33:
        StringBuilder r25 = r111.append(r24).append(", hasEarlyTerm=");
        if (r23 == null) goto L36;
        boolean r112 = true;
    L37:
        r110.i(TAG, r25.append(r112).toString());
        if (r23 == null) goto L44;
        Loog.INSTANCE.e(TAG, " - failed to generate step. earlyTermInfo=" + r23);
        Loog.INSTANCE.i(TAG, "[MakeStep] exit earlyTerm stepId=" + r2.a() + ", reason=" + r23.a());
        r1.a().J().a(r23.a());
        com.obric.autogui.common.d.a r26 = com.obric.autogui.common.d.f29012a;
        String r27 = r23.b();
        if (r27 != null) goto L43;
        r27 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_model_api_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_model_api_failed"), new Object[]{d.c.b.a.b.a(r23.a())});
        d.h.b.o.c(r27, "getString(...)");
    L43:
        return r26.b(r27);
    L44:
        if (r10 != null) goto L47;
        Loog.INSTANCE.e(TAG, " - failed to generate step (w/o earlyTermInfo) resp=null");
        Loog.INSTANCE.i(TAG, "[MakeStep] exit null-response stepId=" + r2.a());
        r1.a().J().a(100001);
        com.obric.autogui.common.d.a r28 = com.obric.autogui.common.d.f29012a;
        String r29 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_model_api_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_model_api_failed"), new Object[]{d.c.b.a.b.a(100001)});
        d.h.b.o.c(r29, "getString(...)");
        return r28.b(r29);
    L47:
        ScreenshotResult r30 = r2.g();
        if (r30 == null) goto L52;
        IScreenshot r31 = r30.getPic();
        if (r31 == null) goto L52;
        AOOperatingSpace.SpaceType r32 = r31.getSpaceType();
    L54:
        if (r32 != AOOperatingSpace.SpaceType.MainDisplay) goto L65;
        com.obric.autogui.session.state.a r33 = r1.a().m().a(BizStatus.OPERATING);
        if (ZeusTransformUtils.instanceOf(r33, com.obric.autogui.session.state.a.h.class) == false) goto L58;
        com.obric.autogui.session.state.a.h r34 = (com.obric.autogui.session.state.a.h) ZeusTransformUtils.preCheckCast(r33, com.obric.autogui.session.state.a.h.class, "com.obric.aiagent.plugin");
    L59:
        if (r34 == null) goto L65;
        DisplayedAppInfo r35 = r34.a();
        if (r35 == null) goto L65;
        ComponentName r36 = r35.getTopActivity();
        if (r36 == null) goto L65;
        r0 = r36;
        goto L65
    L58:
        r34 = null;
    L65:
        au<List<ViewHierarchyDump>> r37 = r2.k();
        if (r37 == null) goto L72;
        r5.f27736a = r2;
        r5.f27737b = r10;
        r5.f27738c = r0;
        r5.f = 2;
        r4 = r37.a(r5);
        if (r4 != r6) goto L70;
        return r6;
    L70:
        r8 = r10;
        goto L71
    L72:
        r9 = null;
    L52:
        r32 = null;
        goto L54
    L36:
        r112 = false;
        goto L37
    L32:
        r24 = false;
        goto L33
    L16:
        d.o.a(r4);
        com.obric.autogui.common.a.k r38 = r18.c();
        if (r38 != null) goto L20;
        com.obric.autogui.common.d.a r39 = com.obric.autogui.common.d.f29012a;
        String r40 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
        d.h.b.o.c(r40, "getString(...)");
        return r39.b(r40);
    L20:
        Loog.INSTANCE.i(TAG, "[MakeStep] enter stepId=" + r19.a() + ", stepNum=" + r19.b() + ", model=" + this.f27626a.a());
        ScreenshotResult r41 = r19.g();
        if (r41 == null) goto L24;
        final ComponentName r42 = r41.getTopComponent();
        if (r42 == null) goto L24;
    L25:
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$PES9QWXIjP9xhdqhS1j8zgYyXPc(r42), $$Lambda$d$ox0dJWrNq28kx3Jr0S4dZeuAg4g.INSTANCE);
        Loog.INSTANCE.i(TAG, "[MakeStep] before performMakeStep stepId=" + r19.a());
        r5.f27736a = r1;
        r5.f27737b = r2;
        r5.f27738c = r42;
        r5.f = 1;
        r4 = b(r1, r38, r2, r5);
        if (r4 != r6) goto L28;
        return r6;
    L28:
        r0 = r42;
    L24:
        r42 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
    L7:
        r5 = new s(this, r3);
        goto L8
    }

    private static final String a(ComponentName r2) {
        return "topComponentBeforeGeneration, " + r2;
    }

    private final Object b(com.obric.autogui.agents.vlm.b.C0677b r5, com.obric.autogui.common.a.k r6, com.obric.autogui.agents.vlm.models.c.b r7, d.c.d<? super c> r8) {
        d.c.d<? super c> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        c r0 = a(r7);
        if (r0 == null) goto L6;
        Loog.INSTANCE.d(TAG, " - [MakeStep] fetchStepFromHolder, result=" + r0);
        return r0;
    L6:
        Loog.INSTANCE.d(TAG, " - [MakeStep] makeStepsAnew (forStepId=" + r7.a() + '.');
        return c(r5, r6, r7, r9);
    }

    private final c a(com.obric.autogui.agents.vlm.models.c.b r7) {
        com.obric.autogui.agents.vlm.models.impl.a.a r0 = this.f;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.b() == true) goto L9;
        Loog.INSTANCE.d(TAG, "[MakeStep][StepsHolder] depleted StepsHolder ($)(atSId=" + r0.a() + ", curSId=" + r7.a() + ").");
        this.g = null;
        return null;
    L9:
        com.obric.autogui.agents.vlm.models.impl.g r2 = r0.c();
        r2.a(this.g);
        Loog.INSTANCE.d(TAG, "[MakeStep][StepsHolder] from StepsHolder (sId=" + r0.a() + "), got=" + r2);
        r2.n(r7.a());
        return new c(r2, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:371:0x1135 -> B:340:0x0ed0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:375:0x11da -> B:376:0x1204). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 58121. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final java.lang.Object c(com.obric.autogui.agents.vlm.b.C0677b r46, com.obric.autogui.common.a.k r47, com.obric.autogui.agents.vlm.models.c.b r48, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.d.c> r49) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r45v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.autogui.agents.vlm.models.impl.d.c(com.obric.autogui.agents.vlm.b$b, com.obric.autogui.common.a.k, com.obric.autogui.agents.vlm.models.c$b, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.d$c>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 5812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.vlm.models.impl.d.c(com.obric.autogui.agents.vlm.b$b, com.obric.autogui.common.a.k, com.obric.autogui.agents.vlm.models.c$b, d.c.d):java.lang.Object");
    }

    private static final d.x a(com.obric.autogui.agents.vlm.models.impl.request.a.c r1, long r2, com.obric.autogui.agents.vlm.models.impl.f.a r4, com.obric.autogui.agents.vlm.models.impl.g r5) {
        d.h.b.o.e(r5, "$this$onRepresentative");
        boolean r0 = true;
        if ((r1.b() & 1) != 0) goto L6;
        r0 = false;
    L6:
        r5.a(r0);
        r5.y().e(r2);
        if (r4 == null) goto L10;
        r5.a(r4);
    L10:
        return d.x.f38692a;
    }

    private static final d.x a(com.obric.autogui.session.c.a r1, com.obric.autogui.agents.vlm.models.c.b r2, C0690d r3, d r4, com.obric.autogui.agents.vlm.models.impl.g r5) {
        d.h.b.o.e(r5, "$this$onRepresentative");
        r5.a(r1);
        r5.e(r2.d());
        r5.b(r3.d());
        r5.a(r2.i());
        r5.a(r4.f27628d);
        return d.x.f38692a;
    }

    private final Object a(com.obric.autogui.agents.vlm.models.c.b r13, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.c.b> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, o.class) == false) goto L7;
        o r0 = (o) ZeusTransformUtils.preCheckCast(r15, o.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f27720e;
        Object r16 = d.c.a.b.a();
        int r2 = r0.g;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        long r17 = r0.f27719d;
        com.obric.autogui.agents.vlm.models.c.b r1 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r0.f27716a, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L15 CancellationException -> L53
        long r7 = r17;
        r13 = r1;
    L42:
        com.obric.autogui.agents.vlm.models.impl.c.b r18 = (com.obric.autogui.agents.vlm.models.impl.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.c.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50 CancellationException -> L53
        Loog r3 = Loog.INSTANCE;     // Catch: Exception -> L50 CancellationException -> L53
        StringBuilder r4 = new StringBuilder().append("[OAutoPreActionPageState] 模型请求页摘要已生成 step_id=").append(r13.a()).append(", available_dimensions=").append(r18.l()).append(", secure=");     // Catch: Exception -> L50 CancellationException -> L53
        Boolean r19 = r18.j();     // Catch: Exception -> L50 CancellationException -> L53
        if (r19 == null) goto L45;
        String r110 = r19.toString();     // Catch: Exception -> L50 CancellationException -> L53
    L46:
        if (r110 != null) goto L48;
        r110 = "";
    L48:
        r3.i(TAG, r4.append(r110).append(", elapsed_ms=").append(d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r7, 0)).toString());     // Catch: Exception -> L50 CancellationException -> L53
    L50:
        e = e;
    L51:
        Loog.INSTANCE.w(TAG, "[OAutoPreActionPageState] 模型请求页摘要生成失败 step_id=" + r13.a() + ", error_type=" + e.getClass().getSimpleName());
        return null;
    L62:
        return (com.obric.autogui.agents.vlm.models.impl.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.c.b.class, "com.obric.aiagent.plugin");
    L45:
        r110 = null;
    L15:
        e = e;
        r13 = r1;
        goto L51
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r7 = r0.f27719d;
        ScreenshotResult r111 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r0.f27718c, ScreenshotResult.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.c.c r5 = (com.obric.autogui.agents.vlm.models.impl.c.c) ZeusTransformUtils.preCheckCast(r0.f27717b, com.obric.autogui.agents.vlm.models.impl.c.c.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r6 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r0.f27716a, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L22 CancellationException -> L53
    L36:
        ScreenshotResult r11 = r111;
        List<ViewHierarchyDump> r112 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L53
        ScreenshotResult r113 = r11;
    L38:
        Long r9 = r6.e();     // Catch: Exception -> L22 CancellationException -> L53
        r0.f27716a = r6;     // Catch: Exception -> L22 CancellationException -> L53
        r0.f27717b = null;     // Catch: Exception -> L22 CancellationException -> L53
        r0.f27718c = null;     // Catch: Exception -> L22 CancellationException -> L53
        r0.f27719d = r7;     // Catch: Exception -> L22 CancellationException -> L53
        r0.g = 2;     // Catch: Exception -> L22 CancellationException -> L53
        r12 = r5.a(r113, r112, r9, r0);     // Catch: Exception -> L22 CancellationException -> L53
        if (r12 != r16) goto L41;
        return r16;
    L41:
        r13 = r6;
    L22:
        e = e;
        r13 = r6;
        goto L51
    L24:
        d.o.a(r12);
        r7 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Exception -> L50 CancellationException -> L53
        r5 = com.obric.autogui.agents.vlm.models.impl.c.c.f27619a;     // Catch: Exception -> L50 CancellationException -> L53
        r113 = r13.g();     // Catch: Exception -> L50 CancellationException -> L53
        au<List<ViewHierarchyDump>> r10 = r13.k();     // Catch: Exception -> L50 CancellationException -> L53
        if (r10 != null) goto L28;
    L37:
        r6 = r13;
        r112 = null;
        goto L38
    L28:
        if (r10.i() == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L37;
        r0.f27716a = r13;     // Catch: Exception -> L50 CancellationException -> L53
        r0.f27717b = r5;     // Catch: Exception -> L50 CancellationException -> L53
        r0.f27718c = r113;     // Catch: Exception -> L50 CancellationException -> L53
        r0.f27719d = r7;     // Catch: Exception -> L50 CancellationException -> L53
        r0.g = 1;     // Catch: Exception -> L50 CancellationException -> L53
        Object r8 = r10.a(r0);     // Catch: Exception -> L50 CancellationException -> L53
        if (r8 != r16) goto L35;
        return r16;
    L35:
        r111 = r113;
        r12 = r8;
        r6 = r13;
    L53:
        e = move-exception;
        throw e;
    L7:
        r0 = new o(this, r15);
        goto L8
    }

    private final c a(com.obric.autogui.agents.vlm.models.impl.a.a r3, com.obric.autogui.agents.vlm.models.impl.c.b r4) {
        com.obric.autogui.agents.vlm.models.impl.a.a r5 = (com.obric.autogui.agents.vlm.models.impl.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.impl.a.a.class, "com.obric.aiagent.plugin");
        if (r5.b() == false) goto L6;
        this.g = r4;
        com.obric.autogui.agents.vlm.models.impl.g r0 = r5.c();
        r0.a(r4);
        this.f = r5;
        Loog.INSTANCE.d(TAG, "Applying the new holder with newStep=" + r0 + '.');
        return new c(r0, null);
    L6:
        Loog.INSTANCE.w(TAG, "Trying to apply an empty holder!");
        throw new IllegalStateException("Trying to apply an empty holder.");
    }

    private final long a(int r4, com.obric.autogui.agents.vlm.models.impl.request.b.a r5) {
        com.obric.autogui.agents.vlm.models.impl.request.b.a r3 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        if (r3.a() != com.obric.autogui.agents.vlm.models.impl.request.b.b.f) goto L5;
    L11:
        long r6 = ((long) (r4 - 1)) * EntityContentProvider.g;
        Loog.INSTANCE.i(TAG, "[MakeStep] - retry after " + r6 + "/ms as last errorType=" + r3.a());
        return r6;
    L5:
        if (r3.a() == com.obric.autogui.agents.vlm.models.impl.request.b.b.f28053d) goto L11;
        if (r3.a() == com.obric.autogui.agents.vlm.models.impl.request.b.b.f28054e) goto L11;
        return 100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    private final Object a(String r29, String r30, C0690d r31, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r32) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, w.class) == false) goto L7;
        w r3 = (w) ZeusTransformUtils.preCheckCast(r1, w.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        w r10 = r3;
        Object r2 = r10.f;
        int r4 = d.c.a.b.a();
        int r5 = r10.h;
        String r11 = "step_id";
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        int r6 = r10.f27762e;
        long r7 = r10.f27761d;
        com.obric.autogui.session.c.a r8 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r10.f27760c, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r9 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r10.f27759b, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r12 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r10.f27758a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14 CancellationException -> L16
        Object r0 = r2;
        r11 = "step_id";
        com.obric.autogui.session.c.a r13 = r8;
    L65:
        com.obric.autogui.agents.vlm.models.impl.request.a.c r14 = (com.obric.autogui.agents.vlm.models.impl.request.a.c) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.request.a.c.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L35
        r13.b("stp_pred", "vlm_request_net", r6);
        long r15 = AOSystemTools.INSTANCE.nowTimeMillis();
        IAutoActionTrackingApi r20 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r16 = new JSONObject();
        r16.put("duration", r15 - r7);
        r16.put("succeed", r14.a());
        r16.put(r11, r9.a());
        com.obric.autogui.session.c.b.a(r16, r12.a());
        d.x r17 = d.x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r20, "request_made", r16, false, false, null, 28, null);
        return r14;
    L35:
        th = th;
        r11 = r11;
        com.obric.autogui.session.c.a r18 = r13;
    L48:
        int r19 = r6;
        Loog.INSTANCE.e(TAG, " - [request] failed (unhandled Throwable): " + th, th);     // Catch: Throwable -> L52
        long r21 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L52
        IAutoActionTrackingApi r110 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L52
        r22.put("duration", r21 - r7);     // Catch: Throwable -> L52
        r22.put("succeed", false);     // Catch: Throwable -> L52
        r22.put(r11, r9.a());     // Catch: Throwable -> L52
        com.obric.autogui.session.c.b.a(r22, r12.a());     // Catch: Throwable -> L52
        d.x r23 = d.x.f38692a;     // Catch: Throwable -> L52
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r110, "request_made", r22, false, false, null, 28, null);     // Catch: Throwable -> L52
        com.obric.autogui.agents.vlm.models.impl.request.a.b r24 = new com.obric.autogui.agents.vlm.models.impl.request.a.b(null, 1, null);     // Catch: Throwable -> L52
        r18.b("stp_pred", "vlm_request_net", r19);
        return r24;
    L52:
        th = th;
        r4 = r19;
    L59:
        r18.b("stp_pred", "vlm_request_net", r4);
        throw th;
    L16:
        e = move-exception;
        throw e;     // Catch: Throwable -> L58
    L14:
        th = th;
        r11 = "step_id";
        r18 = r8;
        goto L48
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r2);
        com.obric.autogui.agents.vlm.b.C0677b r25 = r31.e();
        com.obric.autogui.agents.vlm.models.c.b r26 = r31.f();
        com.obric.autogui.agents.vlm.models.impl.request.a r27 = r31.g();
        JsonObject r111 = r31.h();
        com.obric.autogui.common.a.k r28 = r25.c();
        d.h.b.o.a(r28);
        com.obric.autogui.session.c.a r33 = r26.c();
        long r34 = AOSystemTools.INSTANCE.nowTimeMillis();
        int r35 = r31.d();
        r33.a("stp_pred", "vlm_request_net", r35);
        com.obric.autogui.agents.vlm.models.a r36 = this.f27628d;
        if (r36 == null) goto L61;
        int r112 = r36.b();
        r36.a(r112 + 1);
        d.c.b.a.b.a(r112);
    L61:
        int r37 = ((Number) ZeusTransformUtils.preCheckCast(r28.a().d(), Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L44 CancellationException -> L54
        r10.f27758a = r25;     // Catch: Throwable -> L44 CancellationException -> L54
        r10.f27759b = r26;     // Catch: Throwable -> L44 CancellationException -> L54
        r10.f27760c = r33;     // Catch: Throwable -> L44 CancellationException -> L54
        r10.f27761d = r34;     // Catch: Throwable -> L44 CancellationException -> L54
        r10.f27762e = r35;     // Catch: Throwable -> L44 CancellationException -> L54
        r10.h = 1;     // Catch: Throwable -> L41 CancellationException -> L54
        int r113 = r35;
        com.obric.autogui.session.c.a r210 = r33;
        com.obric.autogui.agents.vlm.models.c.b r211 = r26;
        long r212 = r34;
        com.obric.autogui.agents.vlm.b.C0677b r38 = r25;
        r0 = r27.a(r25, r29, r30, r37, r111, r10);     // Catch: Throwable -> L37 CancellationException -> L39
        if (r0 != r4) goto L31;
        return r4;
    L31:
        r12 = r38;
        r6 = r113;
        r13 = r210;
        r9 = r211;
        r7 = r212;
        goto L65
    L39:
        e = e;
    L57:
        throw e;     // Catch: Throwable -> L58
    L37:
        th = th;
    L46:
        r12 = r38;
        r6 = r113;
        r18 = r210;
        r9 = r211;
        r7 = r212;
        goto L48
    L41:
        th = th;
        r38 = r25;
        r113 = r35;
        r210 = r33;
        r211 = r26;
        r212 = r34;
    L54:
        e = e;
        r113 = r35;
        r210 = r33;
    L44:
        th = th;
        r38 = r25;
        r113 = r35;
        r210 = r33;
        r211 = r26;
        r212 = r34;
    L58:
        th = th;
    L7:
        r3 = new w(this, r1);
        goto L8
    }

    private final f a(Context r2, com.obric.autogui.agents.vlm.models.impl.request.b.a r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.request.b.a r4 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.request.b.b r5 = r4.a();
        switch(g.f27671b[r5.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        int r6 = 100003;
    L16:
        return new f(r6, r4.a(r1));
    L7:
        r6 = 4;
        goto L16
    L8:
        r6 = 104004;
        goto L16
    L9:
        r6 = 101002;
        goto L16
    L10:
        r6 = 6;
        goto L16
    L11:
        r6 = 5;
        goto L16
    L12:
        r6 = 7;
        goto L16
    L13:
        r6 = 2;
        goto L16
    L14:
        r6 = 100001;
        goto L16
    L5:
        throw new d.k();
    }

    @Override // com.obric.autogui.agents.vlm.models.c
    public void a(com.obric.autogui.agents.vlm.b.C0677b r4) {
        d.h.b.o.e(r4, SensitiveType.SESSION);
        Loog.INSTANCE.i(TAG, "stop making step.");
        com.obric.autogui.agents.vlm.models.impl.request.c.a.b.f28069a.a();
        r4.a().h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new ae(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autogui.common.e a(com.obric.autogui.agents.vlm.b.C0677b r6, int r7) {
        long r0 = AOSystemTools.INSTANCE.bootTimeMillis() - r6.k();
        Loog.INSTANCE.d(TAG, " - debug: task execution time = " + r0 + ", maxTime = " + r7);
        if (r0 <= r7) goto L6;
        Loog.INSTANCE.w(TAG, "task execution timeout");
        return com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_task_terminated_executed_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_executed_too_long"), "task execution timeout, executeTime = " + r0 + ", maxTime = " + r7);
    L6:
        return com.obric.autogui.common.e.f29014b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v52 */
    static /* synthetic */ Object a(d r23, com.obric.autogui.agents.vlm.b.C0677b r24, com.obric.autogui.common.a.k r25, com.obric.autogui.agents.vlm.models.c.b r26, boolean r27, d.c.d<? super JsonObject> r28) {
        d r0 = r23;
        boolean r1 = r27;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, q.class) == false) goto L7;
        q r5 = (q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin");
        if ((r5.m & Integer.MIN_VALUE) == 0) goto L7;
        r5.m -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.k;
        Object r6 = d.c.a.b.a();
        String r9 = "ability_desc_list";
        switch(r5.m) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27730e, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27729d, JsonObject.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r8 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r10 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r11 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        Object r12 = r4;
        String r16 = "view_tree";
        d r13 = r11;
        String r14 = "ability_desc_list";
    L225:
        List<ViewHierarchyDump> r15 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L228;
        String r17 = r16;
        r2.add(r17, com.obric.autogui.agents.vlm.models.impl.f.c.f27903a.a(r15));
        d.x r18 = d.x.f38692a;
    L229:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r10.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.s);
        d.x r19 = d.x.f38692a;
        com.obric.autogui.agents.vlm.b.C0677b r110 = r10;
    L231:
        r13.a(r110, r2);
        if (r8.j() == false) goto L234;
        r2.remove(r17);
        r2.remove(r14);
    L234:
        Loog.INSTANCE.i(TAG, "[Make-HP] exit stepId=" + r8.a());
        return r7;
    L228:
        r17 = r16;
        goto L229
    L13:
        r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27730e, JsonObject.class, "com.obric.aiagent.plugin");
        r7 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27729d, JsonObject.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r20 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        r110 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r21 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r13 = r21;
        r16 = "view_tree";
        r14 = "ability_desc_list";
        Object r22 = r6;
        r8 = r20;
    L216:
        if (r8.j() == false) goto L218;
    L230:
        r17 = r16;
        goto L231
    L218:
        if (com.obric.autogui.common.a.d.f28974a.A() == false) goto L230;
        au<List<ViewHierarchyDump>> r29 = r8.k();
        if (r29 == null) goto L230;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r110.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.s);
        r5.f27726a = r13;
        r5.f27727b = r110;
        r5.f27728c = r8;
        r5.f27729d = r7;
        r5.f27730e = r2;
        r5.m = 7;
        r12 = r29.a(r5);
        if (r12 != r22) goto L224;
        return r22;
    L224:
        r10 = r110;
        goto L225
    L14:
        DisplayedAppInfo r30 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r5.f, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        JsonObject r31 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27730e, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r32 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f27729d, JsonObject.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r111 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r112 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r33 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r13 = r33;
        JsonObject r113 = r32;
        r16 = "view_tree";
        r14 = "ability_desc_list";
        r22 = r6;
    L193:
        d.x r34 = d.x.f38692a;
        com.obric.autogui.agents.vlm.models.c.b r35 = r111;
        com.obric.autogui.agents.vlm.b.C0677b r114 = r112;
    L195:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r114.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.q);
        AOOperatingSpace r36 = OperatingSpaceManager.INSTANCE.getActiveSpace();     // Catch: Throwable -> L209
        if (r30 == null) goto L200;
        final ComponentName r37 = r30.getTopActivity();     // Catch: Throwable -> L209
        if (r37 == null) goto L200;
    L201:
        if (r36 == null) goto L203;
        r36.updateRobotsPolicyCache(r37);     // Catch: Throwable -> L209
        d.x r38 = d.x.f38692a;     // Catch: Throwable -> L209
    L203:
        if (r36 == null) goto L206;
        final String r39 = r36.getRobotsProxyPolicy();     // Catch: Throwable -> L209
        if (r39 == null) goto L206;
    L207:
        r31.addProperty("robots_proxy", r39);     // Catch: Throwable -> L209
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$XPjVgI6n4m0alsEwtqgiLCBIBbg(r39, r37), new $$Lambda$d$0DaGMYPYGL0xiXsucq_4GssvqS0(r39, r37));     // Catch: Throwable -> L209
    L211:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r114.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.q);
        r5.f27726a = r13;
        r5.f27727b = r114;
        r5.f27728c = r35;
        r5.f27729d = r113;
        r5.f27730e = r31;
        r5.f = null;
        r5.g = null;
        r5.h = null;
        r5.m = 6;
        if (r13.a(r114, r31, r5) != r22) goto L214;
        return r22;
    L214:
        r2 = r31;
        r8 = r35;
        r110 = r114;
        r7 = r113;
    L206:
        r39 = "{}";
    L200:
        r37 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L209
    L209:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Robots] failed to build robots_proxy hyper param: " + th.getMessage(), th);
        goto L211
    L15:
        int r40 = r5.j;
        boolean r41 = r5.i;
        JsonObject r42 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.h, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r115 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.g, JsonObject.class, "com.obric.aiagent.plugin");
        JsonElement r116 = (JsonElement) ZeusTransformUtils.preCheckCast(r5.f, JsonElement.class, "com.obric.aiagent.plugin");
        List r117 = (List) ZeusTransformUtils.preCheckCast(r5.f27730e, List.class, "com.obric.aiagent.plugin");
        Map<String, Object> r118 = (Map) ZeusTransformUtils.preCheckCast(r5.f27729d, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r43 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r44 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r45 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r16 = "view_tree";
        r9 = "ability_desc_list";
        JsonElement r46 = r116;
        ?? r119 = r40;
        com.obric.autogui.agents.vlm.models.c.b r47 = r43;
        r114 = r44;
        Object r48 = r4;
        r13 = r45;
        boolean r49 = r41;
        r31 = r42;
        JsonObject r50 = r115;
        List r120 = r117;
    L112:
        DoubaoInfoHelper.DoubaoInfo r51 = (DoubaoInfoHelper.DoubaoInfo) ZeusTransformUtils.preCheckCast(r48, DoubaoInfoHelper.DoubaoInfo.class, "com.obric.aiagent.plugin");
        Loog r121 = Loog.INSTANCE;
        Object r122 = r6;
        JsonObject r123 = r50;
        StringBuilder r52 = new StringBuilder().append("[Make-HP] after DoubaoInfoHelper.getInfo stepId=").append(r47.a()).append(", hasInfo=");
        if (r51 == null) goto L115;
        boolean r53 = true;
    L116:
        StringBuilder r54 = r52.append(r53).append(", hasDbDeviceId=");
        if (r51 == null) goto L119;
        String r55 = r51.getDeviceId();
    L120:
        CharSequence r56 = (CharSequence) ZeusTransformUtils.preCheckCast(r55, CharSequence.class, "com.obric.aiagent.plugin");
        if (r56 != null) goto L123;
    L126:
        boolean r57 = true;
    L127:
        StringBuilder r58 = r54.append(!r57).append(", hasDbVersion=");
        if (r51 == null) goto L130;
        String r59 = r51.getUpdateVersionCode();
    L131:
        CharSequence r60 = (CharSequence) ZeusTransformUtils.preCheckCast(r59, CharSequence.class, "com.obric.aiagent.plugin");
        if (r60 != null) goto L134;
    L137:
        boolean r61 = true;
    L138:
        r121.i(TAG, r58.append(!r61).toString());
        if (r51 == null) goto L236;
        r31.addProperty("db_device_id", r51.getDeviceId());
        r31.addProperty("db_update_version_code", r51.getUpdateVersionCode());
        d.x r62 = d.x.f38692a;
    L236:
        d.n.a r63 = d.n.f38560a;     // Catch: Throwable -> L143
        Object r64 = d.n.f(ObricProductSdk.INSTANCE.featureService().appVariant());     // Catch: Throwable -> L143
    L146:
        if (d.n.b(r64) == false) goto L148;
        r64 = null;
    L148:
        r31.addProperty("flow_app_variant", (String) ZeusTransformUtils.preCheckCast(r64, String.class, "com.obric.aiagent.plugin"));
        if (r49 == false) goto L153;
        r14 = r9;
        if (r119 != 0) goto L156;
        r31.add(r14, r46);
    L156:
        Iterator<Map.Entry<String, Object>> r65 = r118.entrySet().iterator();
    L158:
        if (r65.hasNext() == false) goto L175;
        Map.Entry r66 = (Map.Entry) ZeusTransformUtils.preCheckCast(r65.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r67 = (String) ZeusTransformUtils.preCheckCast(r66.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r68 = r66.getValue();
        if (ZeusTransformUtils.instanceOf(r68, Boolean.class) == true) goto L161;
        if (ZeusTransformUtils.instanceOf(r68, Character.class) == true) goto L164;
        if (ZeusTransformUtils.instanceOf(r68, Number.class) == true) goto L167;
        if (ZeusTransformUtils.instanceOf(r68, String.class) == true) goto L170;
        if (ZeusTransformUtils.instanceOf(r68, JsonObject.class) == true) goto L173;
        r31.addProperty(r67, r68.toString());
        goto L158
    L173:
        r31.add(r67, (JsonElement) ZeusTransformUtils.preCheckCast(r68, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L158
    L170:
        r31.addProperty(r67, (String) ZeusTransformUtils.preCheckCast(r68, String.class, "com.obric.aiagent.plugin"));
        goto L158
    L167:
        r31.addProperty(r67, (Number) ZeusTransformUtils.preCheckCast(r68, Number.class, "com.obric.aiagent.plugin"));
        goto L158
    L164:
        r31.addProperty(r67, (Character) ZeusTransformUtils.preCheckCast(r68, Character.class, "com.obric.aiagent.plugin"));
        goto L158
    L161:
        r31.addProperty(r67, (Boolean) ZeusTransformUtils.preCheckCast(r68, Boolean.class, "com.obric.aiagent.plugin"));
        goto L158
    L175:
        r31.addProperty("api_version", (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(9), Number.class, "com.obric.aiagent.plugin"));
        r30 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r30 == null) goto L194;
        ComponentName r69 = r30.getTopActivity();
        if (r69 == null) goto L180;
        String r70 = r69.flattenToString();
    L181:
        r31.addProperty("top_activity", r70);
        ComponentName r71 = r30.getTopActivity();
        if (r71 == null) goto L185;
        String r72 = r71.getPackageName();
        if (r72 == null) goto L185;
    L189:
        r31.addProperty("top_app_package", r72);
        String r73 = r114.a().b();
        Context r74 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r114.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r5.f27726a = r13;
        r5.f27727b = r114;
        com.obric.autogui.agents.vlm.models.c.b r75 = r47;
        r5.f27728c = r75;
        r113 = r123;
        r5.f27729d = r113;
        r5.f27730e = r31;
        r5.f = r30;
        r5.g = null;
        r5.h = null;
        r5.m = 5;
        Object r76 = r13.a(r73, r74, r72, r31, r5);
        r22 = r122;
        if (r76 != r22) goto L192;
        return r22;
    L192:
        r111 = r75;
        r112 = r114;
    L185:
        ComponentName r77 = r30.getRealActivity();
        if (r77 == null) goto L188;
        r72 = r77.getPackageName();
        goto L189
    L188:
        r72 = null;
        goto L189
    L180:
        r70 = null;
        goto L181
    L194:
        r22 = r122;
        r113 = r123;
        r35 = r47;
        goto L195
    L153:
        r14 = r9;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r120, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L156;
        r31.addProperty(r14, com.obric.autogui.util.b.f31495a.a().toJson(r120));
    L143:
        th = move-exception;
        d.n.a r78 = d.n.f38560a;
        r64 = d.n.f(d.o.a(th));
        goto L146
    L134:
        if (r60.length() == 0) goto L137;
        r61 = false;
        goto L138
    L130:
        r59 = null;
        goto L131
    L123:
        if (r56.length() == 0) goto L126;
        r57 = false;
        goto L127
    L119:
        r55 = null;
        goto L120
    L115:
        r53 = false;
        goto L116
    L16:
        boolean r79 = r5.i;
        Map<String, Object> r80 = (Map) ZeusTransformUtils.preCheckCast(r5.g, Map.class, "com.obric.aiagent.plugin");
        List<String[]> r81 = (List) ZeusTransformUtils.preCheckCast(r5.f, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.intent.g r124 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r5.f27730e, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r125 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27729d, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.a.k r126 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r127 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r82 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r16 = "view_tree";
    L52:
        List r83 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        List<String[]> r84 = r81;
    L44:
        com.obric.autogui.agents.vlm.models.c.b r85 = r125;
        com.obric.autogui.agents.vlm.b.C0677b r128 = r127;
        Map<String, Object> r210 = r80;
        r1 = r79;
        r0 = r82;
        com.obric.autogui.agents.vlm.models.omni.intent.g r86 = r124;
        com.obric.autogui.common.a.k r129 = r126;
        Map<String, Object> r130 = r210;
    L54:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r128.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.p);
        Loog.INSTANCE.d(TAG, "supported script ability list: " + r83);
        JsonElement r87 = com.obric.autogui.util.b.f31495a.a().toJsonTree(r84);
        JsonElement r131 = com.obric.autogui.util.b.f31495a.a().toJsonTree(r83);
        if (r1 == false) goto L63;
        com.obric.autogui.agents.vlm.models.omni.j r132 = com.obric.autogui.agents.vlm.models.omni.j.f28421a;
        d.h.b.o.a(r87);
        if (r86 == null) goto L59;
        String r88 = r86.m();
    L61:
        if (r132.a(r87, r88) == false) goto L64;
        boolean r89 = true;
    L65:
        if (r1 == false) goto L73;
        com.obric.autogui.agents.vlm.models.omni.j r133 = com.obric.autogui.agents.vlm.models.omni.j.f28421a;
        d.h.b.o.a(r131);
        if (r86 == null) goto L69;
        String r90 = r86.n();
    L71:
        if (r133.a(r131, r90) == false) goto L74;
        boolean r91 = true;
    L75:
        if (r1 == false) goto L99;
        Loog r134 = Loog.INSTANCE;
        StringBuilder r135 = new StringBuilder().append("[NotifyListTransfer] app_list_omitted=").append(r89).append(", ability_desc_list_omitted=").append(r91).append(", app_list_hash_received=");
        if (r86 == null) goto L79;
        String r136 = r86.m();
    L80:
        CharSequence r92 = (CharSequence) ZeusTransformUtils.preCheckCast(r136, CharSequence.class, "com.obric.aiagent.plugin");
        if (r92 != null) goto L83;
    L86:
        boolean r93 = true;
    L87:
        StringBuilder r94 = r135.append(!r93).append(", ability_desc_list_hash_received=");
        if (r86 == null) goto L90;
        String r95 = r86.n();
    L91:
        CharSequence r96 = (CharSequence) ZeusTransformUtils.preCheckCast(r95, CharSequence.class, "com.obric.aiagent.plugin");
        if (r96 != null) goto L94;
    L97:
        boolean r97 = true;
    L98:
        r134.i(TAG, r94.append(!r97).toString());
    L100:
        JsonObject r98 = new JsonObject();
        if (r1 == false) goto L104;
        if (r89 == true) goto L105;
        r98.add("app_list", r87);
    L105:
        r98.addProperty("device_id", r128.a().R().a());
        r98.addProperty(WsConstants.KEY_APP_VERSION, (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(AOHostAppTools.INSTANCE.getAppVersionCode()), Number.class, "com.obric.aiagent.plugin"));
        r98.addProperty("session_id", r128.b());
        r98.addProperty("model_name", r0.f27626a.a());
        r98.addProperty(IBdInstall.PARAM_APP_NAME, r0.b(r85.g()));
        String r99 = r0.g(r128);
        if (r99 == null) goto L108;
        r98.addProperty("target_app_name", r99);
        d.x r100 = d.x.f38692a;
    L108:
        r98.addProperty("os_devicetime", (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(AOSystemTools.INSTANCE.nowTimeMillis()), Number.class, "com.obric.aiagent.plugin"));
        r98.addProperty("knowledge", "");
        r98.addProperty("use_memory", (Boolean) ZeusTransformUtils.preCheckCast(r129.m().d(), Boolean.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i(TAG, "[Make-HP] before DoubaoInfoHelper.getInfo stepId=" + r85.a());
        DoubaoInfoHelper r101 = DoubaoInfoHelper.INSTANCE;
        Context r102 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r128.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r5.f27726a = r0;
        r5.f27727b = r128;
        r5.f27728c = r85;
        Map<String, Object> r137 = r130;
        r5.f27729d = r137;
        List r103 = r83;
        r5.f27730e = r103;
        r46 = r131;
        r5.f = r46;
        r5.g = r98;
        r5.h = r98;
        r5.i = r1;
        boolean r138 = r91;
        r5.j = r138 ? 1 : 0;
        r5.m = 4;
        Object r104 = r101.getInfo(r102, r5);
        r6 = r6;
        if (r104 != r6) goto L111;
        return r6;
    L111:
        r120 = r103;
        r47 = r85;
        r50 = r98;
        r49 = r1;
        r31 = r50;
        r13 = r0;
        r48 = r104;
        r114 = r128;
        r118 = r137;
        r119 = r138;
        goto L112
    L104:
        r98.addProperty("app_list", com.obric.autogui.util.b.f31495a.a().toJson(r84));
        goto L105
    L94:
        if (d.o.o.d(r96) == true) goto L97;
        r97 = false;
        goto L98
    L90:
        r95 = null;
        goto L91
    L83:
        if (d.o.o.d(r92) == true) goto L86;
        r93 = false;
        goto L87
    L79:
        r136 = null;
        goto L80
    L99:
        r91 = r91;
    L74:
        r91 = false;
        goto L75
    L69:
        r90 = null;
        goto L71
    L73:
        r83 = r83;
    L64:
        r89 = false;
        goto L65
    L59:
        r88 = null;
        goto L61
    L63:
        r6 = r6;
        goto L64
    L17:
        r79 = r5.i;
        r80 = (Map) ZeusTransformUtils.preCheckCast(r5.g, Map.class, "com.obric.aiagent.plugin");
        r81 = (List) ZeusTransformUtils.preCheckCast(r5.f, List.class, "com.obric.aiagent.plugin");
        r124 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r5.f27730e, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        r125 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27729d, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        r126 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        r127 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        r82 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r16 = "view_tree";
    L40:
        List r105 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r105 == null) goto L46;
        r83 = r105;
        r84 = r81;
        r9 = "ability_desc_list";
    L46:
        IJSScriptService r106 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
        if (r106 == null) goto L53;
        Context r107 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r127.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Set<String> r139 = r127.n();
        String r108 = r127.a().b();
        r5.f27726a = r82;
        r5.f27727b = r127;
        r5.f27728c = r126;
        r5.f27729d = r125;
        r5.f27730e = r124;
        r5.f = r81;
        r5.g = r80;
        r5.i = r79;
        boolean r140 = r79;
        r5.m = 3;
        r4 = r106.getSupportedAbilityList(r107, r139, r108, r5);
        if (r4 != r6) goto L51;
        return r6;
    L51:
        r79 = r140;
        goto L52
    L53:
        boolean r141 = r79;
        r9 = "ability_desc_list";
        r83 = d.a.p.b();
        r0 = r82;
        r84 = r81;
        r86 = r124;
        r85 = r125;
        r129 = r126;
        r128 = r127;
        r130 = r80;
        r1 = r141;
        goto L54
    L18:
        boolean r109 = r5.i;
        com.obric.autogui.agents.vlm.models.omni.intent.g r142 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r5.f27730e, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        r85 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27729d, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        r129 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r5.f27728c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        r128 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27727b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r143 = (d) ZeusTransformUtils.preCheckCast(r5.f27726a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r1 = r109;
        r0 = r143;
        r86 = r142;
    L31:
        r84 = ((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).b();
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r128.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.n);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r128.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.o);
        r130 = com.obric.autogui.util.d.f31513a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r128.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(null);
        r16 = "view_tree";
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r128.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.o);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r128.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.p);
        if (r85.j() == false) goto L34;
        r83 = d.a.p.b();
        r9 = "ability_desc_list";
        goto L54
    L34:
        com.obric.autogui.session.d.k r144 = r128.a().k().d();
        if (r144 == null) goto L45;
        r5.f27726a = r0;
        r5.f27727b = r128;
        r5.f27728c = r129;
        r5.f27729d = r85;
        r5.f27730e = r86;
        r5.f = r84;
        r5.g = r130;
        r5.i = r1;
        r5.m = 2;
        Object r145 = r144.a(r5);
        if (r145 != r6) goto L39;
        return r6;
    L39:
        r127 = r128;
        r125 = r85;
        r81 = r84;
        r4 = r145;
        com.obric.autogui.agents.vlm.models.omni.intent.g r211 = r86;
        r82 = r0;
        r79 = r1;
        r80 = r130;
        r126 = r129;
        r124 = r211;
        goto L40
    L45:
        r127 = r128;
        r125 = r85;
        r81 = r84;
        com.obric.autogui.agents.vlm.models.omni.intent.g r212 = r86;
        r82 = r0;
        r79 = r1;
        r80 = r130;
        r126 = r129;
        r124 = r212;
        goto L46
    L19:
        d.o.a(r4);
        Loog.INSTANCE.i(TAG, "[Make-HP] enter stepId=" + r26.a() + ", session=" + r24.b());
        if (r1 == false) goto L26;
        com.obric.autogui.agents.vlm.models.omni.r r146 = com.obric.autogui.agents.vlm.models.omni.t.f28523a.a(r24.b());
        if (r146 == null) goto L26;
        com.obric.autogui.agents.vlm.models.omni.l r147 = r146.e();
        if (r147 == null) goto L26;
        r86 = r147.a();
    L27:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r24.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.n);
        com.obric.autogui.agents.vlm.models.impl.applist.b r148 = new com.obric.autogui.agents.vlm.models.impl.applist.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r5.f27726a = r0;
        r5.f27727b = r24;
        r129 = r25;
        r5.f27728c = r129;
        r5.f27729d = r26;
        r5.f27730e = r86;
        r5.i = r1;
        r5.m = 1;
        r4 = r148.a(r5);
        if (r4 != r6) goto L30;
        return r6;
    L30:
        r128 = r24;
        r85 = r26;
    L26:
        r86 = null;
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new q(r0, r3);
        goto L8
    }

    private static final String a(String r2, ComponentName r3) {
        return "[Robots] robots_proxy=" + r2 + ", top=" + r3;
    }

    private static final String b(String r2, ComponentName r3) {
        return "[Robots] robots_proxy_len=" + r2.length() + ", top=" + r3;
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r7, JsonObject r8, d.c.d<? super d.x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, l.class) == false) goto L7;
        l r0 = (l) ZeusTransformUtils.preCheckCast(r10, l.class, "com.obric.aiagent.plugin");
        if ((r0.f27706e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27706e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f27704c;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f27706e;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        r8 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.f27703b, JsonObject.class, "com.obric.aiagent.plugin");
        r7 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r0.f27702a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L14 CancellationException -> L16
    L30:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
        if (r12 != null) goto L33;
    L38:
        d.x r13 = d.x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r7.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.r);
        return r13;
    L33:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L36;
        r12 = null;
    L36:
        if (r12 == null) goto L38;
        r8.addProperty("saep_packages", r12);     // Catch: Throwable -> L14 CancellationException -> L16
        Loog.INSTANCE.d(TAG, "[SAEP] add saep_packages hyper param, length=" + r12.length());     // Catch: Throwable -> L14 CancellationException -> L16
    L42:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r7.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.r);
        return d.x.f38692a;
    L45:
        th = move-exception;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r7.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.r);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r6);
        if (com.obric.autogui.common.a.d.f28974a.B() == false) goto L23;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r7.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.r);
        com.obric.autogui.session.d.j r14 = r7.a().k().e();     // Catch: Throwable -> L14 CancellationException -> L16
        if (r14 == null) goto L38;
        r0.f27702a = r7;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f27703b = r8;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f27706e = 1;     // Catch: Throwable -> L14 CancellationException -> L16
        r6 = r14.a(r0);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r6 != r11) goto L30;
        return r11;
    L23:
        return d.x.f38692a;
    L16:
        e = move-exception;
        throw e;     // Catch: Throwable -> L45
    L14:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SAEP] failed to add saep_packages hyper param: " + th.getMessage(), th);     // Catch: Throwable -> L45
    L7:
        r0 = new l(this, r10);
        goto L8
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r8, JsonObject r9) {
        Bundle r10 = r8.a().l().getTaskExtras();
        if (r10 == null) goto L5;
        Bundle r11 = r10.getBundle("custom_hp");
    L6:
        if (r11 == null) goto L31;
        Loog.INSTANCE.d(TAG, "[Make-HP] - custom-hp size=" + r11.size());
        Iterator<String> r0 = r11.keySet().iterator();     // Catch: Throwable -> L21
    L9:
        if (r0.hasNext() == false) goto L32;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r3 = r11.get(r1);     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L15;
        r9.addProperty(r1, (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L19:
        Loog.INSTANCE.d(TAG, "[Make-HP] - added custom hp: `" + r1 + "` --> " + r3);     // Catch: Throwable -> L21
        goto L9
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L17;
        r9.addProperty(r1, (Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        goto L19
    L17:
        if (r3 == null) goto L19;
        r9.addProperty(r1, r3.toString());     // Catch: Throwable -> L21
        goto L19
    L32:
        return;
    L21:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Make-HP] - failed to add custom-hp: " + th, th);
        return;
    L31:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public String b(com.obric.autogui.agents.vlm.b.C0677b r1) {
        d.h.b.o.e(r1, SensitiveType.SESSION);
        return r1.p();
    }

    static /* synthetic */ Object a(d r23, com.obric.autogui.agents.vlm.b.C0677b r24, com.obric.autogui.common.a.k r25, com.obric.autogui.agents.vlm.models.c.b r26, d.c.d<? super com.obric.autogui.common.d<JsonObject>> r27) {
        d r0 = r23;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, r.class) == false) goto L7;
        r r2 = (r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.aiagent.plugin");
        if ((r2.k & Integer.MIN_VALUE) == 0) goto L7;
        r2.k -= Integer.MIN_VALUE;
    L8:
        r r6 = r2;
        Object r3 = r6.i;
        Object r8 = d.c.a.b.a();
        int r4 = r6.k;
        String r11 = TAG;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r6.h;
        boolean r7 = r6.g;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.f, String.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.f27735e, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r12 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r6.f27734d, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.c.b r13 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r6.f27733c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r14 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r6.f27732b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d r15 = (d) ZeusTransformUtils.preCheckCast(r6.f27731a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14
        boolean r16 = r7;
        r0 = r15;
        com.obric.autogui.session.c.a r17 = r12;
    L26:
        JsonObject r18 = (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        long r19 = System.currentTimeMillis() - r5;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L30;
        Loog.INSTANCE.d(r10, r9 + " cost: " + r19 + "ms");
    L30:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r14.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.m);
        Loog.INSTANCE.i(TAG, "[MakeRequestBody] after makeHyperParams stepId=" + r13.a());
        JsonObject r20 = new JsonObject();
        r20.addProperty(Params.PROMPT, r0.b(r14));
        r20.addProperty("session_id", r14.b());
        r20.addProperty("session_origin", (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(r14.a().l().getLaunchOrigin()), Number.class, "com.obric.aiagent.plugin"));
        r20.addProperty("model_name", r0.f27626a.a());
        if (r16 == false) goto L33;
        r20.add("hyper_params", (JsonElement) ZeusTransformUtils.preCheckCast(r18, JsonElement.class, "com.obric.aiagent.plugin"));
    L34:
        r20.addProperty("package_name", r0.g());
        com.obric.autogui.session.c.a.b(r17, "stp_pred", "vlm_hyperparams", 0, 4, null);
        Loog.INSTANCE.i(TAG, "[MakeRequestBody] exit success stepId=" + r13.a());     // Catch: Throwable -> L37
        com.obric.autogui.common.d r21 = com.obric.autogui.common.d.f29012a.a(r20);     // Catch: Throwable -> L37
    L39:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r14.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.l);
        return r21;
    L37:
        th = move-exception;
        Loog.INSTANCE.i(TAG, "[MakeRequestBody] exit failed stepId=" + r13.a() + ", error=" + th.getClass().getSimpleName());
        r21 = com.obric.autogui.common.d.f29012a.a("failed to make request body: " + th);
        goto L39
    L33:
        r20.addProperty("hyper_params", r18.toString());
    L14:
        th = th;
        r11 = r10;
    L43:
        long r22 = System.currentTimeMillis() - r5;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L46;
        Loog.INSTANCE.d(r11, r9 + " cost: " + r22 + "ms");
    L46:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r24.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.l);
        Loog.INSTANCE.i(TAG, "[MakeRequestBody] enter stepId=" + r26.a() + ", stepNum=" + r26.b());
        com.obric.autogui.session.c.a r28 = r26.c();
        boolean r29 = com.obric.autogui.agents.vlm.models.omni.k.f28422a.a(r24.b());
        com.obric.autogui.session.c.a.a(r28, "stp_pred", "vlm_hyperparams", 0, 4, null);
        Loog.INSTANCE.i(TAG, "[MakeRequestBody] before makeHyperParams stepId=" + r26.a());
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r24.a().b(), com.obric.autogui.agents.vlm.models.omni.b.c.m);
        long r110 = System.currentTimeMillis();
        if (r29 == false) goto L21;
        boolean r111 = true;
    L49:
        r6.f27731a = r0;     // Catch: Throwable -> L41
        r6.f27732b = r24;     // Catch: Throwable -> L41
        r6.f27733c = r26;     // Catch: Throwable -> L41
        r6.f27734d = r28;     // Catch: Throwable -> L41
        r6.f27735e = TAG;     // Catch: Throwable -> L41
        r6.f = "makeHyperParams";     // Catch: Throwable -> L41
        r6.g = r29;     // Catch: Throwable -> L41
        r6.h = r110;     // Catch: Throwable -> L41
        r6.k = 1;     // Catch: Throwable -> L41
        r16 = r29;
        r17 = r28;
        r3 = r23.a(r24, r25, r26, r111, r6);     // Catch: Throwable -> L41
        if (r3 != r8) goto L25;
        return r8;
    L25:
        r10 = TAG;
        r9 = "makeHyperParams";
        r5 = r110;
        r14 = r24;
        r13 = r26;
    L41:
        th = th;
        r9 = "makeHyperParams";
        r5 = r110;
        goto L43
    L21:
        r111 = false;
    L7:
        r2 = new r(r0, r1);
        goto L8
    }

    private final String g(com.obric.autogui.agents.vlm.b.C0677b r8) {
        com.obric.autogui.operator.e r7 = f(r8);
        if (r7 == null) goto L40;
        Collection<com.obric.autogui.operator.e.C0780e> r9 = r7.Q();
        if (r9 == null) goto L41;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        Object r0 = null;
    L7:
        boolean r3 = true;
        if (r10.hasNext() == false) goto L15;
        Object r2 = r10.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() == com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L7;
        r0 = r2;
        goto L7
    L15:
        com.obric.autogui.operator.e.C0780e r11 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L42;
        com.obric.autogui.operator.b.a r12 = r11.b();
        if (r12 != null) goto L20;
        return null;
    L20:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L22;
        com.obric.autogui.operator.a.b.a.a.b r13 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L23:
        if (r13 == null) goto L44;
        String r14 = r13.c();
        if (r14 == null) goto L45;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r15 != null) goto L29;
        return null;
    L29:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L32;
        r3 = false;
    L32:
        if (r3 == true) goto L34;
        return null;
    L34:
        return r15;
    L45:
        return null;
    L44:
        return null;
    L22:
        r13 = null;
        goto L23
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    }

    private final Object a(String r11, Context r12, String r13, JsonObject r14, d.c.d<? super d.x> r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, m.class) == false) goto L7;
        m r17 = (m) ZeusTransformUtils.preCheckCast(r16, m.class, "com.obric.aiagent.plugin");
        if ((r17.f27710d & Integer.MIN_VALUE) == 0) goto L7;
        r17.f27710d -= Integer.MIN_VALUE;
    L8:
        Object r18 = r17.f27708b;
        Object r0 = d.c.a.b.a();
        int r2 = r17.f27710d;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        r13 = (String) ZeusTransformUtils.preCheckCast(r17.f27707a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Throwable -> L14
    L45:
    L44:
        return d.x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r18);
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == true) goto L27;
        d.n.a r111 = d.n.f38560a;     // Catch: Throwable -> L30
        d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Object r112 = d.n.f(d.c.b.a.b.a(ObricProductSdk.INSTANCE.featureService().isObricOs()));     // Catch: Throwable -> L30
    L32:
        Boolean r113 = d.c.b.a.b.a(false);
        if (d.n.b(r112) == false) goto L36;
        r112 = r113;
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r112, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L39;
        Loog.INSTANCE.i(TAG, "[AntiFraud] skip upload in ObricOs: " + r13);
        return d.x.f38692a;
    L39:
        d.c.g r114 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        d.h.a.m r115 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r3, r13, r11, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r17.f27707a = r13;     // Catch: Throwable -> L14
        r17.f27710d = 1;     // Catch: Throwable -> L14
        if (kotlinx.coroutines.i.a(r114, r115, r17) != r0) goto L45;
        return r0;
    L30:
        th = move-exception;
        d.n.a r116 = d.n.f38560a;
        r112 = d.n.f(d.o.a(th));
        goto L32
    L27:
        return d.x.f38692a;
    L21:
        if (r19.length() == 0) goto L24;
        r110 = false;
    L14:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[AntiFraud] failed to append params for " + r13 + ": " + th.getMessage(), th);
    L7:
        r17 = new m(this, r16);
        goto L8
    }

    private final String h() {
        String r4 = g();
        AppInfoEntry r5 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        if (r5 == null) goto L6;
        final CharSequence r6 = r5.getAppLabel();
        if (r6 == null) goto L6;
    L7:
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$FzDJgcfjNXumvQdKRGVpXhqY4yI(r6));
        return r6.toString();
    L6:
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private static final String a(CharSequence r2) {
        return "getTrackingAppName, appName: " + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final String b(ScreenshotResult r4) {
        if (r4 == null) goto L6;
        ComponentName r5 = r4.getTopComponent();
        if (r5 == null) goto L6;
        final String r6 = r5.getPackageName();
    L7:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        AppInfoEntry r3 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        if (r3 == null) goto L21;
        final CharSequence r7 = r3.getAppLabel();
        if (r7 == null) goto L21;
    L22:
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$PSHyJUDL33oQZrBJUfPlmCZIuc(r6, r7));
        return r7.toString();
    L21:
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        goto L22
    L16:
        return h();
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
    L6:
        r6 = null;
        goto L7
    }

    private static final String a(String r2, CharSequence r3) {
        return "getAppNameFromScreenshot, pkg=" + r2 + ", appName=" + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autogui.agents.vlm.models.impl.d.b.a a(C0690d r4, JsonObject r5) {
        Loog.INSTANCE.d(TAG, "response: " + r5);
        return ((com.obric.autogui.agents.vlm.models.impl.d.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.d.c(b()), com.obric.autogui.agents.vlm.models.impl.d.b.class, "com.obric.aiagent.plugin")).a(r4, r5);
    }

    public com.obric.autogui.agents.vlm.models.impl.d.b b() {
        return (com.obric.autogui.agents.vlm.models.impl.d.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.d.f(), com.obric.autogui.agents.vlm.models.impl.d.b.class, "com.obric.aiagent.plugin");
    }

    public com.obric.autogui.agents.vlm.models.impl.a.a a(String r3, com.obric.autogui.agents.vlm.models.impl.d.b.a r4) {
        com.obric.autogui.agents.vlm.models.impl.d.b.a r2 = (com.obric.autogui.agents.vlm.models.impl.d.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.d.b.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "forRequestId");
        d.h.b.o.e(r2, "forResult");
        if (r2.c() != 1) goto L6;
        return (com.obric.autogui.agents.vlm.models.impl.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.a.c(r3, r2.e()), com.obric.autogui.agents.vlm.models.impl.a.a.class, "com.obric.aiagent.plugin");
    L6:
        return (com.obric.autogui.agents.vlm.models.impl.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.a.b(r3, r2), com.obric.autogui.agents.vlm.models.impl.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.c
    public void a() {
        e();
        com.obric.autogui.agents.vlm.models.impl.a.a r0 = this.f;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.f = null;
        this.g = null;
    }

    static /* synthetic */ Object a(d r8, String r9, AOOperatingSpace r10, boolean r11, boolean r12, d.c.d<? super ScreenshotResult> r13) {
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r10, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super ScreenshotResult> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.a.a r14 = r8.f27627c;
        if (r14 != null) goto L6;
        d.h.b.o.c("mScreenshotProvider");
        r14 = null;
    L6:
        return r14.a(r9, r4, r11, r12, r7);
    }

    static /* synthetic */ Object a(d r2, String r3, ScreenshotConfig r4, boolean r5, d.c.d<? super ScreenshotResult> r6) {
        d.c.d<? super ScreenshotResult> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.a.a r8 = r2.f27627c;
        if (r8 != null) goto L6;
        d.h.b.o.c("mScreenshotProvider");
        r8 = null;
    L6:
        return r8.a(r3, r4, r5, r7);
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public IScreenshot a(String r2) {
        d.h.b.o.e(r2, DbHelper.COL_ID);
        com.obric.autogui.agents.vlm.models.a.a r1 = this.f27627c;
        if (r1 != null) goto L6;
        d.h.b.o.c("mScreenshotProvider");
        r1 = null;
    L6:
        return r1.a(r2);
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public void e() {
        com.obric.autogui.agents.vlm.models.a.a r0 = this.f27627c;
        if (r0 != null) goto L5;
        d.h.b.o.c("mScreenshotProvider");
        r0 = null;
    L5:
        r0.e();
    }

    private final String g() {
        IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionVDListener.class), IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        String r4 = r3.getTrackingAppPkgName();
    L6:
        Loog.INSTANCE.d(TAG, "getTrackingAppPkgName, pkgName: " + r4);
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        r4 = null;
        goto L6
    }
}
