package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/largertoucharea/LargeTouchAreaScope;", "", AccountType.ALL, "Activity", "Fragment", "View", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum LargeTouchAreaScope extends Enum<LargeTouchAreaScope> {
    public static final LargeTouchAreaScope ALL = null;
    public static final LargeTouchAreaScope Activity = null;
    public static final LargeTouchAreaScope Fragment = null;
    public static final LargeTouchAreaScope View = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LargeTouchAreaScope[] f38136a = null;

    static {
        LargeTouchAreaScope r100 = new LargeTouchAreaScope(AccountType.ALL, 0);
        ALL = r100;
        LargeTouchAreaScope r101 = new LargeTouchAreaScope("Activity", 1);
        Activity = r101;
        LargeTouchAreaScope r102 = new LargeTouchAreaScope("Fragment", 2);
        Fragment = r102;
        LargeTouchAreaScope r103 = new LargeTouchAreaScope("View", 3);
        View = r103;
        f38136a = new LargeTouchAreaScope[]{r100, r101, r102, r103};
    }

    public static LargeTouchAreaScope valueOf(String r100) {
        return (LargeTouchAreaScope) r27.a.a(LargeTouchAreaScope.class, r100);
    }

    public static LargeTouchAreaScope[] values() {
        return (LargeTouchAreaScope[]) f38136a.clone();
    }

    public LargeTouchAreaScope(String r100, int r101) {
        super(r100, r101);
    }
}
