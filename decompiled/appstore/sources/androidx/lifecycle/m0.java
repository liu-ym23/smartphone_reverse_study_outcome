package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Lazy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f3560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f3561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f3562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0 f3563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k0 f3564e;

    public m0(KClass r10, Function0 r11, Function0 r12, Function0 r13) {
        kotlin.jvm.internal.q.g(r10, "viewModelClass");
        kotlin.jvm.internal.q.g(r11, "storeProducer");
        kotlin.jvm.internal.q.g(r12, "factoryProducer");
        kotlin.jvm.internal.q.g(r13, "extrasProducer");
        this.f3560a = r10;
        this.f3561b = r11;
        this.f3562c = r12;
        this.f3563d = r13;
    }

    public k0 a() {
        k0 r10 = this.f3564e;
        if (r10 != null) goto L6;
        ViewModelProvider.Factory r11 = (ViewModelProvider.Factory) this.f3562c.invoke();
        k0 r12 = new ViewModelProvider((ViewModelStore) this.f3561b.invoke(), r11, (CreationExtras) this.f3563d.invoke()).a(xf.a.a(this.f3560a));
        this.f3564e = r12;
        return r12;
    L6:
        return r10;
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return a();
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f3564e == null) goto L5;
        return true;
    L5:
        return false;
    }
}
