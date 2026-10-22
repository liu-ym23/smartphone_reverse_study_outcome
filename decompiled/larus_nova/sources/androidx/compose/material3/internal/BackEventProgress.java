package androidx.compose.material3.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/internal/BackEventProgress;", "", "NotRunning", "InProgress", "Completed", "Landroidx/compose/material3/internal/BackEventProgress$Completed;", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "Landroidx/compose/material3/internal/BackEventProgress$NotRunning;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BackEventProgress {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/material3/internal/BackEventProgress$Completed;", "Landroidx/compose/material3/internal/BackEventProgress;", "<init>", "()V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Completed implements BackEventProgress {
        public static final int $stable = 0;
        public static final Completed INSTANCE = null;

        static {
            INSTANCE = new Completed();
        }

        private Completed() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "Landroidx/compose/material3/internal/BackEventProgress;", "touchX", "", "touchY", "progress", "swipeEdge", "Landroidx/compose/material3/internal/SwipeEdge;", "<init>", "(FFFLandroidx/compose/material3/internal/SwipeEdge;)V", "getTouchX", "()F", "getTouchY", "getProgress", "getSwipeEdge", "()Landroidx/compose/material3/internal/SwipeEdge;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InProgress implements BackEventProgress {
        public static final int $stable = 0;
        private final float progress;
        private final SwipeEdge swipeEdge;
        private final float touchX;
        private final float touchY;

        public static /* synthetic */ InProgress copy$default(InProgress r100, float r101, float r102, float r103, SwipeEdge r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.touchX;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.touchY;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.progress;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.swipeEdge;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.touchX;
        }

        public final float component2() {
            return this.touchY;
        }

        public final float component3() {
            return this.progress;
        }

        public final SwipeEdge component4() {
            return this.swipeEdge;
        }

        public final InProgress copy(float r100, float r101, float r102, SwipeEdge r103) {
            return new InProgress(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InProgress) == true) goto L8;
            return false;
        L8:
            InProgress r101 = (InProgress) r100;
            if (Float.compare(this.touchX, r101.touchX) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.touchY, r101.touchY) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.progress, r101.progress) == 0) goto L18;
            return false;
        L18:
            if (this.swipeEdge == r101.swipeEdge) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.touchX) * 31) + Float.floatToIntBits(this.touchY)) * 31) + Float.floatToIntBits(this.progress)) * 31) + this.swipeEdge.hashCode();
        }

        public String toString() {
            return "InProgress(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ')';
        }

        public final float getProgress() {
            return this.progress;
        }

        public final SwipeEdge getSwipeEdge() {
            return this.swipeEdge;
        }

        public final float getTouchX() {
            return this.touchX;
        }

        public final float getTouchY() {
            return this.touchY;
        }

        public InProgress(float r100, float r101, float r102, SwipeEdge r103) {
            this.touchX = r100;
            this.touchY = r101;
            this.progress = r102;
            this.swipeEdge = r103;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/material3/internal/BackEventProgress$NotRunning;", "Landroidx/compose/material3/internal/BackEventProgress;", "<init>", "()V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotRunning implements BackEventProgress {
        public static final int $stable = 0;
        public static final NotRunning INSTANCE = null;

        static {
            INSTANCE = new NotRunning();
        }

        private NotRunning() {
        }
    }
}
