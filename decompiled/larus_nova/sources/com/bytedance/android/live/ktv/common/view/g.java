package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.view.adapter.OpusPreviewAdapter;
import com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectListView;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class g<T> implements com.bytedance.android.livesdk.ktvapi.model.mv.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f70820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpusPreviewAdapter<T> f70821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f70822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f70823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f70824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j<T> f70825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvapi.model.mv.i<T> f70826g;

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.e
    public final RecyclerView c() {
        RecyclerView r100 = this.f70820a;
        if (r100 != null) goto L13;
        r100 = new RecyclerView(this.f70824e);
        this.f70820a = r100;
        r100.setNestedScrollingEnabled(false);
        r100.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        if (this.f70821b != null) goto L12;
        RecyclerView r101 = this.f70820a;
        if (r101 == null) goto L10;
        int r102 = r101.getWidth();
    L11:
        OpusPreviewAdapter<T> r103 = new OpusPreviewAdapter(r102, this.f70825f, new f(this));
        this.f70821b = r103;
        Unit r104 = Unit.INSTANCE;
        r100.setAdapter(r103);
        goto L12
    L10:
        r102 = 0;
    L12:
        GridLayoutManager r105 = new GridLayoutManager(r100.getContext(), 3, 1, false);
        Unit r106 = Unit.INSTANCE;
        r100.setLayoutManager(r105);
    L13:
        return r100;
    }

    public View e() {
        return this.f70822c;
    }

    public final Context getContext() {
        return this.f70824e;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.e
    public final void a(MvSelectListView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f70826g = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.e
    public final void b(List<? extends T> r100) {
        OpusPreviewAdapter<T> r101 = this.f70821b;
        if (r101 == null) goto L5;
        r101.f70773a = r100;
    L5:
        if (r101 == null) goto L8;
        r101.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.e
    public final void d(com.bytedance.android.live.liveinteract.interactivesong.panel.c r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        OpusPreviewAdapter<T> r101 = this.f70821b;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f70775c = r100;
        return;
    }

    public g(Context r100, j<T> r101, com.bytedance.android.livesdk.ktvapi.model.mv.i<T> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vhProvider");
        this.f70824e = r100;
        this.f70825f = r101;
        this.f70826g = r102;
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(1);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r104 = Unit.INSTANCE;
        this.f70823d = r103;
        if (e() == null) goto L5;
        r103.addView(e());
    L5:
        r103.addView(c());
    }
}
