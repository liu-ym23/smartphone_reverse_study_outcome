package com.stepos.agentsafetycenter.auth;

import android.os.Bundle;
import java.util.Stack;
import o8.n;
import p5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ResumeAuthActivity extends LaunchAuthActivity {
    @Override // com.stepos.agentsafetycenter.auth.LaunchAuthActivity
    public final void f() {
        Stack stack = n.f9321a;
        n.f9325e = false;
        n.c(true);
        n.f9326f = true;
        super.f();
    }

    @Override // com.stepos.agentsafetycenter.auth.LaunchAuthActivity, androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        this.i = false;
        if (bundle != null || f.C(this)) {
            n.b();
            super.onCreate(bundle);
            return;
        }
        Stack stack = n.f9321a;
        n.f9325e = false;
        n.c(true);
        n.f9326f = true;
        finish();
    }
}
