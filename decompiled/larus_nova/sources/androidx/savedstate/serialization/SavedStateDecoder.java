package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.d;
import luc.f;
import luc.p;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0019H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-H\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0-H\u0002J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020:H\u0002J\u0013\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0<H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J!\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0DH\u0016¢\u0006\u0002\u0010EJ#\u0010F\u001a\u0004\u0018\u0001HB\"\u0004\b\u0000\u0010B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0DH\u0002¢\u0006\u0002\u0010ER\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006G"}, d2 = {"Landroidx/savedstate/serialization/SavedStateDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate", "()Ljava/lang/String;", "index", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeByte", "", "decodeShort", "", "decodeInt", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeChar", "", "decodeString", "decodeEnum", "enumDescriptor", "decodeIntList", "", "decodeStringList", "decodeBooleanArray", "", "decodeCharArray", "", "decodeDoubleArray", "", "decodeFloatArray", "", "decodeIntArray", "", "decodeLongArray", "", "decodeStringArray", "", "()[Ljava/lang/String;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeNotNullMark", "decodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeFormatSpecificTypes", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateDecoder extends muc.a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final d serializersModule;

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m7841getBooleanArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m7845getCharArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m7855getDoubleArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m7859getFloatArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m7863getIntArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m7865getIntListimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m7873getLongArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m7903getStringArrayimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m7905getStringListimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public boolean decodeBoolean() {
        return SavedStateReader.m7840getBooleanimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public byte decodeByte() {
        return (byte) SavedStateReader.m7862getIntimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public char decodeChar() {
        return SavedStateReader.m7844getCharimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public double decodeDouble() {
        return SavedStateReader.m7854getDoubleimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public float decodeFloat() {
        return SavedStateReader.m7858getFloatimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public int decodeInt() {
        return SavedStateReader.m7862getIntimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public long decodeLong() {
        return SavedStateReader.m7872getLongimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m7910isNullimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public short decodeShort() {
        return (short) SavedStateReader.m7862getIntimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public String decodeString() {
        return SavedStateReader.m7902getStringimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    public final String getKey$savedstate() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate() {
        return this.savedState;
    }

    @Override // muc.e, muc.c
    public d getSerializersModule() {
        return this.serializersModule;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T decodeFormatSpecificTypes(juc.c<? extends T> r100) {
        T r101 = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, r100);
        if (r101 != null) goto L33;
        f r102 = r100.getDescriptor();
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getIntListDescriptor()) == false) goto L8;
        return (T) decodeIntList();
    L8:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getStringListDescriptor()) == false) goto L11;
        return (T) decodeStringList();
    L11:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getBooleanArrayDescriptor()) == false) goto L14;
        return (T) decodeBooleanArray();
    L14:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getCharArrayDescriptor()) == false) goto L17;
        return (T) decodeCharArray();
    L17:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getDoubleArrayDescriptor()) == false) goto L20;
        return (T) decodeDoubleArray();
    L20:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getFloatArrayDescriptor()) == false) goto L23;
        return (T) decodeFloatArray();
    L23:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getIntArrayDescriptor()) == false) goto L26;
        return (T) decodeIntArray();
    L26:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getLongArrayDescriptor()) == false) goto L29;
        return (T) decodeLongArray();
    L29:
        if (Intrinsics.areEqual(r102, SavedStateCodecUtilsKt.getStringArrayDescriptor()) == true) goto L42;
        return null;
    L42:
        return (T) decodeStringArray();
    L33:
        return r101;
    }

    @Override // muc.a, muc.e
    public muc.c beginStructure(f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (Intrinsics.areEqual(this.key, "") == false) goto L6;
        return this;
    L6:
        return new SavedStateDecoder(SavedStateReader.m7888getSavedStateimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // muc.c
    public int decodeElementIndex(f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (Intrinsics.areEqual(r100.getKind(), p.b.f510878a) == false) goto L5;
    L8:
        int r101 = SavedStateReader.m7911sizeimpl(SavedStateReader.m7831constructorimpl(this.savedState));
    L9:
        int r102 = this.index;
        if (r102 >= r101) goto L16;
        if (decodeElementIndex$hasDefaultValueDefined(r100, r102) == false) goto L16;
        if (decodeElementIndex$presentInEncoding(this, r100, this.index) == true) goto L16;
        this.index++;
    L16:
        int r103 = this.index;
        if (r103 >= r101) goto L20;
        this.key = r100.b(r103);
        int r104 = this.index;
        this.index = r104 + 1;
        return r104;
    L20:
        return -1;
    L5:
        if (Intrinsics.areEqual(r100.getKind(), p.c.f510879a) == true) goto L8;
        r101 = r100.d();
        goto L9
    }

    @Override // muc.a, muc.e
    public int decodeEnum(f r100) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
        return SavedStateReader.m7862getIntimpl(SavedStateReader.m7831constructorimpl(this.savedState), this.key);
    }

    @Override // muc.a, muc.e
    public <T> T decodeSerializableValue(juc.c<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        T r101 = (T) decodeFormatSpecificTypes(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (T) super.decodeSerializableValue(r100);
    }

    public SavedStateDecoder(Bundle r100, SavedStateConfiguration r101) {
        Intrinsics.checkNotNullParameter(r100, "savedState");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        this.savedState = r100;
        this.configuration = r101;
        this.key = "";
        this.serializersModule = r101.getSerializersModule();
    }

    private static final boolean decodeElementIndex$hasDefaultValueDefined(f r100, int r101) {
        return r100.i(r101);
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder r100, f r101, int r102) {
        return SavedStateReader.m7832containsimpl(SavedStateReader.m7831constructorimpl(r100.savedState), r101.b(r102));
    }
}
