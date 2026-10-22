package com.bytedance.android.ecom.arch.slice.slices;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.background.PdpBackgroundUtil;
import com.bytedance.android.ecom.arch.slice.f;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.ecom.arch.slice.render.SlcBackground;
import com.bytedance.android.ecom.arch.slice.render.l;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.style.SlcStyle;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/slices/SlcBaseViewHolder;", "Lcom/bytedance/android/ecom/arch/slice/g;", DSLType.Slice, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/ecom/arch/slice/slices/a;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SlcBaseViewHolder<Slice extends g> extends RecyclerView.ViewHolder implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f51026a;

    public abstract f V3();

    public abstract SlcContext W3();

    public abstract void Y3(g r100);

    public void Z3() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.slices.a
    public final void P2() {
        g r100 = this.f51026a;
        if (r100 == null) goto L5;
        r100.setSliceRebindTarget(null);
    L5:
        this.f51026a = null;
        Z3();
    }

    public SlcBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "slcView");
        super(r100);
    }

    public static com.bytedance.android.ecom.arch.slice.background.a U3(View r100) {
        Drawable r101 = r100.getBackground();
        if ((r101 instanceof com.bytedance.android.ecom.arch.slice.background.a) == true) goto L7;
        com.bytedance.android.ecom.arch.slice.background.a r102 = new com.bytedance.android.ecom.arch.slice.background.a();
        r100.setBackground(r102);
        return r102;
    L7:
        return (com.bytedance.android.ecom.arch.slice.background.a) r101;
    }

    public static List b4(List r100) {
        List r101 = r100;     // Catch: Throwable -> L7
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));     // Catch: Throwable -> L7
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L7
    L4:
        if (r103.hasNext() == false) goto L13;
        r102.add(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r103.next(), 0.0f)));     // Catch: Throwable -> L7
    L13:
        return r102;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.ecom.arch.slice.h
    public final void f1(boolean r100) {
        g r101 = this.f51026a;
        if (r101 != null) goto L6;
        nq.a.c(null, SlcBaseViewHolder$rebindV2$1.INSTANCE, 1);
        return;
    L6:
        b3(r101, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T3(g r310, String r311) {
        Intrinsics.checkNotNullParameter(r310, "slice");
        String r100 = null;
        Object[] r101 = 0;
        if (r311 == null) goto L9;
        Map<String, SlcStyle> r102 = r310.getSpecialStyle();
        if (r102 == null) goto L7;
        SlcStyle r103 = r102.get(r311);
    L8:
        if (r103 == null) goto L9;
    L10:
        int r104 = 2;
        String r105 = "stretch";
        if (r103 != null) goto L13;
        r103 = new SlcStyle(r105, r100, r104, r101 == true ? 1 : 0);
    L13:
        View r106 = s0();
        Map<String, Object> r107 = r103.getAttrs();
        if (r107 == null) goto L16;
        int r108 = r107.size();
    L17:
        HashMap r109 = new HashMap((int) (((r108 + 10) / 0.75f) + 1.0f));
        r109.put(GXTemplateKey.FLEXBOX_MARGIN, CollectionsKt.listOf(Float.valueOf(0.0f)));
        r109.put(GXTemplateKey.FLEXBOX_PADDING, CollectionsKt.listOf(Float.valueOf(0.0f)));
        r109.put("width", "stretch");
        r109.put("height", "auto");
        r109.put("radius", CollectionsKt.listOf(Float.valueOf(0.0f)));
        Map<String, Object> r110 = r103.getAttrs();
        if (r110 == null) goto L21;
        r109.putAll(r110);
    L21:
        if (r109.isEmpty() == true) goto L227;
        Iterator r111 = r109.entrySet().iterator();
        Object r112 = null;
        Object r113 = null;
        Object r114 = null;
        Object r115 = null;
        Object r116 = null;
        Object r117 = null;
        Object r118 = null;
        Object r210 = null;
        Object r211 = null;
        Object r212 = null;
    L25:
        if (r111.hasNext() == false) goto L227;
        Map.Entry r213 = (Map.Entry) r111.next();
        String r119 = (String) r213.getKey();
        Object r120 = r213.getValue();
        switch(r119.hashCode()) {
            case -1391253303: goto L210;
            case -1265068311: goto L198;
            case -1221029593: goto L183;
            case -1081309778: goto L165;
            case -938578798: goto L155;
            case -806339567: goto L144;
            case -199136998: goto L122;
            case 113126854: goto L108;
            case 1313099890: goto L46;
            case 1406540266: goto L31;
            default: goto L28;
        };
    L28:
        Object r312 = r112;
        Iterator r214 = r111;
        Object r121 = r117;
        Object r122 = r118;
        Object r123 = r210;
        Object r124 = r211;
    L221:
        r212 = r212;
    L222:
        r118 = r122;
    L223:
        r211 = r124;
    L224:
        r210 = r123;
    L225:
        r117 = r121;
        r111 = r214;
        r112 = r312;
        goto L25
    L108:
        Object r313 = r112;
        r111 = r111;
        if (r119.equals("width") == false) goto L121;
        Object r125 = r116;
        boolean r126 = !Intrinsics.areEqual(r125, r120);
        if (r126 == false) goto L113;
        r116 = r120;
    L114:
        if (r126 == true) goto L116;
    L153:
        r112 = r313;
    L154:
        r111 = r111;
        goto L25
    L116:
        if (r106.getLayoutParams() != null) goto L118;
        nq.a.c(null, SlcBaseViewHolder$setWidth$1.INSTANCE, 1);
        goto L153
    L118:
        r106.getLayoutParams().width = com.bytedance.android.ecom.arch.slice.render.util.b.j(r120, W3().f50172f);
        if (r106.isLayoutRequested() == true) goto L153;
        r106.requestLayout();
        goto L153
    L113:
        r116 = r125;
        goto L114
    L121:
        Object r127 = r117;
    L152:
        r117 = r127;
        goto L153
    L122:
        r313 = r112;
        r111 = r111;
        Object r128 = r116;
        if (r119.equals("background_position") == false) goto L143;
        Object r129 = r117;
        boolean r130 = !Intrinsics.areEqual(r129, r120);
        if (r130 == false) goto L127;
        r117 = r120;
    L128:
        if (r130 == true) goto L130;
    L142:
        r116 = r128;
        goto L153
    L130:
        if ((r120 instanceof String) == true) goto L132;
        r120 = null;
    L132:
        String r131 = (String) r120;
        com.bytedance.android.ecom.arch.slice.background.a r132 = U3(r106);
        if (r131 == null) goto L135;
        r132.getClass();
        HashMap<String, WeakReference<Bitmap>> r133 = PdpBackgroundUtil.f50015a;
        String r134 = r131.trim();
    L136:
        r132.f50018c = r134;
        if (r132.getBounds().isEmpty() == true) goto L141;
        r132.i(r132.getBounds());
        if (r132.f50021f == null) goto L141;
        r132.j(r132.getBounds());
    L141:
        r132.invalidateSelf();
        goto L142
    L135:
        r134 = null;
        goto L136
    L127:
        r117 = r129;
        goto L128
    L143:
        r127 = r117;
    L151:
        r116 = r128;
        goto L152
    L144:
        r313 = r112;
        r111 = r111;
        r128 = r116;
        r127 = r117;
        if (r119.equals(GXTemplateKey.FLEXBOX_PADDING) == false) goto L151;
        boolean r135 = !Intrinsics.areEqual(r113, r120);
        if (r135 == false) goto L149;
        r113 = r120;
    L149:
        if (r135 == false) goto L151;
        List<Float> r136 = com.bytedance.android.ecom.arch.slice.render.util.b.d(r120);
        r116 = r128;
        r106.setPadding(SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.k(r136)), W3()), SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.t(r136)), W3()), SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.q(r136)), W3()), SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.b(r136)), W3()));
        goto L152
    L155:
        r312 = r112;
        r214 = r111;
        r121 = r117;
        if (r119.equals("radius") == false) goto L164;
        Object r137 = r211;
        boolean r138 = !Intrinsics.areEqual(r137, r120);
        if (r138 == false) goto L160;
        r211 = r120;
    L161:
        if (r138 == false) goto L164;
        a4(this, r106, W3().f50172f, com.bytedance.android.ecom.arch.slice.render.util.b.d(r120));
        goto L164
    L160:
        r211 = r137;
    L164:
        r123 = r210;
        goto L224
    L165:
        r312 = r112;
        r214 = r111;
        r121 = r117;
        Object r139 = r211;
        if (r119.equals(GXTemplateKey.FLEXBOX_MARGIN) == false) goto L182;
        Object r140 = r210;
        boolean r141 = !Intrinsics.areEqual(r140, r120);
        if (r141 == false) goto L170;
        r210 = r120;
    L171:
        if (r141 == false) goto L182;
        if ((r120 instanceof List) == true) goto L175;
        r120 = null;
    L175:
        List r142 = (List) r120;
        ViewGroup.LayoutParams r143 = r106.getLayoutParams();
        if ((r143 instanceof ViewGroup.MarginLayoutParams) == false) goto L179;
        SlcViewExtensionsKt.p((ViewGroup.MarginLayoutParams) r143, W3().f50172f, r142);
        r106.setLayoutParams(r143);
    L179:
        if (r106.isLayoutRequested() == true) goto L182;
        r106.requestLayout();
        goto L182
    L170:
        r210 = r140;
    L182:
        r211 = r139;
        goto L225
    L183:
        r312 = r112;
        r214 = r111;
        r121 = r117;
        r123 = r210;
        Object r144 = r211;
        if (r119.equals("height") == false) goto L197;
        Object r145 = r118;
        r124 = r144;
        boolean r146 = !Intrinsics.areEqual(r145, r120);
        if (r146 == false) goto L188;
        r118 = r120;
    L189:
        if (r146 == false) goto L223;
        if (r106.getLayoutParams() != null) goto L193;
        nq.a.c(null, SlcBaseViewHolder$setHeight$1.INSTANCE, 1);
        goto L223
    L193:
        r106.getLayoutParams().height = com.bytedance.android.ecom.arch.slice.render.util.b.j(r120, W3().f50172f);
        if (r106.isLayoutRequested() == true) goto L223;
        r106.requestLayout();
        goto L223
    L188:
        r118 = r145;
        goto L189
    L197:
        r124 = r144;
        r122 = r118;
    L209:
        r115 = r115;
        goto L221
    L198:
        r312 = r112;
        r214 = r111;
        r121 = r117;
        r122 = r118;
        r123 = r210;
        r124 = r211;
        if (r119.equals("bg_color") == false) goto L209;
        Object r147 = r115;
        boolean r148 = !Intrinsics.areEqual(r147, r120);
        if (r148 == false) goto L203;
        r115 = r120;
    L204:
        if (r148 == false) goto L222;
        if ((r120 instanceof String) == true) goto L208;
        r120 = null;
    L208:
        U3(r106).f((String) r120);
        goto L222
    L203:
        r115 = r147;
        goto L204
    L210:
        r312 = r112;
        r214 = r111;
        r121 = r117;
        r122 = r118;
        r123 = r210;
        r124 = r211;
        if (r119.equals("bg_img") == false) goto L221;
        Object r149 = r212;
        boolean r150 = !Intrinsics.areEqual(r149, r120);
        if (r150 == false) goto L215;
        r212 = r120;
    L216:
        if (r150 == false) goto L222;
        if ((r120 instanceof String) == true) goto L220;
        r120 = null;
    L220:
        HashMap<String, WeakReference<Bitmap>> r151 = PdpBackgroundUtil.f50015a;
        PdpBackgroundUtil.c(U3(r106), (String) r120);
        goto L222
    L215:
        r212 = r149;
        goto L216
    L31:
        if (r119.equals("bg_gradient") == false) goto L44;
        boolean r152 = !Intrinsics.areEqual(r112, r120);
        if (r152 == false) goto L35;
        r112 = r120;
    L35:
        if (r152 == false) goto L44;
        if ((r120 instanceof Map) == true) goto L39;
        r120 = null;
    L39:
        vq.b r153 = uq.b.b((Map) r120);
        com.bytedance.android.ecom.arch.slice.background.a r154 = U3(r106);
        r154.f50021f = r153;
        if (r154.getBounds().isEmpty() == true) goto L43;
        if (r153 == null) goto L43;
        r154.j(r154.getBounds());
    L43:
        r154.h();
        r154.invalidateSelf();
    L44:
        r111 = r111;
        goto L154
    L46:
        if (r119.equals("background_size") == false) goto L107;
        boolean r155 = !Intrinsics.areEqual(r114, r120);
        if (r155 == false) goto L50;
        r114 = r120;
    L50:
        if (r155 == false) goto L106;
        com.bytedance.android.ecom.arch.slice.render.context.b r156 = W3().f50172f;
        if ((r120 instanceof String) == true) goto L54;
        r120 = null;
    L54:
        String r157 = (String) r120;
        com.bytedance.android.ecom.arch.slice.background.a r158 = U3(r106);
        r158.getClass();
        Intrinsics.checkNotNullParameter(r156, "slcDisplayMetrics");
        if (r157 != null) goto L57;
    L60:
        boolean r159 = true;
    L61:
        if (r159 == false) goto L64;
        r158.f50020e = null;
        r313 = r112;
    L63:
        Object r215 = r114;
    L99:
        if (r158.getBounds().isEmpty() == true) goto L103;
        r158.i(r158.getBounds());
        if (r158.f50021f == null) goto L103;
        r158.j(r158.getBounds());
    L103:
        r158.invalidateSelf();
        r114 = r215;
        goto L153
    L64:
        HashMap<String, WeakReference<Bitmap>> r160 = PdpBackgroundUtil.f50015a;
        if (r157 == null) goto L105;
        String r161 = r157.trim();
        int r162 = r161.hashCode();
        r313 = r112;
        if (r162 != 94852023) goto L69;
        String r163 = null;
        if (r161.equals("cover") == false) goto L78;
        r158.f50019d = "cover";
        r158.f50020e = null;
    L78:
        r158.f50019d = r163;
        List r164 = StringsKt.split$default(r161, new char[]{' '}, false, 0, 6, null);
        ArrayList r165 = new ArrayList();
        Iterator r166 = r164.iterator();
    L80:
        if (r166.hasNext() == false) goto L85;
        Object r167 = r166.next();
        if ((!StringsKt.isBlank((String) r167)) == false) goto L80;
        r165.add(r167);
        goto L80
    L85:
        if (r165.isEmpty() == false) goto L87;
        r158.f50020e = null;
        goto L63
    L87:
        String r168 = (String) CollectionsKt.getOrNull(r165, 0);
        if (r168 == null) goto L63;
        uq.a r169 = PdpBackgroundUtil.b(r156, r168);
        if (r165.size() > 1) goto L93;
        uq.a r170 = new uq.a(0.0f, 0);
        r215 = r114;
        char r171 = 0;
    L97:
        uq.a[] r172 = new uq.a[2];
        r172[r171] = r169;
        r172[1] = r170;
        r158.f50020e = CollectionsKt.listOf(r172);
        goto L99
    L93:
        r215 = r114;
        r171 = 0;
        String r173 = (String) CollectionsKt.getOrNull(r165, 1);
        if (r173 == null) goto L96;
        r170 = PdpBackgroundUtil.b(r156, r173);
        goto L97
    L96:
        r170 = new uq.a(0.0f, 0);
        goto L97
    L69:
        if (r162 == 951526612) goto L72;
    L74:
        r163 = null;
        goto L78
    L72:
        if (r161.equals(LynxVideoManagerLite.CONTAIN) == false) goto L74;
        r158.f50019d = LynxVideoManagerLite.CONTAIN;
        r158.f50020e = null;
        goto L63
    L105:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L57:
        if (r157.length() == 0) goto L60;
        r159 = false;
        goto L61
    L106:
        r313 = r112;
        r111 = r111;
        goto L153
    L107:
        r313 = r112;
        r111 = r111;
    L227:
        View r174 = s0();
        p r175 = r310.getParent();
        if (r175 != null) goto L230;
        return;
    L230:
        if (r175.b() != true) goto L377;
        SlcBackground r176 = r103.getBackground();
        if (r176 != null) goto L234;
    L241:
        p r177 = r310.getParent();
        if (r177 == null) goto L248;
        SlcStyle r178 = r177.getStyle();
        if (r178 == null) goto L248;
        SlcBackground r179 = r178.getBackground();
        if (r179 == null) goto L248;
        String r180 = r179.f50091c;
    L249:
        if (r180 == null) goto L251;
        U3(r174).f(r180);
    L251:
        p r181 = r310.getParent();
        if (r181 == null) goto L378;
        SlcStyle r182 = r181.getStyle();
        if (r182 == null) goto L379;
        l r183 = r182.getRadius();
        if (r183 == null) goto L312;
        boolean r184 = r310.isHeader();
        boolean r185 = r310.isFooter();
        View r186 = s0();
        l r187 = r103.getRadius();
        if (r187 == null) goto L260;
        float r188 = r187.c();
    L261:
        l r189 = r103.getRadius();
        if (r189 == null) goto L264;
        float r190 = r189.d();
    L265:
        l r191 = r103.getRadius();
        if (r191 == null) goto L268;
        float r192 = r191.a();
    L269:
        l r193 = r103.getRadius();
        if (r193 == null) goto L272;
        float r194 = r193.b();
    L273:
        if (r184 == true) goto L275;
    L291:
        boolean r195 = false;
    L292:
        if (r185 == true) goto L294;
    L310:
        if (r195 == false) goto L312;
        a4(this, r186, W3().f50172f, CollectionsKt.listOf(new Float[]{Float.valueOf(r188), Float.valueOf(r190), Float.valueOf(r194), Float.valueOf(r192)}));
        goto L312
    L294:
        if (r103.getRadius() == null) goto L304;
        l r196 = r103.getRadius();
        if (r196 == null) goto L310;
        float r197 = 0.0f;
        if (r196.a() != 0.0f) goto L310;
        l r198 = r103.getRadius();
        if (r198 == null) goto L310;
        if (r198.b() != 0.0f) goto L310;
    L306:
        if (r183.a() == r197) goto L308;
    L309:
        r192 = r183.a();
        r194 = r183.b();
        r195 = true;
        goto L310
    L308:
        if (r183.b() == r197) goto L310;
    L304:
        r197 = 0.0f;
        goto L306
    L275:
        if (r103.getRadius() == null) goto L285;
        l r199 = r103.getRadius();
        if (r199 == null) goto L291;
        float r1100 = 0.0f;
        if (r199.c() != 0.0f) goto L291;
        l r200 = r103.getRadius();
        if (r200 == null) goto L291;
        if (r200.d() != 0.0f) goto L291;
    L287:
        if (r183.d() == r1100) goto L289;
    L290:
        r188 = r183.c();
        r190 = r183.d();
        r195 = true;
        goto L292
    L289:
        if (r183.c() == r1100) goto L291;
    L285:
        r1100 = 0.0f;
        goto L287
    L272:
        r194 = 0.0f;
        goto L273
    L268:
        r192 = 0.0f;
        goto L269
    L264:
        r190 = 0.0f;
        goto L265
    L260:
        r188 = 0.0f;
    L312:
        p r201 = r310.getParent();
        if (r201 != null) goto L315;
        return;
    L315:
        if (r201.b() != true) goto L381;
        p r202 = r310.getParent();
        if (r202 == null) goto L342;
        SlcStyle r203 = r202.getStyle();
        if (r203 == null) goto L342;
        List<Object> r204 = r203.getMargin();
        if (r204 == null) goto L342;
        List r205 = b4(r204);
        boolean r206 = r310.isHeader();
        boolean r207 = r310.isFooter();
        if (com.bytedance.android.ecom.arch.slice.render.util.b.k(r205) == 0.0f) goto L325;
    L334:
        ViewGroup.LayoutParams r208 = r174.getLayoutParams();
        if ((r208 instanceof ViewGroup.MarginLayoutParams) == false) goto L342;
        ViewGroup.MarginLayoutParams r209 = (ViewGroup.MarginLayoutParams) r208;
        r209.leftMargin += SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.k(r205)), W3());
        r209.rightMargin += SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.q(r205)), W3());
        if (r206 == false) goto L339;
        r209.topMargin += SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.t(r205)), W3());
    L339:
        if (r207 == false) goto L341;
        r209.bottomMargin += SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.b(r205)), W3());
    L341:
        r174.setLayoutParams(r208);
        goto L342
    L325:
        if (com.bytedance.android.ecom.arch.slice.render.util.b.q(r205) != 0.0f) goto L334;
        if (r206 == true) goto L330;
        if (r207 == false) goto L342;
    L330:
        if (com.bytedance.android.ecom.arch.slice.render.util.b.t(r205) != 0.0f) goto L334;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.b(r205) != 0.0f) goto L334;
    L342:
        p r216 = r310.getParent();
        if (r216 == null) goto L382;
        SlcStyle r217 = r216.getStyle();
        if (r217 == null) goto L383;
        List<Object> r218 = r217.getPadding();
        if (r218 == null) goto L384;
        List r219 = b4(r218);
        boolean r220 = r310.isHeader();
        boolean r221 = r310.isFooter();
        if (com.bytedance.android.ecom.arch.slice.render.util.b.k(r219) == 0.0f) goto L351;
    L360:
        int r222 = r174.getPaddingLeft();
        int r223 = r174.getPaddingTop();
        int r224 = r174.getPaddingRight();
        int r225 = r174.getPaddingBottom();
        int r226 = r222 + SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.k(r219)), W3());
        int r227 = r224 + SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.q(r219)), W3());
        if (r220 == false) goto L363;
        r223 = r223 + SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.t(r219)), W3());
    L363:
        if (r221 == false) goto L365;
        r225 = r225 + SlcDimensExtensionsKt.b(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.b(r219)), W3());
    L365:
        r174.setPadding(r226, r223, r227, r225);
        return;
    L351:
        if (com.bytedance.android.ecom.arch.slice.render.util.b.q(r219) != 0.0f) goto L360;
        if (r220 == true) goto L356;
        if (r221 == true) goto L356;
        return;
    L356:
        if (com.bytedance.android.ecom.arch.slice.render.util.b.t(r219) != 0.0f) goto L360;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.b(r219) != 0.0f) goto L360;
        return;
    L384:
        return;
    L383:
        return;
    L382:
        return;
    L381:
        return;
    L379:
        return;
    L378:
        return;
    L248:
        r180 = null;
        goto L249
    L234:
        if (r176.f50090b == null) goto L236;
    L239:
        boolean r228 = true;
    L240:
        if (r228 == true) goto L251;
    L236:
        if (r176.f50091c != null) goto L239;
        r228 = false;
        goto L240
    L377:
        return;
    L16:
        r108 = 0;
        goto L17
    L7:
        r103 = null;
    L9:
        r103 = r310.getStyle();
        goto L10
    }

    public final void X3(IAction r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "targetView");
        int r100 = com.bytedance.android.ecom.arch.slice.action.f.f49989a;
        com.bytedance.android.ecom.arch.slice.action.f.b(null, this.f51026a, W3(), r110, r111, null, null, "slice_view_holder", 128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.slices.a
    public final void b3(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "slice");
        g r102 = this.f51026a;
        String r103 = null;
        Object[] r104 = 0;
        if (r102 == null) goto L5;
        r102.setSliceRebindTarget(null);
    L5:
        this.f51026a = r100;
        r100.setSliceRebindTarget(this);
        Intrinsics.checkNotNullParameter(r100, "slice");
        SlcStyle r105 = r100.getStyle();
        if (r105 != null) goto L8;
        String r106 = "stretch";
        r105 = new SlcStyle(r106, r103, 2, r104 == true ? 1 : 0);
    L8:
        ViewGroup.LayoutParams r107 = s0().getLayoutParams();
        if (r107 != null) goto L12;
        r107 = V3().a(r101);
    L12:
        if (s0().getLayoutParams() != null) goto L15;
        s0().setLayoutParams(r107);
    L15:
        if ((r107 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L17;
        ((StaggeredGridLayoutManager.LayoutParams) r107).setFullSpan(r101);
    L17:
        s0().setLayoutParams(r107);
        if (r105.getWidth() != null) goto L22;
        ViewGroup.LayoutParams r108 = s0().getLayoutParams();
        if (r108 == null) goto L22;
        r108.width = -1;
    L22:
        Y3(r100);
        Intrinsics.checkNotNullParameter(r100, "slice");
    }

    public static void a4(SlcBaseViewHolder r110, View r111, com.bytedance.android.ecom.arch.slice.render.context.b r112, List r113) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "$this$setRadius");
        Intrinsics.checkNotNullParameter(r112, "slcDisplayMetrics");
        com.bytedance.android.ecom.arch.slice.background.a r100 = U3(r111);
        HashMap<String, WeakReference<Bitmap>> r101 = PdpBackgroundUtil.f50015a;
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r100, "bgDrawable");
        Intrinsics.checkNotNullParameter(r112, "slcDisplayMetrics");
        List r114 = r113;
        boolean r102 = true;
        if (r114 != null) goto L5;
    L8:
        boolean r115 = true;
    L10:
        if (r115 == true) goto L22;
        int r116 = r113.size();
        if (r116 == 1) goto L21;
        if (r116 == 2) goto L19;
        if (r116 == 3) goto L18;
        if (r116 != 4) goto L22;
        int r117 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 0), 0.0f)), r112);
        int r103 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 1), 0.0f)), r112);
        int r104 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 2), 0.0f)), r112);
        int r118 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 3), 0.0f)), r112);
    L23:
        com.bytedance.android.ecom.arch.slice.background.c r119 = r100.f50023h;
        if (r119 != null) goto L26;
        r119 = new com.bytedance.android.ecom.arch.slice.background.c();
        r100.f50023h = r119;
    L26:
        r119.f50035a = r117;
        r119.f50036b = r118;
        r119.f50037c = r103;
        r119.f50038d = r104;
        if (r118 > 0) goto L33;
        if (r117 > 0) goto L33;
        if (r103 > 0) goto L33;
        if (r104 > 0) goto L33;
        boolean r105 = false;
    L34:
        r119.f50039e = r105;
        if (r105 == false) goto L84;
        if (r117 != r118) goto L40;
        if (r117 != r103) goto L40;
        if (r117 != r104) goto L40;
        r119.f50040f = 0;
        r119.f50041g = r117;
    L78:
        if (Build.VERSION.SDK_INT >= 28) goto L80;
    L82:
        boolean r120 = false;
    L83:
        r119.f50042h = r120;
    L86:
        if (r100.getBounds().isEmpty() == true) goto L88;
        r119.f50046l = true;
        r119.f50049o = true;
    L88:
        r100.invalidateSelf();
        com.bytedance.android.ecom.arch.slice.background.c r121 = r100.f50023h;
        if (r121 != null) goto L91;
    L93:
        r102 = false;
    L94:
        r111.setClipToOutline(r102);
        return;
    L91:
        if (r121.f50042h == false) goto L93;
    L80:
        if (r119.f50040f == (-1)) goto L82;
        r120 = true;
    L40:
        if (r117 != r103) goto L44;
        if (r118 != 0) goto L44;
        if (r104 != 0) goto L44;
        r119.f50040f = 2;
        r119.f50041g = r117;
    L44:
        if (r118 != r104) goto L48;
        if (r117 != 0) goto L48;
        if (r103 != 0) goto L48;
        r119.f50040f = 4;
        r119.f50041g = r118;
    L48:
        if (r117 != r118) goto L52;
        if (r103 != 0) goto L52;
        if (r104 != 0) goto L52;
        r119.f50040f = 1;
        r119.f50041g = r117;
    L52:
        if (r103 != r104) goto L56;
        if (r117 != 0) goto L56;
        if (r118 != 0) goto L56;
        r119.f50040f = 3;
        r119.f50041g = r103;
    L56:
        if (r117 == 0) goto L61;
        if (r118 != 0) goto L61;
        if (r103 != 0) goto L61;
        if (r104 != 0) goto L61;
        r119.f50040f = 5;
        r119.f50041g = r117;
    L61:
        if (r117 != 0) goto L66;
        if (r118 == 0) goto L66;
        if (r103 != 0) goto L66;
        if (r104 != 0) goto L66;
        r119.f50040f = 6;
        r119.f50041g = r118;
    L66:
        if (r117 != 0) goto L71;
        if (r118 != 0) goto L71;
        if (r103 == 0) goto L71;
        if (r104 != 0) goto L71;
        r119.f50040f = 7;
        r119.f50041g = r103;
    L71:
        if (r117 != 0) goto L76;
        if (r118 != 0) goto L76;
        if (r103 != 0) goto L76;
        if (r104 == 0) goto L76;
        r119.f50040f = 8;
        r119.f50041g = r104;
    L76:
        r119.f50040f = -1;
        r119.f50041g = 0;
        goto L78
    L84:
        r119.f50040f = -1;
        r119.f50041g = 0;
        r119.f50042h = false;
    L33:
        r105 = true;
        goto L34
    L18:
        r117 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 0), 0.0f)), r112);
        r103 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 1), 0.0f)), r112);
        r104 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 2), 0.0f)), r112);
    L20:
        r118 = r103;
        goto L23
    L19:
        r117 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 0), 0.0f)), r112);
        r104 = r117;
        r103 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 1), 0.0f)), r112);
        goto L20
    L21:
        r117 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(CollectionsKt.getOrNull(r113, 0), 0.0f)), r112);
        r118 = r117;
        r103 = r118;
        r104 = r103;
    L22:
        r117 = 0;
        r118 = 0;
        r103 = 0;
        r104 = 0;
        goto L23
    L5:
        if (r114.isEmpty() == true) goto L8;
        r115 = false;
        goto L10
    }
}
