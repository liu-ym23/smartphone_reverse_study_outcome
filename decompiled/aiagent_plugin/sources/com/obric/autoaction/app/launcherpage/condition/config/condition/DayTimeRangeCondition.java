package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.util.ui.SpanFormatter;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DayTimeRangeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DayTimeRangeCondition extends AutoCondition {
    public static final Parcelable.Creator<DayTimeRangeCondition> CREATOR = null;
    private String endTime;
    private String startTime;

    /* JADX INFO: compiled from: DayTimeRangeCondition.kt */
    public static final class Creator implements Parcelable.Creator<DayTimeRangeCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeRangeCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new DayTimeRangeCondition(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeRangeCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeRangeCondition[] newArray(int r1) {
            return new DayTimeRangeCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeRangeCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: DayTimeRangeCondition.kt */
    @d.c.b.a.f(b = "DayTimeRangeCondition.kt", c = {76}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeRangeCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DayTimeRangeCondition f22970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22971d;

        a(DayTimeRangeCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22970c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22969b = r3;
            this.f22971d |= Integer.MIN_VALUE;
            return this.f22970c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DayTimeRangeCondition() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
    }

    public /* synthetic */ DayTimeRangeCondition(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setStartTime(String r1) {
        this.startTime = r1;
    }

    public DayTimeRangeCondition(String r8, String r9) {
        super(GroupInfo.Companion.a(), false, true, 2, null);
        this.startTime = r8;
        this.endTime = r9;
    }

    private final String getTemplate(Context r3) {
        String r2 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_range_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_range_template"));
        o.c(r2, "getString(...)");
        return r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        SpanFormatter.Companion r15 = SpanFormatter.f31572a;
        String r8 = getTemplate(r14);
        Spannable[] r9 = new Spannable[2];
        String r1 = this.startTime;
        if (r1 != null) goto L5;
        r1 = "14:00";
    L5:
        String r2 = r1;
        if (getActive() == false) goto L8;
        int r3 = getGroupInfo().getActiveColor();
    L9:
        int r4 = r3;
        if (getActive() == false) goto L12;
        int r5 = getGroupInfo().getActiveSpanTextWeight();
    L13:
        r9[0] = l.a(r14, r2, r4, Integer.valueOf(r5), null, 16, null);
        String r6 = this.endTime;
        if (r6 != null) goto L16;
        r6 = "15:00";
    L16:
        String r7 = r6;
        if (getActive() == false) goto L19;
        int r10 = getGroupInfo().getActiveColor();
    L20:
        int r11 = r10;
        boolean r16 = getActive();
        GroupInfo r17 = getGroupInfo();
        if (r16 == false) goto L23;
        int r18 = r17.getActiveSpanTextWeight();
    L24:
        r9[1] = l.a(r14, r7, r11, Integer.valueOf(r18), null, 16, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r15.a(r8, r9), CharSequence.class, "com.obric.aiagent.plugin");
    L23:
        r18 = r17.getDefaultSpanTextWeight();
        goto L24
    L19:
        r10 = getGroupInfo().getDefaultColor();
        goto L20
    L12:
        r5 = getGroupInfo().getDefaultSpanTextWeight();
        goto L13
    L8:
        r3 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        SpanFormatter.Companion r15 = SpanFormatter.f31572a;
        String r8 = getTemplate(r14);
        Spannable[] r9 = new Spannable[2];
        String r1 = this.startTime;
        if (r1 != null) goto L5;
        r1 = "14:00";
    L5:
        String r2 = r1;
        if (getActive() == false) goto L8;
        int r3 = getGroupInfo().getActiveColor();
    L9:
        int r4 = r3;
        if (getActive() == false) goto L12;
        int r5 = getGroupInfo().getActiveSpanTextWeight();
    L13:
        r9[0] = l.a(r14, r2, r4, Integer.valueOf(r5), null, 16, null);
        String r6 = this.endTime;
        if (r6 != null) goto L16;
        r6 = "15:00";
    L16:
        String r7 = r6;
        if (getActive() == false) goto L19;
        int r10 = getGroupInfo().getActiveColor();
    L20:
        int r11 = r10;
        boolean r16 = getActive();
        GroupInfo r17 = getGroupInfo();
        if (r16 == false) goto L23;
        int r18 = r17.getActiveSpanTextWeight();
    L24:
        r9[1] = l.a(r14, r7, r11, Integer.valueOf(r18), null, 16, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r15.a(r8, r9), CharSequence.class, "com.obric.aiagent.plugin");
    L23:
        r18 = r17.getDefaultSpanTextWeight();
        goto L24
    L19:
        r10 = getGroupInfo().getDefaultColor();
        goto L20
    L12:
        r5 = getGroupInfo().getDefaultSpanTextWeight();
        goto L13
    L8:
        r3 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r5, View r6, d.c.d<? super Boolean> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r10.f22971d & Integer.MIN_VALUE) == 0) goto L7;
        r10.f22971d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r10.f22969b;
        Object r1 = d.c.a.b.a();
        int r2 = r10.f22971d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        DayTimeRangeCondition this = (DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r10.f22968a, DayTimeRangeCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        d.m r12 = (d.m) ZeusTransformUtils.preCheckCast(r11, d.m.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L22;
        this.startTime = m.a((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r12.a(), com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin"));
        this.endTime = m.a((com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r12.b(), com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin"));
        return d.c.b.a.b.a(true);
    L22:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        com.obric.oui.picker.reels.a.c.b r13 = m.a(this.startTime);
        com.obric.oui.picker.reels.a.c.b r3 = m.a(this.endTime);
        r10.f22968a = this;
        r10.f22971d = 1;
        r11 = f.a(r8, r13, r3, r10);
        if (r11 != r1) goto L17;
        return r1;
    L7:
        r10 = new a(this, r9);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        if (this.startTime != null) goto L5;
        return null;
    L5:
        if (this.endTime == null) goto L10;
        String r2 = this.startTime;
        o.a(r2);
        String r3 = this.endTime;
        o.a(r3);
        return (Condition) ZeusTransformUtils.preCheckCast(new TimeCondition(r2, r3, 0, 4, null), Condition.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r5) {
        o.e(r5, "condition");
        if (ZeusTransformUtils.instanceOf(r5, DayTimeRangeCondition.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (o.a(this.startTime, ((DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeRangeCondition.class, "com.obric.aiagent.plugin")).startTime) == false) goto L9;
        if (o.a(this.endTime, ((DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeRangeCondition.class, "com.obric.aiagent.plugin")).endTime) == false) goto L9;
        return true;
    }
}
