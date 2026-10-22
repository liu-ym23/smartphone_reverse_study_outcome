package com.mdisdk.core;

import C7.f;
import D6.i;
import P3.d;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.UiCapabilityManager;
import com.mdisdk.display.OmniDisplay;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/mdisdk/core/TaskContext;", "", "Landroid/content/Context;", "applicationContext", "Lcom/mdisdk/display/OmniDisplay;", "display", AppAgent.CONSTRUCT, "(Landroid/content/Context;Lcom/mdisdk/display/OmniDisplay;)V", "", "getTaskDisplayId", "()I", "Landroid/view/Display;", "getDisplay", "()Landroid/view/Display;", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "Lcom/mdisdk/display/OmniDisplay;", "()Lcom/mdisdk/display/OmniDisplay;", "Lcom/mdisdk/capability/UiCapabilityManager;", "uiCapabilityManager$delegate", "LC7/f;", "getUiCapabilityManager", "()Lcom/mdisdk/capability/UiCapabilityManager;", "uiCapabilityManager", "Landroid/os/Handler;", "uiHandler$delegate", "getUiHandler", "()Landroid/os/Handler;", "uiHandler", "", "targetPackageName", "Ljava/lang/String;", "getTargetPackageName", "()Ljava/lang/String;", "setTargetPackageName", "(Ljava/lang/String;)V", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskContext {
    private final Context applicationContext;
    private final OmniDisplay display;
    private String targetPackageName;

    /* renamed from: uiCapabilityManager$delegate, reason: from kotlin metadata */
    private final f uiCapabilityManager;

    /* renamed from: uiHandler$delegate, reason: from kotlin metadata */
    private final f uiHandler;

    public TaskContext(Context applicationContext, OmniDisplay display) {
        k.f(applicationContext, "applicationContext");
        k.f(display, "display");
        this.applicationContext = applicationContext;
        this.display = display;
        this.uiCapabilityManager = a.a(new i(this, 17));
        this.uiHandler = a.a(new d(26));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UiCapabilityManager uiCapabilityManager_delegate$lambda$0(TaskContext taskContext) {
        return new UiCapabilityManager(taskContext.applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler uiHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final OmniDisplay getDisplay() {
        return this.display;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public final int getTaskDisplayId() {
        return this.display.getDisplayId();
    }

    public final UiCapabilityManager getUiCapabilityManager() {
        return (UiCapabilityManager) this.uiCapabilityManager.getF4884a();
    }

    public final Handler getUiHandler() {
        return (Handler) this.uiHandler.getF4884a();
    }

    public final void setTargetPackageName(String str) {
        this.targetPackageName = str;
    }

    public final Display getDisplay() {
        return this.display.getTargetDisplay();
    }
}
