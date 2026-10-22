package com.bytedance.android.ecom.live.adapter.impl.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import oj.b;

/* JADX INFO: loaded from: classes44.dex */
public class ECStatusView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f51215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51216b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f51217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f51218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f51219c;

        public a(Context r100) {
            if (r100 == null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("ECStatusView.Builder:Context can not be null");
        }
    }

    @Override // oj.b
    public final void a() {
        setECStatus(0);
    }

    @Override // oj.b
    public final void d() {
        setECStatus(1);
    }

    @Override // oj.b
    public final void e() {
        setECStatus(2);
    }

    @Override // oj.b
    public final void b() {
        int r100 = this.f51216b;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        ((View) ListProtector.get(this.f51215a, r100)).setVisibility(4);
        this.f51216b = -1;
    }

    public ECStatusView(Context r100) {
        this(r100, null);
    }

    public void setBuilder(a r100) {
        if (r100 != null) goto L4;
        Context r101 = getContext();
        a r102 = new a(r101);
        TextView r103 = (TextView) LayoutInflater.from(r101).inflate(R.layout.view_default_empty_list, null);
        r103.setText(R.string.load_status_empty);
        r102.f51218b = r103;
        TextView r104 = (TextView) LayoutInflater.from(r101).inflate(R.layout.load_status_item_view, null);
        r104.setText(R.string.load_status_loading);
        r102.f51217a = r104;
        TextView r105 = (TextView) LayoutInflater.from(r101).inflate(R.layout.load_status_item_view, null);
        r105.setText(R.string.load_status_error);
        r105.setOnClickListener(null);
        r102.f51219c = r105;
        r100 = r102;
    L4:
        ((ArrayList) this.f51215a).clear();
        List<View> r106 = this.f51215a;
        ArrayList r107 = (ArrayList) r106;
        r107.add(r100.f51217a);
        List<View> r108 = this.f51215a;
        ArrayList r109 = (ArrayList) r108;
        r109.add(r100.f51218b);
        List<View> r110 = this.f51215a;
        ArrayList r111 = (ArrayList) r110;
        r111.add(r100.f51219c);
        removeAllViews();
        int r112 = 0;
    L6:
        if (r112 >= ((ArrayList) this.f51215a).size()) goto L12;
        View r113 = (View) ListProtector.get(this.f51215a, r112);
        if (r113 == null) goto L11;
        r113.setVisibility(4);
        addView(r113);
    L11:
        r112 = r112 + 1;
        goto L6
    }

    @Override // oj.b
    public void setECStatus(int r100) {
        int r101 = this.f51216b;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 < 0) goto L8;
        ((View) ListProtector.get(this.f51215a, r101)).setVisibility(4);
    L8:
        if (r100 != (-1)) goto L12;
        this.f51216b = r100;
        return;
    L12:
        if (((View) ListProtector.get(this.f51215a, r100)) != null) goto L14;
        return;
    L14:
        ((View) ListProtector.get(this.f51215a, r100)).setVisibility(0);
        this.f51216b = r100;
        Logger.d("ECStatusView", "setECStatus    " + r100);
    }

    public ECStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ECStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f51215a = new ArrayList(3);
        this.f51216b = -1;
        setBuilder(null);
    }

    @Override // oj.b
    public final void c(Context r100, View r101, View r102) {
        ListProtector.set(this.f51215a, 1, r101);
        ListProtector.set(this.f51215a, 2, r102);
    }
}
