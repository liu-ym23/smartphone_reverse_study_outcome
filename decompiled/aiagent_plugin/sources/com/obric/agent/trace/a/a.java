package com.obric.agent.trace.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BindingViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a<T extends androidx.viewbinding.a> extends RecyclerView.u {
    private final T r;

    public a(T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r3, androidx.viewbinding.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "binding");
        super(r4.a());
        this.r = r4;
    }
}
