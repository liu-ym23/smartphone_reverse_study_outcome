package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s26.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/BaseAnnieXPropsProvider;", "Ls26/a;", "Lcom/bytedance/android/anniex/ability/service/IAnnieXPropsProvider;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAnnieXPropsProvider extends a implements IAnnieXPropsProvider {
    public BaseAnnieXPropsProvider() {
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXPropsProvider
    public final void t0(String r100, KitType r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "kitType");
    }
}
