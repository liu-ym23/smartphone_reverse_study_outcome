package az0;

import cq2.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wy0.g;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f16786a;

    @Override // wy0.g
    public final Map<String, Object> getData() {
        return this.f16786a.getParams();
    }

    @Override // wy0.g
    public final String getName() {
        return this.f16786a.getEventName();
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "originalEvent");
        this.f16786a = r100;
    }
}
