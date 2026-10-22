package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tabliveguide/LiveInnerCardSkyLightVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerCardSkyLightVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f111639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f111640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f111641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveCircleView f111642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.core.view.a f111643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FeedItem f111644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f111645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, String, Unit> f111646h;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveInnerCardSkyLightVH(View r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        super(r100);
        this.f111646h = r101;
        ImageView r102 = (ImageView) r100.findViewById(R.id.skylight_avatar);
        this.f111639a = r102;
        this.f111640b = (TextView) r100.findViewById(R.id.nick_name_tv);
        this.f111641c = (ImageView) r100.findViewById(R.id.tv_bottom_img_tag);
        LiveCircleView r103 = (LiveCircleView) r100.findViewById(R.id.iv_border_circle);
        this.f111642d = r103;
        this.f111643e = new com.bytedance.android.live.core.view.a(r102, r103, Boolean.FALSE);
        this.f111645g = "asset://com.ss.android.ies.live.sdk/ttlive_inner_card_cover_icon.webp";
    }
}
