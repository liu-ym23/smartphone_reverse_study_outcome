package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/aware/Stage;", "", "", "value", "I", "getValue", "()I", "PAGE_CREATE", ConfirmNextAction.ACTION_TYPE_QUERY, "RENDER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Stage extends Enum<Stage> {
    public static final Stage PAGE_CREATE = null;
    public static final Stage QUERY = null;
    public static final Stage RENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Stage[] f180720a = null;
    private final int value;

    static {
        Stage r100 = new Stage("PAGE_CREATE", 0, 1);
        PAGE_CREATE = r100;
        Stage r101 = new Stage(ConfirmNextAction.ACTION_TYPE_QUERY, 1, 2);
        QUERY = r101;
        Stage r102 = new Stage("RENDER", 2, 3);
        RENDER = r102;
        f180720a = new Stage[]{r100, r101, r102};
    }

    public static Stage valueOf(String r100) {
        return (Stage) r27.a.a(Stage.class, r100);
    }

    public static Stage[] values() {
        return (Stage[]) f180720a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Stage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
