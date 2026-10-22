package s4;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsRecord;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a f24504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHandler f24505d;

    public b(String r10, com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a r11, WeakHandler r12) {
        this.f24502a = b.class.getSimpleName();
        this.f24503b = r10;
        this.f24504c = r11;
        this.f24505d = r12;
    }

    public Void a() {
        long r10 = System.currentTimeMillis();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        InetAddress[] r13 = InetAddress.getAllByName(this.f24503b);     // Catch: UnknownHostException -> L8
        int r14 = r13.length;     // Catch: UnknownHostException -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L15;
        InetAddress r16 = r13[r15];     // Catch: UnknownHostException -> L8
        if ((r16 instanceof Inet4Address) == false) goto L11;
        r11.add(r16.getHostAddress());     // Catch: UnknownHostException -> L8
    L14:
        r15 = r15 + 1;     // Catch: UnknownHostException -> L8
        goto L4
    L11:
        if ((r16 instanceof Inet6Address) == false) goto L13;
        r12.add(r16.getHostAddress());     // Catch: UnknownHostException -> L8
        goto L14
    L13:
        Logger.d(this.f24502a, "local dns server returned a invalid address: " + r16.getHostAddress());     // Catch: UnknownHostException -> L8
        goto L14
    L15:
        Logger.d(this.f24502a, "local dns resolved success for host: " + this.f24503b);     // Catch: UnknownHostException -> L8
        if (r11.size() <= 0) goto L18;
    L19:
        this.f24504c.f(this.f24503b, new DnsRecord(this.f24503b, System.currentTimeMillis(), r11, r12, com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().p().get()));     // Catch: UnknownHostException -> L8
    L23:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().s().get() == true) goto L37;
        Message r17 = Message.obtain();
        r17.obj = this;
        r17.what = 1;
        Bundle r18 = new Bundle();
        r18.putString("localdns_completed_host", this.f24503b);
        r17.setData(r18);
        this.f24505d.sendMessage(r17);
        Logger.d(this.f24502a, "send message to collect result handler for host : " + this.f24503b);
        long r19 = System.currentTimeMillis() - r10;
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L31
        r20.put("host", this.f24503b);     // Catch: JSONException -> L31
        if (r11.size() == 0) goto L29;
    L33:
        r20.put("status", "succeed");     // Catch: JSONException -> L31
        ArrayList r21 = new ArrayList();     // Catch: JSONException -> L31
        r21.addAll(r12);     // Catch: JSONException -> L31
        r21.addAll(r11);     // Catch: JSONException -> L31
        r20.put("result", r21);     // Catch: JSONException -> L31
    L34:
        r20.put("rtt", r19);     // Catch: JSONException -> L31
        Logger.d(this.f24502a, r20.toString());     // Catch: JSONException -> L31
        goto L37
    L29:
        if (r12.size() != 0) goto L33;
        r20.put("status", "failed");     // Catch: JSONException -> L31
        r20.put("result", "");     // Catch: JSONException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L37:
        this.f24504c.y(this.f24503b);
        return null;
    L18:
        if (r12.size() <= 0) goto L23;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return a();
    }
}
