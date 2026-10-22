package android.view.serialization.serializers;

import A9.d;
import B9.C0177d;
import B9.F;
import B9.T;
import B9.V;
import B9.d0;
import C7.f;
import android.annotation.SuppressLint;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002:\u0001\u0019B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/savedstate/serialization/serializers/SparseArraySerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/b;", "Landroid/util/SparseArray;", "elementSerializer", AppAgent.CONSTRUCT, "(Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroid/util/SparseArray;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroid/util/SparseArray;", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "surrogateSerializer", "Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "SparseArraySurrogate", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SparseArraySerializer<T> implements b {
    private final g descriptor;
    private final b surrogateSerializer;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u0000 \u001c*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\u001d\u001cB#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\fJG\u0010\u0017\u001a\u00020\u0014\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "", "keys", "values", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/util/List;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/util/List;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "Lx9/b;", "typeSerial0", "LC7/r;", "write$Self$savedstate_release", "(Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;LA9/d;Lz9/g;Lx9/b;)V", "write$Self", "Ljava/util/List;", "getKeys", "()Ljava/util/List;", "getValues", "Companion", "$serializer", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SuppressLint({"UnsafeOptInUsageError"})
    public static final class SparseArraySurrogate<T> {
        private static final g $cachedDescriptor;
        private final List<Integer> keys;
        private final List<T> values;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {a.b(LazyThreadSafetyMode.b, new a()), null};

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0005\"\u0004\b\u0002\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate$Companion;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/b;", "typeSerial0", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "serializer", "(Lx9/b;)Lx9/b;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final <T> b serializer(b typeSerial0) {
                k.f(typeSerial0, "typeSerial0");
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(typeSerial0);
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        static {
            V v10 = new V("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            v10.j("keys", false);
            v10.j("values", false);
            $cachedDescriptor = v10;
        }

        public /* synthetic */ SparseArraySurrogate(int i, List list, List list2, d0 d0Var) {
            if (3 != (i & 3)) {
                T.g($cachedDescriptor, i, 3);
                throw null;
            }
            this.keys = list;
            this.values = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(F.f218a);
        }

        public static final /* synthetic */ void write$Self$savedstate_release(SparseArraySurrogate self, d output, g serialDesc, b typeSerial0) {
            output.encodeSerializableElement(serialDesc, 0, (x9.f) $childSerializers[0].getF4884a(), self.keys);
            output.encodeSerializableElement(serialDesc, 1, new C0177d(typeSerial0), self.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SparseArraySurrogate(List<Integer> keys, List<? extends T> values) {
            k.f(keys, "keys");
            k.f(values, "values");
            this.keys = keys;
            this.values = values;
        }
    }

    public SparseArraySerializer(b elementSerializer) {
        k.f(elementSerializer, "elementSerializer");
        b bVarSerializer = SparseArraySurrogate.INSTANCE.serializer(elementSerializer);
        this.surrogateSerializer = bVarSerializer;
        this.descriptor = bVarSerializer.getDescriptor();
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.InterfaceC2123a
    public SparseArray<T> deserialize(A9.e decoder) {
        k.f(decoder, "decoder");
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) decoder.decodeSerializableValue(this.surrogateSerializer);
        if (sparseArraySurrogate.getKeys().size() != sparseArraySurrogate.getValues().size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        SparseArray<T> sparseArray = new SparseArray<>(sparseArraySurrogate.getKeys().size());
        int size = sparseArraySurrogate.getKeys().size();
        for (int i = 0; i < size; i++) {
            sparseArray.append(sparseArraySurrogate.getKeys().get(i).intValue(), sparseArraySurrogate.getValues().get(i));
        }
        return sparseArray;
    }

    @Override // x9.f
    public void serialize(A9.f encoder, SparseArray<T> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        int size = value.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(value.keyAt(i)));
        }
        int size2 = value.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i6 = 0; i6 < size2; i6++) {
            arrayList2.add(value.valueAt(i6));
        }
        encoder.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(arrayList, arrayList2));
    }
}
