package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.g;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f152692a = 0;

    public static dm.a.b a() {
        return dm.a.a("ExplainCardShowStrategy");
    }

    static {
    }

    public static void b(String r100, String r101, Map r102, RoomContextController r103, Function1 r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        if (r103 != null) goto L13;
        int r104 = RoomContextController.f151593h;
        r103 = RoomContextController.a.a();
    L13:
        ECContext r105 = r103.r();
        if (r105 == null) goto L17;
        bk2.c.a(new qk2.a().b(new g(r105, r103), false, false, r101, r102).subscribe(new d(r102, r110), e.f152691a), r105.getDisposableContext().getValue());
        return;
    L17:
        return;
    L6:
        if (r103 != null) goto L8;
    L12:
        int r106 = RoomContextController.f151593h;
        r103 = RoomContextController.a.b(r100, null);
        goto L13
    L8:
        if (r103.v() == true) goto L11;
        int r107 = RoomContextController.f151593h;
        r103 = RoomContextController.a.b(r100, r103.D());
    L11:
        if (r103 != null) goto L13;
        goto L12
    }
}
