package com.bytedance.android.ec.core.utils;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f45624a = null;

    public static final class a implements ti.j {
        public a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            CarModelSelectInfo r101 = new CarModelSelectInfo();
            r101.setId(r100.optString("id", ""));
            r101.setModel(r100.optString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, ""));
            a r102 = k.f45624a;
            s0.a(new f1(r101));
        }
    }

    static {
        f45624a = new a();
    }
}
