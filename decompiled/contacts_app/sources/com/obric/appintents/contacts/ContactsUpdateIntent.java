package com.obric.appintents.contacts;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.obricsync.FormatPhoneNumberUtil;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.appintents.IntentsConstantKt;
import com.obric.appintents.IntentsUtilsKt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseContactsUpdateIntent;
import com.obric.capabilitykit.common.intent.ContactsUpdateParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Telephone;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContactsUpdateIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ.\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JC\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0006J(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002JC\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/obric/appintents/contacts/ContactsUpdateIntent;", "Lcom/obric/capabilitykit/common/intent/BaseContactsUpdateIntent;", "()V", "deleteContactInfo", "Landroid/content/ContentProviderOperation;", ContactSaveService.EXTRA_CONTACT_ID, "", "mimeType", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTypeByMimeType", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "id", "hasMimeTypeData", "", "insertContactInfo", "value", "type", GroupDeletionDialogFragment.ARG_LABEL, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroid/content/ContentProviderOperation;", "intentsUpdateNameData", "Landroid/content/ContentValues;", "typeValue", "isOnlyChinese", "str", "phoneTypeToTypeIntAndLabel", "updateContactInfo", "updateContactInfoInner", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsUpdateIntent extends BaseContactsUpdateIntent {
    public ContactsUpdateIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsUpdateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<ContactEntity>> r3) {
        return doAction((ContactsUpdateParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseContactsUpdateIntent
    public Object doAction(ContactsUpdateParams r16, DispatchContext r17, Continuation<? super IntentResult<ContactEntity>> r18) {
        if (PrivacyUtils.hasBasePermissionAndAgree(r17.getContext()) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction no permission");
        IntentPrivacyHelper.INSTANCE.openContactsMainPage(r17);
        return new IntentResult(201, null, null, r17.getContext().getString(R.string.app_intent_no_permission), false, false, 1, null, null, null, 948, null);
    L6:
        ContactEntity r4 = updateContactInfo(r17.getContext(), r16);
        if (r4 != null) goto L9;
        String r0 = r17.getContext().getString(R.string.intents_contacts_update_fail);
    L10:
        String r6 = r0;
        Intrinsics.checkNotNullExpressionValue(r6, "if (entity == null) {\n  …update_success)\n        }");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction result:" + r6);
        if (r4 != null) goto L13;
        int r1 = 1;
    L15:
        return new IntentResult(r1, r4, null, r6, false, false, 1, null, null, null, 948, null);
    L13:
        r1 = 0;
        goto L15
    L9:
        r0 = r17.getContext().getString(R.string.intents_contacts_update_success);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v6 */
    private final ContactEntity updateContactInfo(Context r23, ContactsUpdateParams r24) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction call");
        ContactEntity r1 = r24.getTarget();
        if (r1 == null) goto L74;
        String r11 = r1.getId();
        if (r11 == null) goto L82;
        Uri r12 = ContactsContract.Data.CONTENT_URI;
        ArrayList<ContentProviderOperation> r13 = new ArrayList();
        String r5 = "contact_id = ?";
        r13.add(ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI).withValue("aggregation_mode", 2).withSelection("contact_id = ?", new String[]{r11}).build());
        String r4 = r24.getName();
        if (r4 == null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update name");
        if (hasMimeTypeData(r23, r11, "vnd.android.cursor.item/name") == false) goto L12;
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newUpdate(r12);
        r2.withSelection("contact_id =? AND mimetype =?", new String[]{r11, "vnd.android.cursor.item/name"});
        r2.withValues(intentsUpdateNameData(r4));
        ContentProviderOperation r3 = r2.build();
    L13:
        Intrinsics.checkNotNullExpressionValue(r3, "if(hasMimeTypeData(conte…, null)\n                }");
        r13.add(r3);
    L15:
        Telephone[] r7 = r24.getTelephones();
        if (r7 == null) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update telephone");
        String r6 = "vnd.android.cursor.item/phone_v2";
        r13.add(deleteContactInfo(r11, "vnd.android.cursor.item/phone_v2"));
        int r8 = r7.length;
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L26;
        Telephone r10 = r7[r9];
        String r14 = r10.getNumber();
        if (r14 == null) goto L25;
        String r16 = FormatPhoneNumberUtil.Companion.format(r14);
        if (r16 == null) goto L25;
        Pair<Integer, String> r15 = phoneTypeToTypeIntAndLabel(r23, r10.getType());
        String r17 = r6;
        r13.add(insertContactInfo(r23, r11, r17, r16, Integer.valueOf(r15.component1().intValue()), r15.component2()));
    L25:
        r9 = r9 + 1;
        r6 = r6;
        r7 = r7;
        r8 = r8;
    L26:
        String r18 = r24.getCompany();
        if (r18 == null) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update company");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/organization", r18, null, null));
    L29:
        String r19 = r24.getNote();
        if (r19 == null) goto L32;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update note");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/note", r19, null, null));
    L32:
        String r20 = r24.getEmail();
        if (r20 == null) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update email");
        Pair<Integer, String> r21 = getTypeByMimeType(r23, r11, "vnd.android.cursor.item/email_v2");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/email_v2", r20, Integer.valueOf(r21.component1().intValue()), r21.component2()));
    L35:
        String r22 = r24.getIdentifyCard();
        if (r22 == null) goto L38;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update identifyCard");
        Pair<Integer, String> r25 = getTypeByMimeType(r23, r11, "vnd.android.cursor.item/card_id");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/card_id", r22, Integer.valueOf(r25.component1().intValue()), r25.component2()));
    L38:
        String r26 = r24.getGender();
        long r110 = -1;
        if (r26 == null) goto L55;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update gender");
        if (hasMimeTypeData(r23, r11, "vnd.android.cursor.item/gender") == false) goto L46;
        ContentProviderOperation.Builder r27 = ContentProviderOperation.newUpdate(r12);
        boolean r111 = false;
        r27.withSelection("contact_id = ? AND mimetype = ?", new String[]{r11, "vnd.android.cursor.item/gender"});
        String r28 = IntentsConstantKt.getContactValueColumnName().get("vnd.android.cursor.item/gender");
        if (r28 == null) goto L45;
        r27.withValue(r28, Integer.valueOf(IntentsUtilsKt.getGanderByString(r26)));
    L45:
        ContentProviderOperation r29 = r27.build();
    L54:
        Intrinsics.checkNotNullExpressionValue(r29, "if(hasMimeTypeData(conte…build()\n                }");
        r13.add(r29);
        ?? r112 = r111;
    L56:
        String r30 = r24.getBirthday();
        if (r30 == null) goto L59;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update birthday");
        Pair<Integer, String> r31 = getTypeByMimeType(r23, r11, "vnd.android.cursor.item/contact_event");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/contact_event", r30, Integer.valueOf(r31.component1().intValue()), r31.component2()));
    L59:
        String r32 = r24.getRelationship();
        if (r32 == null) goto L62;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update relationship");
        Pair<Integer, String> r33 = getTypeByMimeType(r23, r11, "vnd.android.cursor.item/relation");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/relation", r32, Integer.valueOf(r33.component1().intValue()), r33.component2()));
    L62:
        String r34 = r24.getAddress();
        if (r34 == null) goto L65;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update address");
        Pair<Integer, String> r35 = getTypeByMimeType(r23, r11, "vnd.android.cursor.item/postal-address_v2");
        r13.add(updateContactInfoInner(r23, r11, "vnd.android.cursor.item/postal-address_v2", r34, Integer.valueOf(r35.component1().intValue()), r35.component2()));
    L65:
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI).withValue("aggregation_mode", Integer.valueOf(r112));
        String[] r36 = new String[1];
        r36[r112] = r11;
        r13.add(r0.withSelection(r5, r36).build());
        r23.getContentResolver().applyBatch("com.android.contacts", r13);     // Catch: Exception -> L71
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update success");     // Catch: Exception -> L71
        ContentResolver r37 = r23.getContentResolver();     // Catch: Exception -> L71
        Intrinsics.checkNotNullExpressionValue(r37, "context.contentResolver");     // Catch: Exception -> L71
        Long r38 = StringsKt.toLongOrNull(r11);     // Catch: Exception -> L71
        if (r38 == null) goto L69;
        r110 = r38.longValue();     // Catch: Exception -> L71
    L69:
        return (ContactEntity) CollectionsKt.firstOrNull(ContactEntityUtilKt.queryContactsByIds(r37, CollectionsKt.listOf(Long.valueOf(r110)), r112, r112));
    L71:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(IntentsConstantKt.TAG, "ContactsUpdateIntent#doAction update fail ID:" + r11, e);
        return null;
    L46:
        r111 = false;
        Long r39 = StringsKt.toLongOrNull(r11);
        if (r39 == null) goto L49;
        long r40 = r39.longValue();
    L50:
        long r41 = IntentsUtilsKt.getRawContactIdByContactId(r23, r40);
        ContentProviderOperation.Builder r42 = ContentProviderOperation.newInsert(r12);
        r42.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r41));
        r42.withValue("mimetype", "vnd.android.cursor.item/gender");
        String r43 = IntentsConstantKt.getContactValueColumnName().get("vnd.android.cursor.item/gender");
        if (r43 == null) goto L53;
        r42.withValue(r43, Integer.valueOf(IntentsUtilsKt.getGanderByString(r26)));
    L53:
        r29 = r42.build();
        goto L54
    L49:
        r40 = -1;
        goto L50
    L55:
        r112 = 0;
        goto L56
    L12:
        r3 = insertContactInfo(r23, r11, "vnd.android.cursor.item/name", r4, null, null);
        goto L13
    L14:
        r5 = "contact_id = ?";
        goto L15
    L82:
        return null;
    L74:
        return null;
    }

    private final ContentProviderOperation deleteContactInfo(String r3, String r4) {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI.buildUpon().build());
        r2.withSelection("contact_id = ? AND mimetype = ?", new String[]{r3, r4});
        ContentProviderOperation r5 = r2.build();
        Intrinsics.checkNotNullExpressionValue(r5, "newDelete(uri).apply {\n …      )\n        }.build()");
        return r5;
    }

    private final ContentProviderOperation updateContactInfoInner(Context r5, String r6, String r7, String r8, Integer r9, String r10) {
        if (hasMimeTypeData(r5, r6, r7) == false) goto L5;
        Uri r4 = ContactsContract.Data.CONTENT_URI.buildUpon().build();
        Long r11 = StringsKt.toLongOrNull(r6);
        if (r11 == null) goto L9;
        long r0 = r11.longValue();
    L10:
        boolean r12 = true;
        List r13 = CollectionsKt.toMutableList(CollectionsKt.listOf(new String[]{String.valueOf(IntentsUtilsKt.getRawContactIdByContactId(r5, r0)), r7}));
        String r1 = r10;
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L28;
        String r3 = IntentsConstantKt.getContactLabelColumnName().get(r7);
        if (r3 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L28;
        String r15 = "raw_contact_id =? AND mimetype =? AND " + IntentsConstantKt.getContactLabelColumnName().get(r7) + " =?";
        r13.add(r10);
    L29:
        if (r9 == null) goto L38;
        String r16 = IntentsConstantKt.getContactTypeColumnName().get(r7);
        if (r16 != null) goto L33;
    L36:
        if (r12 == true) goto L38;
        r15 = r15 + " AND " + IntentsConstantKt.getContactTypeColumnName().get(r7) + " =?";
        r13.add(r9.toString());
        goto L38
    L33:
        if (r16.length() == 0) goto L36;
        r12 = false;
    L38:
        ContentProviderOperation.Builder r17 = ContentProviderOperation.newUpdate(r4);
        r17.withSelection(r15, (String[]) r13.toArray(new String[0]));
        String r18 = IntentsConstantKt.getContactValueColumnName().get(r7);
        if (r18 == null) goto L41;
        r17.withValue(r18, r8);
    L41:
        ContentProviderOperation r19 = r17.build();
        Intrinsics.checkNotNullExpressionValue(r19, "newUpdate(uri).apply {\n …      }\n        }.build()");
        return r19;
    L22:
        if (r3.length() == 0) goto L25;
        r14 = false;
    L28:
        r15 = "raw_contact_id =? AND mimetype =?";
        goto L29
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
        goto L18
    L9:
        r0 = -1;
        goto L10
    L5:
        return insertContactInfo(r5, r6, r7, r8, r9, r10);
    }

    private final ContentProviderOperation insertContactInfo(Context r3, String r4, String r5, String r6, Integer r7, String r8) {
        Uri r2 = ContactsContract.Data.CONTENT_URI.buildUpon().build();
        Long r9 = StringsKt.toLongOrNull(r4);
        if (r9 == null) goto L5;
        long r0 = r9.longValue();
    L6:
        long r10 = IntentsUtilsKt.getRawContactIdByContactId(r3, r0);
        ContentProviderOperation.Builder r11 = ContentProviderOperation.newInsert(r2);
        r11.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r10));
        r11.withValue("mimetype", r5);
        String r12 = IntentsConstantKt.getContactValueColumnName().get(r5);
        if (r12 == null) goto L9;
        r11.withValue(r12, r6);
    L9:
        if (r7 == null) goto L13;
        r7.intValue();
        String r13 = IntentsConstantKt.getContactTypeColumnName().get(r5);
        if (r13 == null) goto L13;
        r11.withValue(r13, r7);
    L13:
        String r14 = r8;
        if (r14 != null) goto L16;
    L19:
        boolean r15 = true;
    L20:
        if (r15 == true) goto L24;
        String r16 = IntentsConstantKt.getContactLabelColumnName().get(r5);
        if (r16 == null) goto L24;
        r11.withValue(r16, r8);
    L24:
        ContentProviderOperation r17 = r11.build();
        Intrinsics.checkNotNullExpressionValue(r17, "newInsert(uri).apply {\n …      }\n        }.build()");
        return r17;
    L16:
        if (r14.length() == 0) goto L19;
        r15 = false;
        goto L20
    L5:
        r0 = -1;
        goto L6
    }

    private final boolean hasMimeTypeData(Context r7, String r8, String r9) {
        Cursor r10 = r7.getContentResolver().query(ContactsContract.Data.CONTENT_URI.buildUpon().build(), new String[]{"data1"}, "contact_id =? AND mimetype =?", new String[]{r8, r9}, null);
        StringBuilder r11 = new StringBuilder("ContactsUpdateIntent#hasMimeTypeData cursor = ");
        if (r10 == null) goto L5;
        Integer r0 = Integer.valueOf(r10.getCount());
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r11.append(r0).toString());
        if (r10 == null) goto L17;
        Cursor r12 = r10;
        boolean r6 = r12.moveToFirst();     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r12, null);
        return r6;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L17:
        return false;
    L5:
        r0 = null;
        goto L6
    }

    private final Pair<Integer, String> getTypeByMimeType(Context r9, String r10, String r11) {
        int r7 = 1;
        Cursor r12 = r9.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{IntentsConstantKt.getContactTypeColumnName().get(r11), IntentsConstantKt.getContactLabelColumnName().get(r11)}, "mimetype =? AND contact_id =?", new String[]{r11, r10}, null);
        StringBuilder r13 = new StringBuilder("ContactsUpdateIntent#getTypeByMimeType cursor = ");
        if (r12 == null) goto L5;
        Integer r1 = Integer.valueOf(r12.getCount());
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, r13.append(r1).toString());
        if (r12 == null) goto L21;
        Cursor r14 = r12;
        Cursor r15 = r14;     // Catch: Throwable -> L16
        if (r15.moveToFirst() == false) goto L14;
        int r16 = r15.getInt(0);     // Catch: Throwable -> L16
        String r17 = r15.getString(1);     // Catch: Throwable -> L16
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntentsConstantKt.TAG, "ContactsUpdateIntent#getTypeByMimeType type = " + r16 + ", label = " + r17);     // Catch: Throwable -> L16
        Pair<Integer, String> r8 = new Pair(Integer.valueOf(r16), r17);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r14, null);
        return r8;
    L14:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r14, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L21:
        Integer r19 = IntentsConstantKt.getContactTypeDefaultValue().get(r11);
        if (r19 == null) goto L25;
        r7 = r19.intValue();
    L25:
        return new Pair(Integer.valueOf(r7), IntentsConstantKt.getContactLabelColumnName().get(r11));
    L5:
        r1 = null;
        goto L6
    }

    private final Pair<Integer, String> phoneTypeToTypeIntAndLabel(Context r2, String r3) {
        if (r3 != null) goto L5;
        String r0 = "0";
    L28:
        int r1 = Integer.parseInt(r0);
        if (r1 == Integer.parseInt("0")) goto L33;
        r3 = r2.getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(r1));
    L33:
        return new Pair(Integer.valueOf(r1), r3);
    L5:
        switch(r3.hashCode()) {
            case 652822: goto L24;
            case 658431: goto L20;
            case 666656: goto L16;
            case 765463: goto L12;
            case 965960: goto L8;
            default: goto L34;
        };
    L34:
        r0 = "0";
        goto L28
    L8:
        if (r3.equals("电话") == false) goto L35;
        r0 = "2";
        goto L28
    L35:
        r0 = "0";
        goto L28
    L12:
        if (r3.equals("工作") == false) goto L36;
        r0 = "3";
        goto L28
    L36:
        r0 = "0";
        goto L28
    L16:
        if (r3.equals("其他") == false) goto L37;
        r0 = "7";
        goto L28
    L37:
        r0 = "0";
        goto L28
    L20:
        if (r3.equals("传真") == false) goto L38;
        r0 = "4";
        goto L28
    L38:
        r0 = "0";
        goto L28
    L24:
        if (r3.equals("住宅") == false) goto L39;
        r0 = "1";
        goto L28
    L39:
        r0 = "0";
        goto L28
    }

    private final ContentValues intentsUpdateNameData(String r6) {
        ContentValues r0 = new ContentValues();
        r0.put("data1", r6);
        if (isOnlyChinese(r6) == true) goto L5;
        r0.put(DBHelper.COL_DATA2, r6);
        r0.put(DBHelper.COL_DATA3, "");
    L6:
        return r0;
    L5:
        String r3 = r6.substring(1);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        r0.put(DBHelper.COL_DATA2, r3);
        String r5 = r6.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        r0.put(DBHelper.COL_DATA3, r5);
        goto L6
    }

    public final boolean isOnlyChinese(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        String r3 = r2;
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return false;
    L7:
        return new Regex("^[一-龥]+$").matches(r3);
    }
}
