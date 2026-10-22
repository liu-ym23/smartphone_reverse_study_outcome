package com.stepos.ailauncher.common.permission;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.permission.G;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001a\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermissionProxyActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "p", "", "requestId", "I", "", "delivered", "Z", "Ld/b;", "", "", "launcher", "Ld/b;", "homeReceiverRegistered", "", "permissionSession", "J", "com/stepos/ailauncher/common/permission/PermissionProxyActivity$b", "homeReceiver", "Lcom/stepos/ailauncher/common/permission/PermissionProxyActivity$b;", "Companion", Const.INTENT_KEY_APIKEY, "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionProxyActivity extends b.q {
    private static final String TAG = "PermissionProxyActivity";
    private boolean delivered;
    private final b homeReceiver = new b();
    private boolean homeReceiverRegistered;
    private AbstractC3936b<String[]> launcher;
    private long permissionSession;
    private int requestId;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/common/permission/PermissionProxyActivity$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.CLOSE_SYSTEM_DIALOGS") && kotlin.jvm.internal.p.d(intent.getStringExtra("reason"), "homekey")) {
                long j10 = PermissionProxyActivity.this.permissionSession;
                G g10 = G.INSTANCE;
                if (j10 != g10.J() || g10.S()) {
                    return;
                }
                g10.W();
                G.x(g10, "permission-home", false, 2, null);
            }
        }
    }

    public static final void q(PermissionProxyActivity permissionProxyActivity, Map result) {
        boolean z10;
        InterfaceC5063a<Y8.t> interfaceC5063aB;
        kotlin.jvm.internal.p.i(result, "result");
        boolean z11 = false;
        if (result.isEmpty()) {
            z10 = false;
        } else {
            for (Map.Entry entry : result.entrySet()) {
                String str = (String) entry.getKey();
                if (!((Boolean) entry.getValue()).booleanValue() && !permissionProxyActivity.shouldShowRequestPermissionRationale(str)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        Set setKeySet = result.keySet();
        Collection collectionValues = result.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            z11 = true;
        } else {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    break;
                }
            }
            z11 = true;
        }
        Log.d(TAG, "[PERM-DIAG] onResult: perms=" + setKeySet + " granted=" + z11 + " permanentlyDenied=" + z10);
        G g10 = G.INSTANCE;
        G.OverlayHook overlayHookI = g10.I();
        if (overlayHookI != null && (interfaceC5063aB = overlayHookI.b()) != null) {
            interfaceC5063aB.invoke();
        }
        g10.t0(null);
        permissionProxyActivity.delivered = true;
        g10.i0(permissionProxyActivity.requestId, result, z10);
        permissionProxyActivity.finish();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        InterfaceC5063a<Y8.t> interfaceC5063aB;
        super.onCreate(savedInstanceState);
        p();
        this.requestId = getIntent().getIntExtra("extra_request_id", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(G.EXTRA_PERMISSIONS);
        if (stringArrayExtra == null) {
            stringArrayExtra = new String[0];
        }
        this.launcher = registerForActivityResult(new e.c(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.common.permission.I
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                PermissionProxyActivity.q(this.f26926a, (Map) obj);
            }
        });
        G g10 = G.INSTANCE;
        if (!g10.Q(this.requestId)) {
            Log.d(TAG, "request " + this.requestId + " abandoned before launch, finish");
            this.delivered = true;
            finish();
            return;
        }
        g10.e0(this);
        this.permissionSession = g10.J();
        registerReceiver(this.homeReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
        this.homeReceiverRegistered = true;
        AbstractC3936b<String[]> abstractC3936b = null;
        if (stringArrayExtra.length != 0) {
            AbstractC3936b<String[]> abstractC3936b2 = this.launcher;
            if (abstractC3936b2 == null) {
                kotlin.jvm.internal.p.A("launcher");
            } else {
                abstractC3936b = abstractC3936b2;
            }
            abstractC3936b.a(stringArrayExtra);
            return;
        }
        G.OverlayHook overlayHookI = g10.I();
        if (overlayHookI != null && (interfaceC5063aB = overlayHookI.b()) != null) {
            interfaceC5063aB.invoke();
        }
        g10.t0(null);
        this.delivered = true;
        g10.i0(this.requestId, kotlin.collections.a.i(), false);
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.homeReceiverRegistered) {
            unregisterReceiver(this.homeReceiver);
            this.homeReceiverRegistered = false;
        }
        G g10 = G.INSTANCE;
        g10.g0(this);
        super.onDestroy();
        if (this.delivered || isChangingConfigurations()) {
            return;
        }
        Log.d(TAG, "destroyed without result, cancel request " + this.requestId);
        g10.d0(this.requestId);
    }

    public final void p() {
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KeyguardManager.class);
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            return;
        }
        setShowWhenLocked(true);
        setTurnScreenOn(true);
    }
}
