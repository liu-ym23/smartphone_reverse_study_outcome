package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public abstract class GenericProperty extends Property {
    private Class<?>[] actualClasses;
    private boolean actualClassesChecked;
    private final Type genType;

    public GenericProperty(String str, Class<?> cls, Type type) {
        super(str, cls);
        this.genType = type;
        this.actualClassesChecked = type == null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        if (!this.actualClassesChecked) {
            Type type = this.genType;
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments.length > 0) {
                    this.actualClasses = new Class[actualTypeArguments.length];
                    int i10 = 0;
                    while (true) {
                        if (i10 >= actualTypeArguments.length) {
                            break;
                        }
                        Type type2 = actualTypeArguments[i10];
                        if (!(type2 instanceof Class)) {
                            if (!(type2 instanceof ParameterizedType)) {
                                if (!(type2 instanceof GenericArrayType)) {
                                    this.actualClasses = null;
                                    break;
                                }
                                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                                if (!(genericComponentType instanceof Class)) {
                                    this.actualClasses = null;
                                    break;
                                }
                                this.actualClasses[i10] = Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                            } else {
                                this.actualClasses[i10] = (Class) ((ParameterizedType) type2).getRawType();
                            }
                        } else {
                            this.actualClasses[i10] = (Class) type2;
                        }
                        i10++;
                    }
                }
            } else if (type instanceof GenericArrayType) {
                Type genericComponentType2 = ((GenericArrayType) type).getGenericComponentType();
                if (genericComponentType2 instanceof Class) {
                    this.actualClasses = new Class[]{(Class) genericComponentType2};
                }
            } else if ((type instanceof Class) && ((Class) type).isArray()) {
                this.actualClasses = new Class[]{getType().getComponentType()};
            }
            this.actualClassesChecked = true;
        }
        return this.actualClasses;
    }
}
