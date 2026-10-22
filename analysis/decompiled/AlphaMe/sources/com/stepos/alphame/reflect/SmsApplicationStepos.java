package com.stepos.alphame.reflect;

import android.content.ComponentName;
import android.content.Context;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class SmsApplicationStepos {
    private static final String TAG = "SmsApplicationStepos";

    public static ComponentName getDefaultSmsApplication(Context context, boolean z4) {
        try {
            return PerfBinderHelper.getDefaultSmsApplication(z4);
        } catch (Exception e4) {
            AbstractC0351g.B("getDefaultSmsApplication exception: ", e4, TAG);
            return null;
        }
    }
}
