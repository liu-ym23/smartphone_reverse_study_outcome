package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JDKValueInstantiators {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ArrayListInstantiator extends JDKValueInstantiator {
        static final ArrayListInstantiator INSTANCE = new ArrayListInstantiator();
        private static final long serialVersionUID = 2;

        public ArrayListInstantiator() {
            super(ArrayList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new ArrayList();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ConcurrentHashMapInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public ConcurrentHashMapInstantiator() {
            super(ConcurrentHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new ConcurrentHashMap();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ConstantValueInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;
        protected final Object _value;

        public ConstantValueInstantiator(Object obj) {
            super(obj.getClass());
            this._value = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object createUsingDefault(DeserializationContext deserializationContext) {
            return this._value;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class HashMapInstantiator extends JDKValueInstantiator {
        static final HashMapInstantiator INSTANCE = new HashMapInstantiator();
        private static final long serialVersionUID = 2;

        public HashMapInstantiator() {
            super(HashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new HashMap();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class HashSetInstantiator extends JDKValueInstantiator {
        static final HashSetInstantiator INSTANCE = new HashSetInstantiator();
        private static final long serialVersionUID = 2;

        public HashSetInstantiator() {
            super(HashSet.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new HashSet();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class JDKValueInstantiator extends ValueInstantiator.Base implements Serializable {
        private static final long serialVersionUID = 2;

        public JDKValueInstantiator(Class<?> cls) {
            super(cls);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean canInstantiate() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public abstract Object createUsingDefault(DeserializationContext deserializationContext);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class LinkedHashMapInstantiator extends JDKValueInstantiator {
        static final LinkedHashMapInstantiator INSTANCE = new LinkedHashMapInstantiator();
        private static final long serialVersionUID = 2;

        public LinkedHashMapInstantiator() {
            super(LinkedHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new LinkedHashMap();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class LinkedListInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public LinkedListInstantiator() {
            super(LinkedList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new LinkedList();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class TreeMapInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public TreeMapInstantiator() {
            super(TreeMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new TreeMap();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class TreeSetInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public TreeSetInstantiator() {
            super(TreeSet.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.JDKValueInstantiator, com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new TreeSet();
        }
    }

    public static ValueInstantiator findStdValueInstantiator(DeserializationConfig deserializationConfig, Class<?> cls) {
        if (cls == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        if (!Collection.class.isAssignableFrom(cls)) {
            if (!Map.class.isAssignableFrom(cls)) {
                return null;
            }
            if (cls == LinkedHashMap.class) {
                return LinkedHashMapInstantiator.INSTANCE;
            }
            if (cls == HashMap.class) {
                return HashMapInstantiator.INSTANCE;
            }
            if (cls == ConcurrentHashMap.class) {
                return new ConcurrentHashMapInstantiator();
            }
            if (cls == TreeMap.class) {
                return new TreeMapInstantiator();
            }
            Map map = Collections.EMPTY_MAP;
            if (cls == map.getClass()) {
                return new ConstantValueInstantiator(map);
            }
            return null;
        }
        if (cls == ArrayList.class) {
            return ArrayListInstantiator.INSTANCE;
        }
        if (cls == HashSet.class) {
            return HashSetInstantiator.INSTANCE;
        }
        if (cls == LinkedList.class) {
            return new LinkedListInstantiator();
        }
        if (cls == TreeSet.class) {
            return new TreeSetInstantiator();
        }
        Set set = Collections.EMPTY_SET;
        if (cls == set.getClass()) {
            return new ConstantValueInstantiator(set);
        }
        List list = Collections.EMPTY_LIST;
        if (cls == list.getClass()) {
            return new ConstantValueInstantiator(list);
        }
        return null;
    }
}
