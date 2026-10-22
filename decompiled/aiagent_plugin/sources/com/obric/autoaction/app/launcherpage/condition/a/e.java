package com.obric.autoaction.app.launcherpage.condition.a;

import com.google.android.material.timepicker.TimeModel;
import d.h.b.ad;
import d.h.b.o;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: TimePickUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final String a(int r4) {
        ad r0 = ad.f38485a;
        String r5 = String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1));
        o.c(r5, "format(...)");
        return r5;
    }
}
