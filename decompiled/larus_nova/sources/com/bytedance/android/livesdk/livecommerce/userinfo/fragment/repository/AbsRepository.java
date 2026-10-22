package com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository;

import io.reactivex.Observable;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbsRepository {
    public AbsRepository() {
    }

    public static /* synthetic */ Object b(AbsRepository r100, Function0 r101, Continuation r102) {
        return r100.a(5, 500, r101, r102);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:26:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0068 -> B:25:0x006d). Please report as a decompilation issue!!! */
    public final <V> Object a(int r100, long r101, Function0<? extends Observable<V>> r102, Continuation<? super Observable<V>> r110) {
        if ((r110 instanceof AbsRepository$tryGetObservable$1) == false) goto L7;
        AbsRepository$tryGetObservable$1 r103 = (AbsRepository$tryGetObservable$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r103.I$2;
        int r107 = r103.I$1;
        long r108 = r103.J$0;
        int r109 = r103.I$0;
        Function0<? extends Observable<V>> r112 = (Function0) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L25:
        int r113 = r107;
        int r114 = r109;
        Object r115 = r105;
        AbsRepository$tryGetObservable$1 r116 = r103;
        Function0<? extends Observable<V>> r117 = r112;
    L26:
        r113 = r113 + 1;
    L15:
        if (r113 >= r100) goto L27;
        Observable<V> r118 = r117.invoke();
        if (r118 == null) goto L20;
        return r118;
    L20:
        if (r113 >= (r114 - 1)) goto L26;
        r116.L$0 = r117;
        r116.I$0 = r114;
        r116.J$0 = r108;
        r116.I$1 = r113;
        r116.I$2 = r100;
        r116.label = 1;
        if (DelayKt.delay(r108, r116) != r115) goto L24;
        return r115;
    L24:
        r112 = r117;
        r103 = r116;
        r105 = r115;
        r109 = r114;
        r107 = r113;
        goto L25
    L27:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r113 = 0;
        r115 = r105;
        r116 = r103;
        r117 = r102;
        r108 = r101;
        r114 = r100;
    L7:
        r103 = new AbsRepository$tryGetObservable$1(this, r110);
        goto L8
    }
}
