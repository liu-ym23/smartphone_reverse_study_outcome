package com.obric.components;

import android.content.Intent;
import com.GlobalProxyLancet;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.init.ObricInitHelper;
import com.obric.model.CallFeatureModel;
import com.obric.privacyhook.BaseIntentService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactsTaskService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/components/ContactsTaskService;", "Lcom/obric/privacyhook/BaseIntentService;", "()V", "handleAction", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onActionStartCallSummaryTask", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsTaskService extends BaseIntentService {
    public static final String ACTION_START_CALL_SUMMARY_TASK = "ContactsTaskService.ACTION_START_CALL_SUMMARY_TASK";
    public static final Companion Companion = null;
    public static final String EXTRA_KEY_CALL_CREATE_TIME = "call_create_time";
    public static final String EXTRA_KEY_PHONE_NUMBER = "phone_number";
    private static final String TAG = "ContactsTaskService";

    /* JADX INFO: compiled from: ContactsTaskService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/components/ContactsTaskService$Companion;", "", "()V", "ACTION_START_CALL_SUMMARY_TASK", "", "EXTRA_KEY_CALL_CREATE_TIME", "EXTRA_KEY_PHONE_NUMBER", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ContactsTaskService() {
        super(TAG);
        setIntentRedelivery(false);
    }

    @Override // com.obric.privacyhook.BaseIntentService
    protected void handleAction(String r5, Intent r6) {
        if (r6 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "intent == null return.");
        return;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onHandleIntent[" + r6.getAction() + "] start.");
        String r0 = r6.getAction();
        if (r0 != null) goto L9;
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "unknown action. action is " + r6.getAction());
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onHandleIntent[" + r6.getAction() + "] end.");
        return;
    L9:
        if (r0.hashCode() != 1502718506) goto L14;
        if (r0.equals(ACTION_START_CALL_SUMMARY_TASK) == false) goto L14;
        onActionStartCallSummaryTask(r6);
        goto L15
    }

    private final void onActionStartCallSummaryTask(Intent r12) {
        long r9 = r12.getLongExtra("call_create_time", -1);
        String r13 = r12.getStringExtra("phone_number");
        if (r9 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get callCreateTime error. return!");
        return;
    L6:
        if (r13 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get phoneNumber error. return!");
        return;
    L9:
        ObricInitHelper.INSTANCE.waitForInitDone();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "service startGenerate date=" + r9);
        CallSummaryResult r11 = CallSummaryGenerateManager.INSTANCE.generateAndSaveCallSummary(this, r9, r13, false);
        StringBuilder r0 = new StringBuilder("service generated date=").append(r9).append(" resultError=");
        Integer r2 = null;
        if (r11 == null) goto L12;
        Integer r3 = Integer.valueOf(r11.getErrorCode());
    L13:
        StringBuilder r1 = r0.append(r3).append(" summaryError=");
        if (r11 == null) goto L18;
        CallSummary r4 = r11.getData();
        if (r4 == null) goto L18;
        r2 = Integer.valueOf(r4.getErrorCode());
    L18:
        StringBuilder r5 = r1.append(r2).append(" hasResult=");
        if (r11 == null) goto L21;
        boolean r6 = true;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r5.append(r6).toString());
        CallFeatureModel.INSTANCE.callSummaryFinished(new Pair(Long.valueOf(r9), r13), r11);
        return;
    L21:
        r6 = false;
        goto L22
    L12:
        r3 = null;
        goto L13
    }
}
