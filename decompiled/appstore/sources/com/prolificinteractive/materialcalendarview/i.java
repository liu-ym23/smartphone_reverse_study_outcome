package com.prolificinteractive.materialcalendarview;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static boolean a() {
        return b(Locale.getDefault());
    }

    public static boolean b(Locale r10) {
        byte r11 = Character.getDirectionality(r10.getDisplayName().charAt(0));
        if (r11 == 1) goto L7;
        if (r11 == 2) goto L7;
        return false;
    L7:
        return true;
    }
}
