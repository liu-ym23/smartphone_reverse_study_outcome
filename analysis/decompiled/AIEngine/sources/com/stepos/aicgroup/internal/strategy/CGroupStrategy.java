package com.stepos.aicgroup.internal.strategy;

import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface CGroupStrategy {
    Map<String, String> getAllCGroups(int i10);

    String getCGroup(int i10, String str);

    String getName();

    boolean isAvailable();

    boolean setCGroup(int i10, String str, String str2);

    boolean setProcessProfiles(int i10, int i11, List<String> list);

    boolean setTaskProfiles(int i10, List<String> list);
}
