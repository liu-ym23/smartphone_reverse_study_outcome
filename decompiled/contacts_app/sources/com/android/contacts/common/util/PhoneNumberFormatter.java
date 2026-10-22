package com.android.contacts.common.util;

import android.content.Context;
import android.os.AsyncTask;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.widget.TextView;
import com.android.contacts.common.GeoUtil;
import com.android.contacts.common.compat.PhoneNumberFormattingTextWatcherCompat;

/* JADX INFO: loaded from: classes.dex */
public final class PhoneNumberFormatter {

    private static class TextWatcherLoadAsyncTask extends AsyncTask<Void, Void, PhoneNumberFormattingTextWatcher> {
        private final String mCountryCode;
        private final boolean mFormatAfterWatcherSet;
        private final TextView mTextView;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ PhoneNumberFormattingTextWatcher doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(PhoneNumberFormattingTextWatcher r1) {
            onPostExecute2(r1);
        }

        public TextWatcherLoadAsyncTask(String r1, TextView r2, boolean r3) {
            this.mCountryCode = r1;
            this.mTextView = r2;
            this.mFormatAfterWatcherSet = r3;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected PhoneNumberFormattingTextWatcher doInBackground2(Void... r1) {
            return PhoneNumberFormattingTextWatcherCompat.newInstance(this.mCountryCode);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(PhoneNumberFormattingTextWatcher r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (isCancelled() == true) goto L15;
            this.mTextView.addTextChangedListener(r2);
            if (this.mFormatAfterWatcherSet == false) goto L13;
            Editable r1 = this.mTextView.getEditableText();
            if (r1 == null) goto L14;
            r2.afterTextChanged(r1);
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    private PhoneNumberFormatter() {
    }

    public static final void setPhoneNumberFormattingTextWatcher(Context r1, TextView r2) {
        setPhoneNumberFormattingTextWatcher(r1, r2, false);
    }

    public static final void setPhoneNumberFormattingTextWatcher(Context r1, TextView r2, boolean r3) {
        Void[] r4 = (Void[]) null;
        new TextWatcherLoadAsyncTask(GeoUtil.getCurrentCountryIso(r1), r2, r3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }
}
