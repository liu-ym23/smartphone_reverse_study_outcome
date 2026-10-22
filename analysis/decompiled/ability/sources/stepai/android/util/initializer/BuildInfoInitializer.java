package stepai.android.util.initializer;

import C7.r;
import N9.j;
import android.content.Context;
import androidx.startup.Initializer;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lstepai/android/util/initializer/BuildInfoInitializer;", "Landroidx/startup/Initializer;", "LC7/r;", AppAgent.CONSTRUCT, "()V", "util_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildInfoInitializer implements Initializer<r> {
    @Override // androidx.startup.Initializer
    public final r create(Context context) {
        k.f(context, "context");
        j.H("BuildInfoInitializer create", "MpyInitializer");
        return r.f317a;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return new ArrayList();
    }
}
