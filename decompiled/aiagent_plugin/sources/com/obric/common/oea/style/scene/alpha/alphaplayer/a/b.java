package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import android.content.Context;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f32485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f32486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f32487c;

    public b(Context r3, p r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "lifecycleOwner");
        this.f32486b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f32487c = r6;
        this.f32485a = a.f32483b;
    }

    public final Context getContext() {
        return this.f32486b;
    }

    public final p b() {
        return this.f32487c;
    }

    public final a a() {
        return this.f32485a;
    }

    public final void a(a r2) {
        o.e(r2, "<set-?>");
        this.f32485a = r2;
    }
}
