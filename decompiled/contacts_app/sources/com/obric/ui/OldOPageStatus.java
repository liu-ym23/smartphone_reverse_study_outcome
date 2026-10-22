package com.obric.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OBaseTextView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OldOPageStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020)R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006+"}, d2 = {"Lcom/obric/ui/OldOPageStatus;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasMessage", "", "paddingInternal", "getPaddingInternal", "()I", "setPaddingInternal", "(I)V", "sizeSpec", "Lcom/obric/ui/SizeSpec;", "statusSpec", "Lcom/obric/ui/StatusSpec;", "titleView", "Landroid/widget/TextView;", "topImageSize", "getTopImageSize", "setTopImageSize", "applySpec", "", "createBottomWidButton", "Lcom/obric/oui/button/OButton;", "setImage", "Landroid/widget/ImageView;", "resId", "setMessage", "message", "", "setTitle", "title", "setTitleWithLoading", "Landroid/view/View;", "setTopImage", "showTopLoading", "Lcom/obric/oui/progress/ODownloadProgressView;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OldOPageStatus extends LinearLayout {
    public static final Companion Companion = null;
    private static final String TAG = "OPageStatus";
    private boolean hasMessage;
    private int paddingInternal;
    private SizeSpec sizeSpec;
    private StatusSpec statusSpec;
    private TextView titleView;
    private int topImageSize;

    /* JADX INFO: compiled from: OldOPageStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/ui/OldOPageStatus$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OldOPageStatus.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SizeSpec.values().length];
            r0[SizeSpec.LARGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SizeSpec.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SizeSpec.SMALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OldOPageStatus(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OldOPageStatus(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OldOPageStatus(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OldOPageStatus(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.sizeSpec = SizeSpec.MEDIUM;
        this.statusSpec = StatusSpec.EMPTY;
        setOrientation(1);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.OldOPageStatus);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…styleable.OldOPageStatus)");
        int r7 = r6.getInt(0, SizeSpec.MEDIUM.getValue());
        int r0 = r6.getInt(1, StatusSpec.EMPTY.getValue());
        this.sizeSpec = SizeSpec.Companion.fromValue(r7);
        this.statusSpec = StatusSpec.Companion.fromValue(r0);
        r6.recycle();
        applySpec();
        setLayoutParams(new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, 300, Resources.getSystem().getDisplayMetrics())), -2));
        setGravity(1);
    }

    public final int getPaddingInternal() {
        return this.paddingInternal;
    }

    public final void setPaddingInternal(int r1) {
        this.paddingInternal = r1;
    }

    public final int getTopImageSize() {
        return this.topImageSize;
    }

    public final void setTopImageSize(int r1) {
        this.topImageSize = r1;
    }

    private final void applySpec() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.sizeSpec.ordinal()];
        if (r0 != 1) goto L5;
        this.paddingInternal = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
        this.topImageSize = MathKt.roundToInt(TypedValue.applyDimension(1, 108, Resources.getSystem().getDisplayMetrics()));
    L13:
        if (this.statusSpec == StatusSpec.LOADING) goto L15;
        return;
    L15:
        if (this.sizeSpec != SizeSpec.SMALL) goto L19;
        this.paddingInternal = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        return;
    L19:
        return;
    L5:
        if (r0 != 2) goto L7;
        this.paddingInternal = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
        this.topImageSize = MathKt.roundToInt(TypedValue.applyDimension(1, 72, Resources.getSystem().getDisplayMetrics()));
        goto L13
    L7:
        if (r0 != 3) goto L13;
        this.paddingInternal = MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        this.topImageSize = MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
        goto L13
    }

    @Deprecated(message = "默认不再支持显示顶部图片")
    public final ImageView setImage(int r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setImage is deprecated, this method will be removed in the future");
        return new ImageView(getContext());
    }

    public final ImageView setTopImage(int r4) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r4);
        int r1 = this.topImageSize;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(r1, r1);
        r5.setMargins(0, 0, 0, this.paddingInternal);
        r0.setLayoutParams(r5);
        addView(r0);
        return r0;
    }

    public final ODownloadProgressView showTopLoading() {
        ODownloadProgressView r0 = new ODownloadProgressView(getContext());
        int r2 = this.topImageSize;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r2, r2);
        r1.setMargins(0, 0, 0, this.paddingInternal);
        r0.setLayoutParams(r1);
        addView(r0);
        return r0;
    }

    public final TextView setTitle(String r8) {
        Intrinsics.checkNotNullParameter(r8, "title");
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OBaseTextView r0 = new OBaseTextView(r2, null, 0, 6, null);
        String r9 = r8;
        r0.setText(r9);
        r0.setTextColor(r0.getResources().getColor(R.color.oui_text_3b));
        r0.setGravity(1);
        int r3 = WhenMappings.$EnumSwitchMapping$0[this.sizeSpec.ordinal()];
        if (r3 != 1) goto L5;
        r0.setTextSize(20.0f);
        r0.setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 28, Resources.getSystem().getDisplayMetrics())));
        r0.setTypeface(Typeface.DEFAULT_BOLD);
    L12:
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMargins(0, 0, 0, this.paddingInternal);
        r0.setLayoutParams(r10);
        addView(r0);
        OBaseTextView r1 = r0;
        this.titleView = r1;
        return r1;
    L5:
        if (r3 != 2) goto L7;
        r0.setTextSize(18.0f);
        r0.setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())));
        r0.setTypeface(Typeface.DEFAULT_BOLD);
        goto L12
    L7:
        if (r3 != 3) goto L12;
        r0.setText(r9);
        r0.setTextSize(16.0f);
        r0.setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics())));
        goto L12
    }

    public final TextView setMessage(String r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        TextView r0 = this.titleView;
        if (r0 == null) goto L17;
        this.hasMessage = true;
        Intrinsics.checkNotNull(r0);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        int r3 = WhenMappings.$EnumSwitchMapping$0[this.sizeSpec.ordinal()];
        if (r3 != 1) goto L7;
        r2.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
    L16:
        TextView r4 = this.titleView;
        Intrinsics.checkNotNull(r4);
        r4.setLayoutParams(r2);
        goto L17
    L7:
        if (r3 != 2) goto L9;
        r2.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics())));
        goto L16
    L9:
        if (r3 != 3) goto L16;
        if (this.statusSpec != StatusSpec.EMPTY) goto L16;
        r2.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
    L17:
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OBaseTextView r6 = new OBaseTextView(r5, null, 0, 6, null);
        r6.setText(r11);
        r6.setTextAppearance(R.style.Label_L_Thin);
        r6.setTextColor(r6.getResources().getColor(R.color.oui_text_3b));
        r6.setGravity(1);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -2);
        r12.setMargins(0, 0, 0, this.paddingInternal);
        r6.setLayoutParams(r12);
        addView(r6);
        return r6;
    }

    public final OButton createBottomWidButton() {
        OButton.Companion r0 = OButton.Companion;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        return r0.createButton(r1, this, R.layout.o_l1_primary_width_200_button);
    }

    public final View setTitleWithLoading(String r3) {
        Intrinsics.checkNotNullParameter(r3, "title");
        View r2 = View.inflate(getContext(), R.layout.o_status_title_with_loading, this);
        TextView r0 = (TextView) r2.findViewById(R.id.title);
        if (r0 == null) goto L6;
        r0.setText(r3);
    L6:
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        return r2;
    }
}
