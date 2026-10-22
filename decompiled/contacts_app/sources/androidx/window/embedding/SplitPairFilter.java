package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.android.contacts.ContactsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SplitPairFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName r20, ComponentName r21, String r22) {
        Intrinsics.checkNotNullParameter(r20, "primaryActivityName");
        Intrinsics.checkNotNullParameter(r21, "secondaryActivityName");
        this.primaryActivityName = r20;
        this.secondaryActivityName = r21;
        this.secondaryActivityIntentAction = r22;
        String r0 = r20.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "primaryActivityName.packageName");
        String r1 = r20.getClassName();
        Intrinsics.checkNotNullExpressionValue(r1, "primaryActivityName.className");
        String r3 = r21.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r3, "secondaryActivityName.packageName");
        String r2 = r21.getClassName();
        Intrinsics.checkNotNullExpressionValue(r2, "secondaryActivityName.className");
        String r5 = r0;
        boolean r11 = true;
        if (r5.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == false) goto L74;
        String r13 = r1;
        if (r13.length() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L72;
        if (StringsKt.contains$default(r5, ContactsUtils.CHAR_STAR, false, 2, null) == true) goto L31;
    L34:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L70;
        if (StringsKt.contains$default(r13, ContactsUtils.CHAR_STAR, false, 2, null) == false) goto L43;
        Object r10 = null;
        int r12 = 2;
        if (StringsKt.indexOf$default(r13, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r1.length() - 1)) goto L44;
        boolean r14 = false;
    L46:
        if (r14 == false) goto L68;
        String r15 = r3;
        if (StringsKt.contains$default(r15, ContactsUtils.CHAR_STAR, false, r12, r10) == true) goto L50;
    L53:
        boolean r16 = true;
    L54:
        if (r16 == false) goto L66;
        String r17 = r2;
        if (StringsKt.contains$default(r17, ContactsUtils.CHAR_STAR, false, r12, r10) == true) goto L58;
    L61:
        if (r11 == false) goto L64;
        return;
    L64:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L58:
        if (StringsKt.indexOf$default(r17, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r2.length() - 1)) goto L61;
        r11 = false;
        goto L61
    L66:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L50:
        if (StringsKt.indexOf$default(r15, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r3.length() - 1)) goto L53;
        r16 = false;
        goto L54
    L68:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L44:
        r14 = true;
        goto L46
    L43:
        r10 = null;
        r12 = 2;
        goto L44
    L70:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L31:
        if (StringsKt.indexOf$default(r5, ContactsUtils.CHAR_STAR, 0, false, 6, null) == (r0.length() - 1)) goto L34;
        r9 = false;
        goto L36
    L72:
        throw new IllegalArgumentException("Activity class name must not be empty.".toString());
    L21:
        if (r2.length() != 0) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == true) goto L26;
        r8 = true;
        goto L27
    L23:
        r18 = false;
        goto L24
    L18:
        r7 = false;
        goto L19
    L74:
        throw new IllegalArgumentException("Package name must not be empty".toString());
    L8:
        if (r3.length() != 0) goto L10;
        boolean r19 = true;
    L11:
        if (r19 == true) goto L13;
        r6 = true;
        goto L14
    L10:
        r19 = false;
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final boolean matchesActivityPair(Activity r6, Activity r7) {
        Intrinsics.checkNotNullParameter(r6, "primaryActivity");
        Intrinsics.checkNotNullParameter(r7, "secondaryActivity");
        boolean r1 = true;
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r6.getComponentName(), this.primaryActivityName) == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r7.getIntent() == null) goto L17;
        if (r0 == false) goto L14;
        Intent r8 = r7.getIntent();
        Intrinsics.checkNotNullExpressionValue(r8, "secondaryActivity.intent");
        if (matchesActivityIntentPair(r6, r8) == false) goto L14;
    L16:
        return r1;
    L14:
        r1 = false;
        goto L16
    L17:
        return r0;
    L5:
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r7.getComponentName(), this.secondaryActivityName) == false) goto L7;
        r0 = true;
        goto L9
    }

    public final boolean matchesActivityIntentPair(Activity r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r4, "primaryActivity");
        Intrinsics.checkNotNullParameter(r5, "secondaryActivityIntent");
        ComponentName r6 = r4.getComponentName();
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r6, this.primaryActivityName) == true) goto L6;
        return false;
    L6:
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(r5.getComponent(), this.secondaryActivityName) == false) goto L16;
        String r3 = this.secondaryActivityIntentAction;
        if (r3 != null) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.areEqual(r3, r5.getAction()) == true) goto L12;
        return false;
    L16:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitPairFilter) == true) goto L8;
        return false;
    L8:
        SplitPairFilter r6 = (SplitPairFilter) r5;
        if (Intrinsics.areEqual(this.primaryActivityName, r6.primaryActivityName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondaryActivityName, r6.secondaryActivityName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secondaryActivityIntentAction, r6.secondaryActivityIntentAction) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String r2 = this.secondaryActivityIntentAction;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
