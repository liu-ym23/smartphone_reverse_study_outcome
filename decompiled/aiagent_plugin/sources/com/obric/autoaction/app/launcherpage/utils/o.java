package com.obric.autoaction.app.launcherpage.utils;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: TextToBitMapUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f24530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24531e;
    private int f;
    private float g;
    private float h;
    private Integer i;

    /* JADX INFO: compiled from: TextToBitMapUtil.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final n a(Context r2, d.h.a.b<? super o, x> r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            d.h.b.o.e(r4, "block");
            o r5 = new o(r1);
            r4.invoke(r5);
            return r5.a();
        }
    }

    static {
        f24527a = new a(null);
    }

    public o(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f24528b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f24529c = "";
        this.f24530d = 80.0f;
        this.f24531e = -16777216;
        this.f = -16711936;
        this.g = 4.0f;
        this.h = 60.0f;
    }

    public final o a(String r2) {
        d.h.b.o.e(r2, "text");
        this.f24529c = r2;
        return this;
    }

    public final o a(int r1) {
        this.f24531e = r1;
        return this;
    }

    public final o b(int r1) {
        this.i = Integer.valueOf(r1);
        return this;
    }

    public final n a() {
        return new n(this.f24528b, this.f24529c, this.f24530d, this.f24531e, this.g, this.h, this.f, this.i, 0, 0.0f, 768, null);
    }
}
