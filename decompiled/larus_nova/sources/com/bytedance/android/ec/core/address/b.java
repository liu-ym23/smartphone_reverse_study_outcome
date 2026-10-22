package com.bytedance.android.ec.core.address;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.RecommendAddressConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AddressItemVO f43677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f43678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f43679c;

    public final void a() {
        this.f43677a = null;
        this.f43679c = null;
    }

    public b() {
        this.f43678b = z.j() + ((long) 1800);
        this.f43679c = null;
    }

    public final void update(AddressItemVO r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = r100.getAddressVO();
    L5:
        this.f43679c = r101;
        if (r100 == null) goto L10;
        RecommendAddressConfig r102 = r100.getConfig();
        if (r102 == null) goto L10;
        this.f43678b = r102.getInvalidTime();
    L10:
        this.f43677a = r100;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void update(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f43679c = r100.f43679c;
        this.f43678b = r100.f43678b;
        this.f43677a = r100.f43677a;
    }
}
