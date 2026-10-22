package com.obric.appstore.analytics;

import android.content.pm.PackageManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.StoreBaseApplication;
import com.obric.appstore.network.entity.SysAppAutoUpdateReportReq;
import com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics;
import com.smt.obric.appstore.domain.app.db.SysAppAutoUpdateTaskInfoDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.b;
import kotlin.c;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SysAppAutoUpdateAnalyticsImpl implements SysAppAutoUpdateAnalytics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SysAppAutoUpdateAnalyticsImpl f10521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f10522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f10523c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f10524d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f10525e = null;

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadFailed$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadFailed$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        final /* synthetic */ String $reason;
        int label;

        public AnonymousClass1(String r10, String r11, Continuation<? super AnonymousClass1> r12) {
            this.$pkg = r10;
            this.$reason = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new AnonymousClass1(this.$pkg, this.$reason, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 4, this.$reason));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadStart$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04361 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        int label;

        public C04361(String r10, Continuation<? super C04361> r11) {
            this.$pkg = r10;
            super(1, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04361(this.$pkg, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 2, ""));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04361) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onDownloadSuccess$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04371 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        int label;

        public C04371(String r10, Continuation<? super C04371> r11) {
            this.$pkg = r10;
            super(1, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04371(this.$pkg, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 3, ""));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04371) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {60, 63}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSysAppAutoUpdateAnalytics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppAutoUpdateAnalytics.kt\ncom/obric/appstore/analytics/SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,190:1\n1549#2:191\n1620#2,3:192\n1855#2,2:195\n*S KotlinDebug\n*F\n+ 1 SysAppAutoUpdateAnalytics.kt\ncom/obric/appstore/analytics/SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1\n*L\n53#1:191\n53#1:192,3\n60#1:195,2\n*E\n"})
    public static final class C04381 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AppInfo> $apps;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3", f = "SysAppAutoUpdateAnalytics.kt", i = {0, 0}, l = {66, 72}, m = "invokeSuspend", n = {"$this$coroutineScope", "destination$iv$iv"}, s = {"L$0", "L$1"})
        @SourceDebugExtension({"SMAP\nSysAppAutoUpdateAnalytics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppAutoUpdateAnalytics.kt\ncom/obric/appstore/analytics/SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,190:1\n1603#2,9:191\n1855#2:200\n1856#2:202\n1612#2:203\n1549#2:204\n1620#2,3:205\n1549#2:208\n1620#2,3:209\n1#3:201\n*S KotlinDebug\n*F\n+ 1 SysAppAutoUpdateAnalytics.kt\ncom/obric/appstore/analytics/SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3\n*L\n65#1:191,9\n65#1:200\n65#1:202\n65#1:203\n69#1:204\n69#1:205,3\n71#1:208\n71#1:209,3\n65#1:201\n*E\n"})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<AppInfo> $apps;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass3(List<? extends AppInfo> r10, Continuation<? super AnonymousClass3> r11) {
                this.$apps = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                AnonymousClass3 r12 = new AnonymousClass3(this.$apps, r11);
                r12.L$0 = r10;
                return r12;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0052 -> B:21:0x006b). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0064 -> B:20:0x0067). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r14) {
                Object r10 = a.d();
                int r11 = this.label;
                if (r11 == 0) goto L10;
                if (r11 == 1) goto L9;
                if (r11 != 2) goto L8;
                c.b(r14);
            L35:
                return Unit.f21064a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                Iterator r12 = (Iterator) this.L$2;
                Collection r13 = (Collection) this.L$1;
                CoroutineScope r15 = (CoroutineScope) this.L$0;
                c.b(r14);
            L20:
                he.c r16 = (he.c) r14;
                CoroutineScope r17 = r15;
            L21:
                if (r16 != null) goto L22;
            L11:
                r16 = null;
                if (r12.hasNext() == false) goto L23;
                AppInfo r18 = (AppInfo) r12.next();
                SysAppAutoUpdateTaskInfoDao r19 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
                String r20 = r18.appPackageName;
                if (r20 == null) goto L21;
                this.L$0 = r17;
                this.L$1 = r13;
                this.L$2 = r12;
                this.label = 1;
                Object r21 = r19.getByPkg(r20, this);
                if (r21 != r10) goto L19;
                return r10;
            L19:
                r15 = r17;
                r14 = r21;
                goto L20
            L23:
                List r22 = (List) r13;
                ArrayList r23 = new ArrayList(u.r(r22, 10));
                Iterator r24 = r22.iterator();
            L25:
                if (r24.hasNext() == false) goto L27;
                he.c r25 = (he.c) r24.next();
                r23.add(SysAppAutoUpdateAnalyticsImpl.a(SysAppAutoUpdateAnalyticsImpl.f10521a, r25, 1, ""));
                goto L25
            L27:
                ArrayList r26 = new ArrayList(u.r(r23, 10));
                Iterator r27 = r23.iterator();
            L29:
                if (r27.hasNext() == false) goto L31;
                CoroutineScope r28 = r17;
                r26.add(h.b(r28, null, null, new SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1((SysAppAutoUpdateReportReq) r27.next(), null), 3, null));
                goto L29
            L31:
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (AwaitKt.a(r26, this) != r10) goto L35;
                return r10;
            L22:
                r13.add(r16);
                goto L11
            L10:
                c.b(r14);
                r17 = (CoroutineScope) this.L$0;
                List<AppInfo> r29 = this.$apps;
                r13 = new ArrayList();
                r12 = r29.iterator();
                goto L11
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C04381(List<? extends AppInfo> r10, Continuation<? super C04381> r11) {
            this.$apps = r10;
            super(1, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04381(this.$apps, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            c.b(r10);
        L36:
            return Unit.f21064a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator r13 = (Iterator) this.L$0;
            c.b(r10);
        L28:
            if (r13.hasNext() == false) goto L32;
            he.c r14 = (he.c) r13.next();
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            this.L$0 = r13;
            this.label = 1;
            if (r15.upsert(r14, this) != r11) goto L28;
            return r11;
        L32:
            AnonymousClass3 r16 = new AnonymousClass3(this.$apps, null);
            this.L$0 = null;
            this.label = 2;
            if (d0.e(r16, this) != r11) goto L36;
            return r11;
        L10:
            c.b(r10);
            List<AppInfo> r17 = this.$apps;
            ArrayList r18 = new ArrayList(u.r(r17, 10));
            Iterator<T> r19 = r17.iterator();
        L12:
            if (r19.hasNext() == false) goto L26;
            AppInfo r20 = (AppInfo) r19.next();
            SysAppAutoUpdateAnalyticsImpl r21 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            Result.a r22 = Result.Companion;     // Catch: Throwable -> L16
            Object r23 = Result.m35constructorimpl(tf.a.d(SysAppAutoUpdateAnalyticsImpl.c(r21).getPackageInfo(r20.appPackageName, 0).getLongVersionCode()));     // Catch: Throwable -> L16
        L19:
            if (Result.m41isFailureimpl(r23) == false) goto L21;
            r23 = null;
        L21:
            Long r24 = (Long) r23;
            if (r24 == null) goto L24;
            long r25 = r24.longValue();
        L25:
            r18.add(SysAppAutoUpdateAnalyticsImpl.f(SysAppAutoUpdateAnalyticsImpl.f10521a, r20, r25));
            goto L12
        L24:
            r25 = 0;
        L16:
            th = move-exception;
            Result.a r26 = Result.Companion;
            r23 = Result.m35constructorimpl(c.a(th));
            goto L19
        L26:
            r13 = r18.iterator();
            goto L28
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04381) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallFailed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallFailed$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04391 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        final /* synthetic */ String $reason;
        int label;

        public C04391(String r10, String r11, Continuation<? super C04391> r12) {
            this.$pkg = r10;
            this.$reason = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04391(this.$pkg, this.$reason, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 7, this.$reason));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04391) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallStart$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04401 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        int label;

        public C04401(String r10, Continuation<? super C04401> r11) {
            this.$pkg = r10;
            super(1, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04401(this.$pkg, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 5, ""));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04401) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallSucc$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onInstallSucc$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04411 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pkg;
        int label;

        public C04411(String r10, Continuation<? super C04411> r11) {
            this.$pkg = r10;
            super(1, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new C04411(this.$pkg, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            he.c r13 = (he.c) r10;
            if (r13 == null) goto L14;
            SysAppAutoUpdateAnalyticsImpl r14 = SysAppAutoUpdateAnalyticsImpl.f10521a;
            SysAppAutoUpdateAnalyticsImpl.e(r14, SysAppAutoUpdateAnalyticsImpl.a(r14, r13, 6, ""));
            return Unit.f21064a;
        L14:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SysAppAutoUpdateTaskInfoDao r15 = SysAppAutoUpdateAnalyticsImpl.d(SysAppAutoUpdateAnalyticsImpl.f10521a);
            String r16 = this.$pkg;
            this.label = 1;
            r10 = r15.getByPkg(r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((C04411) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f10521a = new SysAppAutoUpdateAnalyticsImpl();
        f10522b = b.b(SysAppAutoUpdateAnalyticsImpl$context$2.INSTANCE);
        f10523c = b.b(SysAppAutoUpdateAnalyticsImpl$taskInfoDao$2.INSTANCE);
        f10524d = b.b(SysAppAutoUpdateAnalyticsImpl$sequential$2.INSTANCE);
        f10525e = b.b(SysAppAutoUpdateAnalyticsImpl$pm$2.INSTANCE);
    }

    public SysAppAutoUpdateAnalyticsImpl() {
    }

    public static final /* synthetic */ SysAppAutoUpdateReportReq a(SysAppAutoUpdateAnalyticsImpl r10, he.c r11, int r12, String r13) {
        return r10.g(r11, r12, r13);
    }

    public static final /* synthetic */ StoreBaseApplication b(SysAppAutoUpdateAnalyticsImpl r10) {
        return r10.h();
    }

    public static final /* synthetic */ PackageManager c(SysAppAutoUpdateAnalyticsImpl r10) {
        return r10.i();
    }

    public static final /* synthetic */ SysAppAutoUpdateTaskInfoDao d(SysAppAutoUpdateAnalyticsImpl r10) {
        return r10.k();
    }

    public static final /* synthetic */ void e(SysAppAutoUpdateAnalyticsImpl r10, SysAppAutoUpdateReportReq r11) {
        r10.l(r11);
    }

    public static final /* synthetic */ he.c f(SysAppAutoUpdateAnalyticsImpl r10, AppInfo r11, long r12) {
        return r10.m(r11, r12);
    }

    public final SysAppAutoUpdateReportReq g(he.c r16, int r17, String r18) {
        Long r10 = n.i(r16.g());
        if (r10 == null) goto L6;
        long r11 = r10.longValue();
    L5:
        long r12 = r11;
        return new SysAppAutoUpdateReportReq(r12, r16.a(), r16.e(), r16.c(), r16.j(), r18, (int) (System.currentTimeMillis() / ((long) 1000)), r17);
    L6:
        r11 = 0;
        goto L5
    }

    public final StoreBaseApplication h() {
        return (StoreBaseApplication) f10522b.getValue();
    }

    public final PackageManager i() {
        Object r10 = f10525e.getValue();
        q.f(r10, "getValue(...)");
        return (PackageManager) r10;
    }

    public final SendChannel j() {
        return (SendChannel) f10524d.getValue();
    }

    public final SysAppAutoUpdateTaskInfoDao k() {
        return (SysAppAutoUpdateTaskInfoDao) f10523c.getValue();
    }

    public final void l(SysAppAutoUpdateReportReq r14) {
        String r13 = r14.getPackageName();
        long r10 = r14.getTaskId();
        h.d(y0.f21772a, l0.b(), null, new SysAppAutoUpdateAnalyticsImpl$report$1(r14, r14.getStatus(), r14.getReason(), "[srvId=" + r10 + ", pkg=" + r13 + ", oldVer=" + r14.getOldVersionCode() + ", newVer=" + r14.getNewVersionCode() + ']', null), 2, null);
    }

    public final he.c m(AppInfo r18, long r19) {
        String r10 = r18.appId;
        if (r10 != null) goto L5;
        String r11 = "";
    L6:
        String r12 = Long.valueOf(r18.mSysAppAutoUpdateTaskId).toString();
        int r13 = r18.mUpdateModel;
        String r14 = r18.appPackageName;
        if (r14 != null) goto L9;
        String r15 = "";
    L10:
        String r16 = r18.appDownloadUrl;
        if (r16 != null) goto L13;
        String r17 = "";
    L14:
        String r20 = r18.fileMd5;
        if (r20 != null) goto L17;
        String r21 = "";
    L18:
        long r22 = r18.appBytes;
        long r110 = r18.appVersionCode;
        String r23 = r18.appVersionName;
        if (r23 != null) goto L21;
        String r111 = "";
    L23:
        return new he.c(0, r11, r12, r13, r15, r17, r21, r22, r19, r110, r111);
    L21:
        r111 = r23;
        goto L23
    L17:
        r21 = r20;
        goto L18
    L13:
        r17 = r16;
        goto L14
    L9:
        r15 = r14;
        goto L10
    L5:
        r11 = r10;
        goto L6
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onDownloadFailed(String r10, String r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r11, "reason");
        j().mo53trySendJP2dKIU(new AnonymousClass1(r10, r11, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onDownloadStart(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j().mo53trySendJP2dKIU(new C04361(r10, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onDownloadSuccess(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j().mo53trySendJP2dKIU(new C04371(r10, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onGetUpdateInfo(List r10) {
        q.g(r10, "apps");
        j().mo53trySendJP2dKIU(new C04381(r10, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onInstallFailed(String r10, String r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r11, "reason");
        j().mo53trySendJP2dKIU(new C04391(r10, r11, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onInstallStart(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j().mo53trySendJP2dKIU(new C04401(r10, null));
    }

    @Override // com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics
    public void onInstallSucc(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j().mo53trySendJP2dKIU(new C04411(r10, null));
    }
}
