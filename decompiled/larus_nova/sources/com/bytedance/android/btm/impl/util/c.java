package com.bytedance.android.btm.impl.util;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42498a = 0;

    static {
    }

    public static String a(PageFinder r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        Object r101 = r100.page;
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.getClass().getCanonicalName();
    L9:
        View r104 = r100.view;
        if (r104 == null) goto L12;
        String r105 = r104.getClass().getCanonicalName();
    L13:
        Fragment r106 = r100.fragment;
        if (r106 == null) goto L16;
        r102 = r106.getClass().getCanonicalName();
    L16:
        if (r103 != null) goto L26;
        if (r105 != null) goto L27;
        if (r102 != null) goto L28;
        String r107 = r100.btmPageId;
        if (r107 != null) goto L25;
        return "null";
    L25:
        return r107;
    L28:
        return r102;
    L27:
        return r105;
    L26:
        return r103;
    L12:
        r105 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    public static String b(PageFinder r100) {
        String r101 = "null";
        if (r100 != null) goto L5;
        return "null";
    L5:
        StringBuilder r102 = new StringBuilder("page: ");
        Object r103 = r100.page;
        if (r103 == null) goto L10;
        String r104 = r103.getClass().getCanonicalName();
        if (r104 == null) goto L10;
    L11:
        View r105 = r100.view;
        if (r105 == null) goto L16;
        String r106 = r105.getClass().getCanonicalName();
        if (r106 == null) goto L16;
    L17:
        Fragment r107 = r100.fragment;
        if (r107 == null) goto L22;
        String r108 = r107.getClass().getCanonicalName();
        if (r108 == null) goto L22;
        r101 = r108;
    L22:
        r102.append(r104);
        r102.append(", view: ");
        r102.append(r106);
        r102.append(", fragment: ");
        r102.append(r101);
        String r109 = r100.btmPageId;
        if (r109 != null) goto L25;
        String r110 = "false";
    L32:
        r102.append(", has_page_id: ");
        r102.append(r110);
        return r102.toString();
    L25:
        if (r109.length() != 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L30;
        r110 = "empty";
        goto L32
    L30:
        r110 = "true";
        goto L32
    L27:
        r111 = false;
    L16:
        r106 = "null";
    L10:
        r104 = "null";
        goto L11
    }
}
