package com.bytedance.android.livesdk.interactivity.answer;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import o42.c;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridCard f132744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnswerQuestionServiceWidget f132745b;

    public a(HybridCard r100, AnswerQuestionServiceWidget r101) {
        this.f132744a = r100;
        this.f132745b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        if (this.f132745b.f132734b == this.f132744a.getHeight()) goto L11;
        AnswerQuestionServiceWidget r102 = this.f132745b;
        r102.f132734b = this.f132744a.getHeight();
        InteractionWidgetsPosContext r103 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.f132745b.dataCenter, 0, 2);
        if (r103 == null) goto L9;
        m<Integer> r104 = r103.getAnswerQuestionContainerHeight();
        if (r104 == null) goto L9;
        r104.setValue(Integer.valueOf(this.f132745b.f132734b));
    L9:
        RxBusAbility.INSTANCE.getRxBus(this.f132745b.dataCenter).post(new c(false, true, "AnswerQuestionCardShow"));
        return;
    }
}
