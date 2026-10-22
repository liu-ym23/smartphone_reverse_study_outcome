package s0;

import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class I {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f14163a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.r f14164b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f14165c;

    public I(UUID id, B0.r workSpec, Set tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f14163a = id;
        this.f14164b = workSpec;
        this.f14165c = tags;
    }
}
