package com.android.ttcjpaysdk.base.ui.component.pop;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/ArrowPosition;", "", "(Ljava/lang/String;I)V", "CENTER", GXAnimation.STATE_START, GXAnimation.STATE_END, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ArrowPosition extends Enum<ArrowPosition> {
    private static final /* synthetic */ ArrowPosition[] $VALUES = null;
    public static final ArrowPosition CENTER = null;
    public static final ArrowPosition END = null;
    public static final ArrowPosition START = null;

    private static final /* synthetic */ ArrowPosition[] $values() {
        return new ArrowPosition[]{CENTER, START, END};
    }

    public static ArrowPosition valueOf(String r100) {
        return (ArrowPosition) a.a(ArrowPosition.class, r100);
    }

    public static ArrowPosition[] values() {
        return (ArrowPosition[]) $VALUES.clone();
    }

    static {
        CENTER = new ArrowPosition("CENTER", 0);
        START = new ArrowPosition(GXAnimation.STATE_START, 1);
        END = new ArrowPosition(GXAnimation.STATE_END, 2);
        $VALUES = $values();
    }

    private ArrowPosition(String r100, int r101) {
        super(r100, r101);
    }
}
