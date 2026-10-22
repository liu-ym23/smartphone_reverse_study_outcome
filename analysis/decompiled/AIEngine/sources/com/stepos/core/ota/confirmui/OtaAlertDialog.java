package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaAlertDialog {
    private static final int BOTTOM_MARGIN_DP = 18;
    private static final int BUTTON_FONT_WEIGHT = 500;
    private static final int BUTTON_GAP_DP = 12;
    private static final int BUTTON_HEIGHT_DP = 48;
    private static final float BUTTON_TEXT_SP = 17.0f;
    private static final Companion Companion = new Companion(null);
    private static final float DIM_AMOUNT = 0.4f;
    private static final int LANDSCAPE_MAX_WIDTH_DP = 360;
    private static final float MESSAGE_MAX_HEIGHT_RATIO = 0.5f;
    private static final int SIDE_MARGIN_DP = 18;
    private ComponentCallbacks2 configCallbacks;
    private final Context context;
    private final Dialog dialog;
    private boolean landscapeMode;
    private final MaxHeightScrollView messageScroll;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Builder {
        private final ArrayList<ButtonSpec> buttons;
        private boolean buttonsHorizontal;
        private boolean cancelable;
        private final Context context;
        private CharSequence message;
        private CharSequence title;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ButtonStyle.values().length];
                try {
                    iArr[ButtonStyle.EMPHASIZED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStyle.NORMAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStyle.DESTRUCTIVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Builder(Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            this.context = context;
            this.cancelable = true;
            this.buttons = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void create$lambda$10$lambda$9(OtaAlertDialog otaAlertDialog, Builder builder, int i10, View view) {
            otaAlertDialog.dismiss();
            builder.buttons.get(i10).getOnClick().invoke();
        }

        private final TextView createButton(ButtonSpec buttonSpec, boolean z) {
            TextView textView = new TextView(this.context);
            textView.setLayoutParams(z ? new LinearLayout.LayoutParams(0, dp(48), 1.0f) : new LinearLayout.LayoutParams(-1, dp(48)));
            textView.setGravity(17);
            textView.setText(buttonSpec.getText());
            textView.setTextSize(2, OtaAlertDialog.BUTTON_TEXT_SP);
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
            textView.setClickable(true);
            textView.setFocusable(true);
            int i10 = WhenMappings.$EnumSwitchMapping$0[buttonSpec.getStyle().ordinal()];
            if (i10 == 1) {
                textView.setBackgroundResource(R.drawable.ocu_btn_emphasized);
                textView.setTextColor(this.context.getColor(R.color.ocu_btn_emphasized_text));
                return textView;
            }
            if (i10 == 2) {
                textView.setBackgroundResource(R.drawable.ocu_btn_normal);
                textView.setTextColor(this.context.getColor(R.color.ocu_btn_normal_text));
                return textView;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            textView.setBackgroundResource(R.drawable.ocu_btn_destructive);
            textView.setTextColor(this.context.getColor(R.color.ocu_btn_destructive_text));
            return textView;
        }

        private final int dp(int i10) {
            return (int) (i10 * this.context.getResources().getDisplayMetrics().density);
        }

        public final Builder addButton(CharSequence text, ButtonStyle style, zb.a<lb.n> onClick) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(style, "style");
            kotlin.jvm.internal.g.f(onClick, "onClick");
            this.buttons.add(new ButtonSpec(text, style, onClick));
            return this;
        }

        public final OtaAlertDialog create() {
            kotlin.jvm.internal.e eVar = null;
            View viewInflate = LayoutInflater.from(this.context.getApplicationContext()).cloneInContext(this.context).inflate(R.layout.ocu_alert_dialog, (ViewGroup) null);
            kotlin.jvm.internal.g.d(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            ((TextView) viewGroup.findViewById(R.id.ocu_title)).setText(this.title);
            MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) viewGroup.findViewById(R.id.ocu_message_scroll);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ocu_message);
            CharSequence charSequence = this.message;
            final int i10 = 0;
            if (charSequence == null || charSequence.length() == 0) {
                maxHeightScrollView.setVisibility(8);
            } else {
                maxHeightScrollView.setVisibility(0);
                textView.setText(this.message);
            }
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.ocu_button_container);
            linearLayout.setOrientation(!this.buttonsHorizontal ? 1 : 0);
            ArrayList<ButtonSpec> arrayList = this.buttons;
            ArrayList arrayList2 = new ArrayList(mb.m.Z(arrayList, 10));
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                ButtonSpec buttonSpec = arrayList.get(i11);
                i11++;
                arrayList2.add(createButton(buttonSpec, this.buttonsHorizontal));
            }
            int size2 = arrayList2.size();
            int i12 = 0;
            int i13 = 0;
            while (i13 < size2) {
                Object obj = arrayList2.get(i13);
                i13++;
                int i14 = i12 + 1;
                if (i12 < 0) {
                    mb.m.f0();
                    throw null;
                }
                TextView textView2 = (TextView) obj;
                if (i12 > 0) {
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    kotlin.jvm.internal.g.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    if (this.buttonsHorizontal) {
                        layoutParams2.setMarginStart(dp(12));
                    } else {
                        layoutParams2.topMargin = dp(12);
                    }
                }
                linearLayout.addView(textView2);
                i12 = i14;
            }
            Dialog dialog = new Dialog(this.context);
            dialog.requestWindowFeature(1);
            dialog.setContentView(viewGroup, new ViewGroup.LayoutParams(-1, -2));
            dialog.setCancelable(this.cancelable);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.addFlags(2);
                window.setDimAmount(OtaAlertDialog.DIM_AMOUNT);
            }
            Context context = this.context;
            kotlin.jvm.internal.g.c(maxHeightScrollView);
            final OtaAlertDialog otaAlertDialog = new OtaAlertDialog(dialog, context, maxHeightScrollView, eVar);
            int size3 = arrayList2.size();
            int i15 = 0;
            while (i15 < size3) {
                Object obj2 = arrayList2.get(i15);
                i15++;
                int i16 = i10 + 1;
                if (i10 < 0) {
                    mb.m.f0();
                    throw null;
                }
                ((TextView) obj2).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.core.ota.confirmui.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OtaAlertDialog.Builder.create$lambda$10$lambda$9(otaAlertDialog, this, i10, view);
                    }
                });
                i10 = i16;
            }
            return otaAlertDialog;
        }

        public final Builder setButtonsHorizontal(boolean z) {
            this.buttonsHorizontal = z;
            return this;
        }

        public final Builder setCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public final Builder setMessage(CharSequence charSequence) {
            this.message = charSequence;
            return this;
        }

        public final Builder setTitle(CharSequence charSequence) {
            this.title = charSequence;
            return this;
        }

        public final OtaAlertDialog show() {
            OtaAlertDialog otaAlertDialogCreate = create();
            otaAlertDialogCreate.show();
            return otaAlertDialogCreate;
        }

        public final Builder addButton(int i10, ButtonStyle style, zb.a<lb.n> onClick) {
            kotlin.jvm.internal.g.f(style, "style");
            kotlin.jvm.internal.g.f(onClick, "onClick");
            String string = this.context.getString(i10);
            kotlin.jvm.internal.g.e(string, "getString(...)");
            return addButton(string, style, onClick);
        }

        public final Builder setTitle(int i10) {
            this.title = this.context.getString(i10);
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ButtonSpec {
        private final zb.a<lb.n> onClick;
        private final ButtonStyle style;
        private final CharSequence text;

        public ButtonSpec(CharSequence text, ButtonStyle style, zb.a<lb.n> onClick) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(style, "style");
            kotlin.jvm.internal.g.f(onClick, "onClick");
            this.text = text;
            this.style = style;
            this.onClick = onClick;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ButtonSpec copy$default(ButtonSpec buttonSpec, CharSequence charSequence, ButtonStyle buttonStyle, zb.a aVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charSequence = buttonSpec.text;
            }
            if ((i10 & 2) != 0) {
                buttonStyle = buttonSpec.style;
            }
            if ((i10 & 4) != 0) {
                aVar = buttonSpec.onClick;
            }
            return buttonSpec.copy(charSequence, buttonStyle, aVar);
        }

        public final CharSequence component1() {
            return this.text;
        }

        public final ButtonStyle component2() {
            return this.style;
        }

        public final zb.a<lb.n> component3() {
            return this.onClick;
        }

        public final ButtonSpec copy(CharSequence text, ButtonStyle style, zb.a<lb.n> onClick) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(style, "style");
            kotlin.jvm.internal.g.f(onClick, "onClick");
            return new ButtonSpec(text, style, onClick);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ButtonSpec)) {
                return false;
            }
            ButtonSpec buttonSpec = (ButtonSpec) obj;
            return kotlin.jvm.internal.g.b(this.text, buttonSpec.text) && this.style == buttonSpec.style && kotlin.jvm.internal.g.b(this.onClick, buttonSpec.onClick);
        }

        public final zb.a<lb.n> getOnClick() {
            return this.onClick;
        }

        public final ButtonStyle getStyle() {
            return this.style;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public int hashCode() {
            return this.onClick.hashCode() + ((this.style.hashCode() + (this.text.hashCode() * 31)) * 31);
        }

        public String toString() {
            CharSequence charSequence = this.text;
            return "ButtonSpec(text=" + ((Object) charSequence) + ", style=" + this.style + ", onClick=" + this.onClick + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ButtonStyle {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ ButtonStyle[] $VALUES;
        public static final ButtonStyle EMPHASIZED = new ButtonStyle("EMPHASIZED", 0);
        public static final ButtonStyle NORMAL = new ButtonStyle("NORMAL", 1);
        public static final ButtonStyle DESTRUCTIVE = new ButtonStyle("DESTRUCTIVE", 2);

        private static final /* synthetic */ ButtonStyle[] $values() {
            return new ButtonStyle[]{EMPHASIZED, NORMAL, DESTRUCTIVE};
        }

        static {
            ButtonStyle[] buttonStyleArr$values = $values();
            $VALUES = buttonStyleArr$values;
            $ENTRIES = kotlin.enums.a.a(buttonStyleArr$values);
        }

        private ButtonStyle(String str, int i10) {
        }

        public static sb.a<ButtonStyle> getEntries() {
            return $ENTRIES;
        }

        public static ButtonStyle valueOf(String str) {
            return (ButtonStyle) Enum.valueOf(ButtonStyle.class, str);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ OtaAlertDialog(Dialog dialog, Context context, MaxHeightScrollView maxHeightScrollView, kotlin.jvm.internal.e eVar) {
        this(dialog, context, maxHeightScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets _init_$lambda$0(OtaAlertDialog otaAlertDialog, View view, WindowInsets insets) {
        kotlin.jvm.internal.g.f(view, "<unused var>");
        kotlin.jvm.internal.g.f(insets, "insets");
        int iDp = !otaAlertDialog.landscapeMode ? otaAlertDialog.dp(18) + insets.getInsets(WindowInsets.Type.navigationBars()).bottom : 0;
        Window window = otaAlertDialog.dialog.getWindow();
        if (window != null && window.getAttributes().y != iDp) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = iDp;
            window.setAttributes(attributes);
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyOrientationGeometry(Configuration configuration) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        float f8 = configuration.densityDpi / 160.0f;
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        int i10 = configuration.screenWidthDp;
        int i11 = i10 > 0 ? (int) ((i10 * f8) + 0.5f) : displayMetrics.widthPixels;
        int i12 = configuration.screenHeightDp;
        int i13 = i12 > 0 ? (int) ((i12 * f8) + 0.5f) : displayMetrics.heightPixels;
        boolean z = configuration.orientation == 2;
        this.landscapeMode = z;
        if (z) {
            window.setLayout(Math.min(i11 - (dp(18) * 2), dp(LANDSCAPE_MAX_WIDTH_DP)), -2);
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            window.setAttributes(attributes);
        } else {
            window.setLayout(i11 - (dp(18) * 2), -2);
            window.setGravity(81);
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.y = dp(18);
            window.setAttributes(attributes2);
        }
        this.messageScroll.setMaxHeightPx((int) (i13 * 0.5f));
        this.messageScroll.requestLayout();
    }

    private final int dp(int i10) {
        return (int) (i10 * this.context.getResources().getDisplayMetrics().density);
    }

    private final void registerConfigWatcher() {
        if (this.configCallbacks != null) {
            return;
        }
        ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.stepos.core.ota.confirmui.OtaAlertDialog$registerConfigWatcher$callbacks$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                kotlin.jvm.internal.g.f(newConfig, "newConfig");
                Context context = this.this$0.context;
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null && activity.isDestroyed()) {
                    this.this$0.unregisterConfigWatcher();
                    return;
                }
                if (this.this$0.dialog.isShowing()) {
                    try {
                        this.this$0.applyOrientationGeometry(newConfig);
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i10) {
            }
        };
        this.context.getApplicationContext().registerComponentCallbacks(componentCallbacks2);
        this.configCallbacks = componentCallbacks2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterConfigWatcher() {
        ComponentCallbacks2 componentCallbacks2 = this.configCallbacks;
        if (componentCallbacks2 != null) {
            this.context.getApplicationContext().unregisterComponentCallbacks(componentCallbacks2);
        }
        this.configCallbacks = null;
    }

    public final void dismiss() {
        unregisterConfigWatcher();
        this.dialog.dismiss();
    }

    public final boolean isShowing() {
        return this.dialog.isShowing();
    }

    public final void show() {
        if (this.dialog.isShowing()) {
            return;
        }
        this.dialog.show();
        registerConfigWatcher();
    }

    private OtaAlertDialog(Dialog dialog, Context context, MaxHeightScrollView maxHeightScrollView) {
        View decorView;
        this.dialog = dialog;
        this.context = context;
        this.messageScroll = maxHeightScrollView;
        Configuration configuration = context.getResources().getConfiguration();
        kotlin.jvm.internal.g.e(configuration, "getConfiguration(...)");
        applyOrientationGeometry(configuration);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.stepos.core.ota.confirmui.p
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return OtaAlertDialog._init_$lambda$0(this.f7524a, view, windowInsets);
                }
            });
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.core.ota.confirmui.q
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f7525a.unregisterConfigWatcher();
            }
        });
    }
}
