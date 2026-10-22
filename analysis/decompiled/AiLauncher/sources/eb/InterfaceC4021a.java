package eb;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Leb/a;", "", "owner", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Z", "LY8/t;", "m", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "l", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: eb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4021a {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: eb.a$a, reason: collision with other inner class name */
    public static final class C0398a {
    }

    static /* synthetic */ boolean b(InterfaceC4021a interfaceC4021a, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return interfaceC4021a.g(obj);
    }

    static /* synthetic */ Object e(InterfaceC4021a interfaceC4021a, Object obj, InterfaceC4014c interfaceC4014c, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return interfaceC4021a.m(obj, interfaceC4014c);
    }

    static /* synthetic */ void i(InterfaceC4021a interfaceC4021a, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
        if ((i10 & 1) != 0) {
            obj = null;
        }
        interfaceC4021a.l(obj);
    }

    boolean g(Object owner);

    void l(Object owner);

    Object m(Object obj, InterfaceC4014c<? super t> interfaceC4014c);
}
