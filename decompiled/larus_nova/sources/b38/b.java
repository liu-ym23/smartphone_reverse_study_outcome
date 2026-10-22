package b38;

import com.larksuite.rucket.core.RucketImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17382a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f17383c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RucketImpl f17384b;

        static {
            f17383c = new a();
        }

        @Override // b38.b
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f17384b.create(r100);
        }

        public a() {
            this.f17384b = new RucketImpl();
        }
    }

    static {
        f17382a = a.f17383c;
    }

    <T> T create(Class<T> r100);
}
