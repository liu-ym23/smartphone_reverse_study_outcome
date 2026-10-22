package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
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

/* JADX INFO: compiled from: DayTimeRangeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: DayTimeRangeCondition.kt */
    static final class a implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheet f23033a;

        a(OSheet r1) {
            this.f23033a = r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f23033a.dismiss();
        }
    }

    /* JADX INFO: compiled from: DayTimeRangeCondition.kt */
    static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.oui.picker.reels.a.c.b> f23034a;

        b(z.f<com.obric.oui.picker.reels.a.c.b> r1) {
            this.f23034a = r1;
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
        }

        public final void a(d.m<Integer, Integer> r8) {
            o.e(r8, "it");
            z.f<com.obric.oui.picker.reels.a.c.b> r7 = this.f23034a;
            r7.f38504a = (T) new com.obric.oui.picker.reels.a.c.b(((Number) ZeusTransformUtils.preCheckCast(r8.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r8.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: DayTimeRangeCondition.kt */
    static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.oui.picker.reels.a.c.b> f23035a;

        c(z.f<com.obric.oui.picker.reels.a.c.b> r1) {
            this.f23035a = r1;
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
        }

        public final void a(d.m<Integer, Integer> r8) {
            o.e(r8, "it");
            z.f<com.obric.oui.picker.reels.a.c.b> r7 = this.f23035a;
            r7.f38504a = (T) new com.obric.oui.picker.reels.a.c.b(((Number) ZeusTransformUtils.preCheckCast(r8.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r8.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), 0, 4, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object a(Context r33, String r34, com.obric.oui.picker.reels.a.c.b r35, com.obric.oui.picker.reels.a.c.b r36, d.c.d<? super d.m<com.obric.oui.picker.reels.a.c.b, com.obric.oui.picker.reels.a.c.b>> r37) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        LocalDateTime r2 = LocalDateTime.now();
        final z.f r11 = new z.f();
        if (r35 != null) goto L5;
        T r9 = new com.obric.oui.picker.reels.a.c.b(r2.getHour(), r2.getMinute(), 0, 4, null);
    L6:
        r11.f38504a = r9;
        final z.f r12 = new z.f();
        if (r36 == null) goto L9;
        T r13 = r36;
    L13:
        r12.f38504a = r13;
        kotlinx.coroutines.o r14 = new kotlinx.coroutines.o(d.c.a.b.a(r10), 1);
        r14.e();
        final n r15 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin");
        final OSheet r16 = new OSheet(r0, 0, 0, false, false, 30, null);
        r16.setHeightMode(OSheet.c.f36216b);
        r16.setSystemInsetsAppearanceLight(null);
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from(r0), ZeusTransformUtils.mapRes(R.layout.autoaction_day_time_range_sheet_body, "layout", "autoaction_day_time_range_sheet_body"), null, false, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.condition.b.c r4 = new com.obric.autoaction.app.launcherpage.detail.condition.b.c(0);
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "getContext(...)");
        View r6 = r4.a(r5, new d.m(d.c.b.a.b.a(((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin")).a()), d.c.b.a.b.a(((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin")).b())), (Consumer) ZeusTransformUtils.preCheckCast(new c(r11), Consumer.class, "com.obric.aiagent.plugin")).a();
        com.obric.autoaction.app.launcherpage.detail.condition.b.c r7 = new com.obric.autoaction.app.launcherpage.detail.condition.b.c(0);
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "getContext(...)");
        View r17 = r7.a(r8, new d.m(d.c.b.a.b.a(((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin")).a()), d.c.b.a.b.a(((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin")).b())), (Consumer) ZeusTransformUtils.preCheckCast(new b(r12), Consumer.class, "com.obric.aiagent.plugin")).a();
        FrameLayout r18 = (FrameLayout) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.start_time_picker, DbHelper.COL_ID, "start_time_picker")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L16;
        r18.addView(r6);
    L16:
        FrameLayout r19 = (FrameLayout) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.end_time_picker, DbHelper.COL_ID, "end_time_picker")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L19;
        r19.addView(r17);
    L19:
        p.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r16, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r16, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36212c, null, null, r34, null, false, (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeRangeConditionKt$selectDoubleTime$2$oSheet$1$1(r16, r15), View.OnClickListener.class, "com.obric.aiagent.plugin"), (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeRangeConditionKt$selectDoubleTime$2$oSheet$1$2(r12, r11, r0, r16, r15), View.OnClickListener.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, 16150, null);
        r16.show();
        r15.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r16), d.h.a.b.class, "com.obric.aiagent.plugin"));
        Object r1 = r14.h();
        if (r1 != d.c.a.b.a()) goto L22;
        d.c.b.a.h.c(r10);
    L22:
        return r1;
    L9:
        if (r2.getHour() < 23) goto L11;
        r13 = new com.obric.oui.picker.reels.a.c.b(23, 59, 0, 4, null);
        goto L13
    L11:
        r13 = new com.obric.oui.picker.reels.a.c.b(r2.getHour() + 1, r2.getMinute(), 0, 4, null);
        goto L13
    L5:
        r9 = r35;
        goto L6
    }

    public static final Object a(Context r3, com.obric.oui.picker.reels.a.c.b r4, com.obric.oui.picker.reels.a.c.b r5, d.c.d<? super d.m<com.obric.oui.picker.reels.a.c.b, com.obric.oui.picker.reels.a.c.b>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.select_time_range_sheet_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "select_time_range_sheet_title"));
        o.c(r0, "getString(...)");
        return a(r7, r0, r4, r5, r8);
    }
}
