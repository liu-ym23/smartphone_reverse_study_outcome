package com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/deletedproducttip/AnchorV4DeletedProductTipView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DeletedProductTipView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f168148a;

    public final View a() {
        if (this.f168148a != null) goto L5;
        this.f168148a = new LinkedHashMap();
    L5:
        Map<Integer, View> r100 = this.f168148a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(R.id.deleted_tip));
        if (r102 != null) goto L12;
        View r103 = findViewById(R.id.deleted_tip);
        if (r103 == null) goto L10;
        this.f168148a.put(Integer.valueOf(R.id.deleted_tip), r103);
        return r103;
    L10:
        return null;
    L12:
        return r102;
    }

    public AnchorV4DeletedProductTipView(Context r100) {
        this(r100, null);
    }

    public AnchorV4DeletedProductTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f168148a = new LinkedHashMap();
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_anchor_v4_deleted_product_tip, this, true);
        setOrientation(1);
    }
}
