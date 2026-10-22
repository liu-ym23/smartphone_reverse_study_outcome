package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce = false;
    private static int tagId = 2131373828;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    public static final class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        static Integer maxDisplayLength;
        private final List<SizeReadyCallback> cbs;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;
        boolean waitForLayout;

        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SizeDeterminer r100 = this.sizeDeterminerRef.get();
                if (r100 == null) goto L7;
                r100.checkCurrentDimens();
                return true;
            L7:
                return true;
            }

            public SizeDeterminerLayoutListener(SizeDeterminer r100) {
                this.sizeDeterminerRef = new WeakReference(r100);
            }
        }

        private boolean isDimensionValid(int r100) {
            if (r100 <= 0) goto L4;
        L7:
            return true;
        L4:
            if (r100 == Integer.MIN_VALUE) goto L7;
            return false;
        }

        private int getTargetHeight() {
            int r100 = this.view.getPaddingTop() + this.view.getPaddingBottom();
            ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
            if (r101 == null) goto L5;
            int r102 = r101.height;
        L7:
            return getTargetDimen(this.view.getHeight(), r102, r100);
        L5:
            r102 = 0;
            goto L7
        }

        private int getTargetWidth() {
            int r100 = this.view.getPaddingLeft() + this.view.getPaddingRight();
            ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
            if (r101 == null) goto L5;
            int r102 = r101.width;
        L7:
            return getTargetDimen(this.view.getWidth(), r102, r100);
        L5:
            r102 = 0;
            goto L7
        }

        public void checkCurrentDimens() {
            if (this.cbs.isEmpty() == false) goto L5;
            return;
        L5:
            int r100 = getTargetWidth();
            int r101 = getTargetHeight();
            if (isViewStateAndSizeValid(r100, r101) == true) goto L8;
            return;
        L8:
            notifyCbs(r100, r101);
            clearCallbacksAndListener();
        }

        public void clearCallbacksAndListener() {
            ViewTreeObserver r100 = this.view.getViewTreeObserver();
            if (r100.isAlive() == false) goto L5;
            r100.removeOnPreDrawListener(this.layoutListener);
        L5:
            this.layoutListener = null;
            this.cbs.clear();
        }

        public SizeDeterminer(View r100) {
            this.cbs = new ArrayList();
            this.view = r100;
        }

        private static int getMaxDisplayLength(Context r100) {
            if (maxDisplayLength != null) goto L6;
            Display r101 = ((WindowManager) Preconditions.checkNotNull((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW))).getDefaultDisplay();
            Point r102 = new Point();
            r101.getSize(r102);
            maxDisplayLength = Integer.valueOf(Math.max(r102.x, r102.y));
        L6:
            return maxDisplayLength.intValue();
        }

        public void getSize(SizeReadyCallback r100) {
            int r101 = getTargetWidth();
            int r102 = getTargetHeight();
            if (isViewStateAndSizeValid(r101, r102) == false) goto L7;
            r100.onSizeReady(r101, r102);
            return;
        L7:
            if (this.cbs.contains(r100) == true) goto L10;
            this.cbs.add(r100);
        L10:
            if (this.layoutListener != null) goto L13;
            ViewTreeObserver r103 = this.view.getViewTreeObserver();
            SizeDeterminerLayoutListener r104 = new SizeDeterminerLayoutListener(this);
            this.layoutListener = r104;
            r103.addOnPreDrawListener(r104);
            return;
        }

        public void removeCallback(SizeReadyCallback r100) {
            this.cbs.remove(r100);
        }

        private boolean isViewStateAndSizeValid(int r100, int r101) {
            if (isDimensionValid(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (isDimensionValid(r101) == false) goto L7;
            return true;
        }

        private void notifyCbs(int r100, int r101) {
            Iterator r102 = new ArrayList(this.cbs).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((SizeReadyCallback) r102.next()).onSizeReady(r100, r101);
            goto L4
        }

        private int getTargetDimen(int r100, int r101, int r102) {
            int r103 = r101 - r102;
            if (r103 <= 0) goto L6;
            return r103;
        L6:
            if (this.waitForLayout == true) goto L8;
        L10:
            int r104 = r100 - r102;
            if (r104 <= 0) goto L14;
            return r104;
        L14:
            if (this.view.isLayoutRequested() == false) goto L16;
        L19:
            return 0;
        L16:
            if (r101 != (-2)) goto L19;
            GlideLogUtil.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            return getMaxDisplayLength(this.view.getContext());
        L8:
            if (this.view.isLayoutRequested() == false) goto L10;
            return 0;
        }
    }

    private Object getTag() {
        return this.view.getTag(tagId);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener r100 = this.attachStateListener;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == true) goto L10;
        this.view.addOnAttachStateChangeListener(r100);
        this.isAttachStateListenerAdded = true;
        return;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener r100 = this.attachStateListener;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == false) goto L10;
        this.view.removeOnAttachStateChangeListener(r100);
        this.isAttachStateListenerAdded = false;
        return;
    }

    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener == null) goto L5;
        return this;
    L5:
        this.attachStateListener = new AnonymousClass1(this);
        maybeAddAttachStateListener();
        return this;
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    public final ViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Object r100 = getTag();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof Request) == false) goto L8;
        return (Request) r100;
    L8:
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void pauseMyRequest() {
        Request r100 = getRequest();
        if (r100 == null) goto L6;
        this.isClearedByUs = true;
        r100.clear();
        this.isClearedByUs = false;
        return;
    }

    public void resumeMyRequest() {
        Request r100 = getRequest();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCleared() == false) goto L9;
        r100.begin();
        return;
    }

    public T getView() {
        return this.view;
    }

    public ViewTarget(T r100) {
        this.view = (T) Preconditions.checkNotNull(r100);
        this.sizeDeterminer = new SizeDeterminer(r100);
    }

    private void setTag(Object r100) {
        isTagUsedAtLeastOnce = true;
        this.view.setTag(tagId, r100);
    }

    public static void setTagId(int r100) {
        if (isTagUsedAtLeastOnce == true) goto L7;
        tagId = r100;
        return;
    L7:
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback r100) {
        this.sizeDeterminer.getSize(r100);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
        super.onLoadCleared(r100);
        this.sizeDeterminer.clearCallbacksAndListener();
        if (this.isClearedByUs == true) goto L6;
        maybeRemoveAttachStateListener();
        return;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r100) {
        super.onLoadStarted(r100);
        maybeAddAttachStateListener();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback r100) {
        this.sizeDeterminer.removeCallback(r100);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(Request r100) {
        setTag(r100);
    }

    public ViewTarget(T r100, boolean r101) {
        this(r100);
        if (r101 == false) goto L6;
        waitForLayout();
        return;
    }
}
