package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f94253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f94254b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.h
    public final void onFailed() {
        this.f94254b.invoke(null);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.h
    public final void a(r r100) {
        this.f94254b.invoke(r100);
        if (r100 == null) goto L8;
        List<p> r101 = r100.getLinkUsers();
        if (r101 == null) goto L9;
        this.f94253a.f94235f.setValue(r101);
        return;
    L9:
        return;
    }

    public d(a r100, Function1 r101) {
        this.f94253a = r100;
        this.f94254b = r101;
    }
}
