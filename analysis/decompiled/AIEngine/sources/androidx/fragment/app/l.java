package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlinx.coroutines.flow.MutableStateFlow;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements b.InterfaceC0161b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2164b;

    public /* synthetic */ l(Object obj, int i10) {
        this.f2163a = i10;
        this.f2164b = obj;
    }

    @Override // w1.b.InterfaceC0161b
    public final Bundle a() {
        Pair[] pairArr;
        int i10 = this.f2163a;
        Object obj = this.f2164b;
        switch (i10) {
            case 0:
                return ((o) obj).lambda$init$0();
            case 1:
                return ((FragmentManager) obj).U();
            default:
                p1.a aVar = (p1.a) obj;
                for (Map.Entry entry : kotlin.collections.b.n0(aVar.f11392d).entrySet()) {
                    aVar.a(((MutableStateFlow) entry.getValue()).getValue(), (String) entry.getKey());
                }
                for (Map.Entry entry2 : kotlin.collections.b.n0(aVar.f11390b).entrySet()) {
                    aVar.a(((b.InterfaceC0161b) entry2.getValue()).a(), (String) entry2.getKey());
                }
                LinkedHashMap linkedHashMap = aVar.f11389a;
                if (linkedHashMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        arrayList.add(new Pair((String) entry3.getKey(), entry3.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                return r0.b.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
    }
}
