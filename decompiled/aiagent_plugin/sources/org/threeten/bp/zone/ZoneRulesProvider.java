package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = null;
    private static final ConcurrentMap<String, ZoneRulesProvider> ZONES = null;

    public boolean provideRefresh() {
        return false;
    }

    public abstract ZoneRules provideRules(String r1, boolean r2);

    public abstract NavigableMap<String, ZoneRules> provideVersions(String r1);

    public abstract Set<String> provideZoneIds();

    static {
        PROVIDERS = new CopyOnWriteArrayList();
        ZONES = new ConcurrentHashMap(512, 0.75f, 2);
        ZoneRulesInitializer.initialize();
    }

    public static Set<String> getAvailableZoneIds() {
        return Collections.unmodifiableSet(ZONES.keySet());
    }

    public static ZoneRules getRules(String r1, boolean r2) {
        Jdk8Methods.requireNonNull(r1, "zoneId");
        return getProvider(r1).provideRules(r1, r2);
    }

    public static NavigableMap<String, ZoneRules> getVersions(String r1) {
        Jdk8Methods.requireNonNull(r1, "zoneId");
        return getProvider(r1).provideVersions(r1);
    }

    private static ZoneRulesProvider getProvider(String r4) {
        ConcurrentMap<String, ZoneRulesProvider> r0 = ZONES;
        ZoneRulesProvider r1 = (ZoneRulesProvider) ZeusTransformUtils.preCheckCast(r0.get(r4), ZoneRulesProvider.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (r0.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: " + r4);
    }

    public static void registerProvider(ZoneRulesProvider r1) {
        Jdk8Methods.requireNonNull(r1, "provider");
        registerProvider0(r1);
        PROVIDERS.add(r1);
    }

    private static void registerProvider0(ZoneRulesProvider r5) {
        Iterator<String> r0 = r5.provideZoneIds().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r1, "zoneId");
        if (((ZoneRulesProvider) ZeusTransformUtils.preCheckCast(ZONES.putIfAbsent(r1, r5), ZoneRulesProvider.class, "com.obric.aiagent.plugin")) == null) goto L4;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r1 + ", currently loading from provider: " + r5);
    }

    public static boolean refresh() {
        Iterator<ZoneRulesProvider> r0 = PROVIDERS.iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 | ((ZoneRulesProvider) ZeusTransformUtils.preCheckCast(r0.next(), ZoneRulesProvider.class, "com.obric.aiagent.plugin")).provideRefresh();
        goto L4
    L6:
        return r1;
    }

    public ZoneRulesProvider() {
    }
}
