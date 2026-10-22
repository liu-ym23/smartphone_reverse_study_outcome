package com.bytedance.android.live.room.api.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class PanelCoverListener implements com.bytedance.android.live.room.api.panel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<e> f99041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f99042b;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PanelCoverListener f99043a;

        public b(PanelCoverListener r100) {
            this.f99043a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            ALogger.i("PanelCoverListener", "listener = " + this.f99043a.getName() + ", onAnimationEnd GONE");
            View r101 = this.f99043a.d();
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PanelCoverListener f99044a;

        public c(PanelCoverListener r100) {
            this.f99044a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            ALogger.i("PanelCoverListener", "listener = " + this.f99044a.getName() + ", onAnimationStart VISIBLE");
            View r101 = this.f99044a.d();
            if (r101 == null) goto L6;
            r101.setVisibility(0);
            return;
        }
    }

    static {
    }

    public void f() {
        ALogger.i("PanelCoverListener", "hide, listener = " + getName());
        if (((Number) this.f99042b.getValue()).intValue() != 1) goto L8;
        ALogger.i("PanelCoverListener", "hide, opt type = 1, GONE");
        View r100 = d();
        if (r100 == null) goto L23;
        r100.setVisibility(8);
        return;
    L23:
        return;
    L8:
        View r101 = d();
        if (r101 == null) goto L24;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 != null) goto L13;
        return;
    L13:
        if (((Number) this.f99042b.getValue()).intValue() != 2) goto L15;
        ALogger.i("PanelCoverListener", "opt type = 2, call withLayer");
        r102.withLayer();
    L15:
        ViewPropertyAnimator r103 = r102.alpha(0.0f);
        if (r103 == null) goto L26;
        ViewPropertyAnimator r104 = r103.setDuration(200);
        if (r104 == null) goto L27;
        ViewPropertyAnimator r105 = r104.setListener(new b(this));
        if (r105 == null) goto L28;
        r105.start();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public void g() {
        ALogger.i("PanelCoverListener", "show, listener = " + getName());
        if (((Number) this.f99042b.getValue()).intValue() != 1) goto L8;
        ALogger.i("PanelCoverListener", "show, opt type = 1, VISIBLE");
        View r100 = d();
        if (r100 == null) goto L23;
        r100.setVisibility(0);
        return;
    L23:
        return;
    L8:
        View r101 = d();
        if (r101 == null) goto L24;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 != null) goto L13;
        return;
    L13:
        if (((Number) this.f99042b.getValue()).intValue() != 2) goto L15;
        ALogger.i("PanelCoverListener", "opt type = 2, call withLayer");
        r102.withLayer();
    L15:
        ViewPropertyAnimator r103 = r102.alpha(1.0f);
        if (r103 == null) goto L26;
        ViewPropertyAnimator r104 = r103.setDuration(200);
        if (r104 == null) goto L27;
        ViewPropertyAnimator r105 = r104.setListener(new c(this));
        if (r105 == null) goto L28;
        r105.start();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public PanelCoverListener() {
        this.f99042b = LazyKt.lazy(PanelCoverListener$optType$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.api.panel.a
    public final void a(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "panelInfo");
        List<e> r101 = this.f99041a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        ALogger.i("PanelCoverListener", "onPanelClose, hidePanelInfoList is null or empty");
        return;
    L12:
        Function1<e, Boolean> r103 = new PanelCoverListener$onPanelClose$1(r100);
        ArrayList r104 = (ArrayList) r101;
        Iterator r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L19;
        if (((Boolean) r103.invoke(r105.next())).booleanValue() == false) goto L14;
        r105.remove();
        goto L14
    L19:
        if (r104.isEmpty() == false) goto L27;
        g();
        return;
    L27:
        return;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.room.api.panel.a
    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "panelInfo");
        if (e(r100) == true) goto L5;
        return;
    L5:
        if (this.f99041a != null) goto L7;
        this.f99041a = new ArrayList();
    L7:
        List<e> r101 = this.f99041a;
        if (r101 != null) goto L10;
    L12:
        List<e> r102 = this.f99041a;
        if (r102 == null) goto L17;
        ((ArrayList) r102).add(r100);
        return;
    L17:
        return;
    L10:
        if (((ArrayList) r101).size() != 0) goto L12;
        f();
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.panel.a
    public final void c(RemoveReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ALogger.i("PanelCoverListener", getName() + " remove, reason = " + r100.getReason());
        List<e> r101 = this.f99041a;
        if (r101 == null) goto L5;
        int r102 = ((ArrayList) r101).size();
    L6:
        if (r102 <= 0) goto L13;
        ALogger.i("PanelCoverListener", "hidePanelInfoList size > 0");
        View r103 = d();
        if (r103 == null) goto L10;
        r103.setVisibility(0);
    L10:
        View r104 = d();
        if (r104 == null) goto L13;
        r104.setAlpha(1.0f);
    L13:
        List<e> r105 = this.f99041a;
        if (r105 == null) goto L17;
        ((ArrayList) r105).clear();
        return;
    L17:
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
