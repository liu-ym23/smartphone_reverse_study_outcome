package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameDetailPreRequestUtil$fetchUserPortrait$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ JSONObject $aiInfo;
    final /* synthetic */ Function1 $onSuccess;

    public GameDetailPreRequestUtil$fetchUserPortrait$2(Function1 r100, JSONObject r101) {
        this.$onSuccess = r100;
        this.$aiInfo = r101;
        super(2);
    }

    public final void invoke(int r100, String r101) {
        if (GameDetailPreRequestUtil.f55453a == false) goto L6;
        GameDetailPreRequestUtil.f55453a = false;
        GameDetailPreRequestUtil.f("获取用户画像失败 code = " + r100 + ", msg = " + r101);
        this.$onSuccess.invoke(this.$aiInfo);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
