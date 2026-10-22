package com.obric.appintents.phone;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.intent.BasePhoneCallIntent;
import com.obric.capabilitykit.common.intent.ContactTarget;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PhoneCallParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: PhoneCallIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/obric/appintents/phone/PhoneCallIntent;", "Lcom/obric/capabilitykit/common/intent/BasePhoneCallIntent;", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/PhoneCallParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PhoneCallParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInCallWithContacts", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "isVideoCall", "", "(Lcom/obric/capabilitykit/common/DispatchContext;Lcom/obric/capabilitykit/entity/app/ContactEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInCallWithNumber", "number", "", "(Lcom/obric/capabilitykit/common/DispatchContext;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneCallIntent extends BasePhoneCallIntent {
    public static final Companion Companion = null;
    private static final String INTENTS_TYPE_VIDEO = "VIDEO";
    private static final String INTENTS_TYPE_VOICE = "VOICE";

    /* JADX INFO: compiled from: PhoneCallIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/appintents/phone/PhoneCallIntent$Companion;", "", "()V", "INTENTS_TYPE_VIDEO", "", "INTENTS_TYPE_VOICE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.appintents.phone.PhoneCallIntent$doAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: PhoneCallIntent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appintents.phone.PhoneCallIntent", f = "PhoneCallIntent.kt", i = {0, 1}, l = {96, 101, 107}, m = "doAction", n = {"dispatchContext", "dispatchContext"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PhoneCallIntent this$0;

        AnonymousClass1(PhoneCallIntent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.appintents.phone.PhoneCallIntent$openInCallWithContacts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PhoneCallIntent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appintents.phone.PhoneCallIntent", f = "PhoneCallIntent.kt", i = {0, 0, 0}, l = {174}, m = "openInCallWithContacts", n = {"dispatchContext", "context", "cursor"}, s = {"L$0", "L$1", "L$2"})
    static final class C02381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PhoneCallIntent this$0;

        C02381(PhoneCallIntent r1, Continuation<? super C02381> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PhoneCallIntent.access$openInCallWithContacts(this.this$0, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.appintents.phone.PhoneCallIntent$openInCallWithNumber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PhoneCallIntent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appintents.phone.PhoneCallIntent", f = "PhoneCallIntent.kt", i = {0, 0, 0}, l = {210, 227}, m = "openInCallWithNumber", n = {"number", "context", "isVideoCall"}, s = {"L$0", "L$1", "Z$0"})
    static final class C02391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PhoneCallIntent this$0;

        C02391(PhoneCallIntent r1, Continuation<? super C02391> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PhoneCallIntent.access$openInCallWithNumber(this.this$0, null, null, false, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PhoneCallIntent() {
    }

    public static final /* synthetic */ Object access$openInCallWithContacts(PhoneCallIntent r0, DispatchContext r1, ContactEntity r2, boolean r3, Continuation r4) {
        return r0.openInCallWithContacts(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$openInCallWithNumber(PhoneCallIntent r0, DispatchContext r1, String r2, boolean r3, Continuation r4) {
        return r0.openInCallWithNumber(r1, r2, r3, r4);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneCallIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((PhoneCallParams) r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.String] */
    @Override // com.obric.capabilitykit.common.intent.BasePhoneCallIntent
    public Object doAction(PhoneCallParams r24, DispatchContext r25, Continuation<? super IntentResult<Empty>> r26) {
        if ((r26 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r26;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        int r8 = 1;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L125:
        return r2;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        DispatchContext r0 = (DispatchContext) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L87:
        boolean r1 = ((Boolean) r2).booleanValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneCallIntent#doAction contact one phone  success = " + r1);
    L127:
        String r6 = r0.getContext().getString(R.string.intents_call_ok);
        Intrinsics.checkNotNullExpressionValue(r6, "dispatchContext.context.…R.string.intents_call_ok)");
        if (r1 == true) goto L130;
        r6 = r0.getContext().getString(R.string.intents_inquire_further_ok);
        Intrinsics.checkNotNullExpressionValue(r6, "dispatchContext.context.…tents_inquire_further_ok)");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneCallIntent#doAction null params");
        String r7 = "com.android.contacts.activities.DialtactsActivity";
    L131:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneCallIntent#doAction success");
        return new IntentResult(0, null, null, r6, false, false, IntentsUtilsKt.getUiTypeByName(r0.getContext(), r8, r7), null, null, null, 950, null);
    L130:
        r7 = IntentsConstantKt.ACTIVITY_NAME_EDIT_CONTACT;
        r8 = 4194304;
        goto L131
    L17:
        r0 = (DispatchContext) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L55:
        r1 = ((Boolean) r2).booleanValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneCallIntent#doAction phone success = " + r1);
        goto L127
    L18:
        ResultKt.throwOnFailure(r2);
        if (PrivacyUtils.hasBasePermissionAndAgree(r25.getContext()) == true) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneCallIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r25);
        return new IntentResult(201, null, null, r25.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L22:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = "VOICE";
        ?? r10 = r24.getType();
        if (r10 == 0) goto L25;
        r9.element = r10;
    L25:
        boolean r11 = TextUtils.equals((CharSequence) r9.element, "VIDEO");
        ContactEntity r12 = null;
        String r13 = null;
        String r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        if (ContactsUtils.isNoSim(r25.getContext()) == false) goto L35;
        ContactTarget r15 = r24.getTarget();
        if (r15 == null) goto L30;
        String r16 = r15.getTelephone();
    L32:
        if (PhoneNumberUtils.isEmergencyNumber(r16) == true) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneCallIntent#doAction 没有 SIM 卡");
        return new IntentResult(1, null, null, r25.getContext().getResources().getString(R.string.intents_phone_call_no_sim), false, false, 9, null, null, null, 950, null);
    L30:
        r16 = null;
    L35:
        if (r11 == false) goto L41;
        if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == true) goto L41;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneCallIntent#doAction 不支持视频通话");
        return new IntentResult(1, null, null, r25.getContext().getResources().getString(R.string.intents_inquire_further_voice_call_fail), false, false, 9, null, null, null, 950, null);
    L41:
        if (r24.getTarget() == null) goto L57;
        ContactTarget r17 = r24.getTarget();
        if (r17 == null) goto L45;
        String r18 = r17.getTelephone();
    L47:
        if (TextUtils.isEmpty(r18) == true) goto L57;
        ContactTarget r19 = r24.getTarget();
        if (r19 == null) goto L51;
        r13 = r19.getTelephone();
    L51:
        r3.L$0 = r25;
        r3.label = 1;
        r2 = openInCallWithNumber(r25, r13, r11, r3);
        if (r2 != r4) goto L54;
        return r4;
    L54:
        r0 = r25;
        goto L55
    L45:
        r18 = null;
    L57:
        if (r24.getTarget() == null) goto L89;
        ContactTarget r20 = r24.getTarget();
        if (r20 == null) goto L61;
        ContactEntity r21 = r20.getContact();
    L62:
        if (r21 == null) goto L89;
        ContactTarget r22 = r24.getTarget();
        if (r22 == null) goto L72;
        ContactEntity r23 = r22.getContact();
        if (r23 == null) goto L72;
        List<MetaTelephone> r27 = r23.getTelephones();
        if (r27 == null) goto L72;
        if (r27.size() != 1) goto L72;
        Object[] r28 = true;
    L73:
        if (r28 == false) goto L89;
        ContactTarget r29 = r24.getTarget();
        if (r29 == null) goto L83;
        ContactEntity r30 = r29.getContact();
        if (r30 == null) goto L83;
        List<MetaTelephone> r31 = r30.getTelephones();
        if (r31 == null) goto L83;
        MetaTelephone r32 = r31.get(0);
        if (r32 == null) goto L83;
        r14 = r32.getTelephone();
    L83:
        r3.L$0 = r25;
        r3.label = 2;
        r2 = openInCallWithNumber(r25, r14, r11, r3);
        if (r2 != r4) goto L86;
        return r4;
    L86:
        r0 = r25;
    L72:
        r28 = false;
        goto L73
    L61:
        r21 = null;
    L89:
        if (r24.getTarget() == null) goto L126;
        ContactTarget r33 = r24.getTarget();
        if (r33 == null) goto L93;
        ContactEntity r34 = r33.getContact();
    L94:
        if (r34 == null) goto L126;
        ContactTarget r35 = r24.getTarget();
        if (r35 == null) goto L100;
        ContactEntity r36 = r35.getContact();
        if (r36 == null) goto L100;
        List<MetaTelephone> r37 = r36.getTelephones();
    L101:
        List<MetaTelephone> r38 = r37;
        if (r38 != null) goto L104;
    L107:
        Object[] r39 = true;
    L108:
        if (r39 == true) goto L126;
        ContactTarget r40 = r24.getTarget();
        if (r40 == null) goto L116;
        ContactEntity r41 = r40.getContact();
        if (r41 == null) goto L116;
        List<MetaTelephone> r42 = r41.getTelephones();
        if (r42 == null) goto L116;
        Integer r43 = Boxing.boxInt(r42.size());
    L117:
        Intrinsics.checkNotNull(r43);
        if (r43.intValue() <= 1) goto L126;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "PhoneCallIntent#doAction contact more phones");
        ContactTarget r44 = r24.getTarget();
        if (r44 == null) goto L122;
        r12 = r44.getContact();
    L122:
        r3.label = 3;
        r2 = openInCallWithContacts(r25, r12, r11, r3);
        if (r2 != r4) goto L125;
        return r4;
    L116:
        r43 = null;
        goto L117
    L104:
        if (r38.isEmpty() == true) goto L107;
        r39 = false;
    L100:
        r37 = null;
        goto L101
    L93:
        r34 = null;
    L126:
        r0 = r25;
        r1 = false;
    L7:
        r3 = new AnonymousClass1(this, r26);
        goto L8
    }

    private final Object openInCallWithContacts(DispatchContext r28, ContactEntity r29, boolean r30, Continuation<? super IntentResult<Empty>> r31) {
        DispatchContext r1 = r28;
        if ((r31 instanceof C02381) == false) goto L7;
        C02381 r3 = (C02381) r31;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        Cursor r6 = (Cursor) r3.L$2;
        Context r7 = (Context) r3.L$1;
        DispatchContext r8 = (DispatchContext) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L14
        Cursor r9 = r6;
        r1 = r8;
    L78:
        IntentResult r0 = new IntentResult(0, null, null, r7.getString(R.string.intents_call_ok), false, false, IntentsUtilsKt.getUiTypeByName(r1.getContext(), 4194304, IntentsConstantKt.ACTIVITY_NAME_EDIT_CONTACT), null, null, null, 950, null);     // Catch: Throwable -> L63
        if (r9 == null) goto L62;
        r9.close();
    L62:
        return r0;
    L63:
        th = th;
    L83:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithContacts err = " + th);     // Catch: Throwable -> L74
        if (r9 == null) goto L71;
        r9.close();
    L71:
        Context r10 = r7;
    L73:
        return new IntentResult(0, null, null, r10.getString(R.string.intents_inquire_further_ok), false, false, IntentsUtilsKt.getUiTypeByName(r1.getContext(), 1, "com.android.contacts.activities.DialtactsActivity"), null, null, null, 950, null);
    L74:
        th = move-exception;
        if (r9 == null) goto L77;
        r9.close();
    L77:
        throw th;
    L14:
        th = th;
        r9 = r6;
        r1 = r8;
        goto L83
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r10 = r28.getContext();
        if (r29 == null) goto L25;
        String r11 = r29.getId();
        if (r11 == null) goto L25;
        Long r12 = StringsKt.toLongOrNull(r11);
        if (r12 == null) goto L25;
        long r13 = r12.longValue();
    L26:
        ArrayList r14 = new ArrayList();
        if (r29 == null) goto L34;
        List<MetaTelephone> r15 = r29.getTelephones();
        if (r15 == null) goto L34;
        Iterator<T> r16 = r15.iterator();
    L32:
        if (r16.hasNext() == false) goto L34;
        r14.add(((MetaTelephone) r16.next()).getTelephone());
    L34:
        String r17 = IntentsUtilsKt.updateSelection(r14);
        r9 = null;
        r9 = r10.getApplicationContext().getContentResolver().query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, r17, null, "date DESC");     // Catch: Throwable -> L66
        if (r9 == null) goto L39;
    L42:
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L66
        if (r9.moveToNext() == false) goto L45;
    L49:
        int r18 = r9.getColumnIndex("number");     // Catch: Throwable -> L66
        if (r18 == (-1)) goto L65;
        String r19 = r9.getString(r18);     // Catch: Throwable -> L66
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithContacts ");     // Catch: Throwable -> L66
        if (r30 == false) goto L54;
        boolean r20 = true;
    L55:
        r3.L$0 = r1;     // Catch: Throwable -> L66
        r3.L$1 = r10;     // Catch: Throwable -> L66
        r3.L$2 = r9;     // Catch: Throwable -> L66
        r3.label = 1;     // Catch: Throwable -> L66
        if (openInCallWithNumber(r1, r19, r20, r3) != r4) goto L58;
        return r4;
    L58:
        r7 = r10;
        goto L78
    L54:
        r20 = false;
        goto L55
    L65:
        r9.close();
        goto L73
    L45:
        if (r13 == (-1)) goto L49;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithContacts cursor not have next id = " + r13);     // Catch: Throwable -> L66
        IntentResult r21 = new IntentResult(0, null, null, r10.getResources().getString(R.string.intents_inquire_further_phone_call_number_chose), false, false, IntentsUtilsKt.getUiTypeByName(r28.getContext(), 1, IntentsConstantKt.ACTIVITY_NAME_CONTACT_DETAIL), null, new FloatingIntentParams(null, null, null, 7, null), null, 694, null);     // Catch: Throwable -> L66
        r9.close();
        return r21;
    L39:
        if (r13 == (-1)) goto L42;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithContacts cursor null id = " + r13);     // Catch: Throwable -> L66
        return new IntentResult(0, null, null, r10.getResources().getString(R.string.intents_inquire_further_phone_call_number_chose), false, false, IntentsUtilsKt.getUiTypeByName(r28.getContext(), 1, IntentsConstantKt.ACTIVITY_NAME_CONTACT_DETAIL), null, new FloatingIntentParams(null, null, null, 7, null), null, 694, null);
    L66:
        th = th;
        r7 = r10;
    L25:
        r13 = -1;
    L7:
        r3 = new C02381(this, r31);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.obric.capabilitykit.common.DispatchContext] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private final Object openInCallWithNumber(DispatchContext r9, String r10, boolean r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof C02391) == false) goto L7;
        C02391 r1 = (C02391) r12;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r1.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r1.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L40:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r1.Z$0;
        Context r14 = (Context) r1.L$1;
        r10 = (String) r1.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: ActivityNotFoundException -> L18
        r9 = r14;
    L30:
        return Boxing.boxBoolean(true);
    L20:
        ResultKt.throwOnFailure(r8);
        boolean r15 = false;
        if (r10 == null) goto L42;
        Context r16 = r9.getContext();
        Intent r3 = DSUtils.getSelectSimDialogIntentIfNeeded(r16, null, r10, false, r11);
        ?? r17 = r16;
        if (r3 == null) goto L33;
        StringBuilder r7 = new StringBuilder("PhoneCallIntent#openInCallWithNumber show select sim dialog, isVideoCall=");     // Catch: ActivityNotFoundException -> L18
        if (r11 == false) goto L27;
        r15 = true;
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r7.append(r15).toString());     // Catch: ActivityNotFoundException -> L18
        MainCoroutineDispatcher r18 = Dispatchers.getMain().getImmediate();     // Catch: ActivityNotFoundException -> L18
        PhoneCallIntent$openInCallWithNumber$2$1 r0 = new PhoneCallIntent$openInCallWithNumber$2$1(r16, r3, null);     // Catch: ActivityNotFoundException -> L18
        r1.L$0 = r10;     // Catch: ActivityNotFoundException -> L18
        r1.L$1 = r16;     // Catch: ActivityNotFoundException -> L18
        r1.Z$0 = r11;     // Catch: ActivityNotFoundException -> L18
        r1.label = 1;     // Catch: ActivityNotFoundException -> L18
        r9 = r16;
        if (BuildersKt.withContext(r18, r0, r1) != r13) goto L30;
        return r13;
    L33:
        if (r11 == false) goto L35;
        Intent r19 = ContactsIntentUtils.newDialVoltePhoneIntent(r10);
    L36:
        MainCoroutineDispatcher r110 = Dispatchers.getMain().getImmediate();
        PhoneCallIntent$openInCallWithNumber$2$2 r111 = new PhoneCallIntent$openInCallWithNumber$2$2(r19, r17, null);
        r1.L$0 = null;
        r1.L$1 = null;
        r1.label = 2;
        if (BuildersKt.withContext(r110, r111, r1) != r13) goto L40;
        return r13;
    L35:
        r19 = ContactsIntentUtils.newDialNumberIntent(r10);
        goto L36
    L42:
        return Boxing.boxBoolean(false);
    L18:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithNumber open select sim activity failed", e);
        r17 = r9;
    L7:
        r1 = new C02391(this, r12);
        goto L8
    }
}
