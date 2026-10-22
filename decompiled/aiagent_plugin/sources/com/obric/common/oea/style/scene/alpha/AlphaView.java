package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.p;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.c;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.File;

/* JADX INFO: compiled from: AlphaView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AlphaView extends FrameLayout {
    private a listener;
    private PlayerController playerController;

    /* JADX INFO: compiled from: AlphaView.kt */
    public interface a {
        void a();

        void a(int r1, int r2);

        void b();
    }

    /* JADX INFO: compiled from: AlphaView.kt */
    public static final class b implements com.obric.common.oea.style.scene.alpha.alphaplayer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlphaView f32481a;

        b(AlphaView r1) {
            this.f32481a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void a() {
            a r0 = this.f32481a.getListener();
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void b() {
            a r0 = this.f32481a.getListener();
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void a(int r2, int r3, d r4) {
            o.e(r4, "scaleType");
            a r1 = this.f32481a.getListener();
            if (r1 == null) goto L6;
            r1.a(r2, r3);
            return;
        }
    }

    public AlphaView(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public AlphaView(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public /* synthetic */ AlphaView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public AlphaView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public final a getListener() {
        return this.listener;
    }

    public final void setListener(a r3) {
        this.listener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    private final PlayerController getController() {
        if (this.playerController != null) goto L9;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        p r1 = findLifecycleOwner(r0);
        if (r1 == null) goto L8;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.b r3 = new com.obric.common.oea.style.scene.alpha.alphaplayer.a.b(r4, r1);
        r3.a(com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.f32482a);
        PlayerController r2 = new PlayerController(r3, null, 2, null);
        r2.setPlayerAction((com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.preCheckCast(new b(this), com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.aiagent.plugin"));
        x r5 = x.f38692a;
        this.playerController = r2;
        goto L9
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment)."), Throwable.class, "com.obric.aiagent.plugin"));
    L9:
        PlayerController r6 = this.playerController;
        o.a(r6);
        return r6;
    }

    private final p findLifecycleOwner(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, p.class) == true) goto L8;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "currentContext.baseContext");
        goto L4
    L8:
        return (p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }

    public static /* synthetic */ void start$default(AlphaView r0, File r1, boolean r2, d r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = d.f32494b;
    L8:
        r0.start(r1, r2, r3);
    }

    public final void start(File r4, boolean r5, d r6) {
        o.e(r4, "file");
        o.e(r6, "scaleType");
        File r0 = r4.getParentFile();
        if (r0 == null) goto L9;
        c r1 = new c();
        String r2 = r0.getAbsolutePath();
        o.c(r2, "parent.absolutePath");
        c r3 = r1.a(r2);
        String r7 = r4.getName();
        o.c(r7, "file.name");
        c r8 = r3.a(r7, r6);
        String r9 = r4.getName();
        o.c(r9, "file.name");
        c r10 = r8.b(r9, r6).a(r5);
        if (r10.b() == true) goto L7;
        return;
    L7:
        getController().start(r10);
        return;
    }

    public final void pause() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public final void resume() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L6;
        r0.resume();
        return;
    }

    public final void release() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.playerController = (PlayerController) ZeusTransformUtils.preCheckCast(null, PlayerController.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.player.d getStatus() {
        PlayerController r0 = this.playerController;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStatus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getController().attachAlphaView((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L5;
        r0.detachAlphaView((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
    L5:
        release();
    }
}
