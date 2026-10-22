package ch8;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f23808a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f23808a, ((a) r100).f23808a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f23808a.hashCode();
        }

        public final String toString() {
            return "ContentUri(uri=" + this.f23808a + ')';
        }

        public a(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f23808a = r100;
        }
    }

    /* JADX INFO: renamed from: ch8.b$b, reason: collision with other inner class name */
    public static final class C0447b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f23809a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0447b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f23809a, ((C0447b) r100).f23809a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f23809a.hashCode();
        }

        public final String toString() {
            return "FilePath(file=" + this.f23809a + ')';
        }

        public C0447b(PolarisFileWrapper r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            this.f23809a = r100;
        }
    }
}
