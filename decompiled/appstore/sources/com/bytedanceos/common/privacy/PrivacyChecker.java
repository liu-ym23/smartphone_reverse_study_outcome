package com.bytedanceos.common.privacy;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrivacyChecker f9899a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet f9900b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedanceos/common/privacy/PrivacyChecker$Observer;", "", "onPrivacyAgreed", "", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Observer {
        void onPrivacyAgreed();
    }

    static {
        f9899a = new PrivacyChecker();
        f9900b = new LinkedHashSet();
    }

    public PrivacyChecker() {
    }

    public final void a(Observer r10) {
        q.g(r10, "observer");
        LinkedHashSet r11 = f9900b;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == false) goto L7;
        boolean r12 = true;
    L9:
        monitor-exit(r11);
        if (r12 == false) goto L18;
        r10.onPrivacyAgreed();
        return;
    L18:
        return;
    L7:
        r11.add(r10);     // Catch: Throwable -> L13
        r12 = false;
        goto L9
    }

    public final void b() {
        LinkedHashSet r10 = f9900b;
        monitor-enter(r10);
        List r11 = b0.x0(r10);     // Catch: Throwable -> L11
        r10.clear();     // Catch: Throwable -> L11
        monitor-exit(r10);
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((Observer) r12.next()).onPrivacyAgreed();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void c(Observer r10) {
        q.g(r10, "observer");
        LinkedHashSet r11 = f9900b;
        monitor-enter(r11);
        r11.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
