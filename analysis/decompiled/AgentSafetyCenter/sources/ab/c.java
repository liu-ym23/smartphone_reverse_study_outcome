package ab;

import android.graphics.Paint;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kb.s;
import kb.u;
import od.z;
import org.json.JSONException;
import org.json.JSONObject;
import xb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static int f380e;

    /* renamed from: f, reason: collision with root package name */
    public static long f381f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f382a;

    /* renamed from: b, reason: collision with root package name */
    public Object f383b;

    /* renamed from: c, reason: collision with root package name */
    public Object f384c;

    /* renamed from: d, reason: collision with root package name */
    public Object f385d;

    public c(View view) {
        this.f383b = view;
        new Paint(1).setStyle(Paint.Style.FILL);
        b bVar = new b(0);
        bVar.f379f = this;
        VarHandle.storeStoreFence();
        view.addOnAttachStateChangeListener(bVar);
        this.f385d = u.f7406c;
    }

    public pa.c a() {
        pa.a aVar;
        pa.c cVar = new pa.c();
        cVar.f9933a = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.f383b;
        qa.c cVar2 = (qa.c) this.f385d;
        cVar.f9934b = cVar2;
        AgentSafetyApplication agentSafetyApplication = (AgentSafetyApplication) this.f384c;
        cVar.f9935c = agentSafetyApplication;
        boolean z10 = this.f382a;
        cVar.f9936d = z10;
        cVar2.f10214d.put("debug", Boolean.valueOf(z10));
        cVar.f9937e = new HashMap();
        ta.a aVar2 = new ta.a(agentSafetyApplication, "com.stepos.statsapp.v3.event_filter");
        cVar.f9938f = aVar2;
        Iterator<Map.Entry<String, ?>> it = aVar2.f13291a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject(it.next().getValue().toString());
                aVar = new pa.a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
            } catch (JSONException e10) {
                e10.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                cVar.f9937e.put(aVar.f9926a, aVar);
            }
        }
        ua.c.e("Tracker", "Tracker created successfully.");
        return cVar;
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.List] */
    public boolean b(int i, float f5, l lVar) {
        Object objL;
        View view = (View) this.f383b;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            e();
            try {
                y9.f fVar = new y9.f();
                fVar.f16049a = view;
                fVar.f16050b = new ArrayList();
                VarHandle.storeStoreFence();
                fVar.f16051c = i == 1;
                fVar.f16052d = f5;
                fVar.f16053e = true;
                y9.f fVar2 = (y9.f) lVar.invoke(fVar);
                if (fVar2.f16051c) {
                    objL = fVar2.c();
                } else {
                    z9.i iVar = z9.i.f16559a;
                    e eVar = new e(22);
                    eVar.f393f = fVar2;
                    VarHandle.storeStoreFence();
                    objL = (y9.i) iVar.e(eVar);
                }
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Throwable thB = jb.i.b(objL);
            if (thB != null) {
                Log.w("StepOSGlass", "glass commit failed on ".concat(view.getClass().getSimpleName()), thB);
                objL = null;
            }
            y9.i iVar2 = (y9.i) objL;
            this.f384c = iVar2;
            this.f382a = (iVar2 != null ? iVar2.f16057b.size() : 0) > 0;
            this.f385d = iVar2 != null ? kb.l.O0(iVar2.a()) : u.f7406c;
            String simpleName = view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(view);
            boolean z10 = this.f382a;
            int size = iVar2 != null ? iVar2.f16057b.size() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z10 + " count=" + size + " ids=" + ((Set) this.f385d) + " live=" + f380e + " size=" + view.getWidth() + "x" + view.getHeight());
            if (iVar2 != null) {
                int i3 = f380e + 1;
                f380e = i3;
                Trace.setCounter("StepOS:".concat("glass.liveHandles"), i3);
                long j10 = f381f + 1;
                f381f = j10;
                Trace.setCounter("StepOS:".concat("glass.applyCount"), j10);
            }
            if (!this.f382a) {
                Log.i("StepOSGlass", "glass inactive on " + view.getClass().getSimpleName() + "（scope=" + i + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.f382a;
        } finally {
            Trace.endSection();
        }
    }

    public void c(boolean z10) {
        w5.e eVar = (w5.e) this.f385d;
        synchronized (eVar) {
            try {
                if (this.f382a) {
                    throw new IllegalStateException("editor is closed");
                }
                if (k.a(((w5.b) this.f383b).f15240g, this)) {
                    w5.e.d(eVar, this, z10);
                }
                this.f382a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public z d(int i) {
        z zVar;
        w5.e eVar = (w5.e) this.f385d;
        synchronized (eVar) {
            if (this.f382a) {
                throw new IllegalStateException("editor is closed");
            }
            ((boolean[]) this.f384c)[i] = true;
            Object obj = ((w5.b) this.f383b).f15237d.get(i);
            w5.d dVar = eVar.f15261t;
            z zVar2 = (z) obj;
            if (!dVar.f(zVar2)) {
                i6.d.a(dVar.k(zVar2));
            }
            zVar = (z) obj;
        }
        return zVar;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, java.util.List] */
    public void e() {
        View view = (View) this.f383b;
        y9.i iVar = (y9.i) this.f384c;
        u uVar = u.f7406c;
        if (iVar == null) {
            this.f382a = false;
            this.f385d = uVar;
            return;
        }
        Trace.beginSection("StepOS:GlassDelegate.release");
        try {
            Log.i("StepOSGlass", "release " + view.getClass().getSimpleName() + "#" + System.identityHashCode(view) + " live=" + f380e + " size=" + view.getWidth() + "x" + view.getHeight());
            try {
                if (!iVar.f16057b.isEmpty()) {
                    if (iVar.f16056a) {
                        iVar.b();
                    } else {
                        z9.i iVar2 = z9.i.f16559a;
                        e eVar = new e(23);
                        eVar.f393f = iVar;
                        VarHandle.storeStoreFence();
                        iVar2.e(eVar);
                    }
                    iVar.f16057b = s.f7404c;
                }
            } catch (Throwable th) {
                id.c.l(th);
            }
            this.f384c = null;
            this.f382a = false;
            this.f385d = uVar;
            int i = f380e - 1;
            f380e = i;
            Trace.setCounter("StepOS:".concat("glass.liveHandles"), i);
        } finally {
            Trace.endSection();
        }
    }

    public c(w5.e eVar, w5.b bVar) {
        this.f385d = eVar;
        this.f383b = bVar;
        this.f384c = new boolean[2];
    }
}
