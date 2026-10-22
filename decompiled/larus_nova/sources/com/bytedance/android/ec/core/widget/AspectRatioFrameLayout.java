package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AspectRatioFrameLayout;", "Landroid/widget/FrameLayout;", "", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/properties/ReadWriteProperty;", "getRatio", "()F", "setRatio", "(F)V", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f45826b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableProperty f45827a;

    public static final class a extends ObservableProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f45828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AspectRatioFrameLayout f45829b;

        public a(Object r100, Object r101, AspectRatioFrameLayout r102) {
            this.f45828a = r100;
            this.f45829b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Float r101, Float r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (r102.floatValue() == r101.floatValue()) goto L7;
            this.f45829b.invalidate();
            return;
        }
    }

    public static final class b extends ObservableProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f45830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AspectRatioFrameLayout f45831b;

        public b(Object r100, Object r101, AspectRatioFrameLayout r102) {
            this.f45830a = r100;
            this.f45831b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Float r101, Float r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (r102.floatValue() == r101.floatValue()) goto L7;
            this.f45831b.invalidate();
            return;
        }
    }

    public static final class c extends ObservableProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f45832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AspectRatioFrameLayout f45833b;

        public c(Object r100, Object r101, AspectRatioFrameLayout r102) {
            this.f45832a = r100;
            this.f45833b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Float r101, Float r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (r102.floatValue() == r101.floatValue()) goto L7;
            this.f45833b.invalidate();
            return;
        }
    }

    static {
        f45826b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(AspectRatioFrameLayout.class, MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio()F", 0))};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getRatio() {
        return ((Number) this.f45827a.getValue(this, f45826b[0])).floatValue();
    }

    public final void setRatio(float r100) {
        this.f45827a.setValue(this, f45826b[0], Float.valueOf(r100));
    }

    public AspectRatioFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Delegates r101 = Delegates.INSTANCE;
        Float r102 = Float.valueOf(1.0f);
        this.f45827a = new a(r102, r102, this);
    }

    public AspectRatioFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Delegates r102 = Delegates.INSTANCE;
        Float r103 = Float.valueOf(1.0f);
        this.f45827a = new b(r103, r103, this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r100) * getRatio()), View.MeasureSpec.getMode(r100)));
    }

    public AspectRatioFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Delegates r103 = Delegates.INSTANCE;
        Float r104 = Float.valueOf(1.0f);
        this.f45827a = new c(r104, r104, this);
    }
}
