package android.view.serialization;

import A9.a;
import A9.c;
import E9.e;
import android.os.Bundle;
import android.view.SavedStateReader;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.InterfaceC2123a;
import z9.g;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002¢\u0006\u0004\b\"\u0010#J%\u0010'\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\rH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020)H\u0016¢\u0006\u0004\bG\u0010,J\u0017\u0010I\u001a\u00020H2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020-H\u0016¢\u0006\u0004\bK\u0010/J#\u0010L\u001a\u00028\u0000\"\u0004\b\u0000\u0010$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016¢\u0006\u0004\bL\u0010(R\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010PR$\u0010R\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010ER\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010X\u001a\u00020W8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[¨\u0006\\"}, d2 = {"Landroidx/savedstate/serialization/SavedStateDecoder;", "LA9/a;", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedState", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "", "", "decodeIntList", "()Ljava/util/List;", "", "decodeStringList", "", "decodeBooleanArray", "()[Z", "", "decodeCharArray", "()[C", "", "decodeDoubleArray", "()[D", "", "decodeFloatArray", "()[F", "", "decodeIntArray", "()[I", "", "decodeLongArray", "()[J", "", "decodeStringArray", "()[Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/a;", "deserializer", "decodeFormatSpecificTypes", "(Lx9/a;)Ljava/lang/Object;", "Lz9/g;", "descriptor", "decodeElementIndex", "(Lz9/g;)I", "", "decodeBoolean", "()Z", "", "decodeByte", "()B", "", "decodeShort", "()S", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "enumDescriptor", "decodeEnum", "LA9/c;", "beginStructure", "(Lz9/g;)LA9/c;", "decodeNotNullMark", "decodeSerializableValue", "Landroid/os/Bundle;", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "value", "key", "Ljava/lang/String;", "getKey$savedstate_release", "index", "I", "LE9/e;", "serializersModule", "LE9/e;", "getSerializersModule", "()LE9/e;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateDecoder extends a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final e serializersModule;

    public SavedStateDecoder(Bundle savedState, SavedStateConfiguration configuration) {
        k.f(savedState, "savedState");
        k.f(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = configuration.getSerializersModule();
    }

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m7187getBooleanArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m7191getCharArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m7201getDoubleArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder savedStateDecoder, g gVar, int i) {
        return SavedStateReader.m7178containsimpl(SavedStateReader.m7177constructorimpl(savedStateDecoder.savedState), gVar.e(i));
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m7205getFloatArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T decodeFormatSpecificTypes(InterfaceC2123a deserializer) {
        T t9 = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, deserializer);
        if (t9 != null) {
            return t9;
        }
        g descriptor = deserializer.getDescriptor();
        if (k.b(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            return (T) decodeIntList();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            return (T) decodeStringList();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            return (T) decodeBooleanArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            return (T) decodeCharArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            return (T) decodeDoubleArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            return (T) decodeFloatArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            return (T) decodeIntArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            return (T) decodeLongArray();
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return (T) decodeStringArray();
        }
        return null;
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m7209getIntArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m7211getIntListimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m7219getLongArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m7249getStringArrayimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m7251getStringListimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public c beginStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        return k.b(this.key, "") ? this : new SavedStateDecoder(SavedStateReader.m7234getSavedStateimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // A9.a, A9.e
    public boolean decodeBoolean() {
        return SavedStateReader.m7186getBooleanimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public byte decodeByte() {
        return (byte) SavedStateReader.m7208getIntimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public char decodeChar() {
        return SavedStateReader.m7190getCharimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.c
    public /* bridge */ /* synthetic */ int decodeCollectionSize(g gVar) {
        super.decodeCollectionSize(gVar);
        return -1;
    }

    @Override // A9.a, A9.e
    public double decodeDouble() {
        return SavedStateReader.m7200getDoubleimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.c
    public int decodeElementIndex(g descriptor) {
        k.f(descriptor, "descriptor");
        int iM7257sizeimpl = (k.b(descriptor.getKind(), z9.k.d) || k.b(descriptor.getKind(), z9.k.e)) ? SavedStateReader.m7257sizeimpl(SavedStateReader.m7177constructorimpl(this.savedState)) : descriptor.d();
        while (true) {
            int i = this.index;
            if (i >= iM7257sizeimpl || !descriptor.i(i) || decodeElementIndex$presentInEncoding(this, descriptor, this.index)) {
                break;
            }
            this.index++;
        }
        int i6 = this.index;
        if (i6 >= iM7257sizeimpl) {
            return -1;
        }
        this.key = descriptor.e(i6);
        int i10 = this.index;
        this.index = i10 + 1;
        return i10;
    }

    @Override // A9.a, A9.e
    public int decodeEnum(g enumDescriptor) {
        k.f(enumDescriptor, "enumDescriptor");
        return SavedStateReader.m7208getIntimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public float decodeFloat() {
        return SavedStateReader.m7204getFloatimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public int decodeInt() {
        return SavedStateReader.m7208getIntimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public long decodeLong() {
        return SavedStateReader.m7218getLongimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m7256isNullimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    public Object decodeNullableSerializableValue(InterfaceC2123a deserializer) {
        k.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || decodeNotNullMark()) ? decodeSerializableValue(deserializer) : decodeNull();
    }

    @Override // A9.c
    public /* bridge */ /* synthetic */ boolean decodeSequentially() {
        return false;
    }

    @Override // A9.e
    public <T> T decodeSerializableValue(InterfaceC2123a deserializer) {
        k.f(deserializer, "deserializer");
        T t9 = (T) decodeFormatSpecificTypes(deserializer);
        return t9 == null ? (T) deserializer.deserialize(this) : t9;
    }

    @Override // A9.a, A9.e
    public short decodeShort() {
        return (short) SavedStateReader.m7208getIntimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    @Override // A9.a, A9.e
    public String decodeString() {
        return SavedStateReader.m7248getStringimpl(SavedStateReader.m7177constructorimpl(this.savedState), this.key);
    }

    /* renamed from: getKey$savedstate_release, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: getSavedState$savedstate_release, reason: from getter */
    public final Bundle getSavedState() {
        return this.savedState;
    }

    @Override // A9.c
    public e getSerializersModule() {
        return this.serializersModule;
    }
}
