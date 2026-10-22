package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3;

import a20.e;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.LabelType;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.s;
import com.bytedance.android.live.broadcastgame.api.model.t;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.dux.font.DuxFontHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import f10.f;
import g20.g;
import g20.h;
import g20.i;
import h20.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import va1.b;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemViewHolderV3;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "Lf10/f;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenFeatureTabListItemViewHolderV3 extends AbsOpenFeatureTabListItemViewHolder<f> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f61670m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f61671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f61672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f61673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f61674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f61675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f61676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f61677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f61678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f61679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f61680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f61681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OpenFeatureIconCallbackFrom f61682l;

    public static boolean V3(f r100) {
        if ((r100 instanceof f) == true) goto L5;
    L7:
        return false;
    L5:
        if (a.a(r100.f115629k) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence] */
    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder
    public final void T3(f r110) {
        f r100 = r110;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        List<s> r111 = r100.D.highlightDesc;
        boolean r101 = true;
        String r102 = null;
        if (r111 != null) goto L5;
    L27:
        TextView r112 = this.f61672b;
        if (r112 == null) goto L30;
        r112.setText(r100.C);
    L30:
        String r113 = r100.D.highlightIcon;
        if (r113 != null) goto L33;
    L40:
        this.f61673c.setVisibility(8);
    L41:
        U3(this.f61671a, this.f61674d, this.f61676f, this.f61679i, this.itemView, this.f61681k, r100, getAdapterPosition());
        return;
    L33:
        if (r113.length() > 0) goto L36;
        r101 = false;
    L36:
        if (r101 == false) goto L38;
        r102 = r113;
    L38:
        if (r102 == null) goto L40;
        this.f61673c.setVisibility(0);
        ImageLoader.bindImage(this.f61673c, r102);
        goto L41
    L5:
        if ((!r111.isEmpty()) == true) goto L8;
        r111 = null;
    L8:
        if (r111 == null) goto L27;
        ?? r103 = new SpannableStringBuilder();
        Iterator r114 = r111.iterator();
    L11:
        if (r114.hasNext() == false) goto L18;
        s r104 = (s) r114.next();
        r103.append(r104.text);
        if (r104.highlightText.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L11;
        r103.append(" ");
        r103.append(r104.highlightText);
        r103.setSpan(new ForegroundColorSpan(s1.i(r104.highlightColor, s1.h(R.color.ttlive_color_161823_alpha75))), r103.length() - r104.highlightText.length(), r103.length(), 33);
        r103.setSpan(new AbsoluteSizeSpan(13, true), r103.length() - r104.highlightText.length(), r103.length(), 33);
        r103.setSpan(new StyleSpan(1), r103.length() - r104.highlightText.length(), r103.length(), 33);
        goto L11
    L15:
        r105 = false;
        goto L16
    L18:
        ?? r115 = this.f61672b;
        if (r115 == 0) goto L30;
        if (r103.length() != 0) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
        r103 = r100.C;
    L26:
        r115.setText(r103);
        goto L30
    L23:
        r106 = false;
        goto L24
    }

    public OpenFeatureTabListItemViewHolderV3(View r100, e r101, OpenFeatureIconCallbackFrom r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "callbackFrom");
        super(r100);
        this.f61681k = r101;
        this.f61682l = r102;
        this.f61671a = (TextView) r100.findViewById(R.id.txt_game_name);
        this.f61672b = (TextView) r100.findViewById(R.id.txt_game_summary);
        this.f61673c = (HSImageView) r100.findViewById(R.id.img_game_summary);
        this.f61674d = (HSImageView) r100.findViewById(R.id.icon_game_img);
        this.f61675e = r100.findViewById(R.id.red_dot);
        this.f61676f = r100.findViewById(R.id.action_area);
        this.f61677g = (TextView) r100.findViewById(R.id.category_tag);
        this.f61678h = (TextView) r100.findViewById(R.id.feature_start_btn);
        this.f61679i = (LinearLayout) r100.findViewById(R.id.feature_label_layout);
        this.f61680j = (TextView) r100.findViewById(R.id.txt_title_label);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v29 */
    public void U3(TextView r210, HSImageView r211, View r212, LinearLayout r213, View r214, e r215, f r216, int r217) {
        Intrinsics.checkNotNullParameter(r210, "nameView");
        Intrinsics.checkNotNullParameter(r211, "iconView");
        Intrinsics.checkNotNullParameter(r212, "actionView");
        Intrinsics.checkNotNullParameter(r213, "labelLayout");
        Intrinsics.checkNotNullParameter(r214, "itemView");
        Intrinsics.checkNotNullParameter(r216, MapController.ITEM_LAYER_TAG);
        ?? r110 = 0;
        r210.setText(r216.i(false));
        r210.requestLayout();
        GenericDraweeHierarchy r100 = r211.getHierarchy();
        r211.setActualImageResource(r216.f115627i);
        r100.setPlaceholderImage(r216.f115627i);
        r100.setFailureImage(r216.f115627i);
        r211.setHierarchy(r100);
        ?? r101 = 1;
        if ((!r216.f115634p.isEmpty()) == false) goto L11;
        if (((CharSequence) ListProtector.get(r216.f115634p, 0)).length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        r211.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(r216.f115634p, 0))).build());
        goto L11
    L7:
        r102 = false;
    L11:
        if (r216.f475043u == false) goto L18;
        UtilityKotlinExtentionsKt.v(this.f61675e, false);
        UtilityKotlinExtentionsKt.v(this.f61678h, true);
        this.f61678h.setAlpha(0.5f);
        TextView r103 = this.f61678h;
        if (V3(r216) == false) goto L15;
        String r104 = "退出";
    L16:
        r103.setText(r104);
    L53:
        this.f61678h.setTag("button");
        if (TextUtils.isEmpty(r216.D.iconLabel) == false) goto L56;
    L58:
        this.f61677g.setText("");
        UtilityKotlinExtentionsKt.v(this.f61677g, false);
    L59:
        r213.removeAllViews();
        if (r2.a(r216.D.titleLabel) == false) goto L62;
        UtilityKotlinExtentionsKt.v(this.f61680j, true);
        this.f61680j.setText(r216.D.titleLabel);
        this.f61680j.requestLayout();
    L62:
        List<t> r105 = r216.D.highlightLabel;
        if (r105 == null) goto L71;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L66:
        if (r107.hasNext() == false) goto L70;
        Object r111 = r107.next();
        if ((!TextUtils.isEmpty(((t) r111).text)) == false) goto L66;
        r106.add(r111);
        goto L66
    L70:
        List r108 = CollectionsKt.take(r106, 3);
    L72:
        List<v> r109 = r216.D.labels;
        if (r109 == null) goto L82;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r109.iterator();
    L76:
        if (r113.hasNext() == false) goto L81;
        Object r114 = r113.next();
        if ((!TextUtils.isEmpty(((v) r114).text)) == false) goto L76;
        r112.add(r114);
        goto L76
    L81:
        List r115 = CollectionsKt.take(r112, 2);
    L83:
        List r116 = r108;
        if (r116 != null) goto L86;
    L89:
        boolean r117 = true;
    L90:
        float r118 = 10.0f;
        if (r117 == true) goto L166;
        UtilityKotlinExtentionsKt.v(r213, true);
        List r119 = r108;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L94:
        if (r121.hasNext() == false) goto L96;
        r120.add(((t) r121.next()).text);
        goto L94
    L96:
        Iterator r122 = CollectionsKt.withIndex(r120).iterator();
        if (r122.hasNext() == true) goto L99;
        Object r123 = null;
    L108:
        IndexedValue r124 = (IndexedValue) r123;
        if (r124 == null) goto L111;
        Integer r125 = Integer.valueOf(r124.getIndex() + 1);
    L112:
        Iterator r126 = r119.iterator();
        int r127 = 0;
    L114:
        if (r126.hasNext() == false) goto L187;
        t r128 = (t) r126.next();
        r127 = r127 + r101;
        TextView r129 = new TextView(r214.getContext());
        r129.setMaxLines(r101);
        r129.setEllipsize(TextUtils.TruncateAt.END);
        r129.setSingleLine(r101);
        r129.setText(r128.text);
        r129.setTextSize(r101, r118);
        r129.setGravity(16);
        r129.setPadding(s1.f(3.0f), r110, s1.f(3.0f), r110);
        if (Build.VERSION.SDK_INT < 28) goto L118;
        Typeface r130 = Typeface.create(r129.getTypeface(), 700, r110);
    L119:
        r129.setTypeface(r130);
        FrameLayout r131 = new FrameLayout(r213.getContext());
        r131.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        if (r127 == 2) goto L125;
        if (r127 == 3) goto L125;
    L126:
        if (r125 == null) goto L132;
        if (r125.intValue() != r127) goto L132;
        r131.post(new g20.f(r131));
    L132:
        if (r128.labelType != LabelType.GAME_VALUE.getId()) goto L159;
        String r132 = r128.labelNameFontStyle;
        if (r132 != null) goto L136;
    L146:
        r129.setTextColor(s1.i(r128.labelNameFontColor, s1.h(R.color.ttlive_color_161823)));
        HSImageView r133 = new HSImageView(r213.getContext());
        r133.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r133.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r133.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(s1.f(3.0f)));
        r133.setActualImageResource(R.drawable.ttlive_feature_label_bg);
        r133.getHierarchy().setPlaceholderImage(R.drawable.ttlive_feature_label_bg);
        r133.getHierarchy().setFailureImage(R.drawable.ttlive_feature_label_bg);
        String r134 = r128.labelBottomImageUrl;
        if (r134 != null) goto L149;
    L157:
        r131.addView(r133);
        r131.addView(r129, new ViewGroup.LayoutParams(-2, -1));
        r213.addView(r131);
    L165:
        r118 = 10.0f;
        r101 = 1;
        r110 = 0;
        goto L114
    L149:
        if (r134.length() <= 0) goto L151;
        boolean r135 = true;
    L152:
        if (r135 == true) goto L155;
        r134 = null;
    L155:
        if (r134 == null) goto L157;
        r133.setImageURI(UriProtector.parse(r134));
        Unit r136 = Unit.INSTANCE;
        goto L157
    L151:
        r135 = false;
        goto L152
    L136:
        if (r132.length() <= 0) goto L138;
        boolean r137 = true;
    L139:
        if (r137 == true) goto L142;
        r132 = null;
    L142:
        if (r132 == null) goto L146;
        Lazy r138 = DuxFontHelper.f205084a;
        Typeface r139 = DuxFontHelper.c(r214.getContext(), r132);
        if (r139 == null) goto L146;
        r129.setTypeface(r139);
        Unit r140 = Unit.INSTANCE;
        goto L146
    L138:
        r137 = false;
        goto L139
    L159:
        if (r128.labelType != LabelType.TASK.getId()) goto L163;
        r129.setTextColor(s1.h(R.color.ttlive_color_161823));
        r129.setBackgroundResource(R.drawable.ttlive_feature_label_bg);
        if (r128.status != 1) goto L164;
        r129.setTextColor(s1.h(R.color.ttlive_color_ff4c13));
        r129.setBackgroundResource(R.drawable.ttlive_feature_highlight_label_bg);
    L164:
        r131.addView(r129, new ViewGroup.LayoutParams(-2, -1));
        r213.addView(r131);
        goto L165
    L163:
        r129.setTextColor(s1.h(R.color.ttlive_color_161823_alpha60));
        r129.setBackgroundResource(R.drawable.ttlive_feature_label_bg);
    L125:
        r131.setPadding(s1.f(4.0f), 0, 0, 0);
        goto L126
    L118:
        r130 = Typeface.create(r129.getTypeface(), r101);
    L187:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L192;
        if (r215 != null) goto L202;
    L194:
        r212.setOnClickListener(new h(this, r215, r214, r216, r217));
        if (V3(r216) == false) goto L197;
    L200:
        this.f61678h.setOnClickListener(new i(this, r215, r216, r217));
        return;
    L197:
        if (r216.f475043u == false) goto L200;
        this.f61678h.setOnClickListener(null);
        this.f61678h.setClickable(false);
        return;
    L202:
        r215.b(r214, r216, r217);     // Catch: Exception -> L191
        Unit r141 = Unit.INSTANCE;     // Catch: Exception -> L191
    L191:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L194
    L192:
        if (r215 == null) goto L194;
        r215.b(r214, r216, r217);
        Unit r142 = Unit.INSTANCE;
        goto L194
    L111:
        r125 = null;
        goto L112
    L99:
        r123 = r122.next();
        if (r122.hasNext() == false) goto L108;
        int r143 = ((String) ((IndexedValue) r123).component2()).length();
    L103:
        Object r144 = r122.next();
        int r145 = ((String) ((IndexedValue) r144).component2()).length();
        if (r143 >= r145) goto L107;
        r143 = r145;
        r123 = r144;
    L107:
        if (r122.hasNext() == true) goto L103;
    L166:
        List r146 = r115;
        if (r146 != null) goto L169;
    L172:
        boolean r147 = true;
    L173:
        if (r147 == true) goto L185;
        int r148 = 1;
        UtilityKotlinExtentionsKt.v(r213, true);
        Iterator r149 = r115.iterator();
        int r150 = 0;
    L176:
        if (r149.hasNext() == false) goto L187;
        v r151 = (v) r149.next();
        r150 = r150 + r148;
        TextView r152 = new TextView(r214.getContext());
        r152.setText(r151.text);
        r152.setTextSize(r148, 10.0f);
        r152.setGravity(17);
        r152.setTextColor(s1.h(R.color.ttlive_color_161823_alpha60));
        r152.setPadding(s1.f(3.0f), 0, s1.f(3.0f), 0);
        r152.setBackgroundResource(R.drawable.ttlive_feature_label_bg);
        if (Build.VERSION.SDK_INT < 28) goto L180;
        Typeface r153 = Typeface.create(r152.getTypeface(), 700, false);
    L181:
        r152.setTypeface(r153);
        if (r150 != 2) goto L184;
        r152.post(new g(r152));
    L184:
        r213.addView(r152, new ViewGroup.LayoutParams(-2, -1));
        r148 = 1;
        goto L176
    L180:
        r153 = Typeface.create(r152.getTypeface(), 1);
        goto L181
    L185:
        UtilityKotlinExtentionsKt.v(r213, false);
        goto L187
    L169:
        if (r146.isEmpty() == true) goto L172;
        r147 = false;
        goto L173
    L86:
        if (r116.isEmpty() == true) goto L89;
        r117 = false;
        goto L90
    L82:
        r115 = null;
        goto L83
    L71:
        r108 = null;
        goto L72
    L56:
        if (r216.A == false) goto L58;
        this.f61677g.setText(r216.D.iconLabel);
        UtilityKotlinExtentionsKt.v(this.f61677g, true);
        goto L59
    L15:
        r104 = "已启动";
        goto L16
    L18:
        if (r216.f475044v == false) goto L21;
        UtilityKotlinExtentionsKt.v(this.f61675e, false);
        UtilityKotlinExtentionsKt.v(this.f61678h, true);
        this.f61678h.setAlpha(0.5f);
        this.f61678h.setText("已绑定");
        goto L53
    L21:
        if (r216.k() == false) goto L35;
        UtilityKotlinExtentionsKt.v(this.f61675e, true);
        String r154 = r216.h();
        if (r154 != null) goto L25;
    L36:
        this.f61678h.setAlpha(1.0f);
        TextView r155 = this.f61678h;
        k0 r156 = r216.F;
        if (r156 == null) goto L39;
        String r157 = r156.text;
    L40:
        r155.setText(r157);
        k0 r158 = r216.F;
        if (r158 == null) goto L43;
        String r159 = r158.text;
    L44:
        if (r159 != null) goto L46;
    L49:
        boolean r160 = true;
    L50:
        if (r160 == false) goto L52;
        UtilityKotlinExtentionsKt.v(this.f61678h, false);
        goto L53
    L52:
        UtilityKotlinExtentionsKt.v(this.f61678h, true);
        goto L53
    L46:
        if (r159.length() == 0) goto L49;
        r160 = false;
        goto L50
    L43:
        r159 = null;
        goto L44
    L39:
        r157 = null;
        goto L40
    L25:
        if (r154.length() <= 0) goto L27;
        boolean r161 = true;
    L28:
        if (r161 == true) goto L31;
        r154 = null;
    L31:
        if (r154 == null) goto L36;
        ((IBroadcastService) b.a.f553922a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L27:
        r161 = false;
        goto L28
    L35:
        UtilityKotlinExtentionsKt.v(this.f61675e, false);
        goto L36
    }
}
