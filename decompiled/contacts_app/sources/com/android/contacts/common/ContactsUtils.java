package com.android.contacts.common;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.common.compat.ContactsCompat;
import com.android.contacts.common.compat.DirectoryCompat;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.dataitem.ImDataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class ContactsUtils {
    private static final int DEFAULT_THUMBNAIL_SIZE = 96;
    public static final boolean FLAG_N_FEATURE = false;
    public static final String SCHEME_IMTO = "imto";
    public static final String SCHEME_MAILTO = "mailto";
    public static final String SCHEME_SMSTO = "smsto";
    private static final String TAG = "ContactsUtils";
    public static final long USER_TYPE_CURRENT = 0;
    public static final long USER_TYPE_WORK = 1;
    private static int sThumbnailSize = -1;

    public interface ProviderNames {
        public static final String AIM = "AIM";
        public static final String GTALK = "GTalk";
        public static final String ICQ = "ICQ";
        public static final String JABBER = "JABBER";
        public static final String MSN = "MSN";
        public static final String QQ = "QQ";
        public static final String SKYPE = "SKYPE";
        public static final String XMPP = "XMPP";
        public static final String YAHOO = "Yahoo";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserType {
    }

    public static String lookupProviderNameFromId(int r0) {
        switch(r0) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "JABBER";
    L7:
        return "ICQ";
    L9:
        return "GTalk";
    L11:
        return "QQ";
    L13:
        return "SKYPE";
    L15:
        return "Yahoo";
    L17:
        return "MSN";
    L19:
        return "AIM";
    }

    public ContactsUtils() {
    }

    static {
        FLAG_N_FEATURE = true;
    }

    public static boolean isGraphic(CharSequence r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isGraphic(r1) == false) goto L7;
        return true;
    }

    public static boolean areObjectsEqual(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static final boolean areIntentActionEqual(Intent r0, Intent r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        if (r0 == null) goto L10;
        if (r1 != null) goto L9;
        return false;
    L9:
        return TextUtils.equals(r0.getAction(), r1.getAction());
    L10:
        return false;
    }

    public static boolean areGroupWritableAccountsAvailable(Context r0) {
        return !AccountTypeManager.getInstance(r0).getGroupWritableAccounts().isEmpty();
    }

    public static int getThumbnailSize(Context r8) {
        if (sThumbnailSize != (-1)) goto L13;
        Cursor r9 = r8.getContentResolver().query(ContactsContract.DisplayPhoto.CONTENT_MAX_DIMENSIONS_URI, new String[]{"thumbnail_max_dim"}, null, null, null);
        if (r9 == null) goto L13;
    L10:
        th = move-exception;
        r9.close();
        throw th;
    L7:
        if (r9.moveToFirst() == false) goto L9;
        sThumbnailSize = r9.getInt(0);     // Catch: Throwable -> L10
    L9:
        r9.close();
    L13:
        int r10 = sThumbnailSize;
        if (r10 != (-1)) goto L20;
        return 96;
    L20:
        return r10;
    }

    private static Intent getCustomImIntent(ImDataItem r3, int r4) {
        String r0 = r3.getCustomProtocol();
        String r5 = r3.getData();
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        if (r4 == (-1)) goto L9;
        r0 = lookupProviderNameFromId(r4);
    L9:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return null;
    L11:
        String r6 = r0.toLowerCase();
        return new Intent("android.intent.action.SENDTO", new Uri.Builder().scheme("imto").authority(r6).appendPath(r5).build());
    }

    public static Pair<Intent, Intent> buildImIntent(Context r6, ImDataItem r7) {
        boolean r8 = r7.isCreatedFromEmail();
        Intent r0 = null;
        if (r8 == false) goto L5;
    L8:
        String r1 = r7.getData();
        if (TextUtils.isEmpty(r1) == true) goto L11;
        Integer r2 = r7.getProtocol();
        if (r2 == null) goto L17;
        if (r8 == false) goto L16;
        int r9 = 5;
    L18:
        if (r9 != 5) goto L26;
        int r10 = r7.getChatCapability();
        if ((r10 & 4) == 0) goto L23;
        Intent r11 = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        r0 = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?call"));
    L28:
        return new Pair(r11, r0);
    L23:
        if ((r10 & 1) == 0) goto L25;
        r11 = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        r0 = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?call"));
        goto L28
    L25:
        r11 = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        goto L28
    L26:
        r11 = getCustomImIntent(r7, r9);
        goto L28
    L16:
        r9 = r2.intValue();
        goto L18
    L17:
        r9 = 0;
        goto L18
    L11:
        return new Pair(null, null);
    L5:
        if (r7.isProtocolValid() == true) goto L8;
        return new Pair(null, null);
    }

    public static long determineUserType(Long r6, Long r7) {
        if (r6 != null) goto L5;
        if (r7 != null) goto L11;
    L15:
        return 0;
    L11:
        if (r7.longValue() == 0) goto L15;
        if (ContactsCompat.isEnterpriseContactId(r7.longValue()) == false) goto L15;
        return 1;
    L5:
        if (DirectoryCompat.isEnterpriseDirectoryId(r6.longValue()) == false) goto L8;
        return 1;
    L8:
        return 0;
    }
}
