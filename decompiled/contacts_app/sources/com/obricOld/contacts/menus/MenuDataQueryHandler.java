package com.obricOld.contacts.menus;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.util.BytedanceContactContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MenuDataQueryHandler extends AsyncQueryHandler {
    private static final String[] COLUMNS = null;
    private static final int DATA_CONTACT_ID = 1;
    private static final int DATA_DATA1 = 2;
    private static final int DATA_DATA15 = 3;
    private static final int DATA_ID = 0;
    private static final int DATA_MIMETYPE = 4;
    private static final int TOKEN_CONTACT = 3;
    private static final int TOKEN_NUMBER_BLACK = 2;
    private static final int TOKEN_NUMBER_STAR = 1;
    private static String selection;
    private static String[] selectionArgs;
    private final Uri BLACK_NUMBER_URI;
    private final String TAG;

    interface MenuContactQueryCallback {
        void onComplete(Map<Long, List<ContentValues>> r1);
    }

    interface MenuDataQueryCallback {
        void onComplete(boolean r1);
    }

    public MenuDataQueryHandler(ContentResolver r1) {
        super(r1);
        this.TAG = "MenuDataQueryHandler";
        this.BLACK_NUMBER_URI = Uri.parse("content://com.obric.nodisturb.provider/inblacklist");
    }

    public void queryNumberStarByDataId(long r10, MenuDataQueryCallback r12) {
        startQuery(1, r12, Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, String.valueOf(r10)), new String[]{BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG}, null, null, null);
    }

    public void queryNumberBlacked(String r10, MenuDataQueryCallback r11) {
        startQuery(2, r11, Uri.withAppendedPath(this.BLACK_NUMBER_URI, r10), null, "deleted = 0", null, null);
    }

    public void queryContact(Uri r10, MenuContactQueryCallback r11) {
        startQuery(3, r11, Uri.withAppendedPath(r10, "data"), COLUMNS, selection, selectionArgs, null);
    }

    public final void cancelOperation() {
        cancelOperation(1);
        cancelOperation(2);
        cancelOperation(3);
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int r13, Object r14, Cursor r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        boolean r12 = false;
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L23;
        if (r13 == 3) goto L12;
    L40:
        if (r15 == null) goto L61;
        r15.close();     // Catch: Exception -> L43
        return;
    L61:
        return;
    L12:
        if ((r14 instanceof MenuContactQueryCallback) == false) goto L40;
        MenuContactQueryCallback r16 = (MenuContactQueryCallback) r14;     // Catch: Throwable -> L45
        Long r5 = 0L;     // Catch: Throwable -> L45
        HashMap r6 = new HashMap();     // Catch: Throwable -> L45
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L45
    L14:
        if (r15 == null) goto L21;
        if (r15.moveToNext() == false) goto L21;
        ContentValues r8 = new ContentValues();     // Catch: Throwable -> L45
        r8.put("_id", Long.valueOf(r15.getLong(0)));     // Catch: Throwable -> L45
        if (r5.longValue() > 0) goto L20;
        r5 = Long.valueOf(r15.getLong(1));     // Catch: Throwable -> L45
    L20:
        r8.put("data1", r15.getString(2));     // Catch: Throwable -> L45
        r8.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, Integer.valueOf(r15.getInt(3)));     // Catch: Throwable -> L45
        r8.put("mimetype", r15.getString(4));     // Catch: Throwable -> L45
        r7.add(r8);     // Catch: Throwable -> L45
    L21:
        r6.put(r5, r7);     // Catch: Throwable -> L45
        r16.onComplete(r6);     // Catch: Throwable -> L45
        goto L40
    L23:
        if ((r14 instanceof MenuDataQueryCallback) == false) goto L40;
        MenuDataQueryCallback r17 = (MenuDataQueryCallback) r14;     // Catch: Throwable -> L45
        if (r15 != null) goto L27;
    L29:
        r17.onComplete(r12);     // Catch: Throwable -> L45
        goto L40
    L27:
        if (r15.getCount() <= 0) goto L29;
        r12 = true;
        goto L29
    L31:
        if ((r14 instanceof MenuDataQueryCallback) == false) goto L40;
        MenuDataQueryCallback r18 = (MenuDataQueryCallback) r14;     // Catch: Throwable -> L45
        if (r15 != null) goto L35;
    L39:
        r18.onComplete(r12);     // Catch: Throwable -> L45
        goto L40
    L35:
        if (r15.moveToFirst() == false) goto L39;
        if (r15.getInt(0) != 1) goto L39;
        r12 = true;
    L43:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MenuDataQueryHandler", "Failed to query for token: " + r13);
        e.printStackTrace();
        return;
    L45:
        th = move-exception;
        if (r15 != null) goto L54;
    L51:
        throw th;     // Catch: Exception -> L43
    L54:
        r15.close();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L43
        goto L51
    }

    static {
        COLUMNS = new String[]{"_id", "contact_id", "data1", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "mimetype"};
        selectionArgs = new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile"};
        selection = "mimetype =? OR mimetype =? ";
    }
}
