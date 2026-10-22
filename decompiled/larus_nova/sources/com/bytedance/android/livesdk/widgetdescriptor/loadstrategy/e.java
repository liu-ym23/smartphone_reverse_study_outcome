package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import android.os.Handler;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Iterator;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f162405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mg2.d f162406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widgetdescriptor.priority.c f162407d;

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void onDestroy() {
        if (this.f162405b == false) goto L5;
        return;
    L5:
        c.b(LiveCommonConstants.REASON_ON_DEDTROY);
        this.f162405b = true;
        ((Handler) this.f162404a.getValue()).removeCallbacksAndMessages(null);
        this.f162407d.release();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void a(Runnable r100) {
        c.b("loadP2Group");
        e(this.f162407d.b(), r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void b(Runnable r100) {
        c.b("loadP0Group");
        e(this.f162407d.d(), r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void c(Runnable r100) {
        c.b("loadP1Group");
        e(this.f162407d.a(), r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void d(Runnable r100) {
        c.b("loadOtherGroup");
        e(this.f162407d.c(), r100);
    }

    public e(mg2.d r100, com.bytedance.android.livesdk.widgetdescriptor.priority.b r101) {
        Intrinsics.checkNotNullParameter(r100, "componentManager");
        Intrinsics.checkNotNullParameter(r101, "priorityOperator");
        this.f162406c = r100;
        this.f162407d = r101;
        this.f162404a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DescriptorLoadTogetherStrategy$sHandler$2.INSTANCE);
    }

    public final void e(TreeMap<Double, a> r100, Runnable r101) {
        if (this.f162405b == false) goto L5;
        return;
    L5:
        LayerDescriptorList r102 = new LayerDescriptorList();
        LayerDescriptorList r103 = new LayerDescriptorList();
        Iterator<T> r104 = r100.values().iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        a r105 = (a) r104.next();
        LayerDescriptorList r106 = r105.f162382a;
        if (r106 == null) goto L11;
        r102.addAll(r106);
    L11:
        LayerDescriptorList r107 = r105.f162383b;
        if (r107 == null) goto L7;
        r103.addAll(r107);
        goto L7
    L14:
        this.f162406c.b(mg2.e.f513710c, r102);
        this.f162406c.b(mg2.e.f513712e, r103);
        r101.run();
    }
}
