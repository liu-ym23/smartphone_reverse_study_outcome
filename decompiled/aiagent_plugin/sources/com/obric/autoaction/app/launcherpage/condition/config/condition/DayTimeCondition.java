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
import java.util.Iterator;

/* JADX INFO: compiled from: DayTimeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DayTimeCondition extends AutoCondition {
    public static final Parcelable.Creator<DayTimeCondition> CREATOR = null;
    private String dayTime;

    /* JADX INFO: compiled from: DayTimeCondition.kt */
    public static final class Creator implements Parcelable.Creator<DayTimeCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeCondition createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new DayTimeCondition(r1.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayTimeCondition[] newArray(int r1) {
            return new DayTimeCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayTimeCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: DayTimeCondition.kt */
    @d.c.b.a.f(b = "DayTimeCondition.kt", c = {77}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DayTimeCondition f22966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22967d;

        a(DayTimeCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22966c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22965b = r3;
            this.f22967d |= Integer.MIN_VALUE;
            return this.f22966c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DayTimeCondition() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DayTimeCondition copy$default(DayTimeCondition r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.dayTime;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.dayTime;
    }

    public final DayTimeCondition copy(String r1) {
        return new DayTimeCondition(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DayTimeCondition.class) == true) goto L8;
        return false;
    L8:
        DayTimeCondition r6 = (DayTimeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.dayTime, r6.dayTime) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.dayTime;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DayTimeCondition(dayTime=" + this.dayTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.dayTime);
    }

    public /* synthetic */ DayTimeCondition(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getDayTime() {
        return this.dayTime;
    }

    public final void setDayTime(String r1) {
        this.dayTime = r1;
    }

    public DayTimeCondition(String r8) {
        super(GroupInfo.Companion.a(), false, true, 2, null);
        this.dayTime = r8;
    }

    private final String getTemplate(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.condition.config.condition.a r7 = getAutoConditionContext();
        if (r7 == null) goto L19;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r4 = r11.next();
        if (ZeusTransformUtils.instanceOf((AutoCondition) ZeusTransformUtils.preCheckCast(r4, AutoCondition.class, "com.obric.aiagent.plugin"), DayTimeRepeatCondition.class) == false) goto L6;
    L11:
        AutoCondition r12 = (AutoCondition) ZeusTransformUtils.preCheckCast(r4, AutoCondition.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r12 != null) goto L14;
    L16:
        if (r1 == false) goto L19;
        String r13 = r10.getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_from_start, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_from_start"));
        o.c(r13, "getString(...)");
        return r13;
    L14:
        if (r12.getActive() != true) goto L16;
        r1 = true;
        goto L16
    L10:
        r4 = null;
    L19:
        if (r9 != 1) goto L21;
        String r14 = r10.getString(ZeusTransformUtils.mapRes(R.string.condition_day_time_at, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_time_at"));
        o.c(r14, "getString(...)");
        return r14;
    L21:
        return "%s";
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r10, int r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        String r12 = getTemplate(r2, r11);
        SpanFormatter.Companion r13 = SpanFormatter.f31572a;
        Spannable[] r0 = new Spannable[1];
        String r3 = this.dayTime;
        if (r3 != null) goto L6;
        r3 = "8:30";
    L6:
        if (getActive() == false) goto L8;
        int r4 = getGroupInfo().getActiveColor();
    L9:
        boolean r5 = getActive();
        GroupInfo r9 = getGroupInfo();
        if (r5 == false) goto L12;
        int r14 = r9.getActiveSpanTextWeight();
    L13:
        r0[0] = l.a(r2, r3, r4, Integer.valueOf(r14), null, 16, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r13.a(r12, r0), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r14 = r9.getDefaultSpanTextWeight();
        goto L13
    L8:
        r4 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        String r2 = getTemplate(r10, 1);
        SpanFormatter.Companion r3 = SpanFormatter.f31572a;
        Spannable[] r0 = new Spannable[1];
        String r4 = this.dayTime;
        if (r4 != null) goto L6;
        r4 = "8:30";
    L6:
        if (getActive() == false) goto L8;
        int r5 = getGroupInfo().getActiveColor();
    L9:
        boolean r6 = getActive();
        GroupInfo r7 = getGroupInfo();
        if (r6 == false) goto L12;
        int r11 = r7.getActiveSpanTextWeight();
    L13:
        r0[0] = l.a(r10, r4, r5, Integer.valueOf(r11), Integer.valueOf(r9));
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.a(r2, r0), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r11 = r7.getDefaultSpanTextWeight();
        goto L13
    L8:
        r5 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r5, View r6, d.c.d<? super Boolean> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r10.f22967d & Integer.MIN_VALUE) == 0) goto L7;
        r10.f22967d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r10.f22965b;
        Object r1 = d.c.a.b.a();
        int r2 = r10.f22967d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        DayTimeCondition this = (DayTimeCondition) ZeusTransformUtils.preCheckCast(r10.f22964a, DayTimeCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        com.obric.oui.picker.reels.a.c.b r12 = (com.obric.oui.picker.reels.a.c.b) ZeusTransformUtils.preCheckCast(r11, com.obric.oui.picker.reels.a.c.b.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L22;
        this.dayTime = m.a(r12);
        return d.c.b.a.b.a(true);
    L22:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        com.obric.oui.picker.reels.a.c.b r13 = m.a(this.dayTime);
        r10.f22964a = this;
        r10.f22967d = 1;
        r11 = e.a(r8, r13, r10);
        if (r11 != r1) goto L17;
        return r1;
    L7:
        r10 = new a(this, r9);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        String r1 = this.dayTime;
        if (r1 == null) goto L5;
        TimeCondition r6 = new TimeCondition(r1, null, 0, 6, null);
    L7:
        return (Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin");
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r3) {
        o.e(r3, "condition");
        if (ZeusTransformUtils.instanceOf(r3, DayTimeCondition.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.dayTime, ((DayTimeCondition) ZeusTransformUtils.preCheckCast(r3, DayTimeCondition.class, "com.obric.aiagent.plugin")).dayTime) == false) goto L7;
        return true;
    }
}
