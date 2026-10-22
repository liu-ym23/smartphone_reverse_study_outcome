package h9;

import android.content.Context;
import android.util.Log;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import id.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jb.g;
import jb.i;
import jb.v;
import kb.w;
import kb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f5420a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f5421b = new AtomicBoolean(false);

    public static void a(Context context) {
        Object objL;
        context.getClass();
        AtomicBoolean atomicBoolean = f5421b;
        if (atomicBoolean.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            try {
                g[] gVarArr = {new g("up", "file:////android_asset/up_0.html")};
                HashMap map = new HashMap(x.L(1));
                w.O(map, gVarArr);
                PolicySdk.initSDK(applicationContext, "49460154866533570860", "e10d650459f24d3c8f68d0c26aa9c947", "1.0.0_20260928_192215", map);
                objL = Integer.valueOf(Log.i("PolicySdkInit", "PolicySdk init ok version=" + PolicySdk.getPolicySdkVersion()));
            } catch (Throwable th) {
                objL = c.l(th);
            }
            Throwable thB = i.b(objL);
            if (thB != null) {
                atomicBoolean.set(false);
                Log.e("PolicySdkInit", "PolicySdk init failed: " + thB.getMessage(), thB);
            }
        }
    }

    public static void b(Context context, String str) {
        Object objL;
        try {
            PolicySdkResultBean policySdkResultBeanOpenPolicyByMethod = PolicySdk.openPolicyByMethod(context, Boolean.TRUE, str, "up");
            if ((policySdkResultBeanOpenPolicyByMethod != null ? Integer.valueOf(policySdkResultBeanOpenPolicyByMethod.getCode()) : null) != null && policySdkResultBeanOpenPolicyByMethod.getCode() != 0) {
                Log.w("PolicySdkInit", "openPolicyByMethod code=" + policySdkResultBeanOpenPolicyByMethod.getCode());
            }
            objL = v.f6774a;
        } catch (Throwable th) {
            objL = c.l(th);
        }
        Throwable thB = i.b(objL);
        if (thB != null) {
            Log.e("PolicySdkInit", "openLocalPolicy failed: " + thB.getMessage(), thB);
        }
    }
}
