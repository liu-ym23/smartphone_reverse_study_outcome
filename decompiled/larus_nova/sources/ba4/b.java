package ba4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface b<T> {

    public static final class a implements b<boolean[]> {
        public a() {
        }

        @Override // ba4.b
        public final boolean[] createFromParcel(Parcel r100) {
            return r100.createBooleanArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, boolean[] r102) {
            r100.writeBooleanArray(r102);
        }
    }

    public static final class a0 implements b<String[]> {
        public a0() {
        }

        @Override // ba4.b
        public final String[] createFromParcel(Parcel r100) {
            return r100.createStringArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, String[] r102) {
            r100.writeStringArray(r102);
        }
    }

    /* JADX INFO: renamed from: ba4.b$b, reason: collision with other inner class name */
    public static final class C0283b implements b<Boolean> {
        public C0283b() {
        }

        @Override // ba4.b
        public final Boolean createFromParcel(Parcel r100) {
            boolean r101 = true;
            if (r100.readInt() == 1) goto L7;
            r101 = false;
        L7:
            return Boolean.valueOf(r101);
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Boolean r102) {
            Boolean r103 = Boolean.TRUE;
            r100.writeInt(r103.equals(r102) ? 1 : 0);
        }
    }

    public static final class b0 implements b<String> {
        public b0() {
        }

        @Override // ba4.b
        public final String createFromParcel(Parcel r100) {
            return r100.readString();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, String r102) {
            r100.writeString(r102);
        }
    }

    public static final class c implements b<byte[]> {
        public c() {
        }

        @Override // ba4.b
        public final byte[] createFromParcel(Parcel r100) {
            return r100.createByteArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, byte[] r102) {
            r100.writeByteArray(r102);
        }
    }

    public static final class d implements b<Byte> {
        public d() {
        }

        @Override // ba4.b
        public final Byte createFromParcel(Parcel r100) {
            return Byte.valueOf(r100.readByte());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Byte r102) {
            r100.writeByte(r102.byteValue());
        }
    }

    public static final class e implements b<ba4.a> {
        public e() {
        }

        @Override // ba4.b
        public final ba4.a createFromParcel(Parcel r100) {
            String r101 = r100.readString();
            boolean r102 = false;
            if (r100.readByte() == ((byte) 0)) goto L6;
            r102 = true;
        L6:
            return new ba4.a(r101, null, r102);
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, ba4.a r102) {
            ba4.a r103 = r102;
            r100.writeString(r103.f18412a);
            r100.writeByte(r103.f18414c ? 1 : 0);
        }
    }

    public static final class f implements b<char[]> {
        public f() {
        }

        @Override // ba4.b
        public final char[] createFromParcel(Parcel r100) {
            return r100.createCharArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, char[] r102) {
            r100.writeCharArray(r102);
        }
    }

    public static final class g implements b<CharSequence[]> {
        public g() {
        }

        @Override // ba4.b
        public final CharSequence[] createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            if (r101 < 0) goto L7;
            CharSequence[] r102 = new CharSequence[r101];
            int r103 = 0;
        L5:
            if (r103 >= r101) goto L10;
            r102[r103] = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
            r103 = r103 + 1;
            goto L5
        L10:
            return r102;
        L7:
            return null;
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, CharSequence[] r102) {
            CharSequence[] r103 = r102;
            if (r103 == null) goto L7;
            int r104 = r103.length;
            r100.writeInt(r104);
            int r105 = 0;
        L5:
            if (r105 >= r104) goto L10;
            TextUtils.writeToParcel(r103[r105], r100, 0);
            r105 = r105 + 1;
            goto L5
        L10:
            return;
        L7:
            r100.writeInt(-1);
        }
    }

    public static final class h implements b<CharSequence> {
        public h() {
        }

        @Override // ba4.b
        public final CharSequence createFromParcel(Parcel r100) {
            return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, CharSequence r102) {
            TextUtils.writeToParcel(r102, r100, 0);
        }
    }

    public static final class i implements b<Character> {
        public i() {
        }

        @Override // ba4.b
        public final Character createFromParcel(Parcel r100) {
            return Character.valueOf((char) r100.readInt());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Character r102) {
            r100.writeInt(r102.charValue());
        }
    }

    public static final class j implements b<double[]> {
        public j() {
        }

        @Override // ba4.b
        public final double[] createFromParcel(Parcel r100) {
            return r100.createDoubleArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, double[] r102) {
            r100.writeDoubleArray(r102);
        }
    }

    public static final class k implements b<Double> {
        public k() {
        }

        @Override // ba4.b
        public final Double createFromParcel(Parcel r100) {
            return Double.valueOf(r100.readDouble());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Double r102) {
            r100.writeDouble(r102.doubleValue());
        }
    }

    public static final class l implements b<Object> {
        public l() {
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Object r102) {
        }

        @Override // ba4.b
        public final Object createFromParcel(Parcel r100) {
            return null;
        }
    }

    public static final class m implements b<float[]> {
        public m() {
        }

        @Override // ba4.b
        public final float[] createFromParcel(Parcel r100) {
            return r100.createFloatArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, float[] r102) {
            r100.writeFloatArray(r102);
        }
    }

    public static final class n implements b<Float> {
        public n() {
        }

        @Override // ba4.b
        public final Float createFromParcel(Parcel r100) {
            return Float.valueOf(r100.readFloat());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Float r102) {
            r100.writeFloat(r102.floatValue());
        }
    }

    public static final class o implements b<int[]> {
        public o() {
        }

        @Override // ba4.b
        public final int[] createFromParcel(Parcel r100) {
            return r100.createIntArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, int[] r102) {
            r100.writeIntArray(r102);
        }
    }

    public static final class p implements b<Integer> {
        public p() {
        }

        @Override // ba4.b
        public final Integer createFromParcel(Parcel r100) {
            return Integer.valueOf(r100.readInt());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Integer r102) {
            r100.writeInt(r102.intValue());
        }
    }

    public static final class q implements b<JSONArray> {
        public q() {
        }

        @Override // ba4.b
        public final JSONArray createFromParcel(Parcel r100) {
            String r101 = r100.readString();
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L16;
        L14:
            return null;
        L16:
            return new JSONArray(r101);
        L12:
            e = move-exception;
            g94.b.b("IPC_JSONArrayType", new Object[]{"JSONArrayType createFromParcel catch exception", e});
            goto L14
        L5:
            if (r101.trim().length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, JSONArray r102) {
            JSONArray r103 = r102;
            if (r103 != null) goto L5;
            String r104 = null;
        L6:
            r100.writeString(r104);
            return;
        L5:
            r104 = r103.toString();
            goto L6
        }
    }

    public static final class r implements b<JSONObject> {
        public r() {
        }

        @Override // ba4.b
        public final JSONObject createFromParcel(Parcel r100) {
            String r101 = r100.readString();
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L16;
        L14:
            return null;
        L16:
            return new JSONObject(r101);
        L12:
            e = move-exception;
            g94.b.b("IPC_JSONObjectType", new Object[]{"JSONType createFromParcel catch exception", e});
            goto L14
        L5:
            if (r101.trim().length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, JSONObject r102) {
            JSONObject r103 = r102;
            if (r103 != null) goto L5;
            String r104 = null;
        L6:
            r100.writeString(r104);
            return;
        L5:
            r104 = r103.toString();
            goto L6
        }
    }

    public static final class s implements b<List> {
        public s() {
        }

        @Override // ba4.b
        public final List createFromParcel(Parcel r100) {
            return r100.readArrayList(com.bytedance.bdp.bdpbase.util.b.a());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, List r102) {
            r100.writeList(r102);
        }
    }

    public static final class t implements b<long[]> {
        public t() {
        }

        @Override // ba4.b
        public final long[] createFromParcel(Parcel r100) {
            return r100.createLongArray();
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, long[] r102) {
            r100.writeLongArray(r102);
        }
    }

    public static final class u implements b<Long> {
        public u() {
        }

        @Override // ba4.b
        public final Long createFromParcel(Parcel r100) {
            return Long.valueOf(r100.readLong());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Long r102) {
            r100.writeLong(r102.longValue());
        }
    }

    public static final class v implements b<Map> {
        public v() {
        }

        @Override // ba4.b
        public final Map createFromParcel(Parcel r100) {
            return r100.readHashMap(com.bytedance.bdp.bdpbase.util.b.a());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Map r102) {
            r100.writeMap(r102);
        }
    }

    public static final class w implements b<Parcelable[]> {
        public w() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @Override // ba4.b
        public final Parcelable[] createFromParcel(Parcel r100) {
            Class r101 = b(r100.readString());     // Catch: ClassNotFoundException -> L10
            int r102 = r100.readInt();     // Catch: ClassNotFoundException -> L10
            if (r102 < 0) goto L12;
            Object[] r103 = (Object[]) Array.newInstance(r101, r102);     // Catch: ClassNotFoundException -> L10
            int r104 = 0;
        L7:
            if (r104 >= r102) goto L14;
            r103[r104] = r100.readParcelable(com.bytedance.bdp.bdpbase.util.b.a());     // Catch: ClassNotFoundException -> L10
            r104 = r104 + 1;
        L14:
            return (Parcelable[]) r103;
        L12:
            r103 = null;
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Parcelable[] r102) {
            Parcelable[] r103 = r102;
            r100.writeString(r103.getClass().getComponentType().getName());
            r100.writeParcelableArray(r103, r101);
        }
    }

    public static final class x implements b<Parcelable> {
        public x() {
        }

        @Override // ba4.b
        public final Parcelable createFromParcel(Parcel r100) {
            return r100.readParcelable(com.bytedance.bdp.bdpbase.util.b.a());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Parcelable r102) {
            Parcelable r103 = r102;
            if (r101 != 1) goto L5;
            r103.writeToParcel(r100, r101);
            return;
        L5:
            r100.writeParcelable(r103, r101);
        }
    }

    public static final class y implements b<short[]> {
        public y() {
        }

        @Override // ba4.b
        public final short[] createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            if (r101 >= 0) goto L5;
        L9:
            return null;
        L5:
            if (r101 > (r100.dataAvail() >> 2)) goto L9;
            short[] r102 = new short[r101];
            int r103 = 0;
        L7:
            if (r103 >= r101) goto L12;
            r102[r103] = (short) r100.readInt();
            r103 = r103 + 1;
            goto L7
        L12:
            return r102;
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, short[] r102) {
            short[] r103 = r102;
            if (r103 == null) goto L7;
            int r104 = r103.length;
            r100.writeInt(r104);
            int r105 = 0;
        L5:
            if (r105 >= r104) goto L10;
            r100.writeInt(r103[r105]);
            r105 = r105 + 1;
            goto L5
        L10:
            return;
        L7:
            r100.writeInt(-1);
        }
    }

    public static final class z implements b<Short> {
        public z() {
        }

        @Override // ba4.b
        public final Short createFromParcel(Parcel r100) {
            return Short.valueOf((short) r100.readInt());
        }

        @Override // ba4.b
        public final void a(Parcel r100, int r101, Short r102) {
            r100.writeInt(r102.intValue());
        }
    }

    void a(Parcel r100, int r101, T r102);

    T createFromParcel(Parcel r100);
}
