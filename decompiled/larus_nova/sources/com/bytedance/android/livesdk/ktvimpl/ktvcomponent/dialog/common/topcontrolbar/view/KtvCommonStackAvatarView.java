package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getKtvCommonStackAvatarAdapter", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", "ktvCommonStackAvatarAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonStackAvatarView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f144141a;

    public static final class a implements RecyclerView.ChildDrawingOrderCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f144142a = null;

        static {
            f144142a = new a();
        }

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public final int onGetChildDrawingOrder(int r100, int r101) {
            if (r100 > 0) goto L4;
            return r101;
        L4:
            return (r100 - r101) - 1;
        }
    }

    public KtvCommonStackAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvCommonStackAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final KtvCommonStackAvatarAdapter getKtvCommonStackAvatarAdapter() {
        return (KtvCommonStackAvatarAdapter) this.f144141a.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public KtvCommonStackAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f144141a = LazyKt.lazy(KtvCommonStackAvatarView$ktvCommonStackAvatarAdapter$2.INSTANCE);
        setLayoutManager(new SSLinearLayoutManager(r100, 0));
        setAdapter(getKtvCommonStackAvatarAdapter());
        setChildDrawingOrderCallback(a.f144142a);
    }

    public /* synthetic */ KtvCommonStackAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void r(List<? extends py.k> r100, String r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "totalCountStr");
        Intrinsics.checkNotNullParameter(r104, "scene");
        KtvCommonStackAvatarAdapter r105 = getKtvCommonStackAvatarAdapter();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "totalCountStr");
        Intrinsics.checkNotNullParameter(r104, "scene");
        ((ArrayList) r105.f144137c).clear();
        List<py.k> r106 = r105.f144137c;
        ArrayList r107 = (ArrayList) r106;
        r107.addAll(CollectionsKt.take(r100, r103));
        r105.f144138d = r102;
        r105.f144139e = r101;
        r105.f144140f = r103;
        r105.f144135a = r104;
        r105.notifyDataSetChanged();
    }
}
