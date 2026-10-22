package bq3;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f20022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f20023m;

    public static final class a {
    }

    /* JADX INFO: renamed from: bq3.b$b, reason: collision with other inner class name */
    public static final class RunnableC0338b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20025b;

        public RunnableC0338b(b r100, int r101) {
            this.f20024a = r100;
            this.f20025b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f20024a.f20023m;     // Catch: Throwable -> L4
            r100.setPadding(r100.getPaddingLeft(), this.f20024a.f20023m.getPaddingTop(), this.f20024a.f20023m.getPaddingRight(), this.f20025b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return null;
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(0);
        this.f20023m = r100;
        this.f20022l = com.bytedance.android.shopping.extensions.b.b(12);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        if ((r100 instanceof vp3.d) == true) goto L5;
        r100 = null;
    L5:
        vp3.d r101 = (vp3.d) r100;
        if (r101 != null) goto L9;
        return 0;
    L9:
        if (r101.c() == false) goto L11;
        int r102 = 0;
    L13:
        if (this.f20023m.getPaddingBottom() == r102) goto L18;
        RunnableC0338b r103 = new RunnableC0338b(this, r102);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        r103.run();
        goto L18
    L17:
        this.f20023m.post(r103);
    L18:
        return 0;
    L11:
        r102 = this.f20022l;
        goto L13
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f20023m;
    }
}
