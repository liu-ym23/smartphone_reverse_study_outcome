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
import com.obric.eventkit.task.model.StorageCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LowStorageCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LowStorageCondition extends AutoCondition {
    public static final Parcelable.Creator<LowStorageCondition> CREATOR = null;
    public static final a Companion = null;
    public static final int DEFAULT_PERCENT = 30;
    private Integer percent;

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    public static final class Creator implements Parcelable.Creator<LowStorageCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LowStorageCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            if (r2.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            return new LowStorageCondition(r3);
        L5:
            r3 = Integer.valueOf(r2.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LowStorageCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LowStorageCondition[] newArray(int r1) {
            return new LowStorageCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LowStorageCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    @d.c.b.a.f(b = "LowStorageCondition.kt", c = {43}, d = "updateCondition", e = "com.obric.autoaction.app.launcherpage.condition.config.condition.LowStorageCondition")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LowStorageCondition f22985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22986d;

        b(LowStorageCondition r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22985c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22984b = r3;
            this.f22986d |= Integer.MIN_VALUE;
            return this.f22985c.updateCondition(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LowStorageCondition() {
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

    public /* synthetic */ LowStorageCondition(Integer r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Integer getPercent() {
        return this.percent;
    }

    public final void setPercent(Integer r1) {
        this.percent = r1;
    }

    public LowStorageCondition(Integer r8) {
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

    static /* synthetic */ int getPercentWithDefault$default(LowStorageCondition r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 30;
    L6:
        return r0.getPercentWithDefault(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public Object updateCondition(Context r6, View r7, d.c.d<? super Boolean> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r11.f22986d & Integer.MIN_VALUE) == 0) goto L7;
        r11.f22986d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r11.f22984b;
        Object r1 = d.c.a.b.a();
        int r2 = r11.f22986d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        LowStorageCondition this = (LowStorageCondition) ZeusTransformUtils.preCheckCast(r11.f22983a, LowStorageCondition.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L17:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L22;
        this.percent = r13;
        return d.c.b.a.b.a(true);
    L22:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        int r14 = getPercentWithDefault$default(this, 0, 1, null);
        r11.f22983a = this;
        r11.f22986d = 1;
        r12 = i.a(r9, r14, r11);
        if (r12 != r1) goto L17;
        return r1;
    L7:
        r11 = new b(this, r10);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayText(Context r12, int r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (r13 != 1) goto L5;
        String r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_low_storage_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_low_storage_template_sentence"));
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
        r14 = r2.getString(ZeusTransformUtils.mapRes(R.string.condition_low_storage_template_short, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_low_storage_template_short"));
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public CharSequence getDisplayEllipsizeText(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.string.condition_low_storage_template_sentence, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_low_storage_template_sentence"));
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
        Integer r0 = this.percent;
        if (r0 == null) goto L10;
        r0.intValue();
        Integer r2 = this.percent;
        if (r2 == null) goto L7;
        float r3 = r2.intValue();
    L9:
        return (Condition) ZeusTransformUtils.preCheckCast(new StorageCondition(r3), Condition.class, "com.obric.aiagent.plugin");
    L7:
        r3 = 0.0f;
        goto L9
    L10:
        return null;
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition
    public boolean isSame(AutoCondition r3) {
        o.e(r3, "condition");
        if (ZeusTransformUtils.instanceOf(r3, LowStorageCondition.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.percent, ((LowStorageCondition) ZeusTransformUtils.preCheckCast(r3, LowStorageCondition.class, "com.obric.aiagent.plugin")).percent) == false) goto L7;
        return true;
    }
}
