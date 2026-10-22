package k2;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import h2.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final String f9864d = j.f("ConstraintsCmdHandler");

    /* renamed from: a, reason: collision with root package name */
    public final b1 f9865a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9866b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkConstraintsTracker f9867c;

    public c(Context context, b1 b1Var, int i10, f fVar) {
        this.f9865a = b1Var;
        this.f9866b = i10;
        this.f9867c = new WorkConstraintsTracker(fVar.f9887e.f2885j);
    }
}
