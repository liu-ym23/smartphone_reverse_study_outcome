package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreShellTopTipsView;", "Landroid/widget/FrameLayout;", "", "value", "c", FaceService.girlLabel, "getCollapse", "()F", "setCollapse", "(F)V", "collapse", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreShellTopTipsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f184603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f184604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f184605c;

    public static final class a {
    }

    static {
    }

    public ECStoreShellTopTipsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStoreShellTopTipsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getCollapse() {
        return this.f184605c;
    }

    public final void setCollapse(float r100) {
        if (this.f184605c == r100) goto L10;
        this.f184605c = r100;
        if (r100 >= 0.1f) goto L7;
        this.f184603a.setAlpha(1.0f);
    L8:
        FrameLayout r101 = this.f184604b;
        float r102 = this.f184605c;
        r101.setAlpha(r102 * r102);
        return;
    L7:
        this.f184603a.setAlpha(0.0f);
        goto L8
    }

    public ECStoreShellTopTipsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.ec_store_sheet_layout_top_tips, this);
        this.f184603a = (FrameLayout) findViewById(R.id.ec_store_shell_expand_top_tips_container);
        this.f184604b = (FrameLayout) findViewById(R.id.ec_store_shell_collapse_top_tips_container);
        TextView r103 = (TextView) findViewById(R.id.ec_store_shell_expand_top_tips_text);
        TextView r104 = (TextView) findViewById(R.id.ec_store_shell_collapse_top_tips_text);
    }

    public /* synthetic */ ECStoreShellTopTipsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
