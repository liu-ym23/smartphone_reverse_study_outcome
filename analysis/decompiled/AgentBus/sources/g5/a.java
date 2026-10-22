package g5;

import c6.d;
import ia.g1;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import o4.f2;
import p7.k;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3846a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f3847b;

    public /* synthetic */ a(k kVar, int i2) {
        this.f3846a = i2;
        this.f3847b = kVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i2 = this.f3846a;
        k kVar = this.f3847b;
        switch (i2) {
            case 0:
                return (Set) ((d) kVar).invoke(obj);
            case 1:
                return (Set) ((d) kVar).invoke(obj);
            case 2:
                return (Set) ((d) kVar).invoke(obj);
            case 3:
                return (AtomicLong) ((d) kVar).invoke(obj);
            case 4:
                return (AtomicLong) ((d) kVar).invoke(obj);
            case 5:
                return (m5.k) ((d) kVar).invoke(obj);
            case 6:
                return (ConcurrentHashMap) ((o4.b) kVar).invoke(obj);
            case 7:
                return (LinkedHashMap) ((o4.b) kVar).invoke(obj);
            case 8:
                return (LinkedHashMap) ((o4.b) kVar).invoke(obj);
            case 9:
                return (LinkedHashMap) ((o4.b) kVar).invoke(obj);
            case 10:
                return (g1) ((f2) kVar).invoke(obj);
            default:
                return (Set) ((o4.b) kVar).invoke(obj);
        }
    }
}
