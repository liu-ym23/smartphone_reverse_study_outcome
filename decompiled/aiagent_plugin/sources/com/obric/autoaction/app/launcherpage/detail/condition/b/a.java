package com.obric.autoaction.app.launcherpage.detail.condition.b;

import android.content.Context;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.function.Consumer;

/* JADX INFO: compiled from: AbstractReelPickerController.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.oui.picker.reels.a f23404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f23405b;

    /* JADX INFO: renamed from: lambda$5YS_V-SJQYz9Mw1nRHuWAs_vTfU, reason: not valid java name */
    public static /* synthetic */ void m489lambda$5YS_VSJQYz9Mw1nRHuWAs_vTfU(a r0, Object r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$kJeo8Mjvb9aItiionEgslouApRY(a r0, Consumer r1, com.obric.oui.picker.reels.a.a.b r2) {
        a(r0, r1, r2);
    }

    public abstract void a(Context r1, com.obric.oui.picker.reels.a.a.C0970a r2, T r3);

    public a() {
    }

    public com.obric.oui.picker.reels.a.a a(Context r9, final T r10, Consumer<T> r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        final Consumer r12 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r11, Consumer.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r12, "onChangeListener");
        com.obric.oui.picker.reels.a.a.C0970a r13 = new com.obric.oui.picker.reels.a.a.C0970a();
        a(r3, r13, r10);
        r13.a(new $$Lambda$a$kJeo8Mjvb9aItiionEgslouApRY(this, r12));
        com.obric.oui.picker.reels.a.a r14 = (com.obric.oui.picker.reels.a.a) ZeusTransformUtils.preCheckCast(com.obric.oui.picker.reels.a.b.a.a((com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), r3, null, 0, 6, null), com.obric.oui.picker.reels.a.a.class, "com.obric.aiagent.plugin");
        View r15 = r14.a();
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.picker.reels.a.class) == false) goto L5;
        com.obric.oui.picker.reels.a r16 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
    L6:
        this.f23404a = r16;
        this.f23405b = r10;
        View r17 = r14.a();
        if (r17 == null) goto L9;
        r17.post(new $$Lambda$a$5YS_VSJQYz9Mw1nRHuWAs_vTfU(this, r10));
    L9:
        return r14;
    L5:
        r16 = null;
        goto L6
    }

    private static final void a(a r2, Consumer r3, com.obric.oui.picker.reels.a.a.b r4) {
        Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        com.obric.oui.picker.reels.a r6 = r2.f23404a;
        if (r6 != null) goto L5;
        return;
    L5:
        T r0 = r2.f23405b;
        if (r0 != null) goto L8;
        return;
    L8:
        r2.a(r6, r0);
        com.obric.oui.picker.reels.a r7 = r2.f23404a;
        if (r7 != null) goto L11;
        return;
    L11:
        T r8 = r2.a(r7);
        if (r8 != null) goto L14;
        return;
    L14:
        r5.accept(r8);
        r2.f23405b = r8;
    }

    private static final void a(a r1, Object r2) {
        com.obric.oui.picker.reels.a r0 = r1.f23404a;
        if (r0 != null) goto L5;
        return;
    L5:
        r1.b(r0, r2);
    }
}
