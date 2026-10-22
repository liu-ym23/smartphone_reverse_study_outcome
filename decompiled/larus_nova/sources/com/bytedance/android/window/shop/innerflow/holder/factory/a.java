package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.c;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f189160a = null;

    public a() {
    }

    static {
        f189160a = new a();
    }

    public static View a(Context r100, int r101) {
        ShoppingAsyncInflater.f45268e.getClass();
        View r102 = c.a(ShoppingAsyncInflater.a.a(r100), r101, null, 6);
        f189160a.getClass();
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r102;
    }
}
