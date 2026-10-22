package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyMethodGroupFoldBean;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R7\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPayMethodListGroupFoldViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "clickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "groupType", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "ivArrow", "Landroid/widget/ImageView;", "tvDesc", "Landroid/widget/TextView;", "bindData", "bean", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodGroupFoldBean;", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayMethodListGroupFoldViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    private Function1<? super String, Unit> clickListener;
    private final ImageView ivArrow;
    private final TextView tvDesc;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPayMethodListGroupFoldViewHolder$Companion;", "", "()V", "create", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPayMethodListGroupFoldViewHolder;", "parent", "Landroid/view/ViewGroup;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJUnifyPayMethodListGroupFoldViewHolder create(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new CJUnifyPayMethodListGroupFoldViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.cj_unify_pay_method_list_group_fold, r100, false));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final Function1<String, Unit> getClickListener() {
        return this.clickListener;
    }

    public CJUnifyPayMethodListGroupFoldViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.tvDesc = (TextView) r100.findViewById(R.id.tv_group_fold_desc);
        this.ivArrow = (ImageView) r100.findViewById(R.id.iv_group_fold_arrow);
    }

    public final void bindData(final CJUnifyMethodGroupFoldBean r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getFoldDesc();
    L5:
        TextView r102 = this.tvDesc;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101 = this.itemView.getContext().getString(R.string.cj_unify_expand_all_payment_methods);
    L14:
        r102.setText(r101);
        this.ivArrow.setImageResource(R.drawable.cj_pay_icon_unify_arrow_down_gray);
        this.itemView.setOnClickListener(new AnonymousClass1(r100, this));
        return;
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r103 = false;
        goto L12
    L4:
        r101 = null;
        goto L5
    }

    public final void setClickListener(Function1<? super String, Unit> r100) {
        this.clickListener = r100;
    }
}
