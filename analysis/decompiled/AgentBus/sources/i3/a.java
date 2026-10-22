package i3;

import android.os.Bundle;
import c7.j;
import d7.r;
import ib.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f4637a = new LinkedHashSet();

    public a(q6.b bVar) {
        bVar.M0("androidx.savedstate.Restarter", this);
    }

    @Override // i3.d
    public final Bundle a() {
        Bundle bundleK = k.k((j[]) Arrays.copyOf(new j[0], 0));
        List listM1 = r.m1(this.f4637a);
        bundleK.putStringArrayList("classes_to_restore", listM1 instanceof ArrayList ? (ArrayList) listM1 : new ArrayList<>(listM1));
        return bundleK;
    }
}
