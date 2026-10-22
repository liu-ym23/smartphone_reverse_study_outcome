package com.bytedance.android.livesdk.castscreen.pad.controller;

import com.byted.cast.common.api.IBrowseListener;
import com.byted.cast.common.source.ServiceInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements IBrowseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f104609a;

    public c(WeakReference r100) {
        this.f104609a = r100;
    }

    @Override // com.byted.cast.common.api.IBrowseListener
    public final /* synthetic */ void onBrowseInvalidDevice(int r100, List r101) {
        IBrowseListener.CC.$default$onBrowseInvalidDevice(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.IBrowseListener
    public final /* synthetic */ void onError(int r100, String r101) {
        IBrowseListener.CC.$default$onError(this, r100, r101);
    }

    @Override // com.byted.cast.common.api.IBrowseListener
    public final void onBrowse(int r100, List<ServiceInfo> r101) {
        nf1.a r102 = (nf1.a) this.f104609a.get();
        if (r102 == null) goto L13;
        if (r101 == null) goto L9;
        List<ServiceInfo> r103 = r101;
        List<? extends of1.a> r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L10;
        r104.add(new of1.b((ServiceInfo) r105.next()));
    L10:
        r102.onBrowse(r100, r104);
        return;
    L9:
        r104 = CollectionsKt.emptyList();
        goto L10
    }
}
