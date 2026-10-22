package android.view;

import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import g1.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/lifecycle/H;", "Landroidx/lifecycle/m;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "key", "Landroidx/lifecycle/F;", "handle", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/F;)V", "Lg1/e;", "registry", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "LY8/t;", "e", "(Lg1/e;Landroidx/lifecycle/Lifecycle;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "close", "()V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Landroidx/lifecycle/F;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/lifecycle/F;", "", UxipConstants.f30680s, "c", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "isAttached", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class H implements InterfaceC1395m, AutoCloseable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final F handle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isAttached;

    public H(String key, F handle) {
        p.i(key, "key");
        p.i(handle, "handle");
        this.key = key;
        this.handle = handle;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public final void e(e registry, Lifecycle lifecycle) {
        p.i(registry, "registry");
        p.i(lifecycle, "lifecycle");
        if (this.isAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.isAttached = true;
        lifecycle.a(this);
        registry.c(this.key, this.handle.a());
    }

    /* renamed from: g, reason: from getter */
    public final F getHandle() {
        return this.handle;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    @Override // android.view.InterfaceC1395m
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        p.i(source, "source");
        p.i(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            source.getLifecycle().d(this);
        }
    }
}
