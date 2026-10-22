package com.obric.framework.inputmethod.api;

import android.app.ITopActivityAssistDataReceiver;
import android.app.assist.AssistStructure;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricInjectTextResponseCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f33237a;

    public static /* synthetic */ ObricInjectTextResponseCallback$stub$2$1 lambda$LP8RuC9mrK8mvtkx0xEzOCwMELk(b r0) {
        return a(r0);
    }

    public abstract void a(d r1, AssistStructure r2);

    public b() {
        this.f33237a = g.a(new $$Lambda$b$LP8RuC9mrK8mvtkx0xEzOCwMELk(this));
    }

    public final ITopActivityAssistDataReceiver a() {
        return (ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(this.f33237a.b(), ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.framework.inputmethod.api.ObricInjectTextResponseCallback$stub$2$1] */
    private static final ObricInjectTextResponseCallback$stub$2$1 a(final b r1) {
        return new ObricInjectTextResponseCallback$stub$2$1(r1);
    }
}
