package com.bytedance.android.live.revlink.impl.pk.feedview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedPkLynxWidget f96486a;

    public j(FeedPkLynxWidget r100) {
        this.f96486a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        FeedPkLynxWidget r102 = this.f96486a;
        if (r102.v(r102.f96364n, (String) r101.getFirst()) == false) goto L5;
        FeedPkLynxWidget r103 = this.f96486a;
        r103.x(r103.f96363m, FeedPkLynxWidget.s(), ((JSONObject) r101.getSecond()).toString());
    L5:
        Iterator<String> r104 = this.f96486a.f96352b.keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        FeedPkLynxWidget r106 = this.f96486a;
        if (r106.v(r106.f96352b.get(r105), (String) r101.getFirst()) == false) goto L7;
        if (this.f96486a.f96356f.contains(r105) == false) goto L7;
        ArrayList r107 = this.f96486a.f96355e.get(r105);
        if (r107 != null) goto L15;
        r107 = new ArrayList();
        this.f96486a.f96355e.put(r105, (ArrayList<JSONObject>) r107);
    L15:
        r107.add(r101.getSecond());
        goto L7
    }
}
