package com.bytedance.apm;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f190608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f190609b;

    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f190610a = null;

        static {
            f190610a = new k();
        }
    }

    public final void b() {
        if (this.f190608a == null) goto L8;
        if (this.f190609b.contains("apm_cache_buffer_full") == true) goto L8;
        this.f190609b.add("apm_cache_buffer_full");
        ((ApmDelegate.e) this.f190608a).getClass();
        EnsureManager.ensureNotReachHere("apm_apm_cache_buffer_full");
    L8:
        if (d.j() == false) goto L11;
        new RuntimeException("apm_cache_buffer_full");
        System.exit(1);
        return;
    }

    public k() {
        this.f190609b = new HashSet();
    }

    public final void a(Throwable r100) {
        boolean r101 = false;
        if (this.f190608a == null) goto L9;
        EnsureManager.reportLogEException(5, r100, "apm_error", false);     // Catch: Throwable -> L7
    L9:
        if (d.j() == true) goto L19;
        JSONObject r102 = d.f190519g;
        if (r102 != null) goto L13;
    L16:
        if (r101 == true) goto L19;
        return;
    L13:
        if (r102.optString("channel") == null) goto L16;
        r101 = d.f190519g.optString("channel").contains("local");
    L19:
        throw new RuntimeException(r100);
    }

    public final void c(Throwable r100, String r101) {
        if (this.f190608a == null) goto L8;
        if (this.f190609b.contains(r101) == true) goto L8;
        this.f190609b.add(r101);
        a r102 = this.f190608a;
        String r103 = "apm_".concat(r101);
        ((ApmDelegate.e) r102).getClass();
        EnsureManager.ensureNotReachHere(r100, r103);
    L8:
        if (d.j() == false) goto L11;
        r100.printStackTrace();
        return;
    }
}
