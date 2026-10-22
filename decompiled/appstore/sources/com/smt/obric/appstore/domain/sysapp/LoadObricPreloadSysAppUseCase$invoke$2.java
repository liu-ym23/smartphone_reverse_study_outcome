package com.smt.obric.appstore.domain.sysapp;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.n;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadObricPreloadSysAppUseCase$invoke$2", f = "LoadObricPreloadSysAppUseCase.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLoadObricPreloadSysAppUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadObricPreloadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$invoke$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n11383#2,9:134\n13309#2:143\n13310#2:145\n11392#2:146\n1#3:144\n*S KotlinDebug\n*F\n+ 1 LoadObricPreloadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$invoke$2\n*L\n42#1:134,9\n42#1:143\n42#1:145\n42#1:146\n42#1:144\n*E\n"})
public final class LoadObricPreloadSysAppUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends AppInfo>>>, Object> {
    final /* synthetic */ String $preloadDir;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoadObricPreloadSysAppUseCase this$0;

    public LoadObricPreloadSysAppUseCase$invoke$2(String r10, LoadObricPreloadSysAppUseCase r11, Continuation<? super LoadObricPreloadSysAppUseCase$invoke$2> r12) {
        this.$preloadDir = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public static /* synthetic */ boolean a(File r10, String r11) {
        return invokeSuspend$lambda$3$lambda$2$lambda$1(r10, r11);
    }

    public static /* synthetic */ boolean b(File r10, String r11) {
        return invokeSuspend$lambda$3$lambda$0(r10, r11);
    }

    private static final boolean invokeSuspend$lambda$3$lambda$0(File r10, String r11) {
        return new File(r10, r11).isDirectory();
    }

    private static final boolean invokeSuspend$lambda$3$lambda$2$lambda$1(File r10, String r11) {
        q.d(r11);
        return o.o(r11, ".apk", false, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        LoadObricPreloadSysAppUseCase$invoke$2 r12 = new LoadObricPreloadSysAppUseCase$invoke$2(this.$preloadDir, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Result<? extends List<? extends AppInfo>>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        kotlin.c.b(r10);     // Catch: Throwable -> L7
    L32:
        List r13 = (List) r10;     // Catch: Throwable -> L7
    L34:
        Object r14 = Result.m35constructorimpl(r13);     // Catch: Throwable -> L7
    L38:
        return Result.m34boximpl(r14);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlin.c.b(r10);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        String r16 = this.$preloadDir;
        LoadObricPreloadSysAppUseCase r17 = this.this$0;
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L7
        File r19 = new File(r16);     // Catch: Throwable -> L7
        if (r19.exists() == true) goto L15;
    L33:
        j.n("[AppStatus][SysApp] preload apps dir not exists");     // Catch: Throwable -> L7
        r13 = t.i();     // Catch: Throwable -> L7
        goto L34
    L15:
        if (r19.isDirectory() == false) goto L33;
        File[] r110 = r19.listFiles(new b());     // Catch: Throwable -> L7
        if (r110 == null) goto L28;
        List r20 = new ArrayList();     // Catch: Throwable -> L7
        int r21 = r110.length;     // Catch: Throwable -> L7
        int r22 = 0;
    L20:
        if (r22 >= r21) goto L29;
        File[] r23 = r110[r22].listFiles(new c());     // Catch: Throwable -> L7
        if (r23 == null) goto L24;
        q.d(r23);     // Catch: Throwable -> L7
        File r24 = (File) n.s(r23);     // Catch: Throwable -> L7
    L25:
        if (r24 == null) goto L27;
        r20.add(r24);     // Catch: Throwable -> L7
    L27:
        r22 = r22 + 1;     // Catch: Throwable -> L7
        goto L20
    L24:
        r24 = null;
    L29:
        LoadObricPreloadSysAppUseCase$invoke$2$1$1 r111 = new LoadObricPreloadSysAppUseCase$invoke$2$1$1(r20, r17, null);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r10 = d0.e(r111, this);     // Catch: Throwable -> L7
        if (r10 != r11) goto L32;
        return r11;
    L28:
        r20 = t.i();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.a r112 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L38
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Result<? extends List<? extends AppInfo>>> r11) {
        return ((LoadObricPreloadSysAppUseCase$invoke$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
