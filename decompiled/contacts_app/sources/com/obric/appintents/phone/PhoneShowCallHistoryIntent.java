package com.obric.appintents.phone;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PhoneShowCallHistoryParams;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.privacy.PrivacyUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PhoneShowCallHistoryIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/obric/appintents/phone/PhoneShowCallHistoryIntent;", "Lcom/obric/capabilitykit/common/intent/BasePhoneShowCallHistoryIntent;", "()V", "createContactDetailIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "contactUri", "Landroid/net/Uri;", "ids", "", "number", "", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "createDefaultIntent", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/PhoneShowCallHistoryParams;", "(Lcom/obric/capabilitykit/common/intent/PhoneShowCallHistoryParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCallLogExtras", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneShowCallHistoryIntent extends BasePhoneShowCallHistoryIntent {
    public PhoneShowCallHistoryIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((PhoneShowCallHistoryParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent
    public Object doAction(PhoneShowCallHistoryParams r17, DispatchContext r18, Continuation<? super IntentResult<Empty>> r19) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r18.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "PhoneShowCallHistoryIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r18);
        return new IntentResult(201, null, null, r18.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        CallHistoryEntity r1 = r17.getTarget();
        if (r1 == null) goto L37;
        long r3 = Long.parseLong(r1.getId());
        if (IntentsUtilsKt.hasCallLog(r18.getContext(), r3) == true) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneShowCallHistoryIntent#doAction no call log id: " + r3);
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    L12:
        List<ContactEntity> r5 = r1.getContacts();
        if (r5 == null) goto L21;
        ContactEntity r6 = (ContactEntity) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L21;
        String r7 = r6.getId();
        if (r7 == null) goto L21;
        Long r8 = StringsKt.toLongOrNull(r7);
        if (r8 == null) goto L21;
        long r10 = r8.longValue();
    L22:
        String r9 = (String) CollectionsKt.getOrNull(r1.getTelephones(), 0);
        long[] r12 = new long[1];
        if (r3 == (-1)) goto L25;
        r12[0] = r3;
    L25:
        Context r2 = r18.getContext();
        if (r10 != (-1)) goto L28;
        Intent r0 = createDefaultIntent(r2, r12, r9, r18);
    L35:
        r0.addFlags(32768);
        r18.getContext().startActivity(r0);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
    L28:
        if (IntentsUtilsKt.isNormalContacts(r2, r10) == false) goto L31;
        long r13 = IntentsUtilsKt.getRawContactsIdByRawContactId(r2, r10);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "call normal contacts call:[" + r12 + "] contacts:[" + r10 + "]，rawContactId:[" + r13 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        Uri r4 = ContentUris.withAppendedId(Uri.parse("content://contacts/people?currentTime=" + System.currentTimeMillis()), r13);
        Intrinsics.checkNotNullExpressionValue(r4, "withAppendedId(\n        …                        )");
        r0 = createContactDetailIntent(r2, r4, r12, r9, r18);
        goto L35
    L31:
        if (IntentsUtilsKt.isProfileContacts(r2, r10) == false) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "call profile contacts call:[" + r12 + "] contacts:[" + r10 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        Uri r11 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r10);
        Intrinsics.checkNotNullExpressionValue(r11, "withAppendedId(\n        …                        )");
        r0 = createContactDetailIntent(r2, r11, r12, r9, r18);
        goto L35
    L33:
        r0 = createDefaultIntent(r2, r12, r9, r18);
    L21:
        r10 = -1;
        goto L22
    L37:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneShowCallHistoryIntent#doAction no call log params.target is null");
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    }

    private final Intent createContactDetailIntent(Context r2, Uri r3, long[] r4, String r5, DispatchContext r6) {
        Intent r7 = ContactsIntentUtils.launchContactDetailIntent(r2, r3, true);
        Intrinsics.checkNotNullExpressionValue(r7, "launchContactDetailInten…ontext, contactUri, true)");
        return IntentsUtilsKt.getActivityByClassNameIntent(r6, addCallLogExtras(r7, r4, r5));
    }

    private final Intent createDefaultIntent(Context r3, long[] r4, String r5, DispatchContext r6) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "call stranger call:[" + r4 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        Intent r7 = IntentsUtilsKt.getActivityIntent(r3, IntentsConstantKt.ACTIVITY_NAME_CONTACT_DETAIL, null, null);
        r7.setAction("android.intent.action.VIEW");
        r7.putExtra(ContactDetailActivity.EXTRA_LAUNCH_FROM_SELF, true);
        addCallLogExtras(r7, r4, r5);
        return IntentsUtilsKt.getActivityByClassNameIntent(r6, r7);
    }

    private final Intent addCallLogExtras(Intent r1, long[] r2, String r3) {
        r1.putExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS, r2);
        r1.putExtra("phone", r3);
        r1.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r3);
        return r1;
    }
}
