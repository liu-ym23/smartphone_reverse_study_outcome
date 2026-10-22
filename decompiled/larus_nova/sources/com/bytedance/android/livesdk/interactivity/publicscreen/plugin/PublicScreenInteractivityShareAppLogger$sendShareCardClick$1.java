package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.base.model.data.m;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PublicScreenInteractivityShareAppLogger$sendShareCardClick$1 extends Lambda implements Function1<HashMap<String, String>, Unit> {
    final /* synthetic */ m1 $message;

    public PublicScreenInteractivityShareAppLogger$sendShareCardClick$1(m1 r100) {
        this.$message = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Map<String, String> r101 = this.$message.getTrackingParams();
        if (r101 == null) goto L5;
        r100.putAll(r101);
    L5:
        m r102 = this.$message.getItemStyle();
        String r103 = "";
        if (r102 == null) goto L9;
        String r104 = r102.itemId;
        if (r104 == null) goto L9;
    L10:
        r100.put("card_id", r104);
        m r105 = this.$message.getItemStyle();
        if (r105 == null) goto L14;
        String r106 = r105.name;
        if (r106 == null) goto L14;
    L15:
        r100.put("item_name", r106);
        m r107 = this.$message.getItemStyle();
        if (r107 == null) goto L21;
        String r108 = r107.itemType;
        if (r108 == null) goto L21;
        r103 = r108;
    L21:
        r100.put("content", r103);
        IInteractivityInjectService r109 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r109 == null) goto L25;
        r109.checkThenDoInjectMiniAppParams(this.$message, r100);
        return;
    L25:
        return;
    L14:
        r106 = "";
    L9:
        r104 = "";
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
