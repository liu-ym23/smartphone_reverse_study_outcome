package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "Lcom/bytedance/android/anniex/base/service/e;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class IAnnieXBizPropsProvider implements e {
    public IAnnieXBizPropsProvider() {
    }

    public void a(Map<String, Object> r100, KitType r101, String r102, Uri r103) {
        Intrinsics.checkNotNullParameter(r100, "originProps");
        Intrinsics.checkNotNullParameter(r101, "kitType");
        Intrinsics.checkNotNullParameter(r102, "bid");
        Intrinsics.checkNotNullParameter(r103, "uri");
    }

    public Map<String, Object> b(KitType r100, String r101, Uri r102) {
        Intrinsics.checkNotNullParameter(r100, "kitType");
        Intrinsics.checkNotNullParameter(r101, "bid");
        Intrinsics.checkNotNullParameter(r102, "uri");
        return null;
    }

    public Map<String, Object> c(String r100, KitType r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "kitType");
        return null;
    }
}
