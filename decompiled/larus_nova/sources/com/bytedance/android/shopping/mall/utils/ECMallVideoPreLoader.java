package com.bytedance.android.shopping.mall.utils;

import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.api.mall.opt.e;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import yj.d;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallVideoPreLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<VideoCardData> f178604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f178605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f178606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<VideoCardData, String> f178607d;

    public final void a() {
        if (((e) this.f178606c.getValue()).c() == true) goto L5;
        return;
    L5:
        HashSet<VideoCardData> r100 = this.f178604a;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return;
    L14:
        ArrayList r102 = new ArrayList(this.f178604a);
        this.f178604a.clear();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        r103.add(b((VideoCardData) r104.next()));
        goto L16
    L18:
        d r105 = (d) this.f178605b.getValue();
        if (r105 == null) goto L23;
        r105.a();
        return;
    L23:
        return;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public ECMallVideoPreLoader() {
        this.f178604a = new HashSet();
        this.f178605b = LazyKt.lazy(ECMallVideoPreLoader$preLoader$2.INSTANCE);
        this.f178606c = LazyKt.lazy(ECMallVideoPreLoader$videoPreloadConfig$2.INSTANCE);
        this.f178607d = new LinkedHashMap();
    }

    public final String b(VideoCardData r100) {
        String r101 = (String) ((LinkedHashMap) this.f178607d).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Gson r102 = p.f170457a;
        String r103 = p.c(r100.getVideo());
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f178607d.put(r100, r103);
        return r103;
    }
}
