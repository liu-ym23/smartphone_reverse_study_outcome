package com.stepos.widget.list;

import android.content.Context;
import android.view.View;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.widget.R;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/list/StepOSCardPosition;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "SINGLE", "FIRST", "MIDDLE", "LAST", "cornerRadii", "", "radiusPx", "", "hasTopOutset", "", "hasBottomOutset", "showsDivider", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSCardPosition {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ StepOSCardPosition[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final StepOSCardPosition NONE = new StepOSCardPosition(ModelFlowMeta.PLAN_NONE, 0);
    public static final StepOSCardPosition SINGLE = new StepOSCardPosition("SINGLE", 1);
    public static final StepOSCardPosition FIRST = new StepOSCardPosition("FIRST", 2);
    public static final StepOSCardPosition MIDDLE = new StepOSCardPosition("MIDDLE", 3);
    public static final StepOSCardPosition LAST = new StepOSCardPosition("LAST", 4);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/widget/list/StepOSCardPosition$Companion;", "", "<init>", "()V", "", "prevInGroup", "nextInGroup", "Lcom/stepos/widget/list/StepOSCardPosition;", "of", "(ZZ)Lcom/stepos/widget/list/StepOSCardPosition;", "Landroid/view/View;", "view", "position", "", "radiusPx", "", "normalColor", "LY8/t;", "applyCardBackground", "(Landroid/view/View;Lcom/stepos/widget/list/StepOSCardPosition;FI)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ void applyCardBackground$default(Companion companion, View view, StepOSCardPosition stepOSCardPosition, float f10, int i10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                i10 = view.getContext().getColor(R.color.stepos_list_group_background);
            }
            companion.applyCardBackground(view, stepOSCardPosition, f10, i10);
        }

        public final void applyCardBackground(View view, StepOSCardPosition position, float f10) {
            p.i(view, "view");
            p.i(position, "position");
            applyCardBackground$default(this, view, position, f10, 0, 8, null);
        }

        public final StepOSCardPosition of(boolean prevInGroup, boolean nextInGroup) {
            return (prevInGroup || nextInGroup) ? !prevInGroup ? StepOSCardPosition.FIRST : !nextInGroup ? StepOSCardPosition.LAST : StepOSCardPosition.MIDDLE : StepOSCardPosition.SINGLE;
        }

        private Companion() {
        }

        public final void applyCardBackground(View view, StepOSCardPosition position, float radiusPx, int normalColor) {
            p.i(view, "view");
            p.i(position, "position");
            Context context = view.getContext();
            p.h(context, "getContext(...)");
            view.setBackground(StepOSListItemKt.buildCardStateBackground$default(context, position.cornerRadii(radiusPx), normalColor, false, 8, null));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StepOSCardPosition.values().length];
            try {
                iArr[StepOSCardPosition.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StepOSCardPosition.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StepOSCardPosition.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StepOSCardPosition.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StepOSCardPosition.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ StepOSCardPosition[] $values() {
        return new StepOSCardPosition[]{NONE, SINGLE, FIRST, MIDDLE, LAST};
    }

    static {
        StepOSCardPosition[] stepOSCardPositionArr$values = $values();
        $VALUES = stepOSCardPositionArr$values;
        $ENTRIES = kotlin.enums.a.a(stepOSCardPositionArr$values);
        INSTANCE = new Companion(null);
    }

    private StepOSCardPosition(String str, int i10) {
    }

    public static final void applyCardBackground(View view, StepOSCardPosition stepOSCardPosition, float f10) {
        INSTANCE.applyCardBackground(view, stepOSCardPosition, f10);
    }

    public static InterfaceC4149a<StepOSCardPosition> getEntries() {
        return $ENTRIES;
    }

    public static final StepOSCardPosition of(boolean z10, boolean z11) {
        return INSTANCE.of(z10, z11);
    }

    public static StepOSCardPosition valueOf(String str) {
        return (StepOSCardPosition) Enum.valueOf(StepOSCardPosition.class, str);
    }

    public static StepOSCardPosition[] values() {
        return (StepOSCardPosition[]) $VALUES.clone();
    }

    public final float[] cornerRadii(float radiusPx) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i10 == 1) {
            return new float[]{radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx};
        }
        if (i10 == 2) {
            return new float[]{radiusPx, radiusPx, radiusPx, radiusPx, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (i10 == 3) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, radiusPx, radiusPx, radiusPx, radiusPx};
        }
        if (i10 == 4 || i10 == 5) {
            return new float[8];
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean hasBottomOutset() {
        return this == SINGLE || this == LAST;
    }

    public final boolean hasTopOutset() {
        return this == SINGLE || this == FIRST;
    }

    public final boolean showsDivider() {
        return this == FIRST || this == MIDDLE;
    }

    public static final void applyCardBackground(View view, StepOSCardPosition stepOSCardPosition, float f10, int i10) {
        INSTANCE.applyCardBackground(view, stepOSCardPosition, f10, i10);
    }
}
