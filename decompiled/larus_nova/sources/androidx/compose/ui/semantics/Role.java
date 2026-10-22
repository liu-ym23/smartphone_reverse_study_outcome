package androidx.compose.ui.semantics;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.ss.android.lark.picker.Picker;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Role {
    private static final int Button = 0;
    private static final int Carousel = 0;
    private static final int Checkbox = 0;
    public static final Companion Companion = null;
    private static final int DropdownList = 0;
    private static final int Image = 0;
    private static final int RadioButton = 0;
    private static final int Switch = 0;
    private static final int Tab = 0;
    private static final int ValuePicker = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "<init>", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", UserChangedCallback.CHANGE_TYPE_SWITCH, "getSwitch-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Tab", "getTab-o7Vup1c", "Image", "getImage-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "ValuePicker", "getValuePicker-o7Vup1c", "Carousel", "getCarousel-o7Vup1c", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m6769getButtono7Vup1c() {
            return Role.access$getButton$cp();
        }

        /* JADX INFO: renamed from: getCarousel-o7Vup1c, reason: not valid java name */
        public final int m6770getCarouselo7Vup1c() {
            return Role.access$getCarousel$cp();
        }

        /* JADX INFO: renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m6771getCheckboxo7Vup1c() {
            return Role.access$getCheckbox$cp();
        }

        /* JADX INFO: renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m6772getDropdownListo7Vup1c() {
            return Role.access$getDropdownList$cp();
        }

        /* JADX INFO: renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m6773getImageo7Vup1c() {
            return Role.access$getImage$cp();
        }

        /* JADX INFO: renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m6774getRadioButtono7Vup1c() {
            return Role.access$getRadioButton$cp();
        }

        /* JADX INFO: renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m6775getSwitcho7Vup1c() {
            return Role.access$getSwitch$cp();
        }

        /* JADX INFO: renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m6776getTabo7Vup1c() {
            return Role.access$getTab$cp();
        }

        /* JADX INFO: renamed from: getValuePicker-o7Vup1c, reason: not valid java name */
        public final int m6777getValuePickero7Vup1c() {
            return Role.access$getValuePicker$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m6762boximpl(int r100) {
        return new Role(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m6763constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6764equalsimpl(int r100, Object r101) {
        if ((r101 instanceof Role) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Role) r101).m6768unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6765equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6766hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m6764equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6766hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6768unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Button = m6763constructorimpl(0);
        Checkbox = m6763constructorimpl(1);
        Switch = m6763constructorimpl(2);
        RadioButton = m6763constructorimpl(3);
        Tab = m6763constructorimpl(4);
        Image = m6763constructorimpl(5);
        DropdownList = m6763constructorimpl(6);
        ValuePicker = m6763constructorimpl(7);
        Carousel = m6763constructorimpl(8);
    }

    public String toString() {
        return m6767toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getButton$cp() {
        return Button;
    }

    public static final /* synthetic */ int access$getCarousel$cp() {
        return Carousel;
    }

    public static final /* synthetic */ int access$getCheckbox$cp() {
        return Checkbox;
    }

    public static final /* synthetic */ int access$getDropdownList$cp() {
        return DropdownList;
    }

    public static final /* synthetic */ int access$getImage$cp() {
        return Image;
    }

    public static final /* synthetic */ int access$getRadioButton$cp() {
        return RadioButton;
    }

    public static final /* synthetic */ int access$getSwitch$cp() {
        return Switch;
    }

    public static final /* synthetic */ int access$getTab$cp() {
        return Tab;
    }

    public static final /* synthetic */ int access$getValuePicker$cp() {
        return ValuePicker;
    }

    private /* synthetic */ Role(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6767toStringimpl(int r100) {
        if (m6765equalsimpl0(r100, Button) == false) goto L6;
        return "Button";
    L6:
        if (m6765equalsimpl0(r100, Checkbox) == false) goto L9;
        return "Checkbox";
    L9:
        if (m6765equalsimpl0(r100, Switch) == false) goto L12;
        return UserChangedCallback.CHANGE_TYPE_SWITCH;
    L12:
        if (m6765equalsimpl0(r100, RadioButton) == false) goto L15;
        return "RadioButton";
    L15:
        if (m6765equalsimpl0(r100, Tab) == false) goto L18;
        return "Tab";
    L18:
        if (m6765equalsimpl0(r100, Image) == false) goto L21;
        return "Image";
    L21:
        if (m6765equalsimpl0(r100, DropdownList) == false) goto L24;
        return "DropdownList";
    L24:
        if (m6765equalsimpl0(r100, ValuePicker) == false) goto L27;
        return Picker.TAG;
    L27:
        if (m6765equalsimpl0(r100, Carousel) == false) goto L29;
        return "Carousel";
    L29:
        return "Unknown";
    }
}
