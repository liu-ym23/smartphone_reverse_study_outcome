package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/Api31Impl;", "", "<init>", "()V", "create", "Landroid/widget/EdgeEffect;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onPullDistance", "", "edgeEffect", "deltaDistance", "displacement", "getDistance", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api31Impl {
    public static final Api31Impl INSTANCE = null;

    static {
        INSTANCE = new Api31Impl();
    }

    private Api31Impl() {
    }

    public final float getDistance(EdgeEffect r100) {
        return r100.getDistance();
    L4:
        return 0.0f;
    }

    public final EdgeEffect create(Context r100, AttributeSet r101) {
        return new EdgeEffect(r100, r101);
    L5:
        return new EdgeEffect(r100);
    }

    public final float onPullDistance(EdgeEffect r100, float r101, float r102) {
        return r100.onPullDistance(r101, r102);
    L4:
        r100.onPull(r101, r102);
        return 0.0f;
    }
}
