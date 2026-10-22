package com.bytedance.android.livesdk.gecko.offline;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f125829a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "iOfflineController");
        this.f125829a = r100;
    }

    public final File a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ArrayList r101 = new ArrayList();
        r101.addAll(this.f125829a);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        PolarisFileWrapper r103 = ((d) r102.next()).a(r100);
        if (r103 == null) goto L4;
        if (r103.exists() == false) goto L4;
        return r103;
    L10:
        return null;
    }
}
