package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/RecordDragContainer;", "Landroid/widget/FrameLayout;", "", "Ld42/d;", "dragParentView", "", "setDragParentView", "", "enable", "setEnableDrag", "Lkotlin/Function1;", "", "l", "Lkotlin/jvm/functions/Function1;", "getOnMoveToSideListener", "()Lkotlin/jvm/functions/Function1;", "setOnMoveToSideListener", "(Lkotlin/jvm/functions/Function1;)V", "onMoveToSideListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordDragContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f115381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f115382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f115383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f115384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f115385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f115386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f115387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f115388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f115389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f115390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f115391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Integer, Unit> f115392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q4.b f115393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Interpolator f115394n;

    public static final class a {
    }

    static {
    }

    public final Function1<Integer, Unit> getOnMoveToSideListener() {
        return this.f115392l;
    }

    public RecordDragContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f115390j = true;
        this.f115394n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.f115389i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f115390j == false) goto L5;
        int r101 = r100.getAction();
        if (r101 != 0) goto L9;
        getTranslationX();
        getTranslationY();
        this.f115382b = r100.getRawX();
        float r102 = r100.getRawY();
        this.f115383c = r102;
        this.f115384d = this.f115382b;
        this.f115385e = r102;
    L64:
        return super.dispatchTouchEvent(r100);
    L9:
        if (r101 == 1) goto L37;
        if (r101 != 2) goto L12;
        this.f115388h = Math.abs(r100.getRawX() - this.f115384d);
        float r103 = Math.abs(r100.getRawY() - this.f115385e);
        float r104 = this.f115388h;
        float r105 = this.f115389i;
        if (r104 <= r105) goto L23;
    L24:
        this.f115391k = true;
        this.f115386f = r100.getRawX() - this.f115382b;
        this.f115387g = r100.getRawY() - this.f115383c;
        d r106 = this.f115381a;
        if (r106 != null) goto L27;
    L34:
        if (this.f115391k == false) goto L64;
        return true;
    L27:
        if (r106.e(getX() + this.f115386f, getWidth()) == false) goto L30;
        this.f115382b = r100.getRawX();
        setX(getX() + this.f115386f);
    L30:
        if (r106.i(getY() + this.f115387g, getHeight()) == false) goto L32;
        this.f115383c = r100.getRawY();
        setY(getY() + this.f115387g);
    L32:
        r106.g(this);
        goto L34
    L23:
        if (r103 <= r105) goto L34;
    L12:
        if (r101 != 3) goto L64;
        if (this.f115391k == false) goto L64;
        this.f115391k = false;
        d r107 = this.f115381a;
        if (r107 == null) goto L19;
        r107.c(this);
    L19:
        return true;
    L37:
        if (this.f115391k == false) goto L64;
        this.f115391k = false;
        final d r108 = this.f115381a;
        if (r108 != null) goto L42;
    L58:
        d r109 = this.f115381a;
        if (r109 == null) goto L61;
        r109.f(this);
    L61:
        return true;
    L42:
        if ((getX() + (getWidth() / 2)) > (r108.getAreaWidth() / 2)) goto L44;
        boolean r110 = true;
    L45:
        final float r111 = getX();
        if (r110 == false) goto L51;
        Function1<? super Integer, Unit> r112 = this.f115392l;
        if (r112 == null) goto L50;
        Unit r113 = r112.invoke(0);
    L50:
        this.f115393m = u4.c(new RecordDragContainer$tryMoveToSide$1(this, r111, r108));
    L55:
        q4.b r114 = this.f115393m;
        if (r114 == null) goto L58;
        r114.c();
        goto L58
    L51:
        Function1<? super Integer, Unit> r115 = this.f115392l;
        if (r115 == null) goto L54;
        Unit r116 = r115.invoke(1);
    L54:
        this.f115393m = u4.c(new RecordDragContainer$tryMoveToSide$2(this, r111, r108));
        goto L55
    L44:
        r110 = false;
        goto L45
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f115390j == false) goto L9;
        q4.b r101 = this.f115393m;
        if (r101 == null) goto L9;
        if (r101.b() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public void setDragParentView(d42.d r100) {
        if ((r100 instanceof d) == true) goto L5;
        r100 = null;
    L5:
        this.f115381a = (d) r100;
    }

    public void setEnableDrag(boolean r100) {
        this.f115390j = r100;
    }

    public final void setOnMoveToSideListener(Function1<? super Integer, Unit> r100) {
        this.f115392l = r100;
    }

    public RecordDragContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f115390j = true;
        this.f115394n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.f115389i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public RecordDragContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f115390j = true;
        this.f115394n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.f115389i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
