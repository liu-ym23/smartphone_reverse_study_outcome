package com.stepos.ability.mcpserver.security;

import M0.k;
import android.util.Log;
import androidx.compose.foundation.b;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import i4.C1554b;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import k4.l;
import k4.o;
import k4.p;
import k4.q;
import k4.y;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class a implements KeyVerifier {

    /* renamed from: a, reason: collision with root package name */
    public final y f3204a;
    public final long b;
    public final long c;
    public final long d;
    public final S7.a e;
    public final k f;
    public final C1554b g;
    public final Map h;
    public final Map i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f3205j;
    public final AtomicLong k;
    public final AtomicLong l;

    static {
        new McpServerConfig(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, 8388607, null);
    }

    public a(y yVar, long j5, long j6, k kVar, final int i, final int i6, C1554b c1554b) {
        CachingKeyValidator$1 nowMs = CachingKeyValidator$1.f3199a;
        kotlin.jvm.internal.k.f(nowMs, "nowMs");
        this.f3204a = yVar;
        this.b = j5;
        this.c = TaskTimeouts.TAKEOVER_IDLE_MS;
        this.d = j6;
        this.e = nowMs;
        this.f = kVar;
        this.g = c1554b;
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap<k4.k, l>() { // from class: com.stepos.ability.mcpserver.security.CachingKeyValidator$Companion$lruMap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(16, 0.75f, true);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof k4.k) {
                    return super.containsKey((k4.k) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof l) {
                    return super.containsValue((l) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object get(Object obj) {
                if (obj instanceof k4.k) {
                    return (l) super.get((k4.k) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof k4.k) ? obj2 : (l) super.getOrDefault((k4.k) obj, (l) obj2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object remove(Object obj) {
                if (obj instanceof k4.k) {
                    return (l) super.remove((k4.k) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<k4.k, l> eldest) {
                kotlin.jvm.internal.k.f(eldest, "eldest");
                return super.size() > i;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof k4.k) && (obj2 instanceof l)) {
                    return super.remove((k4.k) obj, (l) obj2);
                }
                return false;
            }
        });
        kotlin.jvm.internal.k.e(mapSynchronizedMap, "synchronizedMap(...)");
        this.h = mapSynchronizedMap;
        Map mapSynchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap<k4.k, l>() { // from class: com.stepos.ability.mcpserver.security.CachingKeyValidator$Companion$lruMap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(16, 0.75f, true);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof k4.k) {
                    return super.containsKey((k4.k) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof l) {
                    return super.containsValue((l) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object get(Object obj) {
                if (obj instanceof k4.k) {
                    return (l) super.get((k4.k) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof k4.k) ? obj2 : (l) super.getOrDefault((k4.k) obj, (l) obj2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object remove(Object obj) {
                if (obj instanceof k4.k) {
                    return (l) super.remove((k4.k) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<k4.k, l> eldest) {
                kotlin.jvm.internal.k.f(eldest, "eldest");
                return super.size() > i6;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof k4.k) && (obj2 instanceof l)) {
                    return super.remove((k4.k) obj, (l) obj2);
                }
                return false;
            }
        });
        kotlin.jvm.internal.k.e(mapSynchronizedMap2, "synchronizedMap(...)");
        this.i = mapSynchronizedMap2;
        this.f3205j = new ConcurrentHashMap();
        this.k = new AtomicLong(0L);
        this.l = new AtomicLong(0L);
    }

    public static String a(KeyValidation keyValidation) {
        if (keyValidation instanceof q) {
            Set set = ((q) keyValidation).f4811a;
            return b.s(set != null ? Integer.valueOf(set.size()) : "unrestricted", "Valid(scope=", ")");
        }
        if (keyValidation.equals(o.f4809a)) {
            return "Invalid";
        }
        if (keyValidation.equals(p.f4810a)) {
            return "Unavailable";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final KeyValidation b(FutureTask futureTask, k4.k kVar) throws ExecutionException, InterruptedException, TimeoutException {
        S7.a aVar = this.e;
        try {
            Object obj = futureTask.get(20000L, TimeUnit.MILLISECONDS);
            kotlin.jvm.internal.k.c(obj);
            return (KeyValidation) obj;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return p.f4810a;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            String simpleName = cause != null ? cause.getClass().getSimpleName() : null;
            Throwable cause2 = e.getCause();
            androidx.constraintlayout.core.dsl.a.x("in-flight verify failed: ", simpleName, ": ", cause2 != null ? cause2.getMessage() : null, "CachingKeyValidator");
            return c(kVar, ((Number) aVar.invoke()).longValue());
        } catch (TimeoutException unused2) {
            Log.w("CachingKeyValidator", "waiting for in-flight verify timed out");
            return c(kVar, ((Number) aVar.invoke()).longValue());
        }
    }

    public final KeyValidation c(k4.k kVar, long j5) {
        l lVar = (l) this.h.get(kVar);
        if (lVar == null) {
            lVar = (l) this.i.get(kVar);
        }
        p pVar = p.f4810a;
        if (lVar == null) {
            Log.w("CachingKeyValidator", "no fresh verdict and no cached verdict -> 503");
            return pVar;
        }
        long j6 = lVar.b;
        KeyValidation keyValidation = lVar.f4806a;
        if (keyValidation instanceof q) {
            long j10 = j5 - j6;
            long j11 = this.d;
            if (j10 >= j11) {
                Log.w("CachingKeyValidator", "stale Valid too old (age=" + j10 + "ms >= " + j11 + "ms), fail-closed -> 503");
                return pVar;
            }
        }
        Log.w("CachingKeyValidator", "no fresh verdict, reusing stale verdict=" + a(keyValidation) + " age=" + (j5 - j6) + "ms");
        return keyValidation;
    }

    public final long d(KeyValidation keyValidation) {
        if (keyValidation instanceof q) {
            return this.b;
        }
        if (keyValidation.equals(o.f4809a)) {
            return this.c;
        }
        if (keyValidation.equals(p.f4810a)) {
            return 0L;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    @Override // com.stepos.ability.mcpserver.security.KeyVerifier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ability.mcpserver.security.KeyValidation verify(final java.lang.String r9, final k4.c r10) {
        /*
            r8 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.k.f(r9, r0)
            java.lang.String r0 = "identity"
            kotlin.jvm.internal.k.f(r10, r0)
            k4.k r0 = new k4.k
            java.lang.String r1 = r10.f4797a
            java.lang.String r2 = r10.b
            r0.<init>(r9, r1, r2)
            S7.a r1 = r8.e
            java.lang.Object r1 = r1.invoke()
            java.lang.Number r1 = (java.lang.Number) r1
            long r1 = r1.longValue()
            java.util.Map r3 = r8.h
            java.lang.Object r3 = r3.get(r0)
            k4.l r3 = (k4.l) r3
            if (r3 != 0) goto L31
            java.util.Map r3 = r8.i
            java.lang.Object r3 = r3.get(r0)
            k4.l r3 = (k4.l) r3
        L31:
            r4 = 0
            if (r3 != 0) goto L35
            goto L43
        L35:
            com.stepos.ability.mcpserver.security.KeyValidation r5 = r3.f4806a
            long r6 = r3.b
            long r1 = r1 - r6
            long r6 = r8.d(r5)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 >= 0) goto L43
            goto L44
        L43:
            r5 = r4
        L44:
            i4.b r1 = r8.g
            if (r5 != 0) goto L49
            goto L68
        L49:
            if (r1 == 0) goto L50
            java.util.concurrent.atomic.AtomicLong r2 = r1.g
            r2.incrementAndGet()
        L50:
            java.lang.String r2 = a(r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "cache hit verdict="
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "CachingKeyValidator"
            android.util.Log.d(r3, r2)
            r4 = r5
        L68:
            if (r4 == 0) goto L6b
            return r4
        L6b:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask
            k4.j r3 = new k4.j
            r3.<init>()
            r2.<init>(r3)
            java.util.concurrent.ConcurrentHashMap r9 = r8.f3205j
            java.lang.Object r10 = r9.putIfAbsent(r0, r2)
            java.util.concurrent.FutureTask r10 = (java.util.concurrent.FutureTask) r10
            if (r10 != 0) goto L8f
            r2.run()     // Catch: java.lang.Throwable -> L8a
            r9.remove(r0, r2)
            com.stepos.ability.mcpserver.security.KeyValidation r8 = r8.b(r2, r0)
            return r8
        L8a:
            r8 = move-exception
            r9.remove(r0, r2)
            throw r8
        L8f:
            if (r1 == 0) goto L96
            java.util.concurrent.atomic.AtomicLong r9 = r1.i
            r9.incrementAndGet()
        L96:
            java.util.concurrent.atomic.AtomicLong r9 = r8.l
            r9.incrementAndGet()
            com.stepos.ability.mcpserver.security.KeyValidation r8 = r8.b(r10, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.mcpserver.security.a.verify(java.lang.String, k4.c):com.stepos.ability.mcpserver.security.KeyValidation");
    }
}
