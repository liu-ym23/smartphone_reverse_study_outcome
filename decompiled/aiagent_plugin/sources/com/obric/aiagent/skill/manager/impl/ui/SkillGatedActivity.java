package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillGatedActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SkillGatedActivity extends FragmentActivity {
    private boolean hasResumed;
    private boolean hasStarted;
    private final d.f pageGuard$delegate;
    private boolean refreshedDuringStart;

    /* JADX INFO: renamed from: lambda$9tBxC2qZEtjLm6wIeAybvSL-gag, reason: not valid java name */
    public static /* synthetic */ bl m307lambda$9tBxC2qZEtjLm6wIeAybvSLgag(SkillGatedActivity r0) {
        return pageGuard_delegate$lambda$0(r0);
    }

    public OFloatingTitleBar getFloatingTitleBar() {
        return null;
    }

    public SkillGatedActivity() {
        this.pageGuard$delegate = d.g.a(d.j.f38507c, new $$Lambda$SkillGatedActivity$9tBxC2qZEtjLm6wIeAybvSLgag(this));
    }

    private final bl getPageGuard() {
        return (bl) ZeusTransformUtils.preCheckCast(this.pageGuard$delegate.b(), bl.class, "com.obric.aiagent.plugin");
    }

    private static final bl pageGuard_delegate$lambda$0(SkillGatedActivity r3) {
        return new bl((FragmentActivity) ZeusTransformUtils.preCheckCast((SkillGatedActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillGatedActivity.class, "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"));
    }

    public final boolean isSkillPageAvailable() {
        return getPageGuard().a();
    }

    public final boolean isSkillPageContentInitialized() {
        return getPageGuard().b();
    }

    public final void installSkillPageGuard(int r3, d.h.a.b<? super ISkillManagerService, d.x> r4) {
        d.h.a.b<? super ISkillManagerService, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "initializeContent");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(r3), ViewGroup.class, "com.obric.aiagent.plugin");
        bl r2 = getPageGuard();
        d.h.b.o.a(r6);
        r2.a(r6, r5);
    }

    public final void launchFloatingActivity(Intent r8) {
        d.h.b.o.e(r8, MemorySourceLinkType.INTENT);
        OFloatingTitleBar r3 = getFloatingTitleBar();
        if (r3 == null) goto L22;
        ComponentName r1 = r8.getComponent();
        if (r1 == null) goto L7;
        String r2 = r1.getPackageName();
    L9:
        if (d.h.b.o.a(r2, getPackageName()) == false) goto L22;
        if ((r8.getFlags() & 268435456) != 0) goto L22;
        FloatingTransitionBridge.b.a(FloatingTransitionBridge.f36698a, (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), r3, null, 4, null);
        ZeusTransformUtils.startActivity(this, r8, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        FloatingTransitionBridge.f36698a.a();     // Catch: Exception -> L19
    L21:
        throw e;
    L19:
        e = move-exception;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L21
    L7:
        r2 = null;
    L22:
        ZeusTransformUtils.startActivity(this, r8, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        if (this.hasStarted == true) goto L6;
        this.hasStarted = true;
        return;
    L6:
        this.refreshedDuringStart = true;
        getPageGuard().c();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (this.hasResumed == true) goto L7;
        this.hasResumed = true;
        return;
    L7:
        if (this.refreshedDuringStart == false) goto L10;
        this.refreshedDuringStart = false;
        return;
    L10:
        getPageGuard().c();
    }
}
