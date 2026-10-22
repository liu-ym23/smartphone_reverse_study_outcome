package com.stepos.familyguard.net.entity;

import com.stepos.digitalwellbeing.server.category.data.room.PackageCategoryInfo;
import com.stepos.digitalwellbeing.server.data.BatteryInfo;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import java.util.List;

/* loaded from: classes.dex */
public class RawUsageStatsDataSetEntity {
    public boolean enabled;
    public StatsDataSet[] statsDataSetsArray;
    public long updateTime = 0;
    public List<PackageCategoryInfo> packageCategoryList = null;
    public List<PackageUtils.AppInfo> packageList = null;
    public BatteryInfo batteryInfo = null;
}
