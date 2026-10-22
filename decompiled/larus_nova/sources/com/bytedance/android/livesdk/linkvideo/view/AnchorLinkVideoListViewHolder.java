package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/view/AnchorLinkVideoListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoListViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f147184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f147185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f147186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f147187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f147188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f147189f;

    public AnchorLinkVideoListViewHolder(View r100, boolean r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f147188e = r101;
        this.f147189f = r102;
        this.f147184a = (HSImageView) r100.findViewById(R.id.item_cover);
        this.f147185b = (ImageView) r100.findViewById(R.id.item_select);
        this.f147186c = r100.findViewById(R.id.v_item_select);
        this.f147187d = (TextView) r100.findViewById(R.id.item_like_count_tv);
    }

    public static final void T3(AnchorLinkVideoListViewHolder r100, gf2.a r101, gf2.a r102) {
        r100.getClass();
        if (r101 == null) goto L5;
        Long r103 = r101.b();
    L7:
        if (Intrinsics.areEqual(r103, r102.b()) == false) goto L11;
        h r104 = r100.f147189f;
        if (r104 == null) goto L15;
        r104.Ao(null, false);
        return;
    L15:
        return;
    L11:
        h r105 = r100.f147189f;
        if (r105 == null) goto L17;
        r105.Ao(r102, true);
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
