package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0004\u001bB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/CustomEllipsisPositionTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getEllipsisText", "()Ljava/lang/String;", "setEllipsisText", "(Ljava/lang/String;)V", "ellipsisText", "", "f", "Z", "getNeedCompat", "()Z", "setNeedCompat", "(Z)V", "needCompat", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "EllipsisMode", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomEllipsisPositionTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f148751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f148752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f148753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f148754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EllipsisMode f148755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f148756f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/CustomEllipsisPositionTextView$EllipsisMode;", "", UserProfileEvent.POSITION_NONE, EffectConstants.NORMAL, "FORWARD", "BACKWARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EllipsisMode extends Enum<EllipsisMode> {
        public static final EllipsisMode BACKWARD = null;
        public static final EllipsisMode FORWARD = null;
        public static final EllipsisMode NONE = null;
        public static final EllipsisMode NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EllipsisMode[] f148757a = null;

        static {
            EllipsisMode r100 = new EllipsisMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            EllipsisMode r101 = new EllipsisMode(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            EllipsisMode r102 = new EllipsisMode("FORWARD", 2);
            FORWARD = r102;
            EllipsisMode r103 = new EllipsisMode("BACKWARD", 3);
            BACKWARD = r103;
            f148757a = new EllipsisMode[]{r100, r101, r102, r103};
        }

        public static EllipsisMode valueOf(String r100) {
            return (EllipsisMode) r27.a.a(EllipsisMode.class, r100);
        }

        public static EllipsisMode[] values() {
            return (EllipsisMode[]) f148757a.clone();
        }

        public EllipsisMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public CustomEllipsisPositionTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomEllipsisPositionTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public String getEllipsisText() {
        return this.f148751a;
    }

    public final boolean getNeedCompat() {
        return this.f148756f;
    }

    public void setEllipsisText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f148751a = r100;
    }

    public final void setNeedCompat(boolean r100) {
        this.f148756f = r100;
    }

    public final void z(String r100, int r101) {
        dm.a.a("CustomEllipsisTextView").a("measuredText=" + r100 + ", viewWidth=" + r101);
        setText(r100);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        r102.width = r101;
        setLayoutParams(r102);
    }

    public CustomEllipsisPositionTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148751a = "…";
        this.f148755e = EllipsisMode.NONE;
    }

    public /* synthetic */ CustomEllipsisPositionTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        int r104 = com.bytedance.android.livesdk.livecommerce.iron.listheader.a.f148778a[this.f148755e.ordinal()];
        if (r104 != 1) goto L5;
        String r105 = this.f148754d;
        Integer r106 = this.f148752b;
        Integer r107 = this.f148753c;
        if (r105 == null) goto L52;
        if (r106 == null) goto L53;
        if (r107 == null) goto L54;
        r107.intValue();
        int r108 = r106.intValue();
        Intrinsics.checkNotNullParameter(r105, "text");
        this.f148752b = Integer.valueOf(r108);
        this.f148754d = r105;
        this.f148753c = Integer.valueOf(r100);
        this.f148755e = EllipsisMode.FORWARD;
        if (r100 > 0) goto L19;
        z(r105, 0);
    L19:
        float r109 = getPaint().measureText(r105);
        if (r108 >= 0) goto L26;
        if (this.f148756f == false) goto L24;
        x(r105, false, r100, false);
        return;
    L24:
        setEllipsize(TextUtils.TruncateAt.START);
        z(r105, r100);
        return;
    L26:
        if (r108 >= r105.length()) goto L28;
        setEllipsize(null);
        float r110 = r100;
        if (r109 > r110) goto L34;
        z(r105, r100);
        return;
    L34:
        String r111 = r105.substring(0, r108);
        String r112 = r105;
    L36:
        if (r109 <= r110) goto L40;
        if (r108 >= r105.length()) goto L40;
        r108 = r108 + 1;
        r112 = r111 + getEllipsisText() + r105.substring(r108, r105.length());
        r109 = getPaint().measureText(r112);
    L40:
        if (r109 <= r110) goto L42;
        setEllipsize(TextUtils.TruncateAt.END);
    L43:
        z(r105, r100);
        return;
    L42:
        r105 = r112;
        goto L43
    L28:
        if (this.f148756f == false) goto L30;
        x(r105, true, r100, false);
        return;
    L30:
        setEllipsize(TextUtils.TruncateAt.END);
        z(r105, r100);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        if (r104 == 2) goto L7;
        super.onSizeChanged(r100, r101, r102, r103);
        return;
    L7:
        String r113 = this.f148754d;
        Integer r114 = this.f148752b;
        Integer r115 = this.f148753c;
        if (r113 == null) goto L48;
        if (r114 == null) goto L49;
        if (r115 == null) goto L50;
        r115.intValue();
        y(r113, r114.intValue(), r100, false);
        return;
    L50:
        return;
    L49:
        return;
    }

    public final void x(String r100, boolean r101, int r102, boolean r110) {
        setEllipsize(null);
        float r103 = getPaint().measureText(r100);
        float r104 = r102;
        if (r103 > r104) goto L8;
        if (r110 == false) goto L6;
        r102 = Math.min((int) r103, r102);
    L6:
        z(r100, r102);
        return;
    L8:
        boolean r105 = false;
        if (r100.length() <= 0) goto L11;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L23;
        if (getPaint().measureText(r100 + "…") <= r104) goto L23;
        if (r101 == true) goto L17;
        if (r100 == null) goto L21;
        r100 = r100.substring(1);
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L17:
        r100 = r100.substring(0, r100.length() - 1);
    L23:
        if (r100.length() <= 0) goto L25;
        r105 = true;
    L25:
        if (r105 == false) goto L27;
        String r107 = r100 + "…";
    L28:
        float r108 = getPaint().measureText(r107);
        if (r110 == false) goto L31;
        r102 = Math.min((int) r108, r102);
    L31:
        z(r107, r102);
        return;
    L27:
        r107 = "";
        goto L28
    L11:
        r106 = false;
        goto L13
    }

    public final void y(String r100, int r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f148752b = Integer.valueOf(r101);
        this.f148754d = r100;
        this.f148753c = Integer.valueOf(r102);
        this.f148755e = EllipsisMode.BACKWARD;
        if (r102 > 0) goto L6;
        z(r100, 0);
        return;
    L6:
        float r103 = getPaint().measureText(r100);
        if (r101 >= 0) goto L18;
        if (this.f148756f == false) goto L12;
        x(r100, false, r102, r110);
        return;
    L12:
        setEllipsize(TextUtils.TruncateAt.START);
        if (r110 == false) goto L15;
        r102 = Math.min((int) r103, r102);
    L15:
        z(r100, r102);
        return;
    L18:
        if (r101 > r100.length()) goto L20;
        setEllipsize(null);
        float r104 = r102;
        if (r103 > r104) goto L34;
        if (r110 == false) goto L32;
        r102 = -2;
    L32:
        z(r100, r102);
        return;
    L34:
        int r105 = (r100.length() - r101) - 1;
        String r106 = r100.substring(r100.length() - r101, r100.length());
        String r107 = r100;
    L36:
        if (r103 <= r104) goto L39;
        if (r105 < 0) goto L39;
        r107 = r100.substring(0, r105) + getEllipsisText() + r106;
        r103 = getPaint().measureText(r107);
        r105 = r105 - 1;
    L39:
        if (r103 <= r104) goto L41;
        setEllipsize(TextUtils.TruncateAt.START);
    L42:
        if (r110 == false) goto L44;
        r102 = Math.min((int) r103, r102);
    L44:
        z(r100, r102);
        return;
    L41:
        r100 = r107;
        goto L42
    L20:
        if (this.f148756f == false) goto L23;
        x(r100, true, r102, r110);
        return;
    L23:
        setEllipsize(TextUtils.TruncateAt.END);
        if (r110 == false) goto L26;
        r102 = Math.min((int) r103, r102);
    L26:
        z(r100, r102);
    }
}
