package r8;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.model.SearchParams;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.b0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends APresenter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Looper f23779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile HandlerC0349a f23780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IView f23781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f23782g;

    /* JADX INFO: renamed from: r8.a$a, reason: collision with other inner class name */
    public final class HandlerC0349a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23783a;

        public HandlerC0349a(a r10, Looper r11) {
            this.f23783a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 2) goto L5;
            List<SearchHotWords> r12 = DataBaseManager.SearchHistory.readSearchHistory();
            this.f23783a.d(1, r10.what, r12);
            return;
        L5:
            if (r11 != 3) goto L7;
            DataBaseManager.SearchHistory.saveSearchHistory((String) r10.obj);
            List<SearchHotWords> r13 = DataBaseManager.SearchHistory.readSearchHistory();
            this.f23783a.d(1, 2, r13);
            return;
        L7:
            if (r11 != 4) goto L9;
            DataBaseManager.SearchHistory.clearSearchHistory();
            d9.a.e().n("0052");
            return;
        L9:
            if (r11 != 5) goto L24;
            String r14 = b0.n().r("search_hot_words", null);
            if (TextUtils.equals(r14, a.g(this.f23783a)) == false) goto L14;
        L15:
            a.h(this.f23783a, r14);
            return;
        L14:
            if (TextUtils.isEmpty(a.g(this.f23783a)) == true) goto L15;
            return;
        }
    }

    public a(IView r10) {
        super(Thread.currentThread());
        this.f23782g = "";
        this.f23781f = r10;
        HandlerThread r11 = new HandlerThread("SearchPresenter[" + r10.getClass().getName() + "]");
        r11.start();
        this.f23779d = r11.getLooper();
        this.f23780e = new HandlerC0349a(this, this.f23779d);
    }

    public static /* synthetic */ String g(a r10) {
        return r10.f23782g;
    }

    public static /* synthetic */ void h(a r10, String r11) {
        r10.i(r11);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter
    public void c() {
        super.c();
        if (this.f23780e == null) goto L6;
        this.f23780e.removeCallbacksAndMessages(null);
    L6:
        if (this.f23779d == null) goto L9;
        this.f23779d.quit();
        return;
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter
    public /* bridge */ /* synthetic */ void e(int r10, Object r11, Object r12) {
        j(r10, (String) r11, (SearchParams) r12);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter
    public void f(Message r10) {
        b(r10.what);
        this.f23781f.onUpdateView(r10.what, Integer.valueOf(r10.arg1), r10.obj);
    }

    public final void i(String r10) {
        List r11 = c9.a.H(r10);
        if (r11 != null) goto L5;
    L7:
        Map r12 = c9.a.I(r10);
        if (r12 != null) goto L10;
    L12:
        List r13 = c9.a.J(r10);
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.size() <= 0) goto L19;
        d(1, 13, r13);
        return;
    L19:
        return;
    L10:
        if (r12.size() <= 0) goto L12;
        d(1, 5, r12);
        goto L12
    L5:
        if (r11.size() <= 0) goto L7;
        d(1, 12, r11);
        goto L7
    }

    public void j(int r10, String r11, SearchParams r12) {
        if (r10 != 17) goto L5;
        a(500005);
        CommonAPIHelper.Y(500005, r12);
        return;
    L5:
        switch(r10) {
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L24;
        };
    L7:
        b(500002);
        a(500001);
        CommonAPIHelper.M(r11);
        return;
    L8:
        a(500002);
        CommonAPIHelper.Y(500002, r12);
        return;
    L9:
        b(500001);
        b(10);
        a(500002);
        CommonAPIHelper.Z(500002, r12);
        return;
    L10:
        a(500003);
        CommonAPIHelper.Z(500003, r12);
        return;
    L11:
        a(1100000);
        CommonAPIHelper.N();
        return;
    L12:
        Message r13 = this.f23780e.obtainMessage();
        r13.what = r10;
        if (TextUtils.isEmpty(r11) == true) goto L15;
        r13.obj = r11;
    L15:
        this.f23780e.sendMessage(r13);
        return;
    }

    public void k() {
        j(2, null, null);
        j(6, null, null);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter, com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        b(r10);
        if (r10 == 500005) goto L18;
        String r15 = null;
        if (r10 == 1100000) goto L15;
        switch(r10) {
            case 500001: goto L13;
            case 500002: goto L8;
            case 500003: goto L8;
            default: goto L24;
        };
    L8:
        if (r13 != null) goto L10;
    L12:
        d(1, r10, c9.a.s(r12, r14, r15));
        return;
    L10:
        if ((r13 instanceof String) == false) goto L12;
        r15 = String.valueOf(r13);
        goto L12
    L13:
        d(1, r10, c9.a.G(r12, r14, (String) r13));
        return;
    L24:
        return;
    L15:
        if (TextUtils.equals(b0.n().r("search_hot_words", null), r12) == true) goto L17;
        this.f23782g = r12;
        b0.n().G("search_hot_words", r12, null);
        i(r12);
        return;
    L17:
        j(5, null, null);
        return;
    L18:
        d(1, r10, c9.a.L(BaseApplication.c(), r12));
    }
}
