package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1", f = "FirstScreenStatistic.kt", i = {1}, l = {1112, 1117, 1123, 1131, 1155}, m = "invokeSuspend", n = {SimplayerImageStrategy.RESULT_BITMAP}, s = {"L$0"})
final class FirstScreenStatistic$readBitmapIntoImageView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $cleanUrl;
    final /* synthetic */ HashMap $extra;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ String $md5Name;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1$1", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FirstScreenStatistic$readBitmapIntoImageView$1 this$0;

        public AnonymousClass1(FirstScreenStatistic$readBitmapIntoImageView$1 r100, Continuation r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.this$0.$callback.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FirstScreenStatistic$readBitmapIntoImageView$1(ImageView r100, String r101, HashMap r102, Function1 r103, String r104, Continuation r105) {
        this.$imageView = r100;
        this.$cleanUrl = r101;
        this.$extra = r102;
        this.$callback = r103;
        this.$md5Name = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "completion");
        FirstScreenStatistic$readBitmapIntoImageView$1 r101 = new FirstScreenStatistic$readBitmapIntoImageView$1(this.$imageView, this.$cleanUrl, this.$extra, this.$callback, this.$md5Name, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FirstScreenStatistic$readBitmapIntoImageView$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [T, android.graphics.Bitmap] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L14;
        if (r101 == 4) goto L14;
        if (r101 != 5) goto L11;
        ResultKt.throwOnFailure(r110);
    L64:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Ref.ObjectRef r102 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r103 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L32
        Ref.ObjectRef r111 = r102;
        Object r104 = r110;
    L38:
        r111.element = (Bitmap) r104;     // Catch: Throwable -> L32
        if (((Bitmap) r103.element) != null) goto L46;
        FirstScreenStatistic r105 = FirstScreenStatistic.S;     // Catch: Throwable -> L32
        HashMap r106 = this.$extra;     // Catch: Throwable -> L32
        r105.getClass();     // Catch: Throwable -> L32
        FirstScreenStatistic.n("readBitmapInfoImageView", "wait Bitmap null", null, r106);     // Catch: Throwable -> L32
        if (FirstScreenStatistic.f44372o == false) goto L43;
        this.$callback.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L32
    L52:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L56:
        if (Result.m9455isFailureimpl(r107) == false) goto L64;
        FirstScreenStatistic r108 = FirstScreenStatistic.S;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        HashMap r112 = this.$extra;
        r108.getClass();
        FirstScreenStatistic.n("readBitmapInfoImageView", "run error", r109, r112);
        if (FirstScreenStatistic.f44372o == false) goto L60;
        this.$callback.invoke(Boxing.boxBoolean(false));
        goto L64
    L60:
        MainCoroutineDispatcher r113 = Dispatchers.getMain();
        AnonymousClass1 r114 = new AnonymousClass1(this, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 5;
        if (BuildersKt.withContext(r113, r114, this) != r100) goto L64;
        return r100;
    L43:
        MainCoroutineDispatcher r115 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$2 r116 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$2(null, this, r103);     // Catch: Throwable -> L32
        this.L$0 = null;     // Catch: Throwable -> L32
        this.L$1 = null;     // Catch: Throwable -> L32
        this.label = 3;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r115, r116, this) != r100) goto L52;
        return r100;
    L46:
        dm.a.a("FirstScreenStatistic").a("readBitmapInfoImageView success getBitmap");     // Catch: Throwable -> L32
        p0 r117 = FirstScreenStatistic.N.get(this.$md5Name);     // Catch: Throwable -> L32
        if (r117 == null) goto L49;
        r117.f44934d = System.currentTimeMillis();     // Catch: Throwable -> L32
    L49:
        MainCoroutineDispatcher r118 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$3 r119 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$3(null, this, r103);     // Catch: Throwable -> L32
        this.L$0 = null;     // Catch: Throwable -> L32
        this.L$1 = null;     // Catch: Throwable -> L32
        this.label = 4;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r118, r119, this) != r100) goto L52;
        return r100;
    L14:
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L32
        goto L52
    L16:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r120 = (CoroutineScope) this.L$0;
        FirstScreenStatistic r121 = FirstScreenStatistic.S;
        String r122 = FirstScreenStatistic.L.get(this.$imageView);
        if (r122 != null) goto L20;
        r122 = "";
    L20:
        if ((!Intrinsics.areEqual(r122, this.$cleanUrl)) == false) goto L23;
        this.$extra.put("newUrl", r122);
        HashMap r123 = this.$extra;
        r121.getClass();
        FirstScreenStatistic.n("readBitmapInfoImageView", "imageView url changed in io thread", null, r123);
        this.$callback.invoke(null);
        return Unit.INSTANCE;
    L23:
        r111 = new Ref.ObjectRef();
        r111.element = null;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L32
        Deferred<Bitmap> r125 = FirstScreenStatistic.P.get(this.$md5Name);     // Catch: Throwable -> L32
        if (r125 != null) goto L34;
        HashMap r126 = this.$extra;     // Catch: Throwable -> L32
        r121.getClass();     // Catch: Throwable -> L32
        FirstScreenStatistic.n("readBitmapInfoImageView", "no bitmap task", null, r126);     // Catch: Throwable -> L32
        dm.a.a("FirstScreenStatistic").b("md5 " + this.$md5Name + " url " + this.$cleanUrl + " task == null ? true " + FirstScreenStatistic.K.contains(this.$md5Name), null);     // Catch: Throwable -> L32
        if (FirstScreenStatistic.f44372o == false) goto L29;
        this.$callback.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L32
        goto L52
    L29:
        MainCoroutineDispatcher r127 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1 r128 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1(null, this, r111);     // Catch: Throwable -> L32
        this.label = 1;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r127, r128, this) != r100) goto L52;
        return r100;
    L34:
        this.L$0 = r111;     // Catch: Throwable -> L32
        this.L$1 = r111;     // Catch: Throwable -> L32
        this.label = 2;     // Catch: Throwable -> L32
        r104 = r125.await(this);     // Catch: Throwable -> L32
        if (r104 != r100) goto L37;
        return r100;
    L37:
        r103 = r111;
    L32:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    }
}
