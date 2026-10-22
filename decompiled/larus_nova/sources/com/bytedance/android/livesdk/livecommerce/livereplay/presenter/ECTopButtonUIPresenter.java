package com.bytedance.android.livesdk.livecommerce.livereplay.presenter;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.a;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECTopButtonUIPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f149313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewModelProvider.Factory f149314f;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        int r101 = a.f149355a;
        final AbsECScrollProductCardBaseVideModel r102 = a.a(u(), this.f149313e, this.f149314f);
        if (r102 != null) goto L5;
        return;
    L5:
        c.a(r102, u().e(), ECTopButtonUIPresenter$onBind$1.INSTANCE, new ECTopButtonUIPresenter$onBind$2(this, r102));
        f.a(w(), new ECTopButtonUIPresenter$onBind$3(r102));
    }

    public ECTopButtonUIPresenter(String r100, ViewModelProvider.Factory r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f149313e = r100;
        this.f149314f = r101;
    }
}
