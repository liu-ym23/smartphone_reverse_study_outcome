package ms.bd.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class l1 {
    public static String a(Context r6) {
        String r1 = "null_";
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L31;
        return null;
    L31:
        String r4 = Settings.Secure.getString(r7.getContentResolver(), "default_input_method");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r4) == false) goto L10;
    L17:
        StringBuilder r2 = new StringBuilder(r1);
        Iterator<InputMethodInfo> r8 = ((InputMethodManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin")).getInputMethodList().iterator();     // Catch: Throwable -> L30
    L20:
        if (r8.hasNext() == false) goto L28;
        String r0 = ((InputMethodInfo) ZeusTransformUtils.preCheckCast(r8.next(), InputMethodInfo.class, "com.obric.aiagent.plugin")).getPackageName();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r0) == true) goto L20;
        if (r2.indexOf(r0) >= 0) goto L20;
        r2.append("[<!>]").append(r0);     // Catch: Throwable -> L30
    L28:
        return r2.toString();
    L10:
        if (r4.contains("/") == false) goto L13;
        String r3 = r4.split("/")[0];     // Catch: Throwable -> L14
    L16:
        r1 = r3;
        goto L17
    L13:
        r1 = r4;
    L14:
        th = move-exception;
        r3 = "null_" + th.getMessage();     // Catch: Throwable -> L29
        goto L16
    }

    public static String b(Context r4) {
        String r1 = "null_";
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L19;
        return null;
    L19:
        String r6 = Settings.Secure.getString(r5.getContentResolver(), "default_input_method");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r6) == true) goto L17;
        if (r6.contains("/") == false) goto L12;
        r6 = r6.split("/")[0];     // Catch: Throwable -> L13
    L12:
        r1 = r6;
    L17:
        return new StringBuilder(r1).toString();
    L13:
        th = move-exception;
        r6 = "null_" + th.getMessage();     // Catch: Throwable -> L18
        goto L12
    }
}
