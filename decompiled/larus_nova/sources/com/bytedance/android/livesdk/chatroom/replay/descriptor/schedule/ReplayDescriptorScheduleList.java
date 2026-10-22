package com.bytedance.android.livesdk.chatroom.replay.descriptor.schedule;

import bl1.j;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import mq1.s;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayDescriptorScheduleList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f108292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f108293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f108294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f108295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f108296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f108297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LayerDescriptorList f108298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayerDescriptorList f108299h;

    public static final class a {
    }

    static {
    }

    public ReplayDescriptorScheduleList() {
        j r100 = new j(Boolean.FALSE);
        this.f108292a = r100;
        this.f108293b = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayDescriptorScheduleList$playerControlBrickService$2.INSTANCE);
        Lazy r101 = LazyKt.lazy(new ReplayDescriptorScheduleList$videoPlayerDescriptors$2(this));
        this.f108294c = r101;
        Lazy r102 = LazyKt.lazy(ReplayDescriptorScheduleList$videoInterActionP1Descriptors$2.INSTANCE);
        this.f108295d = r102;
        Lazy r103 = LazyKt.lazy(new ReplayDescriptorScheduleList$videoInterActionP2Descriptors$2(this));
        this.f108296e = r103;
        Lazy r104 = LazyKt.lazy(new ReplayDescriptorScheduleList$videoInterActionP3Descriptors$2(this));
        this.f108297f = r104;
        LayerDescriptorList r105 = new LayerDescriptorList();
        r105.addAll((LayerDescriptorList) r101.getValue());
        r105.addAll((LayerDescriptorList) r102.getValue());
        r105.addAll((LayerDescriptorList) r103.getValue());
        r105.addAll((LayerDescriptorList) r104.getValue());
        Unit r106 = Unit.INSTANCE;
        this.f108298g = r105;
        LayerDescriptorList r107 = new LayerDescriptorList();
        r107.addAll((LayerDescriptorList) r101.getValue());
        r107.addAll((LayerDescriptorList) r102.getValue());
        r107.addAll((LayerDescriptorList) r103.getValue());
        r107.addAll((LayerDescriptorList) r104.getValue());
        r107.remove(r100);
        this.f108299h = r107;
    }

    public static final s a(ReplayDescriptorScheduleList r100) {
        return (s) r100.f108293b.getValue();
    }
}
