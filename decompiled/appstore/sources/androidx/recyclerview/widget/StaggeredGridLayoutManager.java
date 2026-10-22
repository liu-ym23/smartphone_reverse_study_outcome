package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c[] f4261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OrientationHelper f4262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrientationHelper f4263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f4266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BitSet f4269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4271l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LazySpanLookup f4272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4273n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4274o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4275p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SavedState f4276q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4277r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f4278s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f4279t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4280u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4281v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f4282w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f4283x;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f4284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4285b;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public boolean a() {
            return this.f4285b;
        }

        public void b(boolean r10) {
            this.f4285b = r10;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }
    }

    public static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f4286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f4287b;

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public class a implements Parcelable.Creator {
                public a() {
                }

                public FullSpanItem a(Parcel r10) {
                    return new FullSpanItem(r10);
                }

                public FullSpanItem[] b(int r10) {
                    return new FullSpanItem[r10];
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                    return a(r10);
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                    return b(r10);
                }
            }

            static {
                CREATOR = new a();
            }

            public FullSpanItem(Parcel r10) {
                this.mPosition = r10.readInt();
                this.mGapDir = r10.readInt();
                boolean r11 = true;
                if (r10.readInt() == 1) goto L6;
                r11 = false;
            L6:
                this.mHasUnwantedGapAfter = r11;
                int r12 = r10.readInt();
                if (r12 <= 0) goto L10;
                int[] r13 = new int[r12];
                this.mGapPerSpan = r13;
                r10.readIntArray(r13);
                return;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getGapForSpan(int r10) {
                int[] r11 = this.mGapPerSpan;
                if (r11 != null) goto L6;
                return 0;
            L6:
                return r11[r10];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r10, int r11) {
                r10.writeInt(this.mPosition);
                r10.writeInt(this.mGapDir);
                r10.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r12 = this.mGapPerSpan;
                if (r12 != null) goto L5;
            L7:
                r10.writeInt(0);
                return;
            L5:
                if (r12.length <= 0) goto L7;
                r10.writeInt(r12.length);
                r10.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }

        public LazySpanLookup() {
        }

        public void a(FullSpanItem r10) {
            if (this.f4287b != null) goto L5;
            this.f4287b = new ArrayList();
        L5:
            int r11 = this.f4287b.size();
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L15;
            FullSpanItem r13 = (FullSpanItem) this.f4287b.get(r12);
            if (r13.mPosition != r10.mPosition) goto L11;
            this.f4287b.remove(r12);
        L11:
            if (r13.mPosition >= r10.mPosition) goto L12;
            r12 = r12 + 1;
            goto L6
        L12:
            this.f4287b.add(r12, r10);
            return;
        L15:
            this.f4287b.add(r10);
        }

        public void b() {
            int[] r10 = this.f4286a;
            if (r10 == null) goto L5;
            Arrays.fill(r10, -1);
        L5:
            this.f4287b = null;
        }

        public void c(int r10) {
            int[] r11 = this.f4286a;
            if (r11 != null) goto L6;
            int[] r12 = new int[Math.max(r10, 10) + 1];
            this.f4286a = r12;
            Arrays.fill(r12, -1);
            return;
        L6:
            if (r10 < r11.length) goto L10;
            int[] r13 = new int[o(r10)];
            this.f4286a = r13;
            System.arraycopy(r11, 0, r13, 0, r11.length);
            int[] r14 = this.f4286a;
            Arrays.fill(r14, r11.length, r14.length, -1);
            return;
        }

        public int d(int r10) {
            List r11 = this.f4287b;
            if (r11 == null) goto L11;
            int r12 = r11.size() - 1;
        L5:
            if (r12 < 0) goto L11;
            if (((FullSpanItem) this.f4287b.get(r12)).mPosition < r10) goto L9;
            this.f4287b.remove(r12);
        L9:
            r12 = r12 - 1;
        L11:
            return h(r10);
        }

        public FullSpanItem e(int r10, int r11, int r12, boolean r13) {
            List r14 = this.f4287b;
            if (r14 != null) goto L5;
            return null;
        L5:
            int r15 = r14.size();
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L19;
            FullSpanItem r17 = (FullSpanItem) this.f4287b.get(r16);
            int r18 = r17.mPosition;
            if (r18 >= r11) goto L9;
            if (r18 < r10) goto L18;
            if (r12 == 0) goto L17;
            if (r17.mGapDir == r12) goto L17;
            if (r13 == false) goto L18;
            if (r17.mHasUnwantedGapAfter == false) goto L18;
        L17:
            return r17;
        L18:
            r16 = r16 + 1;
            goto L6
        L9:
            return null;
        L19:
            return null;
        }

        public FullSpanItem f(int r10) {
            List r11 = this.f4287b;
            if (r11 != null) goto L5;
            return null;
        L5:
            int r12 = r11.size() - 1;
        L6:
            if (r12 < 0) goto L11;
            FullSpanItem r13 = (FullSpanItem) this.f4287b.get(r12);
            if (r13.mPosition == r10) goto L9;
            r12 = r12 - 1;
            goto L6
        L9:
            return r13;
        L11:
            return null;
        }

        public int g(int r10) {
            int[] r11 = this.f4286a;
            if (r11 != null) goto L5;
            return -1;
        L5:
            if (r10 < r11.length) goto L8;
            return -1;
        L8:
            return r11[r10];
        }

        public int h(int r10) {
            int[] r11 = this.f4286a;
            if (r11 != null) goto L6;
            return -1;
        L6:
            if (r10 < r11.length) goto L8;
            return -1;
        L8:
            int r12 = i(r10);
            if (r12 != (-1)) goto L12;
            int[] r13 = this.f4286a;
            Arrays.fill(r13, r10, r13.length, -1);
            return this.f4286a.length;
        L12:
            int r14 = Math.min(r12 + 1, this.f4286a.length);
            Arrays.fill(this.f4286a, r10, r14, -1);
            return r14;
        }

        public final int i(int r10) {
            if (this.f4287b != null) goto L5;
            return -1;
        L5:
            FullSpanItem r11 = f(r10);
            if (r11 == null) goto L8;
            this.f4287b.remove(r11);
        L8:
            int r12 = this.f4287b.size();
            int r13 = 0;
        L9:
            if (r13 >= r12) goto L14;
            if (((FullSpanItem) this.f4287b.get(r13)).mPosition >= r10) goto L15;
            r13 = r13 + 1;
        L15:
            if (r13 == (-1)) goto L18;
            FullSpanItem r14 = (FullSpanItem) this.f4287b.get(r13);
            this.f4287b.remove(r13);
            return r14.mPosition;
        L18:
            return -1;
        L14:
            r13 = -1;
            goto L15
        }

        public void j(int r10, int r11) {
            int[] r12 = this.f4286a;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            c(r13);
            int[] r14 = this.f4286a;
            System.arraycopy(r14, r10, r14, r13, (r14.length - r10) - r11);
            Arrays.fill(this.f4286a, r10, r13, -1);
            l(r10, r11);
            return;
        }

        public void k(int r10, int r11) {
            int[] r12 = this.f4286a;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            c(r13);
            int[] r14 = this.f4286a;
            System.arraycopy(r14, r13, r14, r10, (r14.length - r10) - r11);
            int[] r15 = this.f4286a;
            Arrays.fill(r15, r15.length - r11, r15.length, -1);
            m(r10, r11);
            return;
        }

        public final void l(int r10, int r11) {
            List r12 = this.f4287b;
            if (r12 != null) goto L5;
            return;
        L5:
            int r13 = r12.size() - 1;
        L6:
            if (r13 < 0) goto L12;
            FullSpanItem r14 = (FullSpanItem) this.f4287b.get(r13);
            int r15 = r14.mPosition;
            if (r15 < r10) goto L11;
            r14.mPosition = r15 + r11;
        L11:
            r13 = r13 - 1;
            goto L6
        }

        public final void m(int r10, int r11) {
            List r12 = this.f4287b;
            if (r12 != null) goto L5;
            return;
        L5:
            int r13 = r10 + r11;
            int r14 = r12.size() - 1;
        L6:
            if (r14 < 0) goto L14;
            FullSpanItem r15 = (FullSpanItem) this.f4287b.get(r14);
            int r16 = r15.mPosition;
            if (r16 < r10) goto L13;
            if (r16 >= r13) goto L12;
            this.f4287b.remove(r14);
            goto L13
        L12:
            r15.mPosition = r16 - r11;
        L13:
            r14 = r14 - 1;
            goto L6
        }

        public void n(int r10, c r11) {
            c(r10);
            this.f4286a[r10] = r11.f4300e;
        }

        public int o(int r10) {
            int r11 = this.f4286a.length;
        L3:
            if (r11 > r10) goto L5;
            r11 = r11 * 2;
            goto L3
        L5:
            return r11;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
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

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mAnchorPosition);
            r10.writeInt(this.mVisibleAnchorPosition);
            r10.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r10.writeIntArray(this.mSpanOffsets);
        L5:
            r10.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r10.writeIntArray(this.mSpanLookup);
        L8:
            r10.writeInt(this.mReverseLayout ? 1 : 0);
            r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r10.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r10.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel r10) {
            this.mAnchorPosition = r10.readInt();
            this.mVisibleAnchorPosition = r10.readInt();
            int r11 = r10.readInt();
            this.mSpanOffsetsSize = r11;
            if (r11 <= 0) goto L5;
            int[] r12 = new int[r11];
            this.mSpanOffsets = r12;
            r10.readIntArray(r12);
        L5:
            int r13 = r10.readInt();
            this.mSpanLookupSize = r13;
            if (r13 <= 0) goto L8;
            int[] r14 = new int[r13];
            this.mSpanLookup = r14;
            r10.readIntArray(r14);
        L8:
            boolean r15 = false;
            if (r10.readInt() != 1) goto L11;
            boolean r16 = true;
        L12:
            this.mReverseLayout = r16;
            if (r10.readInt() != 1) goto L15;
            boolean r17 = true;
        L16:
            this.mAnchorLayoutFromEnd = r17;
            if (r10.readInt() != 1) goto L19;
            r15 = true;
        L19:
            this.mLastLayoutRTL = r15;
            this.mFullSpanItems = r10.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r17 = false;
            goto L16
        L11:
            r16 = false;
            goto L12
        }

        public SavedState(SavedState r10) {
            this.mSpanOffsetsSize = r10.mSpanOffsetsSize;
            this.mAnchorPosition = r10.mAnchorPosition;
            this.mVisibleAnchorPosition = r10.mVisibleAnchorPosition;
            this.mSpanOffsets = r10.mSpanOffsets;
            this.mSpanLookupSize = r10.mSpanLookupSize;
            this.mSpanLookup = r10.mSpanLookup;
            this.mReverseLayout = r10.mReverseLayout;
            this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r10.mLastLayoutRTL;
            this.mFullSpanItems = r10.mFullSpanItems;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f4288a;

        public a(StaggeredGridLayoutManager r10) {
            this.f4288a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4288a.g();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f4294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f4295g;

        public b(StaggeredGridLayoutManager r10) {
            this.f4295g = r10;
            c();
        }

        public void a() {
            if (this.f4291c == false) goto L5;
            int r10 = this.f4295g.f4262c.i();
        L6:
            this.f4290b = r10;
            return;
        L5:
            r10 = this.f4295g.f4262c.n();
            goto L6
        }

        public void b(int r10) {
            if (this.f4291c == false) goto L5;
            this.f4290b = this.f4295g.f4262c.i() - r10;
            return;
        L5:
            this.f4290b = this.f4295g.f4262c.n() + r10;
        }

        public void c() {
            this.f4289a = -1;
            this.f4290b = Integer.MIN_VALUE;
            this.f4291c = false;
            this.f4292d = false;
            this.f4293e = false;
            int[] r10 = this.f4294f;
            if (r10 == null) goto L6;
            Arrays.fill(r10, -1);
            return;
        }

        public void d(c[] r10) {
            int r11 = r10.length;
            int[] r12 = this.f4294f;
            if (r12 != null) goto L5;
        L6:
            this.f4294f = new int[this.f4295g.f4261b.length];
        L7:
            int r13 = 0;
        L8:
            if (r13 >= r11) goto L10;
            this.f4294f[r13] = r10[r13].r(Integer.MIN_VALUE);
            r13 = r13 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r12.length >= r11) goto L7;
            goto L6
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f4296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4300e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f4301f;

        public c(StaggeredGridLayoutManager r10, int r11) {
            this.f4301f = r10;
            this.f4296a = new ArrayList();
            this.f4297b = Integer.MIN_VALUE;
            this.f4298c = Integer.MIN_VALUE;
            this.f4299d = 0;
            this.f4300e = r11;
        }

        public void a(View r10) {
            LayoutParams r11 = p(r10);
            r11.f4284a = this;
            this.f4296a.add(r10);
            this.f4298c = Integer.MIN_VALUE;
            if (this.f4296a.size() != 1) goto L6;
            this.f4297b = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.f4299d += this.f4301f.f4262c.e(r10);
            return;
        L8:
            if (r11.isItemChanged() == true) goto L9;
        }

        public void b(boolean r10, int r11) {
            if (r10 == false) goto L5;
            int r12 = n(Integer.MIN_VALUE);
        L6:
            e();
            if (r12 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r10 == true) goto L11;
        L12:
            if (r10 == false) goto L14;
        L16:
            if (r11 == Integer.MIN_VALUE) goto L18;
            r12 = r12 + r11;
        L18:
            this.f4298c = r12;
            this.f4297b = r12;
            return;
        L14:
            if (r12 <= this.f4301f.f4262c.n()) goto L16;
            return;
        L11:
            if (r12 >= this.f4301f.f4262c.i()) goto L12;
            return;
        L5:
            r12 = r(Integer.MIN_VALUE);
            goto L6
        }

        public void c() {
            ArrayList r10 = this.f4296a;
            View r11 = (View) r10.get(r10.size() - 1);
            LayoutParams r12 = p(r11);
            this.f4298c = this.f4301f.f4262c.d(r11);
            if (r12.f4285b == false) goto L10;
            LazySpanLookup.FullSpanItem r13 = this.f4301f.f4272m.f(r12.getViewLayoutPosition());
            if (r13 != null) goto L7;
            return;
        L7:
            if (r13.mGapDir != 1) goto L12;
            this.f4298c += r13.getGapForSpan(this.f4300e);
            return;
        L12:
            return;
        }

        public void d() {
            View r10 = (View) this.f4296a.get(0);
            LayoutParams r11 = p(r10);
            this.f4297b = this.f4301f.f4262c.g(r10);
            if (r11.f4285b == false) goto L10;
            LazySpanLookup.FullSpanItem r12 = this.f4301f.f4272m.f(r11.getViewLayoutPosition());
            if (r12 != null) goto L7;
            return;
        L7:
            if (r12.mGapDir != (-1)) goto L12;
            this.f4297b -= r12.getGapForSpan(this.f4300e);
            return;
        L12:
            return;
        }

        public void e() {
            this.f4296a.clear();
            s();
            this.f4299d = 0;
        }

        public int f() {
            if (this.f4301f.f4267h == false) goto L6;
            return j(this.f4296a.size() - 1, -1, true);
        L6:
            return j(0, this.f4296a.size(), true);
        }

        public int g() {
            if (this.f4301f.f4267h == false) goto L6;
            return k(0, this.f4296a.size(), true);
        L6:
            return k(this.f4296a.size() - 1, -1, true);
        }

        public int h() {
            if (this.f4301f.f4267h == false) goto L6;
            return j(0, this.f4296a.size(), true);
        L6:
            return j(this.f4296a.size() - 1, -1, true);
        }

        public int i(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r10 = this.f4301f.f4262c.n();
            int r16 = this.f4301f.f4262c.i();
            if (r12 <= r11) goto L5;
            int r17 = 1;
        L6:
            if (r11 == r12) goto L35;
            View r18 = (View) this.f4296a.get(r11);
            int r19 = this.f4301f.f4262c.g(r18);
            int r20 = this.f4301f.f4262c.d(r18);
            boolean r21 = false;
            if (r15 == false) goto L12;
            if (r19 > r16) goto L11;
        L10:
            boolean r22 = true;
        L14:
            if (r15 == false) goto L17;
            if (r20 < r10) goto L19;
        L16:
            r21 = true;
        L19:
            if (r22 == false) goto L34;
            if (r21 == false) goto L34;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r19 < r10) goto L34;
            if (r20 > r16) goto L34;
            return this.f4301f.getPosition(r18);
        L27:
            if (r14 == true) goto L29;
            if (r19 < r10) goto L33;
            if (r20 <= r16) goto L34;
        L33:
            return this.f4301f.getPosition(r18);
        L29:
            return this.f4301f.getPosition(r18);
        L34:
            r11 = r11 + r17;
            goto L6
        L17:
            if (r20 <= r10) goto L19;
        L11:
            r22 = false;
            goto L14
        L12:
            if (r19 >= r16) goto L11;
        L35:
            return -1;
        L5:
            r17 = -1;
            goto L6
        }

        public int j(int r10, int r11, boolean r12) {
            return i(r10, r11, false, false, r12);
        }

        public int k(int r10, int r11, boolean r12) {
            return i(r10, r11, r12, true, false);
        }

        public int l() {
            return this.f4299d;
        }

        public int m() {
            int r10 = this.f4298c;
            if (r10 == Integer.MIN_VALUE) goto L5;
            return r10;
        L5:
            c();
            return this.f4298c;
        }

        public int n(int r10) {
            int r11 = this.f4298c;
            if (r11 == Integer.MIN_VALUE) goto L6;
            return r11;
        L6:
            if (this.f4296a.size() != 0) goto L8;
            return r10;
        L8:
            c();
            return this.f4298c;
        }

        public View o(int r10, int r11) {
            View r12 = null;
            if (r11 != (-1)) goto L18;
            int r13 = this.f4296a.size();
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L32;
            View r15 = (View) this.f4296a.get(r14);
            StaggeredGridLayoutManager r16 = this.f4301f;
            if (r16.f4267h == true) goto L9;
        L10:
            StaggeredGridLayoutManager r17 = this.f4301f;
            if (r17.f4267h == true) goto L16;
            if (r17.getPosition(r15) >= r10) goto L32;
        L16:
            if (r15.hasFocusable() == false) goto L32;
            r14 = r14 + 1;
            r12 = r15;
            goto L5
        L9:
            if (r16.getPosition(r15) > r10) goto L10;
        L32:
            return r12;
        L18:
            int r18 = this.f4296a.size() - 1;
        L19:
            if (r18 < 0) goto L32;
            View r19 = (View) this.f4296a.get(r18);
            StaggeredGridLayoutManager r20 = this.f4301f;
            if (r20.f4267h == true) goto L23;
        L24:
            StaggeredGridLayoutManager r21 = this.f4301f;
            if (r21.f4267h == true) goto L30;
            if (r21.getPosition(r19) <= r10) goto L32;
        L30:
            if (r19.hasFocusable() == false) goto L32;
            r18 = r18 - 1;
            r12 = r19;
            goto L19
        L23:
            if (r20.getPosition(r19) >= r10) goto L32;
            goto L24
        }

        public LayoutParams p(View r10) {
            return (LayoutParams) r10.getLayoutParams();
        }

        public int q() {
            int r10 = this.f4297b;
            if (r10 == Integer.MIN_VALUE) goto L5;
            return r10;
        L5:
            d();
            return this.f4297b;
        }

        public int r(int r10) {
            int r11 = this.f4297b;
            if (r11 == Integer.MIN_VALUE) goto L6;
            return r11;
        L6:
            if (this.f4296a.size() != 0) goto L8;
            return r10;
        L8:
            d();
            return this.f4297b;
        }

        public void s() {
            this.f4297b = Integer.MIN_VALUE;
            this.f4298c = Integer.MIN_VALUE;
        }

        public void t(int r10) {
            int r11 = this.f4297b;
            if (r11 == Integer.MIN_VALUE) goto L5;
            this.f4297b = r11 + r10;
        L5:
            int r12 = this.f4298c;
            if (r12 == Integer.MIN_VALUE) goto L9;
            this.f4298c = r12 + r10;
            return;
        }

        public void u() {
            int r10 = this.f4296a.size();
            View r11 = (View) this.f4296a.remove(r10 - 1);
            LayoutParams r12 = p(r11);
            r12.f4284a = null;
            if (r12.isItemRemoved() == false) goto L5;
        L6:
            this.f4299d -= this.f4301f.f4262c.e(r11);
        L8:
            if (r10 != 1) goto L10;
            this.f4297b = Integer.MIN_VALUE;
        L10:
            this.f4298c = Integer.MIN_VALUE;
            return;
        L5:
            if (r12.isItemChanged() == false) goto L8;
            goto L6
        }

        public void v() {
            View r10 = (View) this.f4296a.remove(0);
            LayoutParams r11 = p(r10);
            r11.f4284a = null;
            if (this.f4296a.size() != 0) goto L6;
            this.f4298c = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.f4299d -= this.f4301f.f4262c.e(r10);
        L10:
            this.f4297b = Integer.MIN_VALUE;
            return;
        L8:
            if (r11.isItemChanged() == false) goto L10;
            goto L9
        }

        public void w(View r10) {
            LayoutParams r11 = p(r10);
            r11.f4284a = this;
            this.f4296a.add(0, r10);
            this.f4297b = Integer.MIN_VALUE;
            if (this.f4296a.size() != 1) goto L6;
            this.f4298c = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.f4299d += this.f4301f.f4262c.e(r10);
            return;
        L8:
            if (r11.isItemChanged() == true) goto L9;
        }

        public void x(int r10) {
            this.f4297b = r10;
            this.f4298c = r10;
        }
    }

    public StaggeredGridLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
        this.f4260a = -1;
        this.f4267h = false;
        this.f4268i = false;
        this.f4270k = -1;
        this.f4271l = Integer.MIN_VALUE;
        this.f4272m = new LazySpanLookup();
        this.f4273n = 2;
        this.f4278s = new Rect();
        this.f4279t = new b(this);
        this.f4280u = false;
        this.f4281v = true;
        this.f4283x = new a(this);
        RecyclerView.LayoutManager.Properties r14 = RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13);
        setOrientation(r14.f4197a);
        U(r14.f4198b);
        setReverseLayout(r14.f4199c);
        this.f4266g = new g();
        n();
    }

    private void I(View r10, int r11, int r12, boolean r13) {
        calculateItemDecorationsForChild(r10, this.f4278s);
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).leftMargin;
        Rect r16 = this.f4278s;
        int r17 = updateSpecWithExtra(r11, r15 + r16.left, ((ViewGroup.MarginLayoutParams) r14).rightMargin + r16.right);
        int r18 = ((ViewGroup.MarginLayoutParams) r14).topMargin;
        Rect r19 = this.f4278s;
        int r20 = updateSpecWithExtra(r12, r18 + r19.top, ((ViewGroup.MarginLayoutParams) r14).bottomMargin + r19.bottom);
        if (r13 == false) goto L5;
        boolean r21 = shouldReMeasureChild(r10, r17, r20, r14);
    L6:
        if (r21 == false) goto L9;
        r10.measure(r17, r20);
        return;
    L9:
        return;
    L5:
        r21 = shouldMeasureChild(r10, r17, r20, r14);
        goto L6
    }

    private void S() {
        if (this.f4264e != 1) goto L5;
    L8:
        this.f4268i = this.f4267h;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.f4268i = !this.f4267h;
    }

    private int convertFocusDirectionToLayoutDirection(int r10) {
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L36;
        if (r10 == 17) goto L31;
        if (r10 == 33) goto L26;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.f4264e != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.f4264e != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.f4264e != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.f4264e != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.f4264e != 1) goto L39;
        return 1;
    L39:
        if (isLayoutRTL() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.f4264e != 1) goto L46;
        return -1;
    L46:
        if (isLayoutRTL() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    private int i(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return l.a(r10, this.f4262c, r(!this.f4281v), q(!this.f4281v), this, this.f4281v);
    }

    private int j(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return l.b(r10, this.f4262c, r(!this.f4281v), q(!this.f4281v), this, this.f4281v, this.f4268i);
    }

    private int k(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return l.c(r10, this.f4262c, r(!this.f4281v), q(!this.f4281v), this, this.f4281v);
    }

    public final int A(int r10) {
        int r11 = this.f4261b[0].r(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.f4260a) goto L9;
        int r13 = this.f4261b[r12].r(r10);
        if (r13 <= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    public final int B(int r10) {
        int r11 = this.f4261b[0].n(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.f4260a) goto L9;
        int r13 = this.f4261b[r12].n(r10);
        if (r13 >= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    public final int C(int r10) {
        int r11 = this.f4261b[0].r(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.f4260a) goto L9;
        int r13 = this.f4261b[r12].r(r10);
        if (r13 >= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    public final c D(g r10) {
        if (L(r10.f4417e) == false) goto L5;
        int r11 = this.f4260a - 1;
        int r12 = -1;
        int r13 = -1;
    L6:
        c r14 = null;
        if (r10.f4417e != 1) goto L15;
        int r15 = this.f4262c.n();
        int r16 = Channel.UNLIMITED;
    L9:
        if (r11 == r12) goto L14;
        c r17 = this.f4261b[r11];
        int r18 = r17.n(r15);
        if (r18 >= r16) goto L13;
        r14 = r17;
        r16 = r18;
    L13:
        r11 = r11 + r13;
        goto L9
    L14:
        return r14;
    L15:
        int r19 = this.f4262c.i();
        int r20 = Integer.MIN_VALUE;
    L16:
        if (r11 == r12) goto L21;
        c r21 = this.f4261b[r11];
        int r22 = r21.r(r19);
        if (r22 <= r20) goto L20;
        r14 = r21;
        r20 = r22;
    L20:
        r11 = r11 + r13;
        goto L16
    L21:
        return r14;
    L5:
        r12 = this.f4260a;
        r11 = 0;
        r13 = 1;
        goto L6
    }

    public int E() {
        return this.f4260a;
    }

    public final void F(int r10, int r11, int r12) {
        if (this.f4268i == false) goto L5;
        int r13 = y();
    L7:
        if (r12 != 8) goto L12;
        if (r10 >= r11) goto L11;
        int r14 = r11 + 1;
    L10:
        int r15 = r10;
    L13:
        this.f4272m.h(r15);
        if (r12 != 1) goto L16;
        this.f4272m.j(r10, r11);
    L22:
        if (r14 > r13) goto L25;
        return;
    L25:
        if (this.f4268i == false) goto L27;
        int r16 = x();
    L28:
        if (r15 > r16) goto L31;
        requestLayout();
        return;
    L31:
        return;
    L27:
        r16 = y();
        goto L28
    L16:
        if (r12 == 2) goto L20;
        if (r12 != 8) goto L22;
        this.f4272m.k(r10, 1);
        this.f4272m.j(r11, 1);
        goto L22
    L20:
        this.f4272m.k(r10, r11);
        goto L22
    L11:
        r14 = r10 + 1;
        r15 = r11;
        goto L13
    L12:
        r14 = r10 + r11;
        goto L10
    L5:
        r13 = x();
        goto L7
    }

    public View G() {
        int r10 = getChildCount();
        int r11 = r10 - 1;
        BitSet r12 = new BitSet(this.f4260a);
        r12.set(0, this.f4260a, true);
        int r13 = -1;
        if (this.f4264e == 1) goto L5;
    L7:
        byte r14 = -1;
    L9:
        if (this.f4268i == false) goto L11;
        r10 = -1;
    L12:
        if (r11 >= r10) goto L14;
        r13 = 1;
    L14:
        if (r11 == r10) goto L47;
        View r15 = getChildAt(r11);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r12.get(r16.f4284a.f4300e) == false) goto L22;
        if (h(r16.f4284a) == true) goto L19;
        r12.clear(r16.f4284a.f4300e);
        goto L22
    L19:
        return r15;
    L22:
        if (r16.f4285b == true) goto L46;
        int r17 = r11 + r13;
        if (r17 == r10) goto L46;
        View r18 = getChildAt(r17);
        if (this.f4268i == false) goto L33;
        int r19 = this.f4262c.d(r15);
        int r110 = this.f4262c.d(r18);
        if (r19 < r110) goto L30;
        if (r19 != r110) goto L46;
    L38:
        if ((r16.f4284a.f4300e - ((LayoutParams) r18.getLayoutParams()).f4284a.f4300e) >= 0) goto L40;
        boolean r20 = true;
    L41:
        if (r14 >= 0) goto L43;
        boolean r21 = true;
    L44:
        if (r20 == r21) goto L46;
        return r15;
    L43:
        r21 = false;
        goto L44
    L40:
        r20 = false;
        goto L41
    L30:
        return r15;
    L33:
        int r111 = this.f4262c.g(r15);
        int r112 = this.f4262c.g(r18);
        if (r111 > r112) goto L35;
        if (r111 != r112) goto L46;
    L35:
        return r15;
    L46:
        r11 = r11 + r13;
        goto L14
    L47:
        return null;
    L11:
        r11 = 0;
        goto L12
    L5:
        if (isLayoutRTL() == false) goto L7;
        r14 = 1;
        goto L9
    }

    public void H() {
        this.f4272m.b();
        requestLayout();
    }

    public final void J(View r10, LayoutParams r11, boolean r12) {
        if (r11.f4285b == false) goto L9;
        if (this.f4264e != 1) goto L7;
        I(r10, this.f4277r, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r11).height, true), r12);
        return;
    L7:
        I(r10, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r11).width, true), this.f4277r, r12);
        return;
    L9:
        if (this.f4264e != 1) goto L11;
        I(r10, RecyclerView.LayoutManager.getChildMeasureSpec(this.f4265f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) r11).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r11).height, true), r12);
        return;
    L11:
        I(r10, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r11).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f4265f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) r11).height, false), r12);
    }

    public final void K(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        b r13 = this.f4279t;
        if (this.f4276q != null) goto L7;
        if (this.f4270k != (-1)) goto L7;
    L10:
        boolean r14 = true;
        if (r13.f4293e == true) goto L13;
    L18:
        boolean r15 = true;
    L19:
        if (r15 == false) goto L26;
        r13.c();
        if (this.f4276q == null) goto L23;
        b(r13);
    L24:
        Y(r11, r13);
        r13.f4293e = true;
        goto L26
    L23:
        S();
        r13.f4291c = this.f4268i;
    L26:
        if (this.f4276q != null) goto L35;
        if (this.f4270k != (-1)) goto L35;
        if (r13.f4291c == this.f4274o) goto L32;
    L33:
        this.f4272m.b();
        r13.f4292d = true;
        goto L35
    L32:
        if (isLayoutRTL() != this.f4275p) goto L33;
    L35:
        if (getChildCount() <= 0) goto L62;
        SavedState r16 = this.f4276q;
        if (r16 == null) goto L41;
        if (r16.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r13.f4292d == false) goto L49;
        int r17 = 0;
    L44:
        if (r17 >= this.f4260a) goto L62;
        this.f4261b[r17].e();
        int r18 = r13.f4290b;
        if (r18 == Integer.MIN_VALUE) goto L48;
        this.f4261b[r17].x(r18);
    L48:
        r17 = r17 + 1;
        goto L44
    L49:
        if (r15 == false) goto L51;
    L57:
        int r19 = 0;
    L59:
        if (r19 >= this.f4260a) goto L61;
        this.f4261b[r19].b(this.f4268i, r13.f4290b);
        r19 = r19 + 1;
        goto L59
    L61:
        this.f4279t.d(this.f4261b);
        goto L62
    L51:
        if (this.f4279t.f4294f == null) goto L57;
        int r20 = 0;
    L55:
        if (r20 >= this.f4260a) goto L62;
        c r21 = this.f4261b[r20];
        r21.e();
        r21.x(this.f4279t.f4294f[r20]);
        r20 = r20 + 1;
    L62:
        detachAndScrapAttachedViews(r10);
        this.f4266g.f4413a = false;
        this.f4280u = false;
        a0(this.f4263d.o());
        Z(r13.f4289a, r11);
        if (r13.f4291c == false) goto L65;
        T(-1);
        o(r10, this.f4266g, r11);
        T(1);
        g r22 = this.f4266g;
        r22.f4415c = r13.f4289a + r22.f4416d;
        o(r10, r22, r11);
    L66:
        R();
        if (getChildCount() > 0) goto L69;
    L72:
        if (r12 == true) goto L74;
    L86:
        r14 = false;
    L88:
        if (r11.f() == false) goto L90;
        this.f4279t.c();
    L90:
        this.f4274o = r13.f4291c;
        this.f4275p = isLayoutRTL();
        if (r14 == false) goto L99;
        this.f4279t.c();
        K(r10, r11, false);
        return;
    L99:
        return;
    L74:
        if (r11.f() == true) goto L86;
        if (this.f4273n == 0) goto L86;
        if (getChildCount() <= 0) goto L86;
        if (this.f4280u == false) goto L82;
    L83:
        removeCallbacks(this.f4283x);
        if (g() == false) goto L86;
    L82:
        if (G() == null) goto L86;
    L69:
        if (this.f4268i == false) goto L71;
        v(r10, r11, true);
        w(r10, r11, false);
        goto L72
    L71:
        w(r10, r11, true);
        v(r10, r11, false);
        goto L72
    L65:
        T(1);
        o(r10, this.f4266g, r11);
        T(-1);
        g r23 = this.f4266g;
        r23.f4415c = r13.f4289a + r23.f4416d;
        o(r10, r23, r11);
        goto L66
    L13:
        if (this.f4270k != (-1)) goto L18;
        if (this.f4276q != null) goto L18;
        r15 = false;
    L7:
        if (r11.c() != 0) goto L10;
        removeAndRecycleAllViews(r10);
        r13.c();
    }

    public final boolean L(int r10) {
        if (this.f4264e != 0) goto L11;
        if (r10 != (-1)) goto L6;
        boolean r11 = true;
    L8:
        if (r11 != this.f4268i) goto L10;
        return false;
    L10:
        return true;
    L6:
        r11 = false;
        goto L8
    L11:
        if (r10 != (-1)) goto L13;
        boolean r12 = true;
    L15:
        if (r12 != this.f4268i) goto L17;
        boolean r13 = true;
    L19:
        if (r13 == isLayoutRTL()) goto L21;
        return false;
    L21:
        return true;
    L17:
        r13 = false;
        goto L19
    L13:
        r12 = false;
        goto L15
    }

    public void M(int r10, RecyclerView.State r11) {
        if (r10 <= 0) goto L5;
        int r12 = y();
        int r13 = 1;
    L6:
        this.f4266g.f4413a = true;
        Z(r12, r11);
        T(r13);
        g r14 = this.f4266g;
        r14.f4415c = r12 + r14.f4416d;
        r14.f4414b = Math.abs(r10);
        return;
    L5:
        r12 = x();
        r13 = -1;
        goto L6
    }

    public final void N(View r10) {
        int r11 = this.f4260a - 1;
    L3:
        if (r11 < 0) goto L5;
        this.f4261b[r11].w(r10);
        r11 = r11 - 1;
        goto L3
    }

    public final void O(RecyclerView.Recycler r10, g r11) {
        if (r11.f4413a == true) goto L5;
        return;
    L5:
        if (r11.f4421i == false) goto L8;
        return;
    L8:
        if (r11.f4414b != 0) goto L14;
        if (r11.f4417e != (-1)) goto L12;
        P(r10, r11.f4419g);
        return;
    L12:
        Q(r10, r11.f4418f);
        return;
    L14:
        if (r11.f4417e != (-1)) goto L20;
        int r12 = r11.f4418f;
        int r13 = r12 - A(r12);
        if (r13 >= 0) goto L18;
        int r14 = r11.f4419g;
    L19:
        P(r10, r14);
        return;
    L18:
        r14 = r11.f4419g - Math.min(r13, r11.f4414b);
        goto L19
    L20:
        int r15 = B(r11.f4419g) - r11.f4419g;
        if (r15 >= 0) goto L23;
        int r16 = r11.f4418f;
    L24:
        Q(r10, r16);
        return;
    L23:
        int r17 = r11.f4418f;
        r16 = Math.min(r15, r11.f4414b) + r17;
        goto L24
    }

    public final void P(RecyclerView.Recycler r10, int r11) {
        int r12 = getChildCount() - 1;
    L3:
        if (r12 < 0) goto L25;
        View r13 = getChildAt(r12);
        if (this.f4262c.g(r13) < r11) goto L34;
        if (this.f4262c.r(r13) < r11) goto L35;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r14.f4285b == false) goto L21;
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r16 >= this.f4260a) goto L18;
        if (this.f4261b[r16].f4296a.size() == 1) goto L15;
        r16 = r16 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r15 >= this.f4260a) goto L24;
        this.f4261b[r15].u();
        r15 = r15 + 1;
    L24:
        removeAndRecycleView(r13, r10);
        r12 = r12 - 1;
        goto L3
    L21:
        if (r14.f4284a.f4296a.size() == 1) goto L22;
        r14.f4284a.u();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void Q(RecyclerView.Recycler r10, int r11) {
    L3:
        if (getChildCount() <= 0) goto L25;
        int r12 = 0;
        View r13 = getChildAt(0);
        if (this.f4262c.d(r13) > r11) goto L34;
        if (this.f4262c.q(r13) > r11) goto L35;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r14.f4285b == false) goto L21;
        int r15 = 0;
    L12:
        if (r15 >= this.f4260a) goto L18;
        if (this.f4261b[r15].f4296a.size() == 1) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r12 >= this.f4260a) goto L24;
        this.f4261b[r12].v();
        r12 = r12 + 1;
    L24:
        removeAndRecycleView(r13, r10);
        goto L3
    L21:
        if (r14.f4284a.f4296a.size() == 1) goto L22;
        r14.f4284a.v();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void R() {
        if (this.f4263d.l() != 1073741824) goto L5;
        return;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
        float r12 = 0.0f;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L15;
        View r14 = getChildAt(r13);
        float r15 = this.f4263d.e(r14);
        if (r15 < r12) goto L14;
        if (((LayoutParams) r14.getLayoutParams()).a() == false) goto L13;
        r15 = (r15 * 1.0f) / this.f4260a;
    L13:
        r12 = Math.max(r12, r15);
    L14:
        r13 = r13 + 1;
        goto L6
    L15:
        int r16 = this.f4265f;
        int r17 = Math.round(r12 * this.f4260a);
        if (this.f4263d.l() != Integer.MIN_VALUE) goto L18;
        r17 = Math.min(r17, this.f4263d.o());
    L18:
        a0(r17);
        if (this.f4265f != r16) goto L21;
        return;
    L21:
        if (r11 >= r10) goto L35;
        View r18 = getChildAt(r11);
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        if (r19.f4285b == true) goto L34;
        if (isLayoutRTL() == true) goto L28;
    L30:
        int r20 = r19.f4284a.f4300e;
        int r21 = this.f4265f * r20;
        int r22 = r20 * r16;
        if (this.f4264e != 1) goto L33;
        r18.offsetLeftAndRight(r21 - r22);
        goto L34
    L33:
        r18.offsetTopAndBottom(r21 - r22);
        goto L34
    L28:
        if (this.f4264e != 1) goto L30;
        int r23 = this.f4260a;
        int r24 = r19.f4284a.f4300e;
        r18.offsetLeftAndRight(((-((r23 - 1) - r24)) * this.f4265f) - ((-((r23 - 1) - r24)) * r16));
    L34:
        r11 = r11 + 1;
        goto L21
    }

    public final void T(int r10) {
        g r11 = this.f4266g;
        r11.f4417e = r10;
        boolean r12 = this.f4268i;
        int r13 = 1;
        if (r10 != (-1)) goto L5;
        boolean r14 = true;
    L6:
        if (r12 == r14) goto L9;
        r13 = -1;
    L9:
        r11.f4416d = r13;
        return;
    L5:
        r14 = false;
        goto L6
    }

    public void U(int r10) {
        assertNotInLayoutOrScroll(null);
        if (r10 == this.f4260a) goto L11;
        H();
        this.f4260a = r10;
        this.f4269j = new BitSet(this.f4260a);
        this.f4261b = new c[this.f4260a];
        int r11 = 0;
    L6:
        if (r11 >= this.f4260a) goto L8;
        this.f4261b[r11] = new c(this, r11);
        r11 = r11 + 1;
        goto L6
    L8:
        requestLayout();
        return;
    }

    public final void V(int r10, int r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.f4260a) goto L10;
        if (this.f4261b[r12].f4296a.isEmpty() == true) goto L9;
        b0(this.f4261b[r12], r10, r11);
    L9:
        r12 = r12 + 1;
        goto L4
    }

    public final boolean W(RecyclerView.State r10, b r11) {
        if (this.f4274o == false) goto L5;
        int r12 = u(r10.c());
    L6:
        r11.f4289a = r12;
        r11.f4290b = Integer.MIN_VALUE;
        return true;
    L5:
        r12 = p(r10.c());
        goto L6
    }

    public boolean X(RecyclerView.State r10, b r11) {
        boolean r12 = false;
        if (r10.f() == true) goto L60;
        int r13 = this.f4270k;
        if (r13 == (-1)) goto L60;
        if (r13 >= 0) goto L10;
    L59:
        this.f4270k = -1;
        this.f4271l = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r13 >= r10.c()) goto L59;
        SavedState r14 = this.f4276q;
        if (r14 != null) goto L15;
    L20:
        View r15 = findViewByPosition(this.f4270k);
        if (r15 != null) goto L23;
        int r16 = this.f4270k;
        r11.f4289a = r16;
        int r17 = this.f4271l;
        if (r17 == Integer.MIN_VALUE) goto L53;
        r11.b(r17);
    L57:
        r11.f4292d = true;
    L58:
        return true;
    L53:
        if (f(r16) != 1) goto L55;
        r12 = true;
    L55:
        r11.f4291c = r12;
        r11.a();
        goto L57
    L23:
        if (this.f4268i == false) goto L25;
        int r18 = y();
    L26:
        r11.f4289a = r18;
        if (this.f4271l == Integer.MIN_VALUE) goto L34;
        if (r11.f4291c == false) goto L31;
        r11.f4290b = (this.f4262c.i() - this.f4271l) - this.f4262c.d(r15);
    L32:
        return true;
    L31:
        r11.f4290b = (this.f4262c.n() + this.f4271l) - this.f4262c.g(r15);
        goto L32
    L34:
        if (this.f4262c.e(r15) > this.f4262c.o()) goto L36;
        int r19 = this.f4262c.g(r15) - this.f4262c.n();
        if (r19 >= 0) goto L45;
        r11.f4290b = -r19;
        return true;
    L45:
        int r20 = this.f4262c.i() - this.f4262c.d(r15);
        if (r20 >= 0) goto L49;
        r11.f4290b = r20;
        return true;
    L49:
        r11.f4290b = Integer.MIN_VALUE;
        goto L58
    L36:
        if (r11.f4291c == false) goto L38;
        int r21 = this.f4262c.i();
    L39:
        r11.f4290b = r21;
        return true;
    L38:
        r21 = this.f4262c.n();
        goto L39
    L25:
        r18 = x();
        goto L26
    L15:
        if (r14.mAnchorPosition == (-1)) goto L20;
        if (r14.mSpanOffsetsSize < 1) goto L20;
        r11.f4290b = Integer.MIN_VALUE;
        r11.f4289a = this.f4270k;
    L60:
        return false;
    }

    public void Y(RecyclerView.State r10, b r11) {
        if (X(r10, r11) == false) goto L6;
        return;
    L6:
        if (W(r10, r11) == false) goto L8;
        return;
    L8:
        r11.a();
        r11.f4289a = 0;
    }

    public final void Z(int r10, RecyclerView.State r11) {
        g r12 = this.f4266g;
        boolean r13 = false;
        r12.f4414b = 0;
        r12.f4415c = r10;
        if (isSmoothScrolling() == false) goto L13;
        int r14 = r11.d();
        if (r14 == (-1)) goto L13;
        boolean r15 = this.f4268i;
        if (r14 >= r10) goto L9;
        boolean r16 = true;
    L10:
        if (r15 != r16) goto L12;
        int r17 = this.f4262c.o();
        int r18 = 0;
    L15:
        if (getClipToPadding() == false) goto L17;
        this.f4266g.f4418f = this.f4262c.n() - r18;
        this.f4266g.f4419g = this.f4262c.i() + r17;
    L18:
        g r19 = this.f4266g;
        r19.f4420h = false;
        r19.f4413a = true;
        if (this.f4262c.l() == 0) goto L21;
    L23:
        r19.f4421i = r13;
        return;
    L21:
        if (this.f4262c.h() != 0) goto L23;
        r13 = true;
        goto L23
    L17:
        this.f4266g.f4419g = this.f4262c.h() + r17;
        this.f4266g.f4418f = -r18;
        goto L18
    L12:
        r18 = this.f4262c.o();
        r17 = 0;
        goto L15
    L9:
        r16 = false;
    L13:
        r17 = 0;
        r18 = 0;
        goto L15
    }

    public final void a(View r10) {
        int r11 = this.f4260a - 1;
    L3:
        if (r11 < 0) goto L5;
        this.f4261b[r11].a(r10);
        r11 = r11 - 1;
        goto L3
    }

    public void a0(int r10) {
        this.f4265f = r10 / this.f4260a;
        this.f4277r = View.MeasureSpec.makeMeasureSpec(r10, this.f4263d.l());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r10) {
        if (this.f4276q != null) goto L6;
        super.assertNotInLayoutOrScroll(r10);
        return;
    }

    public final void b(b r10) {
        SavedState r11 = this.f4276q;
        int r12 = r11.mSpanOffsetsSize;
        if (r12 > 0) goto L5;
    L18:
        SavedState r13 = this.f4276q;
        this.f4275p = r13.mLastLayoutRTL;
        setReverseLayout(r13.mReverseLayout);
        S();
        SavedState r14 = this.f4276q;
        int r15 = r14.mAnchorPosition;
        if (r15 == (-1)) goto L21;
        this.f4270k = r15;
        r10.f4291c = r14.mAnchorLayoutFromEnd;
    L23:
        if (r14.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r16 = this.f4272m;
        r16.f4286a = r14.mSpanLookup;
        r16.f4287b = r14.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r10.f4291c = this.f4268i;
        goto L23
    L5:
        if (r12 != this.f4260a) goto L17;
        int r17 = 0;
    L8:
        if (r17 >= this.f4260a) goto L18;
        this.f4261b[r17].e();
        SavedState r18 = this.f4276q;
        int r19 = r18.mSpanOffsets[r17];
        if (r19 == Integer.MIN_VALUE) goto L16;
        if (r18.mAnchorLayoutFromEnd == false) goto L15;
        int r20 = this.f4262c.i();
    L14:
        r19 = r19 + r20;
        goto L16
    L15:
        r20 = this.f4262c.n();
    L16:
        this.f4261b[r17].x(r19);
        r17 = r17 + 1;
        goto L8
    L17:
        r11.invalidateSpanInfo();
        SavedState r21 = this.f4276q;
        r21.mAnchorPosition = r21.mVisibleAnchorPosition;
        goto L18
    }

    public final void b0(c r10, int r11, int r12) {
        int r13 = r10.l();
        if (r11 != (-1)) goto L8;
        if ((r10.q() + r13) > r12) goto L11;
        this.f4269j.set(r10.f4300e, false);
        return;
    L11:
        return;
    L8:
        if ((r10.m() - r13) < r12) goto L13;
        this.f4269j.set(r10.f4300e, false);
        return;
    }

    public boolean c() {
        int r10 = this.f4261b[0].n(Integer.MIN_VALUE);
        int r11 = 1;
    L4:
        if (r11 >= this.f4260a) goto L9;
        if (this.f4261b[r11].n(Integer.MIN_VALUE) != r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f4264e != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f4264e == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r10, int r11, RecyclerView.State r12, RecyclerView.LayoutManager.LayoutPrefetchRegistry r13) {
        if (this.f4264e == 0) goto L7;
        r10 = r11;
    L7:
        if (getChildCount() == 0) goto L31;
        if (r10 == 0) goto L37;
        M(r10, r12);
        int[] r14 = this.f4282w;
        if (r14 != null) goto L13;
    L14:
        this.f4282w = new int[this.f4260a];
    L15:
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L17:
        if (r16 >= this.f4260a) goto L26;
        g r18 = this.f4266g;
        if (r18.f4416d != (-1)) goto L22;
        int r19 = r18.f4418f;
        int r20 = this.f4261b[r16].r(r19);
    L21:
        int r21 = r19 - r20;
        if (r21 < 0) goto L25;
        this.f4282w[r17] = r21;
        r17 = r17 + 1;
    L25:
        r16 = r16 + 1;
        goto L17
    L22:
        r19 = this.f4261b[r16].n(r18.f4419g);
        r20 = this.f4266g.f4419g;
        goto L21
    L26:
        Arrays.sort(this.f4282w, 0, r17);
    L27:
        if (r15 >= r17) goto L38;
        if (this.f4266g.a(r12) == false) goto L39;
        r13.addPosition(this.f4266g.f4415c, this.f4282w[r15]);
        g r22 = this.f4266g;
        r22.f4415c += r22.f4416d;
        r15 = r15 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r14.length >= this.f4260a) goto L15;
    L37:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r10) {
        return i(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r10) {
        return j(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r10) {
        return k(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r10) {
        int r11 = f(r10);
        PointF r12 = new PointF();
        if (r11 != 0) goto L7;
        return null;
    L7:
        if (this.f4264e != 0) goto L9;
        r12.x = r11;
        r12.y = 0.0f;
    L10:
        return r12;
    L9:
        r12.x = 0.0f;
        r12.y = r11;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r10) {
        return i(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r10) {
        return j(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r10) {
        return k(r10);
    }

    public boolean d() {
        int r10 = this.f4261b[0].r(Integer.MIN_VALUE);
        int r11 = 1;
    L4:
        if (r11 >= this.f4260a) goto L9;
        if (this.f4261b[r11].r(Integer.MIN_VALUE) != r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public final void e(View r10, LayoutParams r11, g r12) {
        if (r12.f4417e != 1) goto L9;
        if (r11.f4285b == false) goto L7;
        a(r10);
        return;
    L7:
        r11.f4284a.a(r10);
        return;
    L9:
        if (r11.f4285b == false) goto L11;
        N(r10);
        return;
    L11:
        r11.f4284a.w(r10);
    }

    public final int f(int r10) {
        if (getChildCount() != 0) goto L9;
        if (this.f4268i == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r10 >= x()) goto L11;
        boolean r11 = true;
    L13:
        if (r11 == this.f4268i) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r11 = false;
        goto L13
    }

    public boolean g() {
        if (getChildCount() != 0) goto L5;
    L36:
        return false;
    L5:
        if (this.f4273n == 0) goto L36;
        if (isAttachedToWindow() == false) goto L36;
        if (this.f4268i == false) goto L12;
        int r10 = y();
        int r11 = x();
    L14:
        if (r10 != 0) goto L20;
        if (G() == null) goto L20;
        this.f4272m.b();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L20:
        if (this.f4280u == true) goto L23;
        return false;
    L23:
        if (this.f4268i == false) goto L25;
        int r12 = -1;
    L26:
        int r13 = r11 + 1;
        LazySpanLookup.FullSpanItem r14 = this.f4272m.e(r10, r13, r12, true);
        if (r14 != null) goto L30;
        this.f4280u = false;
        this.f4272m.d(r13);
        return false;
    L30:
        LazySpanLookup.FullSpanItem r15 = this.f4272m.e(r10, r14.mPosition, r12 * (-1), true);
        if (r15 != null) goto L33;
        this.f4272m.d(r14.mPosition);
    L34:
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L33:
        this.f4272m.d(r15.mPosition + 1);
        goto L34
    L25:
        r12 = 1;
        goto L26
    L12:
        r10 = x();
        r11 = y();
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f4264e != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
        return new LayoutParams(r10, r11);
    }

    public final boolean h(c r10) {
        if (this.f4268i == false) goto L9;
        if (r10.m() >= this.f4262c.i()) goto L12;
        ArrayList r11 = r10.f4296a;
        return !r10.p((View) r11.get(r11.size() - 1)).f4285b;
    L12:
        return false;
    L9:
        if (r10.q() <= this.f4262c.n()) goto L12;
        return !r10.p((View) r10.f4296a.get(0)).f4285b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        if (this.f4273n == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final LazySpanLookup.FullSpanItem l(int r10) {
        LazySpanLookup.FullSpanItem r11 = new LazySpanLookup.FullSpanItem();
        r11.mGapPerSpan = new int[this.f4260a];
        int r12 = 0;
    L4:
        if (r12 >= this.f4260a) goto L6;
        r11.mGapPerSpan[r12] = r10 - this.f4261b[r12].n(r10);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public final LazySpanLookup.FullSpanItem m(int r10) {
        LazySpanLookup.FullSpanItem r11 = new LazySpanLookup.FullSpanItem();
        r11.mGapPerSpan = new int[this.f4260a];
        int r12 = 0;
    L4:
        if (r12 >= this.f4260a) goto L6;
        r11.mGapPerSpan[r12] = this.f4261b[r12].r(r10) - r10;
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public final void n() {
        this.f4262c = OrientationHelper.b(this, this.f4264e);
        this.f4263d = OrientationHelper.b(this, 1 - this.f4264e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int o(RecyclerView.Recycler r17, g r18, RecyclerView.State r19) {
        ?? r10 = 0;
        this.f4269j.set(0, this.f4260a, true);
        if (this.f4266g.f4421i == false) goto L10;
        if (r18.f4417e != 1) goto L8;
        int r11 = Channel.UNLIMITED;
    L7:
        int r12 = r11;
        V(r18.f4417e, r12);
        if (this.f4268i == false) goto L17;
        int r13 = this.f4262c.i();
    L16:
        int r14 = r13;
        ?? r15 = false;
    L20:
        if (r18.a(r19) == false) goto L26;
        if (this.f4266g.f4421i == false) goto L24;
    L27:
        View r16 = r18.b(r17);
        LayoutParams r110 = (LayoutParams) r16.getLayoutParams();
        int r20 = r110.getViewLayoutPosition();
        int r21 = this.f4272m.g(r20);
        if (r21 != (-1)) goto L30;
        ?? r22 = 1;
    L31:
        if (r22 != 0) goto L33;
        c r23 = this.f4261b[r21];
    L37:
        c r111 = r23;
        r110.f4284a = r111;
        if (r18.f4417e != 1) goto L42;
        addView(r16);
    L43:
        J(r16, r110, r10);
        if (r18.f4417e != 1) goto L56;
        if (r110.f4285b == false) goto L48;
        int r24 = z(r14);
    L49:
        int r25 = this.f4262c.e(r16) + r24;
        if (r22 != 0) goto L52;
    L54:
        int r26 = r25;
        int r27 = r24;
    L66:
        if (r110.f4285b == true) goto L68;
    L81:
        e(r16, r110, r18);
        if (isLayoutRTL() == false) goto L91;
        if (this.f4264e != 1) goto L91;
        if (r110.f4285b == false) goto L88;
        int r28 = this.f4263d.i();
    L89:
        int r29 = r28;
        int r30 = r28 - this.f4263d.e(r16);
    L96:
        if (this.f4264e != 1) goto L98;
        layoutDecoratedWithMargins(r16, r30, r27, r29, r26);
    L100:
        if (r110.f4285b == false) goto L102;
        V(this.f4266g.f4417e, r12);
    L103:
        O(r17, this.f4266g);
        if (this.f4266g.f4420h == true) goto L106;
    L110:
        boolean r31 = false;
    L112:
        r10 = r31;
        r15 = true;
        goto L20
    L106:
        if (r16.hasFocusable() == false) goto L110;
        if (r110.f4285b == false) goto L111;
        this.f4269j.clear();
        goto L110
    L111:
        r31 = false;
        this.f4269j.set(r111.f4300e, false);
        goto L112
    L102:
        b0(r111, this.f4266g.f4417e, r12);
        goto L103
    L98:
        layoutDecoratedWithMargins(r16, r27, r30, r26, r29);
        goto L100
    L88:
        r28 = this.f4263d.i() - (((this.f4260a - 1) - r111.f4300e) * this.f4265f);
    L91:
        if (r110.f4285b == false) goto L93;
        int r32 = this.f4263d.n();
    L94:
        r30 = r32;
        r29 = this.f4263d.e(r16) + r32;
        goto L96
    L93:
        r32 = (r111.f4300e * this.f4265f) + this.f4263d.n();
        goto L94
    L68:
        if (r18.f4416d != (-1)) goto L81;
        if (r22 == 0) goto L72;
        this.f4280u = true;
        goto L81
    L72:
        if (r18.f4417e != 1) goto L75;
        boolean r33 = c();
    L76:
        if ((!r33) == false) goto L81;
        LazySpanLookup.FullSpanItem r34 = this.f4272m.f(r20);
        if (r34 == null) goto L80;
        r34.mHasUnwantedGapAfter = true;
    L80:
        this.f4280u = true;
        goto L81
    L75:
        r33 = d();
        goto L76
    L52:
        if (r110.f4285b == false) goto L54;
        LazySpanLookup.FullSpanItem r35 = l(r24);
        r35.mGapDir = -1;
        r35.mPosition = r20;
        this.f4272m.a(r35);
        goto L54
    L48:
        r24 = r111.n(r14);
        goto L49
    L56:
        if (r110.f4285b == false) goto L58;
        int r36 = C(r14);
    L59:
        r27 = r36 - this.f4262c.e(r16);
        if (r22 != 0) goto L62;
    L64:
        r26 = r36;
        goto L66
    L62:
        if (r110.f4285b == false) goto L64;
        LazySpanLookup.FullSpanItem r37 = m(r36);
        r37.mGapDir = 1;
        r37.mPosition = r20;
        this.f4272m.a(r37);
        goto L64
    L58:
        r36 = r111.r(r14);
        goto L59
    L42:
        addView(r16, r10);
        goto L43
    L33:
        if (r110.f4285b == false) goto L35;
        r23 = this.f4261b[r10];
    L36:
        this.f4272m.n(r20, r23);
        goto L37
    L35:
        r23 = D(r18);
        goto L36
    L30:
        r22 = r10;
        goto L31
    L24:
        if (this.f4269j.isEmpty() == false) goto L27;
    L26:
        ?? r38 = r10;
        if (r15 == true) goto L116;
        O(r17, this.f4266g);
    L116:
        if (this.f4266g.f4417e != (-1)) goto L118;
        int r39 = this.f4262c.n() - C(this.f4262c.n());
    L119:
        if (r39 <= 0) goto L122;
        return Math.min(r18.f4414b, r39);
    L122:
        return r38 == true ? 1 : 0;
    L118:
        r39 = z(this.f4262c.i()) - this.f4262c.i();
        goto L119
    L17:
        r13 = this.f4262c.n();
        goto L16
    L8:
        r11 = Integer.MIN_VALUE;
        goto L7
    L10:
        if (r18.f4417e != 1) goto L12;
        r11 = r18.f4419g + r18.f4414b;
        goto L7
    L12:
        r11 = r18.f4418f - r18.f4414b;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r10) {
        super.offsetChildrenHorizontal(r10);
        int r11 = 0;
    L4:
        if (r11 >= this.f4260a) goto L6;
        this.f4261b[r11].t(r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r10) {
        super.offsetChildrenVertical(r10);
        int r11 = 0;
    L4:
        if (r11 >= this.f4260a) goto L6;
        this.f4261b[r11].t(r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter r10, RecyclerView.Adapter r11) {
        this.f4272m.b();
        int r12 = 0;
    L4:
        if (r12 >= this.f4260a) goto L6;
        this.f4261b[r12].e();
        r12 = r12 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        removeCallbacks(this.f4283x);
        int r12 = 0;
    L4:
        if (r12 >= this.f4260a) goto L6;
        this.f4261b[r12].e();
        r12 = r12 + 1;
        goto L4
    L6:
        r10.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        View r14 = findContainingItemView(r10);
        if (r14 != null) goto L8;
        return null;
    L8:
        S();
        int r15 = convertFocusDirectionToLayoutDirection(r11);
        if (r15 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r16 = (LayoutParams) r14.getLayoutParams();
        boolean r17 = r16.f4285b;
        c r18 = r16.f4284a;
        if (r15 != 1) goto L14;
        int r19 = y();
    L15:
        Z(r19, r13);
        T(r15);
        g r20 = this.f4266g;
        r20.f4415c = r20.f4416d + r19;
        r20.f4414b = (int) (this.f4262c.o() * 0.33333334f);
        g r21 = this.f4266g;
        r21.f4420h = true;
        int r22 = 0;
        r21.f4413a = false;
        o(r12, r21, r13);
        this.f4274o = this.f4268i;
        if (r17 == true) goto L22;
        View r110 = r18.o(r19, r15);
        if (r110 == null) goto L22;
        if (r110 == r14) goto L22;
        return r110;
    L22:
        if (L(r15) == false) goto L30;
        int r111 = this.f4260a - 1;
    L24:
        if (r111 < 0) goto L38;
        View r112 = this.f4261b[r111].o(r19, r15);
        if (r112 == null) goto L29;
        if (r112 == r14) goto L29;
        return r112;
    L29:
        r111 = r111 - 1;
    L38:
        boolean r113 = !this.f4267h;
        if (r15 != (-1)) goto L41;
        boolean r114 = true;
    L42:
        if (r113 != r114) goto L44;
        boolean r115 = true;
    L45:
        if (r17 == true) goto L54;
        if (r115 == false) goto L48;
        int r116 = r18.f();
    L49:
        View r117 = findViewByPosition(r116);
        if (r117 == null) goto L54;
        if (r117 == r14) goto L54;
        return r117;
    L48:
        r116 = r18.h();
    L54:
        if (L(r15) == false) goto L69;
        int r118 = this.f4260a - 1;
    L56:
        if (r118 < 0) goto L78;
        if (r118 == r18.f4300e) goto L67;
        if (r115 == false) goto L62;
        int r119 = this.f4261b[r118].f();
    L63:
        View r120 = findViewByPosition(r119);
        if (r120 == null) goto L67;
        if (r120 == r14) goto L67;
        return r120;
    L62:
        r119 = this.f4261b[r118].h();
    L67:
        r118 = r118 - 1;
    L78:
        return null;
    L69:
        if (r22 >= this.f4260a) goto L78;
        if (r115 == false) goto L72;
        int r121 = this.f4261b[r22].f();
    L73:
        View r122 = findViewByPosition(r121);
        if (r122 == null) goto L77;
        if (r122 == r14) goto L77;
        return r122;
    L77:
        r22 = r22 + 1;
        goto L69
    L72:
        r121 = this.f4261b[r22].h();
        goto L73
    L44:
        r115 = false;
        goto L45
    L41:
        r114 = false;
        goto L42
    L30:
        int r123 = 0;
    L32:
        if (r123 >= this.f4260a) goto L38;
        View r124 = this.f4261b[r123].o(r19, r15);
        if (r124 == null) goto L37;
        if (r124 == r14) goto L37;
        return r124;
    L37:
        r123 = r123 + 1;
        goto L32
    L14:
        r19 = x();
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        if (getChildCount() <= 0) goto L13;
        View r11 = r(false);
        View r12 = q(false);
        if (r11 == null) goto L14;
        if (r12 == null) goto L16;
        int r13 = getPosition(r11);
        int r14 = getPosition(r12);
        if (r13 >= r14) goto L11;
        r10.setFromIndex(r13);
        r10.setToIndex(r14);
        return;
    L11:
        r10.setFromIndex(r14);
        r10.setToIndex(r13);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r10, int r11, int r12) {
        F(r11, r12, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r10) {
        this.f4272m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r10, int r11, int r12, int r13) {
        F(r11, r12, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r10, int r11, int r12) {
        F(r11, r12, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r10, int r11, int r12, Object r13) {
        F(r11, r12, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        K(r10, r11, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.f4270k = -1;
        this.f4271l = Integer.MIN_VALUE;
        this.f4276q = null;
        this.f4279t.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == false) goto L9;
        SavedState r11 = (SavedState) r10;
        this.f4276q = r11;
        if (this.f4270k == (-1)) goto L7;
        r11.invalidateAnchorPositionInfo();
        this.f4276q.invalidateSpanInfo();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f4276q != null) goto L5;
        SavedState r10 = new SavedState();
        r10.mReverseLayout = this.f4267h;
        r10.mAnchorLayoutFromEnd = this.f4274o;
        r10.mLastLayoutRTL = this.f4275p;
        LazySpanLookup r11 = this.f4272m;
        int r12 = 0;
        if (r11 == null) goto L11;
        int[] r13 = r11.f4286a;
        if (r13 == null) goto L11;
        r10.mSpanLookup = r13;
        r10.mSpanLookupSize = r13.length;
        r10.mFullSpanItems = r11.f4287b;
    L13:
        if (getChildCount() > 0) goto L15;
        r10.mAnchorPosition = -1;
        r10.mVisibleAnchorPosition = -1;
        r10.mSpanOffsetsSize = 0;
    L32:
        return r10;
    L15:
        if (this.f4274o == false) goto L17;
        int r14 = y();
    L18:
        r10.mAnchorPosition = r14;
        r10.mVisibleAnchorPosition = s();
        int r15 = this.f4260a;
        r10.mSpanOffsetsSize = r15;
        r10.mSpanOffsets = new int[r15];
    L20:
        if (r12 >= this.f4260a) goto L32;
        if (this.f4274o == false) goto L27;
        int r16 = this.f4261b[r12].n(Integer.MIN_VALUE);
        if (r16 == Integer.MIN_VALUE) goto L30;
        int r17 = this.f4262c.i();
    L26:
        r16 = r16 - r17;
    L30:
        r10.mSpanOffsets[r12] = r16;
        r12 = r12 + 1;
        goto L20
    L27:
        r16 = this.f4261b[r12].r(Integer.MIN_VALUE);
        if (r16 == Integer.MIN_VALUE) goto L30;
        r17 = this.f4262c.n();
        goto L26
    L17:
        r14 = x();
    L11:
        r10.mSpanLookupSize = 0;
        goto L13
    L5:
        return new SavedState(this.f4276q);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r10) {
        if (r10 != 0) goto L5;
        g();
        return;
    }

    public final int p(int r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = getPosition(getChildAt(r12));
        if (r13 < 0) goto L8;
        if (r13 >= r10) goto L8;
        return r13;
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        return 0;
    }

    public View q(boolean r10) {
        int r11 = this.f4262c.n();
        int r12 = this.f4262c.i();
        int r13 = getChildCount() - 1;
        View r14 = null;
    L3:
        if (r13 < 0) goto L15;
        View r15 = getChildAt(r13);
        int r16 = this.f4262c.g(r15);
        int r17 = this.f4262c.d(r15);
        if (r17 <= r11) goto L14;
        if (r16 >= r12) goto L14;
        if (r17 <= r12) goto L13;
        if (r10 == false) goto L13;
        if (r14 != null) goto L14;
        r14 = r15;
    L13:
        return r15;
    L14:
        r13 = r13 - 1;
        goto L3
    L15:
        return r14;
    }

    public View r(boolean r10) {
        int r11 = this.f4262c.n();
        int r12 = this.f4262c.i();
        int r13 = getChildCount();
        View r14 = null;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L15;
        View r16 = getChildAt(r15);
        int r17 = this.f4262c.g(r16);
        if (this.f4262c.d(r16) <= r11) goto L14;
        if (r17 >= r12) goto L14;
        if (r17 >= r11) goto L13;
        if (r10 == false) goto L13;
        if (r14 != null) goto L14;
        r14 = r16;
    L13:
        return r16;
    L14:
        r15 = r15 + 1;
        goto L3
    L15:
        return r14;
    }

    public int s() {
        if (this.f4268i == false) goto L5;
        View r10 = q(true);
    L6:
        if (r10 != null) goto L9;
        return -1;
    L9:
        return getPosition(r10);
    L5:
        r10 = r(true);
        goto L6
    }

    public int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L14;
        if (r10 == 0) goto L14;
        M(r10, r12);
        int r13 = o(r11, this.f4266g, r12);
        if (this.f4266g.f4414b < r13) goto L12;
        if (r10 >= 0) goto L11;
        r10 = -r13;
        goto L12
    L11:
        r10 = r13;
    L12:
        this.f4262c.s(-r10);
        this.f4274o = this.f4268i;
        g r14 = this.f4266g;
        r14.f4414b = 0;
        O(r11, r14);
        return r10;
    L14:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return scrollBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        SavedState r11 = this.f4276q;
        if (r11 != null) goto L5;
    L7:
        this.f4270k = r10;
        this.f4271l = Integer.MIN_VALUE;
        requestLayout();
        return;
    L5:
        if (r11.mAnchorPosition == r10) goto L7;
        r11.invalidateAnchorPositionInfo();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return scrollBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r10, int r11, int r12) {
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        if (this.f4264e != 1) goto L5;
        int r15 = RecyclerView.LayoutManager.chooseSize(r12, r10.height() + r14, getMinimumHeight());
        int r16 = RecyclerView.LayoutManager.chooseSize(r11, (this.f4265f * this.f4260a) + r13, getMinimumWidth());
    L6:
        setMeasuredDimension(r16, r15);
        return;
    L5:
        r16 = RecyclerView.LayoutManager.chooseSize(r11, r10.width() + r13, getMinimumWidth());
        r15 = RecyclerView.LayoutManager.chooseSize(r12, (this.f4265f * this.f4260a) + r14, getMinimumHeight());
        goto L6
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r10 != this.f4264e) goto L11;
        return;
    L11:
        this.f4264e = r10;
        OrientationHelper r11 = this.f4262c;
        this.f4262c = this.f4263d;
        this.f4263d = r11;
        requestLayout();
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean r10) {
        assertNotInLayoutOrScroll(null);
        SavedState r11 = this.f4276q;
        if (r11 != null) goto L5;
    L7:
        this.f4267h = r10;
        requestLayout();
        return;
    L5:
        if (r11.mReverseLayout == r10) goto L7;
        r11.mReverseLayout = r10;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        h r13 = new h(r10.getContext());
        r13.setTargetPosition(r12);
        startSmoothScroll(r13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.f4276q != null) goto L5;
        return true;
    L5:
        return false;
    }

    public int[] t(int[] r10) {
        if (r10 != null) goto L5;
        r10 = new int[this.f4260a];
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.f4260a) goto L10;
        r10[r11] = this.f4261b[r11].g();
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        if (r10.length >= this.f4260a) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4260a + ", array size:" + r10.length);
    }

    public final int u(int r10) {
        int r11 = getChildCount() - 1;
    L3:
        if (r11 < 0) goto L9;
        int r12 = getPosition(getChildAt(r11));
        if (r12 < 0) goto L8;
        if (r12 >= r10) goto L8;
        return r12;
    L8:
        r11 = r11 - 1;
        goto L3
    L9:
        return 0;
    }

    public final int updateSpecWithExtra(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        if (r12 != 0) goto L5;
        return r10;
    L5:
        int r13 = View.MeasureSpec.getMode(r10);
        if (r13 == Integer.MIN_VALUE) goto L12;
        if (r13 == 1073741824) goto L12;
        return r10;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r10) - r11) - r12), r13);
    }

    public final void v(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = z(Integer.MIN_VALUE);
        if (r13 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r14 = this.f4262c.i() - r13;
        if (r14 <= 0) goto L12;
        int r15 = r14 - (-scrollBy(-r14, r10, r11));
        if (r12 == false) goto L13;
        if (r15 <= 0) goto L14;
        this.f4262c.s(r15);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void w(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = C(Channel.UNLIMITED);
        if (r13 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r14 = r13 - this.f4262c.n();
        if (r14 <= 0) goto L12;
        int r15 = r14 - scrollBy(r14, r10, r11);
        if (r12 == false) goto L13;
        if (r15 <= 0) goto L14;
        this.f4262c.s(-r15);
        return;
    L14:
        return;
    L13:
        return;
    }

    public int x() {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(0));
    }

    public int y() {
        int r10 = getChildCount();
        if (r10 != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(r10 - 1));
    }

    public final int z(int r10) {
        int r11 = this.f4261b[0].n(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.f4260a) goto L9;
        int r13 = this.f4261b[r12].n(r10);
        if (r13 <= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L7:
        return new LayoutParams(r10);
    }
}
