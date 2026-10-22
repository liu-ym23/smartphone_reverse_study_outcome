package androidx.lifecycle;

import j0.C0631f;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0317n implements E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3970a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3971b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3972c;

    public C0317n(InterfaceC0315l defaultLifecycleObserver, E e4) {
        Intrinsics.checkNotNullParameter(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f3971b = defaultLifecycleObserver;
        this.f3972c = e4;
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i4 = this.f3970a;
        Object obj = this.f3971b;
        Object obj2 = this.f3972c;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                switch (AbstractC0316m.$EnumSwitchMapping$0[event.ordinal()]) {
                    case 1:
                        ((InterfaceC0315l) obj).onCreate(source);
                        break;
                    case 2:
                        ((InterfaceC0315l) obj).onStart(source);
                        break;
                    case 3:
                        ((InterfaceC0315l) obj).onResume(source);
                        break;
                    case 4:
                        ((InterfaceC0315l) obj).onPause(source);
                        break;
                    case 5:
                        ((InterfaceC0315l) obj).onStop(source);
                        break;
                    case 6:
                        ((InterfaceC0315l) obj).onDestroy(source);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                E e4 = (E) obj2;
                if (e4 != null) {
                    e4.a(source, event);
                    return;
                }
                return;
            case 1:
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == EnumC0326x.ON_START) {
                    ((AbstractC0328z) obj).b(this);
                    ((C0631f) obj2).d();
                    return;
                }
                return;
            default:
                HashMap map = ((C0308e) obj2).f3928a;
                C0308e.a((List) map.get(event), source, event, obj);
                C0308e.a((List) map.get(EnumC0326x.ON_ANY), source, event, obj);
                return;
        }
    }

    public C0317n(Object obj) {
        this.f3971b = obj;
        this.f3972c = C0310g.f3941c.b(obj.getClass());
    }

    public C0317n(AbstractC0328z abstractC0328z, C0631f c0631f) {
        this.f3971b = abstractC0328z;
        this.f3972c = c0631f;
    }
}
