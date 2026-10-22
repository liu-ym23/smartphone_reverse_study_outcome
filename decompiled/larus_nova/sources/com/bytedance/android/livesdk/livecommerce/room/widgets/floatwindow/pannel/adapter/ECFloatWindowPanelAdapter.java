package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.response.CarouselDetailInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter$ViewHolder;", "ViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowPanelAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f152122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<CarouselDetailInfo> f152123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public lk2.a f152124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f152125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewHolder f152126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final il.a f152127f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f152128b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a f152129a;

        public static final class a {
        }

        static {
        }

        public ViewHolder(View r100, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "manager");
            super(r100);
            this.f152129a = r101;
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECFloatWindowPanelAdapter f152130a;

        public a(ECFloatWindowPanelAdapter r100) {
            this.f152130a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152130a.safeNotifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<CarouselDetailInfo> r100 = this.f152123b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final void safeNotifyDataSetChanged() {
        RecyclerView r100 = this.f152122a;
        if (r100 != null) goto L5;
    L8:
        notifyDataSetChanged();
        return;
    L5:
        if (r100.isComputingLayout() != true) goto L8;
        r100.post(new a(this));
    }

    public ECFloatWindowPanelAdapter(il.a r100) {
        Intrinsics.checkNotNullParameter(r100, "historyMap");
        this.f152127f = r100;
        this.f152125d = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f152122a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        this.f152122a = null;
    }

    public final b y2(int r110) {
        List<CarouselDetailInfo> r100 = this.f152123b;
        String r101 = null;
        if (r100 == null) goto L17;
        CarouselDetailInfo r111 = (CarouselDetailInfo) CollectionsKt.getOrNull(r100, r110);
        if (r111 == null) goto L18;
        Integer r102 = r111.getType();
        ECFloatWindowDetailInfo r103 = r111.getDetailInfo();
        Map<String, String> r104 = r111.getEventParams();
        lk2.a r112 = this.f152124c;
        if (r112 == null) goto L9;
        String r105 = r112.f509551d;
    L10:
        if (r112 == null) goto L12;
        String r106 = r112.f509552e;
    L13:
        if (r112 == null) goto L16;
        r101 = r112.f509553f;
    L16:
        return new b(r102, r103, r104, r105, r106, r101);
    L12:
        r106 = null;
        goto L13
    L9:
        r105 = null;
        goto L10
    L18:
        return null;
    L17:
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final b r103 = y2(r101);
        r102.f152129a.b(r103);
        if (r103 == null) goto L11;
        il.a r104 = this.f152127f;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103.getType());
        r105.append('_');
        ECFloatWindowDetailInfo r106 = r103.f509556b;
        if (r106 == null) goto L8;
        Integer r107 = Integer.valueOf(r106.hashCode());
    L9:
        r105.append(r107);
        r105.append('_');
        r105.append(r101);
        r104.c("livesdk_size_card_show", r105.toString(), new ECFloatWindowPanelAdapter$logShowEvent$1(this, r103));
        return;
    L8:
        r107 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = ViewHolder.f152128b;
        Context r103 = r100.getContext();
        lk2.a r104 = this.f152124c;
        if (r104 == null) goto L5;
        LiveRoomParams r105 = r104.f509554g;
    L6:
        Function0<Boolean> r106 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, "canToggle");
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a r107 = new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a(r103, r105, r106);
        r107.e();
        View r108 = r107.f152174a;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L10:
        return new ViewHolder(r108, r107);
    L5:
        r105 = null;
        goto L6
    }
}
