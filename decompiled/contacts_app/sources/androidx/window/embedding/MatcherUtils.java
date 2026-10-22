package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.android.contacts.ContactsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatcherUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "()V", "sDebugMatchers", "", "sMatchersTag", "", "areActivityOrIntentComponentsMatching", "activity", "Landroid/app/Activity;", "ruleComponent", "Landroid/content/ComponentName;", "areActivityOrIntentComponentsMatching$window_release", "areComponentsMatching", "activityComponent", "areComponentsMatching$window_release", "wildcardMatch", "name", "pattern", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = null;
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    static {
        INSTANCE = new MatcherUtils();
    }

    private MatcherUtils() {
    }

    public final boolean areComponentsMatching$window_release(ComponentName r7, ComponentName r8) {
        Intrinsics.checkNotNullParameter(r8, "ruleComponent");
        if (r7 == null) goto L5;
        String r3 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "activityComponent.toString()");
        if ((!StringsKt.contains$default(r3, ContactsUtils.CHAR_STAR, false, 2, null)) == false) goto L33;
        if (Intrinsics.areEqual(r7.getPackageName(), r8.getPackageName()) == true) goto L19;
        String r0 = r7.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "activityComponent.packageName");
        String r4 = r8.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r4, "ruleComponent.packageName");
        if (wildcardMatch(r0, r4) == true) goto L19;
        boolean r1 = false;
    L21:
        if (Intrinsics.areEqual(r7.getClassName(), r8.getClassName()) == true) goto L26;
        String r9 = r7.getClassName();
        Intrinsics.checkNotNullExpressionValue(r9, "activityComponent.className");
        String r10 = r8.getClassName();
        Intrinsics.checkNotNullExpressionValue(r10, "ruleComponent.className");
        if (wildcardMatch(r9, r10) == true) goto L26;
        boolean r6 = false;
    L27:
        if (r1 == false) goto L31;
        if (r6 == false) goto L31;
        return true;
    L31:
        return false;
    L26:
        r6 = true;
    L19:
        r1 = true;
        goto L21
    L33:
        throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
    L5:
        if (Intrinsics.areEqual(r8.getPackageName(), ContactsUtils.CHAR_STAR) == false) goto L10;
        if (Intrinsics.areEqual(r8.getClassName(), ContactsUtils.CHAR_STAR) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity r2, ComponentName r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "ruleComponent");
        if (areComponentsMatching$window_release(r2.getComponentName(), r3) == false) goto L6;
        return true;
    L6:
        Intent r1 = r2.getIntent();
        if (r1 == null) goto L14;
        ComponentName r4 = r1.getComponent();
        if (r4 != null) goto L13;
        return false;
    L13:
        return INSTANCE.areComponentsMatching$window_release(r4, r3);
    L14:
        return false;
    }

    private final boolean wildcardMatch(String r13, String r14) {
        String r12 = r14;
        if (StringsKt.contains$default(r12, ContactsUtils.CHAR_STAR, false, 2, null) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r14, ContactsUtils.CHAR_STAR) == false) goto L9;
        return true;
    L9:
        if (StringsKt.indexOf$default(r12, ContactsUtils.CHAR_STAR, 0, false, 6, null) == StringsKt.lastIndexOf$default(r12, ContactsUtils.CHAR_STAR, 0, false, 6, null)) goto L11;
    L13:
        boolean r15 = false;
    L14:
        if (r15 == false) goto L18;
        String r16 = r14.substring(0, r14.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.startsWith$default(r13, r16, false, 2, null);
    L18:
        throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
    L11:
        if (StringsKt.endsWith$default(r14, ContactsUtils.CHAR_STAR, false, 2, null) == false) goto L13;
        r15 = true;
        goto L14
    }
}
