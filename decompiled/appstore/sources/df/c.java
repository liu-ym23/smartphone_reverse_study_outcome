package df;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    public static class a extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f19191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f19192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19193g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f19194h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f19195i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ JSONObject f19196j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Context f19197k;

        public a(String r10, String r11, String r12, long r13, long r14, JSONObject r15, Context r16) {
            this.f19191e = r10;
            this.f19192f = r11;
            this.f19193g = r12;
            this.f19194h = r13;
            this.f19195i = r14;
            this.f19196j = r15;
            this.f19197k = r16;
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            b r10 = new b();     // Catch: Throwable -> L5
            r10.f19185a = this.f19191e;     // Catch: Throwable -> L5
            r10.f19186b = this.f19192f;     // Catch: Throwable -> L5
            r10.f19187c = this.f19193g;     // Catch: Throwable -> L5
            r10.f19188d = this.f19194h;     // Catch: Throwable -> L5
            r10.f19189e = this.f19195i;     // Catch: Throwable -> L5
            JSONObject r11 = this.f19196j;     // Catch: Throwable -> L5
            if (r11 == null) goto L8;
            r10.f19190f = r11.toString();     // Catch: Throwable -> L5
        L8:
            if (Logger.debug() == false) goto L10;
            Logger.d("PushLog", "category = " + r10.f19185a + " tag = " + r10.f19186b + " label = " + r10.f19187c + " value = " + r10.f19188d + " ext_value = " + this.f19195i + " ext_json = " + r10.f19190f);     // Catch: Throwable -> L5
        L10:
            df.a r12 = df.a.e(this.f19197k);     // Catch: Throwable -> L5
            if (r12 == null) goto L18;
            r12.f(r10);     // Catch: Throwable -> L5
            return;
        L18:
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, JSONObject r19) {
        if (e.b(r12) == false) goto L5;
        return;
    L5:
        if (e.b(r13) == true) goto L10;
        new a(r12, r13, r14, r15, r17, r19, r11).a();
        return;
    }
}
