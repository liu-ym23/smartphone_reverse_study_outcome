package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnniePrefetchProcessor f39942a;

    public a() {
        this.f39942a = new AnniePrefetchProcessor();
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final String A0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return this.f39942a.a(r100);
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void E(t r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        AnniePrefetchProcessor r101 = this.f39942a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        r101.f39932c = r100;
        Observable.merge(SequencesKt.asIterable(SequencesKt.map(CollectionsKt.asSequence((Set) r101.f39931b.getValue()), AnniePrefetchProcessor$initActual$itr$1.INSTANCE))).subscribeOn(Schedulers.io()).filter(j.f39968a).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r101), l.f39970a);
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final JSONObject getCacheJsonByScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        AnniePrefetchProcessor r101 = this.f39942a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        x46.a r102 = r101.d(r100);
        if (r102 == null) goto L49;
        List<PrefetchProcess> r103 = r102.getCacheByScheme(r100);
        if (r103 == null) goto L50;
        Iterator<T> r104 = r103.iterator();
        JSONObject r105 = null;
    L8:
        if (r104.hasNext() == false) goto L35;
        PrefetchProcess r106 = (PrefetchProcess) r104.next();
        String r107 = r106.f248740f.f248748d;
        boolean r108 = true;
        if (r107.length() != 0) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == true) goto L8;
        com.bytedance.ies.tools.prefetch.i.b r110 = r106.f248738d;
        if (r110 == null) goto L8;
        if ((r110 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == true) goto L20;
    L22:
        r108 = false;
    L23:
        if (r108 == true) goto L26;
        r110 = null;
    L26:
        if (r110 == null) goto L8;
        JSONObject r111 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r110).f39938h.getValue();
        if (r111 == null) goto L8;
        JSONObject r112 = r111.optJSONObject(TemplateNodeType.RAW);
        if (r112 == null) goto L8;
        if (r105 != null) goto L33;
        r105 = new JSONObject();
    L33:
        r105.put(r107, r112);
        goto L8
    L20:
        if (r110.f248823d != 200) goto L22;
    L12:
        r109 = false;
        goto L13
    L35:
        return r105;
    L50:
        return null;
    L49:
        return null;
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void prefetch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        AnniePrefetchProcessor r101 = this.f39942a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        x46.a r102 = r101.d(r100);
        if (r102 == null) goto L6;
        r102.c(r100);
        return;
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void r0(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        AnniePrefetchProcessor r101 = this.f39942a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "component");
        if ((!r101.f39930a.isEmpty()) == false) goto L5;
        r100.registerMethod("__prefetch", new h(r101));
        return;
    L5:
        r100.registerMethod("__prefetch", i.f39967a);
    }
}
