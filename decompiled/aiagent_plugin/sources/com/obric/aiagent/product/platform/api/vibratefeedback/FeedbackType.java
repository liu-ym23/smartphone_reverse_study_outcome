package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IVibrateFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum FeedbackType extends Enum<FeedbackType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ FeedbackType[] $VALUES = null;
    public static final FeedbackType CONFIRM = null;
    public static final Companion Companion = null;
    public static final FeedbackType LONG_PRESS = null;
    public static final FeedbackType RIGID = null;
    public static final FeedbackType SOFT = null;
    public static final FeedbackType TICK = null;
    public static final FeedbackType WAKE_UP = null;
    public static final FeedbackType WARNING = null;
    private final String typeName;

    /* JADX INFO: compiled from: IVibrateFeedback.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final FeedbackType getByTypeName(String r5) {
            o.e(r5, "typeName");
            FeedbackType[] r4 = FeedbackType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            FeedbackType r2 = r4[r1];
            if (o.a(r2.getTypeName(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ FeedbackType[] $values() {
        return new FeedbackType[]{WAKE_UP, LONG_PRESS, TICK, WARNING, CONFIRM, RIGID, SOFT};
    }

    public static a<FeedbackType> getEntries() {
        return $ENTRIES;
    }

    private FeedbackType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    static {
        WAKE_UP = new FeedbackType("WAKE_UP", 0, "EFFECT_WAKE_UP");
        LONG_PRESS = new FeedbackType("LONG_PRESS", 1, "EFFECT_LONG_PRESS");
        TICK = new FeedbackType("TICK", 2, "EFFECT_TICK");
        WARNING = new FeedbackType("WARNING", 3, "EFFECT_WARNING");
        CONFIRM = new FeedbackType("CONFIRM", 4, "EFFECT_CONFIRM");
        RIGID = new FeedbackType("RIGID", 5, "EFFECT_RIGID");
        SOFT = new FeedbackType("SOFT", 6, "EFFECT_SOFT");
        FeedbackType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        Companion = new Companion(null);
    }

    public static FeedbackType valueOf(String r2) {
        return (FeedbackType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FeedbackType.class, r2), FeedbackType.class, "com.obric.aiagent.plugin");
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FeedbackType[].class, "com.obric.aiagent.plugin");
    }
}
