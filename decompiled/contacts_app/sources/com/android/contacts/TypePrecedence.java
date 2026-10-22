package com.android.contacts;

import com.android.contacts.util.Constants;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class TypePrecedence {
    private static final int[] TYPE_PRECEDENCE_EMAIL = null;
    private static final int[] TYPE_PRECEDENCE_IM = null;
    private static final int[] TYPE_PRECEDENCE_ORG = null;
    private static final int[] TYPE_PRECEDENCE_PHONES = null;
    private static final int[] TYPE_PRECEDENCE_POSTAL = null;

    private TypePrecedence() {
    }

    static {
        TYPE_PRECEDENCE_PHONES = new int[]{0, 12, 2, 1, 3, 7, 5, 4, 6};
        TYPE_PRECEDENCE_EMAIL = new int[]{0, 1, 2, 3};
        TYPE_PRECEDENCE_POSTAL = new int[]{0, 1, 2, 3};
        TYPE_PRECEDENCE_IM = new int[]{0, 1, 2, 3};
        TYPE_PRECEDENCE_ORG = new int[]{0, 1, 2};
    }

    @Deprecated
    public static int getTypePrecedence(String r2, int r3) {
        int[] r4 = getTypePrecedenceList(r2);
        if (r4 != null) goto L6;
        return -1;
    L6:
        int r0 = 0;
    L8:
        if (r0 >= r4.length) goto L14;
        if (r4[r0] == r3) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        return r0;
    L14:
        return r4.length;
    }

    @Deprecated
    private static int[] getTypePrecedenceList(String r1) {
        if (r1.equals("vnd.android.cursor.item/phone_v2") == false) goto L7;
        return TYPE_PRECEDENCE_PHONES;
    L7:
        if (r1.equals("vnd.android.cursor.item/email_v2") == false) goto L11;
        return TYPE_PRECEDENCE_EMAIL;
    L11:
        if (r1.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L15;
        return TYPE_PRECEDENCE_POSTAL;
    L15:
        if (r1.equals("vnd.android.cursor.item/im") == false) goto L19;
        return TYPE_PRECEDENCE_IM;
    L19:
        if (r1.equals(Constants.MIME_TYPE_VIDEO_CHAT) == false) goto L23;
        return TYPE_PRECEDENCE_IM;
    L23:
        if (r1.equals("vnd.android.cursor.item/organization") == true) goto L25;
        return null;
    L25:
        return TYPE_PRECEDENCE_ORG;
    }
}
