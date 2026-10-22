package androidx.compose.ui.semantics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertiesAndroid;", "", "<init>", "()V", "TestTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getTestTagsAsResourceId", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "AccessibilityClassName", "", "getAccessibilityClassName", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticsPropertiesAndroid {
    public static final int $stable = 0;
    private static final SemanticsPropertyKey<String> AccessibilityClassName = null;
    public static final SemanticsPropertiesAndroid INSTANCE = null;
    private static final SemanticsPropertyKey<Boolean> TestTagsAsResourceId = null;

    private SemanticsPropertiesAndroid() {
    }

    static {
        INSTANCE = new SemanticsPropertiesAndroid();
        TestTagsAsResourceId = new SemanticsPropertyKey("TestTagsAsResourceId", false, SemanticsPropertiesAndroid$TestTagsAsResourceId$1.INSTANCE, null, 8, null);
        AccessibilityClassName = new SemanticsPropertyKey("AccessibilityClassName", true, SemanticsPropertiesAndroid$AccessibilityClassName$1.INSTANCE, null, 8, null);
        $stable = 8;
    }

    public final SemanticsPropertyKey<String> getAccessibilityClassName() {
        return AccessibilityClassName;
    }

    public final SemanticsPropertyKey<Boolean> getTestTagsAsResourceId() {
        return TestTagsAsResourceId;
    }
}
