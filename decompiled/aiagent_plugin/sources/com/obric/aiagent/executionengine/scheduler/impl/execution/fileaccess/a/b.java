package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a;

import android.net.Uri;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PermissionCheckers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "PermissionCheckers";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f18415b = null;

    private b() {
    }

    static {
        f18414a = new b();
        f18415b = p.b(new a[]{new e(), new c()});
    }

    public final boolean a(d r8, String r9, Uri r10) {
        o.e(r8, "requester");
        o.e(r9, "sharerPackage");
        o.e(r10, "uri");
        boolean r0 = true;
        if (o.a(r8.a(), r9) == false) goto L6;
        ILogDepend.Companion.i(TAG, "checkPermission (same-package), requester: " + r8 + " --> " + r10);
        return true;
    L6:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(f18415b, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L9;
    L11:
        Iterator r11 = r7.iterator();
    L13:
        if (r11.hasNext() == false) goto L10;
        if (((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.aiagent.plugin")).a(r8, r9, r10) == false) goto L13;
    L16:
        ILogDepend.Companion.i(TAG, "checkPermission (" + r0 + "), requester: " + r8 + " --> " + r10 + " (sharer: " + r9 + ')');
        return r0;
    L10:
        r0 = false;
        goto L16
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        goto L10
    }
}
