package com.stepos.aiengine.algorithm.chat;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.data.LlmChatMessage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u00020\u00032\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u0015\u001a\u00020\u00032\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00172\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0018\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0012\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0017H&J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0018\u0010\u001d\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u0006\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u001a\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0007H&J\u0012\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\fH&J\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H&J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\fH&¨\u0006)"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "", "generateInHistory", "", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "args", "Landroid/os/Bundle;", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "generateWithPrompt", HighlightArgsBundle.KEY_PROMPT, "", "cancel", "", "identity", "", "putHistory", NotificationCompat.CATEGORY_MESSAGE, "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "putHistoryList", "msgs", "", "getHistory", "index", "getHistoryList", "removeHistory", "removeHistoryAfter", "getAndRemoveHistory", "clearHistory", "getHistorySize", "calculateHistoryTokenLength", "embedding", "", "bundle", "embedded", "id", "embeddedList", "ids", "removeEmbedded", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IChatSession {
    int calculateHistoryTokenLength();

    boolean cancel(long identity);

    int clearHistory();

    float[] embedded(String id);

    List<float[]> embeddedList(List<String> ids);

    float[] embedding(AlgorithmToken token, Bundle bundle);

    int generateInHistory(AlgorithmToken token, Bundle args, IBundleCallback callback);

    int generateWithPrompt(AlgorithmToken token, String prompt, Bundle args, IBundleCallback callback);

    LlmChatMessage getAndRemoveHistory(int index);

    LlmChatMessage getHistory(int index);

    List<LlmChatMessage> getHistoryList();

    int getHistorySize();

    int putHistory(LlmChatMessage msg, Bundle args);

    int putHistoryList(List<LlmChatMessage> msgs, Bundle args);

    boolean removeEmbedded(String id);

    boolean removeHistory(int index);

    int removeHistoryAfter(int index);
}
