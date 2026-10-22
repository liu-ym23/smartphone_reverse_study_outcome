package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.a;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class FlexObjectConverter implements PropertyConverter<Object, byte[]> {
    private static final AtomicReference<a> cachedBuilder = new AtomicReference<>();

    private void addMap(a aVar, String str, Map<Object, Object> map) {
        int iZ = aVar.z();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new IllegalArgumentException("Map keys must not be null");
            }
            checkMapKeyType(key);
            String string = key.toString();
            if (value == null) {
                aVar.w(string);
            } else if (value instanceof Map) {
                addMap(aVar, string, (Map) value);
            } else if (value instanceof List) {
                addVector(aVar, string, (List) value);
            } else if (value instanceof String) {
                aVar.y(string, (String) value);
            } else if (value instanceof Boolean) {
                aVar.k(string, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                aVar.s(string, ((Byte) value).intValue());
            } else if (value instanceof Short) {
                aVar.s(string, ((Short) value).intValue());
            } else if (value instanceof Integer) {
                aVar.s(string, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                aVar.t(string, ((Long) value).longValue());
            } else if (value instanceof Float) {
                aVar.p(string, ((Float) value).floatValue());
            } else if (value instanceof Double) {
                aVar.o(string, ((Double) value).doubleValue());
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalArgumentException("Map values of this type are not supported: " + value.getClass().getSimpleName());
                }
                aVar.i(string, (byte[]) value);
            }
        }
        aVar.f(str, iZ);
    }

    private void addValue(a aVar, Object obj) {
        if (obj instanceof Map) {
            addMap(aVar, null, (Map) obj);
            return;
        }
        if (obj instanceof List) {
            addVector(aVar, null, (List) obj);
            return;
        }
        if (obj instanceof String) {
            aVar.x((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            aVar.l(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            aVar.q(((Byte) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            aVar.q(((Short) obj).intValue());
            return;
        }
        if (obj instanceof Integer) {
            aVar.q(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            aVar.r(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            aVar.n(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.m(((Double) obj).doubleValue());
        } else {
            if (obj instanceof byte[]) {
                aVar.j((byte[]) obj);
                return;
            }
            throw new IllegalArgumentException("Values of this type are not supported: " + obj.getClass().getSimpleName());
        }
    }

    private void addVector(a aVar, String str, List<Object> list) {
        int iA = aVar.A();
        for (Object obj : list) {
            if (obj == null) {
                aVar.v();
            } else if (obj instanceof Map) {
                addMap(aVar, null, (Map) obj);
            } else if (obj instanceof List) {
                addVector(aVar, null, (List) obj);
            } else if (obj instanceof String) {
                aVar.x((String) obj);
            } else if (obj instanceof Boolean) {
                aVar.l(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                aVar.q(((Byte) obj).intValue());
            } else if (obj instanceof Short) {
                aVar.q(((Short) obj).intValue());
            } else if (obj instanceof Integer) {
                aVar.q(((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                aVar.r(((Long) obj).longValue());
            } else if (obj instanceof Float) {
                aVar.n(((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                aVar.m(((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof byte[])) {
                    throw new IllegalArgumentException("List values of this type are not supported: " + obj.getClass().getSimpleName());
                }
                aVar.j((byte[]) obj);
            }
        }
        aVar.g(str, iA, false, false);
    }

    private List<Object> buildList(FlexBuffers.j jVar) {
        int iB = jVar.b();
        ArrayList arrayList = new ArrayList(iB);
        Boolean boolValueOf = null;
        for (int i10 = 0; i10 < iB; i10++) {
            FlexBuffers.f fVarD = jVar.d(i10);
            if (fVarD.s()) {
                arrayList.add(null);
            } else if (fVarD.r()) {
                arrayList.add(buildMap(fVarD.h()));
            } else if (fVarD.u()) {
                arrayList.add(buildList(fVarD.k()));
            } else if (fVarD.t()) {
                arrayList.add(fVarD.i());
            } else if (fVarD.n()) {
                arrayList.add(Boolean.valueOf(fVarD.c()));
            } else if (fVarD.p()) {
                if (boolValueOf == null) {
                    boolValueOf = Boolean.valueOf(shouldRestoreAsLong(fVarD));
                }
                if (boolValueOf.booleanValue()) {
                    arrayList.add(Long.valueOf(fVarD.g()));
                } else {
                    arrayList.add(Integer.valueOf(fVarD.e()));
                }
            } else if (fVarD.o()) {
                arrayList.add(Double.valueOf(fVarD.d()));
            } else {
                if (!fVarD.m()) {
                    throw new IllegalArgumentException("List values of this type are not supported: " + fVarD.getClass().getSimpleName());
                }
                arrayList.add(fVarD.b().d());
            }
        }
        return arrayList;
    }

    private Map<Object, Object> buildMap(FlexBuffers.d dVar) {
        int iB = dVar.b();
        FlexBuffers.c cVarF = dVar.f();
        FlexBuffers.j jVarG = dVar.g();
        HashMap map = new HashMap((int) ((iB / 0.75d) + 1.0d));
        for (int i10 = 0; i10 < iB; i10++) {
            Object objConvertToKey = convertToKey(cVarF.a(i10).toString());
            FlexBuffers.f fVarD = jVarG.d(i10);
            if (fVarD.s()) {
                map.put(objConvertToKey, null);
            } else if (fVarD.r()) {
                map.put(objConvertToKey, buildMap(fVarD.h()));
            } else if (fVarD.u()) {
                map.put(objConvertToKey, buildList(fVarD.k()));
            } else if (fVarD.t()) {
                map.put(objConvertToKey, fVarD.i());
            } else if (fVarD.n()) {
                map.put(objConvertToKey, Boolean.valueOf(fVarD.c()));
            } else if (fVarD.p()) {
                if (shouldRestoreAsLong(fVarD)) {
                    map.put(objConvertToKey, Long.valueOf(fVarD.g()));
                } else {
                    map.put(objConvertToKey, Integer.valueOf(fVarD.e()));
                }
            } else if (fVarD.o()) {
                map.put(objConvertToKey, Double.valueOf(fVarD.d()));
            } else {
                if (!fVarD.m()) {
                    throw new IllegalArgumentException("Map values of this type are not supported: " + fVarD.getClass().getSimpleName());
                }
                map.put(objConvertToKey, fVarD.b().d());
            }
        }
        return map;
    }

    public void checkMapKeyType(Object obj) {
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException("Map keys must be String");
        }
    }

    public Object convertToKey(String str) {
        return str;
    }

    public boolean shouldRestoreAsLong(FlexBuffers.f fVar) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = fVar.getClass().getDeclaredField("parentWidth");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(fVar)).intValue() == 8;
        } catch (Exception e10) {
            throw new RuntimeException("FlexMapConverter could not determine FlexBuffers integer bit width.", e10);
        }
    }

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(Object obj) {
        if (obj == null) {
            return null;
        }
        AtomicReference<a> atomicReference = cachedBuilder;
        a andSet = atomicReference.getAndSet(null);
        if (andSet == null) {
            andSet = new a(new S8.a(512), 3);
        }
        addValue(andSet, obj);
        ByteBuffer byteBufferH = andSet.h();
        byte[] bArr = new byte[byteBufferH.limit()];
        byteBufferH.get(bArr);
        if (byteBufferH.limit() <= 262144) {
            andSet.c();
            atomicReference.getAndSet(andSet);
        }
        return bArr;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public Object convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.f fVarG = FlexBuffers.g(new S8.a(bArr, bArr.length));
        if (fVarG.s()) {
            return null;
        }
        if (fVarG.r()) {
            return buildMap(fVarG.h());
        }
        if (fVarG.u()) {
            return buildList(fVarG.k());
        }
        if (fVarG.t()) {
            return fVarG.i();
        }
        if (fVarG.n()) {
            return Boolean.valueOf(fVarG.c());
        }
        if (fVarG.p()) {
            return shouldRestoreAsLong(fVarG) ? Long.valueOf(fVarG.g()) : Integer.valueOf(fVarG.e());
        }
        if (fVarG.o()) {
            return Double.valueOf(fVarG.d());
        }
        if (fVarG.m()) {
            return fVarG.b().d();
        }
        throw new IllegalArgumentException("FlexBuffers type is not supported: " + fVarG.l());
    }
}
