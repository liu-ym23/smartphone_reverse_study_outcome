package com.stepos.ailauncher.oobe;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.stepos.ailauncher.oobe.N;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/oobe/SetupCompleteActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetupCompleteActivity extends b.q {
    public static final void o(View view) {
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        N.Companion companion = N.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        companion.a(window);
        setContentView(R$layout.oobe_activity_setup_complete);
        ((Button) findViewById(R$id.btn_start)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetupCompleteActivity.o(view);
            }
        });
    }
}
