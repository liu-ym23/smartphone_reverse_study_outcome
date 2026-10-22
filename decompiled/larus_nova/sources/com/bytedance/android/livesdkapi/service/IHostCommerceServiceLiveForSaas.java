package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IHostCommerceServiceLiveForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.service.IHostCommerceServiceLiveForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$tryShowSaasCouponDialog(IHostCommerceServiceLiveForSaas r100, Context r101, Bundle r102, Function1 r103) {
        }
    }

    void tryShowSaasCouponDialog(Context r100, Bundle r101, Function1<JSONObject, Unit> r102);
}
