package com.android.phone.common;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.CallLog;

/* JADX INFO: loaded from: classes2.dex */
public class CallLogAsync {
    private static final String TAG = "CallLogAsync";

    public static class GetLastOutgoingCallArgs {
        public final OnLastOutgoingCallComplete callback;
        public final Context context;

        public GetLastOutgoingCallArgs(Context r1, OnLastOutgoingCallComplete r2) {
            this.context = r1;
            this.callback = r2;
        }
    }

    private static class GetLastOutgoingCallTask extends AsyncTask<GetLastOutgoingCallArgs, Void, String> {
        private final OnLastOutgoingCallComplete mCallback;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String doInBackground(GetLastOutgoingCallArgs[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(String r1) {
            onPostExecute2(r1);
        }

        public GetLastOutgoingCallTask(OnLastOutgoingCallComplete r1) {
            this.mCallback = r1;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String doInBackground2(GetLastOutgoingCallArgs... r3) {
            int r2 = r3.length;
            String r0 = "";
            int r1 = 0;
        L3:
            if (r1 >= r2) goto L5;
            r0 = CallLog.Calls.getLastOutgoingCall(r3[r1].context);
            r1 = r1 + 1;
            goto L3
        L5:
            return r0;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(String r1) {
            CallLogAsync.access$000();
            this.mCallback.lastOutgoingCall(r1);
        }
    }

    public interface OnLastOutgoingCallComplete {
        void lastOutgoingCall(String r1);
    }

    public CallLogAsync() {
    }

    static /* synthetic */ void access$000() {
        assertUiThread();
    }

    public AsyncTask getLastOutgoingCall(GetLastOutgoingCallArgs r3) {
        assertUiThread();
        return new GetLastOutgoingCallTask(r3.callback).execute(new GetLastOutgoingCallArgs[]{r3});
    }

    private static void assertUiThread() {
        if (Looper.getMainLooper().equals(Looper.myLooper()) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Not on the UI thread!");
    }
}
