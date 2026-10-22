package stepai.aios.guiagent.session;

import N9.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import stepai.aios.guiagent.config.SessionConfig;
import stepai.aios.guiagent.model.TakeoverReasonType;
import u9.c;
import u9.d;
import z2.l;
import za.e;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SessionConfig f6149a;
    public final ConcurrentHashMap b;
    public final kotlinx.coroutines.sync.a c;

    public a(SessionConfig config) {
        k.f(config, "config");
        this.f6149a = config;
        this.b = new ConcurrentHashMap();
        this.c = new kotlinx.coroutines.sync.a();
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        AbstractC1683A.n(AbstractC1683A.b(l.H(r0VarC, c.f6743a)), null, new SessionManager$startCleanupTask$1(this, null), 3);
    }

    public static /* synthetic */ Object s(a aVar, String str, String str2, TakeoverReasonType takeoverReasonType, ContinuationImpl continuationImpl, int i) {
        if ((i & 4) != 0) {
            takeoverReasonType = TakeoverReasonType.b;
        }
        return aVar.r(str, str2, takeoverReasonType, System.currentTimeMillis(), continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r7, stepai.aios.guiagent.config.Action r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r6 = this;
            java.lang.String r0 = "Action added to session: "
            boolean r1 = r9 instanceof stepai.aios.guiagent.session.SessionManager$addAction$1
            if (r1 == 0) goto L15
            r1 = r9
            stepai.aios.guiagent.session.SessionManager$addAction$1 r1 = (stepai.aios.guiagent.session.SessionManager$addAction$1) r1
            int r2 = r1.f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f = r2
            goto L1a
        L15:
            stepai.aios.guiagent.session.SessionManager$addAction$1 r1 = new stepai.aios.guiagent.session.SessionManager$addAction$1
            r1.<init>(r6, r9)
        L1a:
            java.lang.Object r9 = r1.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.f
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            kotlinx.coroutines.sync.a r7 = r1.c
            stepai.aios.guiagent.config.Action r8 = r1.b
            java.lang.String r1 = r1.f6131a
            kotlin.b.b(r9)
            r9 = r7
            r7 = r1
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.b.b(r9)
            r1.f6131a = r7
            r1.b = r8
            kotlinx.coroutines.sync.a r9 = r6.c
            r1.c = r9
            r1.f = r4
            java.lang.Object r1 = r9.lock(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            java.util.concurrent.ConcurrentHashMap r6 = r6.b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L9d
            Da.a r6 = (Da.a) r6     // Catch: java.lang.Throwable -> L9d
            if (r6 == 0) goto L9f
            za.e r1 = r6.f449a     // Catch: java.lang.Throwable -> L9d
            r1.getClass()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = "action"
            kotlin.jvm.internal.k.f(r8, r2)     // Catch: java.lang.Throwable -> L9d
            java.util.List r2 = r1.i     // Catch: java.lang.Throwable -> L9d
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L9d
            r4 = 50
            if (r3 < r4) goto L70
            r3 = 0
            r2.remove(r3)     // Catch: java.lang.Throwable -> L9d
        L70:
            r2.add(r8)     // Catch: java.lang.Throwable -> L9d
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9d
            r1.g = r2     // Catch: java.lang.Throwable -> L9d
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9d
            r6.b = r1     // Catch: java.lang.Throwable -> L9d
            stepai.aios.guiagent.config.ActionType r6 = r8.getType()     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L9d
            r8.append(r7)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r7 = ", action: "
            r8.append(r7)     // Catch: java.lang.Throwable -> L9d
            r8.append(r6)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r7 = "SessionManager"
            N9.j.H(r6, r7)     // Catch: java.lang.Throwable -> L9d
            goto L9f
        L9d:
            r6 = move-exception
            goto La5
        L9f:
            r9.unlock(r5)
            C7.r r6 = C7.r.f317a
            return r6
        La5:
            r9.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.a(java.lang.String, stepai.aios.guiagent.config.Action, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r7, za.b r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r6 = this;
            java.lang.String r0 = "History record added to session: "
            boolean r1 = r9 instanceof stepai.aios.guiagent.session.SessionManager$addPath$1
            if (r1 == 0) goto L15
            r1 = r9
            stepai.aios.guiagent.session.SessionManager$addPath$1 r1 = (stepai.aios.guiagent.session.SessionManager$addPath$1) r1
            int r2 = r1.f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f = r2
            goto L1a
        L15:
            stepai.aios.guiagent.session.SessionManager$addPath$1 r1 = new stepai.aios.guiagent.session.SessionManager$addPath$1
            r1.<init>(r6, r9)
        L1a:
            java.lang.Object r9 = r1.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.f
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            kotlinx.coroutines.sync.a r7 = r1.c
            za.b r8 = r1.b
            java.lang.String r1 = r1.f6132a
            kotlin.b.b(r9)
            r9 = r7
            r7 = r1
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.b.b(r9)
            r1.f6132a = r7
            r1.b = r8
            kotlinx.coroutines.sync.a r9 = r6.c
            r1.c = r9
            r1.f = r4
            java.lang.Object r1 = r9.lock(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            java.util.concurrent.ConcurrentHashMap r6 = r6.b     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L8d
            Da.a r6 = (Da.a) r6     // Catch: java.lang.Throwable -> L8d
            if (r6 == 0) goto L8f
            za.e r1 = r6.f449a     // Catch: java.lang.Throwable -> L8d
            r1.getClass()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = "history"
            kotlin.jvm.internal.k.f(r8, r2)     // Catch: java.lang.Throwable -> L8d
            java.util.List r2 = r1.f7005j     // Catch: java.lang.Throwable -> L8d
            r2.add(r8)     // Catch: java.lang.Throwable -> L8d
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8d
            r1.g = r2     // Catch: java.lang.Throwable -> L8d
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8d
            r6.b = r1     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L8d
            r6.append(r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r7 = ", history record: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L8d
            r6.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r7 = "SessionManager"
            N9.j.H(r6, r7)     // Catch: java.lang.Throwable -> L8d
            goto L8f
        L8d:
            r6 = move-exception
            goto L95
        L8f:
            r9.unlock(r5)
            C7.r r6 = C7.r.f317a
            return r6
        L95:
            r9.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.b(java.lang.String, za.b, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r7, java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r6 = this;
            java.lang.String r0 = "User input added to session: "
            boolean r1 = r9 instanceof stepai.aios.guiagent.session.SessionManager$addUserInput$1
            if (r1 == 0) goto L15
            r1 = r9
            stepai.aios.guiagent.session.SessionManager$addUserInput$1 r1 = (stepai.aios.guiagent.session.SessionManager$addUserInput$1) r1
            int r2 = r1.f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f = r2
            goto L1a
        L15:
            stepai.aios.guiagent.session.SessionManager$addUserInput$1 r1 = new stepai.aios.guiagent.session.SessionManager$addUserInput$1
            r1.<init>(r6, r9)
        L1a:
            java.lang.Object r9 = r1.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.f
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            kotlinx.coroutines.sync.a r7 = r1.c
            java.lang.String r8 = r1.b
            java.lang.String r1 = r1.f6133a
            kotlin.b.b(r9)
            r9 = r7
            r7 = r1
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.b.b(r9)
            r1.f6133a = r7
            r1.b = r8
            kotlinx.coroutines.sync.a r9 = r6.c
            r1.c = r9
            r1.f = r4
            java.lang.Object r1 = r9.lock(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            java.util.concurrent.ConcurrentHashMap r6 = r6.b     // Catch: java.lang.Throwable -> L85
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L85
            Da.a r6 = (Da.a) r6     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L87
            za.e r1 = r6.f449a     // Catch: java.lang.Throwable -> L85
            r1.getClass()     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "input"
            kotlin.jvm.internal.k.f(r8, r2)     // Catch: java.lang.Throwable -> L85
            java.util.List r2 = r1.y     // Catch: java.lang.Throwable -> L85
            r2.add(r8)     // Catch: java.lang.Throwable -> L85
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L85
            r1.g = r2     // Catch: java.lang.Throwable -> L85
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L85
            r6.b = r1     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r6.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "SessionManager"
            N9.j.H(r6, r7)     // Catch: java.lang.Throwable -> L85
            goto L87
        L85:
            r6 = move-exception
            goto L8d
        L87:
            r9.unlock(r5)
            C7.r r6 = C7.r.f317a
            return r6
        L8d:
            r9.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.c(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof stepai.aios.guiagent.session.SessionManager$cleanupExpiredSessions$1
            if (r0 == 0) goto L13
            r0 = r6
            stepai.aios.guiagent.session.SessionManager$cleanupExpiredSessions$1 r0 = (stepai.aios.guiagent.session.SessionManager$cleanupExpiredSessions$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$cleanupExpiredSessions$1 r0 = new stepai.aios.guiagent.session.SessionManager$cleanupExpiredSessions$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlinx.coroutines.sync.a r0 = r0.f6134a
            kotlin.b.b(r6)
            goto L43
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.b.b(r6)
            kotlinx.coroutines.sync.a r6 = r5.c
            r0.f6134a = r6
            r0.d = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L42
            return r1
        L42:
            r0 = r6
        L43:
            r5.e()     // Catch: java.lang.Throwable -> L4c
            r0.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L4c:
            r5 = move-exception
            r0.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void e() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long sessionTimeoutMinutes = this.f6149a.getSessionTimeoutMinutes() * 60 * 1000;
        ConcurrentHashMap concurrentHashMap = this.b;
        Collection collectionValues = concurrentHashMap.values();
        k.e(collectionValues, "<get-values>(...)");
        ArrayList<Da.a> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Da.a aVar = (Da.a) obj;
            e eVar = aVar.f449a;
            int iOrdinal = eVar.e.ordinal();
            if (iOrdinal == 6 || iOrdinal == 7 || iOrdinal == 8) {
                Long l = eVar.h;
                if (jCurrentTimeMillis - (l != null ? l.longValue() : eVar.g) > sessionTimeoutMinutes / 2) {
                    arrayList.add(obj);
                }
            } else if (jCurrentTimeMillis - aVar.b > sessionTimeoutMinutes) {
                arrayList.add(obj);
            }
        }
        for (Da.a aVar2 : arrayList) {
            concurrentHashMap.remove(aVar2.f449a.f7004a);
            j.H("Expired session cleaned: " + aVar2.f449a.f7004a, "SessionManager");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        j.H("Cleaned " + arrayList.size() + " expired sessions", "SessionManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$clearRecoveringFlag$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$clearRecoveringFlag$1 r0 = (stepai.aios.guiagent.session.SessionManager$clearRecoveringFlag$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$clearRecoveringFlag$1 r0 = new stepai.aios.guiagent.session.SessionManager$clearRecoveringFlag$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6135a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6135a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L60
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L60
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L62
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L60
            r0 = 0
            r6.f7008s = r0     // Catch: java.lang.Throwable -> L60
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L60
            r6.g = r0     // Catch: java.lang.Throwable -> L60
            r5.b = r0     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r5 = move-exception
            goto L68
        L62:
            r7.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L68:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.f(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$completeRecovery$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$completeRecovery$1 r0 = (stepai.aios.guiagent.session.SessionManager$completeRecovery$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$completeRecovery$1 r0 = new stepai.aios.guiagent.session.SessionManager$completeRecovery$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6136a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6136a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L7e
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L7e
            if (r5 == 0) goto L80
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L7e
            stepai.aios.guiagent.model.SessionState r0 = r6.p     // Catch: java.lang.Throwable -> L7e
            if (r0 != 0) goto L5a
            stepai.aios.guiagent.model.SessionState r0 = stepai.aios.guiagent.model.SessionState.c     // Catch: java.lang.Throwable -> L7e
        L5a:
            r6.p = r4     // Catch: java.lang.Throwable -> L7e
            r6.n = r4     // Catch: java.lang.Throwable -> L7e
            r6.o = r4     // Catch: java.lang.Throwable -> L7e
            r6.m = r4     // Catch: java.lang.Throwable -> L7e
            r6.f7007r = r4     // Catch: java.lang.Throwable -> L7e
            r1 = 0
            r6.f7008s = r1     // Catch: java.lang.Throwable -> L7e
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7e
            r6.g = r1     // Catch: java.lang.Throwable -> L7e
            stepai.aios.guiagent.model.SessionState r1 = r6.e     // Catch: java.lang.Throwable -> L7e
            boolean r1 = r1.a()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L76
            goto L79
        L76:
            r6.f(r0)     // Catch: java.lang.Throwable -> L7e
        L79:
            long r0 = r6.g     // Catch: java.lang.Throwable -> L7e
            r5.b = r0     // Catch: java.lang.Throwable -> L7e
            goto L81
        L7e:
            r5 = move-exception
            goto L85
        L80:
            r6 = r4
        L81:
            r7.unlock(r4)
            return r6
        L85:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.g(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(za.f r11, java.util.LinkedHashMap r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.h(za.f, java.util.LinkedHashMap, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$getActions$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$getActions$1 r0 = (stepai.aios.guiagent.session.SessionManager$getActions$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$getActions$1 r0 = new stepai.aios.guiagent.session.SessionManager$getActions$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6138a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6138a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L65
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L65
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L67
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L65
            r5.b = r0     // Catch: java.lang.Throwable -> L65
            za.e r5 = r5.f449a     // Catch: java.lang.Throwable -> L65
            java.util.List r5 = r5.i     // Catch: java.lang.Throwable -> L65
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L65
            java.util.List r5 = D7.v.f1(r5)     // Catch: java.lang.Throwable -> L65
            if (r5 != 0) goto L69
            goto L67
        L65:
            r5 = move-exception
            goto L6d
        L67:
            kotlin.collections.EmptyList r5 = kotlin.collections.EmptyList.f4893a     // Catch: java.lang.Throwable -> L65
        L69:
            r7.unlock(r4)
            return r5
        L6d:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.i(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$getSession$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$getSession$1 r0 = (stepai.aios.guiagent.session.SessionManager$getSession$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$getSession$1 r0 = new stepai.aios.guiagent.session.SessionManager$getSession$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6139a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6139a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L5b
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L5b
            if (r5 == 0) goto L5d
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5b
            r5.b = r0     // Catch: java.lang.Throwable -> L5b
            za.e r5 = r5.f449a     // Catch: java.lang.Throwable -> L5b
            goto L5e
        L5b:
            r5 = move-exception
            goto L62
        L5d:
            r5 = r4
        L5e:
            r7.unlock(r4)
            return r5
        L62:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.j(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$markInfoHappened$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$markInfoHappened$1 r0 = (stepai.aios.guiagent.session.SessionManager$markInfoHappened$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$markInfoHappened$1 r0 = new stepai.aios.guiagent.session.SessionManager$markInfoHappened$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6140a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6140a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L62
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L62
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto L64
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L62
            boolean r0 = r6.u     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L59
            goto L5b
        L59:
            r6.u = r3     // Catch: java.lang.Throwable -> L62
        L5b:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L62
            r5.b = r0     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r5 = move-exception
            goto L6a
        L64:
            r7.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L6a:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.k(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.session.SessionManager$startRecovery$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.session.SessionManager$startRecovery$1 r0 = (stepai.aios.guiagent.session.SessionManager$startRecovery$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$startRecovery$1 r0 = new stepai.aios.guiagent.session.SessionManager$startRecovery$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlinx.coroutines.sync.a r6 = r0.b
            java.lang.String r0 = r0.f6142a
            kotlin.b.b(r7)
            r7 = r6
            r6 = r0
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r7)
            r0.f6142a = r6
            kotlinx.coroutines.sync.a r7 = r5.c
            r0.b = r7
            r0.e = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L48
            return r1
        L48:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L70
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L70
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L72
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L70
            stepai.aios.guiagent.model.SessionState r0 = r6.e     // Catch: java.lang.Throwable -> L70
            boolean r0 = r0.a()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L5d
            goto L6b
        L5d:
            stepai.aios.guiagent.model.SessionState r0 = r6.e     // Catch: java.lang.Throwable -> L70
            stepai.aios.guiagent.model.SessionState r1 = stepai.aios.guiagent.model.SessionState.f     // Catch: java.lang.Throwable -> L70
            if (r0 == r1) goto L64
            goto L6b
        L64:
            r6.f7008s = r3     // Catch: java.lang.Throwable -> L70
            stepai.aios.guiagent.model.SessionState r0 = stepai.aios.guiagent.model.SessionState.c     // Catch: java.lang.Throwable -> L70
            r6.f(r0)     // Catch: java.lang.Throwable -> L70
        L6b:
            long r0 = r6.g     // Catch: java.lang.Throwable -> L70
            r5.b = r0     // Catch: java.lang.Throwable -> L70
            goto L73
        L70:
            r5 = move-exception
            goto L77
        L72:
            r6 = r4
        L73:
            r7.unlock(r4)
            return r6
        L77:
            r7.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.l(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r6, java.lang.String r7, za.h r8, stepai.aios.guiagent.model.TakeoverReasonType r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof stepai.aios.guiagent.session.SessionManager$startTakeover$1
            if (r0 == 0) goto L13
            r0 = r10
            stepai.aios.guiagent.session.SessionManager$startTakeover$1 r0 = (stepai.aios.guiagent.session.SessionManager$startTakeover$1) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$startTakeover$1 r0 = new stepai.aios.guiagent.session.SessionManager$startTakeover$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.h
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            kotlinx.coroutines.sync.a r6 = r0.e
            stepai.aios.guiagent.model.TakeoverReasonType r9 = r0.d
            za.h r8 = r0.c
            java.lang.String r7 = r0.b
            java.lang.String r0 = r0.f6143a
            kotlin.b.b(r10)
            r10 = r6
            r6 = r0
            goto L54
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.b.b(r10)
            r0.f6143a = r6
            r0.b = r7
            r0.c = r8
            r0.d = r9
            kotlinx.coroutines.sync.a r10 = r5.c
            r0.e = r10
            r0.h = r3
            java.lang.Object r0 = r10.lock(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L68
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L68
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L68
            if (r5 == 0) goto L6a
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L68
            r6.d(r7, r8, r9)     // Catch: java.lang.Throwable -> L68
            long r7 = r6.g     // Catch: java.lang.Throwable -> L68
            r5.b = r7     // Catch: java.lang.Throwable -> L68
            goto L6b
        L68:
            r5 = move-exception
            goto L6f
        L6a:
            r6 = r4
        L6b:
            r10.unlock(r4)
            return r6
        L6f:
            r10.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.m(java.lang.String, java.lang.String, za.h, stepai.aios.guiagent.model.TakeoverReasonType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r6, java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.session.SessionManager$updateCurrentActionId$1
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.session.SessionManager$updateCurrentActionId$1 r0 = (stepai.aios.guiagent.session.SessionManager$updateCurrentActionId$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$updateCurrentActionId$1 r0 = new stepai.aios.guiagent.session.SessionManager$updateCurrentActionId$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.a r6 = r0.c
            java.lang.String r7 = r0.b
            java.lang.String r0 = r0.f6144a
            kotlin.b.b(r8)
            r8 = r6
            r6 = r0
            goto L4c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r8)
            r0.f6144a = r6
            r0.b = r7
            kotlinx.coroutines.sync.a r8 = r5.c
            r0.c = r8
            r0.f = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L63
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L63
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L65
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L63
            r6.f7006q = r7     // Catch: java.lang.Throwable -> L63
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L63
            r6.g = r0     // Catch: java.lang.Throwable -> L63
            r5.b = r0     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r5 = move-exception
            goto L6b
        L65:
            r8.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L6b:
            r8.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.n(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r6, java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.session.SessionManager$updateSessionError$1
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.session.SessionManager$updateSessionError$1 r0 = (stepai.aios.guiagent.session.SessionManager$updateSessionError$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$updateSessionError$1 r0 = new stepai.aios.guiagent.session.SessionManager$updateSessionError$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.a r6 = r0.c
            java.lang.String r7 = r0.b
            java.lang.String r0 = r0.f6145a
            kotlin.b.b(r8)
            r8 = r6
            r6 = r0
            goto L4c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r8)
            r0.f6145a = r6
            r0.b = r7
            kotlinx.coroutines.sync.a r8 = r5.c
            r0.c = r8
            r0.f = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L63
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L63
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L65
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L63
            r6.l = r7     // Catch: java.lang.Throwable -> L63
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L63
            r6.g = r0     // Catch: java.lang.Throwable -> L63
            r5.b = r0     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r5 = move-exception
            goto L6b
        L65:
            r8.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L6b:
            r8.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.o(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r6, za.c r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.session.SessionManager$updateSessionProgress$1
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.session.SessionManager$updateSessionProgress$1 r0 = (stepai.aios.guiagent.session.SessionManager$updateSessionProgress$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$updateSessionProgress$1 r0 = new stepai.aios.guiagent.session.SessionManager$updateSessionProgress$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.a r6 = r0.c
            za.c r7 = r0.b
            java.lang.String r0 = r0.f6146a
            kotlin.b.b(r8)
            r8 = r6
            r6 = r0
            goto L4c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r8)
            r0.f6146a = r6
            r0.b = r7
            kotlinx.coroutines.sync.a r8 = r5.c
            r0.c = r8
            r0.f = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L73
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L73
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L75
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L73
            r6.getClass()     // Catch: java.lang.Throwable -> L73
            java.lang.String r0 = "progress"
            kotlin.jvm.internal.k.f(r7, r0)     // Catch: java.lang.Throwable -> L73
            r6.f7012x = r7     // Catch: java.lang.Throwable -> L73
            int r0 = r7.f7000a     // Catch: java.lang.Throwable -> L73
            r6.f7010v = r0     // Catch: java.lang.Throwable -> L73
            int r7 = r7.b     // Catch: java.lang.Throwable -> L73
            r6.f7011w = r7     // Catch: java.lang.Throwable -> L73
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L73
            r6.g = r0     // Catch: java.lang.Throwable -> L73
            r5.b = r0     // Catch: java.lang.Throwable -> L73
            goto L75
        L73:
            r5 = move-exception
            goto L7b
        L75:
            r8.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L7b:
            r8.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.p(java.lang.String, za.c, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r6, stepai.aios.guiagent.model.SessionState r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.session.SessionManager$updateSessionState$1
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.session.SessionManager$updateSessionState$1 r0 = (stepai.aios.guiagent.session.SessionManager$updateSessionState$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$updateSessionState$1 r0 = new stepai.aios.guiagent.session.SessionManager$updateSessionState$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.a r6 = r0.c
            stepai.aios.guiagent.model.SessionState r7 = r0.b
            java.lang.String r0 = r0.f6147a
            kotlin.b.b(r8)
            r8 = r6
            r6 = r0
            goto L4c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r8)
            r0.f6147a = r6
            r0.b = r7
            kotlinx.coroutines.sync.a r8 = r5.c
            r0.c = r8
            r0.f = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L62
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L62
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto L64
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L62
            r6.f(r7)     // Catch: java.lang.Throwable -> L62
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L62
            r5.b = r6     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r5 = move-exception
            goto L6a
        L64:
            r8.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L6a:
            r8.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.q(java.lang.String, stepai.aios.guiagent.model.SessionState, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r6, java.lang.String r7, stepai.aios.guiagent.model.TakeoverReasonType r8, long r9, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r5 = this;
            boolean r0 = r11 instanceof stepai.aios.guiagent.session.SessionManager$updateSessionTakeover$1
            if (r0 == 0) goto L13
            r0 = r11
            stepai.aios.guiagent.session.SessionManager$updateSessionTakeover$1 r0 = (stepai.aios.guiagent.session.SessionManager$updateSessionTakeover$1) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            stepai.aios.guiagent.session.SessionManager$updateSessionTakeover$1 r0 = new stepai.aios.guiagent.session.SessionManager$updateSessionTakeover$1
            r0.<init>(r5, r11)
        L18:
            java.lang.Object r11 = r0.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.h
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r9 = r0.e
            kotlinx.coroutines.sync.a r6 = r0.d
            stepai.aios.guiagent.model.TakeoverReasonType r8 = r0.c
            java.lang.String r7 = r0.b
            java.lang.String r0 = r0.f6148a
            kotlin.b.b(r11)
            r11 = r6
            r6 = r0
            goto L54
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.b.b(r11)
            r0.f6148a = r6
            r0.b = r7
            r0.c = r8
            kotlinx.coroutines.sync.a r11 = r5.c
            r0.d = r11
            r0.e = r9
            r0.h = r3
            java.lang.Object r0 = r11.lock(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            java.util.concurrent.ConcurrentHashMap r5 = r5.b     // Catch: java.lang.Throwable -> L77
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L77
            Da.a r5 = (Da.a) r5     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L79
            za.e r6 = r5.f449a     // Catch: java.lang.Throwable -> L77
            r6.n = r7     // Catch: java.lang.Throwable -> L77
            r6.o = r8     // Catch: java.lang.Throwable -> L77
            java.lang.Long r7 = new java.lang.Long     // Catch: java.lang.Throwable -> L77
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L77
            r6.m = r7     // Catch: java.lang.Throwable -> L77
            r7 = 0
            r6.f7008s = r7     // Catch: java.lang.Throwable -> L77
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L77
            r6.g = r7     // Catch: java.lang.Throwable -> L77
            r5.b = r7     // Catch: java.lang.Throwable -> L77
            goto L79
        L77:
            r5 = move-exception
            goto L7f
        L79:
            r11.unlock(r4)
            C7.r r5 = C7.r.f317a
            return r5
        L7f:
            r11.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.a.r(java.lang.String, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
