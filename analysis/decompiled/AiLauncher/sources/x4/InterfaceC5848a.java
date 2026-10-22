package x4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lx4/a;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "Lx4/a$a;", "Lx4/a$b;", "Lx4/a$c;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: x4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5848a {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx4/a$a;", "Lx4/a;", "Lw4/e;", "row", "<init>", "(Lw4/e;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lw4/e;", Const.INTENT_KEY_APIKEY, "()Lw4/e;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x4.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Applied implements InterfaceC5848a {
        private final w4.e row;

        public Applied(w4.e row) {
            kotlin.jvm.internal.p.i(row, "row");
            this.row = row;
        }

        /* renamed from: a, reason: from getter */
        public final w4.e getRow() {
            return this.row;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Applied) && kotlin.jvm.internal.p.d(this.row, ((Applied) other).row);
        }

        public int hashCode() {
            return this.row.hashCode();
        }

        public String toString() {
            return "Applied(row=" + this.row + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lx4/a$b;", "Lx4/a;", "<init>", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x4.a$b */
    public static final class b implements InterfaceC5848a {
        public static final b INSTANCE = new b();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lx4/a$c;", "Lx4/a;", "<init>", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x4.a$c */
    public static final class c implements InterfaceC5848a {
        public static final c INSTANCE = new c();
    }
}
