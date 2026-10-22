package com.stepos.alphame.reflect;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Process;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class UserHandle {
    public static final android.os.UserHandle ALL;
    public static final android.os.UserHandle CURRENT;
    private static final int DEFAULT_STEPOS_PARALLEL_SPACE_USER_ID = 999;
    private static final int DEFAULT_USER_ALL = -1;
    private static final int DEFAULT_USER_CURRENT = -2;
    private static final int DEFAULT_USER_SYSTEM = 0;
    public static final int STEPOS_PARALLEL_SPACE_USER_ID;
    public static final int USER_SYSTEM;

    static {
        Bundle userHandleConstants = PerfBinderHelper.getUserHandleConstants();
        STEPOS_PARALLEL_SPACE_USER_ID = userHandleConstants.getInt(PerfBinderHelper.KEY_PARALLEL_SPACE_USER_ID, 999);
        int i4 = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_CURRENT_ID, -2);
        int i5 = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_ALL_ID, -1);
        USER_SYSTEM = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_SYSTEM_ID, 0);
        CURRENT = fromIdentifier(i4);
        ALL = fromIdentifier(i5);
    }

    public static android.os.UserHandle fromIdentifier(int i4) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInt(i4);
            parcelObtain.setDataPosition(0);
            return (android.os.UserHandle) android.os.UserHandle.CREATOR.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static int getIdentifier(android.os.UserHandle userHandle) {
        if (userHandle == null) {
            return -1;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            userHandle.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return parcelObtain.readInt();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static int getUserId(int i4) {
        if (i4 < 0) {
            return -1;
        }
        return i4 / ComplexPt.TEN_THOUSAND;
    }

    public static boolean isCore(int i4) {
        return i4 >= 0 && i4 < 10000;
    }

    public static int myUserId() {
        return Process.myUid() / ComplexPt.TEN_THOUSAND;
    }
}
