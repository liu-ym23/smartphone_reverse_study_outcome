package com.bytedance.android.gamecp.business.gamedetail.component.titlebar;

import com.bytedance.android.gamecp.base.gamedetail.GameDetailComponent;
import com.bytedance.android.gamecp.business.gamedetail.page.root.d;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import dt.e;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class TitleRightBtnComponent<P extends p> extends GameDetailComponent<P> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f55133l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f55134k;

    public TitleRightBtnComponent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentClass");
        super(r100);
        this.f55134k = -1.0f;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.GameDetailComponent
    public final void f(final PureWidget<P> r100, JSONObject r101) {
        if (r100 == null) goto L5;
        int r102 = d.f55481b;
        r100.zq(d.a.a(), e.f469988b, null, new TitleRightBtnComponent$readyToShow$$inlined$apply$lambda$1(r100, this));
        return;
    }
}
