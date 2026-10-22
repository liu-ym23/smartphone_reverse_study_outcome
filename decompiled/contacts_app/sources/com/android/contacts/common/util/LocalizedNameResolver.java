package com.android.contacts.common.util;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import com.android.contacts.common.R;
import com.android.contacts.common.model.account.ExternalAccountType;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class LocalizedNameResolver {
    private static final String CONTACTS_DATA_KIND = "ContactsDataKind";
    private static final String TAG = "LocalizedNameResolver";

    public LocalizedNameResolver() {
    }

    public static String getAllContactsName(Context r0, String r1) {
        if (r0 == null) goto L9;
        if (r1 != null) goto L7;
        return null;
    L7:
        return resolveAllContactsName(r0, r1);
    L9:
        throw new IllegalArgumentException("Context must not be null");
    }

    private static String resolveAllContactsName(Context r5, String r6) {
        AuthenticatorDescription[] r0 = AccountManager.get(r5).getAuthenticatorTypes();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        AuthenticatorDescription r3 = r0[r2];
        if (r6.equals(r3.type) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return resolveAllContactsNameFromMetaData(r5, r3.packageName);
    L9:
        return null;
    }

    private static String resolveAllContactsNameFromMetaData(Context r1, String r2) {
        XmlResourceParser r0 = ExternalAccountType.loadContactsXml(r1, r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        return loadAllContactsNameFromXml(r1, r0, r2);
    }

    private static String loadAllContactsNameFromXml(Context r8, XmlPullParser r9, String r10) {
        AttributeSet r1 = Xml.asAttributeSet(r9);     // Catch: IOException -> L43 XmlPullParserException -> L46
    L4:
        int r2 = r9.next();     // Catch: IOException -> L43 XmlPullParserException -> L46
        if (r2 == 2) goto L8;
        if (r2 != 1) goto L4;
    L8:
        if (r2 != 2) goto L42;
        int r3 = r9.getDepth();     // Catch: IOException -> L43 XmlPullParserException -> L46
    L10:
        int r5 = r9.next();     // Catch: IOException -> L43 XmlPullParserException -> L46
        if (r5 == 3) goto L13;
    L14:
        if (r5 == 1) goto L40;
        String r6 = r9.getName();     // Catch: IOException -> L43 XmlPullParserException -> L46
        if (r5 != 2) goto L10;
        if (CONTACTS_DATA_KIND.equals(r6) == false) goto L10;
        TypedArray r11 = r8.obtainStyledAttributes(r1, R.styleable.ContactsDataKind);     // Catch: IOException -> L43 XmlPullParserException -> L46
        String r4 = r11.getNonResourceString(R.styleable.ContactsDataKind_android_allContactsName);     // Catch: Throwable -> L37
        if (r4 == null) goto L24;
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        return r4;
    L24:
        int r7 = r11.getResourceId(R.styleable.ContactsDataKind_android_allContactsName, 0);     // Catch: Throwable -> L37
        if (r7 != 0) goto L49;
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        return null;
    L49:
    L53:
        String r12 = r8.getPackageManager().getResourcesForApplication(r10).getString(r7);     // Catch: Resources.NotFoundException -> L33 Throwable -> L37
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        return r12;
    L33:
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        return null;
    L35:
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        return null;
    L37:
        th = move-exception;
        r11.recycle();     // Catch: IOException -> L43 XmlPullParserException -> L46
        throw th;     // Catch: IOException -> L43 XmlPullParserException -> L46
    L40:
        return null;
    L13:
        if (r9.getDepth() <= r3) goto L40;
    L42:
        throw new IllegalStateException("No start tag found");     // Catch: IOException -> L43 XmlPullParserException -> L46
    L43:
        e = move-exception;
        throw new IllegalStateException("Problem reading XML", e);
    L46:
        e = move-exception;
        throw new IllegalStateException("Problem reading XML", e);
    }
}
