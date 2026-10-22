package androidx.compose.ui.res;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0003R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/res/ResourceIdCache;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/res/Resources;", "res", "", "id", "Landroid/util/TypedValue;", "resolveResourcePath", "(Landroid/content/res/Resources;I)Landroid/util/TypedValue;", "LC7/r;", "clear", "Landroidx/collection/MutableIntObjectMap;", "resIdPathMap", "Landroidx/collection/MutableIntObjectMap;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResourceIdCache {
    public static final int $stable = 8;
    private final MutableIntObjectMap<TypedValue> resIdPathMap = new MutableIntObjectMap<>(0, 1, null);

    public final void clear() {
        synchronized (this) {
            this.resIdPathMap.clear();
        }
    }

    public final TypedValue resolveResourcePath(Resources res, @DrawableRes int id) {
        TypedValue typedValue;
        synchronized (this) {
            typedValue = this.resIdPathMap.get(id);
            if (typedValue == null) {
                typedValue = new TypedValue();
                res.getValue(id, typedValue, true);
                this.resIdPathMap.put(id, typedValue);
            }
        }
        return typedValue;
    }
}
