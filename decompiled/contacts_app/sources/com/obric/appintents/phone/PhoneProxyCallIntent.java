package com.obric.appintents.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import androidx.core.view.PointerIconCompat;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PhoneProxyCallParams;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.model.CallFeatureModel;
import com.obric.privacy.PrivacyUtils;
import com.obric.utils.GlobalUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: compiled from: PhoneProxyCallIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u001e\u0010\u0015\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0002J.\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0002J6\u0010#\u001a\u00020\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/obric/appintents/phone/PhoneProxyCallIntent;", "Lcom/obric/capabilitykit/common/intent/BasePhoneProxyCallIntent;", "()V", "callContext", "Lcom/obric/appintents/phone/PhoneProxyCallIntent$CallContext;", "cancelTask", "", "reason", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateContentString", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "getCallUri", "data", "Lkotlin/Pair;", "", "havePhoneCall", "sendBroadcastReceiver", "", "context", "Landroid/content/Context;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "startCallForMe", "phoneNumber", "jsonData", "id", "updateCallStatus", "detail", "final", "status", "uri", "CallContext", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneProxyCallIntent extends BasePhoneProxyCallIntent {
    private static final String CANCEL_CALL_FOR_ME_CALL = "android.android.incall.action.CANCEL_CALL_FOR_ME_CALL";
    public static final Companion Companion = null;
    private static final String EXTRA_TEL_EXTRAS = "com.android.contacts.tel.extras";
    private static final String HANG_UP_ONGOING_CALL = "android.android.incall.action.HANG_UP_ONGOING_CALL";
    private volatile CallContext callContext;

    /* JADX INFO: compiled from: PhoneProxyCallIntent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/appintents/phone/PhoneProxyCallIntent$CallContext;", "", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "callParams", "Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "callForMeBeanStr", "", "(Lcom/obric/capabilitykit/common/DispatchContext;Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;Ljava/lang/String;)V", "getCallForMeBeanStr", "()Ljava/lang/String;", "getCallParams", "()Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "getDispatchContext", "()Lcom/obric/capabilitykit/common/DispatchContext;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CallContext {
        private final String callForMeBeanStr;
        private final PhoneProxyCallParams callParams;
        private final DispatchContext dispatchContext;

        public static /* synthetic */ CallContext copy$default(CallContext r0, DispatchContext r1, PhoneProxyCallParams r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.dispatchContext;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.callParams;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.callForMeBeanStr;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final DispatchContext component1() {
            return this.dispatchContext;
        }

        public final PhoneProxyCallParams component2() {
            return this.callParams;
        }

        public final String component3() {
            return this.callForMeBeanStr;
        }

        public final CallContext copy(DispatchContext r1, PhoneProxyCallParams r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "dispatchContext");
            Intrinsics.checkNotNullParameter(r2, "callParams");
            return new CallContext(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CallContext) == true) goto L8;
            return false;
        L8:
            CallContext r6 = (CallContext) r5;
            if (Intrinsics.areEqual(this.dispatchContext, r6.dispatchContext) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callParams, r6.callParams) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.callForMeBeanStr, r6.callForMeBeanStr) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.dispatchContext.hashCode() * 31) + this.callParams.hashCode()) * 31;
            String r2 = this.callForMeBeanStr;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "CallContext(dispatchContext=" + this.dispatchContext + ", callParams=" + this.callParams + ", callForMeBeanStr=" + this.callForMeBeanStr + ')';
        }

        public CallContext(DispatchContext r2, PhoneProxyCallParams r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "dispatchContext");
            Intrinsics.checkNotNullParameter(r3, "callParams");
            this.dispatchContext = r2;
            this.callParams = r3;
            this.callForMeBeanStr = r4;
        }

        public /* synthetic */ CallContext(DispatchContext r1, PhoneProxyCallParams r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final DispatchContext getDispatchContext() {
            return this.dispatchContext;
        }

        public final PhoneProxyCallParams getCallParams() {
            return this.callParams;
        }

        public final String getCallForMeBeanStr() {
            return this.callForMeBeanStr;
        }
    }

    /* JADX INFO: compiled from: PhoneProxyCallIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/appintents/phone/PhoneProxyCallIntent$Companion;", "", "()V", "CANCEL_CALL_FOR_ME_CALL", "", "EXTRA_TEL_EXTRAS", "HANG_UP_ONGOING_CALL", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public PhoneProxyCallIntent() {
    }

    public static final /* synthetic */ String access$generateContentString(PhoneProxyCallIntent r0, List r1) {
        return r0.generateContentString(r1);
    }

    public static final /* synthetic */ String access$getCallUri(PhoneProxyCallIntent r0, Pair r1) {
        return r0.getCallUri(r1);
    }

    public static final /* synthetic */ void access$sendBroadcastReceiver(PhoneProxyCallIntent r0, Context r1, String r2, String r3) {
        r0.sendBroadcastReceiver(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateCallStatus(PhoneProxyCallIntent r0, String r1, boolean r2, String r3, String r4) {
        r0.updateCallStatus(r1, r2, r3, r4);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((PhoneProxyCallParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent
    public Object doAction(PhoneProxyCallParams r21, DispatchContext r22, Continuation<? super IntentResult<Empty>> r23) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r22.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r22);
        return new IntentResult(201, null, null, r22.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction, params: " + r21);
        Context r3 = r22.getContext();
        String r5 = r21.getTargetPhoneNumber();
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction 拨出电话号码为空");
        return new IntentResult(103, null, null, r3.getResources().getString(R.string.intents_contacts_phone_number_empty), false, false, 1, null, null, null, 950, null);
    L17:
        if (ContactsUtils.isNoSim(r3) == false) goto L21;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction 没有 SIM 卡");
        return new IntentResult(1, null, null, r3.getResources().getString(R.string.intents_phone_call_no_sim), false, false, 1, null, null, null, 950, null);
    L21:
        if (havePhoneCall() == true) goto L23;
    L26:
        String r4 = GlobalUtils.INSTANCE.getGson().toJson(r21);
        String r7 = System.currentTimeMillis() + '_' + r21.getTargetPhoneNumber();
        JSONObject r8 = new JSONObject();
        r8.put("callId", r7);
        r8.put("params", new JSONObject(r4));
        this.callContext = new CallContext(r22, r21, r8.toString());
        startCallForMe(r21.getTargetPhoneNumber(), r8.toString(), r22.getContext(), r7);
        IntentResult r0 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
        r0.setFinal(false);
        IMAppActionExt r1 = new IMAppActionExt();
        r1.put("state", "call_dialing");
        r0.setExt(r1);
        return r0;
    L23:
        if (Intrinsics.areEqual(r21.getCanInterruptCall(), Boxing.boxBoolean(true)) == true) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneProxyCallIntent#doAction 有电话在通话中");
        return new IntentResult(1, null, null, r3.getResources().getString(R.string.intents_call_confirm_hangup), false, false, 1, null, null, null, 950, null);
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneProxyCallIntent#cancelTask reason: " + r4);
        CallContext r5 = this.callContext;
        if (r5 == null) goto L15;
        DispatchContext r6 = r5.getDispatchContext();
        if (r6 == null) goto L15;
        Context r7 = r6.getContext();
        if (r7 == null) goto L15;
        CallContext r1 = this.callContext;
        if (r1 == null) goto L15;
        String r2 = r1.getCallForMeBeanStr();
        if (r2 == null) goto L15;
        sendBroadcastReceiver(r7, r2, CANCEL_CALL_FOR_ME_CALL);
        this.callContext = null;
    L15:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startCallForMe(final String r10, final String r11, final Context r12, final String r13) {
        if (this.callContext != null) goto L5;
        return;
    L5:
        sendBroadcastReceiver(r12, r11, HANG_UP_ONGOING_CALL);
        final Ref.LongRef r0 = new Ref.LongRef();
        r0.element = -1;
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = r10;
        final CallFeatureModel.CallFeatureModelListener r8 = new PhoneProxyCallIntent$startCallForMe$callRecordDataReadyListener$1(r0, r7, r10, r12, this);
        CallFeatureModel.CallResultListener r14 = new PhoneProxyCallIntent$startCallForMe$callResultListener$1(r13, this, r12, r11, r0, r7, r8);
        CallFeatureModel.INSTANCE.addCallResultListener(r14);
    }

    static /* synthetic */ void updateCallStatus$default(PhoneProxyCallIntent r1, String r2, boolean r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        r1.updateCallStatus(r2, r3, r4, r5);
    }

    private final void updateCallStatus(String r21, boolean r22, String r23, String r24) {
        if (this.callContext != null) goto L5;
        return;
    L5:
        StringBuilder r4 = new StringBuilder("PhoneProxyCallIntent#updateCallStatus detail: ");
        String r5 = r21;
        boolean r6 = false;
        if (r5 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        StringBuilder r8 = r4.append(r7).append(", final: ").append(r22).append(", status: ").append(r23).append(", uri: ");
        String r9 = r24;
        if (r9 != null) goto L15;
    L16:
        r6 = true;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r8.append(r6).toString());
        IntentResult<?> r10 = new IntentResult(0, null, null, r21, false, false, 0, null, null, null, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null);
        r10.setFinal(r22);
        IMAppActionExt r11 = new IMAppActionExt();
        CallContext r12 = this.callContext;
        if (r12 == null) goto L24;
        PhoneProxyCallParams r13 = r12.getCallParams();
        if (r13 == null) goto L24;
        String r14 = r13.getTargetPhoneNumber();
        if (r14 == null) goto L24;
        String r15 = r11.put("phone", r14);
    L24:
        if (r23 == null) goto L26;
        String r2 = r11.put("state", r23);
    L26:
        if (r24 == null) goto L28;
        r11.put("record_link", r24);
    L28:
        r10.setExt(r11);
        CallContext r3 = this.callContext;
        if (r3 == null) goto L33;
        DispatchContext r16 = r3.getDispatchContext();
        if (r16 == null) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneProxyCallIntent#updateCallStatus intentResult call");
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(r10, r16, true);
    L33:
        if (r22 == false) goto L36;
        this.callContext = null;
        return;
    L36:
        return;
    L15:
        if (r9.length() != 0) goto L17;
    L8:
        if (r5.length() == 0) goto L11;
        r7 = false;
        goto L12
    }

    private final boolean havePhoneCall() {
        Object r2 = ContactsApplication.getInstance().getApplicationContext().getSystemService("phone");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        if (((TelephonyManager) r2).getCallState() != 2) goto L5;
        boolean r3 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "havePhoneCall res " + r3);
        return r3;
    L5:
        r3 = false;
        goto L6
    }

    static /* synthetic */ void sendBroadcastReceiver$default(PhoneProxyCallIntent r0, Context r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = HANG_UP_ONGOING_CALL;
    L8:
        r0.sendBroadcastReceiver(r1, r2, r3);
    }

    private final void sendBroadcastReceiver(Context r1, String r2, String r3) {
        Intent r0 = new Intent(r3);
        r0.putExtra(EXTRA_TEL_EXTRAS, r2);
        r1.sendBroadcast(r0);
    }

    private final String getCallUri(Pair<Long, String> r3) {
        StringBuilder r2 = new StringBuilder("intent://#Intent;package=com.android.contacts;component=com.android.contacts/com.android.contacts.calllog.record.CallRecordAndSummaryActivity;S.summary_id=");
        long r0 = r3.getFirst().longValue();
        String r4 = r3.getSecond();
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        return r2.append(CallSummaryWidget.setCallTag(r0, r4)).append(";end").toString();
    }

    private final String generateContentString(List<CallSummaryASRMessageBean> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<CallSummaryASRMessageBean> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CallSummaryASRMessageBean r0 = r5.next();
        r3.append(r0.getName() + ": " + r0.getAsrText() + '\n');
        goto L4
    L6:
        String r6 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "sb.toString()");
        return r6;
    }
}
