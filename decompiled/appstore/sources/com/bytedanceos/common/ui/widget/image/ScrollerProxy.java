package com.bytedanceos.common.ui.widget.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScrollerProxy {

    @TargetApi(9)
    public static class GingerScroller extends ScrollerProxy {
        private OverScroller mScroller;

        public GingerScroller(Context r10) {
            this.mScroller = new OverScroller(r10);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public boolean computeScrollOffset() {
            return this.mScroller.computeScrollOffset();
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public void fling(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21) {
            this.mScroller.fling(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public void forceFinished(boolean r10) {
            this.mScroller.forceFinished(r10);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public int getCurrX() {
            return this.mScroller.getCurrX();
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public int getCurrY() {
            return this.mScroller.getCurrY();
        }
    }

    public static class PreGingerScroller extends ScrollerProxy {
        private Scroller mScroller;

        public PreGingerScroller(Context r10) {
            this.mScroller = new Scroller(r10);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public boolean computeScrollOffset() {
            return this.mScroller.computeScrollOffset();
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public void fling(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
            this.mScroller.fling(r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public void forceFinished(boolean r10) {
            this.mScroller.forceFinished(r10);
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public int getCurrX() {
            return this.mScroller.getCurrX();
        }

        @Override // com.bytedanceos.common.ui.widget.image.ScrollerProxy
        public int getCurrY() {
            return this.mScroller.getCurrY();
        }
    }

    public ScrollerProxy() {
    }

    public static ScrollerProxy getScroller(Context r10) {
        return new GingerScroller(r10);
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19);

    public abstract void forceFinished(boolean r10);

    public abstract int getCurrX();

    public abstract int getCurrY();
}
