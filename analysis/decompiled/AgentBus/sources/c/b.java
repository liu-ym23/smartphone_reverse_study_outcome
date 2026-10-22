package c;

import android.content.Context;
import android.content.Intent;
import android.util.LongSparseArray;
import g3.q;
import w7.e0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1666f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1667g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1668h;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f1666f = i2;
        this.f1667g = obj;
        this.f1668h = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1666f) {
            case 0:
                i iVar = (i) this.f1667g;
                iVar.f4074f.a(new c((o) this.f1668h, iVar));
                return;
            case 1:
                Runnable runnable = (Runnable) this.f1667g;
                q qVar = (q) this.f1668h;
                q7.k.e(runnable, "$command");
                q7.k.e(qVar, "this$0");
                try {
                    runnable.run();
                    return;
                } finally {
                    qVar.a();
                }
            case 2:
                g6.a aVar = (g6.a) this.f1667g;
                Context context = (Context) this.f1668h;
                String str = aVar.f3852b;
                if (aVar.h()) {
                    for (Intent intent : aVar.f(context)) {
                        try {
                            intent.setPackage("com.stepos.pushservice");
                            intent.setAction("com.stepos.cloud.pushservice.action.PUSH_MANAGER_SERVICE");
                            intent.putExtra("sdk_version_code", 5000007L);
                            context.startService(intent);
                        } catch (Exception e10) {
                            j6.a.c(str, "sendRequestMessage error " + e10.getMessage());
                        }
                    }
                    return;
                }
                j6.a.c(str, "exec fail, mismatch condition");
                g6.a aVarA = aVar.a();
                if (aVarA != null) {
                    q6.b bVar = q6.a.f8785a;
                    String str2 = aVar.f3853c;
                    String str3 = aVar.f3854d;
                    String packageName = context.getPackageName();
                    long jB = e0.b(context);
                    String strG = aVar.g();
                    String strB = aVar.b(aVarA);
                    String str4 = (String) bVar.f8788h;
                    try {
                        Intent intent2 = new Intent();
                        intent2.addCategory(packageName);
                        intent2.setPackage(packageName);
                        intent2.setAction("com.stepos.push.intent.MESSAGE");
                        intent2.putExtra("method", strG);
                        intent2.putExtra("messageValue", strB);
                        intent2.putExtra("messageSign", q6.b.B0(str2, str3, packageName, jB, strG));
                        context.sendBroadcast(intent2);
                        j6.a.a(str4, "send callback message  packageName: " + packageName);
                        return;
                    } catch (Exception e11) {
                        j6.a.c(str4, "send callback message error " + e11.getMessage());
                        return;
                    }
                }
                return;
            case 3:
                ((ia.m) this.f1667g).D((ja.d) this.f1668h);
                return;
            default:
                n7.b.g((p0.c) this.f1667g, (LongSparseArray) this.f1668h);
                return;
        }
    }
}
