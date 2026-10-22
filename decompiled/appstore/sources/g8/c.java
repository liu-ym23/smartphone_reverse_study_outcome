package g8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.appstore.buss.entity.ApiType;
import com.bytedanceos.appstore.push.RecommendMessageView;
import com.bytedanceos.appstore.ui.MainActivity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.FetchURLDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.n;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b implements FetchURLDataCallBack, FetchDataCallBack {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final LinkedList f20011l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NotificationManager f20012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g8.a f20013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f20019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f20020k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20022b;

        public a(String r10, int r11) {
            this.f20022b = r11;
            this.f20021a = r10;
        }
    }

    static {
        f20011l = new LinkedList();
    }

    public c(Context r10) {
        super(r10);
        this.f20016g = -1;
        this.f20012c = (NotificationManager) r10.getSystemService("notification");
    }

    @Override // com.bytedanceos.common.network.FetchURLDataCallBack
    public void OnFetchURLDataFailed(String r10, Throwable r11, String r12, Object r13) {
        CountDownLatch r14 = (CountDownLatch) r13;
        if (r14 == null) goto L6;
        r14.countDown();
        return;
    }

    @Override // com.bytedanceos.common.network.FetchURLDataCallBack
    public void OnFetchURLDataSuccess(String r10, int r11, String r12, Object r13) {
        j.e(" OnFetchURLDataSuccess :" + r10 + " responseCode:" + r11 + " body : " + r12);
        JSONObject r14 = new JSONObject(r12);     // Catch: Throwable -> L9 JSONException -> L11
        if (r14.has(ServerElements.BODY) == false) goto L13;
        JSONObject r15 = r14.optJSONObject(ServerElements.BODY);     // Catch: Throwable -> L9 JSONException -> L11
        if (r15 == null) goto L13;
        f(r15);     // Catch: Throwable -> L9 JSONException -> L11
    L13:
        CountDownLatch r16 = (CountDownLatch) r13;
        if (r16 == null) goto L20;
    L15:
        r16.countDown();
        return;
    L20:
        return;
    L9:
        th = move-exception;
        CountDownLatch r17 = (CountDownLatch) r13;
        if (r17 == null) goto L24;
        r17.countDown();
    L24:
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r16 = (CountDownLatch) r13;
        if (r16 != null) goto L15;
    }

    @Override // g8.b
    public /* bridge */ /* synthetic */ void a(Object r10) {
        d((Void) r10);
    }

    @Override // g8.b
    public /* bridge */ /* synthetic */ Object b() {
        return e();
    }

    public final a[] c() {
        ArrayList r10 = new ArrayList();
        if (f20011l.size() <= 3) goto L7;
    L4:
        LinkedList r11 = f20011l;
        r10.add((a) r11.pop());
        if (r11.size() > 3) goto L4;
    L7:
        return (a[]) r10.toArray(new a[0]);
    }

    public void d(Void r10) {
        if (this.f20015f == true) goto L6;
        return;
    L6:
        if (this.f20013d.o() == false) goto L8;
        CommonAPIHelper.o(this, this.f20013d.f());
        return;
    L8:
        j();
    }

    public Void e() {
        if (TextUtils.isEmpty(this.f20014e) == false) goto L5;
        return null;
    L5:
        CountDownLatch r10 = new CountDownLatch(1);
        CommonAPIHelper.L(this.f20014e, this, r10);
        r10.await(60, TimeUnit.SECONDS);     // Catch: InterruptedException -> L8
    L10:
        j.e("onThreadHandle :  getRecommendMessageDetailInfo end " + this.f20015f);
        if (this.f20015f == true) goto L13;
        return null;
    L13:
        this.f20013d.q();
        this.f20013d.s("onThreadHandle");
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final void f(JSONObject r10) {
        j.e(" process body A : " + r10);
        g8.a r11 = g8.a.a(r10);
        this.f20013d = r11;
        if (r11 == null) goto L5;
        boolean r12 = true;
    L6:
        this.f20015f = r12;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void g(String r10, String r11) {
        this.f20017h = true;
        CommonAPIHelper.S(this, r10, r11);
    }

    public void h(String r10, String r11) {
        this.f20018i = true;
        this.f20019j = r11;
        this.f20020k = r10;
        CommonAPIHelper.X(this, r10);
    }

    public final int i(String r10) {
        Iterator r11 = f20011l.iterator();
        int r12 = 200;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = Math.max(((a) r11.next()).f20022b, r12);
        goto L4
    L6:
        int r13 = r12 + 1;
        f20011l.add(new a(r10, r13));
        return r13;
    }

    public final void j() {
        Notification.Builder r10 = new Notification.Builder(this.f20008a);
        r10.setSmallIcon(R.drawable.appstore_notify_icon);
        j.e("onHandleComplete handle procedure : " + this.f20016g);
        RecommendMessageView r11 = new RecommendMessageView(this.f20008a.getPackageName());
        if (r11.syncResource(this.f20013d) == false) goto L21;
        Intent r12 = new Intent();
        r12.setPackage("com.obric.appstore");
        r12.setAction("bytedanceos.appstore.recommend.app.detail.internal");
        r12.setFlags(335544320);
        if (this.f20013d.p() == false) goto L8;
        r12.putExtra("type", "topic");
        r12.putExtra(ServerElements.TOPIC_ID, this.f20013d.k());
        r12.putExtra("topic_name", this.f20013d.l());
        r12.putExtra("from_position", "source_position_notification");
    L11:
        int r13 = i(this.f20013d.f());
        r10.setContentIntent(PendingIntent.getActivity(this.f20008a, r13, r12, 167772160));
        r10.setContent(r11);
        r10.setAutoCancel(true);
        r10.setSmallIcon(R.drawable.push_icon);
        r10.setTicker(this.f20013d.j());
        Notification r14 = new n().a(r10).build();
        r14.bigContentView = r11;
        a[] r15 = c();
        if (r15 != null) goto L14;
    L18:
        this.f20012c.notify(r13, r14);
        j.a("send:" + this.f20013d.j() + "  notificationID:" + r13);
        return;
    L14:
        if (r15.length <= 0) goto L18;
        int r16 = r15.length;
        int r17 = 0;
    L16:
        if (r17 >= r16) goto L18;
        a r18 = r15[r17];
        this.f20012c.cancel(r18.f20022b);
        j.a("cancel:" + r18.f20021a + "  notificationID:" + r18.f20022b);
        r17 = r17 + 1;
        goto L16
    L8:
        if (this.f20013d.n() == false) goto L10;
        r12.setClass(this.f20008a, MainActivity.class);
        r12.putExtra("type", ApiType.gift);
        goto L11
    L10:
        r12.putExtra("type", AppInfo.SEARCH_SOURCE_EXTENAL);
        r12.putExtra(AppPermissionActivity.EXTRA_APP_PKG, this.f20013d.f());
        r12.putExtra("from_package", BaseApplication.c().getPackageName());
        r12.putExtra("from_position", "source_position_notification");
        goto L11
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        j.e("onFetchDataFailed: " + r11.getMessage());
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        j.e(" onFetchDataSuccess : responseCode:" + r11 + " body : " + r12);
        JSONObject r15 = new JSONObject(r12);     // Catch: JSONException -> L11
        if (r15.has(ServerElements.BODY) == false) goto L30;
        JSONObject r16 = r15.optJSONObject(ServerElements.BODY);     // Catch: JSONException -> L11
        if (this.f20017h == false) goto L13;
        if (r16 == null) goto L13;
        f(r16);     // Catch: JSONException -> L11
        if (this.f20015f == false) goto L30;
        a8.a.N().V(this.f20013d, this.f20020k);     // Catch: JSONException -> L11
    L13:
        g8.a r17 = this.f20013d;     // Catch: JSONException -> L11
        if (r17 == null) goto L25;
        if (r17.o() == false) goto L25;
        AppInfo r18 = this.f20013d.c();     // Catch: JSONException -> L11
        if (com.bytedanceos.appstore.utils.a.c(r18.appDownloadUrl) == false) goto L23;
        r18.mIsPushReservation = true;     // Catch: JSONException -> L11
        r18.mTitle = this.f20013d.j();     // Catch: JSONException -> L11
        r18.mSubtitle = this.f20013d.i();     // Catch: JSONException -> L11
        if (e.u0() == false) goto L22;
        com.bytedanceos.common.utils.j.a(this.f20008a, r18, false);     // Catch: JSONException -> L11
        goto L30
    L22:
        a8.a r19 = a8.a.N();     // Catch: JSONException -> L11
        g8.a r20 = this.f20013d;     // Catch: JSONException -> L11
        r19.V(r20, r20.f());     // Catch: JSONException -> L11
        HashMap r21 = new HashMap();     // Catch: JSONException -> L11
        r21.put(r18.appPackageName, r18);     // Catch: JSONException -> L11
        DataBaseManager.ReserveApps.insert(r21);     // Catch: JSONException -> L11
        goto L30
    L23:
        e0.e(R.string.download_error_url);     // Catch: JSONException -> L11
    L25:
        if (this.f20018i == false) goto L30;
        g(this.f20019j, this.f20020k);     // Catch: JSONException -> L11
    L30:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
