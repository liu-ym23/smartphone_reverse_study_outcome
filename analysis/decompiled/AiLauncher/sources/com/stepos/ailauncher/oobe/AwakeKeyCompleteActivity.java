package com.stepos.ailauncher.oobe;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.stepos.ailauncher.oobe.N;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/oobe/AwakeKeyCompleteActivity;", "Lb/q;", "<init>", "()V", "LY8/t;", "q", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AwakeKeyCompleteActivity extends b.q {
    private final void q() {
        int iC = androidx.core.content.a.c(this, R$color.oobe_dark_bg);
        getWindow().setStatusBarColor(iC);
        getWindow().setNavigationBarColor(iC);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
    }

    public static final void r(AwakeKeyCompleteActivity awakeKeyCompleteActivity, View view) {
        awakeKeyCompleteActivity.finish();
    }

    public static final void s(AwakeKeyCompleteActivity awakeKeyCompleteActivity, View view) {
        O.INSTANCE.e(awakeKeyCompleteActivity);
        awakeKeyCompleteActivity.finish();
    }

    public static final void t(AwakeKeyCompleteActivity awakeKeyCompleteActivity, View view) {
        O.INSTANCE.e(awakeKeyCompleteActivity);
        awakeKeyCompleteActivity.finish();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        N.Companion companion = N.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        companion.a(window);
        setContentView(R$layout.oobe_activity_awake_key_complete);
        q();
        ((ImageButton) findViewById(R$id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.K
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyCompleteActivity.r(this.f27547a, view);
            }
        });
        ((TextView) findViewById(R$id.tv_skip)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.L
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyCompleteActivity.s(this.f27551a, view);
            }
        });
        ((Button) findViewById(R$id.btn_continue)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyCompleteActivity.t(this.f27555a, view);
            }
        });
    }
}
