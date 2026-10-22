package h1;

import Y8.j;
import Y8.t;
import android.os.Bundle;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import g1.C4091b;
import g1.e;
import g1.h;
import g1.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00052\u000e\u0010\u0017\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u00052\n\u0010\u001a\u001a\u00060\u000bj\u0002`\fH\u0001¢\u0006\u0004\b\u001b\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010,R$\u00100\u001a\u00020(2\u0006\u0010.\u001a\u00020(8G@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\"\u00104\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010*\u001a\u0004\b)\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lh1/b;", "", "Lg1/h;", "owner", "Lkotlin/Function0;", "LY8/t;", "onAttach", "<init>", "(Lg1/h;Lp9/a;)V", "", "key", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "c", "(Ljava/lang/String;)Landroid/os/Bundle;", "Lg1/e$b;", Const.JSON_KEY_PROVIDER, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Lg1/e$b;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lg1/e$b;", "f", "()V", "savedState", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/os/Bundle;)V", "outBundle", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Lg1/h;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", "getOnAttach$savedstate_release", "()Lp9/a;", "Lh1/c;", "Lh1/c;", "lock", "", "Ljava/util/Map;", "keyToProviders", "", "e", "Z", "attached", "Landroid/os/Bundle;", "restoredState", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "isRestored", "()Z", "setAllowingSavingState$savedstate_release", "(Z)V", "isAllowingSavingState", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: h1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4122b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h owner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<t> onAttach;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C4123c lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<String, e.b> keyToProviders;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean attached;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Bundle restoredState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isRestored;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean isAllowingSavingState;

    public C4122b(h owner, InterfaceC5063a<t> onAttach) {
        p.i(owner, "owner");
        p.i(onAttach, "onAttach");
        this.owner = owner;
        this.onAttach = onAttach;
        this.lock = new C4123c();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    public static final void g(C4122b c4122b, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        p.i(lifecycleOwner, "<unused var>");
        p.i(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            c4122b.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            c4122b.isAllowingSavingState = false;
        }
    }

    public final Bundle c(String key) {
        p.i(key, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleA = C4091b.a(bundle);
        Bundle bundleC = C4091b.b(bundleA, key) ? C4091b.c(bundleA, key) : null;
        i.e(i.a(bundle), key);
        if (C4091b.f(C4091b.a(bundle))) {
            this.restoredState = null;
        }
        return bundleC;
    }

    public final e.b d(String key) {
        e.b bVar;
        p.i(key, "key");
        synchronized (this.lock) {
            Iterator it = this.keyToProviders.entrySet().iterator();
            do {
                bVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                e.b bVar2 = (e.b) entry.getValue();
                if (p.d(str, key)) {
                    bVar = bVar2;
                }
            } while (bVar == null);
        }
        return bVar;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsAllowingSavingState() {
        return this.isAllowingSavingState;
    }

    public final void f() {
        if (this.owner.getLifecycle().getState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.onAttach.invoke();
        this.owner.getLifecycle().a(new InterfaceC1395m() { // from class: h1.a
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                C4122b.g(this.f32883a, lifecycleOwner, event);
            }
        });
        this.attached = true;
    }

    public final void h(Bundle savedState) {
        if (!this.attached) {
            f();
        }
        if (this.owner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getState()).toString());
        }
        if (this.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleC = null;
        if (savedState != null) {
            Bundle bundleA = C4091b.a(savedState);
            if (C4091b.b(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                bundleC = C4091b.c(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
        }
        this.restoredState = bundleC;
        this.isRestored = true;
    }

    public final void i(Bundle outBundle) {
        Pair[] pairArr;
        p.i(outBundle, "outBundle");
        Map mapI = kotlin.collections.a.i();
        if (mapI.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapI.size());
            for (Map.Entry entry : mapI.entrySet()) {
                arrayList.add(j.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleA = x0.c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA2 = i.a(bundleA);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            i.b(bundleA2, bundle);
        }
        synchronized (this.lock) {
            try {
                for (Map.Entry entry2 : this.keyToProviders.entrySet()) {
                    i.c(bundleA2, (String) entry2.getKey(), ((e.b) entry2.getValue()).a());
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (C4091b.f(C4091b.a(bundleA))) {
            return;
        }
        i.c(i.a(outBundle), "androidx.lifecycle.BundlableSavedStateRegistry.key", bundleA);
    }

    public final void j(String key, e.b provider) {
        p.i(key, "key");
        p.i(provider, "provider");
        synchronized (this.lock) {
            if (this.keyToProviders.containsKey(key)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.keyToProviders.put(key, provider);
            t tVar = t.f7040a;
        }
    }
}
