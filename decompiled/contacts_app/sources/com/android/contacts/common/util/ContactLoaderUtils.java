package com.android.contacts.common.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.ContactsContract;
import com.obric.contactsdk.loader.ContractKt;

/* JADX INFO: loaded from: classes.dex */
public final class ContactLoaderUtils {
    private ContactLoaderUtils() {
    }

    public static Uri ensureIsContactUri(ContentResolver r2, Uri r3) throws IllegalArgumentException {
        if (r3 == null) goto L21;
        String r0 = r3.getAuthority();
        if ("com.android.contacts".equals(r0) == false) goto L15;
        String r1 = r2.getType(r3);
        if ("vnd.android.cursor.item/contact".equals(r1) == false) goto L9;
        return r3;
    L9:
        if ("vnd.android.cursor.item/raw_contact".equals(r1) == false) goto L13;
        long r4 = ContentUris.parseId(r3);
        return ContactsContract.RawContacts.getContactLookupUri(r2, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r4));
    L13:
        throw new IllegalArgumentException("uri format is unknown");
    L15:
        if (ContractKt.PARAM_ACTION_DOMAIN_CONTACTS.equals(r0) == false) goto L19;
        long r5 = ContentUris.parseId(r3);
        return ContactsContract.RawContacts.getContactLookupUri(r2, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r5));
    L19:
        throw new IllegalArgumentException("uri authority is unknown");
    L21:
        throw new IllegalArgumentException("uri must not be null");
    }
}
