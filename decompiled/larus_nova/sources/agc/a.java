package agc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.f;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f3375f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f3376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f3377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Messenger f3378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ServiceConnectionC0067a f3380e;

    /* JADX INFO: renamed from: agc.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0067a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3381a;

        public ServiceConnectionC0067a(a r100) {
            this.f3381a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            this.f3381a.f3376a = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            f.b("MessageLogClient", "[start]on LogService Connected");
            a r102 = this.f3381a;
            r102.f3376a = new Messenger(r101);
            this.f3381a.b();
        }
    }

    public final void a() {
        WeakReference<Context> r100 = this.f3377b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L13;
        f.b("MessageLogClient", "doBindService");     // Catch: Throwable -> L9
        Intent r101 = new Intent();     // Catch: Throwable -> L9
        r101.setComponent(new ComponentName(this.f3377b.get(), "com.ss.android.message.log.LogService"));     // Catch: Throwable -> L9
        this.f3377b.get().bindService(r101, this.f3380e, 1);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public final void c() {
        if (f.f267065a == false) goto L6;
        f.b("PushLog", "hanldeEnd");
    L6:
        if (this.f3376a == null) goto L19;
        if (this.f3377b.get() == null) goto L17;
        this.f3377b.get().unbindService(this.f3380e);     // Catch: Throwable -> L14
    L17:
        this.f3376a = null;     // Catch: Exception -> L13
        return;
    L20:
        return;
    }

    public final void b() {
        Message r100 = Message.obtain(null, 0);     // Catch: Throwable -> L8
        r100.replyTo = this.f3378c;     // Catch: Throwable -> L8
        Bundle r101 = new Bundle();     // Catch: Throwable -> L8
        r101.putLong("start_id", this.f3379d);     // Catch: Throwable -> L8
        if (f.f267065a == false) goto L6;
        f.b("PushLog", "start_id = " + this.f3379d);     // Catch: Throwable -> L8
    L6:
        r100.obj = r101;     // Catch: Throwable -> L8
        this.f3376a.send(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        c();
    }

    public a(Context r100) {
        this.f3376a = null;
        this.f3379d = 0;
        this.f3380e = new ServiceConnectionC0067a(this);
        this.f3377b = new WeakReference(r100.getApplicationContext());
        Looper r101 = PushThreadHandlerManager.inst().getLooper();
        if (r101 != null) goto L5;
        r101 = Looper.getMainLooper();
    L5:
        this.f3378c = new Messenger(new WeakHandler(r101, this));
        a();
    }

    public final void d(List<Long> r100) {
        if (((ArrayList) r100).size() > 0) goto L14;
        return;
    L14:
        Message r101 = Message.obtain(null, 1);     // Catch: Throwable -> L11
        r101.replyTo = this.f3378c;     // Catch: Throwable -> L11
        Bundle r102 = new Bundle();     // Catch: Throwable -> L11
        r102.putLongArray("event_ids", ArrayUtils.toLongArray(r100));     // Catch: Throwable -> L11
        if (f.f267065a == false) goto L9;
        f.b("PushLog", "event_ids = " + r100);     // Catch: Throwable -> L11
    L9:
        r101.obj = r102;     // Catch: Throwable -> L11
        this.f3376a.send(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        c();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r210) {
    L52:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (f.f267065a == false) goto L7;
        f.b("PushLog", "msg.what = " + r210.what);     // Catch: Throwable -> L52
    L7:
        int r100 = r210.what;     // Catch: Throwable -> L52
        if (r100 != 0) goto L10;
        f.b("MessageLogClient", "[handleMsg] MSG_GET_LOG");     // Catch: Throwable -> L52
        if (zfc.a.a() != null) goto L20;
        f.e("PushLog", "PushHook is null");     // Catch: Throwable -> L52
        return;
    L20:
        Bundle r101 = (Bundle) r210.obj;     // Catch: Throwable -> L52
        String r102 = r101.getString("events");     // Catch: Throwable -> L52
        boolean r103 = r101.getBoolean("has_more");     // Catch: Throwable -> L52
        if (f.f267065a == false) goto L24;
        f.b("PushLog", "events = " + r102 + " has_more = " + r103);     // Catch: Throwable -> L52
    L24:
        if (StringUtils.isEmpty(r102) == true) goto L48;
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L52
        JSONArray r105 = new JSONArray(r102);     // Catch: Throwable -> L52
        int r106 = r105.length();     // Catch: Throwable -> L52
        int r107 = 0;
    L26:
        if (r107 >= r106) goto L46;
        JSONObject r108 = r105.optJSONObject(r107);     // Catch: Throwable -> L52
        if (r108 != null) goto L30;
        r106 = r106;
    L44:
        r107 = r107 + 1;     // Catch: Throwable -> L52
        r106 = r106;
        goto L26
    L30:
        String r110 = r108.optString("category");     // Catch: Throwable -> L52
        String r111 = r108.optString("tag");     // Catch: Throwable -> L52
        String r112 = r108.optString("label");     // Catch: Throwable -> L52
        long r113 = r108.optLong("value");     // Catch: Throwable -> L52
        long r114 = r108.optLong("ext_value");     // Catch: Throwable -> L52
        String r109 = r108.optString("ext_json");     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r109) == false) goto L56;
    L34:
        JSONObject r115 = null;
    L35:
        JSONObject r116 = r115;
        if (f.f267065a == false) goto L40;
        f.b("MessageLogClient", "[handleMsg]tag = " + r111 + " label = " + r112 + " ext_json_str = " + r109 + " ext_json = " + r116);     // Catch: Throwable -> L52
    L40:
        zfc.a.a().onEvent(this.f3377b.get(), r110, r111, r112, r113, r114, r116);     // Catch: Throwable -> L52
        long r117 = r108.optLong(DBDefinition.ID);     // Catch: Throwable -> L52
        if (r117 <= this.f3379d) goto L43;
        this.f3379d = r117;     // Catch: Throwable -> L52
    L43:
        r104.add(Long.valueOf(r117));     // Catch: Throwable -> L52
        goto L44
    L56:
        r115 = new JSONObject(r109);     // Catch: Exception -> L55 Throwable -> L52
    L46:
        if (r104.size() <= 0) goto L48;
        d(r104);     // Catch: Throwable -> L52
    L48:
        if (r103 == false) goto L50;
        b();     // Catch: Throwable -> L52
        return;
    L50:
        c();     // Catch: Throwable -> L52
        return;
    L10:
        if (r100 == 2) goto L13;
        return;
    L13:
        if (f.f267065a == false) goto L15;
        f.b("PushLog", "MSG_END_LOG");     // Catch: Throwable -> L52
    L15:
        c();     // Catch: Throwable -> L52
    }
}
