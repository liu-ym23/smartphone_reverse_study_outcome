package com.android.contacts.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.Spinner;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public class BytedanceSpinner extends Spinner {
    private static final String TAG = "SmaetSpinner";

    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ BytedanceSpinner this$0;

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        private DialogPopup(BytedanceSpinner r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void dismiss() {
            this.mPopup.dismiss();
            this.mPopup = null;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public boolean isShowing() {
            AlertDialog r0 = this.mPopup;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isShowing();
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r1) {
            this.mListAdapter = r1;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void setPromptText(CharSequence r1) {
            this.mPrompt = r1;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void show() {
            AlertDialog.Builder r0 = new AlertDialog.Builder(this.this$0.getContext());
            CharSequence r1 = this.mPrompt;
            if (r1 == null) goto L5;
            r0.setTitle(r1);
        L5:
            this.mPopup = r0.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r4, int r5) {
            this.this$0.setSelection(r5);
            this.this$0.performItemClick(null, r5, this.mListAdapter.getItemId(r5));
            dismiss();
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r1) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(BytedanceSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void setVerticalOffset(int r1) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(BytedanceSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // com.android.contacts.widget.BytedanceSpinner.SpinnerPopup
        public void setHorizontalOffset(int r1) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(BytedanceSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
    }

    private interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r1);

        void setBackgroundDrawable(Drawable r1);

        void setHorizontalOffset(int r1);

        void setPromptText(CharSequence r1);

        void setVerticalOffset(int r1);

        void show();
    }

    public BytedanceSpinner(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
