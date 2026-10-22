package com.bytedance.android.ec.ab.opt;

import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public abstract class LazyOptGetSettings<Config> implements ReadOnlyProperty<Object, Config> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f42662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f42663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Config f42664c;

    /* JADX INFO: renamed from: com.bytedance.android.ec.ab.opt.LazyOptGetSettings$getValue$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Config", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.ab.opt.LazyOptGetSettings$getValue$1", f = "LazyOptSettings.kt", i = {}, l = {30, 35, 39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyOptGetSettings this$0;

        public AnonymousClass1(LazyOptGetSettings r100, Continuation r101) {
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
        L28:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r100);
        L16:
            if (r100 != this.this$0.b()) goto L22;
            this.this$0.f42662a.compareAndSet(true, false);
            LazyOptGetSettings r103 = this.this$0;
            r103.f42663b = System.currentTimeMillis();
            if (this.this$0.f() == false) goto L28;
            LazyOptGetSettings r104 = this.this$0;
            this.label = 2;
            if (LazyOptGetSettings.a(r104, this) != r101) goto L28;
            return r101;
        L22:
            LazyOptGetSettings r105 = this.this$0;
            r105.f42664c = (Config) r100;
            Function2<Config, Continuation<? super Unit>, Object> r106 = r105.d();
            if (r106 == null) goto L28;
            this.label = 3;
            if (r106.invoke(r100, this) != r101) goto L28;
            return r101;
        L12:
            ResultKt.throwOnFailure(r100);
            LazyOptGetSettings r107 = this.this$0;
            this.label = 1;
            r100 = (Config) r107.e(this);
            if (r100 != r101) goto L16;
            return r101;
        }
    }

    public abstract Config b();

    public abstract a<Config> c();

    public abstract Function2<Config, Continuation<? super Unit>, Object> d();

    public abstract Object e(Continuation<? super Config> r100);

    public abstract boolean f();

    public abstract Function0<Boolean> g();

    public boolean i() {
        return true;
    }

    public LazyOptGetSettings() {
        this.f42662a = new AtomicBoolean(false);
    }

    public static boolean h() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Object a(LazyOptGetSettings r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof LazyOptGetSettings$defaultLocalConfigInit$1) == false) goto L7;
        LazyOptGetSettings$defaultLocalConfigInit$1 r102 = (LazyOptGetSettings$defaultLocalConfigInit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25
    L21:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L25
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L25
        a<Config> r109 = r100.c();     // Catch: Throwable -> L25
        if (r109 == null) goto L22;
        r102.label = 1;     // Catch: Throwable -> L25
        if (r109.a(r102) != r105) goto L21;
        return r105;
    L22:
        r107 = null;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new LazyOptGetSettings$defaultLocalConfigInit$1(r100, r101);
        goto L8
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Config getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Config r102 = null;
        if (this.f42664c == null) goto L5;
    L17:
        Config r103 = this.f42664c;
        if (r103 != null) goto L29;
        boolean r104 = g().invoke().booleanValue();
        boolean r105 = f();     // Catch: Throwable -> L27
        if (r104 == false) goto L28;
        if (r105 == false) goto L28;
        a<Config> r106 = c();     // Catch: Throwable -> L27
        if (r106 == null) goto L28;
        r102 = r106.f42666b;     // Catch: Throwable -> L27
    L28:
        r103 = r102;
    L29:
        if (r103 == null) goto L31;
        return r103;
    L31:
        return b();
    L5:
        if (g().invoke().booleanValue() == false) goto L17;
        if ((System.currentTimeMillis() - this.f42663b) <= 1000) goto L17;
        if (this.f42662a.compareAndSet(false, true) == false) goto L17;
        if (h() == true) goto L13;
    L15:
        CoroutineDispatcher r107 = Dispatchers.getUnconfined();
    L16:
        CoroutineScope r108 = c.f42667a;
        BuildersKt.launch$default(r108, r107, null, new AnonymousClass1(this, null), 2, null);
        goto L17
    L13:
        if (i() == false) goto L15;
        r107 = Dispatchers.getIO();
        goto L16
    }
}
