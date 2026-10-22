package com.bytedance.rpc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RpcException.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends RuntimeException implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<InterfaceC0220a> f9692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9696e;
    private String f;
    private Map<Class<?>, Object> g;

    /* JADX INFO: renamed from: com.bytedance.rpc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RpcException.java */
    public interface InterfaceC0220a {
    }

    static {
        f9692a = new ArrayList();
    }

    public static void a(InterfaceC0220a r2) {
        InterfaceC0220a r3 = (InterfaceC0220a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0220a.class, "com.obric.aiagent.plugin");
        f9692a.add(r3);
    }

    public final Throwable a() {
        return a(getCause());
    }

    public static final Throwable a(Throwable r0) {
        return com.bytedance.rpc.a.a.a(r0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RpcException{code=" + this.f9694c + ", reason=" + getMessage() + ", httpProtocolError=" + this.f9693b + ", requestId=" + this.f9695d + ", errorTime=" + this.f9696e + ", source='" + this.f + "', cause=" + a() + ", tags=" + this.g + '}';
    }
}
