package stepai.aios.guiexecutor.core;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "toPoint", "Landroid/graphics/Point;", "Lkotlin/Pair;", "", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccessibleGuiActionExecutorKt {
    private static final String TAG = "AccessibleGuiActionExecutor";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Point toPoint(Pair<Integer, Integer> pair) {
        return new Point(((Number) pair.f4886a).intValue(), ((Number) pair.b).intValue());
    }
}
