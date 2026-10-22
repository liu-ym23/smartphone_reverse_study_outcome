package com.android.internal.chooser.chooser;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.db.ChooserItem;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.utils.HanziToPinyin;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ChooserItemComparator implements Comparator<DisplayResolveInfo> {
    private final PackageManager mPackageManager;
    private final ChooserRepository mRepository;
    private final boolean mUseCustomizeFavorite;
    private final Map<String, PackageInfo> mPackageInfoMap = new HashMap();
    private final Collator mCollator = Collator.getInstance();

    public ChooserItemComparator(Context context) {
        this.mCollator.setStrength(0);
        this.mRepository = ChooserRepository.getInstance(context);
        this.mUseCustomizeFavorite = this.mRepository.useCustomizeFavorite();
        this.mPackageManager = context.getPackageManager();
    }

    @Override // java.util.Comparator
    public int compare(DisplayResolveInfo first, DisplayResolveInfo second) throws JSONException {
        CompareResult result = notNullCompare(first, second);
        if (result.success) {
            return result.result;
        }
        CompareResult result2 = compareCategory(first, second);
        if (result2.success) {
            return result2.result;
        }
        ResolveInfo firstResolveInfo = first.resolveInfo;
        ResolveInfo secondResolveInfo = second.resolveInfo;
        CompareResult result3 = notNullCompare(firstResolveInfo, secondResolveInfo);
        if (result3.success) {
            return result3.result;
        }
        ComponentInfo firstComponent = firstResolveInfo.getComponentInfo();
        ComponentInfo secondComponent = secondResolveInfo.getComponentInfo();
        CompareResult result4 = notNullCompare(firstComponent, secondComponent);
        if (result4.success) {
            return result4.result;
        }
        if (first.isDevice) {
            return Integer.compare(AppInfo.getAppWeight(firstResolveInfo), AppInfo.getAppWeight(secondResolveInfo));
        }
        if (first.isFavorite) {
            if (this.mUseCustomizeFavorite) {
                return Integer.compare(this.mRepository.getChooserItemInfo(firstResolveInfo).getOrder(), this.mRepository.getChooserItemInfo(secondResolveInfo).getOrder());
            }
            CompareResult result5 = compareUsageCount(firstResolveInfo, secondResolveInfo);
            if (result5.success) {
                return result5.result;
            }
            CompareResult result6 = compareAppWeight(firstResolveInfo, secondResolveInfo);
            if (result6.success) {
                return result6.result;
            }
            CompareResult result7 = compareName(first, second);
            if (result7.success) {
                return result7.result;
            }
            return 0;
        }
        CompareResult result8 = compareUsageCount(firstResolveInfo, secondResolveInfo);
        if (result8.success) {
            return result8.result;
        }
        CompareResult result9 = compareAppInstallTime(firstComponent, secondComponent);
        if (result9.success) {
            return result9.result;
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

    private CompareResult compareCategory(DisplayResolveInfo first, DisplayResolveInfo second) {
        int firstPriority;
        int secondPriority;
        if (first.isDevice) {
            firstPriority = 3;
        } else if (first.isFavorite) {
            firstPriority = 2;
        } else {
            firstPriority = 1;
        }
        if (second.isDevice) {
            secondPriority = 3;
        } else if (second.isFavorite) {
            secondPriority = 2;
        } else {
            secondPriority = 1;
        }
        if (firstPriority > secondPriority) {
            return CompareResult.makeSuccessResult(-1);
        }
        if (firstPriority < secondPriority) {
            return CompareResult.makeSuccessResult(1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareUsageCount(ResolveInfo first, ResolveInfo second) throws JSONException {
        ChooserItem firstUsageInfo = this.mRepository.getChooserItemInfo(first);
        ChooserItem secondUsageInfo = this.mRepository.getChooserItemInfo(second);
        int diffCount = secondUsageInfo.getUsageCount() - firstUsageInfo.getUsageCount();
        if (diffCount != 0) {
            return CompareResult.makeSuccessResult(diffCount > 0 ? 1 : -1);
        }
        long diffTime = secondUsageInfo.getLastTime() - firstUsageInfo.getLastTime();
        if (diffTime > 0) {
            return CompareResult.makeSuccessResult(1);
        }
        if (diffTime < 0) {
            return CompareResult.makeSuccessResult(-1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareAppWeight(ResolveInfo first, ResolveInfo second) {
        int diff = AppInfo.getAppWeight(second) - AppInfo.getAppWeight(first);
        if (diff != 0) {
            return CompareResult.makeSuccessResult(diff > 0 ? -1 : 1);
        }
        return CompareResult.makeFailureResult();
    }

    private CompareResult compareName(DisplayResolveInfo first, DisplayResolveInfo second) {
        String firstName = HanziToPinyin.getInstance().transliterate(first.activityLabel.toString());
        String secondName = HanziToPinyin.getInstance().transliterate(second.activityLabel.toString().trim());
        return CompareResult.makeSuccessResult(this.mCollator.compare(firstName, secondName));
    }

    private CompareResult compareAppInstallTime(ComponentInfo first, ComponentInfo second) {
        long firstInstallTime = 0;
        long secondInstallTime = 0;
        try {
            PackageInfo firstPackageInfo = getPackageInfo(first.packageName);
            PackageInfo secondPackageInfo = getPackageInfo(second.packageName);
            firstInstallTime = Math.max(firstPackageInfo.firstInstallTime, firstPackageInfo.lastUpdateTime);
            secondInstallTime = Math.max(secondPackageInfo.firstInstallTime, secondPackageInfo.lastUpdateTime);
        } catch (PackageManager.NameNotFoundException e) {
        }
        long diff = secondInstallTime - firstInstallTime;
        if (diff != 0) {
            return CompareResult.makeSuccessResult(diff > 0 ? 1 : -1);
        }
        return CompareResult.makeFailureResult();
    }

    private PackageInfo getPackageInfo(String packageName) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.mPackageInfoMap.get(packageName);
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfo2 = this.mPackageManager.getPackageInfo(packageName, 0);
        this.mPackageInfoMap.put(packageName, packageInfo2);
        return packageInfo2;
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
