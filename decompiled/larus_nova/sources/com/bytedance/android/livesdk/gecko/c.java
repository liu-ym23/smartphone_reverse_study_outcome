package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.geckox.model.UpdatePackage;
import io.reactivex.ObservableEmitter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements xo2.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f125799a;

    public c(String r100) {
        this.f125799a = r100;
    }

    @Override // xo2.c.a
    public final void a(UpdatePackage r100, long r101, long r102) {
        if (r101 == 0) goto L15;
        Set<j.a> r103 = d.f125800a;
        Set r104 = (Set) ((LinkedHashMap) d.f125801b).get(this.f125799a);
        if (r104 == null) goto L21;
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        ObservableEmitter r106 = (ObservableEmitter) ((WeakReference) r105.next()).get();
        if (r106 == null) goto L8;
        if (v.a() == false) goto L14;
        ALogger.d("AAM.Source.GeckoHelper", "[" + r106.hashCode() + "] progress: " + r102 + " / " + r101);
    L14:
        r106.onNext(new j.c((100 * r102) / r101));
        goto L8
    L22:
        return;
    L21:
        return;
    }
}
