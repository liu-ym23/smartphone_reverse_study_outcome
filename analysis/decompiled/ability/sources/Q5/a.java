package Q5;

import A5.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blankj.utilcode.util.MessengerUtils$ServerService;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.d;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsrpk.RpkInfo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1116a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Looper looper, int i) {
        super(looper);
        this.f1116a = i;
        this.b = obj;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        d dVar;
        String string;
        NetResponse netResponseB = null;
        long time = 0;
        boolean z10 = true;
        char c = 1;
        switch (this.f1116a) {
            case 0:
                b bVar = (b) this.b;
                c cVar = bVar.h;
                if (message.what == 1) {
                    W5.c.a("ActivityLifecycleCallback", "msg.what: ONCE_USE");
                    if (bVar.c == 0) {
                        W5.c.a("SessionController", "onForeground");
                        ((a) cVar.c).removeCallbacksAndMessages(null);
                        bVar.c = bVar.f1117a;
                        bVar.e = bVar.b;
                    }
                    W5.c.a("SessionController", "onBackground");
                    a aVar = (a) cVar.c;
                    aVar.removeCallbacksAndMessages(null);
                    aVar.sendEmptyMessageDelayed(1, 30000L);
                    long j5 = bVar.d - bVar.c;
                    long j6 = bVar.f - bVar.e;
                    W5.c.a("ActivityLifecycleCallback", "onOnceUse, startTime:" + bVar.c + ", endTime:" + bVar.d + ", duration:" + j5);
                    if (bVar.c > 0 && bVar.d > 0 && j5 > 0) {
                        HashMap map = new HashMap();
                        map.put("startTime", String.valueOf(bVar.c));
                        map.put("endTime", String.valueOf(bVar.d));
                        map.put(TypedValues.TransitionType.S_DURATION, String.valueOf(j5));
                        map.put("duration2", String.valueOf(j6));
                        O5.d dVar2 = O5.c.f1037a;
                        dVar2.g.f(dVar2.f1038a, "_onceuse_", null, map, 0);
                    }
                    bVar.f = 0L;
                    bVar.e = 0L;
                    bVar.d = 0L;
                    bVar.c = 0L;
                    return;
                }
                return;
            case 1:
                W5.c.a("SessionController", "session timeout");
                c cVar2 = (c) this.b;
                if (((String) cVar2.b) != null) {
                    synchronized (cVar2) {
                        W5.c.a("SessionController", "end a session id: " + ((String) cVar2.b));
                        cVar2.b = null;
                    }
                }
                W5.c.a("SessionController", "flush events when session end");
                R5.d dVar3 = O5.c.f1037a.d;
                if (dVar3 == null || (dVar = (d) dVar3.c) == null) {
                    return;
                }
                W5.c.a("V3OfflineEmitter", "flush");
                V5.a aVar2 = dVar.f;
                if (aVar2 == null || aVar2.f1385a.getAll().size() <= 0) {
                    return;
                }
                W5.c.a("V3OfflineEmitter", "flush sp data");
                dVar.e.execute(new O5.b(dVar, z10, c == true ? 1 : 0));
                return;
            case 2:
                synchronized (((N5.a) this.b)) {
                    try {
                        N5.a aVar3 = (N5.a) this.b;
                        if (!aVar3.c) {
                            int i = message.what;
                            if (i == -1) {
                                aVar3.b = SystemClock.elapsedRealtime() + ((N5.a) this.b).f1009a;
                            } else if (i == 1) {
                                long jElapsedRealtime = aVar3.b - SystemClock.elapsedRealtime();
                                if (jElapsedRealtime <= 0) {
                                    ((N5.a) this.b).b();
                                    N5.a aVar4 = (N5.a) this.b;
                                    aVar4.b = (aVar4.b + aVar4.f1009a) - jElapsedRealtime;
                                    sendMessageDelayed(obtainMessage(1), ((N5.a) this.b).f1009a);
                                } else if (jElapsedRealtime <= ((N5.a) this.b).f1009a) {
                                    sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
            case 3:
                MessengerUtils$ServerService messengerUtils$ServerService = (MessengerUtils$ServerService) this.b;
                ConcurrentHashMap concurrentHashMap = messengerUtils$ServerService.f2197a;
                int i6 = message.what;
                if (i6 == 0) {
                    concurrentHashMap.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i6 == 1) {
                    concurrentHashMap.remove(Integer.valueOf(message.arg1));
                    return;
                }
                if (i6 != 2) {
                    super.handleMessage(message);
                    return;
                }
                int i10 = MessengerUtils$ServerService.d;
                messengerUtils$ServerService.a(message);
                Bundle data = message.getData();
                if (data != null && (string = data.getString("MESSENGER_UTILS")) != null && com.blankj.utilcode.util.c.f2203a.get(string) != null) {
                    throw new ClassCastException();
                }
                return;
            default:
                u1.d dVar4 = (u1.d) this.b;
                if (message.what == 1) {
                    try {
                        time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(((V5.a) dVar4.e).f1385a.getString("getTime", "")).getTime();
                    } catch (ParseException unused) {
                    }
                    if (System.currentTimeMillis() - time > (new Random().nextInt(1441) + 1440) * 60000) {
                        RpkInfo rpkInfo = (RpkInfo) dVar4.c;
                        StringBuilder sb = new StringBuilder("getConfigFromServer, now: ");
                        sb.append(System.currentTimeMillis());
                        sb.append(", last get time: ");
                        SharedPreferences sharedPreferences = ((V5.a) dVar4.e).f1385a;
                        sb.append(sharedPreferences.getString("getTime", ""));
                        W5.c.a("RpkConfigController", sb.toString());
                        Context context = (Context) dVar4.b;
                        if (!T5.b.f(context)) {
                            W5.c.a("RpkConfigController", "getConfigFromServer, network unavailable");
                            return;
                        }
                        HashMap map2 = new HashMap();
                        map2.put("If-Modified-Since", sharedPreferences.getString("lastModified", ""));
                        map2.put("If-None-Match", sharedPreferences.getString("ETag", ""));
                        String string2 = Uri.parse(S0.b.l + "rpk/" + rpkInfo.f3976a).buildUpon().toString();
                        W5.c.a("RpkConfigController", "try local... cdn url: " + string2 + ", header: " + map2);
                        if (T5.b.e(context)) {
                            try {
                                netResponseB = K5.c.a(context).b(map2, string2);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (RuntimeException e6) {
                                e6.printStackTrace();
                            }
                            W5.c.a("RpkConfigController", "getConfigFromServer response: " + netResponseB);
                            if (netResponseB == null || netResponseB.getResponseCode() != 200) {
                                if (netResponseB == null || netResponseB.getResponseCode() != 304) {
                                    return;
                                }
                                W5.c.a("RpkConfigController", "config in server has no change");
                                return;
                            }
                            String responseBody = netResponseB.getResponseBody();
                            if (responseBody != null) {
                                try {
                                    M.a.j(context, responseBody, rpkInfo);
                                    M.a.D(context, responseBody, rpkInfo);
                                    return;
                                } catch (JSONException e9) {
                                    W5.c.b("RpkConfigController", e9.getMessage());
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
        }
    }

    public a(MessengerUtils$ServerService messengerUtils$ServerService) {
        this.f1116a = 3;
        this.b = messengerUtils$ServerService;
    }
}
