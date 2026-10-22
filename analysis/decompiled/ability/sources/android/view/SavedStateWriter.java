package android.view;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u001d\u0010&\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J'\u00102\u001a\u00020\u000b\"\b\b\u0000\u0010/*\u00020.2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b0\u00101J'\u00106\u001a\u00020\u000b\"\b\b\u0000\u0010/*\u0002032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b4\u00105J\u001d\u0010:\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u000207¢\u0006\u0004\b8\u00109J\u001d\u0010>\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u001d\u0010A\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b?\u0010@J#\u0010E\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020#0B¢\u0006\u0004\bC\u0010DJ#\u0010G\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00170B¢\u0006\u0004\bF\u0010DJ'\u0010I\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030B¢\u0006\u0004\bH\u0010DJ#\u0010K\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070B¢\u0006\u0004\bJ\u0010DJ-\u0010M\u001a\u00020\u000b\"\b\b\u0000\u0010/*\u00020.2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000B¢\u0006\u0004\bL\u0010DJ\u001d\u0010Q\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020N¢\u0006\u0004\bO\u0010PJ\u001d\u0010U\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020R¢\u0006\u0004\bS\u0010TJ#\u0010Y\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00170V¢\u0006\u0004\bW\u0010XJ\u001d\u0010]\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020Z¢\u0006\u0004\b[\u0010\\J\u001d\u0010a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020^¢\u0006\u0004\b_\u0010`J\u001d\u0010e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u001d\u0010i\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020f¢\u0006\u0004\bg\u0010hJ'\u0010l\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030V¢\u0006\u0004\bj\u0010kJ#\u0010o\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070V¢\u0006\u0004\bm\u0010nJ-\u0010r\u001a\u00020\u000b\"\b\b\u0000\u0010/*\u00020.2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000V¢\u0006\u0004\bp\u0010qJ-\u0010v\u001a\u00020\u000b\"\b\b\u0000\u0010/*\u00020.2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000s¢\u0006\u0004\bt\u0010uJ!\u0010y\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\bw\u0010xJ\u0019\u0010}\u001a\u00020\u000b2\n\u0010z\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b{\u0010|J\u0015\u0010\u007f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b~\u0010,J\u0010\u0010\u0082\u0001\u001a\u00020\u000b¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0013\u0010\u0085\u0001\u001a\u00020\u0007HÖ\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0013\u0010\u0088\u0001\u001a\u00020#HÖ\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001e\u0010\u008c\u0001\u001a\u00020\u000f2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0004\u0010\u008d\u0001\u0088\u0001\u0004\u0092\u0001\u00060\u0002j\u0002`\u0003¨\u0006\u008e\u0001"}, d2 = {"Landroidx/savedstate/SavedStateWriter;", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", AgentBusWakeContract.EXTRA_SOURCE, "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "", "key", "Landroid/os/IBinder;", "value", "LC7/r;", "putBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V", "putBinder", "", "putBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;Z)V", "putBoolean", "", "putChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;C)V", "putChar", "", "putCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/CharSequence;)V", "putCharSequence", "", "putDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;D)V", "putDouble", "", "putFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;F)V", "putFloat", "", "putInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;I)V", "putInt", "", "putLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;J)V", "putLong", "putNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)V", "putNull", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "putParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Parcelable;)V", "putParcelable", "Ljava/io/Serializable;", "putJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "putJavaSerializable", "Landroid/util/Size;", "putSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/Size;)V", "putSize", "Landroid/util/SizeF;", "putSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SizeF;)V", "putSizeF", "putString-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "putString", "", "putIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;)V", "putIntList", "putCharSequenceList-impl", "putCharSequenceList", "putSavedStateList-impl", "putSavedStateList", "putStringList-impl", "putStringList", "putParcelableList-impl", "putParcelableList", "", "putBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Z)V", "putBooleanArray", "", "putCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[C)V", "putCharArray", "", "putCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "putCharSequenceArray", "", "putDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[D)V", "putDoubleArray", "", "putFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[F)V", "putFloatArray", "", "putIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[I)V", "putIntArray", "", "putLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[J)V", "putLongArray", "putSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Bundle;)V", "putSavedStateArray", "putStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "putStringArray", "putParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "putParcelableArray", "Landroid/util/SparseArray;", "putSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SparseArray;)V", "putSparseParcelableArray", "putSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;)V", "putSavedState", TypedValues.TransitionType.S_FROM, "putAll-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)V", "putAll", "remove-impl", "remove", "clear-impl", "(Landroid/os/Bundle;)V", "clear", "toString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "toString", "hashCode-impl", "(Landroid/os/Bundle;)I", "hashCode", "other", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "equals", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateWriter {
    private final Bundle source;

    private /* synthetic */ SavedStateWriter(Bundle bundle) {
        this.source = bundle;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateWriter m7261boximpl(Bundle bundle) {
        return new SavedStateWriter(bundle);
    }

    /* renamed from: clear-impl, reason: not valid java name */
    public static final void m7262clearimpl(Bundle bundle) {
        bundle.clear();
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m7263constructorimpl(Bundle source) {
        k.f(source, "source");
        return source;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7264equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateWriter) && k.b(bundle, ((SavedStateWriter) obj).getSource());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7265equalsimpl0(Bundle bundle, Bundle bundle2) {
        return k.b(bundle, bundle2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7266hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* renamed from: putAll-impl, reason: not valid java name */
    public static final void m7267putAllimpl(Bundle bundle, Bundle from) {
        k.f(from, "from");
        bundle.putAll(from);
    }

    /* renamed from: putBinder-impl, reason: not valid java name */
    public static final void m7268putBinderimpl(Bundle bundle, String key, IBinder value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putBinder(key, value);
    }

    /* renamed from: putBoolean-impl, reason: not valid java name */
    public static final void m7269putBooleanimpl(Bundle bundle, String key, boolean z10) {
        k.f(key, "key");
        bundle.putBoolean(key, z10);
    }

    /* renamed from: putBooleanArray-impl, reason: not valid java name */
    public static final void m7270putBooleanArrayimpl(Bundle bundle, String key, boolean[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putBooleanArray(key, value);
    }

    /* renamed from: putChar-impl, reason: not valid java name */
    public static final void m7271putCharimpl(Bundle bundle, String key, char c) {
        k.f(key, "key");
        bundle.putChar(key, c);
    }

    /* renamed from: putCharArray-impl, reason: not valid java name */
    public static final void m7272putCharArrayimpl(Bundle bundle, String key, char[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putCharArray(key, value);
    }

    /* renamed from: putCharSequence-impl, reason: not valid java name */
    public static final void m7273putCharSequenceimpl(Bundle bundle, String key, CharSequence value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putCharSequence(key, value);
    }

    /* renamed from: putCharSequenceArray-impl, reason: not valid java name */
    public static final void m7274putCharSequenceArrayimpl(Bundle bundle, String key, CharSequence[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putCharSequenceArray(key, value);
    }

    /* renamed from: putCharSequenceList-impl, reason: not valid java name */
    public static final void m7275putCharSequenceListimpl(Bundle bundle, String key, List<? extends CharSequence> value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putCharSequenceArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* renamed from: putDouble-impl, reason: not valid java name */
    public static final void m7276putDoubleimpl(Bundle bundle, String key, double d) {
        k.f(key, "key");
        bundle.putDouble(key, d);
    }

    /* renamed from: putDoubleArray-impl, reason: not valid java name */
    public static final void m7277putDoubleArrayimpl(Bundle bundle, String key, double[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putDoubleArray(key, value);
    }

    /* renamed from: putFloat-impl, reason: not valid java name */
    public static final void m7278putFloatimpl(Bundle bundle, String key, float f) {
        k.f(key, "key");
        bundle.putFloat(key, f);
    }

    /* renamed from: putFloatArray-impl, reason: not valid java name */
    public static final void m7279putFloatArrayimpl(Bundle bundle, String key, float[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putFloatArray(key, value);
    }

    /* renamed from: putInt-impl, reason: not valid java name */
    public static final void m7280putIntimpl(Bundle bundle, String key, int i) {
        k.f(key, "key");
        bundle.putInt(key, i);
    }

    /* renamed from: putIntArray-impl, reason: not valid java name */
    public static final void m7281putIntArrayimpl(Bundle bundle, String key, int[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putIntArray(key, value);
    }

    /* renamed from: putIntList-impl, reason: not valid java name */
    public static final void m7282putIntListimpl(Bundle bundle, String key, List<Integer> value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putIntegerArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* renamed from: putJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> void m7283putJavaSerializableimpl(Bundle bundle, String key, T value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putSerializable(key, value);
    }

    /* renamed from: putLong-impl, reason: not valid java name */
    public static final void m7284putLongimpl(Bundle bundle, String key, long j5) {
        k.f(key, "key");
        bundle.putLong(key, j5);
    }

    /* renamed from: putLongArray-impl, reason: not valid java name */
    public static final void m7285putLongArrayimpl(Bundle bundle, String key, long[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putLongArray(key, value);
    }

    /* renamed from: putNull-impl, reason: not valid java name */
    public static final void m7286putNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        bundle.putString(key, null);
    }

    /* renamed from: putParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m7287putParcelableimpl(Bundle bundle, String key, T value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putParcelable(key, value);
    }

    /* renamed from: putParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m7288putParcelableArrayimpl(Bundle bundle, String key, T[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putParcelableArray(key, value);
    }

    /* renamed from: putParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m7289putParcelableListimpl(Bundle bundle, String key, List<? extends T> value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putParcelableArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* renamed from: putSavedState-impl, reason: not valid java name */
    public static final void m7290putSavedStateimpl(Bundle bundle, String key, Bundle value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putBundle(key, value);
    }

    /* renamed from: putSavedStateArray-impl, reason: not valid java name */
    public static final void m7291putSavedStateArrayimpl(Bundle bundle, String key, Bundle[] value) {
        k.f(key, "key");
        k.f(value, "value");
        m7288putParcelableArrayimpl(bundle, key, value);
    }

    /* renamed from: putSavedStateList-impl, reason: not valid java name */
    public static final void m7292putSavedStateListimpl(Bundle bundle, String key, List<Bundle> value) {
        k.f(key, "key");
        k.f(value, "value");
        m7289putParcelableListimpl(bundle, key, value);
    }

    /* renamed from: putSize-impl, reason: not valid java name */
    public static final void m7293putSizeimpl(Bundle bundle, String key, Size value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putSize(key, value);
    }

    /* renamed from: putSizeF-impl, reason: not valid java name */
    public static final void m7294putSizeFimpl(Bundle bundle, String key, SizeF value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putSizeF(key, value);
    }

    /* renamed from: putSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m7295putSparseParcelableArrayimpl(Bundle bundle, String key, SparseArray<T> value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putSparseParcelableArray(key, value);
    }

    /* renamed from: putString-impl, reason: not valid java name */
    public static final void m7296putStringimpl(Bundle bundle, String key, String value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putString(key, value);
    }

    /* renamed from: putStringArray-impl, reason: not valid java name */
    public static final void m7297putStringArrayimpl(Bundle bundle, String key, String[] value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putStringArray(key, value);
    }

    /* renamed from: putStringList-impl, reason: not valid java name */
    public static final void m7298putStringListimpl(Bundle bundle, String key, List<String> value) {
        k.f(key, "key");
        k.f(value, "value");
        bundle.putStringArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* renamed from: remove-impl, reason: not valid java name */
    public static final void m7299removeimpl(Bundle bundle, String key) {
        k.f(key, "key");
        bundle.remove(key);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7300toStringimpl(Bundle bundle) {
        return "SavedStateWriter(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m7264equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m7266hashCodeimpl(this.source);
    }

    public String toString() {
        return m7300toStringimpl(this.source);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Bundle getSource() {
        return this.source;
    }
}
