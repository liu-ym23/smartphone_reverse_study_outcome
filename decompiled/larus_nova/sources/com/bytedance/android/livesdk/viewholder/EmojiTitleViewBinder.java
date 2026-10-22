package com.bytedance.android.livesdk.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class EmojiTitleViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.model.e, EmojiTitleViewHolder> {

    public static class EmojiTitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f159261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HSImageView f159262b;

        public EmojiTitleViewHolder(View r100) {
            super(r100);
            this.f159261a = (TextView) r100.findViewById(R.id.emoji_title_view);
            this.f159262b = (HSImageView) r100.findViewById(R.id.emoji_group_tag);
        }
    }

    public EmojiTitleViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, com.bytedance.android.livesdk.model.e r101) {
        EmojiTitleViewHolder r102 = (EmojiTitleViewHolder) r100;
        com.bytedance.android.livesdk.model.e r103 = r101;
        TextView r104 = r102.f159261a;
        if (r104 == null) goto L22;
        if (r103 == null) goto L22;
        r104.setText(r103.f153938a);
    L22:
        HSImageView r105 = r102.f159262b;     // Catch: Exception -> L19
        if (r105 == null) goto L24;
        if (r103 == null) goto L25;
        py.k r106 = r103.f153939b;     // Catch: Exception -> L19
        if (r106 == null) goto L26;
        ImageUtil.loadImage(r105, r106, 0);     // Catch: Exception -> L19
        ViewGroup.LayoutParams r107 = r102.f159262b.getLayoutParams();     // Catch: Exception -> L19
        if (r103.f153939b.getWidth() > 0) goto L14;
    L16:
        r107.width = s1.f(31.0f);     // Catch: Exception -> L19
    L17:
        r107.height = s1.f(14.0f);     // Catch: Exception -> L19
        r102.f159262b.setLayoutParams(r107);     // Catch: Exception -> L19
        r102.f159262b.setVisibility(0);     // Catch: Exception -> L19
        return;
    L14:
        if (r103.f153939b.getHeight() <= 0) goto L16;
        r107.width = s1.f(r103.f153939b.getWidth() / (r103.f153939b.getHeight() / 14.0f));     // Catch: Exception -> L19
        goto L17
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L19:
        e = move-exception;
        ALogger.e("ActivityEmojiError", e.getMessage());
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return new EmojiTitleViewHolder(r100.inflate(R.layout.ttlive_item_panel_title_view, r101, false));
    }
}
