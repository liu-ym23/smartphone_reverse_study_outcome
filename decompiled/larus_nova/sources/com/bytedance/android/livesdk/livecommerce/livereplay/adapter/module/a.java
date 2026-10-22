package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ni2.b f149278l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new f(this.f149278l), new g(this.f149278l)});
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.a();
    }

    public a(ni2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(0);
        this.f149278l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(112), UtilityKotlinExtentionsKt.d(112)));
        return r102;
    }
}
