package com.stepos.familyguard.net.entity;

import com.stepos.digitalwellbeing.server.category.data.room.PackageCategoryInfo;
import com.stepos.digitalwellbeing.server.data.BatteryInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RawUsageInfoEntity {
    public int todayPickupTimes;
    public List<UsingTimeStats> todayUsingTimeStatsList = new ArrayList();
    public List<PackageUsingTimeStats> todayPackageUsingTimeStatsList = new ArrayList();
    public List<CategoryUsingTimeStats> todayCategoryUsingTimeStatsList = new ArrayList();
    public List<UsingTimeStats> weekUsingTimeStatsList = new ArrayList();
    public List<PackageUsingTimeStats> weekPackageUsingTimeStatsList = new ArrayList();
    public List<CategoryUsingTimeStats> weekCategoryUsingTimeStatsList = new ArrayList();
    public List<PackageCategoryInfo> packageCategoryList = new ArrayList();
    public long updateTime = 0;
    public List<PackageUtils.AppInfo> packageList = new ArrayList();
    public BatteryInfo batteryInfo = new BatteryInfo();
}
