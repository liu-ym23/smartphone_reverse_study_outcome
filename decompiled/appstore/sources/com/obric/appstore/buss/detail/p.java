package com.obric.appstore.buss.detail;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Category;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final List a(AppInfo r10) {
        q.g(r10, "<this>");
        if (TextUtils.isEmpty(r10.mCategoryId) == true) goto L19;
        if (TextUtils.isEmpty(r10.appCategoryName) == true) goto L19;
        String r11 = r10.appCategoryName;
        q.f(r11, "appCategoryName");
        List<String> r12 = new Regex(",").split(r11, 0);
        if (r12.isEmpty() == true) goto L10;
        ArrayList r13 = new ArrayList();
        Category r14 = new Category();
        r14.setId(r10.mCategoryId);
        r14.setName(r12.get(0));
        r13.add(r14);
        if (TextUtils.isEmpty(r10.secondCategoryId) == false) goto L14;
    L17:
        return r13;
    L14:
        if (r12.size() == 1) goto L17;
        Category r15 = new Category();
        r15.setId(r10.secondCategoryId);
        r15.setName(r12.get(1));
        r15.setParent_id(r10.mCategoryId);
        r13.add(r15);
        goto L17
    L10:
        return t.i();
    L19:
        return t.i();
    }

    public static final CharSequence b(AppInfo r10) {
        q.g(r10, "<this>");
        return d(c(r10));
    }

    public static final String c(AppInfo r10) {
        q.g(r10, "<this>");
        String r11 = r10.appDeveloper;
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        if (r11.length() != 0) goto L9;
        String r12 = pa.a.f23414a.a().getString(R.string.unkown);
        q.f(r12, "getString(...)");
        return r12;
    L9:
        return r11;
    }

    public static final CharSequence d(String r10) {
        q.g(r10, "<this>");
        SpannableString r11 = new SpannableString(r10);
        r11.setSpan(new UnderlineSpan(), 0, r10.length(), 0);
        return r11;
    }
}
