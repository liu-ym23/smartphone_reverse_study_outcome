package butterknife;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@ListenerClass(callbacks = Callback.class, setter = "setOnItemSelectedListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemSelectedListener")
public @interface OnItemSelected {

    public static final enum Callback extends Enum<Callback> {
        private static final /* synthetic */ Callback[] $VALUES = null;

        @ListenerMethod(name = "onItemSelected", parameters = {"android.widget.AdapterView<?>", AndroidComposeViewAccessibilityDelegateCompat.ClassName, "int", "long"})
        public static final Callback ITEM_SELECTED = null;

        @ListenerMethod(name = "onNothingSelected", parameters = {"android.widget.AdapterView<?>"})
        public static final Callback NOTHING_SELECTED = null;

        static {
            Callback r100 = new Callback("ITEM_SELECTED", 0);
            ITEM_SELECTED = r100;
            Callback r101 = new Callback("NOTHING_SELECTED", 1);
            NOTHING_SELECTED = r101;
            $VALUES = new Callback[]{r100, r101};
        }

        public static Callback[] values() {
            return (Callback[]) $VALUES.clone();
        }

        public static Callback valueOf(String r100) {
            return (Callback) r27.a.a(Callback.class, r100);
        }

        private Callback(String r100, int r101) {
            super(r100, r101);
        }
    }

    Callback callback() default Callback.ITEM_SELECTED;

    int[] value() default {-1};
}
