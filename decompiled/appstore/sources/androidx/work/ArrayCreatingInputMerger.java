package androidx.work;

import com.bytedance.apm.constant.CommonKey;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/e;", "<init>", "()V", "", "Landroidx/work/c;", "inputs", "b", "(Ljava/util/List;)Landroidx/work/c;", "", "array1", "array2", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "array", "obj", "Ljava/lang/Class;", "valueClass", "c", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArrayCreatingInputMerger extends e {
    public ArrayCreatingInputMerger() {
    }

    @Override // androidx.work.e
    public c b(List r10) {
        q.g(r10, "inputs");
        c.a r11 = new c.a();
        HashMap r12 = new HashMap();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L27;
        Map r14 = ((c) r13.next()).h();
        q.f(r14, "input.keyValueMap");
        Iterator r15 = r14.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L4;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        Object r18 = r16.getValue();
        if (r18 == null) goto L11;
        Class<?> r19 = r18.getClass();
    L12:
        Object r20 = r12.get(r17);
        q.f(r17, "key");
        if (r20 == null) goto L15;
        Class<?> r21 = r20.getClass();
        if (q.b(r21, r19) == false) goto L22;
        q.f(r18, CommonKey.KEY_VALUE);
        r18 = d(r20, r18);
    L24:
        q.f(r18, "if (existingValue == nul…      }\n                }");
        r12.put(r17, r18);
        goto L7
    L22:
        if (q.b(r21.getComponentType(), r19) == false) goto L26;
        r18 = c(r20, r18, r19);
        goto L24
    L26:
        throw new IllegalArgumentException();
    L15:
        if (r19.isArray() == true) goto L24;
        r18 = e(r18, r19);
        goto L24
    L11:
        r19 = String.class;
        goto L12
    L27:
        r11.c(r12);
        c r22 = r11.a();
        q.f(r22, "output.build()");
        return r22;
    }

    public final Object c(Object r10, Object r11, Class r12) {
        int r13 = Array.getLength(r10);
        Object r14 = Array.newInstance(r12, r13 + 1);
        System.arraycopy(r10, 0, r14, 0, r13);
        Array.set(r14, r13, r11);
        q.f(r14, "newArray");
        return r14;
    }

    public final Object d(Object r10, Object r11) {
        int r12 = Array.getLength(r10);
        int r13 = Array.getLength(r11);
        Class<?> r14 = r10.getClass().getComponentType();
        q.d(r14);
        Object r15 = Array.newInstance(r14, r12 + r13);
        System.arraycopy(r10, 0, r15, 0, r12);
        System.arraycopy(r11, 0, r15, r12, r13);
        q.f(r15, "newArray");
        return r15;
    }

    public final Object e(Object r10, Class r11) {
        Object r12 = Array.newInstance(r11, 1);
        Array.set(r12, 0, r10);
        q.f(r12, "newArray");
        return r12;
    }
}
