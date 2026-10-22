package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/a;", "selectRepository", "", "setSelectRepository", "initOriginData", "", "selectedItemData", "selectOrUnSelectItem", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/a;", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/k;", "_currentStringListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "currentStringListLiveData", "Landroidx/lifecycle/LiveData;", "getCurrentStringListLiveData", "()Landroidx/lifecycle/LiveData;", "_dataListLiveData", "dataListLiveData", "getDataListLiveData", "", "_dismissLiveData", "dismissLiveData", "getDismissLiveData", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectViewModel extends ECBaseViewModel {
    private final MutableLiveData<List<k>> _currentStringListLiveData;
    private final MutableLiveData<List<k>> _dataListLiveData;
    private final MutableLiveData<Boolean> _dismissLiveData;
    private final LiveData<List<k>> currentStringListLiveData;
    private final LiveData<List<k>> dataListLiveData;
    private final LiveData<Boolean> dismissLiveData;
    private a selectRepository;

    public final void initOriginData() {
        a r100 = this.selectRepository;
        if (r100 == null) goto L23;
        List<String> r101 = r100.b();
        if (r101 == null) goto L24;
        a r102 = this.selectRepository;
        if (r102 == null) goto L10;
        List<String> r103 = r102.a();
        if (r103 == null) goto L10;
    L11:
        ArrayList r104 = new ArrayList();
        MutableLiveData<List<k>> r105 = this._dataListLiveData;
        List<String> r106 = r101;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L13:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();
        boolean r110 = r103.contains(r109);
        k r111 = new k(r109, r110);
        if (r110 == false) goto L17;
        r104.add(r111);
    L17:
        r107.add(r111);
        goto L13
    L18:
        r105.setValue(r107);
        this._currentStringListLiveData.setValue(r104);
        return;
    L10:
        r103 = CollectionsKt.emptyList();
        goto L11
    L24:
        return;
    }

    public LiveFlashMultiSelectViewModel() {
        MutableLiveData<List<k>> r100 = new MutableLiveData();
        this._currentStringListLiveData = r100;
        this.currentStringListLiveData = r100;
        MutableLiveData<List<k>> r101 = new MutableLiveData();
        this._dataListLiveData = r101;
        this.dataListLiveData = r101;
        MutableLiveData<Boolean> r102 = new MutableLiveData();
        this._dismissLiveData = r102;
        this.dismissLiveData = r102;
    }

    public final LiveData<List<k>> getCurrentStringListLiveData() {
        return this.currentStringListLiveData;
    }

    public final LiveData<List<k>> getDataListLiveData() {
        return this.dataListLiveData;
    }

    public final LiveData<Boolean> getDismissLiveData() {
        return this.dismissLiveData;
    }

    public final void selectOrUnSelectItem(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedItemData");
        List<k> r101 = this._dataListLiveData.getValue();
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        k r103 = (k) r102.next();
        if (Intrinsics.areEqual(r103.f149736a, r100) == false) goto L6;
        r103.f149737b = !r103.f149737b;
    L10:
        MutableLiveData<List<k>> r104 = this._dataListLiveData;
        r104.setValue(r104.getValue());
        MutableLiveData<List<k>> r105 = this._currentStringListLiveData;
        List<k> r106 = this._dataListLiveData.getValue();
        if (r106 == null) goto L18;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (((k) r109).f149737b == false) goto L14;
        r107.add(r109);
    L19:
        r105.setValue(r107);
        return;
    L18:
        r107 = null;
        goto L19
    }

    public final void setSelectRepository(a r100) {
        this.selectRepository = r100;
    }
}
