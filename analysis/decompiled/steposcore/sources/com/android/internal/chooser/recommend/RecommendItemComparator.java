package com.android.internal.chooser.recommend;

import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.utils.HanziToPinyin;
import java.text.Collator;
import java.util.Comparator;

/* loaded from: classes.dex */
public class RecommendItemComparator implements Comparator<DisplayResolveInfo> {
    private final Collator mCollator = Collator.getInstance();

    enum AppWeight {
        BROWSER("com.android.browser", null, 0);

        private String className;
        private String packageName;
        private int weight;

        AppWeight(String packageName, String className, int weight) {
            this.packageName = packageName;
            this.className = className;
            this.weight = weight;
        }
    }

    public RecommendItemComparator() {
        this.mCollator.setStrength(0);
    }

    @Override // java.util.Comparator
    public int compare(DisplayResolveInfo first, DisplayResolveInfo second) {
        CompareResult result = notNullCompare(first, second);
        if (result.success) {
            return result.result;
        }
        ResolveInfo firstResolveInfo = first.resolveInfo;
        ResolveInfo secondResolveInfo = second.resolveInfo;
        CompareResult result2 = notNullCompare(firstResolveInfo, secondResolveInfo);
        if (result2.success) {
            return result2.result;
        }
        ComponentInfo firstComponent = firstResolveInfo.activityInfo != null ? firstResolveInfo.activityInfo : firstResolveInfo.serviceInfo;
        ComponentInfo secondComponent = secondResolveInfo.activityInfo != null ? secondResolveInfo.activityInfo : secondResolveInfo.serviceInfo;
        CompareResult result3 = notNullCompare(firstComponent, secondComponent);
        if (result3.success) {
            return result3.result;
        }
        CompareResult result4 = compareAppWeight(firstComponent, secondComponent);
        if (result4.success) {
            return result4.result;
        }
        CompareResult result5 = compareAppName(first, second);
        if (result5.success) {
            return result5.result;
        }
        return 0;
    }

    private CompareResult notNullCompare(Object first, Object second) {
        if (first == null && second == null) {
            return CompareResult.makeSuccessResult(0);
        }
        if (first == null) {
            return CompareResult.makeSuccessResult(1);
        }
        if (second == null) {
            return CompareResult.makeSuccessResult(-1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareAppWeight(ComponentInfo first, ComponentInfo second) {
        int diff = getAppWeight(second) - getAppWeight(first);
        if (diff != 0) {
            return CompareResult.makeSuccessResult(diff > 0 ? 1 : -1);
        }
        return CompareResult.makeFailureResult();
    }

    private int getAppWeight(ComponentInfo componentInfo) {
        for (AppWeight appWeight : AppWeight.values()) {
            if (appWeight.packageName.equals(componentInfo.packageName) && (appWeight.className == null || appWeight.className.equals(componentInfo.name))) {
                return appWeight.weight;
            }
        }
        return -1;
    }

    private CompareResult compareAppName(DisplayResolveInfo first, DisplayResolveInfo second) {
        String firstName = HanziToPinyin.getInstance().transliterate(first.activityLabel.toString());
        String secondName = HanziToPinyin.getInstance().transliterate(second.activityLabel.toString().trim());
        return CompareResult.makeSuccessResult(this.mCollator.compare(firstName, secondName));
    }

    static class CompareResult {
        int result;
        boolean success;

        private CompareResult(boolean success, int result) {
            this.success = success;
            this.result = result;
        }

        private CompareResult(boolean success) {
            this.success = success;
        }

        static CompareResult makeSuccessResult(int result) {
            return new CompareResult(true, result);
        }

        static CompareResult makeFailureResult() {
            return new CompareResult(false);
        }
    }
}
