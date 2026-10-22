package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.imageview.ShapeableImageView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RecordDataItemLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class av implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f22784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OIconButton f22785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f22786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OIconButton f22787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f22788e;
    public final OUIFrameLayout f;
    public final OSectionTitleBar g;
    public final OTextView h;
    public final OTextView i;
    private final OUILinearLayout j;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private av(OUILinearLayout r1, ImageView r2, OIconButton r3, View r4, OIconButton r5, ShapeableImageView r6, OUIFrameLayout r7, OSectionTitleBar r8, OTextView r9, OTextView r10) {
        this.j = r1;
        this.f22784a = r2;
        this.f22785b = r3;
        this.f22786c = r4;
        this.f22787d = r5;
        this.f22788e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public OUILinearLayout b() {
        return this.j;
    }

    public static av a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.record_data_item_layout, "layout", "record_data_item_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static av a(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.app_icon, DbHelper.COL_ID, "app_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.delete, DbHelper.COL_ID, "delete");
        OIconButton r9 = (OIconButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OIconButton.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider");
        View r10 = r17.findViewById(r1);
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.modify_btn, DbHelper.COL_ID, "modify_btn");
        OIconButton r11 = (OIconButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OIconButton.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.screen_img, DbHelper.COL_ID, "screen_img");
        ShapeableImageView r12 = (ShapeableImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ShapeableImageView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.screen_img_container, DbHelper.COL_ID, "screen_img_container");
        OUIFrameLayout r13 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OUIFrameLayout.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.section_title, DbHelper.COL_ID, "section_title");
        OSectionTitleBar r14 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OSectionTitleBar.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_tv, DbHelper.COL_ID, "step_tv");
        OTextView r15 = (OTextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.thought_tv, DbHelper.COL_ID, "thought_tv");
        OTextView r16 = (OTextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L23;
        return new av((OUILinearLayout) ZeusTransformUtils.preCheckCast(r17, OUILinearLayout.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
