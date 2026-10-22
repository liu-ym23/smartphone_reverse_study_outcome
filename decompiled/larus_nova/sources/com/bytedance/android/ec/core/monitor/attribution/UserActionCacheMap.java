package com.bytedance.android.ec.core.monitor.attribution;

import androidx.collection.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lg.d;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/attribution/UserActionCacheMap;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/LruCache;", "Llg/d;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserActionCacheMap<T> extends LruCache<T, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f45139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45140b;

    public final Set<T> a() {
        LinkedHashSet r100 = new LinkedHashSet();
        r100.addAll(snapshot().keySet());
        r100.addAll(this.f45139a);
        return r100;
    }

    public UserActionCacheMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        super(10);
        this.f45140b = r100;
        this.f45139a = new LinkedHashSet();
    }

    @Override // androidx.collection.LruCache
    public final d create(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = t0.f45720a;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((d) t0.a.f45721a.fromJson(q.f48131a.getString(this.f45140b + '_' + r100, SliceInitService.DEFAULT_SWITCH), d.class));     // Catch: Throwable -> L5
    L7:
        Object r104 = super.create(r100);
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = r104;
    L11:
        return (d) r103;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // androidx.collection.LruCache
    public final int sizeOf(Object r100, d r101) {
        d r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        return super.sizeOf(r100, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.LruCache
    public final void entryRemoved(boolean r100, Object r101, d r102, d r103) {
        d r104 = r102;
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r104, "oldValue");
        super.entryRemoved(r100, r101, r104, r103);
        if (r100 == false) goto L6;
        a().add(r101);
        q r105 = q.f48131a;
        String r106 = this.f45140b + '_' + r101;
        int r107 = t0.f45720a;
        r105.putString(r106, GsonProtectorUtils.toJson(t0.a.f45721a, r104));
        return;
    }
}
