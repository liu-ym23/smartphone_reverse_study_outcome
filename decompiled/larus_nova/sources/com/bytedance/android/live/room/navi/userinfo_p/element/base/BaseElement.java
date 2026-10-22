package com.bytedance.android.live.room.navi.userinfo_p.element.base;

import aa1.a;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m91.b;
import m91.c;
import m91.d;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "Lm91/c;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseElement implements c, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f99895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f99896c;

    @Override // m91.c
    public final boolean a() {
        return this.f99896c.a();
    }

    @Override // m91.c
    public final a b() {
        return this.f99896c.b();
    }

    @Override // m91.c
    public final boolean c() {
        return true;
    }

    @Override // m91.c
    public final LifecycleOwner e() {
        return this.f99896c.e();
    }

    public void f() {
    }

    @Override // m91.c
    public final k getAvatarThumb() {
        return null;
    }

    @Override // m91.c
    public Context getContext() {
        return this.f99896c.getContext();
    }

    @Override // m91.c
    public final DataCenter getDataCenter() {
        return this.f99896c.getDataCenter();
    }

    @Override // m91.c
    public final Fragment getFragment() {
        return this.f99896c.getFragment();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // m91.c
    public final String getName() {
        return "";
    }

    @Override // m91.c
    public final IRoom getRoom() {
        return this.f99896c.getRoom();
    }

    @Override // m91.c
    public final DataContext getRoomContext() {
        return this.f99896c.getRoomContext();
    }

    @Override // m91.c
    public final boolean isAnchor() {
        return this.f99896c.isAnchor();
    }

    @Override // m91.c
    public final boolean isPortrait() {
        return this.f99896c.isPortrait();
    }

    public void h() {
        ALogger.d(g(), "WIDGET onInit");
    }

    public void i() {
        ALogger.d(g(), "WIDGET onLoad");
    }

    public void j() {
        ALogger.d(g(), "WIDGET onUnload");
    }

    public void k() {
        ALogger.d(g(), "WIDGET onWidgetPrepareViewOnLoad");
    }

    public String g() {
        return this.f99894a;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f99895b;
    }

    public BaseElement(d r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        this.f99896c = r100;
        this.f99894a = "Element";
        this.f99895b = new LifecycleRegistry(this);
    }

    public void l(IRoom r100) {
        ALogger.d(g(), "WIDGET onWidgetRoomEntered");
    }

    public final void m(Observable r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeElement");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeElement");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        ((ObservableSubscribeProxy) r100.as(AutoDispose.bind(this.f99896c.e()))).subscribe(new m91.a(this, r101), new b(this));
    }
}
