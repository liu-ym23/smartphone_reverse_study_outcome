package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.e;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ApplyStep extends a<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IBaseConfig> f38214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TransferStep f38215c;

    public ApplyStep(TransferStep r100) {
        this.f38215c = r100;
        this.f38214b = new ArrayList();
    }

    public final Object a(Boolean r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ApplyStep$excute$1) == false) goto L7;
        ApplyStep$excute$1 r102 = (ApplyStep$excute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ApplyStep r107 = (ApplyStep) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L27:
        List r108 = (List) r104;
        if (r108.isEmpty() == false) goto L32;
        Context r109 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return Unit.INSTANCE;
    L32:
        if (((ArrayList) r107.f38214b).isEmpty() == false) goto L34;
        ((ArrayList) r107.f38214b).addAll(r108);
    L55:
        if (("after apply, remoteConfigList size = " + ((ArrayList) r107.f38214b).size()) == null) goto L57;
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L57:
        ArrayList<IBaseConfig> r111 = AccessibilityConfigEngine.f38239a;
        List<IBaseConfig> r112 = r107.f38214b;
        ArrayList<IBaseConfig> r113 = AccessibilityConfigEngine.f38240b;
        r113.clear();
        r113.addAll(r112);
        AccessibilityConfigEngine.f38243e.clear();
        Iterator<IBaseConfig> r114 = r113.iterator();
    L59:
        if (r114.hasNext() == false) goto L85;
        IBaseConfig r115 = r114.next();
        AccessibilityConfigEngine.c(r115);
        d r116 = r115.getVirtualNode().f38156f;
        if (r116 == null) goto L59;
        Iterator<T> r117 = r116.f38185a.iterator();
    L64:
        if (r117.hasNext() == false) goto L59;
        com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c r118 = (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c) r117.next();
        Iterator<T> r119 = r118.f38183a.iterator();
    L67:
        if (r119.hasNext() == false) goto L76;
        e r120 = (e) r119.next();
        if (r120.f38187b == true) goto L67;
        h r121 = r120.f38188c;
        if (r121 == null) goto L67;
        if (("add dynamic viewIdentifyDsl = " + r121) == null) goto L75;
        Context r122 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L75:
        AccessibilityConfigEngine.f38243e.add(r121);
        goto L67
    L76:
        List<h> r123 = r118.f38184b;
        if (r123 == null) goto L64;
        Iterator<T> r124 = r123.iterator();
    L80:
        if (r124.hasNext() == false) goto L64;
        h r125 = (h) r124.next();
        if (("add dynamic viewidenfify for condition, viewidentify = " + r125) == null) goto L84;
        Context r126 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L84:
        AccessibilityConfigEngine.f38243e.add(r125);
        goto L80
    L85:
        AccessibilityConfigEngine.f38241c = true;
        if (("need dynamic label viewidentify size = " + AccessibilityConfigEngine.f38243e.size()) == null) goto L88;
        Context r127 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L88:
        Context r128 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        r107.f38213a = true;
        return Unit.INSTANCE;
    L34:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r108.iterator();
    L36:
        if (r130.hasNext() == false) goto L51;
        IBaseConfig r131 = (IBaseConfig) r130.next();
        Integer r132 = r131.getVirtualNode().f38152b;
        Iterator r133 = ((ArrayList) r107.f38214b).iterator();
    L39:
        if (r133.hasNext() == false) goto L43;
        Object r134 = r133.next();
        if (Boxing.boxBoolean(Intrinsics.areEqual(((IBaseConfig) r134).getVirtualNode().f38152b, r132)).booleanValue() == false) goto L39;
    L44:
        IBaseConfig r135 = (IBaseConfig) r134;
        if (r135 == null) goto L49;
        boolean r136 = ((ArrayList) r107.f38214b).remove(r135);
        r129.add(r135);
        if (("ApplyStep remove old config, viewId = " + r131.getVirtualNode().f38152b + ", name = " + r131.name() + ", removeSuccess = " + r136) == null) goto L49;
        Context r137 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L49:
        ((ArrayList) r107.f38214b).add(r131);
        goto L36
    L43:
        r134 = null;
        goto L44
    L51:
        if (("ApplyStep remove old config, removeConfigList size = " + r129.size()) == null) goto L53;
        Context r138 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L53:
        AccessibilityConfigEngine.d(r129);
        goto L55
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (this.f38213a == false) goto L21;
        if (Intrinsics.areEqual(r100, Boxing.boxBoolean(false)) == false) goto L21;
        return Unit.INSTANCE;
    L21:
        if (("ApplyStep excute now, remoteConfigSize = " + ((ArrayList) this.f38214b).size()) == null) goto L23;
        Context r139 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L23:
        TransferStep r140 = this.f38215c;
        r102.L$0 = this;
        r102.label = 1;
        r104 = r140.a(r100, r102);
        if (r104 != r105) goto L26;
        return r105;
    L26:
        r107 = this;
    L7:
        r102 = new ApplyStep$excute$1(this, r101);
        goto L8
    }
}
