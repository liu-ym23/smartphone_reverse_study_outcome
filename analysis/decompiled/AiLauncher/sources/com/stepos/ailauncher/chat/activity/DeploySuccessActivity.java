package com.stepos.ailauncher.chat.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.wake.WakeService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/DeploySuccessActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeploySuccessActivity extends b.q {
    public static final void p(DeploySuccessActivity deploySuccessActivity, View view) {
        deploySuccessActivity.finish();
    }

    public static final void q(DeploySuccessActivity deploySuccessActivity, View view) {
        deploySuccessActivity.finish();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_deploy_success);
        WakeService.Companion.a0(WakeService.INSTANCE, this, false, 2, null);
        ((ImageButton) findViewById(R$id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.J0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeploySuccessActivity.p(this.f24738a, view);
            }
        });
        ((Button) findViewById(R$id.btn_start)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.K0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeploySuccessActivity.q(this.f24741a, view);
            }
        });
    }
}
