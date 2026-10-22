package android.view;

import Ua.M;
import W0.b;
import W0.c;
import W0.f;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0006¨\u0006\b"}, d2 = {"LW0/f;", Const.INTENT_KEY_APIKEY, "LW0/f;", "VIEW_MODEL_SCOPE_LOCK", "Landroidx/lifecycle/Q;", "LUa/M;", "(Landroidx/lifecycle/Q;)LUa/M;", "viewModelScope", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public static final f f14244a = new f();

    public static final M a(Q q10) {
        b bVarA;
        p.i(q10, "<this>");
        synchronized (f14244a) {
            bVarA = (b) q10.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (bVarA == null) {
                bVarA = c.a();
                q10.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", bVarA);
            }
        }
        return bVarA;
    }
}
