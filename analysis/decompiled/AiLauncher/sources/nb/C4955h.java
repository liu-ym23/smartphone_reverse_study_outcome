package nb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003¨\u0006\b"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", Const.INTENT_KEY_APIKEY, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementDescriptors", "", Const.INTENT_KEY_PKGNAME, "elementNames", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: nb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4955h {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"nb/h$a", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "I", "elementsLeft", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: nb.h$a */
    public static final class a implements Iterator<SerialDescriptor>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int elementsLeft;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f37286b;

        public a(SerialDescriptor serialDescriptor) {
            this.f37286b = serialDescriptor;
            this.elementsLeft = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SerialDescriptor next() {
            SerialDescriptor serialDescriptor = this.f37286b;
            int iD = serialDescriptor.d();
            int i10 = this.elementsLeft;
            this.elementsLeft = i10 - 1;
            return serialDescriptor.g(iD - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.elementsLeft > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"nb/h$b", "", "", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "", "I", "elementsLeft", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: nb.h$b */
    public static final class b implements Iterator<String>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int elementsLeft;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f37288b;

        public b(SerialDescriptor serialDescriptor) {
            this.f37288b = serialDescriptor;
            this.elementsLeft = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            SerialDescriptor serialDescriptor = this.f37288b;
            int iD = serialDescriptor.d();
            int i10 = this.elementsLeft;
            this.elementsLeft = i10 - 1;
            return serialDescriptor.e(iD - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.elementsLeft > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"nb/h$c", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: nb.h$c */
    public static final class c implements Iterable<SerialDescriptor>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f37289a;

        public c(SerialDescriptor serialDescriptor) {
            this.f37289a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        public Iterator<SerialDescriptor> iterator() {
            return new a(this.f37289a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"nb/h$d", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: nb.h$d */
    public static final class d implements Iterable<String>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f37290a;

        public d(SerialDescriptor serialDescriptor) {
            this.f37290a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return new b(this.f37290a);
        }
    }

    public static final Iterable<SerialDescriptor> a(SerialDescriptor serialDescriptor) {
        p.i(serialDescriptor, "<this>");
        return new c(serialDescriptor);
    }

    public static final Iterable<String> b(SerialDescriptor serialDescriptor) {
        p.i(serialDescriptor, "<this>");
        return new d(serialDescriptor);
    }
}
