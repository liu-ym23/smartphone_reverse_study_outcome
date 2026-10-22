package androidx.compose.runtime.internal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", AppAgent.CONSTRUCT, "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "get", "key", "", "trySet", "", "value", "newWith", "find", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ThreadMap {
    public static final int $stable = 8;
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int i, long[] jArr, Object[] objArr) {
        this.size = i;
        this.keys = jArr;
        this.values = objArr;
    }

    private final int find(long key) {
        int i = this.size - 1;
        if (i != -1) {
            int i6 = 0;
            if (i != 0) {
                while (i6 <= i) {
                    int i10 = (i6 + i) >>> 1;
                    long j5 = this.keys[i10] - key;
                    if (j5 < 0) {
                        i6 = i10 + 1;
                    } else {
                        if (j5 <= 0) {
                            return i10;
                        }
                        i = i10 - 1;
                    }
                }
                return -(i6 + 1);
            }
            long j6 = this.keys[0];
            if (j6 == key) {
                return 0;
            }
            if (j6 > key) {
                return -2;
            }
        }
        return -1;
    }

    public final Object get(long key) {
        int iFind = find(key);
        if (iFind >= 0) {
            return this.values[iFind];
        }
        return null;
    }

    public final ThreadMap newWith(long key, Object value) {
        int i = this.size;
        int i6 = 0;
        int i10 = 0;
        for (Object obj : this.values) {
            if (obj != null) {
                i10++;
            }
        }
        int i11 = i10 + 1;
        long[] jArr = new long[i11];
        Object[] objArr = new Object[i11];
        if (i11 > 1) {
            int i12 = 0;
            while (true) {
                if (i6 >= i11 || i12 >= i) {
                    break;
                }
                long j5 = this.keys[i12];
                Object obj2 = this.values[i12];
                if (j5 > key) {
                    jArr[i6] = key;
                    objArr[i6] = value;
                    i6++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i6] = j5;
                    objArr[i6] = obj2;
                    i6++;
                }
                i12++;
            }
            if (i12 == i) {
                jArr[i10] = key;
                objArr[i10] = value;
            } else {
                while (i6 < i11) {
                    long j6 = this.keys[i12];
                    Object obj3 = this.values[i12];
                    if (obj3 != null) {
                        jArr[i6] = j6;
                        objArr[i6] = obj3;
                        i6++;
                    }
                    i12++;
                }
            }
        } else {
            jArr[0] = key;
            objArr[0] = value;
        }
        return new ThreadMap(i11, jArr, objArr);
    }

    public final boolean trySet(long key, Object value) {
        int iFind = find(key);
        if (iFind < 0) {
            return false;
        }
        this.values[iFind] = value;
        return true;
    }
}
