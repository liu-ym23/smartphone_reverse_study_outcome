package com.android.contacts.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class DataStatus {
    private int mIconRes;
    private int mLabelRes;
    private int mPresence;
    private String mResPackage;
    private String mStatus;
    private long mTimestamp;

    public DataStatus() {
        this.mPresence = -1;
        this.mStatus = null;
        this.mTimestamp = -1;
        this.mResPackage = null;
        this.mIconRes = -1;
        this.mLabelRes = -1;
    }

    public DataStatus(Cursor r5) {
        this.mPresence = -1;
        this.mStatus = null;
        this.mTimestamp = -1;
        this.mResPackage = null;
        this.mIconRes = -1;
        this.mLabelRes = -1;
        fromCursor(r5);
    }

    public void possibleUpdate(Cursor r5) {
        boolean r0 = !isNull(r5, "status");
        boolean r2 = !isNull(r5, "status_ts");
        if (r0 == true) goto L6;
        return;
    L6:
        if (isValid() == false) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        if (r2 == false) goto L14;
        long r1 = getLong(r5, "status_ts", -1);
        if (r1 >= this.mTimestamp) goto L13;
        return;
    L13:
        this.mTimestamp = r1;
    L14:
        fromCursor(r5);
    }

    private void fromCursor(Cursor r5) {
        this.mPresence = getInt(r5, "mode", -1);
        this.mStatus = getString(r5, "status");
        this.mTimestamp = getLong(r5, "status_ts", -1);
        this.mResPackage = getString(r5, "status_res_package");
        this.mIconRes = getInt(r5, "status_icon", -1);
        this.mLabelRes = getInt(r5, "status_label", -1);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mStatus);
    }

    public int getPresence() {
        return this.mPresence;
    }

    public CharSequence getStatus() {
        return this.mStatus;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public CharSequence getTimestampLabel(Context r14) {
        PackageManager r0 = r14.getPackageManager();
        if (this.mResPackage != null) goto L5;
        this.mResPackage = r14.getPackageName();
    L5:
        long r2 = this.mTimestamp;
        if (r2 <= 0) goto L8;
        boolean r1 = true;
    L10:
        if (this.mResPackage != null) goto L12;
    L14:
        boolean r11 = false;
    L16:
        if (r1 == false) goto L18;
        CharSequence r3 = android.text.format.DateUtils.getRelativeTimeSpanString(r2, System.currentTimeMillis(), 60000, 262144);
    L19:
        if (r11 == false) goto L21;
        CharSequence r13 = r0.getText(this.mResPackage, this.mLabelRes, null);
    L22:
        if (r1 == false) goto L26;
        if (r11 == false) goto L26;
        return r14.getString(R.string.contact_status_update_attribution_with_date, new Object[]{r3, r13});
    L26:
        if (r11 == true) goto L28;
        if (r1 == false) goto L31;
        return r3;
    L31:
        return null;
    L28:
        return r14.getString(R.string.contact_status_update_attribution, new Object[]{r13});
    L21:
        r13 = null;
        goto L22
    L18:
        r3 = null;
        goto L19
    L12:
        if (this.mLabelRes == (-1)) goto L14;
        r11 = true;
        goto L16
    L8:
        r1 = false;
        goto L10
    }

    public Drawable getIcon(Context r4) {
        PackageManager r0 = r4.getPackageManager();
        if (this.mResPackage != null) goto L5;
        this.mResPackage = r4.getPackageName();
    L5:
        String r5 = this.mResPackage;
        if (r5 != null) goto L8;
    L10:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
        return null;
    L14:
        return r0.getDrawable(r5, this.mIconRes, null);
    L8:
        if (this.mIconRes == (-1)) goto L10;
        r1 = true;
        goto L12
    }

    private static String getString(Cursor r0, String r1) {
        return r0.getString(r0.getColumnIndex(r1));
    }

    private static int getInt(Cursor r0, String r1) {
        return r0.getInt(r0.getColumnIndex(r1));
    }

    private static int getInt(Cursor r1, String r2, int r3) {
        int r4 = r1.getColumnIndex(r2);
        if (r1.isNull(r4) == false) goto L6;
        return r3;
    L6:
        return r1.getInt(r4);
    }

    private static long getLong(Cursor r1, String r2, long r3) {
        int r4 = r1.getColumnIndex(r2);
        if (r1.isNull(r4) == false) goto L6;
        return r3;
    L6:
        return r1.getLong(r4);
    }

    private static boolean isNull(Cursor r0, String r1) {
        return r0.isNull(r0.getColumnIndex(r1));
    }
}
