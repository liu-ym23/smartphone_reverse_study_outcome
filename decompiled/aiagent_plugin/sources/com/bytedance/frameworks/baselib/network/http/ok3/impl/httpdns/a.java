package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DnsRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f8488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f8489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8491e;
    private final WeakHandler f;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DnsRecord.java */
    public static final enum EnumC0192a extends Enum<EnumC0192a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0192a f8492a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0192a f8493b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0192a f8494c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0192a f8495d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0192a f8496e = null;
        public static final EnumC0192a f = null;
        public static final EnumC0192a g = null;
        private static final /* synthetic */ EnumC0192a[] h = null;

        private EnumC0192a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0192a valueOf(String r2) {
            return (EnumC0192a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0192a.class, r2), EnumC0192a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0192a[] values() {
            return (EnumC0192a[]) ZeusTransformUtils.preCheckCast(h.clone(), EnumC0192a[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC0192a r0 = new EnumC0192a("CACHE_UNSET", 0);
            f8492a = r0;
            EnumC0192a r1 = new EnumC0192a("CACHE_VALID", 1);
            f8493b = r1;
            EnumC0192a r3 = new EnumC0192a("CACHE_STALE_BOTH", 2);
            f8494c = r3;
            EnumC0192a r5 = new EnumC0192a("CACHE_STALE_NETCHANGED", 3);
            f8495d = r5;
            EnumC0192a r7 = new EnumC0192a("CACHE_STALE_EXPIRED", 4);
            f8496e = r7;
            EnumC0192a r9 = new EnumC0192a("PRELOAD_BATCH", 5);
            f = r9;
            EnumC0192a r11 = new EnumC0192a("REFRESH_BATCH", 6);
            g = r11;
            h = new EnumC0192a[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    static {
    }

    public a(String r3, long r4, List<String> r6, List<String> r7, int r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.f8487a = r3;
        this.f8491e = r4;
        this.f8488b = r9;
        this.f8489c = r10;
        this.f8490d = r8;
        this.f = new WeakHandler(e.getService().j().getLooper(), e.getService());
    }

    public void a() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 12;
        a(r0);
        this.f.sendMessageDelayed(r0, this.f8490d * 1000);
        Message r1 = Message.obtain();
        r1.obj = this;
        r1.what = 10;
        a(r1);
        this.f.sendMessageDelayed(r1, (this.f8490d * 1000) + (((long) e.getService().b().get()) * 1000));
    }

    public void b() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 13;
        a(r0);
        this.f.sendMessageDelayed(r0, this.f8490d * 1000);
    }

    public void c() {
        this.f.removeMessages(10);
        this.f.removeMessages(12);
    }

    public void d() {
        this.f.removeMessages(13);
    }

    public void e() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 11;
        a(r0);
        this.f.sendMessageDelayed(r0, ((long) e.getService().a().get()) * 1000);
    }

    public void f() {
        this.f.removeMessages(11);
    }

    public long g() {
        return this.f8491e;
    }

    public long h() {
        return this.f8490d;
    }

    public List<String> i() {
        return this.f8488b;
    }

    public List<String> j() {
        return this.f8489c;
    }

    private void a(Message r3) {
        Bundle r0 = new Bundle();
        r0.putString("dnsrecord_host", this.f8487a);
        r3.setData(r0);
    }
}
