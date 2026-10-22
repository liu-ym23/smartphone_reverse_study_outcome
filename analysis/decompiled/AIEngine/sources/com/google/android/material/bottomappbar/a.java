package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import stepos.support.v7.app.s;
import stepos.support.v7.app.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4659b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f4658a = i10;
        this.f4659b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i10 = this.f4658a;
        Object obj = this.f4659b;
        switch (i10) {
            case 0:
                int i11 = BottomAppBar.f4643i0;
                ((BottomAppBar) obj).V = null;
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                e2.d dVar = (e2.d) obj;
                ArrayList arrayList = new ArrayList(dVar.f8531e);
                int size = arrayList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    ((e2.c) arrayList.get(i12)).a(dVar);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4658a) {
            case 0:
                break;
            case 1:
                ((com.google.android.material.textfield.c) this.f4659b).f5287b.h(true);
                break;
            case 2:
                e2.d dVar = (e2.d) this.f4659b;
                ArrayList arrayList = new ArrayList(dVar.f8531e);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((e2.c) arrayList.get(i10)).b(dVar);
                }
                break;
            default:
                if (!((s) this.f4659b).a()) {
                    w.a().getClass();
                    break;
                }
                break;
        }
    }

    private final void a(Animator animator) {
    }
}
