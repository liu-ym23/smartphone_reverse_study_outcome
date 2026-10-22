package com.android.contacts.util;

import android.content.Context;
import android.content.res.Configuration;
import android.telephony.PhoneNumberUtils;
import android.widget.AbsListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.internal.telephony.ITelephony;
import java.util.List;
import obric.api.AbsListViewSmt;
import obric.api.ConfigureRescourceSmt;
import obric.api.SpinnerSmt;
import obric.api.TelephonySmt;
import obric.api.TextViewSmt;

/* JADX INFO: loaded from: classes2.dex */
public class BytedanceApi {
    public static String formatNumberToLite(Context r0, String r1, String r2) {
        return "";
    }

    public BytedanceApi() {
    }

    public static void setMaxTextSize(TextView r1, float r2) {
        TextViewSmt.getInstance().setMaxTextSize(r1, r2);
    }

    public static void setBytedanceTopSelector(Spinner r1, boolean r2) {
        SpinnerSmt.getInstance().setBytedanceTopSelector(r1, r2);
    }

    public static void setBytedanceBottomSelector(Spinner r1, boolean r2) {
        SpinnerSmt.getInstance().setBytedanceBottomSelector(r1, r2);
    }

    public static void setBytedanceTopSelector(AbsListView r1, boolean r2) {
        AbsListViewSmt.getInstance().setBytedanceTopSelector(r1, r2);
    }

    public static void setBytedanceBottomSelector(AbsListView r1, boolean r2) {
        AbsListViewSmt.getInstance().setBytedanceBottomSelector(r1, r2);
    }

    public static List<String> getActiveNumbers(ITelephony r1) {
        return TelephonySmt.getInstance().getActiveNumbers(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isLocalEmergencyNumber(String r0, Context r1) {
        return PhoneNumberUtils.isLocalEmergencyNumber(r1, r0);
    }

    public static boolean isSameCustomTheme(Configuration r1, Configuration r2) {
        return ConfigureRescourceSmt.getInstance().isSameCustomTheme(r1, r2);
    }
}
