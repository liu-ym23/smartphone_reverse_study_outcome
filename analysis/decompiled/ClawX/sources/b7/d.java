package b7;

import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.LightMemException;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.p;
import u6.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f938a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f939b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f940c;

    public /* synthetic */ d(int i8, long j4, Object obj) {
        this.f938a = i8;
        this.f940c = obj;
        this.f939b = j4;
    }

    @Override // p5.a
    public final Object invoke() {
        l lVar;
        boolean z;
        switch (this.f938a) {
            case 0:
                h hVar = (h) this.f940c;
                long j4 = this.f939b;
                synchronized (hVar) {
                    try {
                        if (!hVar.f967u && (lVar = hVar.f957k) != null) {
                            int i8 = hVar.f969w ? hVar.f968v : -1;
                            hVar.f968v++;
                            hVar.f969w = true;
                            if (i8 != -1) {
                                StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                                sb.append(hVar.f950c);
                                sb.append("ms (after ");
                                h.c(hVar, new SocketTimeoutException(m0.f.e(sb, i8 - 1, " successful ping/pongs)")), null, 2);
                            } else {
                                try {
                                    c7.i payload = c7.i.d;
                                    p.e(payload, "payload");
                                    lVar.a(9, payload);
                                } catch (IOException e9) {
                                    h.c(hVar, e9, null, 2);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Long.valueOf(j4);
            case 1:
                return LightMemClient.postOfflineTrigger$lambda$2((h4.c) this.f940c, this.f939b);
            case 2:
                return LightMemClient.postOfflineTrigger$lambda$5((OfflineTriggerResponse) this.f940c, this.f939b);
            case 3:
                return LightMemClient.postOfflineTrigger$lambda$6(this.f939b, (z3.e) this.f940c);
            case 4:
                return LightMemClient.postOfflineTrigger$lambda$7(this.f939b, (LightMemException) this.f940c);
            case 5:
                return LightMemClient.postOfflineTrigger$lambda$8(this.f939b, (Exception) this.f940c);
            default:
                n nVar = (n) this.f940c;
                long j8 = this.f939b;
                synchronized (nVar) {
                    long j9 = nVar.f5725n;
                    long j10 = nVar.f5724m;
                    if (j9 < j10) {
                        z = true;
                    } else {
                        nVar.f5724m = j10 + 1;
                        z = false;
                    }
                }
                if (z) {
                    u6.b bVar = u6.b.d;
                    nVar.a(bVar, bVar, null);
                    j8 = -1;
                } else {
                    try {
                        nVar.y.l(1, 0, false);
                    } catch (IOException e10) {
                        u6.b bVar2 = u6.b.d;
                        nVar.a(bVar2, bVar2, e10);
                    }
                }
                return Long.valueOf(j8);
        }
    }

    public /* synthetic */ d(long j4, Exception exc, int i8) {
        this.f938a = i8;
        this.f939b = j4;
        this.f940c = exc;
    }
}
