package com.bytedance.android.shopping.anchorv4.voavhs.processflow;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ProcessFlowView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f170038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f170039b;

    public AnchorV4ProcessFlowView(Context r100) {
        this(r100, null);
    }

    public final View a(int r100) {
        if (this.f170038a != null) goto L5;
        this.f170038a = new LinkedHashMap();
    L5:
        View r101 = this.f170038a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f170038a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f170039b.e(r100);
        super.draw(r100);
        this.f170039b.d(r100);
    }

    public AnchorV4ProcessFlowView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f170038a = new LinkedHashMap();
        b r102 = new b(this);
        this.f170039b = r102;
        LinearLayout.inflate(r100, R.layout.shopping_anchor_v4_process_flow, this);
        setOrientation(1);
        setBackgroundColor(-1);
        r102.f(new Radius(8, 8, 8, 8));
        setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        setClipChildren(false);
        setClipToPadding(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f170039b.c(r100, r101);
    }
}
