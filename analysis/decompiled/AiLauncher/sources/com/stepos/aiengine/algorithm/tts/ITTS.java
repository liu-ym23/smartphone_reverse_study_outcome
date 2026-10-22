package com.stepos.aiengine.algorithm.tts;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/tts/ITTS;", "", "synthesize", "", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "text", "", "args", "Landroid/os/Bundle;", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", e.f30860s, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ITTS {
    boolean cancel(long identity);

    int synthesize(AlgorithmToken token, String text, Bundle args, IBundleCallback callback);
}
