package com.bytedance.android.ec.hybrid.list.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/ScrollImageByRV;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollImageByRV extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47423a;

    public static final class a {
    }

    static {
    }

    public ScrollImageByRV(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScrollImageByRV(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ScrollImageByRV(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new ScrollImageByRV$scrollListener$1(this);
    }

    public /* synthetic */ ScrollImageByRV(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f47423a != 0) goto L6;
        this.f47423a = r102;
        return;
    }
}
