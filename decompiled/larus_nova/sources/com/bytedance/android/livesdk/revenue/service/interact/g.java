package com.bytedance.android.livesdk.revenue.service.interact;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f157352a;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f157353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f157354b;

        public a(g r100, b r101) {
            this.f157353a = r100;
            this.f157354b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f157353a.f157352a.removeObserver("data_online_changed_list", this.f157354b);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f157355a;

        public b(ObservableEmitter r100) {
            this.f157355a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List r101 = (List) ((KVData) r100).getData();
            List r102 = null;
            if (r101 == null) goto L17;
            ArrayList r103 = new ArrayList();
            Iterator<T> r104 = r101.iterator();
        L6:
            if (r104.hasNext() == false) goto L16;
            ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r104.next();
            IBaseUser r106 = r105.getUser();
            if (r106 == null) goto L13;
            String r107 = r106.getIdString();
            if (r107 == null) goto L13;
            com.bytedance.android.livesdk.revenue.service.interact.a r108 = new com.bytedance.android.livesdk.revenue.service.interact.a(r107, r105.getFanTicketDisplayStr());
        L14:
            if (r108 == null) goto L6;
            r103.add(r108);
        L13:
            r108 = null;
            goto L14
        L16:
            r102 = r103;
        L17:
            ObservableEmitter r109 = this.f157355a;
            if (r102 != null) goto L20;
            r102 = CollectionsKt.emptyList();
        L20:
            r109.onNext(r102);
        }
    }

    public g(DataCenter r100) {
        this.f157352a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<com.bytedance.android.livesdk.revenue.service.interact.a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        b r101 = new b(r100);
        r100.setCancellable(new a(this, r101));
        this.f157352a.observeForever("data_online_changed_list", r101);
    }
}
