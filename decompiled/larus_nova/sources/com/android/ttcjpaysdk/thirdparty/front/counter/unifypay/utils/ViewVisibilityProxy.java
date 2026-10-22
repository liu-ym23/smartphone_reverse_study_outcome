package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils;

import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/utils/ViewVisibilityProxy;", "", "view", "Landroid/view/View;", "onVisibilityChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "newVisibility", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "<set-?>", RemoteMessageConst.Notification.VISIBILITY, "getVisibility", "()I", "setVisibility", "(I)V", "visibility$delegate", "Lkotlin/properties/ReadWriteProperty;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewVisibilityProxy {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final Function1<Integer, Unit> onVisibilityChanged;
    private final View view;
    private final ReadWriteProperty visibility$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ViewVisibilityProxy.class, RemoteMessageConst.Notification.VISIBILITY, "getVisibility()I", 0))};
    }

    public final int getVisibility() {
        return ((Number) this.visibility$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public static final /* synthetic */ Function1 access$getOnVisibilityChanged$p(ViewVisibilityProxy r100) {
        return r100.onVisibilityChanged;
    }

    public static final /* synthetic */ View access$getView$p(ViewVisibilityProxy r100) {
        return r100.view;
    }

    public final void setVisibility(int r100) {
        this.visibility$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewVisibilityProxy(View r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onVisibilityChanged");
        this.view = r100;
        this.onVisibilityChanged = r101;
        Delegates r102 = Delegates.INSTANCE;
        final Integer r103 = Integer.valueOf(r100.getVisibility());
        this.visibility$delegate = new ViewVisibilityProxy$special$$inlined$observable$1(r103, this);
    }
}
