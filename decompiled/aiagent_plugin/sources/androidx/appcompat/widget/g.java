package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatHintHelper.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    static InputConnection a(InputConnection r2, EditorInfo r3, View r4) {
        InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r2, InputConnection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L13:
        return r5;
    L5:
        if (r3.hintText != null) goto L13;
        ViewParent r6 = r4.getParent();
    L8:
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r6, ad.class) == true) goto L11;
        r6 = r6.getParent();
        goto L8
    L11:
        r3.hintText = ((ad) ZeusTransformUtils.preCheckCast(r6, ad.class, "com.obric.aiagent.plugin")).a();
        goto L13
    }
}
