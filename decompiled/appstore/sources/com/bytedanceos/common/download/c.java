package com.bytedanceos.common.download;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.R$color;
import com.obric.oui.dialog.v2.alert.OAlertDialog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static void a(Activity r10, OAlertDialog r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L14;
        View r12 = r11.E0();
        if (r12 != null) goto L8;
        return;
    L8:
        r12.setBackgroundColor(ContextCompat.b(r10, R$color.oui_fill_element_2));
        if ((r12 instanceof TextView) == false) goto L13;
        ((TextView) r12).setTextColor(ContextCompat.b(r10, R$color.oui_functional_blue_6));
        return;
    L13:
        return;
    L14:
        return;
    }
}
