package D7;

import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class r extends AbstractC0214f implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f404a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r(Object obj, int i) {
        this.f404a = i;
        this.b = obj;
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        switch (this.f404a) {
            case 0:
                if (!(obj instanceof Integer)) {
                    return false;
                }
                return q.O((int[]) this.b, ((Number) obj).intValue());
            default:
                if (!(obj instanceof Float)) {
                    return false;
                }
                float fFloatValue = ((Number) obj).floatValue();
                for (float f : (float[]) this.b) {
                    if (Float.floatToIntBits(f) == Float.floatToIntBits(fFloatValue)) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        switch (this.f404a) {
            case 0:
                return Integer.valueOf(((int[]) this.b)[i]);
            default:
                return Float.valueOf(((float[]) this.b)[i]);
        }
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    /* renamed from: getSize */
    public final int get_size() {
        switch (this.f404a) {
            case 0:
                return ((int[]) this.b).length;
            default:
                return ((float[]) this.b).length;
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f404a) {
            case 0:
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return q.t0((int[]) this.b, ((Number) obj).intValue());
            default:
                if (!(obj instanceof Float)) {
                    return -1;
                }
                float fFloatValue = ((Number) obj).floatValue();
                float[] fArr = (float[]) this.b;
                int length = fArr.length;
                for (int i = 0; i < length; i++) {
                    if (Float.floatToIntBits(fArr[i]) == Float.floatToIntBits(fFloatValue)) {
                        return i;
                    }
                }
                return -1;
        }
    }

    @Override // D7.AbstractC0209a, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f404a) {
            case 0:
                if (((int[]) this.b).length == 0) {
                }
                break;
            default:
                if (((float[]) this.b).length == 0) {
                }
                break;
        }
        return false;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f404a) {
            case 0:
                if (obj instanceof Integer) {
                    int iIntValue = ((Number) obj).intValue();
                    int[] iArr = (int[]) this.b;
                    kotlin.jvm.internal.k.f(iArr, "<this>");
                    int length = iArr.length - 1;
                    if (length >= 0) {
                        while (true) {
                            int i = length - 1;
                            if (iIntValue == iArr[length]) {
                                break;
                            } else if (i < 0) {
                                break;
                            } else {
                                length = i;
                            }
                        }
                    }
                }
                break;
            default:
                if (obj instanceof Float) {
                    float fFloatValue = ((Number) obj).floatValue();
                    float[] fArr = (float[]) this.b;
                    int length2 = fArr.length - 1;
                    if (length2 >= 0) {
                        while (true) {
                            int i6 = length2 - 1;
                            if (Float.floatToIntBits(fArr[length2]) == Float.floatToIntBits(fFloatValue)) {
                                break;
                            } else if (i6 < 0) {
                                break;
                            } else {
                                length2 = i6;
                            }
                        }
                    }
                }
                break;
        }
        return -1;
    }
}
