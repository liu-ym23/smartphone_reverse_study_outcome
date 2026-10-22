package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 extends RecyclerView.Adapter<f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f72613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.s f72614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<TalkRoomBaseDynamicEmoji> f72615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f72616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f72617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f72618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f72619g;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f72615c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        f0 r101 = (f0) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r102 = r101.f72623c;
        if (r102 == null) goto L6;
        i0 r103 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.k(this.f72618f, this.f72619g, r102, true);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        f0 r102 = (f0) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TalkRoomBaseDynamicEmoji r103 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.f72615c, r101);
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L7;
        r102.itemView.setVisibility(4);
        return;
    L7:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "emoji");
        r102.f72623c = r103;
        ImageUtil.loadImage(r102.f72621a, r103.getEmojiImage(), R.drawable.ttlive_icon_default_emoji);
        r102.f72622b.setText(r103.getEmojiName());
        r102.itemView.setOnClickListener(new d0(r103, this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_digit_avatar_emoji_vh, r100, false);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.width = s1.y() / this.f72617e;
        return new f0(r102);
    }

    public e0(int r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        this.f72616d = r100;
        this.f72617e = r101;
        this.f72618f = r102;
        this.f72619g = r103;
        this.f72613a = r100 * r101;
        this.f72615c = new ArrayList();
    }
}
