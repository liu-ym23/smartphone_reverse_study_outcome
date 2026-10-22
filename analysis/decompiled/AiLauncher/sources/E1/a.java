package E1;

import A1.e;
import A1.h;
import A1.o;
import E1.b;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LE1/a;", "LE1/b;", "LE1/c;", "target", "LA1/h;", "result", "<init>", "(LE1/c;LA1/h;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "LE1/c;", Const.INTENT_KEY_PKGNAME, "LA1/h;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final c target;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h result;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LE1/a$a;", "LE1/b$a;", "<init>", "()V", "LE1/c;", "target", "LA1/h;", "result", "LE1/b;", Const.INTENT_KEY_APIKEY, "(LE1/c;LA1/h;)LE1/b;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: E1.a$a, reason: collision with other inner class name */
    public static final class C0023a implements b.a {
        @Override // E1.b.a
        public b a(c target, h result) {
            return new a(target, result);
        }

        public boolean equals(Object other) {
            return other instanceof C0023a;
        }

        public int hashCode() {
            return C0023a.class.hashCode();
        }
    }

    public a(c cVar, h hVar) {
        this.target = cVar;
        this.result = hVar;
    }

    @Override // E1.b
    public void a() {
        h hVar = this.result;
        if (hVar instanceof o) {
            this.target.a(((o) hVar).getDrawable());
        } else {
            if (!(hVar instanceof e)) {
                throw new NoWhenBranchMatchedException();
            }
            this.target.d(((e) hVar).getDrawable());
        }
    }
}
