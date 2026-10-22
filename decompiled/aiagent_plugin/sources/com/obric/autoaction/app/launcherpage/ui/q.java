package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TopExtraLayoutManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public class q extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24462a;

    public q(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        super(r4);
        this.f24462a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public void a(RecyclerView.s r2, int[] r3) {
        d.h.b.o.e(r2, "state");
        d.h.b.o.e(r3, "extraLayoutSpace");
        super.a(r2, r3);
        r3[0] = ZeusTransformUtils.getResources(this.f24462a, "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels / 3;
    }
}
