package com.chad.library.adapter.base.module;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.CommonKey;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback;
import com.chad.library.adapter.base.listener.DraggableListenerImp;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 [2\u00020\u0001:\u0001[B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0004J\b\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0015\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020?H\u0016J\u0010\u0010L\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010M\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010N\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010O\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J4\u0010P\u001a\u00020:2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0012\u0010W\u001a\u00020:2\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010Y\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010\"H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006\\"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "Lcom/chad/library/adapter/base/listener/DraggableListenerImp;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "isDragEnabled", "", "()Z", "setDragEnabled", "(Z)V", CommonKey.KEY_VALUE, "isDragOnLongPressEnabled", "setDragOnLongPressEnabled", "isSwipeEnabled", "setSwipeEnabled", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setItemTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "itemTouchHelperCallback", "Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "getItemTouchHelperCallback", "()Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "setItemTouchHelperCallback", "(Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;)V", "mOnItemDragListener", "Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "getMOnItemDragListener", "()Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "setMOnItemDragListener", "(Lcom/chad/library/adapter/base/listener/OnItemDragListener;)V", "mOnItemSwipeListener", "Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "getMOnItemSwipeListener", "()Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "setMOnItemSwipeListener", "(Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;)V", "mOnToggleViewLongClickListener", "Landroid/view/View$OnLongClickListener;", "getMOnToggleViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMOnToggleViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mOnToggleViewTouchListener", "Landroid/view/View$OnTouchListener;", "getMOnToggleViewTouchListener", "()Landroid/view/View$OnTouchListener;", "setMOnToggleViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "toggleViewId", "", "getToggleViewId", "()I", "setToggleViewId", "(I)V", "attachToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getViewHolderPosition", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasToggleView", "inRange", "position", "initItemTouch", "initView", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "initView$com_github_CymChad_brvah", "onItemDragEnd", "onItemDragMoving", "source", "target", "onItemDragStart", "onItemSwipeClear", "onItemSwipeStart", "onItemSwiped", "onItemSwiping", "canvas", "Landroid/graphics/Canvas;", "dX", "", "dY", "isCurrentlyActive", "setOnItemDragListener", "onItemDragListener", "setOnItemSwipeListener", "onItemSwipeListener", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public class BaseDraggableModule implements DraggableListenerImp {
    public static final Companion Companion = null;
    private static final int NO_TOGGLE_VIEW = 0;
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean isDragEnabled;
    private boolean isDragOnLongPressEnabled;
    private boolean isSwipeEnabled;

    @NotNull
    public ItemTouchHelper itemTouchHelper;

    @NotNull
    public DragAndSwipeCallback itemTouchHelperCallback;

    @Nullable
    private OnItemDragListener mOnItemDragListener;

    @Nullable
    private OnItemSwipeListener mOnItemSwipeListener;

    @Nullable
    private View.OnLongClickListener mOnToggleViewLongClickListener;

    @Nullable
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int toggleViewId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule$Companion;", "", "()V", "NO_TOGGLE_VIEW", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BaseDraggableModule(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "baseQuickAdapter");
        this.baseQuickAdapter = r10;
        initItemTouch();
        this.isDragOnLongPressEnabled = true;
    }

    private final boolean inRange(int r10) {
        if (r10 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r10 >= this.baseQuickAdapter.getData().size()) goto L6;
        return true;
    }

    private final void initItemTouch() {
        DragAndSwipeCallback r10 = new DragAndSwipeCallback(this);
        this.itemTouchHelperCallback = r10;
        this.itemTouchHelper = new ItemTouchHelper(r10);
    }

    public final void attachToRecyclerView(@NotNull RecyclerView r10) {
        q.h(r10, "recyclerView");
        ItemTouchHelper r11 = this.itemTouchHelper;
        if (r11 != null) goto L5;
        q.y("itemTouchHelper");
    L5:
        r11.b(r10);
    }

    @NotNull
    public final ItemTouchHelper getItemTouchHelper() {
        ItemTouchHelper r10 = this.itemTouchHelper;
        if (r10 != null) goto L5;
        q.y("itemTouchHelper");
    L5:
        return r10;
    }

    @NotNull
    public final DragAndSwipeCallback getItemTouchHelperCallback() {
        DragAndSwipeCallback r10 = this.itemTouchHelperCallback;
        if (r10 != null) goto L5;
        q.y("itemTouchHelperCallback");
    L5:
        return r10;
    }

    @Nullable
    public final OnItemDragListener getMOnItemDragListener() {
        return this.mOnItemDragListener;
    }

    @Nullable
    public final OnItemSwipeListener getMOnItemSwipeListener() {
        return this.mOnItemSwipeListener;
    }

    @Nullable
    public final View.OnLongClickListener getMOnToggleViewLongClickListener() {
        return this.mOnToggleViewLongClickListener;
    }

    @Nullable
    public final View.OnTouchListener getMOnToggleViewTouchListener() {
        return this.mOnToggleViewTouchListener;
    }

    public final int getToggleViewId() {
        return this.toggleViewId;
    }

    public final int getViewHolderPosition(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        return r10.getAdapterPosition() - this.baseQuickAdapter.getHeaderLayoutCount();
    }

    public boolean hasToggleView() {
        if (this.toggleViewId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void initView$com_github_CymChad_brvah(@NotNull BaseViewHolder r10) {
        q.h(r10, "holder");
        if (this.isDragEnabled == true) goto L5;
        return;
    L5:
        if (hasToggleView() == false) goto L14;
        View r11 = r10.itemView.findViewById(this.toggleViewId);
        if (r11 == null) goto L15;
        r11.setTag(R.id.BaseQuickAdapter_viewholder_support, r10);
        if (isDragOnLongPressEnabled() == false) goto L11;
        r11.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        return;
    L11:
        r11.setOnTouchListener(this.mOnToggleViewTouchListener);
        return;
    L15:
        return;
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public boolean isDragOnLongPressEnabled() {
        return this.isDragOnLongPressEnabled;
    }

    public final boolean isSwipeEnabled() {
        return this.isSwipeEnabled;
    }

    public void onItemDragEnd(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        OnItemDragListener r11 = this.mOnItemDragListener;
        if (r11 == null) goto L6;
        r11.onItemDragEnd(r10, getViewHolderPosition(r10));
        return;
    }

    public void onItemDragMoving(@NotNull RecyclerView.ViewHolder r10, @NotNull RecyclerView.ViewHolder r11) {
        q.h(r10, "source");
        q.h(r11, "target");
        int r12 = getViewHolderPosition(r10);
        int r13 = getViewHolderPosition(r11);
        if (inRange(r12) == true) goto L5;
    L17:
        OnItemDragListener r14 = this.mOnItemDragListener;
        if (r14 == null) goto L23;
        r14.onItemDragMoving(r10, r12, r11, r13);
        return;
    L23:
        return;
    L5:
        if (inRange(r13) == false) goto L17;
        if (r12 >= r13) goto L10;
        int r15 = r12;
    L8:
        if (r15 >= r13) goto L16;
        int r16 = r15 + 1;
        Collections.swap(this.baseQuickAdapter.getData(), r15, r16);
        r15 = r16;
    L16:
        this.baseQuickAdapter.notifyItemMoved(r10.getAdapterPosition(), r11.getAdapterPosition());
        goto L17
    L10:
        int r17 = r13 + 1;
        if (r12 < r17) goto L16;
        int r18 = r12;
    L13:
        Collections.swap(this.baseQuickAdapter.getData(), r18, r18 - 1);
        if (r18 == r17) goto L16;
        r18 = r18 - 1;
        goto L13
    }

    public void onItemDragStart(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        OnItemDragListener r11 = this.mOnItemDragListener;
        if (r11 == null) goto L6;
        r11.onItemDragStart(r10, getViewHolderPosition(r10));
        return;
    }

    public void onItemSwipeClear(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        if (this.isSwipeEnabled == false) goto L8;
        OnItemSwipeListener r11 = this.mOnItemSwipeListener;
        if (r11 == null) goto L9;
        r11.clearView(r10, getViewHolderPosition(r10));
        return;
    L9:
        return;
    }

    public void onItemSwipeStart(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        if (this.isSwipeEnabled == false) goto L8;
        OnItemSwipeListener r11 = this.mOnItemSwipeListener;
        if (r11 == null) goto L9;
        r11.onItemSwipeStart(r10, getViewHolderPosition(r10));
        return;
    L9:
        return;
    }

    public void onItemSwiped(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "viewHolder");
        int r11 = getViewHolderPosition(r10);
        if (inRange(r11) == false) goto L10;
        this.baseQuickAdapter.getData().remove(r11);
        this.baseQuickAdapter.notifyItemRemoved(r10.getAdapterPosition());
        if (this.isSwipeEnabled == false) goto L11;
        OnItemSwipeListener r12 = this.mOnItemSwipeListener;
        if (r12 == null) goto L12;
        r12.onItemSwiped(r10, r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onItemSwiping(@Nullable Canvas r10, @Nullable RecyclerView.ViewHolder r11, float r12, float r13, boolean r14) {
        if (this.isSwipeEnabled == false) goto L8;
        OnItemSwipeListener r15 = this.mOnItemSwipeListener;
        if (r15 == null) goto L9;
        r15.onItemSwipeMoving(r10, r11, r12, r13, r14);
        return;
    L9:
        return;
    }

    public final void setDragEnabled(boolean r10) {
        this.isDragEnabled = r10;
    }

    public void setDragOnLongPressEnabled(boolean r10) {
        this.isDragOnLongPressEnabled = r10;
        if (r10 == false) goto L5;
        this.mOnToggleViewTouchListener = null;
        this.mOnToggleViewLongClickListener = new AnonymousClass1(this);
        return;
    L5:
        this.mOnToggleViewTouchListener = new AnonymousClass2(this);
        this.mOnToggleViewLongClickListener = null;
    }

    public final void setItemTouchHelper(@NotNull ItemTouchHelper r10) {
        q.h(r10, "<set-?>");
        this.itemTouchHelper = r10;
    }

    public final void setItemTouchHelperCallback(@NotNull DragAndSwipeCallback r10) {
        q.h(r10, "<set-?>");
        this.itemTouchHelperCallback = r10;
    }

    public final void setMOnItemDragListener(@Nullable OnItemDragListener r10) {
        this.mOnItemDragListener = r10;
    }

    public final void setMOnItemSwipeListener(@Nullable OnItemSwipeListener r10) {
        this.mOnItemSwipeListener = r10;
    }

    public final void setMOnToggleViewLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.mOnToggleViewLongClickListener = r10;
    }

    public final void setMOnToggleViewTouchListener(@Nullable View.OnTouchListener r10) {
        this.mOnToggleViewTouchListener = r10;
    }

    @Override // com.chad.library.adapter.base.listener.DraggableListenerImp
    public void setOnItemDragListener(@Nullable OnItemDragListener r10) {
        this.mOnItemDragListener = r10;
    }

    @Override // com.chad.library.adapter.base.listener.DraggableListenerImp
    public void setOnItemSwipeListener(@Nullable OnItemSwipeListener r10) {
        this.mOnItemSwipeListener = r10;
    }

    public final void setSwipeEnabled(boolean r10) {
        this.isSwipeEnabled = r10;
    }

    public final void setToggleViewId(int r10) {
        this.toggleViewId = r10;
    }
}
