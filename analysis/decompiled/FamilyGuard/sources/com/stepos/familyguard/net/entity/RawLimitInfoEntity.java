package com.stepos.familyguard.net.entity;

import com.stepos.familyguard.db.entity.CategoryLimitCache;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import com.stepos.familyguard.db.entity.RawPeriodCache;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RawLimitInfoEntity {
    public List<PackageLimitCache> packageLimitList = new ArrayList();
    public List<CategoryLimitCache> categoryLimitList = new ArrayList();
    public List<PeriodLimitCache> periodLimitList = new ArrayList();
    public List<RawPeriodCache> rawPeriodList = new ArrayList();
    public long updateTime = 0;
}
