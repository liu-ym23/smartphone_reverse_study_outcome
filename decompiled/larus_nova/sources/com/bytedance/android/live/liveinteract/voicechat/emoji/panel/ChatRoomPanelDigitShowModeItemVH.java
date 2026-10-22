package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelDigitShowModeItemVH;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelDigitShowModeItemVH extends ChatRoomPanelItemBaseVH {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f80171a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH f80172a;

        public a(ChatRoomPanelDigitShowModeItemVH r100) {
            this.f80172a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setTag(VideoShowMode.AUDIO);
            g r101 = this.f80172a.f80171a;
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH f80173a;

        public b(ChatRoomPanelDigitShowModeItemVH r100) {
            this.f80173a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setTag(VideoShowMode.VIDEO);
            g r101 = this.f80173a.f80171a;
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH f80174a;

        public c(ChatRoomPanelDigitShowModeItemVH r100) {
            this.f80174a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setTag(VideoShowMode.DIGIT_AVATAR);
            g r101 = this.f80174a.f80171a;
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void U3(ChatRoomPanelItemBaseVH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public ChatRoomPanelDigitShowModeItemVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        ((ImageView) this.itemView.findViewById(R.id.audioModeIcon)).setOnClickListener(new a(this));
        ((ImageView) this.itemView.findViewById(R.id.videoModeIcon)).setOnClickListener(new b(this));
        ((ImageView) this.itemView.findViewById(R.id.avatarModeIcon)).setOnClickListener(new c(this));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void T3(g r110) {
        Intrinsics.checkNotNullParameter(r110, "panelItem");
        this.f80171a = r110;
        LinearLayout r100 = (LinearLayout) this.itemView.findViewById(R.id.audioModeLayout);
        UtilityKotlinExtentionsKt.t(r100);
        boolean r101 = false;
        r100.setSelected(false);
        LinearLayout r102 = (LinearLayout) this.itemView.findViewById(R.id.videoModeLayout);
        UtilityKotlinExtentionsKt.t(r102);
        r102.setSelected(false);
        LinearLayout r103 = (LinearLayout) this.itemView.findViewById(R.id.avatarModeLayout);
        UtilityKotlinExtentionsKt.t(r103);
        r103.setSelected(false);
        Object r111 = r110.c();
        if (r111 == null) goto L44;
        m r112 = (m) r111;
        VideoShowMode[] r104 = r112.f80232a;
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L16;
        VideoShowMode r113 = r104[r106];
        int r114 = f.f80211a[r113.ordinal()];
        if (r114 == 1) goto L14;
        if (r114 == 2) goto L13;
        if (r114 != 3) goto L15;
        UtilityKotlinExtentionsKt.w(this.itemView.findViewById(R.id.avatarModeLayout));
    L15:
        r106 = r106 + 1;
        goto L6
    L13:
        UtilityKotlinExtentionsKt.w(this.itemView.findViewById(R.id.videoModeLayout));
        goto L15
    L14:
        UtilityKotlinExtentionsKt.w(this.itemView.findViewById(R.id.audioModeLayout));
        goto L15
    L16:
        VideoShowMode r107 = r112.f80233b;
        int r108 = f.f80212b[r107.ordinal()];
        if (r108 == 1) goto L23;
        if (r108 == 2) goto L22;
        if (r108 != 3) goto L24;
        ((LinearLayout) this.itemView.findViewById(R.id.avatarModeLayout)).setSelected(true);
    L24:
        TextView r109 = (TextView) ((LinearLayout) this.itemView.findViewById(R.id.avatarModeLayout)).findViewById(R.id.avatarModeText);
        if (r109.getVisibility() == 0) goto L28;
        return;
    L28:
        if (r112.f80233b != VideoShowMode.DIGIT_AVATAR) goto L31;
        r101 = true;
    L31:
        if (r101 == false) goto L41;
        DigitAvatarAuditStatus r115 = r112.f80234c;
        int r116 = f.f80213c[r115.ordinal()];
        if (r116 != 1) goto L35;
        r109.setTextColor(Color.argb(255, 254, 56, 36));
        r109.setText(R.string.ttlive_ktv_avatar_audit_status_not_pass_2);
        return;
    L35:
        if (r116 == 2) goto L39;
        if (r116 != 3) goto L54;
        r109.setTextColor(Color.argb(255, 77, 77, 77));
        r109.setText(R.string.ttlive_ktv_avatar_audit_status_in_progress);
        return;
    L54:
        return;
    L39:
        r109.setTextColor(Color.argb(255, 77, 77, 77));
        r109.setText(R.string.ttlive_digit_avatar_show_mode_avatar);
        return;
    L41:
        r109.setTextColor(Color.argb(255, 148, 148, 148));
        r109.setText(R.string.ttlive_digit_avatar_show_mode_avatar);
        return;
    L22:
        ((LinearLayout) this.itemView.findViewById(R.id.videoModeLayout)).setSelected(true);
        goto L24
    L23:
        ((LinearLayout) this.itemView.findViewById(R.id.audioModeLayout)).setSelected(true);
        goto L24
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.voicechat.emoji.panel.DigitShowModeData");
    }
}
