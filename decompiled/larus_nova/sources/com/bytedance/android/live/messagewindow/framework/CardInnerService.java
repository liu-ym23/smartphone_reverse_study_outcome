package com.bytedance.android.live.messagewindow.framework;

import android.view.View;
import com.bytedance.android.live.messagewindow.framework.process.MsgWindowPositionAdjuster;
import com.bytedance.android.live.messagewindow.framework.process.d;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import h71.c;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/CardInnerService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/ICardInnerService;", "Landroid/view/View;", "cardContainer", "Lh71/d;", "createMsgWindowPositionAdjuster", "Lh71/c;", "getMsgWindowAdjustStrategyFilter", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CardInnerService implements ICardInnerService {
    public CardInnerService() {
        k.l(ICardInnerService.class, this);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService
    public c getMsgWindowAdjustStrategyFilter() {
        return d.f83192a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService
    public h71.d createMsgWindowPositionAdjuster(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardContainer");
        return new MsgWindowPositionAdjuster(r100);
    }
}
