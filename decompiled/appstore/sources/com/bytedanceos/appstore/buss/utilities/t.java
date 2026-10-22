package com.bytedanceos.appstore.buss.utilities;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.obric.appstore.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f8878a = null;

    static {
        f8878a = new t();
    }

    public t() {
    }

    public final OButton a(OCTitleBar r10, View.OnClickListener r11) {
        if (r10 == null) goto L5;
        r10.setShowLeftBack(true);
    L5:
        if (r10 == null) goto L9;
        OButton r12 = r10.getMLeftActionBack();
        if (r12 == null) goto L9;
        r12.setOnClickListener(r11);
    L9:
        if (r10 != null) goto L13;
        return null;
    L13:
        return r10.getMLeftActionBack();
    }

    public final ImageView b(OCTitleBar r10, View.OnClickListener r11) {
        String r12 = null;
        if (r10 == null) goto L5;
        ImageView r13 = r10.b(R.drawable.standard_icon_collect_reverse_selector);
    L6:
        if (r13 == null) goto L9;
        r13.setId(R.id.toolbar_collect);
    L9:
        if (r13 == null) goto L11;
        r13.setOnClickListener(r11);
    L11:
        if (r13 == null) goto L17;
        Context r14 = r13.getContext();
        if (r14 == null) goto L16;
        r12 = r14.getString(R.string.smt_collect);
    L16:
        r13.setContentDescription(r12);
    L17:
        return r13;
    L5:
        r13 = null;
        goto L6
    }

    public final ImageView c(OCTitleBar r10, View.OnClickListener r11) {
        return null;
    }

    public final ImageView d(OCTitleBar r10, View.OnClickListener r11) {
        return null;
    }

    public final ImageView e(OCTitleBar r10, View.OnClickListener r11) {
        return null;
    }
}
