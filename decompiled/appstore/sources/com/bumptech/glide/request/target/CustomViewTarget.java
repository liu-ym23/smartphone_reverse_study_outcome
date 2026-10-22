package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    private static final String TAG = "CustomViewTarget";

    @IdRes
    private static final int VIEW_TAG_ID = 0;

    @Nullable
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;

    @IdRes
    private int overrideTag;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    @VisibleForTesting
    public static final class SizeDeterminer {
        private static final int PENDING_SIZE = 0;

        @Nullable
        @VisibleForTesting
        static Integer maxDisplayLength;
        private final List<SizeReadyCallback> cbs;

        @Nullable
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;
        boolean waitForLayout;

        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(@NonNull SizeDeterminer r10) {
                this.sizeDeterminerRef = new WeakReference(r10);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.TAG, 2) == false) goto L5;
                Log.v(CustomViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
            L5:
                SizeDeterminer r10 = this.sizeDeterminerRef.get();
                if (r10 == null) goto L10;
                r10.checkCurrentDimens();
                return true;
            L10:
                return true;
            }
        }

        public SizeDeterminer(@NonNull View r10) {
            this.cbs = new ArrayList();
            this.view = r10;
        }

        private static int getMaxDisplayLength(@NonNull Context r10) {
            if (maxDisplayLength != null) goto L6;
            Display r11 = ((WindowManager) Preconditions.checkNotNull((WindowManager) r10.getSystemService("window"))).getDefaultDisplay();
            Point r12 = new Point();
            r11.getSize(r12);
            maxDisplayLength = Integer.valueOf(Math.max(r12.x, r12.y));
        L6:
            return maxDisplayLength.intValue();
        }

        private int getTargetDimen(int r10, int r11, int r12) {
            int r13 = r11 - r12;
            if (r13 <= 0) goto L6;
            return r13;
        L6:
            if (this.waitForLayout == true) goto L8;
        L10:
            int r14 = r10 - r12;
            if (r14 <= 0) goto L14;
            return r14;
        L14:
            if (this.view.isLayoutRequested() == false) goto L16;
        L22:
            return 0;
        L16:
            if (r11 != (-2)) goto L22;
            if (Log.isLoggable(CustomViewTarget.TAG, 4) == false) goto L21;
            Log.i(CustomViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        L21:
            return getMaxDisplayLength(this.view.getContext());
        L8:
            if (this.view.isLayoutRequested() == false) goto L10;
            return 0;
        }

        private int getTargetHeight() {
            int r10 = this.view.getPaddingTop() + this.view.getPaddingBottom();
            ViewGroup.LayoutParams r11 = this.view.getLayoutParams();
            if (r11 == null) goto L5;
            int r12 = r11.height;
        L7:
            return getTargetDimen(this.view.getHeight(), r12, r10);
        L5:
            r12 = 0;
            goto L7
        }

        private int getTargetWidth() {
            int r10 = this.view.getPaddingLeft() + this.view.getPaddingRight();
            ViewGroup.LayoutParams r11 = this.view.getLayoutParams();
            if (r11 == null) goto L5;
            int r12 = r11.width;
        L7:
            return getTargetDimen(this.view.getWidth(), r12, r10);
        L5:
            r12 = 0;
            goto L7
        }

        private boolean isDimensionValid(int r10) {
            if (r10 <= 0) goto L4;
        L7:
            return true;
        L4:
            if (r10 == Integer.MIN_VALUE) goto L7;
            return false;
        }

        private boolean isViewStateAndSizeValid(int r10, int r11) {
            if (isDimensionValid(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (isDimensionValid(r11) == false) goto L7;
            return true;
        }

        private void notifyCbs(int r10, int r11) {
            Iterator r12 = new ArrayList(this.cbs).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((SizeReadyCallback) r12.next()).onSizeReady(r10, r11);
            goto L4
        }

        public void checkCurrentDimens() {
            if (this.cbs.isEmpty() == false) goto L5;
            return;
        L5:
            int r10 = getTargetWidth();
            int r11 = getTargetHeight();
            if (isViewStateAndSizeValid(r10, r11) == true) goto L8;
            return;
        L8:
            notifyCbs(r10, r11);
            clearCallbacksAndListener();
        }

        public void clearCallbacksAndListener() {
            ViewTreeObserver r10 = this.view.getViewTreeObserver();
            if (r10.isAlive() == false) goto L5;
            r10.removeOnPreDrawListener(this.layoutListener);
        L5:
            this.layoutListener = null;
            this.cbs.clear();
        }

        public void getSize(@NonNull SizeReadyCallback r10) {
            int r11 = getTargetWidth();
            int r12 = getTargetHeight();
            if (isViewStateAndSizeValid(r11, r12) == false) goto L7;
            r10.onSizeReady(r11, r12);
            return;
        L7:
            if (this.cbs.contains(r10) == true) goto L10;
            this.cbs.add(r10);
        L10:
            if (this.layoutListener != null) goto L13;
            ViewTreeObserver r13 = this.view.getViewTreeObserver();
            SizeDeterminerLayoutListener r14 = new SizeDeterminerLayoutListener(this);
            this.layoutListener = r14;
            r13.addOnPreDrawListener(r14);
            return;
        }

        public void removeCallback(@NonNull SizeReadyCallback r10) {
            this.cbs.remove(r10);
        }
    }

    static {
        VIEW_TAG_ID = R.id.glide_custom_view_target_tag;
    }

    public CustomViewTarget(@NonNull T r10) {
        this.view = (T) Preconditions.checkNotNull(r10);
        this.sizeDeterminer = new SizeDeterminer(r10);
    }

    @Nullable
    private Object getTag() {
        T r10 = this.view;
        int r11 = this.overrideTag;
        if (r11 != 0) goto L6;
        r11 = VIEW_TAG_ID;
    L6:
        return r10.getTag(r11);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener r10 = this.attachStateListener;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == true) goto L10;
        this.view.addOnAttachStateChangeListener(r10);
        this.isAttachStateListenerAdded = true;
        return;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener r10 = this.attachStateListener;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == false) goto L10;
        this.view.removeOnAttachStateChangeListener(r10);
        this.isAttachStateListenerAdded = false;
        return;
    }

    private void setTag(@Nullable Object r10) {
        T r11 = this.view;
        int r12 = this.overrideTag;
        if (r12 != 0) goto L5;
        r12 = VIEW_TAG_ID;
    L5:
        r11.setTag(r12, r10);
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener == null) goto L5;
        return this;
    L5:
        this.attachStateListener = new AnonymousClass1(this);
        maybeAddAttachStateListener();
        return this;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        Object r10 = getTag();
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof Request) == false) goto L9;
        return (Request) r10;
    L9:
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback r10) {
        this.sizeDeterminer.getSize(r10);
    }

    @NonNull
    public final T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable r10) {
        this.sizeDeterminer.clearCallbacksAndListener();
        onResourceCleared(r10);
        if (this.isClearedByUs == true) goto L6;
        maybeRemoveAttachStateListener();
        return;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable r10) {
        maybeAddAttachStateListener();
        onResourceLoading(r10);
    }

    public abstract void onResourceCleared(@Nullable Drawable r10);

    public void onResourceLoading(@Nullable Drawable r10) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public final void pauseMyRequest() {
        Request r10 = getRequest();
        if (r10 == null) goto L6;
        this.isClearedByUs = true;
        r10.clear();
        this.isClearedByUs = false;
        return;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback r10) {
        this.sizeDeterminer.removeCallback(r10);
    }

    public final void resumeMyRequest() {
        Request r10 = getRequest();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isCleared() == false) goto L9;
        r10.begin();
        return;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request r10) {
        setTag(r10);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    public final CustomViewTarget<T, Z> useTagId(@IdRes int r10) {
        if (this.overrideTag != 0) goto L7;
        this.overrideTag = r10;
        return this;
    L7:
        throw new IllegalArgumentException("You cannot change the tag id once it has been set.");
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
