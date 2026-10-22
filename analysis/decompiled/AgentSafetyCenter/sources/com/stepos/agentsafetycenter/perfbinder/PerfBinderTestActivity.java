package com.stepos.agentsafetycenter.perfbinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.p;
import com.stepos.policy.sdk.activity.b;
import java.lang.invoke.VarHandle;
import xb.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PerfBinderTestActivity extends p {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2510f = 0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f2511c;

    public static final void d(LinearLayout linearLayout, PerfBinderTestActivity perfBinderTestActivity, String str, a aVar) {
        Button button = new Button(perfBinderTestActivity);
        button.setText(str);
        b bVar = new b(1);
        bVar.f2783f = aVar;
        bVar.f2784g = perfBinderTestActivity;
        VarHandle.storeStoreFence();
        button.setOnClickListener(bVar);
        linearLayout.addView(button);
    }

    public final void c(String str) {
        TextView textView = this.f2511c;
        if (textView == null) {
            k.f("logView");
            throw null;
        }
        textView.append(str.concat("\n"));
        Toast.makeText(this, str, 0).show();
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(48, 48, 48, 48);
        TextView textView = new TextView(this);
        textView.setTextSize(12.0f);
        textView.setTextIsSelectable(true);
        this.f2511c = textView;
        f9.a aVar = new f9.a(0);
        aVar.f4045f = this;
        VarHandle.storeStoreFence();
        d(linearLayout, this, "writeScreenPerceptionGlobalPolicy(on,TASK_EXECUTION)", aVar);
        f9.a aVar2 = new f9.a(1);
        aVar2.f4045f = this;
        VarHandle.storeStoreFence();
        d(linearLayout, this, "writeScreenPerceptionGlobalPolicy(off)", aVar2);
        f9.a aVar3 = new f9.a(2);
        aVar3.f4045f = this;
        VarHandle.storeStoreFence();
        d(linearLayout, this, "isLockPasswordEnabled", aVar3);
        TextView textView2 = this.f2511c;
        if (textView2 == null) {
            k.f("logView");
            throw null;
        }
        linearLayout.addView(textView2);
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
