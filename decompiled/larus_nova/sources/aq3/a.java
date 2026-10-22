package aq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f15890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final yp3.e<?> f15891m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        if ((r100 instanceof yp3.f) == true) goto L5;
        return 0;
    L5:
        if (((yp3.f) r100).b(this.f15891m) != null) goto L10;
        return 8;
    L10:
        return 0;
    }

    public a(View r100, yp3.e<?> r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "elementKey");
        super(0);
        this.f15890l = r100;
        this.f15891m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f15890l;
    }
}
