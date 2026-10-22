package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.oui.color.j0;
import com.obric.oui.graphic.BlendMode;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes4.dex */
public final class MaterialXmlParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MaterialXmlParser f15185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f15186b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "", "xmlName", "", "nodeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getNodeName", "()Ljava/lang/String;", "getXmlName", "NORMAL", "PRESS", "HOVER", "CHECKED", "SELECTED", "DISABLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum MaterialState extends Enum<MaterialState> {
        private static final /* synthetic */ MaterialState[] $VALUES = null;
        public static final MaterialState CHECKED = null;
        public static final MaterialState DISABLE = null;
        public static final MaterialState HOVER = null;
        public static final MaterialState NORMAL = null;
        public static final MaterialState PRESS = null;
        public static final MaterialState SELECTED = null;

        @NotNull
        private final String nodeName;

        @NotNull
        private final String xmlName;

        private static final /* synthetic */ MaterialState[] $values() {
            return new MaterialState[]{NORMAL, PRESS, HOVER, CHECKED, SELECTED, DISABLE};
        }

        static {
            String r10 = "NORMAL";
            int r11 = 0;
            String r12 = "normal";
            String r13 = null;
            NORMAL = new MaterialState(r10, r11, r12, r13, 2, null);
            int r14 = 2;
            DefaultConstructorMarker r15 = null;
            String r16 = null;
            PRESS = new MaterialState("PRESS", 1, "press", r16, r14, r15);
            int r17 = 2;
            DefaultConstructorMarker r18 = null;
            String r19 = null;
            HOVER = new MaterialState("HOVER", 2, "hover", r19, r17, r18);
            CHECKED = new MaterialState("CHECKED", 3, CommonConfirmDialog.ARGS_CHECKED, r16, r14, r15);
            SELECTED = new MaterialState("SELECTED", 4, "selected", r19, r17, r18);
            DISABLE = new MaterialState("DISABLE", 5, "disable", r16, r14, r15);
            $VALUES = $values();
        }

        private MaterialState(String r10, int r11, String r12, String r13) {
            super(r10, r11);
            this.xmlName = r12;
            this.nodeName = r13;
        }

        public static MaterialState valueOf(String r10) {
            return (MaterialState) Enum.valueOf(MaterialState.class, r10);
        }

        public static MaterialState[] values() {
            return (MaterialState[]) $VALUES.clone();
        }

        @NotNull
        public final String getNodeName() {
            return this.nodeName;
        }

        @NotNull
        public final String getXmlName() {
            return this.xmlName;
        }

        public /* synthetic */ MaterialState(String r10, int r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L5;
            r13 = r12;
        L5:
            this(r10, r11, r12, r13);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.obric.oui.color.a[] f15187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ld.a f15188b;

        public a(com.obric.oui.color.a[] r10, ld.a r11) {
            kotlin.jvm.internal.q.g(r10, "defaultConfig");
            kotlin.jvm.internal.q.g(r11, "stateList");
            this.f15187a = r10;
            this.f15188b = r11;
        }

        public final com.obric.oui.color.a[] a() {
            return this.f15187a;
        }

        public final ld.a b() {
            return this.f15188b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (kotlin.jvm.internal.q.b(this.f15187a, r11.f15187a) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.q.b(this.f15188b, r11.f15188b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f15187a) * 31) + this.f15188b.hashCode();
        }

        public String toString() {
            return "ParsedBlendConfigContainer(defaultConfig=" + Arrays.toString(this.f15187a) + ", stateList=" + this.f15188b + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f15189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f15190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f15191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f15192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f15193e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f15194f;

        public b(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
            this.f15189a = r10;
            this.f15190b = r11;
            this.f15191c = r12;
            this.f15192d = r13;
            this.f15193e = r14;
            this.f15194f = r15;
        }

        public final boolean a(Function2 r10) {
            kotlin.jvm.internal.q.g(r10, "comparator");
            if (((Boolean) r10.mo0invoke(this.f15189a, this.f15190b)).booleanValue() == true) goto L5;
        L13:
            return false;
        L5:
            if (((Boolean) r10.mo0invoke(this.f15189a, this.f15191c)).booleanValue() == false) goto L13;
            if (((Boolean) r10.mo0invoke(this.f15189a, this.f15192d)).booleanValue() == false) goto L13;
            if (((Boolean) r10.mo0invoke(this.f15189a, this.f15193e)).booleanValue() == false) goto L13;
            if (((Boolean) r10.mo0invoke(this.f15189a, this.f15194f)).booleanValue() == false) goto L13;
            return true;
        }

        public final Object b() {
            return this.f15192d;
        }

        public final Object c() {
            return this.f15194f;
        }

        public final Object d() {
            return this.f15191c;
        }

        public final Object e() {
            return this.f15189a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (kotlin.jvm.internal.q.b(this.f15189a, r11.f15189a) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.q.b(this.f15190b, r11.f15190b) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.q.b(this.f15191c, r11.f15191c) == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.q.b(this.f15192d, r11.f15192d) == true) goto L21;
            return false;
        L21:
            if (kotlin.jvm.internal.q.b(this.f15193e, r11.f15193e) == true) goto L24;
            return false;
        L24:
            if (kotlin.jvm.internal.q.b(this.f15194f, r11.f15194f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final Object f() {
            return this.f15190b;
        }

        public final Object g() {
            return this.f15193e;
        }

        public int hashCode() {
            Object r10 = this.f15189a;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = r12 * 31;
            Object r14 = this.f15190b;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            Object r17 = this.f15191c;
            if (r17 != null) goto L13;
            int r18 = 0;
        L14:
            int r19 = (r16 + r18) * 31;
            Object r20 = this.f15192d;
            if (r20 != null) goto L17;
            int r21 = 0;
        L18:
            int r22 = (r19 + r21) * 31;
            Object r23 = this.f15193e;
            if (r23 != null) goto L21;
            int r24 = 0;
        L22:
            int r25 = (r22 + r24) * 31;
            Object r26 = this.f15194f;
            if (r26 == null) goto L27;
            r11 = r26.hashCode();
        L27:
            return r25 + r11;
        L21:
            r24 = r23.hashCode();
            goto L22
        L17:
            r21 = r20.hashCode();
            goto L18
        L13:
            r18 = r17.hashCode();
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "ResolvedStatefulValues(normal=" + this.f15189a + ", pressed=" + this.f15190b + ", hovered=" + this.f15191c + ", checked=" + this.f15192d + ", selected=" + this.f15193e + ", disabled=" + this.f15194f + ')';
        }
    }

    static {
        f15185a = new MaterialXmlParser();
        f15186b = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public MaterialXmlParser() {
    }

    public static final /* synthetic */ String a(MaterialXmlParser r10, String r11) {
        return r10.j(r11);
    }

    public static final /* synthetic */ com.obric.oui.material.b b(MaterialXmlParser r10, XmlPullParser r11) {
        return r10.z(r11);
    }

    public static final /* synthetic */ com.obric.oui.material.b[] c(MaterialXmlParser r10, XmlPullParser r11) {
        return r10.A(r11);
    }

    public static /* synthetic */ String h(MaterialXmlParser r10, XmlPullParser r11, MaterialState r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = null;
    L9:
        return r10.g(r11, r12, r13, r14);
    }

    public final com.obric.oui.material.b[] A(XmlPullParser r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.getDepth();
    L3:
        int r13 = r10.next();
        boolean r14 = true;
        if (r13 == 1) goto L17;
        if (r13 != 2) goto L8;
        String r15 = r10.getName();
        kotlin.jvm.internal.q.f(r15, "parser.name");
        if (kotlin.jvm.internal.q.b(j(r15), "material_config") == true) goto L15;
        M(r10);
        goto L3
    L15:
        r11.add(z(r10));
        goto L3
    L8:
        if (r13 != 3) goto L3;
        if (r10.getDepth() != r12) goto L3;
    L17:
        Object[] r16 = r11.toArray(new com.obric.oui.material.b[0]);
        if (r16 == null) goto L29;
        if (((com.obric.oui.material.b[]) r16).length == 0) goto L23;
        r14 = false;
    L23:
        if (r14 == false) goto L27;
        r16 = null;
    L27:
        return (com.obric.oui.material.b[]) r16;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final com.obric.oui.shadow.a[] B(XmlPullParser r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.getDepth();
    L3:
        int r13 = r10.next();
        boolean r14 = true;
        if (r13 == 1) goto L20;
        if (r13 != 2) goto L8;
        String r15 = r10.getName();
        kotlin.jvm.internal.q.f(r15, "parser.name");
        if (kotlin.jvm.internal.q.b(j(r15), "shadow") == true) goto L15;
        M(r10);
        goto L3
    L15:
        com.obric.oui.shadow.a r16 = C(r10);
        if (r16 == null) goto L3;
        r11.add(r16);
        goto L3
    L8:
        if (r13 != 3) goto L3;
        if (r10.getDepth() != r12) goto L3;
    L20:
        Object[] r17 = r11.toArray(new com.obric.oui.shadow.a[0]);
        if (r17 == null) goto L32;
        if (((com.obric.oui.shadow.a[]) r17).length == 0) goto L26;
        r14 = false;
    L26:
        if (r14 == false) goto L30;
        r17 = null;
    L30:
        return (com.obric.oui.shadow.a[]) r17;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final com.obric.oui.shadow.a C(XmlPullParser r10) {
        Integer r11 = r(f(r10, new String[]{"color"}));
        if (r11 != null) goto L6;
        M(r10);
        return null;
    L6:
        int r12 = r11.intValue();
        Float r13 = w(f(r10, new String[]{FixCard.FixStyle.KEY_X}));
        if (r13 != null) goto L9;
        float r14 = 0.0f;
    L10:
        Float r15 = w(f(r10, new String[]{FixCard.FixStyle.KEY_Y}));
        if (r15 != null) goto L13;
        float r16 = 0.0f;
    L14:
        Float r17 = w(f(r10, new String[]{"blur_radius"}));
        if (r17 != null) goto L17;
        float r18 = 0.0f;
    L18:
        Float r19 = w(f(r10, new String[]{"spread"}));
        if (r19 != null) goto L21;
        float r20 = 0.0f;
    L22:
        Integer r21 = o(f(r10, new String[]{"blend_mode"}));
        if (r21 != null) goto L26;
        int r22 = -1;
    L27:
        com.obric.oui.shadow.a r23 = new com.obric.oui.shadow.a(r14, r16, r18, r12, r20, r22);
        M(r10);
        return r23;
    L26:
        r22 = r21.intValue();
        goto L27
    L21:
        r20 = r19.floatValue();
        goto L22
    L17:
        r18 = r17.floatValue();
        goto L18
    L13:
        r16 = r15.floatValue();
        goto L14
    L9:
        r14 = r13.floatValue();
        goto L10
    }

    public final com.obric.oui.color.a[] D(XmlPullParser r10, String r11, MaterialState r12) {
        com.obric.oui.color.a r13 = n(r10, r11, r12);
        if (r13 != null) goto L6;
        return null;
    L6:
        return new com.obric.oui.color.a[]{r13};
    }

    public final a E(XmlPullParser r10, String r11) {
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        b r12 = K(D(r10, r11, MaterialState.NORMAL), D(r10, r11, MaterialState.PRESS), D(r10, r11, MaterialState.HOVER), D(r10, r11, MaterialState.CHECKED), D(r10, r11, MaterialState.SELECTED), D(r10, r11, MaterialState.DISABLE));
        if (r12 != null) goto L10;
        return null;
    L10:
        ld.a r13 = d(r12);
        return new a(r13.c(), r13);
    L6:
        if (kotlin.text.o.r(r11) == true) goto L4;
        goto L4
    }

    public final ColorStateList F(XmlPullParser r15) {
        b r16 = K(r(h(this, r15, MaterialState.NORMAL, null, null, 12, null)), r(h(this, r15, MaterialState.PRESS, null, null, 12, null)), r(h(this, r15, MaterialState.HOVER, null, null, 12, null)), r(h(this, r15, MaterialState.CHECKED, null, null, 12, null)), r(h(this, r15, MaterialState.SELECTED, null, null, 12, null)), r(h(this, r15, MaterialState.DISABLE, null, null, 12, null)));
        if (r16 != null) goto L6;
        return null;
    L6:
        return e(r16);
    }

    public final j0 G(XmlPullParser r10) {
        Float r11 = w(f(r10, new String[]{Style.KEY_WIDTH}));
        Integer r12 = r(f(r10, new String[]{"color"}));
        Integer r13 = o(f(r10, new String[]{"blend_mode"}));
        M(r10);
        BlendMode r14 = null;
        if (r11 == null) goto L19;
        if (r12 == null) goto L19;
        float r15 = r11.floatValue();
        int r16 = r12.intValue();
        if (r13 == null) goto L15;
        int r17 = r13.intValue();
        BlendMode[] r18 = BlendMode.values();
        int r19 = r18.length;
        int r20 = 0;
    L10:
        if (r20 >= r19) goto L15;
        BlendMode r21 = r18[r20];
        if (r21.porterDuffMode == r17) goto L13;
        r20 = r20 + 1;
        goto L10
    L13:
        r14 = r21;
    L15:
        if (r14 != null) goto L18;
        r14 = BlendMode.SRC_OVER;
    L18:
        return new j0(r15, r16, r14);
    L19:
        return null;
    }

    public final j0 H(XmlPullParser r10) {
        if (i(r10, new String[]{Style.KEY_WIDTH, "color"}) == true) goto L5;
        int r11 = r10.getDepth();
    L7:
        int r12 = r10.next();
        if (r12 == 1) goto L30;
        if (r12 == 2) goto L17;
        if (r12 != 3) goto L7;
        if (r10.getDepth() != r11) goto L7;
        return null;
    L17:
        String r13 = r10.getName();
        kotlin.jvm.internal.q.f(r13, "parser.name");
        if (kotlin.jvm.internal.q.b(j(r13), "stroke") == true) goto L29;
        M(r10);
        return null;
    L29:
        return G(r10);
    L30:
        return null;
    L5:
        return G(r10);
    }

    public final ld.c I(XmlPullParser r12) {
        if (i(r12, new String[]{Style.KEY_WIDTH, "color"}) == false) goto L9;
        j0 r11 = G(r12);
        if (r11 != null) goto L8;
        return null;
    L8:
        return ld.c.f21939b.e(r11);
    L9:
        int r10 = r12.getDepth();
        j0 r13 = null;
        j0 r14 = null;
        j0 r15 = null;
        j0 r16 = null;
        j0 r17 = null;
        j0 r18 = null;
        j0 r19 = null;
    L10:
        int r20 = r12.next();
        if (r20 == 1) goto L42;
        if (r20 != 2) goto L15;
        String r21 = r12.getName();
        kotlin.jvm.internal.q.f(r21, "parser.name");
        String r22 = j(r21);
        if (kotlin.jvm.internal.q.b(r22, "stroke") == true) goto L22;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.NORMAL.getNodeName()) == true) goto L25;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.PRESS.getNodeName()) == true) goto L28;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.HOVER.getNodeName()) == true) goto L31;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.CHECKED.getNodeName()) == true) goto L34;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.SELECTED.getNodeName()) == true) goto L37;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.DISABLE.getNodeName()) == true) goto L40;
        M(r12);
        goto L10
    L40:
        r19 = H(r12);
        goto L10
    L37:
        r18 = H(r12);
        goto L10
    L34:
        r17 = H(r12);
        goto L10
    L31:
        r16 = H(r12);
        goto L10
    L28:
        r15 = H(r12);
        goto L10
    L25:
        r13 = H(r12);
        goto L10
    L22:
        r14 = G(r12);
        goto L10
    L15:
        if (r20 != 3) goto L10;
        if (r12.getDepth() != r10) goto L10;
    L42:
        if (r13 != null) goto L44;
        j0 r23 = r14;
    L45:
        b r110 = K(r23, r15, r16, r17, r18, r19);
        if (r110 != null) goto L49;
        return null;
    L49:
        return ld.c.a.d(ld.c.f21939b, (j0) r110.e(), null, (j0) r110.b(), (j0) r110.f(), (j0) r110.d(), (j0) r110.c(), 2, null);
    L44:
        r23 = r13;
        goto L45
    }

    public final String J(XmlPullParser r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.getDepth();
    L3:
        int r13 = r10.next();
        if (r13 == 1) goto L19;
        if (r13 != 2) goto L8;
        M(r10);
        goto L3
    L8:
        if (r13 != 3) goto L10;
        if (r10.getDepth() != r12) goto L3;
    L10:
        if (r13 == 4) goto L14;
        if (r13 != 5) goto L3;
    L14:
        r11.append(r10.getText());
    L19:
        String r14 = r11.toString();
        kotlin.jvm.internal.q.f(r14, "builder.toString()");
        String r15 = StringsKt__StringsKt.z0(r14).toString();
        if (r15.length() > 0) goto L37;
        return null;
    L37:
        return r15;
    }

    public final b K(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        Object r16 = r10;
    L8:
        if (r12 != null) goto L10;
        Object r17 = r16;
    L12:
        if (r13 != null) goto L14;
        Object r18 = r10;
    L15:
        if (r14 != null) goto L17;
        Object r19 = r10;
    L18:
        if (r15 != null) goto L20;
        Object r20 = r10;
    L22:
        return new b(r10, r16, r17, r18, r19, r20);
    L20:
        r20 = r15;
        goto L22
    L17:
        r19 = r14;
        goto L18
    L14:
        r18 = r13;
        goto L15
    L10:
        r17 = r12;
        goto L12
    L7:
        r16 = r11;
        goto L8
    }

    public final com.obric.oui.color.a[] L(com.obric.oui.color.a r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new com.obric.oui.color.a[]{r10};
    }

    public final void M(XmlPullParser r10) {
        int r11 = 1;
    L3:
        if (r11 <= 0) goto L13;
        int r12 = r10.next();
        if (r12 == 1) goto L23;
        if (r12 != 2) goto L9;
        r11 = r11 + 1;
        goto L3
    L9:
        if (r12 != 3) goto L3;
        r11 = r11 - 1;
        goto L3
    L23:
        return;
    }

    public final ld.a d(b r15) {
        if (r15.a(MaterialXmlParser$buildBlendConfigStateList$1.INSTANCE) == false) goto L7;
        return ld.a.f21932b.e((com.obric.oui.color.a[]) r15.e());
    L7:
        return ld.a.f21932b.c(f15186b, new com.obric.oui.color.a[][]{(com.obric.oui.color.a[]) r15.b(), (com.obric.oui.color.a[]) r15.b(), (com.obric.oui.color.a[]) r15.g(), (com.obric.oui.color.a[]) r15.g(), (com.obric.oui.color.a[]) r15.g(), (com.obric.oui.color.a[]) r15.g(), (com.obric.oui.color.a[]) r15.f(), (com.obric.oui.color.a[]) r15.d(), (com.obric.oui.color.a[]) r15.b(), (com.obric.oui.color.a[]) r15.g(), (com.obric.oui.color.a[]) r15.c(), (com.obric.oui.color.a[]) r15.e()});
    }

    public final ColorStateList e(b r15) {
        if (r15.a(MaterialXmlParser$buildColorStateList$1.INSTANCE) == false) goto L7;
        ColorStateList r14 = ColorStateList.valueOf(((Number) r15.e()).intValue());
        kotlin.jvm.internal.q.f(r14, "valueOf(values.normal)");
        return r14;
    L7:
        return new ColorStateList(f15186b, new int[]{((Number) r15.b()).intValue(), ((Number) r15.b()).intValue(), ((Number) r15.g()).intValue(), ((Number) r15.g()).intValue(), ((Number) r15.g()).intValue(), ((Number) r15.g()).intValue(), ((Number) r15.f()).intValue(), ((Number) r15.d()).intValue(), ((Number) r15.b()).intValue(), ((Number) r15.g()).intValue(), ((Number) r15.c()).intValue(), ((Number) r15.e()).intValue()});
    }

    public final String f(XmlPullParser r10, String... r11) {
        if (r11.length != 0) goto L5;
        return null;
    L5:
        Set r12 = kotlin.collections.n.O(r11);
        int r13 = r10.getAttributeCount();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L23;
        int r15 = r14 + 1;
        String r16 = r10.getAttributeName(r14);
        if (r16 == null) goto L22;
        if (r12.contains(r16) == false) goto L22;
        String r17 = r10.getAttributeValue(r14);
        if (r17 == null) goto L29;
        String r18 = StringsKt__StringsKt.z0(r17).toString();
        if (r18 != null) goto L19;
        return null;
    L19:
        if (r18.length() > 0) goto L21;
        return null;
    L21:
        return r18;
    L29:
        return null;
    L22:
        r14 = r15;
        goto L6
    L23:
        return null;
    }

    public final String g(XmlPullParser r10, MaterialState r11, String r12, String r13) {
        String r14 = r11.getXmlName();
        List r15 = s.c();
        if (r13 != null) goto L5;
    L11:
        if (r12 == null) goto L14;
        r15.add(r14 + '_' + r12);
    L14:
        if (r12 != null) goto L16;
        r15.add(r14);
    L16:
        Object[] r16 = s.a(r15).toArray(new String[0]);
        if (r16 == null) goto L21;
        String[] r17 = (String[]) r16;
        return f(r10, (String[]) Arrays.copyOf(r17, r17.length));
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L5:
        if (kotlin.text.o.r(r13) == true) goto L11;
        r15.add(r13 + '_' + r14);
        if (r12 == null) goto L11;
        r15.add(r13 + '_' + r14 + '_' + r12);
        goto L11
    }

    public final boolean i(XmlPullParser r10, String... r11) {
        if (f(r10, (String[]) Arrays.copyOf(r11, r11.length)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String j(String r10) {
        String r11 = StringsKt__StringsKt.z0(r10).toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.q.f(r11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return kotlin.text.o.w(r11, '-', '_', false, 4, null);
    }

    public final com.obric.oui.color.a[] k(XmlPullParser r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.getDepth();
    L3:
        int r13 = r10.next();
        boolean r14 = true;
        if (r13 == 1) goto L20;
        if (r13 != 2) goto L8;
        String r15 = r10.getName();
        kotlin.jvm.internal.q.f(r15, "parser.name");
        if (kotlin.jvm.internal.q.b(j(r15), "blend_config") == true) goto L15;
        M(r10);
        goto L3
    L15:
        com.obric.oui.color.a r16 = m(r10);
        if (r16 == null) goto L3;
        r11.add(r16);
        goto L3
    L8:
        if (r13 != 3) goto L3;
        if (r10.getDepth() != r12) goto L3;
    L20:
        Object[] r17 = r11.toArray(new com.obric.oui.color.a[0]);
        if (r17 == null) goto L32;
        if (((com.obric.oui.color.a[]) r17).length == 0) goto L26;
        r14 = false;
    L26:
        if (r14 == false) goto L30;
        r17 = null;
    L30:
        return (com.obric.oui.color.a[]) r17;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final a l(XmlPullParser r13) {
        a r10 = E(r13, null);
        if (r10 == null) goto L5;
        f15185a.M(r13);
        return r10;
    L5:
        if (i(r13, new String[]{"color"}) == false) goto L11;
        com.obric.oui.color.a[] r12 = L(m(r13));
        if (r12 != null) goto L10;
        return null;
    L10:
        return new a(r12, ld.a.f21932b.e(r12));
    L11:
        ArrayList r11 = new ArrayList();
        int r14 = r13.getDepth();
        com.obric.oui.color.a[] r15 = null;
        com.obric.oui.color.a[] r16 = null;
        com.obric.oui.color.a[] r17 = null;
        com.obric.oui.color.a[] r18 = null;
        com.obric.oui.color.a[] r19 = null;
        com.obric.oui.color.a[] r110 = null;
    L12:
        int r20 = r13.next();
        boolean r111 = true;
        if (r20 == 1) goto L48;
        if (r20 != 2) goto L17;
        String r21 = r13.getName();
        kotlin.jvm.internal.q.f(r21, "parser.name");
        String r22 = j(r21);
        if (kotlin.jvm.internal.q.b(r22, "blend_config") == true) goto L24;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.NORMAL.getNodeName()) == true) goto L30;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.PRESS.getNodeName()) == true) goto L33;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.HOVER.getNodeName()) == true) goto L36;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.CHECKED.getNodeName()) == true) goto L39;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.SELECTED.getNodeName()) == true) goto L42;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.DISABLE.getNodeName()) == true) goto L45;
        M(r13);
        goto L12
    L45:
        r110 = k(r13);
        goto L12
    L42:
        r19 = k(r13);
        goto L12
    L39:
        r18 = k(r13);
        goto L12
    L36:
        r17 = k(r13);
        goto L12
    L33:
        r16 = k(r13);
        goto L12
    L30:
        r15 = k(r13);
        goto L12
    L24:
        com.obric.oui.color.a r23 = m(r13);
        if (r23 == null) goto L12;
        r11.add(r23);
        goto L12
    L17:
        if (r20 != 3) goto L12;
        if (r13.getDepth() != r14) goto L12;
    L48:
        if (r15 != null) goto L57;
        if (r11.isEmpty() == true) goto L57;
        Object[] r24 = r11.toArray(new com.obric.oui.color.a[0]);
        if (r24 == null) goto L56;
        r15 = (com.obric.oui.color.a[]) r24;
        goto L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L57:
        b r25 = K(r15, r16, r17, r18, r19, r110);
        if (r25 == null) goto L61;
        ld.a r112 = d(r25);
        return new a(r112.c(), r112);
    L61:
        Object[] r113 = r11.toArray(new com.obric.oui.color.a[0]);
        if (r113 == null) goto L76;
        if (((com.obric.oui.color.a[]) r113).length == 0) goto L67;
        r111 = false;
    L67:
        if (r111 == false) goto L70;
        r113 = null;
    L70:
        com.obric.oui.color.a[] r114 = (com.obric.oui.color.a[]) r113;
        if (r114 != null) goto L74;
        return null;
    L74:
        return new a(r114, ld.a.f21932b.e(r114));
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final com.obric.oui.color.a m(XmlPullParser r10) {
        Integer r11 = r(f(r10, new String[]{"color"}));
        if (r11 != null) goto L6;
        M(r10);
        return null;
    L6:
        int r12 = r11.intValue();
        Integer r13 = o(f(r10, new String[]{"blend_mode"}));
        if (r13 != null) goto L9;
        int r14 = BlendMode.SRC_OVER.porterDuffMode;
    L10:
        M(r10);
        return new com.obric.oui.color.a(r12, r14);
    L9:
        r14 = r13.intValue();
        goto L10
    }

    public final com.obric.oui.color.a n(XmlPullParser r10, String r11, MaterialState r12) {
        Integer r13 = r(g(r10, r12, "color", r11));
        if (r13 != null) goto L6;
        return null;
    L6:
        int r14 = r13.intValue();
        Integer r15 = o(g(r10, r12, "blend_mode", r11));
        if (r15 != null) goto L9;
        int r16 = BlendMode.SRC_OVER.porterDuffMode;
    L11:
        return new com.obric.oui.color.a(r14, r16);
    L9:
        r16 = r15.intValue();
        goto L11
    }

    public final Integer o(String r10) {
        if (r10 != null) goto L5;
    L4:
        String r11 = null;
    L10:
        if (r11 != null) goto L12;
        return null;
    L12:
        Integer r12 = kotlin.text.n.g(r11);
        if (r12 != null) goto L26;
        String r13 = j(r11).toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.q.f(r13, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        BlendMode[] r14 = BlendMode.values();
        int r15 = r14.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L20;
        BlendMode r17 = r14[r16];
        String r18 = f15185a.j(r17.name()).toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.q.f(r18, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (kotlin.jvm.internal.q.b(r18, r13) == true) goto L21;
        r16 = r16 + 1;
    L21:
        if (r17 != null) goto L24;
        return null;
    L24:
        return Integer.valueOf(r17.porterDuffMode);
    L20:
        r17 = null;
        goto L21
    L26:
        return Integer.valueOf(r12.intValue());
    L5:
        r11 = StringsKt__StringsKt.z0(r10).toString();
        if (r11 == null) goto L4;
        if (r11.length() <= 0) goto L4;
        goto L4
    }

    public final pc.a p(XmlPullParser r10) {
        Float r11 = w(f(r10, new String[]{"blur_radius"}));
        Integer r12 = q(f(r10, new String[]{"direction"}));
        int r13 = 0;
        if (r12 != null) goto L5;
        int r14 = 0;
    L6:
        Float r15 = w(f(r10, new String[]{"alpha"}));
        if (r15 != null) goto L9;
        float r16 = 1.0f;
    L10:
        Integer r17 = t(f(r10, new String[]{"curve_type"}));
        if (r17 != null) goto L13;
    L12:
        int r18 = r13;
        Float r19 = w(f(r10, new String[]{"end_point"}));
        if (r19 != null) goto L17;
        float r20 = 1.0f;
    L18:
        M(r10);
        if (r11 != null) goto L23;
        return null;
    L23:
        return new pc.a(r11.floatValue(), r14, r16, r18, r20);
    L17:
        r20 = r19.floatValue();
        goto L18
    L13:
        r13 = r17.intValue();
        goto L12
    L9:
        r16 = r15.floatValue();
        goto L10
    L5:
        r14 = r12.intValue();
        goto L6
    }

    public final Integer q(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = j(r10);
        switch(r11.hashCode()) {
            case -1372950257: goto L29;
            case -1039745817: goto L25;
            case -885896177: goto L21;
            case -149309725: goto L17;
            case 3387192: goto L13;
            case 818060433: goto L9;
            default: goto L38;
        };
    L9:
        if (r11.equals("progress_rightleft") == false) goto L38;
        return 4;
    L13:
        if (r11.equals(SchedulerSupport.NONE) == false) goto L38;
        return -1;
    L17:
        if (r11.equals("progress_leftright") == false) goto L38;
        return 3;
    L21:
        if (r11.equals("progress_updown") == false) goto L38;
        return 2;
    L25:
        if (r11.equals("normal") == false) goto L38;
        return 0;
    L29:
        if (r11.equals("progress_downup") == false) goto L38;
        return 1;
    L38:
        return kotlin.text.n.g(r10);
    }

    public final Integer r(String r10) {
        if (r10 != null) goto L5;
    L4:
        String r11 = null;
    L10:
        if (r11 != null) goto L28;
        return null;
    L28:
        if (kotlin.text.o.B(r11, "#", false, 2, null) == false) goto L16;
        int r12 = Color.parseColor(r11);     // Catch: Throwable -> L27
    L25:
        return Integer.valueOf(r12);
    L16:
        if (kotlin.text.o.A(r11, "0x", true) == false) goto L18;
        String r13 = r11.substring(2);     // Catch: Throwable -> L27
        kotlin.jvm.internal.q.f(r13, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L27
        r12 = (int) Long.parseLong(r13, kotlin.text.a.a(16));     // Catch: Throwable -> L27
        goto L25
    L18:
        Long r14 = kotlin.text.n.i(r11);     // Catch: Throwable -> L27
        if (r14 != null) goto L21;
        Integer r15 = null;
    L22:
        if (r15 != null) goto L24;
        r12 = Color.parseColor(r11);     // Catch: Throwable -> L27
        goto L25
    L24:
        r12 = r15.intValue();     // Catch: Throwable -> L27
        goto L25
    L21:
        r15 = Integer.valueOf((int) r14.longValue());     // Catch: Throwable -> L27
    L30:
        return null;
    L5:
        r11 = StringsKt__StringsKt.z0(r10).toString();
        if (r11 == null) goto L4;
        if (r11.length() <= 0) goto L4;
        goto L4
    }

    public final Integer s(XmlPullParser r10) {
        Integer r11 = r(f(r10, new String[]{"color"}));
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
        f15185a.M(r10);
        return Integer.valueOf(r12);
    L5:
        return r(J(r10));
    }

    public final Integer t(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = j(r10);
        switch(r11.hashCode()) {
            case -1102672091: goto L33;
            case -356211779: goto L29;
            case -32570448: goto L25;
            case 54365080: goto L21;
            case 1672389401: goto L17;
            case 1829408660: goto L13;
            case 1939029025: goto L9;
            default: goto L43;
        };
    L9:
        if (r11.equals("in_quad") == false) goto L43;
        return 1;
    L13:
        if (r11.equals("inout_cubic") == false) goto L43;
        return 6;
    L17:
        if (r11.equals("out_cubic") == false) goto L43;
        return 5;
    L21:
        if (r11.equals("out_quad") == false) goto L43;
        return 2;
    L25:
        if (r11.equals("in_cubic") == false) goto L43;
        return 4;
    L29:
        if (r11.equals("inout_quad") == false) goto L43;
        return 3;
    L33:
        if (r11.equals("linear") == false) goto L43;
        return 0;
    L43:
        return kotlin.text.n.g(r10);
    }

    public final ColorStateList u(XmlPullParser r11) {
        ColorStateList r10 = F(r11);
        if (r10 != null) goto L46;
        Integer r12 = r(f(r11, new String[]{"color"}));
        if (r12 == null) goto L8;
        M(r11);
        return ColorStateList.valueOf(r12.intValue());
    L8:
        int r13 = r11.getDepth();
        Integer r14 = null;
        Integer r15 = null;
        Integer r16 = null;
        Integer r17 = null;
        Integer r18 = null;
        Integer r19 = null;
    L9:
        int r20 = r11.next();
        if (r20 == 1) goto L38;
        if (r20 != 2) goto L14;
        String r21 = r11.getName();
        kotlin.jvm.internal.q.f(r21, "parser.name");
        String r22 = j(r21);
        if (kotlin.jvm.internal.q.b(r22, MaterialState.NORMAL.getNodeName()) == true) goto L21;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.PRESS.getNodeName()) == true) goto L24;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.HOVER.getNodeName()) == true) goto L27;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.CHECKED.getNodeName()) == true) goto L30;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.SELECTED.getNodeName()) == true) goto L33;
        if (kotlin.jvm.internal.q.b(r22, MaterialState.DISABLE.getNodeName()) == true) goto L36;
        M(r11);
        goto L9
    L36:
        r19 = s(r11);
        goto L9
    L33:
        r18 = s(r11);
        goto L9
    L30:
        r17 = s(r11);
        goto L9
    L27:
        r16 = s(r11);
        goto L9
    L24:
        r15 = s(r11);
        goto L9
    L21:
        r14 = s(r11);
        goto L9
    L14:
        if (r20 != 3) goto L9;
        if (r11.getDepth() != r13) goto L9;
    L38:
        if (r14 != null) goto L40;
        Integer r23 = null;
    L41:
        b r110 = K(r23, r15, r16, r17, r18, r19);
        if (r110 != null) goto L45;
        return null;
    L45:
        return e(r110);
    L40:
        r23 = r14;
        goto L41
    L46:
        f15185a.M(r11);
        return r10;
    }

    public final ColorStateList v(XmlPullParser r15) {
        Integer r10 = r(h(this, r15, MaterialState.NORMAL, null, "fallback_bg_color", 4, null));
        if (r10 != null) goto L5;
        r10 = r(f(r15, new String[]{"fallback_bg_color"}));
    L5:
        b r16 = K(r10, r(h(this, r15, MaterialState.PRESS, null, "fallback_bg_color", 4, null)), r(h(this, r15, MaterialState.HOVER, null, "fallback_bg_color", 4, null)), r(h(this, r15, MaterialState.CHECKED, null, "fallback_bg_color", 4, null)), r(h(this, r15, MaterialState.SELECTED, null, "fallback_bg_color", 4, null)), r(h(this, r15, MaterialState.DISABLE, null, "fallback_bg_color", 4, null)));
        if (r16 != null) goto L9;
        return null;
    L9:
        return e(r16);
    }

    public final Float w(String r10) {
        if (r10 != null) goto L5;
    L4:
        String r11 = null;
    L10:
        if (r11 != null) goto L13;
        return null;
    L13:
        return kotlin.text.m.f(StringsKt__StringsKt.g0(StringsKt__StringsKt.g0(StringsKt__StringsKt.g0(r11, "dp"), "px"), CloudControlInf.SP));
    L5:
        r11 = StringsKt__StringsKt.z0(r10).toString();
        if (r11 == null) goto L4;
        if (r11.length() <= 0) goto L4;
        goto L4
    }

    public final com.obric.oui.fluid.a x(XmlPullParser r10) {
        float[] r11 = y(r10);
        M(r10);
        return new com.obric.oui.fluid.a(r11);
    }

    public final float[] y(XmlPullParser r11) {
        Float r10 = w(f(r11, new String[]{"refraction_height"}));
        if (r10 != null) goto L5;
        return null;
    L5:
        float r12 = r10.floatValue();
        Float r13 = w(f(r11, new String[]{"refraction_strength"}));
        if (r13 != null) goto L8;
        return null;
    L8:
        float r14 = r13.floatValue();
        Float r15 = w(f(r11, new String[]{"highlight_angle"}));
        if (r15 != null) goto L11;
        return null;
    L11:
        float r16 = r15.floatValue();
        Float r17 = w(f(r11, new String[]{"highlight_falloff"}));
        if (r17 != null) goto L14;
        return null;
    L14:
        float r18 = r17.floatValue();
        Float r19 = w(f(r11, new String[]{"highlight_width"}));
        if (r19 != null) goto L17;
        return null;
    L17:
        float r20 = r19.floatValue();
        Float r21 = w(f(r11, new String[]{"highlight_alpha"}));
        if (r21 != null) goto L20;
        return null;
    L20:
        float r22 = r21.floatValue();
        Float r23 = w(f(r11, new String[]{"highlight_inset"}));
        if (r23 != null) goto L23;
        return null;
    L23:
        float r24 = r23.floatValue();
        Float r25 = w(f(r11, new String[]{"highlight_strength"}));
        if (r25 != null) goto L26;
        return null;
    L26:
        int r26 = 0;
        float[] r27 = {r12, r14, r16, r18, r20, r22, r24, r25.floatValue()};
        Integer r28 = r(f(r11, new String[]{"first_layer_highlight_color"}));
        Integer r29 = o(f(r11, new String[]{"first_layer_highlight_blend_mode"}));
        Integer r30 = r(f(r11, new String[]{"second_layer_highlight_color"}));
        Integer r31 = o(f(r11, new String[]{"second_layer_highlight_blend_mode"}));
        Float r110 = w(f(r11, new String[]{"chromatic_aberration"}));
        if (r28 != null) goto L32;
        if (r29 != null) goto L32;
        if (r30 != null) goto L32;
        if (r31 != null) goto L32;
        if (r110 != null) goto L32;
        return r27;
    L32:
        kotlin.jvm.internal.o r111 = new kotlin.jvm.internal.o(6);
        r111.a(r27);
        kotlin.jvm.internal.n r32 = kotlin.jvm.internal.n.f21182a;
        if (r28 != null) goto L35;
        int r33 = 0;
    L36:
        r111.g(Float.intBitsToFloat(r33));
        if (r29 != null) goto L39;
        int r34 = BlendMode.SRC_OVER.porterDuffMode;
    L40:
        r111.g(r34);
        if (r30 == null) goto L44;
        r26 = r30.intValue();
    L44:
        r111.g(Float.intBitsToFloat(r26));
        if (r31 != null) goto L47;
        int r35 = BlendMode.SRC_OVER.porterDuffMode;
    L48:
        r111.g(r35);
        if (r110 != null) goto L51;
        float r112 = 0.0f;
    L52:
        r111.g(r112);
        return r111.i();
    L51:
        r112 = r110.floatValue();
        goto L52
    L47:
        r35 = r31.intValue();
        goto L48
    L39:
        r34 = r29.intValue();
        goto L40
    L35:
        r33 = r28.intValue();
        goto L36
    }

    public final com.obric.oui.material.b z(XmlPullParser r15) {
        com.obric.oui.material.b r13 = new com.obric.oui.material.b(v(r15), null, null, null, null, null, null, w(f(r15, new String[]{"blur_radius"})), null, null, 894, null);
        a r10 = E(r15, "blend_configs");
        if (r10 == null) goto L6;
        r13.l(r10.a());
        r13.m(r10.b());
    L6:
        int r11 = r15.getDepth();
    L7:
        int r12 = r15.next();
        if (r12 == 1) goto L74;
        if (r12 != 2) goto L12;
        String r14 = r15.getName();
        kotlin.jvm.internal.q.f(r14, "parser.name");
        String r16 = j(r14);
        switch(r16.hashCode()) {
            case -1622636237: goto L69;
            case -1115483408: goto L61;
            case -891980232: goto L57;
            case -220247165: goto L44;
            case 97532362: goto L40;
            case 737726312: goto L33;
            case 1690590746: goto L29;
            case 1873723302: goto L25;
            case 2053811027: goto L21;
            default: goto L70;
        };
    L25:
        if (r16.equals("fallback_bg_color") == false) goto L70;
        r13.o(u(r15));
        goto L7
    L29:
        if (r16.equals("blur_config") == false) goto L70;
        r13.n(p(r15));
        goto L7
    L33:
        if (r16.equals("stroke_statelist") == false) goto L70;
        ld.c r17 = I(r15);
        if (r17 == null) goto L7;
        r13.t(r17);
        goto L7
    L40:
        if (r16.equals("fluid") == false) goto L70;
        r13.p(x(r15));
        goto L7
    L44:
        if (r16.equals("blend_configs") == false) goto L70;
        a r18 = l(r15);
        ld.a r19 = null;
        if (r18 != null) goto L49;
        com.obric.oui.color.a[] r20 = null;
    L50:
        r13.l(r20);
        if (r18 == null) goto L54;
        r19 = r18.b();
    L54:
        if (r19 == null) goto L7;
        r13.m(r18.b());
        goto L7
    L49:
        r20 = r18.a();
        goto L50
    L57:
        if (r16.equals("stroke") == false) goto L70;
        r13.s(G(r15));
        goto L7
    L61:
        if (r16.equals("blend_config") == false) goto L70;
        if (i(r15, new String[]{"color"}) == false) goto L66;
        com.obric.oui.color.a[] r21 = L(m(r15));
    L67:
        r13.l(r21);
        goto L7
    L66:
        r21 = k(r15);
        goto L67
    L69:
        if (r16.equals("overlayblend_configs") == false) goto L70;
        a r22 = l(r15);
        if (r22 == null) goto L7;
        r13.q(r22.b());
    L70:
        M(r15);
        goto L7
    L21:
        if (r16.equals("shadows") == false) goto L70;
        r13.r(B(r15));
        goto L7
    L12:
        if (r12 != 3) goto L7;
        if (r15.getDepth() != r11) goto L7;
        return r13;
    L74:
        return r13;
    }
}
