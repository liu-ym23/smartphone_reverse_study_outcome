package com.stepos.ailauncher.agent.skill.installer;

import Xa.o;
import Xa.p;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u00182\u00020\u0001:\u0002\u0019\fJ\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\t\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\n\u0010\u0007J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u000b\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\f\u0010\u0007J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\r\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller;", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "statusModel", "LXa/o;", "", "", Const.INTENT_KEY_UMID, "()LXa/o;", "statusFlow", "Companion", "StatusModel", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SkillInstaller {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "", "<init>", "(Ljava/lang/String;I)V", "PULL", "PUSH", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class StatusModel {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ StatusModel[] $VALUES;
        public static final StatusModel PULL = new StatusModel("PULL", 0);
        public static final StatusModel PUSH = new StatusModel("PUSH", 1);

        private static final /* synthetic */ StatusModel[] $values() {
            return new StatusModel[]{PULL, PUSH};
        }

        static {
            StatusModel[] statusModelArr$values = $values();
            $VALUES = statusModelArr$values;
            $ENTRIES = kotlin.enums.a.a(statusModelArr$values);
        }

        private StatusModel(String str, int i10) {
        }

        public static InterfaceC4149a<StatusModel> getEntries() {
            return $ENTRIES;
        }

        public static StatusModel valueOf(String str) {
            return (StatusModel) Enum.valueOf(StatusModel.class, str);
        }

        public static StatusModel[] values() {
            return (StatusModel[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$a;", "", "<init>", "()V", "LXa/o;", "", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "EMPTY_FLOW", "LXa/o;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installer.SkillInstaller$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final o<Map<String, SkillItem>> EMPTY_FLOW = p.b(0, 0, null, 7, null);
    }

    static /* synthetic */ Object f(SkillInstaller skillInstaller, SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c) {
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new UnsupportedOperationException("update not supported")));
    }

    Object a(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c);

    default Object b(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c) {
        return f(this, skillItem, interfaceC4014c);
    }

    Object c(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c);

    default o<Map<String, SkillItem>> d() {
        return Companion.EMPTY_FLOW;
    }

    Object e(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c);

    Object g(SkillItem skillItem, InterfaceC4014c<? super Result<t>> interfaceC4014c);

    Object h(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c);

    /* renamed from: i */
    StatusModel getStatusModel();
}
