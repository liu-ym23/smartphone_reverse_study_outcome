package com.bytedance.android.live.core.tetris;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.c;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import j70.f;
import j70.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/IComponentManager;", "Landroidx/lifecycle/LifecycleOwner;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IComponentManager extends LifecycleOwner {
    void C8();

    void L3(LayerDescriptorList r100, boolean r101, boolean r102, boolean r103);

    void X7(h<? extends h70.b> r100);

    void c5(c r100, q r101);

    com.bytedance.android.live.core.tetris.componentx.a config();

    void dd(LayerDescriptorList r100);

    void dl(f r100);

    Element<?> f2(f r100);

    void iS(c r100, ComponentSchedulingManager.ScenInfo r101, Map r102, e0 r103, j r104, q r105);

    <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r100, LayerIndex r101);

    void q6(List<? extends f> r100, Map<f70.b, List<f>> r101);

    void release();

    void rq(BatchTogetherConditionManager.BatchLoadConditionType r100);
}
