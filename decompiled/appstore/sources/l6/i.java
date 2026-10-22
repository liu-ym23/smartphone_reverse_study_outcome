package l6;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class i implements SsHttpCall.IHttpCallThrottleControl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile i f21913f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f21917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f21918e;

    public i() {
        this.f21914a = false;
        this.f21915b = 0;
        this.f21916c = false;
        this.f21917d = new CopyOnWriteArraySet();
        this.f21918e = new ConcurrentHashMap();
        a();
    }

    public static i b() {
        if (f21913f != null) goto L16;
        monitor-enter(i.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21913f != null) goto L11;
        f21913f = new i();     // Catch: Throwable -> L9
    L11:
        monitor-exit(i.class);     // Catch: Throwable -> L9
    L16:
        return f21913f;
    }

    public void a() {
        boolean r10 = true;
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_enable", 0) <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.f21914a = r11;
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_use_black_list", 0) > 0) goto L10;
        r10 = false;
    L10:
        this.f21916c = r10;
        this.f21915b = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_whitelist_delay_time", 0);
        h.g(this.f21917d, TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "app_delay_white_list", ""));
        h.d(this.f21918e, TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "app_delay_black_list", ""));
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public int getDelayTimeByApp(String r10) {
        boolean r11 = this.f21916c;
        if (r11 == false) goto L17;
        Map r12 = this.f21918e;
        if (r12 == null) goto L17;
        Iterator r13 = r12.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L32;
        String r14 = (String) r13.next();
        if (TextUtils.isEmpty(r14) == true) goto L8;
        if (r10.startsWith(r14) == false) goto L8;
        Integer r15 = (Integer) this.f21918e.get(r14);
        if (r15 != null) goto L28;
        return 0;
    L28:
        return r15.intValue();
    L32:
        return 0;
    L17:
        if (r11 == false) goto L19;
        return 0;
    L19:
        if (r6.a.a(r10, this.f21917d) == true) goto L21;
        return 0;
    L21:
        return this.f21915b;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public int getDispatchDelayTime(String r10, String r11) {
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().c(r10, r11);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean isAppDelayHandleEnable() {
        return this.f21914a;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean isDispatchDelayEnabled() {
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().n();
    }
}
