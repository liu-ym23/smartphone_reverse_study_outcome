package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorLinkVideoListViewHolder f147200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gf2.a f147201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gf2.a f147202c;

    public c(AnchorLinkVideoListViewHolder r100, gf2.a r101, gf2.a r102) {
        this.f147200a = r100;
        this.f147201b = r101;
        this.f147202c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorLinkVideoListViewHolder.T3(this.f147200a, this.f147201b, this.f147202c);
    }
}
