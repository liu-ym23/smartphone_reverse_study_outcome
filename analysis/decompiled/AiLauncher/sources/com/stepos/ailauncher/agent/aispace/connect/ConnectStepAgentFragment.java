package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import Y4.C1119c;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
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
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 92\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003JC\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0014J'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J+\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0003R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "h0", "c0", "Lkotlin/Function1;", "", "onBound", "Lkotlin/Function2;", "", "", "onError", "f0", "(Lp9/l;Lp9/p;)V", "text", "Q", "(Ljava/lang/String;)V", "deviceToken", "P", "deviceId", "agentType", "deviceName", "b0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "j0", "(Ljava/lang/CharSequence;)V", "O", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "LY4/c;", "_binding", "LY4/c;", "R", "()LY4/c;", "binding", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectStepAgentFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_DISPLAY_NAME = "display_name";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "connect_step_agent";
    private C1119c _binding;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentFragment$a;", "", "<init>", "()V", "", "displayName", "Lcom/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentFragment;", "TAG", "Ljava/lang/String;", "ARG_DISPLAY_NAME", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ConnectStepAgentFragment a(String displayName) {
            ConnectStepAgentFragment connectStepAgentFragment = new ConnectStepAgentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("display_name", displayName);
            connectStepAgentFragment.setArguments(bundle);
            return connectStepAgentFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentFragment$b", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "LY8/t;", "onSuccess", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "reason", "onFailure", "(Ljava/lang/String;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements IExternalAgentBindService.BindCallback {
        public b() {
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onFailure(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (ConnectStepAgentFragment.this.isAdded()) {
                ConnectStepAgentFragment connectStepAgentFragment = ConnectStepAgentFragment.this;
                String string = connectStepAgentFragment.getString(R$string.connect_bind_failure_toast, reason);
                kotlin.jvm.internal.p.h(string, "getString(...)");
                connectStepAgentFragment.j0(string);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onSuccess(IExternalAgentBindService.ConnectedDevice device) {
            kotlin.jvm.internal.p.i(device, "device");
            if (ConnectStepAgentFragment.this.isAdded()) {
                ConnectStepAgentFragment connectStepAgentFragment = ConnectStepAgentFragment.this;
                String string = connectStepAgentFragment.getString(R$string.connect_bind_success_toast, device.getDeviceName());
                kotlin.jvm.internal.p.h(string, "getString(...)");
                connectStepAgentFragment.j0(string);
                ConnectStepAgentFragment.this.b0(device.getDeviceId(), device.getAgentType(), device.getDeviceName());
            }
        }
    }

    private final void O() throws Resources.NotFoundException {
        R().b().setBackgroundColor(-15658735);
        R().b().setFitsSystemWindows(false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_padding_h);
        R().contentColumn.setPadding(dimensionPixelSize, R().contentColumn.getPaddingTop(), dimensionPixelSize, R().contentColumn.getPaddingBottom());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageButton btnBack = R().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        C2773b6.p(c2773b6, new View[]{btnBack}, null, false, 6, null);
        ImageButton imageButton = R().btnBack;
        imageButton.setBackgroundResource(R$drawable.bg_amoo_store_icon_btn);
        imageButton.setImageResource(R$drawable.ic_amoo_back);
        int dimensionPixelSize2 = imageButton.getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_icon_padding);
        imageButton.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        imageButton.setImageTintList(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(String deviceToken) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            String string = getString(R$string.connect_bind_failure_toast, "service unavailable");
            kotlin.jvm.internal.p.h(string, "getString(...)");
            j0(string);
        } else {
            String string2 = getString(R$string.connect_binding_toast);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            j0(string2);
            iExternalAgentBindService.bindDevice(deviceToken, ExternalAgent.STEPAI.getId(), new b());
        }
    }

    private final void Q(String text) {
        Object systemService = requireContext().getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("clawphone_cmd", text));
        String string = getString(R$string.connect_copy_toast, text);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        j0(string);
    }

    private final void S() {
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        ScanQrActivity.Companion companion = ScanQrActivity.INSTANCE;
        Context contextRequireContext2 = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
        String strC = C4171a.c(contextRequireContext, companion.b(contextRequireContext2, ExternalAgent.STEPAI.getId(), false));
        if (strC == null) {
            C4148a.u("ConnectStepAgent", "launch scan relay failed", false, 4, null);
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ConnectStepAgentFragment$launchScan$1(this, strC, null), 3, null);
    }

    private final void T() {
        ViewGroup viewGroup;
        if (C2215l.INSTANCE.b() || (viewGroup = (ViewGroup) requireActivity().findViewById(R$id.ail_sheet_panel)) == null) {
            return;
        }
        final String string = getString(R$string.agent_auth_stepai_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = getString(R$string.agent_auth_stepai_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.agent_auth_stepai_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(viewGroup, string2, string3, string, W4.c.ENTRY_STEPAI, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.g0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentFragment.U(this.f24042a, string);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.h0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentFragment.V();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.i0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentFragment.W(this.f24050a);
            }
        });
    }

    public static final Y8.t U(ConnectStepAgentFragment connectStepAgentFragment, String str) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        androidx.fragment.app.r rVarRequireActivity = connectStepAgentFragment.requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        jVar.f(rVarRequireActivity, "zlgnsq", La.H.E1(str, 12298, 12299));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t V() {
        C2215l.INSTANCE.e();
        return Y8.t.f7040a;
    }

    public static final Y8.t W(ConnectStepAgentFragment connectStepAgentFragment) {
        if (!connectStepAgentFragment.x()) {
            connectStepAgentFragment.o();
        }
        return Y8.t.f7040a;
    }

    public static final void X(ConnectStepAgentFragment connectStepAgentFragment, View view) {
        if (C2213k.INSTANCE.h() || connectStepAgentFragment.x()) {
            return;
        }
        connectStepAgentFragment.o();
    }

    public static final void Y(ConnectStepAgentFragment connectStepAgentFragment, View view) {
        String string = connectStepAgentFragment.getString(R$string.connect_step_card1_url);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        connectStepAgentFragment.Q(string);
    }

    public static final void Z(ConnectStepAgentFragment connectStepAgentFragment, View view) {
        connectStepAgentFragment.c0();
    }

    public static final void a0(ConnectStepAgentFragment connectStepAgentFragment, View view) {
        connectStepAgentFragment.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String deviceId, String agentType, String deviceName) {
        if (La.H.x0(deviceId)) {
            x();
            return;
        }
        C2222o0 c2222o0 = C2222o0.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        c2222o0.b(contextRequireContext, deviceId, agentType, deviceName);
    }

    private final void c0() {
        f0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectStepAgentFragment.d0(this.f24031a, ((Boolean) obj).booleanValue());
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.agent.aispace.connect.f0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ConnectStepAgentFragment.e0(this.f24036a, ((Integer) obj).intValue(), (String) obj2);
            }
        });
    }

    public static final Y8.t d0(ConnectStepAgentFragment connectStepAgentFragment, boolean z10) {
        Object objB;
        if (z10) {
            connectStepAgentFragment.R().btnAccountLink.setImageResource(com.stepos.ailauncher.agent.R$drawable.ic_connect_account_bound);
            String string = connectStepAgentFragment.getString(R$string.connect_step_account_already_bound);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            connectStepAgentFragment.j0(string);
        } else {
            Intent intentP = com.stepos.ailauncher.foundation.account.f.INSTANCE.p();
            if (intentP != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    connectStepAgentFragment.startActivity(intentP);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.e(objB) != null) {
                    String string2 = connectStepAgentFragment.getString(R$string.connect_step_account_link_open_failed);
                    kotlin.jvm.internal.p.h(string2, "getString(...)");
                    connectStepAgentFragment.j0(string2);
                }
                Result.a(objB);
            } else {
                String string3 = connectStepAgentFragment.getString(R$string.connect_step_account_link_open_failed);
                kotlin.jvm.internal.p.h(string3, "getString(...)");
                connectStepAgentFragment.j0(string3);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t e0(ConnectStepAgentFragment connectStepAgentFragment, int i10, String str) {
        int i11 = R$string.connect_step_account_query_failed;
        Integer numValueOf = Integer.valueOf(i10);
        if (str == null) {
            str = "";
        }
        String string = connectStepAgentFragment.getString(i11, numValueOf, str);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        connectStepAgentFragment.j0(string);
        return Y8.t.f7040a;
    }

    private final void f0(InterfaceC5074l<? super Boolean, Y8.t> onBound, p9.p<? super Integer, ? super String, Y8.t> onError) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ConnectStepAgentFragment$queryOasisBound$1(onError, this, onBound, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g0(ConnectStepAgentFragment connectStepAgentFragment, InterfaceC5074l interfaceC5074l, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        connectStepAgentFragment.f0(interfaceC5074l, pVar);
    }

    private final void h0() {
        g0(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectStepAgentFragment.i0(this.f24021a, ((Boolean) obj).booleanValue());
            }
        }, null, 2, null);
    }

    public static final Y8.t i0(ConnectStepAgentFragment connectStepAgentFragment, boolean z10) {
        connectStepAgentFragment.R().btnAccountLink.setImageResource(z10 ? com.stepos.ailauncher.agent.R$drawable.ic_connect_account_bound : com.stepos.ailauncher.agent.R$drawable.ic_connect_account_link);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(CharSequence text) {
        Toast.makeText(requireContext(), text, 0).show();
    }

    public final C1119c R() {
        C1119c c1119c = this._binding;
        kotlin.jvm.internal.p.f(c1119c);
        return c1119c;
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
        this._binding = C1119c.d(inflater, container, false);
        LinearLayout linearLayoutB = R().b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        return linearLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        O();
        R().tvTitle.setText(R$string.connect_step_agent_title);
        R().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectStepAgentFragment.X(this.f23996a, view2);
            }
        });
        R().btnCopyUrl.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectStepAgentFragment.Y(this.f24002a, view2);
            }
        });
        R().btnAccountLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectStepAgentFragment.Z(this.f24005a, view2);
            }
        });
        R().btnScan.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectStepAgentFragment.a0(this.f24013a, view2);
            }
        });
        T();
    }
}
