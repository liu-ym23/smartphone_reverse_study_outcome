package com.stepos.aiengine.algorithm.face;

import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/algorithm/face/IFaceQuality;", "", "assessQuality", "Landroid/os/Bundle;", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFaceQuality {
    Bundle assessQuality(AlgorithmToken token, Bundle image);
}
