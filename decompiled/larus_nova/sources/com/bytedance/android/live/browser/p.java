package com.bytedance.android.live.browser;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements IExternalLiveAnnieComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridCard f64153a;

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final View getHybridView() {
        Objects.toString(this.f64153a);
        return this.f64153a;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final void release() {
        this.f64153a.release();
    }

    public p(HybridCard r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridCard");
        this.f64153a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f64153a.updateData(r100);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final void load(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f64153a.load(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f64153a.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f64153a.sendJsEvent(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f64153a.registerMethod(r100, r101);
    }
}
