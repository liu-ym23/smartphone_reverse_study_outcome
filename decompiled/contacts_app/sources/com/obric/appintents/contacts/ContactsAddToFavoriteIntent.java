package com.obric.appintents.contacts;

import android.content.Context;
import android.os.Parcelable;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseContactsAddToFavoriteIntent;
import com.obric.capabilitykit.common.intent.ContactsAddToFavoriteParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContactsAddToFavoriteIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/obric/appintents/contacts/ContactsAddToFavoriteIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsAddToFavoriteIntent;", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDetail", "", "context", "Landroid/content/Context;", "updateFavouriteStatus", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsAddToFavoriteIntent extends BaseContactsAddToFavoriteIntent {
    public ContactsAddToFavoriteIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsAddToFavoriteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<ContactEntity>> r3) {
        return doAction((ContactsAddToFavoriteParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsAddToFavoriteIntent
    public Object doAction(ContactsAddToFavoriteParams r18, DispatchContext r19, Continuation<? super IntentResult<ContactEntity>> r20) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r19.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsAddToFavoriteIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r19);
        return new IntentResult(201, null, null, r19.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsAddToFavoriteIntent#doAction call");
        ContactEntity r4 = r18.getTarget();
        boolean r5 = false;
        if (r4 == null) goto L13;
        List<MetaTelephone> r6 = r4.getTelephones();
        if (r6 == null) goto L13;
        if (r6.isEmpty() == true) goto L13;
        r5 = true;
    L13:
        if (r5 == false) goto L26;
        ContactEntity r7 = r18.getTarget();
        if (r7 == null) goto L24;
        String r8 = r7.getId();
        if (r8 == null) goto L24;
        Long r9 = StringsKt.toLongOrNull(r8);
        if (r9 == null) goto L24;
        long r10 = r9.longValue();
        if (IntentsUtilsKt.isProfileContacts(r19.getContext(), r10) == false) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsAddToFavoriteIntent#doAction contact is profile contact, id " + r10);
        return new IntentResult(1, null, null, r19.getContext().getString(R.string.unabletostarred), false, false, 1, null, null, null, 948, null);
    L24:
        updateFavouriteStatus(r19.getContext(), r18);
        return new IntentResult(0, r18.getTarget(), null, updateDetail(r19.getContext(), r18), false, false, 1, null, null, null, 948, null);
    L26:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsAddToFavoriteIntent#doAction target is null");
        return new IntentResult(1001, null, null, null, false, false, 0, null, null, null, 1022, null);
    }

    private final void updateFavouriteStatus(Context r4, ContactsAddToFavoriteParams r5) {
        ContactEntity r3 = r5.getTarget();
        if (r3 == null) goto L12;
        List<MetaTelephone> r6 = r3.getTelephones();
        if (r6 == null) goto L12;
        List<MetaTelephone> r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r1.add(((MetaTelephone) r8.next()).getTelephone());
        goto L8
    L10:
        String[] r9 = (String[]) r1.toArray(new String[0]);
        if (r9 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r5.isAdd(), true) == false) goto L16;
        ContactSaveService.FavoriteAction r10 = ContactSaveService.FavoriteAction.ADD;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsAddToFavoriteIntent#updateFavouriteStatus action = " + r10);
        ContactSaveService.setPhoneStarted(r4, r9, r10);
        return;
    L16:
        r10 = ContactSaveService.FavoriteAction.REMOVE;
    L12:
        r9 = new String[0];
        goto L14
    }

    private final String updateDetail(Context r1, ContactsAddToFavoriteParams r2) {
        if (Intrinsics.areEqual(r2.isAdd(), true) == false) goto L5;
        String r0 = r1.getResources().getString(R.string.intents_inquire_further_contacts_start_success);
    L6:
        Intrinsics.checkNotNullExpressionValue(r0, "if(params.isAdd == true)…tacts_un_start)\n        }");
        return r0;
    L5:
        r0 = r1.getResources().getString(R.string.intents_inquire_further_contacts_un_start);
        goto L6
    }
}
