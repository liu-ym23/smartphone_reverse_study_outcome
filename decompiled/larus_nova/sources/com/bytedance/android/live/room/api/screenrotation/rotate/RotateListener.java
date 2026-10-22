package com.bytedance.android.live.room.api.screenrotation.rotate;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RotateListener<T> implements b<T>, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super d, ? super h<T>, Boolean> f99136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super d, ? super h<T>, Unit> f99137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super d, ? super h<T>, Unit> f99138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super d, ? super h<T>, Unit> f99139d;

    public RotateListener() {
        this.f99136a = RotateListener$onIsForceRotate$1.INSTANCE;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void b(Function2<? super d, ? super h<T>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "rotateCallback");
        this.f99138c = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void d(Function2<? super d, ? super h<T>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "rotateCallback");
        this.f99139d = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void e(Function2<? super d, ? super h<T>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "rotateCallback");
        this.f99136a = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void f(Function2<? super d, ? super h<T>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "rotateCallback");
        this.f99137b = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void a(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        Function2<? super d, ? super h<T>, Unit> r102 = this.f99138c;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void c(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        Function2<? super d, ? super h<T>, Unit> r102 = this.f99137b;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final boolean g(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        Function2<? super d, ? super h<T>, Boolean> r102 = this.f99136a;
        if (r102 == null) goto L5;
        Boolean r103 = r102.invoke(r100, r101);
    L7:
        return r103.booleanValue();
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void h(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        Function2<? super d, ? super h<T>, Unit> r102 = this.f99139d;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r100, r101);
        return;
    }
}
