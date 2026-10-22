package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.View;
import com.bytedance.android.live.base.model.data.n;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggTemplatePreviewDialog f139973a;

    public b(LikeEggTemplatePreviewDialog r100) {
        this.f139973a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LikeEggTemplatePreviewDialog r101 = this.f139973a;
        n.a r102 = (n.a) CollectionsKt.getOrNull(r101.K, r101.Q);
        if (r102 == null) goto L10;
        k r103 = r102.templatePhoto;
        if (r103 == null) goto L11;
        LikeEggTemplatePreviewDialog r104 = this.f139973a;
        Function2<? super k, ? super Integer, Unit> r105 = r104.L;
        if (r105 == null) goto L12;
        Unit r106 = r105.invoke(r103, Integer.valueOf(r104.Q));
        return;
    L12:
        return;
    L11:
        return;
    }
}
