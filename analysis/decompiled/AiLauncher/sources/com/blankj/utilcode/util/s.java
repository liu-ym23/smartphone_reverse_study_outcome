package com.blankj.utilcode.util;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class s {
    public static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(p.a().getResources().getConfiguration().getLocales().get(0)) == 1;
    }

    public static View b(int i10) {
        return ((LayoutInflater) p.a().getSystemService("layout_inflater")).inflate(i10, (ViewGroup) null);
    }
}
