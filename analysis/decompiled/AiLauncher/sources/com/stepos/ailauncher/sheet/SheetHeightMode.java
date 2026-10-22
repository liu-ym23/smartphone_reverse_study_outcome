package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "", "", "wireValue", "<init>", "(Ljava/lang/String;II)V", "I", "getWireValue", "()I", "Companion", Const.INTENT_KEY_APIKEY, "FULL_9", "HALF_EXPANDABLE", "MINIFY_EXPANDABLE", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SheetHeightMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SheetHeightMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final SheetHeightMode FULL_9 = new SheetHeightMode("FULL_9", 0, 0);
    public static final SheetHeightMode HALF_EXPANDABLE = new SheetHeightMode("HALF_EXPANDABLE", 1, 1);
    public static final SheetHeightMode MINIFY_EXPANDABLE = new SheetHeightMode("MINIFY_EXPANDABLE", 2, 3);
    private final int wireValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetHeightMode$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.SheetHeightMode$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SheetHeightMode a(int value) {
            SheetHeightMode next;
            Iterator<SheetHeightMode> it = SheetHeightMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getWireValue() == value) {
                    break;
                }
            }
            SheetHeightMode sheetHeightMode = next;
            return sheetHeightMode == null ? value == 2 ? SheetHeightMode.HALF_EXPANDABLE : SheetHeightMode.FULL_9 : sheetHeightMode;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ SheetHeightMode[] $values() {
        return new SheetHeightMode[]{FULL_9, HALF_EXPANDABLE, MINIFY_EXPANDABLE};
    }

    static {
        SheetHeightMode[] sheetHeightModeArr$values = $values();
        $VALUES = sheetHeightModeArr$values;
        $ENTRIES = kotlin.enums.a.a(sheetHeightModeArr$values);
        INSTANCE = new Companion(null);
    }

    private SheetHeightMode(String str, int i10, int i11) {
        this.wireValue = i11;
    }

    public static InterfaceC4149a<SheetHeightMode> getEntries() {
        return $ENTRIES;
    }

    public static SheetHeightMode valueOf(String str) {
        return (SheetHeightMode) Enum.valueOf(SheetHeightMode.class, str);
    }

    public static SheetHeightMode[] values() {
        return (SheetHeightMode[]) $VALUES.clone();
    }

    public final int getWireValue() {
        return this.wireValue;
    }
}
