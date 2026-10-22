package com.bytedance.android.live.virtuallive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout$CropType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout$CropType;", "getCropType", "()Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout$CropType;", "setCropType", "(Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout$CropType;)V", "cropType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CropType", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VirtualLiveContainerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CropType f102648a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/virtuallive/view/VirtualLiveContainerFrameLayout$CropType;", "", "FIT_WIDTH", "FIT_HEIGHT", "CENTER_CROP", "CENTER_INSIDE", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CropType extends Enum<CropType> {
        public static final CropType CENTER_CROP = null;
        public static final CropType CENTER_INSIDE = null;
        public static final CropType FIT_HEIGHT = null;
        public static final CropType FIT_WIDTH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CropType[] f102649a = null;

        static {
            CropType r100 = new CropType("FIT_WIDTH", 0);
            FIT_WIDTH = r100;
            CropType r101 = new CropType("FIT_HEIGHT", 1);
            FIT_HEIGHT = r101;
            CropType r102 = new CropType("CENTER_CROP", 2);
            CENTER_CROP = r102;
            CropType r103 = new CropType("CENTER_INSIDE", 3);
            CENTER_INSIDE = r103;
            f102649a = new CropType[]{r100, r101, r102, r103};
        }

        public static CropType valueOf(String r100) {
            return (CropType) a.a(CropType.class, r100);
        }

        public static CropType[] values() {
            return (CropType[]) f102649a.clone();
        }

        public CropType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VirtualLiveContainerFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VirtualLiveContainerFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final CropType getCropType() {
        return this.f102648a;
    }

    public final void setCropType(CropType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f102648a = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        final int r102 = View.MeasureSpec.getMode(r100);
        final int r103 = View.MeasureSpec.getMode(r101);
        final Ref.IntRef r104 = new Ref.IntRef();
        r104.element = r100;
        final Ref.IntRef r105 = new Ref.IntRef();
        r105.element = r101;
        if (r102 != r103) goto L23;
        if (r102 == 0) goto L23;
        final int r106 = View.MeasureSpec.getSize(r100);
        final int r107 = View.MeasureSpec.getSize(r101);
        final float r108 = 0.5625f;
        Function0<Unit> r109 = new AnonymousClass1(r106, r108, r105, r103);
        Function0<Unit> r110 = new AnonymousClass2(r107, r108, r104, r102);
        CropType r111 = this.f102648a;
        if (r111 != CropType.FIT_WIDTH) goto L9;
        r109.invoke2();
        goto L23
    L9:
        if (r111 != CropType.FIT_HEIGHT) goto L11;
        r110.invoke2();
        goto L23
    L11:
        float r112 = r106 / r107;
        if (r111 != CropType.CENTER_CROP) goto L18;
        if (r112 <= 0.5625f) goto L16;
        r109.invoke2();
        goto L23
    L16:
        r110.invoke2();
        goto L23
    L18:
        if (r111 != CropType.CENTER_INSIDE) goto L23;
        if (r112 <= 0.5625f) goto L22;
        r110.invoke2();
        goto L23
    L22:
        r109.invoke2();
    L23:
        super.onMeasure(r104.element, r105.element);
    }

    public VirtualLiveContainerFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f102648a = CropType.FIT_HEIGHT;
    }

    public /* synthetic */ VirtualLiveContainerFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
