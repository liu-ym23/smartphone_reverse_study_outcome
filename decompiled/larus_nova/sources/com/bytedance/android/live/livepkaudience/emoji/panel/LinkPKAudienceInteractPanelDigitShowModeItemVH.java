package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelDigitShowModeItemVH;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelDigitShowModeItemVH extends LinkPKAudienceInteractPanelItemBaseVH {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f81971a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPKAudienceInteractPanelDigitShowModeItemVH f81972a;

        public a(LinkPKAudienceInteractPanelDigitShowModeItemVH r100) {
            this.f81972a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setTag(2);
            g r101 = this.f81972a.f81971a;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPKAudienceInteractPanelDigitShowModeItemVH f81973a;

        public b(LinkPKAudienceInteractPanelDigitShowModeItemVH r100) {
            this.f81973a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setTag(1);
            g r101 = this.f81973a.f81971a;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }
    }

    public LinkPKAudienceInteractPanelDigitShowModeItemVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        ((ImageView) this.itemView.findViewById(R.id.audioModeIcon)).setOnClickListener(new a(this));
        ((ImageView) this.itemView.findViewById(R.id.videoModeIcon)).setOnClickListener(new b(this));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemBaseVH
    public final void T3(g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItem");
        this.f81971a = r100;
        LinearLayout r101 = (LinearLayout) this.itemView.findViewById(R.id.audioModeLayout);
        UtilityKotlinExtentionsKt.t(r101);
        int r102 = 0;
        r101.setSelected(false);
        LinearLayout r103 = (LinearLayout) this.itemView.findViewById(R.id.videoModeLayout);
        UtilityKotlinExtentionsKt.t(r103);
        r103.setSelected(false);
        Object r104 = r100.b();
        if (r104 == null) goto L22;
        c r105 = (c) r104;
        int[] r106 = r105.f81979a;
        int r107 = r106.length;
    L6:
        if (r102 >= r107) goto L14;
        int r108 = r106[r102];
        if (r108 == 1) goto L12;
        if (r108 != 2) goto L13;
        UtilityKotlinExtentionsKt.w(this.itemView.findViewById(R.id.audioModeLayout));
    L13:
        r102 = r102 + 1;
        goto L6
    L12:
        UtilityKotlinExtentionsKt.w(this.itemView.findViewById(R.id.videoModeLayout));
        goto L13
    L14:
        int r109 = r105.f81980b;
        if (r109 == 1) goto L19;
        if (r109 != 2) goto L28;
        ((LinearLayout) this.itemView.findViewById(R.id.audioModeLayout)).setSelected(true);
        return;
    L28:
        return;
    L19:
        ((LinearLayout) this.itemView.findViewById(R.id.videoModeLayout)).setSelected(true);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.panel.DigitShowModeData");
    }
}
