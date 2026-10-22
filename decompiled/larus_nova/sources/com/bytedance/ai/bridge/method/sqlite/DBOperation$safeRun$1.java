package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$safeRun$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DBOperation$safeRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SQLiteDatabase, Unit> $block;
    final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DBOperation this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DBOperation$safeRun$1(DBOperation r100, Function1<? super SQLiteDatabase, Unit> r101, f3.h<AbsExecuteSqliteActionMethodIDL.b> r102, Continuation<? super DBOperation$safeRun$1> r103) {
        this.this$0 = r100;
        this.$block = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DBOperation$safeRun$1 r102 = new DBOperation$safeRun$1(this.this$0, this.$block, this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DBOperation$safeRun$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        DBOperation r102 = this.this$0;
        SQLiteDatabase r103 = r102.f35885c;
        if (r103 == null) goto L10;
        Function1<SQLiteDatabase, Unit> r104 = this.$block;
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r105 = this.$callback;
        if (r103.isOpen() == false) goto L9;
        r104.invoke(r103);
    L12:
        return Unit.INSTANCE;
    L9:
        String r106 = "db is not open: " + r102.f35884b;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r106);
        f3.h.a.a(r105, r106, null, null, 14);
        goto L12
    L10:
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r107 = this.$callback;
        String r108 = "db is not open: " + r102.f35884b;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r108);
        f3.h.a.a(r107, r108, null, null, 14);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
