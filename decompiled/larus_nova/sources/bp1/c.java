package bp1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19950a = null;

    static {
        f19950a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Throwable) r100, "it");
        int r101 = a.f19927h;
        ALogger.e("ExtShareEnhancePanel", "ShopGuideID Error: use default data");
        return new i(0);
    }
}
