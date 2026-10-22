package com.smt.obric.appstore.domain.app;

import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1", f = "AppInstallActor.kt", i = {}, l = {404}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ StateFlow<Boolean> $settingState;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1$1", f = "AppInstallActor.kt", i = {0}, l = {405, 413, 419}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1261:1\n1855#2,2:1262\n*S KotlinDebug\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1$1\n*L\n418#1:1262,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
        final /* synthetic */ StateFlow<Boolean> $settingState;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AppInstallActor this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(StateFlow<Boolean> r10, AppInstallActor r11, SendChannel<? super AppInstallActor.b> r12, Continuation<? super AnonymousClass1> r13) {
            this.$settingState = r10;
            this.this$0 = r11;
            this.$actorMailbox = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$settingState, this.this$0, this.$actorMailbox, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Boolean r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L12;
            if (r12 == 1) goto L11;
            if (r12 == 2) goto L10;
            if (r12 != 3) goto L9;
            Iterator r13 = (Iterator) this.L$1;
            SendChannel<AppInstallActor.b> r14 = (SendChannel) this.L$0;
            kotlin.c.b(r10);
        L24:
            if (r13.hasNext() == false) goto L29;
            AppInstallActor.b.a r15 = new AppInstallActor.b.a(((com.smt.obric.appstore.domain.app.entity.a) r13.next()).E(), null);
            this.L$0 = r14;
            this.L$1 = r13;
            this.label = 3;
            if (r14.send(r15, this) != r11) goto L24;
            return r11;
        L29:
            return Unit.f21064a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            kotlin.c.b(r10);
        L22:
            List r16 = (List) r10;
            com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] wifi auto update setting disabled by user, cancel all sysapp wifi auto update tasks, size=" + r16.size());
            r14 = this.$actorMailbox;
            r13 = r16.iterator();
            goto L24
        L11:
            Boolean r17 = (Boolean) this.L$0;
            kotlin.c.b(r10);
        L15:
            if (r17 == null) goto L18;
            com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] wifi auto update setting state changed = " + r17.booleanValue());
        L18:
            if (q.b(this.$settingState.getValue(), tf.a.a(false)) == false) goto L29;
            AppInstallTaskDAO r18 = AppInstallActor.t(this.this$0);
            this.L$0 = null;
            this.label = 2;
            r10 = r18.getAllTasksByUpdateModeAndComplianceMode(3, 1, this);
            if (r10 != r11) goto L22;
            return r11;
        L12:
            kotlin.c.b(r10);
            r17 = (Boolean) this.L$0;
            this.L$0 = r17;
            this.label = 1;
            if (DelayKt.b(1000, this) != r11) goto L15;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Boolean r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1(StateFlow<Boolean> r10, AppInstallActor r11, SendChannel<? super AppInstallActor.b> r12, Continuation<? super AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1> r13) {
        this.$settingState = r10;
        this.this$0 = r11;
        this.$actorMailbox = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1(this.$settingState, this.this$0, this.$actorMailbox, r11);
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
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        StateFlow<Boolean> r13 = this.$settingState;
        AnonymousClass1 r14 = new AnonymousClass1(r13, this.this$0, this.$actorMailbox, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.c.h(r13, r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
