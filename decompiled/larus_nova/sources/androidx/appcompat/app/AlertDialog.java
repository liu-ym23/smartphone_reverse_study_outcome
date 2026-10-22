package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes2.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public AlertDialog create() {
            AlertDialog r100 = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(r100.mAlert);
            r100.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable == false) goto L5;
            r100.setCanceledOnTouchOutside(true);
        L5:
            r100.setOnCancelListener(this.P.mOnCancelListener);
            r100.setOnDismissListener(this.P.mOnDismissListener);
            DialogInterface.OnKeyListener r101 = this.P.mOnKeyListener;
            if (r101 == null) goto L8;
            r100.setOnKeyListener(r101);
        L8:
            return r100;
        }

        public Context getContext() {
            return this.P.mContext;
        }

        public AlertDialog show() {
            AlertDialog r100 = create();
            INVOKEVIRTUAL_androidx_appcompat_app_AlertDialog$Builder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
            return r100;
        }

        public Builder(Context r100) {
            this(r100, AlertDialog.resolveDialogTheme(r100, 0));
        }

        public static void INVOKEVIRTUAL_androidx_appcompat_app_AlertDialog$Builder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public Builder setCancelable(boolean r100) {
            this.P.mCancelable = r100;
            return this;
        }

        public Builder setCustomTitle(View r100) {
            this.P.mCustomTitleView = r100;
            return this;
        }

        public Builder setIcon(int r100) {
            this.P.mIconId = r100;
            return this;
        }

        public Builder setIconAttribute(int r100) {
            TypedValue r101 = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(r100, r101, true);
            AlertController.AlertParams r102 = this.P;
            r102.mIconId = r101.resourceId;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean r100) {
            this.P.mForceInverseBackground = r100;
            return this;
        }

        public Builder setMessage(int r100) {
            AlertController.AlertParams r101 = this.P;
            r101.mMessage = r101.mContext.getText(r100);
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable r100) {
            this.P.mNegativeButtonIcon = r100;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable r100) {
            this.P.mNeutralButtonIcon = r100;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener r100) {
            this.P.mOnCancelListener = r100;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener r100) {
            this.P.mOnDismissListener = r100;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r100) {
            this.P.mOnItemSelectedListener = r100;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener r100) {
            this.P.mOnKeyListener = r100;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable r100) {
            this.P.mPositiveButtonIcon = r100;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean r100) {
            this.P.mRecycleOnMeasure = r100;
            return this;
        }

        public Builder setTitle(int r100) {
            AlertController.AlertParams r101 = this.P;
            r101.mTitle = r101.mContext.getText(r100);
            return this;
        }

        public Builder setView(int r100) {
            AlertController.AlertParams r101 = this.P;
            r101.mView = null;
            r101.mViewLayoutResId = r100;
            r101.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setIcon(Drawable r100) {
            this.P.mIcon = r100;
            return this;
        }

        public Builder setMessage(CharSequence r100) {
            this.P.mMessage = r100;
            return this;
        }

        public Builder setTitle(CharSequence r100) {
            this.P.mTitle = r100;
            return this;
        }

        public Builder setView(View r100) {
            AlertController.AlertParams r101 = this.P;
            r101.mView = r100;
            r101.mViewLayoutResId = 0;
            r101.mViewSpacingSpecified = false;
            return this;
        }

        public Builder(Context r100, int r101) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(r100, AlertDialog.resolveDialogTheme(r100, r101)));
            this.mTheme = r101;
        }

        public Builder setAdapter(ListAdapter r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mAdapter = r100;
            r102.mOnClickListener = r101;
            return this;
        }

        public Builder setItems(int r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mItems = r102.mContext.getResources().getTextArray(r100);
            this.P.mOnClickListener = r101;
            return this;
        }

        public Builder setNegativeButton(int r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mNegativeButtonText = r102.mContext.getText(r100);
            this.P.mNegativeButtonListener = r101;
            return this;
        }

        public Builder setNeutralButton(int r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mNeutralButtonText = r102.mContext.getText(r100);
            this.P.mNeutralButtonListener = r101;
            return this;
        }

        public Builder setPositiveButton(int r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mPositiveButtonText = r102.mContext.getText(r100);
            this.P.mPositiveButtonListener = r101;
            return this;
        }

        public Builder setItems(CharSequence[] r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mItems = r100;
            r102.mOnClickListener = r101;
            return this;
        }

        public Builder setNegativeButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mNegativeButtonText = r100;
            r102.mNegativeButtonListener = r101;
            return this;
        }

        public Builder setNeutralButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mNeutralButtonText = r100;
            r102.mNeutralButtonListener = r101;
            return this;
        }

        public Builder setPositiveButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            AlertController.AlertParams r102 = this.P;
            r102.mPositiveButtonText = r100;
            r102.mPositiveButtonListener = r101;
            return this;
        }

        public Builder setCursor(Cursor r100, DialogInterface.OnClickListener r101, String r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mCursor = r100;
            r103.mLabelColumn = r102;
            r103.mOnClickListener = r101;
            return this;
        }

        public Builder setMultiChoiceItems(int r100, boolean[] r101, DialogInterface.OnMultiChoiceClickListener r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mItems = r103.mContext.getResources().getTextArray(r100);
            AlertController.AlertParams r104 = this.P;
            r104.mOnCheckboxClickListener = r102;
            r104.mCheckedItems = r101;
            r104.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int r100, int r101, DialogInterface.OnClickListener r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mItems = r103.mContext.getResources().getTextArray(r100);
            AlertController.AlertParams r104 = this.P;
            r104.mOnClickListener = r102;
            r104.mCheckedItem = r101;
            r104.mIsSingleChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] r100, boolean[] r101, DialogInterface.OnMultiChoiceClickListener r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mItems = r100;
            r103.mOnCheckboxClickListener = r102;
            r103.mCheckedItems = r101;
            r103.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter r100, int r101, DialogInterface.OnClickListener r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mAdapter = r100;
            r103.mOnClickListener = r102;
            r103.mCheckedItem = r101;
            r103.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] r100, int r101, DialogInterface.OnClickListener r102) {
            AlertController.AlertParams r103 = this.P;
            r103.mItems = r100;
            r103.mOnClickListener = r102;
            r103.mCheckedItem = r101;
            r103.mIsSingleChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor r100, String r101, String r102, DialogInterface.OnMultiChoiceClickListener r103) {
            AlertController.AlertParams r104 = this.P;
            r104.mCursor = r100;
            r104.mOnCheckboxClickListener = r103;
            r104.mIsCheckedColumn = r101;
            r104.mLabelColumn = r102;
            r104.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor r100, int r101, String r102, DialogInterface.OnClickListener r103) {
            AlertController.AlertParams r104 = this.P;
            r104.mCursor = r100;
            r104.mOnClickListener = r103;
            r104.mCheckedItem = r101;
            r104.mLabelColumn = r102;
            r104.mIsSingleChoice = true;
            return this;
        }

        public Builder setView(View r100, int r101, int r102, int r103, int r104) {
            AlertController.AlertParams r105 = this.P;
            r105.mView = r100;
            r105.mViewLayoutResId = 0;
            r105.mViewSpacingSpecified = true;
            r105.mViewSpacingLeft = r101;
            r105.mViewSpacingTop = r102;
            r105.mViewSpacingRight = r103;
            r105.mViewSpacingBottom = r104;
            return this;
        }
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    public AlertDialog(Context r100) {
        this(r100, 0);
    }

    public Button getButton(int r100) {
        return this.mAlert.getButton(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mAlert.installContent();
    }

    public void setButtonPanelLayoutHint(int r100) {
        this.mAlert.setButtonPanelLayoutHint(r100);
    }

    public void setCustomTitle(View r100) {
        this.mAlert.setCustomTitle(r100);
    }

    public void setIcon(int r100) {
        this.mAlert.setIcon(r100);
    }

    public void setIconAttribute(int r100) {
        TypedValue r101 = new TypedValue();
        getContext().getTheme().resolveAttribute(r100, r101, true);
        this.mAlert.setIcon(r101.resourceId);
    }

    public void setMessage(CharSequence r100) {
        this.mAlert.setMessage(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r100) {
        super.setTitle(r100);
        this.mAlert.setTitle(r100);
    }

    public void setView(View r100) {
        this.mAlert.setView(r100);
    }

    public void setIcon(Drawable r100) {
        this.mAlert.setIcon(r100);
    }

    public AlertDialog(Context r100, int r101) {
        super(r100, resolveDialogTheme(r100, r101));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public static int resolveDialogTheme(Context r100, int r101) {
        if (((r101 >>> 24) & 255) < 1) goto L5;
        return r101;
    L5:
        TypedValue r102 = new TypedValue();
        r100.getTheme().resolveAttribute(R.attr.alertDialogTheme, r102, true);
        return r102.resourceId;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (this.mAlert.onKeyDown(r100, r101) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        if (this.mAlert.onKeyUp(r100, r101) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r100, r101);
    }

    public AlertDialog(Context r100, boolean r101, DialogInterface.OnCancelListener r102) {
        this(r100, 0);
        setCancelable(r101);
        setOnCancelListener(r102);
    }

    public void setButton(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        this.mAlert.setButton(r100, r101, r102, null, null);
    }

    public void setButton(int r100, CharSequence r101, Message r102) {
        this.mAlert.setButton(r100, r101, null, r102, null);
    }

    public void setButton(int r100, CharSequence r101, Drawable r102, DialogInterface.OnClickListener r110) {
        this.mAlert.setButton(r100, r101, r110, null, r102);
    }

    public void setView(View r100, int r101, int r102, int r110, int r111) {
        this.mAlert.setView(r100, r101, r102, r110, r111);
    }
}
