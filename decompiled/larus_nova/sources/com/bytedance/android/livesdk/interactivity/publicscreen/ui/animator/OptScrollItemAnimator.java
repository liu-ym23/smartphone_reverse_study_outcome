package com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.d7;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ec2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class OptScrollItemAnimator extends BaseScrollItemAnimator {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static TimeInterpolator f140223k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f140224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<b> f140225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f140226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f140227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f140228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f140229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f140230j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f140231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f140232b;

        public a(RecyclerView.ViewHolder r100, int r101) {
            this.f140231a = r100;
            this.f140232b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f140233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f140234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f140235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f140236d;

        public b(RecyclerView.ViewHolder r100, int r101, int r102, int r103) {
            this.f140233a = r100;
            this.f140234b = r101;
            this.f140235c = r102;
            this.f140236d = r103;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        int r100 = this.f140225e.size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        b r101 = (b) ListProtector.get(this.f140225e, r100);
        View r102 = r101.f140233a.itemView;
        r102.setTranslationY(0.0f);
        r102.setTranslationX(0.0f);
        dispatchMoveFinished(r101.f140233a);
        ListProtector.remove(this.f140225e, r100);
        goto L3
    L6:
        int r103 = this.f140224d.size();
    L7:
        r103 = r103 - 1;
        if (r103 < 0) goto L11;
        RecyclerView.ViewHolder r104 = ((a) ListProtector.get(this.f140224d, r103)).f140231a;
        r104.itemView.setTranslationY(0.0f);
        dispatchAddFinished(r104);
        ListProtector.remove(this.f140224d, r103);
        goto L7
    L11:
        if (isRunning() == true) goto L13;
        return;
    L13:
        ArrayList<RecyclerView.ViewHolder> r105 = this.f140227g;
        int r106 = r105.size();
    L14:
        r106 = r106 - 1;
        if (r106 < 0) goto L17;
        ((RecyclerView.ViewHolder) ListProtector.get(r105, r106)).itemView.animate().cancel();
        goto L14
    L17:
        ArrayList<RecyclerView.ViewHolder> r107 = this.f140226f;
        int r108 = r107.size();
    L18:
        r108 = r108 - 1;
        if (r108 < 0) goto L21;
        ((RecyclerView.ViewHolder) ListProtector.get(r107, r108)).itemView.animate().cancel();
        goto L18
    L21:
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (this.f140224d.isEmpty() == true) goto L5;
    L12:
        return true;
    L5:
        if (this.f140225e.isEmpty() == false) goto L12;
        if (this.f140227g.isEmpty() == false) goto L12;
        if (this.f140226f.isEmpty() == false) goto L12;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        boolean r100 = !this.f140225e.isEmpty();
        boolean r101 = !this.f140224d.isEmpty();
        if (r100 == true) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        int r102 = 0;
        if (r100 == false) goto L19;
        Iterator<b> r103 = this.f140225e.iterator();
    L10:
        if (r103.hasNext() == false) goto L18;
        b r104 = r103.next();
        RecyclerView.ViewHolder r110 = r104.f140233a;
        int r105 = r104.f140234b;
        int r106 = r104.f140235c;
        View r111 = r110.itemView;
        int r112 = r106 - r105;
        long r107 = Math.min((long) (Math.abs(r112) * this.f140220a), this.f140222c);
        this.f140227g.add(r110);
        ViewPropertyAnimator r113 = r111.animate();
        if (r112 == 0) goto L15;
        r113.translationY(0.0f);
    L15:
        if (this.f140229i != 2) goto L17;
        r113.withLayer();
    L17:
        r113.setDuration(Math.max(0, r107)).setListener(new ta2.b(this, r111, r110, r112, r113)).start();
        goto L10
    L18:
        ArrayList<b> r108 = this.f140225e;
        r102 = 0 + ((b) ListProtector.get(r108, r108.size() - 1)).f140236d;
        this.f140225e.clear();
    L19:
        if (r101 == false) goto L43;
        Iterator<a> r109 = this.f140224d.iterator();
    L22:
        if (r109.hasNext() == false) goto L24;
        r102 = r102 + (r109.next().f140232b + this.f140221b);
        goto L22
    L24:
        Iterator<a> r114 = this.f140224d.iterator();
    L26:
        if (r114.hasNext() == false) goto L34;
        RecyclerView.ViewHolder r115 = r114.next().f140231a;
        View r116 = r115.itemView;
        if (r102 == 0) goto L30;
        r116.setTranslationY(r102);
        r116.animate().translationY(0.0f);
        r116.animate().alpha(1.0f);
    L30:
        ViewPropertyAnimator r117 = r116.animate();
        this.f140226f.add(r115);
        long r118 = Math.min((long) (Math.abs(r102) * this.f140220a), this.f140222c);
        if (this.f140229i != 1) goto L33;
        r117.withLayer();
    L33:
        r117.setDuration(Math.max(0, r118)).setListener(new ta2.a(this, r116, r115, r102, r117)).start();
        goto L26
    L34:
        this.f140224d.clear();
        return;
    }

    public OptScrollItemAnimator() {
        this.f140224d = new ArrayList();
        this.f140225e = new ArrayList();
        this.f140226f = new ArrayList();
        this.f140227g = new ArrayList();
        this.f140228h = true;
        this.f140229i = q0.f472049a.getValue().publicScreenAnimHWStyle;
        this.f140230j = d7.f121935a.getValue().booleanValue();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        View r101 = r100.itemView;
        int r102 = r101.getHeight();
        r101.setAlpha(0.0f);
        resetAnimation(r100);
        this.f140224d.add(new a(r100, r102));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        dispatchRemoveFinished(r100);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r100) {
        View r101 = r100.itemView;
        r101.animate().cancel();
        boolean r102 = true;
        int r103 = this.f140225e.size() - 1;
    L3:
        if (r103 < 0) goto L8;
        if (((b) ListProtector.get(this.f140225e, r103)).f140233a != r100) goto L7;
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        dispatchMoveFinished(r100);
        ListProtector.remove(this.f140225e, r103);
    L7:
        r103 = r103 - 1;
        goto L3
    L8:
        int r104 = this.f140224d.size();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L14;
        if (r100 == ((a) ListProtector.get(this.f140224d, r105)).f140231a) goto L12;
        r105 = r105 + 1;
        goto L9
    L12:
        ListProtector.remove(this.f140224d, r105);
    L15:
        if (r102 == false) goto L18;
        r101.setAlpha(1.0f);
        dispatchAddFinished(r100);
    L18:
        if (isRunning() == true) goto L26;
        dispatchAnimationsFinished();
        return;
    L26:
        return;
    L14:
        r102 = false;
        goto L15
    }

    public final void resetAnimation(RecyclerView.ViewHolder r100) {
        if (f140223k != null) goto L5;
        f140223k = new ValueAnimator().getInterpolator();
    L5:
        r100.itemView.animate().setInterpolator(f140223k);
        endAnimation(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r100, List<Object> r101) {
        if (r101.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r100, r101) == true) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
        View r105 = r100.itemView;
        if (this.f140228h == true) goto L5;
    L7:
        int r106 = 0;
    L8:
        int r107 = r102 + ((int) r100.itemView.getTranslationY());
        resetAnimation(r100);
        int r108 = r104 - r107;
        if (r108 != 0) goto L12;
        dispatchMoveFinished(r100);
        return false;
    L12:
        r105.setTranslationY(-r108);
        this.f140225e.add(new b(r100, r107, r104, r106));
        return true;
    L5:
        if (((int) r105.getTranslationY()) <= 0) goto L7;
        r106 = (int) r100.itemView.getTranslationY();
        goto L8
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r110, int r111, int r112) {
        if (this.f140230j == false) goto L8;
        if (r100 == r101) goto L7;
        dispatchChangeFinished(r100, true);
    L7:
        return animateMove(r101, r102, r110, r111, r112);
    L8:
        dispatchChangeFinished(r100, true);
        if (r100 == r101) goto L11;
        dispatchChangeFinished(r101, false);
    L11:
        return true;
    }
}
