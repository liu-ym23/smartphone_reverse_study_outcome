package android.view;

import V0.CreationExtras;
import android.os.Bundle;
import android.view.Lifecycle;
import android.view.U;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import g1.e;
import g1.h;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\r*\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014\"\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014\"\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014\"\u0018\u0010\u001b\u001a\u00020\u0018*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0018\u0010\u001f\u001a\u00020\u001c*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lg1/h;", "Landroidx/lifecycle/W;", ExifInterface.GPS_DIRECTION_TRUE, "LY8/t;", "c", "(Lg1/h;)V", "savedStateRegistryOwner", "viewModelStoreOwner", "", "key", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultArgs", "Landroidx/lifecycle/F;", Const.INTENT_KEY_PKGNAME, "(Lg1/h;Landroidx/lifecycle/W;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/F;", "LV0/a;", Const.INTENT_KEY_APIKEY, "(LV0/a;)Landroidx/lifecycle/F;", "LV0/a$c;", "LV0/a$c;", "SAVED_STATE_REGISTRY_OWNER_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "DEFAULT_ARGS_KEY", "Landroidx/lifecycle/L;", "e", "(Landroidx/lifecycle/W;)Landroidx/lifecycle/L;", "savedStateHandlesVM", "Landroidx/lifecycle/K;", Const.INTENT_KEY_UMID, "(Lg1/h;)Landroidx/lifecycle/K;", "savedStateHandlesProvider", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static final CreationExtras.c<h> f14182a;

    /* renamed from: b, reason: collision with root package name */
    public static final CreationExtras.c<W> f14183b;

    /* renamed from: c, reason: collision with root package name */
    public static final CreationExtras.c<Bundle> f14184c;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/lifecycle/I$a", "Landroidx/lifecycle/U$c;", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "modelClass", "LV0/a;", "extras", Const.INTENT_KEY_APIKEY, "(Lw9/d;LV0/a;)Landroidx/lifecycle/Q;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements U.c {
        @Override // androidx.lifecycle.U.c
        public <T extends Q> T a(InterfaceC5745d<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            return new L();
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"androidx/lifecycle/I$b", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements CreationExtras.c<h> {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"androidx/lifecycle/I$c", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements CreationExtras.c<W> {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"androidx/lifecycle/I$d", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements CreationExtras.c<Bundle> {
    }

    static {
        CreationExtras.Companion companion = CreationExtras.INSTANCE;
        f14182a = new b();
        f14183b = new c();
        f14184c = new d();
    }

    public static final F a(CreationExtras creationExtras) {
        p.i(creationExtras, "<this>");
        h hVar = (h) creationExtras.a(f14182a);
        if (hVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        W w10 = (W) creationExtras.a(f14183b);
        if (w10 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) creationExtras.a(f14184c);
        String str = (String) creationExtras.a(U.f14251c);
        if (str != null) {
            return b(hVar, w10, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final F b(h hVar, W w10, String str, Bundle bundle) {
        K kD = d(hVar);
        L lE = e(w10);
        F f10 = lE.e().get(str);
        if (f10 != null) {
            return f10;
        }
        F fA = F.INSTANCE.a(kD.c(str), bundle);
        lE.e().put(str, fA);
        return fA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends h & W> void c(T t10) {
        p.i(t10, "<this>");
        Lifecycle.State state = t10.getLifecycle().getState();
        if (state != Lifecycle.State.INITIALIZED && state != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (t10.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            K k10 = new K(t10.getSavedStateRegistry(), t10);
            t10.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", k10);
            t10.getLifecycle().a(new G(k10));
        }
    }

    public static final K d(h hVar) {
        p.i(hVar, "<this>");
        e.b bVarB = hVar.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        K k10 = bVarB instanceof K ? (K) bVarB : null;
        if (k10 != null) {
            return k10;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final L e(W w10) {
        p.i(w10, "<this>");
        return (L) U.Companion.c(U.INSTANCE, w10, new a(), null, 4, null).b("androidx.lifecycle.internal.SavedStateHandlesVM", t.b(L.class));
    }
}
