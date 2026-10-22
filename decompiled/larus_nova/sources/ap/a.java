package ap;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends T> f15822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f15823b;

    public abstract View a(Object r100);

    public a(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f15823b = new HashSet();
        this.f15822a = r100;
    }
}
