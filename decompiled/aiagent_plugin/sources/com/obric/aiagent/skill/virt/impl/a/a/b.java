package com.obric.aiagent.skill.virt.impl.a.a;

import android.os.ParcelFileDescriptor;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CtrdBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ Integer a(int r0) {
        return b(r0);
    }

    public static final /* synthetic */ String a(Throwable r0) {
        return b(r0);
    }

    public static final /* synthetic */ void a(ParcelFileDescriptor r0) {
        b(r0);
    }

    public static final /* synthetic */ boolean a(String r0) {
        return e(r0);
    }

    public static final /* synthetic */ String b(String r0) {
        return f(r0);
    }

    public static final /* synthetic */ String c(String r0) {
        return d(r0);
    }

    private static final String d(String r8) {
        return '\'' + o.a(r8, "'", "'\\''", false, 4, null) + '\'';
    }

    private static final boolean e(String r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L12;
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin"), DownloadConstants.VULNERABILITY_PATH) == false) goto L9;
        return true;
    L12:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private static final String f(String r6) {
        return o.e(o.a(r6, '\n', ' ', false, 4, null), 512);
    }

    private static final void b(ParcelFileDescriptor r1) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.close();     // Catch: Throwable -> L8
        x r2 = x.f38692a;     // Catch: Throwable -> L8
    L6:
        n.f(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        n.a r3 = n.f38560a;
        n.f(d.o.a(th));
    }

    private static final String b(Throwable r2) {
        StringBuilder r0 = new StringBuilder().append(r2.getClass().getSimpleName()).append(": ");
        String r3 = r2.getMessage();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        return o.e(r0.append(r3).toString(), 512);
    }

    private static final Integer b(int r2) {
        boolean r0 = false;
        if (129 <= r2) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf(r2 - 128);
    L5:
        if (r2 >= 256) goto L7;
        r0 = true;
        goto L7
    }
}
