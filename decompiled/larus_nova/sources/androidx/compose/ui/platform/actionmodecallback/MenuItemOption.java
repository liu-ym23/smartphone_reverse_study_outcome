package androidx.compose.ui.platform.actionmodecallback;

import android.R;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "Copy", "Paste", "Cut", "SelectAll", "Autofill", "titleResource", "getTitleResource", "order", "getOrder", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MenuItemOption extends Enum<MenuItemOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MenuItemOption[] $VALUES = null;
    public static final MenuItemOption Autofill = null;
    public static final MenuItemOption Copy = null;
    public static final MenuItemOption Cut = null;
    public static final MenuItemOption Paste = null;
    public static final MenuItemOption SelectAll = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15262id;
    private final int order;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[MenuItemOption.values().length];
            r100[MenuItemOption.Copy.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[MenuItemOption.Paste.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[MenuItemOption.Cut.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MenuItemOption.SelectAll.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[MenuItemOption.Autofill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ MenuItemOption[] $values() {
        return new MenuItemOption[]{Copy, Paste, Cut, SelectAll, Autofill};
    }

    public static EnumEntries<MenuItemOption> getEntries() {
        return $ENTRIES;
    }

    static {
        Copy = new MenuItemOption("Copy", 0, 0);
        Paste = new MenuItemOption("Paste", 1, 1);
        Cut = new MenuItemOption("Cut", 2, 2);
        SelectAll = new MenuItemOption("SelectAll", 3, 3);
        Autofill = new MenuItemOption("Autofill", 4, 4);
        MenuItemOption[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MenuItemOption[] values() {
        return (MenuItemOption[]) $VALUES.clone();
    }

    public final int getTitleResource() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 != 1) goto L5;
        return R.string.copy;
    L5:
        if (r100 != 2) goto L7;
        return R.string.paste;
    L7:
        if (r100 != 3) goto L9;
        return R.string.cut;
    L9:
        if (r100 != 4) goto L11;
        return R.string.selectAll;
    L11:
        if (r100 != 5) goto L17;
        if (Build.VERSION.SDK_INT > 26) goto L15;
        return com.larus.nova.R.string.autofill;
    L15:
        return R.string.autofill;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final int getId() {
        return this.f15262id;
    }

    public final int getOrder() {
        return this.order;
    }

    public static MenuItemOption valueOf(String r100) {
        return (MenuItemOption) a.a(MenuItemOption.class, r100);
    }

    private MenuItemOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.f15262id = r102;
        this.order = r102;
    }
}
