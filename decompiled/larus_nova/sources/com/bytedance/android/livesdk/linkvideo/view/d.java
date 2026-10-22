package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorLinkVideoListViewHolder f147203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gf2.a f147204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gf2.a f147205c;

    public d(AnchorLinkVideoListViewHolder r100, gf2.a r101, gf2.a r102) {
        this.f147203a = r100;
        this.f147204b = r101;
        this.f147205c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorLinkVideoListViewHolder.T3(this.f147203a, this.f147204b, this.f147205c);
    }
}
