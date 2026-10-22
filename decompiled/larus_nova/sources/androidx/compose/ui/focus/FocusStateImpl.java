package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/focus/FocusStateImpl;", "Landroidx/compose/ui/focus/FocusState;", "", "<init>", "(Ljava/lang/String;I)V", "Active", "ActiveParent", "Captured", "Inactive", "isFocused", "", "()Z", "hasFocus", "getHasFocus", "isCaptured", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FocusStateImpl extends Enum<FocusStateImpl> implements FocusState {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FocusStateImpl[] $VALUES = null;
    public static final FocusStateImpl Active = null;
    public static final FocusStateImpl ActiveParent = null;
    public static final FocusStateImpl Captured = null;
    public static final FocusStateImpl Inactive = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[FocusStateImpl.values().length];
            r100[FocusStateImpl.Captured.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FocusStateImpl.Active.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FocusStateImpl.ActiveParent.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FocusStateImpl.Inactive.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ FocusStateImpl[] $values() {
        return new FocusStateImpl[]{Active, ActiveParent, Captured, Inactive};
    }

    public static EnumEntries<FocusStateImpl> getEntries() {
        return $ENTRIES;
    }

    static {
        Active = new FocusStateImpl("Active", 0);
        ActiveParent = new FocusStateImpl("ActiveParent", 1);
        Captured = new FocusStateImpl("Captured", 2);
        Inactive = new FocusStateImpl("Inactive", 3);
        FocusStateImpl[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FocusStateImpl[] values() {
        return (FocusStateImpl[]) $VALUES.clone();
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean getHasFocus() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 != 3) goto L9;
        return true;
    L9:
        if (r100 != 4) goto L12;
        return false;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean isCaptured() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
    L13:
        return false;
    L7:
        if (r100 == 3) goto L13;
        if (r100 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean isFocused() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 != 3) goto L9;
    L13:
        return false;
    L9:
        if (r100 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public static FocusStateImpl valueOf(String r100) {
        return (FocusStateImpl) a.a(FocusStateImpl.class, r100);
    }

    private FocusStateImpl(String r100, int r101) {
        super(r100, r101);
    }
}
