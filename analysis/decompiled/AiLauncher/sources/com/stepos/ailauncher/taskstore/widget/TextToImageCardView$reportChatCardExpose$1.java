package com.stepos.ailauncher.taskstore.widget;

import Ua.C1056g;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TextToImageCardView$reportChatCardExpose$1", f = "TextToImageCardView.kt", l = {1723}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TextToImageCardView$reportChatCardExpose$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ TaskInfoCard $card;
    final /* synthetic */ List<Pair<Integer, TaskInfoPart>> $pending;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextToImageCardView$reportChatCardExpose$1(List<Pair<Integer, TaskInfoPart>> list, TaskInfoCard taskInfoCard, String str, InterfaceC4014c<? super TextToImageCardView$reportChatCardExpose$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pending = list;
        this.$card = taskInfoCard;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TextToImageCardView$reportChatCardExpose$1(this.$pending, this.$card, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TextToImageCardView$reportChatCardExpose$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            TextToImageCardView$reportChatCardExpose$1$taskStatus$1 textToImageCardView$reportChatCardExpose$1$taskStatus$1 = new TextToImageCardView$reportChatCardExpose$1$taskStatus$1(this.$card, null);
            this.label = 1;
            obj = C1056g.j(iB, textToImageCardView$reportChatCardExpose$1$taskStatus$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str = (String) obj;
        List<Pair<Integer, TaskInfoPart>> list = this.$pending;
        String str2 = this.$sessionId;
        TaskInfoCard taskInfoCard = this.$card;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int iIntValue = ((Number) pair.a()).intValue();
            M5.c.d(M5.c.INSTANCE, com.stepos.ailauncher.taskstore.chat.G.c((TaskInfoPart) pair.b(), str2, taskInfoCard.getTaskId()), str2, "chatview", null, str, M5.c.CARD_TYPE_PREVIEW, String.valueOf(iIntValue), 8, null);
        }
        return Y8.t.f7040a;
    }
}
