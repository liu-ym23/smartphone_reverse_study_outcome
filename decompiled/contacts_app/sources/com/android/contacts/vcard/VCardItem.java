package com.android.contacts.vcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.vcard.VCardEntry;
import com.android.vcard.exception.VCardException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class VCardItem {
    private static final String TAG = "VCardItem";
    HashMap<Integer, Drawable.ConstantState> constantStateCache;
    Context mContext;
    ArrayList<VCardEntry> mVCardEntries;

    public VCardItem(Context r1, Uri r2) throws IOException, VCardException {
        this(r1, ContactsVCardUtils.getVCardEntries(r1, r2));
    }

    public VCardItem(Context r2, ArrayList<VCardEntry> r3) {
        this.mVCardEntries = null;
        this.mContext = null;
        this.constantStateCache = new HashMap();
        this.mContext = r2;
        if (r3 == null) goto L7;
        this.mVCardEntries = r3;
        return;
    L7:
        throw new NullPointerException("Initialization value can not be null.");
    }

    public CharSequence getDisplayVCardContent(int r3) {
        if (r3 >= 0) goto L4;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getDisplayVCardContent Out of bounds, size: " + this.mVCardEntries.size() + "; position:" + r3);
        return null;
    L4:
        if (r3 > (this.mVCardEntries.size() - 1)) goto L8;
        return getVCardContent(this.mVCardEntries.get(r3));
    }

    private CharSequence getVCardContent(VCardEntry r5) {
        String r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        String r1 = r5.getDisplayName();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = this.mContext.getString(R.string.vcard_unknow_name);
    L8:
        List<VCardEntry.PhoneData> r4 = r5.getPhoneList();
        if (r4 != null) goto L11;
    L13:
        List<VCardEntry.EmailData> r6 = r5.getEmailList();
        if (r6 != null) goto L16;
    L19:
        if (TextUtils.isEmpty(r0) == true) goto L22;
        SpannableString r7 = new SpannableString(r1 + "\n" + r0);
        r7.setSpan(new ForegroundColorSpan(-7829368), r1.length() + 1, r7.length(), 33);
        r7.setSpan(new RelativeSizeSpan(0.92f), r1.length() + 1, r7.length(), 33);
        return r7;
    L22:
        return new SpannableString(r1);
    L16:
        if (r6.size() <= 0) goto L19;
        r0 = r6.get(0).getAddress();
        goto L19
    L11:
        if (r4.size() <= 0) goto L13;
        r0 = PhoneNumberUtils.formatNumber(r4.get(0).getNumber());
        goto L19
    }

    public CharSequence getAllVCardContent(int r3) {
        if (r3 >= 0) goto L4;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getDisplayVCardContent Out of bounds, size: " + this.mVCardEntries.size() + "; position:" + r3);
        return null;
    L4:
        if (r3 > (this.mVCardEntries.size() - 1)) goto L8;
        return ContactsVCardUtils.getVCardInfo(this.mContext, this.mVCardEntries.get(r3));
    }

    public Drawable.ConstantState getAvatar(Integer r4) {
        if (this.constantStateCache.containsKey(r4) == true) goto L9;
        byte[] r0 = getAvatarBytes(r4);
        if (r0 == null) goto L7;
        Bitmap r1 = BitmapFactory.decodeByteArray(r0, 0, r0.length);
        Drawable.ConstantState r2 = new BitmapDrawable(this.mContext.getResources(), r1).getConstantState();
        this.constantStateCache.put(r4, r2);
        goto L9
    L7:
        this.constantStateCache.put(r4, null);
    L9:
        return this.constantStateCache.get(r4);
    }

    private byte[] getAvatarBytes(Integer r4) {
        if (r4.intValue() >= 0) goto L5;
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAvatarBytes Out of bounds, size: " + this.mVCardEntries.size() + "; position:" + r4);
        return null;
    L5:
        if (r4.intValue() > (this.mVCardEntries.size() - 1)) goto L14;
        List<VCardEntry.PhotoData> r3 = this.mVCardEntries.get(r4.intValue()).getPhotoList();
        if (r3 != null) goto L10;
    L13:
        return null;
    L10:
        if (r3.size() <= 0) goto L13;
        return r3.get(0).getBytes();
    }

    public int size() {
        return this.mVCardEntries.size();
    }

    public void destroy() {
        HashMap<Integer, Drawable.ConstantState> r0 = this.constantStateCache;
        if (r0 == null) goto L8;
        Iterator<Integer> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Integer r2 = r1.next();
        Drawable.ConstantState r3 = this.constantStateCache.get(r2);
        goto L6
    L10:
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("size:");
        r0.append(size()).append("\n").append(ContactsVCardUtils.getVCardEntriesInfo(this.mContext, this.mVCardEntries));
        return r0.toString();
    }
}
