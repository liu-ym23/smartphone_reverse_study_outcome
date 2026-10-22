package com.android.contacts.calllog;

import android.content.Context;
import android.database.Cursor;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PhoneCallDetails;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class CallLogGroupBuilder {
    private Context mContext;
    private final String mDefaultCountryIso;
    private final GroupCreator mGroupCreator;
    private boolean mIsShowSingleContactCalls;

    public interface GroupCreator {
        void addGroup(int r1, int r2, boolean r3);
    }

    public CallLogGroupBuilder(GroupCreator r2, Context r3) {
        this(r2, false, r3);
    }

    public CallLogGroupBuilder(GroupCreator r1, boolean r2, Context r3) {
        this.mGroupCreator = r1;
        this.mIsShowSingleContactCalls = r2;
        this.mContext = r3;
        if (r3 == null) goto L5;
        this.mDefaultCountryIso = ContactsUtils.getCurrentCountryIso(r3);
        return;
    L5:
        this.mDefaultCountryIso = ContactsUtils.getUnknownCountryIso();
    }

    public void addGroups(Cursor r19) {
        if (this.mIsShowSingleContactCalls == false) goto L5;
        return;
    L5:
        if (r19.isClosed() == false) goto L7;
        return;
    L7:
        if (r19.moveToFirst() == false) goto L66;
        int r2 = r19.getCount();
        if (r2 != 0) goto L12;
        return;
    L12:
        int r3 = 1;
        String r4 = r19.getString(1);     // Catch: Exception -> L55
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        int r7 = r19.getInt(4);     // Catch: Exception -> L55
        long r9 = r19.getLong(2);     // Catch: Exception -> L55
        Calendar r11 = Calendar.getInstance();     // Catch: Exception -> L55
        r11.setTimeInMillis(r9);     // Catch: Exception -> L55
        Calendar r10 = Calendar.getInstance();     // Catch: Exception -> L55
        int r12 = 1;
    L20:
        if (r19.moveToNext() == false) goto L52;
        String r13 = r19.getString(r3);     // Catch: Exception -> L55
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        int r14 = r19.getInt(4);     // Catch: Exception -> L55
        boolean r15 = equalNumbers(r4, r13, this.mContext);     // Catch: Exception -> L55
        String r16 = r4;
        long r5 = r19.getLong(2);     // Catch: Exception -> L55
        r10.setTimeInMillis(r5);     // Catch: Exception -> L55
        boolean r17 = false;
        if (CallLogQuery.isSectionHeader(r19) == true) goto L44;
        if (r15 == false) goto L44;
        if (isSameDay(r11, r10) == false) goto L44;
        if (r7 == 4) goto L42;
        if (r7 == 3) goto L42;
        if (r14 != 7) goto L39;
    L41:
        r17 = true;
        goto L44
    L39:
        if (r14 == 1) goto L41;
        if (r14 != 2) goto L44;
    L42:
        if (r14 == 3) goto L41;
    L44:
        if (r17 == false) goto L47;
        r12 = r12 + 1;     // Catch: Exception -> L55
        r4 = r16;
    L50:
        r3 = 1;
        goto L20
    L47:
        if (r12 <= 1) goto L49;
        addGroup(r19.getPosition() - r12, r12);     // Catch: Exception -> L55
    L49:
        r11.setTimeInMillis(r5);     // Catch: Exception -> L55
        r4 = r13;
        r7 = r14;
        r12 = 1;
        goto L50
    L52:
        if (r12 <= r3) goto L65;
        addGroup(r2 - r12, r12);     // Catch: Exception -> L55
        return;
    L65:
        return;
    L55:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public boolean isTheSameGroup(PhoneCallDetails r9, PhoneCallDetails r10) {
        if (TextUtils.isEmpty(r9.number) == false) goto L5;
        return false;
    L5:
        String r0 = r9.number.toString();
        if (r9.callTypes != null) goto L8;
        return false;
    L8:
        if (r9.callTypes.length == 0) goto L41;
        int r2 = r9.callTypes[0];
        long r3 = r9.date;
        Calendar r11 = Calendar.getInstance();
        r11.setTimeInMillis(r3);
        Calendar r4 = Calendar.getInstance();
        if (TextUtils.isEmpty(r10.number) == false) goto L13;
        return false;
    L13:
        String r5 = r10.number.toString();
        if (r10.callTypes != null) goto L16;
        return false;
    L16:
        if (r10.callTypes.length == 0) goto L42;
        int r6 = r10.callTypes[0];
        boolean r1 = equalNumbers(r0, r5, this.mContext);
        r4.setTimeInMillis(r10.date);
        if (r1 == true) goto L22;
        return false;
    L22:
        if (isSameDay(r11, r4) == true) goto L25;
        return false;
    L25:
        if (r2 == 4) goto L34;
        if (r2 == 3) goto L34;
        if (r6 == 7) goto L39;
        if (r6 == 1) goto L39;
        if (r6 == 2) goto L39;
        return false;
    L39:
        return true;
    L34:
        if (r6 == 3) goto L39;
        return false;
    L42:
        return false;
    L41:
        return false;
    }

    private boolean isSameDay(Calendar r3, Calendar r4) {
        if (r3.get(1) == r4.get(1)) goto L5;
        return false;
    L5:
        if (r3.get(2) == r4.get(2)) goto L7;
        return false;
    L7:
        if (r3.get(6) != r4.get(6)) goto L12;
        return true;
    L12:
        return false;
    }

    private void addGroup(int r2, int r3) {
        this.mGroupCreator.addGroup(r2, r3, false);
    }

    boolean equalNumbers(String r1, String r2, Context r3) {
        if (PhoneNumberUtils.isUriNumber(r1) == true) goto L19;
        if (PhoneNumberUtils.isUriNumber(r2) == true) goto L19;
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (TextUtils.isEmpty(r2) == true) goto L17;
        boolean r4 = r1.equals(r2);
        if (r4 == false) goto L14;
        return r4;
    L14:
        return PhoneNumberUtils.areSamePhoneNumber(r1, r2, this.mDefaultCountryIso);
    L17:
        return PhoneNumberUtils.areSamePhoneNumber(r1, r2, this.mDefaultCountryIso);
    L19:
        return compareSipAddresses(r1, r2);
    }

    boolean compareSipAddresses(String r8, String r9) {
        if (r8 == null) goto L20;
        if (r9 == null) goto L20;
        int r2 = r8.indexOf(64);
        String r3 = "";
        if (r2 == (-1)) goto L9;
        String r5 = r8.substring(0, r2);
        String r4 = r8.substring(r2);
        r8 = r5;
    L10:
        int r1 = r9.indexOf(64);
        if (r1 == (-1)) goto L14;
        String r6 = r9.substring(0, r1);
        r3 = r9.substring(r1);
        r9 = r6;
    L14:
        if (r8.equals(r9) == false) goto L19;
        if (r4.equalsIgnoreCase(r3) == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        r4 = "";
    L20:
        if (r8 != r9) goto L23;
        return true;
    L23:
        return false;
    }
}
