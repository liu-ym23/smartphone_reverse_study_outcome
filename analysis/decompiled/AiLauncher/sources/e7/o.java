package e7;

import La.C0953c;
import Y8.t;
import Z8.C1168p;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.core.storage.FileHeader;
import com.stepos.datacenter.core.storage.FileMagic;
import com.stepos.datacenter.core.storage.c;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.IndexDescriptor;
import com.stepos.datacenter.vector.VectorRegistrySnapshot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5174d;
import qb.v;
import v9.C5685n;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\tJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u001bR\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0-j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010/R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170-j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0017`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010/¨\u00063"}, d2 = {"Le7/o;", "", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/datacenter/core/result/DataCenterResult;", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", Const.JSON_KEY_DESC, "l", "(Lcom/stepos/datacenter/vector/CollectionDescriptor;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "", "id", "e", "(Ljava/lang/String;)Lcom/stepos/datacenter/vector/CollectionDescriptor;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/List;", "m", "(Ljava/lang/String;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "Lcom/stepos/datacenter/vector/IndexDescriptor;", "f", "(Ljava/lang/String;)Lcom/stepos/datacenter/vector/IndexDescriptor;", Const.INTENT_KEY_UMID, "()Ljava/io/File;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lkotlin/Result;", "Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "k", "(Ljava/io/File;)Ljava/lang/Object;", "", SingleFileBundle.KEY_BYTES, "", "c", "([B)J", Const.INTENT_KEY_APIKEY, "Ljava/io/File;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "lock", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "collections", "indexes", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC5171a f32324e = v.b(null, new InterfaceC5074l() { // from class: e7.n
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return o.b((C5174d) obj);
        }
    }, 1, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final File rootDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ReentrantReadWriteLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final LinkedHashMap<String, CollectionDescriptor> collections;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final LinkedHashMap<String, IndexDescriptor> indexes;

    public o(File rootDir) throws IOException {
        kotlin.jvm.internal.p.i(rootDir, "rootDir");
        this.rootDir = rootDir;
        this.lock = new ReentrantReadWriteLock();
        this.collections = new LinkedHashMap<>();
        this.indexes = new LinkedHashMap<>();
        if (!rootDir.exists() && !rootDir.mkdirs()) {
            throw new IOException("Cannot create VectorRegistry dir: " + rootDir.getAbsolutePath());
        }
        if (rootDir.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException(("rootDir must be a directory: " + rootDir.getAbsolutePath()).toString());
    }

    public static final t b(C5174d Json) {
        kotlin.jvm.internal.p.i(Json, "$this$Json");
        Json.e(true);
        Json.g(true);
        Json.i(false);
        return t.f7040a;
    }

    public final long c(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return crc32.getValue();
    }

    public final File d() {
        return new File(this.rootDir, "vector_registry.json");
    }

    public final CollectionDescriptor e(String id) {
        kotlin.jvm.internal.p.i(id, "id");
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            return this.collections.get(id);
        } finally {
            lock.unlock();
        }
    }

    public final IndexDescriptor f(String id) {
        kotlin.jvm.internal.p.i(id, "id");
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            return this.indexes.get(id);
        } finally {
            lock.unlock();
        }
    }

    /* renamed from: g, reason: from getter */
    public final File getRootDir() {
        return this.rootDir;
    }

    public final List<CollectionDescriptor> h() {
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            Collection<CollectionDescriptor> collectionValues = this.collections.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            return F.m1(collectionValues);
        } finally {
            lock.unlock();
        }
    }

    public final DataCenterResult<t> i() {
        DataCenterResult<t> dataCenterResultFailure;
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            File fileD = d();
            if (fileD.exists()) {
                Object objK = k(fileD);
                Throwable thE = Result.e(objK);
                if (thE == null) {
                    VectorRegistrySnapshot vectorRegistrySnapshot = (VectorRegistrySnapshot) objK;
                    this.collections.clear();
                    this.indexes.clear();
                    for (CollectionDescriptor collectionDescriptor : vectorRegistrySnapshot.g()) {
                        this.collections.put(collectionDescriptor.getId(), collectionDescriptor);
                    }
                    for (IndexDescriptor indexDescriptor : vectorRegistrySnapshot.i()) {
                        this.indexes.put(indexDescriptor.getId(), indexDescriptor);
                    }
                    dataCenterResultFailure = DataCenterResult.INSTANCE.ok(t.f7040a);
                } else {
                    DataCenterResult.Companion companion = DataCenterResult.INSTANCE;
                    DataCenterError dataCenterError = DataCenterError.CORRUPT_DATA;
                    String message = thE.getMessage();
                    if (message == null) {
                        message = "vector_registry load failed";
                    }
                    dataCenterResultFailure = companion.failure(dataCenterError, message, thE);
                }
            } else {
                this.collections.clear();
                this.indexes.clear();
                dataCenterResultFailure = DataCenterResult.INSTANCE.ok(t.f7040a);
            }
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            return dataCenterResultFailure;
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final DataCenterResult<t> j() throws IOException {
        Collection<CollectionDescriptor> collectionValues = this.collections.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        List listM1 = F.m1(collectionValues);
        Collection<IndexDescriptor> collectionValues2 = this.indexes.values();
        kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
        VectorRegistrySnapshot vectorRegistrySnapshot = new VectorRegistrySnapshot(1, listM1, F.m1(collectionValues2));
        AbstractC5171a abstractC5171a = f32324e;
        abstractC5171a.getSerializersModule();
        byte[] bytes = abstractC5171a.a(VectorRegistrySnapshot.INSTANCE.serializer(), vectorRegistrySnapshot).getBytes(C0953c.UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        int iC = (int) c(bytes);
        byte[] bArrA = new FileHeader(FileMagic.VECTOR_REGISTRY, 1, 0L, System.nanoTime(), FileHeader.INSTANCE.d("vector_registry.v1"), 4, null).a();
        byte[] bArrArray = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(iC).array();
        File file = new File(this.rootDir, "vector_registry.json.tmp");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArrA);
                fileOutputStream.write(bytes);
                fileOutputStream.write(bArrArray);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                t tVar = t.f7040a;
                l9.b.a(fileOutputStream, null);
                Files.move(file.toPath(), d().toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                return DataCenterResult.INSTANCE.ok(t.f7040a);
            } finally {
            }
        } catch (IOException e10) {
            file.delete();
            return DataCenterResult.INSTANCE.failure(DataCenterError.INTERNAL_ERROR, "persist failed: " + e10.getMessage(), e10);
        }
    }

    public final Object k(File f10) {
        try {
            byte[] bArrJ = l9.i.j(f10);
            if (bArrJ.length < 68) {
                Result.Companion companion = Result.INSTANCE;
                return Result.b(C4849c.a(new IllegalStateException("vector_registry truncated: " + bArrJ.length + " < 68")));
            }
            com.stepos.datacenter.core.storage.c cVarB = FileHeader.INSTANCE.b(bArrJ, 0, FileMagic.VECTOR_REGISTRY);
            if (cVarB instanceof c.Failure) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.b(C4849c.a(new IllegalStateException("vector_registry bad header: " + ((c.Failure) cVarB).getError().getMessage())));
            }
            if (!(cVarB instanceof c.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            c.Success success = (c.Success) cVarB;
            if (success.getHeader().getFormatVersion() != 1) {
                Result.Companion companion3 = Result.INSTANCE;
                return Result.b(C4849c.a(new IllegalStateException("vector_registry formatVersion " + success.getHeader().getFormatVersion() + " != supported 1")));
            }
            byte[] bArrO = C1168p.o(bArrJ, 64, bArrJ.length - 4);
            long j10 = ByteBuffer.wrap(bArrJ, r0, 4).order(ByteOrder.LITTLE_ENDIAN).getInt() & 4294967295L;
            long jC = c(bArrO);
            if (j10 != jC) {
                Result.Companion companion4 = Result.INSTANCE;
                return Result.b(C4849c.a(new IllegalStateException("vector_registry body CRC mismatch: stored=" + j10 + " computed=" + jC)));
            }
            try {
                Result.Companion companion5 = Result.INSTANCE;
                AbstractC5171a abstractC5171a = f32324e;
                String str = new String(bArrO, C0953c.UTF_8);
                abstractC5171a.getSerializersModule();
                return Result.b(abstractC5171a.c(VectorRegistrySnapshot.INSTANCE.serializer(), str));
            } catch (Exception e10) {
                Result.Companion companion6 = Result.INSTANCE;
                return Result.b(C4849c.a(e10));
            }
        } catch (IOException e11) {
            Result.Companion companion7 = Result.INSTANCE;
            return Result.b(C4849c.a(e11));
        }
    }

    public final DataCenterResult<CollectionDescriptor> l(CollectionDescriptor desc) {
        DataCenterResult dataCenterResultOk;
        kotlin.jvm.internal.p.i(desc, "desc");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (this.collections.containsKey(desc.getId())) {
                dataCenterResultOk = DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.ALREADY_EXISTS, "collection '" + desc.getId() + "' already exists", null, 4, null);
            } else {
                List<String> activeIndexIds = desc.getActiveIndexIds();
                ArrayList arrayList = new ArrayList();
                for (Object obj : activeIndexIds) {
                    if (!this.indexes.containsKey((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.collections.put(desc.getId(), desc);
                    DataCenterResult dataCenterResultJ = j();
                    if (dataCenterResultJ instanceof DataCenterResult.Failure) {
                        this.collections.remove(desc.getId());
                        dataCenterResultOk = dataCenterResultJ;
                    } else {
                        dataCenterResultOk = DataCenterResult.INSTANCE.ok(desc);
                    }
                } else {
                    dataCenterResultOk = DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.INVALID_ARGS, "collection '" + desc.getId() + "' references unknown index(es): " + arrayList, null, 4, null);
                }
            }
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            return dataCenterResultOk;
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final DataCenterResult<t> m(String id) {
        DataCenterResult<t> dataCenterResultOk;
        kotlin.jvm.internal.p.i(id, "id");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            CollectionDescriptor collectionDescriptor = this.collections.get(id);
            if (collectionDescriptor == null) {
                dataCenterResultOk = DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.VECTOR_COLLECTION_NOT_FOUND, "collection '" + id + "' not registered", null, 4, null);
            } else {
                Collection<IndexDescriptor> collectionValues = this.indexes.values();
                kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    if (kotlin.jvm.internal.p.d(((IndexDescriptor) obj).getCollectionId(), id)) {
                        arrayList.add(obj);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(arrayList, 10)), 16));
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(((IndexDescriptor) obj2).getId(), obj2);
                }
                this.collections.remove(id);
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    this.indexes.remove((String) it.next());
                }
                DataCenterResult<t> dataCenterResultJ = j();
                if (dataCenterResultJ instanceof DataCenterResult.Failure) {
                    this.collections.put(id, collectionDescriptor);
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        kotlin.jvm.internal.p.h(value, "component2(...)");
                        this.indexes.put(str, (IndexDescriptor) value);
                    }
                    dataCenterResultOk = dataCenterResultJ;
                } else {
                    dataCenterResultOk = DataCenterResult.INSTANCE.ok(t.f7040a);
                }
            }
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            return dataCenterResultOk;
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }
}
