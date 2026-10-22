package com.obric.appstore.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.obric.appstore.R;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(OPanelTitleBar r10) {
        q.g(r10, "<this>");
        View r11 = r10.findViewById(R.id.panel_title);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof TextView) == false) goto L7;
        TextView r12 = (TextView) r11;
    L8:
        if (r12 == null) goto L13;
        TextViewCompat.n(r12, R.style.Title_Title_M);
        return;
    L13:
        return;
    L7:
        r12 = null;
        goto L8
    }
}
