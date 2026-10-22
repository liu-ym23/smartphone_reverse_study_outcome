package com.obric.autogui.operator;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i implements g, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29936a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f29938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29939e;

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29936a = new a(null);
    }

    public i(boolean r1, boolean r2, int r3) {
        this.f29937c = r1;
        this.f29938d = r2;
        this.f29939e = r3;
    }

    public /* synthetic */ i(boolean r1, boolean r2, int r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Integer.MIN_VALUE;
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.autogui.operator.g
    public String c() {
        return g.b.a(this);
    }

    @Override // com.obric.autogui.operator.g
    public g.e e() {
        return g.b.c(this);
    }

    @Override // com.obric.autogui.operator.g
    public Object f() {
        return g.b.d(this);
    }

    @Override // com.obric.autogui.operator.g
    public f g() {
        return g.b.e(this);
    }

    @Override // com.obric.autogui.operator.g
    public boolean a() {
        return this.f29937c;
    }

    @Override // com.obric.autogui.operator.g
    public g.c b() {
        if (this.f29938d == false) goto L6;
        return g.c.f29925d;
    L6:
        return g.c.f29924c;
    }

    @Override // com.obric.autogui.operator.g
    public int d() {
        int r0 = this.f29939e;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return g.b.b(this);
    }

    public String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (this.f29937c == false) goto L6;
        return r4.getString(ZeusTransformUtils.mapRes(R.string.espe_executed_all_with_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_executed_all_with_error"));
    L6:
        return r4.getString(ZeusTransformUtils.mapRes(R.string.espe_executed_all_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_executed_all_success"));
    }
}
