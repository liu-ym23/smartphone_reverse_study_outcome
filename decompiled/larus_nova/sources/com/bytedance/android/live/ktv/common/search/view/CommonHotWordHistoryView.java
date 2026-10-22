package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J@\u0010\f\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003H\u0016J+\u0010\u000f\u001a\u00020\n2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\rH\u0016R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", EffectConfiguration.KEY_SEARCH_WORD, "", "isHistory", "", "hotWordHistoryClickAction", "setHotWordHistoryClickAction", "Lkotlin/Function1;", "historyRemoveAction", "setHistoryRemoveAction", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getTitle", "()Landroid/widget/TextView;", "title", "Lcom/bytedance/android/live/uikit/layout/WrapLineFlowLayout;", "b", "getContainer", "()Lcom/bytedance/android/live/uikit/layout/WrapLineFlowLayout;", KtvSubElement.CONTAINER, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonHotWordHistoryView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f70249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f70250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f70251e;

    public static final class a {
    }

    static {
    }

    public CommonHotWordHistoryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonHotWordHistoryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final WrapLineFlowLayout getContainer() {
        return (WrapLineFlowLayout) this.f70248b.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.f70247a.getValue();
    }

    public void setHistoryRemoveAction(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "historyRemoveAction");
        this.f70250d = r100;
    }

    public void setHotWordHistoryClickAction(Function2<? super String, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "hotWordHistoryClickAction");
        this.f70249c = r100;
    }

    public final void a(boolean r100, List<u> r101) {
        WrapLineFlowLayout r102 = getContainer();
        if (r102 == null) goto L5;
        r102.removeAllViews();
    L5:
        ALogger.i("CommonHotWordHistoryView", "words:" + r101.size());
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L28;
        u r104 = (u) r103.next();
        if (this.f70251e == false) goto L13;
        if (r100 == false) goto L12;
        int r105 = R.layout.ttlive_ktv_common_search_history_adapt;
    L16:
        View r106 = LayoutInflater.from(getContext()).inflate(r105, getContainer(), false);
        TextView r107 = (TextView) r106.findViewById(R.id.content);
        if (r107 == null) goto L19;
        KtvOrderSongThemeManager.d(r107, KtvOrderSongThemeManager.f70197f);
        KtvOrderSongThemeManager.c(r107, KtvOrderSongThemeManager.f70198g);
        r107.setAlpha(1.0f);
        r107.setTag(r104.a());
        r107.setText(r104.a());
        r107.setOnClickListener(new com.bytedance.android.live.ktv.common.search.view.a(this, r100));
    L19:
        View r108 = r106.findViewById(R.id.remove_icon);
        if (r108 == null) goto L22;
        KtvOrderSongThemeManager.c(r108, KtvOrderSongThemeManager.f70203l);
    L22:
        FrameLayout r109 = (FrameLayout) r106.findViewById(R.id.remove_bt);
        if (r109 == null) goto L25;
        r109.setTag(r104.a());
        r109.setOnClickListener(new b(this));
    L25:
        WrapLineFlowLayout r110 = getContainer();
        if (r110 == null) goto L7;
        r110.addView(r106);
        goto L7
    L12:
        r105 = R.layout.ttlive_ktv_common_search_hot_word_adapt;
        goto L16
    L13:
        if (r100 == false) goto L15;
        r105 = R.layout.ttlive_ktv_common_search_history;
        goto L16
    L15:
        r105 = R.layout.ttlive_ktv_common_search_hot_word;
        goto L16
    }

    public final void b(int r100, List<u> r101) {
        List<u> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        UtilityKotlinExtentionsKt.t(this);
        return;
    L11:
        UtilityKotlinExtentionsKt.w(this);
        TextView r104 = getTitle();
        if (r104 == null) goto L14;
        KtvOrderSongThemeManager.d(r104, 200);
    L14:
        if (r100 == 0) goto L21;
        if (r100 != 1) goto L28;
        TextView r105 = getTitle();
        if (r105 == null) goto L20;
        r105.setText(s1.B(R.string.ttlive_ktv_search_hot_word_title));
    L20:
        a(false, r101);
        return;
    L28:
        return;
    L21:
        TextView r106 = getTitle();
        if (r106 == null) goto L24;
        r106.setText(s1.B(R.string.ttlive_ktv_search_history_title));
    L24:
        a(true, r101);
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public CommonHotWordHistoryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f70247a = LazyKt.lazy(new CommonHotWordHistoryView$title$2(this));
        this.f70248b = LazyKt.lazy(new CommonHotWordHistoryView$container$2(this));
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.search_hot_history_enable_font_scale});
        boolean r104 = r103.getBoolean(0, false);
        this.f70251e = r104;
        r103.recycle();
        if (r104 == false) goto L5;
        int r105 = R.layout.ttlive_ktv_common_search_history_and_hot_word_adapt;
    L6:
        LayoutInflater.from(r100).inflate(r105, this);
        return;
    L5:
        r105 = R.layout.ttlive_ktv_common_search_history_and_hot_word;
        goto L6
    }

    public /* synthetic */ CommonHotWordHistoryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
