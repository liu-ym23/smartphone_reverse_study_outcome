package com.obric.oui.dialog;

import android.view.ViewGroup;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DialogUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final void a(TextView r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r7, "message");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (d.o.o.c(r7, '\n', false, 2, null) == false) goto L5;
        r0.width = -1;
    L6:
        r5.setLayoutParams(r0);
        return;
    L5:
        r0.width = -2;
        goto L6
    }
}
