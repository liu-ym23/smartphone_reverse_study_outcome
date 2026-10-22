package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;
import zg1.t2;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/RoomStickerDecorationImageViewHolder;", "Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/AbsRoomStickerDecorationViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStickerDecorationImageViewHolder extends AbsRoomStickerDecorationViewHolder<RoomDecoration> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f113691a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f113692a = null;

        static {
            f113692a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (c.a(r100) == true) goto L5;
            return;
        L5:
            Object r101 = r100.getTag();
            if (r101 == null) goto L10;
            RoomDecoration r102 = (RoomDecoration) r101;
            com.bytedance.android.live.liveinteract.api.utils.a.f71509a.getClass();
            com.bytedance.android.live.liveinteract.api.utils.a.C1154a.c(r102);
            b.a().post(new t2(r102));
            com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.b(0);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration");
        }
    }

    public RoomStickerDecorationImageViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f113691a = (ImageView) r100.findViewById(R.id.sticker_image_item);
        r100.setOnClickListener(a.f113692a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.AbsRoomStickerDecorationViewHolder
    public final void T3(RoomDecoration r100) {
        RoomDecoration r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "roomDecoration");
        this.itemView.setTag(r101);
        if (r101.getImage() != null) goto L5;
    L9:
        ImageView r102 = this.f113691a;
        if (r102 == null) goto L17;
        long r103 = r101.getId();
        AnchorStickerWrapperWidget.F.getClass();
        if (r103 != AnchorStickerWrapperWidget.E) goto L14;
        float r104 = 0.3f;
    L15:
        r102.setAlpha(r104);
        return;
    L14:
        r104 = 1.0f;
        goto L15
    L17:
        return;
    L5:
        if (r101.getImage().getUrls() == null) goto L9;
        if (r101.getImage().getUrls().size() <= 0) goto L9;
        ((f) TTLiveSDKContext.getHostService()).f157991a.frescoHelper().loadFirstAvailableImageBitmap(r101.getImage(), new mo1.a(this));
        goto L9
    }
}
