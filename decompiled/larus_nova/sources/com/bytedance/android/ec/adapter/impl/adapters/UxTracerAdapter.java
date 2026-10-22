package com.bytedance.android.ec.adapter.impl.adapters;

import com.bytedance.android.ec.adapter.api.i;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class UxTracerAdapter implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UxTracerAdapter f42731b = null;

    public UxTracerAdapter() {
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void b() {
        Intrinsics.checkNotNullParameter("enter_room_api_duration", "name");
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void getSingleTimeStamp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    static {
        f42731b = new UxTracerAdapter();
        f42730a = LazyKt.lazy(UxTracerAdapter$liveTracer$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter("start", "milestone");
        return ((ILiveUxTracer) f42730a.getValue()).getTimeStamp(r100, "start");
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final Object getArgument(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((ILiveUxTracer) f42730a.getValue()).getArgument(r100);
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void setBeforeReportCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ILiveUxTracer) f42730a.getValue()).setBeforeReportCallback(r100);
    }
}
