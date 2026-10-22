package android.view;

import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/P;", "Landroidx/lifecycle/m;", "Landroidx/lifecycle/h;", "generatedAdapter", "<init>", "(Landroidx/lifecycle/h;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/h;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P implements InterfaceC1395m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1390h generatedAdapter;

    public P(InterfaceC1390h generatedAdapter) {
        p.i(generatedAdapter, "generatedAdapter");
        this.generatedAdapter = generatedAdapter;
    }

    @Override // android.view.InterfaceC1395m
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        p.i(source, "source");
        p.i(event, "event");
        this.generatedAdapter.a(source, event, false, null);
        this.generatedAdapter.a(source, event, true, null);
    }
}
