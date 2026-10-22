package V4;

import S4.d;
import Y8.t;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.wecom.C2331b;
import com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment;
import com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.dialog.f;
import com.stepos.ailauncher.contract.api.wecom.IWecomConnectService;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"LV4/b;", "Lcom/stepos/ailauncher/contract/api/wecom/IWecomConnectService;", "<init>", "()V", "", "cliName", "", "connected", "Landroid/content/Context;", "hostContext", "Landroidx/fragment/app/Fragment;", "createConfigFragment", "(Ljava/lang/String;ZLandroid/content/Context;)Landroidx/fragment/app/Fragment;", "connectedState", "()Ljava/lang/Boolean;", "uninstalling", "()Z", "context", "LY8/t;", "confirmUninstall", "(Landroid/content/Context;)V", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements IWecomConnectService {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String STATUS_CONNECTED = "connected";

    @Deprecated
    public static final String STATUS_DISCONNECTED = "disconnected";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"LV4/b$a;", "", "<init>", "()V", "", "STATUS_CONNECTED", "Ljava/lang/String;", "STATUS_DISCONNECTED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    public static final t b() {
        WecomCliRepository.m(WecomCliRepository.INSTANCE, null, null, 3, null);
        return t.f7040a;
    }

    @Override // com.stepos.ailauncher.contract.api.wecom.IWecomConnectService
    public void confirmUninstall(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.wecom_cli_uninstall_dialog_title);
        p.h(string, "getString(...)");
        String string2 = context.getString(R$string.wecom_cli_uninstall_dialog_desc);
        p.h(string2, "getString(...)");
        String string3 = context.getString(R$string.wecom_cli_abort_dialog_cancel);
        p.h(string3, "getString(...)");
        String string4 = context.getString(R$string.wecom_cli_abort_dialog_confirm);
        p.h(string4, "getString(...)");
        f.q(new d(context, string, string2, string3, string4, null, new InterfaceC5063a() { // from class: V4.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b.b();
            }
        }, 32, null), "wecomUninstallFromStore");
    }

    @Override // com.stepos.ailauncher.contract.api.wecom.IWecomConnectService
    public Boolean connectedState() {
        String value = WecomCliRepository.INSTANCE.y().getValue();
        if (value != null) {
            return Boolean.valueOf(p.d(value, "connected") || p.d(value, "disconnected"));
        }
        return null;
    }

    @Override // com.stepos.ailauncher.contract.api.wecom.IWecomConnectService
    public Fragment createConfigFragment(String cliName, boolean connected, Context hostContext) {
        C2331b c2331b = C2331b.INSTANCE;
        if (hostContext == null) {
            hostContext = C3197a.INSTANCE.a();
        }
        if (c2331b.b(hostContext)) {
            return null;
        }
        return WecomConnectFragment.INSTANCE.a(connected ? SkillStatus.CONNECTED : null);
    }

    @Override // com.stepos.ailauncher.contract.api.wecom.IWecomConnectService
    public boolean uninstalling() {
        WecomCliRepository wecomCliRepository = WecomCliRepository.INSTANCE;
        return wecomCliRepository.A().getValue().booleanValue() || p.d(wecomCliRepository.y().getValue(), "logout");
    }
}
