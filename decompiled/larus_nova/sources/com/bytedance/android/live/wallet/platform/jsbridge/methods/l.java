package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Consumer<Map<String, Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f102757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f102758b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Map<String, Boolean> r100) throws Exception {
        Map<String, Boolean> r101 = r100;
        if (r101 != null) goto L5;
        this.f102758b.finishWithFailure();
        return;
    L5:
        Iterator<Map.Entry<String, Boolean>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r103 = r102.next();
        this.f102757a.put(r103.getKey(), r103.getValue());
        goto L7
    L9:
        JSONObject r104 = new JSONObject();
        r104.put("result", this.f102757a);
        this.f102758b.finishWithResult(r104);
    }

    public l(n r100, JSONObject r101) {
        this.f102758b = r100;
        this.f102757a = r101;
    }
}
