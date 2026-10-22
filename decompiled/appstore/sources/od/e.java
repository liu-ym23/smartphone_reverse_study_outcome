package od;

import com.bytedanceos.common.tracker.TrackerElement;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f22576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f22577b;

        public a(int[] r10, float[] r11) {
            q.g(r10, "colors");
            q.g(r11, TrackerElement.POSITIONS);
            super(null);
            this.f22576a = r10;
            this.f22577b = r11;
        }

        public final int[] a() {
            return this.f22576a;
        }

        public final float[] b() {
            return this.f22577b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Arrays.equals(this.f22576a, r11.f22576a) == false) goto L14;
            if (Arrays.equals(this.f22577b, r11.f22577b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f22576a) * 31) + Arrays.hashCode(this.f22577b);
        }

        public String toString() {
            return "LinearGradient(colors=" + Arrays.toString(this.f22576a) + ", positions=" + Arrays.toString(this.f22577b) + ')';
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22578a = null;

        static {
            f22578a = new b();
        }

        public b() {
            super(null);
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker r10) {
        this();
    }

    public e() {
    }
}
