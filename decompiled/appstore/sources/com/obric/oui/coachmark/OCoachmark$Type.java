package com.obric.oui.coachmark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/obric/oui/coachmark/OCoachmark$Type", "", "Lcom/obric/oui/coachmark/OCoachmark$Type;", "<init>", "(Ljava/lang/String;I)V", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OCoachmark$Type extends Enum<OCoachmark$Type> {
    private static final /* synthetic */ OCoachmark$Type[] $VALUES = null;
    public static final OCoachmark$Type CARD = null;
    public static final OCoachmark$Type PILL = null;

    private static final /* synthetic */ OCoachmark$Type[] $values() {
        return new OCoachmark$Type[]{PILL, CARD};
    }

    static {
        PILL = new OCoachmark$Type("PILL", 0);
        CARD = new OCoachmark$Type("CARD", 1);
        $VALUES = $values();
    }

    private OCoachmark$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static OCoachmark$Type valueOf(String r10) {
        return (OCoachmark$Type) Enum.valueOf(OCoachmark$Type.class, r10);
    }

    public static OCoachmark$Type[] values() {
        return (OCoachmark$Type[]) $VALUES.clone();
    }
}
