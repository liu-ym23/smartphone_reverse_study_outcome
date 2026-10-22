package com.obric.appstore.buss.search;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.obric.appstore.network.entity.PageResp;
import com.smt.obric.appstore.assistant.intent.DownloadAppIntentState;
import com.smt.obric.appstore.ui.app.AppStatusEvent;
import com.smt.obric.appstore.ui.app.AppUIStatus;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.g2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2", f = "SearchAppFragment.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {181, 193, 218, 262}, m = "invokeSuspend", n = {"$this$coroutineScope", "sid", "$this$coroutineScope", "sid", "resultCh", "$this$coroutineScope", "sid", "resultCh", "appInfo", "sid", "appInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
@SourceDebugExtension({"SMAP\nSearchAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchAppFragment.kt\ncom/obric/appstore/buss/search/SearchAppFragment$autoDownloadIfFirstExactMatch$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,336:1\n1#2:337\n*E\n"})
public final class SearchAppFragment$autoDownloadIfFirstExactMatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appName;
    final /* synthetic */ String $downloadIntentSessionId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SearchAppFragment this$0;

    /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/smt/obric/appstore/ui/app/AppUIStatus;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$2", f = "SearchAppFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<AppUIStatus, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(r11);
            r12.L$0 = r10;
            return r12;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull AppUIStatus r10, @Nullable Continuation<? super Boolean> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L7;
            kotlin.c.b(r10);
            return tf.a.a(!((AppUIStatus) this.L$0).d());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(AppUIStatus r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$3", f = "SearchAppFragment.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appName;
        final /* synthetic */ SendChannel<com.smt.obric.appstore.assistant.intent.b> $resultCh;
        final /* synthetic */ String $sid;
        int label;
        final /* synthetic */ SearchAppFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f10837a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10838b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f10839c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ SendChannel f10840d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f10841e;

            public AnonymousClass1(String r10, String r11, Ref$BooleanRef r12, SendChannel r13, Ref$BooleanRef r14) {
                this.f10837a = r10;
                this.f10838b = r11;
                this.f10839c = r12;
                this.f10840d = r13;
                this.f10841e = r14;
            }

            public final Object a(AppStatusEvent r10, Continuation r11) {
                if ((r11 instanceof SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1) == false) goto L7;
                SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1 r12 = (SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = kotlin.coroutines.intrinsics.a.d();
                int r16 = r12.label;
                if (r16 == 0) goto L16;
                if (r16 == 1) goto L15;
                if (r16 != 2) goto L13;
                kotlin.c.b(r14);
            L39:
                throw new CancellationException();
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                AnonymousClass1 this = (AnonymousClass1) r12.L$0;
                kotlin.c.b(r14);
            L23:
                this.f10841e.element = true;
            L34:
                if (this.f10841e.element == false) goto L41;
                r12.L$0 = null;
                r12.label = 2;
                if (DelayKt.b(WsConstants.EXIT_DELAY_TIME, r12) != r15) goto L39;
                return r15;
            L41:
                return Unit.f21064a;
            L16:
                kotlin.c.b(r14);
                com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp] on tryEnqueueOrResumeEvent, sid=" + this.f10837a + ", appName=" + this.f10838b + ", event=" + u.b(r10.getClass()).getSimpleName());
                if ((r10 instanceof AppStatusEvent.b) == false) goto L25;
                com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp][SendResult] Downloaded, sid=" + this.f10837a + ", appName=" + this.f10838b + ", expecting_next_do_action=" + this.f10839c.element);
                this.f10840d.mo53trySendJP2dKIU(new com.smt.obric.appstore.assistant.intent.b.C0214b(false, 1, null));
                Ref$BooleanRef r17 = this.f10839c;
                if (r17.element == false) goto L23;
                r17.element = false;
                com.bytedanceos.common.toolbox.j.n("[AI_Intent] [MultiRound] [DownloadApp][SendResult] AwaitUserConfirmCellularDataWarning, sid=" + this.f10837a + ", appName=" + this.f10838b);
                DownloadAppIntentState r18 = DownloadAppIntentState.f17875a;
                String r19 = this.f10837a;
                r12.L$0 = this;
                r12.label = 1;
                if (r18.a(r19, r12) != r15) goto L23;
                return r15;
            L25:
                if (q.b(r10, AppStatusEvent.a.f18151a) == false) goto L28;
                com.bytedanceos.common.toolbox.j.n("[AI_Intent] [MultiRound] [DownloadApp][SendResult] AwaitUserConfirmCellularDataWarning, sid=" + this.f10837a + ", appName=" + this.f10838b);
                this.f10840d.mo53trySendJP2dKIU(new com.smt.obric.appstore.assistant.intent.b.a(false, 1, null));
                this.f10839c.element = true;
                this.f10841e.element = false;
                goto L34
            L28:
                if ((r10 instanceof AppStatusEvent.c) == false) goto L31;
                this.f10840d.mo53trySendJP2dKIU(new com.smt.obric.appstore.assistant.intent.b.c(((AppStatusEvent.c) r10).a(), false, 2, null));
                this.f10841e.element = true;
                goto L34
            L31:
                if (q.b(r10, AppStatusEvent.d.f18154a) == false) goto L43;
                this.f10841e.element = true;
                goto L34
            L43:
                throw new NoWhenBranchMatchedException();
            L7:
                r12 = new SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a((AppStatusEvent) r10, r11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(String r10, String r11, SearchAppFragment r12, SendChannel<? super com.smt.obric.appstore.assistant.intent.b> r13, Continuation<? super AnonymousClass3> r14) {
            this.$sid = r10;
            this.$appName = r11;
            this.this$0 = r12;
            this.$resultCh = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass3(this.$sid, this.$appName, this.this$0, this.$resultCh, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            kotlin.c.b(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            Ref$BooleanRef r13 = new Ref$BooleanRef();
            Ref$BooleanRef r14 = new Ref$BooleanRef();
            com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp] collect tryEnqueueOrResumeEvent, sid=" + this.$sid + ", appName=" + this.$appName);
            SharedFlow r15 = SearchAppFragment.e0(this.this$0).o();
            AnonymousClass1 r16 = new AnonymousClass1(this.$sid, this.$appName, r14, this.$resultCh, r13);
            this.label = 1;
            if (r15.collect(r16, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public SearchAppFragment$autoDownloadIfFirstExactMatch$2(String r10, String r11, SearchAppFragment r12, Continuation<? super SearchAppFragment$autoDownloadIfFirstExactMatch$2> r13) {
        this.$downloadIntentSessionId = r10;
        this.$appName = r11;
        this.this$0 = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SearchAppFragment$autoDownloadIfFirstExactMatch$2 r12 = new SearchAppFragment$autoDownloadIfFirstExactMatch$2(this.$downloadIntentSessionId, this.$appName, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r18) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        String r12 = null;
        if (r11 == 0) goto L14;
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L11;
        if (r11 != 4) goto L10;
        he.a r13 = (he.a) this.L$1;
        String r14 = (String) this.L$0;
        kotlin.c.b(r18);
    L60:
        com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp] tryEnqueueOrResume, sid=" + r14 + ", appName=" + this.$appName);
        FragmentActivity r15 = this.this$0.getActivity();
        if (r15 == null) goto L72;
        SearchAppFragment.e0(this.this$0).y(r15, r13);
    L72:
        return Unit.f21064a;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        he.a r16 = (he.a) this.L$3;
        SendChannel r17 = (SendChannel) this.L$2;
        String r19 = (String) this.L$1;
        CoroutineScope r20 = (CoroutineScope) this.L$0;
        kotlin.c.b(r18);
        SendChannel r110 = r17;
    L56:
        CoroutineScope r21 = r20;
        kotlinx.coroutines.h.d(r21, null, null, new AnonymousClass3(r19, this.$appName, this.this$0, r110, null), 3, null);
        this.L$0 = r19;
        this.L$1 = r16;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 4;
        if (g2.a(this) != r10) goto L59;
        return r10;
    L59:
        r13 = r16;
        r14 = r19;
        goto L60
    L12:
        SendChannel r22 = (SendChannel) this.L$2;
        String r23 = (String) this.L$1;
        CoroutineScope r24 = (CoroutineScope) this.L$0;
        kotlin.c.b(r18);
        CoroutineScope r111 = r24;
        String r25 = r23;
        Object r26 = r18;
    L26:
        com.obric.appstore.network.g r27 = (com.obric.appstore.network.g) r26;
        StringBuilder r112 = new StringBuilder();
        r112.append("[AI_Intent] [DownloadApp] search result received, sid=");
        r112.append(r25);
        r112.append(", appName=");
        r112.append(this.$appName);
        r112.append(", result=");
        if (r27 == null) goto L29;
        String r113 = r27.getClass().getSimpleName();
    L30:
        r112.append(r113);
        com.bytedanceos.common.toolbox.j.n(r112.toString());
        if ((r27 instanceof com.obric.appstore.network.g.d) == false) goto L65;
        Object r28 = ((com.obric.appstore.network.g.d) r27).a();
        if ((r28 instanceof PageResp) == false) goto L35;
        PageResp r29 = (PageResp) r28;
    L36:
        if (r29 == null) goto L38;
        List r30 = r29.getData();
    L39:
        if (r30 == null) goto L41;
        AppInfo r31 = (AppInfo) b0.Z(r30);
    L42:
        if (r31 == null) goto L48;
        String r114 = r31.appName;
        q.f(r114, "appName");
        if (r114.length() <= 0) goto L48;
        String r115 = r31.appName;
        q.f(r115, "appName");
        if (q.b(com.smt.obric.appstore.assistant.intent.a.a(r115), com.smt.obric.appstore.assistant.intent.a.a(this.$appName)) == false) goto L48;
        boolean r116 = true;
    L49:
        com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp] first search result firstMatched=" + r116 + ", sid=" + r25 + ", appName=" + this.$appName + ", result=" + r31);
        if (r116 == false) goto L63;
        if (r31 == null) goto L63;
        he.a r32 = AppInfoKtxKt.newDomainEntity$default(r31, null, 1, null);
        SearchAppFragment.e0(this.this$0).q(r32);
        StateFlow r33 = SearchAppFragment.e0(this.this$0).p();
        AnonymousClass2 r117 = new AnonymousClass2(null);
        this.L$0 = r111;
        this.L$1 = r25;
        this.L$2 = r22;
        this.L$3 = r32;
        this.label = 3;
        if (kotlinx.coroutines.flow.c.v(r33, r117, this) != r10) goto L55;
        return r10;
    L55:
        r110 = r22;
        r16 = r32;
        r19 = r25;
        r20 = r111;
    L63:
        com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp][SendResult] Searched, sid=" + r25 + ", appName=" + this.$appName);
        r22.mo53trySendJP2dKIU(new com.smt.obric.appstore.assistant.intent.b.e(false, 1, null));
    L48:
        r116 = false;
        goto L49
    L41:
        r31 = null;
        goto L42
    L38:
        r30 = null;
        goto L39
    L35:
        r29 = null;
        goto L36
    L65:
        if ((r27 instanceof com.obric.appstore.network.g.a) == false) goto L67;
        com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp][SendResult] Error, sid=" + r25 + ", appName=" + this.$appName);
        r22.mo53trySendJP2dKIU(new com.smt.obric.appstore.assistant.intent.b.d(false, 1, null));
        goto L72
    L67:
        StringBuilder r34 = new StringBuilder();
        r34.append("[AI_Intent] [DownloadApp] unexpected search result type, sid=");
        r34.append(r25);
        r34.append(", appName=");
        r34.append(this.$appName);
        r34.append(", result=");
        if (r27 == null) goto L70;
        r12 = r27.getClass().getSimpleName();
    L70:
        r34.append(r12);
        com.bytedanceos.common.toolbox.j.n(r34.toString());
        goto L72
    L29:
        r113 = null;
        goto L30
    L13:
        final String r35 = (String) this.L$1;
        CoroutineScope r36 = (CoroutineScope) this.L$0;
        kotlin.c.b(r18);
        Object r118 = r18;
    L17:
        final Channel r119 = (Channel) r118;
        if (r119 == null) goto L73;
        Job r120 = (Job) r36.getCoroutineContext().get(Job.Key);
        if (r120 == null) goto L22;
        final String r121 = this.$appName;
        r120.invokeOnCompletion(new AnonymousClass1(r35, r121, r119));
    L22:
        com.bytedanceos.common.toolbox.j.n("[AI_Intent] [DownloadApp] search result waiting, sid=" + r35 + ", appName=" + this.$appName);
        Flow r122 = FlowLiveDataConversions.a(SearchAppFragment.h0(this.this$0).m());
        SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1 r123 = new SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1(null);
        this.L$0 = r36;
        this.L$1 = r35;
        this.L$2 = r119;
        this.label = 2;
        r26 = kotlinx.coroutines.flow.c.x(r122, r123, this);
        if (r26 != r10) goto L25;
        return r10;
    L25:
        CoroutineScope r124 = r36;
        r25 = r35;
        r22 = r119;
        r111 = r124;
        goto L26
    L73:
        com.bytedanceos.common.toolbox.j.p("[AI_Intent] [DownloadApp] null resultCh, sid=" + r35 + ", appName=" + this.$appName);
        return Unit.f21064a;
    L14:
        kotlin.c.b(r18);
        r36 = (CoroutineScope) this.L$0;
        r35 = this.$downloadIntentSessionId;
        DownloadAppIntentState r125 = DownloadAppIntentState.f17875a;
        this.L$0 = r36;
        this.L$1 = r35;
        this.label = 1;
        r118 = r125.f(r35, this);
        if (r118 != r10) goto L17;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SearchAppFragment$autoDownloadIfFirstExactMatch$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
