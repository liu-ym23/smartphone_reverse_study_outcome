package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: PlayerBubbleBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f24617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCircleImageView f24618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f24619d;

    private h(View r1, LinearLayout r2, OTextView r3, OCircleImageView r4) {
        this.f24619d = r1;
        this.f24616a = r2;
        this.f24617b = r3;
        this.f24618c = r4;
    }

    @Override // androidx.viewbinding.a
    public View a() {
        return this.f24619d;
    }

    public static h a(LayoutInflater r3, ViewGroup r4) {
        Objects.requireNonNull(r4, "parent");
        ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.player_bubble, "layout", "player_bubble"), r4, "com.obric.aiagent.plugin");
        return a(r4);
    }

    public static h a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.floating_icon_content, DbHelper.COL_ID, "floating_icon_content");
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.floating_icon_expanded_text, DbHelper.COL_ID, "floating_icon_expanded_text");
        OTextView r3 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.floating_icon_img, DbHelper.COL_ID, "floating_icon_img");
        OCircleImageView r1 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCircleImageView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new h(r6, r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
