package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.divider.ODivider;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: OLineInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OLineInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final int ARRANGE_DIRECTION_VERTICAL_SINGEL_BOX = 2;
    public static final int CLICK_MODE = 3;
    public static final a Companion = null;
    public static final int INPUT_MODE = 2;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    private final int DEFAULT_MAX_LINES;
    private final ViewGroup actionContainer;
    private ConstraintLayout activeBorderView;
    private int arrangeDirection;
    private b config;
    private TextWatcher counterTextWatcher;
    private final ODivider divider;
    private final OFormEditText editText;
    private String errorTips;
    private final ViewGroup inputContainer;
    private String inputTips;
    private boolean isErrorState;
    private boolean isShowActionImage;
    private boolean isShowActionText;
    private boolean isShowErrorTips;
    private boolean isShowInputTips;
    private boolean isShowPrefix;
    private boolean isShowSuffix;
    private boolean isShowTitle;
    private boolean isShowTitleIcon;
    private final ImageView ivAction;
    private final LinearLayout ivActionContainer;
    private final ImageView ivClear;
    private final LinearLayout ivClearContainer;
    private final ImageView ivTitleIcon;
    private ConstraintLayout leftContainer;
    private final RelativeLayout prefixContainer;
    private boolean showTitleDefaultIcon;
    private final RelativeLayout suffixContainer;
    private String text;
    private int textGravity;
    private final ViewGroup titleContainer;
    private int titleDefaultIconSize;
    private final TextView tvAction;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvInputTips;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OLineInputView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f35277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f35278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f35279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f35280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f35281e;
        private View f;
        private Integer g;
        private boolean h;
        private String i;
        private TextWatcher j;
        private View.OnFocusChangeListener k;
        private boolean l;
        private Drawable m;
        private View.OnClickListener n;
        private View.OnClickListener o;
        private String p;
        private Integer q;
        private Integer r;
        private Drawable s;
        private boolean t;
        private boolean u;
        private boolean v;
        private int w;
        private boolean x;
        private d y;
        private c z;

        /* JADX INFO: compiled from: OLineInputView.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f35282a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f35283b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Drawable f35284c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f35285d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Integer f35286e;
            private boolean f;
            private String g;
            private View h;
            private View i;
            private boolean j;
            private String k;
            private Integer l;
            private boolean m;
            private View.OnClickListener n;
            private Drawable o;
            private View.OnClickListener p;
            private TextWatcher q;
            private View.OnFocusChangeListener r;
            private Integer s;
            private boolean t;
            private boolean u;
            private boolean v;
            private int w;
            private boolean x;
            private d y;
            private c z;

            public a() {
                this(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f35282a, r6.f35282a) == true) goto L12;
                return false;
            L12:
                if (o.a(this.f35283b, r6.f35283b) == true) goto L15;
                return false;
            L15:
                if (o.a(this.f35284c, r6.f35284c) == true) goto L18;
                return false;
            L18:
                if (this.f35285d == r6.f35285d) goto L21;
                return false;
            L21:
                if (o.a(this.f35286e, r6.f35286e) == true) goto L24;
                return false;
            L24:
                if (this.f == r6.f) goto L27;
                return false;
            L27:
                if (o.a(this.g, r6.g) == true) goto L30;
                return false;
            L30:
                if (o.a(this.h, r6.h) == true) goto L33;
                return false;
            L33:
                if (o.a(this.i, r6.i) == true) goto L36;
                return false;
            L36:
                if (this.j == r6.j) goto L39;
                return false;
            L39:
                if (o.a(this.k, r6.k) == true) goto L42;
                return false;
            L42:
                if (o.a(this.l, r6.l) == true) goto L45;
                return false;
            L45:
                if (this.m == r6.m) goto L48;
                return false;
            L48:
                if (o.a(this.n, r6.n) == true) goto L51;
                return false;
            L51:
                if (o.a(this.o, r6.o) == true) goto L54;
                return false;
            L54:
                if (o.a(this.p, r6.p) == true) goto L57;
                return false;
            L57:
                if (o.a(this.q, r6.q) == true) goto L60;
                return false;
            L60:
                if (o.a(this.r, r6.r) == true) goto L63;
                return false;
            L63:
                if (o.a(this.s, r6.s) == true) goto L66;
                return false;
            L66:
                if (this.t == r6.t) goto L69;
                return false;
            L69:
                if (this.u == r6.u) goto L72;
                return false;
            L72:
                if (this.v == r6.v) goto L75;
                return false;
            L75:
                if (this.w == r6.w) goto L78;
                return false;
            L78:
                if (this.x == r6.x) goto L81;
                return false;
            L81:
                if (o.a(this.y, r6.y) == true) goto L84;
                return false;
            L84:
                if (o.a(this.z, r6.z) == true) goto L86;
                return false;
            L86:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23, types: [int] */
            /* JADX WARN: Type inference failed for: r1v31, types: [int] */
            /* JADX WARN: Type inference failed for: r1v51, types: [int] */
            /* JADX WARN: Type inference failed for: r1v53, types: [int] */
            /* JADX WARN: Type inference failed for: r1v55, types: [int] */
            /* JADX WARN: Type inference failed for: r1v63 */
            /* JADX WARN: Type inference failed for: r1v64 */
            /* JADX WARN: Type inference failed for: r1v65 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v72 */
            /* JADX WARN: Type inference failed for: r1v75 */
            /* JADX WARN: Type inference failed for: r1v79 */
            /* JADX WARN: Type inference failed for: r1v81 */
            /* JADX WARN: Type inference failed for: r1v84 */
            /* JADX WARN: Type inference failed for: r1v85 */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v88 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int r0 = this.f35282a.hashCode() * 31;
                String r1 = this.f35283b;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Drawable r5 = this.f35284c;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                boolean r8 = this.f35285d;
                ?? r9 = 1;
                ?? r10 = r8;
                if (r8 == false) goto L13;
                r10 = 1;
            L13:
                int r11 = (r7 + r10) * 31;
                Integer r12 = this.f35286e;
                if (r12 != null) goto L16;
                int r13 = 0;
            L17:
                int r14 = (r11 + r13) * 31;
                boolean r15 = this.f;
                ?? r16 = r15;
                if (r15 == false) goto L20;
                r16 = 1;
            L20:
                int r17 = (r14 + r16) * 31;
                String r18 = this.g;
                if (r18 != null) goto L23;
                int r19 = 0;
            L24:
                int r20 = (r17 + r19) * 31;
                View r21 = this.h;
                if (r21 != null) goto L27;
                int r22 = 0;
            L28:
                int r23 = (r20 + r22) * 31;
                View r24 = this.i;
                if (r24 != null) goto L31;
                int r25 = 0;
            L32:
                int r26 = (r23 + r25) * 31;
                boolean r27 = this.j;
                ?? r28 = r27;
                if (r27 == false) goto L35;
                r28 = 1;
            L35:
                int r29 = (r26 + r28) * 31;
                String r30 = this.k;
                if (r30 != null) goto L38;
                int r31 = 0;
            L39:
                int r32 = (r29 + r31) * 31;
                Integer r33 = this.l;
                if (r33 != null) goto L42;
                int r34 = 0;
            L43:
                int r35 = (r32 + r34) * 31;
                boolean r36 = this.m;
                ?? r37 = r36;
                if (r36 == false) goto L46;
                r37 = 1;
            L46:
                int r38 = (r35 + r37) * 31;
                View.OnClickListener r39 = this.n;
                if (r39 != null) goto L49;
                int r40 = 0;
            L50:
                int r41 = (r38 + r40) * 31;
                Drawable r42 = this.o;
                if (r42 != null) goto L53;
                int r43 = 0;
            L54:
                int r44 = (r41 + r43) * 31;
                View.OnClickListener r45 = this.p;
                if (r45 != null) goto L57;
                int r46 = 0;
            L58:
                int r47 = (r44 + r46) * 31;
                TextWatcher r48 = this.q;
                if (r48 != null) goto L61;
                int r49 = 0;
            L62:
                int r50 = (r47 + r49) * 31;
                View.OnFocusChangeListener r51 = this.r;
                if (r51 != null) goto L65;
                int r52 = 0;
            L66:
                int r53 = (r50 + r52) * 31;
                Integer r54 = this.s;
                if (r54 != null) goto L69;
                int r55 = 0;
            L70:
                int r56 = (r53 + r55) * 31;
                boolean r57 = this.t;
                ?? r58 = r57;
                if (r57 == false) goto L73;
                r58 = 1;
            L73:
                int r59 = (r56 + r58) * 31;
                boolean r60 = this.u;
                ?? r61 = r60;
                if (r60 == false) goto L76;
                r61 = 1;
            L76:
                int r62 = (r59 + r61) * 31;
                boolean r63 = this.v;
                ?? r64 = r63;
                if (r63 == false) goto L79;
                r64 = 1;
            L79:
                int r65 = (((r62 + r64) * 31) + Integer.hashCode(this.w)) * 31;
                boolean r66 = this.x;
                if (r66 == true) goto L83;
                r9 = r66;
            L83:
                int r67 = (r65 + r9) * 31;
                d r68 = this.y;
                if (r68 != null) goto L86;
                int r69 = 0;
            L87:
                int r70 = (r67 + r69) * 31;
                c r71 = this.z;
                if (r71 == null) goto L92;
                r2 = r71.hashCode();
            L92:
                return r70 + r2;
            L86:
                r69 = r68.hashCode();
                goto L87
            L69:
                r55 = r54.hashCode();
                goto L70
            L65:
                r52 = r51.hashCode();
                goto L66
            L61:
                r49 = r48.hashCode();
                goto L62
            L57:
                r46 = r45.hashCode();
                goto L58
            L53:
                r43 = r42.hashCode();
                goto L54
            L49:
                r40 = r39.hashCode();
                goto L50
            L42:
                r34 = r33.hashCode();
                goto L43
            L38:
                r31 = r30.hashCode();
                goto L39
            L31:
                r25 = r24.hashCode();
                goto L32
            L27:
                r22 = r21.hashCode();
                goto L28
            L23:
                r19 = r18.hashCode();
                goto L24
            L16:
                r13 = r12.hashCode();
                goto L17
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append("Builder(title=").append(this.f35282a).append(", inputTips=").append(this.f35283b).append(", titleIcon=").append(this.f35284c).append(", showCounter=").append(this.f35285d).append(", lengthLimit=").append(this.f35286e).append(", showClear=").append(this.f).append(", hintText=").append(this.g).append(", prefixView=").append(this.h).append(", suffixView=").append(this.i).append(", showDivider=").append(this.j).append(", actionText=").append(this.k).append(", actionTextColor=");
                r0.append(this.l).append(", actionTextClickable=").append(this.m).append(", actionTextListener=").append(this.n).append(", actionImageDrawable=").append(this.o).append(", actionImageDrawableListener=").append(this.p).append(", textWatcher=").append(this.q).append(", editTextOnFocusChangeListener=").append(this.r).append(", inputBoxHeight=").append(this.s).append(", isInSearchBar=").append(this.t).append(", autoHideClearWhenTextEmpty=").append(this.u).append(", multiLine=").append(this.v).append(", mode=").append(this.w);
                r0.append(", hideClearWhenNoFocus=").append(this.x).append(", textExceedLengthListener=").append(this.y).append(", textClearedListener=").append(this.z).append(')');
                return r0.toString();
            }

            public a(String r11, String r12, Drawable r13, boolean r14, Integer r15, boolean r16, String r17, View r18, View r19, boolean r20, String r21, Integer r22, boolean r23, View.OnClickListener r24, Drawable r25, View.OnClickListener r26, TextWatcher r27, View.OnFocusChangeListener r28, Integer r29, boolean r30, boolean r31, boolean r32, int r33, boolean r34, d r35, c r36) {
                View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.aiagent.plugin");
                View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r26, View.OnClickListener.class, "com.obric.aiagent.plugin");
                TextWatcher r5 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r27, TextWatcher.class, "com.obric.aiagent.plugin");
                View.OnFocusChangeListener r6 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r28, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
                d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r35, d.class, "com.obric.aiagent.plugin");
                c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r36, c.class, "com.obric.aiagent.plugin");
                o.e(r11, DBDefinition.TITLE);
                this.f35282a = r11;
                this.f35283b = r12;
                this.f35284c = r13;
                this.f35285d = r14;
                this.f35286e = r15;
                this.f = r16;
                this.g = r17;
                this.h = r18;
                this.i = r19;
                this.j = r20;
                this.k = r21;
                this.l = r22;
                this.m = r23;
                this.n = r2;
                this.o = r25;
                this.p = r4;
                this.q = r5;
                this.r = r6;
                this.s = r29;
                this.t = r30;
                this.u = r31;
                this.v = r32;
                this.w = r33;
                this.x = r34;
                this.y = r7;
                this.z = r3;
            }

            public /* synthetic */ a(String r28, String r29, Drawable r30, boolean r31, Integer r32, boolean r33, String r34, View r35, View r36, boolean r37, String r38, Integer r39, boolean r40, View.OnClickListener r41, Drawable r42, View.OnClickListener r43, TextWatcher r44, View.OnFocusChangeListener r45, Integer r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, d r52, c r53, int r54, h r55) {
                View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r41, View.OnClickListener.class, "com.obric.aiagent.plugin");
                View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r43, View.OnClickListener.class, "com.obric.aiagent.plugin");
                TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r44, TextWatcher.class, "com.obric.aiagent.plugin");
                View.OnFocusChangeListener r5 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r45, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r52, d.class, "com.obric.aiagent.plugin");
                c r2 = (c) ZeusTransformUtils.wrapperContextForParams(r53, c.class, "com.obric.aiagent.plugin");
                if ((r54 & 1) == 0) goto L5;
                String r7 = "标题";
            L7:
                if ((r54 & 2) == 0) goto L9;
                String r8 = null;
            L11:
                if ((r54 & 4) == 0) goto L13;
                Drawable r10 = null;
            L15:
                if ((r54 & 8) == 0) goto L17;
                boolean r11 = false;
            L19:
                if ((r54 & 16) == 0) goto L21;
                Integer r13 = null;
            L23:
                if ((r54 & 32) == 0) goto L25;
                boolean r14 = false;
            L27:
                if ((r54 & 64) == 0) goto L29;
                String r15 = null;
            L31:
                if ((r54 & 128) == 0) goto L33;
                View r9 = null;
            L35:
                if ((r54 & 256) == 0) goto L37;
                View r12 = null;
            L38:
                boolean r16 = true;
                if ((r54 & 512) == 0) goto L41;
                boolean r17 = true;
            L43:
                if ((r54 & 1024) == 0) goto L45;
                String r18 = null;
            L47:
                if ((r54 & 2048) == 0) goto L49;
                Integer r19 = null;
            L51:
                if ((r54 & 4096) == 0) goto L53;
                boolean r20 = false;
            L55:
                if ((r54 & 8192) == 0) goto L57;
                View.OnClickListener r21 = null;
            L59:
                if ((r54 & 16384) == 0) goto L61;
                Drawable r22 = null;
            L63:
                if ((r54 & 32768) == 0) goto L65;
                View.OnClickListener r110 = null;
            L67:
                if ((r54 & 65536) == 0) goto L69;
                TextWatcher r111 = null;
            L71:
                if ((r54 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
                View.OnFocusChangeListener r112 = null;
            L75:
                if ((r54 & 262144) == 0) goto L77;
                Integer r23 = null;
            L79:
                if ((r54 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
                boolean r24 = false;
            L83:
                if ((r54 & 1048576) == 0) goto L85;
                boolean r25 = false;
            L87:
                if ((r54 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
                boolean r26 = false;
            L91:
                if ((r54 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
                int r27 = 2;
            L95:
                if ((r54 & UiType.FLAG_APPLET_CARD) != 0) goto L99;
                r16 = r51;
            L99:
                if ((r54 & 16777216) == 0) goto L101;
                d r210 = null;
            L103:
                if ((r54 & 33554432) == 0) goto L105;
                c r0 = null;
            L106:
                this(r7, r8, r10, r11, r13, r14, r15, r9, r12, r17, r18, r19, r20, r21, r22, r110, r111, r112, r23, r24, r25, r26, r27, r16, r210, r0);
                return;
            L105:
                r0 = r2;
                goto L106
            L101:
                r210 = r6;
                goto L103
            L93:
                r27 = r50;
                goto L95
            L89:
                r26 = r49;
                goto L91
            L85:
                r25 = r48;
                goto L87
            L81:
                r24 = r47;
                goto L83
            L77:
                r23 = r46;
                goto L79
            L73:
                r112 = r5;
                goto L75
            L69:
                r111 = r4;
                goto L71
            L65:
                r110 = r3;
                goto L67
            L61:
                r22 = r42;
                goto L63
            L57:
                r21 = r1;
                goto L59
            L53:
                r20 = r40;
                goto L55
            L49:
                r19 = r39;
                goto L51
            L45:
                r18 = r38;
                goto L47
            L41:
                r17 = r37;
                goto L43
            L37:
                r12 = r36;
                goto L38
            L33:
                r9 = r35;
                goto L35
            L29:
                r15 = r34;
                goto L31
            L25:
                r14 = r33;
                goto L27
            L21:
                r13 = r32;
                goto L23
            L17:
                r11 = r31;
                goto L19
            L13:
                r10 = r30;
                goto L15
            L9:
                r8 = r29;
                goto L11
            L5:
                r7 = r28;
                goto L7
            }

            public final b a() {
                String r2 = this.f35282a;
                String r1 = this.f35283b;
                Drawable r3 = this.f35284c;
                boolean r4 = this.f35285d;
                boolean r5 = this.f;
                String r6 = this.g;
                Integer r8 = this.f35286e;
                boolean r9 = this.j;
                String r10 = this.k;
                TextWatcher r11 = this.q;
                View r7 = this.h;
                View r12 = this.i;
                boolean r13 = this.m;
                View.OnClickListener r15 = this.n;
                Drawable r14 = this.o;
                View.OnClickListener r16 = this.p;
                Integer r17 = this.l;
                return new b(r2, r4, r5, r6, r7, r12, r8, r9, r10, r11, this.r, r13, r14, r15, r16, r1, r17, this.s, r3, this.t, this.u, this.v, this.w, this.x, this.y, this.z, null);
            }
        }

        public /* synthetic */ b(String r28, boolean r29, boolean r30, String r31, View r32, View r33, Integer r34, boolean r35, String r36, TextWatcher r37, View.OnFocusChangeListener r38, boolean r39, Drawable r40, View.OnClickListener r41, View.OnClickListener r42, String r43, Integer r44, Integer r45, Drawable r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, d r52, c r53, h r54) {
            this(r28, r29, r30, r31, r32, r33, r34, r35, r36, (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r37, TextWatcher.class, "com.obric.aiagent.plugin"), (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r38, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin"), r39, r40, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r41, View.OnClickListener.class, "com.obric.aiagent.plugin"), (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r42, View.OnClickListener.class, "com.obric.aiagent.plugin"), r43, r44, r45, r46, r47, r48, r49, r50, r51, (d) ZeusTransformUtils.wrapperContextForParams(r52, d.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r53, c.class, "com.obric.aiagent.plugin"));
        }

        private b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r20, boolean r21, Drawable r22, View.OnClickListener r23, View.OnClickListener r24, String r25, Integer r26, Integer r27, Drawable r28, boolean r29, boolean r30, boolean r31, int r32, boolean r33, d r34, c r35) {
            TextWatcher r1 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r19, TextWatcher.class, "com.obric.aiagent.plugin");
            View.OnFocusChangeListener r3 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r20, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r23, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r34, d.class, "com.obric.aiagent.plugin");
            c r2 = (c) ZeusTransformUtils.wrapperContextForParams(r35, c.class, "com.obric.aiagent.plugin");
            this.f35277a = r10;
            this.f35278b = r11;
            this.f35279c = r12;
            this.f35280d = r13;
            this.f35281e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
            this.j = r1;
            this.k = r3;
            this.l = r21;
            this.m = r22;
            this.n = r4;
            this.o = r5;
            this.p = r25;
            this.q = r26;
            this.r = r27;
            this.s = r28;
            this.t = r29;
            this.u = r30;
            this.v = r31;
            this.w = r32;
            this.x = r33;
            this.y = r6;
            this.z = r2;
        }

        public final String a() {
            return this.f35277a;
        }

        public final void a(String r2) {
            o.e(r2, "<set-?>");
            this.f35277a = r2;
        }

        public final void a(boolean r1) {
            this.f35278b = r1;
        }

        public final boolean b() {
            return this.f35278b;
        }

        public final void b(boolean r1) {
            this.f35279c = r1;
        }

        public final boolean c() {
            return this.f35279c;
        }

        public final void b(String r1) {
            this.f35280d = r1;
        }

        public final String d() {
            return this.f35280d;
        }

        public final View e() {
            return this.f35281e;
        }

        public final View f() {
            return this.f;
        }

        public final void a(Integer r1) {
            this.g = r1;
        }

        public final Integer g() {
            return this.g;
        }

        public final void c(boolean r1) {
            this.h = r1;
        }

        public final boolean h() {
            return this.h;
        }

        public final String i() {
            return this.i;
        }

        public final void a(TextWatcher r3) {
            this.j = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.aiagent.plugin");
        }

        public final TextWatcher j() {
            return this.j;
        }

        public final View.OnFocusChangeListener k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public final Drawable m() {
            return this.m;
        }

        public final View.OnClickListener n() {
            return this.n;
        }

        public final View.OnClickListener o() {
            return this.o;
        }

        public final void c(String r1) {
            this.p = r1;
        }

        public final String p() {
            return this.p;
        }

        public final Integer q() {
            return this.q;
        }

        public final void b(Integer r1) {
            this.r = r1;
        }

        public final Integer r() {
            return this.r;
        }

        public final Drawable s() {
            return this.s;
        }

        public final boolean t() {
            return this.t;
        }

        public final void d(boolean r1) {
            this.u = r1;
        }

        public final boolean u() {
            return this.u;
        }

        public final void e(boolean r1) {
            this.v = r1;
        }

        public final boolean v() {
            return this.v;
        }

        public final int w() {
            return this.w;
        }

        public final boolean x() {
            return this.x;
        }

        public final void a(d r3) {
            this.y = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        }

        public final d y() {
            return this.y;
        }

        public final void a(c r3) {
            this.z = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        }

        public final c z() {
            return this.z;
        }
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    public interface d {
        void a(String r1);
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    public static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<String, x> f35287a;

        e(d.h.a.b<? super String, x> r3) {
            this.f35287a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.forms.OLineInputView.d
        public void a(String r2) {
            o.e(r2, "s");
            this.f35287a.invoke(r2);
        }
    }

    static {
        Companion = new a(null);
    }

    public OLineInputView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OLineInputView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OLineInputView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public static /* synthetic */ void lambda$4FGNJEnZKHDngkEiL2piCrhLJpI(OLineInputView r0, View r1) {
        m1080refreshConfig$lambda2(r0, r1);
    }

    public static /* synthetic */ boolean lambda$8RigH74U3xT9icIwnXijfbekH3c(OLineInputView r0, View r1, MotionEvent r2) {
        return m1082refreshConfig$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Ez1PWrKrk__6UZd2108x3zLwl9U(OLineInputView r0, View r1, boolean r2) {
        m1081refreshConfig$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$y-zJm8vU0gwNEWdcKLw7Tg-K6Ho, reason: not valid java name */
    public static /* synthetic */ void m1078lambda$yzJm8vU0gwNEWdcKLw7TgK6Ho(OLineInputView r0, View r1, boolean r2) {
        m1079refreshConfig$lambda1(r0, r1, r2);
    }

    public /* synthetic */ OLineInputView(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 1;
    L11:
        this(r8, r9, r4, r5);
    }

    public static final /* synthetic */ b access$getConfig$p(OLineInputView r0) {
        return r0.config;
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public OLineInputView(Context r36, AttributeSet r37, int r38, int r39) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r37, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        super(r2, r4, r38);
        this.arrangeDirection = r39;
        this.config = new b.a(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null).a();
        this.textGravity = 16;
        this.isShowTitle = true;
        this.DEFAULT_MAX_LINES = 20;
        this.errorTips = "";
        this.inputTips = "";
        TypedArray r1 = r2.getTheme().obtainStyledAttributes(r4, R.styleable.OLineInputView, r38, 0);
        setArrangeDirection(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formArrangeDirection, "styleable", "OLineInputView_oui_formArrangeDirection"), 0));
        String r5 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formTitle, "styleable", "OLineInputView_oui_formTitle"));
        b r8 = this.config;
        if (r5 != null) goto L5;
        r5 = DBDefinition.TITLE;
    L5:
        r8.a(r5);
        boolean r6 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowClear, "styleable", "OLineInputView_oui_formShowClear"), true);
        this.config.b(r6);
        String r7 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_hint, "styleable", "OLineInputView_android_hint"));
        this.config.b(r7);
        boolean r9 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowCounter, "styleable", "OLineInputView_oui_formShowCounter"), false);
        this.config.a(r9);
        int r10 = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formLengthLimit, "styleable", "OLineInputView_oui_formLengthLimit"), 0);
        if (r10 <= 0) goto L8;
        this.config.a(Integer.valueOf(r10));
    L8:
        int r11 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formInputHeight, "styleable", "OLineInputView_oui_formInputHeight"), 0);
        if (r11 <= 0) goto L11;
        this.config.b(Integer.valueOf(r11));
    L11:
        this.config.e(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formMultiLine, "styleable", "OLineInputView_oui_formMultiLine"), false));
        boolean r12 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowDivider, "styleable", "OLineInputView_oui_formShowDivider"), true);
        this.config.c(r12);
        String r13 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formInputTips, "styleable", "OLineInputView_oui_formInputTips"));
        this.config.c(r13);
        this.text = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_text, "styleable", "OLineInputView_android_text"));
        this.showTitleDefaultIcon = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowTitleDefaultIcon, "styleable", "OLineInputView_oui_formShowTitleDefaultIcon"), false);
        this.titleDefaultIconSize = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formTitleDefaultIconSize, "styleable", "OLineInputView_oui_formTitleDefaultIconSize"), 0);
        this.textGravity = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_gravity, "styleable", "OLineInputView_android_gravity"), 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r3 = this.arrangeDirection;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L15;
        int r14 = ZeusTransformUtils.mapRes(R.layout.o_form_line_input_horizontal, "layout", "o_form_line_input_horizontal");
    L20:
        ZeusTransformUtils.inflate(LayoutInflater.from(r2), r14, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r15, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.aiagent.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.et_input, DbHelper.COL_ID, "et_input"));
        o.c(r16, "findViewById(R.id.et_input)");
        OFormEditText r17 = (OFormEditText) ZeusTransformUtils.preCheckCast(r16, OFormEditText.class, "com.obric.aiagent.plugin");
        this.editText = r17;
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_error_tips, DbHelper.COL_ID, "tv_error_tips"));
        o.c(r18, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) ZeusTransformUtils.preCheckCast(r18, TextView.class, "com.obric.aiagent.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_counter, DbHelper.COL_ID, "tv_counter"));
        o.c(r19, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) ZeusTransformUtils.preCheckCast(r19, TextView.class, "com.obric.aiagent.plugin");
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_action, DbHelper.COL_ID, "tv_action"));
        o.c(r20, "findViewById(R.id.tv_action)");
        this.tvAction = (TextView) ZeusTransformUtils.preCheckCast(r20, TextView.class, "com.obric.aiagent.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_clear, DbHelper.COL_ID, "iv_clear"));
        o.c(r21, "findViewById(R.id.iv_clear)");
        this.ivClear = (ImageView) ZeusTransformUtils.preCheckCast(r21, ImageView.class, "com.obric.aiagent.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_action, DbHelper.COL_ID, "iv_action"));
        o.c(r22, "findViewById(R.id.iv_action)");
        this.ivAction = (ImageView) ZeusTransformUtils.preCheckCast(r22, ImageView.class, "com.obric.aiagent.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"));
        o.c(r23, "findViewById(R.id.divider)");
        this.divider = (ODivider) ZeusTransformUtils.preCheckCast(r23, ODivider.class, "com.obric.aiagent.plugin");
        View r24 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_title_icon, DbHelper.COL_ID, "iv_title_icon"));
        o.c(r24, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) ZeusTransformUtils.preCheckCast(r24, ImageView.class, "com.obric.aiagent.plugin");
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.prefix_container, DbHelper.COL_ID, "prefix_container"));
        o.c(r25, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r25, RelativeLayout.class, "com.obric.aiagent.plugin");
        View r26 = findViewById(ZeusTransformUtils.mapRes(R.id.suffix_container, DbHelper.COL_ID, "suffix_container"));
        o.c(r26, "findViewById(R.id.suffix_container)");
        this.suffixContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r26, RelativeLayout.class, "com.obric.aiagent.plugin");
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_input_tips, DbHelper.COL_ID, "tv_input_tips"));
        o.c(r27, "findViewById(R.id.tv_input_tips)");
        this.tvInputTips = (TextView) ZeusTransformUtils.preCheckCast(r27, TextView.class, "com.obric.aiagent.plugin");
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, DbHelper.COL_ID, "title_container"));
        o.c(r28, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r28, ViewGroup.class, "com.obric.aiagent.plugin");
        View r29 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, DbHelper.COL_ID, "input_container"));
        o.c(r29, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r29, ViewGroup.class, "com.obric.aiagent.plugin");
        this.leftContainer = (ConstraintLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.left_container, DbHelper.COL_ID, "left_container")), ConstraintLayout.class, "com.obric.aiagent.plugin");
        View r30 = findViewById(ZeusTransformUtils.mapRes(R.id.action_container, DbHelper.COL_ID, "action_container"));
        o.c(r30, "findViewById(R.id.action_container)");
        this.actionContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r30, ViewGroup.class, "com.obric.aiagent.plugin");
        this.activeBorderView = (ConstraintLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.active_border_view, DbHelper.COL_ID, "active_border_view")), ConstraintLayout.class, "com.obric.aiagent.plugin");
        View r31 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_clear_container, DbHelper.COL_ID, "iv_clear_container"));
        o.c(r31, "findViewById(R.id.iv_clear_container)");
        this.ivClearContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r31, LinearLayout.class, "com.obric.aiagent.plugin");
        View r32 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_action_container, DbHelper.COL_ID, "iv_action_container"));
        o.c(r32, "findViewById(R.id.iv_action_container)");
        this.ivActionContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r32, LinearLayout.class, "com.obric.aiagent.plugin");
        updateConfig(this.config);
        r17.setVerticalScrollBarEnabled(false);
        return;
    L15:
        if (r3 == 2) goto L17;
        r14 = ZeusTransformUtils.mapRes(R.layout.o_form_line_input_vertical, "layout", "o_form_line_input_vertical");
        goto L20
    L17:
        r14 = ZeusTransformUtils.mapRes(R.layout.o_form_line_input_vertical_single_box, "layout", "o_form_line_input_vertical_single_box");
        goto L20
    L19:
        r14 = ZeusTransformUtils.mapRes(R.layout.o_form_line_input_vertical, "layout", "o_form_line_input_vertical");
        goto L20
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final OFormEditText getEditText() {
        return this.editText;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final TextView getTvAction() {
        return this.tvAction;
    }

    public final ImageView getIvClear() {
        return this.ivClear;
    }

    public final LinearLayout getIvClearContainer() {
        return this.ivClearContainer;
    }

    public final ImageView getIvAction() {
        return this.ivAction;
    }

    public final LinearLayout getIvActionContainer() {
        return this.ivActionContainer;
    }

    public final ODivider getDivider() {
        return this.divider;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.prefixContainer;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.suffixContainer;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final TextView getTvInputTips() {
        return this.tvInputTips;
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    public final ViewGroup getActionContainer() {
        return this.actionContainer;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.activeBorderView;
    }

    public final void setActiveBorderView(ConstraintLayout r1) {
        this.activeBorderView = r1;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.leftContainer;
    }

    public final void setLeftContainer(ConstraintLayout r1) {
        this.leftContainer = r1;
    }

    public final void enableVerticalScrollBar(boolean r1) {
        this.editText.setVerticalScrollBarEnabled(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.editText.setEnabled(r2);
        super.setEnabled(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 44);
        k.a((View) ZeusTransformUtils.preCheckCast(this.actionContainer, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 44));
        k.a((View) ZeusTransformUtils.preCheckCast(this.actionContainer, View.class, "com.obric.aiagent.plugin"), r0, r0, new View[]{(View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.aiagent.plugin")});
    }

    public final void setInputContainerBackground(Drawable r2) {
        o.e(r2, "drawable");
        this.inputContainer.setBackground(r2);
    }

    public final void setInputContainerPadding(int r1, int r2, int r3, int r4) {
        this.inputContainer.setPadding(r1, r2, r3, r4);
    }

    private final void refreshConfig() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.a(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        this.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.config.a(), CharSequence.class, "com.obric.aiagent.plugin"));
    L13:
        if (this.isShowTitle == false) goto L15;
        showTitle();
    L17:
        if (this.config.s() == null) goto L20;
        this.ivTitleIcon.setImageDrawable(this.config.s());
        this.isShowTitleIcon = true;
    L20:
        if (this.isShowTitleIcon == false) goto L22;
        showTitleIcon();
    L23:
        int r3 = this.titleDefaultIconSize;
        if (r3 == 0) goto L28;
        if (r3 == 1) goto L27;
        setSmallTitleIcon();
    L30:
        if (this.config.u() == false) goto L33;
        TextWatcher r4 = new OLineInputView$refreshConfig$clearWatcher$1(this);
        getTextWatchers().add(new WeakReference(r4));
        this.editText.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r4, TextWatcher.class, "com.obric.aiagent.plugin"));
    L33:
        if (this.config.b() == false) goto L38;
        if (this.config.g() == null) goto L38;
        this.counterTextWatcher = (TextWatcher) ZeusTransformUtils.preCheckCast(new C11961(this), TextWatcher.class, "com.obric.aiagent.plugin");
        ArrayList<WeakReference<TextWatcher>> r5 = getTextWatchers();
        TextWatcher r6 = this.counterTextWatcher;
        o.a(r6);
        r5.add(new WeakReference(r6));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvCounter, View.class, "com.obric.aiagent.plugin"));
    L38:
        if (this.config.c() == true) goto L40;
        hideClear();
        this.editText.setOnFocusChangeListener(new $$Lambda$OLineInputView$yzJm8vU0gwNEWdcKLw7TgK6Ho(this));
    L44:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L47;
    L50:
        boolean r8 = true;
    L51:
        if (r8 == true) goto L54;
        this.editText.setHint((CharSequence) ZeusTransformUtils.preCheckCast(this.config.d(), CharSequence.class, "com.obric.aiagent.plugin"));
    L54:
        if (this.config.e() == null) goto L57;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(this.config.e(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        showPrefixView();
    L57:
        if (this.config.f() == null) goto L60;
        this.suffixContainer.removeAllViews();
        this.suffixContainer.addView(this.config.f(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        showSuffixView();
    L60:
        if (this.config.t() == false) goto L63;
        this.config.c(false);
    L63:
        if (this.config.h() == false) goto L65;
        showDivider();
    L66:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.i(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L69;
    L72:
        boolean r10 = true;
    L73:
        if (r10 == true) goto L85;
        this.tvAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.config.i(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.config.q() == null) goto L77;
        TextView r11 = this.tvAction;
        Integer r12 = this.config.q();
        o.a(r12);
        r11.setTextColor(r12.intValue());
    L79:
        if (this.config.l() == true) goto L81;
    L83:
        showActionText();
        goto L85
    L81:
        if (this.config.n() == null) goto L83;
        this.tvAction.setOnClickListener(this.config.n());
        goto L83
    L77:
        this.tvAction.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
    L85:
        if (this.config.j() == null) goto L88;
        ArrayList<WeakReference<TextWatcher>> r13 = getTextWatchers();
        TextWatcher r14 = this.config.j();
        o.a(r14);
        r13.add(new WeakReference(r14));
        this.editText.addTextChangedListener(this.config.j());
    L88:
        if (this.config.m() == null) goto L94;
        this.ivAction.setImageDrawable(this.config.m());
        if (this.config.o() == null) goto L92;
        this.ivAction.setOnClickListener(this.config.o());
    L92:
        showActionImage();
    L94:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.config.p(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L97;
        String r15 = this.config.p();
        o.a(r15);
        showInputTips(r15);
    L97:
        if (this.config.r() == null) goto L99;
        View r16 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        Objects.requireNonNull(r17, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r18 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r17, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        Integer r20 = this.config.r();
        o.a(r20);
        r19.height = r20.intValue();
        r16.setLayoutParams(r18);
    L111:
        if (this.config.v() == false) goto L113;
        OFormEditText r21 = this.editText;
        r21.setSingleLine(false);
        r21.setLines(this.DEFAULT_MAX_LINES);
    L114:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(this.text, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L117;
    L118:
        r1 = true;
    L119:
        if (r1 == true) goto L122;
        setText(this.text);
    L122:
        if (this.showTitleDefaultIcon == true) goto L124;
    L126:
        this.editText.setGravity(this.textGravity);
        if (this.config.k() == null) goto L130;
        View.OnFocusChangeListener r23 = this.config.k();
        o.a(r23);
        setEditTextOnFocusChangeListener(r23);
    L130:
        if (this.isShowTitle == false) goto L132;
        showTitle();
    L134:
        if (this.isShowErrorTips == false) goto L136;
        String r24 = this.errorTips;
        o.a(r24);
        showErrorTips(r24);
    L138:
        if (this.isShowInputTips == false) goto L140;
        String r25 = this.inputTips;
        o.a(r25);
        showInputTips(r25);
    L142:
        if (this.isShowPrefix == false) goto L144;
        showPrefixView();
    L146:
        if (this.isShowSuffix == false) goto L148;
        showSuffixView();
    L150:
        if (this.isShowActionText == false) goto L152;
        showActionText();
    L154:
        if (this.isShowActionImage == false) goto L156;
        showActionImage();
    L157:
        setMode$default(this, this.config.w(), null, 2, null);
        return;
    L156:
        hideActionImage();
        goto L157
    L152:
        hideActionText();
        goto L154
    L148:
        hideSuffixView();
        goto L150
    L144:
        hidePrefixView();
        goto L146
    L140:
        hideInputTips();
        goto L142
    L136:
        hideErrorTips();
        goto L138
    L132:
        hideTitle();
        goto L134
    L124:
        if (this.config.s() != null) goto L126;
        showTitleIcon();
        goto L126
    L117:
        if (r22.length() != 0) goto L119;
    L113:
        this.editText.setSingleLine(true);
        goto L114
    L99:
        View r26 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        Objects.requireNonNull(r27, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r28 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r27, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r28, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r30 = getArrangeDirection();
        if (r30 == 1) goto L106;
        if (r30 == 2) goto L104;
        int r31 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 40);
    L109:
        r29.height = r31;
        r26.setLayoutParams(r28);
        goto L111
    L104:
        r31 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 40);
        goto L109
    L106:
        if (this.config.t() == false) goto L108;
        r31 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 36);
        goto L109
    L108:
        r31 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 52);
        goto L109
    L69:
        if (r9.length() == 0) goto L72;
        r10 = false;
        goto L73
    L65:
        hideDivider();
        goto L66
    L47:
        if (r7.length() == 0) goto L50;
        r8 = false;
        goto L51
    L40:
        this.ivClear.setOnClickListener(new $$Lambda$OLineInputView$4FGNJEnZKHDngkEiL2piCrhLJpI(this));
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.editText.getText(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L43;
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.aiagent.plugin"));
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.aiagent.plugin"));
    L43:
        this.editText.setOnFocusChangeListener(new $$Lambda$OLineInputView$Ez1PWrKrk__6UZd2108x3zLwl9U(this));
        this.editText.setOnTouchListener(new $$Lambda$OLineInputView$8RigH74U3xT9icIwnXijfbekH3c(this));
        goto L44
    L27:
        setMiddleTitleIcon();
        goto L30
    L28:
        setSmallTitleIcon();
        goto L30
    L22:
        hideTitleIcon();
        goto L23
    L15:
        hideTitle();
        goto L17
    L11:
        this.isShowTitle = false;
        goto L13
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-1, reason: not valid java name */
    private static final void m1079refreshConfig$lambda1(OLineInputView r0, View r1, boolean r2) {
        o.e(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-2, reason: not valid java name */
    private static final void m1080refreshConfig$lambda2(OLineInputView r0, View r1) {
        o.e(r0, "this$0");
        c r2 = r0.config.z();
        if (r2 == null) goto L6;
        r2.a();
    L6:
        r0.setText("");
        c r3 = r0.config.z();
        if (r3 == null) goto L11;
        r3.b();
        return;
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-3, reason: not valid java name */
    private static final void m1081refreshConfig$lambda3(OLineInputView r1, View r2, boolean r3) {
        o.e(r1, "this$0");
        if (r3 == false) goto L12;
        if (r1.config.u() == true) goto L7;
    L9:
        r1.showClear();
    L10:
        r1.showSoftInput();
        return;
    L7:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1.getText(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        r1.hideClear();
        goto L10
    L12:
        if (r1.config.x() == false) goto L14;
    L15:
        r1.hideClear();
    L16:
        r1.hideSoftInput();
        return;
    L14:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1.getText(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L16;
        goto L15
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-4, reason: not valid java name */
    private static final boolean m1082refreshConfig$lambda4(OLineInputView r1, View r2, MotionEvent r3) {
        o.e(r1, "this$0");
        o.e(r3, "event");
        int r4 = r3.getActionMasked();
        if (r4 == 0) goto L26;
        if (r4 == 1) goto L10;
        if (r4 == 3) goto L10;
        return false;
    L10:
        if (r1.isErrorState == false) goto L16;
        ConstraintLayout r5 = r1.activeBorderView;
        if (r5 == null) goto L49;
        r5.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_error_default_border, "drawable", "o_line_box_input_error_default_border"));
        return false;
    L49:
        return false;
    L16:
        if (r1.editText.hasFocus() == false) goto L21;
        ConstraintLayout r6 = r1.activeBorderView;
        if (r6 == null) goto L50;
        r6.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_focused_default_border, "drawable", "o_line_box_input_focused_default_border"));
        return false;
    L50:
        return false;
    L21:
        ConstraintLayout r7 = r1.activeBorderView;
        if (r7 == null) goto L51;
        r7.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_normal_default_border, "drawable", "o_line_box_input_normal_default_border"));
        return false;
    L51:
        return false;
    L26:
        if (r1.isErrorState == false) goto L32;
        ConstraintLayout r8 = r1.activeBorderView;
        if (r8 == null) goto L52;
        r8.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_error_pressed_border, "drawable", "o_line_box_input_error_pressed_border"));
        return false;
    L52:
        return false;
    L32:
        if (r1.editText.hasFocus() == false) goto L37;
        ConstraintLayout r9 = r1.activeBorderView;
        if (r9 == null) goto L53;
        r9.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_focused_pressed_border, "drawable", "o_line_box_input_focused_pressed_border"));
        return false;
    L53:
        return false;
    L37:
        ConstraintLayout r10 = r1.activeBorderView;
        if (r10 == null) goto L54;
        r10.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_normal_pressed_border, "drawable", "o_line_box_input_normal_pressed_border"));
        return false;
    L54:
        return false;
    }

    private final void showSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin")).showSoftInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
    }

    private final void hideSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public static /* synthetic */ void setMode$default(OLineInputView r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.setMode(r2, r6);
    }

    public final void setMode(int r3, View.OnClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r3 != 2) goto L5;
        this.editText.setFocusable(true);
        this.editText.setFocusableInTouchMode(true);
        this.editText.setOnClickListener(null);
        setOnClickListener(null);
        return;
    L5:
        if (r3 != 3) goto L15;
        this.editText.setFocusable(false);
        this.editText.setFocusableInTouchMode(false);
        if (r5 != null) goto L10;
        this.editText.setOnClickListener(this.config.o());
        setOnClickListener(this.config.o());
        return;
    L10:
        this.editText.setOnClickListener(r5);
        setOnClickListener(r5);
        return;
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void setText(String r4) {
        if (r4 == null) goto L8;
        this.editText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        TextWatcher r3 = this.counterTextWatcher;
        if (r3 == null) goto L9;
        r3.onTextChanged((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, r4.length());
        return;
    L9:
        return;
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.aiagent.plugin");
        this.editText.removeTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r1.get(), TextWatcher.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public final b getConfig() {
        return this.config;
    }

    public final void updateConfig(b r2) {
        o.e(r2, "newConfig");
        this.config = r2;
        clear();
        refreshConfig();
    }

    public static /* synthetic */ void setAutoHideClearWhenTextEmpty$default(OLineInputView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.setAutoHideClearWhenTextEmpty(r1);
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r2) {
        b r0 = getConfig();
        r0.d(r2);
        updateConfig(r0);
    }

    public final void showErrorTips(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.aiagent.plugin"));
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"));
        this.divider.setBackgroundColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, "color", "Primary")));
        if (k.d((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.aiagent.plugin")) == false) goto L7;
        hideInputTips();
    L7:
        this.isShowErrorTips = true;
        this.errorTips = r7;
    }

    public final void setInputViewNormal() {
        this.isErrorState = false;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_normal_border_selector, "drawable", "o_line_box_input_normal_border_selector");
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void setInputViewActived() {
        this.isErrorState = false;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_focused_border_selector, "drawable", "o_line_box_input_focused_border_selector");
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void setInputViewError() {
        this.isErrorState = true;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_error_border_selector, "drawable", "o_line_box_input_error_border_selector");
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void hideErrorTips() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.aiagent.plugin"));
        this.divider.setStyle(0);
        CharSequence r0 = this.tvInputTips.getText();
        o.c(r0, "tvInputTips.text");
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        showInputTips(this.tvInputTips.getText().toString());
    L8:
        this.isShowErrorTips = false;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void showInputTips(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.tvInputTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.aiagent.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        hideErrorTips();
    L10:
        this.isShowInputTips = true;
        this.inputTips = r4;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void hideInputTips() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.aiagent.plugin"));
        this.isShowInputTips = false;
    }

    public final void showTitleIcon() {
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L8:
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.aiagent.plugin"));
        this.isShowTitleIcon = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideTitleIcon() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.aiagent.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L9:
        k.b((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L10:
        this.isShowTitleIcon = false;
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == false) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSmallTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        o.c(r0, "ivTitleIcon.getLayoutParams()");
        r0.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10);
        r0.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void setMiddleTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        o.c(r0, "ivTitleIcon.getLayoutParams()");
        r0.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        r0.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void showTitle() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.aiagent.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L8:
        this.isShowTitle = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideTitle() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.aiagent.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.b((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L8:
        this.isShowTitle = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showClear() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.aiagent.plugin"));
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.aiagent.plugin"));
        this.config.b(false);
    }

    public final void hideClear() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.aiagent.plugin"));
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.aiagent.plugin"));
        this.config.b(false);
    }

    public final void showActionImage() {
        if (((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.aiagent.plugin"));
    L8:
        this.isShowActionImage = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideActionImage() {
        if (((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.aiagent.plugin"));
    L8:
        this.isShowActionImage = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showPrefixView() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.aiagent.plugin"));
        this.isShowPrefix = true;
    }

    public final void hidePrefixView() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.aiagent.plugin"));
        this.isShowPrefix = false;
    }

    public final void showSuffixView() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.suffixContainer, View.class, "com.obric.aiagent.plugin"));
        this.isShowSuffix = true;
    }

    public final void hideSuffixView() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.suffixContainer, View.class, "com.obric.aiagent.plugin"));
        this.isShowSuffix = false;
    }

    public final void showDivider() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.divider, View.class, "com.obric.aiagent.plugin"));
        this.config.c(true);
    }

    public final void hideDivider() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.divider, View.class, "com.obric.aiagent.plugin"));
        this.config.c(false);
    }

    public final void showActionText() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.aiagent.plugin"));
        this.isShowActionText = true;
    }

    public final void hideActionText() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.aiagent.plugin"));
        this.isShowActionText = false;
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.editText.setOnFocusChangeListener(r4);
    }

    public final void editTextOnFocusChangeListener(m<? super View, ? super Boolean, x> r3) {
        final m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "handler");
        setEditTextOnFocusChangeListener((View.OnFocusChangeListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), View.OnFocusChangeListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return (EditText) ZeusTransformUtils.preCheckCast(this.editText, EditText.class, "com.obric.aiagent.plugin");
    }

    public final void setTextExceedLengthListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "textExceedLengthListener");
        this.config.a(r4);
    }

    public final void onTextExceedLengthListener(d.h.a.b<? super String, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "handler");
        this.config.a((d) ZeusTransformUtils.preCheckCast(new e(r4), d.class, "com.obric.aiagent.plugin"));
    }

    public final void setTextClearedListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "textClearedListener");
        this.config.a(r4);
    }

    public final void setTextWatcher(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.aiagent.plugin");
        this.config.a(r4);
        refreshConfig();
    }
}
