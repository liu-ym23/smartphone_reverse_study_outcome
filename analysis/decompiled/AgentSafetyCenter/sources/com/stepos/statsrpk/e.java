package com.stepos.statsrpk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.blankj.utilcode.util.MessengerUtils$ServerService;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2859a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2860b;

    public e(MessengerUtils$ServerService messengerUtils$ServerService) {
        this.f2859a = 1;
        this.f2860b = messengerUtils$ServerService;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String string;
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.f fVar;
        NetResponse netResponseA = null;
        long time = 0;
        switch (this.f2859a) {
            case 0:
                p5.i iVar = (p5.i) this.f2860b;
                ta.a aVar = (ta.a) iVar.f9733h;
                if (message.what == 1) {
                    try {
                        time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(aVar.f13291a.getString("getTime", "")).getTime();
                    } catch (ParseException unused) {
                    }
                    if (System.currentTimeMillis() - time > (new Random().nextInt(1441) + 1440) * 60000) {
                        b bVar = (b) iVar.f9731f;
                        StringBuilder sb2 = new StringBuilder("getConfigFromServer, now: ");
                        sb2.append(System.currentTimeMillis());
                        sb2.append(", last get time: ");
                        SharedPreferences sharedPreferences = aVar.f13291a;
                        sb2.append(sharedPreferences.getString("getTime", ""));
                        ua.c.a("RpkConfigController", sb2.toString());
                        Context context = (Context) iVar.f9730c;
                        if (!ra.b.f(context)) {
                            ua.c.a("RpkConfigController", "getConfigFromServer, network unavailable");
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("If-Modified-Since", sharedPreferences.getString("lastModified", ""));
                        map.put("If-None-Match", sharedPreferences.getString("ETag", ""));
                        String string2 = Uri.parse(h.f2867e + "rpk/" + bVar.f2848c).buildUpon().toString();
                        ua.c.a("RpkConfigController", "try local... cdn url: " + string2 + ", header: " + map);
                        if (ra.b.e(context)) {
                            try {
                                netResponseA = ia.c.b(context).a(string2, map);
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            } catch (RuntimeException e11) {
                                e11.printStackTrace();
                            }
                            ua.c.a("RpkConfigController", "getConfigFromServer response: " + netResponseA);
                            if (netResponseA == null || netResponseA.f2840c != 200) {
                                if (netResponseA == null || netResponseA.f2840c != 304) {
                                    return;
                                }
                                ua.c.a("RpkConfigController", "config in server has no change");
                                return;
                            }
                            String str = netResponseA.f2841f;
                            if (str != null) {
                                try {
                                    td.h.f(context, str, bVar);
                                    td.h.h(context, str, bVar);
                                    return;
                                } catch (JSONException e12) {
                                    ua.c.b("RpkConfigController", e12.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1:
                MessengerUtils$ServerService messengerUtils$ServerService = (MessengerUtils$ServerService) this.f2860b;
                ConcurrentHashMap concurrentHashMap = messengerUtils$ServerService.f2286c;
                int i = message.what;
                if (i == 0) {
                    concurrentHashMap.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i == 1) {
                    concurrentHashMap.remove(Integer.valueOf(message.arg1));
                    return;
                }
                if (i != 2) {
                    super.handleMessage(message);
                    return;
                }
                int i3 = MessengerUtils$ServerService.f2285h;
                messengerUtils$ServerService.a(message);
                Bundle data = message.getData();
                if (data == null || (string = data.getString("MESSENGER_UTILS")) == null || j6.c.f6598a.get(string) == null) {
                    return;
                }
                od.f.j();
                return;
            case 2:
                oa.a aVar2 = (oa.a) this.f2860b;
                m mVar = aVar2.f9350h;
                if (message.what == 1) {
                    ua.c.a("ActivityLifecycleCallback", "msg.what: ONCE_USE");
                    if (aVar2.f9345c == 0) {
                        ua.c.a("SessionController", "onForeground");
                        ((e) mVar.f9742g).removeCallbacksAndMessages(null);
                        aVar2.f9345c = aVar2.f9343a;
                        aVar2.f9347e = aVar2.f9344b;
                    }
                    ua.c.a("SessionController", "onBackground");
                    e eVar = (e) mVar.f9742g;
                    eVar.removeCallbacksAndMessages(null);
                    eVar.sendEmptyMessageDelayed(1, 30000L);
                    long j10 = aVar2.f9346d - aVar2.f9345c;
                    long j11 = aVar2.f9348f - aVar2.f9347e;
                    ua.c.a("ActivityLifecycleCallback", "onOnceUse, startTime:" + aVar2.f9345c + ", endTime:" + aVar2.f9346d + ", duration:" + j10);
                    if (aVar2.f9345c > 0 && aVar2.f9346d > 0 && j10 > 0) {
                        HashMap map2 = new HashMap();
                        map2.put("startTime", String.valueOf(aVar2.f9345c));
                        map2.put("endTime", String.valueOf(aVar2.f9346d));
                        map2.put("duration", String.valueOf(j10));
                        map2.put("duration2", String.valueOf(j11));
                        ma.e eVar2 = ma.d.f8538a;
                        eVar2.f8545g.a(eVar2.f8539a, "_onceuse_", null, map2, 0);
                    }
                    aVar2.f9348f = 0L;
                    aVar2.f9347e = 0L;
                    aVar2.f9346d = 0L;
                    aVar2.f9345c = 0L;
                    return;
                }
                return;
            case 3:
                ua.c.a("SessionController", "session timeout");
                m mVar2 = (m) this.f2860b;
                if (((String) mVar2.f9741f) != null) {
                    synchronized (mVar2) {
                        ua.c.a("SessionController", "end a session id: " + ((String) mVar2.f9741f));
                        mVar2.f9741f = null;
                    }
                }
                ua.c.a("SessionController", "flush events when session end");
                pa.c cVar = ma.d.f8538a.f8542d;
                if (cVar == null || (fVar = cVar.f9933a) == null) {
                    return;
                }
                ua.c.a("V3OfflineEmitter", "flush");
                ta.a aVar3 = fVar.f2835f;
                if (aVar3 == null || aVar3.f13291a.getAll().size() <= 0) {
                    return;
                }
                ua.c.a("V3OfflineEmitter", "flush sp data");
                ThreadPoolExecutor threadPoolExecutor = fVar.f2834e;
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.a aVar4 = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(0);
                aVar4.f2822g = fVar;
                aVar4.f2821f = true;
                VarHandle.storeStoreFence();
                threadPoolExecutor.execute(aVar4);
                return;
            default:
                synchronized (((la.a) this.f2860b)) {
                    try {
                        la.a aVar5 = (la.a) this.f2860b;
                        if (!aVar5.f7813c) {
                            int i10 = message.what;
                            if (i10 == -1) {
                                aVar5.f7812b = SystemClock.elapsedRealtime() + ((la.a) this.f2860b).f7811a;
                            } else if (i10 == 1) {
                                long jElapsedRealtime = aVar5.f7812b - SystemClock.elapsedRealtime();
                                la.a aVar6 = (la.a) this.f2860b;
                                if (jElapsedRealtime <= 0) {
                                    aVar6.b();
                                    la.a aVar7 = (la.a) this.f2860b;
                                    aVar7.f7812b = (aVar7.f7812b + aVar7.f7811a) - jElapsedRealtime;
                                    sendMessageDelayed(obtainMessage(1), ((la.a) this.f2860b).f7811a);
                                } else if (jElapsedRealtime <= aVar6.f7811a) {
                                    sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, Looper looper, int i) {
        super(looper);
        this.f2859a = i;
        this.f2860b = obj;
    }
}
