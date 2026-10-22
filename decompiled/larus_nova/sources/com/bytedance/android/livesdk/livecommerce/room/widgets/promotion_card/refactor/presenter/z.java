package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class z extends com.bytedance.android.ec.core.utils.rotation.a<List<? extends ECRitTag>> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f152501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Query f152502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Query f152503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ List f152504n;

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r100) {
        if (r100 != 0) goto L4;
        Query r101 = this.f152502l;
    L6:
        return r101.f();
    L4:
        r101 = this.f152503m;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void i(int r100, Object r101) {
        List<ECRitTag> r102 = (List) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        x r103 = this.f152501k;
        if (r100 != 0) goto L5;
        Query r104 = this.f152502l;
    L6:
        r103.E(r104, r102);
        oh.a.c("info", new y(this, r102));
        return;
    L5:
        r104 = this.f152503m;
        goto L6
    }

    public z(x r100, Query r110, Query r111, List r112, List r113, long r114, long r115) {
        this.f152501k = r100;
        this.f152502l = r110;
        this.f152503m = r111;
        this.f152504n = r112;
        super(r113, r114, r115, false);
    }
}
