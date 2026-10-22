package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.prepurchase.arch.container.intf.f, com.bytedance.android.shopping.prepurchase.arch.container.intf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f180816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f180817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<Configuration, Unit>> f180818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.f f180819d;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void H() {
        this.f180819d.H();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void e(boolean r100) {
        this.f180819d.e(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Window f7() {
        return this.f180819d.f7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final FragmentManager g7() {
        return this.f180819d.g7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final ViewGroup getContainerView() {
        return this.f180819d.getContainerView();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public FragmentActivity getContext() {
        return this.f180819d.getContext();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a i7() {
        return this.f180819d.i7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Object k7() {
        return this.f180819d.k7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.g
    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f180817b).add(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.g
    public final void b(Function1<? super Configuration, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f180818c).add(r100);
    }

    public final void c(Lifecycle.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f180816a.f(r100);
    }

    public a(e r100, com.bytedance.android.shopping.prepurchase.arch.container.intf.f r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "containerAbility");
        this.f180819d = r101;
        this.f180816a = new LifecycleRegistry(r100);
        this.f180817b = new ArrayList();
        this.f180818c = new ArrayList();
    }
}
