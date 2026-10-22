package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ab;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.common.util.g;
import com.obric.oui.text.OTextView;
import com.obric.oui.widget.VerticalFadeFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OInputLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OInputLayout extends FrameLayout {
    public static final a Companion = null;
    public static final int DEFAULT_START_AREA_CODE = 0;
    public static final String TAG = "OInputLayout";
    public static final int TYPE_COMPACT_MULTI = 2;
    public static final int TYPE_MULTI = 1;
    public static final int TYPE_SINGLE = 0;
    private boolean autoChangeWithLimit;
    private float customFadeLength;
    private int customMaxHeight;
    private int customMaxLines;
    private int customMinHeight;
    private CharSequence digits;
    private TextUtils.TruncateAt ellipsize;
    private int inputType;
    private boolean isErrorState;
    private boolean isInAutoChanging;
    private int limitCount;
    private b limitStateChangeListener;
    private boolean overLimit;
    private boolean showClear;
    private boolean showEyes;
    private boolean showLimit;
    private int type;
    private final ImageView vClear;
    private final FrameLayout vCustomEnd;
    private final FrameLayout vCustomStart;
    private final View vDivider;
    private final LinearLayout vEditContainer;
    private final ImageView vEyes;
    private final FrameLayout vHelperContainer;
    private final OEditText vInput;
    private final LinearLayout vInputContainer;
    private final VerticalFadeFrameLayout vInputFadeContainer;
    private final OTextView vLabel;
    private final OTextView vLimitMulti;
    private final OTextView vLimitSingle;
    private final OTextView vTip;

    /* JADX INFO: compiled from: OInputLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    public interface b {
        void onLimitStateChange(boolean r1);
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    static final class c extends p implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f35265a;

        c(OInputLayout r1) {
            this.f35265a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r1) {
            if (r1 == false) goto L4;
            this.f35265a.showSoftInput();
            return;
        L4:
            this.f35265a.hideSoftInput();
        }
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    static final class d extends p implements r<CharSequence, Integer, Integer, Integer, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f35266a;

        d(OInputLayout r1) {
            this.f35266a = r1;
            super(4);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(CharSequence r3, Integer r4, Integer r5, Integer r6) {
            a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
            return x.f38692a;
        }

        public final void a(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
            if (OInputLayout.access$isInAutoChanging$p(this.f35266a) == false) goto L5;
            return;
        L5:
            this.f35266a.updateLimit();
            OInputLayout.access$updateClear(this.f35266a);
            OInputLayout.access$updateEyes(this.f35266a);
        }
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    static final class e extends p implements d.h.a.b<Editable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f35267a;

        e(OInputLayout r1) {
            this.f35267a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Editable r3) {
            a((Editable) ZeusTransformUtils.preCheckCast(r3, Editable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            if (OInputLayout.access$isInAutoChanging$p(this.f35267a) == false) goto L5;
            return;
        L5:
            this.f35267a.doAfterTextStateChange(r4);
            this.f35267a.updateLimit();
            OInputLayout.access$updateClear(this.f35267a);
            OInputLayout.access$updateEyes(this.f35267a);
            OInputLayout.access$refreshInputFade(this.f35267a);
        }
    }

    static {
        Companion = new a(null);
    }

    public OInputLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OInputLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private final boolean isExpandedMultiLineType(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final boolean isMultiLineType(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean isPasswordOrNumType(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r1 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r1 == true) goto L20;
        if (r2 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    private final boolean isSingleLineType(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    private final boolean isSupportedType(int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 == 2) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    public static /* synthetic */ void lambda$OOI1lNTymwV9TSW8p8xdHkIhLfY(OInputLayout r0, View r1) {
        m1068_init_$lambda2(r0, r1);
    }

    public static /* synthetic */ void lambda$wQLgiUzXOrrlPy0MJE1CIZMABqU(OInputLayout r0, View r1) {
        m1067_init_$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$yz6PqKSjlBCT_tkrpiyei0KyJnw(OInputLayout r0, View r1) {
        m1069_init_$lambda3(r0, r1);
    }

    public void doAfterTextStateChange(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ boolean access$isInAutoChanging$p(OInputLayout r0) {
        return r0.isInAutoChanging;
    }

    public static final /* synthetic */ void access$refreshInputFade(OInputLayout r0) {
        r0.refreshInputFade();
    }

    public static final /* synthetic */ void access$updateClear(OInputLayout r0) {
        r0.updateClear();
    }

    public static final /* synthetic */ void access$updateEyes(OInputLayout r0) {
        r0.updateEyes();
    }

    public /* synthetic */ OInputLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OInputLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, r11);
        this.customMinHeight = -1;
        this.customMaxHeight = -1;
        this.customMaxLines = -1;
        this.customFadeLength = -1.0f;
        this.inputType = 131073;
        this.limitCount = -1;
        View r14 = ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_input_view_layout, "layout", "o_input_view_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r15 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, DbHelper.COL_ID, "input_container"));
        o.c(r16, "findViewById(R.id.input_container)");
        LinearLayout r17 = (LinearLayout) ZeusTransformUtils.preCheckCast(r16, LinearLayout.class, "com.obric.aiagent.plugin");
        this.vInputContainer = r17;
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.edit_container, DbHelper.COL_ID, "edit_container"));
        o.c(r2, "findViewById(R.id.edit_container)");
        this.vEditContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.input_fade_container, DbHelper.COL_ID, "input_fade_container"));
        o.c(r3, "findViewById(R.id.input_fade_container)");
        this.vInputFadeContainer = (VerticalFadeFrameLayout) ZeusTransformUtils.preCheckCast(r3, VerticalFadeFrameLayout.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.helper_container, DbHelper.COL_ID, "helper_container"));
        o.c(r4, "findViewById(R.id.helper_container)");
        this.vHelperContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_start_container, DbHelper.COL_ID, "custom_start_container"));
        o.c(r5, "findViewById(R.id.custom_start_container)");
        this.vCustomStart = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.label, DbHelper.COL_ID, "label"));
        o.c(r6, "findViewById(R.id.label)");
        this.vLabel = (OTextView) ZeusTransformUtils.preCheckCast(r6, OTextView.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.input, DbHelper.COL_ID, "input"));
        o.c(r7, "findViewById(R.id.input)");
        OEditText r8 = (OEditText) ZeusTransformUtils.preCheckCast(r7, OEditText.class, "com.obric.aiagent.plugin");
        this.vInput = r8;
        if (this.type != 0) goto L5;
        int r18 = (int) g.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
    L6:
        r8.setMinimumHeight(r18);
        if (this.type != 0) goto L9;
        View r19 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r20 = 66;
    L10:
        r8.setMaxHeight(g.a(r19, r20));
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, DbHelper.COL_ID, "custom_end_container"));
        o.c(r21, "findViewById(R.id.custom_end_container)");
        this.vCustomEnd = (FrameLayout) ZeusTransformUtils.preCheckCast(r21, FrameLayout.class, "com.obric.aiagent.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.input_divider, DbHelper.COL_ID, "input_divider"));
        o.c(r22, "findViewById(R.id.input_divider)");
        this.vDivider = r22;
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.clear, DbHelper.COL_ID, "clear"));
        o.c(r23, "findViewById(R.id.clear)");
        ImageView r24 = (ImageView) ZeusTransformUtils.preCheckCast(r23, ImageView.class, "com.obric.aiagent.plugin");
        this.vClear = r24;
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.eyes, DbHelper.COL_ID, "eyes"));
        o.c(r25, "findViewById(R.id.eyes)");
        ImageView r26 = (ImageView) ZeusTransformUtils.preCheckCast(r25, ImageView.class, "com.obric.aiagent.plugin");
        this.vEyes = r26;
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.tip, DbHelper.COL_ID, "tip"));
        o.c(r27, "findViewById(R.id.tip)");
        this.vTip = (OTextView) ZeusTransformUtils.preCheckCast(r27, OTextView.class, "com.obric.aiagent.plugin");
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.limit_single, DbHelper.COL_ID, "limit_single"));
        o.c(r28, "findViewById(R.id.limit_single)");
        this.vLimitSingle = (OTextView) ZeusTransformUtils.preCheckCast(r28, OTextView.class, "com.obric.aiagent.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.limit_multi, DbHelper.COL_ID, "limit_multi"));
        o.c(r0, "findViewById(R.id.limit_multi)");
        this.vLimitMulti = (OTextView) ZeusTransformUtils.preCheckCast(r0, OTextView.class, "com.obric.aiagent.plugin");
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r8.setFocusable(true);
        r8.setFocusableInTouchMode(true);
        if (r13 == null) goto L14;
        parseAttributes(r13, r11);
    L14:
        applyFadeLength();
        initInput();
        r24.setOnClickListener(new $$Lambda$OInputLayout$wQLgiUzXOrrlPy0MJE1CIZMABqU(this));
        r26.setOnClickListener(new $$Lambda$OInputLayout$OOI1lNTymwV9TSW8p8xdHkIhLfY(this));
        r17.setOnClickListener(new $$Lambda$OInputLayout$yz6PqKSjlBCT_tkrpiyei0KyJnw(this));
        resetInputContainerCorner();
        return;
    L9:
        r19 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r20 = 240;
        goto L10
    L5:
        r18 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 120);
        goto L6
    }

    public final OEditText getVInput() {
        return this.vInput;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1067_init_$lambda1(OInputLayout r2, View r3) {
        o.e(r2, "this$0");
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        r2.updateClear();
    }

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final void m1068_init_$lambda2(OInputLayout r5, View r6) {
        o.e(r5, "this$0");
        int r0 = 0;
        if ((r5.vInput.getInputType() & 4080) != 144) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        r5.vEyes.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_close, "drawable", "o_input_view_eyes_close"));
        r5.updateInputTypeForMultiLine();
    L11:
        if (r5.vInput.hasFocus() == false) goto L18;
        OEditText r8 = r5.vInput;
        Editable r9 = r8.getText();
        if (r9 == null) goto L16;
        r0 = r9.length();
    L16:
        r8.setSelection(r0);
        return;
    L18:
        return;
    L9:
        r5.vEyes.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_open, "drawable", "o_input_view_eyes_open"));
        r5.vInput.setInputType((r5.vInput.getInputType() & (-4081)) | 144);
        goto L11
    L5:
        r7 = false;
        goto L7
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final void m1069_init_$lambda3(OInputLayout r1, View r2) {
        o.e(r1, "this$0");
        r1.vInput.requestFocus();
        if (r1.vInput.hasFocus() == false) goto L8;
        if (r1.vInput.isCursorVisible() == true) goto L8;
        r1.vInput.setCursorVisible(true);
    L8:
        if (r1.vInput.hasFocus() == false) goto L14;
        Editable r3 = r1.vInput.getText();
        if (r3 != null) goto L12;
        int r4 = 0;
    L13:
        r1.vInput.setSelection(r4);
        goto L14
    L12:
        r4 = r3.length();
    L14:
        r1.showSoftInput();
    }

    private final void parseAttributes(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r8, R.styleable.OInputLayout, r7, 0);
        this.customMinHeight = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_minHeight, "styleable", "OInputLayout_oinput_minHeight"), this.customMinHeight);
        this.customMaxHeight = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_maxHeight, "styleable", "OInputLayout_oinput_maxHeight"), this.customMaxHeight);
        this.customFadeLength = r9.getDimension(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_fadeLength, "styleable", "OInputLayout_oinput_fadeLength"), this.customFadeLength);
        setType(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_type, "styleable", "OInputLayout_oinput_type"), 0));
        showInputBackground(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showInputBackground, "styleable", "OInputLayout_oinput_showInputBackground"), false));
        setCustomStart(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_customStart, "styleable", "OInputLayout_oinput_customStart"), 0));
        showCustomStart(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showCustomStart, "styleable", "OInputLayout_oinput_showCustomStart"), false));
        setLabel((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_label, "styleable", "OInputLayout_oinput_label")), CharSequence.class, "com.obric.aiagent.plugin"));
        showLabel(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showLabel, "styleable", "OInputLayout_oinput_showLabel"), false));
        setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_text, "styleable", "OInputLayout_oinput_text")), CharSequence.class, "com.obric.aiagent.plugin"));
        setHint((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_hint, "styleable", "OInputLayout_oinput_hint")), CharSequence.class, "com.obric.aiagent.plugin"));
        this.digits = r9.getText(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_digits, "styleable", "OInputLayout_android_digits"));
        this.inputType = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_inputType, "styleable", "OInputLayout_android_inputType"), this.inputType);
        setMaxLines(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_maxLines, "styleable", "OInputLayout_android_maxLines"), -1));
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_ellipsize, "styleable", "OInputLayout_android_ellipsize")) == false) goto L5;
        setEllipsize(parseEllipsize(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_ellipsize, "styleable", "OInputLayout_android_ellipsize"), 0)));
    L5:
        setCustomEnd(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_customEnd, "styleable", "OInputLayout_oinput_customEnd"), 0));
        showCustomEnd(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showCustomEnd, "styleable", "OInputLayout_oinput_showCustomEnd"), false));
        this.showClear = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showClear, "styleable", "OInputLayout_oinput_showClear"), false);
        this.showEyes = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showEyes, "styleable", "OInputLayout_oinput_showEyes"), false);
        setTip((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_tip, "styleable", "OInputLayout_oinput_tip")), CharSequence.class, "com.obric.aiagent.plugin"));
        showTip(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showTip, "styleable", "OInputLayout_oinput_showTip"), false));
        setLimitCount(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_limitCount, "styleable", "OInputLayout_oinput_limitCount"), -1));
        showLimit(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showLimit, "styleable", "OInputLayout_oinput_showLimit"), false));
        setAutoChangeWithLimit(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_autoChangeWithLimit, "styleable", "OInputLayout_oinput_autoChangeWithLimit"), false));
    }

    public void setType(int r3) {
        if (isSupportedType(r3) == true) goto L5;
        return;
    L5:
        this.type = r3;
        this.vInput.setMinimumHeight(resolveInputMinHeight(r3));
        this.vInput.setMaxHeight(resolveInputMaxHeight(r3));
        int r0 = this.customMaxLines;
        if (r0 == (-1)) goto L9;
    L12:
        updateMaxLines(r0);
        updatePadding();
        updateLimit();
        updateClear();
        updateEyes();
        return;
    L9:
        if (isSingleLineType(r3) == false) goto L11;
        r0 = 1;
        goto L12
    L11:
        r0 = 12;
        goto L12
    }

    public final int getType() {
        return this.type;
    }

    static /* synthetic */ boolean isSingleLineType$default(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.type;
    L7:
        return r0.isSingleLineType(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isSingleLineType");
    }

    static /* synthetic */ boolean isMultiLineType$default(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.type;
    L7:
        return r0.isMultiLineType(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isMultiLineType");
    }

    static /* synthetic */ boolean isExpandedMultiLineType$default(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.type;
    L7:
        return r0.isExpandedMultiLineType(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isExpandedMultiLineType");
    }

    static /* synthetic */ int resolveInputMinHeight$default(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.type;
    L7:
        return r0.resolveInputMinHeight(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveInputMinHeight");
    }

    private final int resolveInputMinHeight(int r4) {
        int r0 = this.customMinHeight;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (isSingleLineType(r4) == false) goto L10;
        float r3 = g.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
    L13:
        return (int) r3;
    L10:
        if (isExpandedMultiLineType(r4) == true) goto L14;
        r3 = g.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
        goto L13
    L14:
        return g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 120);
    }

    static /* synthetic */ int resolveInputMaxHeight$default(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.type;
    L7:
        return r0.resolveInputMaxHeight(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveInputMaxHeight");
    }

    private final int resolveInputMaxHeight(int r3) {
        int r0 = this.customMaxHeight;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (isSingleLineType(r3) == false) goto L8;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r4 = 66;
    L10:
        return g.a(r2, r4);
    L8:
        r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r4 = 240;
        goto L10
    }

    private final void updatePadding() {
        boolean r1 = true;
        if (isSingleLineType$default(this, 0, 1, null) == true) goto L5;
        LinearLayout r2 = this.vInputContainer;
        int r6 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        int r7 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        if (((View) ZeusTransformUtils.preCheckCast(this.vHelperContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        int r3 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
    L23:
        r2.setPadding(r6, r7, 0, r3);
        this.vLabel.setPadding(0, 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), 0);
        this.vInput.setPadding(0, 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), 0);
        this.vInput.setGravity(8388659);
        this.vInput.setScrollBarStyle(33554432);
        this.vHelperContainer.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        return;
    L22:
        r3 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        goto L23
    L5:
        if (((View) ZeusTransformUtils.preCheckCast(this.vLabel, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8.5d);
    L11:
        LinearLayout r5 = this.vInputContainer;
        int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        if (this.showClear == false) goto L14;
        int r9 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L15:
        r5.setPadding(r8, r4, r9, r4);
        this.vLabel.setPadding(0, 0, 0, 0);
        this.vInput.setPadding(0, 0, 0, 0);
        this.vInput.setGravity(8388627);
        this.vInput.setScrollBarStyle(0);
        int r0 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 5);
        this.vHelperContainer.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), r0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), r0);
        return;
    L14:
        r9 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        goto L15
    L10:
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 13);
        goto L11
    }

    public final void showInputBackground(boolean r4) {
        LinearLayout r0 = this.vInputContainer;
        if (r4 == false) goto L5;
        int r3 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card"));
    L6:
        r0.setBackgroundColor(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private final void resetInputContainerCorner() {
        this.vInputContainer.setClipToOutline(true);
        this.vInputContainer.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        this.vInputContainer.invalidateOutline();
    }

    private final void initInput() {
        enableUpdateCursorDrawable();
        CharSequence r0 = this.digits;
        if (r0 == null) goto L9;
        this.vInput.setKeyListener((KeyListener) ZeusTransformUtils.preCheckCast(DigitsKeyListener.getInstance(String.valueOf(r0)), KeyListener.class, "com.obric.aiagent.plugin"));
        int r1 = this.inputType;
        if (r1 != 0) goto L8;
        r1 = 1;
    L8:
        this.inputType = r1;
    L9:
        int r2 = this.inputType;
        if (r2 == 0) goto L12;
        setInputType(r2);
    L12:
        this.vInput.onFocusChange$OUI_standardRelease((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.vInput.onTextChanged$OUI_standardRelease((r) ZeusTransformUtils.preCheckCast(new d(this), r.class, "com.obric.aiagent.plugin"));
        this.vInput.afterTextChanged$OUI_standardRelease((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void showSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput((View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.aiagent.plugin"), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void hideSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(this.vInput.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator<View> r0 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.aiagent.plugin")).setEnabled(r5);
        goto L4
    L6:
        this.vInput.setEnabled(r5);
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) != 0) goto L12;
        if ((r2 & 2) != 0) goto L12;
        if ((r2 & 3) != 0) goto L12;
        if ((r2 & 4) != 0) goto L12;
        r2 = r2 | 1;
    L12:
        if (this.inputType == r2) goto L14;
        this.inputType = r2;
    L14:
        updateInputTypeForMultiLine();
        updateEyes();
        doAfterTextStateChange(this.vInput.getText());
    }

    public final int getInputType() {
        return this.inputType;
    }

    public void setCustomStart(int r4) {
        this.vCustomStart.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.vCustomStart, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r3) {
        this.vCustomStart.removeAllViews();
        if (r3 != 0) goto L5;
        setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
        return;
    L5:
        showCustomStart(false);
    }

    public final View getCustomStart() {
        if (this.vCustomStart.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.vCustomStart.getChildAt(0);
    }

    public void showCustomStart(boolean r4) {
        int r0 = 0;
        if (isMultiLineType$default(this, 0, 1, null) == false) goto L6;
        return;
    L6:
        if (this.vCustomStart.getChildCount() == 0) goto L12;
        FrameLayout r3 = this.vCustomStart;
        if (r4 == true) goto L11;
        r0 = 8;
    L11:
        r3.setVisibility(r0);
        return;
    L12:
        this.vCustomStart.setVisibility(8);
    }

    public final void setLabel(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.vLabel.setText(r4);
    }

    public final CharSequence getLabel() {
        return this.vLabel.getText();
    }

    public final void showLabel(boolean r4) {
        CharSequence r0 = getLabel();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.vLabel;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
    L17:
        updatePadding();
        return;
    L16:
        this.vLabel.setVisibility(8);
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.vInput.setText(r4);
        doAfterTextStateChange(this.vInput.getText());
    }

    public CharSequence getText() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public int getConstraintLength(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length();
    }

    public final void setHint(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.vInput.setHint(r4);
    }

    public final CharSequence getHint() {
        return this.vInput.getHint();
    }

    public final void setMaxLines(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.customMaxLines = r1;
        updateMaxLines(r1);
    }

    public final void setFadeLength(float r2) {
        float r3 = n.a(r2, 0.0f);
        if (this.customFadeLength != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.customFadeLength = r3;
        applyFadeLength();
        refreshInputFade();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float getFadeLength() {
        return this.vInputFadeContainer.getFadeLength();
    }

    private final void updateMaxLines(int r3) {
        OEditText r0 = this.vInput;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        this.vInput.setMaxLines(r3);
        updateInputTypeForMultiLine();
        refreshInputFade();
    }

    private final void updateInputTypeForMultiLine() {
        boolean r1 = true;
        if (getMaxLines() != 1) goto L6;
        r1 = false;
    L6:
        int r0 = this.inputType;
        if (r1 == true) goto L9;
    L11:
        int r2 = r0 ^ UiType.FLAG_PHONE_CARD;
    L12:
        this.vInput.setInputType(r2);
        this.vInput.invalidate();
        refreshInputFade();
        return;
    L9:
        if (isPasswordOrNumType(r0) == true) goto L11;
        r2 = r0 | UiType.FLAG_PHONE_CARD;
        goto L12
    }

    public final int getMaxLines() {
        return this.vInput.getMaxLines();
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.ellipsize = r1;
        this.vInput.setEllipsize(r1);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.vInput.getEllipsize();
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    public final void setCustomEnd(int r4) {
        this.vCustomEnd.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.vCustomEnd, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final View getCustomEnd() {
        if (this.vCustomEnd.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.vCustomEnd.getChildAt(0);
    }

    public final void showCustomEnd(boolean r4) {
        int r0 = 0;
        if (isMultiLineType$default(this, 0, 1, null) == false) goto L6;
        return;
    L6:
        if (this.vCustomEnd.getChildCount() == 0) goto L12;
        FrameLayout r3 = this.vCustomEnd;
        if (r4 == true) goto L11;
        r0 = 8;
    L11:
        r3.setVisibility(r0);
        return;
    L12:
        this.vCustomEnd.setVisibility(8);
    }

    public final void showDivider(boolean r1) {
        View r0 = this.vDivider;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void showClear(boolean r1) {
        this.showClear = r1;
        updateClear();
    }

    private final void updateClear() {
        ImageView r0 = this.vClear;
        int r1 = 0;
        boolean r2 = true;
        if (isSingleLineType$default(this, 0, 1, null) == true) goto L5;
    L14:
        r1 = 8;
    L15:
        r0.setVisibility(r1);
        updatePadding();
        return;
    L5:
        if (this.showClear == false) goto L14;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
    L12:
        if (r2 == true) goto L14;
    L9:
        if (r3.length() == 0) goto L12;
        r2 = false;
        goto L12
    }

    public final void showEyes(boolean r1) {
        this.showEyes = r1;
        updateEyes();
    }

    private final void updateEyes() {
        ImageView r0 = this.vEyes;
        int r1 = 0;
        boolean r2 = true;
        if (isSingleLineType$default(this, 0, 1, null) == true) goto L5;
    L16:
        r1 = 8;
    L17:
        r0.setVisibility(r1);
        return;
    L5:
        if (this.showEyes == false) goto L16;
        if (isPasswordMode() == false) goto L16;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L11;
    L14:
        if (r2 == true) goto L16;
    L11:
        if (r5.length() == 0) goto L14;
        r2 = false;
        goto L14
    }

    public final boolean isPasswordMode() {
        return isPasswordOrNumType(this.inputType);
    }

    public final void setTip(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.vTip.setText(r4);
    }

    public final CharSequence getTip() {
        return this.vTip.getText();
    }

    public final void showTip(boolean r4) {
        CharSequence r0 = getTip();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.vTip;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
    L17:
        updateHelperContainerVis();
        return;
    L16:
        this.vTip.setVisibility(8);
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private final void updateHelperContainerVis() {
        FrameLayout r0 = this.vHelperContainer;
        boolean r2 = true;
        int r4 = 0;
        if (((View) ZeusTransformUtils.preCheckCast(this.vTip, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L14:
        r0.setVisibility(r4);
        return;
    L8:
        if (((View) ZeusTransformUtils.preCheckCast(this.vLimitMulti, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L14;
        r4 = 8;
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public final void setLimitStateChangeListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "limitStateChangeListener");
        this.limitStateChangeListener = r4;
    }

    public void setLimitCount(int r2) {
        if (this.limitCount != r2) goto L5;
        return;
    L5:
        this.limitCount = r2;
        updateLimit();
        doAfterTextStateChange(this.vInput.getText());
    }

    public final int getLimitCount() {
        return this.limitCount;
    }

    public final void showLimit(boolean r2) {
        if (this.showLimit != r2) goto L5;
        return;
    L5:
        this.showLimit = r2;
        updateLimit();
        updateHelperContainerVis();
    }

    public final void updateLimit() {
        if (this.limitCount <= 0) goto L5;
        OTextView r0 = this.vLimitSingle;
        StringBuilder r2 = new StringBuilder();
        Editable r3 = this.vInput.getText();
        o.a(r3);
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2.append(getConstraintLength((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))).append('/').append(this.limitCount).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r1 = this.vLimitMulti;
        StringBuilder r4 = new StringBuilder();
        Editable r5 = this.vInput.getText();
        o.a(r5);
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.append(getConstraintLength((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))).append('/').append(this.limitCount).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
    L5:
        OTextView r6 = this.vLimitSingle;
        boolean r7 = false;
        int r8 = 8;
        if (isSingleLineType$default(this, 0, 1, null) == true) goto L8;
    L10:
        int r9 = 8;
    L11:
        r6.setVisibility(r9);
        OTextView r10 = this.vLimitMulti;
        if (isMultiLineType$default(this, 0, 1, null) == true) goto L14;
    L16:
        r10.setVisibility(r8);
        if (this.limitCount <= 0) goto L29;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L29;
        Editable r13 = this.vInput.getText();
        o.a(r13);
        if (getConstraintLength((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) <= this.limitCount) goto L29;
        r7 = true;
        goto L29
    L21:
        if (r11.length() == 0) goto L24;
        r12 = false;
    L29:
        boolean r14 = this.overLimit;
        if (r7 == r14) goto L36;
        this.overLimit = r7;
        b r15 = this.limitStateChangeListener;
        if (r15 == null) goto L35;
        r15.onLimitStateChange(r7);
    L35:
        updateTextWithOverLimit();
        return;
    L36:
        if (r14 == false) goto L40;
        updateTextWithOverLimit();
        return;
    L40:
        return;
    L14:
        if (this.showLimit == false) goto L16;
        r8 = 0;
        goto L16
    L8:
        if (this.showLimit == false) goto L10;
        r9 = 0;
        goto L11
    }

    public final void setAutoChangeWithLimit(boolean r1) {
        this.autoChangeWithLimit = r1;
        updateTextWithOverLimit();
    }

    private final void updateTextWithOverLimit() {
        if (this.overLimit == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        setTextState(r0);
        return;
    L5:
        if (this.autoChangeWithLimit == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void setTextState(boolean r15) {
        if (this.isInAutoChanging == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.isInAutoChanging = true;
        int r1 = this.vInput.getSelectionStart();
        int r2 = this.vInput.getSelectionEnd();
        Editable r3 = this.vInput.getText();
        if (r3 == null) goto L49;
        int r7 = r3.length();     // Catch: Exception -> L46
        if (r15 == false) goto L10;
        int r8 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, "color", "oui_functional_red_2"));     // Catch: Exception -> L46
    L11:
        ErrorBackgroundSpan[] r9 = (ErrorBackgroundSpan[]) ZeusTransformUtils.preCheckCast(r3.getSpans(0, r7, ErrorBackgroundSpan.class), ErrorBackgroundSpan[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L46
        o.c(r9, "existingSpans");     // Catch: Exception -> L46
        int r10 = r9.length;     // Catch: Exception -> L46
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L20;
        ErrorBackgroundSpan r12 = r9[r11];     // Catch: Exception -> L46
        if (r12.getBackgroundColor() != r8) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L21;
        r11 = r11 + 1;     // Catch: Exception -> L46
    L21:
        if (r12 != null) goto L23;
        r12 = new ErrorBackgroundSpan(r8);     // Catch: Exception -> L46
    L23:
        int r14 = r9.length;     // Catch: Exception -> L46
        int r16 = 0;
    L24:
        if (r16 >= r14) goto L26;
        r3.removeSpan(r9[r16]);     // Catch: Exception -> L46
        r16 = r16 + 1;     // Catch: Exception -> L46
        goto L24
    L26:
        r3.setSpan(r12, 0, r7, 33);     // Catch: Exception -> L46
        OPasswordTransformationMethod[] r4 = (OPasswordTransformationMethod[]) ZeusTransformUtils.preCheckCast(r3.getSpans(0, r7, OPasswordTransformationMethod.class), OPasswordTransformationMethod[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L46
        o.c(r4, "existingPasswordTransSpans");     // Catch: Exception -> L46
        int r17 = r4.length;     // Catch: Exception -> L46
        int r18 = 0;
    L27:
        if (r18 >= r17) goto L33;
        OPasswordTransformationMethod r19 = r4[r18];     // Catch: Exception -> L46
        if (r19 == null) goto L32;
        r19.setShowErrorBackground(r15);     // Catch: Exception -> L46
        r18 = r18 + 1;     // Catch: Exception -> L46
        goto L27
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.forms.OPasswordTransformationMethod");     // Catch: Exception -> L46
    L33:
        if (r1 < 0) goto L36;
        if (r1 > r7) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == false) goto L44;
        if (r2 < 0) goto L41;
        if (r2 > r7) goto L41;
    L42:
        if (r0 == false) goto L44;
        this.vInput.setSelection(r1, r2);     // Catch: Exception -> L46
    L41:
        r0 = false;
    L44:
        this.vInput.setSelection(r1, r7);     // Catch: Exception -> L46
    L36:
        r5 = false;
        goto L37
    L16:
        r13 = false;
        goto L17
    L20:
        r12 = null;
        goto L21
    L10:
        r8 = 0;
    L46:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_forms_OInputLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, o.a("Error setTextState: ", e));
    L49:
        if (this.isErrorState == r15) goto L57;
        this.isErrorState = r15;
        if (Build.VERSION.SDK_INT < 29) goto L57;
        OEditText r6 = this.vInput;
        if (r15 == false) goto L55;
        int r20 = R.drawable.o_input_cursor_red;
        String r21 = "o_input_cursor_red";
    L56:
        r6.setTextCursorDrawable(ZeusTransformUtils.mapRes(r20, "drawable", r21));
        goto L57
    L55:
        r20 = R.drawable.o_input_cursor_blue;
        r21 = "o_input_cursor_blue";
    L57:
        OTextView r22 = this.vTip;
        Resources r23 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (r15 == false) goto L60;
        int r24 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
    L61:
        r22.setTextColor(r23.getColor(r24));
        OTextView r25 = this.vLimitSingle;
        Resources r26 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (r15 == false) goto L64;
        int r27 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
    L65:
        r25.setTextColor(r26.getColor(r27));
        OTextView r28 = this.vLimitMulti;
        Resources r29 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (r15 == false) goto L68;
        int r110 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
    L69:
        r28.setTextColor(r29.getColor(r110));
        this.isInAutoChanging = false;
        refreshInputFade();
        return;
    L68:
        r110 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b");
        goto L69
    L64:
        r27 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b");
        goto L65
    L60:
        r24 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b");
        goto L61
    }

    public final void enableUpdateCursorDrawable() {
        Method r0 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", new Class[0]);     // Catch: Exception -> L4
        o.c(r0, "TextView::class.java.get…orDrawable\"\n            )");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(this.vInput, new Object[0]);     // Catch: Exception -> L4
        return;
    }

    private final void applyFadeLength() {
        float r0 = this.customFadeLength;
        if (r0 < 0.0f) goto L6;
        this.vInputFadeContainer.setFadeLength(r0);
        return;
    }

    private final void refreshInputFade() {
        this.vInputFadeContainer.refreshFade();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_forms_OInputLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
