package com.stepos.alphame.reflect;

import android.os.Bundle;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class UserHandleStepos {
    public static final android.os.UserHandle ALL;
    public static final android.os.UserHandle CURRENT;
    public static final int USER_ALL;
    public static final int USER_CURRENT;
    public static final int USER_OWNER;

    static {
        Bundle userHandleConstants = PerfBinderHelper.getUserHandleConstants();
        int i4 = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_ALL_ID, -1);
        USER_ALL = i4;
        int i5 = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_CURRENT_ID, -2);
        USER_CURRENT = i5;
        USER_OWNER = userHandleConstants.getInt(PerfBinderHelper.KEY_USER_HANDLE_OWNER_ID, 0);
        ALL = UserHandle.fromIdentifier(i4);
        CURRENT = UserHandle.fromIdentifier(i5);
    }
}
