package com.bytedance.android.livesdk.livecommerce.livereplay.utils;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.c;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f149355a = 0;

    public static dm.a.b c() {
        return dm.a.a("EC_LIVE_REPLAY");
    }

    static {
    }

    public static boolean b(String r100) {
        return TextUtils.equals(r100, "live_fragment_replay");
    }

    public static AbsECScrollProductCardBaseVideModel a(QContext r100, String r101, ViewModelProvider.Factory r102) {
        Intrinsics.checkNotNullParameter(r100, "qContext");
        Intrinsics.checkNotNullParameter(r102, "factory");
        if (b(r101) == false) goto L6;
        return (AbsECScrollProductCardBaseVideModel) c.a(r100, ECReplayScrollProductCardViewModel.class, r102);
    L6:
        return (AbsECScrollProductCardBaseVideModel) c.a(r100, ECScrollProductCardViewModel.class, r102);
    }
}
