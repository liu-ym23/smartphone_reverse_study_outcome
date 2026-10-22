package com.bytedance.android.livesdk.linkvideo.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends me.drakeet.multitype.b<f, AnchorLinkVideoLoadingMoreViewHolder> {
    public e() {
    }

    @Override // me.drakeet.multitype.b
    public final void e(RecyclerView.ViewHolder r100) {
        AnchorLinkVideoLoadingMoreViewHolder r101 = (AnchorLinkVideoLoadingMoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f147192c != 1) goto L8;
        LiveDoubleColorBallAnimationView r102 = r101.f147190a;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void f(RecyclerView.ViewHolder r100) {
        AnchorLinkVideoLoadingMoreViewHolder r101 = (AnchorLinkVideoLoadingMoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f147192c != 1) goto L8;
        LiveDoubleColorBallAnimationView r102 = r101.f147190a;
        if (r102 == null) goto L9;
        r102.c();
        return;
    L9:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, f r101) {
        AnchorLinkVideoLoadingMoreViewHolder r102 = (AnchorLinkVideoLoadingMoreViewHolder) r100;
        f r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        int r104 = r103.f147206a;
        r102.f147192c = r104;
        if (r104 != 1) goto L10;
        LiveDoubleColorBallAnimationView r105 = r102.f147190a;
        if (r105 == null) goto L7;
        r105.setVisibility(0);
    L7:
        TextView r106 = r102.f147191b;
        if (r106 == null) goto L17;
        r106.setVisibility(8);
        return;
    L17:
        return;
    L10:
        LiveDoubleColorBallAnimationView r107 = r102.f147190a;
        if (r107 == null) goto L13;
        r107.setVisibility(8);
    L13:
        TextView r108 = r102.f147191b;
        if (r108 == null) goto L19;
        r108.setVisibility(0);
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new AnchorLinkVideoLoadingMoreViewHolder(r100.inflate(R.layout.ttlive_layout_link_video_list_loading_more_footer, r101, false));
    }
}
