package com.obric.appintents.phone;

import android.content.Context;
import android.os.Parcelable;
import android.provider.CallLog;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePhoneDeleteIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PhoneDeleteParams;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: PhoneDeleteIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0002J-\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/obric/appintents/phone/PhoneDeleteIntent;", "Lcom/obric/capabilitykit/common/intent/BasePhoneDeleteIntent;", "()V", "deletePhoneCallLog", "", "context", "Landroid/content/Context;", "deleteIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "params", "Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListIdsByData", "data", "([Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;)Ljava/util/ArrayList;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneDeleteIntent extends BasePhoneDeleteIntent {
    public PhoneDeleteIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneDeleteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<CallHistoryEntity[]>> r3) {
        return doAction((PhoneDeleteParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneDeleteIntent
    public Object doAction(PhoneDeleteParams r18, DispatchContext r19, Continuation<? super IntentResult<CallHistoryEntity[]>> r20) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r19.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneDeleteIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r19);
        return new IntentResult(201, null, null, r19.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneDeleteIntent#doAction call");
        CallHistoryEntity[] r6 = r18.getTargets();
        if (r6 == null) goto L12;
        boolean r0 = deletePhoneCallLog(r19.getContext(), getListIdsByData(r6));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneDeleteIntent#doAction isSuccess " + r0);
        if (r0 == false) goto L12;
        return new IntentResult(0, r6, null, r19.getContext().getResources().getString(R.string.intents_inquire_further_phone_delete_done), false, false, 1, null, null, null, 948, null);
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneDeleteIntent#doAction params null or delete fail");
        return new IntentResult(0, null, null, r19.getContext().getResources().getString(R.string.intents_inquire_further_phone_delete), false, false, 1, null, null, null, 950, null);
    }

    private final ArrayList<String> getListIdsByData(CallHistoryEntity[] r5) {
        ArrayList<String> r4 = new ArrayList();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CallHistoryEntity r2 = r5[r1];
        if (r4.contains(r2.getId()) == true) goto L7;
        r4.add(r2.getId());
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    private final boolean deletePhoneCallLog(Context r13, ArrayList<String> r14) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneDeleteIntent#deletePhoneCallLog call deleteIds " + r14);
        ArrayList<String> r12 = r14;
        if (r12 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneDeleteIntent#deletePhoneCallLog return deleteIds is null");
        return false;
    L12:
        String r16 = "_id IN " + CollectionsKt.joinToString$default(r14, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneDeleteIntent#deletePhoneCallLog callLogsSelection: " + r16);
        r13.getContentResolver().delete(CallLog.Calls.CONTENT_URI, r16, null);
        return true;
    L5:
        if (r12.isEmpty() == true) goto L8;
        r15 = false;
        goto L9
    }
}
