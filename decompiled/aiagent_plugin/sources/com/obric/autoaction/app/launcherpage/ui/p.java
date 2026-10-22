package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import com.obric.oui.orecyclerview.widget.GridLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TopExtraGridLayoutManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends GridLayoutManager {
    private final Context z;

    public p(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        super(r5, r4);
        this.z = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public void a(RecyclerView.s r2, int[] r3) {
        d.h.b.o.e(r2, "state");
        d.h.b.o.e(r3, "extraLayoutSpace");
        super.a(r2, r3);
        r3[0] = ZeusTransformUtils.getResources(this.z, "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels / 3;
    }
}
