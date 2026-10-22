package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.android.contacts.ContactsUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ActivityFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/ActivityFilter;", "", "componentName", "Landroid/content/ComponentName;", "intentAction", "", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "getComponentName", "()Landroid/content/ComponentName;", "getIntentAction", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "matchesActivity", "activity", "Landroid/app/Activity;", "matchesIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "componentName");
        this.componentName = r18;
        this.intentAction = r19;
        String r0 = r18.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "componentName.packageName");
        String r1 = r18.getClassName();
        Intrinsics.checkNotNullExpressionValue(r1, "componentName.className");
        String r3 = r0;
        boolean r9 = true;
        if (r3.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L35;
        String r11 = r1;
        if (r11.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L33;
        if (StringsKt.contains$default(r3, ContactsUtils.CHAR_STAR, false, 2, null) == true) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L31;
        if (StringsKt.contains$default(r11, ContactsUtils.CHAR_STAR, false, 2, null) == true) goto L23;
    L26:
        if (r9 == false) goto L29;
        return;
    L29:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L23:
        if (StringsKt.indexOf$default(r11, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r1.length() - 1)) goto L26;
        r9 = false;
        goto L26
    L31:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L15:
        if (StringsKt.indexOf$default(r3, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r0.length() - 1)) goto L18;
        r5 = false;
        goto L19
    L33:
        throw new IllegalArgumentException("Activity class name must not be empty.".toString());
    L10:
        r4 = false;
        goto L11
    L35:
        throw new IllegalArgumentException("Package name must not be empty".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public final boolean matchesIntent(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r4.getComponent(), this.componentName) == false) goto L12;
        String r3 = this.intentAction;
        if (r3 != null) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r3, r4.getAction()) == true) goto L9;
        return false;
    L12:
        return false;
    }

    public final boolean matchesActivity(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(r3, this.componentName) == false) goto L13;
        String r2 = this.intentAction;
        if (r2 == null) goto L12;
        Intent r4 = r3.getIntent();
        if (r4 != null) goto L9;
        String r5 = null;
    L11:
        if (Intrinsics.areEqual(r2, r5) == false) goto L13;
    L9:
        r5 = r4.getAction();
    L12:
        return true;
    L13:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActivityFilter) == true) goto L8;
        return false;
    L8:
        ActivityFilter r6 = (ActivityFilter) r5;
        if (Intrinsics.areEqual(this.componentName, r6.componentName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentAction, r6.intentAction) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.componentName.hashCode() * 31;
        String r1 = this.intentAction;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }
}
