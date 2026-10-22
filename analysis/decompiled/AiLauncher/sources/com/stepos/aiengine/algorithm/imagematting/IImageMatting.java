package com.stepos.aiengine.algorithm.imagematting;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/algorithm/imagematting/IImageMatting;", "", "cutImage", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", MattingOptionBundle.KEY_ROTATE_ANGLE, "", "mattingWith", "options", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IImageMatting {
    Bundle cutImage(AlgorithmToken token, Bundle image, int rotateAngle);

    Bundle mattingWith(AlgorithmToken token, Bundle image, Bundle options);
}
