package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.view.View;
import androidx.activity.ComponentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationItemData;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.util.ui.SpanFormatter;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ExitLocationCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExitLocationCondition extends AutoCondition implements g {
    public static final Parcelable.Creator<ExitLocationCondition> CREATOR = null;
    private String geofenceName;
    private Double latitude;
    private Integer locationType;
    private Double longitude;

    /* JADX INFO: compiled from: ExitLocationCondition.kt */
    public static final class Creator implements Parcelable.Creator<ExitLocationCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExitLocationCondition createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            String r0 = r7.readString();
            Double r2 = null;
            if (r7.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r7.readInt() != 0) goto L9;
            Double r3 = null;
        L11:
            if (r7.readInt() == 0) goto L15;
            r2 = Double.valueOf(r7.readDouble());
        L15:
            return new ExitLocationCondition(r0, r1, r3, r2);
        L9:
            r3 = Double.valueOf(r7.readDouble());
            goto L11
        L5:
            r1 = Integer.valueOf(r7.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExitLocationCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExitLocationCondition[] newArray(int r1) {
            return new ExitLocationCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExitLocationCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ExitLocationCondition.kt */
    @d.c.b.a.f(b = "ExitLocationCondition.kt", c = {86}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.ExitLocationCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExitLocationCondition f22981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22982d;

        a(ExitLocationCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22981c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22980b = r3;
            this.f22982d |= Integer.MIN_VALUE;
            return this.f22981c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ExitLocationCondition() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: renamed from: lambda$ft77iTOH1IL3Gpc-Iv7E8G8aUko, reason: not valid java name */
    public static /* synthetic */ String m451lambda$ft77iTOH1IL3GpcIv7E8G8aUko() {
        return updateCondition$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$uYv4gNQzs4I-O613pZSADgvYiIE, reason: not valid java name */
    public static /* synthetic */ String m452lambda$uYv4gNQzs4IO613pZSADgvYiIE(ConditionLocationItemData r0) {
        return updateCondition$lambda$0(r0);
    }

    private static final String updateCondition$lambda$1() {
        return "onResult:";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeString(this.geofenceName);
        Integer r7 = this.locationType;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Double r8 = this.longitude;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Double r4 = this.latitude;
        if (r4 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeDouble(r4.doubleValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeDouble(r8.doubleValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L6
    }

    public /* synthetic */ ExitLocationCondition(String r2, Integer r3, Double r4, Double r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public String getGeofenceName() {
        return this.geofenceName;
    }

    public void setGeofenceName(String r1) {
        this.geofenceName = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
    public Integer getLocationType() {
        return this.locationType;
    }

    public void setLocationType(Integer r1) {
        this.locationType = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double r1) {
        this.longitude = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double r1) {
        this.latitude = r1;
    }

    public ExitLocationCondition(String r8, Integer r9, Double r10, Double r11) {
        super(GroupInfo.Companion.b(), false, false, 6, null);
        this.geofenceName = r8;
        this.locationType = r9;
        this.longitude = r10;
        this.latitude = r11;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (r13 != 1) goto L5;
        String r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_exit_location_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_exit_location_template_sentence"));
    L6:
        o.a(r14);
        SpanFormatter.Companion r9 = SpanFormatter.f31572a;
        Spannable[] r15 = new Spannable[1];
        String r3 = getGeofenceName();
        if (r3 != null) goto L9;
        String r0 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_default_home_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_home_location"));
        o.c(r0, "getString(...)");
        r3 = r0;
    L9:
        boolean r1 = getActive();
        GroupInfo r11 = getGroupInfo();
        if (r1 == false) goto L12;
        int r16 = r11.getActiveColor();
    L13:
        r15[0] = l.a(r2, r3, r16, null, null, 24, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r9.a(r14, r15), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r16 = r11.getDefaultColor();
        goto L13
    L5:
        r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_exit_location_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_exit_location_template"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_exit_location_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_exit_location_template_sentence"));
        o.c(r0, "getString(...)");
        SpanFormatter.Companion r4 = SpanFormatter.f31572a;
        Spannable[] r5 = new Spannable[1];
        String r6 = getGeofenceName();
        if (r6 != null) goto L6;
        r6 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_default_home_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_home_location"));
        o.c(r6, "getString(...)");
    L6:
        if (getActive() == false) goto L8;
        int r2 = getGroupInfo().getActiveColor();
    L9:
        boolean r3 = getActive();
        GroupInfo r8 = getGroupInfo();
        if (r3 == false) goto L12;
        int r12 = r8.getActiveSpanTextWeight();
    L13:
        r5[0] = l.a(r11, r6, r2, Integer.valueOf(r12), Integer.valueOf(r10));
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(r0, r5), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r12 = r8.getDefaultSpanTextWeight();
        goto L13
    L8:
        r2 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        Integer r0 = getLocationType();
        if (r0 != null) goto L6;
    L7:
        Integer r1 = getLocationType();
        if (r1 != null) goto L11;
    L13:
        String r2 = "geo_radius";
    L15:
        String r3 = r2;
        Integer r4 = getLocationType();
        if (r4 != null) goto L19;
    L22:
        Integer r5 = getLocationType();
        if (r5 != null) goto L26;
    L28:
        String r6 = null;
    L21:
        String r9 = r6;
        return (Condition) ZeusTransformUtils.preCheckCast(new LocationCondition(r3, "outside", getLongitude(), getLatitude(), Integer.valueOf(ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION), getGeofenceName(), r9), Condition.class, "com.obric.aiagent.plugin");
    L26:
        if (r5.intValue() != 1) goto L28;
        r6 = "company";
        goto L21
    L19:
        if (r4.intValue() != 0) goto L22;
        r6 = "home";
        goto L21
    L11:
        if (r1.intValue() != 1) goto L13;
    L14:
        r2 = "place_alias";
        goto L15
    L6:
        if (r0.intValue() == 0) goto L14;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r7, View r8, d.c.d<? super Boolean> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if ((r12.f22982d & Integer.MIN_VALUE) == 0) goto L7;
        r12.f22982d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r12.f22980b;
        Object r1 = d.c.a.b.a();
        int r2 = r12.f22982d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ExitLocationCondition this = (ExitLocationCondition) ZeusTransformUtils.preCheckCast(r12.f22979a, ExitLocationCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L21:
        final ConditionLocationItemData r14 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r13, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.dp("ExitLocationCondition", new $$Lambda$ExitLocationCondition$uYv4gNQzs4IO613pZSADgvYiIE(r14), $$Lambda$ExitLocationCondition$ft77iTOH1IL3GpcIv7E8G8aUko.INSTANCE);
        if (r14 == null) goto L24;
        this.setLongitude(d.c.b.a.b.a(r14.getLongitude()));
        this.setLatitude(d.c.b.a.b.a(r14.getLatitude()));
        this.setGeofenceName(r14.getName());
        this.setLocationType(d.c.b.a.b.a(r14.getType()));
        return d.c.b.a.b.a(true);
    L24:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        if (h.f23036a.a(r10) == false) goto L17;
        com.obric.autoaction.app.launcherpage.condition.location.c.a r15 = com.obric.autoaction.app.launcherpage.condition.location.c.f23130a;
        o.a(r10, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity r16 = (ComponentActivity) ZeusTransformUtils.preCheckCast(r10, ComponentActivity.class, "com.obric.aiagent.plugin");
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");
        r12.f22979a = this;
        r12.f22982d = 1;
        r13 = r15.a(r16, "from", r3, r12);
        if (r13 != r1) goto L21;
        return r1;
    L17:
        return d.c.b.a.b.a(false);
    L7:
        r12 = new a(this, r11);
        goto L8
    }

    private static final String updateCondition$lambda$0(ConditionLocationItemData r2) {
        return "onResult: " + r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r5) {
        o.e(r5, "condition");
        if (ZeusTransformUtils.instanceOf(r5, ExitLocationCondition.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (o.a(getGeofenceName(), ((ExitLocationCondition) ZeusTransformUtils.preCheckCast(r5, ExitLocationCondition.class, "com.obric.aiagent.plugin")).getGeofenceName()) == false) goto L13;
        if (o.a(getLocationType(), ((ExitLocationCondition) ZeusTransformUtils.preCheckCast(r5, ExitLocationCondition.class, "com.obric.aiagent.plugin")).getLocationType()) == false) goto L13;
        if (o.a(getLongitude(), ((ExitLocationCondition) ZeusTransformUtils.preCheckCast(r5, ExitLocationCondition.class, "com.obric.aiagent.plugin")).getLongitude()) == false) goto L13;
        if (o.a(getLatitude(), ((ExitLocationCondition) ZeusTransformUtils.preCheckCast(r5, ExitLocationCondition.class, "com.obric.aiagent.plugin")).getLatitude()) == false) goto L13;
        return true;
    }
}
