package android.os.collector.base;

import android.util.ArrayMap;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class Field {
    public final Supplier<Object> getter;
    final Supplier<?> msgCtor;
    final Function<Object, Field[]> msgFieldsFn;
    public final String name;
    public final Consumer<Object> setter;
    public final Type type;

    public enum Type {
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        BOOL,
        STRING,
        INT_ARRAY,
        LONG_ARRAY,
        FLOAT_ARRAY,
        BOOL_ARRAY,
        STRING_ARRAY,
        STRING_MAP,
        MESSAGE,
        MESSAGE_LIST
    }

    private Field(String n, Type t, Supplier<Object> g, Consumer<Object> s) {
        this(n, t, g, s, null, null);
    }

    private Field(String n, Type t, Supplier<Object> g, Consumer<Object> s, Supplier<?> ctor, Function<Object, Field[]> fieldsFn) {
        this.name = n;
        this.type = t;
        this.getter = g;
        this.setter = s;
        this.msgCtor = ctor;
        this.msgFieldsFn = fieldsFn;
    }

    public static Field ofInt(String n, final IntSupplier g, final IntConsumer s) {
        Type type = Type.INT;
        Objects.requireNonNull(g);
        return new Field(n, type, new Supplier() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(g.getAsInt());
            }
        }, new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept(((Integer) obj).intValue());
            }
        });
    }

    public static Field ofLong(String n, final LongSupplier g, final LongConsumer s) {
        Type type = Type.LONG;
        Objects.requireNonNull(g);
        return new Field(n, type, new Supplier() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return Long.valueOf(g.getAsLong());
            }
        }, new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept(((Long) obj).longValue());
            }
        });
    }

    public static Field ofFloat(String n, Supplier<Float> g, final Consumer<Float> s) {
        Type type = Type.FLOAT;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda10
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((Float) obj);
            }
        });
    }

    public static Field ofDouble(String n, Supplier<Double> g, final Consumer<Double> s) {
        Type type = Type.DOUBLE;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((Double) obj);
            }
        });
    }

    public static Field ofBool(String n, final BooleanSupplier g, final Consumer<Boolean> s) {
        Type type = Type.BOOL;
        Objects.requireNonNull(g);
        return new Field(n, type, new Supplier() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda18
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(g.getAsBoolean());
            }
        }, new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda19
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((Boolean) obj);
            }
        });
    }

    public static Field ofString(String n, Supplier<String> g, final Consumer<String> s) {
        Type type = Type.STRING;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((String) obj);
            }
        });
    }

    public static Field ofIntArray(String n, Supplier<int[]> g, final Consumer<int[]> s) {
        Type type = Type.INT_ARRAY;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((int[]) obj);
            }
        });
    }

    public static Field ofLongArray(String n, Supplier<long[]> g, final Consumer<long[]> s) {
        Type type = Type.LONG_ARRAY;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((long[]) obj);
            }
        });
    }

    public static Field ofFloatArray(String n, Supplier<float[]> g, final Consumer<float[]> s) {
        Type type = Type.FLOAT_ARRAY;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((float[]) obj);
            }
        });
    }

    public static Field ofBoolArray(String n, Supplier<boolean[]> g, final Consumer<boolean[]> s) {
        Type type = Type.BOOL_ARRAY;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((boolean[]) obj);
            }
        });
    }

    public static Field ofStringArray(String n, Supplier<String[]> g, final Consumer<String[]> s) {
        Type type = Type.STRING_ARRAY;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda14
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((String[]) obj);
            }
        });
    }

    public static Field ofStringMap(String n, Supplier<ArrayMap<String, String>> g, final Consumer<ArrayMap<String, String>> s) {
        Type type = Type.STRING_MAP;
        Objects.requireNonNull(g);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(g), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                s.accept((ArrayMap) obj);
            }
        });
    }

    public static <T extends StepOSSubFieldHolder> Field ofMessage(String n, Supplier<T> getter, final Consumer<T> setter, Supplier<T> ctor, final Function<T, Field[]> fieldsFn) {
        Type type = Type.MESSAGE;
        Objects.requireNonNull(getter);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(getter), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                setter.accept((StepOSSubFieldHolder) obj);
            }
        }, ctor, new Function() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Field.lambda$ofMessage$13(fieldsFn, obj);
            }
        });
    }

    static /* synthetic */ Field[] lambda$ofMessage$13(Function fieldsFn, Object obj) {
        return (Field[]) fieldsFn.apply((StepOSSubFieldHolder) obj);
    }

    public static <T extends StepOSSubFieldHolder> Field ofMessageList(String n, Supplier<List<T>> getter, final Consumer<List<T>> setter, Supplier<T> ctor, final Function<T, Field[]> fieldsFn) {
        Type type = Type.MESSAGE_LIST;
        Objects.requireNonNull(getter);
        return new Field(n, type, new Field$$ExternalSyntheticLambda0(getter), new Consumer() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                setter.accept((List) obj);
            }
        }, ctor, new Function() { // from class: android.os.collector.base.Field$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Field.lambda$ofMessageList$15(fieldsFn, obj);
            }
        });
    }

    static /* synthetic */ Field[] lambda$ofMessageList$15(Function fieldsFn, Object obj) {
        return (Field[]) fieldsFn.apply((StepOSSubFieldHolder) obj);
    }
}
