package com.obric.appintents.contacts;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.common.model.dataitem.CardIdDataItem;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.obricsync.FormatPhoneNumberUtil;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseContactsCreateIntent;
import com.obric.capabilitykit.common.intent.ContactsCreateParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Telephone;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ContactsCreateIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J5\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/appintents/contacts/ContactsCreateIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsCreateIntent;", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultTypeAndLabel", "Lkotlin/Pair;", "", "", "context", "Landroid/content/Context;", "mimeType", "getPhoneTypeAndLabel", "type", "getSuccessDetail", "insertContactItemData", "Landroid/content/ContentProviderOperation;", "value", GroupDeletionDialogFragment.ARG_LABEL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroid/content/ContentProviderOperation;", "insertItem", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsCreateIntent extends BaseContactsCreateIntent {
    public static final String CREATE_TEL_TYPE_HOME = "HOME";
    public static final String CREATE_TEL_TYPE_MOBILE = "MOBILE";
    public static final String CREATE_TEL_TYPE_WORK = "WORK";
    public static final Companion Companion = null;
    public static final String GANDER_FEMALE = "女";
    public static final String GANDER_MALE = "男";

    /* JADX INFO: compiled from: ContactsCreateIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/appintents/contacts/ContactsCreateIntent$Companion;", "", "()V", "CREATE_TEL_TYPE_HOME", "", "CREATE_TEL_TYPE_MOBILE", "CREATE_TEL_TYPE_WORK", "GANDER_FEMALE", "GANDER_MALE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public ContactsCreateIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsCreateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<ContactEntity>> r3) {
        return doAction((ContactsCreateParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsCreateIntent
    public Object doAction(ContactsCreateParams r16, DispatchContext r17, Continuation<? super IntentResult<ContactEntity>> r18) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r17.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsCreateIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r17);
        return new IntentResult(201, null, null, r17.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsCreateIntent#doAction");
        ContactEntity r0 = insertItem(r17.getContext(), r16);
        if (r0 == null) goto L9;
        String r2 = getSuccessDetail(r16);
    L10:
        String r6 = r2;
        StringBuilder r3 = new StringBuilder("ContactsCreateIntent#doAction detail = ");
        if (r6.length() != 0) goto L13;
        boolean r4 = true;
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r3.append(r4).toString());
        return new IntentResult(0, r0, null, r6, false, false, 1, null, null, null, 948, null);
    L13:
        r4 = false;
        goto L14
    L9:
        r2 = r17.getContext().getString(R.string.intents_contacts_create_fail);
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            dispatchCo…ts_create_fail)\n        }");
        goto L10
    }

    private final ContactEntity insertItem(Context r17, ContactsCreateParams r18) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem");
        ArrayList<ContentProviderOperation> r2 = new ArrayList();
        Ref.LongRef r4 = new Ref.LongRef();
        r4.element = -1;
        ContentValues r7 = new ContentValues();
        r7.put("aggregation_mode", "2");
        r7.put("account_name", "default");
        r7.put("account_type", ContactsUtils.LOCAL_ACCOUNT_TYPE);
        r2.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI.buildUpon().build()).withValues(r7).build());
        String r8 = r18.getName();
        if (r8 != null) goto L5;
    L8:
        boolean r9 = true;
    L10:
        if (r9 == true) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem name");
        r2.add(insertContactItemData("vnd.android.cursor.item/name", r18.getName(), null, null));
    L12:
        String r10 = r18.getCompany();
        if (r10 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem company");
        r2.add(insertContactItemData("vnd.android.cursor.item/organization", r18.getCompany(), null, null));
    L21:
        String r12 = r18.getNote();
        if (r12 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L30;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem note");
        r2.add(insertContactItemData("vnd.android.cursor.item/note", r18.getNote(), null, null));
    L30:
        Telephone[] r14 = r18.getTelephones();
        if (r14 == null) goto L41;
        int r15 = r14.length;
        int r16 = 0;
    L33:
        if (r16 >= r15) goto L41;
        Telephone r19 = r14[r16];
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem telephones");
        String r110 = r19.getNumber();
        if (r110 == null) goto L40;
        String r111 = FormatPhoneNumberUtil.Companion.format(r110);
        if (r111 == null) goto L40;
        Pair<Integer, String> r112 = getPhoneTypeAndLabel(r17, r19.getType());
        int r113 = r112.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/phone_v2", r111, Integer.valueOf(r113), r112.component2()));
    L40:
        r16 = r16 + 1;
    L41:
        String r5 = r18.getEmail();
        if (r5 != null) goto L44;
    L47:
        boolean r6 = true;
    L48:
        if (r6 == true) goto L50;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem email");
        Pair<Integer, String> r20 = getDefaultTypeAndLabel(r17, "vnd.android.cursor.item/email_v2");
        int r21 = r20.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/email_v2", r18.getEmail(), Integer.valueOf(r21), r20.component2()));
    L50:
        String r22 = r18.getIdentifyCard();
        if (r22 != null) goto L53;
    L56:
        boolean r23 = true;
    L57:
        if (r23 == true) goto L59;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem identifyCard");
        Pair<Integer, String> r24 = getDefaultTypeAndLabel(r17, "vnd.android.cursor.item/card_id");
        int r25 = r24.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/card_id", r18.getIdentifyCard(), Integer.valueOf(r25), r24.component2()));
    L59:
        String r26 = r18.getGender();
        if (r26 != null) goto L62;
    L65:
        boolean r27 = true;
    L66:
        if (r27 == true) goto L68;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem gender");
        r7.clear();
        r7.put("mimetype", "vnd.android.cursor.item/gender");
        r7.put(IntentsConstantKt.getContactValueColumnName().get("vnd.android.cursor.item/gender"), Integer.valueOf(IntentsUtilsKt.getGanderByString(r18.getGender())));
        ContentProviderOperation.Builder r28 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().build());
        Intrinsics.checkNotNullExpressionValue(r28, "newInsert(u)");
        r2.add(r28.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0).withValues(r7).build());
    L68:
        String r29 = r18.getBirthday();
        if (r29 != null) goto L71;
    L74:
        boolean r30 = true;
    L75:
        if (r30 == true) goto L77;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem birthday");
        Pair<Integer, String> r31 = getDefaultTypeAndLabel(r17, "vnd.android.cursor.item/contact_event");
        int r32 = r31.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/contact_event", r18.getBirthday(), Integer.valueOf(r32), r31.component2()));
    L77:
        String r33 = r18.getRelationship();
        if (r33 != null) goto L80;
    L83:
        boolean r34 = true;
    L84:
        if (r34 == true) goto L86;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem relationship");
        Pair<Integer, String> r35 = getDefaultTypeAndLabel(r17, "vnd.android.cursor.item/relation");
        int r36 = r35.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/relation", r18.getRelationship(), Integer.valueOf(r36), r35.component2()));
    L86:
        String r37 = r18.getAddress();
        if (r37 != null) goto L89;
    L92:
        boolean r38 = true;
    L93:
        if (r38 == true) goto L111;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem address");
        Pair<Integer, String> r39 = getDefaultTypeAndLabel(r17, "vnd.android.cursor.item/postal-address_v2");
        int r40 = r39.component1().intValue();
        r2.add(insertContactItemData("vnd.android.cursor.item/postal-address_v2", r18.getAddress(), Integer.valueOf(r40), r39.component2()));
    L111:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L97
        ContactsCreateIntent r0 = this;     // Catch: Throwable -> L97
        Object r1 = Result.m803constructorimpl(r17.getContentResolver().applyBatch("com.android.contacts", r2));     // Catch: Throwable -> L97
    L100:
        if (Result.m810isSuccessimpl(r1) == false) goto L106;
        Uri r3 = ((ContentProviderResult[]) r1)[0].uri;
        if (r3 == null) goto L104;
        long r42 = Long.valueOf(ContentUris.parseId(r3)).longValue();
    L105:
        r4.element = r42;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem success id = " + r4.element + " , uri = " + r3);
        goto L106
    L104:
        r42 = -1;
    L106:
        Throwable r43 = Result.m806exceptionOrNullimpl(r1);
        if (r43 == null) goto L109;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#insertItem fail " + r43);
    L109:
        ContentResolver r44 = r17.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r44, "context.contentResolver");
        return (ContactEntity) CollectionsKt.firstOrNull(ContactEntityUtilKt.queryContactsByIds(r44, CollectionsKt.listOf(Long.valueOf(r4.element)), false, true));
    L97:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r1 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L100
    L89:
        if (r37.length() == 0) goto L92;
        r38 = false;
        goto L93
    L80:
        if (r33.length() == 0) goto L83;
        r34 = false;
        goto L84
    L71:
        if (r29.length() == 0) goto L74;
        r30 = false;
        goto L75
    L62:
        if (r26.length() == 0) goto L65;
        r27 = false;
        goto L66
    L53:
        if (r22.length() == 0) goto L56;
        r23 = false;
        goto L57
    L44:
        if (r5.length() == 0) goto L47;
        r6 = false;
        goto L48
    L24:
        if (r12.length() == 0) goto L27;
        r13 = false;
        goto L28
    L15:
        if (r10.length() == 0) goto L18;
        r11 = false;
        goto L19
    L5:
        if (r8.length() == 0) goto L8;
        r9 = false;
        goto L10
    }

    private final ContentProviderOperation insertContactItemData(String r3, String r4, Integer r5, String r6) {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().build());
        Intrinsics.checkNotNullExpressionValue(r2, "newInsert(sqlUri)");
        ContentValues r0 = new ContentValues();
        r0.put("mimetype", r3);
        r0.put(IntentsConstantKt.getContactValueColumnName().get(r3), r4);
        if (r5 == null) goto L5;
        int r7 = r5.intValue();
        r0.put(IntentsConstantKt.getContactTypeColumnName().get(r3), Integer.valueOf(r7));
    L5:
        if (r6 == null) goto L7;
        r0.put(IntentsConstantKt.getContactLabelColumnName().get(r3), r6);
    L7:
        ContentProviderOperation r8 = r2.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0).withValues(r0).build();
        Intrinsics.checkNotNullExpressionValue(r8, "contentProviderOperation…ues)\n            .build()");
        return r8;
    }

    private final Pair<Integer, String> getDefaultTypeAndLabel(Context r2, String r3) {
        Integer r1 = IntentsConstantKt.getContactTypeDefaultValue().get(r3);
        if (r1 == null) goto L5;
        int r4 = r1.intValue();
    L6:
        if (r3 != null) goto L8;
    L33:
        String r5 = "其他";
    L34:
        Intrinsics.checkNotNullExpressionValue(r5, "when (mimeType){\n       …\"\n            }\n        }");
        return new Pair(Integer.valueOf(r4), r5);
    L8:
        switch(r3.hashCode()) {
            case -1569536764: goto L30;
            case -1328682538: goto L26;
            case -601229436: goto L23;
            case -213986043: goto L19;
            case 950831081: goto L15;
            case 1409846529: goto L11;
            default: goto L33;
        };
    L11:
        if (r3.equals("vnd.android.cursor.item/relation") == false) goto L33;
        r5 = r2.getString(ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(r4));
        goto L34
    L15:
        if (r3.equals("vnd.android.cursor.item/im") == false) goto L33;
        r5 = r2.getString(ContactsContract.CommonDataKinds.Im.getTypeLabelResource(r4));
        goto L34
    L19:
        if (r3.equals("vnd.android.cursor.item/card_id") == false) goto L33;
        r5 = r2.getString(CardIdDataItem.getTypeLabelResource(r4));
        goto L34
    L23:
        if (r3.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L33;
        r5 = r2.getString(ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabelResource(r4));
        goto L34
    L26:
        if (r3.equals("vnd.android.cursor.item/contact_event") == false) goto L33;
        r5 = r2.getString(ContactsContract.CommonDataKinds.Event.getTypeResource(Integer.valueOf(r4)));
        goto L34
    L30:
        if (r3.equals("vnd.android.cursor.item/email_v2") == false) goto L33;
        r5 = r2.getString(ContactsContract.CommonDataKinds.Email.getTypeLabelResource(r4));
        goto L34
    L5:
        r4 = 1;
        goto L6
    }

    private final Pair<Integer, String> getPhoneTypeAndLabel(Context r2, String r3) {
        if (r3 == null) goto L21;
        int r1 = r3.hashCode();
        if (r1 == (-2015525726)) goto L19;
        if (r1 == 2223327) goto L15;
        if (r1 != 2670353) goto L21;
        if (r3.equals("WORK") == false) goto L21;
        int r4 = 3;
    L22:
        String r5 = r2.getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(r4));
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(Contac…peLabelResource(newType))");
        return new Pair(Integer.valueOf(r4), r5);
    L15:
        if (r3.equals("HOME") == false) goto L21;
        r4 = 1;
        goto L22
    L19:
        if (r3.equals(CREATE_TEL_TYPE_MOBILE) == false) goto L21;
        r4 = 2;
    L21:
        r4 = 0;
        goto L22
    }

    private final String getSuccessDetail(ContactsCreateParams r18) {
        boolean r2 = false;
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(CREATE_TEL_TYPE_MOBILE, "手机号"), TuplesKt.to("WORK", "工作号"), TuplesKt.to("HOME", "住宅号")});
        String r1 = r18.getName();
        String r5 = "";
        if (r1 != null) goto L5;
    L14:
        String r3 = "";
    L15:
        Telephone[] r6 = r18.getTelephones();
        if (r6 == null) goto L27;
        ArrayList r7 = new ArrayList();
        int r8 = r6.length;
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L26;
        Telephone r10 = r6[r9];
        String r11 = (String) r0.get(r10.getType());
        if (r11 == null) goto L22;
        String r12 = r11 + 26159 + r10.getNumber();
    L23:
        if (r12 == null) goto L25;
        r7.add(r12);
    L25:
        r9 = r9 + 1;
        goto L18
    L22:
        r12 = null;
        goto L23
    L26:
        ArrayList r13 = r7;
    L29:
        if (r3.length() <= 0) goto L31;
        boolean r4 = true;
    L33:
        if (r4 == true) goto L35;
    L37:
        StringBuilder r14 = new StringBuilder();
        r14.append(r3);
        r14.append(r5);
        r14.append(CollectionsKt.joinToString$default(r13, "，", null, null, 0, null, null, 62, null));
        if (r14.length() <= 0) goto L40;
        boolean r15 = true;
    L41:
        if (r15 == false) goto L43;
        String r16 = "的联系人";
    L44:
        r14.append(r16);
        String r17 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");
        StringBuilder r19 = new StringBuilder("ContactsCreateIntent#getSuccessDetail finalStr isEmpty: ");
        if (r17.length() != 0) goto L47;
        r2 = true;
    L47:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r19.append(r2).toString());
        return r17;
    L43:
        r16 = "已创建联系人";
        goto L44
    L40:
        r15 = false;
        goto L41
    L35:
        if ((!r13.isEmpty()) == false) goto L37;
        r5 = "，";
        goto L37
    L31:
        r4 = false;
        goto L33
    L27:
        r13 = CollectionsKt.emptyList();
        goto L29
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r20 = true;
    L8:
        if (r20 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        r3 = "姓名是" + r1;
        if (r3 != null) goto L15;
    L7:
        r20 = false;
        goto L8
    }
}
