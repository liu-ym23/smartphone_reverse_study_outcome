package com.bytedance.android.shopping.anchorv4.nav;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/AnchorV4SearchEditView;", "Lcom/bytedance/android/shopping/anchorv3/widget/AnchorV3SearchEditView;", "", "getLayoutId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4SearchEditView extends AnchorV3SearchEditView {
    public AnchorV4SearchEditView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4SearchEditView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView
    public int getLayoutId() {
        return R.layout.ec_commerce_anchor_v4_search_edit_view;
    }

    public final void b() {
        com.bytedance.android.shopping.anchorv3.widget.e r100 = getLogAction();
        if (r100 == null) goto L10;
        com.bytedance.android.shopping.anchorv3.widget.f r101 = getSearchParams();
        if (r101 == null) goto L7;
        String r102 = r101.f165605c;
    L8:
        r100.a(r102, getSearchInfo());
        return;
    L7:
        r102 = null;
        goto L8
    }

    public AnchorV4SearchEditView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV4SearchEditView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
