package j0;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0626a implements InterfaceC0630e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f13117a;

    public C0626a(C0631f registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        this.f13117a = new LinkedHashSet();
        registry.c("androidx.savedstate.Restarter", this);
    }

    @Override // j0.InterfaceC0630e
    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f13117a));
        return bundle;
    }
}
