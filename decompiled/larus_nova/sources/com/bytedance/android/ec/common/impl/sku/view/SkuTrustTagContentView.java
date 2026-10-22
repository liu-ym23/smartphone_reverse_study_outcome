package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "Landroid/widget/LinearLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getHasExposed", "()Z", "setHasExposed", "(Z)V", "hasExposed", "", "Lcom/bytedance/android/ec/model/sku/ContentInfo;", "b", "Ljava/util/List;", "getShowContents", "()Ljava/util/List;", "setShowContents", "(Ljava/util/List;)V", "showContents", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTrustTagContentView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ContentInfo> f43416b;

    public SkuTrustTagContentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkuTrustTagContentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getHasExposed() {
        return this.f43415a;
    }

    public final List<ContentInfo> getShowContents() {
        return this.f43416b;
    }

    public final void setHasExposed(boolean r100) {
        this.f43415a = r100;
    }

    public final void setShowContents(List<ContentInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f43416b = r100;
    }

    public SkuTrustTagContentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f43416b = new ArrayList();
    }

    public /* synthetic */ SkuTrustTagContentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
