package com.stepos.ailauncher.agent.skill.cli;

import La.H;
import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.api.SkillApi;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.List;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0096@¢\u0006\u0004\b\b\u0010\tJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0096@¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\n*\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0007*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/ApiCliRepository;", "Lcom/stepos/ailauncher/agent/skill/cli/d;", "<init>", "()V", "", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "statusIn", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "query", "c", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "keyword", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "m", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/cli/CliItem;", "n", "(Lcom/stepos/ailauncher/agent/skill/cli/CliItem;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "skillApi$delegate", "LY8/h;", "k", "()Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "skillApi", "Lcom/stepos/ailauncher/agent/skill/cli/c;", "cliListApi$delegate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/agent/skill/cli/c;", "cliListApi", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiCliRepository implements d {

    /* renamed from: skillApi$delegate, reason: from kotlin metadata */
    private final h skillApi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.cli.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ApiCliRepository.l(this.f24334a);
        }
    });

    /* renamed from: cliListApi$delegate, reason: from kotlin metadata */
    private final h cliListApi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.cli.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ApiCliRepository.h(this.f24335a);
        }
    });

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.UNINSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.INSTALLING.ordinal()] = 2;
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
            try {
                iArr[SkillStatus.CONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SkillStatus.DISCONNECTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SkillStatus.TOGGLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SkillStatus.QUEUED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SkillStatus.INSTALL_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SkillStatus.UNINSTALLING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SkillStatus.REVIEWING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final c h(ApiCliRepository apiCliRepository) throws Throwable {
        Object objB;
        C4148a.d("ApiCli", "create CliListApi via HttpManager(botMsg)", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((c) HttpManager.INSTANCE.create(c.class, "botMsg"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("ApiCli", "HttpManager.create<CliListApi> failed", thE, false, 8, null);
        }
        C4849c.b(objB);
        return (c) objB;
    }

    public static final SkillApi l(ApiCliRepository apiCliRepository) throws Throwable {
        Object objB;
        C4148a.d("ApiCli", "create SkillApi via HttpManager(skillStore) for search only", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((SkillApi) HttpManager.INSTANCE.create(SkillApi.class, "skillStore"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("ApiCli", "HttpManager.create<SkillApi> failed", thE, false, 8, null);
        }
        C4849c.b(objB);
        return (SkillApi) objB;
    }

    @Override // com.stepos.ailauncher.agent.skill.cli.d
    public Object b(List<? extends SkillStatus> list, InterfaceC4014c<? super List<SkillItem>> interfaceC4014c) {
        return i(null, list, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.agent.skill.cli.d
    public Object c(String str, List<? extends SkillStatus> list, InterfaceC4014c<? super List<SkillItem>> interfaceC4014c) {
        String string = H.D1(str).toString();
        if (H.x0(string)) {
            string = null;
        }
        return i(string, list, interfaceC4014c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ce, code lost:
    
        if (r4 != r5) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r21, java.util.List<? extends com.stepos.ailauncher.agent.skill.SkillStatus> r22, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.agent.skill.SkillItem>> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.cli.ApiCliRepository.i(java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    public final c j() {
        return (c) this.cliListApi.getValue();
    }

    public final SkillApi k() {
        return (SkillApi) this.skillApi.getValue();
    }

    public final String m(SkillStatus skillStatus) {
        switch (a.$EnumSwitchMapping$0[skillStatus.ordinal()]) {
            case 1:
                return com.stepos.ailauncher.chat.trace.a.INSTALL_UNINSTALLED;
            case 2:
                return "installing";
            case 3:
                return x5.d.EXTRA_ENABLED;
            case 4:
                return "disabled";
            case 5:
                return "installed";
            case 6:
                return "connected";
            case 7:
                return "disconnected";
            case 8:
                return "toggling";
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                return null;
        }
    }

    public final SkillItem n(CliItem cliItem) {
        String id = cliItem.getId();
        String str = id == null ? "" : id;
        String name = cliItem.getName();
        String displayName = cliItem.getDisplayName();
        return new SkillItem(str, name, displayName == null ? "" : displayName, cliItem.getDescription(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, cliItem.getDownloadCount(), 0, null, null, 0, null, null, null, null, null, null, null, cliItem.getStatus(), cliItem.getIcon(), null, InstallKind.CLI, null, 2146959344, 10, null);
    }
}
