package com.stepos.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.widget.R;
import com.stepos.widget.dialog.StepOSAlertDialog;
import com.stepos.widget.dialog.StepOSShowAtBottomAlertDialog;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B\u001b\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog;", "Lcom/stepos/widget/dialog/StepOSAlertDialog;", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "", "isContinue", "LY8/t;", "setContinueShowBottomDialog", "(Z)V", "color", "setNavigationBarColor", "(I)V", "Builder", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSShowAtBottomAlertDialog extends StepOSAlertDialog {

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001=B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007H\u0017J\u0012\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\u0017J\u0012\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0007H\u0016J$\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J1\u0010\u001a\u001a\u00020\u00002\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010!J.\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\"H\u0016J;\u0010\u001a\u001a\u00020\u00002\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J9\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010 H\u0016¢\u0006\u0002\u0010%JA\u0010\u001a\u001a\u00020\u00002\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010 H\u0016¢\u0006\u0002\u0010&JF\u0010'\u001a\u00020\u000022\u0010\u001f\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)\u0018\u00010(j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)\u0018\u0001`+2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J)\u0010'\u001a\u00020\u00002\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001eH\u0016JB\u0010/\u001a\u00020\u00002\b\b\u0001\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\n2\b\b\u0001\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016JB\u0010/\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u00162\b\u00101\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010\u00162\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u00107\u001a\u00020\u00002\b\b\u0001\u00108\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u00107\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "negativeButtonText", "", "negativeButtonListener", "Landroid/content/DialogInterface$OnClickListener;", "setNightModeColor", "color", "setNavigationBarColor", "setTitle", "titleId", "title", "setIconBadge", "resId", "icon", "Landroid/graphics/drawable/Drawable;", "setTitleMaxLines", "maxLines", "setMessageMaxLines", "setItems", "itemsId", "listener", "isCenter", "", DidiCardProvider.KEY_ITEMS, "", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Z)Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "Landroid/content/res/ColorStateList;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;ZLandroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "colors", "(ILandroid/content/DialogInterface$OnClickListener;Z[Landroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Z[Landroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "setListItems", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "", "Lkotlin/collections/ArrayList;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder;", "setListItemsScrollbarEnabled", x5.d.EXTRA_ENABLED, "setIconContent", "leftIconRes", "leftLabel", "rightIconRes", "rightLabel", "selectedIndex", "leftIcon", "rightIcon", "setNegativeButton", "textId", "text", "create", "Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog;", "show", "DismissAfter", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Builder extends StepOSAlertDialog.Builder {
        private DialogInterface.OnClickListener negativeButtonListener;
        private CharSequence negativeButtonText;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/widget/dialog/StepOSShowAtBottomAlertDialog$Builder$DismissAfter;", "Landroid/content/DialogInterface$OnClickListener;", "delegate", "<init>", "(Landroid/content/DialogInterface$OnClickListener;)V", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "which", "LY8/t;", "onClick", "(Landroid/content/DialogInterface;I)V", "Landroid/content/DialogInterface$OnClickListener;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DismissAfter implements DialogInterface.OnClickListener {
            private final DialogInterface.OnClickListener delegate;

            public DismissAfter(DialogInterface.OnClickListener onClickListener) {
                this.delegate = onClickListener;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DialogInterface.OnClickListener onClickListener = this.delegate;
                if (onClickListener != null) {
                    onClickListener.onClick(dialog, which);
                }
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context, 0, 2, null);
            kotlin.jvm.internal.p.i(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StepOSShowAtBottomAlertDialog create$lambda$19(Context context, int i10) {
            kotlin.jvm.internal.p.i(context, "context");
            return new StepOSShowAtBottomAlertDialog(context, i10);
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public /* bridge */ /* synthetic */ StepOSAlertDialog.Builder setListItems(ArrayList arrayList, DialogInterface.OnClickListener onClickListener) {
            return setListItems((ArrayList<Pair<String, String>>) arrayList, onClickListener);
        }

        public Builder setNavigationBarColor(int color) {
            return this;
        }

        public Builder setNightModeColor(int color) {
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context, int i10) {
            super(context, i10);
            kotlin.jvm.internal.p.i(context, "context");
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public StepOSShowAtBottomAlertDialog create() {
            CharSequence text = this.negativeButtonText;
            if (text == null) {
                text = getContext().getText(R.string.stepos_dialog_cancel);
                kotlin.jvm.internal.p.h(text, "getText(...)");
            }
            super.setNegativeButton(text, (DialogInterface.OnClickListener) new DismissAfter(this.negativeButtonListener));
            return (StepOSShowAtBottomAlertDialog) create(new StepOSAlertDialog.Builder.DialogFactory() { // from class: com.stepos.widget.dialog.p
                @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder.DialogFactory
                public final StepOSAlertDialog newDialog(Context context, int i10) {
                    return StepOSShowAtBottomAlertDialog.Builder.create$lambda$19(context, i10);
                }
            });
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setListItemsScrollbarEnabled(boolean enabled) {
            super.setListItemsScrollbarEnabled(enabled);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setMessageMaxLines(int maxLines) {
            super.setMessageMaxLines(maxLines);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setTitleMaxLines(int maxLines) {
            super.setTitleMaxLines(maxLines);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public StepOSShowAtBottomAlertDialog show() {
            StepOSShowAtBottomAlertDialog stepOSShowAtBottomAlertDialogCreate = create();
            stepOSShowAtBottomAlertDialogCreate.show();
            return stepOSShowAtBottomAlertDialogCreate;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setIconBadge(int resId) {
            super.setIconBadge(resId);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setIconContent(int leftIconRes, CharSequence leftLabel, int rightIconRes, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) {
            super.setIconContent(leftIconRes, leftLabel, rightIconRes, rightLabel, selectedIndex, listener);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setListItems(ArrayList<Pair<String, String>> items, DialogInterface.OnClickListener listener) {
            super.setListItems(items, listener);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            super.setNegativeButton(textId, listener);
            this.negativeButtonText = getContext().getText(textId);
            this.negativeButtonListener = listener;
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setTitle(int titleId) {
            super.setTitle(titleId);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setIconBadge(Drawable icon) {
            super.setIconBadge(icon);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setIconContent(Drawable leftIcon, CharSequence leftLabel, Drawable rightIcon, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) {
            super.setIconContent(leftIcon, leftLabel, rightIcon, rightLabel, selectedIndex, listener);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setListItems(CharSequence[] items, DialogInterface.OnClickListener listener) {
            super.setListItems(items, listener);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setTitle(CharSequence title) {
            super.setTitle(title);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
            super.setNegativeButton(text, listener);
            this.negativeButtonText = text;
            this.negativeButtonListener = listener;
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter) {
            super.setItems(itemsId, listener, isCenter);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter) {
            super.setItems(items, listener, isCenter);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList color) {
            super.setItems(itemsId, listener, isCenter, color);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList color) {
            super.setItems(items, listener, isCenter, color);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList[] colors) {
            super.setItems(itemsId, listener, isCenter, colors);
            return this;
        }

        @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder
        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList[] colors) {
            super.setItems(items, listener, isCenter, colors);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSShowAtBottomAlertDialog(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public void setContinueShowBottomDialog(boolean isContinue) {
    }

    public void setNavigationBarColor(int color) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSShowAtBottomAlertDialog(Context context) {
        this(context, 0);
        kotlin.jvm.internal.p.i(context, "context");
    }
}
