package com.bytedance.android.window.shop.holder.factory;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f187959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f187960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fo.b f187961c;

    @Override // com.bytedance.android.ec.hybrid.list.ability.r0
    public final BaseViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return (BaseViewHolder) this.f187959a.invoke(this.f187960b, this.f187961c);
    }

    public g(Function2 r100, Fragment r101, fo.b r102) {
        this.f187959a = r100;
        this.f187960b = r101;
        this.f187961c = r102;
    }
}
