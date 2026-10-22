package aw7;

import android.view.ViewGroup;
import androidx.collection.SieveCacheKt;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.larus.dora.impl.ota.g2.j0;
import java.util.Arrays;
import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends SimpleWrapperAdapter<RecyclerView.ViewHolder> implements bw7.e<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f16584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerViewExpandableItemManager f16585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f16586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f16587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f16590i;

    public final void I2() {
        e r100 = this.f16586e;
        if (r100 == null) goto L11;
        long[] r101 = new long[r100.f16580c];
        int r102 = 0;
    L6:
        if (r102 >= r100.f16580c) goto L8;
        long r103 = r100.f16578a[r102];
        long r104 = ((long) r100.f16579b[r102]) << 32;
        r101[r102] = (r103 & j0.G2_OTA_SPACE_RESERVE_BYTES) | r104;
        r102 = r102 + 1;
        goto L6
    L8:
        Arrays.sort(r101);
        this.f16586e.a(this.f16584c, this.f16585d.f276044i);
        this.f16586e.g(r101);
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        e r100 = this.f16586e;
        return r100.f16580c + r100.f16581d;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public final void z2() {
        I2();
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r110) {
        if (this.f16584c != null) goto L6;
        return -1;
    L6:
        long r100 = this.f16586e.d(r110);
        int r101 = b.b(r100);
        int r102 = (int) (r100 >>> 32);
        if (r102 != (-1)) goto L16;
        long r103 = this.f16584c.getGroupId(r101);
        if (r103 < (-134217728)) goto L15;
        if (r103 > 134217727) goto L15;
        return ((r103 << 28) & 72057593769492480L) | 268435455;
    L15:
        throw new IllegalArgumentException("Group ID value is out of range. (groupId = " + r103 + ")");
    L16:
        long r104 = this.f16584c.getGroupId(r101);
        long r105 = this.f16584c.getChildId(r101, r102);
        if (r104 < (-134217728)) goto L29;
        if (r104 > 134217727) goto L29;
        if (r105 < (-134217728)) goto L27;
        if (r105 > 134217727) goto L27;
        return ((r105 << 0) & 268435455) | ((r104 << 28) & 72057593769492480L);
    L27:
        throw new IllegalArgumentException("Child ID value is out of range. (childId = " + r105 + ")");
    L29:
        throw new IllegalArgumentException("Group ID value is out of range. (groupId = " + r104 + ")");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = 0;
        if (this.f16584c != null) goto L5;
        return 0;
    L5:
        long r102 = this.f16586e.d(r100);
        int r103 = b.b(r102);
        int r104 = (int) (r102 >>> 32);
        if (r104 != (-1)) goto L8;
        this.f16584c.R1();
    L10:
        if ((r101 & Integer.MIN_VALUE) != 0) goto L15;
        if (r104 == (-1)) goto L13;
        return r101;
    L13:
        return r101 | Integer.MIN_VALUE;
    L15:
        throw new IllegalStateException("Illegal view type (type = " + Integer.toHexString(r101) + ")");
    L8:
        r101 = this.f16584c.P(r103, r104);
        goto L10
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public final void A2(int r100, int r101) {
        notifyItemRangeChanged(r100, r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public final void C2(int r100, int r101) {
        I2();
        notifyItemRangeInserted(r100, r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public final void D2(int r110, int r111) {
        if (r111 != 1) goto L27;
        long r100 = this.f16586e.d(r110);
        int r101 = b.b(r100);
        int r102 = (int) (r100 >>> 32);
        int r103 = -1;
        if (r102 != (-1)) goto L17;
        e r104 = this.f16586e;
        long r112 = r104.f16578a[r101 + 0];
        if ((j0.G2_OTA_SPACE_RESERVE_BYTES & r112) == 0) goto L9;
        r104.f16581d -= (int) (r112 & SieveCacheKt.NodeLinkMask);
    L9:
        r104.f16580c--;
        int r105 = r101;
    L10:
        int r106 = r104.f16580c;
        if (r105 >= r106) goto L13;
        long[] r107 = r104.f16578a;
        int r108 = r105 + 1;
        r107[r105] = r107[r108];
        int[] r109 = r104.f16579b;
        r109[r105] = r109[r108];
        r105 = r108;
        goto L10
    L13:
        if (r106 == 0) goto L16;
        r103 = (-1) + r101;
    L16:
        r104.f16582e = Math.min(r104.f16582e, r103);
    L28:
        notifyItemRangeRemoved(r110, r111);
        return;
    L17:
        e r113 = this.f16586e;
        long[] r114 = r113.f16578a;
        long r115 = r114[r101];
        int r116 = (int) (SieveCacheKt.NodeLinkMask & r115);
        if (r102 < 0) goto L26;
        if ((r102 + 1) > r116) goto L26;
        if ((j0.G2_OTA_SPACE_RESERVE_BYTES & r115) == 0) goto L24;
        r113.f16581d--;
    L24:
        r114[r101] = (SieveCacheKt.NodeMetaAndPreviousMask & r115) | ((long) (r116 - 1));
        r113.f16582e = Math.min(r113.f16582e, r101 - 1);
    L26:
        throw new IllegalStateException("Invalid child position removeChildItems(groupPosition = " + r101 + ", childPosition = " + r102 + ", count = 1)");
    L27:
        I2();
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, wv7.c
    public final void E0(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof d) == false) goto L5;
        ((d) r100).j1(-1);
    L5:
        super.E0(r100, r101);
    }

    public final boolean F2(int r100, boolean r101) {
        if (this.f16586e.f(r100) == true) goto L6;
        return false;
    L6:
        if (this.f16584c.v1(r100, r101) == true) goto L9;
        return false;
    L9:
        if (this.f16586e.b(r100) == false) goto L11;
        long r102 = b.a(r100);
        int r103 = this.f16586e.e(r102);
        int r104 = r103 + 1;
        notifyItemRangeRemoved(r104, (int) (this.f16586e.f16578a[r100] & SieveCacheKt.NodeLinkMask));
    L11:
        long r105 = b.a(r100);
        notifyItemChanged(this.f16586e.e(r105), null);
        return true;
    }

    public final boolean G2(int r100, boolean r101) {
        if (this.f16586e.f(r100) == false) goto L6;
        return false;
    L6:
        if (this.f16584c.K0(r100, r101) == true) goto L9;
        return false;
    L9:
        if (this.f16586e.c(r100) == false) goto L11;
        long r102 = b.a(r100);
        int r103 = this.f16586e.e(r102);
        int r104 = r103 + 1;
        notifyItemRangeInserted(r104, (int) (this.f16586e.f16578a[r100] & SieveCacheKt.NodeLinkMask));
    L11:
        long r105 = b.a(r100);
        notifyItemChanged(this.f16586e.e(r105), null);
        return true;
    }

    @Override // bw7.e
    public final void H(RecyclerView.ViewHolder r100, int r101) {
        c r102 = this.f16584c;
        if ((r102 instanceof a) == true) goto L5;
        return;
    L5:
        a r103 = (a) r102;
        if (((int) (this.f16586e.d(r101) >>> 32)) != (-1)) goto L8;
        r103.f();
        return;
    L8:
        r103.c();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        c r102 = this.f16584c;
        if (r102 != null) goto L6;
        return null;
    L6:
        int r103 = Integer.MAX_VALUE & r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L9;
        RecyclerView.ViewHolder r104 = r102.B(r100);
    L11:
        if ((r104 instanceof d) == false) goto L13;
        ((d) r104).j1(-1);
    L13:
        return r104;
    L9:
        r104 = r102.N(r100, r103);
        goto L11
    }

    public f(RecyclerViewExpandableItemManager r100, AbstractExpandableItemAdapter r101, long[] r102) {
        super(r101);
        this.f16587f = -1;
        this.f16588g = -1;
        this.f16589h = -1;
        this.f16590i = -1;
        c r103 = (c) dw7.c.a(r101, c.class);
        this.f16584c = r103;
        if (r103 == null) goto L12;
        if (r100 == null) goto L10;
        this.f16585d = r100;
        e r104 = new e();
        this.f16586e = r104;
        r104.a(r103, r100.f276044i);
        if (r102 == null) goto L13;
        r104.g(r102);
        return;
    L13:
        return;
    L10:
        throw new IllegalArgumentException("manager cannot be null");
    L12:
        throw new IllegalArgumentException("adapter does not implement ExpandableItemAdapter");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public final void E2(int r100, int r101, int r102) {
        I2();
        super.E2(r100, r101, r102);
    }

    @Override // bw7.e
    public final void b0(RecyclerView.ViewHolder r100, int r101, int r102) {
        c r103 = this.f16584c;
        if ((r103 instanceof a) == true) goto L5;
        return;
    L5:
        a r104 = (a) r103;
        if (((int) (this.f16586e.d(r101) >>> 32)) != (-1)) goto L8;
        r104.g();
        return;
    L8:
        r104.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111, List<Object> r112) {
        if (this.f16584c != null) goto L5;
        return;
    L5:
        long r100 = this.f16586e.d(r111);
        int r101 = b.b(r100);
        int r102 = (int) (r100 >>> 32);
        int r103 = r110.getItemViewType() & Integer.MAX_VALUE;
        boolean r104 = true;
        if (r102 != (-1)) goto L8;
        int r105 = 1;
    L10:
        if (this.f16586e.f(r101) == false) goto L13;
        r105 = r105 | 4;
    L13:
        if ((r110 instanceof d) == false) goto L26;
        d r106 = (d) r110;
        int r113 = r106.p3();
        if (r113 != (-1)) goto L18;
    L20:
        if (r113 != (-1)) goto L22;
    L23:
        r105 = r105 | Integer.MIN_VALUE;
    L24:
        r106.j1(r105);
        goto L26
    L22:
        if ((Integer.MAX_VALUE & (r113 ^ r105)) == 0) goto L24;
    L18:
        if (((r113 ^ r105) & 4) == 0) goto L20;
        r105 = r105 | 8;
    L26:
        if ((r110 instanceof zv7.a) == false) goto L64;
        zv7.a r107 = (zv7.a) r110;
        int r108 = this.f16587f;
        if (r108 != (-1)) goto L31;
    L33:
        boolean r114 = false;
    L34:
        int r115 = this.f16589h;
        if (r115 != (-1)) goto L37;
    L39:
        boolean r116 = false;
    L40:
        if (r101 >= r108) goto L42;
    L44:
        boolean r109 = false;
    L45:
        if (r101 == (-1)) goto L50;
        if (r102 < r115) goto L50;
        if (r102 > this.f16590i) goto L50;
        boolean r117 = true;
    L51:
        int r118 = r107.M1();
        if ((r118 & 1) != 0) goto L54;
    L61:
        r104 = false;
    L62:
        if (r104 == false) goto L64;
        r107.k3((r118 | 4) | Integer.MIN_VALUE);
        goto L64
    L54:
        if ((r118 & 4) != 0) goto L61;
        if (r114 == false) goto L57;
        if (r109 == false) goto L61;
    L57:
        if (r116 == false) goto L62;
        if (r116 == false) goto L61;
        if (r117 == false) goto L61;
    L50:
        r117 = false;
        goto L51
    L42:
        if (r101 > this.f16588g) goto L44;
        r109 = true;
        goto L45
    L37:
        if (this.f16590i == (-1)) goto L39;
        r116 = true;
        goto L40
    L31:
        if (this.f16588g == (-1)) goto L33;
        r114 = true;
    L64:
        if (r102 != (-1)) goto L66;
        this.f16584c.a1(r110, r101, r103, r112);
        return;
    L66:
        this.f16584c.f1(r110, r101, r102, r103, r112);
        return;
    L8:
        r105 = 2;
        goto L10
    }

    @Override // bw7.e
    public final cw7.a q2(RecyclerView.ViewHolder r100, int r101, int r102) {
        c r103 = this.f16584c;
        if ((r103 instanceof a) == true) goto L6;
        return null;
    L6:
        if (r101 != (-1)) goto L8;
        return null;
    L8:
        a r104 = (a) r103;
        if (((int) (this.f16586e.d(r101) >>> 32)) != (-1)) goto L12;
        return ((g) r104).b();
    L12:
        return ((g) r104).h();
    }

    public final void H2(int r100, int r110, int r111, Object r112) {
        e r101 = this.f16586e;
        if (r101.f(r100) == false) goto L5;
        int r102 = (int) (SieveCacheKt.NodeLinkMask & r101.f16578a[r100]);
    L6:
        if (r102 <= 0) goto L12;
        if (r110 >= r102) goto L13;
        long r103 = (((long) 0) << 32) | (((long) r100) & BodyPartID.bodyIdMax);
        int r104 = this.f16586e.e(r103);
        if (r104 == (-1)) goto L14;
        notifyItemRangeChanged(r104 + r110, Math.min(r111, r102 - r110), r112);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // bw7.e
    public final int Q1(RecyclerView.ViewHolder r100, int r101, int r102, int r103) {
        c r104 = this.f16584c;
        if ((r104 instanceof a) == true) goto L6;
        return 0;
    L6:
        a r105 = (a) r104;
        if (((int) (this.f16586e.d(r101) >>> 32)) != (-1)) goto L11;
        return r105.e();
    L11:
        return r105.a();
    }
}
