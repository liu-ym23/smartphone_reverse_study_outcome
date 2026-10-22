package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
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

    private final boolean wildcardMatch(String r110, String r111) {
        if (StringsKt.contains$default(r111, "*", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r111, "*") == false) goto L9;
        return true;
    L9:
        if (StringsKt.indexOf$default(r111, "*", 0, false, 6, null) == StringsKt.lastIndexOf$default(r111, "*", 0, false, 6, null)) goto L11;
    L13:
        boolean r100 = false;
    L14:
        if (r100 == false) goto L18;
        return StringsKt.startsWith$default(r110, r111.substring(0, r111.length() - 1), false, 2, null);
    L18:
        throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
    L11:
        if (StringsKt.endsWith$default(r111, "*", false, 2, null) == false) goto L13;
        r100 = true;
        goto L14
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity r100, ComponentName r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "ruleComponent");
        if (areComponentsMatching$window_release(r100.getComponentName(), r101) == false) goto L6;
        return true;
    L6:
        Intent r102 = r100.getIntent();
        if (r102 == null) goto L11;
        ComponentName r103 = r102.getComponent();
        if (r103 == null) goto L11;
        return INSTANCE.areComponentsMatching$window_release(r103, r101);
    L11:
        return false;
    }

    public final boolean areComponentsMatching$window_release(ComponentName r100, ComponentName r101) {
        Intrinsics.checkNotNullParameter(r101, "ruleComponent");
        if (r100 != null) goto L12;
        if (Intrinsics.areEqual(r101.getPackageName(), "*") == true) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(r101.getClassName(), "*") == false) goto L9;
        return true;
    L12:
        if ((!StringsKt.contains$default(r100.toString(), "*", false, 2, null)) == false) goto L33;
        if (Intrinsics.areEqual(r100.getPackageName(), r101.getPackageName()) == false) goto L16;
    L19:
        boolean r102 = true;
    L21:
        if (Intrinsics.areEqual(r100.getClassName(), r101.getClassName()) == false) goto L23;
    L26:
        boolean r103 = true;
    L27:
        if (r102 == false) goto L30;
        if (r103 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        if (wildcardMatch(r100.getClassName(), r101.getClassName()) == true) goto L26;
        r103 = false;
        goto L27
    L16:
        if (wildcardMatch(r100.getPackageName(), r101.getPackageName()) == true) goto L19;
        r102 = false;
        goto L21
    L33:
        throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
    }
}
