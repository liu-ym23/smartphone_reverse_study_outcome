package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.h implements RecyclerView.q.b {
    private static final String TAG = "StaggeredGridLManager";
    private SavedState A;
    private int B;
    private final Rect C;
    private final a D;
    private boolean E;
    private boolean F;
    private int[] G;
    private final Runnable H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b[] f2395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    u f2396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    u f2397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2399e;
    int f;
    int g;
    LazySpanLookup h;
    private int i;
    private int j;
    private int k;
    private final o l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean z;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        b mSpan;

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(RecyclerView.LayoutParams r1) {
            super(r1);
        }

        public void setFullSpan(boolean r1) {
            this.mFullSpan = r1;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public final int getSpanIndex() {
            b r0 = this.mSpan;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.f2412e;
        }
    }

    static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f2401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f2402b;

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel r3) {
                this.mPosition = r3.readInt();
                this.mGapDir = r3.readInt();
                boolean r1 = true;
                if (r3.readInt() == 1) goto L6;
                r1 = false;
            L6:
                this.mHasUnwantedGapAfter = r1;
                int r0 = r3.readInt();
                if (r0 <= 0) goto L10;
                int[] r2 = new int[r0];
                this.mGapPerSpan = r2;
                r3.readIntArray(r2);
                return;
            }

            FullSpanItem() {
            }

            int getGapForSpan(int r1) {
                int[] r0 = this.mGapPerSpan;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0[r1];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r2, int r3) {
                r2.writeInt(this.mPosition);
                r2.writeInt(this.mGapDir);
                r2.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r4 = this.mGapPerSpan;
                if (r4 != null) goto L5;
            L7:
                r2.writeInt(0);
                return;
            L5:
                if (r4.length <= 0) goto L7;
                r2.writeInt(r4.length);
                r2.writeIntArray(this.mGapPerSpan);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            static {
                CREATOR = new AnonymousClass1();
            }
        }

        LazySpanLookup() {
        }

        int a(int r5) {
            List<FullSpanItem> r0 = this.f2402b;
            if (r0 == null) goto L11;
            int r1 = r0.size() - 1;
        L5:
            if (r1 < 0) goto L11;
            if (((FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r1), FullSpanItem.class, "com.obric.aiagent.plugin")).mPosition < r5) goto L9;
            this.f2402b.remove(r1);
        L9:
            r1 = r1 - 1;
        L11:
            return b(r5);
        }

        int b(int r4) {
            int[] r0 = this.f2401a;
            if (r0 != null) goto L6;
            return -1;
        L6:
            if (r4 < r0.length) goto L8;
            return -1;
        L8:
            int r1 = g(r4);
            if (r1 != (-1)) goto L12;
            int[] r2 = this.f2401a;
            Arrays.fill(r2, r4, r2.length, -1);
            return this.f2401a.length;
        L12:
            int r3 = Math.min(r1 + 1, this.f2401a.length);
            Arrays.fill(this.f2401a, r4, r3, -1);
            return r3;
        }

        int c(int r2) {
            int[] r1 = this.f2401a;
            if (r1 != null) goto L5;
            return -1;
        L5:
            if (r2 < r1.length) goto L8;
            return -1;
        L8:
            return r1[r2];
        }

        void a(int r1, b r2) {
            e(r1);
            this.f2401a[r1] = r2.f2412e;
        }

        int d(int r1) {
            int r0 = this.f2401a.length;
        L3:
            if (r0 > r1) goto L5;
            r0 = r0 * 2;
            goto L3
        L5:
            return r0;
        }

        void e(int r5) {
            int[] r0 = this.f2401a;
            if (r0 != null) goto L6;
            int[] r6 = new int[Math.max(r5, 10) + 1];
            this.f2401a = r6;
            Arrays.fill(r6, -1);
            return;
        L6:
            if (r5 < r0.length) goto L10;
            int[] r7 = new int[d(r5)];
            this.f2401a = r7;
            System.arraycopy(r0, 0, r7, 0, r0.length);
            int[] r4 = this.f2401a;
            Arrays.fill(r4, r0.length, r4.length, -1);
            return;
        }

        void a() {
            int[] r0 = this.f2401a;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.f2402b = null;
        }

        void a(int r5, int r6) {
            int[] r0 = this.f2401a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 >= r0.length) goto L10;
            int r1 = r5 + r6;
            e(r1);
            int[] r2 = this.f2401a;
            System.arraycopy(r2, r1, r2, r5, (r2.length - r5) - r6);
            int[] r3 = this.f2401a;
            Arrays.fill(r3, r3.length - r6, r3.length, -1);
            c(r5, r6);
            return;
        }

        private void c(int r6, int r7) {
            List<FullSpanItem> r0 = this.f2402b;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r6 + r7;
            int r2 = r0.size() - 1;
        L6:
            if (r2 < 0) goto L15;
            FullSpanItem r3 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r2), FullSpanItem.class, "com.obric.aiagent.plugin");
            if (r3.mPosition < r6) goto L14;
            if (r3.mPosition >= r1) goto L13;
            this.f2402b.remove(r2);
            goto L14
        L13:
            r3.mPosition -= r7;
        L14:
            r2 = r2 - 1;
            goto L6
        }

        void b(int r4, int r5) {
            int[] r0 = this.f2401a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r4 >= r0.length) goto L10;
            int r1 = r4 + r5;
            e(r1);
            int[] r2 = this.f2401a;
            System.arraycopy(r2, r4, r2, r1, (r2.length - r4) - r5);
            Arrays.fill(this.f2401a, r4, r1, -1);
            d(r4, r5);
            return;
        }

        private void d(int r5, int r6) {
            List<FullSpanItem> r0 = this.f2402b;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L12;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r1), FullSpanItem.class, "com.obric.aiagent.plugin");
            if (r2.mPosition < r5) goto L11;
            r2.mPosition += r6;
        L11:
            r1 = r1 - 1;
            goto L6
        }

        private int g(int r7) {
            if (this.f2402b != null) goto L5;
            return -1;
        L5:
            FullSpanItem r0 = f(r7);
            if (r0 == null) goto L8;
            this.f2402b.remove(r0);
        L8:
            int r1 = this.f2402b.size();
            int r2 = 0;
        L10:
            if (r2 >= r1) goto L15;
            if (((FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r2), FullSpanItem.class, "com.obric.aiagent.plugin")).mPosition >= r7) goto L16;
            r2 = r2 + 1;
        L16:
            if (r2 == (-1)) goto L19;
            FullSpanItem r8 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r2), FullSpanItem.class, "com.obric.aiagent.plugin");
            this.f2402b.remove(r2);
            return r8.mPosition;
        L19:
            return -1;
        L15:
            r2 = -1;
            goto L16
        }

        public void a(FullSpanItem r6) {
            if (this.f2402b != null) goto L5;
            this.f2402b = new ArrayList();
        L5:
            int r0 = this.f2402b.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L15;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r1), FullSpanItem.class, "com.obric.aiagent.plugin");
            if (r2.mPosition != r6.mPosition) goto L11;
            this.f2402b.remove(r1);
        L11:
            if (r2.mPosition >= r6.mPosition) goto L12;
            r1 = r1 + 1;
            goto L6
        L12:
            this.f2402b.add(r1, r6);
            return;
        L15:
            this.f2402b.add(r6);
        }

        public FullSpanItem f(int r6) {
            List<FullSpanItem> r0 = this.f2402b;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L11;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r1), FullSpanItem.class, "com.obric.aiagent.plugin");
            if (r2.mPosition == r6) goto L9;
            r1 = r1 - 1;
            goto L6
        L9:
            return r2;
        L11:
            return null;
        }

        public FullSpanItem a(int r7, int r8, int r9, boolean r10) {
            List<FullSpanItem> r0 = this.f2402b;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L20;
            FullSpanItem r3 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f2402b.get(r2), FullSpanItem.class, "com.obric.aiagent.plugin");
            if (r3.mPosition >= r8) goto L9;
            if (r3.mPosition < r7) goto L19;
            if (r9 == 0) goto L18;
            if (r3.mGapDir == r9) goto L18;
            if (r10 == false) goto L19;
            if (r3.mHasUnwantedGapAfter == false) goto L19;
        L18:
            return r3;
        L19:
            r2 = r2 + 1;
            goto L6
        L9:
            return null;
        L20:
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel r4) {
            this.mAnchorPosition = r4.readInt();
            this.mVisibleAnchorPosition = r4.readInt();
            int r0 = r4.readInt();
            this.mSpanOffsetsSize = r0;
            if (r0 <= 0) goto L5;
            int[] r1 = new int[r0];
            this.mSpanOffsets = r1;
            r4.readIntArray(r1);
        L5:
            int r2 = r4.readInt();
            this.mSpanLookupSize = r2;
            if (r2 <= 0) goto L8;
            int[] r3 = new int[r2];
            this.mSpanLookup = r3;
            r4.readIntArray(r3);
        L8:
            boolean r5 = false;
            if (r4.readInt() != 1) goto L11;
            boolean r6 = true;
        L12:
            this.mReverseLayout = r6;
            if (r4.readInt() != 1) goto L15;
            boolean r7 = true;
        L16:
            this.mAnchorLayoutFromEnd = r7;
            if (r4.readInt() != 1) goto L19;
            r5 = true;
        L19:
            this.mLastLayoutRTL = r5;
            this.mFullSpanItems = r4.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r7 = false;
            goto L16
        L11:
            r6 = false;
            goto L12
        }

        public SavedState(SavedState r2) {
            this.mSpanOffsetsSize = r2.mSpanOffsetsSize;
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mVisibleAnchorPosition = r2.mVisibleAnchorPosition;
            this.mSpanOffsets = r2.mSpanOffsets;
            this.mSpanLookupSize = r2.mSpanLookupSize;
            this.mSpanLookup = r2.mSpanLookup;
            this.mReverseLayout = r2.mReverseLayout;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r2.mLastLayoutRTL;
            this.mFullSpanItems = r2.mFullSpanItems;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mVisibleAnchorPosition);
            r1.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r1.writeIntArray(this.mSpanOffsets);
        L5:
            r1.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r1.writeIntArray(this.mSpanLookup);
        L8:
            r1.writeInt(this.mReverseLayout ? 1 : 0);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r1.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r1.writeList(this.mFullSpanItems);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2407e;
        int[] f;
        final /* synthetic */ StaggeredGridLayoutManager g;

        a(StaggeredGridLayoutManager r1) {
            this.g = r1;
            a();
        }

        void a() {
            this.f2403a = -1;
            this.f2404b = Integer.MIN_VALUE;
            this.f2405c = false;
            this.f2406d = false;
            this.f2407e = false;
            int[] r2 = this.f;
            if (r2 == null) goto L6;
            Arrays.fill(r2, -1);
            return;
        }

        void a(b[] r6) {
            int r0 = r6.length;
            int[] r1 = this.f;
            if (r1 != null) goto L5;
        L6:
            this.f = new int[this.g.f2395a.length];
        L7:
            int r2 = 0;
        L8:
            if (r2 >= r0) goto L10;
            this.f[r2] = r6[r2].a(Integer.MIN_VALUE);
            r2 = r2 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }

        void b() {
            if (this.f2405c == false) goto L5;
            int r0 = this.g.f2396b.d();
        L6:
            this.f2404b = r0;
            return;
        L5:
            r0 = this.g.f2396b.c();
            goto L6
        }

        void a(int r2) {
            if (this.f2405c == false) goto L5;
            this.f2404b = this.g.f2396b.d() - r2;
            return;
        L5:
            this.f2404b = this.g.f2396b.c() + r2;
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<View> f2408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f2412e;
        final /* synthetic */ StaggeredGridLayoutManager f;

        b(StaggeredGridLayoutManager r1, int r2) {
            this.f = r1;
            this.f2408a = new ArrayList();
            this.f2409b = Integer.MIN_VALUE;
            this.f2410c = Integer.MIN_VALUE;
            this.f2411d = 0;
            this.f2412e = r2;
        }

        int a(int r3) {
            int r0 = this.f2409b;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.f2408a.size() != 0) goto L8;
            return r3;
        L8:
            a();
            return this.f2409b;
        }

        void a() {
            View r0 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.get(0), View.class, "com.obric.aiagent.plugin");
            LayoutParams r1 = c(r0);
            this.f2409b = this.f.f2396b.a(r0);
            if (r1.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r2 = this.f.h.f(r1.getViewLayoutPosition());
            if (r2 != null) goto L7;
            return;
        L7:
            if (r2.mGapDir != (-1)) goto L12;
            this.f2409b -= r2.getGapForSpan(this.f2412e);
            return;
        L12:
            return;
        }

        int b() {
            int r0 = this.f2409b;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            a();
            return this.f2409b;
        }

        int b(int r3) {
            int r0 = this.f2410c;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.f2408a.size() != 0) goto L8;
            return r3;
        L8:
            c();
            return this.f2410c;
        }

        void c() {
            ArrayList<View> r0 = this.f2408a;
            View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), View.class, "com.obric.aiagent.plugin");
            LayoutParams r2 = c(r1);
            this.f2410c = this.f.f2396b.b(r1);
            if (r2.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r3 = this.f.h.f(r2.getViewLayoutPosition());
            if (r3 != null) goto L7;
            return;
        L7:
            if (r3.mGapDir != 1) goto L12;
            this.f2410c += r3.getGapForSpan(this.f2412e);
            return;
        L12:
            return;
        }

        int d() {
            int r0 = this.f2410c;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            c();
            return this.f2410c;
        }

        void a(View r5) {
            LayoutParams r0 = c(r5);
            r0.mSpan = this;
            this.f2408a.add(0, r5);
            this.f2409b = Integer.MIN_VALUE;
            if (this.f2408a.size() != 1) goto L6;
            this.f2410c = Integer.MIN_VALUE;
        L6:
            if (r0.isItemRemoved() == false) goto L8;
        L9:
            this.f2411d += this.f.f2396b.e(r5);
            return;
        L8:
            if (r0.isItemChanged() == true) goto L9;
        }

        void b(View r5) {
            LayoutParams r0 = c(r5);
            r0.mSpan = this;
            this.f2408a.add(r5);
            this.f2410c = Integer.MIN_VALUE;
            if (this.f2408a.size() != 1) goto L6;
            this.f2409b = Integer.MIN_VALUE;
        L6:
            if (r0.isItemRemoved() == false) goto L8;
        L9:
            this.f2411d += this.f.f2396b.e(r5);
            return;
        L8:
            if (r0.isItemChanged() == true) goto L9;
        }

        void a(boolean r4, int r5) {
            if (r4 == false) goto L5;
            int r1 = b(Integer.MIN_VALUE);
        L6:
            e();
            if (r1 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r4 == true) goto L11;
        L12:
            if (r4 == false) goto L14;
        L16:
            if (r5 == Integer.MIN_VALUE) goto L18;
            r1 = r1 + r5;
        L18:
            this.f2410c = r1;
            this.f2409b = r1;
            return;
        L14:
            if (r1 <= this.f.f2396b.c()) goto L16;
            return;
        L11:
            if (r1 >= this.f.f2396b.d()) goto L12;
            return;
        L5:
            r1 = a(Integer.MIN_VALUE);
            goto L6
        }

        void e() {
            this.f2408a.clear();
            f();
            this.f2411d = 0;
        }

        void f() {
            this.f2409b = Integer.MIN_VALUE;
            this.f2410c = Integer.MIN_VALUE;
        }

        void c(int r1) {
            this.f2409b = r1;
            this.f2410c = r1;
        }

        void g() {
            int r0 = this.f2408a.size();
            View r1 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.remove(r0 - 1), View.class, "com.obric.aiagent.plugin");
            LayoutParams r2 = c(r1);
            r2.mSpan = null;
            if (r2.isItemRemoved() == false) goto L5;
        L6:
            this.f2411d -= this.f.f2396b.e(r1);
        L8:
            if (r0 != 1) goto L10;
            this.f2409b = Integer.MIN_VALUE;
        L10:
            this.f2410c = Integer.MIN_VALUE;
            return;
        L5:
            if (r2.isItemChanged() == false) goto L8;
            goto L6
        }

        void h() {
            View r0 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.remove(0), View.class, "com.obric.aiagent.plugin");
            LayoutParams r1 = c(r0);
            r1.mSpan = null;
            if (this.f2408a.size() != 0) goto L6;
            this.f2410c = Integer.MIN_VALUE;
        L6:
            if (r1.isItemRemoved() == false) goto L8;
        L9:
            this.f2411d -= this.f.f2396b.e(r0);
        L10:
            this.f2409b = Integer.MIN_VALUE;
            return;
        L8:
            if (r1.isItemChanged() == false) goto L10;
            goto L9
        }

        public int i() {
            return this.f2411d;
        }

        LayoutParams c(View r2) {
            return (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        }

        void d(int r3) {
            int r0 = this.f2409b;
            if (r0 == Integer.MIN_VALUE) goto L5;
            this.f2409b = r0 + r3;
        L5:
            int r1 = this.f2410c;
            if (r1 == Integer.MIN_VALUE) goto L9;
            this.f2410c = r1 + r3;
            return;
        }

        public int j() {
            if (this.f.f2398d == false) goto L6;
            return a(this.f2408a.size() - 1, -1, true);
        L6:
            return a(0, this.f2408a.size(), true);
        }

        public int k() {
            if (this.f.f2398d == false) goto L6;
            return a(0, this.f2408a.size(), true);
        L6:
            return a(this.f2408a.size() - 1, -1, true);
        }

        int a(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r0 = this.f.f2396b.c();
            int r1 = this.f.f2396b.d();
            if (r12 <= r11) goto L5;
            int r4 = 1;
        L6:
            if (r11 == r12) goto L35;
            View r5 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.get(r11), View.class, "com.obric.aiagent.plugin");
            int r6 = this.f.f2396b.a(r5);
            int r7 = this.f.f2396b.b(r5);
            boolean r8 = false;
            if (r15 == false) goto L11;
            if (r6 <= r1) goto L12;
        L13:
            boolean r9 = false;
        L14:
            if (r15 == false) goto L17;
            if (r7 >= r0) goto L18;
        L19:
            if (r9 == false) goto L34;
            if (r8 == false) goto L34;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r6 < r0) goto L34;
            if (r7 > r1) goto L34;
            return this.f.d(r5);
        L27:
            if (r14 == true) goto L29;
            if (r6 < r0) goto L33;
            if (r7 <= r1) goto L34;
        L33:
            return this.f.d(r5);
        L29:
            return this.f.d(r5);
        L34:
            r11 = r11 + r4;
        L18:
            r8 = true;
            goto L19
        L17:
            if (r7 <= r0) goto L19;
        L12:
            r9 = true;
            goto L14
        L11:
            if (r6 >= r1) goto L13;
        L35:
            return -1;
        L5:
            r4 = -1;
            goto L6
        }

        int a(int r7, int r8, boolean r9) {
            return a(r7, r8, false, false, r9);
        }

        public View a(int r6, int r7) {
            View r2 = null;
            if (r7 != (-1)) goto L18;
            int r8 = this.f2408a.size();
            int r1 = 0;
        L5:
            if (r1 >= r8) goto L32;
            View r3 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.get(r1), View.class, "com.obric.aiagent.plugin");
            if (this.f.f2398d == false) goto L11;
            if (this.f.d(r3) <= r6) goto L32;
        L11:
            if (this.f.f2398d == true) goto L16;
            if (this.f.d(r3) >= r6) goto L32;
        L16:
            if (r3.hasFocusable() == false) goto L32;
            r1 = r1 + 1;
            r2 = r3;
        L32:
            return r2;
        L18:
            int r9 = this.f2408a.size() - 1;
        L19:
            if (r9 < 0) goto L32;
            View r4 = (View) ZeusTransformUtils.preCheckCast(this.f2408a.get(r9), View.class, "com.obric.aiagent.plugin");
            if (this.f.f2398d == false) goto L25;
            if (this.f.d(r4) >= r6) goto L32;
        L25:
            if (this.f.f2398d == true) goto L30;
            if (this.f.d(r4) <= r6) goto L32;
        L30:
            if (r4.hasFocusable() == false) goto L32;
            r9 = r9 - 1;
            r2 = r4;
            goto L19
        }
    }

    public StaggeredGridLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        this.i = -1;
        this.f2398d = false;
        this.f2399e = false;
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.h = new LazySpanLookup();
        this.n = 2;
        this.C = new Rect();
        this.D = new a(this);
        this.E = false;
        this.F = true;
        this.H = new AnonymousClass1(this);
        RecyclerView.h.b r9 = a(r7, r8, r5, r6);
        b(r9.f2354a);
        a(r9.f2355b);
        a(r9.f2356c);
        this.l = new o();
        N();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean d() {
        if (this.n == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void N() {
        this.f2396b = u.a(this, this.j);
        this.f2397c = u.a(this, 1 - this.j);
    }

    boolean b() {
        if (x() != 0) goto L5;
    L36:
        return false;
    L5:
        if (this.n == 0) goto L36;
        if (s() == false) goto L36;
        if (this.f2399e == false) goto L12;
        int r0 = o();
        int r2 = p();
    L14:
        if (r0 != 0) goto L20;
        if (h() == null) goto L20;
        this.h.a();
        L();
        q();
        return true;
    L20:
        if (this.E == true) goto L23;
        return false;
    L23:
        if (this.f2399e == false) goto L25;
        int r4 = -1;
    L26:
        int r3 = r2 + 1;
        LazySpanLookup.FullSpanItem r6 = this.h.a(r0, r3, r4, true);
        if (r6 != null) goto L30;
        this.E = false;
        this.h.a(r3);
        return false;
    L30:
        LazySpanLookup.FullSpanItem r1 = this.h.a(r0, r6.mPosition, r4 * (-1), true);
        if (r1 != null) goto L33;
        this.h.a(r6.mPosition);
    L34:
        L();
        q();
        return true;
    L33:
        this.h.a(r1.mPosition + 1);
        goto L34
    L25:
        r4 = 1;
        goto L26
    L12:
        r0 = p();
        r2 = o();
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void l(int r1) {
        if (r1 != 0) goto L5;
        b();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r2, RecyclerView.n r3) {
        super.a(r2, r3);
        a(this.H);
        int r4 = 0;
    L4:
        if (r4 >= this.i) goto L6;
        this.f2395a[r4].e();
        r4 = r4 + 1;
        goto L4
    L6:
        r2.requestLayout();
    }

    View h() {
        int r0 = x() - 1;
        BitSet r2 = new BitSet(this.i);
        r2.set(0, this.i, true);
        int r5 = -1;
        if (this.j == 1) goto L5;
    L7:
        byte r3 = -1;
    L9:
        if (this.f2399e == false) goto L11;
        int r6 = -1;
    L12:
        if (r0 >= r6) goto L14;
        r5 = 1;
    L14:
        if (r0 == r6) goto L50;
        View r7 = i(r0);
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.get(r8.mSpan.f2412e) == false) goto L22;
        if (a(r8.mSpan) == true) goto L19;
        r2.clear(r8.mSpan.f2412e);
        goto L22
    L19:
        return r7;
    L22:
        if (r8.mFullSpan == true) goto L49;
        int r9 = r0 + r5;
        if (r9 == r6) goto L49;
        View r10 = i(r9);
        if (this.f2399e == false) goto L33;
        int r11 = this.f2396b.b(r7);
        int r12 = this.f2396b.b(r10);
        if (r11 < r12) goto L30;
        if (r11 == r12) goto L37;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L49;
        if ((r8.mSpan.f2412e - ((LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mSpan.f2412e) >= 0) goto L43;
        boolean r14 = true;
    L44:
        if (r3 >= 0) goto L46;
        boolean r15 = true;
    L47:
        if (r14 == r15) goto L49;
        return r7;
    L46:
        r15 = false;
        goto L47
    L43:
        r14 = false;
    L37:
        r13 = true;
        goto L39
    L30:
        return r7;
    L33:
        int r16 = this.f2396b.a(r7);
        int r17 = this.f2396b.a(r10);
        if (r16 > r17) goto L35;
        if (r16 != r17) goto L38;
    L35:
        return r7;
    L49:
        r0 = r0 + r5;
        goto L14
    L50:
        return null;
    L11:
        r6 = r0 + 1;
        r0 = 0;
        goto L12
    L5:
        if (j() == false) goto L7;
        r3 = 1;
        goto L9
    }

    private boolean a(b r4) {
        if (this.f2399e == false) goto L9;
        if (r4.d() < this.f2396b.d()) goto L7;
    L12:
        return false;
    L7:
        return !r4.c((View) ZeusTransformUtils.preCheckCast(r4.f2408a.get(r4.f2408a.size() - 1), View.class, "com.obric.aiagent.plugin")).mFullSpan;
    L9:
        if (r4.b() <= this.f2396b.c()) goto L12;
        return !r4.c((View) ZeusTransformUtils.preCheckCast(r4.f2408a.get(0), View.class, "com.obric.aiagent.plugin")).mFullSpan;
    }

    public void a(int r3) {
        a(null);
        if (r3 == this.i) goto L11;
        i();
        this.i = r3;
        this.m = new BitSet(this.i);
        this.f2395a = new b[this.i];
        int r4 = 0;
    L6:
        if (r4 >= this.i) goto L8;
        this.f2395a[r4] = new b(this, r4);
        r4 = r4 + 1;
        goto L6
    L8:
        q();
        return;
    }

    public void b(int r2) {
        if (r2 != 0) goto L4;
    L8:
        a(null);
        if (r2 != this.j) goto L11;
        return;
    L11:
        this.j = r2;
        u r3 = this.f2396b;
        this.f2396b = this.f2397c;
        this.f2397c = r3;
        q();
        return;
    L4:
        if (r2 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void a(boolean r2) {
        a(null);
        SavedState r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        this.f2398d = r2;
        q();
        return;
    L5:
        if (r0.mReverseLayout == r2) goto L7;
        this.A.mReverseLayout = r2;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(String r2) {
        if (this.A != null) goto L6;
        super.a(r2);
        return;
    }

    public void i() {
        this.h.a();
        q();
    }

    private void O() {
        if (this.j != 1) goto L5;
    L8:
        this.f2399e = this.f2398d;
        return;
    L5:
        if (j() == false) goto L8;
        this.f2399e = !this.f2398d;
    }

    boolean j() {
        if (v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(Rect r5, int r6, int r7) {
        int r0 = C() + E();
        int r1 = D() + F();
        if (this.j != 1) goto L5;
        int r8 = a(r7, r5.height() + r1, J());
        int r9 = a(r6, (this.k * this.i) + r0, I());
    L6:
        f(r9, r8);
        return;
    L5:
        r9 = a(r6, r5.width() + r0, I());
        r8 = a(r7, (this.k * this.i) + r1, J());
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void c(RecyclerView.n r2, RecyclerView.r r3) {
        a(r2, r3, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView.a r1, RecyclerView.a r2) {
        this.h.a();
        int r3 = 0;
    L4:
        if (r3 >= this.i) goto L6;
        this.f2395a[r3].e();
        r3 = r3 + 1;
        goto L4
    }

    private void a(RecyclerView.n r9, RecyclerView.r r10, boolean r11) {
        a r0 = this.D;
        if (this.A != null) goto L7;
        if (this.f != (-1)) goto L7;
    L10:
        boolean r4 = true;
        if (r0.f2407e == true) goto L13;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == false) goto L26;
        r0.a();
        if (this.A == null) goto L23;
        a(r0);
    L24:
        a(r10, r0);
        r0.f2407e = true;
        goto L26
    L23:
        O();
        r0.f2405c = this.f2399e;
    L26:
        if (this.A != null) goto L35;
        if (this.f != (-1)) goto L35;
        if (r0.f2405c == this.o) goto L32;
    L33:
        this.h.a();
        r0.f2406d = true;
        goto L35
    L32:
        if (j() != this.z) goto L33;
    L35:
        if (x() <= 0) goto L62;
        SavedState r5 = this.A;
        if (r5 == null) goto L41;
        if (r5.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r0.f2406d == false) goto L49;
        int r2 = 0;
    L44:
        if (r2 >= this.i) goto L62;
        this.f2395a[r2].e();
        if (r0.f2404b == Integer.MIN_VALUE) goto L48;
        this.f2395a[r2].c(r0.f2404b);
    L48:
        r2 = r2 + 1;
        goto L44
    L49:
        if (r1 == false) goto L51;
    L57:
        int r3 = 0;
    L59:
        if (r3 >= this.i) goto L61;
        this.f2395a[r3].a(this.f2399e, r0.f2404b);
        r3 = r3 + 1;
        goto L59
    L61:
        this.D.a(this.f2395a);
        goto L62
    L51:
        if (this.D.f == null) goto L57;
        int r6 = 0;
    L55:
        if (r6 >= this.i) goto L62;
        b r7 = this.f2395a[r6];
        r7.e();
        r7.c(this.D.f[r6]);
        r6 = r6 + 1;
    L62:
        a(r9);
        this.l.f2563a = false;
        this.E = false;
        f(this.f2397c.f());
        b(r0.f2403a, r10);
        if (r0.f2405c == false) goto L65;
        m(-1);
        a(r9, this.l, r10);
        m(1);
        this.l.f2565c = r0.f2403a + this.l.f2566d;
        a(r9, this.l, r10);
    L66:
        P();
        if (x() > 0) goto L69;
    L72:
        if (r11 == true) goto L74;
    L89:
        r4 = false;
    L91:
        if (r10.a() == false) goto L93;
        this.D.a();
    L93:
        this.o = r0.f2405c;
        this.z = j();
        if (r4 == false) goto L102;
        this.D.a();
        a(r9, r10, false);
        return;
    L102:
        return;
    L74:
        if (r10.a() == true) goto L89;
        if (this.n != 0) goto L78;
    L84:
        boolean r12 = false;
    L85:
        if (r12 == false) goto L89;
        a(this.H);
        if (b() == false) goto L89;
    L78:
        if (x() <= 0) goto L84;
        if (this.E == false) goto L82;
    L83:
        r12 = true;
        goto L85
    L82:
        if (h() == null) goto L84;
    L69:
        if (this.f2399e == false) goto L71;
        b(r9, r10, true);
        c(r9, r10, false);
        goto L72
    L71:
        c(r9, r10, true);
        b(r9, r10, false);
        goto L72
    L65:
        m(1);
        a(r9, this.l, r10);
        m(-1);
        this.l.f2565c = r0.f2403a + this.l.f2566d;
        a(r9, this.l, r10);
        goto L66
    L13:
        if (this.f != (-1)) goto L18;
        if (this.A != null) goto L18;
        r1 = false;
    L7:
        if (r10.e() != 0) goto L10;
        c(r9);
        r0.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView.r r1) {
        super.a(r1);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    private void P() {
        if (this.f2397c.h() != 1073741824) goto L5;
        return;
    L5:
        float r0 = 0.0f;
        int r1 = x();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L16;
        View r5 = i(r3);
        float r6 = this.f2397c.e(r5);
        if (r6 < r0) goto L15;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).isFullSpan() == false) goto L14;
        r6 = (r6 * 1.0f) / this.i;
    L14:
        r0 = Math.max(r0, r6);
    L15:
        r3 = r3 + 1;
        goto L7
    L16:
        int r4 = this.k;
        int r7 = Math.round(r0 * this.i);
        if (this.f2397c.h() != Integer.MIN_VALUE) goto L19;
        r7 = Math.min(r7, this.f2397c.f());
    L19:
        f(r7);
        if (this.k != r4) goto L22;
        return;
    L22:
        if (r2 >= r1) goto L36;
        View r8 = i(r2);
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r9.mFullSpan == true) goto L35;
        if (j() == true) goto L29;
    L31:
        int r10 = r9.mSpan.f2412e * this.k;
        int r11 = r9.mSpan.f2412e * r4;
        if (this.j != 1) goto L34;
        r8.offsetLeftAndRight(r10 - r11);
        goto L35
    L34:
        r8.offsetTopAndBottom(r10 - r11);
        goto L35
    L29:
        if (this.j != 1) goto L31;
        r8.offsetLeftAndRight(((-((this.i - 1) - r9.mSpan.f2412e)) * this.k) - ((-((this.i - 1) - r9.mSpan.f2412e)) * r4));
    L35:
        r2 = r2 + 1;
        goto L22
    }

    private void a(a r4) {
        if (this.A.mSpanOffsetsSize > 0) goto L5;
    L18:
        this.z = this.A.mLastLayoutRTL;
        a(this.A.mReverseLayout);
        O();
        if (this.A.mAnchorPosition == (-1)) goto L21;
        this.f = this.A.mAnchorPosition;
        r4.f2405c = this.A.mAnchorLayoutFromEnd;
    L23:
        if (this.A.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r5 = this.h;
        r5.f2401a = this.A.mSpanLookup;
        LazySpanLookup r6 = this.h;
        r6.f2402b = this.A.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r4.f2405c = this.f2399e;
        goto L23
    L5:
        if (this.A.mSpanOffsetsSize != this.i) goto L17;
        int r0 = 0;
    L8:
        if (r0 >= this.i) goto L18;
        this.f2395a[r0].e();
        int r1 = this.A.mSpanOffsets[r0];
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (this.A.mAnchorLayoutFromEnd == false) goto L14;
        int r2 = this.f2396b.d();
    L15:
        r1 = r1 + r2;
        goto L16
    L14:
        r2 = this.f2396b.c();
    L16:
        this.f2395a[r0].c(r1);
        r0 = r0 + 1;
        goto L8
    L17:
        this.A.invalidateSpanInfo();
        SavedState r3 = this.A;
        r3.mAnchorPosition = r3.mVisibleAnchorPosition;
        goto L18
    }

    void a(RecyclerView.r r2, a r3) {
        if (b(r2, r3) == false) goto L6;
        return;
    L6:
        if (c(r2, r3) == false) goto L8;
        return;
    L8:
        r3.b();
        r3.f2403a = 0;
    }

    private boolean c(RecyclerView.r r2, a r3) {
        if (this.o == false) goto L5;
        int r1 = w(r2.e());
    L6:
        r3.f2403a = r1;
        r3.f2404b = Integer.MIN_VALUE;
        return true;
    L5:
        r1 = v(r2.e());
        goto L6
    }

    boolean b(RecyclerView.r r5, a r6) {
        boolean r1 = false;
        if (r5.a() == true) goto L60;
        int r0 = this.f;
        if (r0 == (-1)) goto L60;
        if (r0 >= 0) goto L10;
    L59:
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r0 >= r5.e()) goto L59;
        SavedState r7 = this.A;
        if (r7 != null) goto L15;
    L20:
        View r8 = c(this.f);
        if (r8 != null) goto L23;
        r6.f2403a = this.f;
        int r9 = this.g;
        if (r9 == Integer.MIN_VALUE) goto L53;
        r6.a(r9);
    L57:
        r6.f2406d = true;
    L58:
        return true;
    L53:
        if (u(r6.f2403a) != 1) goto L55;
        r1 = true;
    L55:
        r6.f2405c = r1;
        r6.b();
        goto L57
    L23:
        if (this.f2399e == false) goto L25;
        int r2 = o();
    L26:
        r6.f2403a = r2;
        if (this.g == Integer.MIN_VALUE) goto L34;
        if (r6.f2405c == false) goto L31;
        r6.f2404b = (this.f2396b.d() - this.g) - this.f2396b.b(r8);
    L32:
        return true;
    L31:
        r6.f2404b = (this.f2396b.c() + this.g) - this.f2396b.a(r8);
        goto L32
    L34:
        if (this.f2396b.e(r8) > this.f2396b.f()) goto L36;
        int r3 = this.f2396b.a(r8) - this.f2396b.c();
        if (r3 >= 0) goto L45;
        r6.f2404b = -r3;
        return true;
    L45:
        int r4 = this.f2396b.d() - this.f2396b.b(r8);
        if (r4 >= 0) goto L49;
        r6.f2404b = r4;
        return true;
    L49:
        r6.f2404b = Integer.MIN_VALUE;
        goto L58
    L36:
        if (r6.f2405c == false) goto L38;
        int r10 = this.f2396b.d();
    L39:
        r6.f2404b = r10;
        return true;
    L38:
        r10 = this.f2396b.c();
        goto L39
    L25:
        r2 = p();
        goto L26
    L15:
        if (r7.mAnchorPosition == (-1)) goto L20;
        if (this.A.mSpanOffsetsSize < 1) goto L20;
        r6.f2404b = Integer.MIN_VALUE;
        r6.f2403a = this.f;
    L60:
        return false;
    }

    void f(int r2) {
        this.k = r2 / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(r2, this.f2397c.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean c() {
        if (this.A != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int d(RecyclerView.r r1) {
        return f(r1);
    }

    private int f(RecyclerView.r r8) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return x.a(r8, this.f2396b, b(!this.F), c(!this.F), this, this.F, this.f2399e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int e(RecyclerView.r r1) {
        return f(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g(RecyclerView.r r1) {
        return i(r1);
    }

    private int i(RecyclerView.r r7) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return x.a(r7, this.f2396b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int h(RecyclerView.r r1) {
        return i(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int b(RecyclerView.r r1) {
        return j(r1);
    }

    private int j(RecyclerView.r r7) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return x.b(r7, this.f2396b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int c(RecyclerView.r r1) {
        return j(r1);
    }

    private void a(View r7, LayoutParams r8, boolean r9) {
        if (r8.mFullSpan == false) goto L9;
        if (this.j != 1) goto L7;
        a(r7, this.B, a(B(), z(), D() + F(), r8.height, true), r9);
        return;
    L7:
        a(r7, a(A(), y(), C() + E(), r8.width, true), this.B, r9);
        return;
    L9:
        if (this.j != 1) goto L11;
        a(r7, a(this.k, y(), 0, r8.width, false), a(B(), z(), D() + F(), r8.height, true), r9);
        return;
    L11:
        a(r7, a(A(), y(), C() + E(), r8.width, true), a(this.k, z(), 0, r8.height, false), r9);
    }

    private void a(View r5, int r6, int r7, boolean r8) {
        b(r5, this.C);
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r9 = b(r6, r0.leftMargin + this.C.left, r0.rightMargin + this.C.right);
        int r10 = b(r7, r0.topMargin + this.C.top, r0.bottomMargin + this.C.bottom);
        if (r8 == false) goto L5;
        boolean r4 = a(r5, r9, r10, r0);
    L6:
        if (r4 == false) goto L9;
        r5.measure(r9, r10);
        return;
    L9:
        return;
    L5:
        r4 = b(r5, r9, r10, r0);
        goto L6
    }

    private int b(int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        if (r4 != 0) goto L5;
        return r2;
    L5:
        int r1 = View.MeasureSpec.getMode(r2);
        if (r1 == Integer.MIN_VALUE) goto L12;
        if (r1 == 1073741824) goto L12;
        return r2;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r2) - r3) - r4), r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == false) goto L9;
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        this.A = r5;
        if (this.f == (-1)) goto L7;
        r5.invalidateAnchorPositionInfo();
        this.A.invalidateSpanInfo();
    L7:
        q();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public Parcelable e() {
        if (this.A != null) goto L5;
        SavedState r0 = new SavedState();
        r0.mReverseLayout = this.f2398d;
        r0.mAnchorLayoutFromEnd = this.o;
        r0.mLastLayoutRTL = this.z;
        LazySpanLookup r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L9;
    L11:
        r0.mSpanLookupSize = 0;
    L13:
        if (x() > 0) goto L15;
        r0.mAnchorPosition = -1;
        r0.mVisibleAnchorPosition = -1;
        r0.mSpanOffsetsSize = 0;
    L32:
        return r0;
    L15:
        if (this.o == false) goto L17;
        int r3 = o();
    L18:
        r0.mAnchorPosition = r3;
        r0.mVisibleAnchorPosition = k();
        r0.mSpanOffsetsSize = this.i;
        r0.mSpanOffsets = new int[this.i];
    L20:
        if (r2 >= this.i) goto L32;
        if (this.o == false) goto L26;
        int r4 = this.f2395a[r2].b(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        int r5 = this.f2396b.d();
    L29:
        r4 = r4 - r5;
    L30:
        r0.mSpanOffsets[r2] = r4;
        r2 = r2 + 1;
        goto L20
    L26:
        r4 = this.f2395a[r2].a(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        r5 = this.f2396b.c();
        goto L29
    L17:
        r3 = p();
        goto L18
    L9:
        if (r1.f2401a == null) goto L11;
        r0.mSpanLookup = this.h.f2401a;
        r0.mSpanLookupSize = r0.mSpanLookup.length;
        r0.mFullSpanItems = this.h.f2402b;
        goto L13
    L5:
        return new SavedState(this.A);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(AccessibilityEvent r3) {
        super.a(r3);
        if (x() <= 0) goto L13;
        View r1 = b(false);
        View r0 = c(false);
        if (r1 == null) goto L14;
        if (r0 == null) goto L16;
        int r2 = d(r1);
        int r4 = d(r0);
        if (r2 >= r4) goto L11;
        r3.setFromIndex(r2);
        r3.setToIndex(r4);
        return;
    L11:
        r3.setFromIndex(r4);
        r3.setToIndex(r2);
        return;
    L16:
        return;
    L14:
        return;
    }

    int k() {
        if (this.f2399e == false) goto L5;
        View r0 = c(true);
    L6:
        if (r0 != null) goto L9;
        return -1;
    L9:
        return d(r0);
    L5:
        r0 = b(true);
        goto L6
    }

    View b(boolean r9) {
        int r0 = this.f2396b.c();
        int r1 = this.f2396b.d();
        int r2 = x();
        View r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L15;
        View r5 = i(r4);
        int r6 = this.f2396b.a(r5);
        if (this.f2396b.b(r5) <= r0) goto L14;
        if (r6 >= r1) goto L14;
        if (r6 >= r0) goto L13;
        if (r9 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r5;
    L13:
        return r5;
    L14:
        r4 = r4 + 1;
        goto L3
    L15:
        return r3;
    }

    View c(boolean r8) {
        int r0 = this.f2396b.c();
        int r1 = this.f2396b.d();
        int r2 = x() - 1;
        View r3 = null;
    L3:
        if (r2 < 0) goto L15;
        View r4 = i(r2);
        int r5 = this.f2396b.a(r4);
        int r6 = this.f2396b.b(r4);
        if (r6 <= r0) goto L14;
        if (r5 >= r1) goto L14;
        if (r6 <= r1) goto L13;
        if (r8 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r4;
    L13:
        return r4;
    L14:
        r2 = r2 - 1;
        goto L3
    L15:
        return r3;
    }

    private void b(RecyclerView.n r3, RecyclerView.r r4, boolean r5) {
        int r1 = r(Integer.MIN_VALUE);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r0 = this.f2396b.d() - r1;
        if (r0 <= 0) goto L12;
        int r2 = r0 - (-c(-r0, r3, r4));
        if (r5 == false) goto L13;
        if (r2 <= 0) goto L14;
        this.f2396b.a(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void c(RecyclerView.n r3, RecyclerView.r r4, boolean r5) {
        int r1 = q(Integer.MAX_VALUE);
        if (r1 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r2 = r1 - this.f2396b.c();
        if (r2 <= 0) goto L12;
        int r6 = r2 - c(r2, r3, r4);
        if (r5 == false) goto L13;
        if (r6 <= 0) goto L14;
        this.f2396b.a(-r6);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void b(int r5, RecyclerView.r r6) {
        boolean r1 = false;
        this.l.f2564b = 0;
        this.l.f2565c = r5;
        if (u() == false) goto L13;
        int r7 = r6.c();
        if (r7 == (-1)) goto L13;
        boolean r0 = this.f2399e;
        if (r7 >= r5) goto L9;
        boolean r8 = true;
    L10:
        if (r0 != r8) goto L12;
        int r9 = this.f2396b.f();
        int r10 = 0;
    L15:
        if (t() == false) goto L17;
        this.l.f = this.f2396b.c() - r10;
        this.l.g = this.f2396b.d() + r9;
    L18:
        this.l.h = false;
        this.l.f2563a = true;
        o r11 = this.l;
        if (this.f2396b.h() == 0) goto L21;
    L23:
        r11.i = r1;
        return;
    L21:
        if (this.f2396b.e() != 0) goto L23;
        r1 = true;
        goto L23
    L17:
        this.l.g = this.f2396b.e() + r9;
        this.l.f = -r10;
        goto L18
    L12:
        r10 = this.f2396b.f();
        r9 = 0;
        goto L15
    L9:
        r8 = false;
    L13:
        r9 = 0;
        r10 = 0;
        goto L15
    }

    private void m(int r4) {
        this.l.f2567e = r4;
        o r0 = this.l;
        boolean r3 = this.f2399e;
        int r1 = 1;
        if (r4 != (-1)) goto L5;
        boolean r5 = true;
    L6:
        if (r3 == r5) goto L9;
        r1 = -1;
    L9:
        r0.f2566d = r1;
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void j(int r3) {
        super.j(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L6;
        this.f2395a[r0].d(r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void k(int r3) {
        super.k(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L6;
        this.f2395a[r0].d(r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void b(RecyclerView r1, int r2, int r3) {
        c(r2, r3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3) {
        c(r2, r3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1) {
        this.h.a();
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, int r4) {
        c(r2, r3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, Object r4) {
        c(r2, r3, 4);
    }

    private void c(int r7, int r8, int r9) {
        if (this.f2399e == false) goto L5;
        int r0 = o();
    L7:
        if (r9 != 8) goto L11;
        if (r7 >= r8) goto L10;
        int r2 = r8 + 1;
    L12:
        int r3 = r7;
    L13:
        this.h.b(r3);
        if (r9 != 1) goto L16;
        this.h.b(r7, r8);
    L22:
        if (r2 > r0) goto L25;
        return;
    L25:
        if (this.f2399e == false) goto L27;
        int r10 = p();
    L28:
        if (r3 > r10) goto L31;
        q();
        return;
    L31:
        return;
    L27:
        r10 = o();
        goto L28
    L16:
        if (r9 == 2) goto L20;
        if (r9 != 8) goto L22;
        this.h.a(r7, 1);
        this.h.b(r8, 1);
        goto L22
    L20:
        this.h.a(r7, r8);
        goto L22
    L10:
        r2 = r7 + 1;
        r3 = r8;
        goto L13
    L11:
        r2 = r7 + r8;
        goto L12
    L5:
        r0 = p();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int a(RecyclerView.n r17, o r18, RecyclerView.r r19) {
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i == false) goto L9;
        if (r18.f2567e != 1) goto L7;
        int r0 = Integer.MAX_VALUE;
    L12:
        int r11 = r0;
        a(r18.f2567e, r11);
        if (this.f2399e == false) goto L15;
        int r1 = this.f2396b.d();
    L16:
        int r12 = r1;
        ?? r2 = false;
    L18:
        if (r18.a(r19) == false) goto L108;
        if (this.l.i == false) goto L22;
    L23:
        View r13 = r18.a(r17);
        LayoutParams r14 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r3 = r14.getViewLayoutPosition();
        int r4 = this.h.c(r3);
        if (r4 != (-1)) goto L26;
        ?? r5 = 1;
    L27:
        if (r5 != 0) goto L29;
        b r6 = this.f2395a[r4];
    L34:
        b r15 = r6;
        r14.mSpan = r15;
        if (r18.f2567e != 1) goto L37;
        b(r13);
    L38:
        a(r13, r14, r9);
        if (r18.f2567e != 1) goto L51;
        if (r14.mFullSpan == false) goto L43;
        int r7 = r(r12);
    L44:
        int r8 = this.f2396b.e(r13) + r7;
        if (r5 != 0) goto L47;
    L49:
        int r10 = r8;
        int r16 = r7;
    L61:
        if (r14.mFullSpan == true) goto L63;
    L76:
        a(r13, r14, r18);
        if (j() == false) goto L86;
        if (this.j != 1) goto L86;
        if (r14.mFullSpan == false) goto L83;
        int r20 = this.f2397c.d();
    L84:
        int r21 = r20;
        int r22 = r20 - this.f2397c.e(r13);
    L91:
        if (this.j != 1) goto L93;
        a(r13, r22, r16, r21, r10);
    L95:
        if (r14.mFullSpan == false) goto L97;
        a(this.l.f2567e, r11);
    L98:
        a(r17, this.l);
        if (this.l.h == true) goto L101;
    L106:
        boolean r23 = false;
    L107:
        r9 = r23;
        r2 = true;
        goto L18
    L101:
        if (r13.hasFocusable() == false) goto L106;
        if (r14.mFullSpan == false) goto L105;
        this.m.clear();
        goto L106
    L105:
        r23 = false;
        this.m.set(r15.f2412e, false);
        goto L107
    L97:
        a(r15, this.l.f2567e, r11);
        goto L98
    L93:
        a(r13, r16, r22, r10, r21);
        goto L95
    L83:
        r20 = this.f2397c.d() - (((this.i - 1) - r15.f2412e) * this.k);
    L86:
        if (r14.mFullSpan == false) goto L88;
        int r24 = this.f2397c.c();
    L89:
        r22 = r24;
        r21 = this.f2397c.e(r13) + r24;
        goto L91
    L88:
        r24 = (r15.f2412e * this.k) + this.f2397c.c();
        goto L89
    L63:
        if (r18.f2566d != (-1)) goto L76;
        if (r5 == 0) goto L67;
        this.E = true;
        goto L76
    L67:
        if (r18.f2567e != 1) goto L69;
        boolean r25 = l();
    L71:
        if ((!r25) == false) goto L76;
        LazySpanLookup.FullSpanItem r26 = this.h.f(r3);
        if (r26 == null) goto L75;
        r26.mHasUnwantedGapAfter = true;
    L75:
        this.E = true;
        goto L76
    L69:
        r25 = m();
        goto L71
    L47:
        if (r14.mFullSpan == false) goto L49;
        LazySpanLookup.FullSpanItem r27 = n(r7);
        r27.mGapDir = -1;
        r27.mPosition = r3;
        this.h.a(r27);
        goto L49
    L43:
        r7 = r15.b(r12);
        goto L44
    L51:
        if (r14.mFullSpan == false) goto L53;
        int r28 = q(r12);
    L54:
        r16 = r28 - this.f2396b.e(r13);
        if (r5 != 0) goto L57;
    L59:
        r10 = r28;
        goto L61
    L57:
        if (r14.mFullSpan == false) goto L59;
        LazySpanLookup.FullSpanItem r29 = o(r28);
        r29.mGapDir = 1;
        r29.mPosition = r3;
        this.h.a(r29);
        goto L59
    L53:
        r28 = r15.a(r12);
        goto L54
    L37:
        b(r13, r9);
        goto L38
    L29:
        if (r14.mFullSpan == false) goto L31;
        r6 = this.f2395a[r9];
    L32:
        this.h.a(r3, r6);
        goto L34
    L31:
        r6 = a(r18);
        goto L32
    L26:
        r5 = r9;
        goto L27
    L22:
        if (this.m.isEmpty() == false) goto L23;
    L108:
        ?? r30 = r9;
        if (r2 == true) goto L112;
        a(r17, this.l);
    L112:
        if (this.l.f2567e != (-1)) goto L114;
        int r31 = this.f2396b.c() - q(this.f2396b.c());
    L115:
        if (r31 <= 0) goto L118;
        return Math.min(r18.f2564b, r31);
    L118:
        return r30 == true ? 1 : 0;
    L114:
        r31 = r(this.f2396b.d()) - this.f2396b.d();
        goto L115
    L15:
        r1 = this.f2396b.c();
        goto L16
    L7:
        r0 = Integer.MIN_VALUE;
        goto L12
    L9:
        if (r18.f2567e != 1) goto L11;
        r0 = r18.g + r18.f2564b;
        goto L12
    L11:
        r0 = r18.f - r18.f2564b;
        goto L12
    }

    private LazySpanLookup.FullSpanItem n(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.i];
        int r1 = 0;
    L4:
        if (r1 >= this.i) goto L6;
        r0.mGapPerSpan[r1] = r5 - this.f2395a[r1].b(r5);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private LazySpanLookup.FullSpanItem o(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.i];
        int r1 = 0;
    L4:
        if (r1 >= this.i) goto L6;
        r0.mGapPerSpan[r1] = this.f2395a[r1].a(r5) - r5;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private void a(View r2, LayoutParams r3, o r4) {
        if (r4.f2567e != 1) goto L9;
        if (r3.mFullSpan == false) goto L7;
        p(r2);
        return;
    L7:
        r3.mSpan.b(r2);
        return;
    L9:
        if (r3.mFullSpan == false) goto L11;
        q(r2);
        return;
    L11:
        r3.mSpan.a(r2);
    }

    private void a(RecyclerView.n r3, o r4) {
        if (r4.f2563a == true) goto L5;
        return;
    L5:
        if (r4.i == false) goto L8;
        return;
    L8:
        if (r4.f2564b != 0) goto L14;
        if (r4.f2567e != (-1)) goto L12;
        b(r3, r4.g);
        return;
    L12:
        a(r3, r4.f);
        return;
    L14:
        if (r4.f2567e != (-1)) goto L20;
        int r0 = r4.f - p(r4.f);
        if (r0 >= 0) goto L18;
        int r5 = r4.g;
    L19:
        b(r3, r5);
        return;
    L18:
        r5 = r4.g - Math.min(r0, r4.f2564b);
        goto L19
    L20:
        int r1 = s(r4.g) - r4.g;
        if (r1 >= 0) goto L23;
        int r6 = r4.f;
    L24:
        a(r3, r6);
        return;
    L23:
        int r2 = r4.f;
        r6 = Math.min(r1, r4.f2564b) + r2;
        goto L24
    }

    private void p(View r3) {
        int r0 = this.i - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f2395a[r0].b(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void q(View r3) {
        int r0 = this.i - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f2395a[r0].a(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void a(int r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L10;
        if (this.f2395a[r0].f2408a.isEmpty() == true) goto L9;
        a(this.f2395a[r0], r3, r4);
    L9:
        r0 = r0 + 1;
        goto L4
    }

    private void a(b r4, int r5, int r6) {
        int r0 = r4.i();
        if (r5 != (-1)) goto L8;
        if ((r4.b() + r0) > r6) goto L11;
        this.m.set(r4.f2412e, false);
        return;
    L11:
        return;
    L8:
        if ((r4.d() - r0) < r6) goto L13;
        this.m.set(r4.f2412e, false);
        return;
    }

    private int p(int r4) {
        int r0 = this.f2395a[0].a(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f2395a[r1].a(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int q(int r4) {
        int r0 = this.f2395a[0].a(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f2395a[r1].a(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    boolean l() {
        int r0 = this.f2395a[0].b(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.i) goto L9;
        if (this.f2395a[r4].b(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    boolean m() {
        int r0 = this.f2395a[0].a(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.i) goto L9;
        if (this.f2395a[r4].a(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private int r(int r4) {
        int r0 = this.f2395a[0].b(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f2395a[r1].b(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int s(int r4) {
        int r0 = this.f2395a[0].b(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f2395a[r1].b(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private void a(RecyclerView.n r6, int r7) {
    L3:
        if (x() <= 0) goto L25;
        int r0 = 0;
        View r1 = i(0);
        if (this.f2396b.b(r1) > r7) goto L34;
        if (this.f2396b.c(r1) > r7) goto L35;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.mFullSpan == false) goto L21;
        int r3 = 0;
    L12:
        if (r3 >= this.i) goto L18;
        if (this.f2395a[r3].f2408a.size() == 1) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r0 >= this.i) goto L24;
        this.f2395a[r0].h();
        r0 = r0 + 1;
    L24:
        a(r1, r6);
        goto L3
    L21:
        if (r2.mSpan.f2408a.size() == 1) goto L22;
        r2.mSpan.h();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void b(RecyclerView.n r7, int r8) {
        int r0 = x() - 1;
    L3:
        if (r0 < 0) goto L25;
        View r2 = i(r0);
        if (this.f2396b.a(r2) < r8) goto L34;
        if (this.f2396b.d(r2) < r8) goto L35;
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r3.mFullSpan == false) goto L21;
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r5 >= this.i) goto L18;
        if (this.f2395a[r5].f2408a.size() == 1) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r4 >= this.i) goto L24;
        this.f2395a[r4].g();
        r4 = r4 + 1;
    L24:
        a(r2, r7);
        r0 = r0 - 1;
        goto L3
    L21:
        if (r3.mSpan.f2408a.size() == 1) goto L22;
        r3.mSpan.g();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private boolean t(int r5) {
        if (this.j != 0) goto L12;
        if (r5 != (-1)) goto L6;
        boolean r6 = true;
    L8:
        if (r6 == this.f2399e) goto L11;
        return true;
    L11:
        return false;
    L6:
        r6 = false;
        goto L8
    L12:
        if (r5 != (-1)) goto L14;
        boolean r7 = true;
    L16:
        if (r7 != this.f2399e) goto L18;
        boolean r8 = true;
    L20:
        if (r8 != j()) goto L23;
        return true;
    L23:
        return false;
    L18:
        r8 = false;
        goto L20
    L14:
        r7 = false;
        goto L16
    }

    private b a(o r8) {
        int r1 = -1;
        if (t(r8.f2567e) == false) goto L5;
        int r0 = this.i - 1;
        int r3 = -1;
    L6:
        b r4 = null;
        if (r8.f2567e != 1) goto L15;
        int r9 = Integer.MAX_VALUE;
        int r2 = this.f2396b.c();
    L9:
        if (r0 == r1) goto L14;
        b r5 = this.f2395a[r0];
        int r6 = r5.b(r2);
        if (r6 >= r9) goto L13;
        r4 = r5;
        r9 = r6;
    L13:
        r0 = r0 + r3;
        goto L9
    L14:
        return r4;
    L15:
        int r10 = Integer.MIN_VALUE;
        int r7 = this.f2396b.d();
    L16:
        if (r0 == r1) goto L21;
        b r11 = this.f2395a[r0];
        int r12 = r11.a(r7);
        if (r12 <= r10) goto L20;
        r4 = r11;
        r10 = r12;
    L20:
        r0 = r0 + r3;
        goto L16
    L21:
        return r4;
    L5:
        r0 = 0;
        r1 = this.i;
        r3 = 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean g() {
        if (this.j == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean f() {
        if (this.j != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int a(int r1, RecyclerView.n r2, RecyclerView.r r3) {
        return c(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int b(int r1, RecyclerView.n r2, RecyclerView.r r3) {
        return c(r1, r2, r3);
    }

    private int u(int r4) {
        if (x() != 0) goto L9;
        if (this.f2399e == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r4 >= p()) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == this.f2399e) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r5 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q.b
    public PointF d(int r3) {
        int r4 = u(r3);
        PointF r0 = new PointF();
        if (r4 != 0) goto L7;
        return null;
    L7:
        if (this.j != 0) goto L9;
        r0.x = r4;
        r0.y = 0.0f;
    L10:
        return r0;
    L9:
        r0.x = 0.0f;
        r0.y = r4;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r3, RecyclerView.r r4, int r5) {
        p r6 = new p((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r6.c(r5);
        a(r6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void e(int r2) {
        SavedState r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        this.f = r2;
        this.g = Integer.MIN_VALUE;
        q();
        return;
    L5:
        if (r0.mAnchorPosition == r2) goto L7;
        this.A.invalidateAnchorPositionInfo();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(int r5, int r6, RecyclerView.r r7, RecyclerView.h.a r8) {
        RecyclerView.h.a r9 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r8, RecyclerView.h.a.class, "com.obric.aiagent.plugin");
        if (this.j == 0) goto L7;
        r5 = r6;
    L7:
        if (x() == 0) goto L31;
        if (r5 == 0) goto L37;
        a(r5, r7);
        int[] r10 = this.G;
        if (r10 != null) goto L13;
    L14:
        this.G = new int[this.i];
    L15:
        int r11 = 0;
        int r12 = 0;
        int r0 = 0;
    L17:
        if (r12 >= this.i) goto L26;
        if (this.l.f2566d != (-1)) goto L21;
        int r1 = this.l.f;
        int r2 = this.f2395a[r12].a(this.l.f);
    L22:
        int r3 = r1 - r2;
        if (r3 < 0) goto L25;
        this.G[r0] = r3;
        r0 = r0 + 1;
    L25:
        r12 = r12 + 1;
        goto L17
    L21:
        r1 = this.f2395a[r12].b(this.l.g);
        r2 = this.l.g;
        goto L22
    L26:
        Arrays.sort(this.G, 0, r0);
    L27:
        if (r11 >= r0) goto L38;
        if (this.l.a(r7) == false) goto L39;
        r9.b(this.l.f2565c, this.G[r11]);
        this.l.f2565c += this.l.f2566d;
        r11 = r11 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r10.length >= this.i) goto L15;
    L37:
        return;
    }

    void a(int r6, RecyclerView.r r7) {
        if (r6 <= 0) goto L5;
        int r1 = o();
        int r2 = 1;
    L6:
        this.l.f2563a = true;
        b(r1, r7);
        m(r2);
        o r8 = this.l;
        r8.f2565c = r1 + r8.f2566d;
        this.l.f2564b = Math.abs(r6);
        return;
    L5:
        r2 = -1;
        r1 = p();
        goto L6
    }

    int c(int r3, RecyclerView.n r4, RecyclerView.r r5) {
        if (x() == 0) goto L14;
        if (r3 == 0) goto L14;
        a(r3, r5);
        int r6 = a(r4, this.l, r5);
        if (this.l.f2564b < r6) goto L12;
        if (r3 >= 0) goto L11;
        r3 = -r6;
        goto L12
    L11:
        r3 = r6;
    L12:
        this.f2396b.a(-r3);
        this.o = this.f2399e;
        this.l.f2564b = 0;
        a(r4, this.l);
        return r3;
    L14:
        return 0;
    }

    int o() {
        int r0 = x();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return d(i(r0 - 1));
    }

    int p() {
        if (x() != 0) goto L6;
        return 0;
    L6:
        return d(i(0));
    }

    private int v(int r5) {
        int r0 = x();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r3 = d(i(r2));
        if (r3 < 0) goto L8;
        if (r3 >= r5) goto L8;
        return r3;
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return 0;
    }

    private int w(int r3) {
        int r0 = x() - 1;
    L3:
        if (r0 < 0) goto L9;
        int r1 = d(i(r0));
        if (r1 < 0) goto L8;
        if (r1 >= r3) goto L8;
        return r1;
    L8:
        r0 = r0 - 1;
        goto L3
    L9:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        if (this.j != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(Context r2, AttributeSet r3) {
        return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L7:
        return new LayoutParams(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean a(RecyclerView.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public View a(View r9, int r10, RecyclerView.n r11, RecyclerView.r r12) {
        if (x() != 0) goto L5;
        return null;
    L5:
        View r13 = e(r9);
        if (r13 != null) goto L8;
        return null;
    L8:
        O();
        int r14 = x(r10);
        if (r14 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        boolean r2 = r0.mFullSpan;
        b r1 = r0.mSpan;
        if (r14 != 1) goto L14;
        int r4 = o();
    L15:
        b(r4, r12);
        m(r14);
        o r5 = this.l;
        r5.f2565c = r5.f2566d + r4;
        this.l.f2564b = (int) (this.f2396b.f() * 0.33333334f);
        this.l.h = true;
        int r6 = 0;
        this.l.f2563a = false;
        a(r11, this.l, r12);
        this.o = this.f2399e;
        if (r2 == true) goto L22;
        View r15 = r1.a(r4, r14);
        if (r15 == null) goto L22;
        if (r15 == r13) goto L22;
        return r15;
    L22:
        if (t(r14) == false) goto L30;
        int r16 = this.i - 1;
    L24:
        if (r16 < 0) goto L38;
        View r17 = this.f2395a[r16].a(r4, r14);
        if (r17 == null) goto L29;
        if (r17 == r13) goto L29;
        return r17;
    L29:
        r16 = r16 - 1;
    L38:
        boolean r18 = !this.f2398d;
        if (r14 != (-1)) goto L41;
        boolean r19 = true;
    L42:
        if (r18 != r19) goto L44;
        boolean r110 = true;
    L45:
        if (r2 == true) goto L54;
        if (r110 == false) goto L48;
        int r111 = r1.j();
    L49:
        View r112 = c(r111);
        if (r112 == null) goto L54;
        if (r112 == r13) goto L54;
        return r112;
    L48:
        r111 = r1.k();
    L54:
        if (t(r14) == false) goto L69;
        int r113 = this.i - 1;
    L56:
        if (r113 < 0) goto L78;
        if (r113 == r1.f2412e) goto L67;
        if (r110 == false) goto L62;
        int r114 = this.f2395a[r113].j();
    L63:
        View r115 = c(r114);
        if (r115 == null) goto L67;
        if (r115 == r13) goto L67;
        return r115;
    L62:
        r114 = this.f2395a[r113].k();
    L67:
        r113 = r113 - 1;
    L78:
        return null;
    L69:
        if (r6 >= this.i) goto L78;
        if (r110 == false) goto L72;
        int r116 = this.f2395a[r6].j();
    L73:
        View r117 = c(r116);
        if (r117 == null) goto L77;
        if (r117 == r13) goto L77;
        return r117;
    L77:
        r6 = r6 + 1;
        goto L69
    L72:
        r116 = this.f2395a[r6].k();
        goto L73
    L44:
        r110 = false;
        goto L45
    L41:
        r19 = false;
        goto L42
    L30:
        int r118 = 0;
    L32:
        if (r118 >= this.i) goto L38;
        View r119 = this.f2395a[r118].a(r4, r14);
        if (r119 == null) goto L37;
        if (r119 == r13) goto L37;
        return r119;
    L37:
        r118 = r118 + 1;
        goto L32
    L14:
        r4 = p();
        goto L15
    }

    private int x(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.j != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.j != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.j != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.j != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.j != 1) goto L39;
        return 1;
    L39:
        if (j() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.j != 1) goto L46;
        return -1;
    L46:
        if (j() == false) goto L48;
        return 1;
    L48:
        return -1;
    }
}
