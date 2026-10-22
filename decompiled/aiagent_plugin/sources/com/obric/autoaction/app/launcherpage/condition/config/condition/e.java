package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: DayTimeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: DayTimeCondition.kt */
    static final class a implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheet f23030a;

        a(OSheet r1) {
            this.f23030a = r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f23030a.dismiss();
        }
    }

    /* JADX INFO: compiled from: DayTimeCondition.kt */
    static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.d f23031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.d f23032b;

        b(z.d r1, z.d r2) {
            this.f23031a = r1;
            this.f23032b = r2;
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
        }

        public final void a(d.m<Integer, Integer> r5) {
            o.e(r5, "it");
            z.d r0 = this.f23031a;
            r0.f38502a = ((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
            z.d r4 = this.f23032b;
            r4.f38502a = ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        }
    }

    public static final Object a(Context r33, com.obric.oui.picker.reels.a.c.b r34, d.c.d<? super com.obric.oui.picker.reels.a.c.b> r35) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r11 = new kotlinx.coroutines.o(d.c.a.b.a(r10), 1);
        r11.e();
        final n r12 = (n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin");
        LocalDateTime r2 = LocalDateTime.now();
        final z.d r13 = new z.d();
        if (r34 == null) goto L5;
        int r3 = r34.a();
    L6:
        r13.f38502a = r3;
        final z.d r14 = new z.d();
        if (r34 == null) goto L9;
        int r4 = r34.b();
    L10:
        r14.f38502a = r4;
        final OSheet r15 = new OSheet(r0, 0, 0, false, false, 30, null);
        r15.setHeightMode(OSheet.c.f36216b);
        r15.setSystemInsetsAppearanceLight(null);
        com.obric.autoaction.app.launcherpage.detail.condition.b.c r5 = new com.obric.autoaction.app.launcherpage.detail.condition.b.c(0);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "getContext(...)");
        View r7 = r5.a(r6, new d.m(d.c.b.a.b.a(r13.f38502a), d.c.b.a.b.a(r14.f38502a)), (Consumer) ZeusTransformUtils.preCheckCast(new b(r13, r14), Consumer.class, "com.obric.aiagent.plugin")).a();
        p.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r7);
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36212c, null, null, r0.getString(ZeusTransformUtils.mapRes(R.string.condition_select_time_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_select_time_title")), null, false, (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeConditionKt$selectDayTime$2$oSheet$1$1(r15, r12), View.OnClickListener.class, "com.obric.aiagent.plugin"), (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeConditionKt$selectDayTime$2$oSheet$1$2(r15, r12, r13, r14), View.OnClickListener.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, 16150, null);
        r15.show();
        r12.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r15), d.h.a.b.class, "com.obric.aiagent.plugin"));
        Object r1 = r11.h();
        if (r1 != d.c.a.b.a()) goto L13;
        d.c.b.a.h.c(r10);
    L13:
        return r1;
    L9:
        r4 = r2.getMinute();
        goto L10
    L5:
        r3 = r2.getHour();
        goto L6
    }
}
