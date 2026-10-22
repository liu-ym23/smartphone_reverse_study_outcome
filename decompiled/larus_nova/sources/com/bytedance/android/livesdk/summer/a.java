package com.bytedance.android.livesdk.summer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.service.GlobalLiveLifecycle;
import com.bytedance.android.livesdkapi.service.IAcceleratedService;
import com.bytedance.android.livesdkapi.service.ILiveLifecycle;
import com.bytedance.android.livesdkapi.service.ISummerService;
import com.bytedance.android.livesdkapi.service.LiveLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IAcceleratedService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f158439b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAcceleratedService f158440a;

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final int attachTask(int r100, LiveLifecycle r101, Context r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f158440a.attachTask(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachTask(int r100, LiveLifecycle r101, String r102, Function0<? extends R> r103) {
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r103, "action");
        return this.f158440a.attachTask(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachTask(int r100, LiveLifecycle r101, String r110, Function0<? extends R> r111, Function1<? super R, Unit> r112) {
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r111, "action");
        Intrinsics.checkNotNullParameter(r112, "recovery");
        return this.f158440a.attachTask(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachTask(LiveLifecycle r100, String r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r102, "action");
        return this.f158440a.attachTask(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachToHost(@ISummerService.TaskID int r100, int r101, int r110, int r111, Function0<? extends R> r112) {
        Intrinsics.checkNotNullParameter(r112, "action");
        return this.f158440a.attachToHost(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachToHost(@ISummerService.TaskID int r100, int r101, int r102, Function0<? extends R> r103) {
        Intrinsics.checkNotNullParameter(r103, "action");
        return this.f158440a.attachToHost(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final int attachToRoom(int r100, Context r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f158440a.attachToRoom(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachToRoom(int r100, String r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r102, "action");
        return this.f158440a.attachToRoom(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachToRoom(int r100, String r101, Function0<? extends R> r102, Function1<? super R, Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "recovery");
        return this.f158440a.attachToRoom(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <R> int attachToRoom(String r100, Function0<? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return this.f158440a.attachToRoom(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final GlobalLiveLifecycle getGlobalLiveLifecycle(int r100) {
        return this.f158440a.getGlobalLiveLifecycle(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final int getLiveTheme() {
        return this.f158440a.getLiveTheme();
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <T extends View> View lookup(int r100, Class<T> r101, Context r110, ViewGroup r111, int r112) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f158440a.lookup(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <T> T lookup(int r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) this.f158440a.lookup(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <T> T lookup(int r100, Class<T> r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "action");
        return (T) this.f158440a.lookup(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <T> T lookup(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f158440a.lookup(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final <T> T lookup(Class<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "action");
        return (T) this.f158440a.lookup(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onEnter(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onEnter(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onExit(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onExit(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onInLive(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onInLive(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onLaunch(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onLaunch(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onPreload(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onPreload(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void onShutdown(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f158440a.onShutdown(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void release(int r100) {
        this.f158440a.release(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IAcceleratedService
    public final void setLiveTheme(int r100) {
        this.f158440a.setLiveTheme(r100);
    }

    static {
        f158439b = new a();
    }

    public a() {
        IAcceleratedService r100 = (IAcceleratedService) jc1.k.f(IAcceleratedService.class);
        if (r100 != null) goto L5;
        r100 = new AcceleratedService();
    L5:
        this.f158440a = r100;
    }

    public static int b(j r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        GlobalLiveLifecycle r101 = f158439b.getGlobalLiveLifecycle(1);
        IAcceleratedService r102 = (IAcceleratedService) jc1.k.f(IAcceleratedService.class);
        if ((r102 instanceof AcceleratedService) == true) goto L5;
        return -1;
    L5:
        return ((AcceleratedService) r102).attachTaskInternal(r101, r100);
    }
}
