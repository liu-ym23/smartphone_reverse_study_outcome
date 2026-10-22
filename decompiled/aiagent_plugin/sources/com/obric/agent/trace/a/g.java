package com.obric.agent.trace.a;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BindingViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends a<com.obric.agent.c.b> {
    private final ConstraintLayout r;
    private final TextView s;

    public g(com.obric.agent.c.b r3) {
        o.e(r3, "binding");
        super((androidx.viewbinding.a) ZeusTransformUtils.preCheckCast(r3, androidx.viewbinding.a.class, "com.obric.aiagent.plugin"));
        ConstraintLayout r0 = r3.f14255a;
        o.c(r0, "content");
        this.r = r0;
        TextView r4 = r3.f14256b;
        o.c(r4, "text");
        this.s = r4;
    }
}
