package androidx.compose.runtime.snapshots;

import Y8.t;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.f;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d0.C3941a;
import d0.e;
import io.ktor.http.ContentDisposition;
import j0.C4753k;
import j0.n;
import j0.o;
import j0.p;
import j0.r;
import j0.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import p9.InterfaceC5074l;
import q9.InterfaceC5165d;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010+\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 U*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006:\u0001VB\u0017\b\u0000\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010!J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b)\u0010+J%\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b3\u0010\u0017J\u001f\u00103\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b3\u00104J%\u00105\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b5\u00106J\u001d\u00105\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b5\u0010\u001bJ\u000f\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u000bJ\u0017\u00108\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b8\u0010\u0017J\u001d\u00109\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b9\u0010\u001bJ\u0017\u0010:\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b:\u0010\u001fJ\u001d\u0010;\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b;\u0010\u001bJ \u0010<\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u001d\u0010>\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c¢\u0006\u0004\b>\u0010?J-\u0010D\u001a\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001cH\u0000¢\u0006\u0004\bB\u0010CJ\u001f\u0010H\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u001cH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u001cH\u0016¢\u0006\u0004\bJ\u0010KR$\u0010L\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR \u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118AX\u0080\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u000b\u001a\u0004\bP\u0010\u0013R\u0014\u0010T\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010K¨\u0006W"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Lj0/p;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ld0/e;", "persistentList", "<init>", "(Ld0/e;)V", "()V", "Lj0/r;", UxipConstants.f30680s, "LY8/t;", "prependStateRecord", "(Lj0/r;)V", "", "toList", "()Ljava/util/List;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "add", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeRange", "(II)V", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "retainAllInRange$runtime", "(Ljava/util/Collection;II)I", "retainAllInRange", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "firstStateRecord", "Lj0/r;", "getFirstStateRecord", "()Lj0/r;", "getDebuggerDisplayValue", "getDebuggerDisplayValue$annotations", "debuggerDisplayValue", "getSize", ContentDisposition.Parameters.Size, "Companion", Const.INTENT_KEY_PKGNAME, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class SnapshotStateList<T> implements Parcelable, p, List<T>, RandomAccess, InterfaceC5165d {
    public static final int $stable = 0;
    private r firstStateRecord;
    public static final Parcelable.Creator<SnapshotStateList<Object>> CREATOR = new a();

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J)\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SnapshotStateList$a", "Landroid/os/Parcelable$ClassLoaderCreator;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "Landroid/os/Parcel;", "parcel", "Ljava/lang/ClassLoader;", "loader", "c", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", Const.INTENT_KEY_PKGNAME, "(Landroid/os/Parcel;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", ContentDisposition.Parameters.Size, "", "e", "(I)[Landroidx/compose/runtime/snapshots/SnapshotStateList;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.ClassLoaderCreator<SnapshotStateList<Object>> {
        public static final Object d(Parcel parcel, ClassLoader classLoader, int i10) {
            return parcel.readValue(classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SnapshotStateList<Object> createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SnapshotStateList<Object> createFromParcel(final Parcel parcel, final ClassLoader loader) {
            if (loader == null) {
                loader = a.class.getClassLoader();
            }
            return C4753k.a(parcel.readInt(), new InterfaceC5074l() { // from class: j0.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SnapshotStateList.a.d(parcel, loader, ((Integer) obj).intValue());
                }
            });
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public SnapshotStateList<Object>[] newArray(int size) {
            return new SnapshotStateList[size];
        }
    }

    public SnapshotStateList(d0.e<? extends T> eVar) {
        this.firstStateRecord = C4753k.l(this, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addAll$lambda$4(int i10, Collection collection, List list) {
        return list.addAll(i10, collection);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainAll$lambda$10(Collection collection, List list) {
        return list.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarAdd = eVarG.add((d0.e<T>) element);
            if (kotlin.jvm.internal.p.d(eVarAdd, eVarG)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarAdd, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int index, final Collection<? extends T> elements) {
        return C4753k.k(this, new InterfaceC5074l() { // from class: j0.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SnapshotStateList.addAll$lambda$4(index, elements, (List) obj));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        c cVarA;
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        o oVar = (o) firstStateRecord;
        synchronized (d.h()) {
            cVarA = c.INSTANCE.a();
            o oVar2 = (o) d.t(oVar, this, cVarA);
            synchronized (C4753k.f34438a) {
                oVar2.j(C3941a.a());
                oVar2.k(oVar2.getModification() + 1);
                oVar2.l(oVar2.getStructuralChange() + 1);
            }
        }
        d.k(cVarA, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return C4753k.g(this).g().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        return C4753k.g(this).g().containsAll(elements);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.List
    public T get(int index) {
        return C4753k.g(this).g().get(index);
    }

    public final List<T> getDebuggerDisplayValue() {
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((o) d.e((o) firstStateRecord)).g();
    }

    @Override // j0.p
    public r getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return C4753k.g(this).g().size();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return C4753k.g(this).g().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return C4753k.g(this).g().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return C4753k.g(this).g().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new n(this, 0);
    }

    @Override // j0.p
    public /* bridge */ /* synthetic */ r mergeRecords(r rVar, r rVar2, r rVar3) {
        return super.mergeRecords(rVar, rVar2, rVar3);
    }

    @Override // j0.p
    public void prependStateRecord(r value) {
        value.e(getFirstStateRecord());
        kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (o) value;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return removeAt(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> elements) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarRemoveAll = eVarG.removeAll((Collection<? extends T>) elements);
            if (kotlin.jvm.internal.p.d(eVarRemoveAll, eVarG)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarRemoveAll, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return true;
    }

    public T removeAt(int index) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        T t10 = get(index);
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarH = eVarG.h(index);
            if (kotlin.jvm.internal.p.d(eVarH, eVarG)) {
                return t10;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarH, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return t10;
    }

    public final void removeRange(int fromIndex, int toIndex) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            e.a<T> aVarBuilder = eVarG.builder();
            aVarBuilder.subList(fromIndex, toIndex).clear();
            d0.e<T> eVarBuild = aVarBuilder.build();
            if (kotlin.jvm.internal.p.d(eVarBuild, eVarG)) {
                return;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarBuild, true);
            }
            d.k(cVarA, this);
        } while (!zF);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<?> elements) {
        return C4753k.k(this, new InterfaceC5074l() { // from class: j0.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SnapshotStateList.retainAll$lambda$10(elements, (List) obj));
            }
        });
    }

    public final int retainAllInRange$runtime(Collection<? extends T> elements, int start, int end) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        int size = size();
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            e.a<T> aVarBuilder = eVarG.builder();
            aVarBuilder.subList(start, end).retainAll(elements);
            d0.e<T> eVarBuild = aVarBuilder.build();
            if (kotlin.jvm.internal.p.d(eVarBuild, eVarG)) {
                break;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarBuild, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return size - size();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        T t10 = get(index);
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVar = eVarG.set(index, (int) element);
            if (kotlin.jvm.internal.p.d(eVar, eVarG)) {
                return t10;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVar, false);
            }
            d.k(cVarA, this);
        } while (!zF);
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size())) {
            f.a("fromIndex or toIndex are out of bounds");
        }
        return new u(this, fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return h.a(this);
    }

    public final List<T> toList() {
        return C4753k.g(this).g();
    }

    public String toString() {
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((o) d.e((o) firstStateRecord)).g() + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        List<T> list = toList();
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeValue(list.get(i10));
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarAddAll = eVarG.addAll(elements);
            if (kotlin.jvm.internal.p.d(eVarAddAll, eVarG)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarAddAll, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return true;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new n(this, index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarRemove = eVarG.remove((d0.e<T>) element);
            if (kotlin.jvm.internal.p.d(eVarRemove, eVarG)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarRemove, true);
            }
            d.k(cVarA, this);
        } while (!zF);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h.b(this, tArr);
    }

    public SnapshotStateList() {
        this(C3941a.a());
    }

    @Override // java.util.List
    public void add(int index, T element) {
        int modification;
        d0.e<T> eVarG;
        c cVarA;
        boolean zF;
        do {
            synchronized (C4753k.f34438a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                o oVar = (o) d.e((o) firstStateRecord);
                modification = oVar.getModification();
                eVarG = oVar.g();
                t tVar = t.f7040a;
            }
            kotlin.jvm.internal.p.f(eVarG);
            d0.e<T> eVarAdd = eVarG.add(index, (int) element);
            if (kotlin.jvm.internal.p.d(eVarAdd, eVarG)) {
                return;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            o oVar2 = (o) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zF = C4753k.f((o) d.t(oVar2, this, cVarA), modification, eVarAdd, true);
            }
            d.k(cVarA, this);
        } while (!zF);
    }
}
