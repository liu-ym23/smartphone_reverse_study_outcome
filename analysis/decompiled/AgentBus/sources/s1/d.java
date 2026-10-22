package s1;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9234a;

    public /* synthetic */ d(int i2) {
        this.f9234a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9234a) {
        }
        return ib.k.q(Integer.valueOf(((c) obj).f9230b), Integer.valueOf(((c) obj2).f9230b));
    }
}
