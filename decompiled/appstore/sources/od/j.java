package od;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22588a = null;

        static {
            f22588a = new a();
        }

        public a() {
            super(null);
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Direction f22589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Direction f22590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f22592d;

        public b(Direction r10, Direction r11, float r12, float r13) {
            q.g(r10, "direction");
            q.g(r11, "gradientAlphaDirection");
            super(null);
            this.f22589a = r10;
            this.f22590b = r11;
            this.f22591c = r12;
            this.f22592d = r13;
        }

        public final Direction a() {
            return this.f22589a;
        }

        public final float b() {
            return this.f22591c;
        }

        public final Direction c() {
            return this.f22590b;
        }

        public final float d() {
            return this.f22592d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f22589a == r11.f22589a) goto L12;
            return false;
        L12:
            if (this.f22590b == r11.f22590b) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f22591c), Float.valueOf(r11.f22591c)) == true) goto L18;
            return false;
        L18:
            if (q.b(Float.valueOf(this.f22592d), Float.valueOf(r11.f22592d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f22589a.hashCode() * 31) + this.f22590b.hashCode()) * 31) + Float.hashCode(this.f22591c)) * 31) + Float.hashCode(this.f22592d);
        }

        public String toString() {
            return "ScanWindow(direction=" + this.f22589a + ", gradientAlphaDirection=" + this.f22590b + ", featherRatio=" + this.f22591c + ", minFeatherDp=" + this.f22592d + ')';
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker r10) {
        this();
    }

    public j() {
    }
}
