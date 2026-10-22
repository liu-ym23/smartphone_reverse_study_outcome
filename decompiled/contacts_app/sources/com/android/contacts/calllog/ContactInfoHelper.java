package com.android.contacts.calllog;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.UriUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ContactInfoHelper {
    private final Context mContext;
    private final String mCurrentCountryIso;
    private boolean mUseStrictPhoneNumberComparation;

    public ContactInfoHelper(Context r1, String r2) {
        this.mContext = r1;
        this.mCurrentCountryIso = r2;
        this.mUseStrictPhoneNumberComparation = r1.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation);
    }

    public ContactInfo lookupNumber(String r4, String r5) {
        if (PhoneNumberUtils.isUriNumber(r4) == false) goto L11;
        ContactInfo r0 = queryContactInfoForSipAddress(r4);
        if (r0 != null) goto L7;
    L8:
        String r1 = PhoneNumberUtils.getUsernameFromUriNumber(r4);
        if (PhoneNumberUtils.isGlobalPhoneNumber(r1) == false) goto L17;
        r0 = queryContactInfoForPhoneNumber(r1, r5);
    L17:
        if (r0 != null) goto L20;
        return null;
    L20:
        if (r0 != ContactInfo.EMPTY) goto L24;
        ContactInfo r2 = new ContactInfo();
        r2.number = r4;
        r2.formattedNumber = formatPhoneNumber(r4, null, r5);
        return r2;
    L24:
        return r0;
    L7:
        if (r0 != ContactInfo.EMPTY) goto L17;
    L11:
        r0 = queryContactInfoForPhoneNumber(r4, r5);
        if (r0 != null) goto L14;
    L15:
        r0 = queryContactInfoForSipAddress(r4);
        goto L17
    L14:
        if (r0 != ContactInfo.EMPTY) goto L17;
        goto L15
    }

    public boolean lookupEmail(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        Uri r3 = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_LOOKUP_URI, Uri.encode(r9));
        Cursor r8 = this.mContext.getContentResolver().query(r3, null, null, null, null);
        if (r8 != null) goto L16;
    L15:
        return false;
    L16:
        if (r8.getCount() <= 0) goto L11;
        r8.close();
        return true;
    L11:
        r8.close();
    L12:
        th = move-exception;
        r8.close();
        throw th;
    }

    private ContactInfo lookupContactFromUri(Uri r8) {
        Cursor r9 = this.mContext.getContentResolver().query(r8, PhoneQuery._PROJECTION, null, null, null);
        ContactInfo r0 = null;
        if (r9 != null) goto L14;
    L12:
        setNumberLabel(r0);
        return r0;
    L14:
    L9:
        th = move-exception;
        r9.close();
        throw th;
    L5:
        if (r9.moveToFirst() == false) goto L8;
        ContactInfo r1 = new ContactInfo();     // Catch: Throwable -> L9
        r1.lookupUri = ContactsContract.Contacts.getLookupUri(r9.getLong(0), r9.getString(7));     // Catch: Throwable -> L9
        r1.name = r9.getString(1);     // Catch: Throwable -> L9
        r1.type = r9.getInt(2);     // Catch: Throwable -> L9
        r1.label = r9.getString(3);     // Catch: Throwable -> L9
        r1.number = r9.getString(4);     // Catch: Throwable -> L9
        r1.normalizedNumber = r9.getString(5);     // Catch: Throwable -> L9
        r1.photoId = r9.getLong(6);     // Catch: Throwable -> L9
        r1.photoUri = UriUtils.parseUriOrNull(r9.getString(8));     // Catch: Throwable -> L9
        r1.formattedNumber = null;     // Catch: Throwable -> L9
        r0 = r1;
    L8:
        r9.close();
        goto L12
    }

    private void setNumberLabel(final ContactInfo r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        if (r14.lookupUri != null) goto L6;
        return;
    L6:
        if (r14.type != 3) goto L8;
    L10:
        long r3 = ContentUris.parseId(r14.lookupUri);
        Cursor r5 = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"mimetype", "data1", DBHelper.COL_DATA2}, "contact_id=? AND (mimetype=? OR mimetype=?)", new String[]{String.valueOf(r3), "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/organization"}, null);
        if (r5 == null) goto L80;
        HashSet r6 = new HashSet();
        HashSet r7 = new HashSet();
        HashSet r8 = new HashSet();
        String r9 = null;
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
    L30:
        r5.close();
        String[] r4 = {""};
        if (TextUtils.isEmpty(r9) == true) goto L67;
        if (1 != r6.size()) goto L47;
        if (2 != r14.type) goto L44;
        r4[0] = r9;
    L64:
        if (TextUtils.isEmpty(r4[0]) == true) goto L81;
        r14.type = 0;
        r14.label = r4[0];
        return;
    L81:
        return;
    L44:
        if (3 != r14.type) goto L64;
        r4[0] = buildLabelWorkTypeAppendOrgaName(r9);
        goto L64
    L47:
        if (r6.size() <= 1) goto L54;
        if (r7.size() <= 0) goto L54;
        if (3 != r14.type) goto L64;
        r4[0] = buildLabelWorkTypeAppendOrgaName(r9);
    L54:
        if (r6.size() <= 1) goto L59;
        if (r6.size() != r8.size()) goto L59;
        r4[0] = r9;
    L59:
        if (r6.size() <= 1) goto L64;
        if (r6.size() != r7.size()) goto L64;
        r4[0] = buildLabelWorkTypeAppendOrgaName(r9);
        goto L64
    L67:
        if (r6.size() > 1) goto L69;
        return;
    L69:
        if (r6.size() != r8.size()) goto L84;
        NumberInfosManager.getInstance().getBaseInfos(r14.number, new AnonymousClass1(this, r14));
        return;
    L84:
        return;
    L31:
        th = move-exception;
        r5.close();
        throw th;
    L14:
        if (r5.moveToFirst() == false) goto L30;
    L15:
        if ("vnd.android.cursor.item/organization".equals(r5.getString(0)) == false) goto L19;
        r9 = r5.getString(1);     // Catch: Throwable -> L31 Exception -> L33
    L29:
        if (r5.moveToNext() == true) goto L15;
    L19:
        if ("vnd.android.cursor.item/phone_v2".equals(r5.getString(0)) == false) goto L29;
        if (TextUtils.isEmpty(r5.getString(1)) == true) goto L29;
        String r10 = ContactsUtils.formatNumber(r5.getString(1));     // Catch: Throwable -> L31 Exception -> L33
        r6.add(r10);     // Catch: Throwable -> L31 Exception -> L33
        if (3 != r5.getInt(2)) goto L26;
        r7.add(r10);     // Catch: Throwable -> L31 Exception -> L33
        goto L29
    L26:
        if (2 != r5.getInt(2)) goto L29;
        r8.add(r10);     // Catch: Throwable -> L31 Exception -> L33
        goto L29
    L80:
        return;
    L8:
        if (r14.type == 2) goto L10;
    }

    private String buildLabelWorkTypeAppendOrgaName(String r3) {
        return this.mContext.getString(ContactTypeLabelUtils.getPhoneTypeLabelResource(3)) + " - " + r3;
    }

    private ContactInfo queryContactInfoForSipAddress(String r3) {
        Uri.Builder r0 = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon();
        r0.appendPath(Uri.encode(r3));
        r0.appendQueryParameter(Constants.SCHEME_SIP, "1");
        return lookupContactFromUri(r0.build());
    }

    private ContactInfo queryContactInfoForPhoneNumber(String r5, String r6) {
        ContactInfo r0 = lookupContactFromUri(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r5)));
        if (r0 == null) goto L9;
        if (r0 == ContactInfo.EMPTY) goto L9;
        r0.formattedNumber = formatPhoneNumber(r5, null, r6);
        return r0;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        String r1 = PhoneNumberUtils.formatNumberToE164(r5, r6);
        if (TextUtils.isEmpty(r1) == true) goto L13;
    L14:
        ContactInfo r2 = lookupProfileContactByNumber(r1);
        if (r2 == null) goto L18;
        r2.formattedNumber = formatPhoneNumber(r5, null, r6);
        return r2;
    L18:
        ContactInfo r3 = lookupContactFromDataByPhoneNumber(r5);
        if (r3 != null) goto L21;
        return r2;
    L21:
        if (r3 == ContactInfo.EMPTY) goto L25;
        r3.formattedNumber = formatPhoneNumber(r5, null, r6);
        return r3;
    L25:
        return r2;
    L13:
        r1 = r5;
        goto L14
    }

    private ContactInfo lookupContactFromDataByPhoneNumber(String r17) {
        Cursor r4 = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "lookup", "display_name", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "photo_id", "photo_uri"}, "mimetype=? AND PHONE_NUMBERS_EQUAL(data1, ?, 1)", new String[]{"vnd.android.cursor.item/phone_v2", r17}, null);
        if (r4 != null) goto L16;
        return null;
    L16:
    L13:
        th = move-exception;
        r4.close();
        throw th;
    L6:
        if (r4.moveToFirst() == true) goto L10;
        ContactInfo r0 = ContactInfo.EMPTY;     // Catch: Throwable -> L13
        r4.close();
        return r0;
    L10:
        ContactInfo r6 = new ContactInfo();     // Catch: Throwable -> L13
        r6.lookupUri = ContactsContract.Contacts.getLookupUri(r4.getLong(0), r4.getString(1));     // Catch: Throwable -> L13
        r6.name = r4.getString(2);     // Catch: Throwable -> L13
        r6.type = r4.getInt(4);     // Catch: Throwable -> L13
        r6.label = r4.getString(5);     // Catch: Throwable -> L13
        r6.number = r4.getString(3);     // Catch: Throwable -> L13
        r6.normalizedNumber = r4.getString(6);     // Catch: Throwable -> L13
        r6.photoId = r4.getLong(7);     // Catch: Throwable -> L13
        r6.photoUri = UriUtils.parseUriOrNull(r4.getString(8));     // Catch: Throwable -> L13
        r6.formattedNumber = null;     // Catch: Throwable -> L13
        setNumberLabel(r6);     // Catch: Throwable -> L13
        r4.close();
        return r6;
    }

    private ContactInfo lookupProfileContactByNumber(String r12) {
        Uri r0 = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        Cursor r13 = this.mContext.getContentResolver().query(r0, new String[]{"contact_id", "lookup", "display_name", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "photo_id", "photo_uri"}, "data4 =? OR PHONE_NUMBERS_EQUAL(data1, ?, " + (this.mUseStrictPhoneNumberComparation ? 1 : 0) + ")", new String[]{r12, r12}, null);
        ContactInfo r2 = null;
        if (r13 != null) goto L32;
    L12:
        ContactInfo r14 = r2;
        if (r14 != null) goto L15;
    L31:
        return r14;
    L15:
        if (TextUtils.isEmpty(r14.label) == false) goto L31;
        if (2 != r14.type) goto L19;
    L20:
        Cursor r1 = this.mContext.getContentResolver().query(r0, new String[]{"data1"}, "mimetype = 'vnd.android.cursor.item/organization'", null, null);
        if (r1 == null) goto L31;
        if (r1.moveToFirst() == false) goto L30;
        String r3 = r1.getString(0);
        if (r14.type != 2) goto L28;
        r14.label = r3;
        goto L30
    L28:
        if (3 != r14.type) goto L30;
        r14.label = buildLabelWorkTypeAppendOrgaName(r3);
    L30:
        r1.close();
        goto L31
    L19:
        if (3 != r14.type) goto L31;
    L32:
    L9:
        th = move-exception;
        r13.close();
        throw th;
    L5:
        if (r13.moveToFirst() == false) goto L8;
        ContactInfo r4 = new ContactInfo();     // Catch: Throwable -> L9
        r4.lookupUri = ContactsContract.Contacts.getLookupUri(r13.getLong(0), r13.getString(1));     // Catch: Throwable -> L9
        r4.name = r13.getString(2);     // Catch: Throwable -> L9
        r4.type = r13.getInt(4);     // Catch: Throwable -> L9
        r4.label = r13.getString(5);     // Catch: Throwable -> L9
        r4.number = r13.getString(3);     // Catch: Throwable -> L9
        r4.normalizedNumber = r13.getString(6);     // Catch: Throwable -> L9
        r4.photoId = r13.getLong(7);     // Catch: Throwable -> L9
        r4.photoUri = UriUtils.parseUriOrNull(r13.getString(8));     // Catch: Throwable -> L9
        r4.formattedNumber = null;     // Catch: Throwable -> L9
        r2 = r4;
    L8:
        r13.close();
        goto L12
    }

    private ContactInfo queryContactInfoForPhoneNumberFromCallLog(String r8, String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L7;
        String r0 = PhoneNumberUtils.formatNumberToE164(r8, r9);
        if (TextUtils.isEmpty(r0) == true) goto L7;
        r8 = r0;
    L7:
        Uri r2 = Uri.withAppendedPath(CallLog.Calls.CONTENT_FILTER_URI, Uri.encode(r8));
        Cursor r10 = this.mContext.getContentResolver().query(r2, CallLogQuery._PROJECTION, " type = 1", null, "date DESC LIMIT 1");
        ContactInfo r1 = null;
        if (r10 != null) goto L25;
    L24:
        return r1;
    L25:
    L21:
        th = move-exception;
        r10.close();
        throw th;
    L10:
        if (r10.moveToFirst() == false) goto L19;
        ContactInfo r3 = new ContactInfo();     // Catch: Throwable -> L21
        r3.lookupUri = UriUtils.parseUriOrNull(r10.getString(11));     // Catch: Throwable -> L21
        r3.name = r10.getString(8);     // Catch: Throwable -> L21
        r3.type = r10.getInt(9);     // Catch: Throwable -> L21
        r3.label = r10.getString(10);     // Catch: Throwable -> L21
        String r4 = r10.getString(12);     // Catch: Throwable -> L21
        if (r4 != null) goto L14;
        r4 = r10.getString(1);     // Catch: Throwable -> L21
    L14:
        r3.number = r4;     // Catch: Throwable -> L21
        if (r3.number != null) goto L17;
        r3.number = "";     // Catch: Throwable -> L21
    L17:
        r3.normalizedNumber = r10.getString(13);     // Catch: Throwable -> L21
        r3.photoId = r10.getLong(14);     // Catch: Throwable -> L21
        r3.photoUri = null;     // Catch: Throwable -> L21
        r3.formattedNumber = formatPhoneNumber(r3.number, null, r9);     // Catch: Throwable -> L21
        r1 = r3;
    L20:
        r10.close();
        goto L24
    L19:
        r1 = ContactInfo.EMPTY;     // Catch: Throwable -> L21
        goto L20
    }

    public String formatPhoneNumber(String r1, String r2, String r3) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return "";
    L7:
        if (PhoneNumberUtils.isUriNumber(r1) == false) goto L10;
        return r1;
    L10:
        return ContactsUtils.formatNumber(r1);
    }
}
