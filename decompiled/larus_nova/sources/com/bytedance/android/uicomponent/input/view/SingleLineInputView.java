package com.bytedance.android.uicomponent.input.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/uicomponent/input/view/SingleLineInputView;", "Lcom/bytedance/android/uicomponent/input/view/InputView;", "", "getLayoutID", "", "title", "", d.f25925o, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleLineInputView extends InputView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f187680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f187681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f187682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f187683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f187684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f187685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f187686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f187687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f187688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f187689u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f187690v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f187691w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleLineInputView f187692a;

        public b(SingleLineInputView r100) {
            this.f187692a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f187692a.getMOnClearListener();
            this.f187692a.getMEditText().setText(null);
        }
    }

    static {
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public int getLayoutID() {
        return R.layout.uicomponent_inputview_type_line;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void b() {
        if (this.f187687s != 0) goto L9;
        View r100 = this.f187682n;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L7:
        r100.setBackgroundColor(getContext().getResources().getColor(R.color.ttlive_std_line_black_3));
        return;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void c() {
        if (this.f187687s != 0) goto L9;
        View r100 = this.f187682n;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L7:
        r100.setBackgroundColor(getContext().getResources().getColor(R.color.ttlive_std_error));
        return;
    }

    public final void i() {
        if (this.f187690v != null) goto L5;
        return;
    L5:
        TextView r100 = this.f187681m;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    L8:
        r100.setVisibility(0);
        TextView r101 = this.f187681m;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    L11:
        r101.setText(this.f187690v);
        if (this.f187689u == false) goto L18;
        ImageView r102 = this.f187686r;
        if (r102 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mIsMustFillIv");
    L16:
        r102.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void e() {
        this.f187685q = findViewById(R.id.input_view_container);
        this.f187683o = (FrameLayout) findViewById(R.id.input_view_prefix_cus_view);
        this.f187684p = (FrameLayout) findViewById(R.id.input_view_post_cus_view);
        if (this.f187691w != 0) goto L5;
        TextView r100 = (TextView) findViewById(R.id.input_view_vertical_title);
    L6:
        this.f187681m = r100;
        if (this.f187691w != 0) goto L9;
        ImageView r101 = (ImageView) findViewById(R.id.input_view_vertical_title_ic);
    L10:
        this.f187686r = r101;
        i();
        ImageView r102 = (ImageView) findViewById(R.id.input_view_clear_iv);
        this.f187680l = r102;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L13:
        r102.setOnClickListener(new b(this));
        View r103 = findViewById(R.id.input_view_line);
        this.f187682n = r103;
        if (this.f187687s != 0) goto L18;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L17:
        r103.setVisibility(0);
        return;
    L18:
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L20:
        r103.setVisibility(8);
        View r104 = this.f187685q;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L23:
        r104.setBackground(getContext().getResources().getDrawable(R.drawable.uicomponent_bg_input));
        View r105 = this.f187685q;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L26:
        r105.setPadding((int) e.a(getContext(), 12.0f), (int) e.a(getContext(), 8.0f), (int) e.a(getContext(), 12.0f), (int) e.a(getContext(), 8.0f));
        return;
    L9:
        r101 = (ImageView) findViewById(R.id.input_view_horizon_title_ic);
        goto L10
    L5:
        r100 = (TextView) findViewById(R.id.input_view_horizon_title);
        goto L6
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void a(Editable r100) {
        super.a(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.toString().length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L12:
        h(false);
        return;
    L10:
        if (this.f187688t == false) goto L12;
        h(true);
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void d(TypedArray r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        this.f187690v = r100.getString(7);
        this.f187687s = r100.getInt(3, 0);
        this.f187688t = r100.getBoolean(0, false);
        this.f187689u = r100.getBoolean(4, false);
        r100.getDimension(9, 0.0f);
        this.f187691w = r100.getInt(8, 0);
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L8;
        ImageView r101 = this.f187680l;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L7:
        r101.setVisibility(0);
        return;
    L8:
        ImageView r102 = this.f187680l;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L11:
        r102.setVisibility(8);
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f187690v = r100;
        i();
    }

    public SingleLineInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
    }
}
