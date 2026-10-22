package com.bytedance.android.livesdk.dslservice.slice.view.container;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.d;
import zt1.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/slice/view/container/NormalContainerView;", "Landroid/widget/FrameLayout;", "Lyt1/d;", "Lzt1/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lzt1/a;", "getContainerData", "()Lzt1/a;", "setContainerData", "(Lzt1/a;)V", "containerData", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "mAttributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalContainerView extends FrameLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f122950a;

    @Override // yt1.d
    public a getContainerData() {
        return this.f122950a;
    }

    @Override // yt1.d
    public final void release() {
        removeAllViews();
    }

    public NormalContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
    }

    @Override // yt1.d
    public void setContainerData(a r100) {
        this.f122950a = r100;
    }

    public NormalContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mAttributeSet");
        super(r100, r101);
    }
}
