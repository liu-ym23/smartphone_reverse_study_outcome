package com.bytedance.android.livesdk.chatroom.ui.decoration.legacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class RoomDecorationListAdapter extends RecyclerView.Adapter<a<RoomDecoration>> {

    public static abstract class a<T> extends RecyclerView.ViewHolder {
        public abstract void T3(T r100);

        public a(View r100) {
            super(r100);
        }
    }

    public static class b extends a<RoomDecoration> {
        public b(View r100) {
            super(r100);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final /* bridge */ /* synthetic */ void T3(RoomDecoration r100) {
        }
    }

    public static class c extends a<RoomDecoration> {
        public c(View r100) {
            super(r100);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final /* bridge */ /* synthetic */ void T3(RoomDecoration r100) {
        }
    }

    public static class d extends a<RoomDecoration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f112747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View.OnClickListener f112748b;

        public d(View r100) {
            super(r100);
            this.f112747a = (ImageView) r100.findViewById(R.id.decoration_text_image);
            this.f112748b = null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final void T3(RoomDecoration r100) {
            RoomDecoration r101 = r100;
            if (r101 == null) goto L22;
            this.itemView.setTag(r101);
            if (r101.getImage() != null) goto L8;
        L12:
            long r102 = r101.getId();
            AnchorStickerWrapperWidget.F.getClass();
            if (r102 != AnchorStickerWrapperWidget.D) goto L15;
            boolean r103 = true;
        L16:
            ImageView r104 = this.f112747a;
            if (r103 == false) goto L19;
            float r105 = 0.3f;
        L20:
            r104.setAlpha(r105);
            return;
        L19:
            r105 = 1.0f;
            goto L20
        L15:
            r103 = false;
            goto L16
        L8:
            if (r101.getImage().getUrls() == null) goto L12;
            if (r101.getImage().getUrls().size() <= 0) goto L12;
            ((f) TTLiveSDKContext.getHostService()).f157991a.frescoHelper().loadFirstAvailableImageBitmap(r101.getImage(), new com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.a(this));
            goto L12
        }
    }

    public static class e extends a<RoomDecoration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f112749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View.OnClickListener f112750b;

        public e(View r100) {
            super(r100);
            this.f112749a = (ImageView) r100.findViewById(R.id.decoration_image);
            this.f112750b = null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final void T3(RoomDecoration r100) {
            RoomDecoration r101 = r100;
            if (r101 == null) goto L22;
            this.itemView.setTag(r101);
            if (r101.getImage() != null) goto L8;
        L12:
            long r102 = r101.getId();
            AnchorStickerWrapperWidget.F.getClass();
            if (r102 != AnchorStickerWrapperWidget.E) goto L15;
            boolean r103 = true;
        L16:
            ImageView r104 = this.f112749a;
            if (r103 == false) goto L19;
            float r105 = 0.3f;
        L20:
            r104.setAlpha(r105);
            return;
        L19:
            r105 = 1.0f;
            goto L20
        L15:
            r103 = false;
            goto L16
        L8:
            if (r101.getImage().getUrls() == null) goto L12;
            if (r101.getImage().getUrls().size() <= 0) goto L12;
            ((f) TTLiveSDKContext.getHostService()).f157991a.frescoHelper().loadFirstAvailableImageBitmap(r101.getImage(), new com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.b(this));
            goto L12
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 <= 0) goto L9;
        if (r100 >= 0) goto L9;
        return 3;
    L9:
        if (r100 != 0) goto L12;
        return 2;
    L12:
        return 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ((a) r100).T3((RoomDecoration) ListProtector.get(null, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1) goto L5;
        RecyclerView.ViewHolder r102 = new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_header_decoration_text_vcd, r100, false));
    L16:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        r102 = new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_header_decoration_vcd, r100, false));
        goto L16
    L7:
        if (r101 != 3) goto L9;
        r102 = new d(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_decoration_text_vcd, r100, false));
        goto L16
    L9:
        if (r101 == 4) goto L11;
        return null;
    L11:
        r102 = new e(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_decoration_vcd, r100, false));
        goto L16
    }
}
