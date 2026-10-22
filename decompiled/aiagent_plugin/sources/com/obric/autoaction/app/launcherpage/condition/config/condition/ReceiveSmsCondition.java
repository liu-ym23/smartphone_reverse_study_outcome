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
import com.obric.eventkit.task.model.SmsCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ReceiveSmsCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReceiveSmsCondition extends AutoCondition {
    public static final Parcelable.Creator<ReceiveSmsCondition> CREATOR = null;
    private String categoryType;

    /* JADX INFO: compiled from: ReceiveSmsCondition.kt */
    public static final class Creator implements Parcelable.Creator<ReceiveSmsCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReceiveSmsCondition createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new ReceiveSmsCondition(r1.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ReceiveSmsCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReceiveSmsCondition[] newArray(int r1) {
            return new ReceiveSmsCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ReceiveSmsCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ReceiveSmsCondition.kt */
    @d.c.b.a.f(b = "ReceiveSmsCondition.kt", c = {41}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.ReceiveSmsCondition")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReceiveSmsCondition f22993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22994d;

        a(ReceiveSmsCondition r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22993c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22992b = r3;
            this.f22994d |= Integer.MIN_VALUE;
            return this.f22993c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReceiveSmsCondition() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.categoryType);
    }

    public /* synthetic */ ReceiveSmsCondition(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final void setCategoryType(String r1) {
        this.categoryType = r1;
    }

    public ReceiveSmsCondition(String r8) {
        super(GroupInfo.Companion.c(), false, false, 6, null);
        this.categoryType = r8;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r6, View r7, d.c.d<? super Boolean> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if ((r0.f22994d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22994d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f22992b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f22994d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ReceiveSmsCondition this = (ReceiveSmsCondition) ZeusTransformUtils.preCheckCast(r0.f22991a, ReceiveSmsCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L20;
    L23:
        boolean r14 = true;
    L24:
        if (r14 == true) goto L28;
        this.categoryType = r12;
        return d.c.b.a.b.a(true);
    L28:
        return d.c.b.a.b.a(false);
    L20:
        if (r13.length() == 0) goto L23;
        r14 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        String r15 = this.categoryType;
        r0.f22991a = this;
        r0.f22994d = 1;
        r11 = k.a(r9, r15, r7, r0);
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
        String r3 = resolveCategoryName(r2, this.categoryType);
        if (r12 != 1) goto L5;
        String r13 = r2.getString(ZeusTransformUtils.mapRes(R.string.sms_condition_receive_single, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_condition_receive_single"));
    L6:
        o.a(r13);
        return (CharSequence) ZeusTransformUtils.preCheckCast(SpanFormatter.f31572a.a(r13, new Spannable[]{l.a(r2, r3, getGroupInfo().getActiveColor(), null, null, 24, null)}), CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        r13 = r2.getString(ZeusTransformUtils.mapRes(R.string.sms_condition_receive_multi, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_condition_receive_multi"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        String r0 = resolveCategoryName(r10, this.categoryType);
        String r2 = r10.getString(ZeusTransformUtils.mapRes(R.string.sms_condition_ellipsis, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_condition_ellipsis"));
        o.c(r2, "getString(...)");
        SpanFormatter.Companion r3 = SpanFormatter.f31572a;
        Spannable[] r4 = new Spannable[1];
        if (getActive() == false) goto L5;
        int r5 = getGroupInfo().getActiveColor();
    L6:
        boolean r6 = getActive();
        GroupInfo r7 = getGroupInfo();
        if (r6 == false) goto L9;
        int r11 = r7.getActiveSpanTextWeight();
    L10:
        r4[0] = l.a(r10, r0, r5, Integer.valueOf(r11), Integer.valueOf(r9));
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.a(r2, r4), CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        r11 = r7.getDefaultSpanTextWeight();
        goto L10
    L5:
        r5 = getGroupInfo().getDefaultColor();
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Condition buildCondition() {
        String r1 = this.categoryType;
        if (r1 != null) goto L6;
        return null;
    L6:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a().get(r1), String.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        return (Condition) ZeusTransformUtils.preCheckCast(new SmsCondition(r1, r0, null, 4, null), Condition.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r3) {
        o.e(r3, "condition");
        if (ZeusTransformUtils.instanceOf(r3, ReceiveSmsCondition.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.categoryType, ((ReceiveSmsCondition) ZeusTransformUtils.preCheckCast(r3, ReceiveSmsCondition.class, "com.obric.aiagent.plugin")).categoryType) == false) goto L7;
        return true;
    }

    private final String resolveCategoryName(Context r6, String r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        String r8 = r5.getString(ZeusTransformUtils.mapRes(R.string.sms_condition_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_condition_type"));
        o.c(r8, "getString(...)");
        return r8;
    L6:
        String r3 = (String) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a().get(r7), String.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return r3;
    L15:
        String r9 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.a(r7);
        if (r9 != null) goto L19;
        String r10 = r5.getString(ZeusTransformUtils.mapRes(R.string.sms_condition_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_condition_type"));
        o.c(r10, "getString(...)");
        return r10;
    L19:
        return r9;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }
}
