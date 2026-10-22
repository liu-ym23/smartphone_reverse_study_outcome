package com.stepos.ailauncher.contract.api.skill;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService;", "", "Landroid/content/Context;", "context", "LY8/t;", "openInstalledSkills", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "item", "openSkillDetail", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "Landroidx/fragment/app/Fragment;", "createInstalledSkillsFragment", "()Landroidx/fragment/app/Fragment;", "", "testing", "createSkillDetailFragment", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;Z)Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "getSkillStatus", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "installSkill", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "uninstallSkill", "SkillUiStatus", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISkillUiService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Fragment createInstalledSkillsFragment(ISkillUiService iSkillUiService) {
            return ISkillUiService.super.createInstalledSkillsFragment();
        }

        @Deprecated
        public static Fragment createSkillDetailFragment(ISkillUiService iSkillUiService, SkillItemBrief item, boolean z10) {
            p.i(item, "item");
            return ISkillUiService.super.createSkillDetailFragment(item, z10);
        }

        @Deprecated
        public static SkillUiStatus getSkillStatus(ISkillUiService iSkillUiService, SkillItemBrief item) {
            p.i(item, "item");
            return ISkillUiService.super.getSkillStatus(item);
        }

        @Deprecated
        public static void installSkill(ISkillUiService iSkillUiService, SkillItemBrief item) {
            p.i(item, "item");
            ISkillUiService.super.installSkill(item);
        }

        @Deprecated
        public static void uninstallSkill(ISkillUiService iSkillUiService, SkillItemBrief item) {
            p.i(item, "item");
            ISkillUiService.super.uninstallSkill(item);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_INSTALLED", "INSTALLING", "QUEUED", "INSTALLED", "UNINSTALLING", "INSTALL_FAILED", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SkillUiStatus {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SkillUiStatus[] $VALUES;
        public static final SkillUiStatus NOT_INSTALLED = new SkillUiStatus("NOT_INSTALLED", 0);
        public static final SkillUiStatus INSTALLING = new SkillUiStatus("INSTALLING", 1);
        public static final SkillUiStatus QUEUED = new SkillUiStatus("QUEUED", 2);
        public static final SkillUiStatus INSTALLED = new SkillUiStatus("INSTALLED", 3);
        public static final SkillUiStatus UNINSTALLING = new SkillUiStatus("UNINSTALLING", 4);
        public static final SkillUiStatus INSTALL_FAILED = new SkillUiStatus("INSTALL_FAILED", 5);

        private static final /* synthetic */ SkillUiStatus[] $values() {
            return new SkillUiStatus[]{NOT_INSTALLED, INSTALLING, QUEUED, INSTALLED, UNINSTALLING, INSTALL_FAILED};
        }

        static {
            SkillUiStatus[] skillUiStatusArr$values = $values();
            $VALUES = skillUiStatusArr$values;
            $ENTRIES = a.a(skillUiStatusArr$values);
        }

        private SkillUiStatus(String str, int i10) {
        }

        public static InterfaceC4149a<SkillUiStatus> getEntries() {
            return $ENTRIES;
        }

        public static SkillUiStatus valueOf(String str) {
            return (SkillUiStatus) Enum.valueOf(SkillUiStatus.class, str);
        }

        public static SkillUiStatus[] values() {
            return (SkillUiStatus[]) $VALUES.clone();
        }
    }

    static /* synthetic */ Fragment createSkillDetailFragment$default(ISkillUiService iSkillUiService, SkillItemBrief skillItemBrief, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSkillDetailFragment");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return iSkillUiService.createSkillDetailFragment(skillItemBrief, z10);
    }

    default Fragment createInstalledSkillsFragment() {
        return null;
    }

    default Fragment createSkillDetailFragment(SkillItemBrief item, boolean testing) {
        p.i(item, "item");
        return null;
    }

    default SkillUiStatus getSkillStatus(SkillItemBrief item) {
        p.i(item, "item");
        return item.getInstalled() ? SkillUiStatus.INSTALLED : SkillUiStatus.NOT_INSTALLED;
    }

    default void installSkill(SkillItemBrief item) {
        p.i(item, "item");
    }

    void openInstalledSkills(Context context);

    void openSkillDetail(Context context, SkillItemBrief item);

    default void uninstallSkill(SkillItemBrief item) {
        p.i(item, "item");
    }
}
