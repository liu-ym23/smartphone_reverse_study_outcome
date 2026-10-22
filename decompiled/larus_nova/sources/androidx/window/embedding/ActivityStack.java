package androidx.window.embedding;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/ActivityStack;", "", "activities", "", "Landroid/app/Activity;", "isEmpty", "", "(Ljava/util/List;Z)V", "getActivities$window_release", "()Ljava/util/List;", "contains", "activity", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityStack {
    private final List<Activity> activities;
    private final boolean isEmpty;

    public int hashCode() {
        return ((this.isEmpty ? 1 : 0) * 31) + this.activities.hashCode();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ActivityStack{");
        r100.append("activities=" + this.activities);
        r100.append("isEmpty=" + this.isEmpty + '}');
        return r100.toString();
    }

    public final List<Activity> getActivities$window_release() {
        return this.activities;
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public final boolean contains(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.activities.contains(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActivityStack) == true) goto L8;
        return false;
    L8:
        ActivityStack r101 = (ActivityStack) r100;
        if (Intrinsics.areEqual(this.activities, r101.activities) == false) goto L11;
    L13:
        return false;
    L11:
        if (this.isEmpty == r101.isEmpty) goto L13;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(List<? extends Activity> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activities");
        this.activities = r100;
        this.isEmpty = r101;
    }

    public /* synthetic */ ActivityStack(List r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
