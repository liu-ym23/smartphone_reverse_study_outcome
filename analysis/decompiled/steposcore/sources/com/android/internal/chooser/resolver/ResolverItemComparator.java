package com.android.internal.chooser.resolver;

import android.content.pm.ResolveInfo;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.utils.HanziToPinyin;
import java.text.Collator;
import java.util.Comparator;

/* loaded from: classes.dex */
public class ResolverItemComparator implements Comparator<DisplayResolveInfo> {
    private final Collator mCollator = Collator.getInstance();
    private ResolveInfo mLastChosen;

    public ResolverItemComparator(ResolveInfo lastChosen) {
        this.mCollator.setStrength(0);
        this.mLastChosen = lastChosen;
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
        CompareResult result3 = compareRecommendApp(first, second);
        if (result3.success) {
            return result3.result;
        }
        CompareResult result4 = compareLastChosen(firstResolveInfo, secondResolveInfo);
        if (result4.success) {
            return result4.result;
        }
        CompareResult result5 = compareSystemApp(first, second);
        if (result5.success) {
            return result5.result;
        }
        CompareResult result6 = compareAppName(first, second);
        if (result6.success) {
            return result6.result;
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

    private CompareResult compareRecommendApp(DisplayResolveInfo first, DisplayResolveInfo second) {
        if (first.isRecommend != second.isRecommend) {
            if (second.isRecommend) {
                return CompareResult.makeSuccessResult(1);
            }
            return CompareResult.makeSuccessResult(-1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareLastChosen(ResolveInfo first, ResolveInfo second) {
        if (this.mLastChosen == null) {
            return CompareResult.makeFailureResult();
        }
        if (this.mLastChosen.activityInfo.packageName.equals(second.activityInfo.packageName) && this.mLastChosen.activityInfo.name.equals(second.activityInfo.name)) {
            return CompareResult.makeSuccessResult(1);
        }
        if (this.mLastChosen.activityInfo.packageName.equals(first.activityInfo.packageName) && this.mLastChosen.activityInfo.name.equals(first.activityInfo.name)) {
            return CompareResult.makeSuccessResult(-1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareSystemApp(DisplayResolveInfo first, DisplayResolveInfo second) {
        if (first.isSystem != second.isSystem) {
            if (second.isSystem) {
                return CompareResult.makeSuccessResult(1);
            }
            return CompareResult.makeSuccessResult(-1);
        }
        return CompareResult.makeFailureResult();
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
