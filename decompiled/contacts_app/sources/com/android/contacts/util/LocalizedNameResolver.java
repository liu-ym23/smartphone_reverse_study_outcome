package com.android.contacts.util;

import android.R;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import com.GlobalProxyLancet;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LocalizedNameResolver {
    private static final String CONTACTS_DATA_KIND = "ContactsDataKind";
    private static final String METADATA_CONTACTS = "android.provider.CONTACTS_STRUCTURE";
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

    private static String resolveAllContactsNameFromMetaData(Context r6, String r7) {
        PackageManager r0 = r6.getPackageManager();
        PackageInfo r1 = r0.getPackageInfo(r7, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.services == null) goto L23;
        ServiceInfo[] r2 = r1.services;     // Catch: PackageManager.NameNotFoundException -> L14
        int r3 = r2.length;     // Catch: PackageManager.NameNotFoundException -> L14
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L24;
        XmlResourceParser r5 = r2[r4].loadXmlMetaData(r0, METADATA_CONTACTS);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r5 != null) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        return loadAllContactsNameFromXml(r6, r5, r7);
    L24:
        return null;
    L23:
        return null;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Problem loading \"All Contacts\"-name: " + e.toString());
        return null;
    }

    private static String loadAllContactsNameFromXml(Context r9, XmlPullParser r10, String r11) {
        AttributeSet r1 = Xml.asAttributeSet(r10);     // Catch: IOException -> L49 XmlPullParserException -> L52
    L4:
        int r2 = r10.next();     // Catch: IOException -> L49 XmlPullParserException -> L52
        if (r2 == 2) goto L8;
        if (r2 != 1) goto L4;
    L8:
        if (r2 != 2) goto L48;
        int r3 = r10.getDepth();     // Catch: IOException -> L49 XmlPullParserException -> L52
    L10:
        int r5 = r10.next();     // Catch: IOException -> L49 XmlPullParserException -> L52
        if (r5 == 3) goto L13;
    L14:
        if (r5 == 1) goto L46;
        String r6 = r10.getName();     // Catch: IOException -> L49 XmlPullParserException -> L52
        if (r5 != 2) goto L10;
        if (CONTACTS_DATA_KIND.equals(r6) == false) goto L10;
        TypedArray r7 = r9.obtainStyledAttributes(r1, R.styleable.ContactsDataKind);     // Catch: IOException -> L49 XmlPullParserException -> L52
        String r8 = r7.getNonResourceString(5);     // Catch: Throwable -> L43
        if (r8 != null) goto L23;
        int r12 = r7.getResourceId(5, 0);     // Catch: Throwable -> L43
        if (r12 == 0) goto L28;
        PackageManager r13 = r9.getPackageManager();     // Catch: Throwable -> L43
        if (r13 != null) goto L58;
        Resources r14 = null;
    L34:
        if (r14 != null) goto L55;
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        goto L10
    L55:
        String r15 = r14.getString(r12);     // Catch: Resources.NotFoundException -> L38 Throwable -> L43
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        return r15;
    L38:
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        return null;
    L58:
        r14 = r13.getResourcesForApplication(r11);     // Catch: PackageManager.NameNotFoundException -> L41 Throwable -> L43
    L41:
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        return null;
    L28:
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        return null;
    L23:
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        return r8;
    L43:
        th = move-exception;
        r7.recycle();     // Catch: IOException -> L49 XmlPullParserException -> L52
        throw th;     // Catch: IOException -> L49 XmlPullParserException -> L52
    L46:
        return null;
    L13:
        if (r10.getDepth() <= r3) goto L46;
    L48:
        throw new IllegalStateException("No start tag found");     // Catch: IOException -> L49 XmlPullParserException -> L52
    L49:
        e = move-exception;
        throw new IllegalStateException("Problem reading XML", e);
    L52:
        e = move-exception;
        throw new IllegalStateException("Problem reading XML", e);
    }
}
