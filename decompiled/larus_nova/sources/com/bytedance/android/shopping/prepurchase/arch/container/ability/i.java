package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public interface i extends a {
    void appendEventParamToEntranceInfo(String r100, String r101);

    void appendEventParams(Map<String, ? extends Object> r100);

    void appendEventParams(Pair<String, ? extends Object>... r100);

    PageFinder getPageFinder();

    ContainerTrackAbility.a m();

    Map<String, Object> u1();

    void y1(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100);
}
