package androidx.fragment.app;

import V0.CreationExtras;
import android.view.U;
import android.view.V;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011²\u0006\u0018\u0010\u0010\u001a\u00020\u000f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0010\u001a\u00020\u000f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/Q;", "VM", "Landroidx/fragment/app/Fragment;", "Lw9/d;", "viewModelClass", "Lkotlin/Function0;", "Landroidx/lifecycle/V;", "storeProducer", "LV0/a;", "extrasProducer", "Landroidx/lifecycle/U$c;", "factoryProducer", "LY8/h;", Const.INTENT_KEY_APIKEY, "(Landroidx/fragment/app/Fragment;Lw9/d;Lp9/a;Lp9/a;Lp9/a;)LY8/h;", "Landroidx/lifecycle/W;", "owner", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt {
    public static final <VM extends android.view.Q> Y8.h<VM> a(final Fragment fragment, InterfaceC5745d<VM> interfaceC5745d, InterfaceC5063a<? extends V> interfaceC5063a, InterfaceC5063a<? extends CreationExtras> interfaceC5063a2, InterfaceC5063a<? extends U.c> interfaceC5063a3) {
        if (interfaceC5063a3 == null) {
            interfaceC5063a3 = new InterfaceC5063a<U.c>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                @Override // p9.InterfaceC5063a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final U.c invoke() {
                    return fragment.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new android.view.T(interfaceC5745d, interfaceC5063a, interfaceC5063a3, interfaceC5063a2);
    }
}
