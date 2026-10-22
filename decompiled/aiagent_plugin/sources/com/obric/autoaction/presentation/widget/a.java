package com.obric.autoaction.presentation.widget;

import android.os.Bundle;
import androidx.lifecycle.aj;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends aj {
    private static final String TAG = "AITaskWidgetViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0603a f25123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<com.obric.autoaction.presentation.a> f25124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ak<com.obric.autoaction.presentation.a> f25125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autoaction.d.b.a.f f25126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.d.b.a.g f25127e;
    private final com.obric.autoaction.d.b.a.a f;
    private final com.obric.autoaction.d.b.a.e g;
    private final com.obric.autoaction.d.b.a.c h;
    private final com.obric.autoaction.d.b.a.b i;
    private final com.obric.autoaction.d.b.a.d j;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    public static final class C0603a {
        public /* synthetic */ C0603a(d.h.b.h r1) {
            this();
        }

        private C0603a() {
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {74}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$cancelTask$1")
    static final class b extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25129b;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25129b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f25129b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25128a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.c(this.f25129b).a();
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25130a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25128a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {87}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$enterCallUser$1")
    static final class c extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25132b;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25132b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25132b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25131a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.d(this.f25132b).a();
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25133a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25131a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {112}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$enterUserAddition$1")
    static final class d extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25135b;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25135b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f25135b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25134a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.f(this.f25135b).a();
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25136a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25134a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {99}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$exitCallUser$1")
    static final class e extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25138b;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25138b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f25138b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25137a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.e(this.f25138b).a();
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25139a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25137a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {139}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$exitUserAddition$1")
    static final class f extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f25142c;

        f(a r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25141b = r3;
            this.f25142c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f25141b, this.f25142c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25140a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.h(this.f25141b).a(this.f25142c);
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25143a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25140a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {125}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$exitUserClarify$1")
    static final class g extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f25146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25147d;

        g(a r3, String r4, String r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25145b = r3;
            this.f25146c = r4;
            this.f25147d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f25145b, this.f25146c, this.f25147d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25144a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r7 = a.g(this.f25145b).a(this.f25146c, this.f25147d);
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25148a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25144a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AITaskWidgetViewModel.kt */
    @d.c.b.a.f(b = "AITaskWidgetViewModel.kt", c = {49}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.widget.AITaskWidgetViewModel$startAITask$1")
    static final class h extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f25151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f25152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f25153e;
        final /* synthetic */ Bundle f;

        h(a r3, String r4, boolean r5, int r6, Bundle r7, d.c.d<? super h> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25150b = r3;
            this.f25151c = r4;
            this.f25152d = r5;
            this.f25153e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f25150b, this.f25151c, this.f25152d, this.f25153e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25149a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            kotlinx.coroutines.b.h<n<com.obric.autogui.common.e>> r9 = a.a(this.f25150b).a(new com.obric.autoaction.d.a.a(this.f25151c, this.f25152d, this.f25153e, this.f));
            final a r3 = this.f25150b;
            i<? super n<com.obric.autogui.common.e>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25149a = 1;
            if (r9.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        f25123a = new C0603a(null);
    }

    public a() {
        x<com.obric.autoaction.presentation.a> r0 = kotlinx.coroutines.b.am.a(com.obric.autoaction.presentation.a.c.f24807a);
        this.f25124b = r0;
        this.f25125c = j.a(r0);
        this.f25126d = new com.obric.autoaction.d.b.a.f();
        this.f25127e = new com.obric.autoaction.d.b.a.g();
        this.f = new com.obric.autoaction.d.b.a.a();
        this.g = new com.obric.autoaction.d.b.a.e();
        this.h = new com.obric.autoaction.d.b.a.c();
        this.i = new com.obric.autoaction.d.b.a.b();
        this.j = new com.obric.autoaction.d.b.a.d();
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.f a(a r0) {
        return r0.f25126d;
    }

    public static final /* synthetic */ x b(a r0) {
        return r0.f25124b;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.g c(a r0) {
        return r0.f25127e;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.a d(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.e e(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.b f(a r0) {
        return r0.i;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.d g(a r0) {
        return r0.j;
    }

    public static final /* synthetic */ com.obric.autoaction.d.b.a.c h(a r0) {
        return r0.h;
    }

    public final void a(String r12, boolean r13, int r14, Bundle r15) {
        d.h.b.o.e(r12, DownloadConstants.QUERY_KEY);
        Loog.INSTANCE.d(TAG, "startAITask");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new h(this, r12, r13, r14, r15, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b() {
        Loog.INSTANCE.d(TAG, "cancelTask");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void c() {
        Loog.INSTANCE.d(TAG, "enterCallUser");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void e() {
        Loog.INSTANCE.d(TAG, "exitCallUser");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void f() {
        Loog.INSTANCE.d(TAG, "enterUserAdditon");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = DownloadSettingKeys.BugFix.DEFAULT;
    L5:
        r0.a(r1, r2);
    }

    public final void a(String r10, String r11) {
        d.h.b.o.e(r10, "userResponse");
        Loog.INSTANCE.d(TAG, "exitUserClarify");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new g(this, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r10) {
        d.h.b.o.e(r10, "userAddition");
        Loog.INSTANCE.d(TAG, "exitUserAddition");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
