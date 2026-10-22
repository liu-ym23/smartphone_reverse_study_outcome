package com.obric.autogui.evaluation;

import com.obric.autogui.common.api.AOFileUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.session.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.io.File;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: LastJournalRequester.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "LastJournal";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29063a = null;

    /* JADX INFO: renamed from: com.obric.autogui.evaluation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LastJournalRequester.kt */
    @f(b = "LastJournalRequester.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.evaluation.LastJournalRequester$requestLastJournalInPlace$2")
    static final class C0730a extends l implements m<am, d<? super File>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29064a;

        C0730a(d<? super C0730a> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super File> r4) {
            return ((C0730a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0730a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new C0730a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super File> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            b.a();
            if (this.f29064a != 0) goto L7;
            o.a(r5);
            String r4 = c.f30720a.a().getAbsolutePath();
            Loog.INSTANCE.i(a.TAG, "requestLastJournalInPlace, toDir=" + r4);
            File r6 = AOFileUtil.INSTANCE.getWritableAppDir();
            com.obric.autogui.util.f.a r0 = com.obric.autogui.util.f.a.f31549a;
            d.h.b.o.a(r4);
            File r7 = r0.a(r4, new File(r6, "compressed-journals"));
            Loog.INSTANCE.i(a.TAG, "requestLastJournalInPlace, savedTo=" + r7);
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f29063a = new a();
    }

    private a() {
    }

    public final Object a(d<? super File> r4) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0730a(null), m.class, "com.obric.aiagent.plugin"), r3);
    }
}
