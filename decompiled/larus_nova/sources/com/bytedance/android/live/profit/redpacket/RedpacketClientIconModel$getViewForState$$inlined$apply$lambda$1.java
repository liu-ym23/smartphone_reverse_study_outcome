package com.bytedance.android.live.profit.redpacket;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"loadAnnieCard", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/profit/redpacket/RedpacketClientIconModel$getViewForState$1$1"}, k = 3, mv = {1, 4, 3})
final class RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h1 $state$inlined;
    final /* synthetic */ xr2.g $this_apply;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ b1 this$0;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 f88577a;

        public a(RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r100) {
            this.f88577a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f88577a.this$0.onClick();
        }
    }

    public RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1(xr2.g r100, long r101, b1 r102, h1 r103) {
        this.$this_apply = r100;
        this.$timestamp = r101;
        this.this$0 = r102;
        this.$state$inlined = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r100 = null;
        com.bytedance.android.live.revenue.common.x0 r101 = new com.bytedance.android.live.revenue.common.x0((String) i1.f88631n.getValue(null, i1.f88618a[11]));
        r101.d("url").b("timestamp", String.valueOf(this.$timestamp));
        b1 r102 = this.this$0;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r103 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.this$0.getContext(), r101.c(), RedpacketClientIconModel$getViewForState$1$1$1.INSTANCE);
        if (r103 == null) goto L14;
        b1 r104 = this.this$0;
        String r105 = ((h1.b) this.$state$inlined).f88614b;
        boolean r106 = b1.f88584m;
        r104.getClass();
        xy0.a<?> r107 = r103.g();
        if (r107 == null) goto L7;
        r107.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("data_from_native", r105)));
    L7:
        this.$this_apply.setContentView(r103.f91466c);
        View r108 = this.$this_apply.getContentView();
        if (r108 == null) goto L10;
        r108.setOnClickListener(new a(this));
    L10:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r109 = r103.f91467d;
        if (r109 == null) goto L13;
        r109.load(null, null);
    L13:
        Unit r110 = Unit.INSTANCE;
        r100 = r103;
    L14:
        r102.f88585f = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
