package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.aq;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public class ComponentDialog extends Dialog implements d, p {
    private r _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    public ComponentDialog(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this(r5, 0, 2, null);
    }

    private static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    public static /* synthetic */ void lambda$3VrmmHeIN9Sasz9FquQXdvV7x_o(ComponentDialog r0) {
        m0onBackPressedDispatcher$lambda1(r0);
    }

    public /* synthetic */ ComponentDialog(Context r2, int r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        this(r6, r3);
    }

    public ComponentDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r4);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new $$Lambda$ComponentDialog$3VrmmHeIN9Sasz9FquQXdvV7x_o(this));
    }

    private final r getLifecycleRegistry() {
        r r0 = this._lifecycleRegistry;
        if (r0 != null) goto L6;
        r r1 = new r((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
        this._lifecycleRegistry = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // androidx.lifecycle.p
    public final i getLifecycle() {
        return (i) ZeusTransformUtils.preCheckCast(getLifecycleRegistry(), i.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.onBackPressedDispatcher.a(getOnBackInvokedDispatcher());
    L5:
        getLifecycleRegistry().a(i.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().a(i.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        getLifecycleRegistry().a(i.a.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    /* JADX INFO: renamed from: onBackPressedDispatcher$lambda-1, reason: not valid java name */
    private static final void m0onBackPressedDispatcher$lambda1(ComponentDialog r1) {
        o.e(r1, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.activity.d
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.c();
    }

    @Override // android.app.Dialog
    public void setContentView(int r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2) {
        o.e(r2, "view");
        initViewTreeOwners();
        super.setContentView(r2);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        o.e(r2, "view");
        initViewTreeOwners();
        super.setContentView(r2, r3);
    }

    @Override // android.app.Dialog
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        o.e(r2, "view");
        initViewTreeOwners();
        super.addContentView(r2, r3);
    }

    private final void initViewTreeOwners() {
        Window r0 = getWindow();
        o.a(r0);
        aq.a(r0.getDecorView(), (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
        Window r1 = getWindow();
        o.a(r1);
        View r2 = r1.getDecorView();
        o.c(r2, "window!!.decorView");
        f.a(r2, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
    }
}
