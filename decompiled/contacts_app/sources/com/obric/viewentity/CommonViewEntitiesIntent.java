package com.obric.viewentity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.GlobalProxyLancet;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.CommonViewEntitiesParams;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommonViewEntitiesIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/obric/viewentity/CommonViewEntitiesIntent;", "Lcom/obric/capabilitykit/common/intent/BaseCommonViewEntitiesIntent;", "()V", "TAG", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startActivityByEntity", "Landroid/content/Intent;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonViewEntitiesIntent extends BaseCommonViewEntitiesIntent {
    private final String TAG;

    public CommonViewEntitiesIntent() {
        this.TAG = "CommonViewEntitiesIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((CommonViewEntitiesParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent
    public Object doAction(CommonViewEntitiesParams r16, DispatchContext r17, Continuation<? super IntentResult<Empty>> r18) {
        Intent r0 = startActivityByEntity(r16, r17);
        IntentResult r14 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, 1022, null);
        r14.setUiType(r14.getUiType() | 4194304);
        r14.setIntent(r0);
        r14.setFloatingIntentParams(new FloatingIntentParams(null, null, null, 7, null));
        return r14;
    }

    private final Intent startActivityByEntity(CommonViewEntitiesParams r17, DispatchContext r18) {
        Integer r2 = r17.getIndex();
        if (r2 == null) goto L43;
        int r3 = r2.intValue();
        AppEntity[] r4 = r17.getEntities();
        if (r4 == null) goto L44;
        AppEntity r5 = (AppEntity) ArraysKt.getOrNull(r4, r3);
        if (r5 == null) goto L47;
        int r6 = r5.getType();
        long r7 = Long.parseLong(r5.getId());
        String r8 = this.TAG;
        StringBuilder r9 = new StringBuilder("startActivityByEntity, index = [").append(r3).append("], currentType = [").append(r6).append("], id = [").append(r7).append("], size = [");
        AppEntity[] r10 = r17.getEntities();
        if (r10 == null) goto L12;
        Integer r11 = Integer.valueOf(r10.length);
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(r8, r9.append(r11).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString());
        if (r6 != 201) goto L16;
        Intent r12 = IntentsUtilsKt.getContactDetailFragmentIntent(r18, IntentsUtilsKt.getRawContactsIdByRawContactId(r18.getContext(), r7), null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(this.TAG, "contacts contacts:[" + r7 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        return r12;
    L16:
        if (r6 == 202) goto L19;
        return null;
    L19:
        if ((r5 instanceof CallHistoryEntity) == false) goto L21;
        CallHistoryEntity r13 = (CallHistoryEntity) r5;
    L22:
        if (r13 == null) goto L45;
        List<ContactEntity> r14 = r13.getContacts();
        if (r14 == null) goto L32;
        ContactEntity r15 = (ContactEntity) CollectionsKt.getOrNull(r14, 0);
        if (r15 == null) goto L32;
        String r16 = r15.getId();
        if (r16 == null) goto L32;
        Long r19 = StringsKt.toLongOrNull(r16);
        if (r19 == null) goto L32;
        long r110 = r19.longValue();
    L33:
        String r20 = (String) CollectionsKt.getOrNull(r13.getTelephones(), 0);
        long[] r21 = new long[1];
        if (r7 == (-1)) goto L37;
        r21[0] = r7;
    L37:
        if (r110 != (-1)) goto L39;
        Intent r22 = IntentsUtilsKt.getActivityIntent(r18.getContext(), IntentsConstantKt.ACTIVITY_NAME_CONTACT_DETAIL, null, null);
        r22.putExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS, r21);
        r22.putExtra("phone", r20);
        r22.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r20);
        Intent r1 = IntentsUtilsKt.getActivityByClassNameIntent(r18, r22);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(this.TAG, "call stranger call:[" + r21 + DefaultContactListAdapter.SNIPPET_END_MATCH);
    L46:
        return r1;
    L39:
        Uri r23 = ContentUris.withAppendedId(Uri.parse("content://contacts/people?currentTime=" + System.currentTimeMillis()), IntentsUtilsKt.getRawContactsIdByRawContactId(r18.getContext(), r110));
        Intrinsics.checkNotNullExpressionValue(r23, "withAppendedId(legacyContentUri, rawContactId)");
        Intent r24 = ContactsIntentUtils.launchContactDetailIntent(r18.getContext(), r23, true);
        r24.putExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS, r21);
        r24.putExtra("phone", r20);
        r24.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r20);
        r1 = IntentsUtilsKt.getActivityByClassNameIntent(r18, r24);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(this.TAG, "call contacts call:[" + r21 + "] contacts:[" + r110 + DefaultContactListAdapter.SNIPPET_END_MATCH);
    L32:
        r110 = -1;
        goto L33
    L45:
        return null;
    L21:
        r13 = null;
        goto L22
    L12:
        r11 = null;
        goto L13
    L47:
        return null;
    L44:
        return null;
    L43:
        return null;
    }
}
