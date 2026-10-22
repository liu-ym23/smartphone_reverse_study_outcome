package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv3.utils.z;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/AnchorV3SearchEditView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Lcom/bytedance/android/shopping/anchorv3/i;", "b", "Lcom/bytedance/android/shopping/anchorv3/i;", "getSearchInfo", "()Lcom/bytedance/android/shopping/anchorv3/i;", "setSearchInfo", "(Lcom/bytedance/android/shopping/anchorv3/i;)V", "searchInfo", "Lcom/bytedance/android/shopping/anchorv3/widget/f;", "c", "Lcom/bytedance/android/shopping/anchorv3/widget/f;", "getSearchParams", "()Lcom/bytedance/android/shopping/anchorv3/widget/f;", "setSearchParams", "(Lcom/bytedance/android/shopping/anchorv3/widget/f;)V", "searchParams", "Lcom/bytedance/android/shopping/anchorv3/widget/e;", "d", "Lcom/bytedance/android/shopping/anchorv3/widget/e;", "getLogAction", "()Lcom/bytedance/android/shopping/anchorv3/widget/e;", "setLogAction", "(Lcom/bytedance/android/shopping/anchorv3/widget/e;)V", "logAction", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV3SearchEditView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f165573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f165574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f165575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f165576d;

    public AnchorV3SearchEditView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3SearchEditView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getLayoutId() {
        return R.layout.ec_commerce_anchor_v3_search_edit_view;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.f165573a = (TextView) findViewById(R.id.anchor_v3_tv_search_word);
    }

    public final e getLogAction() {
        return this.f165576d;
    }

    public final i getSearchInfo() {
        return this.f165574b;
    }

    public final f getSearchParams() {
        return this.f165575c;
    }

    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        String r100 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c9263.d4884", Boolean.FALSE).withView(r110).build());
        e r101 = this.f165576d;
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        z.c(z.f165361a, getContext(), this.f165574b, this.f165575c, th.a.f(getContext()).getString(R.string.shopping_anchor_v3_tip_search_hint), false, "a1.b8094.c9263.d4884", r110, 48);
    }

    public final void setLogAction(e r100) {
        this.f165576d = r100;
    }

    public final void setSearchInfo(i r100) {
        this.f165574b = r100;
    }

    public final void setSearchParams(f r100) {
        this.f165575c = r100;
    }

    public AnchorV3SearchEditView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV3SearchEditView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
