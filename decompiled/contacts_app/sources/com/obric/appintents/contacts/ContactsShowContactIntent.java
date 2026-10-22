package com.obric.appintents.contacts;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent;
import com.obric.capabilitykit.common.intent.ContactsShowContactParams;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContactsShowContactIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/obric/appintents/contacts/ContactsShowContactIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsShowContactIntent;", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsShowContactParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsShowContactParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsShowContactIntent extends BaseContactsShowContactIntent {
    public ContactsShowContactIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((ContactsShowContactParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent
    public Object doAction(ContactsShowContactParams r17, DispatchContext r18, Continuation<? super IntentResult<Empty>> r19) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r18.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsShowContactIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r18);
        return new IntentResult(201, null, null, r18.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        ContactEntity r1 = r17.getTarget();
        if (r1 == null) goto L20;
        String r2 = r1.getId();
        if (r2 == null) goto L20;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L20;
        long r4 = r3.longValue();
        if (IntentsUtilsKt.isNormalContacts(r18.getContext(), r4) == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "call normal contacts call:[" + r4 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        Intent r5 = IntentsUtilsKt.getContactDetailFragmentIntent(r18, IntentsUtilsKt.getRawContactsIdByRawContactId(r18.getContext(), r4), null);
        r5.addFlags(32768);
        r18.getContext().startActivity(r5);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
    L17:
        if (IntentsUtilsKt.isProfileContacts(r18.getContext(), r4) == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "call profile contacts call:[" + r4 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        Uri r6 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r4);
        Intrinsics.checkNotNullExpressionValue(r6, "withAppendedId(personUri, it)");
        Intent r7 = ContactsIntentUtils.launchContactDetailIntent(r18.getContext(), r6, true);
        IntentsUtilsKt.getActivityByClassNameIntent(r18, r7);
        r18.getContext().startActivity(r7);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsShowContactIntent#doAction no contacts");
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    }
}
