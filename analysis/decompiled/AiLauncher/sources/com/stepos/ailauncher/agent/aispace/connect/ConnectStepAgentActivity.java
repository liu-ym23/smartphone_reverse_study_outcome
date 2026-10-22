package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import Y4.C1119c;
import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.C1398p;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003JC\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00132\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "", "text", "LY8/t;", "D", "(Ljava/lang/String;)V", "deviceToken", "C", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", ExifInterface.LONGITUDE_EAST, "R", "M", "Lkotlin/Function1;", "", "onBound", "Lkotlin/Function2;", "", "onError", "P", "(Lp9/l;Lp9/p;)V", "LY4/c;", "binding", "LY4/c;", "Ld/b;", "Landroid/content/Intent;", "scanLauncher", "Ld/b;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectStepAgentActivity extends androidx.appcompat.app.d {
    private C1119c binding;
    private final AbstractC3936b<Intent> scanLauncher = registerForActivityResult(new e.e(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.agent.aispace.connect.N
        @Override // d.InterfaceC3935a
        public final void a(Object obj) {
            ConnectStepAgentActivity.T(this.f23959a, (ActivityResult) obj);
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentActivity$a", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "LY8/t;", "onSuccess", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "reason", "onFailure", "(Ljava/lang/String;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements IExternalAgentBindService.BindCallback {
        public a() {
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onFailure(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (ConnectStepAgentActivity.this.isFinishing() || ConnectStepAgentActivity.this.isDestroyed()) {
                return;
            }
            ConnectStepAgentActivity connectStepAgentActivity = ConnectStepAgentActivity.this;
            Toast.makeText(connectStepAgentActivity, connectStepAgentActivity.getString(R$string.connect_bind_failure_toast, reason), 0).show();
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onSuccess(IExternalAgentBindService.ConnectedDevice device) {
            kotlin.jvm.internal.p.i(device, "device");
            if (ConnectStepAgentActivity.this.isFinishing() || ConnectStepAgentActivity.this.isDestroyed()) {
                return;
            }
            ConnectStepAgentActivity connectStepAgentActivity = ConnectStepAgentActivity.this;
            Toast.makeText(connectStepAgentActivity, connectStepAgentActivity.getString(R$string.connect_bind_success_toast, device.getDeviceName()), 0).show();
            ConnectStepAgentActivity.this.finish();
        }
    }

    private final void C(String deviceToken) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            Toast.makeText(this, getString(R$string.connect_bind_failure_toast, "service unavailable"), 0).show();
        } else {
            Toast.makeText(this, R$string.connect_binding_toast, 0).show();
            iExternalAgentBindService.bindDevice(deviceToken, ExternalAgent.STEPAI.getId(), new a());
        }
    }

    private final void D(String text) {
        Object systemService = getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("clawphone_cmd", text));
        Toast.makeText(this, getString(R$string.connect_copy_toast, text), 0).show();
    }

    public static final Y8.t F(ConnectStepAgentActivity connectStepAgentActivity, String str) {
        com.stepos.ailauncher.chat.util.j.INSTANCE.f(connectStepAgentActivity, "zlgnsq", La.H.E1(str, 12298, 12299));
        return Y8.t.f7040a;
    }

    public static final Y8.t G() {
        C2215l.INSTANCE.e();
        return Y8.t.f7040a;
    }

    public static final Y8.t H(ConnectStepAgentActivity connectStepAgentActivity) {
        connectStepAgentActivity.finish();
        return Y8.t.f7040a;
    }

    public static final void I(ConnectStepAgentActivity connectStepAgentActivity, View view) {
        if (C2213k.INSTANCE.h()) {
            return;
        }
        connectStepAgentActivity.finish();
    }

    public static final void J(ConnectStepAgentActivity connectStepAgentActivity, View view) {
        W4.c.r(W4.c.INSTANCE, W4.c.STEP_DOWNLOAD_COPY, null, 2, null);
        String string = connectStepAgentActivity.getString(R$string.connect_step_card1_url);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        connectStepAgentActivity.D(string);
    }

    public static final void K(ConnectStepAgentActivity connectStepAgentActivity, View view) {
        connectStepAgentActivity.M();
    }

    public static final void L(ConnectStepAgentActivity connectStepAgentActivity, View view) {
        W4.c.r(W4.c.INSTANCE, "scan_pair", null, 2, null);
        connectStepAgentActivity.scanLauncher.a(ScanQrActivity.Companion.c(ScanQrActivity.INSTANCE, connectStepAgentActivity, ExternalAgent.STEPAI.getId(), false, 4, null));
    }

    public static final Y8.t N(ConnectStepAgentActivity connectStepAgentActivity, boolean z10) {
        Object objB;
        W4.c.INSTANCE.q(W4.c.STEP_ACCOUNT_LINK, z10 ? W4.c.LINKED : W4.c.UNLINKED);
        if (z10) {
            C1119c c1119c = connectStepAgentActivity.binding;
            if (c1119c == null) {
                kotlin.jvm.internal.p.A("binding");
                c1119c = null;
            }
            c1119c.btnAccountLink.setImageResource(R$drawable.ic_connect_account_bound);
            Toast.makeText(connectStepAgentActivity, R$string.connect_step_account_already_bound, 0).show();
        } else {
            Intent intentP = com.stepos.ailauncher.foundation.account.f.INSTANCE.p();
            Log.i("OasisBind", "link tap: intent=" + intentP);
            if (intentP != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    connectStepAgentActivity.startActivity(intentP);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.h(objB)) {
                    Log.i("OasisBind", "startActivity ok");
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w("OasisBind", "startActivity failed", thE);
                    Toast.makeText(connectStepAgentActivity, R$string.connect_step_account_link_open_failed, 0).show();
                }
                Result.a(objB);
            } else {
                Toast.makeText(connectStepAgentActivity, R$string.connect_step_account_link_open_failed, 0).show();
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t O(ConnectStepAgentActivity connectStepAgentActivity, int i10, String str) {
        int i11 = R$string.connect_step_account_query_failed;
        Integer numValueOf = Integer.valueOf(i10);
        if (str == null) {
            str = "";
        }
        Toast.makeText(connectStepAgentActivity, connectStepAgentActivity.getString(i11, numValueOf, str), 0).show();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Q(ConnectStepAgentActivity connectStepAgentActivity, InterfaceC5074l interfaceC5074l, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        connectStepAgentActivity.P(interfaceC5074l, pVar);
    }

    public static final Y8.t S(ConnectStepAgentActivity connectStepAgentActivity, boolean z10) {
        C1119c c1119c = connectStepAgentActivity.binding;
        if (c1119c == null) {
            kotlin.jvm.internal.p.A("binding");
            c1119c = null;
        }
        c1119c.btnAccountLink.setImageResource(z10 ? R$drawable.ic_connect_account_bound : R$drawable.ic_connect_account_link);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void T(com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity r5, androidx.activity.result.ActivityResult r6) {
        /*
            java.lang.String r0 = "result"
            kotlin.jvm.internal.p.i(r6, r0)
            int r0 = r6.getResultCode()
            r1 = -1
            if (r0 == r1) goto Le
            return
        Le:
            android.content.Intent r0 = r6.getData()
            r1 = 0
            if (r0 == 0) goto L1f
            java.lang.String r2 = "extra_already_confirmed"
            boolean r0 = r0.getBooleanExtra(r2, r1)
            r2 = 1
            if (r0 != r2) goto L1f
            goto L20
        L1f:
            r2 = r1
        L20:
            android.content.Intent r0 = r6.getData()
            r3 = 0
            if (r0 == 0) goto L2e
            java.lang.String r4 = "extra_device_name"
            java.lang.String r0 = r0.getStringExtra(r4)
            goto L2f
        L2e:
            r0 = r3
        L2f:
            java.lang.String r4 = ""
            if (r0 != 0) goto L34
            r0 = r4
        L34:
            if (r2 == 0) goto L54
            int r6 = com.stepos.ailauncher.agent.R$string.connect_bind_success_toast
            boolean r2 = La.H.x0(r0)
            if (r2 == 0) goto L41
            java.lang.String r0 = "阶跃 AI"
        L41:
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r6 = r5.getString(r6, r0)
            android.widget.Toast r6 = android.widget.Toast.makeText(r5, r6, r1)
            r6.show()
            r5.finish()
            return
        L54:
            android.content.Intent r6 = r6.getData()
            if (r6 == 0) goto L60
            java.lang.String r0 = "extra_device_token"
            java.lang.String r3 = r6.getStringExtra(r0)
        L60:
            if (r3 != 0) goto L63
            goto L64
        L63:
            r4 = r3
        L64:
            int r6 = r4.length()
            if (r6 <= 0) goto L6d
            r5.C(r4)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity.T(com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity, androidx.activity.result.ActivityResult):void");
    }

    public final void E() {
        ViewGroup viewGroup;
        if (C2215l.INSTANCE.b() || (viewGroup = (ViewGroup) findViewById(R.id.content)) == null) {
            return;
        }
        final String string = getString(R$string.agent_auth_stepai_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = getString(R$string.agent_auth_stepai_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.agent_auth_stepai_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(viewGroup, string2, string3, string, W4.c.ENTRY_STEPAI, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.V
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentActivity.F(this.f23984a, string);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.W
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentActivity.G();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectStepAgentActivity.H(this.f23953a);
            }
        });
    }

    public final void M() {
        P(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectStepAgentActivity.N(this.f23980a, ((Boolean) obj).booleanValue());
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.agent.aispace.connect.U
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ConnectStepAgentActivity.O(this.f23982a, ((Integer) obj).intValue(), (String) obj2);
            }
        });
    }

    public final void P(InterfaceC5074l<? super Boolean, Y8.t> onBound, p9.p<? super Integer, ? super String, Y8.t> onError) {
        C1060i.d(C1398p.a(this), null, null, new ConnectStepAgentActivity$queryOasisBound$1(onError, this, onBound, null), 3, null);
    }

    public final void R() {
        Q(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectStepAgentActivity.S(this.f23948a, ((Boolean) obj).booleanValue());
            }
        }, null, 2, null);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1119c c1119cC = C1119c.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c1119cC, "inflate(...)");
        this.binding = c1119cC;
        C1119c c1119c = null;
        if (c1119cC == null) {
            kotlin.jvm.internal.p.A("binding");
            c1119cC = null;
        }
        setContentView(c1119cC.b());
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
        W4.c.INSTANCE.p();
        C1119c c1119c2 = this.binding;
        if (c1119c2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1119c2 = null;
        }
        c1119c2.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.O
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectStepAgentActivity.I(this.f23965a, view);
            }
        });
        C1119c c1119c3 = this.binding;
        if (c1119c3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1119c3 = null;
        }
        c1119c3.btnCopyUrl.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.P
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectStepAgentActivity.J(this.f23967a, view);
            }
        });
        C1119c c1119c4 = this.binding;
        if (c1119c4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1119c4 = null;
        }
        c1119c4.btnAccountLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectStepAgentActivity.K(this.f23972a, view);
            }
        });
        C1119c c1119c5 = this.binding;
        if (c1119c5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1119c = c1119c5;
        }
        c1119c.btnScan.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.S
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectStepAgentActivity.L(this.f23976a, view);
            }
        });
        E();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        R();
    }
}
