package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations;
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList;
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations;
    ArrayList<ArrayList<ChangeInfo>> mChangesList;
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations;
    ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals;
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    /* JADX INFO: loaded from: classes17.dex */
    public static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }

        private ChangeInfo(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101) {
            this.oldHolder = r100;
            this.newHolder = r101;
        }

        public ChangeInfo(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105) {
            this(r100, r101);
            this.fromX = r102;
            this.fromY = r103;
            this.toX = r104;
            this.toY = r105;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        public MoveInfo(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
            this.holder = r100;
            this.fromX = r101;
            this.fromY = r102;
            this.toX = r103;
            this.toY = r104;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int r100 = this.mPendingMoves.size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        MoveInfo r101 = (MoveInfo) ListProtector.get(this.mPendingMoves, r100);
        View r102 = r101.holder.itemView;
        r102.setTranslationY(0.0f);
        r102.setTranslationX(0.0f);
        dispatchMoveFinished(r101.holder);
        ListProtector.remove(this.mPendingMoves, r100);
        goto L3
    L6:
        int r103 = this.mPendingRemovals.size() - 1;
    L7:
        if (r103 < 0) goto L9;
        dispatchRemoveFinished((RecyclerView.ViewHolder) ListProtector.get(this.mPendingRemovals, r103));
        ListProtector.remove(this.mPendingRemovals, r103);
        r103 = r103 - 1;
        goto L7
    L9:
        int r104 = this.mPendingAdditions.size();
    L10:
        r104 = r104 - 1;
        if (r104 < 0) goto L13;
        RecyclerView.ViewHolder r105 = (RecyclerView.ViewHolder) ListProtector.get(this.mPendingAdditions, r104);
        r105.itemView.setAlpha(1.0f);
        dispatchAddFinished(r105);
        ListProtector.remove(this.mPendingAdditions, r104);
        goto L10
    L13:
        int r106 = this.mPendingChanges.size() - 1;
    L14:
        if (r106 < 0) goto L16;
        endChangeAnimationIfNecessary((ChangeInfo) ListProtector.get(this.mPendingChanges, r106));
        r106 = r106 - 1;
        goto L14
    L16:
        this.mPendingChanges.clear();
        if (isRunning() == true) goto L19;
        return;
    L19:
        int r107 = this.mMovesList.size() - 1;
    L20:
        if (r107 < 0) goto L28;
        ArrayList r108 = (ArrayList) ListProtector.get(this.mMovesList, r107);
        int r109 = r108.size() - 1;
    L22:
        if (r109 < 0) goto L27;
        MoveInfo r110 = (MoveInfo) ListProtector.get(r108, r109);
        View r111 = r110.holder.itemView;
        r111.setTranslationY(0.0f);
        r111.setTranslationX(0.0f);
        dispatchMoveFinished(r110.holder);
        ListProtector.remove(r108, r109);
        if (r108.isEmpty() == false) goto L26;
        this.mMovesList.remove(r108);
    L26:
        r109 = r109 - 1;
        goto L22
    L27:
        r107 = r107 - 1;
        goto L20
    L28:
        int r112 = this.mAdditionsList.size() - 1;
    L29:
        if (r112 < 0) goto L37;
        ArrayList r113 = (ArrayList) ListProtector.get(this.mAdditionsList, r112);
        int r114 = r113.size() - 1;
    L31:
        if (r114 < 0) goto L36;
        RecyclerView.ViewHolder r115 = (RecyclerView.ViewHolder) ListProtector.get(r113, r114);
        r115.itemView.setAlpha(1.0f);
        dispatchAddFinished(r115);
        ListProtector.remove(r113, r114);
        if (r113.isEmpty() == false) goto L35;
        this.mAdditionsList.remove(r113);
    L35:
        r114 = r114 - 1;
        goto L31
    L36:
        r112 = r112 - 1;
        goto L29
    L37:
        int r116 = this.mChangesList.size() - 1;
    L38:
        if (r116 < 0) goto L46;
        ArrayList r117 = (ArrayList) ListProtector.get(this.mChangesList, r116);
        int r118 = r117.size() - 1;
    L40:
        if (r118 < 0) goto L45;
        endChangeAnimationIfNecessary((ChangeInfo) ListProtector.get(r117, r118));
        if (r117.isEmpty() == false) goto L44;
        this.mChangesList.remove(r117);
    L44:
        r118 = r118 - 1;
        goto L40
    L45:
        r116 = r116 - 1;
        goto L38
    L46:
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.mPendingChanges.isEmpty() == false) goto L26;
        if (this.mPendingMoves.isEmpty() == false) goto L26;
        if (this.mPendingRemovals.isEmpty() == false) goto L26;
        if (this.mMoveAnimations.isEmpty() == false) goto L26;
        if (this.mRemoveAnimations.isEmpty() == false) goto L26;
        if (this.mAddAnimations.isEmpty() == false) goto L26;
        if (this.mChangeAnimations.isEmpty() == false) goto L26;
        if (this.mMovesList.isEmpty() == false) goto L26;
        if (this.mAdditionsList.isEmpty() == false) goto L26;
        if (this.mChangesList.isEmpty() == false) goto L26;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean r100 = !this.mPendingRemovals.isEmpty();
        boolean r101 = !this.mPendingMoves.isEmpty();
        boolean r102 = !this.mPendingChanges.isEmpty();
        boolean r103 = !this.mPendingAdditions.isEmpty();
        if (r100 == true) goto L8;
        if (r101 == true) goto L8;
        if (r103 == true) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        Iterator<RecyclerView.ViewHolder> r104 = this.mPendingRemovals.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        animateRemoveImpl(r104.next());
        goto L10
    L12:
        this.mPendingRemovals.clear();
        if (r101 == false) goto L18;
        final ArrayList<MoveInfo> r105 = new ArrayList();
        r105.addAll(this.mPendingMoves);
        this.mMovesList.add(r105);
        this.mPendingMoves.clear();
        Runnable r106 = new AnonymousClass1(this, r105);
        if (r100 == false) goto L17;
        ViewCompat.postOnAnimationDelayed(((MoveInfo) ListProtector.get(r105, 0)).holder.itemView, r106, getRemoveDuration());
        goto L18
    L17:
        r106.run();
    L18:
        if (r102 == false) goto L23;
        final ArrayList<ChangeInfo> r107 = new ArrayList();
        r107.addAll(this.mPendingChanges);
        this.mChangesList.add(r107);
        this.mPendingChanges.clear();
        Runnable r108 = new AnonymousClass2(this, r107);
        if (r100 == false) goto L22;
        ViewCompat.postOnAnimationDelayed(((ChangeInfo) ListProtector.get(r107, 0)).oldHolder.itemView, r108, getRemoveDuration());
        goto L23
    L22:
        r108.run();
    L23:
        if (r103 == false) goto L42;
        final ArrayList<RecyclerView.ViewHolder> r109 = new ArrayList();
        r109.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(r109);
        this.mPendingAdditions.clear();
        Runnable r110 = new AnonymousClass3(this, r109);
        if (r100 == true) goto L30;
        if (r101 == true) goto L30;
        if (r102 == true) goto L30;
        r110.run();
        return;
    L30:
        long r111 = 0;
        if (r100 == false) goto L33;
        long r112 = getRemoveDuration();
    L34:
        if (r101 == false) goto L36;
        long r113 = getMoveDuration();
    L37:
        if (r102 == false) goto L39;
        r111 = getChangeDuration();
    L39:
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) ListProtector.get(r109, 0)).itemView, r110, r112 + Math.max(r113, r111));
        return;
    L36:
        r113 = 0;
        goto L37
    L33:
        r112 = 0;
        goto L34
    }

    public DefaultItemAnimator() {
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    public void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder r100) {
        final View r101 = r100.itemView;
        final ViewPropertyAnimator r102 = r101.animate();
        this.mRemoveAnimations.add(r100);
        r102.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnonymousClass4(this, r100, r102, r101)).start();
    }

    private void endChangeAnimationIfNecessary(ChangeInfo r100) {
        RecyclerView.ViewHolder r101 = r100.oldHolder;
        if (r101 == null) goto L5;
        endChangeAnimationIfNecessary(r100, r101);
    L5:
        RecyclerView.ViewHolder r102 = r100.newHolder;
        if (r102 == null) goto L9;
        endChangeAnimationIfNecessary(r100, r102);
        return;
    }

    private void resetAnimation(RecyclerView.ViewHolder r100) {
        if (sDefaultInterpolator != null) goto L5;
        sDefaultInterpolator = new ValueAnimator().getInterpolator();
    L5:
        r100.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(r100);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder r100) {
        resetAnimation(r100);
        r100.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(r100);
        return true;
    }

    public void animateAddImpl(final RecyclerView.ViewHolder r100) {
        final View r101 = r100.itemView;
        final ViewPropertyAnimator r102 = r101.animate();
        this.mAddAnimations.add(r100);
        r102.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnonymousClass5(this, r100, r101, r102)).start();
    }

    public void animateChangeImpl(final ChangeInfo r100) {
        RecyclerView.ViewHolder r101 = r100.oldHolder;
        final View r102 = null;
        if (r101 != null) goto L5;
        final View r103 = null;
    L6:
        RecyclerView.ViewHolder r104 = r100.newHolder;
        if (r104 == null) goto L10;
        r102 = r104.itemView;
    L10:
        if (r103 == null) goto L12;
        final ViewPropertyAnimator r105 = r103.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(r100.oldHolder);
        r105.translationX(r100.toX - r100.fromX);
        r105.translationY(r100.toY - r100.fromY);
        r105.alpha(0.0f).setListener(new AnonymousClass7(this, r100, r105, r103)).start();
    L12:
        if (r102 == null) goto L15;
        final ViewPropertyAnimator r106 = r102.animate();
        this.mChangeAnimations.add(r100.newHolder);
        r106.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnonymousClass8(this, r100, r106, r102)).start();
        return;
    L15:
        return;
    L5:
        r103 = r101.itemView;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder r100) {
        resetAnimation(r100);
        this.mPendingRemovals.add(r100);
        return true;
    }

    public void cancelAll(List<RecyclerView.ViewHolder> r100) {
        int r101 = r100.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ((RecyclerView.ViewHolder) ListProtector.get(r100, r101)).itemView.animate().cancel();
        r101 = r101 - 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder r100) {
        View r101 = r100.itemView;
        r101.animate().cancel();
        int r102 = this.mPendingMoves.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        if (((MoveInfo) ListProtector.get(this.mPendingMoves, r102)).holder != r100) goto L3;
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        dispatchMoveFinished(r100);
        ListProtector.remove(this.mPendingMoves, r102);
        goto L3
    L9:
        endChangeAnimation(this.mPendingChanges, r100);
        if (this.mPendingRemovals.remove(r100) == false) goto L13;
        r101.setAlpha(1.0f);
        dispatchRemoveFinished(r100);
    L13:
        if (this.mPendingAdditions.remove(r100) == false) goto L15;
        r101.setAlpha(1.0f);
        dispatchAddFinished(r100);
    L15:
        int r103 = this.mChangesList.size() - 1;
    L16:
        if (r103 < 0) goto L21;
        ArrayList r104 = (ArrayList) ListProtector.get(this.mChangesList, r103);
        endChangeAnimation(r104, r100);
        if (r104.isEmpty() == false) goto L20;
        ListProtector.remove(this.mChangesList, r103);
    L20:
        r103 = r103 - 1;
        goto L16
    L21:
        int r105 = this.mMovesList.size() - 1;
    L22:
        if (r105 < 0) goto L32;
        ArrayList r106 = (ArrayList) ListProtector.get(this.mMovesList, r105);
        int r107 = r106.size() - 1;
    L24:
        if (r107 < 0) goto L31;
        if (((MoveInfo) ListProtector.get(r106, r107)).holder == r100) goto L27;
        r107 = r107 - 1;
        goto L24
    L27:
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        dispatchMoveFinished(r100);
        ListProtector.remove(r106, r107);
        if (r106.isEmpty() == false) goto L31;
        ListProtector.remove(this.mMovesList, r105);
    L31:
        r105 = r105 - 1;
        goto L22
    L32:
        int r108 = this.mAdditionsList.size() - 1;
    L33:
        if (r108 < 0) goto L40;
        ArrayList r109 = (ArrayList) ListProtector.get(this.mAdditionsList, r108);
        if (r109.remove(r100) == false) goto L39;
        r101.setAlpha(1.0f);
        dispatchAddFinished(r100);
        if (r109.isEmpty() == false) goto L39;
        ListProtector.remove(this.mAdditionsList, r108);
    L39:
        r108 = r108 - 1;
        goto L33
    L40:
        this.mRemoveAnimations.remove(r100);
        this.mAddAnimations.remove(r100);
        this.mChangeAnimations.remove(r100);
        this.mMoveAnimations.remove(r100);
        dispatchFinishedWhenDone();
    }

    private void endChangeAnimation(List<ChangeInfo> r100, RecyclerView.ViewHolder r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L12;
        ChangeInfo r103 = (ChangeInfo) ListProtector.get(r100, r102);
        if (endChangeAnimationIfNecessary(r103, r101) == false) goto L11;
        if (r103.oldHolder != null) goto L11;
        if (r103.newHolder != null) goto L11;
        r100.remove(r103);
    L11:
        r102 = r102 - 1;
        goto L3
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo r100, RecyclerView.ViewHolder r101) {
        boolean r102 = false;
        if (r100.newHolder != r101) goto L6;
        r100.newHolder = null;
    L8:
        r101.itemView.setAlpha(1.0f);
        r101.itemView.setTranslationX(0.0f);
        r101.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r101, r102);
        return true;
    L6:
        if (r100.oldHolder != r101) goto L10;
        r100.oldHolder = null;
        r102 = true;
        goto L8
    L10:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r100, List<Object> r101) {
        if (r101.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r100, r101) == true) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder r100, int r110, int r111, int r112, int r113) {
        View r101 = r100.itemView;
        int r102 = r110 + ((int) r101.getTranslationX());
        int r103 = r111 + ((int) r100.itemView.getTranslationY());
        resetAnimation(r100);
        int r114 = r112 - r102;
        int r115 = r113 - r103;
        if (r114 != 0) goto L7;
        if (r115 != 0) goto L7;
        dispatchMoveFinished(r100);
        return false;
    L7:
        if (r114 == 0) goto L9;
        r101.setTranslationX(-r114);
    L9:
        if (r115 == 0) goto L11;
        r101.setTranslationY(-r115);
    L11:
        this.mPendingMoves.add(new MoveInfo(r100, r102, r103, r112, r113));
        return true;
    }

    public void animateMoveImpl(final RecyclerView.ViewHolder r100, int r101, int r110, int r111, int r112) {
        final View r102 = r100.itemView;
        final int r103 = r111 - r101;
        final int r104 = r112 - r110;
        if (r103 == 0) goto L5;
        r102.animate().translationX(0.0f);
    L5:
        if (r104 == 0) goto L7;
        r102.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r105 = r102.animate();
        this.mMoveAnimations.add(r100);
        r105.setDuration(getMoveDuration()).setListener(new AnonymousClass6(this, r100, r103, r102, r104, r105)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r110, RecyclerView.ViewHolder r111, int r112, int r113, int r114, int r115) {
        if (r110 == r111) goto L4;
        float r100 = r110.itemView.getTranslationX();
        float r101 = r110.itemView.getTranslationY();
        float r102 = r110.itemView.getAlpha();
        resetAnimation(r110);
        int r103 = (int) ((r114 - r112) - r100);
        int r104 = (int) ((r115 - r113) - r101);
        r110.itemView.setTranslationX(r100);
        r110.itemView.setTranslationY(r101);
        r110.itemView.setAlpha(r102);
        if (r111 == null) goto L8;
        resetAnimation(r111);
        r111.itemView.setTranslationX(-r103);
        r111.itemView.setTranslationY(-r104);
        r111.itemView.setAlpha(0.0f);
    L8:
        this.mPendingChanges.add(new ChangeInfo(r110, r111, r112, r113, r114, r115));
        return true;
    L4:
        return animateMove(r110, r112, r113, r114, r115);
    }
}
