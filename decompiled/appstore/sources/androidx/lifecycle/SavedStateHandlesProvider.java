package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SavedStateRegistry f3475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f3477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f3478d;

    public SavedStateHandlesProvider(SavedStateRegistry r10, final ViewModelStoreOwner r11) {
        kotlin.jvm.internal.q.g(r10, "savedStateRegistry");
        kotlin.jvm.internal.q.g(r11, "viewModelStoreOwner");
        this.f3475a = r10;
        this.f3478d = kotlin.b.b(new SavedStateHandlesProvider$viewModel$2(r11));
    }

    public final Bundle a(String r10) {
        kotlin.jvm.internal.q.g(r10, "key");
        c();
        Bundle r11 = this.f3477c;
        if (r11 == null) goto L5;
        Bundle r12 = r11.getBundle(r10);
    L6:
        Bundle r13 = this.f3477c;
        if (r13 == null) goto L9;
        r13.remove(r10);
    L9:
        Bundle r14 = this.f3477c;
        if (r14 != null) goto L12;
    L14:
        return r12;
    L12:
        if (r14.isEmpty() != true) goto L14;
        this.f3477c = null;
        goto L14
    L5:
        r12 = null;
        goto L6
    }

    public final f0 b() {
        return (f0) this.f3478d.getValue();
    }

    public final void c() {
        if (this.f3476b == true) goto L11;
        Bundle r10 = this.f3475a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle r11 = new Bundle();
        Bundle r12 = this.f3477c;
        if (r12 == null) goto L7;
        r11.putAll(r12);
    L7:
        if (r10 == null) goto L9;
        r11.putAll(r10);
    L9:
        this.f3477c = r11;
        this.f3476b = true;
        b();
        return;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle r10 = new Bundle();
        Bundle r11 = this.f3477c;
        if (r11 == null) goto L5;
        r10.putAll(r11);
    L5:
        Iterator r12 = b().f().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Bundle r15 = ((b0) r13.getValue()).e().saveState();
        if (kotlin.jvm.internal.q.b(r15, Bundle.EMPTY) == true) goto L7;
        r10.putBundle(r14, r15);
        goto L7
    L11:
        this.f3476b = false;
        return r10;
    }
}
