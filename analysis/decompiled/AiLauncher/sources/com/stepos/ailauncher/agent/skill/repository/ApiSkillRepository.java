package com.stepos.ailauncher.agent.skill.repository;

import Y8.h;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillInstallItemResponse;
import com.stepos.ailauncher.agent.skill.SkillInstallSingleResponse;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.api.SkillApi;
import com.stepos.ailauncher.agent.skill.installer.b;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.net.HttpManager;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b \u0010\u001fJ\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b!\u0010\u001fJ\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\"\u0010\u001fJ\u001f\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\u00152\u0006\u0010$\u001a\u00020(2\u0006\u0010%\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010+J/\u0010-\u001a\u00020\u00152\u0006\u0010$\u001a\u00020(2\u0006\u0010%\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010.J \u0010/\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b/\u00100J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b1\u0010\u001fJ*\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0082@¢\u0006\u0004\b2\u0010\u001cJ\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b3\u0010\u001fJ\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b4\u0010\u001fJ\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010,\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b5\u00106R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082D¢\u0006\u0006\n\u0004\b@\u0010AR \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020?0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010D¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/ApiSkillRepository;", "Lcom/stepos/ailauncher/agent/skill/repository/e;", "<init>", "()V", "", "page", "pageSize", "necessary", "testing", "Lb5/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(IILjava/lang/Integer;Ljava/lang/Integer;Le9/c;)Ljava/lang/Object;", "", "query", "c", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skillItem", "", "forceFromCaller", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLe9/c;)Ljava/lang/Object;", "", DidiCardProvider.KEY_ITEMS, "", "e", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LY8/t;", "f", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/skill/SkillInstallSingleResponse;", "resp", "identifier", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/ailauncher/agent/skill/SkillInstallSingleResponse;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/skill/installer/b;", "Lcom/stepos/ailauncher/agent/skill/SkillInstallResponse;", "action", "z", "(Lcom/stepos/ailauncher/agent/skill/SkillInstallResponse;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/skill/installer/b;", "targetEnabled", "B", "(Lcom/stepos/ailauncher/agent/skill/SkillInstallResponse;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/ailauncher/agent/skill/installer/b;", "u", "(IILe9/c;)Ljava/lang/Object;", "w", "v", "t", "y", "x", "(ZLe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "api$delegate", "LY8/h;", "s", "()Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "api", "useMock", "Z", "", "mockDelayMs", "J", "", "mockInstallProgress", "Ljava/util/Map;", "loadedSkillCache", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiSkillRepository implements e {
    private boolean useMock;

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private final h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.repository.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ApiSkillRepository.r(this.f24479a);
        }
    });
    private final long mockDelayMs = 500;
    private final Map<String, Long> mockInstallProgress = new LinkedHashMap();
    private final Map<String, SkillItem> loadedSkillCache = new LinkedHashMap();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.TOGGLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final CharSequence C(SkillItem it) {
        p.i(it, "it");
        return it.getIdentifier();
    }

    public static final CharSequence D(SkillItem it) {
        String strName;
        p.i(it, "it");
        String name = it.getName();
        SkillStatus status = it.getStatus();
        if (status == null || (strName = status.name()) == null) {
            strName = "null";
        }
        return name + ServerSentEventKt.COLON + strName;
    }

    public static final SkillApi r(ApiSkillRepository apiSkillRepository) throws Throwable {
        Object objB;
        C4148a.d("SkillApi", "create SkillApi via HttpManager(skillStore)", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((SkillApi) HttpManager.INSTANCE.create(SkillApi.class, "skillStore"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("SkillApi", "HttpManager.create<SkillApi> failed", thE, false, 8, null);
        }
        C4849c.b(objB);
        return (SkillApi) objB;
    }

    public final com.stepos.ailauncher.agent.skill.installer.b A(SkillInstallSingleResponse resp, String identifier) {
        SkillItem skill;
        SkillInstallItemResponse result = resp.getResult();
        if (result == null) {
            C4148a.u("SkillApi", "startInstall ack result null id=" + identifier + ", fallback Pending (后端可能未回写 result 字段)", false, 4, null);
        }
        Integer numValueOf = result != null ? Integer.valueOf(result.getCode()) : null;
        if (numValueOf == null || numValueOf.intValue() == 0) {
            SkillStatus status = (result == null || (skill = result.getSkill()) == null) ? null : skill.getStatus();
            if (status != null && !status.isInFlight()) {
                return new b.Final(status, result != null ? result.getSkill() : null);
            }
            return b.c.INSTANCE;
        }
        String msg = result.getMsg();
        if (msg == null) {
            msg = "code=" + numValueOf;
        }
        C4148a.u("SkillApi", "startInstall not ok id=" + identifier + " " + msg + ", code: " + numValueOf, false, 4, null);
        return new b.Failed("startInstall failed: " + msg + ", code: " + numValueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.agent.skill.installer.b B(com.stepos.ailauncher.agent.skill.SkillInstallResponse r5, java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.B(com.stepos.ailauncher.agent.skill.SkillInstallResponse, java.lang.String, java.lang.String, boolean):com.stepos.ailauncher.agent.skill.installer.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad A[Catch: all -> 0x00bd, TryCatch #2 {all -> 0x00bd, blocks: (B:32:0x0094, B:34:0x00ad, B:39:0x00c0, B:40:0x00c3, B:41:0x00c4), top: B:57:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4 A[Catch: all -> 0x00bd, TRY_LEAVE, TryCatch #2 {all -> 0x00bd, blocks: (B:32:0x0094, B:34:0x00ad, B:39:0x00c0, B:40:0x00c3, B:41:0x00c4), top: B:57:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(com.stepos.ailauncher.agent.skill.SkillItem r14, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.a(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(com.stepos.ailauncher.agent.skill.SkillItem r18, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r19) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.b(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        if (r9 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r6, int r7, int r8, e9.InterfaceC4014c<? super b5.PagedSkillResponse> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$searchSkills$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$searchSkills$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$searchSkills$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$searchSkills$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$searchSkills$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository r5 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L97
            goto L86
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)
            return r9
        L44:
            kotlin.C4849c.b(r9)
            boolean r9 = r5.useMock
            if (r9 == 0) goto L5f
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$0 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r5 = r5.u(r7, r8, r0)
            if (r5 != r1) goto L5e
            goto L85
        L5e:
            return r5
        L5f:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L97
            com.stepos.ailauncher.agent.skill.api.SkillApi r9 = r5.s()     // Catch: java.lang.Throwable -> L97
            com.stepos.ailauncher.agent.skill.SearchSkillParams r2 = new com.stepos.ailauncher.agent.skill.SearchSkillParams     // Catch: java.lang.Throwable -> L97
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L97
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L97
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L97
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L97
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L97
            r0.I$1 = r8     // Catch: java.lang.Throwable -> L97
            r0.I$2 = r4     // Catch: java.lang.Throwable -> L97
            r0.label = r3     // Catch: java.lang.Throwable -> L97
            java.lang.Object r9 = r9.searchSkills(r2, r0)     // Catch: java.lang.Throwable -> L97
            if (r9 != r1) goto L86
        L85:
            return r1
        L86:
            com.stepos.ailauncher.agent.skill.api.SkillEnvelope r9 = (com.stepos.ailauncher.agent.skill.api.SkillEnvelope) r9     // Catch: java.lang.Throwable -> L97
            java.lang.Object r5 = r9.getDataOrThrow()     // Catch: java.lang.Throwable -> L97
            b5.d r5 = (b5.PagedSkillResponse) r5     // Catch: java.lang.Throwable -> L97
            b5.d r5 = com.stepos.ailauncher.agent.skill.repository.d.b(r5)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L97
            goto La2
        L97:
            r5 = move-exception
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        La2:
            boolean r6 = kotlin.Result.g(r5)
            if (r6 == 0) goto La9
            r5 = 0
        La9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.c(java.lang.String, int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(com.stepos.ailauncher.agent.skill.SkillItem r18, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r19) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.d(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9 A[LOOP:1: B:63:0x01b3->B:65:0x01b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0281 A[LOOP:3: B:76:0x027b->B:78:0x0281, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.util.List<com.stepos.ailauncher.agent.skill.SkillItem> r27, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, com.stepos.ailauncher.agent.skill.SkillItem>> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.e(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(com.stepos.ailauncher.agent.skill.SkillItem r14, e9.InterfaceC4014c<? super kotlin.Result<Y8.t>> r15) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.f(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(int r19, int r20, java.lang.Integer r21, java.lang.Integer r22, e9.InterfaceC4014c<? super b5.PagedSkillResponse> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.g(int, int, java.lang.Integer, java.lang.Integer, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0107 A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:48:0x00ec, B:50:0x0107, B:55:0x0119, B:56:0x011c, B:57:0x011d, B:59:0x0125, B:61:0x014c, B:60:0x0144), top: B:75:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011d A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:48:0x00ec, B:50:0x0107, B:55:0x0119, B:56:0x011c, B:57:0x011d, B:59:0x0125, B:61:0x014c, B:60:0x0144), top: B:75:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.stepos.ailauncher.agent.skill.repository.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(com.stepos.ailauncher.agent.skill.SkillItem r21, boolean r22, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r23) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.h(com.stepos.ailauncher.agent.skill.SkillItem, boolean, e9.c):java.lang.Object");
    }

    public final SkillApi s() {
        return (SkillApi) this.api.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<Y8.t>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockCancelInstall$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockCancelInstall$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockCancelInstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockCancelInstall$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockCancelInstall$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r5 = (com.stepos.ailauncher.agent.skill.SkillItem) r5
            kotlin.C4849c.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            r0.L$0 = r5
            r0.label = r3
            r2 = 100
            java.lang.Object r6 = Ua.U.a(r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.util.Map<java.lang.String, java.lang.Long> r6 = r4.mockInstallProgress
            monitor-enter(r6)
            java.util.Map<java.lang.String, java.lang.Long> r4 = r4.mockInstallProgress     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r5.getIdentifier()     // Catch: java.lang.Throwable -> L5b
            r4.remove(r5)     // Catch: java.lang.Throwable -> L5b
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5b
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r6)
            return r4
        L5b:
            r4 = move-exception
            monitor-exit(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.t(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(int r12, int r13, e9.InterfaceC4014c<? super b5.PagedSkillResponse> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockPaged$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockPaged$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockPaged$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockPaged$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockPaged$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r13 = r0.I$1
            int r12 = r0.I$0
            kotlin.C4849c.b(r14)
            goto L47
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            kotlin.C4849c.b(r14)
            long r4 = r11.mockDelayMs
            r0.I$0 = r12
            r0.I$1 = r13
            r0.label = r3
            java.lang.Object r14 = Ua.U.a(r4, r0)
            if (r14 != r1) goto L47
            return r1
        L47:
            b5.l r14 = b5.l.INSTANCE
            java.util.List r14 = r14.b()
            int r12 = r12 * r13
            int r0 = r14.size()
            int r12 = v9.C5685n.j(r12, r0)
            int r13 = r13 + r12
            int r0 = r14.size()
            int r13 = v9.C5685n.j(r13, r0)
            java.util.List r5 = r14.subList(r12, r13)
            java.util.Map<java.lang.String, com.stepos.ailauncher.agent.skill.SkillItem> r12 = r11.loadedSkillCache
            monitor-enter(r12)
            r0 = r5
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L83
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L83
        L6d:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L86
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L83
            com.stepos.ailauncher.agent.skill.SkillItem r1 = (com.stepos.ailauncher.agent.skill.SkillItem) r1     // Catch: java.lang.Throwable -> L83
            java.util.Map<java.lang.String, com.stepos.ailauncher.agent.skill.SkillItem> r2 = r11.loadedSkillCache     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r1.getIdentifier()     // Catch: java.lang.Throwable -> L83
            r2.put(r4, r1)     // Catch: java.lang.Throwable -> L83
            goto L6d
        L83:
            r0 = move-exception
            r11 = r0
            goto La1
        L86:
            Y8.t r11 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L83
            monitor-exit(r12)
            b5.d r4 = new b5.d
            int r6 = r14.size()
            int r11 = r14.size()
            if (r13 >= r11) goto L97
        L95:
            r7 = r3
            goto L99
        L97:
            r3 = 0
            goto L95
        L99:
            r9 = 8
            r10 = 0
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        La1:
            monitor-exit(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.u(int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.util.List<com.stepos.ailauncher.agent.skill.SkillItem> r53, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, com.stepos.ailauncher.agent.skill.SkillItem>> r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.v(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(com.stepos.ailauncher.agent.skill.SkillItem r8, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockStartInstall$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockStartInstall$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockStartInstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockStartInstall$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockStartInstall$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r8 = (com.stepos.ailauncher.agent.skill.SkillItem) r8
            kotlin.C4849c.b(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.C4849c.b(r9)
            r0.L$0 = r8
            r0.label = r3
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Object r9 = Ua.U.a(r2, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.util.Map<java.lang.String, java.lang.Long> r9 = r7.mockInstallProgress
            monitor-enter(r9)
            java.lang.String r8 = r8.getIdentifier()     // Catch: java.lang.Throwable -> L6d
            java.util.Map<java.lang.String, java.lang.Long> r0 = r7.mockInstallProgress     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L6f
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6d
            kotlin.random.Random$Default r2 = kotlin.random.Random.INSTANCE     // Catch: java.lang.Throwable -> L6d
            r3 = 3000(0xbb8, double:1.482E-320)
            r5 = 6000(0x1770, double:2.9644E-320)
            long r2 = r2.k(r3, r5)     // Catch: java.lang.Throwable -> L6d
            long r0 = r0 + r2
            java.util.Map<java.lang.String, java.lang.Long> r7 = r7.mockInstallProgress     // Catch: java.lang.Throwable -> L6d
            java.lang.Long r0 = g9.C4109a.g(r0)     // Catch: java.lang.Throwable -> L6d
            r7.put(r8, r0)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r7 = move-exception
            goto L79
        L6f:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L6d
            com.stepos.ailauncher.agent.skill.installer.b$c r7 = com.stepos.ailauncher.agent.skill.installer.b.c.INSTANCE     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r9)
            return r7
        L79:
            monitor-exit(r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.w(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(boolean r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockToggleAck$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockToggleAck$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockToggleAck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockToggleAck$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockToggleAck$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            boolean r5 = r0.Z$0
            kotlin.C4849c.b(r4)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.C4849c.b(r4)
            r0.Z$0 = r5
            r0.label = r2
            r1 = 200(0xc8, double:9.9E-322)
            java.lang.Object r4 = Ua.U.a(r1, r0)
            if (r4 != r6) goto L43
            return r6
        L43:
            if (r5 == 0) goto L48
            com.stepos.ailauncher.agent.skill.SkillStatus r4 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_ENABLED
            goto L4a
        L48:
            com.stepos.ailauncher.agent.skill.SkillStatus r4 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_DISABLED
        L4a:
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            com.stepos.ailauncher.agent.skill.installer.b$b r5 = new com.stepos.ailauncher.agent.skill.installer.b$b
            r6 = 2
            r0 = 0
            r5.<init>(r4, r0, r6, r0)
            java.lang.Object r4 = kotlin.Result.b(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.x(boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockUninstall$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockUninstall$1 r0 = (com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockUninstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockUninstall$1 r0 = new com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository$mockUninstall$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r5 = (com.stepos.ailauncher.agent.skill.SkillItem) r5
            kotlin.C4849c.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            r0.L$0 = r5
            r0.label = r3
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Object r6 = Ua.U.a(r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.util.Map<java.lang.String, java.lang.Long> r6 = r4.mockInstallProgress
            monitor-enter(r6)
            java.util.Map<java.lang.String, java.lang.Long> r4 = r4.mockInstallProgress     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = r5.getIdentifier()     // Catch: java.lang.Throwable -> L62
            r4.remove(r5)     // Catch: java.lang.Throwable -> L62
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L62
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> L62
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.UNINSTALLED     // Catch: java.lang.Throwable -> L62
            r0 = 2
            r1 = 0
            r4.<init>(r5, r1, r0, r1)     // Catch: java.lang.Throwable -> L62
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L62
            monitor-exit(r6)
            return r4
        L62:
            r4 = move-exception
            monitor-exit(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.y(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.agent.skill.installer.b z(com.stepos.ailauncher.agent.skill.SkillInstallResponse r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.util.List r3 = r4.a()
            r0 = 0
            if (r3 == 0) goto L2b
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        Ld:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L25
            java.lang.Object r1 = r3.next()
            r2 = r1
            com.stepos.ailauncher.agent.skill.SkillInstallItemResponse r2 = (com.stepos.ailauncher.agent.skill.SkillInstallItemResponse) r2
            java.lang.String r2 = r2.getSkillId()
            boolean r2 = kotlin.jvm.internal.p.d(r2, r5)
            if (r2 == 0) goto Ld
            goto L26
        L25:
            r1 = r0
        L26:
            com.stepos.ailauncher.agent.skill.SkillInstallItemResponse r1 = (com.stepos.ailauncher.agent.skill.SkillInstallItemResponse) r1
            if (r1 == 0) goto L2b
            goto L3a
        L2b:
            java.util.List r3 = r4.a()
            if (r3 == 0) goto L39
            java.lang.Object r3 = Z8.F.s0(r3)
            r1 = r3
            com.stepos.ailauncher.agent.skill.SkillInstallItemResponse r1 = (com.stepos.ailauncher.agent.skill.SkillInstallItemResponse) r1
            goto L3a
        L39:
            r1 = r0
        L3a:
            if (r1 == 0) goto L45
            int r3 = r1.getCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L46
        L45:
            r3 = r0
        L46:
            if (r3 == 0) goto Lac
            int r4 = r3.intValue()
            if (r4 == 0) goto Lac
            if (r1 == 0) goto L56
            java.lang.String r4 = r1.getMsg()
            if (r4 != 0) goto L67
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "code="
            r4.append(r1)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
        L67:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r2 = " not ok id="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = ", code: "
            r1.append(r5)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r5 = 0
            r1 = 4
            java.lang.String r2 = "SkillApi"
            h8.C4148a.u(r2, r3, r5, r1, r0)
            com.stepos.ailauncher.agent.skill.installer.b$a r3 = new com.stepos.ailauncher.agent.skill.installer.b$a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r6 = " failed: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.<init>(r4)
            return r3
        Lac:
            if (r1 == 0) goto Lb9
            com.stepos.ailauncher.agent.skill.SkillItem r3 = r1.getSkill()
            if (r3 == 0) goto Lb9
            com.stepos.ailauncher.agent.skill.SkillStatus r3 = r3.getStatus()
            goto Lba
        Lb9:
            r3 = r0
        Lba:
            if (r3 != 0) goto Lbf
            com.stepos.ailauncher.agent.skill.installer.b$c r3 = com.stepos.ailauncher.agent.skill.installer.b.c.INSTANCE
            return r3
        Lbf:
            boolean r4 = r3.isInFlight()
            if (r4 == 0) goto Lc8
            com.stepos.ailauncher.agent.skill.installer.b$c r3 = com.stepos.ailauncher.agent.skill.installer.b.c.INSTANCE
            return r3
        Lc8:
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b
            r5 = 2
            r4.<init>(r3, r0, r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository.z(com.stepos.ailauncher.agent.skill.SkillInstallResponse, java.lang.String, java.lang.String):com.stepos.ailauncher.agent.skill.installer.b");
    }
}
