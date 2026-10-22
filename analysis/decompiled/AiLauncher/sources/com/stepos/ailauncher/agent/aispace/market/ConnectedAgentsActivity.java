package com.stepos.ailauncher.agent.aispace.market;

import Y4.C1120d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "LY4/d;", "binding", "LY4/d;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectedAgentsActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_FILTER = "extra_filter";
    public static final String FILTER_REMOTE = "remote";
    public static final String FILTER_STEPAI = "stepai";
    private C1120d binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "filter", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "EXTRA_FILTER", "Ljava/lang/String;", "FILTER_STEPAI", "FILTER_REMOTE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, String filter) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(filter, "filter");
            Intent intent = new Intent(context, (Class<?>) ConnectedAgentsActivity.class);
            intent.putExtra(ConnectedAgentsActivity.EXTRA_FILTER, filter);
            if (context instanceof Activity) {
                intent.addFlags(603979776);
            }
            b5.i.INSTANCE.a(context, intent);
        }

        public Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.core.view.a0 u(View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, eVarF.f41980d);
        return insets;
    }

    public static final void v(ConnectedAgentsActivity connectedAgentsActivity, View view) {
        connectedAgentsActivity.finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            super.onCreate(r10)
            android.view.LayoutInflater r10 = r9.getLayoutInflater()
            Y4.d r10 = Y4.C1120d.b(r10)
            java.lang.String r0 = "inflate(...)"
            kotlin.jvm.internal.p.h(r10, r0)
            r9.binding = r10
            r0 = 0
            java.lang.String r1 = "binding"
            if (r10 != 0) goto L1b
            kotlin.jvm.internal.p.A(r1)
            r10 = r0
        L1b:
            android.widget.LinearLayout r10 = r10.root
            r9.setContentView(r10)
            android.view.Window r10 = r9.getWindow()
            r2 = 0
            androidx.core.view.Y.b(r10, r2)
            android.view.Window r10 = r9.getWindow()
            android.view.Window r3 = r9.getWindow()
            android.view.View r3 = r3.getDecorView()
            androidx.core.view.b0 r10 = androidx.core.view.Y.a(r10, r3)
            r10.e(r2)
            Y4.d r10 = r9.binding
            if (r10 != 0) goto L43
            kotlin.jvm.internal.p.A(r1)
            r10 = r0
        L43:
            android.widget.LinearLayout r10 = r10.root
            com.stepos.ailauncher.agent.aispace.market.D0 r2 = new com.stepos.ailauncher.agent.aispace.market.D0
            r2.<init>()
            androidx.core.view.N.u0(r10, r2)
            Y4.d r10 = r9.binding
            if (r10 != 0) goto L55
            kotlin.jvm.internal.p.A(r1)
            r10 = r0
        L55:
            android.widget.ImageView r10 = r10.ivBack
            com.stepos.ailauncher.agent.aispace.market.E0 r2 = new com.stepos.ailauncher.agent.aispace.market.E0
            r2.<init>()
            r10.setOnClickListener(r2)
            W4.c r10 = W4.c.INSTANCE
            android.content.Intent r2 = r9.getIntent()
            java.lang.String r3 = "extra_filter"
            java.lang.String r2 = r2.getStringExtra(r3)
            if (r2 == 0) goto L98
            int r4 = r2.hashCode()
            r5 = -934610874(0xffffffffc84af846, float:-207841.1)
            if (r4 == r5) goto L8a
            r5 = -892366860(0xffffffffcacf8ff4, float:-6801402.0)
            if (r4 == r5) goto L7c
            goto L98
        L7c:
            java.lang.String r4 = "stepai"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L86
            goto L98
        L86:
            java.lang.String r2 = "stepai_desktop"
            goto La0
        L8a:
            java.lang.String r4 = "remote"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L94
            goto L98
        L94:
            java.lang.String r2 = "remote_agent"
            goto La0
        L98:
            android.content.Intent r2 = r9.getIntent()
            java.lang.String r2 = r2.getStringExtra(r3)
        La0:
            r10.l(r2)
            com.stepos.ailauncher.agent.aispace.AgentTabView r3 = new com.stepos.ailauncher.agent.aispace.AgentTabView
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            r4 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            com.stepos.ailauncher.agent.aispace.AgentTabView$PageMode r9 = com.stepos.ailauncher.agent.aispace.AgentTabView.PageMode.DEVICE_LIST
            r3.W(r9)
            Y4.d r9 = r4.binding
            if (r9 != 0) goto Lba
            kotlin.jvm.internal.p.A(r1)
            goto Lbb
        Lba:
            r0 = r9
        Lbb:
            android.widget.FrameLayout r9 = r0.flContainer
            r9.addView(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
