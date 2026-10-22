package com.obric.aiagent.applog;

import android.os.Bundle;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.flow.applog.idl.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppLogImpl implements IAppLog {
    public static final a Companion = null;
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String TAG = "AppLogImpl";
    private final CopyOnWriteArrayList<d.h.a.b<String, x>> flowDidCallbacks;
    private final AtomicBoolean hasRegisteredFlowDidCallback;

    /* JADX INFO: compiled from: AppLogImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$urhGNitSCgYnm7E4yizhX7to-9c, reason: not valid java name */
    public static /* synthetic */ void m119lambda$urhGNitSCgYnm7E4yizhX7to9c(AppLogImpl r0, IFlowAppLogIDL r1) {
        registerFlowDidCallbackIfNeeded$lambda$0(r0, r1);
    }

    public AppLogImpl() {
        this.flowDidCallbacks = new CopyOnWriteArrayList();
        this.hasRegisteredFlowDidCallback = new AtomicBoolean(false);
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void init(com.obric.aiagent.applog.a r1) {
        o.e(r1, "configInfo");
        com.obric.aiagent.applog.impl.a.f16126a.a(r1);
        if (r1.h() == false) goto L6;
        com.obric.aiagent.applog.impl.a.f16126a.c();
        return;
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public com.bytedance.applog.h inst() {
        return com.obric.aiagent.applog.impl.a.f16126a.a();
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void report(String r2, Bundle r3) {
        o.e(r2, "event");
        o.e(r3, "bundleParams");
        appendDeviceIdIfNeeded(r3);
        com.obric.aiagent.applog.impl.a.f16126a.a(r2, r3);
        reportToFlow(r2, r3);
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void report(String r2, JSONObject r3) {
        o.e(r2, "event");
        o.e(r3, "params");
        appendDeviceIdIfNeeded(r3);
        com.obric.aiagent.applog.impl.a.f16126a.a(r2, r3);
        reportToFlow(r2, r3);
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void reportToFlow(String r2, Bundle r3) {
        o.e(r2, "event");
        o.e(r3, "bundleParams");
        appendDeviceIdIfNeeded(r3);
        com.obric.aiagent.flow.applog.a.f18577a.a(r2, r3);
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void reportToFlow(String r2, JSONObject r3) {
        o.e(r2, "event");
        o.e(r3, "params");
        appendDeviceIdIfNeeded(r3);
        com.obric.aiagent.flow.applog.a.f18577a.a(r2, r3);
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public String getFlowDid() {
        return com.obric.aiagent.flow.applog.a.f18577a.d();
    }

    @Override // com.obric.aiagent.applog.IAppLog
    public void awaitFlowDid(d.h.a.b<? super String, x> r5) {
        d.h.a.b<String, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "callback");
        String r0 = getFlowDid();
        String r2 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.invoke(r0);
        return;
    L12:
        this.flowDidCallbacks.add(r6);
        registerFlowDidCallbackIfNeeded();
        String r7 = getFlowDid();
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        notifyFlowDidIfReady(r2);
        return;
    L8:
        r1 = false;
        goto L9
    }

    private final void appendDeviceIdIfNeeded(Bundle r3) {
        if (r3.containsKey("device_id") == false) goto L5;
        return;
    L5:
        String r2 = getFlowDid();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r3.putString("device_id", r2);
    }

    private final void appendDeviceIdIfNeeded(JSONObject r3) {
        if (r3.has("device_id") == false) goto L5;
        return;
    L5:
        String r2 = getFlowDid();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r3.put("device_id", r2);
    }

    private final void registerFlowDidCallbackIfNeeded() {
        if (this.hasRegisteredFlowDidCallback.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c.a(aa.b(IFlowAppLogIDL.class), false, true, new $$Lambda$AppLogImpl$urhGNitSCgYnm7E4yizhX7to9c(this));
    }

    private static final void registerFlowDidCallbackIfNeeded$lambda$0(AppLogImpl r2, IFlowAppLogIDL r3) {
        IFlowAppLogIDL r4 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "ipc");
        String r5 = r4.getDid();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r2.notifyFlowDidIfReady(r5);
    }

    private final void notifyFlowDidIfReady(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.flowDidCallbacks.isEmpty() == true) goto L16;
        List r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(this.flowDidCallbacks, Iterable.class, "com.obric.aiagent.plugin"));
        this.flowDidCallbacks.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        ((d.h.a.b) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r4);
        goto L12
    L17:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
