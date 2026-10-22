package androidx.compose.material3.pulltorefresh;

import C7.r;
import H7.c;
import androidx.annotation.FloatRange;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;

@Stable
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "", "LC7/r;", "animateToThreshold", "(LH7/c;)Ljava/lang/Object;", "animateToHidden", "", "targetValue", "snapTo", "(FLH7/c;)Ljava/lang/Object;", "getDistanceFraction", "()F", "distanceFraction", "", "isAnimating", "()Z", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PullToRefreshState {
    Object animateToHidden(c<? super r> cVar);

    Object animateToThreshold(c<? super r> cVar);

    @FloatRange(from = 0.0d)
    float getDistanceFraction();

    default boolean isAnimating() {
        return false;
    }

    Object snapTo(@FloatRange(from = 0.0d) float f, c<? super r> cVar);
}
