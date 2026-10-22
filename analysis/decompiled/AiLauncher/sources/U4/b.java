package U4;

import S4.d;
import Y8.t;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.C2311g;
import com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.j;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.dialog.f;
import com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LU4/b;", "Lcom/stepos/ailauncher/contract/api/feishu/IFeishuConnectService;", "<init>", "()V", "Landroid/content/Context;", "context", "", "cliName", "LY8/t;", "openConfigPage", "(Landroid/content/Context;Ljava/lang/String;)V", "", "connected", "hostContext", "Landroidx/fragment/app/Fragment;", "createConfigFragment", "(Ljava/lang/String;ZLandroid/content/Context;)Landroidx/fragment/app/Fragment;", "connectedState", "()Ljava/lang/Boolean;", "uninstalling", "()Z", "confirmUninstall", "(Landroid/content/Context;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements IFeishuConnectService {
    public static final t b() {
        FeishuCliRepository.l(FeishuCliRepository.INSTANCE, null, null, 3, null);
        return t.f7040a;
    }

    @Override // com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService
    public void confirmUninstall(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.feishu_cli_uninstall_dialog_title);
        p.h(string, "getString(...)");
        String string2 = context.getString(R$string.feishu_cli_uninstall_dialog_desc);
        p.h(string2, "getString(...)");
        String string3 = context.getString(R$string.feishu_cli_abort_dialog_cancel);
        p.h(string3, "getString(...)");
        String string4 = context.getString(R$string.feishu_cli_abort_dialog_confirm);
        p.h(string4, "getString(...)");
        f.q(new d(context, string, string2, string3, string4, null, new InterfaceC5063a() { // from class: U4.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b.b();
            }
        }, 32, null), "feishuUninstallFromStore");
    }

    @Override // com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService
    public Boolean connectedState() {
        String value = j.INSTANCE.i().getValue();
        if (value != null) {
            return Boolean.valueOf(p.d(value, "connected") || p.d(value, "disconnected"));
        }
        return null;
    }

    @Override // com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService
    public Fragment createConfigFragment(String cliName, boolean connected, Context hostContext) {
        C2311g c2311g = C2311g.INSTANCE;
        if (hostContext == null) {
            hostContext = C3197a.INSTANCE.a();
        }
        if (c2311g.b(hostContext)) {
            return null;
        }
        return FeishuConnectFragment.INSTANCE.a(connected);
    }

    @Override // com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService
    public void openConfigPage(Context context, String cliName) {
        p.i(context, "context");
        C2311g.INSTANCE.c(context);
    }

    @Override // com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService
    public boolean uninstalling() {
        j jVar = j.INSTANCE;
        return jVar.m().getValue().booleanValue() || p.d(jVar.i().getValue(), "logout");
    }
}
