package com.obric.appstore.sysapp.restore;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageViewModel$refresh$1", f = "SysAppManageViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppManageViewModel$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SysAppManageViewModel this$0;

    /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageViewModel$refresh$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "", "Lcom/bytedanceos/common/model/AppInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageViewModel$refresh$1$1", f = "SysAppManageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSysAppManageViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppManageViewModel.kt\ncom/obric/appstore/sysapp/restore/SysAppManageViewModel$refresh$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,119:1\n1864#2,3:120\n1549#2:123\n1620#2,3:124\n*S KotlinDebug\n*F\n+ 1 SysAppManageViewModel.kt\ncom/obric/appstore/sysapp/restore/SysAppManageViewModel$refresh$1$1\n*L\n72#1:120,3\n85#1:123\n85#1:124,3\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Result<? extends List<? extends AppInfo>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$BooleanRef $succeed;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SysAppManageViewModel this$0;

        public AnonymousClass1(SysAppManageViewModel r10, Ref$BooleanRef r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$succeed = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$succeed, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Result<? extends List<? extends AppInfo>> r10, Continuation<? super Unit> r11) {
            return invoke(r10.m44unboximpl(), r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L27;
            kotlin.c.b(r10);
            Object r11 = ((Result) this.L$0).m44unboximpl();
            Ref$BooleanRef r12 = this.$succeed;
            SysAppManageViewModel r13 = this.this$0;
            Throwable r14 = Result.m38exceptionOrNullimpl(r11);
            if (r14 != null) goto L21;
            List r15 = (List) r11;
            j.n("SysAppRestoreViewModel.refresh, success: size=" + r15.size());
            Iterator r16 = r15.iterator();
            int r17 = 0;
        L8:
            if (r16.hasNext() == false) goto L16;
            Object r18 = r16.next();
            int r19 = r17 + 1;
            if (r17 >= 0) goto L12;
            t.q();
        L12:
            AppInfo r20 = (AppInfo) r18;
            if (q.b(r20.appPackageName, "com.obric.recorder") == false) goto L15;
            j.n("[SysAppNameDebug][SysAppManageViewModel] refresh result[" + r17 + "] pkg=" + r20.appPackageName + " name=" + r20.appName + " version=" + r20.appVersionCode + '/' + r20.appVersionName + " state=" + r20.appState + " appSource=" + r20.appSource + " icon=" + r20.appIcon + " preloadPath=" + r20.obricPreloadApkFilePath);
        L15:
            r17 = r19;
            goto L8
        L16:
            r12.element = true;
            MutableStateFlow r21 = SysAppManageViewModel.i(r13);
            ArrayList r22 = new ArrayList(u.r(r15, 10));
            Iterator r110 = r15.iterator();
        L18:
            if (r110.hasNext() == false) goto L20;
            r22.add(new e((AppInfo) r110.next()));
            goto L18
        L20:
            r21.setValue(r22);
        L24:
            SysAppManageViewModel.j(this.this$0).setValue(tf.a.a(false));
            return Unit.f21064a;
        L21:
            j.p("SysAppRestoreViewModel.refresh, error: " + r14);
            if (r12.element == true) goto L24;
            SysAppManageViewModel.h(r13).setValue(r14);
            goto L24
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull Object r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(Result.m34boximpl(r10), r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public SysAppManageViewModel$refresh$1(SysAppManageViewModel r10, Continuation<? super SysAppManageViewModel$refresh$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppManageViewModel$refresh$1(this.this$0, r11);
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
        SysAppManageViewModel.j(this.this$0).setValue(tf.a.a(true));
        SysAppManageViewModel.h(this.this$0).setValue(null);
        Ref$BooleanRef r13 = new Ref$BooleanRef();
        Flow r14 = SysAppManageViewModel.f(this.this$0).l();
        AnonymousClass1 r15 = new AnonymousClass1(this.this$0, r13, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.c.h(r14, r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppManageViewModel$refresh$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
