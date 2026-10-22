package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: compiled from: StyleController.kt */
    public static final class a {
        public static void a(e r2, AbstractDialog r3) {
            o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "this");
            o.e(r3, "dialog");
        }

        public static void a(e r2, AlertDialogHost r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
            AlertDialogHost r5 = (AlertDialogHost) ZeusTransformUtils.wrapperContextForParams(r3, AlertDialogHost.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            o.e(r5, "host");
            if (ZeusTransformUtils.instanceOf(r5, OAlertDialog.class) == false) goto L6;
            r4.a((AbstractDialog) ZeusTransformUtils.preCheckCast(r5, AbstractDialog.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    void a(Context r1, c r2);

    void a(AbstractDialog r1);

    void a(AlertDialogHost r1);
}
