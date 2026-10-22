package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {
    public a() {
    }

    public abstract ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> a(int r100, Fragment r101, fo.b r102);

    public Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        return MapsKt.emptyMap();
    }
}
