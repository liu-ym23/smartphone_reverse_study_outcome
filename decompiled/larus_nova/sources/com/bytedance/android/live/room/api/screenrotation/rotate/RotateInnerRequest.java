package com.bytedance.android.live.room.api.screenrotation.rotate;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RotateInnerRequest<T> extends h<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f99132g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f99133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f99134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g<T> f99135f;

    public static final class a {
        public a() {
        }
    }

    static {
        f99132g = new a();
    }

    public final HorizontalPlayEvent b() {
        f99132g.getClass();
        Intrinsics.checkNotNullParameter(this, "innerRequest");
        g<T> r100 = this.f99135f;
        f r101 = this.f99134e;
        int r102 = 1;
        if (Intrinsics.areEqual(r101, f.b.f99141a) == false) goto L6;
        int r103 = 1;
    L8:
        HorizontalPlayEvent r104 = new HorizontalPlayEvent(r103);
        i r105 = r100.f99143b;
        if (Intrinsics.areEqual(r105, i.a.f99149a) == false) goto L12;
    L20:
        r104.rotationType = r102;
        r104.source = r100.f99142a;
        r104.extra = r100.f99144c;
        r104.rotateInnerReq = this;
        return r104;
    L12:
        if (Intrinsics.areEqual(r105, i.c.f99151a) == false) goto L15;
        r102 = 3;
        goto L20
    L15:
        if (Intrinsics.areEqual(r105, i.d.f99152a) == false) goto L18;
        r102 = 2;
        goto L20
    L18:
        if (Intrinsics.areEqual(r105, i.b.f99150a) == false) goto L23;
        r102 = 0;
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        if (Intrinsics.areEqual(r101, f.a.f99140a) == false) goto L25;
        r103 = 2;
        goto L8
    L25:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RotateInnerRequest a(HorizontalPlayEvent r100) {
        f99132g.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.rotateInnerReq;
        if ((r101 instanceof RotateInnerRequest) == true) goto L5;
        r101 = null;
    L5:
        RotateInnerRequest r102 = (RotateInnerRequest) r101;
        if (r102 != null) goto L27;
        int r103 = r100.what;
        if (r103 == 1) goto L13;
        if (r103 == 2) goto L12;
        f r104 = f.b.f99141a;
    L14:
        int r105 = r100.rotationType;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L23;
        if (r105 != 2) goto L19;
        i r106 = i.d.f99152a;
    L25:
        String r107 = String.valueOf(System.currentTimeMillis());
        g r108 = new g();
        String r109 = r100.source;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f99142a = r109;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r108.f99143b = r106;
        r108.f99144c = (T) r100.extra;
        Unit r110 = Unit.INSTANCE;
        return new RotateInnerRequest(r107, r104, r108);
    L19:
        if (r105 == 3) goto L21;
        r106 = i.b.f99150a;
        goto L25
    L21:
        r106 = i.c.f99151a;
        goto L25
    L23:
        r106 = i.a.f99149a;
        goto L25
    L24:
        r106 = i.b.f99150a;
        goto L25
    L12:
        r104 = f.a.f99140a;
        goto L14
    L13:
        r104 = f.b.f99141a;
        goto L14
    L27:
        return r102;
    }

    public RotateInnerRequest(String r100, f r101, g<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "orientation");
        Intrinsics.checkNotNullParameter(r102, "builder");
        super(r101, r102.f99142a, r102.f99143b, r102.f99144c);
        this.f99134e = r101;
        this.f99135f = r102;
        this.f99133d = LazyKt.lazy(new RotateInnerRequest$curRotateHandler$2(this));
    }
}
