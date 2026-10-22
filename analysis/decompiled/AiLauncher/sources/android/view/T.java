package android.view;

import V0.CreationExtras;
import Y8.h;
import android.view.Q;
import android.view.U;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BC\b\u0007\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/T;", "Landroidx/lifecycle/Q;", "VM", "LY8/h;", "Lw9/d;", "viewModelClass", "Lkotlin/Function0;", "Landroidx/lifecycle/V;", "storeProducer", "Landroidx/lifecycle/U$c;", "factoryProducer", "LV0/a;", "extrasProducer", "<init>", "(Lw9/d;Lp9/a;Lp9/a;Lp9/a;)V", "", "isInitialized", "()Z", Const.INTENT_KEY_APIKEY, "Lw9/d;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", "c", Const.INTENT_KEY_UMID, "e", "Landroidx/lifecycle/Q;", "cached", "()Landroidx/lifecycle/Q;", UxipConstants.f30680s, "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class T<VM extends Q> implements h<VM> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<VM> viewModelClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<V> storeProducer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<U.c> factoryProducer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<CreationExtras> extrasProducer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public VM cached;

    /* JADX WARN: Multi-variable type inference failed */
    public T(InterfaceC5745d<VM> viewModelClass, InterfaceC5063a<? extends V> storeProducer, InterfaceC5063a<? extends U.c> factoryProducer, InterfaceC5063a<? extends CreationExtras> extrasProducer) {
        p.i(viewModelClass, "viewModelClass");
        p.i(storeProducer, "storeProducer");
        p.i(factoryProducer, "factoryProducer");
        p.i(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // Y8.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) U.INSTANCE.a(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).c(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    @Override // Y8.h
    public boolean isInitialized() {
        return this.cached != null;
    }
}
