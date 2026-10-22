package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TrayWaveControllerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrayWaveControllerView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f129895c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f129896d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f129897e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f129898f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f129899g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f129900h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AnimatorSet> f129901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<p> f129902b;

    public static final class a {
    }

    public TrayWaveControllerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TrayWaveControllerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        f129895c = s1.f(99.0f);
        f129896d = s1.f(79.0f);
        f129897e = s1.f(79.0f);
        f129898f = s1.f(63.0f);
        f129899g = s1.f(59.0f);
        f129900h = s1.f(47.0f);
    }

    public final void a() {
        List<p> r100 = this.f129902b;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((p) r101.next()).b();
    L8:
        List<AnimatorSet> r102 = this.f129901a;
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L18;
        AnimatorSet r104 = (AnimatorSet) r103.next();
        if (r104 == null) goto L16;
        r104.removeAllListeners();
    L16:
        if (r104 == null) goto L12;
        r104.cancel();
    L18:
        List<p> r105 = this.f129902b;
        if (r105 == null) goto L21;
        r105.clear();
    L21:
        List<AnimatorSet> r106 = this.f129901a;
        if (r106 == null) goto L24;
        r106.clear();
    L24:
        this.f129902b = null;
        this.f129901a = null;
        removeAllViews();
    }

    public TrayWaveControllerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ TrayWaveControllerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
