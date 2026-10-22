package j2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.s;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import w0.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f20890a;

    /* JADX INFO: renamed from: j2.a$a, reason: collision with other inner class name */
    public static class C0277a extends com.bytedance.apm6.hub.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20891a;

        /* JADX INFO: renamed from: j2.a$a$a, reason: collision with other inner class name */
        public class C0278a implements EncryptService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0277a f20892a;

            public C0278a(C0277a r10) {
                this.f20892a = r10;
            }

            @Override // com.bytedance.apm6.service.encrypt.EncryptService
            public String tryEncryptRequest(String r10, List r11) {
                return RequestEncryptUtils.g(r10, r11);
            }
        }

        /* JADX INFO: renamed from: j2.a$a$b */
        public class b implements SlardarResponseService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0277a f20893a;

            /* JADX INFO: renamed from: j2.a$a$b$a, reason: collision with other inner class name */
            public class RunnableC0279a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JSONObject f20894a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f20895b;

                public RunnableC0279a(b r10, JSONObject r11) {
                    this.f20895b = r10;
                    this.f20894a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.a(this.f20894a);
                }
            }

            public b(C0277a r10) {
                this.f20893a = r10;
            }

            @Override // com.bytedance.apm6.consumer.slardar.SlardarResponseService
            public void onResponse(JSONObject r10) {
                if (w0.c.F() == true) goto L5;
                return;
            L5:
                AsyncEventManager.e().h(new RunnableC0279a(this, r10));
            }
        }

        /* JADX INFO: renamed from: j2.a$a$c */
        public class c implements IDeviceInfoService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0277a f20896a;

            public c(C0277a r10) {
                this.f20896a = r10;
            }

            @Override // com.bytedance.apm6.service.device.IDeviceInfoService
            public JSONObject getDeviceInfo() {
                JSONObject r10 = new JSONObject();
                d.k().a(r10);
                return r10;
            }
        }

        public C0277a(Context r10) {
            this.f20891a = r10;
        }

        @Override // com.bytedance.apm6.hub.a
        public IDeviceInfoService c() {
            return new c(this);
        }

        @Override // com.bytedance.apm6.hub.a
        public EncryptService d() {
            return new C0278a(this);
        }

        @Override // com.bytedance.apm6.hub.a
        public IEncrypt e() {
            return ApmDelegate.j().i();
        }

        @Override // com.bytedance.apm6.hub.a
        public IHttpService g() {
            return w0.c.l();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public int getAid() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.a();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getAppVersion() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.b();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getChannel() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.c();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public Context getContext() {
            return this.f20891a;
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getDeviceId() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.d();
        }

        @Override // com.bytedance.apm6.hub.a, com.bytedance.apm6.foundation.context.ApmContextAdapter
        public JSONObject getDynamicHeaderExtras() {
            return super.getDynamicHeaderExtras();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public int getManifestVersionCode() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.e();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public JSONObject getOutsideConfig() {
            f r10 = w0.c.u();
            if (r10 == null) goto L8;
            JSONObject r11 = r10.i();
            if (r11 == null) goto L13;
            JSONObject r12 = new JSONObject();     // Catch: JSONException -> L10
            r12.put(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, r11.optInt(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, -1));     // Catch: JSONException -> L10
            return r12;
        L14:
            return null;
        L13:
            return null;
        L8:
            return null;
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public Map getParamsExtras() {
            return w0.c.v();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getProcessName() {
            return w0.c.h();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getReleaseBuild() {
            f r10 = w0.c.u();
            if (r10 == null) goto L5;
            String r11 = r10.g();
        L7:
            if (TextUtils.isEmpty(r11) == true) goto L11;
            if (Objects.equals(r11, "null") == true) goto L11;
            return r11;
        L11:
            return s.a();
        L5:
            r11 = null;
            goto L7
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getSessionId() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.h();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public JSONObject getStableHeaderExtras() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.i();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public long getUid() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.j();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public int getUpdateVersionCode() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.k();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public int getVersionCode() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.k();
        }

        @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
        public String getVersionName() {
            f r10 = w0.c.u();
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.l();
        }

        @Override // com.bytedance.apm6.hub.a
        public IMapsCollectService i() {
            return new j2.b();
        }

        @Override // com.bytedance.apm6.hub.a
        public MemoryConfigService j() {
            return new j2.c();
        }

        @Override // com.bytedance.apm6.hub.a
        public SlardarResponseService l() {
            return new b(this);
        }
    }

    public static void a(JSONObject r10) {
        List r11 = f20890a;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        ((IResponseConfigListener) r12.next()).onResponse(r10);
        goto L6
    L10:
        return;
    }

    public static Runnable b(Context r10) {
        return Apm.c(new C0277a(r10));
    }

    public static void c(IResponseConfigListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (f20890a != null) goto L8;
        f20890a = new CopyOnWriteArrayList();
    L8:
        if (f20890a.contains(r10) == true) goto L11;
        f20890a.add(r10);
        return;
    }

    public static void d(IResponseConfigListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List r11 = f20890a;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }
}
