package com.stepos.ability.screenops;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ability/screenops/TriggerType;", "", "", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", Const.INTENT_KEY_APIKEY, "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_TOP_RESUMED_GAINED", "ON_TOP_RESUMED_LOST", "FIRST_TRAVERSALS", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TriggerType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TriggerType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final TriggerType ON_START = new TriggerType("ON_START", 0, 1);
    public static final TriggerType ON_RESUME = new TriggerType("ON_RESUME", 1, 2);
    public static final TriggerType ON_PAUSE = new TriggerType("ON_PAUSE", 2, 3);
    public static final TriggerType ON_STOP = new TriggerType("ON_STOP", 3, 4);
    public static final TriggerType ON_DESTROY = new TriggerType("ON_DESTROY", 4, 5);
    public static final TriggerType ON_TOP_RESUMED_GAINED = new TriggerType("ON_TOP_RESUMED_GAINED", 5, 8);
    public static final TriggerType ON_TOP_RESUMED_LOST = new TriggerType("ON_TOP_RESUMED_LOST", 6, 9);
    public static final TriggerType FIRST_TRAVERSALS = new TriggerType("FIRST_TRAVERSALS", 7, 20);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ability/screenops/TriggerType$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lcom/stepos/ability/screenops/TriggerType;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/ability/screenops/TriggerType;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.screenops.TriggerType$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TriggerType a(int value) {
            TriggerType next;
            Iterator<TriggerType> it = TriggerType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getValue() == value) {
                    break;
                }
            }
            return next;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ TriggerType[] $values() {
        return new TriggerType[]{ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_TOP_RESUMED_GAINED, ON_TOP_RESUMED_LOST, FIRST_TRAVERSALS};
    }

    static {
        TriggerType[] triggerTypeArr$values = $values();
        $VALUES = triggerTypeArr$values;
        $ENTRIES = a.a(triggerTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private TriggerType(String str, int i10, int i11) {
        this.value = i11;
    }

    public static InterfaceC4149a<TriggerType> getEntries() {
        return $ENTRIES;
    }

    public static TriggerType valueOf(String str) {
        return (TriggerType) Enum.valueOf(TriggerType.class, str);
    }

    public static TriggerType[] values() {
        return (TriggerType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
