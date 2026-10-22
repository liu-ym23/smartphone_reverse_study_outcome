package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/ActivityFilter;", "", "componentName", "Landroid/content/ComponentName;", "intentAction", "", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "getComponentName", "()Landroid/content/ComponentName;", "getIntentAction", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "matchesActivity", "activity", "Landroid/app/Activity;", "matchesIntent", "intent", "Landroid/content/Intent;", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public int hashCode() {
        int r100 = this.componentName.hashCode() * 31;
        String r101 = this.intentAction;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActivityFilter) == true) goto L8;
        return false;
    L8:
        ActivityFilter r101 = (ActivityFilter) r100;
        if (Intrinsics.areEqual(this.componentName, r101.componentName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentAction, r101.intentAction) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean matchesActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(r100, this.componentName) == false) goto L13;
        String r101 = this.intentAction;
        if (r101 == null) goto L12;
        Intent r102 = r100.getIntent();
        if (r102 == null) goto L9;
        String r103 = r102.getAction();
    L11:
        if (Intrinsics.areEqual(r101, r103) == false) goto L13;
    L9:
        r103 = null;
    L12:
        return true;
    L13:
        return false;
    }

    public final boolean matchesIntent(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r100.getComponent(), this.componentName) == false) goto L12;
        String r101 = this.intentAction;
        if (r101 != null) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r101, r100.getAction()) == true) goto L9;
        return false;
    L12:
        return false;
    }

    public ActivityFilter(ComponentName r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "componentName");
        this.componentName = r110;
        this.intentAction = r111;
        String r112 = r110.getPackageName();
        String r113 = r110.getClassName();
        boolean r100 = true;
        if (r112.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L35;
        if (r113.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L33;
        if (StringsKt.contains$default(r112, "*", false, 2, null) == true) goto L15;
    L18:
        boolean r114 = true;
    L19:
        if (r114 == false) goto L31;
        if (StringsKt.contains$default(r113, "*", false, 2, null) == true) goto L23;
    L26:
        if (r100 == false) goto L29;
        return;
    L29:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L23:
        if (StringsKt.indexOf$default(r113, "*", 0, false, 6, null) == (r113.length() - 1)) goto L26;
        r100 = false;
        goto L26
    L31:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L15:
        if (StringsKt.indexOf$default(r112, "*", 0, false, 6, null) == (r112.length() - 1)) goto L18;
        r114 = false;
        goto L19
    L33:
        throw new IllegalArgumentException("Activity class name must not be empty.".toString());
    L10:
        r102 = false;
        goto L11
    L35:
        throw new IllegalArgumentException("Package name must not be empty".toString());
    L5:
        r101 = false;
        goto L6
    }
}
