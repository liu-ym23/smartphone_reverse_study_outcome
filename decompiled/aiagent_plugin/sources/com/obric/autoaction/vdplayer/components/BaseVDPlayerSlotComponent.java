package com.obric.autoaction.vdplayer.components;

import com.obric.autoaction.a.g;
import com.obric.autoaction.vdplayer.d.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseVDPlayerSlotComponent<S> extends BaseVDPlayerComponent<S> implements g {
    public BaseVDPlayerSlotComponent(d.h.a.b<? super s, ? extends S> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "selector");
        super(r4);
    }
}
