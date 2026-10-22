package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameDetailPreRequestUtil$fetchUserPortrait$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Function1 $onSuccess;

    public GameDetailPreRequestUtil$fetchUserPortrait$1(Function1 r100) {
        this.$onSuccess = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (GameDetailPreRequestUtil.f55453a == false) goto L6;
        GameDetailPreRequestUtil.f55453a = false;
        GameDetailPreRequestUtil.f("获取用户画像成功");
        this.$onSuccess.invoke(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
