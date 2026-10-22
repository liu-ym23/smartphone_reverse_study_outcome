package com.bytedance.android.livesdk.livecommerce.userinfo.title.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECMaxSizeLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/views/ECIntroductionLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECMaxSizeLinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIntroductionLayout extends ECMaxSizeLinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f153010g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TextView> f153011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<VerticalDashLineView> f153012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ECDraweeView> f153013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ECIntroductionRotationView> f153014f;

    public static final class a {
        public static TextView a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            TextView r101 = new TextView(r100);
            r101.setTextSize(1, 11.0f);
            r101.setEllipsize(TextUtils.TruncateAt.END);
            r101.setMaxLines(1);
            r101.setIncludeFontPadding(false);
            if (Build.VERSION.SDK_INT < 28) goto L5;
            r101.setFallbackLineSpacing(false);
            r101.setLineHeight(UtilityKotlinExtentionsKt.d(12));
        L5:
            return r101;
        }
    }

    static {
    }

    public ECIntroductionLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f153011c = new ArrayList();
        this.f153012d = new ArrayList();
        this.f153013e = new ArrayList();
        this.f153014f = new ArrayList();
        setOrientation(0);
    }

    public final <T extends View> T d(List<T> r100) {
        if ((!r100.isEmpty()) == false) goto L7;
        T r101 = (T) ListProtector.remove(r100, 0);
        if (r101.getParent() != null) goto L9;
        return r101;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECMaxSizeLinearLayout, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 != null) goto L6;
        return new LinearLayoutCompat.LayoutParams(-2, -2);
    L6:
        if ((r100 instanceof LinearLayoutCompat.LayoutParams) == false) goto L9;
        return (LinearLayoutCompat.LayoutParams) r100;
    L9:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        return new LinearLayoutCompat.LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L12:
        return super.generateLayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        if ((r100 instanceof TextView) == false) goto L6;
        this.f153011c.add(r100);
        return;
    L6:
        if ((r100 instanceof VerticalDashLineView) == false) goto L9;
        this.f153012d.add(r100);
        return;
    L9:
        if ((r100 instanceof ECDraweeView) == false) goto L12;
        this.f153013e.add(r100);
        return;
    L12:
        if ((r100 instanceof ECIntroductionRotationView) == false) goto L18;
        this.f153014f.add(r100);
        return;
    }

    public ECIntroductionLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.f153011c = new ArrayList();
        this.f153012d = new ArrayList();
        this.f153013e = new ArrayList();
        this.f153014f = new ArrayList();
        setOrientation(0);
    }

    public ECIntroductionLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153011c = new ArrayList();
        this.f153012d = new ArrayList();
        this.f153013e = new ArrayList();
        this.f153014f = new ArrayList();
        setOrientation(0);
    }
}
