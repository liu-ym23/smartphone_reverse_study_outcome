package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV4SearchEntryView;", "Landroid/widget/RelativeLayout;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getSearchWordTv", "()Landroid/widget/TextView;", "searchWordTv", "Landroid/widget/LinearLayout;", "b", "getSearchArea", "()Landroid/widget/LinearLayout;", "searchArea", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4SearchEntryView extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f165493c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f165495b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4SearchEntryView f165496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f165497b;

        public b(AnchorV4SearchEntryView r100, Function1 r101) {
            this.f165496a = r100;
            this.f165497b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f165497b.invoke(this.f165496a);
        }
    }

    static {
    }

    public AnchorV4SearchEntryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4SearchEntryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final LinearLayout getSearchArea() {
        return (LinearLayout) this.f165495b.getValue();
    }

    private final TextView getSearchWordTv() {
        return (TextView) this.f165494a.getValue();
    }

    public final void a(com.bytedance.android.shopping.anchorv3.i r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "searchInfo");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        getSearchWordTv().setText(r100.f165115a);
        getSearchArea().setOnClickListener(new b(this, r101));
    }

    public AnchorV4SearchEntryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        u63.a.a(r100, R.layout.ec_commerce_layout_anchor_v4_search_entry, this, true);
        this.f165494a = LazyKt.lazy(new AnchorV4SearchEntryView$searchWordTv$2(this));
        this.f165495b = LazyKt.lazy(new AnchorV4SearchEntryView$searchArea$2(this));
    }

    public /* synthetic */ AnchorV4SearchEntryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
