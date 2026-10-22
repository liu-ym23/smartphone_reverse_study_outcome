package com.obric.autogui.common.api.platform.packages;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: StartActivityPosition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum StartActivityPosition extends Enum<StartActivityPosition> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ StartActivityPosition[] $VALUES = null;
    public static final StartActivityPosition ActiveOperatingSpace = null;
    public static final StartActivityPosition MainDisplay = null;

    private static final /* synthetic */ StartActivityPosition[] $values() {
        return new StartActivityPosition[]{ActiveOperatingSpace, MainDisplay};
    }

    public static a<StartActivityPosition> getEntries() {
        return $ENTRIES;
    }

    private StartActivityPosition(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ActiveOperatingSpace = new StartActivityPosition("ActiveOperatingSpace", 0);
        MainDisplay = new StartActivityPosition("MainDisplay", 1);
        StartActivityPosition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static StartActivityPosition valueOf(String r2) {
        return (StartActivityPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(StartActivityPosition.class, r2), StartActivityPosition.class, "com.obric.aiagent.plugin");
    }

    public static StartActivityPosition[] values() {
        return (StartActivityPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StartActivityPosition[].class, "com.obric.aiagent.plugin");
    }
}
