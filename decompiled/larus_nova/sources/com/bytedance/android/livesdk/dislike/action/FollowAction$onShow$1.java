package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.ItemType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class FollowAction$onShow$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1 $reload;
    final /* synthetic */ FollowAction this$0;

    public FollowAction$onShow$1(FollowAction r100, Function1 r101) {
        this.this$0 = r100;
        this.$reload = r101;
        super(1);
    }

    public final void invoke(boolean r100) {
        if (r100 == false) goto L11;
        Pair[] r101 = new Pair[3];
        ItemType r102 = ItemType.UNFOLLOW;
        r101[0] = TuplesKt.to("title", r102.getDesc());
        r101[1] = TuplesKt.to("option_action", new FollowAction$onShow$1$reloadMap$1(this));
        Integer r103 = r102.getImgRes();
        if (r103 == null) goto L6;
        int r104 = r103.intValue();
    L7:
        r101[2] = TuplesKt.to("icon", s1.m(r104));
        HashMap r105 = MapsKt.hashMapOf(r101);
        Function1 r106 = this.$reload;
        if (r106 == null) goto L12;
        Unit r107 = (Unit) r106.invoke(r105);
        return;
    L12:
        return;
    L6:
        r104 = R.drawable.ttlive_unfollow_icon_new;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
