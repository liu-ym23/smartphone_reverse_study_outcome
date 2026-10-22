package V0;

import android.view.Q;
import android.view.U;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/Q;", "VM", "Landroidx/lifecycle/U$c;", "factory", "Lw9/d;", "modelClass", "LV0/a;", "extras", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/U$c;Lw9/d;LV0/a;)Landroidx/lifecycle/Q;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {
    public static final <VM extends Q> VM a(U.c factory, InterfaceC5745d<VM> modelClass, CreationExtras extras) {
        p.i(factory, "factory");
        p.i(modelClass, "modelClass");
        p.i(extras, "extras");
        try {
            try {
                return (VM) factory.a(modelClass, extras);
            } catch (AbstractMethodError unused) {
                return (VM) factory.c(C5013a.b(modelClass));
            }
        } catch (AbstractMethodError unused2) {
            return (VM) factory.b(C5013a.b(modelClass), extras);
        }
    }
}
