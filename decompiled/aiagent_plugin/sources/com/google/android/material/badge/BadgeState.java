package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.g.c;
import com.google.android.material.g.d;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class BadgeState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f13199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final float f13200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final float f13201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final State f13202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final State f13203e;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = null;
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Integer backgroundColor;
        private Integer badgeGravity;
        private int badgeResId;
        private Integer badgeTextColor;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private int maxCharacterCount;
        private int number;
        private Locale numberLocale;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static /* synthetic */ int access$000(State r0) {
            return r0.badgeResId;
        }

        static /* synthetic */ int access$002(State r0, int r1) {
            r0.badgeResId = r1;
            return r1;
        }

        static /* synthetic */ int access$100(State r0) {
            return r0.alpha;
        }

        static /* synthetic */ Integer access$1000(State r0) {
            return r0.badgeGravity;
        }

        static /* synthetic */ Integer access$1002(State r0, Integer r1) {
            r0.badgeGravity = r1;
            return r1;
        }

        static /* synthetic */ int access$102(State r0, int r1) {
            r0.alpha = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1100(State r0) {
            return r0.horizontalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1102(State r0, Integer r1) {
            r0.horizontalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1200(State r0) {
            return r0.verticalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1202(State r0, Integer r1) {
            r0.verticalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1300(State r0) {
            return r0.horizontalOffsetWithText;
        }

        static /* synthetic */ Integer access$1302(State r0, Integer r1) {
            r0.horizontalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1400(State r0) {
            return r0.verticalOffsetWithText;
        }

        static /* synthetic */ Integer access$1402(State r0, Integer r1) {
            r0.verticalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1500(State r0) {
            return r0.additionalHorizontalOffset;
        }

        static /* synthetic */ Integer access$1502(State r0, Integer r1) {
            r0.additionalHorizontalOffset = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1600(State r0) {
            return r0.additionalVerticalOffset;
        }

        static /* synthetic */ Integer access$1602(State r0, Integer r1) {
            r0.additionalVerticalOffset = r1;
            return r1;
        }

        static /* synthetic */ Locale access$1700(State r0) {
            return r0.numberLocale;
        }

        static /* synthetic */ Locale access$1702(State r0, Locale r1) {
            r0.numberLocale = r1;
            return r1;
        }

        static /* synthetic */ CharSequence access$200(State r0) {
            return r0.contentDescriptionNumberless;
        }

        static /* synthetic */ CharSequence access$202(State r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            r2.contentDescriptionNumberless = r4;
            return r4;
        }

        static /* synthetic */ int access$300(State r0) {
            return r0.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$302(State r0, int r1) {
            r0.contentDescriptionQuantityStrings = r1;
            return r1;
        }

        static /* synthetic */ int access$400(State r0) {
            return r0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$402(State r0, int r1) {
            r0.contentDescriptionExceedsMaxBadgeNumberRes = r1;
            return r1;
        }

        static /* synthetic */ Boolean access$500(State r0) {
            return r0.isVisible;
        }

        static /* synthetic */ Boolean access$502(State r0, Boolean r1) {
            r0.isVisible = r1;
            return r1;
        }

        static /* synthetic */ int access$600(State r0) {
            return r0.maxCharacterCount;
        }

        static /* synthetic */ int access$602(State r0, int r1) {
            r0.maxCharacterCount = r1;
            return r1;
        }

        static /* synthetic */ int access$700(State r0) {
            return r0.number;
        }

        static /* synthetic */ int access$702(State r0, int r1) {
            r0.number = r1;
            return r1;
        }

        static /* synthetic */ Integer access$800(State r0) {
            return r0.backgroundColor;
        }

        static /* synthetic */ Integer access$802(State r0, Integer r1) {
            r0.backgroundColor = r1;
            return r1;
        }

        static /* synthetic */ Integer access$900(State r0) {
            return r0.badgeTextColor;
        }

        static /* synthetic */ Integer access$902(State r0, Integer r1) {
            r0.badgeTextColor = r1;
            return r1;
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
        }

        State(Parcel r4) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
            this.badgeResId = r4.readInt();
            this.backgroundColor = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.badgeTextColor = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.alpha = r4.readInt();
            this.number = r4.readInt();
            this.maxCharacterCount = r4.readInt();
            this.contentDescriptionNumberless = r4.readString();
            this.contentDescriptionQuantityStrings = r4.readInt();
            this.badgeGravity = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.horizontalOffsetWithoutText = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.verticalOffsetWithoutText = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.horizontalOffsetWithText = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.verticalOffsetWithText = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.additionalHorizontalOffset = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.additionalVerticalOffset = (Integer) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Integer.class, "com.obric.aiagent.plugin");
            this.isVisible = (Boolean) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Boolean.class, "com.obric.aiagent.plugin");
            this.numberLocale = (Locale) ZeusTransformUtils.preCheckCast(r4.readSerializable(), Locale.class, "com.obric.aiagent.plugin");
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.badgeResId);
            r1.writeSerializable(this.backgroundColor);
            r1.writeSerializable(this.badgeTextColor);
            r1.writeInt(this.alpha);
            r1.writeInt(this.number);
            r1.writeInt(this.maxCharacterCount);
            CharSequence r3 = this.contentDescriptionNumberless;
            if (r3 != null) goto L5;
            String r4 = null;
        L6:
            r1.writeString(r4);
            r1.writeInt(this.contentDescriptionQuantityStrings);
            r1.writeSerializable(this.badgeGravity);
            r1.writeSerializable(this.horizontalOffsetWithoutText);
            r1.writeSerializable(this.verticalOffsetWithoutText);
            r1.writeSerializable(this.horizontalOffsetWithText);
            r1.writeSerializable(this.verticalOffsetWithText);
            r1.writeSerializable(this.additionalHorizontalOffset);
            r1.writeSerializable(this.additionalVerticalOffset);
            r1.writeSerializable(this.isVisible);
            r1.writeSerializable(this.numberLocale);
            return;
        L5:
            r4 = r3.toString();
            goto L6
        }
    }

    BadgeState(Context r6, int r7, int r8, int r9, State r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        State r0 = new State();
        this.f13203e = r0;
        if (r10 != null) goto L5;
        r10 = new State();
    L5:
        if (r7 == 0) goto L7;
        State.access$002(r10, r7);
    L7:
        TypedArray r12 = a(r11, State.access$000(r10), r8, r9);
        Resources r13 = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin");
        this.f13199a = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Badge_badgeRadius, "styleable", "Badge_badgeRadius"), r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_badge_radius, "dimen", "mtrl_badge_radius")));
        this.f13201c = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Badge_badgeWidePadding, "styleable", "Badge_badgeWidePadding"), r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_badge_long_text_horizontal_padding, "dimen", "mtrl_badge_long_text_horizontal_padding")));
        this.f13200b = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Badge_badgeWithTextRadius, "styleable", "Badge_badgeWithTextRadius"), r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_badge_with_text_radius, "dimen", "mtrl_badge_with_text_radius")));
        if (State.access$100(r10) != (-2)) goto L10;
        int r14 = 255;
    L11:
        State.access$102(r0, r14);
        if (State.access$200(r10) != null) goto L14;
        CharSequence r15 = r11.getString(ZeusTransformUtils.mapRes(R.string.mtrl_badge_numberless_content_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_badge_numberless_content_description"));
    L15:
        State.access$202(r0, r15);
        if (State.access$300(r10) != 0) goto L18;
        int r16 = ZeusTransformUtils.mapRes(R.plurals.mtrl_badge_content_description, "plurals", "mtrl_badge_content_description");
    L19:
        State.access$302(r0, r16);
        if (State.access$400(r10) != 0) goto L22;
        int r17 = ZeusTransformUtils.mapRes(R.string.mtrl_exceed_max_badge_number_content_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_exceed_max_badge_number_content_description");
    L23:
        State.access$402(r0, r17);
        int r2 = 0;
        if (State.access$500(r10) != null) goto L26;
    L29:
        boolean r18 = true;
    L30:
        State.access$502(r0, Boolean.valueOf(r18));
        if (State.access$600(r10) != (-2)) goto L33;
        int r19 = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.Badge_maxCharacterCount, "styleable", "Badge_maxCharacterCount"), 4);
    L34:
        State.access$602(r0, r19);
        if (State.access$700(r10) == (-2)) goto L38;
        State.access$702(r0, State.access$700(r10));
    L42:
        if (State.access$800(r10) != null) goto L44;
        int r20 = a(r11, r12, ZeusTransformUtils.mapRes(R.styleable.Badge_backgroundColor, "styleable", "Badge_backgroundColor"));
    L45:
        State.access$802(r0, Integer.valueOf(r20));
        if (State.access$900(r10) == null) goto L49;
        State.access$902(r0, State.access$900(r10));
    L53:
        if (State.access$1000(r10) != null) goto L55;
        int r21 = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.Badge_badgeGravity, "styleable", "Badge_badgeGravity"), 8388661);
    L56:
        State.access$1002(r0, Integer.valueOf(r21));
        if (State.access$1100(r10) != null) goto L59;
        int r22 = r12.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.Badge_horizontalOffset, "styleable", "Badge_horizontalOffset"), 0);
    L60:
        State.access$1102(r0, Integer.valueOf(r22));
        if (State.access$1100(r10) != null) goto L63;
        int r23 = r12.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.Badge_verticalOffset, "styleable", "Badge_verticalOffset"), 0);
    L64:
        State.access$1202(r0, Integer.valueOf(r23));
        if (State.access$1300(r10) != null) goto L67;
        int r24 = r12.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.Badge_horizontalOffsetWithText, "styleable", "Badge_horizontalOffsetWithText"), State.access$1100(r0).intValue());
    L68:
        State.access$1302(r0, Integer.valueOf(r24));
        if (State.access$1400(r10) != null) goto L71;
        int r25 = r12.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.Badge_verticalOffsetWithText, "styleable", "Badge_verticalOffsetWithText"), State.access$1200(r0).intValue());
    L72:
        State.access$1402(r0, Integer.valueOf(r25));
        if (State.access$1500(r10) != null) goto L75;
        int r26 = 0;
    L76:
        State.access$1502(r0, Integer.valueOf(r26));
        if (State.access$1600(r10) == null) goto L80;
        r2 = State.access$1600(r10).intValue();
    L80:
        State.access$1602(r0, Integer.valueOf(r2));
        r12.recycle();
        if (State.access$1700(r10) == null) goto L83;
        State.access$1702(r0, State.access$1700(r10));
    L88:
        this.f13202d = r10;
        return;
    L83:
        if (Build.VERSION.SDK_INT < 24) goto L85;
        Locale r27 = Locale.getDefault(Locale.Category.FORMAT);
    L86:
        State.access$1702(r0, r27);
        goto L88
    L85:
        r27 = Locale.getDefault();
        goto L86
    L75:
        r26 = State.access$1500(r10).intValue();
        goto L76
    L71:
        r25 = State.access$1400(r10).intValue();
        goto L72
    L67:
        r24 = State.access$1300(r10).intValue();
        goto L68
    L63:
        r23 = State.access$1200(r10).intValue();
        goto L64
    L59:
        r22 = State.access$1100(r10).intValue();
        goto L60
    L55:
        r21 = State.access$1000(r10).intValue();
        goto L56
    L49:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.Badge_badgeTextColor, "styleable", "Badge_badgeTextColor")) == false) goto L51;
        State.access$902(r0, Integer.valueOf(a(r11, r12, ZeusTransformUtils.mapRes(R.styleable.Badge_badgeTextColor, "styleable", "Badge_badgeTextColor"))));
        goto L53
    L51:
        State.access$902(r0, Integer.valueOf(new d(r11, ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialComponents_Badge, "style", "TextAppearance_MaterialComponents_Badge")).b().getDefaultColor()));
        goto L53
    L44:
        r20 = State.access$800(r10).intValue();
        goto L45
    L38:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.Badge_number, "styleable", "Badge_number")) == false) goto L40;
        State.access$702(r0, r12.getInt(ZeusTransformUtils.mapRes(R.styleable.Badge_number, "styleable", "Badge_number"), 0));
        goto L42
    L40:
        State.access$702(r0, -1);
        goto L42
    L33:
        r19 = State.access$600(r10);
        goto L34
    L26:
        if (State.access$500(r10).booleanValue() == true) goto L29;
        r18 = false;
        goto L30
    L22:
        r17 = State.access$400(r10);
        goto L23
    L18:
        r16 = State.access$300(r10);
        goto L19
    L14:
        r15 = State.access$200(r10);
        goto L15
    L10:
        r14 = State.access$100(r10);
        goto L11
    }

    private TypedArray a(Context r7, int r8, int r9, int r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (r8 == 0) goto L5;
        AttributeSet r11 = com.google.android.material.b.a.a(r0, r8, "badge");
        int r12 = r11.getStyleAttribute();
    L6:
        AttributeSet r1 = r11;
        if (r12 != 0) goto L9;
        int r4 = r10;
    L11:
        return l.a(r0, r1, R.styleable.Badge, r9, r4, new int[0]);
    L9:
        r4 = r12;
        goto L11
    L5:
        r11 = null;
        r12 = 0;
        goto L6
    }

    State a() {
        return this.f13202d;
    }

    boolean b() {
        return State.access$500(this.f13203e).booleanValue();
    }

    void a(boolean r3) {
        State.access$502(this.f13202d, Boolean.valueOf(r3));
        State.access$502(this.f13203e, Boolean.valueOf(r3));
    }

    boolean c() {
        if (State.access$700(this.f13203e) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    int d() {
        return State.access$700(this.f13203e);
    }

    void a(int r2) {
        State.access$702(this.f13202d, r2);
        State.access$702(this.f13203e, r2);
    }

    void e() {
        a(-1);
    }

    int f() {
        return State.access$100(this.f13203e);
    }

    void b(int r2) {
        State.access$102(this.f13202d, r2);
        State.access$102(this.f13203e, r2);
    }

    int g() {
        return State.access$600(this.f13203e);
    }

    void c(int r2) {
        State.access$602(this.f13202d, r2);
        State.access$602(this.f13203e, r2);
    }

    int h() {
        return State.access$800(this.f13203e).intValue();
    }

    void d(int r3) {
        State.access$802(this.f13202d, Integer.valueOf(r3));
        State.access$802(this.f13203e, Integer.valueOf(r3));
    }

    int i() {
        return State.access$900(this.f13203e).intValue();
    }

    void e(int r3) {
        State.access$902(this.f13202d, Integer.valueOf(r3));
        State.access$902(this.f13203e, Integer.valueOf(r3));
    }

    int j() {
        return State.access$1000(this.f13203e).intValue();
    }

    void f(int r3) {
        State.access$1002(this.f13202d, Integer.valueOf(r3));
        State.access$1002(this.f13203e, Integer.valueOf(r3));
    }

    int k() {
        return State.access$1100(this.f13203e).intValue();
    }

    void g(int r3) {
        State.access$1102(this.f13202d, Integer.valueOf(r3));
        State.access$1102(this.f13203e, Integer.valueOf(r3));
    }

    int l() {
        return State.access$1200(this.f13203e).intValue();
    }

    void h(int r3) {
        State.access$1202(this.f13202d, Integer.valueOf(r3));
        State.access$1202(this.f13203e, Integer.valueOf(r3));
    }

    int m() {
        return State.access$1300(this.f13203e).intValue();
    }

    void i(int r3) {
        State.access$1302(this.f13202d, Integer.valueOf(r3));
        State.access$1302(this.f13203e, Integer.valueOf(r3));
    }

    int n() {
        return State.access$1400(this.f13203e).intValue();
    }

    void j(int r3) {
        State.access$1402(this.f13202d, Integer.valueOf(r3));
        State.access$1402(this.f13203e, Integer.valueOf(r3));
    }

    int o() {
        return State.access$1500(this.f13203e).intValue();
    }

    void k(int r3) {
        State.access$1502(this.f13202d, Integer.valueOf(r3));
        State.access$1502(this.f13203e, Integer.valueOf(r3));
    }

    int p() {
        return State.access$1600(this.f13203e).intValue();
    }

    void l(int r3) {
        State.access$1602(this.f13202d, Integer.valueOf(r3));
        State.access$1602(this.f13203e, Integer.valueOf(r3));
    }

    CharSequence q() {
        return State.access$200(this.f13203e);
    }

    void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        State.access$202(this.f13202d, r4);
        State.access$202(this.f13203e, r4);
    }

    int r() {
        return State.access$300(this.f13203e);
    }

    void m(int r2) {
        State.access$302(this.f13202d, r2);
        State.access$302(this.f13203e, r2);
    }

    int s() {
        return State.access$400(this.f13203e);
    }

    void n(int r2) {
        State.access$402(this.f13202d, r2);
        State.access$402(this.f13203e, r2);
    }

    Locale t() {
        return State.access$1700(this.f13203e);
    }

    void a(Locale r2) {
        State.access$1702(this.f13202d, r2);
        State.access$1702(this.f13203e, r2);
    }

    private static int a(Context r2, TypedArray r3, int r4) {
        return c.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4).getDefaultColor();
    }
}
