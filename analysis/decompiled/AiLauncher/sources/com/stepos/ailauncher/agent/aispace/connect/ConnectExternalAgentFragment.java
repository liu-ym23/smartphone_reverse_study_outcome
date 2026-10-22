package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import Y4.C1118b;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.R$id;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import i6.C4171a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010&R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u0010/\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "R", "", "text", "O", "(Ljava/lang/String;)V", "deviceToken", "N", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Q", "deviceId", "agentType", "deviceName", "a0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "b0", "(Ljava/lang/CharSequence;)V", "M", "LY4/b;", "_binding", "LY4/b;", "Ljava/lang/String;", "", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "P", "()LY4/b;", "binding", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectExternalAgentFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_AGENT_TYPE = "agent_type";
    private static final String ARG_DISPLAY_NAME = "display_name";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "connect_external_agent";
    private C1118b _binding;
    private String agentType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentFragment$a;", "", "<init>", "()V", "", "agentType", "displayName", "Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentFragment;", "TAG", "Ljava/lang/String;", "ARG_AGENT_TYPE", "ARG_DISPLAY_NAME", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ ConnectExternalAgentFragment b(Companion companion, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return companion.a(str, str2);
        }

        public final ConnectExternalAgentFragment a(String agentType, String displayName) {
            kotlin.jvm.internal.p.i(agentType, "agentType");
            ConnectExternalAgentFragment connectExternalAgentFragment = new ConnectExternalAgentFragment();
            connectExternalAgentFragment.setArguments(x0.c.a(Y8.j.a(ConnectExternalAgentFragment.ARG_AGENT_TYPE, agentType), Y8.j.a("display_name", displayName)));
            return connectExternalAgentFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentFragment$b", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "LY8/t;", "onSuccess", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "reason", "onFailure", "(Ljava/lang/String;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements IExternalAgentBindService.BindCallback {
        public b() {
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onFailure(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (ConnectExternalAgentFragment.this.isAdded()) {
                ConnectExternalAgentFragment connectExternalAgentFragment = ConnectExternalAgentFragment.this;
                String string = connectExternalAgentFragment.getString(R$string.connect_bind_failure_toast, reason);
                kotlin.jvm.internal.p.h(string, "getString(...)");
                connectExternalAgentFragment.b0(string);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onSuccess(IExternalAgentBindService.ConnectedDevice device) {
            kotlin.jvm.internal.p.i(device, "device");
            if (ConnectExternalAgentFragment.this.isAdded()) {
                ConnectExternalAgentFragment connectExternalAgentFragment = ConnectExternalAgentFragment.this;
                String string = connectExternalAgentFragment.getString(R$string.connect_bind_success_toast, device.getDeviceName());
                kotlin.jvm.internal.p.h(string, "getString(...)");
                connectExternalAgentFragment.b0(string);
                ConnectExternalAgentFragment.this.a0(device.getDeviceId(), device.getAgentType(), device.getDeviceName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(String deviceToken) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            String string = getString(R$string.connect_bind_failure_toast, "service unavailable");
            kotlin.jvm.internal.p.h(string, "getString(...)");
            b0(string);
            return;
        }
        String string2 = getString(R$string.connect_binding_toast);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        b0(string2);
        String str = this.agentType;
        if (str == null) {
            kotlin.jvm.internal.p.A("agentType");
            str = null;
        }
        iExternalAgentBindService.bindDevice(deviceToken, str, new b());
    }

    private final void O(String text) {
        Object systemService = requireContext().getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("clawphone_cmd", text));
        String string = getString(R$string.connect_copy_toast, text);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        b0(string);
    }

    private final void R() {
        ViewGroup viewGroup;
        if (C2215l.INSTANCE.a() || (viewGroup = (ViewGroup) requireActivity().findViewById(R$id.ail_sheet_panel)) == null) {
            return;
        }
        final String string = getString(R$string.agent_auth_external_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = getString(R$string.agent_auth_external_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.agent_auth_external_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(viewGroup, string2, string3, string, W4.c.ENTRY_REMOTE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectExternalAgentFragment.S(this.f23940a, string);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectExternalAgentFragment.T();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectExternalAgentFragment.U(this.f23946a);
            }
        });
    }

    public static final Y8.t S(ConnectExternalAgentFragment connectExternalAgentFragment, String str) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        androidx.fragment.app.r rVarRequireActivity = connectExternalAgentFragment.requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        jVar.f(rVarRequireActivity, "gnsqsf", La.H.E1(str, 12298, 12299));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t T() {
        C2215l.INSTANCE.d();
        return Y8.t.f7040a;
    }

    public static final Y8.t U(ConnectExternalAgentFragment connectExternalAgentFragment) {
        connectExternalAgentFragment.x();
        return Y8.t.f7040a;
    }

    public static final void V(ConnectExternalAgentFragment connectExternalAgentFragment, View view) {
        if (connectExternalAgentFragment.x()) {
            return;
        }
        connectExternalAgentFragment.o();
    }

    public static final void W(ConnectExternalAgentFragment connectExternalAgentFragment, String str, View view) {
        connectExternalAgentFragment.O(str);
    }

    public static final void X(ConnectExternalAgentFragment connectExternalAgentFragment, String str, View view) {
        connectExternalAgentFragment.O(str);
    }

    public static final void Y(ConnectExternalAgentFragment connectExternalAgentFragment, String str, View view) {
        connectExternalAgentFragment.O(str);
    }

    public static final void Z(ConnectExternalAgentFragment connectExternalAgentFragment, View view) {
        connectExternalAgentFragment.Q();
    }

    public final void M() throws Resources.NotFoundException {
        P().b().setBackgroundColor(-15658735);
        P().b().setFitsSystemWindows(false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_padding_h);
        P().contentColumn.setPadding(dimensionPixelSize, P().contentColumn.getPaddingTop(), dimensionPixelSize, P().contentColumn.getPaddingBottom());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageButton btnBack = P().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        C2773b6.p(c2773b6, new View[]{btnBack}, null, false, 6, null);
        ImageButton imageButton = P().btnBack;
        imageButton.setBackgroundResource(R$drawable.bg_amoo_store_icon_btn);
        imageButton.setImageResource(R$drawable.ic_amoo_back);
        int dimensionPixelSize2 = imageButton.getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_icon_padding);
        imageButton.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        imageButton.setImageTintList(null);
    }

    public final C1118b P() {
        C1118b c1118b = this._binding;
        kotlin.jvm.internal.p.f(c1118b);
        return c1118b;
    }

    public final void Q() {
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        ScanQrActivity.Companion companion = ScanQrActivity.INSTANCE;
        Context contextRequireContext2 = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
        String str = this.agentType;
        if (str == null) {
            kotlin.jvm.internal.p.A("agentType");
            str = null;
        }
        String strC = C4171a.c(contextRequireContext, companion.b(contextRequireContext2, str, false));
        if (strC == null) {
            C4148a.u("ConnectExternalAgent", "launch scan relay failed", false, 4, null);
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ConnectExternalAgentFragment$launchScan$1(this, strC, null), 3, null);
    }

    public final void a0(String deviceId, String agentType, String deviceName) {
        C4148a.k("ConnectExternalAgent", "scan confirmed, open chat deviceId=" + deviceId + " agent=" + agentType, false, 4, null);
        if (La.H.x0(deviceId)) {
            x();
            return;
        }
        C2222o0 c2222o0 = C2222o0.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        c2222o0.b(contextRequireContext, deviceId, agentType, deviceName);
    }

    public final void b0(CharSequence text) {
        Toast.makeText(requireContext(), text, 0).show();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        this._binding = C1118b.d(inflater, container, false);
        LinearLayout linearLayoutB = P().b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        return linearLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r6, android.os.Bundle r7) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
