package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GroupPhotoShareLayoutViewHolder$tryShareToApp$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageStr;
    final /* synthetic */ l this$0;

    public GroupPhotoShareLayoutViewHolder$tryShareToApp$1(l r100, Context r101, String r102) {
        this.this$0 = r100;
        this.$context = r101;
        this.$packageStr = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        f2.b(R.string.ttlive_group_photo_save_image_success, 0);
        this.this$0.f100359d.uy();
        puc.a.openInstalledApp(this.$context, this.$packageStr);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
