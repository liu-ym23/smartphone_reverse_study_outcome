package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.u;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TextViewOnReceiveContentListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements u {

    /* JADX INFO: compiled from: TextViewOnReceiveContentListener.java */
    private static final class a {
        static CharSequence a(Context r2, ClipData.Item r3, int r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L9;
            CharSequence r6 = r3.coerceToText(r5);
            if (ZeusTransformUtils.instanceOf(r6, Spanned.class) == true) goto L7;
            return r6;
        L7:
            return r6.toString();
        L9:
            return r3.coerceToStyledText(r5);
        }
    }

    /* JADX INFO: compiled from: TextViewOnReceiveContentListener.java */
    private static final class b {
        static CharSequence a(Context r2, ClipData.Item r3, int r4) {
            CharSequence r5 = r3.coerceToText((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
            if ((r4 & 1) != 0) goto L5;
            return r5;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L7;
            return r5;
        L7:
            return r5.toString();
        }
    }

    public h() {
    }

    @Override // androidx.core.view.u
    public androidx.core.view.b a(View r7, androidx.core.view.b r8) {
        if (a("ReceiveContent", 3) == false) goto L6;
        a("ReceiveContent", "onReceive: " + r8);
    L6:
        if (r8.c() != 2) goto L8;
        return r8;
    L8:
        ClipData r6 = r8.b();
        int r9 = r8.d();
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        Editable r0 = (Editable) ZeusTransformUtils.preCheckCast(r10.getText(), Editable.class, "com.obric.aiagent.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        boolean r2 = false;
    L10:
        if (r1 >= r6.getItemCount()) goto L17;
        CharSequence r3 = a(r11, r6.getItemAt(r1), r9);
        if (r3 == null) goto L16;
        if (r2 == true) goto L15;
        a(r0, r3);
        r2 = true;
        goto L16
    L15:
        r0.insert(Selection.getSelectionEnd(r0), "\n");
        r0.insert(Selection.getSelectionEnd(r0), r3);
    L16:
        r1 = r1 + 1;
        goto L10
    L17:
        return null;
    }

    private static CharSequence a(Context r2, ClipData.Item r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return a.a(r5, r3, r4);
    L7:
        return b.a(r5, r3, r4);
    }

    private static void a(Editable r4, CharSequence r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = Selection.getSelectionStart(r6);
        int r1 = Selection.getSelectionEnd(r6);
        int r2 = Math.max(0, Math.min(r0, r1));
        int r3 = Math.max(0, Math.max(r0, r1));
        Selection.setSelection(r6, r3);
        r6.replace(r2, r3, r7);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
