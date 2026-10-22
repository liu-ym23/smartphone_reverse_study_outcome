package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.host.api.info.IECHostDeviceInfoService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class EComFoldDeviceInfoInjector implements com.bytedance.android.ec.sdk.helper.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EComFoldDeviceInfoInjector f45528b = null;

    public EComFoldDeviceInfoInjector() {
    }

    static {
        f45528b = new EComFoldDeviceInfoInjector();
        f45527a = LazyKt.lazy(EComFoldDeviceInfoInjector$deviceInfoService$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.sdk.helper.u
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Lazy r102 = f45527a;
        IECHostDeviceInfoService r103 = (IECHostDeviceInfoService) r102.getValue();
        Integer r104 = null;
        if (r103 == null) goto L5;
        Integer r105 = r103.getFoldType();
    L6:
        r101.put("ecom_fold_type", r105);
        IECHostDeviceInfoService r106 = (IECHostDeviceInfoService) r102.getValue();
        if (r106 == null) goto L9;
        r104 = r106.getFoldStatus();
    L9:
        r101.put("ecom_fold_status", r104);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
