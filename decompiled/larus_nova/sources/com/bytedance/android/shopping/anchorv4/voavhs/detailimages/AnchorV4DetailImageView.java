package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B)\b\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "getDetailImageVO", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "setDetailImageVO", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;)V", "detailImageVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageView extends SimpleDraweeView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f168287b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f168288a;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4DetailImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final d getDetailImageVO() {
        return this.f168288a;
    }

    public final void setDetailImageVO(d r100) {
        this.f168288a = r100;
    }

    public AnchorV4DetailImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV4DetailImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
