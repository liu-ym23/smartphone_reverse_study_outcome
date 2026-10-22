package com.stepos.datacenter.ame;

import La.C0953c;
import La.H;
import Y8.t;
import Z8.F;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5174d;
import qb.v;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R,\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u00180\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$¨\u0006)"}, d2 = {"Lcom/stepos/datacenter/ame/a;", "", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "", "collectionId", "Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "record", "LY8/t;", "t", "(Ljava/lang/String;Lcom/stepos/datacenter/ame/VectorMetadataRecord;)V", "", "vectorId", "r", "(Ljava/lang/String;J)Lcom/stepos/datacenter/ame/VectorMetadataRecord;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "p", "q", "()V", "s", "(Ljava/lang/String;)Ljava/io/File;", "", "m", "(Ljava/lang/String;)Ljava/util/Map;", Const.STR_FILE, "into", "w", "(Ljava/io/File;Ljava/util/Map;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Ljava/io/File;", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "caches", "c", "writerLocks", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC5171a f29799d = v.b(null, new InterfaceC5074l() { // from class: T6.a
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return com.stepos.datacenter.ame.a.h((C5174d) obj);
        }
    }, 1, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final File rootDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, Map<Long, VectorMetadataRecord>> caches;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, Object> writerLocks;

    public a(File rootDir) {
        p.i(rootDir, "rootDir");
        this.rootDir = rootDir;
        this.caches = new ConcurrentHashMap<>();
        this.writerLocks = new ConcurrentHashMap<>();
    }

    public static final t h(C5174d Json) {
        p.i(Json, "$this$Json");
        Json.g(true);
        Json.e(true);
        return t.f7040a;
    }

    public static final Object k(String it) {
        p.i(it, "it");
        return new Object();
    }

    public static final Object l(InterfaceC5074l interfaceC5074l, Object obj) {
        return interfaceC5074l.invoke(obj);
    }

    public static final Object n(String it) {
        p.i(it, "it");
        return new Object();
    }

    public static final Object o(InterfaceC5074l interfaceC5074l, Object obj) {
        return interfaceC5074l.invoke(obj);
    }

    public static final Object u(String it) {
        p.i(it, "it");
        return new Object();
    }

    public static final Object v(InterfaceC5074l interfaceC5074l, Object obj) {
        return interfaceC5074l.invoke(obj);
    }

    public final void i(String collectionId, VectorMetadataRecord record) {
        File fileS = s(collectionId);
        try {
            File parentFile = fileS.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileS, true), C0953c.UTF_8), b.THRESHOLD);
            try {
                bufferedWriter.write(f29799d.a(VectorMetadataRecord.INSTANCE.serializer(), record));
                bufferedWriter.newLine();
                t tVar = t.f7040a;
                l9.b.a(bufferedWriter, null);
            } finally {
            }
        } catch (IOException e10) {
            Log.w("PerColMetadataStore", "append: write failed for " + fileS.getAbsolutePath(), e10);
        }
    }

    public final void j(String collectionId) {
        p.i(collectionId, "collectionId");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.writerLocks;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: T6.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return com.stepos.datacenter.ame.a.k((String) obj);
            }
        };
        Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(collectionId, new Function() { // from class: T6.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return com.stepos.datacenter.ame.a.l(interfaceC5074l, obj);
            }
        });
        p.h(objComputeIfAbsent, "computeIfAbsent(...)");
        synchronized (objComputeIfAbsent) {
            try {
                this.caches.remove(collectionId);
                File fileS = s(collectionId);
                if (fileS.exists() && !fileS.delete()) {
                    Log.w("PerColMetadataStore", "drop: failed to delete " + fileS.getAbsolutePath());
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<Long, VectorMetadataRecord> m(String collectionId) {
        Map<Long, VectorMetadataRecord> map = this.caches.get(collectionId);
        if (map != null) {
            return map;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = this.writerLocks;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: T6.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return com.stepos.datacenter.ame.a.n((String) obj);
            }
        };
        Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(collectionId, new Function() { // from class: T6.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return com.stepos.datacenter.ame.a.o(interfaceC5074l, obj);
            }
        });
        p.h(objComputeIfAbsent, "computeIfAbsent(...)");
        synchronized (objComputeIfAbsent) {
            try {
                Map<Long, VectorMetadataRecord> map2 = this.caches.get(collectionId);
                if (map2 != null) {
                    return map2;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                File fileS = s(collectionId);
                if (fileS.exists() && fileS.isFile()) {
                    w(fileS, linkedHashMap);
                }
                this.caches.put(collectionId, linkedHashMap);
                return linkedHashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(String collectionId) {
        p.i(collectionId, "collectionId");
        File fileS = s(collectionId);
        if (!fileS.exists() || !fileS.isFile()) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileS);
            try {
                fileInputStream.getFD().sync();
                t tVar = t.f7040a;
                l9.b.a(fileInputStream, null);
            } finally {
            }
        } catch (IOException e10) {
            Log.w("PerColMetadataStore", "flush: fsync '" + fileS.getAbsolutePath() + "' failed", e10);
        }
    }

    public final void q() {
        Set<String> setKeySet = this.caches.keySet();
        p.h(setKeySet, "<get-keys>(...)");
        Iterator it = F.m1(setKeySet).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    public final VectorMetadataRecord r(String collectionId, long vectorId) {
        p.i(collectionId, "collectionId");
        return m(collectionId).get(Long.valueOf(vectorId));
    }

    public final File s(String collectionId) {
        return new File(new File(this.rootDir, "collections/" + collectionId), "metadata.jsonl");
    }

    public final void t(String collectionId, VectorMetadataRecord record) {
        p.i(collectionId, "collectionId");
        p.i(record, "record");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.writerLocks;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: T6.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return com.stepos.datacenter.ame.a.u((String) obj);
            }
        };
        Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(collectionId, new Function() { // from class: T6.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return com.stepos.datacenter.ame.a.v(interfaceC5074l, obj);
            }
        });
        p.h(objComputeIfAbsent, "computeIfAbsent(...)");
        synchronized (objComputeIfAbsent) {
            m(collectionId).put(Long.valueOf(record.l()), record);
            i(collectionId, record);
            t tVar = t.f7040a;
        }
    }

    public final void w(File file, Map<Long, VectorMetadataRecord> into) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), C0953c.UTF_8));
            int i10 = 0;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        t tVar = t.f7040a;
                        l9.b.a(bufferedReader, null);
                        return;
                    }
                    i10++;
                    if (!H.x0(line)) {
                        try {
                            VectorMetadataRecord vectorMetadataRecord = (VectorMetadataRecord) f29799d.c(VectorMetadataRecord.INSTANCE.serializer(), line);
                            into.put(Long.valueOf(vectorMetadataRecord.l()), vectorMetadataRecord);
                        } catch (SerializationException e10) {
                            Log.w("PerColMetadataStore", "replay: malformed line " + i10 + " in " + file.getName() + ": " + e10.getMessage());
                        }
                    }
                } finally {
                }
            }
        } catch (IOException e11) {
            Log.w("PerColMetadataStore", "replay: read failed for " + file.getAbsolutePath(), e11);
        }
    }
}
