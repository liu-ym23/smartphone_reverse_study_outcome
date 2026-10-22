package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import com.bytedance.android.live.revlink.impl.utils.v;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleAudiencePKComponent f98131a;

    public a(DoubleAudiencePKComponent r100) {
        this.f98131a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        this.f98131a.getClass();
        DoubleAudiencePKComponent.b(true);
        DoubleAudiencePKComponent r102 = this.f98131a;
        r102.f98115d = true;
        v r103 = r102.f98116e;
        r103.getClass();
        r103.b("delay_sync_done", new JSONObject());
    }
}
