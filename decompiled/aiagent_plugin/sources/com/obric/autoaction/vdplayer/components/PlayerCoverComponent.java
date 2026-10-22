package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ab;
import androidx.lifecycle.p;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.d.e;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autoaction.vdplayer.d.u;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import d.x;
import java.util.Iterator;

/* JADX INFO: compiled from: PlayerCoverComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerCoverComponent extends BaseVDPlayerSlotComponent<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f25292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f25293b;

    /* JADX INFO: compiled from: PlayerCoverComponent.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25294a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f25475a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[e.f25476b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[e.f25477c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f25294a = r0;
        }
    }

    public static /* synthetic */ x lambda$3MWTZugSna6iwzPykHAxXbNj5zw(ViewGroup r0, boolean r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ e lambda$ktZYMuBcaqtZZE4HHcY6RgQCwHU(s r0) {
        return a(r0);
    }

    public PlayerCoverComponent() {
        super($$Lambda$PlayerCoverComponent$ktZYMuBcaqtZZE4HHcY6RgQCwHU.INSTANCE);
        this.f25293b = System.currentTimeMillis();
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"));
    }

    private static final e a(s r1) {
        o.e(r1, "it");
        return r1.i();
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r5, com.obric.autoaction.a.c r6) {
        o.e(r5, "container");
        o.e(r6, "componentHost");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_player_cover, "layout", "vd_component_player_cover"), r5, false, "com.obric.aiagent.plugin");
        r7.setVisibility(8);
        o.a(r7, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f25292a = (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin");
        o.c(r7, "also(...)");
        return r7;
    }

    public void a(e r13) {
        o.e(r13, "coverState");
        final ViewGroup r0 = this.f25292a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r14 = a.f25294a[r13.ordinal()];
        if (r14 == 1) goto L19;
        if (r14 == 2) goto L13;
        if (r14 != 3) goto L12;
        a(r0);
        return;
    L12:
        throw new k();
    L13:
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
        Iterator<View> r12 = ab.b(r0).a();
    L15:
        if (r12.hasNext() == false) goto L17;
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r12.next(), View.class, "com.obric.aiagent.plugin"));
        goto L15
    L17:
        r0.setForeground(null);
        return;
    L19:
        if ((System.currentTimeMillis() - this.f25293b) >= 96) goto L21;
        r0.setVisibility(8);
        return;
    L21:
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(1000, 0, null, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$PlayerCoverComponent$3MWTZugSna6iwzPykHAxXbNj5zw(r0)).b(), null, null, 3, null);
    }

    private static final x a(ViewGroup r0, boolean r1, Throwable r2) {
        r0.setVisibility(8);
        return x.f38692a;
    }

    private final void a(ViewGroup r5) {
        r5.setVisibility(0);
        r5.setAlpha(1.0f);
        u r4 = b();
        if (r4 == null) goto L5;
        Bitmap r6 = r4.e();
    L7:
        if (r6 == null) goto L13;
        Iterator<View> r0 = ab.b(r5).a();
    L10:
        if (r0.hasNext() == false) goto L12;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        Resources r1 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin");
        o.c(r1, "getResources(...)");
        r5.setForeground((Drawable) ZeusTransformUtils.preCheckCast(new BitmapDrawable(r1, r6), Drawable.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i("PlayerCoverComponent", " use last-screen-cover ");
        return;
    L13:
        Iterator<View> r7 = ab.b(r5).a();
    L15:
        if (r7.hasNext() == false) goto L17;
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.aiagent.plugin"));
        goto L15
    L17:
        r5.setForeground(null);
        return;
    L5:
        r6 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25292a = null;
    }
}
