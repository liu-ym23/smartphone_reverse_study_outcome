package com.obric.cloudsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.obric.cloudsdk.kv.base.KvLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CommonUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/cloudsdk/CommonUtil;", "", "()V", "TAG", "", "readAssertFileContent", "context", "Landroid/content/Context;", "fileName", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonUtil {
    public static final CommonUtil INSTANCE = null;
    private static final String TAG = "CommonUtil";

    static {
        INSTANCE = new CommonUtil();
    }

    private CommonUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.String] */
    public final String readAssertFileContent(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "fileName");
        String r0 = null;
        KvLog.INSTANCE.i(TAG, "readAssertFileContent, start");     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
        InputStream r8 = r6.createPackageContext(r6.getPackageName(), 3).getAssets().open(r7);     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
        Intrinsics.checkNotNullExpressionValue(r8, "pkgContext.assets.open(fileName)");     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r8, "UTF-8"));     // Catch: Throwable -> L14 IOException -> L16
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L14 IOException -> L16
        Ref.ObjectRef r2 = new Ref.ObjectRef();     // Catch: Throwable -> L14 IOException -> L16
    L5:
        ?? r3 = r1.readLine();     // Catch: Throwable -> L14 IOException -> L16
        r2.element = r3;     // Catch: Throwable -> L14 IOException -> L16
        if (r3 == 0) goto L8;
        r9.append((String) r2.element).append("\n");     // Catch: Throwable -> L14 IOException -> L16
        goto L5
    L8:
        r0 = r9.toString();     // Catch: Throwable -> L14 IOException -> L16
        KvLog.INSTANCE.i(TAG, "readAssertFileContent: " + r0);     // Catch: Throwable -> L14 IOException -> L16
        r8.close();     // Catch: IOException -> L11 PackageManager.NameNotFoundException -> L30
    L13:
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
        goto L13
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        r8.close();     // Catch: IOException -> L20 PackageManager.NameNotFoundException -> L30
    L32:
        return r0;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
    L14:
        th = move-exception;
        r8.close();     // Catch: IOException -> L25 PackageManager.NameNotFoundException -> L30
    L27:
        throw th;     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L28 PackageManager.NameNotFoundException -> L30
    L28:
        e = move-exception;
        KvLog.INSTANCE.i(TAG, "readAssertFileContent, IOException: " + e);
    L30:
        e = move-exception;
        KvLog.INSTANCE.i(TAG, "readAssertFileContent, PackageManager.NameNotFoundException: " + e);
        goto L32
    }
}
