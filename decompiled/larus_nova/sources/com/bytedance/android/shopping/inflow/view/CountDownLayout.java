package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/CountDownLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f176324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TextView> f176325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TextView> f176326c;

    public CountDownLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountDownLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f176324a != null) goto L5;
        this.f176324a = new LinkedHashMap();
    L5:
        View r101 = this.f176324a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f176324a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public CountDownLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f176324a = new LinkedHashMap();
        FrameLayout.inflate(r110, R.layout.shopping_countdown_layout_in_flow, this);
        this.f176325b = CollectionsKt.listOf(new TextView[]{(TextView) a(R.id.activity_countdown_day), (TextView) a(R.id.activity_countdown_day_label), (TextView) a(R.id.activity_countdown_hours), (TextView) a(R.id.activity_countdown_category_between_hours_and_min), (TextView) a(R.id.activity_countdown_min), (TextView) a(R.id.activity_countdown_category_between_min_and_sec), (TextView) a(R.id.activity_countdown_sec)});
        this.f176326c = CollectionsKt.listOf(new TextView[]{(TextView) a(R.id.activity_countdown_day), (TextView) a(R.id.activity_countdown_hours), (TextView) a(R.id.activity_countdown_min), (TextView) a(R.id.activity_countdown_sec)});
    }

    public /* synthetic */ CountDownLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
