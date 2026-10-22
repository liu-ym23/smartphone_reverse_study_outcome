package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageMoreInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "c", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "getDetailImageVO", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "setDetailImageVO", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;)V", "detailImageVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageMoreInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f168279d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f168280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f168281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f168282c;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailImageMoreInfoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4DetailImageMoreInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final d getDetailImageVO() {
        return this.f168282c;
    }

    public final void setDetailImageVO(d r100) {
        this.f168282c = r100;
    }

    public AnchorV4DetailImageMoreInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_layout_detail_image_more_info, this, true);
        this.f168280a = (SimpleDraweeView) findViewById(R.id.sdv_detail_image);
        ConstraintLayout r103 = (ConstraintLayout) findViewById(R.id.cl_more_info_container);
        LinearLayout r104 = (LinearLayout) findViewById(R.id.ll_more_info_btn);
        this.f168281b = (TextView) findViewById(R.id.tv_more_info);
    }

    public /* synthetic */ AnchorV4DetailImageMoreInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
