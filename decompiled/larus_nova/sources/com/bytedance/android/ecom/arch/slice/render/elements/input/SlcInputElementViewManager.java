package com.bytedance.android.ecom.arch.slice.render.elements.input;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.provider.FontsContractCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcActionSource;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.h;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.i;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcInputElementViewManager extends BaseSlcViewManager<SlcInputElementView> {

    /* JADX INFO: renamed from: p4, reason: collision with root package name */
    public static final a f50423p4 = null;
    public boolean H3;
    public CharSequence I3;
    public boolean J3;
    public int K3;
    public IAction L3;
    public IAction M3;
    public IAction N3;
    public IAction O3;
    public IAction P3;
    public String Q3;
    public Object R3;
    public Object S3;
    public Object T3;
    public String U3;
    public Integer V3;
    public Set<Character> W3;
    public boolean X3;
    public Object Y3;
    public Object Z3;

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public Object f50424a4;

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public boolean f50425b4;

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public Object f50426c4;

    /* JADX INFO: renamed from: d4, reason: collision with root package name */
    public Object f50427d4;

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    public Object f50428e4;

    /* JADX INFO: renamed from: f4, reason: collision with root package name */
    public Object f50429f4;

    /* JADX INFO: renamed from: g4, reason: collision with root package name */
    public Object f50430g4;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public Object f50431h4;

    /* JADX INFO: renamed from: i4, reason: collision with root package name */
    public Object f50432i4;

    /* JADX INFO: renamed from: j4, reason: collision with root package name */
    public Object f50433j4;

    /* JADX INFO: renamed from: k4, reason: collision with root package name */
    public Object f50434k4;

    /* JADX INFO: renamed from: l4, reason: collision with root package name */
    public Object f50435l4;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    public Object f50436m4;

    /* JADX INFO: renamed from: n4, reason: collision with root package name */
    public Object f50437n4;

    /* JADX INFO: renamed from: o4, reason: collision with root package name */
    public boolean f50438o4;

    public static final class a {
        public a() {
        }

        public static CharSequence a(String r100, CharSequence r110, Integer r111) {
            StringBuilder r101 = new StringBuilder();
            int r102 = r100.length();
            int r103 = r110.length();
            int r104 = 0;
            int r105 = 0;
        L4:
            if (r104 >= r102) goto L19;
            if (r105 >= r103) goto L19;
            char r106 = r100.charAt(r104);
            char r107 = r110.charAt(r105);
            if (r106 == '#') goto L17;
            if (r106 == '\\') goto L10;
            r101.append(r106);
        L18:
            r104 = r104 + 1;
            goto L4
        L10:
            r104 = r104 + 1;
            if (r104 >= r102) goto L16;
            char r108 = r100.charAt(r104);
            if (r108 != '#') goto L15;
            r101.append('#');
            goto L18
        L15:
            r101.append(r106);
            r101.append(r108);
            goto L18
        L16:
            r101.append(r106);
            goto L18
        L17:
            r101.append(r107);
            r105 = r105 + 1;
        L19:
            int r112 = r110.length();
            if (r111 == null) goto L38;
            if (r111.intValue() != r112) goto L38;
            if (r104 >= r102) goto L38;
        L25:
            if (r104 >= r102) goto L38;
            char r113 = r100.charAt(r104);
            if (r113 != '\\') goto L35;
            r104 = r104 + 1;
            if (r104 >= r102) goto L34;
            char r114 = r100.charAt(r104);
            if (r114 != '#') goto L33;
            r101.append('#');
        L36:
            r104 = r104 + 1;
            goto L25
        L33:
            r101.append(r113);
            r101.append(r114);
            goto L36
        L34:
            r101.append(r113);
            goto L36
        L35:
            r101.append(r113);
        L38:
            return r101.toString();
        }

        public static CharSequence b(String r100, CharSequence r101, int r110, int r111) {
            if (r110 <= r111) goto L4;
            return r101;
        L4:
            StringBuilder r102 = new StringBuilder();
            int r103 = r100.length();
            int r104 = 0;
            int r105 = r110;
        L6:
            if (r104 >= r110) goto L24;
            Character r106 = StringsKt.getOrNull(r101, r104);
            if (r106 == null) goto L23;
            if (r106.charValue() != '#') goto L23;
            Character r107 = StringsKt.getOrNull(r100, r104);
            if (r107 == null) goto L23;
            if (r107.charValue() != '\\') goto L23;
            Character r108 = StringsKt.getOrNull(r100, r104 + 1);
            if (r108 == null) goto L23;
            if (r108.charValue() != '#') goto L23;
            r105 = r105 + 1;
        L23:
            r104 = r104 + 1;
        L24:
            if (r105 >= r103) goto L43;
            if (r110 >= r111) goto L43;
            Character r109 = StringsKt.getOrNull(r100, r105);
            Character r112 = StringsKt.getOrNull(r101, r110);
            if (r109 != null) goto L30;
        L32:
            if (r109 == null) goto L41;
            if (r109.charValue() != '\\') goto L41;
            r105 = r105 + 1;
            if (r105 >= r103) goto L41;
            if (r100.charAt(r105) == '#') goto L41;
            r110 = r110 + 1;
        L41:
            r110 = r110 + 1;
            r105 = r105 + 1;
            goto L24
        L30:
            if (r109.charValue() != '#') goto L32;
            r102.append(r112);
        L43:
            return r102.toString();
        }
    }

    public final class b implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcInputElementViewManager f50439a;

        public b(SlcInputElementViewManager r100) {
            this.f50439a = r100;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r210, int r211, int r212, Spanned r213, int r214, int r215) {
            int r100 = r214;
            SlcInputElementViewManager r101 = this.f50439a;
            if (r101.J3 == false) goto L5;
            return null;
        L5:
            String r102 = r101.U3;
            Set<Character> r103 = r101.W3;
            boolean r104 = true;
            if (r103 != null) goto L8;
        L16:
            String r105 = r210;
        L17:
            int r106 = r105.length();
            String r107 = this.f50439a.U3;
            if (r107 != null) goto L20;
        L23:
            boolean r110 = true;
        L25:
            if (r110 == true) goto L30;
            a r111 = SlcInputElementViewManager.f50423p4;
            SlcInputElementViewManager r112 = this.f50439a;
            CharSequence r113 = r112.I3;
            Integer r114 = r112.V3;
            r111.getClass();
            if ((!Intrinsics.areEqual(a.a(r107, r113, r114).toString(), r213.toString())) == false) goto L32;
            this.f50439a.I3 = a.b(r107, r213, 0, r213.length()).toString();
            this.f50439a.K3 = -1;
        L32:
            CharSequence r108 = this.f50439a.I3;
            if (r102 != null) goto L35;
        L38:
            boolean r115 = true;
        L39:
            if (r115 == false) goto L41;
            int r116 = 0;
            int r117 = 0;
        L60:
            int r109 = r100 - r116;
            int r118 = r215 - r117;
            int r119 = r211;
            StringBuilder r120 = new StringBuilder(r108).replace(r109, r118, r105.subSequence(r119, r106).toString());
            IAction r121 = this.f50439a.M3;
            if (r121 == null) goto L64;
            HashMap r122 = new HashMap();
            r122.put("raw_input_value", r120.toString());
            SlcInputElementViewManager r123 = this.f50439a;
            r123.f50260a.d(r121, r123.getView(), r123.l(), r122, SlcActionSource.ON_WILL_CHANGE);
        L64:
            if (Intrinsics.areEqual(this.f50439a.T3, "number") == false) goto L78;
            int r124 = 0;
        L67:
            if (r124 >= r105.length()) goto L78;
            char r125 = r105.charAt(r124);
            if ('0' <= r125) goto L72;
        L74:
            boolean r126 = false;
        L75:
            if (r126 == false) goto L76;
            r124 = r124 + 1;
            goto L67
        L76:
            String r127 = "";
        L79:
            CharSequence r128 = r105;
            if (Intrinsics.areEqual(r127, "") == false) goto L82;
            return "";
        L82:
            if (r127 == null) goto L84;
            r106 = r127.length();
            r128 = r127;
            r119 = 0;
        L84:
            String r129 = this.f50439a.U3;
            if (r129 != null) goto L87;
        L90:
            boolean r130 = true;
        L91:
            if (r130 == true) goto L93;
            Integer r131 = this.f50439a.V3;
        L94:
            if (r131 != null) goto L96;
        L109:
            CharSequence r132 = null;
        L110:
            CharSequence r133 = r128;
            if (Intrinsics.areEqual(r132, "") == false) goto L113;
            return "";
        L113:
            if (r132 == null) goto L115;
            r106 = r132.length();
            r133 = r132;
            r119 = 0;
        L115:
            SlcInputElementViewManager r134 = this.f50439a;
            if (Intrinsics.areEqual(r133, r210) == true) goto L119;
            r120 = new StringBuilder(r108).replace(r109, r118, r133.subSequence(r119, r106).toString());
        L119:
            r134.I3 = r120;
            if (r102 != null) goto L122;
        L125:
            if (r104 == true) goto L127;
            SlcInputElementViewManager r135 = this.f50439a;
            a r136 = SlcInputElementViewManager.f50423p4;
            CharSequence r137 = r135.I3.subSequence(0, (r109 + r106) - r119);
            Integer r138 = this.f50439a.V3;
            r136.getClass();
            r135.K3 = ((String) a.a(r102, r137, r138)).length();
        L127:
            return r133;
        L122:
            if (StringsKt.isBlank(r102) == true) goto L125;
            r104 = false;
            goto L125
        L96:
            if (r131.intValue() < 0) goto L109;
            int r139 = r131.intValue() - (r108.length() - (r118 - r109));
            if (r139 > 0) goto L101;
        L106:
            r132 = "";
            goto L110
        L101:
            if (r139 >= (r106 - r119)) goto L109;
            int r140 = r139 + r119;
            int r141 = r140 - 1;
            if (Character.isHighSurrogate(r128.charAt(r141)) == false) goto L108;
            if (r141 == r119) goto L106;
            r140 = r141;
        L108:
            r132 = r128.subSequence(r119, r140);
            goto L110
        L93:
            r131 = com.bytedance.android.ecom.arch.slice.render.util.b.i(this.f50439a.S3);
            goto L94
        L87:
            if (StringsKt.isBlank(r129) == true) goto L90;
            r130 = false;
            goto L91
        L72:
            if ('9' < r125) goto L74;
            r126 = true;
        L78:
            r127 = null;
            goto L79
        L41:
            if (r210.length() != 0) goto L43;
            boolean r142 = true;
        L44:
            if (r142 == false) goto L58;
            if (r100 >= r215) goto L58;
            if (r100 == 0) goto L57;
            SlcInputElementViewManager.f50423p4.getClass();
            int r143 = a.b(r102, r213, r100, r215).length();
            if (r143 > 0) goto L51;
            int r144 = 2;
        L52:
            r100 = r100 - 1;
            if (r100 < 0) goto L57;
            SlcInputElementViewManager.f50423p4.getClass();
            if (a.b(r102, r213, r100, r215).length() < r144) goto L52;
            r100 = r100 + 1;
            goto L58
        L51:
            r144 = r143 + 1;
        L57:
            r100 = 0;
        L58:
            SlcInputElementViewManager.f50423p4.getClass();
            r116 = r100 - a.b(r102, r213, 0, r100).length();
            r117 = ((r215 - r100) - a.b(r102, r213, r100, r215).length()) + r116;
            goto L60
        L43:
            r142 = false;
            goto L44
        L35:
            if (StringsKt.isBlank(r102) == true) goto L38;
            r115 = false;
            goto L39
        L30:
            if ((!Intrinsics.areEqual(this.f50439a.I3.toString(), r213.toString())) == false) goto L32;
            SlcInputElementViewManager r145 = this.f50439a;
            r145.I3 = r213;
            r145.K3 = -1;
            goto L32
        L20:
            if (StringsKt.isBlank(r107) == true) goto L23;
            r110 = false;
            goto L25
        L8:
            if ((!((HashSet) r103).isEmpty()) != true) goto L16;
            SlcInputElementViewManager r146 = this.f50439a;
            r146.getClass();
            String r147 = r210.toString();
            Set<Character> r148 = r146.W3;
            r105 = r147;
            if (r148 == null) goto L17;
            Iterator r149 = ((HashSet) r148).iterator();
            String r150 = r147;
        L13:
            if (r149.hasNext() == false) goto L15;
            r150 = StringsKt.replace$default(r150, String.valueOf(((Character) r149.next()).charValue()), "", false, 4, null);
            goto L13
        L15:
            r105 = r150;
            goto L17
        }
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final String a0() {
        return AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName;
    }

    static {
        f50423p4 = new a();
    }

    public final void m1() {
        if (this.f50438o4 == false) goto L18;
        EditText r100 = getView().getTextInput();
        String r101 = com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50435l4);
        int r102 = com.bytedance.android.ecom.arch.slice.render.util.b.f(this.f50433j4, 400);
        if (this.f50260a.f50235w.f50174g == false) goto L7;
        com.bytedance.android.ecom.arch.slice.render.elements.text.d r103 = new com.bytedance.android.ecom.arch.slice.render.elements.text.d(this.Q3);
        r103.setSpan(i.b(r102, com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50434k4), r101), 0, this.Q3.length(), 18);
        r100.setText(r103);
    L16:
        this.f50438o4 = false;
        return;
    L7:
        r100.setText(this.Q3);
        boolean r104 = Intrinsics.areEqual(com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50434k4), "italic");
        boolean r105 = h.a(Integer.valueOf(r102));
        if (r104 == false) goto L10;
        int r106 = 2;
    L11:
        int r107 = r106 | (r105 ? 1 : 0);
        Typeface r108 = i.c(null, r102, r107, r101);
        r100.setTypeface(r108);
        i.a(r100.getPaint(), r107);
        if (r108 != null) goto L16;
        int r109 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        SlcInputElementViewManager$setText$1 r110 = SlcInputElementViewManager$setText$1.INSTANCE;
        SliceRender.f50121o.getClass();
        pq.a r111 = SliceRender.f50108b;
        if (r111 == null) goto L16;
        r111.g(4, r110);
        goto L16
    L10:
        r106 = 0;
        goto L11
    }

    public final boolean k1() {
        EditText r100 = getView().getTextInput();
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L26:
        return false;
    L8:
        if (r100.isFocusable() == false) goto L26;
        if (r100.isEnabled() == false) goto L26;
        if (getView().getBottom() > getView().getTop()) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return true;
    L19:
        if (getView().isLaidOut() == true) goto L21;
    L23:
        boolean r103 = false;
    L24:
        if (r103 == false) goto L26;
        return true;
    L21:
        if (getView().isLayoutRequested() == true) goto L23;
        r103 = true;
        goto L24
    L14:
        if (getView().getRight() <= getView().getLeft()) goto L16;
        r102 = true;
        goto L17
    L5:
        r101 = false;
        goto L6
    }

    public SlcInputElementViewManager(SlcTemplateContext r100) {
        super(r100);
        this.I3 = "";
        this.K3 = -1;
        this.Q3 = "";
        this.f50428e4 = "none";
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View A0(Context r100) {
        AttributeSet r101 = null;
        return new SlcInputElementView(r100, r101, 6, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r100) {
        if (getView().dispatchHoverEvent(r100) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void G0(Map<String, ? extends Object> r100) {
        this.N3 = n.a(r100.get(SlcActionSource.ON_FOCUS));
        this.M3 = n.a(r100.get(SlcActionSource.ON_WILL_CHANGE));
        this.L3 = n.a(r100.get(SlcActionSource.ON_CHANGE));
        this.O3 = n.a(r100.get(SlcActionSource.ON_BLUR));
        IAction r101 = this.P3;
        IAction r102 = n.a(r100.get("on_suffix"));
        this.P3 = r102;
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L9;
        final IAction r103 = this.P3;
        if (r103 == null) goto L7;
        getView().getSuffixIcon().setOnClickListener(new SlcInputElementViewManager$onUpdateAction$1(this, r103));
        return;
    L7:
        getView().getSuffixIcon().setOnClickListener(null);
        getView().getSuffixIcon().setClickable(false);
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r110) {
        EditText r100 = getView().getTextInput();
        Iterator<Map.Entry<String, ? extends Object>> r111 = r110.entrySet().iterator();
        boolean r101 = false;
        boolean r102 = false;
    L3:
        int r103 = 1;
        Object r104 = null;
        Object r105 = null;
        Float r106 = null;
        if (r111.hasNext() == false) goto L208;
        Map.Entry<String, ? extends Object> r107 = r111.next();
        String r112 = r107.getKey();
        Object r108 = r107.getValue();
        switch(r112.hashCode()) {
            case -1278082919: goto L160;
            case -1268779017: goto L152;
            case -916844246: goto L144;
            case -827649017: goto L136;
            case -691434242: goto L128;
            case -56434618: goto L91;
            case 3556653: goto L79;
            case 97604824: goto L67;
            case 98073629: goto L59;
            case 512961100: goto L51;
            case 598246771: goto L43;
            case 1111390753: goto L38;
            case 1386692239: goto L17;
            case 2097322329: goto L9;
            default: goto L3;
        };
    L9:
        if (r112.equals("confirm_type") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50426c4, r108)) == false) goto L13;
        this.f50426c4 = r108;
    L14:
        if (r103 == 0) goto L3;
        getView().setSlcConfirmType(com.bytedance.android.ecom.arch.slice.render.util.b.r(r108));
        goto L3
    L13:
        r103 = 0;
        goto L14
    L17:
        if (r112.equals("input_type") == false) goto L3;
        if ((!Intrinsics.areEqual(this.T3, r108)) == false) goto L21;
        this.T3 = r108;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L3;
        if ((r108 instanceof String) == false) goto L27;
        r105 = r108;
    L27:
        String r113 = (String) r105;
        if (r113 != null) goto L31;
    L36:
        r100.setRawInputType(r103);
        goto L3
    L31:
        if (r113.hashCode() != (-1034364087)) goto L36;
        if (r113.equals("number") == false) goto L36;
        r103 = 4098;
        goto L36
    L21:
        r109 = false;
        goto L22
    L38:
        if (r112.equals("max_length") == false) goto L3;
        if ((true ^ Intrinsics.areEqual(this.S3, r108)) == false) goto L3;
        this.S3 = r108;
        goto L3
    L43:
        if (r112.equals(GXTemplateKey.GAIAX_PLACEHOLDER) == false) goto L3;
        if ((!Intrinsics.areEqual(this.R3, r108)) == false) goto L47;
        this.R3 = r108;
        boolean r114 = true;
    L48:
        if (r114 == false) goto L3;
    L142:
        r102 = true;
        goto L3
    L47:
        r114 = false;
        goto L48
    L51:
        if (r112.equals("suffix_icon_src") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50427d4, r108)) == false) goto L55;
        this.f50427d4 = r108;
    L56:
        if (r103 == 0) goto L3;
        getView().setSuffixIconSrc(com.bytedance.android.ecom.arch.slice.render.util.b.r(r108));
        goto L3
    L55:
        r103 = 0;
        goto L56
    L59:
        if (r112.equals("placeholder_text_color") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50424a4, r108)) == false) goto L63;
        this.f50424a4 = r108;
        boolean r115 = true;
    L64:
        if (r115 == false) goto L3;
    L63:
        r115 = false;
        goto L64
    L67:
        if (r112.equals(ButtonColorBean.StateFocus) == false) goto L3;
        boolean r116 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r108);
        if (this.X3 != r116) goto L71;
        boolean r117 = true;
    L73:
        if ((!r117) == false) goto L75;
        this.X3 = r116;
    L76:
        if (r103 == 0) goto L3;
        N0(r116);
        goto L3
    L75:
        r103 = 0;
        goto L76
    L71:
        r117 = false;
        goto L73
    L79:
        if (r112.equals("text") == false) goto L3;
        String r118 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r108);
        if (r118 != null) goto L85;
        r118 = "";
    L85:
        if ((!Intrinsics.areEqual(this.Q3, r118)) == false) goto L87;
        this.Q3 = r118;
        boolean r119 = true;
    L88:
        if (r119 == false) goto L3;
        this.f50438o4 = true;
        goto L3
    L87:
        r119 = false;
        goto L88
    L91:
        if (r112.equals("suffix_icon_margin") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50430g4, r108)) == false) goto L95;
        this.f50430g4 = r108;
        boolean r120 = true;
    L96:
        if (r120 == false) goto L3;
        if ((r108 instanceof List) == true) goto L100;
        r108 = null;
    L100:
        List r121 = (List) r108;
        int r122 = SlcDimensExtensionsKt.a(Float.valueOf(3.0f), this.f50260a.m());
        List r123 = r121;
        if (r123 != null) goto L103;
    L106:
        if (r103 != 0) goto L107;
        Object r124 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.d(r121);
        if (r124 == null) goto L111;
        Float r125 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r124);
    L112:
        if (r125 != null) goto L114;
    L117:
        int r126 = r122;
    L118:
        Object r127 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.c(r121);
        if (r127 == null) goto L121;
        r106 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r127);
    L121:
        if (r106 != null) goto L123;
    L126:
        SlcInputElementView r128 = getView();
        r128.f50420d = r122;
        r128.f50421e = r126;
        goto L3
    L123:
        if (r106.floatValue() < 0) goto L126;
        r122 = Math.round(SlcDimensExtensionsKt.c(r106, this.f50260a.m()));
        goto L126
    L114:
        if (r125.floatValue() < 0) goto L117;
        r126 = Math.round(SlcDimensExtensionsKt.c(r125, this.f50260a.m()));
        goto L118
    L111:
        r125 = null;
        goto L112
    L107:
        SlcInputElementView r129 = getView();
        r129.f50420d = r122;
        r129.f50421e = r122;
        goto L3
    L103:
        if (r123.isEmpty() == true) goto L106;
        r103 = 0;
        goto L106
    L95:
        r120 = false;
        goto L96
    L128:
        if (r112.equals("placeholder_text_weight") == false) goto L3;
        if ((!Intrinsics.areEqual(this.Z3, r108)) == false) goto L132;
        this.Z3 = r108;
        boolean r130 = true;
    L133:
        if (r130 == false) goto L3;
    L132:
        r130 = false;
        goto L133
    L136:
        if (r112.equals("placeholder_text_size") == false) goto L3;
        if ((!Intrinsics.areEqual(this.Y3, r108)) == false) goto L140;
        this.Y3 = r108;
        boolean r131 = true;
    L141:
        if (r131 == false) goto L3;
    L140:
        r131 = false;
        goto L141
    L144:
        if (r112.equals("suffix_icon_display") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50428e4, r108)) == false) goto L148;
        this.f50428e4 = r108;
    L149:
        if (r103 == 0) goto L3;
        getView().setSuffixDisplay(com.bytedance.android.ecom.arch.slice.render.util.b.r(r108));
        goto L3
    L148:
        r103 = 0;
        goto L149
    L152:
        if (r112.equals(SubInfo.KEY_FORMAT) == false) goto L3;
        if ((!Intrinsics.areEqual(this.U3, r108)) == false) goto L156;
        this.U3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r108);
        boolean r132 = true;
    L157:
        if (r132 == false) goto L3;
        r101 = true;
        goto L3
    L156:
        r132 = false;
        goto L157
    L160:
        if (r112.equals("suffix_icon_size") == false) goto L3;
        if ((!Intrinsics.areEqual(this.f50429f4, r108)) == false) goto L164;
        this.f50429f4 = r108;
        boolean r133 = true;
    L165:
        if (r133 == false) goto L3;
        if ((r108 instanceof List) == false) goto L170;
        r104 = r108;
    L170:
        List r134 = (List) r104;
        if (r134 == null) goto L173;
        int r135 = r134.size();
    L175:
        if (r135 <= 1) goto L192;
        if (r134 == null) goto L182;
        Object r136 = CollectionsKt.getOrNull(r134, 0);
        if (r136 == null) goto L182;
        Float r137 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r136);
        if (r137 == null) goto L182;
        float r138 = r137.floatValue();
    L183:
        int r139 = SlcDimensExtensionsKt.a(Float.valueOf(r138), this.f50260a.m());
        if (r134 == null) goto L190;
        Object r140 = CollectionsKt.getOrNull(r134, 1);
        if (r140 == null) goto L190;
        Float r141 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r140);
        if (r141 == null) goto L190;
        float r142 = r141.floatValue();
    L191:
        int r143 = SlcDimensExtensionsKt.a(Float.valueOf(r142), this.f50260a.m());
    L202:
        int r144 = SlcDimensExtensionsKt.a(Float.valueOf(14.0f), this.f50260a.m());
        if (r139 > 0) goto L205;
        r139 = r144;
    L205:
        if (r143 > 0) goto L207;
        r143 = r144;
    L207:
        SlcInputElementView r145 = getView();
        r145.f50418b = r139;
        r145.f50419c = r143;
    L190:
        r142 = 14.0f;
    L182:
        r138 = 14.0f;
        goto L183
    L192:
        if (r135 <= 0) goto L201;
        if (r134 == null) goto L199;
        Object r146 = CollectionsKt.getOrNull(r134, 0);
        if (r146 == null) goto L199;
        Float r147 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r146);
        if (r147 == null) goto L199;
        float r148 = r147.floatValue();
    L200:
        r139 = SlcDimensExtensionsKt.a(Float.valueOf(r148), this.f50260a.m());
        r143 = r139;
    L199:
        r148 = 14.0f;
        goto L200
    L201:
        r139 = SlcDimensExtensionsKt.a(Float.valueOf(14.0f), this.f50260a.m());
        r143 = SlcDimensExtensionsKt.a(Float.valueOf(14.0f), this.f50260a.m());
        goto L202
    L173:
        r135 = 0;
        goto L175
    L164:
        r133 = false;
        goto L165
    L208:
        if (r101 == false) goto L232;
        String r149 = this.U3;
        if (r149 != null) goto L212;
    L215:
        boolean r150 = true;
    L216:
        if (r150 == true) goto L231;
        HashSet r151 = new HashSet();
        int r152 = r149.length();
        int r153 = 0;
        int r154 = 0;
        boolean r155 = false;
    L218:
        if (r153 >= r152) goto L230;
        char r156 = r149.charAt(r153);
        if (r156 != '#') goto L222;
        if (r155 == true) goto L227;
        r154 = r154 + 1;
    L228:
        r155 = false;
    L229:
        r153 = r153 + 1;
        goto L218
    L227:
        r151.add(Character.valueOf(r156));
        goto L228
    L222:
        if (r156 == '\\') goto L224;
        r151.add(Character.valueOf(r156));
        goto L228
    L224:
        r155 = true;
        goto L229
    L230:
        this.W3 = r151;
        this.V3 = Integer.valueOf(r154);
        goto L232
    L231:
        this.W3 = null;
        this.V3 = null;
        goto L232
    L212:
        if (StringsKt.isBlank(r149) == true) goto L215;
        r150 = false;
    L232:
        String r157 = com.bytedance.android.ecom.arch.slice.render.util.b.r(this.R3);
        if (r102 == false) goto L341;
        if (r157 != null) goto L236;
    L239:
        if (r103 != 0) goto L342;
        SpannableStringBuilder r158 = new SpannableStringBuilder(r157);
        CharacterStyle r159 = l1("placeholder_text_size");
        if (r159 == null) goto L243;
        r158.setSpan(r159, 0, r158.length(), 33);
    L243:
        CharacterStyle r160 = l1("placeholder_text_weight");
        if (r160 == null) goto L246;
        r158.setSpan(r160, 0, r158.length(), 33);
    L246:
        CharacterStyle r161 = l1("placeholder_text_color");
        if (r161 == null) goto L249;
        r158.setSpan(r161, 0, r158.length(), 33);
    L249:
        r100.setHint(r158);
        return;
    L342:
        return;
    L236:
        if (StringsKt.isBlank(r157) == true) goto L239;
        r103 = 0;
        goto L239
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void I0(Map<String, ? extends Object> r100) {
        EditText r101 = getView().getTextInput();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L86;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        boolean r106 = false;
        boolean r107 = true;
        switch(r104.hashCode()) {
            case -2117277325: goto L77;
            case -1539906063: goto L65;
            case -1432924870: goto L44;
            case -507058317: goto L30;
            case -492120639: goto L23;
            case 1534043476: goto L16;
            case 2024311912: goto L9;
            default: goto L4;
        };
    L9:
        if (r104.equals(FontsContractCompat.Columns.WEIGHT) == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50433j4, r105)) == false) goto L13;
        this.f50433j4 = r105;
        r106 = true;
    L13:
        if (r106 == false) goto L4;
        this.f50438o4 = true;
        goto L4
    L16:
        if (r104.equals("font_family") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50435l4, r105)) == false) goto L20;
        this.f50435l4 = r105;
        r106 = true;
    L20:
        if (r106 == false) goto L4;
        this.f50438o4 = true;
        goto L4
    L23:
        if (r104.equals("font_style") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50434k4, r105)) == false) goto L27;
        this.f50434k4 = r105;
        r106 = true;
    L27:
        if (r106 == false) goto L4;
        this.f50438o4 = true;
        goto L4
    L30:
        if (r104.equals("font_color") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50431h4, r105)) == false) goto L34;
        this.f50431h4 = r105;
        r106 = true;
    L34:
        if (r106 == false) goto L4;
        if ((r105 instanceof String) == true) goto L38;
        r105 = null;
    L38:
        Integer r108 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r105);
        if (r108 == null) goto L41;
        int r109 = r108.intValue();
    L42:
        r101.setTextColor(r109);
        goto L4
    L41:
        r109 = -15329245;
        goto L42
    L44:
        if (r104.equals("cursor_color") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50437n4, r105)) == false) goto L48;
        this.f50437n4 = r105;
        r106 = true;
    L48:
        if (r106 == false) goto L4;
        SlcInputElementView r110 = getView();
        com.bytedance.android.ecom.arch.slice.render.context.b r111 = this.f50260a.m();
        if ((r105 instanceof String) == true) goto L52;
        r105 = null;
    L52:
        String r112 = (String) r105;
        if (Build.VERSION.SDK_INT >= 29) goto L54;
        r110.getClass();
        goto L4
    L54:
        Drawable r113 = r110.f50417a.getTextCursorDrawable();
        if (r113 != null) goto L57;
    L59:
        GradientDrawable r114 = new GradientDrawable();
    L60:
        Integer r115 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r112);
        if (r115 == null) goto L4;
        r114.setColor(r115.intValue());
        r114.setCornerRadius(SlcDimensExtensionsKt.c(1, r111));
        r114.setSize(SlcDimensExtensionsKt.a(2, r111), -1);
        r110.f50417a.setTextCursorDrawable(r114);
        goto L4
    L57:
        if ((r113 instanceof GradientDrawable) == false) goto L59;
        r114 = (GradientDrawable) r113;
        goto L60
    L65:
        if (r104.equals("font_size") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50432i4, r105)) == false) goto L69;
        this.f50432i4 = r105;
    L70:
        if (r107 == false) goto L4;
        float r116 = 14.0f;
        float r117 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r105, 14.0f);
        if (r117 <= 0) goto L75;
        r116 = r117;
    L75:
        r101.setTextSize(0, SlcDimensExtensionsKt.e(Float.valueOf(r116), this.f50260a.m()));
        goto L4
    L69:
        r107 = false;
        goto L70
    L77:
        if (r104.equals("text_align") == false) goto L4;
        if ((!Intrinsics.areEqual(this.f50436m4, r105)) == false) goto L81;
        this.f50436m4 = r105;
        r106 = true;
    L81:
        if (r106 == false) goto L4;
        SlcInputElementView r118 = getView();
        if ((r105 instanceof String) == true) goto L85;
        r105 = null;
    L85:
        r118.setTextAlign((String) r105);
        goto L4
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void N0(boolean r100) {
        if (r100 == true) goto L4;
        getView().getTextInput().clearFocus();
        Object r101 = getContext().getSystemService("input_method");     // Catch: Throwable -> L18
        if ((r101 instanceof InputMethodManager) == true) goto L12;
        r101 = null;
    L12:
        InputMethodManager r102 = (InputMethodManager) r101;     // Catch: Throwable -> L18
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.isActive() == false) goto L25;
        r102.hideSoftInputFromWindow(getView().getTextInput().getWindowToken(), 0);     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L18:
        th = move-exception;
        nq.a.f(th, "slc input element soft keyboard close error");
        return;
    L4:
        if (k1() == true) goto L7;
        this.H3 = true;
        return;
    L7:
        getView().post(new com.bytedance.android.ecom.arch.slice.render.elements.input.b(this));
    }

    public final CharacterStyle l1(String r100) {
        int r101 = r100.hashCode();
        if (r101 == (-827649017)) goto L25;
        if (r101 == (-691434242)) goto L19;
        if (r101 == 98073629) goto L10;
    L30:
        return null;
    L10:
        if (r100.equals("placeholder_text_color") == false) goto L30;
        Object r102 = this.f50424a4;
        if ((r102 instanceof String) == true) goto L14;
        r102 = null;
    L14:
        Integer r103 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r102);
        if (r103 == null) goto L30;
        return new ForegroundColorSpan(r103.intValue());
    L19:
        if (r100.equals("placeholder_text_weight") == false) goto L30;
        Integer r104 = com.bytedance.android.ecom.arch.slice.render.util.b.i(this.Z3);
        if (r104 == null) goto L30;
        return i.b(r104.intValue(), "normal", null);
    L25:
        if (r100.equals("placeholder_text_size") == false) goto L30;
        Integer r105 = com.bytedance.android.ecom.arch.slice.render.util.b.i(this.Y3);
        if (r105 == null) goto L30;
        return new AbsoluteSizeSpan(Math.round(SlcDimensExtensionsKt.e(Integer.valueOf(r105.intValue()), this.f50260a.m())));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void w0(Map<String, ? extends Object> r100) {
        m1();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void x0(View r100) {
        SlcInputElementView r101 = (SlcInputElementView) r100;
        EditText r102 = r101.getTextInput();
        r102.setText("");
        Float r103 = Float.valueOf(14.0f);
        r102.setTextSize(0, SlcDimensExtensionsKt.e(r103, this.f50260a.m()));
        r102.setTextColor(-15329245);
        r102.setFocusableInTouchMode(true);
        r102.setSingleLine(true);
        r102.setFocusable(true);
        r102.setImeOptions(6);
        r102.setBackground(null);
        r102.setGravity(16);
        r102.setIncludeFontPadding(false);
        int r104 = Build.VERSION.SDK_INT;
        if (r104 >= 26) goto L5;
    L7:
        r102.setRawInputType(1);
        r102.setFilters(new b[]{new b(this)});
        int r105 = SlcDimensExtensionsKt.a(Float.valueOf(3.0f), this.f50260a.m());
        int r106 = SlcDimensExtensionsKt.a(r103, this.f50260a.m());
        r101.f50420d = r105;
        r101.f50421e = r105;
        r101.f50418b = r106;
        r101.f50419c = r106;
        EditText r107 = r101.getTextInput();
        if (r101.isAttachedToWindow() == false) goto L10;
        this.f50260a.f50235w.a();
    L11:
        r107.addTextChangedListener(new c(this, r101));
        r107.setOnFocusChangeListener(new d(this, r101));
        r107.setOnEditorActionListener(new e(this));
        return;
    L10:
        r101.addOnAttachStateChangeListener(new com.bytedance.android.ecom.arch.slice.render.elements.input.a(this));
        goto L11
    L5:
        if (r104 > 27) goto L7;
        r102.setLayerType(1, null);
        r102.setImportantForAutofill(2);
        goto L7
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void y0(SlcElement r100) {
        m1();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void F0(int r100, int r101, int r102, int r103) {
        super.F0(r100, r101, r102, r103);
        if (this.H3 == true) goto L5;
        return;
    L5:
        if (k1() == false) goto L9;
        N0(true);
        this.H3 = false;
        return;
    }
}
