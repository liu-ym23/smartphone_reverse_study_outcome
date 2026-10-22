package com.stepos.core.ota.confirmui;

import Z8.C1173v;
import Z8.C1174w;
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
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0004$%&#B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\fJ\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", "", "Landroid/app/Dialog;", C3081a.FOCUS_DIALOG_NAME, "Landroid/content/Context;", "context", "Lcom/stepos/core/ota/confirmui/MaxHeightScrollView;", "messageScroll", "<init>", "(Landroid/app/Dialog;Landroid/content/Context;Lcom/stepos/core/ota/confirmui/MaxHeightScrollView;)V", "LY8/t;", "registerConfigWatcher", "()V", "unregisterConfigWatcher", "Landroid/content/res/Configuration;", "config", "applyOrientationGeometry", "(Landroid/content/res/Configuration;)V", "", UxipConstants.f30680s, "dp", "(I)I", "show", DidiCardProvider.ACTION_DISMISS, "Landroid/app/Dialog;", "Landroid/content/Context;", "Lcom/stepos/core/ota/confirmui/MaxHeightScrollView;", "Landroid/content/ComponentCallbacks2;", "configCallbacks", "Landroid/content/ComponentCallbacks2;", "", "landscapeMode", "Z", "isShowing", "()Z", "Companion", "ButtonStyle", "ButtonSpec", "Builder", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001aJ+\u0010!\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b!\u0010\"J+\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b!\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020%¢\u0006\u0004\b(\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010-R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00060/j\b\u0012\u0004\u0012\u00020\u0006`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonSpec;", "spec", "", "horizontal", "Landroid/widget/TextView;", "createButton", "(Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonSpec;Z)Landroid/widget/TextView;", "", UxipConstants.f30680s, "dp", "(I)I", "", "text", "setTitle", "(Ljava/lang/CharSequence;)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "resId", "(I)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "setMessage", "cancelable", "setCancelable", "(Z)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "setButtonsHorizontal", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;", "style", "Lkotlin/Function0;", "LY8/t;", "onClick", "addButton", "(Ljava/lang/CharSequence;Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;Lp9/a;)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "textResId", "(ILcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;Lp9/a;)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", "create", "()Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", "show", "Landroid/content/Context;", "title", "Ljava/lang/CharSequence;", "message", "Z", "buttonsHorizontal", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buttons", "Ljava/util/ArrayList;", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final ArrayList<ButtonSpec> buttons;
        private boolean buttonsHorizontal;
        private boolean cancelable;
        private final Context context;
        private CharSequence message;
        private CharSequence title;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
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
            kotlin.jvm.internal.p.i(context, "context");
            this.context = context;
            this.cancelable = true;
            this.buttons = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void create$lambda$10$lambda$9(OtaAlertDialog otaAlertDialog, Builder builder, int i10, View view) {
            otaAlertDialog.dismiss();
            builder.buttons.get(i10).getOnClick().invoke();
        }

        private final TextView createButton(ButtonSpec spec, boolean horizontal) {
            TextView textView = new TextView(this.context);
            textView.setLayoutParams(horizontal ? new LinearLayout.LayoutParams(0, dp(48), 1.0f) : new LinearLayout.LayoutParams(-1, dp(48)));
            textView.setGravity(17);
            textView.setText(spec.getText());
            textView.setTextSize(2, OtaAlertDialog.BUTTON_TEXT_SP);
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
            textView.setClickable(true);
            textView.setFocusable(true);
            int i10 = WhenMappings.$EnumSwitchMapping$0[spec.getStyle().ordinal()];
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

        private final int dp(int value) {
            return (int) (value * this.context.getResources().getDisplayMetrics().density);
        }

        public final Builder addButton(CharSequence text, ButtonStyle style, InterfaceC5063a<Y8.t> onClick) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(style, "style");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            this.buttons.add(new ButtonSpec(text, style, onClick));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final OtaAlertDialog create() {
            kotlin.jvm.internal.i iVar = null;
            View viewInflate = LayoutInflater.from(this.context.getApplicationContext()).cloneInContext(this.context).inflate(R.layout.ocu_alert_dialog, (ViewGroup) null);
            kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            ((TextView) viewGroup.findViewById(R.id.ocu_title)).setText(this.title);
            MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) viewGroup.findViewById(R.id.ocu_message_scroll);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ocu_message);
            CharSequence charSequence = this.message;
            final int i10 = 0;
            if ((charSequence == null || charSequence.length() == 0) == true) {
                maxHeightScrollView.setVisibility(8);
            } else {
                maxHeightScrollView.setVisibility(0);
                textView.setText(this.message);
            }
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.ocu_button_container);
            linearLayout.setOrientation(!this.buttonsHorizontal ? 1 : 0);
            ArrayList<ButtonSpec> arrayList = this.buttons;
            ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(createButton((ButtonSpec) it.next(), this.buttonsHorizontal));
            }
            int i11 = 0;
            for (Object obj : arrayList2) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    C1173v.w();
                }
                TextView textView2 = (TextView) obj;
                if (i11 > 0) {
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    if (this.buttonsHorizontal) {
                        layoutParams2.setMarginStart(dp(12));
                    } else {
                        layoutParams2.topMargin = dp(12);
                    }
                }
                linearLayout.addView(textView2);
                i11 = i12;
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
                window.setDimAmount(0.4f);
            }
            Context context = this.context;
            kotlin.jvm.internal.p.f(maxHeightScrollView);
            final OtaAlertDialog otaAlertDialog = new OtaAlertDialog(dialog, context, maxHeightScrollView, iVar);
            for (Object obj2 : arrayList2) {
                int i13 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                ((TextView) obj2).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.core.ota.confirmui.T
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OtaAlertDialog.Builder.create$lambda$10$lambda$9(otaAlertDialog, this, i10, view);
                    }
                });
                i10 = i13;
            }
            return otaAlertDialog;
        }

        public final Builder setButtonsHorizontal(boolean horizontal) {
            this.buttonsHorizontal = horizontal;
            return this;
        }

        public final Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public final Builder setMessage(CharSequence text) {
            this.message = text;
            return this;
        }

        public final Builder setTitle(CharSequence text) {
            this.title = text;
            return this;
        }

        public final OtaAlertDialog show() {
            OtaAlertDialog otaAlertDialogCreate = create();
            otaAlertDialogCreate.show();
            return otaAlertDialogCreate;
        }

        public final Builder addButton(int textResId, ButtonStyle style, InterfaceC5063a<Y8.t> onClick) {
            kotlin.jvm.internal.p.i(style, "style");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            String string = this.context.getString(textResId);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return addButton(string, style, onClick);
        }

        public final Builder setTitle(int resId) {
            this.title = this.context.getString(resId);
            return this;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonSpec;", "", "", "text", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;", "style", "Lkotlin/Function0;", "LY8/t;", "onClick", "<init>", "(Ljava/lang/CharSequence;Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;Lp9/a;)V", "component1", "()Ljava/lang/CharSequence;", "component2", "()Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;", "component3", "()Lp9/a;", ChatTracker.CLICK_COPY, "(Ljava/lang/CharSequence;Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;Lp9/a;)Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonSpec;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getText", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;", "getStyle", "Lp9/a;", "getOnClick", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ButtonSpec {
        private final InterfaceC5063a<Y8.t> onClick;
        private final ButtonStyle style;
        private final CharSequence text;

        public ButtonSpec(CharSequence text, ButtonStyle style, InterfaceC5063a<Y8.t> onClick) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(style, "style");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            this.text = text;
            this.style = style;
            this.onClick = onClick;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ButtonSpec copy$default(ButtonSpec buttonSpec, CharSequence charSequence, ButtonStyle buttonStyle, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charSequence = buttonSpec.text;
            }
            if ((i10 & 2) != 0) {
                buttonStyle = buttonSpec.style;
            }
            if ((i10 & 4) != 0) {
                interfaceC5063a = buttonSpec.onClick;
            }
            return buttonSpec.copy(charSequence, buttonStyle, interfaceC5063a);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final ButtonStyle getStyle() {
            return this.style;
        }

        public final InterfaceC5063a<Y8.t> component3() {
            return this.onClick;
        }

        public final ButtonSpec copy(CharSequence text, ButtonStyle style, InterfaceC5063a<Y8.t> onClick) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(style, "style");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            return new ButtonSpec(text, style, onClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ButtonSpec)) {
                return false;
            }
            ButtonSpec buttonSpec = (ButtonSpec) other;
            return kotlin.jvm.internal.p.d(this.text, buttonSpec.text) && this.style == buttonSpec.style && kotlin.jvm.internal.p.d(this.onClick, buttonSpec.onClick);
        }

        public final InterfaceC5063a<Y8.t> getOnClick() {
            return this.onClick;
        }

        public final ButtonStyle getStyle() {
            return this.style;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.onClick.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.text;
            return "ButtonSpec(text=" + ((Object) charSequence) + ", style=" + this.style + ", onClick=" + this.onClick + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaAlertDialog$ButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "EMPHASIZED", "NORMAL", "DESTRUCTIVE", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ButtonStyle {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

        public static InterfaceC4149a<ButtonStyle> getEntries() {
            return $ENTRIES;
        }

        public static ButtonStyle valueOf(String str) {
            return (ButtonStyle) Enum.valueOf(ButtonStyle.class, str);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Companion;", "", "<init>", "()V", "DIM_AMOUNT", "", "SIDE_MARGIN_DP", "", "BOTTOM_MARGIN_DP", "LANDSCAPE_MAX_WIDTH_DP", "MESSAGE_MAX_HEIGHT_RATIO", "BUTTON_HEIGHT_DP", "BUTTON_GAP_DP", "BUTTON_TEXT_SP", "BUTTON_FONT_WEIGHT", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ OtaAlertDialog(Dialog dialog, Context context, MaxHeightScrollView maxHeightScrollView, kotlin.jvm.internal.i iVar) {
        this(dialog, context, maxHeightScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets _init_$lambda$0(OtaAlertDialog otaAlertDialog, View view, WindowInsets insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
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
    public final void applyOrientationGeometry(Configuration config) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        float f10 = config.densityDpi / 160.0f;
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        int i10 = config.screenWidthDp;
        int i11 = i10 > 0 ? (int) ((i10 * f10) + 0.5f) : displayMetrics.widthPixels;
        int i12 = config.screenHeightDp;
        int i13 = i12 > 0 ? (int) ((i12 * f10) + 0.5f) : displayMetrics.heightPixels;
        boolean z10 = config.orientation == 2;
        this.landscapeMode = z10;
        if (z10) {
            window.setLayout(Math.min(i11 - (dp(18) * 2), dp(360)), -2);
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

    private final int dp(int value) {
        return (int) (value * this.context.getResources().getDisplayMetrics().density);
    }

    private final void registerConfigWatcher() {
        if (this.configCallbacks != null) {
            return;
        }
        ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.stepos.core.ota.confirmui.OtaAlertDialog$registerConfigWatcher$callbacks$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                kotlin.jvm.internal.p.i(newConfig, "newConfig");
                Context context = this.this$0.context;
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null && activity.isDestroyed()) {
                    this.this$0.unregisterConfigWatcher();
                    return;
                }
                if (this.this$0.dialog.isShowing()) {
                    OtaAlertDialog otaAlertDialog = this.this$0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        otaAlertDialog.applyOrientationGeometry(newConfig);
                        Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.b(C4849c.a(th));
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int level) {
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
        kotlin.jvm.internal.p.h(configuration, "getConfiguration(...)");
        applyOrientationGeometry(configuration);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.stepos.core.ota.confirmui.Q
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return OtaAlertDialog._init_$lambda$0(this.f29556a, view, windowInsets);
                }
            });
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.core.ota.confirmui.S
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f29557a.unregisterConfigWatcher();
            }
        });
    }
}
