package android.view;

import Y8.h;
import Y8.j;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import g1.C4091b;
import g1.e;
import g1.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import x0.c;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/lifecycle/K;", "Lg1/e$b;", "Lg1/e;", "savedStateRegistry", "Landroidx/lifecycle/W;", "viewModelStoreOwner", "<init>", "(Lg1/e;Landroidx/lifecycle/W;)V", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", Const.INTENT_KEY_APIKEY, "()Landroid/os/Bundle;", "LY8/t;", "e", "()V", "", "key", "c", "(Ljava/lang/String;)Landroid/os/Bundle;", "Lg1/e;", "", Const.INTENT_KEY_PKGNAME, "Z", "restored", "Landroid/os/Bundle;", "restoredState", "Landroidx/lifecycle/L;", Const.INTENT_KEY_UMID, "LY8/h;", "()Landroidx/lifecycle/L;", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class K implements e.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e savedStateRegistry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean restored;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Bundle restoredState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h viewModel;

    public K(e savedStateRegistry, final W viewModelStoreOwner) {
        p.i(savedStateRegistry, "savedStateRegistry");
        p.i(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel = C4848b.b(new InterfaceC5063a() { // from class: androidx.lifecycle.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return K.f(viewModelStoreOwner);
            }
        });
    }

    public static final L f(W w10) {
        return I.e(w10);
    }

    @Override // g1.e.b
    public Bundle a() {
        Pair[] pairArr;
        Map mapI = a.i();
        if (mapI.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapI.size());
            for (Map.Entry entry : mapI.entrySet()) {
                arrayList.add(j.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleA = c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA2 = i.a(bundleA);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            i.b(bundleA2, bundle);
        }
        for (Map.Entry<String, F> entry2 : d().e().entrySet()) {
            String key = entry2.getKey();
            Bundle bundleA3 = entry2.getValue().a().a();
            if (!C4091b.f(C4091b.a(bundleA3))) {
                i.c(bundleA2, key, bundleA3);
            }
        }
        this.restored = false;
        return bundleA;
    }

    public final Bundle c(String key) {
        Pair[] pairArr;
        p.i(key, "key");
        e();
        Bundle bundle = this.restoredState;
        if (bundle == null || !C4091b.b(C4091b.a(bundle), key)) {
            return null;
        }
        Bundle bundleD = C4091b.d(C4091b.a(bundle), key);
        if (bundleD == null) {
            Map mapI = a.i();
            if (mapI.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapI.size());
                for (Map.Entry entry : mapI.entrySet()) {
                    arrayList.add(j.a((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            bundleD = c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            i.a(bundleD);
        }
        i.e(i.a(bundle), key);
        if (C4091b.f(C4091b.a(bundle))) {
            this.restoredState = null;
        }
        return bundleD;
    }

    public final L d() {
        return (L) this.viewModel.getValue();
    }

    public final void e() {
        Pair[] pairArr;
        if (this.restored) {
            return;
        }
        Bundle bundleA = this.savedStateRegistry.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Map mapI = a.i();
        if (mapI.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapI.size());
            for (Map.Entry entry : mapI.entrySet()) {
                arrayList.add(j.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleA2 = c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA3 = i.a(bundleA2);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            i.b(bundleA3, bundle);
        }
        if (bundleA != null) {
            i.b(bundleA3, bundleA);
        }
        this.restoredState = bundleA2;
        this.restored = true;
        d();
    }
}
