package com.stepos.ailauncher.container;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.stepos.launcher.assistant.widgetdrag.ScrollOverlayWidgetComponent;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\u000eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/container/d;", "Lcom/stepos/launcher/assistant/widgetdrag/ScrollOverlayWidgetComponent;", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/ComponentCallbacks2;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "bundle", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", "onPause", "onResume", "onStop", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "", "level", "onTrimMemory", "(I)V", "r", "p", "q", "Lcom/stepos/ailauncher/container/q0;", "_dispatcher", "Lcom/stepos/ailauncher/container/q0;", "configuration", "Landroid/content/res/Configuration;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "o", "()Lcom/stepos/ailauncher/container/q0;", "dispatcher", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.container.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ComponentCallbacks2C3211d extends ScrollOverlayWidgetComponent implements LifecycleOwner, ComponentCallbacks2 {
    private q0 _dispatcher;
    private final Configuration configuration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentCallbacks2C3211d(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.configuration = new Configuration();
    }

    @Override // android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return o().b();
    }

    public final q0 o() {
        if (this._dispatcher == null) {
            this._dispatcher = new q0(this);
        }
        q0 q0Var = this._dispatcher;
        kotlin.jvm.internal.p.f(q0Var);
        return q0Var;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        if (newConfig.orientation == 2) {
            q();
            this.configuration.setTo(newConfig);
            return;
        }
        int iDiff = newConfig.diff(this.configuration);
        boolean z10 = (iDiff & 1024) != 0;
        boolean z11 = (iDiff & 4096) != 0;
        this.configuration.setTo(newConfig);
        if (z10 || z11) {
            p();
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onCreate(Bundle bundle) {
        o().a(Lifecycle.Event.ON_CREATE);
        Context context = this.mWindowContext;
        if (context != null) {
            context.registerComponentCallbacks(this);
        }
        this.configuration.setTo(getApplicationContext().getResources().getConfiguration());
        super.onCreate(bundle);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onDestroy() {
        o().a(Lifecycle.Event.ON_DESTROY);
        this._dispatcher = null;
        Context context = this.mWindowContext;
        if (context != null) {
            context.unregisterComponentCallbacks(this);
        }
        super.onDestroy();
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        r(80);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onPause() {
        o().a(Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onResume() {
        o().a(Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onStart() {
        o().a(Lifecycle.Event.ON_START);
        super.onStart();
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onStop() {
        o().a(Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        r(level);
    }

    public void p() {
    }

    public void q() {
    }

    public void r(int level) {
    }
}
