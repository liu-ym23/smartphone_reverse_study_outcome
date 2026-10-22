package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f186785a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f186786a = null;

        public a() {
        }

        static {
            f186786a = new a();
        }
    }

    static {
        f186785a = a.f186786a;
    }

    View a();

    List<QIPresenter> b(View r100);

    void destroy();

    void init();

    void onHide(boolean r100);

    void onShow(boolean r100);
}
