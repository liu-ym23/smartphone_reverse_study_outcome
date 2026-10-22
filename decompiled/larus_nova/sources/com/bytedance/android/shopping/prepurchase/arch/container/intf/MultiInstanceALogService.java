package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import android.util.Log;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MultiInstanceALogService implements xi.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f180781c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Biz f180783b;

    public static final class a {
        public static final n83.e a() {
            Lazy r100 = MultiInstanceALogService.f180781c;
            return (n83.e) MultiInstanceALogService.f180781c.getValue();
        }

        public a() {
        }
    }

    static {
        new a();
        f180781c = LazyKt.lazy(MultiInstanceALogService$Companion$alogInstance$2.INSTANCE);
    }

    public MultiInstanceALogService(Biz r100) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        this.f180783b = r100;
        this.f180782a = LazyKt.lazy(MultiInstanceALogService$enableDToI$2.INSTANCE);
    }

    @Override // xi.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (((Boolean) this.f180782a.getValue()).booleanValue() == false) goto L5;
        i(r100, r101);
        return;
    L5:
        n83.e r102 = a.a();
        if (r102 == null) goto L10;
        this.f180783b.getValue();
        r102.d();
        return;
    }

    @Override // xi.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        n83.e r102 = a.a();
        if (r102 == null) goto L6;
        this.f180783b.getValue();
        r102.i();
        return;
    }

    @Override // xi.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (r102 == null) goto L11;
        if (r101 != null) goto L8;
        n83.e r103 = a.a();
        if (r103 == null) goto L15;
        this.f180783b.getValue();
        Log.getStackTraceString(r102);
        r103.e();
        return;
    L15:
        return;
    L8:
        n83.e r104 = a.a();
        if (r104 == null) goto L17;
        this.f180783b.getValue();
        Log.getStackTraceString(r102);
        r104.e();
        return;
    L17:
        return;
    L11:
        n83.e r105 = a.a();
        if (r105 == null) goto L19;
        this.f180783b.getValue();
        r105.e();
        return;
    }
}
