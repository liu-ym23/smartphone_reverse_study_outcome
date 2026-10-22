package N9;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public KmEffectType f4944a;

    /* renamed from: b, reason: collision with root package name */
    public KmEffectInvocationKind f4945b;

    /* renamed from: c, reason: collision with root package name */
    public final List<k> f4946c;

    /* renamed from: d, reason: collision with root package name */
    public k f4947d;

    public j(KmEffectType type, KmEffectInvocationKind kmEffectInvocationKind) {
        kotlin.jvm.internal.p.i(type, "type");
        this.f4944a = type;
        this.f4945b = kmEffectInvocationKind;
        this.f4946c = new ArrayList(1);
    }

    public final List<k> a() {
        return this.f4946c;
    }

    public final void b(k kVar) {
        this.f4947d = kVar;
    }
}
