package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(callbacks = Callback.class, remover = "removeOnPageChangeListener", setter = "addOnPageChangeListener", targetType = "androidx.viewpager.widget.ViewPager", type = "androidx.viewpager.widget.ViewPager.OnPageChangeListener")
public @interface OnPageChange {

    public static final enum Callback extends Enum<Callback> {
        private static final /* synthetic */ Callback[] $VALUES = null;

        @ListenerMethod(name = "onPageScrolled", parameters = {"int", "float", "int"})
        public static final Callback PAGE_SCROLLED = null;

        @ListenerMethod(name = "onPageScrollStateChanged", parameters = {"int"})
        public static final Callback PAGE_SCROLL_STATE_CHANGED = null;

        @ListenerMethod(name = "onPageSelected", parameters = {"int"})
        public static final Callback PAGE_SELECTED = null;

        static {
            Callback r100 = new Callback("PAGE_SELECTED", 0);
            PAGE_SELECTED = r100;
            Callback r101 = new Callback("PAGE_SCROLLED", 1);
            PAGE_SCROLLED = r101;
            Callback r102 = new Callback("PAGE_SCROLL_STATE_CHANGED", 2);
            PAGE_SCROLL_STATE_CHANGED = r102;
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

    Callback callback() default Callback.PAGE_SELECTED;

    int[] value() default {-1};
}
