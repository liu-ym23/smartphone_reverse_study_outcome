package com.bytedance.android.livesdk.interactivity.answer;

import cc2.e;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.event.z;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import o42.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/answer/AnswerQuestionServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lwlc/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnswerQuestionServiceWidget extends MiddlewareRoomRecyclableWidget implements wlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnswerQuestionCard f132733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f132734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f132735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f132736d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnswerQuestionServiceWidget f132737a;

        public b(AnswerQuestionServiceWidget r100) {
            this.f132737a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = ((z) r100).f123385c;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L11;
            r101 = null;
        L11:
            if (r101 == null) goto L19;
            AnswerQuestionCard r103 = this.f132737a.f132733a;
            if (r103 == null) goto L20;
            HybridCard r104 = r103.f132732n;
            if (r104 == null) goto L21;
            r104.sendJsEvent("answer_container_send_comment_extra", r101);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r102 = false;
            goto L8
        }
    }

    static {
    }

    @Override // wlc.b
    public final void Rk(IStreamMessage r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        IAnswerQuestionService r100 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r100 == null) goto L5;
        r100.setAnswerWidget(null);
    L5:
        wq();
        Disposable r101 = this.f132736d;
        if (r101 != null) goto L8;
    L12:
        this.f132736d = null;
        return;
    L8:
        if (r101.isDisposed() == true) goto L12;
        Disposable r102 = this.f132736d;
        if (r102 == null) goto L12;
        r102.dispose();
        goto L12
    }

    public final boolean wq() {
        AnswerQuestionCard r100 = this.f132733a;
        if (r100 == null) goto L17;
        ALogger.d("AnswerQuestionServiceWidget", "Dismiss Answer Card：" + r100);
        r100.dismissWindow();
        Disposable r101 = this.f132735c;
        if (r101 != null) goto L7;
    L11:
        InteractionWidgetsPosContext r102 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.dataCenter, 0, 2);
        if (r102 == null) goto L16;
        m<Integer> r103 = r102.getAnswerQuestionContainerHeight();
        if (r103 == null) goto L16;
        r103.setValue(0);
    L16:
        RxBusAbility.INSTANCE.getRxBus(this.dataCenter).post(new c(false, true, "AnswerQuestionCardShow"));
        goto L17
    L7:
        if (r101.isDisposed() == true) goto L11;
        Disposable r104 = this.f132735c;
        if (r104 == null) goto L11;
        r104.dispose();
    L17:
        this.f132733a = null;
        this.f132735c = null;
        this.f132734b = 0;
        h r105 = i.a(null, this.dataCenter);
        if (r105 == null) goto L24;
        m<Boolean> r106 = r105.getAnswerQuestionShow();
        if (r106 == null) goto L24;
        if (r106.getValue().booleanValue() != true) goto L24;
        xq(false);
    L24:
        return true;
    }

    public AnswerQuestionServiceWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IAnswerQuestionService r101 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r101 == null) goto L6;
        r101.setAnswerWidget(this);
    L6:
        if (ec2.h.f472021a.getValue().booleanValue() == false) goto L9;
        this.f132736d = xs2.b.a().b(z.class).subscribe(new b(this));
        return;
    }

    public final void xq(boolean r100) {
        h r101 = i.a(null, this.dataCenter);
        if (r101 == null) goto L7;
        m<Boolean> r102 = r101.getAnswerQuestionShow();
        if (r102 == null) goto L7;
        r102.setValue(Boolean.valueOf(r100));
    L7:
        e r103 = new e();
        r103.a(cc2.k.class, cc2.k.a.f23200c, r100);
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L11;
        r104.put("cmd_change_interactivity_component_visibility", r103);
        return;
    }
}
