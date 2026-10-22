package com.bytedance.android.livesdkapi.sti;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "", "()V", "icon", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "getIcon", "()Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "Added", "InsertionStarted", "ReInitBigCardAnim", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$Added;", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$InsertionStarted;", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$ReInitBigCardAnim;", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShortTermIndicatorEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$Added;", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "icon", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "(Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;)V", "getIcon", "()Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Added extends ShortTermIndicatorEvent {
        private final ShortTermIcon icon;

        public static /* synthetic */ Added copy$default(Added r100, ShortTermIcon r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.getIcon();
        L6:
            return r100.copy(r101);
        }

        public final ShortTermIcon component1() {
            return getIcon();
        }

        public final Added copy(ShortTermIcon r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            return new Added(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Added) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(getIcon(), ((Added) r100).getIcon()) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            ShortTermIcon r100 = getIcon();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "Added(icon=" + getIcon() + ")";
        }

        @Override // com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent
        public ShortTermIcon getIcon() {
            return this.icon;
        }

        public Added(ShortTermIcon r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            super(null);
            this.icon = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$InsertionStarted;", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "icon", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "finalPositionOnScreen", "Landroid/graphics/Rect;", "(Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;Landroid/graphics/Rect;)V", "getFinalPositionOnScreen", "()Landroid/graphics/Rect;", "getIcon", "()Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InsertionStarted extends ShortTermIndicatorEvent {
        private final Rect finalPositionOnScreen;
        private final ShortTermIcon icon;

        public static /* synthetic */ InsertionStarted copy$default(InsertionStarted r100, ShortTermIcon r101, Rect r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.getIcon();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.finalPositionOnScreen;
        L9:
            return r100.copy(r101, r102);
        }

        public final ShortTermIcon component1() {
            return getIcon();
        }

        public final Rect component2() {
            return this.finalPositionOnScreen;
        }

        public final InsertionStarted copy(ShortTermIcon r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            return new InsertionStarted(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof InsertionStarted) == false) goto L10;
            InsertionStarted r101 = (InsertionStarted) r100;
            if (Intrinsics.areEqual(getIcon(), r101.getIcon()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.finalPositionOnScreen, r101.finalPositionOnScreen) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            ShortTermIcon r100 = getIcon();
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.finalPositionOnScreen;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "InsertionStarted(icon=" + getIcon() + ", finalPositionOnScreen=" + this.finalPositionOnScreen + ")";
        }

        public final Rect getFinalPositionOnScreen() {
            return this.finalPositionOnScreen;
        }

        @Override // com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent
        public ShortTermIcon getIcon() {
            return this.icon;
        }

        public InsertionStarted(ShortTermIcon r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            super(null);
            this.icon = r100;
            this.finalPositionOnScreen = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent$ReInitBigCardAnim;", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "icon", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "finalPositionOnScreen", "Landroid/graphics/Rect;", "listener", "Lcom/bytedance/android/livesdkapi/sti/IBigCardAnimExcuteListener;", "(Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;Landroid/graphics/Rect;Lcom/bytedance/android/livesdkapi/sti/IBigCardAnimExcuteListener;)V", "getFinalPositionOnScreen", "()Landroid/graphics/Rect;", "getIcon", "()Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "getListener", "()Lcom/bytedance/android/livesdkapi/sti/IBigCardAnimExcuteListener;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ReInitBigCardAnim extends ShortTermIndicatorEvent {
        private final Rect finalPositionOnScreen;
        private final ShortTermIcon icon;
        private final IBigCardAnimExcuteListener listener;

        public static /* synthetic */ ReInitBigCardAnim copy$default(ReInitBigCardAnim r100, ShortTermIcon r101, Rect r102, IBigCardAnimExcuteListener r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.getIcon();
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.finalPositionOnScreen;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.listener;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final ShortTermIcon component1() {
            return getIcon();
        }

        public final Rect component2() {
            return this.finalPositionOnScreen;
        }

        public final IBigCardAnimExcuteListener component3() {
            return this.listener;
        }

        public final ReInitBigCardAnim copy(ShortTermIcon r100, Rect r101, IBigCardAnimExcuteListener r102) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            Intrinsics.checkNotNullParameter(r102, "listener");
            return new ReInitBigCardAnim(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ReInitBigCardAnim) == false) goto L12;
            ReInitBigCardAnim r101 = (ReInitBigCardAnim) r100;
            if (Intrinsics.areEqual(getIcon(), r101.getIcon()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.finalPositionOnScreen, r101.finalPositionOnScreen) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.listener, r101.listener) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            ShortTermIcon r100 = getIcon();
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.finalPositionOnScreen;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            IBigCardAnimExcuteListener r107 = this.listener;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ReInitBigCardAnim(icon=" + getIcon() + ", finalPositionOnScreen=" + this.finalPositionOnScreen + ", listener=" + this.listener + ")";
        }

        public final Rect getFinalPositionOnScreen() {
            return this.finalPositionOnScreen;
        }

        @Override // com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent
        public ShortTermIcon getIcon() {
            return this.icon;
        }

        public final IBigCardAnimExcuteListener getListener() {
            return this.listener;
        }

        public ReInitBigCardAnim(ShortTermIcon r100, Rect r101, IBigCardAnimExcuteListener r102) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            Intrinsics.checkNotNullParameter(r102, "listener");
            super(null);
            this.icon = r100;
            this.finalPositionOnScreen = r101;
            this.listener = r102;
        }
    }

    private ShortTermIndicatorEvent() {
    }

    public abstract ShortTermIcon getIcon();

    public /* synthetic */ ShortTermIndicatorEvent(DefaultConstructorMarker r100) {
        this();
    }
}
