package com.obric.appstore.common.core.ui.view;

import android.view.View;
import com.obric.appstore.R;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final View a(OSearchBar r10) {
        q.g(r10, "<this>");
        int r11 = R.id.tag_appstore_oui_search_bar_border_container;
        Object r12 = r10.getTag(r11);
        if ((r12 instanceof View) == false) goto L5;
        View r13 = (View) r12;
    L6:
        if (r13 == null) goto L8;
        return r13;
    L8:
        View r14 = r10.findViewById(R.id.searchbar_container);
        if (r14 == null) goto L12;
        r10.setTag(r11, r14);
        return r14;
    L12:
        return null;
    L5:
        r13 = null;
        goto L6
    }
}
