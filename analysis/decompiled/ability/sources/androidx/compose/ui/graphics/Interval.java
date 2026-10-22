package androidx.compose.ui.graphics;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0011\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/Interval;", ExifInterface.GPS_DIRECTION_TRUE, "", "start", "", "end", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(FFLjava/lang/Object;)V", "getStart", "()F", "getEnd", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "overlaps", "", "other", "contains", "value", "equals", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class Interval<T> {
    private final T data;
    private final float end;
    private final float start;

    public Interval(float f, float f7, T t9) {
        this.start = f;
        this.end = f7;
        this.data = t9;
    }

    public final boolean contains(float value) {
        return value <= this.end && this.start <= value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && getClass() == other.getClass()) {
            Interval interval = (Interval) other;
            return this.start == interval.start && this.end == interval.end && k.b(this.data, interval.data);
        }
        return false;
    }

    public final T getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        int iB = androidx.appfunctions.metadata.a.b(this.end, Float.hashCode(this.start) * 31, 31);
        T t9 = this.data;
        return iB + (t9 != null ? t9.hashCode() : 0);
    }

    public final boolean overlaps(Interval<T> other) {
        return this.start <= other.end && this.end >= other.start;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Interval(start=");
        sb.append(this.start);
        sb.append(", end=");
        sb.append(this.end);
        sb.append(", data=");
        return androidx.compose.foundation.b.t(sb, this.data, ')');
    }

    public /* synthetic */ Interval(float f, float f7, Object obj, int i, e eVar) {
        this(f, f7, (i & 4) != 0 ? null : obj);
    }

    public final boolean overlaps(float start, float end) {
        return this.start <= end && this.end >= start;
    }
}
