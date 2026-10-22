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
import com.obric.eventkit.task.model.WifiCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConnectWifiCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectWifiCondition extends AutoCondition {
    public static final Parcelable.Creator<ConnectWifiCondition> CREATOR = null;
    private String bssid;
    private String ssid;

    /* JADX INFO: compiled from: ConnectWifiCondition.kt */
    public static final class Creator implements Parcelable.Creator<ConnectWifiCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConnectWifiCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new ConnectWifiCondition(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectWifiCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConnectWifiCondition[] newArray(int r1) {
            return new ConnectWifiCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectWifiCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ConnectWifiCondition.kt */
    @d.c.b.a.f(b = "ConnectWifiCondition.kt", c = {34}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectWifiCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConnectWifiCondition f22962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22963d;

        a(ConnectWifiCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22962c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22961b = r3;
            this.f22963d |= Integer.MIN_VALUE;
            return this.f22962c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConnectWifiCondition() {
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
        r1.writeString(this.ssid);
        r1.writeString(this.bssid);
    }

    public /* synthetic */ ConnectWifiCondition(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final void setSsid(String r1) {
        this.ssid = r1;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final void setBssid(String r1) {
        this.bssid = r1;
    }

    public ConnectWifiCondition(String r8, String r9) {
        super(GroupInfo.Companion.c(), false, false, 6, null);
        this.ssid = r8;
        this.bssid = r9;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r6, View r7, d.c.d<? super Boolean> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if ((r0.f22963d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22963d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f22961b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f22963d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ConnectWifiCondition this = (ConnectWifiCondition) ZeusTransformUtils.preCheckCast(r0.f22960a, ConnectWifiCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        com.obric.autoaction.app.launcherpage.api.b.b.C0492b r12 = (com.obric.autoaction.app.launcherpage.api.b.b.C0492b) ZeusTransformUtils.preCheckCast(r11, com.obric.autoaction.app.launcherpage.api.b.b.C0492b.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L24;
        String r13 = r12.a();
        if (r13 == null) goto L24;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L29;
        this.ssid = r12.a();
        this.bssid = r12.b();
        return d.c.b.a.b.a(true);
    L29:
        return d.c.b.a.b.a(false);
    L24:
        r14 = false;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        String r15 = this.ssid;
        String r4 = this.bssid;
        r0.f22960a = this;
        r0.f22963d = 1;
        r11 = d.a(r9, r15, r4, r7, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new a(this, r10);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r11, int r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (r12 != 1) goto L5;
        String r13 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_wifi_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_wifi_template_sentence"));
    L6:
        o.a(r13);
        SpanFormatter.Companion r14 = SpanFormatter.f31572a;
        Spannable[] r0 = new Spannable[1];
        String r3 = this.ssid;
        if (r3 != null) goto L9;
        r3 = "WiFi";
    L9:
        boolean r4 = getActive();
        GroupInfo r10 = getGroupInfo();
        if (r4 == false) goto L12;
        int r15 = r10.getActiveColor();
    L13:
        r0[0] = l.a(r2, r3, r15, null, null, 24, null);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r14.a(r13, r0), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r15 = r10.getDefaultColor();
        goto L13
    L5:
        r13 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_template"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        String r0 = r10.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_to_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_to_template_sentence"));
        o.c(r0, "getString(...)");
        SpanFormatter.Companion r2 = SpanFormatter.f31572a;
        Spannable[] r3 = new Spannable[1];
        String r4 = this.ssid;
        if (r4 != null) goto L6;
        r4 = "WiFi";
    L6:
        if (getActive() == false) goto L8;
        int r5 = getGroupInfo().getActiveColor();
    L9:
        boolean r6 = getActive();
        GroupInfo r7 = getGroupInfo();
        if (r6 == false) goto L12;
        int r11 = r7.getActiveSpanTextWeight();
    L13:
        r3[0] = l.a(r10, r4, r5, Integer.valueOf(r11), Integer.valueOf(r9));
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(r0, r3), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r11 = r7.getDefaultSpanTextWeight();
        goto L13
    L8:
        r5 = getGroupInfo().getDefaultColor();
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        String r0 = this.ssid;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Condition) ZeusTransformUtils.preCheckCast(new WifiCondition(r0, this.bssid), Condition.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r5) {
        o.e(r5, "condition");
        if (ZeusTransformUtils.instanceOf(r5, ConnectWifiCondition.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (o.a(this.ssid, ((ConnectWifiCondition) ZeusTransformUtils.preCheckCast(r5, ConnectWifiCondition.class, "com.obric.aiagent.plugin")).ssid) == false) goto L9;
        if (o.a(this.bssid, ((ConnectWifiCondition) ZeusTransformUtils.preCheckCast(r5, ConnectWifiCondition.class, "com.obric.aiagent.plugin")).bssid) == false) goto L9;
        return true;
    }
}
