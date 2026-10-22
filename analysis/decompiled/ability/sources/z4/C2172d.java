package z4;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: z4.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2172d {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6958a = new ConcurrentHashMap();

    public final C2171c a(String toolCallId) {
        kotlin.jvm.internal.k.f(toolCallId, "toolCallId");
        String string = j9.m.R0(toolCallId).toString();
        if (string.length() <= 0) {
            string = null;
        }
        if (string != null) {
            return (C2171c) this.f6958a.get(string);
        }
        return null;
    }

    public final void b(String str) {
        String string = j9.m.R0(str).toString();
        if (string.length() <= 0) {
            string = null;
        }
        if (string != null) {
        }
    }
}
