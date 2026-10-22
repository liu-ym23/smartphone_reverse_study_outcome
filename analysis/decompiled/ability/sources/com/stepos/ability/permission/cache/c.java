package com.stepos.ability.permission.cache;

import com.zyql.common.utils.upload.TOSUploader;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import m9.q0;
import n5.C1741a;
import s9.C1923c;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f3214a;
    public final b b;
    public final InterfaceC1733z c;
    public final S7.a d;
    public volatile long e;
    public volatile long f;
    public final Object g;
    public final LinkedHashSet h;
    public Long i;

    /* renamed from: j, reason: collision with root package name */
    public Long f3215j;
    public boolean k;
    public q0 l;

    public c(a mapping, b modes, C1923c scope, C1741a clock) {
        k.f(mapping, "mapping");
        k.f(modes, "modes");
        k.f(scope, "scope");
        k.f(clock, "clock");
        this.f3214a = mapping;
        this.b = modes;
        this.c = scope;
        this.d = clock;
        this.g = new Object();
        this.h = new LinkedHashSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008a, code lost:
    
        if (r2.longValue() != r6) goto L15;
     */
    /* JADX WARN: Path cross not found for [B:15:0x0036, B:49:0x008f], limit reached: 84 */
    /* JADX WARN: Path cross not found for [B:44:0x0084, B:15:0x0036], limit reached: 84 */
    /* JADX WARN: Path cross not found for [B:49:0x008f, B:15:0x0036], limit reached: 84 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0067 -> B:49:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0071 -> B:33:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.permission.cache.c r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.permission.cache.c.a(com.stepos.ability.permission.cache.c, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r10 = this;
            com.stepos.ability.permission.cache.b r0 = r10.b
            java.lang.Long r1 = r0.b()
            java.lang.String r2 = "safetyNet"
            java.lang.String r3 = "SlaPermRefresh"
            if (r1 == 0) goto L3c
            long r4 = r1.longValue()
            long[] r1 = o4.a.f5427a
            r6 = 43200000(0x2932e00, double:2.1343636E-316)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L1a
            goto L6d
        L1a:
            long r4 = r0.e
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L28
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L38
        L28:
            S7.a r1 = r0.c
            java.lang.Object r1 = r1.invoke()
            java.lang.Number r1 = (java.lang.Number) r1
            long r4 = r1.longValue()
            long r0 = r0.e
            long r0 = r4 - r0
        L38:
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L6d
        L3c:
            com.stepos.ability.permission.cache.b r0 = r10.b
            java.lang.Long r0 = r0.b()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "safety net triggered (mode age="
            r1.<init>(r4)
            r1.append(r0)
            java.lang.String r0 = "ms, no notify) -> silent refetch"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            P3.c.b(r3, r0)
            com.stepos.ability.permission.cache.b r0 = r10.b
            r1 = 1
            r4 = 0
            r0.c(r2, r1, r4)
            S7.a r0 = r10.d
            java.lang.Object r0 = r0.invoke()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            r10.e = r0
        L6d:
            com.stepos.ability.permission.cache.a r0 = r10.f3214a
            java.lang.Long r0 = r0.a()
            if (r0 == 0) goto L84
            long r0 = r0.longValue()
            long[] r4 = o4.a.f5427a
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L83
            goto L84
        L83:
            return
        L84:
            com.stepos.ability.permission.cache.a r0 = r10.f3214a
            java.lang.Long r0 = r0.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "safety net triggered (mapping age="
            r1.<init>(r4)
            r1.append(r0)
            java.lang.String r0 = "ms) -> silent refetch"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            P3.c.b(r3, r0)
            com.stepos.ability.permission.cache.a r0 = r10.f3214a
            r0.b(r2)
            S7.a r0 = r10.d
            java.lang.Object r0 = r0.invoke()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            r10.f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.permission.cache.c.b():void");
    }

    public final void c(String str) {
        P3.c.b("SlaPermRefresh", str.concat(": fetch mapping(force) + mode(force)"));
        this.f3214a.b(str);
        this.b.c(str, true, false);
        this.f = ((Number) this.d.invoke()).longValue();
        this.e = ((Number) this.d.invoke()).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.permission.cache.c.d(java.lang.String):void");
    }

    public final void e(int i) {
        String strI;
        if (i == 1) {
            f("deny(mode)", false);
            return;
        }
        if (i == 3) {
            long jLongValue = ((Number) this.d.invoke()).longValue();
            long j5 = jLongValue - this.f;
            if (this.f != 0) {
                long[] jArr = o4.a.f5427a;
                if (j5 < TOSUploader.EXPIRED_TIMES) {
                    P3.c.b("SlaPermRefresh", "throttled (last mapping force refresh " + j5 + "ms ago, min 1800000ms) reason=deny(unknownFunction)");
                    return;
                }
            }
            this.f3214a.b("deny(unknownFunction)");
            this.f = jLongValue;
            return;
        }
        if (i == 5) {
            P3.c.b("SlaPermRefresh", "deny(noModeSnapshot) -> immediate force refresh (bypass throttle)");
            this.b.c("deny(noModeSnapshot)", true, false);
            this.e = ((Number) this.d.invoke()).longValue();
            return;
        }
        if (i == 6) {
            P3.c.b("SlaPermRefresh", "deny(noMappingSnapshot) -> immediate force refresh (bypass throttle)");
            this.f3214a.b("deny(noMappingSnapshot)");
            this.f = ((Number) this.d.invoke()).longValue();
            return;
        }
        switch (i) {
            case 0:
                strI = "none";
                break;
            case 1:
                strI = "mode";
                break;
            case 2:
                strI = "redline";
                break;
            case 3:
                strI = "unknownFunction";
                break;
            case 4:
                strI = "scopeMissing";
                break;
            case 5:
                strI = "noModeSnapshot";
                break;
            case 6:
                strI = "noMappingSnapshot";
                break;
            case 7:
                strI = "stale";
                break;
            default:
                strI = androidx.appfunctions.metadata.a.i(i, "unknown(", ")");
                break;
        }
        P3.c.b("SlaPermRefresh", "deny(" + strI + ") -> no refresh (refreshing would not change the verdict)");
    }

    public final boolean f(String str, boolean z10) {
        long jLongValue = ((Number) this.d.invoke()).longValue();
        long j5 = jLongValue - this.e;
        if (!z10 && this.e != 0) {
            long[] jArr = o4.a.f5427a;
            if (j5 < 60000) {
                P3.c.b("SlaPermRefresh", "throttled (last mode force refresh " + j5 + "ms ago, min 60000ms) reason=" + str);
                return false;
            }
        }
        this.b.c(str, true, false);
        this.e = jLongValue;
        return true;
    }

    public final void g() {
        P3.c.b("SlaPermRefresh", "warmUp: fetch mapping(force) + mode(force) in parallel");
        this.f3214a.b("warmup");
        this.b.c("warmup", true, false);
        this.f = ((Number) this.d.invoke()).longValue();
        this.e = ((Number) this.d.invoke()).longValue();
    }
}
