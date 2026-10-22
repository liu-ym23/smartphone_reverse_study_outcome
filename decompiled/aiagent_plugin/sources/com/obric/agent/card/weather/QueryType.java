package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum QueryType extends Enum<QueryType> {
    private static final /* synthetic */ d.d.a $ENTRIES = null;
    private static final /* synthetic */ QueryType[] $VALUES = null;
    public static final QueryType AIRQUALITY = null;
    public static final QueryType FEEL_TEMPERATURE = null;
    public static final QueryType HUMIDITY = null;
    public static final QueryType MINUTE_RAIN = null;
    public static final QueryType SUN_RISE_SET = null;
    public static final QueryType UV = null;
    public static final QueryType WEATHER = null;
    public static final QueryType WINDSPEED = null;

    private static final /* synthetic */ QueryType[] $values() {
        return new QueryType[]{WEATHER, HUMIDITY, WINDSPEED, UV, AIRQUALITY, SUN_RISE_SET, MINUTE_RAIN, FEEL_TEMPERATURE};
    }

    public static d.d.a<QueryType> getEntries() {
        return $ENTRIES;
    }

    private QueryType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        WEATHER = new QueryType("WEATHER", 0);
        HUMIDITY = new QueryType("HUMIDITY", 1);
        WINDSPEED = new QueryType("WINDSPEED", 2);
        UV = new QueryType("UV", 3);
        AIRQUALITY = new QueryType("AIRQUALITY", 4);
        SUN_RISE_SET = new QueryType("SUN_RISE_SET", 5);
        MINUTE_RAIN = new QueryType("MINUTE_RAIN", 6);
        FEEL_TEMPERATURE = new QueryType("FEEL_TEMPERATURE", 7);
        QueryType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static QueryType valueOf(String r2) {
        return (QueryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(QueryType.class, r2), QueryType.class, "com.obric.aiagent.plugin");
    }

    public static QueryType[] values() {
        return (QueryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), QueryType[].class, "com.obric.aiagent.plugin");
    }
}
