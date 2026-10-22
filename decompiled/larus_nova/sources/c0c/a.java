package c0c;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a extends c implements ComponentLifecycleAware {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f21991b;

    @Override // c0c.c, com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f21991b;
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentCreate() {
        s.a(this);
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentDestroy() {
        s.b(this);
    }

    public a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f21991b = r100;
    }
}
