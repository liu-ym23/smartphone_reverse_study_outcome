package com.android.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.provider.CallLog;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.obric.privacyhook.BaseIntentService;

/* JADX INFO: loaded from: classes.dex */
public class CallLogSaveService extends BaseIntentService {
    public static final String ACTION_UPDATE_CALLLOG = "updateCallLog";
    public static final String EXTRA_UPDATE_CALLLOG = "extra_update_calllog";
    private static final String TAG = "CallLogSaveService";

    public CallLogSaveService() {
        super(TAG);
        setIntentRedelivery(true);
    }

    public static final Intent createUpdateCallLogIntent(Context r2, ContentValues r3) {
        Intent r0 = new Intent(r2, CallLogSaveService.class);
        r0.setPackage("com.android.contacts");
        r0.setAction(ACTION_UPDATE_CALLLOG);
        r0.putExtra(EXTRA_UPDATE_CALLLOG, r3);
        return r0;
    }

    @Override // com.obric.privacyhook.BaseIntentService
    protected void handleAction(String r2, Intent r3) {
        if (ACTION_UPDATE_CALLLOG.equals(r2) == false) goto L6;
        updateCallLogLabels(r3);
        return;
    }

    private void updateCallLogLabels(Intent r10) {
        String r1 = r10.getStringExtra("countryiso");
        String r2 = r10.getStringExtra("number");
        ContentValues r11 = (ContentValues) r10.getParcelableExtra(EXTRA_UPDATE_CALLLOG);
        if (r11 == null) goto L5;
        String r3 = r11.getAsString("numberlabel");
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return;
    L9:
        StringBuilder r4 = new StringBuilder("number =? AND ");
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r4.append("countryiso IS NULL AND ( numberlabel IS NULL OR numberlabel != ?)");
        String[] r5 = {r2, r3};
    L13:
        r4.append(" AND type IN (1, 7, 2, 3)");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateCallLogLabels updatedRows=" + getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r11, r4.toString(), r5) + ", countryIsoEmpty=" + TextUtils.isEmpty(r1));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        r4.append("(countryiso =? OR countryiso IS NULL) AND ( numberlabel IS NULL OR numberlabel != ?)");
        r5 = new String[]{r2, r1, r3};
        goto L13
    L5:
        r3 = null;
        goto L7
    }
}
