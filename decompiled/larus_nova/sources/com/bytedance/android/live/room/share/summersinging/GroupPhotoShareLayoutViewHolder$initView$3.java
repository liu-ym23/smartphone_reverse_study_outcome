package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GroupPhotoShareLayoutViewHolder$initView$3 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public GroupPhotoShareLayoutViewHolder$initView$3(l r100) {
        super(1, r100, l.class, "onShareQQClick", "onShareQQClick(Landroid/view/View;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        l r101 = (l) this.receiver;
        int r102 = l.f100355e;
        r101.getClass();
        if (r100 == null) goto L12;
        Context r103 = r100.getContext();
        if (r103 == null) goto L14;
        String r104 = s1.B(R.string.ttlive_group_photo_no_qq);
        if (puc.a.isInstalledApp(r103, "com.tencent.mobileqq") == true) goto L10;
        f2.c(r104, 0);
        return;
    L10:
        l.a(r101, r103, new GroupPhotoShareLayoutViewHolder$tryShareToApp$1(r101, r103, "com.tencent.mobileqq"));
        return;
    L14:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
