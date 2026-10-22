package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f70827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f70828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.ktvapi.model.mv.e<?>> f70829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OpusPreviewViewModel f70830d;

    public static final class a implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f70831a;

        public a(h r100) {
            this.f70831a = r100;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r100, int r101, int r102, int r110, int r111) {
            if (r102 != r100.getScrollY()) goto L16;
            NestedScrollView r103 = this.f70831a.f70827a;
            if (r103 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        L7:
            View r104 = r103.getChildAt(0);
            if (r104 == null) goto L17;
            int r105 = r104.getHeight();
            NestedScrollView r112 = this.f70831a.f70827a;
            if (r112 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        L13:
            if ((r112.getHeight() + r102) < r105) goto L18;
            h r106 = this.f70831a;
            r106.getClass();
            ALogger.i("onScrollToEnd", "onScrollToEnd");
            OpusPreviewViewModel.requestMvList$default(r106.f70830d, false, true, null, 4, null);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public h(Context r100, OpusPreviewViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vm");
        this.f70830d = r101;
        this.f70829c = new ArrayList();
        View r102 = LayoutInflater.from(r100).inflate(R.layout.layout_mv_preview_container, null);
        if (r102 == null) goto L7;
        NestedScrollView r103 = (NestedScrollView) r102;
        this.f70827a = r103;
        r103.setOnScrollChangeListener(new a(this));
        this.f70828b = (ViewGroup) r103.findViewById(R.id.layout_container);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
    }
}
