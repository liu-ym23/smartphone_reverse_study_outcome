package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.p;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.toolbox.e;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import d9.a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalListView extends RelativeLayout implements ITangramViewLifeCycle, BouncyScrollListView.IReportListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f9943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BouncyScrollListView f9944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f9945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f9946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Point f9947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f9949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f9950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9951i;

    public HorizontalListView(Context r10) {
        this(r10, null);
    }

    private void a() {
        BouncyScrollListView r10 = new BouncyScrollListView(getContext());
        this.f9944b = r10;
        r10.setClipToPadding(false);
        this.f9944b.setClipChildren(false);
        this.f9944b.setIReportListener(this);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-1, -2);
        r11.addRule(15);
        addView(this.f9944b, r11);
        RecyclerView r12 = this.f9944b.getListView();
        this.f9943a = r12;
        r12.setClipChildren(false);
        this.f9943a.setFocusable(false);
        this.f9946d = new Rect();
        this.f9947e = new Point();
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        p.a(r10);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (this.f9948f == false) goto L6;
        reportExpose();
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        throw null;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
    }

    @Override // com.bytedanceos.common.tangram.view.BouncyScrollListView.IReportListener
    public void reportExpose() {
        String r10 = e.W(e.f10020b);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if ("tab_featured".equals(r10) == false) goto L7;
    L8:
        RecyclerView r11 = this.f9943a;
        if (r11 == null) goto L37;
        int r12 = r11.getChildCount();
        this.f9950h.clear();
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r14 >= r12) goto L22;
        View r15 = this.f9943a.getChildAt(r14);
        if (r15 == null) goto L21;
        if (r15.getGlobalVisibleRect(this.f9946d, this.f9947e) == false) goto L21;
        this.f9948f = false;
        if ((r15 instanceof TangramBannerView) == false) goto L21;
        Topic r16 = ((TangramBannerView) r15).getTopic();
        this.f9950h.add(r16.getTitle());
        if (this.f9951i != 0) goto L21;
        this.f9951i = r16.getLocation();
    L21:
        r14 = r14 + 1;
        goto L11
    L22:
        this.f9950h.removeAll(this.f9949g);
        Object[] r17 = this.f9950h.toArray();
        if (r17.length <= 0) goto L38;
        this.f9949g.clear();
        boolean r18 = "tab_featured".equals(r10);
    L26:
        if (r13 >= r17.length) goto L39;
        this.f9949g.add(r17[r13].toString());
        a.e().m(r18, String.valueOf(this.f9951i), r17[r13].toString());
        r13 = r13 + 1;
        goto L26
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L7:
        if ("tab_game".equals(r10) == true) goto L8;
    }

    public HorizontalListView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public HorizontalListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9945c = new ArrayList();
        this.f9949g = new LinkedHashSet();
        this.f9950h = new LinkedHashSet();
        this.f9951i = 0;
        a();
    }
}
