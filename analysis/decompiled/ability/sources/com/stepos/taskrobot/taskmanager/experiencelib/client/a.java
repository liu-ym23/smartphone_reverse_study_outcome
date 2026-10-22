package com.stepos.taskrobot.taskmanager.experiencelib.client;

import C7.f;
import F9.F;
import com.google.gson.Gson;
import com.stepos.taskrobot.taskmanager.experiencelib.api.ExperienceApi;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.k;
import n5.C1741a;
import qa.N;
import ra.C1884a;
import u1.d;

/* loaded from: classes3.dex */
public final class a {
    public static final F1.a e = new F1.a();
    public static volatile a f;

    /* renamed from: a, reason: collision with root package name */
    public final String f4055a;
    public final f b = kotlin.a.a(new C1741a(4));
    public final f c;
    public final f d;

    public a(String str) {
        this.f4055a = str;
        final int i = 0;
        this.c = kotlin.a.a(new S7.a(this) { // from class: q6.a
            public final /* synthetic */ com.stepos.taskrobot.taskmanager.experiencelib.client.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                switch (i) {
                    case 0:
                        d dVar = new d(20);
                        com.stepos.taskrobot.taskmanager.experiencelib.client.a aVar = this.b;
                        dVar.I(aVar.f4055a);
                        F f7 = (F) aVar.b.getF4884a();
                        Objects.requireNonNull(f7, "client == null");
                        dVar.b = f7;
                        ((ArrayList) dVar.d).add(C1884a.c(new Gson()));
                        return dVar.J();
                    default:
                        Object f4884a = this.b.c.getF4884a();
                        k.e(f4884a, "getValue(...)");
                        return (ExperienceApi) ((N) f4884a).b(ExperienceApi.class);
                }
            }
        });
        final int i6 = 1;
        this.d = kotlin.a.a(new S7.a(this) { // from class: q6.a
            public final /* synthetic */ com.stepos.taskrobot.taskmanager.experiencelib.client.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        d dVar = new d(20);
                        com.stepos.taskrobot.taskmanager.experiencelib.client.a aVar = this.b;
                        dVar.I(aVar.f4055a);
                        F f7 = (F) aVar.b.getF4884a();
                        Objects.requireNonNull(f7, "client == null");
                        dVar.b = f7;
                        ((ArrayList) dVar.d).add(C1884a.c(new Gson()));
                        return dVar.J();
                    default:
                        Object f4884a = this.b.c.getF4884a();
                        k.e(f4884a, "getValue(...)");
                        return (ExperienceApi) ((N) f4884a).b(ExperienceApi.class);
                }
            }
        });
        new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Request failed: "
            boolean r1 = r8 instanceof com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$deleteExperience$1
            if (r1 == 0) goto L15
            r1 = r8
            com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$deleteExperience$1 r1 = (com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$deleteExperience$1) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.c = r2
            goto L1a
        L15:
            com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$deleteExperience$1 r1 = new com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$deleteExperience$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.f4052a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.c
            java.lang.String r4 = "ExperienceClient"
            r5 = 1
            if (r3 == 0) goto L36
            if (r3 != r5) goto L2e
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L2b
            goto L60
        L2b:
            r6 = move-exception
            goto Laa
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.b.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "---------------------deleteExperience  "
            r8.<init>(r3)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            f6.AbstractC1436a.a(r4, r8, r5)
            C7.f r6 = r6.d     // Catch: java.lang.Exception -> L2b
            java.lang.Object r6 = r6.getF4884a()     // Catch: java.lang.Exception -> L2b
            java.lang.String r8 = "getValue(...)"
            kotlin.jvm.internal.k.e(r6, r8)     // Catch: java.lang.Exception -> L2b
            com.stepos.taskrobot.taskmanager.experiencelib.api.ExperienceApi r6 = (com.stepos.taskrobot.taskmanager.experiencelib.api.ExperienceApi) r6     // Catch: java.lang.Exception -> L2b
            r1.c = r5     // Catch: java.lang.Exception -> L2b
            java.lang.Object r8 = r6.deleteExperience(r7, r1)     // Catch: java.lang.Exception -> L2b
            if (r8 != r2) goto L60
            return r2
        L60:
            qa.L r8 = (qa.L) r8     // Catch: java.lang.Exception -> L2b
            F9.M r6 = r8.f5644a     // Catch: java.lang.Exception -> L2b
            boolean r6 = r6.c()     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L7d
            java.lang.Object r6 = r8.b     // Catch: java.lang.Exception -> L2b
            com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse r6 = (com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse) r6     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L71
            return r6
        L71:
            java.lang.Exception r6 = new java.lang.Exception     // Catch: java.lang.Exception -> L2b
            java.lang.String r7 = "Response body is null"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L2b
            kotlin.Result$Failure r6 = kotlin.b.a(r6)     // Catch: java.lang.Exception -> L2b
            return r6
        L7d:
            F9.P r6 = r8.c     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L86
            java.lang.String r6 = r6.g()     // Catch: java.lang.Exception -> L2b
            goto L88
        L86:
            java.lang.String r6 = "Unknown error"
        L88:
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Exception -> L2b
            F9.M r8 = r8.f5644a     // Catch: java.lang.Exception -> L2b
            int r8 = r8.d     // Catch: java.lang.Exception -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2b
            r1.append(r8)     // Catch: java.lang.Exception -> L2b
            java.lang.String r8 = " - "
            r1.append(r8)     // Catch: java.lang.Exception -> L2b
            r1.append(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L2b
            r7.<init>(r6)     // Catch: java.lang.Exception -> L2b
            kotlin.Result$Failure r6 = kotlin.b.a(r7)     // Catch: java.lang.Exception -> L2b
            return r6
        Laa:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "---------------------deleteExperience fail "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            f6.AbstractC1436a.a(r4, r7, r5)
            kotlin.Result$Failure r6 = kotlin.b.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmanager.experiencelib.client.a.a(com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable b(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Request failed: "
            boolean r1 = r8 instanceof com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$injectExperience$1
            if (r1 == 0) goto L15
            r1 = r8
            com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$injectExperience$1 r1 = (com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$injectExperience$1) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.c = r2
            goto L1a
        L15:
            com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$injectExperience$1 r1 = new com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient$injectExperience$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.f4053a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.c
            java.lang.String r4 = "ExperienceClient"
            r5 = 1
            if (r3 == 0) goto L36
            if (r3 != r5) goto L2e
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L2b
            goto L60
        L2b:
            r6 = move-exception
            goto Lae
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.b.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "---------------------injectExperience  "
            r8.<init>(r3)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            f6.AbstractC1436a.a(r4, r8, r5)
            C7.f r6 = r6.d     // Catch: java.lang.Exception -> L2b
            java.lang.Object r6 = r6.getF4884a()     // Catch: java.lang.Exception -> L2b
            java.lang.String r8 = "getValue(...)"
            kotlin.jvm.internal.k.e(r6, r8)     // Catch: java.lang.Exception -> L2b
            com.stepos.taskrobot.taskmanager.experiencelib.api.ExperienceApi r6 = (com.stepos.taskrobot.taskmanager.experiencelib.api.ExperienceApi) r6     // Catch: java.lang.Exception -> L2b
            r1.c = r5     // Catch: java.lang.Exception -> L2b
            java.lang.Object r8 = r6.injectExperience(r7, r1)     // Catch: java.lang.Exception -> L2b
            if (r8 != r2) goto L60
            return r2
        L60:
            qa.L r8 = (qa.L) r8     // Catch: java.lang.Exception -> L2b
            F9.M r6 = r8.f5644a     // Catch: java.lang.Exception -> L2b
            boolean r6 = r6.c()     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L81
            java.lang.Object r6 = r8.b     // Catch: java.lang.Exception -> L2b
            F9.P r6 = (F9.P) r6     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L75
            java.lang.String r6 = r6.g()     // Catch: java.lang.Exception -> L2b
            return r6
        L75:
            java.lang.Exception r6 = new java.lang.Exception     // Catch: java.lang.Exception -> L2b
            java.lang.String r7 = "Response body is null"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L2b
            kotlin.Result$Failure r6 = kotlin.b.a(r6)     // Catch: java.lang.Exception -> L2b
            return r6
        L81:
            F9.P r6 = r8.c     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L8a
            java.lang.String r6 = r6.g()     // Catch: java.lang.Exception -> L2b
            goto L8c
        L8a:
            java.lang.String r6 = "Unknown error"
        L8c:
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Exception -> L2b
            F9.M r8 = r8.f5644a     // Catch: java.lang.Exception -> L2b
            int r8 = r8.d     // Catch: java.lang.Exception -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2b
            r1.append(r8)     // Catch: java.lang.Exception -> L2b
            java.lang.String r8 = " - "
            r1.append(r8)     // Catch: java.lang.Exception -> L2b
            r1.append(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L2b
            r7.<init>(r6)     // Catch: java.lang.Exception -> L2b
            kotlin.Result$Failure r6 = kotlin.b.a(r7)     // Catch: java.lang.Exception -> L2b
            return r6
        Lae:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "---------------------injectExperience  fail "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            f6.AbstractC1436a.a(r4, r7, r5)
            kotlin.Result$Failure r6 = kotlin.b.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmanager.experiencelib.client.a.b(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmanager.experiencelib.client.a.c(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
