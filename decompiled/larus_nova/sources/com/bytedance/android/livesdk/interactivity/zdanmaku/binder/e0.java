package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.y6;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 extends tk6.e<com.bytedance.android.livesdk.interactivity.zdanmaku.j, View> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StrokeColorTextView f141486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StrokeColorTextView f141487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StrokeColorTextView f141488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StrokeColorTextView f141489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StrokeColorTextView f141490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f141491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f141492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearLayout f141493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StrokeColorTextView[] f141494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h80.d<p22.k> f141495n;

    public e0(View r110, h80.d<p22.k> r111) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        Intrinsics.checkNotNullParameter(r111, "danmakuSettingConfigSupplier");
        super(r110, DanmakuCacheProviders.f141301a, SnapType.Bitmap, 8);
        this.f141495n = r111;
        StrokeColorTextView r112 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_1_1);
        StrokeColorTextView r100 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_1_2);
        StrokeColorTextView r101 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_1_3);
        this.f141486e = r101;
        StrokeColorTextView r102 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_1_4);
        this.f141487f = r102;
        StrokeColorTextView r103 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_2_1);
        StrokeColorTextView r104 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_2_2);
        StrokeColorTextView r105 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_2_3);
        this.f141488g = r105;
        StrokeColorTextView r106 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_3_1);
        StrokeColorTextView r107 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_3_2);
        StrokeColorTextView r108 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_3_3);
        this.f141489h = r108;
        StrokeColorTextView r113 = (StrokeColorTextView) r110.findViewById(R.id.supreme_attach_3_4);
        this.f141490i = r113;
        this.f141491j = (LinearLayout) r110.findViewById(R.id.main_area);
        this.f141492k = (LinearLayout) r110.findViewById(R.id.supreme_first_line);
        this.f141493l = (LinearLayout) r110.findViewById(R.id.supreme_third_line);
        this.f141494m = new StrokeColorTextView[]{r112, r100, r101, r102, r103, r104, r105, r106, r107, r108, r113};
        r112.setAlpha(0.7f);
        r100.setAlpha(1.0f);
        r101.setAlpha(0.7f);
        r102.setAlpha(1.0f);
        r103.setAlpha(1.0f);
        r104.setAlpha(0.7f);
        r105.setAlpha(1.0f);
        r106.setAlpha(1.0f);
        r107.setAlpha(0.8f);
        r108.setAlpha(0.7f);
        r113.setAlpha(1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.text.SpannableString, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence] */
    @Override // of6.b
    public final void b(Object r100, RenderEntity r101) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.j r102 = (com.bytedance.android.livesdk.interactivity.zdanmaku.j) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "entity");
        p22.k r103 = this.f141495n.get();
        StrokeColorTextView[] r104 = this.f141494m;
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L5;
        StrokeColorTextView r108 = r104[r107];
        r108.setTextSize(0, r103.f527418d.f527424c);
        r108.setText(r102.f141646a.getContent());
        r108.setVisibility(0);
        r107 = r107 + 1;
        goto L3
    L5:
        int r109 = x52.a.f562512a;
        s3 r110 = r102.f141646a;
        float r111 = r103.f527418d.f527424c;
        Intrinsics.checkNotNullParameter(r110, "privilegeScreenChatMessage");
        String r112 = r110.getContent();
        CharSequence r113 = "";
        ?? r114 = r112;
        if (r112 != null) goto L10;
        r114 = "";
    L10:
        if (r110.getRenderSpan() != null) goto L12;
    L18:
        SpannableString r115 = ab2.a.f(r114, r111);
        if (r115 == null) goto L21;
        r113 = r115;
    L21:
        StrokeColorTextView[] r116 = this.f141494m;
        int r117 = r116.length;
        int r118 = 0;
    L22:
        if (r118 >= r117) goto L24;
        r116[r118].setText(r113);
        r118 = r118 + 1;
        goto L22
    L24:
        String r119 = r113.toString();
        ArrayList r120 = (ArrayList) ab2.a.d(r119);
        Iterator r121 = r120.iterator();
        int r122 = 0;
    L26:
        if (r121.hasNext() == false) goto L28;
        db2.a r123 = (db2.a) r121.next();
        r122 = r122 + (r123.f467798c - r123.f467797b);
        goto L26
    L28:
        int r124 = r120.size() + (r119.length() - r122);
        if (r124 <= 5) goto L32;
        this.f141487f.setVisibility(8);
        this.f141490i.setVisibility(8);
    L32:
        if (r124 <= 10) goto L35;
        this.f141486e.setVisibility(8);
        this.f141488g.setVisibility(8);
        this.f141489h.setVisibility(8);
    L35:
        if (r103.f527393b != BarrageSettingFont.SMALL) goto L41;
        ViewGroup.LayoutParams r125 = this.f141491j.getLayoutParams();
        if (r125 == null) goto L40;
        LinearLayout.LayoutParams r126 = (LinearLayout.LayoutParams) r125;
        r126.setMargins(0, s1.f(4.0f), 0, s1.f(5.0f));
        this.f141491j.setLayoutParams(r126);
    L44:
        p22.k.b r127 = r103.f527418d;
        int r128 = r127.f527427f;
        int r129 = r127.f527428g;
        ViewGroup.LayoutParams r130 = this.f141492k.getLayoutParams();
        if (r130 == null) goto L55;
        LinearLayout.LayoutParams r131 = (LinearLayout.LayoutParams) r130;
        r131.setMargins(r128, 0, 0, 0);
        this.f141492k.setLayoutParams(r131);
        ViewGroup.LayoutParams r132 = this.f141493l.getLayoutParams();
        if (r132 == null) goto L53;
        LinearLayout.LayoutParams r133 = (LinearLayout.LayoutParams) r132;
        r133.setMargins(r129, 0, 0, 0);
        this.f141493l.setLayoutParams(r133);
        StrokeColorTextView[] r134 = this.f141494m;
        int r135 = r134.length;
    L49:
        if (r106 >= r135) goto L51;
        StrokeColorTextView r136 = r134[r106];
        r136.x(s1.f(0.5f), r103.f527418d.f527430i);
        r136.setTextColor(r103.f527418d.f527429h);
        r106 = r106 + 1;
        goto L49
    L51:
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L41:
        ViewGroup.LayoutParams r137 = this.f141491j.getLayoutParams();
        if (r137 == null) goto L57;
        LinearLayout.LayoutParams r138 = (LinearLayout.LayoutParams) r137;
        r138.setMargins(0, s1.f(3.0f), 0, s1.f(7.0f));
        this.f141491j.setLayoutParams(r138);
        goto L44
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L12:
        if (y6.f162550a.getValue().booleanValue() == false) goto L14;
        r114 = new SpannableString(r110.getRenderSpan());
    L15:
        ForegroundColorSpan[] r139 = (ForegroundColorSpan[]) r114.getSpans(0, r114.length(), ForegroundColorSpan.class);
        int r140 = r139.length;
        int r141 = 0;
    L16:
        if (r141 >= r140) goto L18;
        r114.removeSpan(r139[r141]);
        r141 = r141 + 1;
        goto L16
    L14:
        r114 = new SpannableString(String.valueOf(r110.getRenderSpan()));
        goto L15
    }
}
