package t7;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s7.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u001a\u0010'\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010,¨\u0006."}, d2 = {"Lt7/b;", "", "", "Ls7/k;", "children", "<init>", "(Ljava/util/List;)V", "LY8/t;", "release", "()V", "", "name", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;F)V", "x", "y", "c", "(Ljava/lang/String;FF)V", "z", "e", "(Ljava/lang/String;FFF)V", "w", "f", "(Ljava/lang/String;FFFF)V", Const.JSON_KEY_SPEED, Const.INTENT_KEY_UMID, "(F)V", "", "fps", Const.INTENT_KEY_APIKEY, "(I)V", "Ljava/util/List;", "", Const.INTENT_KEY_PKGNAME, "J", "getId", "()J", "id", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "()Z", "isActive", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: t7.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5519b implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<k> children;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public C5519b(List<? extends k> children) {
        p.i(children, "children");
        this.children = children;
        this.id = System.nanoTime();
        this.name = F.A0(children, "+", null, null, 0, null, new InterfaceC5074l() { // from class: t7.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C5519b.i((k) obj);
            }
        }, 30, null);
    }

    public static final CharSequence i(k it) {
        p.i(it, "it");
        return it.getName();
    }

    @Override // s7.k
    public void a(int fps) {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(fps);
        }
    }

    @Override // s7.k
    public boolean b() {
        List<k> list = this.children;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((k) it.next()).b()) {
                return true;
            }
        }
        return false;
    }

    @Override // s7.k
    public void c(String name, float x10, float y10) {
        p.i(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).c(name, x10, y10);
        }
    }

    @Override // s7.k
    public void d(float speed) {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).d(speed);
        }
    }

    @Override // s7.k
    public void e(String name, float x10, float y10, float z10) {
        p.i(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).e(name, x10, y10, z10);
        }
    }

    @Override // s7.k
    public void f(String name, float x10, float y10, float z10, float w10) {
        p.i(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).f(name, x10, y10, z10, w10);
        }
    }

    @Override // s7.k
    public void g(String name, float value) {
        p.i(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).g(name, value);
        }
    }

    @Override // s7.k
    public long getId() {
        return this.id;
    }

    @Override // s7.k
    public String getName() {
        return this.name;
    }

    @Override // s7.k
    public void release() {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((k) it.next()).release();
        }
    }
}
