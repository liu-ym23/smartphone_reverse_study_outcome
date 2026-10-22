package android.view.serialization;

import A9.b;
import A9.d;
import E9.e;
import android.os.Bundle;
import android.view.SavedStateReader;
import android.view.SavedStateWriter;
import androidx.appfunctions.metadata.a;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import x9.f;
import z9.g;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b2\u00103J+\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u001042\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000052\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b7\u00108J#\u0010:\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u00109\u001a\u00020)H\u0002¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0002¢\u0006\u0004\b=\u0010>J\u001d\u0010?\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020)0<H\u0002¢\u0006\u0004\b?\u0010>J\u0017\u0010A\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020FH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020IH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020LH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020OH\u0002¢\u0006\u0004\bP\u0010QJ\u001d\u0010S\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020)0RH\u0002¢\u0006\u0004\bS\u0010TJ+\u0010U\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\bU\u0010VJ+\u0010W\u001a\u00020\r\"\u0004\b\u0000\u001042\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000052\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\bW\u0010XR\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010Y\u001a\u0004\bZ\u0010[R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\\R$\u0010]\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020)8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001a\u0010b\u001a\u00020a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e¨\u0006f"}, d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "LA9/b;", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedState", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "Lz9/g;", "descriptor", "", "index", "", "shouldEncodeElementDefault", "(Lz9/g;I)Z", "encodeElement", "value", "LC7/r;", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeChar", "(C)V", "", "encodeString", "(Ljava/lang/String;)V", "enumDescriptor", "encodeEnum", "(Lz9/g;I)V", "encodeNull", "()V", "LA9/d;", "beginStructure", "(Lz9/g;)LA9/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/f;", "serializer", "encodeSerializableValue", "(Lx9/f;Ljava/lang/Object;)V", "elementName", "checkDiscriminatorCollisions", "(Landroid/os/Bundle;Ljava/lang/String;)V", "", "encodeIntList", "(Ljava/util/List;)V", "encodeStringList", "", "encodeBooleanArray", "([Z)V", "", "encodeCharArray", "([C)V", "", "encodeDoubleArray", "([D)V", "", "encodeFloatArray", "([F)V", "", "encodeIntArray", "([I)V", "", "encodeLongArray", "([J)V", "", "encodeStringArray", "([Ljava/lang/String;)V", "putClassDiscriminatorIfRequired", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lz9/g;Landroid/os/Bundle;)V", "encodeFormatSpecificTypes", "(Lx9/f;Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "key", "Ljava/lang/String;", "getKey$savedstate_release", "()Ljava/lang/String;", "LE9/e;", "serializersModule", "LE9/e;", "getSerializersModule", "()LE9/e;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateEncoder extends b {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final e serializersModule;

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
        k.f(savedState, "savedState");
        k.f(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = configuration.getSerializersModule();
    }

    private final void checkDiscriminatorCollisions(Bundle savedState, String elementName) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean zM7178containsimpl = SavedStateReader.m7178containsimpl(SavedStateReader.m7177constructorimpl(savedState), "type");
            boolean zB = k.b(elementName, "type");
            if (zM7178containsimpl && zB) {
                throw new IllegalArgumentException(a.m("SavedStateEncoder for ", SavedStateReader.m7248getStringimpl(SavedStateReader.m7177constructorimpl(savedState), "type"), " has property '", elementName, "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation."));
            }
        }
    }

    private final void encodeBooleanArray(boolean[] value) {
        SavedStateWriter.m7270putBooleanArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeCharArray(char[] value) {
        SavedStateWriter.m7272putCharArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeDoubleArray(double[] value) {
        SavedStateWriter.m7277putDoubleArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeFloatArray(float[] value) {
        SavedStateWriter.m7279putFloatArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> boolean encodeFormatSpecificTypes(f serializer, T value) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializer, value)) {
            return true;
        }
        g descriptor = serializer.getDescriptor();
        if (k.b(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            encodeIntList((List) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            encodeStringList((List) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.BooleanArray");
            encodeBooleanArray((boolean[]) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.CharArray");
            encodeCharArray((char[]) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.DoubleArray");
            encodeDoubleArray((double[]) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.FloatArray");
            encodeFloatArray((float[]) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.IntArray");
            encodeIntArray((int[]) value);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            k.d(value, "null cannot be cast to non-null type kotlin.LongArray");
            encodeLongArray((long[]) value);
            return true;
        }
        if (!k.b(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return false;
        }
        k.d(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        encodeStringArray((String[]) value);
        return true;
    }

    private final void encodeIntArray(int[] value) {
        SavedStateWriter.m7281putIntArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeIntList(List<Integer> value) {
        SavedStateWriter.m7282putIntListimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeLongArray(long[] value) {
        SavedStateWriter.m7285putLongArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeStringArray(String[] value) {
        SavedStateWriter.m7297putStringArrayimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeStringList(List<String> value) {
        SavedStateWriter.m7298putStringListimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration configuration, g descriptor, Bundle savedState) {
        if (configuration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m7178containsimpl(SavedStateReader.m7177constructorimpl(savedState), "type")) {
            if (k.b(descriptor.getKind(), z9.k.c) || k.b(descriptor.getKind(), z9.k.f)) {
                SavedStateWriter.m7296putStringimpl(SavedStateWriter.m7263constructorimpl(savedState), "type", descriptor.h());
            }
        }
    }

    @Override // A9.f
    public /* bridge */ /* synthetic */ d beginCollection(g gVar, int i) {
        return super.beginCollection(gVar, i);
    }

    @Override // A9.b, A9.f
    public d beginStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        if (k.b(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            return this;
        }
        kotlin.collections.a.M();
        Pair[] pairArr = new Pair[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7263constructorimpl(bundleBundleOf);
        SavedStateWriter.m7290putSavedStateimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, bundleBundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleBundleOf);
        return new SavedStateEncoder(bundleBundleOf, this.configuration);
    }

    @Override // A9.b, A9.f
    public void encodeBoolean(boolean value) {
        SavedStateWriter.m7269putBooleanimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeByte(byte value) {
        SavedStateWriter.m7280putIntimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeChar(char value) {
        SavedStateWriter.m7271putCharimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeDouble(double value) {
        SavedStateWriter.m7276putDoubleimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b
    public boolean encodeElement(g descriptor, int index) {
        k.f(descriptor, "descriptor");
        String strE = descriptor.e(index);
        this.key = strE;
        checkDiscriminatorCollisions(this.savedState, strE);
        return true;
    }

    @Override // A9.f
    public void encodeEnum(g enumDescriptor, int index) {
        k.f(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m7280putIntimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, index);
    }

    @Override // A9.b, A9.f
    public void encodeFloat(float value) {
        SavedStateWriter.m7278putFloatimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeInt(int value) {
        SavedStateWriter.m7280putIntimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeLong(long value) {
        SavedStateWriter.m7284putLongimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.f
    public /* bridge */ /* synthetic */ void encodeNotNullMark() {
    }

    @Override // A9.f
    public void encodeNull() {
        SavedStateWriter.m7286putNullimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key);
    }

    @Override // A9.f
    public /* bridge */ /* synthetic */ void encodeNullableSerializableValue(f fVar, Object obj) {
        super.encodeNullableSerializableValue(fVar, obj);
    }

    @Override // A9.f
    public <T> void encodeSerializableValue(f serializer, T value) {
        k.f(serializer, "serializer");
        if (encodeFormatSpecificTypes(serializer, value)) {
            return;
        }
        serializer.serialize(this, value);
    }

    @Override // A9.b, A9.f
    public void encodeShort(short value) {
        SavedStateWriter.m7280putIntimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    @Override // A9.b, A9.f
    public void encodeString(String value) {
        k.f(value, "value");
        SavedStateWriter.m7296putStringimpl(SavedStateWriter.m7263constructorimpl(this.savedState), this.key, value);
    }

    /* renamed from: getKey$savedstate_release, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: getSavedState$savedstate_release, reason: from getter */
    public final Bundle getSavedState() {
        return this.savedState;
    }

    @Override // A9.f
    public e getSerializersModule() {
        return this.serializersModule;
    }

    @Override // A9.d
    public boolean shouldEncodeElementDefault(g descriptor, int index) {
        k.f(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}
