package b5;

import La.H;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.U0;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillSource;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment;
import com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity;
import com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u001f*\u00020\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lb5/o;", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService;", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "openInstalledSkills", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "item", "openSkillDetail", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "Landroidx/fragment/app/Fragment;", "createInstalledSkillsFragment", "()Landroidx/fragment/app/Fragment;", "", "testing", "createSkillDetailFragment", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;Z)Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "getSkillStatus", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "installSkill", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "uninstallSkill", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o implements ISkillUiService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.INSTALLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.TOGGLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.REVIEWING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.QUEUED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SkillStatus.INSTALLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SkillStatus.CONNECTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SkillStatus.UNINSTALLING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SkillStatus.INSTALL_FAILED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SkillStatus.UNINSTALLED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SkillStatus.IDLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SkillStatus.DISCONNECTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ SkillItem c(o oVar, SkillItemBrief skillItemBrief, SkillStatus skillStatus, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            skillStatus = null;
        }
        return oVar.b(skillItemBrief, skillStatus);
    }

    public final String a(SkillItemBrief skillItemBrief) {
        String id = skillItemBrief.getId();
        if (id != null) {
            if (H.x0(id)) {
                id = null;
            }
            if (id != null) {
                return id;
            }
        }
        String name = skillItemBrief.getName();
        return name == null ? "" : name;
    }

    public final SkillItem b(SkillItemBrief skillItemBrief, SkillStatus skillStatus) {
        SkillStatus skillStatus2;
        String id = skillItemBrief.getId();
        String strA = a(skillItemBrief);
        String name = skillItemBrief.getName();
        String description = skillItemBrief.getDescription();
        if (description == null) {
            description = "";
        }
        String str = description;
        if (skillStatus == null) {
            skillStatus2 = skillItemBrief.getInstalled() ? SkillStatus.INSTALLED_ENABLED : SkillStatus.UNINSTALLED;
        } else {
            skillStatus2 = skillStatus;
        }
        String version = skillItemBrief.getVersion();
        if (H.x0(version)) {
            version = null;
        }
        return new SkillItem(id, strA, name, str, null, null, null, null, null, null, null, null, null, version, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, skillStatus2, null, null, null, skillItemBrief.getTesting() ? SkillSource.TESTING : SkillSource.NORMAL, 2147475440, 7, null);
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public Fragment createInstalledSkillsFragment() {
        return InstalledSkillFragment.INSTANCE.a();
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public Fragment createSkillDetailFragment(SkillItemBrief item, boolean testing) {
        p.i(item, "item");
        SkillDetailFragment.Companion companion = SkillDetailFragment.INSTANCE;
        String id = item.getId();
        if (id == null) {
            id = "";
        }
        return companion.a(id, item.getName(), item.getDescription(), c(this, item, null, 1, null), testing, item.getEnv());
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public ISkillUiService.SkillUiStatus getSkillStatus(SkillItemBrief item) {
        SkillItem skillItemG;
        SkillStatus status;
        p.i(item, "item");
        String strA = a(item);
        X4.a aVar = (X4.a) D5.a.INSTANCE.a(X4.a.class);
        if (aVar == null || (skillItemG = aVar.g(strA)) == null || (status = skillItemG.getStatus()) == null) {
            return item.getInstalled() ? ISkillUiService.SkillUiStatus.INSTALLED : ISkillUiService.SkillUiStatus.NOT_INSTALLED;
        }
        switch (a.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return ISkillUiService.SkillUiStatus.INSTALLING;
            case 5:
                return ISkillUiService.SkillUiStatus.QUEUED;
            case 6:
            case 7:
            case 8:
            case 9:
                return ISkillUiService.SkillUiStatus.INSTALLED;
            case 10:
                return ISkillUiService.SkillUiStatus.UNINSTALLING;
            case 11:
                return ISkillUiService.SkillUiStatus.INSTALL_FAILED;
            case 12:
            case 13:
            case 14:
                return ISkillUiService.SkillUiStatus.NOT_INSTALLED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public void installSkill(SkillItemBrief item) {
        p.i(item, "item");
        if (item.getTesting()) {
            U0 u02 = U0.INSTANCE;
            String strA = a(item);
            String name = item.getName();
            if (name == null) {
                name = "";
            }
            String description = item.getDescription();
            if (description == null) {
                description = "";
            }
            u02.f(strA, name, description, item.getIconUrl(), item.getVersion(), item.getVersionName(), item.getInstallVersion());
        }
        X4.a aVar = (X4.a) D5.a.INSTANCE.a(X4.a.class);
        if (aVar != null) {
            aVar.n(b(item, SkillStatus.UNINSTALLED));
        }
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public void openInstalledSkills(Context context) {
        p.i(context, "context");
        i.INSTANCE.a(context, new Intent(context, (Class<?>) InstalledSkillActivity.class));
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public void openSkillDetail(Context context, SkillItemBrief item) {
        p.i(context, "context");
        p.i(item, "item");
        SkillDetailActivity.Companion companion = SkillDetailActivity.INSTANCE;
        String id = item.getId();
        if (id == null) {
            id = "";
        }
        SkillDetailActivity.Companion.b(companion, context, id, item.getName(), item.getDescription(), null, false, null, 112, null);
    }

    @Override // com.stepos.ailauncher.contract.api.skill.ISkillUiService
    public void uninstallSkill(SkillItemBrief item) {
        p.i(item, "item");
        U0.INSTANCE.i(a(item));
        X4.a aVar = (X4.a) D5.a.INSTANCE.a(X4.a.class);
        if (aVar != null) {
            aVar.h(b(item, SkillStatus.INSTALLED_ENABLED));
        }
    }
}
