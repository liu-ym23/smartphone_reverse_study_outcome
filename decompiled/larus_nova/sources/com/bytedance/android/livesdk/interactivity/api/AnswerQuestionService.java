package com.bytedance.android.livesdk.interactivity.api;

import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.answer.AnswerQuestionCard;
import com.bytedance.android.livesdk.interactivity.answer.AnswerQuestionServiceWidget;
import com.bytedance.android.livesdk.interactivity.answer.PreviewAnswerQuestionServiceWidget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\fH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/AnswerQuestionService;", "Lcom/bytedance/android/livesdk/interactivity/api/IAnswerQuestionService;", "()V", "answerWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAnswerWidget", "()Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "setAnswerWidget", "(Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;)V", "dismissAnswerQuestionContainer", "", "getAnswerQuestionServiceWidget", "Ljava/lang/Class;", "getPreviewAnswerQuestionServiceWidget", "showAnswerQuestionContainer", "schema", "", "initData", "Lcom/google/gson/JsonObject;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnswerQuestionService implements IAnswerQuestionService {
    private LiveRecyclableWidget answerWidget;

    public AnswerQuestionService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public boolean dismissAnswerQuestionContainer() {
        LiveRecyclableWidget r100 = getAnswerWidget();
        if ((r100 instanceof AnswerQuestionServiceWidget) == true) goto L5;
        r100 = null;
    L5:
        AnswerQuestionServiceWidget r101 = (AnswerQuestionServiceWidget) r100;
        if (r101 == null) goto L8;
        r101.wq();
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public Class<? extends LiveRecyclableWidget> getAnswerQuestionServiceWidget() {
        return AnswerQuestionServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public LiveRecyclableWidget getAnswerWidget() {
        return this.answerWidget;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public Class<? extends LiveRecyclableWidget> getPreviewAnswerQuestionServiceWidget() {
        return PreviewAnswerQuestionServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public void setAnswerWidget(LiveRecyclableWidget r100) {
        this.answerWidget = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public boolean showAnswerQuestionContainer(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "initData");
        LiveRecyclableWidget r102 = getAnswerWidget();
        if ((r102 instanceof AnswerQuestionServiceWidget) == true) goto L5;
        r102 = null;
    L5:
        AnswerQuestionServiceWidget r103 = (AnswerQuestionServiceWidget) r102;
        if (r103 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "initData");
        r103.wq();
        Uri r104 = UriProtector.parse(r100);
        IBrowserService r105 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r105 == null) goto L10;
        HybridCard r106 = r105.getHybridCard(r103.context, r104, null);
    L11:
        if (r106 == null) goto L24;
        IHybridComponent r107 = r106.getMCurrentHybridComponent();
        if (r107 == null) goto L16;
        r107.load(null, UtilsKt.i(r101));
    L16:
        r106.show();
        AnswerQuestionCard r108 = new AnswerQuestionCard(r106, r103.dataCenter, r100);
        r108.show();
        Unit r109 = Unit.INSTANCE;
        r103.f132733a = r108;
        r103.xq(true);
        AnswerQuestionCard r110 = r103.f132733a;
        if (r110 == null) goto L21;
        HybridCard r111 = r110.f132732n;
        if (r111 == null) goto L21;
        r103.f132735c = RxUtilKt.g(r111, false).subscribe(new com.bytedance.android.livesdk.interactivity.answer.a(r111, r103));
    L21:
        return true;
    L24:
        return false;
    L10:
        r106 = null;
        goto L11
    L23:
        return false;
    }
}
