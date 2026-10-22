package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.util.ui.SpanFormatter;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.time.LocalTime;
import java.util.function.Consumer;

/* JADX INFO: compiled from: DayTimeRepeatCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DayTimeRepeatCondition extends AutoCondition {
    public static final Parcelable.Creator<DayTimeRepeatCondition> CREATOR = null;
    private int interval;

    /* JADX INFO: compiled from: DayTimeRepeatCondition.kt */
    public static final class Creator implements Parcelable.Creator<DayTimeRepeatCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeRepeatCondition createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new DayTimeRepeatCondition(r1.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeRepeatCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeRepeatCondition[] newArray(int r1) {
            return new DayTimeRepeatCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeRepeatCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: DayTimeRepeatCondition.kt */
    static final class a implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheet f22972a;

        a(OSheet r1) {
            this.f22972a = r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f22972a.dismiss();
        }
    }

    /* JADX INFO: compiled from: DayTimeRepeatCondition.kt */
    static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.d f22973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.d f22974b;

        b(z.d r1, z.d r2) {
            this.f22973a = r1;
            this.f22974b = r2;
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
        }

        public final void a(d.m<Integer, Integer> r5) {
            o.e(r5, "it");
            z.d r0 = this.f22973a;
            r0.f38502a = ((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
            z.d r4 = this.f22974b;
            r4.f38502a = ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public DayTimeRepeatCondition() {
        this(0, 1, null);
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.interval);
    }

    public /* synthetic */ DayTimeRepeatCondition(int r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int r1) {
        this.interval = r1;
    }

    public DayTimeRepeatCondition(int r8) {
        super(GroupInfo.Companion.a(), false, false, 2, null);
        this.interval = r8;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r37, View r38, d.c.d<? super Boolean> r39) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r37, Context.class, "com.obric.aiagent.plugin");
        d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r39, d.c.d.class, "com.obric.aiagent.plugin");
        final z.d r3 = new z.d();
        r3.f38502a = com.obric.autoaction.app.launcherpage.condition.a.a.a(this.interval);
        final z.d r4 = new z.d();
        r4.f38502a = com.obric.autoaction.app.launcherpage.condition.a.a.b(this.interval);
        com.obric.autoaction.app.launcherpage.condition.config.condition.a r0 = getAutoConditionContext();
        d.h.b.h r1 = null;
        if (r0 == null) goto L5;
        d.m<com.obric.oui.picker.reels.a.c.b, com.obric.oui.picker.reels.a.c.b> r2 = r0.b();
    L6:
        if (r2 == null) goto L8;
        com.obric.oui.picker.reels.a.c.b r5 = (com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 == null) goto L11;
        com.obric.oui.picker.reels.a.c.b r7 = (com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r2.b(), com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin");
    L12:
        final int r8 = Integer.MAX_VALUE;
        if (r5 == null) goto L23;
        if (r7 == null) goto L23;
        n.a r9 = n.f38560a;     // Catch: Throwable -> L17
        DayTimeRepeatCondition r10 = (DayTimeRepeatCondition) ZeusTransformUtils.preCheckCast(this, DayTimeRepeatCondition.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Object r11 = n.f(d.c.b.a.b.a(LocalTime.of(r7.a(), r7.b(), r7.c()).toSecondOfDay() - LocalTime.of(r5.a(), r5.b(), r5.c()).toSecondOfDay()));     // Catch: Throwable -> L17
    L19:
        Integer r12 = d.c.b.a.b.a(Integer.MAX_VALUE);
        if (n.b(r11) == false) goto L22;
        r11 = r12;
    L22:
        r8 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue();
    L17:
        th = move-exception;
        n.a r13 = n.f38560a;
        r11 = n.f(d.o.a(th));
    L23:
        kotlinx.coroutines.o r14 = new kotlinx.coroutines.o(d.c.a.b.a(r18), 1);
        r14.e();
        final kotlinx.coroutines.n r15 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r14, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        final OSheet r16 = new OSheet(r6, 0, 0, false, false, 30, null);
        r16.setHeightMode(OSheet.c.f36216b);
        r16.setSystemInsetsAppearanceLight(null);
        p.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r16, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), new com.obric.autoaction.app.launcherpage.detail.condition.b.c(0, 1, r1).a(r6, new d.m(d.c.b.a.b.a(r3.f38502a), d.c.b.a.b.a(r4.f38502a)), (Consumer) ZeusTransformUtils.preCheckCast(new b(r3, r4), Consumer.class, "com.obric.aiagent.plugin")).a());
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r16, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36212c, null, null, p.a(ZeusTransformUtils.mapRes(R.string.select_time_range_sheet_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "select_time_range_sheet_title"), null, 1, null), null, false, (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeRepeatCondition$updateCondition$2$oSheet$1$1(r16, r15), View.OnClickListener.class, "com.obric.aiagent.plugin"), (View.OnClickListener) ZeusTransformUtils.preCheckCast(new DayTimeRepeatCondition$updateCondition$2$oSheet$1$2(r16, r3, r4, r8, r6, this, r15), View.OnClickListener.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, 16150, null);
        r16.show();
        r15.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r16), d.h.a.b.class, "com.obric.aiagent.plugin"));
        Object r17 = r14.h();
        if (r17 != d.c.a.b.a()) goto L26;
        d.c.b.a.h.c(r18);
    L26:
        return r17;
    L11:
        r7 = null;
        goto L12
    L8:
        r5 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        int r14 = com.obric.autoaction.app.launcherpage.condition.a.a.a(this.interval);
        int r0 = com.obric.autoaction.app.launcherpage.condition.a.a.b(this.interval);
        if (r13 != 1) goto L5;
        String r15 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_repeat_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_repeat_template_sentence"));
    L6:
        o.a(r15);
        if (r14 != 0) goto L10;
        if (r0 != 0) goto L10;
        String r16 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_default_30_minutes, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_30_minutes"));
        o.c(r16, "getString(...)");
    L12:
        String r3 = r16;
        if (getActive() == false) goto L19;
        int r17 = getGroupInfo().getActiveColor();
    L20:
        int r4 = r17;
        boolean r18 = getActive();
        GroupInfo r11 = getGroupInfo();
        if (r18 == false) goto L23;
        int r19 = r11.getActiveSpanTextWeight();
    L24:
        SpannableStringBuilder r110 = l.a(r2, r3, r4, Integer.valueOf(r19), null, 16, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(SpanFormatter.f31572a.a(r15, new Spannable[]{r110}), CharSequence.class, "com.obric.aiagent.plugin");
    L23:
        r19 = r11.getDefaultSpanTextWeight();
        goto L24
    L19:
        r17 = getGroupInfo().getDefaultColor();
    L10:
        if (r14 != 0) goto L13;
        r16 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_minute_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_minute_format"), new Object[]{Integer.valueOf(r0)});
        o.c(r16, "getString(...)");
        goto L12
    L13:
        if (r0 != 0) goto L15;
        r16 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_hour_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_hour_format"), new Object[]{Integer.valueOf(r14)});
        o.c(r16, "getString(...)");
        goto L12
    L15:
        r16 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_hour_minute_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_hour_minute_format"), new Object[]{Integer.valueOf(r14), Integer.valueOf(r0)});
        o.c(r16, "getString(...)");
        goto L12
    L5:
        r15 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_repeat_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_repeat_template"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r12, int r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        int r14 = com.obric.autoaction.app.launcherpage.condition.a.a.a(this.interval);
        int r15 = com.obric.autoaction.app.launcherpage.condition.a.a.b(this.interval);
        String r8 = r1.getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_repeat_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_repeat_template_sentence"));
        o.c(r8, "getString(...)");
        if (r14 != 0) goto L6;
        if (r15 != 0) goto L6;
        String r16 = r1.getString(ZeusTransformUtils.mapRes(R.string.condition_default_30_minutes, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_30_minutes"));
        o.c(r16, "getString(...)");
    L8:
        String r2 = r16;
        if (getActive() == false) goto L15;
        int r17 = getGroupInfo().getActiveColor();
    L16:
        int r3 = r17;
        boolean r18 = getActive();
        GroupInfo r11 = getGroupInfo();
        if (r18 == false) goto L19;
        int r19 = r11.getActiveSpanTextWeight();
    L20:
        SpannableStringBuilder r110 = l.a(r1, r2, r3, Integer.valueOf(r19), null, 16, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(SpanFormatter.f31572a.a(r8, new Spannable[]{r110}), CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        r19 = r11.getDefaultSpanTextWeight();
        goto L20
    L15:
        r17 = getGroupInfo().getDefaultColor();
    L6:
        if (r14 != 0) goto L9;
        r16 = r1.getString(ZeusTransformUtils.mapRes(R.string.condition_minute_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_minute_format"), new Object[]{Integer.valueOf(r15)});
        o.c(r16, "getString(...)");
        goto L8
    L9:
        if (r15 != 0) goto L11;
        r16 = r1.getString(ZeusTransformUtils.mapRes(R.string.condition_hour_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_hour_format"), new Object[]{Integer.valueOf(r14)});
        o.c(r16, "getString(...)");
        goto L8
    L11:
        r16 = r1.getString(ZeusTransformUtils.mapRes(R.string.condition_hour_minute_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_hour_minute_format"), new Object[]{Integer.valueOf(r14), Integer.valueOf(r15)});
        o.c(r16, "getString(...)");
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition configCondition(Condition r5) {
        Condition r6 = (Condition) ZeusTransformUtils.wrapperContextForParams(r5, Condition.class, "com.obric.aiagent.plugin");
        o.e(r6, "condition");
        if (ZeusTransformUtils.instanceOf(r6, TimeCondition.class) == true) goto L5;
        return r6;
    L5:
        return (Condition) ZeusTransformUtils.preCheckCast(new TimeCondition(((TimeCondition) ZeusTransformUtils.preCheckCast(r6, TimeCondition.class, "com.obric.aiagent.plugin")).getStart(), ((TimeCondition) ZeusTransformUtils.preCheckCast(r6, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd(), this.interval), Condition.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r3) {
        o.e(r3, "condition");
        if (ZeusTransformUtils.instanceOf(r3, DayTimeRepeatCondition.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.interval != ((DayTimeRepeatCondition) ZeusTransformUtils.preCheckCast(r3, DayTimeRepeatCondition.class, "com.obric.aiagent.plugin")).interval) goto L7;
        return true;
    }
}
