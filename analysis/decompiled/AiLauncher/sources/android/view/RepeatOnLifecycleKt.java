package android.view;

import Ua.M;
import Y8.t;
import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlinx.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a@\u0010\f\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", VoiceWakeupReceiver.EXTRA_STATE, "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "LY8/t;", "", "block", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lp9/p;Le9/c;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lp9/p;Le9/c;)Ljava/lang/Object;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF;
        if (state != Lifecycle.State.INITIALIZED) {
            return (lifecycle.getState() != Lifecycle.State.DESTROYED && (objF = d.f(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, null), interfaceC4014c)) == C4063a.g()) ? objF : t.f7040a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final Object b(LifecycleOwner lifecycleOwner, Lifecycle.State state, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objA = a(lifecycleOwner.getLifecycle(), state, pVar, interfaceC4014c);
        return objA == C4063a.g() ? objA : t.f7040a;
    }
}
