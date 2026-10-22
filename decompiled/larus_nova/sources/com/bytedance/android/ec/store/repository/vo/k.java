package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.core.utils.t0;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends com.bytedance.android.shopping.store.hybridproduct.extension.o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f48470i = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ej3.f f48471h;

    public static final class a {
        public a() {
        }

        public static k a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            k r102 = new k();
            Object r103 = null;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
            int r105 = t0.f45720a;     // Catch: Throwable -> L11
            Object r106 = t0.a.f45721a.fromJson(r101, Map.class);     // Catch: Throwable -> L11
            if ((r106 instanceof Map) == true) goto L6;
            r106 = null;
        L6:
            Map r107 = (Map) r106;     // Catch: Throwable -> L11
            if (r107 != null) goto L9;
            r107 = MapsKt.emptyMap();     // Catch: Throwable -> L11
        L9:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r108) == true) goto L17;
            r103 = r108;
        L17:
            Map<String, ? extends Object> r109 = (Map) r103;
            if (r109 != null) goto L20;
            r109 = MapsKt.emptyMap();
        L20:
            Intrinsics.checkNotNullParameter(r109, "<set-?>");
            r102.f185014a = r109;
            int r110 = t0.f45720a;     // Catch: Throwable -> L23
            dj3.g r111 = (dj3.g) t0.a.f45721a.fromJson(r101, dj3.g.class);     // Catch: Throwable -> L23
            ej3.f.f472858g.getClass();     // Catch: Throwable -> L23
            r102.f48471h = ej3.f.a.a(r111);     // Catch: Throwable -> L23
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        L25:
            return r102;
        L23:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L11:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 104;
    }

    static {
        f48470i = new a();
    }

    public k() {
    }
}
