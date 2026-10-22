package com.bytedance.android.livesdk.interactivity.answer;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x61.c;
import x61.f;
import x61.h;

/* JADX INFO: loaded from: classes9.dex */
public final class AnswerQuestionCard extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MsgWindowPosition f132731m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HybridCard f132732n;

    @Override // v61.c
    public final h<?, ?> content() {
        h.a r100 = h.f562592a;
        Function1<c.a, View> r101 = new AnonymousClass1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_INFLATE);
        return new f(r101);
    }

    @Override // v61.a, com.bytedance.android.livesdkapi.interact.IAbsCardWindow
    public final void dismissWindow() {
        this.f132732n.release();     // Catch: Exception -> L4
    L6:
        dismiss();
        return;
    L4:
        e = move-exception;
        ALogger.d("AnswerQuestionCard", "Dismiss Answer Card：" + ExceptionsKt.stackTraceToString(e));
        goto L6
    }

    @Override // v61.a
    public final CardConstraint z() {
        CardConstraint r100 = new CardConstraint(-2, -2);
        r100.b(CardConstraint.Position.TopLeft);
        return r100;
    }

    @Override // v61.a, v61.c
    public final MsgWindowPosition getPosition() {
        return this.f132731m;
    }

    public AnswerQuestionCard(HybridCard r100, DataCenter r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "cardType");
        super(r101, r102, 1);
        this.f132732n = r100;
        this.f132731m = MsgWindowPosition.TOP_LEFT;
    }
}
