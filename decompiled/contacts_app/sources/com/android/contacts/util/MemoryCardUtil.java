package com.android.contacts.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryCardUtil {
    private static String CARDID = "id";
    private static String CARDTYPE = "type";
    private static String ENTRYCONTACTID = "entryContactId";
    private static String IDNUMBERS = "idNumber";
    private static String INTENTTYPE = "intentType";
    private static String MEMORYOPERATE = "com.obric.memory.wallet.operate";
    private static String MEMORYPACKAGENAME = "com.obric.memory";
    private static String MEMORYPHONTACTIVITY = "wallet.WalletPhotoActivity";
    private static String MEMORYPHONTINFOACTIVITY = "wallet.WalletInfoActivity";
    private static String OPENMODE = "openMode";
    private static String OPTYPE = "opType";
    private static final int OPTYPE_DELETE = 2;
    private static final int OPTYPE_UPDATE = 1;
    private static String REFID = "refId";
    public static final int REQUEST_CODE_CREATE_CARD = 1002;
    private static String STARTMODEL = "startModel";
    private static final int START_BY_LIST_VIEW = 1003;
    private static final String TAG = "MemoryCardUtil";

    static {
    }

    public MemoryCardUtil() {
    }

    public static void addMemoryCard(Context r5, int r6, long r7) {
        Intent r0 = new Intent();
        r0.setClassName(MEMORYPACKAGENAME, MEMORYPACKAGENAME + LibrarianImpl.Constants.DOT + MEMORYPHONTACTIVITY);
        r0.putExtra(STARTMODEL, 1003);
        r0.putExtra(CARDTYPE, r6);
        r0.putExtra(ENTRYCONTACTID, r7);
        if ((r5 instanceof Activity) == false) goto L6;
        ((Activity) r5).startActivityForResult(r0, 1002);
        return;
    }

    public static void showMemoryCard(Context r5, Long r6, int r7, long r8) {
        Intent r0 = new Intent();
        r0.setClassName(MEMORYPACKAGENAME, MEMORYPACKAGENAME + LibrarianImpl.Constants.DOT + MEMORYPHONTINFOACTIVITY);
        r0.putExtra(CARDID, r6);
        r0.putExtra(CARDTYPE, r7);
        r0.putExtra(ENTRYCONTACTID, r8);
        if ((r5 instanceof Activity) == false) goto L6;
        ((Activity) r5).startActivityForResult(r0, 1002);
        return;
    }

    public static void deleteCard(Context r4, Long r5, String r6, ArrayList<Long> r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.longValue() != (-1)) goto L6;
        return;
    L6:
        if (r7.contains(r5) == true) goto L12;
        Intent r0 = new Intent(MEMORYOPERATE);
        r0.setPackage(MEMORYPACKAGENAME);
        r0.putExtra(OPTYPE, 2);
        r0.putExtra(REFID, r5);
        r0.putExtra(IDNUMBERS, r6);
        r4.sendBroadcast(r0);
        return;
    }

    public static void deleteAllCardNotInList(Context r4, EntityDeltaList r5, ArrayList<Long> r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L22;
        Iterator<EntityDelta> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L23;
        ArrayList<EntityDelta.ValuesDelta> r0 = r7.next().getMimeEntries("vnd.android.cursor.item/card_id");
        if (r0 == null) goto L8;
        Iterator<EntityDelta.ValuesDelta> r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L8;
        EntityDelta.ValuesDelta r2 = r1.next();
        deleteCard(r4, r2.getAsLong(DBHelper.COL_DATA3), r2.getAsString("data1"), r6);
        goto L14
    L23:
        return;
    }

    public static void updateIDCardInfo(Context r6, EntityDeltaList r7) {
        Iterator<EntityDelta> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L19;
        ArrayList<EntityDelta.ValuesDelta> r0 = r8.next().getMimeEntries("vnd.android.cursor.item/card_id");
        if (r0 == null) goto L4;
        Iterator<EntityDelta.ValuesDelta> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r2 = r1.next();
        if (r2.isUpdate() == false) goto L15;
        int r3 = 1;
    L18:
        Long r4 = r2.getAsLong(DBHelper.COL_DATA3);
        String r5 = r2.getAsString("data1");
        Intent r9 = new Intent(MEMORYOPERATE);
        r9.setPackage(MEMORYPACKAGENAME);
        r9.putExtra(OPTYPE, r3);
        r9.putExtra(REFID, r4);
        r9.putExtra(IDNUMBERS, r5);
        r6.sendBroadcast(r9);
        goto L10
    L15:
        if (r2.isDelete() == false) goto L17;
        r3 = 2;
        goto L18
    L17:
        r3 = -1;
        goto L18
    }

    public static Intent getCardInfoIntent(Long r5, int r6) {
        Intent r0 = new Intent();
        if (r5.longValue() == (-1)) goto L5;
        r0.setClassName(MEMORYPACKAGENAME, MEMORYPACKAGENAME + LibrarianImpl.Constants.DOT + MEMORYPHONTINFOACTIVITY);
        r0.putExtra(INTENTTYPE, "wallet");
        r0.putExtra(OPENMODE, 1);
        r0.putExtra(CARDID, r5);
        r0.putExtra(CARDTYPE, r6);
    L6:
        return r0;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "error in return card info intent, the refId is" + r5 + " the type is " + r6);
        goto L6
    }

    public static void deleteCardWithContactUri(Context r2, Uri r3) {
        Iterator<Long> r4 = ContactsUtils.queryRefsIdFromWallet(r2, r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        deleteWallet(r2, r4.next().longValue());
        goto L4
    }

    private static void deleteWallet(Context r3, long r4) {
        Intent r1 = new Intent(MEMORYOPERATE);
        r1.setPackage(MEMORYPACKAGENAME);
        r1.putExtra(OPTYPE, 2);
        r1.putExtra(REFID, r4);
        r3.sendBroadcast(r1);
    }
}
