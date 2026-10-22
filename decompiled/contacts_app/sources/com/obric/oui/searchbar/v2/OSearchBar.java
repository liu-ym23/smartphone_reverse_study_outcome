package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.vcard.VCardConstants;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u0004\u0018\u000109J\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u0004\u0018\u00010;J\u0006\u0010=\u001a\u00020>J\u0018\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\rH\u0016J\u0012\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0012\u0010G\u001a\u0004\u0018\u0001092\u0006\u0010H\u001a\u00020\nH\u0002J\u0012\u0010I\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;H\u0016J\u000e\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020\rJ\u0010\u0010M\u001a\u0002042\b\u0010N\u001a\u0004\u0018\u000109J\u0010\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020\rH\u0016J\u000e\u0010Q\u001a\u0002042\u0006\u0010R\u001a\u00020SJ\u0010\u0010T\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;J\u0010\u0010U\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;J\u000e\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020(J\u0010\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020\nH\u0016J\u0010\u0010Z\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010[\u001a\u000204H\u0002J\b\u0010\\\u001a\u000204H\u0002J\u0010\u0010]\u001a\u0002042\u0006\u0010^\u001a\u00020_H\u0002J\u001a\u0010`\u001a\u0002042\u0006\u0010a\u001a\u00020_2\b\b\u0002\u0010b\u001a\u00020\rH\u0002J\b\u0010c\u001a\u000204H\u0002J\u0014\u0010d\u001a\u000204*\u00020;2\u0006\u0010e\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010,\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "originContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgColor", "", "bgColorResting", "canShowClear", "", "clearAction", "Landroid/widget/ImageView;", "clearActionContainer", "Landroid/view/ViewGroup;", "currentMaterials", "", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "currentTheme", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "enabledMaterial", "inputView", "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "isBackdropView", "()Z", "setBackdropView", "(Z)V", "leftContainer", "Landroid/widget/FrameLayout;", "materialSrcType", "materialToken", "", "materialTokenResting", "materialsActive", "materialsResting", "rightContainer", "searchBarContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsResting", "applyContentMaterial", "", "apply", "applyDynamicTheme", "themeStyle", "getEllipsize", "Landroid/text/TextUtils$TruncateAt;", "getPostfixView", "Landroid/view/View;", "getPrefixView", "getText", "", "initShadows", "context", "typedArray", "Landroid/content/res/TypedArray;", "isDarkTheme", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "parseEllipsize", "value", "setBackdropTarget", "view", "setCanShowClear", "show", "setEllipsize", "where", "setEnabled", "enabled", "setOnInputFocusChange", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "setPostfixView", "setPrefixView", "setText", "text", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateClear", "updateInputViewPadding", "updateMaterials", "state", "Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "updateShadows", "currentState", "showShadow", "updateStateInternal", "updateViewWidth", "newWidth", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSearchBar extends OUIFrameLayout implements MaterialOwner, ODynamicThemeWidget {
    public static final Companion Companion = null;
    private static final String TAG = "OSearchBar";
    private int bgColor;
    private int bgColorResting;
    private boolean canShowClear;
    private final ImageView clearAction;
    private final ViewGroup clearActionContainer;
    private MaterialConfig[] currentMaterials;
    private int currentTheme;
    private boolean enabledMaterial;
    private final OEditText inputView;
    private boolean isBackdropView;
    private final FrameLayout leftContainer;
    private int materialSrcType;
    private String materialToken;
    private String materialTokenResting;
    private MaterialConfig[] materialsActive;
    private MaterialConfig[] materialsResting;
    private final FrameLayout rightContainer;
    private OUILinearLayout searchBarContainer;
    private List<Shadow> shadowsNormal;
    private List<Shadow> shadowsResting;

    /* JADX INFO: compiled from: OSearchBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion;", "", "()V", "TAG", "", "SearchBarState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OSearchBar.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "", "(Ljava/lang/String;I)V", "RESTING", "ACTIVE", VCardConstants.PARAM_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum SearchBarState extends Enum<SearchBarState> {
            private static final /* synthetic */ SearchBarState[] $VALUES = null;
            public static final SearchBarState ACTIVE = null;
            public static final SearchBarState RESTING = null;
            public static final SearchBarState VALUE = null;

            private static final /* synthetic */ SearchBarState[] $values() {
                return new SearchBarState[]{RESTING, ACTIVE, VALUE};
            }

            public static SearchBarState valueOf(String r1) {
                return (SearchBarState) Enum.valueOf(SearchBarState.class, r1);
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) $VALUES.clone();
            }

            private SearchBarState(String r1, int r2) {
                super(r1, r2);
            }

            static {
                RESTING = new SearchBarState("RESTING", 0);
                ACTIVE = new SearchBarState("ACTIVE", 1);
                VALUE = new SearchBarState(VCardConstants.PARAM_VALUE, 2);
                $VALUES = $values();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSearchBar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Companion.SearchBarState.values().length];
            r0[Companion.SearchBarState.RESTING.ordinal()] = 1;
            r0[Companion.SearchBarState.ACTIVE.ordinal()] = 2;
            r0[Companion.SearchBarState.VALUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$jhWeaav6reO0PmnK8mg7muNgDp8(OSearchBar r0, View r1) {
        m665lambda4$lambda0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "originContext");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSearchBar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ OUILinearLayout access$getSearchBarContainer$p(OSearchBar r0) {
        return r0.searchBarContainer;
    }

    public static final /* synthetic */ void access$updateClear(OSearchBar r0) {
        r0.updateClear();
    }

    public static final /* synthetic */ void access$updateStateInternal(OSearchBar r0) {
        r0.updateStateInternal();
    }

    public OSearchBar(Context r22, AttributeSet r23) {
        Intrinsics.checkNotNullParameter(r22, "originContext");
        super(r22, r23, 0, null, 12, null);
        this.isBackdropView = true;
        this.canShowClear = true;
        this.materialSrcType = -1;
        FrameLayout.inflate(getContext(), R.layout.o_widget_search_bar_v2, this);
        setChangeAlphaWhenPress(false);
        OSearchBar r3 = this;
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r3) == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.enabledMaterial = r4;
        View r5 = findViewById(R.id.searchbar_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.searchbar_container)");
        this.searchBarContainer = (OUILinearLayout) r5;
        View r6 = findViewById(R.id.input_view);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.input_view)");
        OEditText r7 = (OEditText) r6;
        this.inputView = r7;
        r7.onOnTouchEvent$OUI_standardRelease(new AnonymousClass1(this));
        View r8 = findViewById(R.id.left_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.left_container)");
        FrameLayout r9 = (FrameLayout) r8;
        this.leftContainer = r9;
        View r10 = findViewById(R.id.right_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.right_container)");
        FrameLayout r11 = (FrameLayout) r10;
        this.rightContainer = r11;
        View r12 = findViewById(R.id.clear_action_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.clear_action_container)");
        ViewGroup r13 = (ViewGroup) r12;
        this.clearActionContainer = r13;
        View r14 = findViewById(R.id.clear_action);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.clear_action)");
        ImageView r15 = (ImageView) r14;
        this.clearAction = r15;
        Context r16 = getContext();
        Intrinsics.checkNotNullExpressionValue(r16, "context");
        int[] r17 = R.styleable.OSearchBar;
        Intrinsics.checkNotNullExpressionValue(r17, TAG);
        TypedArray r18 = r16.obtainStyledAttributes(r23, r17, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r18, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        OUILinearLayout r0 = null;
        this.bgColor = r18.getColor(R.styleable.OSearchBar_oui_widgetBgColor, getContext().getResources().getColor(R.color.oui_searchbar_bg, null));
        this.bgColorResting = r18.getColor(R.styleable.OSearchBar_oui_widgetBgColorResting, getContext().getResources().getColor(R.color.oui_searchbar_bg_resting, null));
        getInputView().setTextColor(r18.getColorStateList(R.styleable.OSearchBar_oui_widgetTextColor));
        ColorStateList r19 = r18.getColorStateList(R.styleable.OSearchBar_oui_widgetTextColorHint);
        getInputView().setHintTextColor(r19);
        r15.setImageTintList(r19);
        getInputView().setHint(r18.getString(R.styleable.OSearchBar_android_hint));
        getInputView().setText(r18.getString(R.styleable.OSearchBar_android_text));
        if (r18.hasValue(R.styleable.OSearchBar_android_ellipsize) == false) goto L11;
        setEllipsize(parseEllipsize(r18.getInt(R.styleable.OSearchBar_android_ellipsize, 0)));
    L11:
        int r20 = r18.getLayoutDimension(R.styleable.OSearchBar_android_layout_height, 0);
        if (r20 > 0) goto L14;
        L.e(TAG, Intrinsics.stringPlus("searchBarHeight must be greater than 0, ", Integer.valueOf(r20)));
    L14:
        int r110 = r18.getResourceId(R.styleable.OSearchBar_oui_search_postfixView, 0);
        if (r110 == 0) goto L17;
        FrameLayout.inflate(getContext(), r110, r11);
        ViewExtensionsKt.makeVisible(r11);
    L17:
        int r21 = r18.getResourceId(R.styleable.OSearchBar_oui_search_prefixView, R.layout.o_widget_search_bar_prefix_v2);
        if (r21 == 0) goto L20;
        FrameLayout.inflate(getContext(), r21, r9);
        ViewExtensionsKt.makeVisible(r9);
        updateViewWidth(r9, r20);
    L20:
        updateViewWidth(r13, r20);
        r13.setOnClickListener(new OSearchBar$$ExternalSyntheticLambda0(this));
        Context r24 = getContext();
        Intrinsics.checkNotNullExpressionValue(r24, "context");
        initShadows(r24, r18);
        if (this.enabledMaterial == false) goto L23;
        this.materialSrcType = r18.getInt(R.styleable.OSearchBar_oui_widgetMaterialSrcType, -1);
        this.enabledMaterial = r18.getBoolean(R.styleable.OSearchBar_oui_widgetEnableMaterial, false);
    L23:
        boolean r25 = isDarkTheme();
        if (this.enabledMaterial == false) goto L51;
        String r26 = r18.getString(R.styleable.OSearchBar_oui_widgetMaterial);
        this.materialToken = r26;
        if (r26 != null) goto L28;
        this.materialToken = r18.getResources().getString(R.string.oui_material_bg_floating);
    L28:
        this.materialTokenResting = r18.getString(R.styleable.OSearchBar_oui_widgetMaterialResting);
        this.materialsActive = MaterialToken.parseSet(this.materialToken, !r25);
        String r27 = this.materialTokenResting;
        if (r27 == null) goto L31;
        MaterialConfig[] r28 = MaterialToken.parseSet(r27, !r25);
    L32:
        this.materialsResting = r28;
        if (r28 != null) goto L35;
        r28 = this.materialsActive;
    L35:
        MaterialConfig[] r111 = r28;
        this.currentMaterials = r111;
        if (r111 != null) goto L38;
        Unit r1 = null;
    L49:
        if (r1 != null) goto L51;
        this.enabledMaterial = false;
        goto L51
    L38:
        setBackground(null);
        int r29 = this.materialSrcType;
        if (r29 == (-1)) goto L41;
        int r112 = r29;
    L42:
        OUILinearLayout r2 = this.searchBarContainer;
        if (r2 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r2 = null;
    L45:
        GradientDrawable r30 = new GradientDrawable();
        r30.setShape(0);
        r30.setCornerRadius(OUnitExtensionKt.vdpFloat(r3, 99));
        r30.setColor(0);
        r2.setBackground(r30);
        OUILinearLayout r31 = this.searchBarContainer;
        if (r31 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r31 = null;
    L48:
        OMaterialExtBaseKt.materials$default(r31, r111, false, r112, null, 10, null);
        r1 = Unit.INSTANCE;
        goto L49
    L41:
        r112 = 2;
        goto L42
    L31:
        r28 = null;
    L51:
        r18.recycle();
        if ((!isDarkTheme()) == false) goto L57;
        OUILinearLayout r32 = this.searchBarContainer;
        if (r32 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r32 = null;
    L56:
        r32.setOverridePressColor(getResources().getColor(R.color.oui_basic_fill_element_2_light));
    L61:
        OUILinearLayout r33 = this.searchBarContainer;
        if (r33 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L65:
        r0.refreshColors(TAG);
        r7.onTextChanged$OUI_standardRelease(new AnonymousClass3(this));
        r7.onFocusChange$OUI_standardRelease(new AnonymousClass4(this));
        updateStateInternal();
        updateInputViewPadding();
        return;
    L64:
        r0 = r33;
        goto L65
    L57:
        OUILinearLayout r34 = this.searchBarContainer;
        if (r34 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r34 = null;
    L60:
        r34.setOverridePressColor(getResources().getColor(R.color.oui_basic_fill_element_2_dark));
        goto L61
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        r4 = true;
        goto L8
    }

    public final boolean isBackdropView() {
        return this.isBackdropView;
    }

    public final void setBackdropView(boolean r1) {
        this.isBackdropView = r1;
    }

    public final OEditText getInputView() {
        return this.inputView;
    }

    protected final int getCurrentTheme() {
        return this.currentTheme;
    }

    protected final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        this.inputView.setEnabled(r2);
        super.setEnabled(r2);
    }

    /* JADX INFO: renamed from: lambda-4$lambda-0, reason: not valid java name */
    private static final void m665lambda4$lambda0(OSearchBar r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.inputView.setText("");
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r2) {
        MaterialOwnerKt.applyBackdropMaterial(this, r2, this.isBackdropView);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r1) {
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r1);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L12;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        OUILinearLayout r2 = this.searchBarContainer;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r2 = null;
    L10:
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(r2, r3);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r1) {
        this.materialSrcType = r1;
        OUILinearLayout r0 = this.searchBarContainer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r0 = null;
    L5:
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(r0, r1);
    }

    private final void updateViewWidth(View r1, int r2) {
        if (r2 > 0) goto L5;
        L.e(TAG, Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r2)));
        return;
    L5:
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r2;
        r1.setLayoutParams(r0);
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r9) {
        if (this.currentTheme == r9) goto L16;
        this.currentTheme = r9;
        if (this.enabledMaterial == false) goto L17;
        String r10 = this.materialToken;
        if (r10 == null) goto L18;
        MaterialConfig[] r2 = MaterialToken.parseSet(r10, !isDarkTheme());
        if (r2 == null) goto L19;
        OUILinearLayout r8 = this.searchBarContainer;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r8 = null;
    L14:
        OMaterialExtBaseKt.materials$default(r8, r2, false, 0, null, 14, null);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        if (this.currentTheme != 2) goto L9;
    L12:
        return true;
    L9:
        if (OPalette.isDarkColor(r0) == true) goto L12;
        return false;
    }

    private final void initShadows(Context r7, TypedArray r8) {
        int r0 = r8.getResourceId(R.styleable.OSearchBar_oui_widgetShadowNormal, 0);
        if (r0 == 0) goto L5;
        List<Shadow> r1 = OUILayoutHelper.extractShadowInfo(r7, r0);
        this.shadowsNormal = CollectionsKt.listOf(new Shadow[]{r1.get(0), r1.get(1)});
    L5:
        int r9 = r8.getResourceId(R.styleable.OSearchBar_oui_widgetShadowResting, 0);
        if (r9 == 0) goto L9;
        List<Shadow> r10 = OUILayoutHelper.extractShadowInfo(r7, r9);
        this.shadowsResting = CollectionsKt.listOf(new Shadow[]{r10.get(0), r10.get(1)});
        return;
    }

    static /* synthetic */ void updateShadows$default(OSearchBar r0, Companion.SearchBarState r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.updateShadows(r1, r2);
    }

    private final void updateShadows(Companion.SearchBarState r4, boolean r5) {
        if (this.shadowsNormal != null) goto L6;
        setShadow(Shadow.NONE, Shadow.NONE, false);
        return;
    L6:
        int r0 = OUnitExtensionKt.vdp(this, 99);
        setShadowCornerRadius(r0);
        OUILinearLayout r2 = this.searchBarContainer;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r2 = null;
    L9:
        r2.setRadius(r0);
        if (r5 == true) goto L12;
        setShadow(Shadow.NONE, Shadow.NONE, true);
        return;
    L12:
        if (WhenMappings.$EnumSwitchMapping$0[r4.ordinal()] != 1) goto L17;
        List<Shadow> r6 = this.shadowsResting;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNull(r6);
        Shadow r7 = (Shadow) CollectionsKt.getOrNull(r6, 0);
        List<Shadow> r8 = this.shadowsResting;
        Intrinsics.checkNotNull(r8);
        setShadow(r7, (Shadow) CollectionsKt.getOrNull(r8, 1), true);
        return;
    L16:
        setShadow(Shadow.NONE, Shadow.NONE, true);
        return;
    L17:
        List<Shadow> r9 = this.shadowsNormal;
        Intrinsics.checkNotNull(r9);
        Shadow r10 = (Shadow) CollectionsKt.getOrNull(r9, 0);
        List<Shadow> r11 = this.shadowsNormal;
        Intrinsics.checkNotNull(r11);
        setShadow(r10, (Shadow) CollectionsKt.getOrNull(r11, 1), true);
    }

    private final void updateStateInternal() {
        if (this.inputView.hasFocus() == false) goto L5;
        Companion.SearchBarState r0 = Companion.SearchBarState.ACTIVE;
    L15:
        int r3 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r3 == 1) goto L36;
        if (r3 == 2) goto L29;
        if (r3 == 3) goto L22;
    L42:
        updateMaterials(r0);
        return;
    L22:
        if (this.enabledMaterial == true) goto L27;
        OUILinearLayout r4 = this.searchBarContainer;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r4 = null;
    L26:
        r4.setBackgroundColor(this.bgColor);
    L27:
        this.leftContainer.setSelected(true);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L29:
        if (this.enabledMaterial == true) goto L34;
        OUILinearLayout r5 = this.searchBarContainer;
        if (r5 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r5 = null;
    L33:
        r5.setBackgroundColor(this.bgColor);
    L34:
        this.leftContainer.setSelected(true);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L36:
        if (this.enabledMaterial == true) goto L41;
        OUILinearLayout r1 = this.searchBarContainer;
        if (r1 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r1 = null;
    L40:
        r1.setBackgroundColor(this.bgColorResting);
    L41:
        this.leftContainer.setSelected(false);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L5:
        Editable r2 = this.inputView.getText();
        if (r2 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r0 = Companion.SearchBarState.RESTING;
        goto L15
    L14:
        r0 = Companion.SearchBarState.VALUE;
        goto L15
    L8:
        if (r2.length() == 0) goto L11;
        r6 = false;
        goto L12
    }

    private final void updateMaterials(Companion.SearchBarState r8) {
        if (this.enabledMaterial == true) goto L6;
        return;
    L6:
        if (r8 != Companion.SearchBarState.RESTING) goto L10;
        MaterialConfig[] r9 = this.materialsResting;
        if (r9 != null) goto L11;
        r9 = this.materialsActive;
    L11:
        MaterialConfig[] r1 = r9;
        this.currentMaterials = r1;
        if (r1 == null) goto L23;
        int r10 = this.materialSrcType;
        if (r10 != (-1)) goto L18;
        r10 = 2;
    L18:
        int r3 = r10;
        OUILinearLayout r7 = this.searchBarContainer;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r7 = null;
    L21:
        OMaterialExtBaseKt.materials$default(r7, r1, false, r3, null, 10, null);
        return;
    L23:
        return;
    L10:
        r9 = this.materialsActive;
        goto L11
    }

    private final void updateClear() {
        int r1 = 8;
        boolean r2 = true;
        if (this.canShowClear == true) goto L5;
        this.clearActionContainer.setVisibility(8);
    L16:
        if (this.clearActionContainer.getVisibility() != 0) goto L18;
        boolean r0 = true;
    L19:
        if (r0 == false) goto L22;
        ViewExtensionsKt.makeGone(this.rightContainer);
    L27:
        updateInputViewPadding();
        return;
    L22:
        if (this.rightContainer.getChildCount() != 0) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        ViewExtensionsKt.makeVisible(this.rightContainer);
        goto L27
    L18:
        r0 = false;
        goto L19
    L5:
        ViewGroup r3 = this.clearActionContainer;
        Editable r4 = this.inputView.getText();
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        r1 = 0;
    L14:
        r3.setVisibility(r1);
        goto L16
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    private final void updateInputViewPadding() {
        if (this.leftContainer.getVisibility() != 0) goto L5;
        int r0 = 0;
    L6:
        boolean r3 = true;
        if (this.clearActionContainer.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L18:
        int r4 = OUnitExtensionKt.vdp(this, 0);
    L19:
        this.inputView.setPaddingRelative(r0, 0, r4, 0);
        return;
    L12:
        if (this.rightContainer.getVisibility() == 0) goto L15;
        r3 = false;
    L15:
        if (r3 == true) goto L18;
        r4 = OUnitExtensionKt.vdp(this, 8);
        goto L19
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = OUnitExtensionKt.vdp(this, 12);
        goto L6
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.inputView.setText(r2);
    }

    public final CharSequence getText() {
        CharSequence r0 = this.inputView.getText();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return r0;
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.inputView.setEllipsize(r1);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.inputView.getEllipsize();
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r2);
    }

    public final View getPrefixView() {
        if (this.leftContainer.getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.leftContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final View getPostfixView() {
        if (this.rightContainer.getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.rightContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final void setPrefixView(View r2) {
        this.leftContainer.removeAllViews();
        if (r2 != null) goto L5;
        ViewExtensionsKt.makeGone(this.leftContainer);
    L6:
        updateInputViewPadding();
        return;
    L5:
        r2.setDuplicateParentStateEnabled(true);
        this.leftContainer.addView(r2);
        ViewExtensionsKt.makeVisible(this.leftContainer);
        goto L6
    }

    public final void setPostfixView(View r2) {
        this.rightContainer.removeAllViews();
        if (r2 != null) goto L5;
        ViewExtensionsKt.makeGone(this.rightContainer);
    L6:
        updateInputViewPadding();
        return;
    L5:
        this.rightContainer.addView(r2);
        ViewExtensionsKt.makeVisible(this.rightContainer);
        goto L6
    }

    public final void setCanShowClear(boolean r1) {
        this.canShowClear = r1;
        updateClear();
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

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        OSearchBar r0 = this;
        this.materialsActive = MaterialToken.parseSet(this.materialToken, !ViewUtilKt.isDarkMode(r0));
        String r4 = this.materialTokenResting;
        if (r4 == null) goto L5;
        MaterialConfig[] r5 = MaterialToken.parseSet(r4, !ViewUtilKt.isDarkMode(r0));
    L6:
        this.materialsResting = r5;
        updateStateInternal();
        return;
    L5:
        r5 = null;
        goto L6
    }
}
