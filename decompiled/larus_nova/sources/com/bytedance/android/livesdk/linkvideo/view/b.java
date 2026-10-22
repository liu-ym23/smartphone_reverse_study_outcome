package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorLinkVideoListViewHolder f147198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gf2.a f147199b;

    public b(AnchorLinkVideoListViewHolder r100, gf2.a r101) {
        this.f147198a = r100;
        this.f147199b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h r101 = this.f147198a.f147189f;
        if (r101 == null) goto L10;
        Long r102 = this.f147199b.b();
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L8:
        r101.XJ(r103);
        return;
    L7:
        r103 = 0;
        goto L8
    }
}
