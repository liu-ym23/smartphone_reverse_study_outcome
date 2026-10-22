package com.stepos.ailauncher.agent.aispace.connect;

import Y4.C1118b;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "", "agentType", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)Ljava/lang/String;", "text", "y", "(Ljava/lang/String;)V", "deviceToken", "x", "LY4/b;", "binding", "LY4/b;", "Ljava/lang/String;", "Ld/b;", "Landroid/content/Intent;", "scanLauncher", "Ld/b;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectExternalAgentActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_AGENT_TYPE = "extra_agent_type";
    private static final String EXTRA_ENTRY_SOURCE = "extra_entry_source";
    private String agentType;
    private C1118b binding;
    private final AbstractC3936b<Intent> scanLauncher = registerForActivityResult(new e.e(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.agent.aispace.connect.C
        @Override // d.InterfaceC3935a
        public final void a(Object obj) {
            ConnectExternalAgentActivity.F(this.f23918a, (ActivityResult) obj);
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "agentType", "entrySource", "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_AGENT_TYPE", "Ljava/lang/String;", "EXTRA_ENTRY_SOURCE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, String str, String str2, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str2 = W4.c.SOURCE_UNCONNECTED;
            }
            return companion.a(context, str, str2);
        }

        public final Intent a(Context context, String agentType, String entrySource) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(agentType, "agentType");
            kotlin.jvm.internal.p.i(entrySource, "entrySource");
            Intent intent = new Intent(context, (Class<?>) ConnectExternalAgentActivity.class);
            intent.putExtra(ConnectExternalAgentActivity.EXTRA_AGENT_TYPE, agentType);
            intent.putExtra("extra_entry_source", entrySource);
            return intent;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ConnectExternalAgentActivity$b", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "LY8/t;", "onSuccess", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "reason", "onFailure", "(Ljava/lang/String;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements IExternalAgentBindService.BindCallback {
        public b() {
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onFailure(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (ConnectExternalAgentActivity.this.isFinishing() || ConnectExternalAgentActivity.this.isDestroyed()) {
                return;
            }
            ConnectExternalAgentActivity connectExternalAgentActivity = ConnectExternalAgentActivity.this;
            Toast.makeText(connectExternalAgentActivity, connectExternalAgentActivity.getString(R$string.connect_bind_failure_toast, reason), 0).show();
        }

        @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.BindCallback
        public void onSuccess(IExternalAgentBindService.ConnectedDevice device) {
            kotlin.jvm.internal.p.i(device, "device");
            if (ConnectExternalAgentActivity.this.isFinishing() || ConnectExternalAgentActivity.this.isDestroyed()) {
                return;
            }
            ConnectExternalAgentActivity connectExternalAgentActivity = ConnectExternalAgentActivity.this;
            Toast.makeText(connectExternalAgentActivity, connectExternalAgentActivity.getString(R$string.connect_bind_success_toast, device.getDeviceName()), 0).show();
            ConnectExternalAgentActivity.this.setResult(-1);
            ConnectExternalAgentActivity.this.finish();
        }
    }

    public static final void A(ConnectExternalAgentActivity connectExternalAgentActivity, String str, View view) {
        W4.c cVar = W4.c.INSTANCE;
        String str2 = connectExternalAgentActivity.agentType;
        if (str2 == null) {
            kotlin.jvm.internal.p.A("agentType");
            str2 = null;
        }
        cVar.g(str2, 1, W4.c.ACTION_INSTALL_COPY);
        connectExternalAgentActivity.y(str);
    }

    public static final void B(ConnectExternalAgentActivity connectExternalAgentActivity, String str, View view) {
        W4.c cVar = W4.c.INSTANCE;
        String str2 = connectExternalAgentActivity.agentType;
        if (str2 == null) {
            kotlin.jvm.internal.p.A("agentType");
            str2 = null;
        }
        cVar.g(str2, 1, W4.c.ACTION_INSTALL_COPY);
        connectExternalAgentActivity.y(str);
    }

    public static final void C(ConnectExternalAgentActivity connectExternalAgentActivity, String str, View view) {
        W4.c cVar = W4.c.INSTANCE;
        String str2 = connectExternalAgentActivity.agentType;
        if (str2 == null) {
            kotlin.jvm.internal.p.A("agentType");
            str2 = null;
        }
        cVar.g(str2, 2, W4.c.ACTION_LAUNCH_COPY);
        connectExternalAgentActivity.y(str);
    }

    public static final void D(ConnectExternalAgentActivity connectExternalAgentActivity, View view) {
        String str;
        W4.c cVar = W4.c.INSTANCE;
        String str2 = connectExternalAgentActivity.agentType;
        if (str2 == null) {
            kotlin.jvm.internal.p.A("agentType");
            str2 = null;
        }
        cVar.g(str2, 3, "scan_pair");
        AbstractC3936b<Intent> abstractC3936b = connectExternalAgentActivity.scanLauncher;
        ScanQrActivity.Companion companion = ScanQrActivity.INSTANCE;
        String str3 = connectExternalAgentActivity.agentType;
        if (str3 == null) {
            kotlin.jvm.internal.p.A("agentType");
            str = null;
        } else {
            str = str3;
        }
        abstractC3936b.a(ScanQrActivity.Companion.c(companion, connectExternalAgentActivity, str, false, 4, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity r6, androidx.activity.result.ActivityResult r7) {
        /*
            java.lang.String r0 = "result"
            kotlin.jvm.internal.p.i(r7, r0)
            int r0 = r7.getResultCode()
            r1 = -1
            if (r0 == r1) goto Le
            goto L71
        Le:
            android.content.Intent r0 = r7.getData()
            r2 = 0
            if (r0 == 0) goto L1f
            java.lang.String r3 = "extra_already_confirmed"
            boolean r0 = r0.getBooleanExtra(r3, r2)
            r3 = 1
            if (r0 != r3) goto L1f
            goto L20
        L1f:
            r3 = r2
        L20:
            android.content.Intent r0 = r7.getData()
            r4 = 0
            if (r0 == 0) goto L2e
            java.lang.String r5 = "extra_device_name"
            java.lang.String r0 = r0.getStringExtra(r5)
            goto L2f
        L2e:
            r0 = r4
        L2f:
            if (r0 != 0) goto L33
            java.lang.String r0 = ""
        L33:
            if (r3 == 0) goto L5f
            int r7 = com.stepos.ailauncher.agent.R$string.connect_bind_success_toast
            boolean r3 = La.H.x0(r0)
            if (r3 == 0) goto L49
            java.lang.String r0 = r6.agentType
            if (r0 != 0) goto L47
            java.lang.String r0 = "agentType"
            kotlin.jvm.internal.p.A(r0)
            goto L48
        L47:
            r4 = r0
        L48:
            r0 = r4
        L49:
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r7 = r6.getString(r7, r0)
            android.widget.Toast r7 = android.widget.Toast.makeText(r6, r7, r2)
            r7.show()
            r6.setResult(r1)
            r6.finish()
            return
        L5f:
            android.content.Intent r7 = r7.getData()
            if (r7 == 0) goto L71
            java.lang.String r0 = "extra_device_token"
            java.lang.String r7 = r7.getStringExtra(r0)
            if (r7 != 0) goto L6e
            goto L71
        L6e:
            r6.x(r7)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity.F(com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity, androidx.activity.result.ActivityResult):void");
    }

    public static final void z(ConnectExternalAgentActivity connectExternalAgentActivity, View view) {
        connectExternalAgentActivity.finish();
    }

    public final String E(String agentType) {
        return com.stepos.ailauncher.agent.aispace.x.INSTANCE.a(agentType);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity.onCreate(android.os.Bundle):void");
    }

    public final void x(String deviceToken) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            Toast.makeText(this, getString(R$string.connect_bind_failure_toast, "service unavailable"), 0).show();
            return;
        }
        Toast.makeText(this, R$string.connect_binding_toast, 0).show();
        String str = this.agentType;
        if (str == null) {
            kotlin.jvm.internal.p.A("agentType");
            str = null;
        }
        iExternalAgentBindService.bindDevice(deviceToken, str, new b());
    }

    public final void y(String text) {
        Object systemService = getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("clawphone_cmd", text));
        Toast.makeText(this, getString(R$string.connect_copy_toast, text), 0).show();
    }
}
