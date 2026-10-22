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
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(callbacks = Callback.class, remover = "removeTextChangedListener", setter = "addTextChangedListener", targetType = AndroidComposeViewAccessibilityDelegateCompat.TextClassName, type = "android.text.TextWatcher")
public @interface OnTextChanged {

    public static final enum Callback extends Enum<Callback> {
        private static final /* synthetic */ Callback[] $VALUES = null;

        @ListenerMethod(name = "afterTextChanged", parameters = {"android.text.Editable"})
        public static final Callback AFTER_TEXT_CHANGED = null;

        @ListenerMethod(name = "beforeTextChanged", parameters = {"java.lang.CharSequence", "int", "int", "int"})
        public static final Callback BEFORE_TEXT_CHANGED = null;

        @ListenerMethod(name = "onTextChanged", parameters = {"java.lang.CharSequence", "int", "int", "int"})
        public static final Callback TEXT_CHANGED = null;

        static {
            Callback r100 = new Callback("TEXT_CHANGED", 0);
            TEXT_CHANGED = r100;
            Callback r101 = new Callback("BEFORE_TEXT_CHANGED", 1);
            BEFORE_TEXT_CHANGED = r101;
            Callback r102 = new Callback("AFTER_TEXT_CHANGED", 2);
            AFTER_TEXT_CHANGED = r102;
            $VALUES = new Callback[]{r100, r101, r102};
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

    Callback callback() default Callback.TEXT_CHANGED;

    int[] value() default {-1};
}
