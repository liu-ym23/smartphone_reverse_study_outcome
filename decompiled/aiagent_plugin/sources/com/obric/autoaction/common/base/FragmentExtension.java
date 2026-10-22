package com.obric.autoaction.common.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentExtension<C extends b> extends BaseExtension<C, Fragment> {
    public FragmentExtension(C r3, Fragment r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "config");
        o.e(r4, "host");
        super(r5, (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.aiagent.plugin"));
    }
}
