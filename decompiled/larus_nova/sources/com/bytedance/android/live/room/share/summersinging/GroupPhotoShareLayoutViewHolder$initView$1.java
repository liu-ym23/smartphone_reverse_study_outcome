package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GroupPhotoShareLayoutViewHolder$initView$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public GroupPhotoShareLayoutViewHolder$initView$1(l r100) {
        super(1, r100, l.class, "onShareFriendClick", "onShareFriendClick(Landroid/view/View;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        final l r101 = (l) this.receiver;
        int r102 = l.f100355e;
        r101.getClass();
        if (r100 == null) goto L9;
        final Context r103 = r100.getContext();
        if (r103 == null) goto L10;
        l.a(r101, r103, new GroupPhotoShareLayoutViewHolder$onShareFriendClick$1(r101, r103));
        return;
    L10:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
