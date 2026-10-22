package com.stepos.ailauncher.task.detail.chrome;

import android.content.res.Resources;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.R$dimen;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "", "immersive", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Z)V", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    public static final void a(View view, boolean z10) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(view, "<this>");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(z10 ? R$dimen.artifact_detail_immersive_topbar_padding_top : R$dimen.artifact_detail_topbar_padding_top);
        int dimensionPixelSize2 = view.getResources().getDimensionPixelSize(z10 ? R$dimen.artifact_detail_immersive_topbar_padding_bottom : R$dimen.artifact_detail_topbar_padding_bottom);
        if (view.getPaddingTop() == dimensionPixelSize && view.getPaddingBottom() == dimensionPixelSize2) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), dimensionPixelSize, view.getPaddingRight(), dimensionPixelSize2);
    }
}
