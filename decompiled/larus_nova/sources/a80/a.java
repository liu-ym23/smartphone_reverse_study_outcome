package a80;

import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.e;
import j70.f;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T extends h70.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f2138a;

    public boolean d(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return true;
    }

    public abstract ElementConstraint m(T r100);

    public abstract f o(T r100);

    public abstract e p();

    public a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
    }

    public final ElementConstraint l(Function1<? super ElementConstraint, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        ElementConstraint r101 = new ElementConstraint(0.0f, 3);
        r100.invoke(r101);
        return r101;
    }
}
