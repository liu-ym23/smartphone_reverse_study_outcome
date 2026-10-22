package com.stepos.core.data;

import D7.v;
import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.parse.b;
import d5.c;
import d5.d;
import d5.f;
import d5.h;
import d5.i;
import d5.j;
import d5.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u0003\u0004:;B\u001d\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0019¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\f¢\u0006\u0004\b0\u0010)J\u001f\u00103\u001a\u0002022\u0006\u0010\t\u001a\u00020\b2\u0006\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\fH\u0016¢\u0006\u0004\b5\u0010)J\u000f\u00106\u001a\u00020\u0003H\u0016¢\u0006\u0004\b6\u00107R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00108¨\u0006<"}, d2 = {"Lcom/stepos/core/data/ContentParams;", "Landroid/os/Parcelable;", "", "", "Ld5/l;", "params", AppAgent.CONSTRUCT, "(Ljava/util/Map;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "key", "", "default", "getInt", "(Ljava/lang/String;I)I", "", "getLong", "(Ljava/lang/String;J)J", "", "getFloat", "(Ljava/lang/String;F)F", "", "getDouble", "(Ljava/lang/String;D)D", "", "getBoolean", "(Ljava/lang/String;Z)Z", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "getIntArray", "(Ljava/lang/String;)[I", "", "getFloatArray", "(Ljava/lang/String;)[F", "containsKey", "(Ljava/lang/String;)Z", "isEmpty", "()Z", "size", "()I", "", "keys", "()Ljava/util/Set;", "", "toByteArray", "()[B", "calculateByteSize", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "Companion", "d5/b", "d5/c", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentParams implements Parcelable {
    private static final byte TYPE_BOOLEAN = 4;
    private static final byte TYPE_DOUBLE = 3;
    private static final byte TYPE_FLOAT = 2;
    private static final byte TYPE_FLOAT_ARRAY = 7;
    private static final byte TYPE_INT = 0;
    private static final byte TYPE_INT_ARRAY = 6;
    private static final byte TYPE_LONG = 1;
    private static final byte TYPE_STRING = 5;
    private final Map<String, l> params;
    public static final c Companion = new c();
    public static final Parcelable.Creator<ContentParams> CREATOR = new g(12);

    public /* synthetic */ ContentParams(Map map, e eVar) {
        this((Map<String, ? extends l>) map);
    }

    public static final ContentParams empty() {
        Companion.getClass();
        return new ContentParams(a.M(), null);
    }

    public static final ContentParams fromByteArray(byte[] bArr) {
        Companion.getClass();
        return c.a(bArr);
    }

    public static /* synthetic */ boolean getBoolean$default(ContentParams contentParams, String str, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return contentParams.getBoolean(str, z10);
    }

    public static /* synthetic */ double getDouble$default(ContentParams contentParams, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return contentParams.getDouble(str, d);
    }

    public static /* synthetic */ float getFloat$default(ContentParams contentParams, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return contentParams.getFloat(str, f);
    }

    public static /* synthetic */ int getInt$default(ContentParams contentParams, String str, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return contentParams.getInt(str, i);
    }

    public static /* synthetic */ long getLong$default(ContentParams contentParams, String str, long j5, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 0;
        }
        return contentParams.getLong(str, j5);
    }

    public static /* synthetic */ String getString$default(ContentParams contentParams, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return contentParams.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$2(Map.Entry it) {
        k.f(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int calculateByteSize() {
        /*
            r8 = this;
            java.util.Map<java.lang.String, d5.l> r8 = r8.params
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            r0 = 4
            r1 = r0
        Lc:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L89
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            d5.l r2 = (d5.l) r2
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r5 = "UTF_8"
            kotlin.jvm.internal.k.e(r4, r5)
            byte[] r3 = r3.getBytes(r4)
            java.lang.String r6 = "getBytes(...)"
            kotlin.jvm.internal.k.e(r3, r6)
            int r3 = r3.length
            int r3 = r3 + 3
            int r3 = r3 + r1
            boolean r1 = r2 instanceof d5.i
            if (r1 == 0) goto L3e
        L3c:
            r7 = r0
            goto L80
        L3e:
            boolean r1 = r2 instanceof d5.j
            r7 = 8
            if (r1 == 0) goto L45
            goto L80
        L45:
            boolean r1 = r2 instanceof d5.g
            if (r1 == 0) goto L4a
            goto L3c
        L4a:
            boolean r1 = r2 instanceof d5.e
            if (r1 == 0) goto L4f
            goto L80
        L4f:
            boolean r1 = r2 instanceof d5.d
            if (r1 == 0) goto L55
            r7 = 1
            goto L80
        L55:
            boolean r1 = r2 instanceof d5.k
            if (r1 == 0) goto L6b
            d5.k r2 = (d5.k) r2
            java.lang.String r1 = r2.f4301a
            kotlin.jvm.internal.k.e(r4, r5)
            byte[] r1 = r1.getBytes(r4)
            kotlin.jvm.internal.k.e(r1, r6)
            int r1 = r1.length
        L68:
            int r7 = r1 + 4
            goto L80
        L6b:
            boolean r1 = r2 instanceof d5.h
            if (r1 == 0) goto L76
            d5.h r2 = (d5.h) r2
            int[] r1 = r2.f4298a
            int r1 = r1.length
        L74:
            int r1 = r1 * r0
            goto L68
        L76:
            boolean r1 = r2 instanceof d5.f
            if (r1 == 0) goto L83
            d5.f r2 = (d5.f) r2
            float[] r1 = r2.f4296a
            int r1 = r1.length
            goto L74
        L80:
            int r1 = r3 + r7
            goto Lc
        L83:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L89:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.data.ContentParams.calculateByteSize():int");
    }

    public final boolean containsKey(String key) {
        k.f(key, "key");
        return this.params.containsKey(key);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getBoolean(String key, boolean z10) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        d dVar = lVar instanceof d ? (d) lVar : null;
        return dVar != null ? dVar.f4294a : z10;
    }

    public final double getDouble(String key, double d) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        d5.e eVar = lVar instanceof d5.e ? (d5.e) lVar : null;
        return eVar != null ? eVar.f4295a : d;
    }

    public final float getFloat(String key, float f) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        d5.g gVar = lVar instanceof d5.g ? (d5.g) lVar : null;
        return gVar != null ? gVar.f4297a : f;
    }

    public final float[] getFloatArray(String key) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        f fVar = lVar instanceof f ? (f) lVar : null;
        if (fVar != null) {
            return fVar.f4296a;
        }
        return null;
    }

    public final int getInt(String key, int i) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        i iVar = lVar instanceof i ? (i) lVar : null;
        return iVar != null ? iVar.f4299a : i;
    }

    public final int[] getIntArray(String key) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        h hVar = lVar instanceof h ? (h) lVar : null;
        if (hVar != null) {
            return hVar.f4298a;
        }
        return null;
    }

    public final long getLong(String key, long j5) {
        k.f(key, "key");
        l lVar = this.params.get(key);
        j jVar = lVar instanceof j ? (j) lVar : null;
        return jVar != null ? jVar.f4300a : j5;
    }

    public final String getString(String key, String str) {
        String str2;
        k.f(key, "key");
        k.f(str, "default");
        l lVar = this.params.get(key);
        d5.k kVar = lVar instanceof d5.k ? (d5.k) lVar : null;
        return (kVar == null || (str2 = kVar.f4301a) == null) ? str : str2;
    }

    public final boolean isEmpty() {
        return this.params.isEmpty();
    }

    public final Set<String> keys() {
        return this.params.keySet();
    }

    public final int size() {
        return this.params.size();
    }

    public final byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(calculateByteSize()).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(this.params.size());
        for (Map.Entry<String, l> entry : this.params.entrySet()) {
            String key = entry.getKey();
            l value = entry.getValue();
            Charset UTF_8 = StandardCharsets.UTF_8;
            k.e(UTF_8, "UTF_8");
            byte[] bytes = key.getBytes(UTF_8);
            k.e(bytes, "getBytes(...)");
            int i = 0;
            if (value instanceof i) {
                byteBufferOrder.put(TYPE_INT);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(((i) value).f4299a);
            } else if (value instanceof j) {
                byteBufferOrder.put(TYPE_LONG);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putLong(((j) value).f4300a);
            } else if (value instanceof d5.g) {
                byteBufferOrder.put(TYPE_FLOAT);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putFloat(((d5.g) value).f4297a);
            } else if (value instanceof d5.e) {
                byteBufferOrder.put(TYPE_DOUBLE);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putDouble(((d5.e) value).f4295a);
            } else if (value instanceof d) {
                byteBufferOrder.put(TYPE_BOOLEAN);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.put(((d) value).f4294a ? (byte) 1 : (byte) 0);
            } else if (value instanceof d5.k) {
                String str = ((d5.k) value).f4301a;
                k.e(UTF_8, "UTF_8");
                byte[] bytes2 = str.getBytes(UTF_8);
                k.e(bytes2, "getBytes(...)");
                byteBufferOrder.put(TYPE_STRING);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(bytes2.length);
                byteBufferOrder.put(bytes2);
            } else if (value instanceof h) {
                byteBufferOrder.put(TYPE_INT_ARRAY);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                h hVar = (h) value;
                byteBufferOrder.putInt(hVar.f4298a.length);
                int[] iArr = hVar.f4298a;
                int length = iArr.length;
                while (i < length) {
                    byteBufferOrder.putInt(iArr[i]);
                    i++;
                }
            } else {
                if (!(value instanceof f)) {
                    throw new NoWhenBranchMatchedException();
                }
                byteBufferOrder.put(TYPE_FLOAT_ARRAY);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                f fVar = (f) value;
                byteBufferOrder.putInt(fVar.f4296a.length);
                float[] fArr = fVar.f4296a;
                int length2 = fArr.length;
                while (i < length2) {
                    byteBufferOrder.putFloat(fArr[i]);
                    i++;
                }
            }
        }
        byte[] bArrArray = byteBufferOrder.array();
        k.e(bArrArray, "array(...)");
        byte[] bArrCopyOf = Arrays.copyOf(bArrArray, byteBufferOrder.position());
        k.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        return B7.a.m("ContentParams(", v.I0(this.params.entrySet(), null, null, null, new b(17), 31), ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        byte[] byteArray = toByteArray();
        parcel.writeInt(byteArray.length);
        parcel.writeByteArray(byteArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ContentParams(Map<String, ? extends l> map) {
        this.params = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ContentParams(Parcel parcel) {
        k.f(parcel, "parcel");
        Companion.getClass();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        this((Map<String, ? extends l>) c.a(bArr).params);
    }
}
