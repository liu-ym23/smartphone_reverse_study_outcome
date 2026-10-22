package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.vivo.push.PushClientConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleScene<View, c, q> f171459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f171460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardListObjectContainer f171461c;

    public final Context e() {
        return this.f171461c.getContext();
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onCreate() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171453d;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onDestroy() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171458i;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onPause() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171456g;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onResume() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171455f;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onStart() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171454e;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onStop() {
        SimpleScene<View, c, q> r100 = this.f171459a;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f171457h;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    public b(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f171461c = r100;
        LifecycleOwner r101 = r100.f171543c;
        if (r101 != null) goto L7;
        r101 = r100.f171544d;
        if (r101 != null) goto L7;
        throw new Exception("访问了不存在了lifecycle");
    L7:
        this.f171460b = r101;
    }

    public final <T extends a> T f(KClass<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        return (T) this.f171461c.b(r100);
    }
}
