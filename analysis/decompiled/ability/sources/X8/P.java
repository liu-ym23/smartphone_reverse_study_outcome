package X8;

import i8.InterfaceC1561g;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public abstract class P {

    /* renamed from: a, reason: collision with root package name */
    public static final O f1526a = new O();

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public InterfaceC1561g c(InterfaceC1561g annotations) {
        kotlin.jvm.internal.k.f(annotations, "annotations");
        return annotations;
    }

    public abstract N d(w wVar);

    public boolean e() {
        return this instanceof O;
    }

    public w f(w topLevelType, Variance position) {
        kotlin.jvm.internal.k.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.k.f(position, "position");
        return topLevelType;
    }
}
