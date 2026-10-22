package com.amap.api.mapcore.util;

import com.amap.api.services.district.DistrictSearchQuery;
import com.ss.android.lark.location.dto.LocationConstants$NameType;

/* JADX INFO: loaded from: classes28.dex */
public class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f28553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[][] f28554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f28555c = null;

    static {
        f28553a = new String[]{"land", "water", "green", LocationConstants$NameType.BUILDING, "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};
        f28554b = new String[][]{new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", DistrictSearchQuery.KEYWORDS_COUNTRY, "province", "city", DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};
        f28555c = new String[]{"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};
    }
}
