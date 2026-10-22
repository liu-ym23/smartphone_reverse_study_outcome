package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4722g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.b f4723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f4725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.savedstate.a.b f4727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4728f;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AutoRecreated {
        void onRecreated(@NotNull SavedStateRegistryOwner r10);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "saveState", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SavedStateProvider {
        @NotNull
        Bundle saveState();
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f4722g = new a(null);
    }

    public SavedStateRegistry() {
        this.f4723a = new i.b();
        this.f4728f = true;
    }

    public static /* synthetic */ void a(SavedStateRegistry r10, LifecycleOwner r11, Lifecycle.Event r12) {
        d(r10, r11, r12);
    }

    public static final void d(SavedStateRegistry r10, LifecycleOwner r11, Lifecycle.Event r12) {
        q.g(r10, "this$0");
        q.g(r11, "<anonymous parameter 0>");
        q.g(r12, "event");
        if (r12 != Lifecycle.Event.ON_START) goto L6;
        r10.f4728f = true;
        return;
    L6:
        if (r12 != Lifecycle.Event.ON_STOP) goto L10;
        r10.f4728f = false;
        return;
    }

    public final Bundle b(String r10) {
        q.g(r10, "key");
        if (this.f4726d == false) goto L21;
        Bundle r11 = this.f4725c;
        if (r11 == null) goto L19;
        if (r11 == null) goto L8;
        Bundle r12 = r11.getBundle(r10);
    L9:
        Bundle r13 = this.f4725c;
        if (r13 == null) goto L12;
        r13.remove(r10);
    L12:
        Bundle r14 = this.f4725c;
        if (r14 != null) goto L15;
    L17:
        this.f4725c = null;
    L18:
        return r12;
    L15:
        if (r14.isEmpty() == true) goto L17;
    L8:
        r12 = null;
        goto L9
    L19:
        return null;
    L21:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final SavedStateProvider c(String r10) {
        q.g(r10, "key");
        Iterator r11 = this.f4723a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        q.f(r12, "components");
        String r13 = (String) r12.getKey();
        SavedStateProvider r14 = (SavedStateProvider) r12.getValue();
        if (q.b(r13, r10) == false) goto L4;
        return r14;
    L8:
        return null;
    }

    public final void e(Lifecycle r10) {
        q.g(r10, "lifecycle");
        if (this.f4724b == true) goto L7;
        r10.a(new b(this));
        this.f4724b = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    public final void f(Bundle r10) {
        if (this.f4724b == false) goto L14;
        if (this.f4726d == true) goto L12;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    L9:
        this.f4725c = r11;
        this.f4726d = true;
        return;
    L8:
        r11 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
    }

    public final void g(Bundle r10) {
        q.g(r10, "outBundle");
        Bundle r11 = new Bundle();
        Bundle r12 = this.f4725c;
        if (r12 == null) goto L5;
        r11.putAll(r12);
    L5:
        i.b.d r13 = this.f4723a.c();
        q.f(r13, "this.components.iteratorWithAdditions()");
    L7:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r11.putBundle((String) r14.getKey(), ((SavedStateProvider) r14.getValue()).saveState());
        goto L7
    L10:
        if (r11.isEmpty() == true) goto L14;
        r10.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", r11);
        return;
    }

    public final void h(String r10, SavedStateProvider r11) {
        q.g(r10, "key");
        q.g(r11, "provider");
        if (((SavedStateProvider) this.f4723a.f(r10, r11)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    public final void i(Class r10) {
        q.g(r10, "clazz");
        if (this.f4728f == false) goto L17;
        androidx.savedstate.a.b r11 = this.f4727e;
        if (r11 != null) goto L7;
        r11 = new androidx.savedstate.a.b(this);
    L7:
        this.f4727e = r11;
        r10.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L13
        androidx.savedstate.a.b r12 = this.f4727e;
        if (r12 == null) goto L20;
        String r13 = r10.getName();
        q.f(r13, "clazz.name");
        r12.a(r13);
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r10.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}
