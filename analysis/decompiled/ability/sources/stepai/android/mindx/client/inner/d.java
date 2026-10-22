package stepai.android.mindx.client.inner;

import C7.r;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import stepai.android.mindx.client.config.ChatData;
import stepai.android.mindx.client.config.StepChatResult;

/* loaded from: classes4.dex */
public final class d implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p9.d f6210a;

    public d(p9.d dVar) {
        this.f6210a = dVar;
    }

    @Override // p9.d
    public final Object emit(Object obj, H7.c cVar) {
        ChatData chatData = (ChatData) obj;
        String response = chatData.getResponse();
        if (response == null) {
            response = "";
        }
        String responseId = chatData.getResponseId();
        k.c(responseId);
        Object objEmit = this.f6210a.emit(new StepChatResult.Success(response, responseId), cVar);
        return objEmit == CoroutineSingletons.f4909a ? objEmit : r.f317a;
    }
}
