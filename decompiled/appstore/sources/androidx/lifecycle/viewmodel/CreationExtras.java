package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class CreationExtras {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3576a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", "", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Key<T> {
    }

    public static final class a extends CreationExtras {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3577b = null;

        static {
            f3577b = new a();
        }

        public a() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        public Object a(Key r10) {
            q.g(r10, "key");
            return null;
        }
    }

    public CreationExtras() {
        this.f3576a = new LinkedHashMap();
    }

    public abstract Object a(Key r10);

    public final Map b() {
        return this.f3576a;
    }
}
