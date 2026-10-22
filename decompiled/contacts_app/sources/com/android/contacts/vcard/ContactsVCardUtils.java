package com.android.contacts.vcard;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.HanziToPinyin;
import com.android.vcard.VCardEntry;
import com.android.vcard.VCardEntryConstructor;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardVersionException;
import com.obric.aikernel.sdk.ext.Params;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsVCardUtils {
    private static final String TAG = "VCardUtils";

    public ContactsVCardUtils() {
    }

    public static String getVCardEntriesInfo(Context r2, ArrayList<VCardEntry> r3) {
        if (r3 == null) goto L4;
        StringBuilder r0 = new StringBuilder();
        Iterator<VCardEntry> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        r0.append(getVCardInfo(r2, r4.next()));
        goto L10
    L13:
        return r0.toString();
    L4:
        if (ContactsUtils.DEBUG == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "The attachment uri is null!!");
        return "";
    L15:
        return "";
    }

    public static String getVCardInfo(Context r12, VCardEntry r13) {
        StringBuilder r0 = new StringBuilder("[");
        String r1 = r13.getDisplayName();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = r12.getResources().getString(R.string.missing_name);
    L5:
        r0.append(r12.getString(R.string.full_name)).append("] ").append(r1);
        List<VCardEntry.AndroidCustomData> r2 = r13.getAndroidCustomData();
        if (r13.getPhoneList() == null) goto L19;
        Iterator<VCardEntry.PhoneData> r3 = r13.getPhoneList().iterator();
    L9:
        if (r3.hasNext() == false) goto L19;
        VCardEntry.PhoneData r5 = r3.next();
        if (TextUtils.isEmpty(r5.getNumber()) == true) goto L9;
        String r6 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(r12.getResources(), r5.getType(), r5.getEntryLabel().toString()).toString();     // Catch: Exception -> L15 Resources.NotFoundException -> L16
    L17:
        r0.append(";\n[").append(r6).append("] ").append(ContactsUtils.formatNumber(r5.getNumber()));
        goto L9
    L16:
        r6 = r12.getResources().getStringArray(android.R.array.phoneTypes)[6];
    L15:
        r6 = r12.getResources().getStringArray(android.R.array.phoneTypes)[6];
    L19:
        if (r2 == null) goto L29;
        if (r2.size() <= 0) goto L29;
        Iterator<VCardEntry.AndroidCustomData> r7 = r2.iterator();
    L24:
        if (r7.hasNext() == false) goto L29;
        VCardEntry.AndroidCustomData r8 = r7.next();
        if ("vnd.android.cursor.item/nickname".equals(r8.getMimeType()) == false) goto L24;
        String r9 = r8.getDataList().get(0);
        r0.append(";\n[").append(r12.getString(R.string.nicknameLabelsGroup)).append("] ").append(r9);
    L29:
        if (r13.getEmailList() == null) goto L42;
        Iterator<VCardEntry.EmailData> r10 = r13.getEmailList().iterator();
    L32:
        if (r10.hasNext() == false) goto L42;
        VCardEntry.EmailData r11 = r10.next();
        if (TextUtils.isEmpty(r11.getAddress()) == true) goto L32;
        String r14 = ContactsContract.CommonDataKinds.Email.getTypeLabel(r12.getResources(), r11.getType(), r11.getLabel()).toString();     // Catch: Exception -> L38 Resources.NotFoundException -> L39
    L40:
        r0.append(";\n[").append(r14).append("] ").append(r11.getAddress());
        goto L32
    L39:
        r14 = r12.getResources().getStringArray(android.R.array.emailAddressTypes)[2];
    L38:
        r14 = r12.getResources().getStringArray(android.R.array.emailAddressTypes)[2];
    L42:
        if (r13.getPostalList() == null) goto L73;
        Iterator<VCardEntry.PostalData> r15 = r13.getPostalList().iterator();
    L45:
        if (r15.hasNext() == false) goto L73;
        VCardEntry.PostalData r16 = r15.next();
        String r17 = r12.getResources().getStringArray(android.R.array.postalAddressTypes)[r16.getType() - 1];     // Catch: Exception -> L49 Resources.NotFoundException -> L50
    L51:
        r0.append(";\n[").append(r17).append("] ");
        if (TextUtils.isEmpty(r16.getPobox()) == true) goto L55;
        r0.append(r16.getPobox());
    L55:
        if (TextUtils.isEmpty(r16.getExtendedAddress()) == true) goto L58;
        r0.append(r16.getExtendedAddress());
    L58:
        if (TextUtils.isEmpty(r16.getStreet()) == true) goto L61;
        r0.append(r16.getStreet());
    L61:
        if (TextUtils.isEmpty(r16.getLocalty()) == true) goto L64;
        r0.append(r16.getLocalty());
    L64:
        if (TextUtils.isEmpty(r16.getRegion()) == true) goto L67;
        r0.append(r16.getRegion());
    L67:
        if (TextUtils.isEmpty(r16.getPostalCode()) == true) goto L70;
        r0.append(r16.getPostalCode());
    L70:
        if (TextUtils.isEmpty(r16.getCountry()) == true) goto L45;
        r0.append(r16.getCountry());
        goto L45
    L50:
        r17 = r12.getResources().getStringArray(android.R.array.postalAddressTypes)[2];
    L49:
        r17 = r12.getResources().getStringArray(android.R.array.postalAddressTypes)[2];
    L73:
        if (r13.getImList() == null) goto L86;
        Iterator<VCardEntry.ImData> r18 = r13.getImList().iterator();
    L76:
        if (r18.hasNext() == false) goto L86;
        VCardEntry.ImData r19 = r18.next();
        if (TextUtils.isEmpty(r19.getAddress()) == true) goto L76;
        String r20 = r12.getResources().getString(ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(r19.getProtocol()));     // Catch: Exception -> L82 Resources.NotFoundException -> L83
    L84:
        r0.append(";\n[").append(r20).append("] ").append(r19.getAddress());
        goto L76
    L83:
        r20 = r12.getResources().getString(R.string.common_others);
    L82:
        r20 = r12.getResources().getString(R.string.common_others);
    L86:
        if (r13.getOrganizationList() == null) goto L102;
        Iterator<VCardEntry.OrganizationData> r21 = r13.getOrganizationList().iterator();
    L89:
        if (r21.hasNext() == false) goto L102;
        VCardEntry.OrganizationData r22 = r21.next();
        String r23 = r12.getResources().getString(ContactsContract.CommonDataKinds.Organization.getTypeLabelResource(r22.getType()));     // Catch: Exception -> L93 Resources.NotFoundException -> L94
    L95:
        r0.append(";\n[").append(r23).append("] ");
        if (TextUtils.isEmpty(r22.getOrganizationName()) == true) goto L99;
        r0.append(r22.getOrganizationName()).append(HanziToPinyin.Token.SEPARATOR);
    L99:
        if (TextUtils.isEmpty(r22.getDepartmentName()) == true) goto L89;
        r0.append(r22.getDepartmentName()).append(HanziToPinyin.Token.SEPARATOR);
        goto L89
    L94:
        r23 = r12.getResources().getStringArray(android.R.array.organizationTypes)[1];
    L93:
        r23 = r12.getResources().getStringArray(android.R.array.organizationTypes)[1];
    L102:
        if (r13.getWebsiteList() == null) goto L110;
        Iterator<VCardEntry.WebsiteData> r24 = r13.getWebsiteList().iterator();
    L105:
        if (r24.hasNext() == false) goto L110;
        VCardEntry.WebsiteData r25 = r24.next();
        if (TextUtils.isEmpty(r25.getWebsite()) == true) goto L105;
        String r26 = r12.getResources().getString(R.string.vcard_website_homepage);
        r0.append(";\n[").append(r26).append("] ").append(r25.getWebsite());
    L110:
        if (TextUtils.isEmpty(r13.getBirthday()) == true) goto L112;
        r0.append(";\n[").append(r12.getResources().getString(R.string.common_birthday)).append("] ").append(r13.getBirthday());
    L112:
        if (r2 == null) goto L122;
        if (r2.size() <= 0) goto L122;
        Iterator<VCardEntry.AndroidCustomData> r4 = r2.iterator();
    L117:
        if (r4.hasNext() == false) goto L122;
        VCardEntry.AndroidCustomData r27 = r4.next();
        if ("vnd.android.cursor.item/contact_event".equals(r27.getMimeType()) == false) goto L117;
        int r28 = Integer.valueOf(r27.getDataList().get(1)).intValue();
        String r29 = r27.getDataList().get(0);
        r0.append(";\n[").append(r12.getString(ContactsUtils.getEventTypeResource(Integer.valueOf(r28)))).append("] ").append(r29);
    L122:
        if (r13.getNotes() == null) goto L128;
        Iterator<VCardEntry.NoteData> r110 = r13.getNotes().iterator();
    L125:
        if (r110.hasNext() == false) goto L128;
        VCardEntry.NoteData r30 = r110.next();
        r0.append(";\n[").append(r12.getResources().getString(R.string.common_notes)).append("] ").append(r30.getNote());
    L128:
        return r0.toString();
    }

    public static String getVCardName(Context r6, Uri r7) {
        ParcelFileDescriptor r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
    L21:
        e = move-exception;
        e.printStackTrace();
    L45:
        return r2;
    L38:
        e = e;
        ParcelFileDescriptor r8 = null;
        InputStream r3 = null;
    L59:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Exception: " + e);     // Catch: Throwable -> L46
        if (r8 == null) goto L43;
        r8.close();     // Catch: IOException -> L21
    L43:
        if (r3 == null) goto L45;
        r3.close();     // Catch: IOException -> L21
    L46:
        th = th;
        r1 = r8;
    L48:
        if (r1 != null) goto L57;
    L52:
        if (r3 == null) goto L56;
        r3.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
    L56:
        throw th;
    L57:
        r1.close();     // Catch: IOException -> L50
    L36:
        th = th;
        r3 = null;
        goto L48
    L4:
        if (r7.getScheme().equals(Params.CONTENT) == false) goto L10;
        List<String> r9 = r7.getPathSegments();     // Catch: Throwable -> L36 Exception -> L38
        if (r9 == null) goto L8;
        InputStream r10 = r6.getContentResolver().openInputStream(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, Uri.encode(r9.get(2))));     // Catch: Throwable -> L36 Exception -> L38
    L9:
        r8 = null;
    L64:
        ArrayList<VCardEntry> r4 = getVCardEntries(r10);     // Catch: Throwable -> L27 Exception -> L29
        if (r4.isEmpty() == false) goto L16;
    L19:
        if (r8 == null) goto L23;
        r8.close();     // Catch: IOException -> L21
    L23:
        if (r10 == null) goto L45;
        r10.close();     // Catch: IOException -> L21
        goto L45
    L16:
        if (r4.size() != 1) goto L19;
        r2 = r4.get(0).getDisplayName();     // Catch: Throwable -> L27 Exception -> L29
        goto L19
    L29:
        e = move-exception;
        Exception r5 = e;
        r3 = r10;
    L35:
        e = r5;
    L27:
        th = move-exception;
        r3 = r10;
        r1 = r8;
        th = th;
        goto L48
    L8:
        r10 = null;
        goto L9
    L10:
        ParcelFileDescriptor r11 = r6.getContentResolver().openFileDescriptor(r7, "r");     // Catch: Throwable -> L36 Exception -> L38
        r8 = r11;
        r10 = new FileInputStream(r11.getFileDescriptor());     // Catch: Throwable -> L31 Exception -> L33
        goto L64
    L33:
        e = move-exception;
        r3 = null;
        r5 = e;
        r8 = r11;
    L31:
        th = move-exception;
        r3 = null;
        r1 = r11;
        th = th;
        goto L48
    }

    public static ArrayList<VCardEntry> getVCardEntries(Context r1, Uri r2) throws IOException, VCardException {
        InputStream r0 = null;
        r0 = r1.getContentResolver().openInputStream(r2);     // Catch: Throwable -> L7
        ArrayList<VCardEntry> r3 = getVCardEntries(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.close();
    L10:
        throw th;
    }

    public static ArrayList<VCardEntry> getVCardEntries(InputStream r4) throws IOException, VCardException {
        final ArrayList<VCardEntry> r0 = new ArrayList();
        VCardEntryConstructor r1 = new VCardEntryConstructor(0);
        r1.addEntryHandler(new AnonymousClass1(r0));
        new VCardParser_V21(0).parse(r4, r1);     // Catch: VCardVersionException -> L5
    L6:
        return r0;
    L5:
        new VCardParser_V30(0).parse(r4, r1);
        goto L6
    }
}
