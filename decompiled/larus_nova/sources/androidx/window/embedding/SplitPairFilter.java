package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public int hashCode() {
        int r100 = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String r101 = this.secondaryActivityIntentAction;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SplitPairFilter) == true) goto L8;
        return false;
    L8:
        SplitPairFilter r101 = (SplitPairFilter) r100;
        if (Intrinsics.areEqual(this.primaryActivityName, r101.primaryActivityName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondaryActivityName, r101.secondaryActivityName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secondaryActivityIntentAction, r101.secondaryActivityIntentAction) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean matchesActivityIntentPair(Activity r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "primaryActivity");
        Intrinsics.checkNotNullParameter(r101, "secondaryActivityIntent");
        ComponentName r102 = r100.getComponentName();
        MatcherUtils r103 = MatcherUtils.INSTANCE;
        if (r103.areComponentsMatching$window_release(r102, this.primaryActivityName) == true) goto L6;
        return false;
    L6:
        if (r103.areComponentsMatching$window_release(r101.getComponent(), this.secondaryActivityName) == false) goto L16;
        String r104 = this.secondaryActivityIntentAction;
        if (r104 != null) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.areEqual(r104, r101.getAction()) == true) goto L12;
        return false;
    L16:
        return false;
    }

    public final boolean matchesActivityPair(Activity r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "primaryActivity");
        Intrinsics.checkNotNullParameter(r101, "secondaryActivity");
        MatcherUtils r102 = MatcherUtils.INSTANCE;
        boolean r103 = true;
        if (r102.areComponentsMatching$window_release(r100.getComponentName(), this.primaryActivityName) == true) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r101.getIntent() == null) goto L17;
        if (r104 == true) goto L12;
    L14:
        r103 = false;
    L16:
        return r103;
    L12:
        if (matchesActivityIntentPair(r100, r101.getIntent()) == false) goto L14;
    L17:
        return r104;
    L5:
        if (r102.areComponentsMatching$window_release(r101.getComponentName(), this.secondaryActivityName) == false) goto L7;
        r104 = true;
        goto L9
    }

    public SplitPairFilter(ComponentName r110, ComponentName r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "primaryActivityName");
        Intrinsics.checkNotNullParameter(r111, "secondaryActivityName");
        this.primaryActivityName = r110;
        this.secondaryActivityName = r111;
        this.secondaryActivityIntentAction = r112;
        String r100 = r110.getPackageName();
        String r101 = r110.getClassName();
        String r102 = r111.getPackageName();
        String r113 = r111.getClassName();
        boolean r114 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L73;
        if (r101.length() != 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L71;
        if (StringsKt.contains$default(r100, "*", false, 2, null) == true) goto L31;
    L34:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L69;
        if (StringsKt.contains$default(r101, "*", false, 2, null) == true) goto L40;
    L43:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L67;
        if (StringsKt.contains$default(r102, "*", false, 2, null) == true) goto L49;
    L52:
        boolean r109 = true;
    L53:
        if (r109 == false) goto L65;
        if (StringsKt.contains$default(r113, "*", false, 2, null) == true) goto L57;
    L60:
        if (r114 == false) goto L63;
        return;
    L63:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L57:
        if (StringsKt.indexOf$default(r113, "*", 0, false, 6, null) == (r113.length() - 1)) goto L60;
        r114 = false;
        goto L60
    L65:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L49:
        if (StringsKt.indexOf$default(r102, "*", 0, false, 6, null) == (r102.length() - 1)) goto L52;
        r109 = false;
        goto L53
    L67:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L40:
        if (StringsKt.indexOf$default(r101, "*", 0, false, 6, null) == (r101.length() - 1)) goto L43;
        r108 = false;
        goto L45
    L69:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L31:
        if (StringsKt.indexOf$default(r100, "*", 0, false, 6, null) == (r100.length() - 1)) goto L34;
        r107 = false;
        goto L36
    L71:
        throw new IllegalArgumentException("Activity class name must not be empty.".toString());
    L21:
        if (r113.length() != 0) goto L23;
        boolean r115 = true;
    L24:
        if (r115 == true) goto L26;
        r106 = true;
        goto L27
    L23:
        r115 = false;
        goto L24
    L18:
        r105 = false;
        goto L19
    L73:
        throw new IllegalArgumentException("Package name must not be empty".toString());
    L8:
        if (r102.length() != 0) goto L10;
        boolean r116 = true;
    L11:
        if (r116 == true) goto L13;
        r104 = true;
        goto L14
    L10:
        r116 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }
}
