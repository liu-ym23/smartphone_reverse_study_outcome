package m8;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.networkv2.rest.AppStoreV15Rest;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.utils.AppStoreCommonError;
import com.bytedanceos.common.utils.n;
import java.util.Observable;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Observable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f22161f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f22163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FetchDataCallBack f22164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FetchDataCallBack f22165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FetchDataCallBack f22166e;

    /* JADX INFO: renamed from: m8.a$a, reason: collision with other inner class name */
    public class HandlerC0315a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22167a;

        public HandlerC0315a(a r10) {
            this.f22167a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            int r11 = r10.what;
            if (r11 != 1) goto L5;
            CommonAPIHelper.e0(a.a(this.f22167a));
            return;
        L5:
            if (r11 != 2) goto L11;
            CommonAPIHelper.f0(a.a(this.f22167a));
            return;
        }
    }

    public class b implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f22169b;

        public b(a r10) {
            this.f22169b = r10;
            this.f22168a = 0;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            if (r10 != 600004) goto L5;
            DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), false);
        L6:
            int r14 = this.f22168a + 2;
            this.f22168a = r14;
            if (r14 == 4) goto L10;
            a.b(this.f22169b, "logout", n.a(BaseApplication.c(), r11, r12));
            this.f22168a = 0;
            return;
        L10:
            return;
        L5:
            DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), false);
            goto L6
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            if (r10 != 600004) goto L5;
            DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), true);
        L6:
            int r15 = this.f22168a + 1;
            this.f22168a = r15;
            if (r15 != 2) goto L10;
            this.f22169b.e();
            this.f22168a = 0;
            return;
        L10:
            return;
        L5:
            DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), true);
            goto L6
        }
    }

    public class c implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22170a;

        public c(a r10) {
            this.f22170a = r10;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            if (r10 != 600004) goto L5;
            DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), false);
            return;
        L5:
            DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), false);
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            if (r10 != 600004) goto L5;
            DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), true);
            return;
        L5:
            DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), true);
        }
    }

    public class d implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22171a;

        public d(a r10) {
            this.f22171a = r10;
        }

        public final void a(String r10) {
            AccountDataCache.b().y(new JSONObject(r10));     // Catch: JSONException -> L4
            a.b(this.f22171a, "account", null);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            j.b("Parse json error:" + e.getMessage());
        }

        public final void b(String r10) {
            AccountDataCache.b().y(new JSONObject(r10).getJSONObject("data"));     // Catch: JSONException -> L4
            a.b(this.f22171a, "account", null);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            j.b("Parse json error:" + e.getMessage());
        }

        public final void c(AppStoreCommonError r10, String r11) {
            AccountDataCache.b().t(a.c(this.f22171a));
        }

        public final void d() {
            a.d(this.f22171a, "");
            AccountDataCache.b().t(a.c(this.f22171a));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [m8.a] */
        public final void e(AppStoreCommonError r10, String r11) {
            if (r10 == null) goto L23;
            int r12 = r10.getErrorCode();
            if (r12 != 1303) goto L7;
        L15:
            JSONObject r13 = new JSONObject(r11);     // Catch: Throwable -> L11 JSONException -> L13
            if (r13.isNull("data") == true) goto L26;
            AccountDataCache.b().x(r13.getJSONObject("data").getString("captcha"));     // Catch: Throwable -> L11 JSONException -> L13
        L26:
        L18:
            d this = this.f22171a;
            a.b(this, TrackerElement.ISLOGIN, r10);
            return;
        L7:
            if (r12 == 1501) goto L15;
            if (r12 == 1502) goto L15;
            String r14 = AccountDataCache.b().m();     // Catch: Throwable -> L11 JSONException -> L13
            AccountDataCache.b().a();     // Catch: Throwable -> L11 JSONException -> L13
            AccountDataCache.b().x(r14);     // Catch: Throwable -> L11 JSONException -> L13
        L11:
            th = move-exception;
            a.b(this.f22171a, TrackerElement.ISLOGIN, r10);
            throw th;
        L13:
            e = move-exception;
            j.b("login result error:" + r11);     // Catch: Throwable -> L11
            e.printStackTrace();     // Catch: Throwable -> L11
            goto L18
        }

        public final void f(String r10) {
            JSONObject r11 = new JSONObject(r10).getJSONObject("data");     // Catch: JSONException -> L5
            String r12 = r11.getJSONObject("user").getString("uid");     // Catch: JSONException -> L5
            String r13 = r11.optString("ticket", null);     // Catch: JSONException -> L5
            AccountDataCache.b().v(r12);     // Catch: JSONException -> L5
            AccountDataCache.b().u(r13);     // Catch: JSONException -> L5
            AccountDataCache.b().r(true);     // Catch: JSONException -> L5
        L7:
            this.f22171a.f();
            a.b(this.f22171a, TrackerElement.ISLOGIN, null);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            j.b("Parse json error:" + e.getMessage());
            goto L7
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            AppStoreCommonError r14 = n.a(BaseApplication.c(), r11, r12);
            switch(r10) {
                case 1000001: goto L7;
                case 1000002: goto L6;
                case 1000003: goto L11;
                case 1000004: goto L11;
                case 1000005: goto L5;
                default: goto L11;
            };
        L5:
            a.b(this.f22171a, "account", r14);
            return;
        L6:
            c(r14, r12);
            return;
        L7:
            e(r14, r12);
            return;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            switch(r10) {
                case 1000001: goto L7;
                case 1000002: goto L6;
                case 1000003: goto L12;
                case 1000004: goto L12;
                case 1000005: goto L5;
                case 1000006: goto L12;
                case 1000007: goto L5;
                case 1000008: goto L4;
                default: goto L12;
            };
        L4:
            a(r12);
            return;
        L5:
            b(r12);
            return;
        L6:
            d();
            EventBus.getDefault().post(new LoginEvent(false));
            return;
        L7:
            j.e("Login Success");
            f(r12);
            AppStoreV15Rest.instance().reportUserInfo(null);
            EventBus.getDefault().post(new LoginEvent(true));
            return;
        }
    }

    static {
    }

    public a(Context r10) {
        this.f22163b = new HandlerC0315a(this);
        this.f22164c = new b(this);
        this.f22165d = new c(this);
        this.f22166e = new d(this);
    }

    public static /* synthetic */ FetchDataCallBack a(a r10) {
        return r10.f22165d;
    }

    public static /* synthetic */ void b(a r10, String r11, AppStoreCommonError r12) {
        r10.k(r11, r12);
    }

    public static /* synthetic */ String c(a r10) {
        return r10.f22162a;
    }

    public static /* synthetic */ String d(a r10, String r11) {
        r10.f22162a = r11;
        return r11;
    }

    public static synchronized a i() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f22161f != null) goto L9;
        f22161f = new a(BaseApplication.c());     // Catch: Throwable -> L7
    L9:
        a r10 = f22161f;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }

    public void e() {
        BaseApplication.c().b().i();
        k("logout", null);
    }

    public void f() {
        if (TextUtils.isEmpty(AccountDataCache.b().j()) == false) goto L5;
        g(this.f22166e);
    L6:
        BaseApplication.c().b().O();
        String r10 = AccountDataCache.b().g();
        if (TextUtils.equals(r10, AccountDataCache.b().i()) == true) goto L10;
        l(r10);
        return;
    L10:
        return;
    L5:
        h(this.f22166e);
        k(TrackerElement.ISLOGIN, null);
        goto L6
    }

    public void g(FetchDataCallBack r10) {
        w8.a.j0().h0(r10);
    }

    public void h(FetchDataCallBack r10) {
        w8.a.j0().i0(r10);
    }

    public void j() {
        k("account_info", null);
    }

    public final void k(String r10, AppStoreCommonError r11) {
        setChanged();
        Bundle r12 = new Bundle();
        r12.putString("key", r10);
        r12.putSerializable("error", r11);
        notifyObservers(r12);
    }

    public final void l(String r10) {
        this.f22162a = r10;
        w8.a.j0().k0(r10, this.f22166e);
    }
}
