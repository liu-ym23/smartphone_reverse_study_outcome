package com.stepos.ailauncher.task.space;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J'\u0010\u0019\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010*J#\u0010/\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u0010\u001cJ\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010;\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00106R\u0014\u0010<\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00106R\u0014\u0010=\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00106R\u0014\u0010>\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00106R\u0014\u0010?\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00106R\u0014\u0010@\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00106R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00108R\u0016\u0010B\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00108R\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00108R\u0016\u0010D\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00106R\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106R\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00106R\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00108R\u0016\u0010H\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010IR\u0016\u0010S\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00108R\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00108R$\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0007\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006_"}, d2 = {"Lcom/stepos/ailauncher/task/space/CollapsedCardLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", "total", "LY8/t;", "B", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;I)V", "Landroid/view/View;", "view", "layer", "v", "(Landroid/view/View;I)V", "u", "(Landroid/view/View;)V", "", "w", "(I)F", "x", "currentDragY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lo", "hi", "z", "(FFF)F", "D", "()V", ExifInterface.LONGITUDE_EAST, "raw", "C", "(II)I", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "", "canScrollVertically", "()Z", "canScrollHorizontally", "isAutoMeasureEnabled", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "y", "position", "scrollToPosition", "(I)V", "density", "F", "stepPx", "I", "visibleLayerCount", "commitThresholdPx", "followXOverdragPx", "fadeStartPx", "fadeDistancePx", "recallCatchUpPx", "recallOverdragYPx", "recallOverdragXPx", "baseRotation", "dragX", "dragY", "pressLocalX", "pressLocalY", "fingerXFromCenter", "aboveOffscreenPx", "settleInFlight", "Z", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/ImageView;", "phantomAboveView", "Landroid/widget/ImageView;", "Landroid/graphics/Bitmap;", "phantomBitmap", "Landroid/graphics/Bitmap;", "phantomAttached", "phantomOffscreenPx", "", "Landroidx/dynamicanimation/animation/i;", "activeSpringAnimations", "Ljava/util/List;", "pendingCommitDirection", "Lkotlin/Function1;", "pendingCommitOnEnd", "Lp9/l;", "Lkotlin/Function0;", "pendingCommitOnCancel", "Lp9/a;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CollapsedCardLayoutManager extends RecyclerView.LayoutManager {
    private int aboveOffscreenPx;
    private final List<androidx.dynamicanimation.animation.i> activeSpringAnimations;
    private RecyclerView attachedRecyclerView;
    private int baseRotation;
    private final int commitThresholdPx;
    private final float density;
    private int dragX;
    private int dragY;
    private final float fadeDistancePx;
    private final float fadeStartPx;
    private float fingerXFromCenter;
    private final float followXOverdragPx;
    private int pendingCommitDirection;
    private InterfaceC5063a<Y8.t> pendingCommitOnCancel;
    private InterfaceC5074l<? super Boolean, Y8.t> pendingCommitOnEnd;
    private ImageView phantomAboveView;
    private boolean phantomAttached;
    private Bitmap phantomBitmap;
    private int phantomOffscreenPx;
    private float pressLocalX;
    private float pressLocalY;
    private final float recallCatchUpPx;
    private final float recallOverdragXPx;
    private final float recallOverdragYPx;
    private boolean settleInFlight;
    private final int stepPx;
    private final int visibleLayerCount;

    public final float A(int currentDragY) {
        float fAbs = Math.abs(currentDragY);
        float f10 = this.fadeStartPx;
        if (fAbs <= f10) {
            return 1.0f;
        }
        return 1.0f - C5685n.m((fAbs - f10) / this.fadeDistancePx, 0.0f, 1.0f);
    }

    public final void B(RecyclerView.Recycler recycler, int total) {
        int iC = C(this.baseRotation, total);
        int iMin = Math.min(this.visibleLayerCount, total);
        for (int i10 = 0; i10 < iMin; i10++) {
            View viewForPosition = recycler.getViewForPosition(C(iC + i10, total));
            kotlin.jvm.internal.p.h(viewForPosition, "getViewForPosition(...)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + (this.stepPx * i10);
            layoutDecoratedWithMargins(viewForPosition, paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
            viewForPosition.setElevation(iMin - i10);
            viewForPosition.setTranslationZ(0.0f);
            viewForPosition.setVisibility(0);
            viewForPosition.setPivotX(viewForPosition.getWidth() / 2.0f);
            viewForPosition.setPivotY(viewForPosition.getHeight());
            v(viewForPosition, i10);
        }
        if (total < this.visibleLayerCount + 1) {
            this.aboveOffscreenPx = 0;
            return;
        }
        View viewForPosition2 = recycler.getViewForPosition(C(this.baseRotation - 1, total));
        kotlin.jvm.internal.p.h(viewForPosition2, "getViewForPosition(...)");
        addView(viewForPosition2);
        measureChildWithMargins(viewForPosition2, 0, 0);
        int decoratedMeasuredWidth2 = getDecoratedMeasuredWidth(viewForPosition2);
        int decoratedMeasuredHeight2 = getDecoratedMeasuredHeight(viewForPosition2);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop2 = getPaddingTop();
        layoutDecoratedWithMargins(viewForPosition2, paddingLeft2, paddingTop2, decoratedMeasuredWidth2 + paddingLeft2, paddingTop2 + decoratedMeasuredHeight2);
        viewForPosition2.setElevation(iMin + 1);
        viewForPosition2.setTranslationZ(0.0f);
        viewForPosition2.setVisibility(0);
        viewForPosition2.setPivotX(viewForPosition2.getWidth() / 2.0f);
        viewForPosition2.setPivotY(viewForPosition2.getHeight());
        this.aboveOffscreenPx = (int) (decoratedMeasuredHeight2 * 1.3f);
        u(viewForPosition2);
    }

    public final int C(int raw, int total) {
        return ((raw % total) + total) % total;
    }

    public final void D() {
        ViewGroupOverlay overlay;
        ImageView imageView = this.phantomAboveView;
        if (imageView != null) {
            RecyclerView recyclerView = this.attachedRecyclerView;
            if (recyclerView != null && (overlay = recyclerView.getOverlay()) != null) {
                overlay.remove(imageView);
            }
            imageView.setImageBitmap(null);
        }
        this.phantomAboveView = null;
        this.phantomBitmap = null;
        this.phantomAttached = false;
        this.phantomOffscreenPx = 0;
    }

    public final void E() {
        this.dragX = 0;
        this.dragY = 0;
        this.fingerXFromCenter = 0.0f;
        this.pressLocalX = 0.0f;
        this.pressLocalY = 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onAttachedToWindow(view);
        this.attachedRecyclerView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(recycler, "recycler");
        super.onDetachedFromWindow(view, recycler);
        D();
        this.attachedRecyclerView = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        kotlin.jvm.internal.p.i(recycler, "recycler");
        kotlin.jvm.internal.p.i(state, "state");
        int itemCount = state.getItemCount();
        if (itemCount != 0) {
            detachAndScrapAttachedViews(recycler);
            B(recycler, itemCount);
        } else {
            detachAndScrapAttachedViews(recycler);
            E();
            D();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        int itemCount = getItemCount();
        if (itemCount <= 0) {
            return;
        }
        y();
        this.baseRotation = C(position, itemCount);
        E();
        requestLayout();
    }

    public final void u(View view) {
        if (this.aboveOffscreenPx <= 0) {
            return;
        }
        Integer numValueOf = Integer.valueOf(view.getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : (int) (this.aboveOffscreenPx / 1.3f);
        int i10 = this.dragY;
        if (i10 <= 0) {
            view.setTranslationX(0.0f);
            view.setTranslationY(-this.aboveOffscreenPx);
            view.setRotation(0.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
            view.setAlpha(0.0f);
            return;
        }
        float fM = C5685n.m(i10 / this.recallCatchUpPx, 0.0f, 1.0f);
        float fA = B.a((-iIntValue) * 0.55f, this.dragY, fM);
        if (fA > 0.0f) {
            fA = B.b(fA, C5685n.e(this.recallOverdragYPx, 0.001f));
        }
        view.setTranslationX(B.b(this.fingerXFromCenter, C5685n.e(this.recallOverdragXPx, 0.001f)));
        view.setTranslationY(fA);
        view.setRotation(this.fingerXFromCenter * 0.05f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        float fA2 = B.a(0.9f, 1.0f, fM);
        view.setScaleX(fA2);
        view.setScaleY(fA2);
        view.setAlpha(C5685n.m(this.dragY / (this.recallCatchUpPx * 0.4f), 0.0f, 1.0f));
    }

    public final void v(View view, int layer) {
        if (layer != 0) {
            float fW = w(layer);
            float fX = x(layer);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setRotation(0.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setAlpha(fW);
            view.setScaleX(fX);
            view.setScaleY(fX);
            return;
        }
        int i10 = this.dragY;
        if (i10 < 0) {
            view.setTranslationY(i10 * 1.4f);
            view.setTranslationX(B.b(this.dragX * 0.7f, this.followXOverdragPx));
            view.setRotation(this.dragX * 0.05f * 0.5f);
            view.setRotationY(z(this.dragX * 0.04f * 0.5f, -14.0f, 14.0f));
            view.setRotationX(z((-this.dragY) * 0.03f * 0.5f, 0.0f, 12.0f));
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setAlpha(A(this.dragY));
            return;
        }
        if (i10 <= 0) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setRotation(0.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setAlpha(1.0f);
            return;
        }
        float fM = C5685n.m(i10 / this.recallCatchUpPx, 0.0f, 1.0f);
        float f10 = this.stepPx;
        float fX2 = x(1);
        float fW2 = w(0);
        float fW3 = w(1);
        view.setTranslationX(0.0f);
        view.setTranslationY(B.a(0.0f, f10, fM));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        float fA = B.a(1.0f, fX2, fM);
        view.setScaleX(fA);
        view.setScaleY(fA);
        view.setAlpha(B.a(fW2, fW3, fM));
    }

    public final float w(int layer) {
        A a10 = A.INSTANCE;
        return a10.a()[C5685n.n(layer, 0, Z8.r.c0(a10.a()))];
    }

    public final float x(int layer) {
        return C5685n.e(1.0f - (layer * 0.05f), 0.0f);
    }

    public final void y() {
        if (this.activeSpringAnimations.isEmpty() && !this.settleInFlight) {
            D();
            return;
        }
        List listM1 = Z8.F.m1(this.activeSpringAnimations);
        this.activeSpringAnimations.clear();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.i) it.next()).d();
        }
        if (this.settleInFlight && this.pendingCommitDirection != 0) {
            InterfaceC5063a<Y8.t> interfaceC5063a = this.pendingCommitOnCancel;
            this.pendingCommitOnCancel = null;
            this.pendingCommitOnEnd = null;
            this.pendingCommitDirection = 0;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        this.settleInFlight = false;
        D();
    }

    public final float z(float v10, float lo, float hi) {
        return v10 < lo ? lo : v10 > hi ? hi : v10;
    }
}
