package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.livesmallwindowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.enums.LabelType;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yi2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/livesmallwindowview/LiveSmallWindowView;", "Landroid/widget/FrameLayout;", "", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getHasSeeId", "()Ljava/util/Set;", "hasSeeId", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/viewmodel/a;", "c", "getViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/viewmodel/a;", "viewModel", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallWindowView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f151881f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f151882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f151883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f151884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CarouselView f151885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f151886e;

    public static final class a {
    }

    static {
    }

    public LiveSmallWindowView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveSmallWindowView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Set<Long> getHasSeeId() {
        return (Set) this.f151882a.getValue();
    }

    private final com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a getViewModel() {
        return (com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a) this.f151884c.getValue();
    }

    public static boolean b(List r100) {
        if (r100.size() != 1) goto L20;
        b r101 = (b) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L7;
        Integer r102 = r101.b();
    L8:
        int r103 = LabelType.EXPLAIN.getType();
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.intValue() != r103) goto L22;
        b r104 = (b) CollectionsKt.firstOrNull(r100);
        if (r104 == null) goto L16;
        Long r105 = r104.a();
    L18:
        if (Intrinsics.areEqual(null, r105) == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r105 = null;
        goto L18
    L22:
        return false;
    L7:
        r102 = null;
        goto L8
    L20:
        return false;
    }

    public static final void a(LiveSmallWindowView r100, List r101) {
        ((ArrayList) r100.f151883b).clear();
        ((ArrayList) r100.f151883b).addAll(r101);
        int r102 = ((ArrayList) r100.f151883b).size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L12;
        b r103 = (b) CollectionsKt.getOrNull(r100.f151883b, r102);
        if (r103 == null) goto L3;
        if (r100.getHasSeeId().contains(r103.a()) == false) goto L3;
        ListProtector.remove(r100.f151883b, r102);
        goto L3
    L12:
        if (b(r100.f151883b) == false) goto L22;
        ((ArrayList) r100.f151883b).clear();
        return;
    }

    public LiveSmallWindowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f151882a = LazyKt.lazy(LiveSmallWindowView$hasSeeId$2.INSTANCE);
        this.f151883b = new ArrayList();
        this.f151884c = LazyKt.lazy(new LiveSmallWindowView$viewModel$2(this));
        th.a.c(r100, R.layout.ec_live_small_window_view, this, true);
        this.f151886e = findViewById(R.id.live_carouse_bg);
        this.f151885d = (CarouselView) findViewById(R.id.live_carouse_container);
    }

    public /* synthetic */ LiveSmallWindowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
