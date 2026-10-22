package androidx.lifecycle;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0006R7\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/JediViewHolderProxyViewModelStore;", "", "()V", "viewModels", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/ViewModel;", "Lkotlin/collections/HashMap;", "getViewModels", "()Ljava/util/HashMap;", "viewModels$delegate", "Lkotlin/Lazy;", "clear", "", MonitorConstants.CONNECT_TYPE_GET, "key", "put", "viewModel", "ext_adapter_release"}, k = 1, mv = {1, 1, 16})
public final class JediViewHolderProxyViewModelStore {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy viewModels$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JediViewHolderProxyViewModelStore.class), "viewModels", "getViewModels()Ljava/util/HashMap;"))};
    }

    private final HashMap<String, ViewModel> getViewModels() {
        Lazy r100 = this.viewModels$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (HashMap) r100.getValue();
    }

    public JediViewHolderProxyViewModelStore() {
        this.viewModels$delegate = LazyKt.lazy(JediViewHolderProxyViewModelStore$viewModels$2.INSTANCE);
    }

    public final void clear() {
        Iterator<T> r100 = getViewModels().values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ViewModel) r100.next()).onCleared();
        goto L4
    L6:
        getViewModels().clear();
    }

    public final ViewModel get(String r100) {
        return getViewModels().get(r100);
    }

    public final void put(String r100, ViewModel r101) {
        ViewModel r102 = getViewModels().put(r100, r101);
        if (r102 == null) goto L6;
        r102.onCleared();
        return;
    }
}
