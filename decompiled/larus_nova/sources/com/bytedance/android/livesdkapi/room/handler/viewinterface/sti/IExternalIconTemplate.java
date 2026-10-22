package com.bytedance.android.livesdkapi.room.handler.viewinterface.sti;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalIconTemplate;", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getEntryAnimation", "Landroid/animation/Animator;", "originDelay", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalIconTemplate {
    Animator getEntryAnimation(long r100);

    View getView();
}
