package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class o implements t {
    @Override // K1.t
    public final void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        char c10;
        z zVar = mVar.f4048b;
        int i10 = 1;
        boolean z10 = (zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0;
        Type typeY = z10 ? L1.d.y(type) : null;
        if (obj == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                zVar.write("[]");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        if (size == 0) {
            zVar.append("[]");
            return;
        }
        w wVar = mVar.f4059m;
        if ((zVar.f4092c & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            mVar.f4059m = new w(wVar, obj, obj2, 0);
            if (mVar.f4058l == null) {
                mVar.f4058l = new IdentityHashMap<>();
            }
            mVar.f4058l.put(obj, mVar.f4059m);
        }
        try {
            char c11 = ']';
            if ((zVar.f4092c & SerializerFeature.PrettyFormat.mask) != 0) {
                zVar.write(91);
                mVar.l();
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj3 = list.get(i11);
                    if (i11 != 0) {
                        zVar.write(44);
                    }
                    mVar.m();
                    if (obj3 != null) {
                        IdentityHashMap<Object, w> identityHashMap = mVar.f4058l;
                        if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                            t tVarA = mVar.f4047a.a(obj3.getClass());
                            mVar.f4059m = new w(wVar, obj, obj2, 0);
                            tVarA.a(mVar, obj3, Integer.valueOf(i11), typeY);
                        } else {
                            mVar.t(obj3);
                        }
                    } else {
                        mVar.f4048b.Y();
                    }
                }
                mVar.d();
                mVar.m();
                zVar.write(93);
                mVar.f4059m = wVar;
                return;
            }
            int i12 = zVar.f4091b + 1;
            if (i12 > zVar.f4090a.length) {
                if (zVar.f4093d == null) {
                    zVar.l(i12);
                } else {
                    zVar.flush();
                    i12 = 1;
                }
            }
            zVar.f4090a[zVar.f4091b] = '[';
            zVar.f4091b = i12;
            int i13 = 0;
            while (i13 < list.size()) {
                Object obj4 = list.get(i13);
                if (i13 != 0) {
                    int i14 = zVar.f4091b + 1;
                    if (i14 > zVar.f4090a.length) {
                        if (zVar.f4093d == null) {
                            zVar.l(i14);
                        } else {
                            zVar.flush();
                            i14 = 1;
                        }
                    }
                    c10 = c11;
                    zVar.f4090a[zVar.f4091b] = ',';
                    zVar.f4091b = i14;
                } else {
                    c10 = c11;
                }
                if (obj4 == null) {
                    zVar.append("null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        zVar.writeInt(((Integer) obj4).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj4).longValue();
                        if (z10) {
                            zVar.writeLong(jLongValue);
                            zVar.write(76);
                        } else {
                            zVar.writeLong(jLongValue);
                        }
                    } else if (cls == String.class) {
                        String str = (String) obj4;
                        if ((zVar.f4092c & SerializerFeature.UseSingleQuotes.mask) != 0) {
                            zVar.k0(str);
                        } else {
                            zVar.g0(str, (char) 0, true);
                        }
                    } else {
                        if ((zVar.f4092c & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                            mVar.f4059m = new w(wVar, obj, obj2, 0);
                        }
                        IdentityHashMap<Object, w> identityHashMap2 = mVar.f4058l;
                        if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                            mVar.f4047a.a(obj4.getClass()).a(mVar, obj4, Integer.valueOf(i13), typeY);
                        } else {
                            mVar.t(obj4);
                        }
                    }
                }
                i13++;
                c11 = c10;
            }
            char c12 = c11;
            int i15 = zVar.f4091b + 1;
            if (i15 <= zVar.f4090a.length) {
                i10 = i15;
            } else if (zVar.f4093d == null) {
                zVar.l(i15);
                i10 = i15;
            } else {
                zVar.flush();
            }
            zVar.f4090a[zVar.f4091b] = c12;
            zVar.f4091b = i10;
            mVar.f4059m = wVar;
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }
}
