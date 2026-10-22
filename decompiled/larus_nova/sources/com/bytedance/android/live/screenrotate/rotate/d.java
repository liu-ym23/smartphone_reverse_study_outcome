package com.bytedance.android.live.screenrotate.rotate;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.e;
import com.bytedance.android.live.room.api.screenrotation.rotate.f;
import com.bytedance.android.live.room.api.screenrotation.rotate.g;
import com.bytedance.common.wschannel.WsConstants;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PublishSubject<RotateInnerRequest<?>> f100582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PublishSubject f100583b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f100584c = null;

    public d() {
    }

    static {
        f100584c = new d();
        PublishSubject<RotateInnerRequest<?>> r100 = PublishSubject.create();
        f100582a = r100;
        f100583b = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.e
    public final PublishSubject a() {
        return f100583b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.e
    public final void b(f r100, Function1<? super g<Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "orientation");
        Intrinsics.checkNotNullParameter(r100, "orientation");
        g r102 = new g();
        if (r101 == null) goto L5;
        Unit r103 = r101.invoke(r102);
    L5:
        RotateInnerRequest<?> r104 = new RotateInnerRequest(String.valueOf(System.currentTimeMillis()), r100, r102);
        SimpleAlogArgsBuilder r105 = new SimpleAlogArgsBuilder();
        r105.d("ScreenRotation");
        r105.c("request rotate");
        int r106 = 0;
        Pair[] r107 = {TuplesKt.to("orientation", r104.f99134e), TuplesKt.to("rotateType", r104.f99147b), TuplesKt.to("source", r104.f99146a), TuplesKt.to(WsConstants.KEY_PAYLOAD, r104.f99148c)};
    L6:
        if (r106 >= 4) goto L13;
        Pair r108 = r107[r106];
        if (r108 == null) goto L12;
        Object r109 = r108.getSecond();
        if (r109 == null) goto L12;
        r105.a((String) r108.getFirst(), r109);
    L12:
        r106 = r106 + 1;
        goto L6
    L13:
        f81.a.a(r105.b());
        f100582a.onNext(r104);
    }
}
