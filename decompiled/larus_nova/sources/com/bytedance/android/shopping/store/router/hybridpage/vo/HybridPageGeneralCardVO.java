package com.bytedance.android.shopping.store.router.hybridpage.vo;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.store.hybridproduct.extension.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class HybridPageGeneralCardVO extends o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f185977i = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f185978h;

    public static final class a {
        public a() {
        }

        public static HybridPageGeneralCardVO a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            HybridPageGeneralCardVO r102 = new HybridPageGeneralCardVO();
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
            return r102;
        L11:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 100;
    }

    static {
        f185977i = new a();
    }

    public HybridPageGeneralCardVO() {
        this.f185978h = LazyKt.lazy(new HybridPageGeneralCardVO$sliceRenderDataMap$2(this));
    }
}
