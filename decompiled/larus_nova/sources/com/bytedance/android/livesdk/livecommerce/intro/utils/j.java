package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements com.bytedance.android.livesdk.livecommerce.room.model.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f148544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f148545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f148546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f148547d;

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
        return RoomContextController.a.b(this.f148546c, null).I();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String getGroupId() {
        return (String) this.f148544a.get("group_id");
    }

    @Override // ml.b
    public final String c() {
        return this.f148547d;
    }

    @Override // ml.b
    public final String roomId() {
        return this.f148546c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "carrierType");
        ECEventUtilsV2 r101 = ECEventUtilsV2.f147718b;
        Map r102 = this.f148544a;
        Map r103 = this.f148545b;
        int r104 = w.f151719h;
        String r105 = w.a.c(r103);
        r101.getClass();
        return ECEventUtilsV2.b(r100, r102, r103, null, null, r105);
    }

    public j(Map r100, Map r101, String r102, String r103) {
        this.f148544a = r100;
        this.f148545b = r101;
        this.f148546c = r102;
        this.f148547d = r103;
    }
}
