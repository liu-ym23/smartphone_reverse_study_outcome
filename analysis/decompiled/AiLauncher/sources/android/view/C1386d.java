package android.view;

import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/d;", "Landroidx/lifecycle/m;", "", "Landroidx/lifecycle/h;", "generatedAdapters", "<init>", "([Landroidx/lifecycle/h;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", Const.INTENT_KEY_APIKEY, "[Landroidx/lifecycle/h;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1386d implements InterfaceC1395m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1390h[] generatedAdapters;

    public C1386d(InterfaceC1390h[] generatedAdapters) {
        p.i(generatedAdapters, "generatedAdapters");
        this.generatedAdapters = generatedAdapters;
    }

    @Override // android.view.InterfaceC1395m
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        p.i(source, "source");
        p.i(event, "event");
        x xVar = new x();
        for (InterfaceC1390h interfaceC1390h : this.generatedAdapters) {
            interfaceC1390h.a(source, event, false, xVar);
        }
        for (InterfaceC1390h interfaceC1390h2 : this.generatedAdapters) {
            interfaceC1390h2.a(source, event, true, xVar);
        }
    }
}
