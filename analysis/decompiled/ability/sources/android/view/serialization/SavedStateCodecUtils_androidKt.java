package android.view.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.view.serialization.serializers.CharSequenceSerializer;
import android.view.serialization.serializers.DefaultParcelableSerializer;
import android.view.serialization.serializers.SparseArraySerializer;
import g1.AbstractC1451a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import x9.c;
import z9.g;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b&\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u001a\u0010\t\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\" \u0010\u000b\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0002\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\u0004\" \u0010\u000f\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0002\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\u0004\"\u001a\u0010\u0012\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0004\"\u001a\u0010\u0014\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0004\" \u0010\u0016\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0002\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0017\u0010\u0004\" \u0010\u0019\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0002\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\u0004\"\u001a\u0010\u001c\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0004\"\u001a\u0010\u001e\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0004\"\u001a\u0010 \u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010\u0002\u001a\u0004\b!\u0010\u0004\"\u001a\u0010\"\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0004\"\u001a\u0010$\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0004¨\u0006&"}, d2 = {"Lz9/g;", "polymorphicCharSequenceDescriptor", "Lz9/g;", "getPolymorphicCharSequenceDescriptor", "()Lz9/g;", "polymorphicParcelableDescriptor", "getPolymorphicParcelableDescriptor", "polymorphicJavaSerializableDescriptor", "getPolymorphicJavaSerializableDescriptor", "polymorphicIBinderDescriptor", "getPolymorphicIBinderDescriptor", "parcelableArrayDescriptor", "getParcelableArrayDescriptor", "getParcelableArrayDescriptor$annotations", "()V", "polymorphicParcelableArrayDescriptor", "getPolymorphicParcelableArrayDescriptor", "getPolymorphicParcelableArrayDescriptor$annotations", "parcelableListDescriptor", "getParcelableListDescriptor", "polymorphicParcelableListDescriptor", "getPolymorphicParcelableListDescriptor", "charSequenceArrayDescriptor", "getCharSequenceArrayDescriptor", "getCharSequenceArrayDescriptor$annotations", "polymorphicCharSequenceArrayDescriptor", "getPolymorphicCharSequenceArrayDescriptor", "getPolymorphicCharSequenceArrayDescriptor$annotations", "charSequenceListDescriptor", "getCharSequenceListDescriptor", "polymorphicCharSequenceListDescriptor", "getPolymorphicCharSequenceListDescriptor", "sparseParcelableArrayDescriptor", "getSparseParcelableArrayDescriptor", "polymorphicSparseParcelableArrayDescriptor", "getPolymorphicSparseParcelableArrayDescriptor", "nullablePolymorphicSparseParcelableArrayDescriptor", "getNullablePolymorphicSparseParcelableArrayDescriptor", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateCodecUtils_androidKt {
    private static final g charSequenceArrayDescriptor;
    private static final g charSequenceListDescriptor;
    private static final g nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final g parcelableArrayDescriptor;
    private static final g parcelableListDescriptor;
    private static final g polymorphicCharSequenceArrayDescriptor;
    private static final g polymorphicCharSequenceDescriptor;
    private static final g polymorphicCharSequenceListDescriptor;
    private static final g polymorphicIBinderDescriptor;
    private static final g polymorphicJavaSerializableDescriptor;
    private static final g polymorphicParcelableArrayDescriptor;
    private static final g polymorphicParcelableDescriptor;
    private static final g polymorphicParcelableListDescriptor;
    private static final g polymorphicSparseParcelableArrayDescriptor;
    private static final g sparseParcelableArrayDescriptor;

    static {
        n nVar = m.f4928a;
        polymorphicCharSequenceDescriptor = new c(nVar.b(CharSequence.class)).getDescriptor();
        polymorphicParcelableDescriptor = new c(nVar.b(Parcelable.class)).getDescriptor();
        polymorphicJavaSerializableDescriptor = new c(nVar.b(Serializable.class)).getDescriptor();
        polymorphicIBinderDescriptor = new c(nVar.b(IBinder.class)).getDescriptor();
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
        parcelableArrayDescriptor = AbstractC1451a.c(nVar.b(Parcelable.class), defaultParcelableSerializer).c;
        polymorphicParcelableArrayDescriptor = AbstractC1451a.c(nVar.b(Parcelable.class), new c(nVar.b(Parcelable.class))).c;
        parcelableListDescriptor = AbstractC1451a.d(defaultParcelableSerializer).b;
        polymorphicParcelableListDescriptor = AbstractC1451a.d(new c(nVar.b(Parcelable.class))).b;
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
        charSequenceArrayDescriptor = AbstractC1451a.c(nVar.b(CharSequence.class), charSequenceSerializer).c;
        polymorphicCharSequenceArrayDescriptor = AbstractC1451a.c(nVar.b(CharSequence.class), new c(nVar.b(CharSequence.class))).c;
        charSequenceListDescriptor = AbstractC1451a.d(charSequenceSerializer).b;
        polymorphicCharSequenceListDescriptor = AbstractC1451a.d(new c(nVar.b(CharSequence.class))).b;
        sparseParcelableArrayDescriptor = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new c(nVar.b(Parcelable.class))).getDescriptor();
        nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(AbstractC1451a.G(new c(nVar.b(Parcelable.class)))).getDescriptor();
    }

    public static final g getCharSequenceArrayDescriptor() {
        return charSequenceArrayDescriptor;
    }

    public static /* synthetic */ void getCharSequenceArrayDescriptor$annotations() {
    }

    public static final g getCharSequenceListDescriptor() {
        return charSequenceListDescriptor;
    }

    public static final g getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final g getParcelableArrayDescriptor() {
        return parcelableArrayDescriptor;
    }

    public static /* synthetic */ void getParcelableArrayDescriptor$annotations() {
    }

    public static final g getParcelableListDescriptor() {
        return parcelableListDescriptor;
    }

    public static final g getPolymorphicCharSequenceArrayDescriptor() {
        return polymorphicCharSequenceArrayDescriptor;
    }

    public static /* synthetic */ void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static final g getPolymorphicCharSequenceDescriptor() {
        return polymorphicCharSequenceDescriptor;
    }

    public static final g getPolymorphicCharSequenceListDescriptor() {
        return polymorphicCharSequenceListDescriptor;
    }

    public static final g getPolymorphicIBinderDescriptor() {
        return polymorphicIBinderDescriptor;
    }

    public static final g getPolymorphicJavaSerializableDescriptor() {
        return polymorphicJavaSerializableDescriptor;
    }

    public static final g getPolymorphicParcelableArrayDescriptor() {
        return polymorphicParcelableArrayDescriptor;
    }

    public static /* synthetic */ void getPolymorphicParcelableArrayDescriptor$annotations() {
    }

    public static final g getPolymorphicParcelableDescriptor() {
        return polymorphicParcelableDescriptor;
    }

    public static final g getPolymorphicParcelableListDescriptor() {
        return polymorphicParcelableListDescriptor;
    }

    public static final g getPolymorphicSparseParcelableArrayDescriptor() {
        return polymorphicSparseParcelableArrayDescriptor;
    }

    public static final g getSparseParcelableArrayDescriptor() {
        return sparseParcelableArrayDescriptor;
    }
}
