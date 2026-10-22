package com.android.ttcjpaysdk.base.h5.utils;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import com.android.ttcjpaysdk.base.service.bean.H5ParamBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/utils/WxH5PayRedirectModel;", "", "activity", "Landroid/content/Context;", "h5ParamBuilder", "Lcom/android/ttcjpaysdk/base/service/bean/H5ParamBuilder;", "triggerFrom", "Lcom/android/ttcjpaysdk/base/service/ICJPayH5Service$WxH5PayFrom;", "fallbackCJH5", "Lkotlin/Function0;", "", "wxPayJsbCallbackId", "", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/bean/H5ParamBuilder;Lcom/android/ttcjpaysdk/base/service/ICJPayH5Service$WxH5PayFrom;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "getActivity", "()Landroid/content/Context;", "getFallbackCJH5", "()Lkotlin/jvm/functions/Function0;", "getH5ParamBuilder", "()Lcom/android/ttcjpaysdk/base/service/bean/H5ParamBuilder;", "getTriggerFrom", "()Lcom/android/ttcjpaysdk/base/service/ICJPayH5Service$WxH5PayFrom;", "getWxPayJsbCallbackId", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WxH5PayRedirectModel {
    private final Context activity;
    private final Function0<Unit> fallbackCJH5;
    private final H5ParamBuilder h5ParamBuilder;
    private final ICJPayH5Service.WxH5PayFrom triggerFrom;
    private final String wxPayJsbCallbackId;

    public final Context getActivity() {
        return this.activity;
    }

    public final Function0<Unit> getFallbackCJH5() {
        return this.fallbackCJH5;
    }

    public final H5ParamBuilder getH5ParamBuilder() {
        return this.h5ParamBuilder;
    }

    public final ICJPayH5Service.WxH5PayFrom getTriggerFrom() {
        return this.triggerFrom;
    }

    public final String getWxPayJsbCallbackId() {
        return this.wxPayJsbCallbackId;
    }

    public WxH5PayRedirectModel(Context r100, H5ParamBuilder r101, ICJPayH5Service.WxH5PayFrom r102, Function0<Unit> r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "h5ParamBuilder");
        Intrinsics.checkNotNullParameter(r102, "triggerFrom");
        Intrinsics.checkNotNullParameter(r103, "fallbackCJH5");
        this.activity = r100;
        this.h5ParamBuilder = r101;
        this.triggerFrom = r102;
        this.fallbackCJH5 = r103;
        this.wxPayJsbCallbackId = r104;
    }

    public /* synthetic */ WxH5PayRedirectModel(Context r100, H5ParamBuilder r101, ICJPayH5Service.WxH5PayFrom r102, Function0 r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
