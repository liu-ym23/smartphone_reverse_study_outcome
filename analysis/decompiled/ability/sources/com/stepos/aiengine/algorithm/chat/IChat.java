package com.stepos.aiengine.algorithm.chat;

import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.data.FloatArrayMap;
import com.stepos.core.data.LlmChatMessage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H&¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0014H&¢\u0006\u0004\b+\u0010\u0016J!\u0010,\u001a\u00020\u00142\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u0011H&¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/IChat;", "", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "preload", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "openSession", "(Ljava/lang/String;Lcom/stepos/aiengine/api/task/IBundleCallback;)Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "LC7/r;", "closeSession", "(Ljava/lang/String;)V", "", "getSessions", "()Ljava/util/List;", "", "clearSessions", "()I", "token", "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "messages", "generateIn", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "encoded", "generate", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "bundle", "Lcom/stepos/aiengine/data/FloatArrayMap;", "embedding", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/data/FloatArrayMap;", "", "identity", "", "cancel", "(J)Z", "resetContext", "()Z", "getMaxTokenLimit", "calculateTokenLength", "(Ljava/util/List;)I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IChat {
    int calculateTokenLength(List<LlmChatMessage> messages);

    boolean cancel(long identity);

    int clearSessions();

    void closeSession(String name);

    FloatArrayMap embedding(AlgorithmToken token, Bundle bundle);

    int generate(AlgorithmToken token, String encoded, Bundle args, IBundleCallback callback);

    int generateIn(AlgorithmToken token, List<LlmChatMessage> messages, Bundle args, IBundleCallback callback);

    int getMaxTokenLimit();

    List<String> getSessions();

    IChatSession openSession(String name, IBundleCallback callback);

    AlgorithmToken preload(Bundle args);

    boolean resetContext();
}
