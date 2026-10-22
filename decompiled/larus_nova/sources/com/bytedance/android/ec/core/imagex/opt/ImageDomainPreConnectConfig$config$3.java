package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/image/a0;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/api/image/a0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ImageDomainPreConnectConfig$config$3 extends AdaptedFunctionReference implements Function2<com.bytedance.android.shopping.api.image.a0, Continuation<? super Unit>, Object>, SuspendFunction {
    public ImageDomainPreConnectConfig$config$3(DomainPreConnect r100) {
        super(2, r100, DomainPreConnect.class, "initConfig", "initConfig(Lcom/bytedance/android/shopping/api/image/ImageDomainPreConnectModel;)V", 4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.bytedance.android.shopping.api.image.a0 r100, Continuation<? super Unit> r101) {
        ((DomainPreConnect) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        HashMap<String, DomainPreConnect.a> r102 = new HashMap();
        List<com.bytedance.android.shopping.api.image.z> r103 = r100.b();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        com.bytedance.android.shopping.api.image.z r105 = (com.bytedance.android.shopping.api.image.z) r104.next();
        Long r106 = r105.b();
        if (r106 == null) goto L10;
        long r107 = r106.longValue();
    L11:
        String r108 = r105.a();
        if (r108 == null) goto L6;
        r102.put(r108, new DomainPreConnect.a("https://" + r105.a(), r107 * 1000000));
        goto L6
    L10:
        r107 = 1000;
    L15:
        if ((!r102.isEmpty()) == false) goto L18;
        DomainPreConnect.f44727a = r102;
    L18:
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.bytedance.android.shopping.api.image.a0 r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }
}
