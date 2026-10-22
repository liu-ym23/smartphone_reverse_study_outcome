package androidx.work;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    public ArrayCreatingInputMerger() {
    }

    private Object createArrayFor(Object r100) {
        Object r101 = Array.newInstance(r100.getClass(), 1);
        Array.set(r101, 0, r100);
        return r101;
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> r110) {
        Data.Builder r100 = new Data.Builder();
        HashMap r101 = new HashMap();
        Iterator<Data> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L33;
        Iterator<Map.Entry<String, Object>> r102 = r111.next().getKeyValueMap().entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Map.Entry<String, Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        Class<?> r106 = r105.getClass();
        Object r107 = r101.get(r104);
        if (r107 == null) goto L11;
        Class<?> r108 = r107.getClass();
        if (r108.equals(r106) == false) goto L21;
        if (r108.isArray() == false) goto L19;
        r105 = concatenateArrays(r107, r105);
    L30:
        r101.put(r104, r105);
        goto L7
    L19:
        r105 = concatenateNonArrays(r107, r105);
        goto L30
    L21:
        if (r108.isArray() == false) goto L26;
        if (r108.getComponentType().equals(r106) == false) goto L26;
        r105 = concatenateArrayAndNonArray(r107, r105);
    L26:
        if (r106.isArray() == false) goto L32;
        if (r106.getComponentType().equals(r108) == false) goto L32;
        r105 = concatenateArrayAndNonArray(r105, r107);
    L32:
        throw new IllegalArgumentException();
    L11:
        if (r106.isArray() == true) goto L30;
        r105 = createArrayFor(r105);
        goto L30
    L33:
        r100.putAll(r101);
        return r100.build();
    }

    private Object concatenateArrayAndNonArray(Object r100, Object r101) {
        int r102 = Array.getLength(r100);
        Object r103 = Array.newInstance(r101.getClass(), r102 + 1);
        System.arraycopy(r100, 0, r103, 0, r102);
        Array.set(r103, r102, r101);
        return r103;
    }

    private Object concatenateArrays(Object r100, Object r101) {
        int r102 = Array.getLength(r100);
        int r103 = Array.getLength(r101);
        Object r104 = Array.newInstance(r100.getClass().getComponentType(), r102 + r103);
        System.arraycopy(r100, 0, r104, 0, r102);
        System.arraycopy(r101, 0, r104, r102, r103);
        return r104;
    }

    private Object concatenateNonArrays(Object r100, Object r101) {
        Object r102 = Array.newInstance(r100.getClass(), 2);
        Array.set(r102, 0, r100);
        Array.set(r102, 1, r101);
        return r102;
    }
}
