package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: OBoxInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBoxInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final a Companion = null;
    private static final int DEFAULT_INPUT_BOX_HEIGHT_DP = 0;
    private static final int DEFAULT_LINES = 6;
    private final int DEFAULT_MAX_LINES;
    private int arrangeDirection;
    private b config;
    private TextWatcher counterTextWatcher;
    private final AppCompatEditText editText;
    private final ViewGroup inputContainer;
    private final ImageView ivTitleIcon;
    private final ViewGroup prefixContainer;
    private boolean showTitleDefaultIcon;
    private String text;
    private int textGravity;
    private ViewGroup titleContainer;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OBoxInputView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OBoxInputView.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f35255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f35256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f35257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f35258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f35259e;
        private View f;
        private TextWatcher g;
        private int h;
        private int i;
        private boolean j;
        private Drawable k;

        /* JADX INFO: compiled from: OBoxInputView.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f35260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f35261b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f35262c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Integer f35263d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f35264e;
            private View f;
            private TextWatcher g;
            private int h;
            private int i;
            private boolean j;
            private Drawable k;

            public a() {
                this(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (this.f35260a == r6.f35260a) goto L12;
                return false;
            L12:
                if (o.a(this.f35261b, r6.f35261b) == true) goto L15;
                return false;
            L15:
                if (this.f35262c == r6.f35262c) goto L18;
                return false;
            L18:
                if (o.a(this.f35263d, r6.f35263d) == true) goto L21;
                return false;
            L21:
                if (o.a(this.f35264e, r6.f35264e) == true) goto L24;
                return false;
            L24:
                if (o.a(this.f, r6.f) == true) goto L27;
                return false;
            L27:
                if (o.a(this.g, r6.g) == true) goto L30;
                return false;
            L30:
                if (this.h == r6.h) goto L33;
                return false;
            L33:
                if (this.i == r6.i) goto L36;
                return false;
            L36:
                if (this.j == r6.j) goto L39;
                return false;
            L39:
                if (o.a(this.k, r6.k) == true) goto L41;
                return false;
            L41:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                boolean r0 = this.f35260a;
                ?? r1 = 1;
                ?? r2 = r0;
                if (r0 == false) goto L5;
                r2 = 1;
            L5:
                int r3 = r2 * 31;
                String r4 = this.f35261b;
                int r5 = 0;
                if (r4 != null) goto L8;
                int r6 = 0;
            L9:
                int r7 = (r3 + r6) * 31;
                boolean r8 = this.f35262c;
                ?? r9 = r8;
                if (r8 == false) goto L12;
                r9 = 1;
            L12:
                int r10 = (r7 + r9) * 31;
                Integer r11 = this.f35263d;
                if (r11 != null) goto L15;
                int r12 = 0;
            L16:
                int r13 = (r10 + r12) * 31;
                String r14 = this.f35264e;
                if (r14 != null) goto L19;
                int r15 = 0;
            L20:
                int r16 = (r13 + r15) * 31;
                View r17 = this.f;
                if (r17 != null) goto L23;
                int r18 = 0;
            L24:
                int r19 = (r16 + r18) * 31;
                TextWatcher r20 = this.g;
                if (r20 != null) goto L27;
                int r21 = 0;
            L28:
                int r22 = (((((r19 + r21) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
                boolean r23 = this.j;
                if (r23 == true) goto L32;
                r1 = r23;
            L32:
                int r24 = (r22 + r1) * 31;
                Drawable r25 = this.k;
                if (r25 == null) goto L37;
                r5 = r25.hashCode();
            L37:
                return r24 + r5;
            L27:
                r21 = r20.hashCode();
                goto L28
            L23:
                r18 = r17.hashCode();
                goto L24
            L19:
                r15 = r14.hashCode();
                goto L20
            L15:
                r12 = r11.hashCode();
                goto L16
            L8:
                r6 = r4.hashCode();
                goto L9
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append("Builder(showTitle=").append(this.f35260a).append(", title=").append(this.f35261b).append(", showCounter=").append(this.f35262c).append(", lengthLimit=").append(this.f35263d).append(", hintText=").append(this.f35264e).append(", prefixView=").append(this.f).append(", textWatcher=").append(this.g).append(", inputBoxHeight=").append(this.h).append(", inputBoxMaxHeight=").append(this.i).append(", autoAdjustHeight=").append(this.j).append(", ivTitleIcon=").append(this.k).append(')');
                return r0.toString();
            }

            public a(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13) {
                TextWatcher r14 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r9, TextWatcher.class, "com.obric.aiagent.plugin");
                this.f35260a = r3;
                this.f35261b = r4;
                this.f35262c = r5;
                this.f35263d = r6;
                this.f35264e = r7;
                this.f = r8;
                this.g = r14;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
            }

            public /* synthetic */ a(boolean r14, String r15, boolean r16, Integer r17, String r18, View r19, TextWatcher r20, int r21, int r22, boolean r23, Drawable r24, int r25, h r26) {
                TextWatcher r1 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r20, TextWatcher.class, "com.obric.aiagent.plugin");
                boolean r3 = false;
                if ((r25 & 1) == 0) goto L5;
                boolean r2 = false;
            L6:
                Drawable r5 = null;
                if ((r25 & 2) == 0) goto L9;
                String r4 = null;
            L11:
                if ((r25 & 4) == 0) goto L13;
                boolean r6 = false;
            L15:
                if ((r25 & 8) == 0) goto L17;
                Integer r7 = null;
            L19:
                if ((r25 & 16) == 0) goto L21;
                String r8 = null;
            L23:
                if ((r25 & 32) == 0) goto L25;
                View r9 = null;
            L27:
                if ((r25 & 64) == 0) goto L30;
                r1 = null;
            L30:
                if ((r25 & 128) == 0) goto L32;
                int r10 = OBoxInputView.access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp();
            L34:
                if ((r25 & 256) == 0) goto L36;
                int r11 = Integer.MAX_VALUE;
            L38:
                if ((r25 & 512) != 0) goto L42;
                r3 = r23;
            L42:
                if ((r25 & 1024) != 0) goto L45;
                r5 = r24;
            L45:
                this(r2, r4, r6, r7, r8, r9, r1, r10, r11, r3, r5);
                return;
            L36:
                r11 = r22;
                goto L38
            L32:
                r10 = r21;
                goto L34
            L25:
                r9 = r19;
                goto L27
            L21:
                r8 = r18;
                goto L23
            L17:
                r7 = r17;
                goto L19
            L13:
                r6 = r16;
                goto L15
            L9:
                r4 = r15;
                goto L11
            L5:
                r2 = r14;
                goto L6
            }

            public final b a() {
                boolean r1 = this.f35260a;
                String r2 = this.f35261b;
                boolean r3 = this.f35262c;
                String r5 = this.f35264e;
                Integer r4 = this.f35263d;
                TextWatcher r7 = this.g;
                return new b(r1, r2, r3, r4, r5, this.f, r7, this.h, this.i, this.j, this.k, null);
            }
        }

        public /* synthetic */ b(boolean r14, String r15, boolean r16, Integer r17, String r18, View r19, TextWatcher r20, int r21, int r22, boolean r23, Drawable r24, h r25) {
            this(r14, r15, r16, r17, r18, r19, (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r20, TextWatcher.class, "com.obric.aiagent.plugin"), r21, r22, r23, r24);
        }

        private b(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13) {
            TextWatcher r14 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r9, TextWatcher.class, "com.obric.aiagent.plugin");
            this.f35255a = r3;
            this.f35256b = r4;
            this.f35257c = r5;
            this.f35258d = r6;
            this.f35259e = r7;
            this.f = r8;
            this.g = r14;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
        }

        public final void a(boolean r1) {
            this.f35255a = r1;
        }

        public final boolean a() {
            return this.f35255a;
        }

        public final void a(String r1) {
            this.f35256b = r1;
        }

        public final String b() {
            return this.f35256b;
        }

        public final void b(boolean r1) {
            this.f35257c = r1;
        }

        public final boolean c() {
            return this.f35257c;
        }

        public final void a(Integer r1) {
            this.f35258d = r1;
        }

        public final Integer d() {
            return this.f35258d;
        }

        public final void b(String r1) {
            this.f35259e = r1;
        }

        public final String e() {
            return this.f35259e;
        }

        public final View f() {
            return this.f;
        }

        public final TextWatcher g() {
            return this.g;
        }

        public final void a(int r1) {
            this.h = r1;
        }

        public final int h() {
            return this.h;
        }

        public final void b(int r1) {
            this.i = r1;
        }

        public final int i() {
            return this.i;
        }

        public final void c(boolean r1) {
            this.j = r1;
        }

        public final boolean j() {
            return this.j;
        }

        public final Drawable k() {
            return this.k;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OBoxInputView$updateConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: OBoxInputView.kt */
    public static final class AnonymousClass1 implements TextWatcher {
        final /* synthetic */ OBoxInputView this$0;

        public static /* synthetic */ void lambda$ECDYGpM9aC33mj5cjXdkKAP8RzQ(OBoxInputView r0) {
            m1065afterTextChanged$lambda0(r0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            o.e((CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin"), "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            o.e((CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin"), "s");
        }

        AnonymousClass1(OBoxInputView r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: afterTextChanged$lambda-0, reason: not valid java name */
        private static final void m1065afterTextChanged$lambda0(OBoxInputView r1) {
            o.e(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            o.e((Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin"), "s");
            AppCompatEditText r4 = this.this$0.getEditText();
            final OBoxInputView r2 = this.this$0;
            r4.post(new $$Lambda$OBoxInputView$updateConfig$1$ECDYGpM9aC33mj5cjXdkKAP8RzQ(r2));
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OBoxInputView$updateConfig$2, reason: invalid class name */
    /* JADX INFO: compiled from: OBoxInputView.kt */
    public static final class AnonymousClass2 implements TextWatcher {
        final /* synthetic */ b $config;
        final /* synthetic */ OBoxInputView this$0;

        public static /* synthetic */ void lambda$fv4rXAuycy9L5ISJFl5w_lV7Tyk(OBoxInputView r0) {
            m1066afterTextChanged$lambda0(r0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        }

        AnonymousClass2(b r1, OBoxInputView r2) {
            this.$config = r1;
            this.this$0 = r2;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
            if (this.$config.d() == null) goto L24;
            Resources r11 = ZeusTransformUtils.getResources(this.this$0, "com.obric.aiagent.plugin");
            int r12 = ZeusTransformUtils.mapRes(R.string.oui_form_counter, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_form_counter");
            Object[] r0 = new Object[2];
            if (r10 != null) goto L7;
            String r1 = null;
        L8:
            r0[0] = r1;
            r0[1] = String.valueOf(this.$config.d());
            String r13 = r11.getString(r12, r0);
            o.c(r13, "resources.getString(\n   …                        )");
            SpannableString r14 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"));
            if (r10 != null) goto L11;
            int r15 = 0;
        L12:
            Integer r2 = this.$config.d();
            o.a(r2);
            if (r15 <= r2.intValue()) goto L22;
            ForegroundColorSpan r16 = new ForegroundColorSpan(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, "color", "Primary")));
            if (r10 != null) goto L17;
        L16:
            int r17 = 0;
        L21:
            r14.setSpan(r16, 0, r17, 18);
            goto L22
        L17:
            String r18 = Integer.valueOf(r10.length()).toString();
            if (r18 == null) goto L16;
            r17 = r18.length();
        L22:
            this.this$0.getTvCounter().setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), TextView.BufferType.SPANNABLE);
            return;
        L11:
            r15 = Integer.valueOf(r10.length()).intValue();
            goto L12
        L7:
            r1 = Integer.valueOf(r10.length()).toString();
            goto L8
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            if (this.$config.j() == false) goto L6;
            AppCompatEditText r5 = this.this$0.getEditText();
            final OBoxInputView r2 = this.this$0;
            r5.post(new $$Lambda$OBoxInputView$updateConfig$2$fv4rXAuycy9L5ISJFl5w_lV7Tyk(r2));
            return;
        }

        /* JADX INFO: renamed from: afterTextChanged$lambda-0, reason: not valid java name */
        private static final void m1066afterTextChanged$lambda0(OBoxInputView r1) {
            o.e(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }
    }

    public OBoxInputView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OBoxInputView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OBoxInputView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    /* JADX INFO: renamed from: lambda$e6-T8ItmLzs2AXx2sVyao7yHD5o, reason: not valid java name */
    public static /* synthetic */ void m1064lambda$e6T8ItmLzs2AXx2sVyao7yHD5o(OBoxInputView r0, View r1, boolean r2) {
        m1063_init_$lambda1(r0, r1, r2);
    }

    public /* synthetic */ OBoxInputView(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
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

    public static final /* synthetic */ void access$adjustHeight(OBoxInputView r0) {
        r0.adjustHeight();
    }

    public static final /* synthetic */ int access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp() {
        return DEFAULT_INPUT_BOX_HEIGHT_DP;
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public OBoxInputView(Context r21, AttributeSet r22, int r23, int r24) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        super(r2, r4, r23);
        this.arrangeDirection = r24;
        this.config = new b.a(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null).a();
        this.textGravity = 48;
        this.DEFAULT_MAX_LINES = 20;
        TypedArray r5 = r2.getTheme().obtainStyledAttributes(r4, R.styleable.OBoxInputView, 0, 0);
        setArrangeDirection(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formArrangeDirection, "styleable", "OBoxInputView_oui_formArrangeDirection"), 1));     // Catch: Throwable -> L23
        this.config.b(r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_hint, "styleable", "OBoxInputView_android_hint")));     // Catch: Throwable -> L23
        this.config.b(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formShowCounter, "styleable", "OBoxInputView_oui_formShowCounter"), false));     // Catch: Throwable -> L23
        int r7 = r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formLengthLimit, "styleable", "OBoxInputView_oui_formLengthLimit"), 0);     // Catch: Throwable -> L23
        if (r7 <= 0) goto L6;
        this.config.a(Integer.valueOf(r7));     // Catch: Throwable -> L23
    L6:
        String r8 = r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formTitle, "styleable", "OBoxInputView_oui_formTitle"));     // Catch: Throwable -> L23
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r10 != null) goto L9;
    L12:
        boolean r11 = true;
    L13:
        if (r11 == true) goto L15;
        this.config.a(r8);     // Catch: Throwable -> L23
        this.config.a(true);     // Catch: Throwable -> L23
    L16:
        this.config.a(r5.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formInputHeight, "styleable", "OBoxInputView_oui_formInputHeight"), g.a(r2, DEFAULT_INPUT_BOX_HEIGHT_DP)));     // Catch: Throwable -> L23
        this.config.b(r5.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formInputMaxHeight, "styleable", "OBoxInputView_oui_formInputMaxHeight"), Integer.MAX_VALUE));     // Catch: Throwable -> L23
        this.text = r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_text, "styleable", "OBoxInputView_android_text"));     // Catch: Throwable -> L23
        this.showTitleDefaultIcon = r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formShowTitleDefaultIcon, "styleable", "OBoxInputView_oui_formShowTitleDefaultIcon"), false);     // Catch: Throwable -> L23
        this.config.c(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formAutoAdjustHeight, "styleable", "OBoxInputView_oui_formAutoAdjustHeight"), false));     // Catch: Throwable -> L23
        this.textGravity = r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_gravity, "styleable", "OBoxInputView_android_gravity"), 48);     // Catch: Throwable -> L23
        r5.recycle();
        if (this.arrangeDirection != 1) goto L20;
        int r1 = ZeusTransformUtils.mapRes(R.layout.o_form_box_horizontal, "layout", "o_form_box_horizontal");
    L21:
        ZeusTransformUtils.inflate(LayoutInflater.from(r2), r1, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r3, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_title_icon, DbHelper.COL_ID, "iv_title_icon"));
        o.c(r6, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.prefix_container, DbHelper.COL_ID, "prefix_container"));
        o.c(r9, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.edittext, DbHelper.COL_ID, "edittext"));
        o.c(r12, "findViewById(R.id.edittext)");
        AppCompatEditText r13 = (AppCompatEditText) ZeusTransformUtils.preCheckCast(r12, AppCompatEditText.class, "com.obric.aiagent.plugin");
        this.editText = r13;
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_counter, DbHelper.COL_ID, "tv_counter"));
        o.c(r14, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_error_tips, DbHelper.COL_ID, "tv_error_tips"));
        o.c(r15, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.aiagent.plugin");
        r13.setOnFocusChangeListener(new $$Lambda$OBoxInputView$e6T8ItmLzs2AXx2sVyao7yHD5o(this));
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, DbHelper.COL_ID, "input_container"));
        o.c(r16, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r16, ViewGroup.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, DbHelper.COL_ID, "title_container"));
        o.c(r17, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r17, ViewGroup.class, "com.obric.aiagent.plugin");
        updateConfig(this.config);
        r13.setLines(20);
        r13.setSingleLine(false);
        return;
    L20:
        r1 = ZeusTransformUtils.mapRes(R.layout.o_form_box_vertical, "layout", "o_form_box_vertical");
        goto L21
    L15:
        this.config.a("标题");     // Catch: Throwable -> L23
        goto L16
    L9:
        if (r10.length() == 0) goto L12;
        r11 = false;
    L23:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final AppCompatEditText getEditText() {
        return this.editText;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    public final ViewGroup getPrefixContainer() {
        return this.prefixContainer;
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final void setTitleContainer(ViewGroup r2) {
        o.e(r2, "<set-?>");
        this.titleContainer = r2;
    }

    static {
        Companion = new a(null);
        DEFAULT_INPUT_BOX_HEIGHT_DP = 144;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1063_init_$lambda1(OBoxInputView r0, View r1, boolean r2) {
        o.e(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    private final void setPrefixView(View r4) {
        if (r4 == null) goto L5;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void showPrefixView() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.aiagent.plugin"));
    }

    public final void hidePrefixView() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.aiagent.plugin"));
    }

    public final void updateConfig(b r8) {
        o.e(r8, "config");
        this.config = r8;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        this.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        if (r8.a() == false) goto L14;
        showTitle();
    L16:
        if (r8.f() == null) goto L19;
        View r3 = r8.f();
        o.a(r3);
        setPrefixView(r3);
    L19:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.e(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L22;
        this.editText.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r8.e(), CharSequence.class, "com.obric.aiagent.plugin"));
    L22:
        if (r8.j() == false) goto L25;
        this.editText.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TextWatcher.class, "com.obric.aiagent.plugin"));
    L25:
        if (r8.c() == true) goto L27;
    L33:
        r8.h();
        if (r8.h() <= 0) goto L37;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).height = r8.h();
        r4.setLayoutParams(r6);
    L37:
        if (r8.g() == null) goto L40;
        TextWatcher r7 = r8.g();
        o.a(r7);
        setTextWatcher(r7);
    L40:
        if (r8.k() == null) goto L43;
        this.ivTitleIcon.setImageDrawable(r8.k());
    L43:
        if (this.showTitleDefaultIcon == true) goto L45;
    L47:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.text, CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L50;
    L53:
        if (r1 == true) goto L55;
        setText(this.text);
    L55:
        this.editText.setGravity(this.textGravity);
        return;
    L50:
        if (r9.length() == 0) goto L53;
        r1 = false;
        goto L53
    L45:
        if (r8.k() != null) goto L47;
        showTitleIcon();
        goto L47
    L27:
        if (r8.d() == null) goto L33;
        this.counterTextWatcher = (TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r8, this), TextWatcher.class, "com.obric.aiagent.plugin");
        ArrayList<WeakReference<TextWatcher>> r10 = getTextWatchers();
        TextWatcher r11 = this.counterTextWatcher;
        o.a(r11);
        r10.add(new WeakReference(r11));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        TextWatcher r12 = this.counterTextWatcher;
        if (r12 == null) goto L32;
        r12.onTextChanged((CharSequence) ZeusTransformUtils.preCheckCast(this.editText.getText(), CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0);
    L32:
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvCounter, View.class, "com.obric.aiagent.plugin"));
        goto L33
    L14:
        hideTitle();
        goto L16
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void adjustHeight() {
        int r0 = this.editText.getLineCount();
        int r1 = this.editText.getLineHeight();
        int r2 = this.editText.getHeight();
        int r3 = this.inputContainer.getHeight();
        int r4 = ((r0 * r1) + r3) - r2;
        if (r4 >= this.config.h()) goto L5;
    L8:
        ViewGroup.LayoutParams r5 = this.inputContainer.getLayoutParams();
        o.c(r5, "inputContainer.getLayoutParams()");
        r5.height = r3;
        this.inputContainer.setLayoutParams(r5);
        return;
    L5:
        if (r4 >= this.config.i()) goto L8;
        r3 = r4;
        goto L8
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

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void setText(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        this.editText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        TextWatcher r4 = this.counterTextWatcher;
        if (r4 == null) goto L16;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r4.onTextChanged(r2, 0, 0, r5.length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void showTitleIcon() {
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L8:
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.aiagent.plugin"));
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
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == true) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showTitle() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.aiagent.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        k.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.aiagent.plugin"));
    L8:
        this.config.a(true);
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
        this.config.a(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final b getConfig() {
        return this.config;
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.aiagent.plugin");
        this.editText.removeTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r1.get(), TextWatcher.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public final void setTextWatcher(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.aiagent.plugin");
        o.e(r4, "textWatcher");
        clear();
        getTextWatchers().add(new WeakReference(r4));
        this.editText.addTextChangedListener(r4);
    }

    public final void showErrorTips(String r4) {
        o.e(r4, "tips");
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.aiagent.plugin"));
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void hideErrorTips() {
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return (EditText) ZeusTransformUtils.preCheckCast(this.editText, EditText.class, "com.obric.aiagent.plugin");
    }
}
