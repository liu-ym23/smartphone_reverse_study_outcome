package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class PSHighlightRenderHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f133410a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133411b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f133412c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f133413d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f133414e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/PSHighlightRenderHelper$AnimType;", "", "None", "VerticalFadeSlide", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType None = null;
        public static final AnimType VerticalFadeSlide = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimType[] f133415a = null;

        static {
            AnimType r100 = new AnimType("None", 0);
            None = r100;
            AnimType r101 = new AnimType("VerticalFadeSlide", 1);
            VerticalFadeSlide = r101;
            f133415a = new AnimType[]{r100, r101};
        }

        public static AnimType valueOf(String r100) {
            return (AnimType) r27.a.a(AnimType.class, r100);
        }

        public static AnimType[] values() {
            return (AnimType[]) f133415a.clone();
        }

        public AnimType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(View r100);

        boolean b(View r100, ek6.c r101);
    }

    public PSHighlightRenderHelper() {
    }

    static {
        f133410a = UtilityKotlinExtentionsKt.i(100);
        f133411b = UtilityKotlinExtentionsKt.i(8);
        f133412c = UtilityKotlinExtentionsKt.i(3);
        f133413d = UtilityKotlinExtentionsKt.i(4);
        f133414e = LazyKt.lazy(PSHighlightRenderHelper$defaultSpanRendConfig$2.INSTANCE);
    }

    public static final float a(View r100) {
        int r101 = r100.getMeasuredHeight();
        if (r101 > 0) goto L6;
        r100.measure(View.MeasureSpec.makeMeasureSpec(s1.y(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(f133410a, Integer.MIN_VALUE));
        r101 = r100.getMeasuredHeight();
    L6:
        return r101;
    }

    @JvmStatic
    public static final void b(DataCenter r100, TextView r101) {
        com.bytedance.android.livesdk.interactivity.api.h r102 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r100, 0, 2), r100);
        if (r102 == null) goto L17;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r103 = r102.getPublicScreenContext();
        if (r103 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r104 = r103.getValue();
        if (r104 == null) goto L19;
        e52.a r105 = r104.getTextConfig();
        if (r105 == null) goto L20;
        g52.e r106 = r105.getTextConfig();
        if (r106 == null) goto L21;
        if (r101 == null) goto L14;
        int r107 = g52.e.f480020j;
        r106.a(r101, true);
    L14:
        if (r101 == null) goto L22;
        int r108 = f133411b;
        int r109 = f133412c;
        r101.setPadding(r108, r109, f133413d, r109);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @JvmStatic
    public static final q4.b c(final View r100, boolean r101, AnimType r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "animType");
        Intrinsics.checkNotNullParameter(r103, "onEnd");
        if (r100 == null) goto L5;
        int r104 = p.f133453a[r102.ordinal()];
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L13;
        return u4.c(new PSHighlightRenderHelper$getAnim$3(r100, r101, r103));
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        return u4.c(new PSHighlightRenderHelper$getAnim$2(r100, r103));
    L5:
        return u4.c(new PSHighlightRenderHelper$getAnim$1(r103));
    }
}
