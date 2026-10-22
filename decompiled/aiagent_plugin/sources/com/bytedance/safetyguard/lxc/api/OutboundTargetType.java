package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum OutboundTargetType extends Enum<OutboundTargetType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ OutboundTargetType[] $VALUES = null;
    public static final OutboundTargetType DOMAIN = null;
    public static final OutboundTargetType IPV4 = null;
    public static final OutboundTargetType IPV6 = null;

    private static final /* synthetic */ OutboundTargetType[] $values() {
        return new OutboundTargetType[]{DOMAIN, IPV4, IPV6};
    }

    public static a<OutboundTargetType> getEntries() {
        return $ENTRIES;
    }

    public static OutboundTargetType valueOf(String r2) {
        return (OutboundTargetType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OutboundTargetType.class, r2), OutboundTargetType.class, "com.obric.aiagent.plugin");
    }

    public static OutboundTargetType[] values() {
        return (OutboundTargetType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutboundTargetType[].class, "com.obric.aiagent.plugin");
    }

    private OutboundTargetType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        DOMAIN = new OutboundTargetType("DOMAIN", 0);
        IPV4 = new OutboundTargetType("IPV4", 1);
        IPV6 = new OutboundTargetType("IPV6", 2);
        OutboundTargetType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
