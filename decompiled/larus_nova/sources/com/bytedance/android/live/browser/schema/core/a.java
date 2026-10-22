package com.bytedance.android.live.browser.schema.core;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RedirectRule f64197c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, RedirectRule> f64198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f64199b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.a$a, reason: collision with other inner class name */
    public static final class C1055a {
    }

    static {
        f64197c = new RedirectRule(new com.bytedance.android.live.browser.schema.core.strategy.b(-1, "miss placeholder"), null, null);
    }

    public a(RedirectRuleCreator r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f64199b = r100;
        this.f64198a = new HashMap();
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        monitor-enter(this);
        RedirectRule r101 = (RedirectRule) ((HashMap) this.f64198a).get(r100);     // Catch: Throwable -> L19
        RedirectRule r102 = null;
        if (r101 != null) goto L7;
        RedirectRule r103 = this.f64199b.get(r100);     // Catch: Throwable -> L19
        if (r103 == null) goto L15;
        ((HashMap) this.f64198a).put(r100, r103);     // Catch: Throwable -> L19
        r102 = r103;
    L16:
        com.bytedance.android.live.schema.api.utils.a.a("RedirectRuleCache", "miss cache for " + r100);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r102;
    L15:
        ((HashMap) this.f64198a).put(r100, f64197c);     // Catch: Throwable -> L19
        goto L16
    L7:
        if (r101 != f64197c) goto L9;
        r101 = null;
    L9:
        com.bytedance.android.live.schema.api.utils.a.a("RedirectRuleCache", "hit cache for " + r100);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r101;
    L19:
        th = move-exception;
        throw th;
    }
}
