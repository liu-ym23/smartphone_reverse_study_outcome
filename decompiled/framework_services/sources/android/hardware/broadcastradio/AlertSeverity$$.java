package android.hardware.broadcastradio;

import java.lang.reflect.Array;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public interface AlertSeverity$$ {
    static String toString(int _aidl_v) {
        if (_aidl_v != 0) goto L6;
        return "EXTREME";
    L6:
        if (_aidl_v != 1) goto L10;
        return "SEVERE";
    L10:
        if (_aidl_v != 2) goto L14;
        return "MODERATE";
    L14:
        if (_aidl_v != 3) goto L18;
        return "MINOR";
    L18:
        if (_aidl_v != 4) goto L22;
        return "UNKNOWN";
    L22:
        return Integer.toString(_aidl_v);
    }

    static String arrayToString(Object _aidl_v) {
        if (_aidl_v != null) goto L5;
        return "null";
    L5:
        Class<?> _aidl_cls = _aidl_v.getClass();
        if (_aidl_cls.isArray() == false) goto L25;
        Class<?> comp = _aidl_cls.getComponentType();
        StringJoiner _aidl_sj = new StringJoiner(", ", "[", "]");
        if (comp.isArray() == false) goto L15;
        int _aidl_i = 0;
    L11:
        if (_aidl_i >= Array.getLength(_aidl_v)) goto L21;
        _aidl_sj.add(arrayToString(Array.get(_aidl_v, _aidl_i)));
        _aidl_i = _aidl_i + 1;
    L21:
        return _aidl_sj.toString();
    L15:
        if (_aidl_cls != int[].class) goto L23;
        int[] r3 = (int[]) _aidl_v;
        int r4 = r3.length;
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L21;
        int e = r3[r5];
        _aidl_sj.add(toString(e));
        r5 = r5 + 1;
        goto L18
    L23:
        throw new IllegalArgumentException("wrong type: " + _aidl_cls);
    L25:
        throw new IllegalArgumentException("not an array: " + _aidl_v);
    }
}
