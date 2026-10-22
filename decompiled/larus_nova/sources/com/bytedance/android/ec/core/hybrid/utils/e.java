package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements ti.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f44303b;

    @Override // ti.l
    public final View b() {
        return null;
    }

    @Override // ti.l
    public final void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // ti.l
    public final void updateBusinessGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // ti.l
    public final void updateScreenMetrics(int r100, int r101) {
    }

    @Override // ti.l
    public final void release() {
        ((pd.b) this.f44303b.element).release();
    }

    @Override // ti.l
    public final View getHybridView() {
        return this.f44302a;
    }

    public e(Ref.ObjectRef r100) {
        this.f44303b = r100;
        View r101 = ((pd.b) r100.element).getHybridView();
        Intrinsics.checkNotNull(r101);
        this.f44302a = r101;
    }

    @Override // ti.l
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ((pd.b) this.f44303b.element).updateData(r100);
    }

    @Override // ti.l
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ((pd.b) this.f44303b.element).updateGlobalProps(r100);
    }

    @Override // ti.l
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((pd.b) this.f44303b.element).registerMethod(r100, r101);
    }

    @Override // ti.l
    public final void renderTemplate(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        ((pd.b) this.f44303b.element).load(r100, r101);
    }

    @Override // ti.l
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        ((pd.b) this.f44303b.element).sendJsEvent(r100, r101);
    }

    @Override // ti.l
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        ((pd.b) this.f44303b.element).registerMethod(r100, r101);
    }
}
