package com.obric.appintents;

import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.contacts.activities.DialtactsActivity;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.privacy.PrivacyUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentPrivacyHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/appintents/IntentPrivacyHelper;", "", "()V", "INTENT_ACTION_OPEN_CONTACTS_MAIN_PAGE_EXTRA", "", "TAG", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "openContactsMainPage", "", "updateResult", "context", "Landroid/content/Context;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntentPrivacyHelper {
    public static final IntentPrivacyHelper INSTANCE = null;
    public static final String INTENT_ACTION_OPEN_CONTACTS_MAIN_PAGE_EXTRA = "intent_action_open_contacts_main_page_extra";
    private static final String TAG = "IntentPrivacyHelper";
    private static DispatchContext dispatchContext;

    static {
        INSTANCE = new IntentPrivacyHelper();
    }

    private IntentPrivacyHelper() {
    }

    public final void openContactsMainPage(DispatchContext r3) {
        Intrinsics.checkNotNullParameter(r3, "dispatchContext");
        StringBuilder r2 = new StringBuilder("openContactsMainPage: questionId=").append(r3.getQuestionId()).append(", pendingBefore=");
        if (dispatchContext == null) goto L5;
        boolean r0 = true;
    L6:
        StringBuilder r4 = r2.append(r0).append(", pendingQuestionId=");
        DispatchContext r1 = dispatchContext;
        if (r1 == null) goto L9;
        Long r5 = r1.getQuestionId();
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r4.append(r5).toString());
        dispatchContext = r3;
        Context r6 = r3.getContext();
        Intent r7 = new Intent(r6, DialtactsActivity.class);
        r7.putExtra(INTENT_ACTION_OPEN_CONTACTS_MAIN_PAGE_EXTRA, true);
        r7.addFlags(268435456);
        r6.startActivity(r7);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void updateResult(Context r20) {
        Intrinsics.checkNotNullParameter(r20, "context");
        DispatchContext r0 = dispatchContext;
        StringBuilder r2 = new StringBuilder("updateResult: hasPendingDispatchContext=");
        if (r0 == null) goto L5;
        boolean r4 = true;
    L6:
        StringBuilder r3 = r2.append(r4).append(", pendingQuestionId=");
        if (r0 == null) goto L9;
        Long r5 = r0.getQuestionId();
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r3.append(r5).toString());
        PrivacyUtils.INSTANCE.applicationInit();
        if (r0 != null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "updateResult: dispatchContext is null");
        PrivacyUtils.startDialtactsActivity(r20);
        return;
    L14:
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(new IntentResult(0, null, null, null, false, false, 0, null, null, new ConcurrentHashMap(MapsKt.mapOf(TuplesKt.to(Ext.KEY_PRIVACY_STATEMENT_AGREED, "1"))), 510, null), r0, false);
        dispatchContext = null;
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = false;
        goto L6
    }
}
