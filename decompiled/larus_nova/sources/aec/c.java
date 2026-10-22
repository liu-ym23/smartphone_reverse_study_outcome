package aec;

import aec.d;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.recyclerview.hive.HiveAdapter;
import com.ss.android.lark.widget.recyclerview.hive.HiveViewHolder;

/* JADX INFO: loaded from: classes38.dex */
public abstract class c<Value, VH extends d> extends a<Value, VH> implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<Pair<Integer, a>> f3129c;

    public abstract void i();

    public c() {
        this.f3129c = new SparseArray();
    }

    @Override // aec.a
    public final e f() {
        d r100 = (d) super.f();
        r100.f3131d = this.f3129c;
        return r100;
    }

    @Override // aec.a
    public final int h() {
        return super.h();
    }

    @Override // aec.a
    public final void g(e r100) {
        d r101 = (d) r100;
        int r102 = this.f3129c.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int r104 = this.f3129c.keyAt(r103);
        Pair<Integer, a> r105 = this.f3129c.valueAt(r103);
        if (r101.f3130c.get(r104) == null) goto L7;
        e r106 = (e) r101.f3130c.get(r104).second;
        ((a) r105.second).g(r106);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = ((Integer) r100.getTag(R.id.hive_cell_tag)).intValue();
        HiveViewHolder r102 = HiveAdapter.z2(r100);
        if (r102 == null) goto L11;
        VH r103 = r102.f448186a;
        if (r103 == 0) goto L12;
        d r104 = (d) r103;
        if (r104.f3131d.get(r101) == null) goto L9;
        ((a) r104.f3131d.get(r101).second).d((e) r104.f3130c.get(r101).second);
        return;
    L9:
        Log.e("HiveGroupCell", "click, not find hiveId corresponding value ,hiveId: " + r101);
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        int r101 = ((Integer) r100.getTag(R.id.hive_cell_tag)).intValue();
        HiveViewHolder r102 = HiveAdapter.z2(r100);
        if (r102 == null) goto L13;
        VH r103 = r102.f448186a;
        if (r103 == 0) goto L14;
        d r104 = (d) r103;
        if (r104.f3131d.get(r101) != null) goto L9;
        Log.e("HiveGroupCell", " longClick, not find hiveId corresponding value ,hiveId: " + r101);
        return false;
    L9:
        return ((a) r104.f3131d.get(r101).second).e((e) r104.f3130c.get(r101).second);
    L14:
        return false;
    L13:
        return false;
    }

    @Override // aec.a
    public final void c(e r100, Object r101) {
        d r102 = (d) r100;
        int r103 = this.f3129c.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        int r105 = this.f3129c.keyAt(r104);
        Pair<Integer, a> r106 = this.f3129c.valueAt(r104);
        int r107 = ((Integer) r106.first).intValue();
        a r108 = (a) r106.second;
        r108.c((e) r102.f3130c.get(r105).second, r101);
        View r109 = r102.f3132a.findViewById(r107);
        r109.setTag(R.id.hive_cell_tag, Integer.valueOf(r105));
        if (r102.f3132a == r109) goto L7;
        r109.setOnClickListener(this);
        r109.setOnLongClickListener(this);
        r108.f3127b = new b(this);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        i();
    }
}
