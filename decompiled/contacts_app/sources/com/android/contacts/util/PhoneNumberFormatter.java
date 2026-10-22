package com.android.contacts.util;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.widget.ContactPhoneNumberFormattingTextWatcher;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneNumberFormatter {

    private static class TextWatcherLoadAsyncTask extends AsyncTask<Void, Void, ContactPhoneNumberFormattingTextWatcher> {
        private final String mCountryCode;
        private final boolean mRemoveSpecialChar;
        private final TextView mTextView;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ContactPhoneNumberFormattingTextWatcher doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ContactPhoneNumberFormattingTextWatcher r1) {
            onPostExecute2(r1);
        }

        public TextWatcherLoadAsyncTask(String r1, TextView r2, boolean r3) {
            this.mCountryCode = r1;
            this.mTextView = r2;
            this.mRemoveSpecialChar = r3;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ContactPhoneNumberFormattingTextWatcher doInBackground2(Void... r2) {
            return new ContactPhoneNumberFormattingTextWatcher(this.mCountryCode, this.mRemoveSpecialChar);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ContactPhoneNumberFormattingTextWatcher r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (isCancelled() == true) goto L9;
            this.mTextView.addTextChangedListener(r2);
            return;
        }
    }

    private PhoneNumberFormatter() {
    }

    public static final void setPhoneNumberFormattingTextWatcher(Context r2, TextView r3, boolean r4) {
        TextWatcherLoadAsyncTask r0 = new TextWatcherLoadAsyncTask(ContactsUtils.getCurrentCountryIso(r2), r3, r4);
        Void[] r5 = (Void[]) null;     // Catch: RejectedExecutionException -> L5
        r0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("PhoneNumberFormatter", "RejectedExecutionException occurred when execute TextWatcherLoadAsyncTask.\n" + e);
        Void[] r6 = (Void[]) null;
        r0.executeOnExecutor(ContactsApplication.getThreadPoolExecutor(), null);
    }

    public static final void setPhoneNumberFormattingTextWatcher(Context r1, TextView r2) {
        setPhoneNumberFormattingTextWatcher(r1, r2, true);
    }
}
