package com.bytedance.android.ec.hybrid.list.ability;

import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/ability/ECMallOnceAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallOnceAnimator extends DefaultItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f46960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PathInterpolator f46961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f46962c;

    public static final class a implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMallOnceAnimator f46963a;

        public a(ECMallOnceAnimator r100) {
            this.f46963a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public final void onAnimationsFinished() {
            this.f46963a.f46962c.setItemAnimator(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final long getAddDuration() {
        return 300;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final long getMoveDuration() {
        return 300;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if ((!this.f46960a.isEmpty()) == false) goto L5;
        return true;
    L5:
        if (super.isRunning() == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        super.runPendingAnimations();
        if ((!this.f46960a.isEmpty()) == false) goto L8;
        int r100 = this.f46960a.size();
    L5:
        r100 = r100 - 1;
        if (r100 < 0) goto L8;
        RecyclerView.ViewHolder r101 = (RecyclerView.ViewHolder) ListProtector.get(this.f46960a, r100);
        r101.itemView.animate().translationY(0.0f).alpha(1.0f).setDuration(300).setInterpolator(this.f46961b).setListener(new j(this, r101)).start();
        ListProtector.remove(this.f46960a, r100);
    L8:
        isRunning(new a(this));
    }

    public ECMallOnceAnimator(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f46962c = r100;
        this.f46960a = new ArrayList();
        this.f46961b = new PathInterpolator(0.0f, 0.46f, 0.25f, 1.0f);
        r100.setItemAnimator(this);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        r100.itemView.setAlpha(0.0f);
        View r101 = r100.itemView;
        r101.setTranslationY(-r101.getHeight());
        r100.itemView.setTranslationZ(0.0f);
        this.f46960a.add(r100);
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f46960a.remove(r100) == false) goto L5;
        dispatchAddFinished(r100);
        r100.itemView.setTranslationY(0.0f);
        r100.itemView.setAlpha(1.0f);
        r100.itemView.setTranslationZ(1.0f);
    L5:
        super.endAnimation(r100);
    }
}
