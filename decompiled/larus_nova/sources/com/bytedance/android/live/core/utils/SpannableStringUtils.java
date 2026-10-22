package com.bytedance.android.live.core.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class SpannableStringUtils {
    public SpannableStringUtils() {
    }

    public static int getFormatColor(String r100) {
        return Color.parseColor(r100);
    L4:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
        return s1.h(R.color.ttlive_black);
    }

    public static SpannableString getDiffColorSpannable(String r100, String r101, List<Pair<Integer, Integer>> r102) {
        SpannableString r103 = new SpannableString(r100);
        Iterator<Pair<Integer, Integer>> r104 = r102.iterator();     // Catch: Exception -> L8
    L5:
        if (r104.hasNext() == false) goto L10;
        Pair<Integer, Integer> r105 = r104.next();     // Catch: Exception -> L8
        r103.setSpan(new ForegroundColorSpan(getFormatColor(r101)), ((Integer) r105.first).intValue(), ((Integer) r105.second).intValue(), 33);     // Catch: Exception -> L8
    L10:
        return r103;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static SpannableString getDiffColorSpannable(String r100, int r101, int r102, int r103) {
        SpannableString r104 = new SpannableString(r100);
        r104.setSpan(new ForegroundColorSpan(r103), r101, r102, 33);
        return r104;
    }
}
