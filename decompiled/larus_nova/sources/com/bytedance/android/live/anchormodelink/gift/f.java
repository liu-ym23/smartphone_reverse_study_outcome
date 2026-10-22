package com.bytedance.android.live.anchormodelink.gift;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f58647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58648b;

    public f(e r100, String r101) {
        this.f58647a = r100;
        this.f58648b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        e r101 = this.f58647a;
        String r102 = this.f58648b;
        r101.getClass();
        String r103 = null;
        InputStreamReader r104 = null;
        r104 = null;
        r103 = null;
        if (new PolarisFileWrapper(r102).exists() == true) goto L58;
    L45:
        if (r103 != null) goto L47;
        r103 = "";
    L47:
        r100.onNext(r103);
        r100.onComplete();
        return;
    L58:
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L18 IOException -> L20
    L60:
        InputStreamReader r106 = new InputStreamReader(r105, "UTF-8");     // Catch: Throwable -> L14 IOException -> L16
        char[] r107 = new char[r105.available()];     // Catch: IOException -> L12 Throwable -> L34
        r106.read(r107);     // Catch: IOException -> L10 Throwable -> L34
        r106.close();     // Catch: IOException -> L10 Throwable -> L34
        r105.close();     // Catch: IOException -> L10 Throwable -> L34
        r106.close();     // Catch: IOException -> L26
    L29:
        r105.close();     // Catch: IOException -> L26
    L32:
        if (r107 == null) goto L45;
        r103 = new String(r107);
    L10:
        IOException e100 = e;
    L23:
        e100.printStackTrace();     // Catch: Throwable -> L34
        if (r106 == null) goto L28;
        r106.close();     // Catch: IOException -> L26
    L28:
        if (r105 == null) goto L32;
    L12:
        e = move-exception;
        e100 = e;
        r107 = null;
    L34:
        th = th;
        r104 = r106;
    L36:
        if (r104 != null) goto L56;
    L40:
        if (r105 == null) goto L44;
        r105.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L44:
        throw th;
    L56:
        r104.close();     // Catch: IOException -> L38
        goto L40
    L16:
        e = move-exception;
        e100 = e;
    L22:
        r106 = null;
        r107 = null;
    L14:
        th = th;
    L20:
        e = move-exception;
        e100 = e;
        r105 = null;
    L18:
        th = th;
        r105 = null;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }
}
