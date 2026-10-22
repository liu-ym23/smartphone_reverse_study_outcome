package com.bytedance.android.live.liveinteract.plantform.utils;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f77498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f77499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f77501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f77502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f77503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.o f77504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hg6.g f77505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LifecycleOwner f77506i;

    public final boolean a() {
        com.bytedance.android.livesdk.chatroom.o r100 = this.f77504g;
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.X1();
        if (r101 == null) goto L8;
        if (r101.getValue().booleanValue() != true) goto L8;
        return true;
    L8:
        com.bytedance.android.livesdk.chatroom.o r102 = this.f77504g;
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.n2();
        if (r103 == null) goto L15;
        if (r103.getValue().booleanValue() != true) goto L15;
        return true;
    L15:
        return false;
    }

    public final void b() {
        if (((Boolean) vm2.d.f555872j5.getValue(null, vm2.d.f555776a[319(0x13f, float:4.47E-43)])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f77503f == false) goto L8;
        return;
    L8:
        this.f77503f = true;
        if (a() == true) goto L23;
        int r100 = this.f77498a.getStreamMaxVolume(0);
        float r101 = this.f77501d;
        if (r101 <= 0) goto L22;
        int r102 = (int) (r100 * r101);
        if (r102 > r100) goto L17;
        r100 = r102;
    L17:
        int r103 = this.f77498a.getStreamVolume(0);
        this.f77498a.getMode();
        if (r103 > r100) goto L23;
        if (r100 <= 0) goto L22;
        this.f77498a.setStreamVolume(0, r100, 0);
    L22:
        this.f77501d = 0.0f;
    L23:
        this.f77502e.add(((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.a.class).as(AutoDispose.bind(this.f77506i))).subscribe(new l0(this)));
        com.bytedance.android.livesdk.chatroom.o r104 = this.f77504g;
        if (r104 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.X1();
        if (r105 == null) goto L34;
        Observable<Boolean> r106 = r105.a();
        if (r106 == null) goto L34;
        ObservableSubscribeProxy r107 = (ObservableSubscribeProxy) r106.as(AutoDispose.bind(this.f77506i));
        if (r107 == null) goto L34;
        Disposable r108 = r107.subscribe(new j0(this));
        if (r108 == null) goto L34;
        this.f77502e.add(r108);
    L34:
        com.bytedance.android.livesdk.chatroom.o r109 = this.f77504g;
        if (r109 == null) goto L46;
        com.bytedance.live.datacontext.m<Boolean> r110 = r109.n2();
        if (r110 == null) goto L47;
        Observable<Boolean> r111 = r110.a();
        if (r111 == null) goto L48;
        ObservableSubscribeProxy r112 = (ObservableSubscribeProxy) r111.as(AutoDispose.bind(this.f77506i));
        if (r112 == null) goto L49;
        Disposable r113 = r112.subscribe(new k0(this));
        if (r113 == null) goto L50;
        this.f77502e.add(r113);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void c() {
        CompositeDisposable r100 = this.f77502e;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f77503f = false;
    }

    public final void d() {
        if (((Boolean) vm2.d.f555872j5.getValue(null, vm2.d.f555776a[319(0x13f, float:4.47E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        int r100 = this.f77498a.getStreamVolume(3);
        int r101 = this.f77498a.getStreamMaxVolume(3);
        if (r101 <= 0) goto L8;
        float r102 = r100 / r101;
    L9:
        this.f77501d = r102;
        this.f77498a.getMode();
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    public m0(Context r100, com.bytedance.android.livesdk.chatroom.o r101, hg6.g r102, LifecycleOwner r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "lifecycleOwner");
        this.f77504g = r101;
        this.f77505h = r102;
        this.f77506i = r103;
        Object r104 = r100.getSystemService("audio");
        if (r104 == null) goto L7;
        this.f77498a = (AudioManager) r104;
        this.f77499b = 100;
        this.f77500c = ((Number) vm2.d.f555882k5.getValue(null, vm2.d.f555776a[320(0x140, float:4.48E-43)])).intValue();
        this.f77502e = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
