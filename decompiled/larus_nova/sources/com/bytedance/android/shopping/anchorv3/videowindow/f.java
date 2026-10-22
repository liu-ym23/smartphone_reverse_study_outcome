package com.bytedance.android.shopping.anchorv3.videowindow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.sdk.helper.p;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoWindowSession f165387a;

    public f(VideoWindowSession r100) {
        this.f165387a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = VideoWindowSession.f165362t;
        VideoWindowSession r102 = this.f165387a;
        String r103 = r102.f165378p;
        a r104 = r102.f165381s;
        Context r105 = null;
        if (r104 == null) goto L5;
        Map<String, String> r106 = r104.getBaseParams();
    L6:
        String r107 = VideoWindowSession.a.b(r103, r106);
        if (r107 == null) goto L15;
        Context r108 = this.f165387a.i().getContext();
        if ((r108 instanceof Activity) == false) goto L12;
        r105 = r108;
    L12:
        Activity r109 = (Activity) r105;
        if (r109 == null) goto L15;
        p.f48130a.d(com.bytedance.android.ec.core.btm.c.c(r107, this.f165387a.i(), "a1.b8094.c49952.d9703", new Pair[0]), r109);
    L15:
        a r110 = this.f165387a.f165381s;
        if (r110 == null) goto L19;
        r110.b();
        return;
    L19:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
