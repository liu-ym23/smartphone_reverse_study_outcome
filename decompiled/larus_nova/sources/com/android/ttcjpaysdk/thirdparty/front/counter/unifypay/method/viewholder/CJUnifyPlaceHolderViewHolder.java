package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyMethodHolderBean;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPlaceHolderViewHolder;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPayMethodCategoryViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "data", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodHolderBean;", "bindData", "", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPlaceHolderViewHolder extends CJUnifyPayMethodCategoryViewHolder {
    public static final Companion Companion = null;
    private CJUnifyMethodHolderBean data;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPlaceHolderViewHolder$Companion;", "", "()V", "create", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/viewholder/CJUnifyPlaceHolderViewHolder;", "parent", "Landroid/view/ViewGroup;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJUnifyPlaceHolderViewHolder create(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new CJUnifyPlaceHolderViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.cj_pay_view_place_holder, r100, false));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJUnifyPlaceHolderViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void bindData(CJUnifyMethodHolderBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.data = r100;
        Integer r101 = Integer.valueOf(r100.getHeight());
        if (r101.intValue() < 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        this.itemView.getLayoutParams().height = r101.intValue();
        return;
    L14:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
