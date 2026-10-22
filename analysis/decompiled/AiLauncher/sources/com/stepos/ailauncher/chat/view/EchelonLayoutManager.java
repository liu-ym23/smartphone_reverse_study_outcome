package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u0001:\u0001>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0018J\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0018J\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0018J\u001b\u0010\u001e\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0005R\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010$\u001a\u00020!2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020!2\u0006\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010'J\u001f\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\r2\u0006\u0010)\u001a\u00020!H\u0002¢\u0006\u0004\b*\u0010+J'\u0010/\u001a\u00020!2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020!H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00109¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/chat/view/EchelonLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "dy", "scrollVerticallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I", "", "canScrollVertically", "()Z", "position", "scrollToPosition", "(I)V", "B", "()I", "u", "(I)I", "w", "C", "v", "D", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "baseTop", "", "stackTranslate", "level", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(IFI)F", "z", "(I)F", "x", "density", "y", "(IF)F", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "fraction", ExifInterface.LONGITUDE_EAST, "(FFF)F", "Landroid/view/View;", "child", "F", "(Landroid/view/View;)V", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "mItemViewWidth", "I", "mItemViewHeight", "mItemCount", "mScrollOffset", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EchelonLayoutManager extends RecyclerView.LayoutManager {
    private static final float ELEVATION_STEP_DP = 5.0f;
    private static final int MAX_VISIBLE_COUNT = 3;
    private static final float MIN_ELEVATION_DP = 6.0f;
    private static final float MIN_SCALE = 0.84f;
    private static final float STACK_ALPHA_STEP = 0.14f;
    private static final float STACK_SCALE_STEP = 0.08f;
    private static final float STACK_TRANSLATE_DP = 14.0f;
    private static final float TOP_ELEVATION_DP = 18.0f;
    private final Context mContext;
    private int mItemCount;
    private int mItemViewHeight;
    private int mItemViewWidth;
    private int mScrollOffset;

    public final float A(int baseTop, float stackTranslate, int level) {
        return level <= 0 ? baseTop : baseTop + (stackTranslate * level);
    }

    public final int B() {
        int i10;
        if (this.mItemCount == 0 || (i10 = this.mItemViewHeight) == 0) {
            return 0;
        }
        return C5685n.n(C5227b.b(this.mScrollOffset / i10), 0, this.mItemCount - 1);
    }

    public final int C() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final void D(RecyclerView.Recycler recycler) {
        if (getItemCount() == 0) {
            return;
        }
        int iC = C();
        int i10 = this.mItemViewHeight;
        int i11 = (iC - i10) / 2;
        float f10 = this.mScrollOffset / i10;
        int iN = C5685n.n((int) Math.floor(f10), 0, this.mItemCount - 1);
        float f11 = f10 - iN;
        int iMin = Math.min(this.mItemCount - 1, iN + 2);
        float f12 = this.mContext.getResources().getDisplayMetrics().density;
        float f13 = 14.0f * f12;
        detachAndScrapAttachedViews(recycler);
        if (iN > iMin) {
            return;
        }
        while (true) {
            int i12 = iMin - iN;
            View viewForPosition = recycler.getViewForPosition(iMin);
            kotlin.jvm.internal.p.h(viewForPosition, "getViewForPosition(...)");
            this.addView(viewForPosition);
            this.F(viewForPosition);
            int iV = (this.v() - this.mItemViewWidth) / 2;
            float fA = this.A(i11, f13, i12);
            int i13 = i12 - 1;
            int iE = (int) (i12 == 0 ? this.E(fA, i11 - this.mItemViewHeight, f11) : this.E(fA, this.A(i11, f13, i13), f11));
            EchelonLayoutManager echelonLayoutManager = this;
            echelonLayoutManager.layoutDecoratedWithMargins(viewForPosition, iV, iE, iV + this.mItemViewWidth, iE + this.mItemViewHeight);
            float fZ = echelonLayoutManager.z(i12);
            float fM = C5685n.m(i12 == 0 ? echelonLayoutManager.E(fZ, fZ - 0.08f, f11) : echelonLayoutManager.E(fZ, echelonLayoutManager.z(i13), f11), MIN_SCALE, 1.0f);
            float fX = echelonLayoutManager.x(i12);
            float fM2 = C5685n.m(i12 == 0 ? echelonLayoutManager.E(fX, fX - 0.063f, f11) : echelonLayoutManager.E(fX, echelonLayoutManager.x(i13), f11), 0.6f, 1.0f);
            float fY = echelonLayoutManager.y(i12, f12);
            float fE = C5685n.e(i12 == 0 ? echelonLayoutManager.E(fY, fY - ((5.0f * f12) * 0.35f), f11) : echelonLayoutManager.E(fY, echelonLayoutManager.y(i13, f12), f11), 6.0f * f12);
            viewForPosition.setPivotX(viewForPosition.getWidth() / 2.0f);
            viewForPosition.setPivotY(0.0f);
            viewForPosition.setScaleX(fM);
            viewForPosition.setScaleY(fM);
            viewForPosition.setAlpha(fM2);
            viewForPosition.setElevation(fE);
            viewForPosition.setTranslationZ(fE);
            if (iMin == iN) {
                return;
            }
            iMin--;
            this = echelonLayoutManager;
        }
    }

    public final float E(float start, float end, float fraction) {
        return start + ((end - start) * fraction);
    }

    public final void F(View child) {
        child.measure(View.MeasureSpec.makeMeasureSpec(this.mItemViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mItemViewHeight, 1073741824));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mItemCount > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        kotlin.jvm.internal.p.i(recycler, "recycler");
        kotlin.jvm.internal.p.i(state, "state");
        if (state.getItemCount() == 0 || state.isPreLayout()) {
            return;
        }
        removeAndRecycleAllViews(recycler);
        int iV = (int) (v() * 0.87f);
        this.mItemViewWidth = iV;
        this.mItemViewHeight = (int) (iV * 1.46f);
        int itemCount = getItemCount();
        this.mItemCount = itemCount;
        if (this.mScrollOffset == Integer.MAX_VALUE) {
            this.mScrollOffset = 0;
        }
        this.mScrollOffset = C5685n.n(this.mScrollOffset, 0, Math.max(0, (itemCount - 1) * this.mItemViewHeight));
        D(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.mScrollOffset = C5685n.n(position, 0, Math.max(0, this.mItemCount - 1)) * this.mItemViewHeight;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        kotlin.jvm.internal.p.i(recycler, "recycler");
        kotlin.jvm.internal.p.i(state, "state");
        int i10 = this.mItemCount;
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.mScrollOffset;
        this.mScrollOffset = C5685n.n(this.mScrollOffset + dy, 0, Math.max(0, (i10 - 1) * this.mItemViewHeight));
        D(recycler);
        return this.mScrollOffset - i11;
    }

    public final int u(int position) {
        return (C5685n.n(position, 0, Math.max(0, this.mItemCount - 1)) * this.mItemViewHeight) - this.mScrollOffset;
    }

    public final int v() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: w, reason: from getter */
    public final int getMItemViewHeight() {
        return this.mItemViewHeight;
    }

    public final float x(int level) {
        if (level <= 0) {
            return 1.0f;
        }
        return C5685n.m(1.0f - (level * STACK_ALPHA_STEP), 0.6f, 1.0f);
    }

    public final float y(int level, float density) {
        return level <= 0 ? density * TOP_ELEVATION_DP : C5685n.e(TOP_ELEVATION_DP - (level * 5.0f), 6.0f) * density;
    }

    public final float z(int level) {
        if (level <= 0) {
            return 1.0f;
        }
        return C5685n.m(1.0f - (level * 0.08f), MIN_SCALE, 1.0f);
    }
}
