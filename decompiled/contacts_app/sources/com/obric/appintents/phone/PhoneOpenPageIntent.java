package com.obric.appintents.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.calllog.record.CallRecordAndSummaryActivity;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PhoneOpenPageParams;
import com.obric.model.CallFeatureModel;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PhoneOpenPageIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/obric/appintents/phone/PhoneOpenPageIntent;", "Lcom/obric/capabilitykit/common/intent/BasePhoneOpenPageIntent;", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/PhoneOpenPageParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PhoneOpenPageParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcastReceiver", "", "context", "Landroid/content/Context;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneOpenPageIntent extends BasePhoneOpenPageIntent {
    private static final String CALL_SCREEN_TO_FOREGROUND = "android.android.incall.action.CALL_SCREEN_TO_FOREGROUND";
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: PhoneOpenPageIntent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/appintents/phone/PhoneOpenPageIntent$Companion;", "", "()V", "CALL_SCREEN_TO_FOREGROUND", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public PhoneOpenPageIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((PhoneOpenPageParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent
    public Object doAction(PhoneOpenPageParams r21, DispatchContext r22, Continuation<? super IntentResult<Empty>> r23) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r22.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r22);
        return new IntentResult(201, null, null, r22.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        String r0 = r21.getPage();
        Context r3 = r22.getContext();
        String r4 = r0;
        boolean r5 = false;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L16;
        sendBroadcastReceiver(r3);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
    L16:
        String r1 = Intent.parseUri(r0, 1).getStringExtra(CallSummaryWidget.INTENT_PARAMS_CALL_SUMMARY_ID);
        String r7 = r1;
        if (r7 != null) goto L19;
    L20:
        r5 = true;
    L21:
        if (r5 == false) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneOpenPageIntent#doAction call with empty callSummaryId");
        return new IntentResult(ErrorCode.Contacts.PHONE_NO_PAGE_ERROR, null, null, null, false, false, 0, null, null, null, 1022, null);
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneOpenPageIntent#doAction call");
        Pair<String, String> r2 = CallSummaryWidget.getCallCreateTimeAndPhoneNumber(r1);
        if (r2 == null) goto L34;
        Long r8 = StringsKt.toLongOrNull(r2.getFirst());
        if (r8 == null) goto L29;
        long r9 = r8.longValue();
    L31:
        if (CallFeatureModel.INSTANCE.getCallFeature(r9, r2.getSecond()) != null) goto L34;
        return new IntentResult(ErrorCode.Contacts.PHONE_NO_PAGE_ERROR, null, null, null, false, false, 0, null, null, null, 1022, null);
    L29:
        r9 = -1;
    L34:
        Intent r10 = new Intent();
        r10.setClass(r3, CallRecordAndSummaryActivity.class);
        r10.putExtra(CallSummaryWidget.INTENT_PARAMS_CALL_SUMMARY_ID, r1);
        r10.addFlags(268435456);
        r10.addFlags(67108864);
        r10.addFlags(32768);
        r22.getContext().startActivity(r10);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
    L19:
        if (r7.length() != 0) goto L21;
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    private final void sendBroadcastReceiver(Context r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneOpenPageIntent#sendBroadcastReceiver");
        r2.sendBroadcast(new Intent(CALL_SCREEN_TO_FOREGROUND));
    }
}
