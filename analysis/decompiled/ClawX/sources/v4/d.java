package v4;

import androidx.emoji2.text.r;
import java.util.ArrayList;
import java.util.List;
import k4.v;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final ArrayList f5966e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final r f5967a;

    /* renamed from: b, reason: collision with root package name */
    public final v f5968b;

    /* renamed from: c, reason: collision with root package name */
    public List f5969c;
    public boolean d;

    public d(r phase, v vVar) {
        p.e(phase, "phase");
        ArrayList arrayList = f5966e;
        p.c(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<@[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.Unit>>");
        if ((arrayList instanceof q5.a) && !(arrayList instanceof q5.c)) {
            d0.d(arrayList, "kotlin.collections.MutableList");
            throw null;
        }
        this.f5967a = phase;
        this.f5968b = vVar;
        this.f5969c = arrayList;
        this.d = true;
        if (!arrayList.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified");
        }
    }

    public final String toString() {
        return "Phase `" + this.f5967a.f626b + "`, " + this.f5969c.size() + " handlers";
    }
}
