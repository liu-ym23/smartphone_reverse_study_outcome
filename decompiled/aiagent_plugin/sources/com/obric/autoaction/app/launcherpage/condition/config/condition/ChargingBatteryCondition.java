package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.util.ui.SpanFormatter;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ChargingBatteryCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ChargingBatteryCondition extends AutoCondition {
    public static final Parcelable.Creator<ChargingBatteryCondition> CREATOR = null;
    public static final a Companion = null;
    public static final int DEFAULT_PERCENT = 80;
    private Integer percent;

    /* JADX INFO: compiled from: ChargingBatteryCondition.kt */
    public static final class Creator implements Parcelable.Creator<ChargingBatteryCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChargingBatteryCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            if (r2.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            return new ChargingBatteryCondition(r3);
        L5:
            r3 = Integer.valueOf(r2.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ChargingBatteryCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChargingBatteryCondition[] newArray(int r1) {
            return new ChargingBatteryCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ChargingBatteryCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ChargingBatteryCondition.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ChargingBatteryCondition.kt */
    @d.c.b.a.f(b = "ChargingBatteryCondition.kt", c = {39}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.ChargingBatteryCondition")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChargingBatteryCondition f22954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22955d;

        b(ChargingBatteryCondition r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22954c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22953b = r3;
            this.f22955d |= Integer.MIN_VALUE;
            return this.f22954c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChargingBatteryCondition() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        Integer r0 = this.percent;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r1.writeInt(1);
        r3 = r0.intValue();
        goto L6
    }

    public /* synthetic */ ChargingBatteryCondition(Integer r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 80;
    L5:
        this(r1);
    }

    public final Integer getPercent() {
        return this.percent;
    }

    public final void setPercent(Integer r1) {
        this.percent = r1;
    }

    public ChargingBatteryCondition(Integer r8) {
        super(GroupInfo.Companion.c(), false, false, 6, null);
        this.percent = r8;
    }

    private final int getPercentWithDefault(int r1) {
        Integer r0 = this.percent;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.intValue();
    }

    static /* synthetic */ int getPercentWithDefault$default(ChargingBatteryCondition r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 80;
    L6:
        return r0.getPercentWithDefault(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r5, View r6, d.c.d<? super Boolean> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r10.f22955d & Integer.MIN_VALUE) == 0) goto L7;
        r10.f22955d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r10.f22953b;
        Object r1 = d.c.a.b.a();
        int r2 = r10.f22955d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ChargingBatteryCondition this = (ChargingBatteryCondition) ZeusTransformUtils.preCheckCast(r10.f22952a, ChargingBatteryCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L21:
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L26;
        this.percent = r12;
        return d.c.b.a.b.a(true);
    L26:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        Integer r13 = this.percent;
        if (r13 == null) goto L17;
        int r14 = r13.intValue();
    L18:
        r10.f22952a = this;
        r10.f22955d = 1;
        r11 = com.obric.autoaction.app.launcherpage.condition.config.condition.b.a(r8, r14, r10);
        if (r11 != r1) goto L21;
        return r1;
    L17:
        r14 = 80;
    L7:
        r10 = new b(this, r9);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (r13 != 1) goto L5;
        String r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_charging_battery_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_charging_battery_template_sentence"));
    L6:
        o.a(r14);
        SpanFormatter.Companion r15 = SpanFormatter.f31572a;
        Spannable[] r9 = new Spannable[1];
        String r3 = new StringBuilder().append(getPercentWithDefault$default(this, 0, 1, null)).append('%').toString();
        boolean r0 = getActive();
        GroupInfo r11 = getGroupInfo();
        if (r0 == false) goto L9;
        int r16 = r11.getActiveColor();
    L10:
        r9[0] = l.a(r2, r3, r16, null, null, 24, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r15.a(r14, r9), CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        r16 = r11.getDefaultColor();
        goto L10
    L5:
        r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_charging_battery_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_charging_battery_template"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_charging_battery_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_charging_battery_template_sentence"));
        o.c(r0, "getString(...)");
        SpanFormatter.Companion r2 = SpanFormatter.f31572a;
        Spannable[] r4 = new Spannable[1];
        String r3 = new StringBuilder().append(getPercentWithDefault$default(this, 0, 1, null)).append('%').toString();
        if (getActive() == false) goto L5;
        int r5 = getGroupInfo().getActiveColor();
    L6:
        boolean r7 = getActive();
        GroupInfo r8 = getGroupInfo();
        if (r7 == false) goto L9;
        int r12 = r8.getActiveSpanTextWeight();
    L10:
        r4[0] = l.a(r11, r3, r5, Integer.valueOf(r12), Integer.valueOf(r10));
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(r0, r4), CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        r12 = r8.getDefaultSpanTextWeight();
        goto L10
    L5:
        r5 = getGroupInfo().getDefaultColor();
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        Integer r3 = this.percent;
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return (Condition) ZeusTransformUtils.preCheckCast(new BatteryCondition(r4, true), Condition.class, "com.obric.aiagent.plugin");
    L5:
        r4 = 80;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r3) {
        o.e(r3, "condition");
        if (ZeusTransformUtils.instanceOf(r3, ChargingBatteryCondition.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.percent, ((ChargingBatteryCondition) ZeusTransformUtils.preCheckCast(r3, ChargingBatteryCondition.class, "com.obric.aiagent.plugin")).percent) == false) goto L7;
        return true;
    }
}
