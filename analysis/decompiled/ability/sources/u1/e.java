package u1;

import H.h;
import a.AbstractC0291a;
import android.content.Context;
import android.text.TextUtils;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6690a;
    public final Object b;
    public final AtomicBoolean c;
    public final C2031a d;
    public long e;
    public long f;
    public long g;
    public final d h;
    public final LinkedList i;

    public e(Context context, d dVar, LinkedList linkedList, AtomicBoolean atomicBoolean) {
        super("LogSender");
        this.b = new Object();
        this.e = -1L;
        this.f = 0L;
        this.g = 120000L;
        this.h = dVar;
        this.f6690a = context;
        this.i = linkedList;
        this.c = atomicBoolean;
        if (C2031a.c == null) {
            synchronized (C2031a.class) {
                try {
                    if (C2031a.c == null) {
                        C2031a c2031a = new C2031a();
                        if (context != null) {
                            try {
                                c2031a.f6686a = new Y5.b(context.getApplicationContext(), "lib_log_queue.db", null, 1, 2).getWritableDatabase();
                            } catch (Throwable unused) {
                            }
                        }
                        C2031a.c = c2031a;
                    }
                } finally {
                }
            }
        }
        this.d = C2031a.c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00eb -> B:96:0x0118). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00f2 -> B:93:0x0118). Please report as a decompilation issue!!! */
    public static boolean a(H0.a aVar, String str, byte[] bArr) {
        F0.c cVar;
        JSONObject jSONObject;
        B.b bVarDoPost;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str) && (cVar = H0.c.b) != null) {
            cVar.getClass();
            if (h.b && bArr != null) {
                String str2 = new String(bArr);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        S0.b.j1("DATA_SEND_BEGIN", new JSONObject(str2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            B1.b bVar = new B1.b(3, (byte) 0);
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        try {
                            F0.d dVarA = new F0.d(str, bArr).a(cVar.o);
                            bVarDoPost = h.g.doPost(dVarA.f532a, dVarA.c, dVarA.b);
                        } catch (Throwable unused) {
                        }
                        if (bVarDoPost != null) {
                            int i = bVarDoPost.f171a;
                            bVar.b = i;
                            if (i == 200) {
                                JSONObject jSONObject2 = new JSONObject(new String(bVarDoPost.c));
                                try {
                                    String strOptString = jSONObject2.optString(SettingsConfig.KEY_DATA);
                                    if (!strOptString.isEmpty()) {
                                        jSONObject2 = new JSONObject(AbstractC0291a.g("", strOptString.getBytes()));
                                    }
                                    if (!S0.b.s0(jSONObject2)) {
                                        S0.b.s0(jSONObject2.optJSONObject("configs"));
                                    }
                                    bVar.c = jSONObject2;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                if (h.b) {
                                    S0.b.Q(str, bArr, bVar.b);
                                    str = "Send:\nurl:" + str + " \nresponse:" + bVar.b + " \ndata:" + new String(bArr);
                                    S0.b.o0(str);
                                }
                            } else if (h.b) {
                                S0.b.Q(str, bArr, i);
                                S0.b.o0("Send:\nurl:" + str + " response:" + bVar.b);
                            }
                        } else if (h.b) {
                            S0.b.Q(str, bArr, bVar.b);
                            S0.b.o0("Send:\nurl:" + str + " response:" + bVar.b);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            int i6 = bVar.b;
            if (i6 > 0) {
                H0.b bVar2 = aVar.h;
                bVar2.c = false;
                if (i6 == 200 && (jSONObject = (JSONObject) bVar.c) != null) {
                    if ("success".equals(jSONObject.opt("message"))) {
                        H0.b bVar3 = aVar.h;
                        bVar3.d = 0;
                        bVar3.b = 0L;
                        N.c.f1004a.getClass();
                        List list = F0.c.f517D;
                        F0.b.f516a.d = true;
                        return true;
                    }
                    boolean z10 = ((JSONObject) bVar.c).optInt("is_crash", 0) == 1;
                    boolean zEquals = "drop data".equals(((JSONObject) bVar.c).opt("message"));
                    if (z10 || zEquals) {
                        H0.b.a(aVar.h, true);
                        return false;
                    }
                    H0.b.a(aVar.h, false);
                    return false;
                }
                if (500 <= i6 && i6 <= 600) {
                    H0.b.a(bVar2, false);
                    return false;
                }
            } else {
                aVar.h.c = true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x01d3, code lost:
    
        if (r6 == false) goto L219;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023c A[EDGE_INSN: B:179:0x02ae->B:146:0x023c BREAK  A[LOOP:2: B:171:0x028f->B:189:0x02c7]] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0177  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.e.run():void");
    }
}
