package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvServiceImpl f146087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f146088b;

    public o(MvServiceImpl r100, String r101) {
        this.f146087a = r100;
        this.f146088b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        MvServiceImpl r100 = this.f146087a;
        String r101 = this.f146088b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "dirPath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.isDirectory() == false) goto L24;
        File[] r103 = r102.listFiles();
        if (r103 == null) goto L31;
        List r104 = ArraysKt.toList(r103);
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.isEmpty() == false) goto L12;
        return;
    L12:
        if (r104.size() < 8) goto L34;
        List r105 = r104;
        List r106 = CollectionsKt.take(CollectionsKt.sortedWith(r105, new r()), 5);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r105.iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        Object r109 = r108.next();
        if ((!r106.contains((File) r109)) == false) goto L16;
        r107.add(r109);
        goto L16
    L20:
        Iterator r110 = r107.iterator();
    L22:
        if (r110.hasNext() == false) goto L35;
        ((File) r110.next()).delete();
        goto L22
    L35:
        return;
    L34:
        return;
    L31:
        return;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
