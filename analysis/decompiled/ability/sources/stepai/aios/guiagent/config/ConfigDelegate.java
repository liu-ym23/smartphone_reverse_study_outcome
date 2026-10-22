package stepai.aios.guiagent.config;

import C7.r;
import S7.o;
import V7.c;
import Z7.t;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\b\u001a\u0013\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\n0\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0004J$\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000e0\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000eH\u0004J$\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00100\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0010H\u0004J$\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00120\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0012H\u0004J$\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00140\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0014H\u0004J-\u0010\u0015\u001a\u0013\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\n0\tR\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0016H\u0004R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiagent/config/ConfigDelegate;", "", AppAgent.CONSTRUCT, "()V", "ID", "", "getID", "()Ljava/lang/String;", TypedValues.Custom.S_STRING, "Lstepai/aios/guiagent/config/ConfigDelegate$MMKVDelegate;", "Lkotlin/jvm/internal/EnhancedNullability;", "key", "defaultValue", "int", "", "long", "", TypedValues.Custom.S_BOOLEAN, "", TypedValues.Custom.S_FLOAT, "", SingleFileBundle.KEY_BYTES, "", "MMKVDelegate", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ConfigDelegate {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0084\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002BW\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0007\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0011\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0006\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/config/ConfigDelegate$MMKVDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "LV7/c;", "", "", "key", "defaultValue", "Lkotlin/Function3;", "Lcom/tencent/mmkv/MMKV;", "LC7/r;", "encode", "decode", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/config/ConfigDelegate;Ljava/lang/String;Ljava/lang/Object;LS7/o;LS7/o;)V", "thisRef", "LZ7/t;", "property", "getValue", "(Ljava/lang/Object;LZ7/t;)Ljava/lang/Object;", "value", "setValue", "(Ljava/lang/Object;LZ7/t;Ljava/lang/Object;)V", "Ljava/lang/String;", "Ljava/lang/Object;", "LS7/o;", "mmkv", "Lcom/tencent/mmkv/MMKV;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class MMKVDelegate<T> implements c {
        private final o decode;
        private final T defaultValue;
        private final o encode;
        private final String key;
        private final MMKV mmkv;
        final /* synthetic */ ConfigDelegate this$0;

        public MMKVDelegate(ConfigDelegate configDelegate, String key, T t9, o encode, o decode) throws RuntimeException {
            k.f(key, "key");
            k.f(encode, "encode");
            k.f(decode, "decode");
            this.this$0 = configDelegate;
            this.key = key;
            this.defaultValue = t9;
            this.encode = encode;
            this.decode = decode;
            MMKV mmkvMmkvWithID = MMKV.mmkvWithID(configDelegate.getID());
            k.e(mmkvMmkvWithID, "mmkvWithID(...)");
            this.mmkv = mmkvMmkvWithID;
        }

        @Override // V7.b
        public T getValue(Object thisRef, t property) {
            k.f(property, "property");
            return (T) this.decode.invoke(this.mmkv, this.key, this.defaultValue);
        }

        public void setValue(Object thisRef, t property, T value) {
            k.f(property, "property");
            if (value == null && this.defaultValue == null) {
                this.mmkv.removeValueForKey(this.key);
            } else {
                this.encode.invoke(this.mmkv, this.key, value);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$boolean$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements o {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super("encode(Ljava/lang/String;Z)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, ((Boolean) obj3).booleanValue());
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, boolean z10) {
            k.f(p02, "p0");
            p02.encode(str, z10);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$boolean$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements o {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(3, MMKV.class, "decodeBool", "decodeBool(Ljava/lang/String;Z)Z", 0);
        }

        public final Boolean invoke(MMKV p02, String str, boolean z10) {
            k.f(p02, "p0");
            return Boolean.valueOf(p02.decodeBool(str, z10));
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((MMKV) obj, (String) obj2, ((Boolean) obj3).booleanValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$bytes$1, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19301 extends AdaptedFunctionReference implements o {
        public static final C19301 INSTANCE = new C19301();

        public C19301() {
            super("encode(Ljava/lang/String;[B)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, (byte[]) obj3);
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, byte[] bArr) {
            k.f(p02, "p0");
            p02.encode(str, bArr);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$bytes$2, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19312 extends FunctionReferenceImpl implements o {
        public static final C19312 INSTANCE = new C19312();

        public C19312() {
            super(3, MMKV.class, "decodeBytes", "decodeBytes(Ljava/lang/String;[B)[B", 0);
        }

        @Override // S7.o
        public final byte[] invoke(MMKV p02, String str, byte[] bArr) {
            k.f(p02, "p0");
            return p02.decodeBytes(str, bArr);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$float$1, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19321 extends AdaptedFunctionReference implements o {
        public static final C19321 INSTANCE = new C19321();

        public C19321() {
            super("encode(Ljava/lang/String;F)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, ((Number) obj3).floatValue());
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, float f) {
            k.f(p02, "p0");
            p02.encode(str, f);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$float$2, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19332 extends FunctionReferenceImpl implements o {
        public static final C19332 INSTANCE = new C19332();

        public C19332() {
            super(3, MMKV.class, "decodeFloat", "decodeFloat(Ljava/lang/String;F)F", 0);
        }

        public final Float invoke(MMKV p02, String str, float f) {
            k.f(p02, "p0");
            return Float.valueOf(p02.decodeFloat(str, f));
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((MMKV) obj, (String) obj2, ((Number) obj3).floatValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$int$1, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19341 extends AdaptedFunctionReference implements o {
        public static final C19341 INSTANCE = new C19341();

        public C19341() {
            super("encode(Ljava/lang/String;I)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, ((Number) obj3).intValue());
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, int i) {
            k.f(p02, "p0");
            p02.encode(str, i);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$int$2, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19352 extends FunctionReferenceImpl implements o {
        public static final C19352 INSTANCE = new C19352();

        public C19352() {
            super(3, MMKV.class, "decodeInt", "decodeInt(Ljava/lang/String;I)I", 0);
        }

        public final Integer invoke(MMKV p02, String str, int i) {
            k.f(p02, "p0");
            return Integer.valueOf(p02.decodeInt(str, i));
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((MMKV) obj, (String) obj2, ((Number) obj3).intValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$long$1, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19361 extends AdaptedFunctionReference implements o {
        public static final C19361 INSTANCE = new C19361();

        public C19361() {
            super("encode(Ljava/lang/String;J)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, ((Number) obj3).longValue());
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, long j5) {
            k.f(p02, "p0");
            p02.encode(str, j5);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$long$2, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19372 extends FunctionReferenceImpl implements o {
        public static final C19372 INSTANCE = new C19372();

        public C19372() {
            super(3, MMKV.class, "decodeLong", "decodeLong(Ljava/lang/String;J)J", 0);
        }

        public final Long invoke(MMKV p02, String str, long j5) {
            k.f(p02, "p0");
            return Long.valueOf(p02.decodeLong(str, j5));
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((MMKV) obj, (String) obj2, ((Number) obj3).longValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$string$1, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19381 extends AdaptedFunctionReference implements o {
        public static final C19381 INSTANCE = new C19381();

        public C19381() {
            super("encode(Ljava/lang/String;Ljava/lang/String;)Z");
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MMKV) obj, (String) obj2, (String) obj3);
            return r.f317a;
        }

        public final void invoke(MMKV p02, String str, String str2) {
            k.f(p02, "p0");
            p02.encode(str, str2);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.config.ConfigDelegate$string$2, reason: invalid class name and case insensitive filesystem */
    public static final /* synthetic */ class C19392 extends FunctionReferenceImpl implements o {
        public static final C19392 INSTANCE = new C19392();

        public C19392() {
            super(3, MMKV.class, "decodeString", "decodeString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // S7.o
        public final String invoke(MMKV p02, String str, String str2) {
            k.f(p02, "p0");
            return p02.decodeString(str, str2);
        }
    }

    public static /* synthetic */ MMKVDelegate boolean$default(ConfigDelegate configDelegate, String str, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: boolean");
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        return configDelegate.m7361boolean(str, z10);
    }

    public static /* synthetic */ MMKVDelegate bytes$default(ConfigDelegate configDelegate, String str, byte[] bArr, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bytes");
        }
        if ((i & 2) != 0) {
            bArr = null;
        }
        return configDelegate.bytes(str, bArr);
    }

    public static /* synthetic */ MMKVDelegate float$default(ConfigDelegate configDelegate, String str, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: float");
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return configDelegate.m7362float(str, f);
    }

    public static /* synthetic */ MMKVDelegate int$default(ConfigDelegate configDelegate, String str, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: int");
        }
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return configDelegate.m7363int(str, i);
    }

    public static /* synthetic */ MMKVDelegate long$default(ConfigDelegate configDelegate, String str, long j5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: long");
        }
        if ((i & 2) != 0) {
            j5 = 0;
        }
        return configDelegate.m7364long(str, j5);
    }

    public static /* synthetic */ MMKVDelegate string$default(ConfigDelegate configDelegate, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: string");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return configDelegate.string(str, str2);
    }

    /* renamed from: boolean, reason: not valid java name */
    public final MMKVDelegate<Boolean> m7361boolean(String key, boolean defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, Boolean.valueOf(defaultValue), AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
    }

    public final MMKVDelegate<byte[]> bytes(String key, byte[] defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, defaultValue, C19301.INSTANCE, C19312.INSTANCE);
    }

    /* renamed from: float, reason: not valid java name */
    public final MMKVDelegate<Float> m7362float(String key, float defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, Float.valueOf(defaultValue), C19321.INSTANCE, C19332.INSTANCE);
    }

    public abstract String getID();

    /* renamed from: int, reason: not valid java name */
    public final MMKVDelegate<Integer> m7363int(String key, int defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, Integer.valueOf(defaultValue), C19341.INSTANCE, C19352.INSTANCE);
    }

    /* renamed from: long, reason: not valid java name */
    public final MMKVDelegate<Long> m7364long(String key, long defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, Long.valueOf(defaultValue), C19361.INSTANCE, C19372.INSTANCE);
    }

    public final MMKVDelegate<String> string(String key, String defaultValue) {
        k.f(key, "key");
        return new MMKVDelegate<>(this, key, defaultValue, C19381.INSTANCE, C19392.INSTANCE);
    }
}
