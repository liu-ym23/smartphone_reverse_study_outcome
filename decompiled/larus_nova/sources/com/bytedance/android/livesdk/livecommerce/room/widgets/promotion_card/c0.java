package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c0 implements com.bytedance.android.livesdk.livecommerce.room.model.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f152258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f152259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f152260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f152261d;

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String a() {
        return "";
    }

    @Override // ml.b
    public final String d() {
        return "0";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final boolean isAnchor() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String b() {
        int r100 = RoomContextController.f151593h;
        return RoomContextController.a.b(this.f152260c, null).I();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String getGroupId() {
        return (String) this.f152258a.get("group_id");
    }

    @Override // ml.b
    public final String c() {
        return this.f152261d;
    }

    @Override // ml.b
    public final String roomId() {
        return this.f152260c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "carrierType");
        ECEventUtilsV2 r101 = ECEventUtilsV2.f147718b;
        Map r102 = this.f152258a;
        Map r103 = this.f152259b;
        int r104 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;
        String r105 = com.bytedance.android.livesdk.livecommerce.room.controller.w.a.c(r103);
        r101.getClass();
        return ECEventUtilsV2.b(r100, r102, r103, null, null, r105);
    }

    public c0(Map r100, Map r101, String r102, String r103) {
        this.f152258a = r100;
        this.f152259b = r101;
        this.f152260c = r102;
        this.f152261d = r103;
    }
}
