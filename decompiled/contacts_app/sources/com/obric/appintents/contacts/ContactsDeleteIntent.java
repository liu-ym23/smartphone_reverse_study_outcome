package com.obric.appintents.contacts;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseContactsDeleteIntent;
import com.obric.capabilitykit.common.intent.ContactsDeleteParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: compiled from: ContactsDeleteIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J-\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/appintents/contacts/ContactsDeleteIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsDeleteIntent;", "()V", "deleteContacts", "", "context", "Landroid/content/Context;", "deleteIds", "", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsDeleteIntent extends BaseContactsDeleteIntent {
    public ContactsDeleteIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsDeleteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<ContactEntity[]>> r3) {
        return doAction((ContactsDeleteParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsDeleteIntent
    public Object doAction(ContactsDeleteParams r16, DispatchContext r17, Continuation<? super IntentResult<ContactEntity[]>> r18) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r17.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsDeleteIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r17);
        return new IntentResult(201, null, null, r17.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsDeleteIntent#doAction call");
        ContactEntity[] r4 = r16.getTargets();
        if (r4 == null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsDeleteIntent#doAction size = " + r4.length);
        Context r0 = r17.getContext();
        ArrayList r1 = new ArrayList(r4.length);
        int r3 = r4.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L11;
        r1.add(Boxing.boxLong(Long.parseLong(r4[r5].getId())));
        r5 = r5 + 1;
        goto L9
    L11:
        deleteContacts(r0, r1);
        return new IntentResult(0, r4, null, r17.getContext().getResources().getString(R.string.intents_inquire_further_phone_delete_done), false, false, 1, null, null, null, 948, null);
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsDeleteIntent#doAction null params");
        return new IntentResult(0, null, null, r17.getContext().getResources().getString(R.string.intents_inquire_further_delete_contacts), false, false, 1, null, null, null, 950, null);
    }

    private final boolean deleteContacts(Context r7, List<Long> r8) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsDeleteIntent#deleteContacts call deleteIds " + r8);
        List<Long> r6 = r8;
        if (r6 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsDeleteIntent#deleteContacts return deleteIds " + r8);
        return false;
    L12:
        Iterator<T> r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L19;
        long r3 = ((Number) r10.next()).longValue();
        List<Long> r11 = IntentsUtilsKt.getRawContactIdsByContactId(r7, r3);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsDeleteIntent#deleteContacts contactId " + r3 + " has " + r11.size() + " raw contact(s)");
        Iterator<T> r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L14;
        Uri r1 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ((Number) r12.next()).longValue()).buildUpon().build();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsDeleteIntent#deleteContacts delete rawContactUri " + r1);
        r7.startService(ContactSaveService.createDeleteRawContactIntent(r7, r1));
        goto L17
    L19:
        return true;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r9 = false;
        goto L9
    }
}
