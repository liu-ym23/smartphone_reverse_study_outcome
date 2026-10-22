package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftListPreLoadService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f131307i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f131308j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f131309k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f131310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f131311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f131312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f131313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x f131314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y f131315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f131316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final yz0.g f131317h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f131318a = null;

        static {
            f131318a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_DISABLE_SORT_REQUEST_PROP_LIST", "getLIVE_DISABLE_SORT_REQUEST_PROP_LIST()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_SORT_MSG_REQUEST_GIFT_LIST_DELAY", "getLIVE_SORT_MSG_REQUEST_GIFT_LIST_DELAY()J", 0))};
        }

        public a() {
        }
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
        f131309k = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r100 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_sort_request_prop_list", Boolean.FALSE, Boolean.TYPE, false);
        KProperty<?>[] r101 = a.f131318a;
        KProperty<?> r110 = r101[0];
        f131307i = UltraSettingsManager.a().a(r100.f271017a, r100.f271018b, r100.getType(), r100.f271020d, r110);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sort_msg_request_gift_list_delay", 0L, Long.TYPE, false);
        KProperty<?> r103 = r101[1];
        f131308j = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r103);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.f131310a.getValue()).b() == true) goto L5;
        return;
    L5:
        this.f131313d = true;
        ((rq2.a) vh6.c.b(rq2.a.class)).bm(new b());
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (this.f131313d == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).removeGiftListPreloadCallback();
    }

    public final void a(final int r110, final ca0.w r111, final Map<String, String> r210) {
        final IRoom r100 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getOwner() == null) goto L8;
        IBaseUser r101 = r100.getOwner();
        Intrinsics.checkNotNull(r101);
        final String r102 = com.bytedance.android.live.base.model.user.o.a(r101);
    L10:
        if (CollectionsKt.listOf(new Integer[]{512, 1024}).contains(1) == true) goto L18;
        a r103 = f131309k;
        r103.getClass();
        if (((Boolean) f131307i.getValue(r103, a.f131318a[0])).booleanValue() == true) goto L18;
        long r112 = r100.getId();
        String r104 = r100.getAnchorId();
        if (r104 != null) goto L16;
        String r113 = "";
    L17:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(r112, r113, 1, r100.getId());
        goto L18
    L16:
        r113 = r104;
    L18:
        long r114 = 0;
        if (r110 == 16) goto L21;
    L23:
        long r115 = 0;
    L25:
        if (r110 == 16) goto L27;
    L44:
        final int r105 = 1;
        v02.b.a(r115, false, new GiftListPreLoadService$syncGiftListForSort$2(this, r111, r100, r105, r110, r102, r210), 6);
        return;
    L27:
        if (((com.bytedance.android.livesdk.gift.configmodel.u0) this.f131311b.getValue()).m() <= 0) goto L44;
        IBaseUser r106 = this.f131317h.getRoom().getOwnerKt();
        if (r106 == null) goto L34;
        Intrinsics.checkNotNullParameter(r106, "$this$secUidExt");
        String r107 = r106.getCastSecUid();
        if (r107 == null) goto L34;
        String r108 = r107;
    L35:
        String r109 = String.valueOf(r100.getId()) + "_" + r108;
        Long r116 = (Long) ((LinkedHashMap) this.f131312c).get(r109);
        if (r116 == null) goto L39;
        r114 = r116.longValue();
    L39:
        if ((System.currentTimeMillis() - r114) < ((com.bytedance.android.livesdk.gift.configmodel.u0) this.f131311b.getValue()).m()) goto L41;
        this.f131312c.put(r109, Long.valueOf(System.currentTimeMillis()));
        final int r117 = 1;
        final String r118 = r102;
        final String r119 = r108;
        v02.b.a(r115, false, new GiftListPreLoadService$syncGiftListForSort$1(r111, r100, r117, r110, r118, r119, r210), 6);
        return;
    L41:
        return;
    L34:
        r108 = "";
        goto L35
    L21:
        if (i12.m.f487958e2.a() == null) goto L23;
        a r120 = f131309k;
        r120.getClass();
        r115 = ((Number) f131308j.getValue(r120, a.f131318a[1])).longValue();
        goto L25
    L8:
        r102 = "";
        goto L10
    }

    public GiftListPreLoadService(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r100, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r101, DataCenter r102, yz0.g r103) {
        Intrinsics.checkNotNullParameter(r100, "recommendReceiverService");
        Intrinsics.checkNotNullParameter(r101, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r102, "mDataCenter");
        Intrinsics.checkNotNullParameter(r103, "roomDataService");
        this.f131314e = r100;
        this.f131315f = r101;
        this.f131316g = r102;
        this.f131317h = r103;
        this.f131310a = LazyKt.lazy(GiftListPreLoadService$liveGiftListPreloadConfig$2.INSTANCE);
        this.f131311b = LazyKt.lazy(GiftListPreLoadService$panelOpenOptConfig$2.INSTANCE);
        this.f131312c = new LinkedHashMap();
    }
}
