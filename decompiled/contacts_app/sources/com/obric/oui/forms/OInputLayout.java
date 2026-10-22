package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.GlobalProxyLancet;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.text.OTextView;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: OInputLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\b\u0017\u0018\u0000 x2\u00020\u0001:\u0003xyzB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0006\u00105\u001a\u000202J\u0012\u00106\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00108\u001a\u0004\u0018\u00010\"J\b\u00109\u001a\u0004\u0018\u00010\"J\b\u0010:\u001a\u0004\u0018\u00010\u0011J\b\u0010;\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010<\u001a\u00020\u0007J\b\u0010=\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010>\u001a\u00020\u0007J\u0006\u0010?\u001a\u00020\u0007J\n\u0010@\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010A\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010B\u001a\u00020\u0007J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\u0006\u0010E\u001a\u00020\nJ\u0010\u0010F\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0018\u0010G\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u00112\u0006\u0010I\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u000202H\u0002J\u000e\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\nJ\u000e\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020\u0007J\u0010\u0010O\u001a\u0002022\u0006\u0010N\u001a\u00020\u0007H\u0016J\u0010\u0010P\u001a\u0002022\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u0002022\b\u0010S\u001a\u0004\u0018\u00010\u0011J\u0010\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020\nH\u0016J\u0010\u0010V\u001a\u0002022\b\u0010W\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010X\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010Y\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u000e\u0010]\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010^\u001a\u0002022\u0006\u0010_\u001a\u00020\u0007J\u0010\u0010`\u001a\u0002022\b\u0010a\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010b\u001a\u0002022\u0006\u0010c\u001a\u00020\nJ\u0010\u0010d\u001a\u0002022\b\u0010e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010f\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u000e\u0010\u0019\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\u000e\u0010h\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\u0010\u0010i\u001a\u0002022\u0006\u0010g\u001a\u00020\nH\u0016J\u000e\u0010j\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\u000e\u0010k\u001a\u0002022\u0006\u0010l\u001a\u00020\nJ\u000e\u0010m\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\b\u0010n\u001a\u000202H\u0002J\u000e\u0010o\u001a\u0002022\u0006\u0010g\u001a\u00020\nJ\b\u0010p\u001a\u000202H\u0002J\b\u0010q\u001a\u000202H\u0002J\b\u0010r\u001a\u000202H\u0002J\b\u0010s\u001a\u000202H\u0002J\u0006\u0010t\u001a\u000202J\u0010\u0010u\u001a\u0002022\u0006\u0010_\u001a\u00020\u0007H\u0002J\b\u0010v\u001a\u000202H\u0002J\b\u0010w\u001a\u000202H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoChangeWithLimit", "", "customMaxHeight", "customMaxLines", "customMinHeight", "digits", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "inputType", "isErrorState", "isInAutoChanging", "limitCount", "limitStateChangeListener", "Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "overLimit", "showClear", "showEyes", "showLimit", "type", "vClear", "Landroid/widget/ImageView;", "vCustomEnd", "vCustomStart", "vDivider", "Landroid/view/View;", "vEditContainer", "Landroid/widget/LinearLayout;", "vEyes", "vHelperContainer", "vInput", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInputContainer", "vLabel", "Lcom/obric/oui/text/OTextView;", "vLimitMulti", "vLimitSingle", "vTip", "doAfterTextStateChange", "", "editable", "Landroid/text/Editable;", "enableUpdateCursorDrawable", "getConstraintLength", "s", "getCustomEnd", "getCustomStart", "getEllipsize", "getHint", "getInputType", "getLabel", "getLimitCount", "getMaxLines", "getText", "getTip", "getType", "hideSoftInput", "initInput", "isPasswordMode", "isPasswordOrNumType", "parseAttributes", "parseEllipsize", "value", "resetInputContainerCorner", "setAutoChangeWithLimit", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "setCustomEnd", "resId", "setCustomStart", "setDefaultCustomStart", "defaultStart", "setEllipsize", "where", "setEnabled", "enabled", "setHint", "hint", "setInputType", "setLabel", GroupDeletionDialogFragment.ARG_LABEL, "setLimitCount", "count", "setLimitStateChangeListener", "setMaxLines", "lines", "setText", "text", "setTextState", "isError", "setTip", "tip", "setType", "show", "showCustomEnd", "showCustomStart", "showDivider", "showInputBackground", "showBg", "showLabel", "showSoftInput", "showTip", "updateClear", "updateEyes", "updateHelperContainerVis", "updateInputTypeForMultiLine", "updateLimit", "updateMaxLines", "updatePadding", "updateTextWithOverLimit", "Companion", "ErrorBackgroundSpan", "LimitStateChangeObserver", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInputLayout extends FrameLayout {
    public static final Companion Companion = null;
    public static final int DEFAULT_START_AREA_CODE = 0;
    public static final String TAG = "OInputLayout";
    public static final int TYPE_MULTI = 1;
    public static final int TYPE_SINGLE = 0;
    private boolean autoChangeWithLimit;
    private int customMaxHeight;
    private int customMaxLines;
    private int customMinHeight;
    private CharSequence digits;
    private TextUtils.TruncateAt ellipsize;
    private int inputType;
    private boolean isErrorState;
    private boolean isInAutoChanging;
    private int limitCount;
    private LimitStateChangeObserver limitStateChangeListener;
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
    private final OTextView vLabel;
    private final OTextView vLimitMulti;
    private final OTextView vLimitSingle;
    private final OTextView vTip;

    /* JADX INFO: compiled from: OInputLayout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$Companion;", "", "()V", "DEFAULT_START_AREA_CODE", "", "TAG", "", "TYPE_MULTI", "TYPE_SINGLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$ErrorBackgroundSpan;", "Landroid/text/style/BackgroundColorSpan;", "color", "", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ErrorBackgroundSpan extends BackgroundColorSpan {
        public ErrorBackgroundSpan(int r1) {
            super(r1);
        }
    }

    /* JADX INFO: compiled from: OInputLayout.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "", "onLimitStateChange", "", "over", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LimitStateChangeObserver {
        void onLimitStateChange(boolean r1);
    }

    public static /* synthetic */ void $r8$lambda$OOI1lNTymwV9TSW8p8xdHkIhLfY(OInputLayout r0, View r1) {
        m510_init_$lambda2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wQLgiUzXOrrlPy0MJE1CIZMABqU(OInputLayout r0, View r1) {
        m509_init_$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yz6PqKSjlBCT_tkrpiyei0KyJnw(OInputLayout r0, View r1) {
        m511_init_$lambda3(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OInputLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OInputLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final boolean isPasswordOrNumType(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r6 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r7 = true;
    L14:
        if (r6 == true) goto L20;
        if (r2 == true) goto L21;
        if (r7 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r7 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r6 = false;
        goto L7
    }

    public void doAfterTextStateChange(Editable r1) {
    }

    public static final /* synthetic */ void access$hideSoftInput(OInputLayout r0) {
        r0.hideSoftInput();
    }

    public static final /* synthetic */ boolean access$isInAutoChanging$p(OInputLayout r0) {
        return r0.isInAutoChanging;
    }

    public static final /* synthetic */ void access$showSoftInput(OInputLayout r0) {
        r0.showSoftInput();
    }

    public static final /* synthetic */ void access$updateClear(OInputLayout r0) {
        r0.updateClear();
    }

    public static final /* synthetic */ void access$updateEyes(OInputLayout r0) {
        r0.updateEyes();
    }

    public /* synthetic */ OInputLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OInputLayout(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.customMinHeight = -1;
        this.customMaxHeight = -1;
        this.customMaxLines = -1;
        this.inputType = 131073;
        this.limitCount = -1;
        View r10 = LayoutInflater.from(r7).inflate(R.layout.o_input_view_layout, this, true);
        if (r10 == null) goto L19;
        FrameLayout r11 = (FrameLayout) r10;
        View r12 = findViewById(R.id.input_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.input_container)");
        LinearLayout r13 = (LinearLayout) r12;
        this.vInputContainer = r13;
        View r0 = findViewById(R.id.edit_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.edit_container)");
        this.vEditContainer = (LinearLayout) r0;
        View r1 = findViewById(R.id.helper_container);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.helper_container)");
        this.vHelperContainer = (FrameLayout) r1;
        View r2 = findViewById(R.id.custom_start_container);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.custom_start_container)");
        this.vCustomStart = (FrameLayout) r2;
        View r3 = findViewById(R.id.label);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.label)");
        this.vLabel = (OTextView) r3;
        View r4 = findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.input)");
        OEditText r5 = (OEditText) r4;
        this.vInput = r5;
        if (this.type != 0) goto L7;
        int r6 = (int) OUnitExtensionKt.vspFloat(this, 22.0f);
    L8:
        r5.setMinimumHeight(r6);
        if (this.type != 0) goto L11;
        OInputLayout r14 = this;
        int r15 = 66;
    L12:
        r5.setMaxHeight(OUnitExtensionKt.vdp(r14, r15));
        View r16 = findViewById(R.id.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.custom_end_container)");
        this.vCustomEnd = (FrameLayout) r16;
        View r17 = findViewById(R.id.input_divider);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.input_divider)");
        this.vDivider = r17;
        View r18 = findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.clear)");
        ImageView r19 = (ImageView) r18;
        this.vClear = r19;
        View r20 = findViewById(R.id.eyes);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.eyes)");
        ImageView r21 = (ImageView) r20;
        this.vEyes = r21;
        View r22 = findViewById(R.id.tip);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tip)");
        this.vTip = (OTextView) r22;
        View r23 = findViewById(R.id.limit_single);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.limit_single)");
        this.vLimitSingle = (OTextView) r23;
        View r24 = findViewById(R.id.limit_multi);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.limit_multi)");
        this.vLimitMulti = (OTextView) r24;
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r5.setFocusable(true);
        r5.setFocusableInTouchMode(true);
        if (r8 == null) goto L16;
        parseAttributes(r8, r9);
    L16:
        initInput();
        r19.setOnClickListener(new OInputLayout$$ExternalSyntheticLambda0(this));
        r21.setOnClickListener(new OInputLayout$$ExternalSyntheticLambda1(this));
        r13.setOnClickListener(new OInputLayout$$ExternalSyntheticLambda2(this));
        resetInputContainerCorner();
        return;
    L11:
        r14 = this;
        r15 = BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND;
        goto L12
    L7:
        r6 = OUnitExtensionKt.vdp(this, 120);
        goto L8
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final OEditText getVInput() {
        return this.vInput;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m509_init_$lambda1(OInputLayout r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.setText("");
        r0.updateClear();
    }

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final void m510_init_$lambda2(OInputLayout r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        int r0 = 0;
        if ((r3.vInput.getInputType() & 4080) != 144) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        r3.vEyes.setImageResource(R.drawable.o_input_view_eyes_close);
        r3.updateInputTypeForMultiLine();
    L10:
        if (r3.vInput.hasFocus() == false) goto L17;
        OEditText r6 = r3.vInput;
        Editable r7 = r6.getText();
        if (r7 == null) goto L15;
        r0 = r7.length();
    L15:
        r6.setSelection(r0);
        return;
    L17:
        return;
    L8:
        r3.vEyes.setImageResource(R.drawable.o_input_view_eyes_open);
        r3.vInput.setInputType((r3.vInput.getInputType() & (-4081)) | 144);
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final void m511_init_$lambda3(OInputLayout r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
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

    private final void parseAttributes(AttributeSet r4, int r5) {
        TypedArray r6 = getContext().getTheme().obtainStyledAttributes(r4, R.styleable.OInputLayout, r5, 0);
        setType(r6.getInt(R.styleable.OInputLayout_oinput_type, 0));
        showInputBackground(r6.getBoolean(R.styleable.OInputLayout_oinput_showInputBackground, false));
        this.customMinHeight = r6.getDimensionPixelSize(R.styleable.OInputLayout_oinput_minHeight, -1);
        this.customMaxHeight = r6.getDimensionPixelSize(R.styleable.OInputLayout_oinput_maxHeight, -1);
        setCustomStart(r6.getResourceId(R.styleable.OInputLayout_oinput_customStart, 0));
        showCustomStart(r6.getBoolean(R.styleable.OInputLayout_oinput_showCustomStart, false));
        setLabel(r6.getString(R.styleable.OInputLayout_oinput_label));
        showLabel(r6.getBoolean(R.styleable.OInputLayout_oinput_showLabel, false));
        setText(r6.getString(R.styleable.OInputLayout_oinput_text));
        setHint(r6.getString(R.styleable.OInputLayout_oinput_hint));
        this.digits = r6.getText(R.styleable.OInputLayout_android_digits);
        this.inputType = r6.getInt(R.styleable.OInputLayout_android_inputType, this.inputType);
        setMaxLines(r6.getInt(R.styleable.OInputLayout_android_maxLines, -1));
        if (r6.hasValue(R.styleable.OInputLayout_android_ellipsize) == false) goto L5;
        setEllipsize(parseEllipsize(r6.getInt(R.styleable.OInputLayout_android_ellipsize, 0)));
    L5:
        setCustomEnd(r6.getResourceId(R.styleable.OInputLayout_oinput_customEnd, 0));
        showCustomEnd(r6.getBoolean(R.styleable.OInputLayout_oinput_showCustomEnd, false));
        this.showClear = r6.getBoolean(R.styleable.OInputLayout_oinput_showClear, false);
        this.showEyes = r6.getBoolean(R.styleable.OInputLayout_oinput_showEyes, false);
        setTip(r6.getString(R.styleable.OInputLayout_oinput_tip));
        showTip(r6.getBoolean(R.styleable.OInputLayout_oinput_showTip, false));
        setLimitCount(r6.getInt(R.styleable.OInputLayout_oinput_limitCount, -1));
        showLimit(r6.getBoolean(R.styleable.OInputLayout_oinput_showLimit, false));
        setAutoChangeWithLimit(r6.getBoolean(R.styleable.OInputLayout_oinput_autoChangeWithLimit, false));
    }

    public void setType(int r6) {
        int r0 = 1;
        if (r6 == 0) goto L6;
        if (r6 == 1) goto L6;
        return;
    L6:
        this.type = r6;
        OEditText r1 = this.vInput;
        int r2 = this.customMinHeight;
        if (r2 != (-1)) goto L13;
        OInputLayout r3 = this;
        if (r6 != 0) goto L12;
        r2 = (int) OUnitExtensionKt.vspFloat(r3, 22.0f);
        goto L13
    L12:
        r2 = OUnitExtensionKt.vdp(r3, 120);
    L13:
        r1.setMinimumHeight(r2);
        OEditText r4 = this.vInput;
        int r5 = this.customMaxHeight;
        if (r5 != (-1)) goto L21;
        OInputLayout r7 = this;
        if (r6 != 0) goto L19;
        int r8 = 66;
    L20:
        r5 = OUnitExtensionKt.vdp(r7, r8);
        goto L21
    L19:
        r8 = BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND;
    L21:
        r4.setMaxHeight(r5);
        int r9 = this.customMaxLines;
        if (r9 == (-1)) goto L24;
        r0 = r9;
    L27:
        updateMaxLines(r0);
        updatePadding();
        updateLimit();
        updateClear();
        updateEyes();
        return;
    L24:
        if (r6 == 0) goto L27;
        r0 = 12;
        goto L27
    }

    public final int getType() {
        return this.type;
    }

    private final void updatePadding() {
        boolean r1 = true;
        if (this.type == 0) goto L5;
        LinearLayout r0 = this.vInputContainer;
        OInputLayout r5 = this;
        int r6 = OUnitExtensionKt.vdp(r5, 12);
        int r7 = OUnitExtensionKt.vdp(r5, 8);
        if (this.vHelperContainer.getVisibility() == 0) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L19;
        int r2 = OUnitExtensionKt.vdp(r5, 0);
    L20:
        r0.setPadding(r6, r7, 0, r2);
        this.vLabel.setPadding(0, 0, OUnitExtensionKt.vdp(r5, 12), 0);
        this.vInput.setPadding(0, 0, OUnitExtensionKt.vdp(r5, 12), 0);
        this.vInput.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        this.vHelperContainer.setPadding(OUnitExtensionKt.vdp(r5, 12), OUnitExtensionKt.vdp(r5, 6), OUnitExtensionKt.vdp(r5, 12), OUnitExtensionKt.vdp(r5, 8));
        return;
    L19:
        r2 = OUnitExtensionKt.vdp(r5, 8);
        goto L20
    L5:
        if (this.vLabel.getVisibility() == 0) goto L8;
        r1 = false;
    L8:
        OInputLayout r3 = this;
        if (r1 == false) goto L11;
        int r4 = OUnitExtensionKt.vdp(r3, 8.5d);
    L12:
        OInputLayout r8 = this;
        this.vInputContainer.setPadding(OUnitExtensionKt.vdp(r8, 12), r4, OUnitExtensionKt.vdp(r8, 8), r4);
        this.vLabel.setPadding(0, 0, 0, 0);
        this.vInput.setPadding(0, 0, 0, 0);
        this.vInput.setScrollBarStyle(0);
        int r9 = OUnitExtensionKt.vdp(r8, 5);
        this.vHelperContainer.setPadding(OUnitExtensionKt.vdp(r8, 12), r9, OUnitExtensionKt.vdp(r8, 8), r9);
        return;
    L11:
        r4 = OUnitExtensionKt.vdp(r3, 13);
        goto L12
    }

    public final void showInputBackground(boolean r2) {
        LinearLayout r0 = this.vInputContainer;
        if (r2 == false) goto L5;
        int r1 = getResources().getColor(R.color.oui_fill_list_item_card);
    L6:
        r0.setBackgroundColor(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private final void resetInputContainerCorner() {
        this.vInputContainer.setClipToOutline(true);
        this.vInputContainer.setOutlineProvider(new C03451(this));
        this.vInputContainer.invalidateOutline();
    }

    private final void initInput() {
        enableUpdateCursorDrawable();
        CharSequence r0 = this.digits;
        if (r0 == null) goto L9;
        this.vInput.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r0)));
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
        this.vInput.onFocusChange$OUI_standardRelease(new AnonymousClass1(this));
        this.vInput.onTextChanged$OUI_standardRelease(new AnonymousClass2(this));
        this.vInput.afterTextChanged$OUI_standardRelease(new AnonymousClass3(this));
    }

    private final void showSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput(this.vInput, 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void hideSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
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
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        Iterator<View> r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setEnabled(r3);
        goto L4
    L6:
        this.vInput.setEnabled(r3);
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

    public void setCustomStart(int r2) {
        this.vCustomStart.removeAllViews();
        if (r2 == 0) goto L9;
        FrameLayout.inflate(getContext(), r2, this.vCustomStart);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r2) {
        this.vCustomStart.removeAllViews();
        if (r2 != 0) goto L5;
        setCustomStart(R.layout.o_input_custom_start_area_code);
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

    public void showCustomStart(boolean r3) {
        if (this.type != 1) goto L5;
        return;
    L5:
        int r1 = 8;
        if (this.vCustomStart.getChildCount() == 0) goto L11;
        FrameLayout r2 = this.vCustomStart;
        if (r3 == false) goto L10;
        r1 = 0;
    L10:
        r2.setVisibility(r1);
        return;
    L11:
        this.vCustomStart.setVisibility(8);
    }

    public final void setLabel(CharSequence r1) {
        this.vLabel.setText(r1);
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

    public final void setText(CharSequence r2) {
        this.vInput.setText(r2);
        doAfterTextStateChange(this.vInput.getText());
    }

    public CharSequence getText() {
        return this.vInput.getText();
    }

    public int getConstraintLength(CharSequence r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.length();
    }

    public final void setHint(CharSequence r1) {
        this.vInput.setHint(r1);
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

    private final void updateMaxLines(int r3) {
        OEditText r0 = this.vInput;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        this.vInput.setMaxLines(r3);
        updateInputTypeForMultiLine();
    }

    private final void updateInputTypeForMultiLine() {
        boolean r1 = true;
        if (getMaxLines() != 1) goto L6;
        r1 = false;
    L6:
        int r0 = this.inputType;
        if (r1 == true) goto L9;
    L11:
        int r2 = r0 ^ 131072;
    L12:
        this.vInput.setInputType(r2);
        this.vInput.invalidate();
        return;
    L9:
        if (isPasswordOrNumType(r0) == true) goto L11;
        r2 = r0 | 131072;
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

    public final void setCustomEnd(int r2) {
        this.vCustomEnd.removeAllViews();
        if (r2 == 0) goto L9;
        FrameLayout.inflate(getContext(), r2, this.vCustomEnd);     // Catch: Exception -> L6
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

    public final void showCustomEnd(boolean r3) {
        if (this.type != 1) goto L5;
        return;
    L5:
        int r1 = 8;
        if (this.vCustomEnd.getChildCount() == 0) goto L11;
        FrameLayout r2 = this.vCustomEnd;
        if (r3 == false) goto L10;
        r1 = 0;
    L10:
        r2.setVisibility(r1);
        return;
    L11:
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
        if (this.type == 0) goto L5;
    L15:
        int r1 = 8;
    L16:
        r0.setVisibility(r1);
        return;
    L5:
        if (this.showClear == false) goto L15;
        Editable r2 = this.vInput.getText();
        r1 = 0;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    public final void showEyes(boolean r1) {
        this.showEyes = r1;
        updateEyes();
    }

    private final void updateEyes() {
        ImageView r0 = this.vEyes;
        if (this.type == 0) goto L5;
    L17:
        int r1 = 8;
    L18:
        r0.setVisibility(r1);
        return;
    L5:
        if (this.showEyes == false) goto L17;
        if (isPasswordMode() == false) goto L17;
        Editable r2 = this.vInput.getText();
        r1 = 0;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    }

    public final boolean isPasswordMode() {
        return isPasswordOrNumType(this.inputType);
    }

    public final void setTip(CharSequence r1) {
        this.vTip.setText(r1);
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
        int r3 = 0;
        if (this.vTip.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L14:
        r0.setVisibility(r3);
        return;
    L8:
        if (this.vLimitMulti.getVisibility() == 0) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L14;
        r3 = 8;
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public final void setLimitStateChangeListener(LimitStateChangeObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "limitStateChangeListener");
        this.limitStateChangeListener = r2;
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
        StringBuilder r1 = new StringBuilder();
        Editable r2 = this.vInput.getText();
        Intrinsics.checkNotNull(r2);
        r0.setText(r1.append(getConstraintLength(r2)).append('/').append(this.limitCount).toString());
        OTextView r3 = this.vLimitMulti;
        StringBuilder r4 = new StringBuilder();
        Editable r5 = this.vInput.getText();
        Intrinsics.checkNotNull(r5);
        r3.setText(r4.append(getConstraintLength(r5)).append('/').append(this.limitCount).toString());
    L5:
        OTextView r6 = this.vLimitSingle;
        int r7 = 8;
        boolean r8 = false;
        if (this.type == 0) goto L8;
    L10:
        int r9 = 8;
    L11:
        r6.setVisibility(r9);
        OTextView r10 = this.vLimitMulti;
        if (this.type == 1) goto L14;
    L16:
        r10.setVisibility(r7);
        if (this.limitCount <= 0) goto L29;
        Editable r11 = this.vInput.getText();
        if (r11 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L29;
        Editable r13 = this.vInput.getText();
        Intrinsics.checkNotNull(r13);
        if (getConstraintLength(r13) <= this.limitCount) goto L29;
        r8 = true;
        goto L29
    L21:
        if (r11.length() == 0) goto L24;
        r12 = false;
    L29:
        boolean r14 = this.overLimit;
        if (r8 == r14) goto L36;
        this.overLimit = r8;
        LimitStateChangeObserver r15 = this.limitStateChangeListener;
        if (r15 == null) goto L35;
        r15.onLimitStateChange(r8);
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
        r7 = 0;
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

    public final void setTextState(boolean r13) {
        if (this.isInAutoChanging == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.isInAutoChanging = true;
        int r1 = this.vInput.getSelectionStart();
        int r2 = this.vInput.getSelectionEnd();
        Editable r3 = this.vInput.getText();
        if (r3 == null) goto L43;
        int r5 = r3.length();     // Catch: Exception -> L40
        if (r13 == false) goto L10;
        int r6 = ContextCompat.getColor(getContext(), R.color.oui_functional_red_2);     // Catch: Exception -> L40
    L11:
        ErrorBackgroundSpan[] r7 = (ErrorBackgroundSpan[]) r3.getSpans(0, r5, ErrorBackgroundSpan.class);     // Catch: Exception -> L40
        Intrinsics.checkNotNullExpressionValue(r7, "existingSpans");     // Catch: Exception -> L40
        int r8 = r7.length;     // Catch: Exception -> L40
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L20;
        ErrorBackgroundSpan r10 = r7[r9];     // Catch: Exception -> L40
        if (r10.getBackgroundColor() != r6) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == true) goto L21;
        r9 = r9 + 1;     // Catch: Exception -> L40
    L21:
        if (r10 != null) goto L23;
        r10 = new ErrorBackgroundSpan(r6);     // Catch: Exception -> L40
    L23:
        int r12 = r7.length;     // Catch: Exception -> L40
        int r14 = 0;
    L24:
        if (r14 >= r12) goto L26;
        r3.removeSpan(r7[r14]);     // Catch: Exception -> L40
        r14 = r14 + 1;     // Catch: Exception -> L40
        goto L24
    L26:
        r3.setSpan(r10, 0, r5, 33);     // Catch: Exception -> L40
        if (r1 < 0) goto L30;
        if (r1 > r5) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == false) goto L38;
        if (r2 < 0) goto L35;
        if (r2 > r5) goto L35;
    L36:
        if (r0 == false) goto L38;
        this.vInput.setSelection(r1, r2);     // Catch: Exception -> L40
    L35:
        r0 = false;
    L38:
        this.vInput.setSelection(r1, r5);     // Catch: Exception -> L40
    L30:
        r4 = false;
        goto L31
    L16:
        r11 = false;
        goto L17
    L20:
        r10 = null;
        goto L21
    L10:
        r6 = 0;
    L40:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, Intrinsics.stringPlus("Error setTextState: ", e));
    L43:
        if (this.isErrorState == r13) goto L49;
        this.isErrorState = r13;
        OEditText r15 = this.vInput;
        if (r13 == false) goto L47;
        int r16 = R.drawable.o_input_cursor_red;
    L48:
        r15.setTextCursorDrawable(r16);
        goto L49
    L47:
        r16 = R.drawable.o_input_cursor_blue;
    L49:
        OTextView r17 = this.vTip;
        Resources r18 = getResources();
        if (r13 == false) goto L52;
        int r19 = R.color.oui_functional_red_6;
    L53:
        r17.setTextColor(r18.getColor(r19));
        OTextView r20 = this.vLimitSingle;
        Resources r21 = getResources();
        if (r13 == false) goto L56;
        int r22 = R.color.oui_functional_red_6;
    L57:
        r20.setTextColor(r21.getColor(r22));
        OTextView r23 = this.vLimitMulti;
        Resources r24 = getResources();
        if (r13 == false) goto L60;
        int r110 = R.color.oui_functional_red_6;
    L61:
        r23.setTextColor(r24.getColor(r110));
        this.isInAutoChanging = false;
        return;
    L60:
        r110 = R.color.oui_basic_text_3b;
        goto L61
    L56:
        r22 = R.color.oui_basic_text_3b;
        goto L57
    L52:
        r19 = R.color.oui_basic_text_3b;
        goto L53
    }

    public final void enableUpdateCursorDrawable() {
        Method r0 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", new Class[0]);     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r0, "TextView::class.java.get…orDrawable\"\n            )");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(this.vInput, new Object[0]);     // Catch: Exception -> L4
        return;
    }
}
