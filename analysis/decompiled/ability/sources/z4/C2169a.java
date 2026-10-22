package z4;

import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: z4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2169a {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6955a = new ConcurrentHashMap();

    public final void a(C2172d store, C2175g pending, String str) {
        kotlin.jvm.internal.k.f(store, "store");
        kotlin.jvm.internal.k.f(pending, "pending");
        String string = j9.m.R0(str).toString();
        if (string.length() == 0) {
            return;
        }
        C2171c c2171cA = store.a(string);
        if (c2171cA == null) {
            pending.c(string, false);
            return;
        }
        String str2 = c2171cA.b;
        String str3 = c2171cA.c;
        C2174f c2174f = new C2174f(false, string, str2, str3, c2171cA.d, null, null, c2171cA.h, str3, null);
        ConcurrentHashMap concurrentHashMap = this.f6955a;
        if (concurrentHashMap.putIfAbsent(string, c2174f) != null) {
            Log.w("AuthCallbackInbox", "claimCancel ignored: duplicate callback toolCallId=".concat(string));
        } else {
            if (pending.c(string, false)) {
                return;
            }
            concurrentHashMap.remove(string, c2174f);
            Log.w("AuthCallbackInbox", "claimCancel ignored: no waiter or already settled toolCallId=".concat(string));
        }
    }
}
