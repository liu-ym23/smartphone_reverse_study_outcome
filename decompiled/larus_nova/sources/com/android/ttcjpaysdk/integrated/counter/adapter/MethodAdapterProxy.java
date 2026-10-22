package com.android.ttcjpaysdk.integrated.counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H&J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0014H&J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H&J\u0016\u0010\u001e\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 H\u0016R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/MethodAdapterProxy;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", WidgetCostModule.TYPE_INFLATE, "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getInflate", "()Landroid/view/LayoutInflater;", "dataChangedNotify", "", "list", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", e.f25671s, "Lkotlin/Function0;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MethodAdapterProxy {
    private final ArrayList<PaymentMethodInfo> data;
    private final LayoutInflater inflate;

    public abstract int getItemCount();

    public abstract int getItemViewType(int r100);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101);

    public void setClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
    }

    public final ArrayList<PaymentMethodInfo> getData() {
        return this.data;
    }

    public final LayoutInflater getInflate() {
        return this.inflate;
    }

    public MethodAdapterProxy(Context r100) {
        this.data = new ArrayList();
        this.inflate = LayoutInflater.from(r100);
    }

    public void dataChangedNotify(ArrayList<PaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        PaymentMethodInfo r102 = (PaymentMethodInfo) r101.next();
        if (r102.isCollapse.booleanValue() == true) goto L4;
        this.data.add(r102);
        goto L4
    }
}
