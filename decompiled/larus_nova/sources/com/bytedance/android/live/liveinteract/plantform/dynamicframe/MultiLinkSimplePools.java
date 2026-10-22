package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/MultiLinkSimplePools;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/core/util/Pools$Pool;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkSimplePools<T> implements Pools.Pool<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<T> f76865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f76866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f76867c;

    public final int a() {
        return this.f76865a.size();
    }

    @Override // androidx.core.util.Pools.Pool
    public final T acquire() {
        if (this.f76865a.size() > 0) goto L7;
        return null;
    L7:
        return this.f76865a.removeFirst();
    }

    public MultiLinkSimplePools(int r100) {
        this.f76867c = r100;
        this.f76865a = new ArrayDeque();
        this.f76866b = "MultiLinkSimplePools";
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        new ArrayList(r100);
        return;
    L10:
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.core.util.Pools.Pool
    public final boolean release(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        int r101 = this.f76865a.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        if (this.f76865a.get(r102) == r100) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L14;
        int r104 = x8.a.f562881a;
        x8.a.b(this.f76866b, "Already in the pool!", false);
        return true;
    L14:
        if (this.f76865a.size() >= this.f76867c) goto L19;
        this.f76865a.addLast(r100);
        return true;
    L19:
        return false;
    L9:
        r103 = false;
        goto L10
    }
}
