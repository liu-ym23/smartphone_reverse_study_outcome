package com.android.ttcjpaysdk.integrated.counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00172\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\b\u0010\u001a\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H&J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0011H&J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H&R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/ConfirmAdapterProxy;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", WidgetCostModule.TYPE_INFLATE, "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getInflate", "()Landroid/view/LayoutInflater;", "showNum", "", "getShowNum", "()I", "setShowNum", "(I)V", "clearAdapterShowNum", "", "dataChangedNotify", "list", "getItemCount", "getItemViewType", "position", "isCanCollapse", "", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ConfirmAdapterProxy {
    public static final Companion Companion = null;
    public static final int VIEW_TYPE_GROUP_PAY_BASE = 0;
    public static final int VIEW_TYPE_MORE_PAY_BASE = 2;
    public static final int VIEW_TYPE_SINGE_PAY_BASE = 1;
    private final ArrayList<PaymentMethodInfo> data;
    private final LayoutInflater inflate;
    private int showNum;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/ConfirmAdapterProxy$Companion;", "", "()V", "VIEW_TYPE_GROUP_PAY_BASE", "", "VIEW_TYPE_MORE_PAY_BASE", "VIEW_TYPE_SINGE_PAY_BASE", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void clearAdapterShowNum() {
    }

    public abstract int getItemCount();

    public abstract int getItemViewType(int r100);

    public boolean isCanCollapse() {
        return false;
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101);

    public final ArrayList<PaymentMethodInfo> getData() {
        return this.data;
    }

    public final LayoutInflater getInflate() {
        return this.inflate;
    }

    public final int getShowNum() {
        return this.showNum;
    }

    public ConfirmAdapterProxy(Context r100) {
        this.data = new ArrayList();
        this.inflate = LayoutInflater.from(r100);
    }

    public void dataChangedNotify(ArrayList<PaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
    }

    public final void setShowNum(int r100) {
        this.showNum = r100;
    }
}
