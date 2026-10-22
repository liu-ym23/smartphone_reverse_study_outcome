package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.apiImpl;

import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECStageTriggerSource;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.SessionSettingUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.a;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c;
import com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/apiImpl/MallSessionServiceImpl;", "Lcom/bytedance/android/shopping/api/mall/mallSession/IMallSessionService;", "<init>", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallSessionServiceImpl implements IMallSessionService {
    public MallSessionServiceImpl() {
    }

    @Override // com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService
    public final void a(String r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (((Boolean) SessionSettingUtil.f170348e.getValue()).booleanValue() == false) goto L6;
        CopyOnWriteArrayList<WeakReference<c>> r103 = a.f170351a;
        a.a(r100, r101, r102, ECStageTriggerSource.GENERAL.getType(), null);
        return;
    }
}
