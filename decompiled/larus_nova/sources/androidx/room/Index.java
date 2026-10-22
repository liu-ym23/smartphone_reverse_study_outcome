package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes17.dex */
@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface Index {

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order ASC = null;
        public static final Order DESC = null;

        static {
            Order r100 = new Order("ASC", 0);
            ASC = r100;
            Order r101 = new Order("DESC", 1);
            DESC = r101;
            $VALUES = new Order[]{r100, r101};
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }

        public static Order valueOf(String r100) {
            return (Order) r27.a.a(Order.class, r100);
        }

        private Order(String r100, int r101) {
            super(r100, r101);
        }
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
