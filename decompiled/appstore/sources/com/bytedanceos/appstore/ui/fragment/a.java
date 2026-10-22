package com.bytedanceos.appstore.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.widget.ParentView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f9510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f9512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ParentView f9513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f9514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RefreshLoadListView f9515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f9516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f9520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f9522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f9523p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f9524q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f9525r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f9526s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f9527t;

    public a() {
        this.f9520m = null;
    }

    public void A(String r10) {
        this.f9519l = r10;
    }

    public void B(String r10) {
        this.f9525r = r10;
    }

    public void C(int r10) {
        this.f9509b = r10;
    }

    public void D(String r10) {
        this.f9518k = r10;
    }

    public void E(int r10) {
        this.f9508a = r10;
    }

    public final void F() {
        int r10 = this.f9508a;
        if (r10 != 3) goto L5;
    L22:
        ViewGroup r11 = this.f9512e;
        if (r11 == null) goto L32;
        r11.setVisibility(0);
        return;
    L32:
        return;
    L5:
        if (r10 == 4) goto L22;
        if (r10 != 5) goto L9;
        ViewGroup r12 = this.f9514g;
        if (r12 == null) goto L30;
        r12.setVisibility(0);
        return;
    L30:
        return;
    L9:
        if (r10 != 6) goto L11;
        ViewGroup r13 = this.f9516i;
        if (r13 == null) goto L28;
        r13.setVisibility(0);
        return;
    L28:
        return;
    L11:
        if (r10 != 9) goto L33;
        RefreshLoadListView r14 = this.f9515h;
        if (r14 == null) goto L26;
        r14.setVisibility(0);
        return;
    L26:
        return;
    }

    public int getState() {
        return this.f9508a;
    }

    public ViewGroup i(View.OnClickListener r10, boolean r11) {
        ViewGroup r12 = b.d(this.f9513f, r10, r11);
        this.f9514g = r12;
        return r12;
    }

    public ViewGroup j() {
        return this.f9512e;
    }

    public ViewGroup k() {
        if (this.f9508a != 5) goto L7;
        return this.f9514g;
    L7:
        return this.f9512e;
    }

    public String l() {
        return this.f9522o;
    }

    public ViewGroup m() {
        return this.f9514g;
    }

    public String n() {
        return this.f9519l;
    }

    public String o() {
        return this.f9525r;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        ParentView r13 = this.f9513f;
        if (r13 == null) goto L14;
        ViewGroup r14 = (ViewGroup) r13.getParent();
        if (r14 == null) goto L7;
        r14.removeAllViewsInLayout();
    L7:
        F();
        Object r15 = this.f9512e.getTag();
        if (r15 == null) goto L13;
        if ((r15 instanceof AppInfo) == false) goto L13;
        b.e(this.f9512e, (AppInfo) r15);
    L13:
        return this.f9513f;
    L14:
        boolean r16 = false;
        ParentView r17 = (ParentView) r10.inflate(R.layout.fragment_appinfo, r11, false);
        this.f9513f = r17;
        View.OnClickListener r18 = this.f9510c;
        if (this.f9511d != 0) goto L17;
        r16 = true;
    L17:
        this.f9512e = b.d(r17, r18, r16);
        if (TextUtils.isEmpty(this.f9520m) == true) goto L21;
        this.f9512e.setTag(R.id.report_params_sstj, this.f9520m);
    L21:
        if (TextUtils.isEmpty(this.f9521n) == true) goto L23;
        this.f9512e.setTag(R.id.report_params_ads, this.f9521n);
    L23:
        this.f9512e.setTag(R.id.appinfo_type, Integer.valueOf(this.f9511d));
        DisplayMetrics r19 = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(r19);
        return this.f9513f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (BaseApplication.c().q() == false) goto L6;
        b.a(this.f9512e);
        return;
    }

    public int p() {
        return this.f9509b;
    }

    public String q() {
        return this.f9523p;
    }

    public String r() {
        return this.f9517j;
    }

    public String s() {
        return this.f9518k;
    }

    public String t() {
        return this.f9524q;
    }

    public String u() {
        return this.f9526s;
    }

    public String v() {
        return this.f9527t;
    }

    public ViewGroup w() {
        if (this.f9508a != 5) goto L7;
        return this.f9514g;
    L7:
        return this.f9512e;
    }

    public String x(int r10) {
        return y(this.f9508a, r10);
    }

    public String y(int r10, int r11) {
        if (r10 != 3) goto L5;
    L29:
        if (r11 != 0) goto L36;
        ViewGroup r12 = this.f9512e;
        if (r12 != null) goto L33;
        return "";
    L33:
        if (r12.getTag() != null) goto L48;
        return "";
    L48:
        return ((AppInfo) this.f9512e.getTag()).appName;
    L36:
        if (r11 == 1) goto L38;
        return "";
    L38:
        return this.f9518k;
    L5:
        if (r10 == 4) goto L29;
        if (r10 != 5) goto L9;
        if (r11 == 0) goto L43;
        if (r11 != 1) goto L44;
        RefreshLoadListView r13 = this.f9515h;
        if (r13 == null) goto L52;
        Object r14 = r13.getTag(R.id.app_list_key);
        if (r14 != null) goto L46;
        return "";
    L46:
        return r14.toString();
    L52:
        return "";
    L44:
        return "";
    L43:
        return this.f9519l;
    L9:
        if (r10 != 9) goto L50;
        if (r11 != 0) goto L18;
        RefreshLoadListView r15 = this.f9515h;
        if (r15 == null) goto L51;
        Object r16 = r15.getTag(R.id.app_list_key);
        if (r16 != null) goto L40;
        return "";
    L40:
        return r16.toString();
    L51:
        return "";
    L18:
        if (r11 == 1) goto L42;
        return "";
    L42:
        return this.f9517j;
    L50:
        return "";
    }

    public void z(String r10) {
        this.f9522o = r10;
    }
}
