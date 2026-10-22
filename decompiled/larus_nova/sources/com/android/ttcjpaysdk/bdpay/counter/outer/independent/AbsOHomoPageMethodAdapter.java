package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/AbsOHomoPageMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataChangedNotify", "", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentCheckedPosition", "", "OnClickAdapterListener", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOHomoPageMethodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/AbsOHomoPageMethodAdapter$OnClickAdapterListener;", "", "onItemClick", "", "itemBean", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodBean;", "onSelectMethod", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnClickAdapterListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onItemClick(OnClickAdapterListener r100, OHomePageMethodBean r101) {
            }
        }

        void onItemClick(OHomePageMethodBean r100);

        void onSelectMethod(FrontSubPayTypeInfo r100);
    }

    public abstract void dataChangedNotify(ArrayList<Object> r100);

    public abstract int getCurrentCheckedPosition();

    public AbsOHomoPageMethodAdapter() {
    }
}
