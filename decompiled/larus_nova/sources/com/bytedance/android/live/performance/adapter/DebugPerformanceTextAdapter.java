package com.bytedance.android.live.performance.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tr0.e;
import vr0.a;

/* JADX INFO: loaded from: classes46.dex */
public class DebugPerformanceTextAdapter extends RecyclerView.Adapter<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f85382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f85383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClipboardManager f85384c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f85383b).size();
    }

    public DebugPerformanceTextAdapter(Context r100) {
        this.f85383b = new ArrayList();
        this.f85382a = r100;
        if (r100 == null) goto L6;
        this.f85384c = (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
        return;
    }

    public final void y2(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.f556806b) == true) goto L28;
        String r101 = r100.f556806b;
        String r102 = r100.f556807c;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        Iterator r103 = ((ArrayList) this.f85383b).iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        a r104 = (a) r103.next();
        if (r104.f556806b.equals(r101) == false) goto L11;
    L16:
        if (r104 != null) goto L19;
        ((ArrayList) this.f85383b).add(r100);
        notifyDataSetChanged();
        return;
    L19:
        if (r102.equals(r104.f556807c) == true) goto L27;
        int r105 = ((ArrayList) this.f85383b).indexOf(r104);
        ListProtector.set(this.f85383b, r105, r100);
        notifyDataSetChanged();
        return;
    L27:
        return;
    L15:
        r104 = null;
        goto L16
    }

    public static void z2(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final TextView r102 = ((e) r100).f547280a;
        if (r102 == null) goto L6;
        a r103 = (a) ListProtector.get(this.f85383b, r101);
        r102.setText(r103.f556806b + ": " + r103.f556807c);
        r102.setOnLongClickListener(new tr0.d(this, r102));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new e(LayoutInflater.from(this.f85382a).inflate(R.layout.item_debug_performance_text, null));
    }
}
