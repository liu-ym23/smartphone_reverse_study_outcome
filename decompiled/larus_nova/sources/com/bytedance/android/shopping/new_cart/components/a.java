package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CartObjectContainer f178820a;

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public final NewCartActivity c() {
        return this.f178820a.getActivity();
    }

    public final Context e() {
        return this.f178820a.getContext();
    }

    public final LifecycleOwner f() {
        NewCartActivity r100 = c();
        if (r100 == null) goto L5;
        return r100;
    L5:
        Fragment r101 = this.f178820a.f178936f;
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new Exception("访问了不存在了lifecycle");
    }

    public a(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f178820a = r100;
    }

    public final <T extends a> T g(KClass<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        return (T) this.f178820a.a(r100);
    }
}
