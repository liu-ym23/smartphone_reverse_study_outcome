package com.obric.aiagent.ipc.control;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IPCControl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<P, S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f18632b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, c<Intent, IBinder>> f18633c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f18634a;

    /* JADX INFO: compiled from: IPCControl.kt */
    public interface a<S> {
        void a();

        void a(S r1);
    }

    /* JADX INFO: compiled from: IPCControl.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final Intent a(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r3, MemorySourceLinkType.INTENT);
            if (r3.getComponent() == null) goto L6;
            return r3;
        L6:
            if (r3.getPackage() == null) goto L8;
            return r3;
        L8:
            List<ResolveInfo> r4 = r1.getPackageManager().queryIntentServices(r3, 0);
            o.c(r4, "queryIntentServices(...)");
            if (r4.isEmpty() == false) goto L12;
            return null;
        L12:
            Intent r5 = new Intent(r3);
            r5.setPackage(((ResolveInfo) ZeusTransformUtils.preCheckCast(p.k(r4), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo.packageName);
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IPCControl.kt */
    public static final class C0391c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f18635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18636b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0391c.class) == true) goto L8;
            return false;
        L8:
            C0391c r6 = (C0391c) ZeusTransformUtils.preCheckCast(r5, C0391c.class, "com.obric.aiagent.plugin");
            if (this.f18635a == r6.f18635a) goto L12;
            return false;
        L12:
            if (o.a(this.f18636b, r6.f18636b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f18635a) * 31;
            String r1 = this.f18636b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "CreateResult(isSuccess=" + this.f18635a + ", errMsg=" + this.f18636b + ')';
        }

        public C0391c(boolean r1, String r2) {
            this.f18635a = r1;
            this.f18636b = r2;
        }

        public /* synthetic */ C0391c(boolean r1, String r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }
    }

    public final Context getContext() {
        return this.f18634a;
    }

    static {
        f18632b = new b(null);
        f18633c = new ConcurrentHashMap();
    }
}
