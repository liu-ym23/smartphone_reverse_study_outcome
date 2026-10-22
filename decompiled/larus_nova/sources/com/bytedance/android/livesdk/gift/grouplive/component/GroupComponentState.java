package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.common.wschannel.WsConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class GroupComponentState extends MVIState<GroupComponentState> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126272j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f126273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f126274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f126275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f126276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f126277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f126278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f126279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f126280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f126281i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Mode;", "", "", "value", "I", "getValue", "()I", "EXPAND", "CLOSE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        public static final Mode CLOSE = null;
        public static final Mode EXPAND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f126282a = null;
        private final int value;

        static {
            Mode r100 = new Mode("EXPAND", 0, 1);
            EXPAND = r100;
            Mode r101 = new Mode("CLOSE", 1, 0);
            CLOSE = r101;
            f126282a = new Mode[]{r100, r101};
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) f126282a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Style;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "HORIZONTAL", "VERTICAL", "DEFAULT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style DEFAULT = null;
        public static final Style HORIZONTAL = null;
        public static final Style VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f126283a = null;
        private final String value;

        static {
            Style r100 = new Style("HORIZONTAL", 0, "horizontal");
            HORIZONTAL = r100;
            Style r101 = new Style("VERTICAL", 1, "vertical");
            VERTICAL = r101;
            Style r102 = new Style("DEFAULT", 2, "default");
            DEFAULT = r102;
            f126283a = new Style[]{r100, r101, r102};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f126283a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Style(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f126272j = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "enableDrag", "getEnableDrag()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "showStyle", "getShowStyle()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "position", "getPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "showUrl", "getShowUrl()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, WsConstants.KEY_PAYLOAD, "getPayload()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "placeHolderHeight", "getPlaceHolderHeight()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, RemoteMessageConst.Notification.VISIBILITY, "getVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "isAnchorSide", "isAnchorSide()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public GroupComponentState() {
        Boolean r100 = Boolean.FALSE;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = f126272j;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.f126273a = r103;
        Style r105 = Style.DEFAULT;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r106 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r107 = this.propertyAddedCallback;
        r r108 = new r(r105, r106, r107);
        r108.f41672a = r104[1].getName();
        r107.invoke(r108);
        this.f126274b = r108;
        Mode r109 = Mode.EXPAND;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        r r112 = new r(r109, r110, r111);
        r112.f41672a = r104[2].getName();
        r111.invoke(r112);
        this.f126275c = r112;
        ty1.c r113 = new ty1.c(0);
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r114 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r115 = this.propertyAddedCallback;
        r r116 = new r(r113, r114, r115);
        r116.f41672a = r104[3].getName();
        r115.invoke(r116);
        this.f126276d = r116;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r117 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r118 = this.propertyAddedCallback;
        r r119 = new r("", r117, r118);
        r119.f41672a = r104[4].getName();
        r118.invoke(r119);
        this.f126277e = r119;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r120 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r121 = this.propertyAddedCallback;
        r r122 = new r("", r120, r121);
        r122.f41672a = r104[5].getName();
        r121.invoke(r122);
        this.f126278f = r122;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r123 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r124 = this.propertyAddedCallback;
        r r125 = new r(234, r123, r124);
        r125.f41672a = r104[6].getName();
        r124.invoke(r125);
        this.f126279g = r125;
        Boolean r126 = Boolean.TRUE;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r127 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r128 = this.propertyAddedCallback;
        r r129 = new r(r126, r127, r128);
        r129.f41672a = r104[7].getName();
        r128.invoke(r129);
        this.f126280h = r129;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r130 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r131 = this.propertyAddedCallback;
        r r132 = new r(r100, r130, r131);
        r132.f41672a = r104[8].getName();
        r131.invoke(r132);
        this.f126281i = r132;
    }
}
