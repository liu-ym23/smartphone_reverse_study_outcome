package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements ti.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f44305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pd.j f44306c;

    @Override // ti.l
    public final void release() {
        this.f44306c.release();
    }

    @Override // ti.l
    public final View b() {
        return this.f44305b;
    }

    @Override // ti.l
    public final View getHybridView() {
        return this.f44304a;
    }

    public f(pd.j r100) {
        this.f44306c = r100;
        this.f44304a = r100.getHybridView();
        this.f44305b = r100.b();
    }

    @Override // ti.l
    public final void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f44306c.loadUrl(r100);
    }

    @Override // ti.l
    public final void updateBusinessGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f44306c.updateBusinessGlobalProps(r100);
    }

    @Override // ti.l
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f44306c.updateData(r100);
    }

    @Override // ti.l
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f44306c.updateGlobalProps(r100);
    }

    @Override // ti.l
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f44306c.registerStatefulMethod(r100, r101);
    }

    @Override // ti.l
    public final void renderTemplate(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f44306c.renderTemplate(r100, r101);
    }

    @Override // ti.l
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f44306c.sendJsEvent(r100, r101);
    }

    @Override // ti.l
    public final void updateScreenMetrics(int r100, int r101) {
        this.f44306c.a();
    }

    @Override // ti.l
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f44306c.registerStatelessMethod(r100, r101);
    }
}
