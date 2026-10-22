package g0;

import com.autonavi.aps.amapapi.config.Const;
import h0.C4120c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\nR\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014¨\u0006\u0017"}, d2 = {"Lg0/a;", "", "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "()V", "(Ljava/lang/Object;)V", "newNext", "e", "(Ljava/lang/Object;)Lg0/a;", "newPrevious", "f", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", Const.INTENT_KEY_UMID, "()Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "c", "", "()Z", "hasNext", "hasPrevious", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4087a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object previous;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object next;

    public C4087a(Object obj, Object obj2) {
        this.previous = obj;
        this.next = obj2;
    }

    public final boolean a() {
        return this.next != C4120c.f32881a;
    }

    public final boolean b() {
        return this.previous != C4120c.f32881a;
    }

    /* renamed from: c, reason: from getter */
    public final Object getNext() {
        return this.next;
    }

    /* renamed from: d, reason: from getter */
    public final Object getPrevious() {
        return this.previous;
    }

    public final C4087a e(Object newNext) {
        return new C4087a(this.previous, newNext);
    }

    public final C4087a f(Object newPrevious) {
        return new C4087a(newPrevious, this.next);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C4087a() {
        C4120c c4120c = C4120c.f32881a;
        this(c4120c, c4120c);
    }

    public C4087a(Object obj) {
        this(obj, C4120c.f32881a);
    }
}
