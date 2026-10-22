package com.obric.appintents.contacts;

import android.content.Context;
import android.os.Parcelable;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.util.BlackListQueryHandler;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.intent.BaseContactsAddToBlocklistIntent;
import com.obric.capabilitykit.common.intent.BlockListTarget;
import com.obric.capabilitykit.common.intent.ContactsAddToBlocklistParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ContactsAddToBlocklistIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/obric/appintents/contacts/ContactsAddToBlocklistIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsAddToBlocklistIntent;", "()V", "blackAction", "", "context", "Landroid/content/Context;", "phoneNumberList", "", "", "isAdd", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/Boolean;)Z", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "isSuccess", "updateDetail", "add", "(Landroid/content/Context;Ljava/lang/Boolean;)Ljava/lang/String;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsAddToBlocklistIntent extends BaseContactsAddToBlocklistIntent {
    public ContactsAddToBlocklistIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsAddToBlocklistIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<BlockListTarget>> r3) {
        return doAction((ContactsAddToBlocklistParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsAddToBlocklistIntent
    public Object doAction(ContactsAddToBlocklistParams r16, DispatchContext r17, Continuation<? super IntentResult<BlockListTarget>> r18) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r17.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r17);
        return new IntentResult(201, null, null, r17.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        Boolean r4 = r16.isAdd();
        if (r4 == null) goto L9;
        boolean r5 = r4.booleanValue();
    L10:
        Context r6 = r17.getContext();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent call isAdd: " + r5);
        BlockListTarget r7 = r16.getTarget();
        if (r7 == null) goto L16;
        String r8 = r7.getTelephone();
        if (r8 == null) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent add telephone");
        return result(r17.getContext(), r16, blackAction(r6, CollectionsKt.listOf(r8), Boxing.boxBoolean(r5)));
    L16:
        BlockListTarget r9 = r16.getTarget();
        if (r9 == null) goto L30;
        ContactEntity r10 = r9.getContact();
        if (r10 == null) goto L30;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent add contact");
        List<MetaTelephone> r3 = r10.getTelephones();
        if (r3 == null) goto L27;
        List<MetaTelephone> r11 = r3;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        r12.add(((MetaTelephone) r13.next()).getTelephone());
        goto L24
    L26:
        ArrayList r14 = r12;
    L29:
        return result(r17.getContext(), r16, blackAction(r6, r14, Boxing.boxBoolean(r5)));
    L27:
        r14 = CollectionsKt.emptyList();
    L30:
        BlockListTarget r15 = r16.getTarget();
        if (r15 == null) goto L37;
        CallHistoryEntity r19 = r15.getCallHistory();
        if (r19 == null) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent add callHistory");
        return result(r17.getContext(), r16, blackAction(r6, r19.getTelephones(), Boxing.boxBoolean(r5)));
    L37:
        return result(r17.getContext(), r16, false);
    L9:
        r5 = false;
        goto L10
    }

    private final String updateDetail(Context r1, Boolean r2) {
        if (Intrinsics.areEqual(r2, true) == false) goto L5;
        String r0 = r1.getResources().getString(R.string.intents_inquire_further_contacts_add_to_black_success);
        Intrinsics.checkNotNullExpressionValue(r0, "{\n            context.re…_black_success)\n        }");
        return r0;
    L5:
        String r3 = r1.getResources().getString(R.string.intents_inquire_further_contacts_delete_black);
        Intrinsics.checkNotNullExpressionValue(r3, "{\n            context.re…s_delete_black)\n        }");
        return r3;
    }

    private final IntentResult<BlockListTarget> result(Context r18, ContactsAddToBlocklistParams r19, boolean r20) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent result isSuccess: " + r20);
        Boolean r1 = r19.isAdd();
        int r2 = 0;
        if (r1 == null) goto L5;
        boolean r3 = r1.booleanValue();
    L6:
        if (r20 == false) goto L8;
        String r4 = updateDetail(r18, Boolean.valueOf(r3));
    L9:
        String r8 = r4;
        if (r20 == false) goto L12;
        BlockListTarget r5 = r19.getTarget();
    L13:
        BlockListTarget r6 = r5;
        if (r20 == true) goto L18;
        r2 = 1001;
    L18:
        return new IntentResult(r2, r6, null, r8, false, false, 1, null, new FloatingIntentParams(null, null, null, 7, null), null, 692, null);
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = r18.getResources().getString(R.string.intents_inquire_further_contacts_add_to_black);
        Intrinsics.checkNotNullExpressionValue(r4, "{\n            context.re…s_add_to_black)\n        }");
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    private final boolean blackAction(Context r4, List<String> r5, Boolean r6) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "ContactsAddToBlocklistIntent blackAction isAdd: " + r6);
        List<String> r3 = r5;
        if (r3 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return false;
    L11:
        BlackListQueryHandler r8 = (BlackListQueryHandler) BuildersKt.runBlocking(Dispatchers.getMain(), new ContactsAddToBlocklistIntent$blackAction$blacklistManager$1(r4, null));
        Iterator<T> r9 = r5.iterator();
    L13:
        if (r9.hasNext() == false) goto L18;
        String r10 = (String) r9.next();
        if (Intrinsics.areEqual(r6, true) == true) goto L16;
        r8.doRemoveBlacklistAction(r10);
        goto L13
    L16:
        r8.doJoinBlacklistAction(r10);
        goto L13
    L18:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }
}
