package com.obric.autogui.operator.a.a.b;

import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.e;
import com.obric.autogui.operator.a.a.d;
import com.obric.autogui.operator.a.a.f;
import com.obric.autogui.operator.a.c;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l;
import java.util.Collection;

/* JADX INFO: compiled from: PositionalNodeFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.operator.a.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29257a = null;

    /* JADX INFO: compiled from: PositionalNodeFinder.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PositionalNodeFinder.kt */
    private static final class C0741b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f29258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f29259b;

        public C0741b(float r1, float r2) {
            this.f29258a = r1;
            this.f29259b = r2;
        }

        @Override // com.obric.autogui.operator.a.a.d
        public Object a(InjectEventContext.Context r11, d.c.d<? super e> r12) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return c.a(c.f29713a, this.f29258a, this.f29259b, 0, null, r11, r7, 12, null);
        }

        @Override // com.obric.autogui.operator.a.a.d
        public Object a(int r11, InjectEventContext.Context r12, d.c.d<? super e> r13) {
            return c.a(c.f29713a, this.f29258a, this.f29259b, r11, null, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"), 8, null);
        }

        @Override // com.obric.autogui.operator.a.a.d
        public Object b(int r10, InjectEventContext.Context r11, d.c.d<? super e> r12) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return c.a(c.f29713a, this.f29258a, this.f29259b, r10, null, r11, r6, 8, null);
        }

        @Override // com.obric.autogui.operator.a.a.d
        public Object a(String r1, d.c.d<? super e> r2) {
            d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
            throw new l("An operation is not implemented: Not yet implemented");
        }
    }

    static {
        f29257a = new a(null);
    }

    private final boolean a(float r1, float r2) {
        if (r1 > 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (r2 <= 0.0f) goto L7;
        return true;
    }

    public b() {
    }

    @Override // com.obric.autogui.operator.a.a.b.a
    public boolean a(com.obric.autogui.operator.a.a.e r2) {
        o.e(r2, DownloadConstants.QUERY_KEY);
        f r3 = r2.a();
        if (r3 != null) goto L7;
        return false;
    L7:
        return a(r3.a(), r3.b());
    }

    @Override // com.obric.autogui.operator.a.a.b.a
    public Object a(com.obric.autogui.operator.a.a.e r3, d.c.d<? super Collection<? extends d>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        f r6 = r3.a();
        if (r6 != null) goto L7;
        return p.b();
    L7:
        if (a(r6.a(), r6.b()) == true) goto L11;
        return p.b();
    L11:
        return p.a(new C0741b(r6.a(), r6.b()));
    }
}
