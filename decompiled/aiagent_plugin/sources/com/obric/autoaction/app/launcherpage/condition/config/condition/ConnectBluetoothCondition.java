package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.util.ui.SpanFormatter;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectBluetoothCondition extends AutoCondition {
    public static final Parcelable.Creator<ConnectBluetoothCondition> CREATOR = null;
    private String address;
    private String name;

    /* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
    public static final class Creator implements Parcelable.Creator<ConnectBluetoothCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConnectBluetoothCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new ConnectBluetoothCondition(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectBluetoothCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConnectBluetoothCondition[] newArray(int r1) {
            return new ConnectBluetoothCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectBluetoothCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
    @d.c.b.a.f(b = "ConnectBluetoothCondition.kt", c = {34}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectBluetoothCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConnectBluetoothCondition f22958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22959d;

        a(ConnectBluetoothCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22958c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22957b = r3;
            this.f22959d |= Integer.MIN_VALUE;
            return this.f22958c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConnectBluetoothCondition() {
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
        r1.writeString(this.name);
        r1.writeString(this.address);
    }

    public /* synthetic */ ConnectBluetoothCondition(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public ConnectBluetoothCondition(String r8, String r9) {
        super(GroupInfo.Companion.c(), false, false, 6, null);
        this.name = r8;
        this.address = r9;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r6, View r7, d.c.d<? super Boolean> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if ((r0.f22959d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22959d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f22957b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f22959d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ConnectBluetoothCondition this = (ConnectBluetoothCondition) ZeusTransformUtils.preCheckCast(r0.f22956a, ConnectBluetoothCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        d.m r12 = (d.m) ZeusTransformUtils.preCheckCast(r11, d.m.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L24;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.a(), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L24;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L29;
        this.name = (String) ZeusTransformUtils.preCheckCast(r12.a(), String.class, "com.obric.aiagent.plugin");
        this.address = (String) ZeusTransformUtils.preCheckCast(r12.b(), String.class, "com.obric.aiagent.plugin");
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
        String r15 = this.name;
        String r4 = this.address;
        r0.f22956a = this;
        r0.f22959d = 1;
        r11 = c.a(r9, r15, r4, r7, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new a(this, r10);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (r13 != 1) goto L5;
        String r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_bluetooth_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_bluetooth_template_sentence"));
    L6:
        o.a(r14);
        SpanFormatter.Companion r9 = SpanFormatter.f31572a;
        Spannable[] r15 = new Spannable[1];
        String r3 = this.name;
        if (r3 != null) goto L9;
        String r0 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_default_bluetooth_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_bluetooth_name"));
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
        r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_template"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_connect_to_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_connect_to_template_sentence"));
        o.c(r0, "getString(...)");
        SpanFormatter.Companion r4 = SpanFormatter.f31572a;
        Spannable[] r5 = new Spannable[1];
        String r6 = this.name;
        if (r6 != null) goto L6;
        r6 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_default_bluetooth_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_default_bluetooth_name"));
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
        String r0 = this.name;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Condition) ZeusTransformUtils.preCheckCast(new BluetoothCondition(r0, this.address), Condition.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r5) {
        o.e(r5, "condition");
        if (ZeusTransformUtils.instanceOf(r5, ConnectBluetoothCondition.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (o.a(this.name, ((ConnectBluetoothCondition) ZeusTransformUtils.preCheckCast(r5, ConnectBluetoothCondition.class, "com.obric.aiagent.plugin")).name) == false) goto L9;
        if (o.a(this.address, ((ConnectBluetoothCondition) ZeusTransformUtils.preCheckCast(r5, ConnectBluetoothCondition.class, "com.obric.aiagent.plugin")).address) == false) goto L9;
        return true;
    }
}
