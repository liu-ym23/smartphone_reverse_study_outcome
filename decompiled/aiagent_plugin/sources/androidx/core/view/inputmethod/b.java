package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.util.d;
import androidx.core.util.g;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: InputConnectionCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: InputConnectionCompat.java */
    public interface a {
        boolean onCommitContent(c r1, int r2, Bundle r3);
    }

    public static /* synthetic */ boolean lambda$cNQoTRopG134YFSfyvriwuz7V6c(View r0, c r1, int r2, Bundle r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    static boolean a(String r8, Bundle r9, a r10) {
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.aiagent.plugin");
        ?? r0 = 0;
        r0 = 0;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", r8) == false) goto L9;
        boolean r12 = false;
    L12:
        if (r12 == false) goto L14;
        String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    L50:
        ResultReceiver r4 = (ResultReceiver) ZeusTransformUtils.preCheckCast(r9.getParcelable(r3), ResultReceiver.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r12 == false) goto L18;
        String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    L52:
        Uri r6 = (Uri) ZeusTransformUtils.preCheckCast(r9.getParcelable(r5), Uri.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L22;
        String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    L23:
        ClipDescription r13 = (ClipDescription) ZeusTransformUtils.preCheckCast(r9.getParcelable(r7), ClipDescription.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L26;
        String r14 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    L27:
        Uri r15 = (Uri) ZeusTransformUtils.preCheckCast(r9.getParcelable(r14), Uri.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L30;
        String r16 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    L31:
        int r17 = r9.getInt(r16);     // Catch: Throwable -> L42
        if (r12 == false) goto L34;
        String r18 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    L35:
        Bundle r19 = (Bundle) ZeusTransformUtils.preCheckCast(r9.getParcelable(r18), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r6 == null) goto L39;
        if (r13 == null) goto L39;
        r0 = r11.onCommitContent(new c(r6, r13, r15), r17, r19);     // Catch: Throwable -> L42
    L39:
        if (r4 == 0) goto L41;
        r4.send(r0, null);
    L41:
        return r0;
    L34:
        r18 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        goto L35
    L30:
        r16 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        goto L31
    L26:
        r14 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        goto L27
    L22:
        r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    L42:
        th = th;
    L46:
        if (r4 == 0) goto L48;
        r4.send(0, null);
    L48:
        throw th;
    L18:
        r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    L44:
        th = th;
        r4 = 0;
        goto L46
    L14:
        r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        goto L50
    L9:
        if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", r8) == false) goto L49;
        r12 = true;
        goto L12
    L49:
        return false;
    }

    @Deprecated
    public static InputConnection a(InputConnection r3, EditorInfo r4, a r5) {
        final InputConnection r6 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin");
        final a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        d.a(r6, "inputConnection must be non-null");
        d.a(r4, "editorInfo must be non-null");
        d.a(r7, "onCommitContentListener must be non-null");
        final boolean r1 = false;
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return new InputConnectionCompat$1(r6, r1, r7);
    L7:
        if (androidx.core.view.inputmethod.a.a(r4).length != 0) goto L10;
        return r6;
    L10:
        return new InputConnectionCompat$2(r6, r1, r7);
    }

    public static InputConnection a(View r2, InputConnection r3, EditorInfo r4) {
        return a((InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin"), r4, a(r2));
    }

    private static a a(final View r1) {
        g.a(r1);
        return new $$Lambda$b$cNQoTRopG134YFSfyvriwuz7V6c(r1);
    }

    private static /* synthetic */ boolean a(View r5, c r6, int r7, Bundle r8) {
        if (Build.VERSION.SDK_INT < 25) goto L16;
        if ((r7 & 1) == 0) goto L16;
        r6.e();     // Catch: Exception -> L12
        Parcelable r9 = (Parcelable) ZeusTransformUtils.preCheckCast(r6.d(), Parcelable.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L10;
        r8 = new Bundle();
    L11:
        r8.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", r9);
        goto L16
    L10:
        r8 = new Bundle(r8);
    L12:
        e = move-exception;
        a("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L16:
        if (ViewCompat.a(r5, new androidx.core.view.b.a(new ClipData(r6.b(), new ClipData.Item(r6.a())), 2).a(r6.c()).a(r8).a()) == null) goto L18;
        return false;
    L18:
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
