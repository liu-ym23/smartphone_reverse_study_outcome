package p1;

import androidx.fragment.app.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f11389a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11390b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f11391c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f11392d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final l f11393e = new l(this, 2);

    public a(Map<String, ? extends Object> map) {
        this.f11389a = b.o0(map);
    }

    public final void a(Object obj, String key) {
        g.f(key, "key");
        this.f11389a.put(key, obj);
        MutableStateFlow mutableStateFlow = (MutableStateFlow) this.f11391c.get(key);
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(obj);
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow) this.f11392d.get(key);
        if (mutableStateFlow2 != null) {
            mutableStateFlow2.setValue(obj);
        }
    }
}
