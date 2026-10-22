package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class LoadingStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f56933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56934c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f56935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f56936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f56937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f56938d;

        public a(Context r100) {
            if (r100 == null) goto L7;
            this.f56935a = r100;
            return;
        L7:
            throw new IllegalArgumentException("LoadingStatusView.Builder:Context can not be null");
        }

        public static a a(Context r100) {
            a r101 = new a(r100);
            TextView r102 = (TextView) LayoutInflater.from(r100).inflate(R.layout.gamecp_liveuikit_view_default_empty_list, null);
            r102.setText(R.string.gamecp_load_status_empty);
            r101.f56937c = r102;
            TextView r103 = (TextView) LayoutInflater.from(r100).inflate(R.layout.gamecp_liveuikit_load_status_item_view, null);
            r103.setText(R.string.gamecp_load_status_loading);
            r101.f56936b = r103;
            TextView r104 = (TextView) LayoutInflater.from(r100).inflate(R.layout.gamecp_liveuikit_load_status_item_view, null);
            r104.setText(R.string.gamecp_load_status_error);
            r104.setOnClickListener(null);
            r101.f56938d = r104;
            return r101;
        }

        public final void b(int r100) {
            CircularProgressView r101 = (CircularProgressView) LayoutInflater.from(this.f56935a).inflate(R.layout.gamecp_liveuikit_uikit_load_status_item_progressbar, null);
            FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
            r102.height = r100;
            r102.width = r100;
            r102.gravity = 17;
            r101.setLayoutParams(r102);
            this.f56936b = r101;
        }
    }

    public final void b() {
        setStatus(1);
    }

    public final void c() {
        setStatus(2);
    }

    public final void d() {
        setStatus(0);
    }

    public final void a() {
        int r100 = this.f56934c;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        ((View) ListProtector.get(this.f56933b, r100)).setVisibility(4);
        this.f56934c = -1;
    }

    public LoadingStatusView(Context r100) {
        this(r100, null);
    }

    private void setStatus(int r100) {
        int r101 = this.f56934c;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 < 0) goto L8;
        ((View) ListProtector.get(this.f56933b, r101)).setVisibility(4);
    L8:
        if (((View) ListProtector.get(this.f56933b, r100)) != null) goto L10;
        return;
    L10:
        ((View) ListProtector.get(this.f56933b, r100)).setVisibility(0);
        this.f56934c = r100;
        Logger.d(this.f56932a, "setStatus    " + r100);
    }

    public void setBuilder(a r100) {
        if (r100 != null) goto L4;
        r100 = a.a(getContext());
    L4:
        ((ArrayList) this.f56933b).clear();
        List<View> r101 = this.f56933b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(r100.f56936b);
        List<View> r103 = this.f56933b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(r100.f56937c);
        List<View> r105 = this.f56933b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(r100.f56938d);
        removeAllViews();
        int r107 = 0;
    L6:
        if (r107 >= ((ArrayList) this.f56933b).size()) goto L15;
        View r108 = (View) ListProtector.get(this.f56933b, r107);
        if (r108 == null) goto L14;
        r108.setVisibility(4);
        if (r108.getParent() == null) goto L13;
        ((ViewGroup) r108.getParent()).removeView(r108);
    L13:
        addView(r108);
    L14:
        r107 = r107 + 1;
        goto L6
    }

    public LoadingStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LoadingStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f56932a = "LoadingStatusView";
        this.f56933b = new ArrayList(3);
        this.f56934c = -1;
        setBuilder(null);
    }
}
