package com.bytedance.android.livesdk.chatroom.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StickerPresenter extends n<IView> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f107637g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f107638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ha0.b f107639f;

    public interface IView extends IWidget {
        void OS(DecorationDetail r100);

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    static {
        f107637g = StickerPresenter.class.getSimpleName();
    }

    public IView i0() {
        return (IView) this.f531633a;
    }

    public StickerPresenter() {
        this.f107638e = new CompositeDisposable();
    }

    @Override // q46.b
    public /* bridge */ /* synthetic */ q46.a b0() {
        return i0();
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public void detachView() {
        super.detachView();
        CompositeDisposable r100 = this.f107638e;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f107639f.d1("");
        this.f107639f = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public void g0(IView r100) {
        super.c0(r100);
        if (this.f107639f != null) goto L6;
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        this.f107639f = (ha0.b) com.bytedance.android.live.revenue.core.util.h.d(ha0.b.class);
        return;
    }

    public final String h0(int r100) {
        String r101 = s1.B(r100);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "";
    L6:
        return r101;
    }

    public final void j0(String r100) {
        if (this.f107639f != null) goto L5;
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        this.f107639f = (ha0.b) com.bytedance.android.live.revenue.core.util.h.d(ha0.b.class);
    L5:
        if (r100 != null) goto L7;
        this.f107639f.d1("");
        return;
    L7:
        this.f107639f.d1(r100);
    }
}
