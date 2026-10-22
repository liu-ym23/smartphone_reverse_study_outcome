package aa9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0042a f2357a = null;

    /* JADX INFO: renamed from: aa9.a$a, reason: collision with other inner class name */
    public static final class C0042a implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ C0042a f2358c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f2359b;

        static {
            f2358c = new C0042a();
        }

        public final PolarisFileWrapper b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "subPath");
            return this.f2359b.e(r100, r101);
        }

        public final PolarisFileWrapper c(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "subPath");
            return this.f2359b.f(r100, r101);
        }

        public final File a() {
            return this.f2359b.f2366b.getValue();
        }

        public C0042a() {
            this.f2359b = new h();
        }

        public final File d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "subPath");
            Intrinsics.checkNotNullParameter(r101, "name");
            h r102 = this.f2359b;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "subPath");
            Intrinsics.checkNotNullParameter(r101, "name");
            return new PolarisFileWrapper(r102.e(r100, true), r101);
        }
    }

    static {
        f2357a = C0042a.f2358c;
    }
}
