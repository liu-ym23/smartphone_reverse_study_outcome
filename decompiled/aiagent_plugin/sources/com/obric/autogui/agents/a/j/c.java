package com.obric.autogui.agents.a.j;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.agents.a.f.d;
import com.obric.autogui.operator.f;
import com.obric.autogui.operator.g;
import com.obric.autogui.operator.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements g, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26526a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f26527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f26528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26529e;

    /* JADX INFO: compiled from: ActionEffectStepResult.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(g r2, d r3, String r4) {
            g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            o.e(r1, "original");
            o.e(r3, WsConstants.KEY_CONNECTION_ERROR);
            return new c(r1, r3, r4, null);
        }
    }

    static {
        f26526a = new a(null);
    }

    public /* synthetic */ c(g r2, d r3, String r4, h r5) {
        this((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.obric.autogui.operator.k
    public String a(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        return "";
    }

    @Override // com.obric.autogui.operator.g
    public boolean a() {
        return true;
    }

    @Override // com.obric.autogui.operator.g
    public int d() {
        return -1;
    }

    private c(g r3, d r4, String r5) {
        this.f26527c = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        this.f26528d = r4;
        this.f26529e = r5;
    }

    @Override // com.obric.autogui.operator.g
    public String c() {
        return this.f26527c.c();
    }

    @Override // com.obric.autogui.operator.g
    public g.c b() {
        return this.f26527c.b();
    }

    @Override // com.obric.autogui.operator.g
    public g.e e() {
        return g.e.f29929b;
    }

    @Override // com.obric.autogui.operator.g
    public Object f() {
        return this.f26528d;
    }

    @Override // com.obric.autogui.operator.g
    public f g() {
        return new f(this.f26528d.a(), this.f26528d.toString());
    }
}
