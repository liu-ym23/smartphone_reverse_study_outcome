package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class TransferStep extends a<Boolean, List<? extends IBaseConfig>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IBaseConfig> f38220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewIdReplaceStep f38221c;

    public TransferStep(ViewIdReplaceStep r100) {
        this.f38221c = r100;
        this.f38220b = new ArrayList();
    }

    public final Object a(Boolean r100, Continuation<? super List<? extends IBaseConfig>> r110) {
        if ((r110 instanceof TransferStep$excute$1) == false) goto L7;
        TransferStep$excute$1 r101 = (TransferStep$excute$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        TransferStep r105 = (TransferStep) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L24:
        List r112 = (List) r111;
        if (r112 == null) goto L43;
        Iterator r113 = r112.iterator();
    L28:
        if (r113.hasNext() == false) goto L43;
        f r106 = (f) r113.next();
        if (("activity id = " + r106.f38189a) == null) goto L32;
        Context r107 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L32:
        r105.getClass();
        ArrayList r108 = new ArrayList();
        List<g> r109 = r106.f38190b;
        if (r109 == null) goto L42;
        Iterator<T> r114 = r109.iterator();
    L36:
        if (r114.hasNext() == false) goto L42;
        final g r115 = (g) r114.next();
        int r116 = h6.a.f483894a;
        String r117 = r106.f38189a;
        if (r117 != null) goto L41;
        r117 = "defaultActivityPage";
    L41:
        g6.a r118 = new g6.a(r117.concat(":") + r115.f38191a, r115.f38192b.f38208a, new TransferStep$transferConfig$1$config$1(r115));
        r118.build();
        r108.add(r118);
    L42:
        ((ArrayList) r105.f38220b).addAll(r108);
    L43:
        r105.f38219a = true;
        if (("TransferStep excute configList size = " + ((ArrayList) r105.f38220b).size()) == null) goto L47;
        Context r119 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L47:
        return r105.f38220b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (this.f38219a == true) goto L17;
    L20:
        ((ArrayList) this.f38220b).clear();
        Context r120 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        ViewIdReplaceStep r121 = this.f38221c;
        Boolean r122 = Boxing.boxBoolean(true);
        r101.L$0 = this;
        r101.label = 1;
        r111 = r121.a(r122, r101);
        if (r111 != r103) goto L23;
        return r103;
    L23:
        r105 = this;
        goto L24
    L17:
        if (Intrinsics.areEqual(r100, Boxing.boxBoolean(false)) == false) goto L20;
        Context r123 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return this.f38220b;
    L7:
        r101 = new TransferStep$excute$1(this, r110);
        goto L8
    }
}
