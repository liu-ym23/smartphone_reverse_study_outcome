package Ma;

import H7.c;
import S7.n;
import android.content.Context;
import stepai.android.llm.base.LLMRequest;
import stepai.android.mindx.base.d;
import stepai.android.mindx.client.config.ClientConfig;

/* loaded from: classes4.dex */
public interface a {
    boolean bindService(Context context);

    Object chat(LLMRequest lLMRequest, d dVar, c cVar);

    String getTraceById(String str);

    boolean isServiceConnected();

    void recordPathList(String str);

    void registerErrorListener(n nVar);

    p9.c stream(LLMRequest lLMRequest, d dVar);

    boolean syncTraceBuffer();

    void unbindService();

    void updateSetting(ClientConfig clientConfig);
}
