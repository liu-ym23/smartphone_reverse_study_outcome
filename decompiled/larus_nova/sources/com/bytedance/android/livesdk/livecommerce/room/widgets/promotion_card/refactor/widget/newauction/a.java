package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f152531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f152532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f152533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f152534d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a$a, reason: collision with other inner class name */
    public static final class C2347a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f152536b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a$b$a, reason: collision with other inner class name */
        public static final class C2348a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f152537a;

            public C2348a(b r100) {
                this.f152537a = r100;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                b r101 = this.f152537a;
                a r102 = r101.f152535a;
                T r103 = (T) r101.f152536b;
                r102.f152531a = r103;
                r102.a(r103, r102.f152532b);
                this.f152537a.f152535a.f152532b.setAlpha(1.0f);
                this.f152537a.f152535a.f152533c.setVisibility(4);
            }
        }

        public b(a r100, Object r101) {
            this.f152535a = r100;
            this.f152536b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            this.f152535a.f152532b.animate().alpha(0.0f).setListener(null).setDuration(250).start();
            this.f152535a.f152533c.setVisibility(0);
            this.f152535a.f152533c.setAlpha(0.0f);
            View r109 = this.f152535a.f152533c;
            r109.setTranslationY(r109.getMeasuredHeight() * this.f152535a.f152534d);
            this.f152535a.f152533c.animate().translationY(0.0f).alpha(1.0f).setListener(new C2348a(this)).setDuration(250).start();
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f152539b;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f152538a;
            T r102 = (T) this.f152539b;
            r101.f152531a = r102;
            r101.a(r102, r101.f152532b);
            this.f152538a.f152532b.setAlpha(1.0f);
            this.f152538a.f152533c.setVisibility(4);
        }

        public c(a r100, Object r101) {
            this.f152538a = r100;
            this.f152539b = r101;
        }
    }

    static {
    }

    public abstract void a(T r100, View r101);

    public abstract boolean b(T r100, T r101);

    public final void c(T r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        T r101 = this.f152531a;
        if (r101 != null) goto L8;
        a(r100, this.f152532b);
        this.f152532b.setAlpha(1.0f);
        this.f152533c.setVisibility(4);
        this.f152531a = r100;
        return;
    L8:
        if (b(r101, r100) == true) goto L10;
        a(r100, this.f152532b);
        this.f152532b.setAlpha(1.0f);
        this.f152533c.setVisibility(4);
        this.f152531a = r100;
        return;
    L10:
        a(this.f152531a, this.f152532b);
        a(r100, this.f152533c);
        View r102 = this.f152533c;
        if (ViewCompat.isLaidOut(r102) == true) goto L13;
    L15:
        r102.addOnLayoutChangeListener(new b(this, r100));
        return;
    L13:
        if (r102.isLayoutRequested() == true) goto L15;
        this.f152532b.animate().alpha(0.0f).setListener(null).setDuration(250).start();
        this.f152533c.setVisibility(0);
        this.f152533c.setAlpha(0.0f);
        View r103 = this.f152533c;
        r103.setTranslationY(r103.getMeasuredHeight() * this.f152534d);
        this.f152533c.animate().translationY(0.0f).alpha(1.0f).setListener(new c(this, r100)).setDuration(250).start();
    }

    public a(View r100, View r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "hideView");
        Intrinsics.checkNotNullParameter(r101, "showView");
        this.f152532b = r100;
        this.f152533c = r101;
        this.f152534d = r102;
    }
}
