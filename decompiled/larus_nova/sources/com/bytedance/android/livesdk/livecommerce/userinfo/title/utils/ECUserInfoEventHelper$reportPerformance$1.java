package com.bytedance.android.livesdk.livecommerce.userinfo.title.utils;

import android.os.SystemClock;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.i;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECUserInfoEventHelper$reportPerformance$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $btmPageId;
    final /* synthetic */ String $roomId;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.utils.ECUserInfoEventHelper$reportPerformance$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iAdapterService", "Lcom/bytedance/android/ec/adapter/api/IAdapterService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<IAdapterService, Unit> {
        final /* synthetic */ d $monitor;

        public AnonymousClass1(d r100) {
            this.$monitor = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IAdapterService r100) {
            if (r100 == null) goto L12;
            i r101 = r100.getUxTracerService();
            if (r101 == null) goto L13;
            long r102 = (r101.a("enter_room") - SystemClock.uptimeMillis()) + System.currentTimeMillis();
            r101.b();
            d r103 = this.$monitor;
            if (r103 == null) goto L8;
            r103.d("initial", r102);
        L8:
            d r104 = this.$monitor;
            if (r104 == null) goto L14;
            r104.b("enter_room_api_duration", 0L);
            return;
        L14:
            return;
        L13:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IAdapterService r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public ECUserInfoEventHelper$reportPerformance$1(a r100, String r101, String r102) {
        this.this$0 = r100;
        this.$btmPageId = r101;
        this.$roomId = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
