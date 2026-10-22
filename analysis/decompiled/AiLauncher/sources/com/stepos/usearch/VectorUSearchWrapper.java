package com.stepos.usearch;

import La.C;
import La.H;
import O7.a;
import Ua.C1056g;
import Ua.Y;
import Y8.h;
import Y8.t;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.usearch.VectorUSearchWrapper;
import d7.d;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import f9.C4063a;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l9.i;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0002 \"Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\u001eH\u0086@¢\u0006\u0004\b\u001f\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010=\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/stepos/usearch/VectorUSearchWrapper;", "", "Landroid/content/Context;", "context", "", "dimension", "metric", "connectivity", "expansionAdd", "expansionSearch", "addThreads", "searchThreads", "", "indexFileName", "metadataFileName", "<init>", "(Landroid/content/Context;IIIIIIILjava/lang/String;Ljava/lang/String;)V", "Ljava/io/File;", "v", "()Ljava/io/File;", "LY8/t;", "u", "()V", "s", "(Le9/c;)Ljava/lang/Object;", "", "id", "p", "(JLe9/c;)Ljava/lang/Object;", "o", "", "t", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "I", "c", Const.INTENT_KEY_UMID, "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LO7/a;", "k", "LO7/a;", "index", "Leb/a;", "l", "Leb/a;", "writeMutex", "", "Lcom/stepos/usearch/VectorUSearchWrapper$b;", "m", "Ljava/util/Map;", "metadataMap", "n", "J", "nextId", "LY8/h;", "q", "()Ljava/lang/String;", "indexPath", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VectorUSearchWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int dimension;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int metric;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int connectivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int expansionAdd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int expansionSearch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int addThreads;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int searchThreads;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final String indexFileName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final String metadataFileName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public a index;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a writeMutex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Map<Long, VectorMetadata> metadataMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public long nextId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final h indexPath;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/usearch/VectorUSearchWrapper$b;", "", "", "label", "", QueryAlgorithmBundle.KEY_CATEGORY, "metadata", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getLabel", Const.INTENT_KEY_PKGNAME, "I", "getCategory", "c", "getMetadata", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.usearch.VectorUSearchWrapper$b, reason: from toString */
    public static final /* data */ class VectorMetadata {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String label;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int category;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String metadata;

        public VectorMetadata(String label, int i10, String metadata) {
            p.i(label, "label");
            p.i(metadata, "metadata");
            this.label = label;
            this.category = i10;
            this.metadata = metadata;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VectorMetadata)) {
                return false;
            }
            VectorMetadata vectorMetadata = (VectorMetadata) other;
            return p.d(this.label, vectorMetadata.label) && this.category == vectorMetadata.category && p.d(this.metadata, vectorMetadata.metadata);
        }

        public int hashCode() {
            return (((this.label.hashCode() * 31) + Integer.hashCode(this.category)) * 31) + this.metadata.hashCode();
        }

        public String toString() {
            return "VectorMetadata(label=" + this.label + ", category=" + this.category + ", metadata=" + this.metadata + ")";
        }
    }

    public VectorUSearchWrapper(Context context, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String indexFileName, String metadataFileName) {
        p.i(context, "context");
        p.i(indexFileName, "indexFileName");
        p.i(metadataFileName, "metadataFileName");
        this.context = context;
        this.dimension = i10;
        this.metric = i11;
        this.connectivity = i12;
        this.expansionAdd = i13;
        this.expansionSearch = i14;
        this.addThreads = i15;
        this.searchThreads = i16;
        this.indexFileName = indexFileName;
        this.metadataFileName = metadataFileName;
        this.writeMutex = f.b(false, 1, null);
        this.metadataMap = new LinkedHashMap();
        this.nextId = 1L;
        this.indexPath = C4848b.b(new InterfaceC5063a() { // from class: O7.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VectorUSearchWrapper.r(this.f5262a);
            }
        });
    }

    public static final String r(VectorUSearchWrapper vectorUSearchWrapper) {
        return new File(d.f32141a.a(), vectorUSearchWrapper.indexFileName).getAbsolutePath();
    }

    public Object o(InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new VectorUSearchWrapper$count$2(this, null), interfaceC4014c);
    }

    public Object p(long j10, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new VectorUSearchWrapper$deleteVector$2(this, j10, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public final String q() {
        Object value = this.indexPath.getValue();
        p.h(value, "getValue(...)");
        return (String) value;
    }

    public Object s(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new VectorUSearchWrapper$initialize$2(this, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public final Object t(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new VectorUSearchWrapper$loadIndex$2(this, null), interfaceC4014c);
    }

    public final void u() throws NumberFormatException {
        File fileV = v();
        if (fileV.exists()) {
            this.metadataMap.clear();
            for (String str : i.l(fileV, null, 1, null)) {
                try {
                    List listB1 = H.b1(str, new String[]{"|"}, false, 4, 2, null);
                    if (listB1.size() >= 3) {
                        long j10 = Long.parseLong((String) listB1.get(0));
                        String str2 = (String) listB1.get(1);
                        Integer numW = C.w((String) listB1.get(2));
                        this.metadataMap.put(Long.valueOf(j10), new VectorMetadata(str2, numW != null ? numW.intValue() : 0, listB1.size() > 3 ? (String) listB1.get(3) : ""));
                        if (j10 >= this.nextId) {
                            this.nextId = j10 + 1;
                        }
                    }
                } catch (Exception e10) {
                    Log.w("VectorUSearchWrapper", "Failed to parse metadata: " + str, e10);
                }
            }
        }
    }

    public final File v() {
        return new File(d.f32141a.a(), this.metadataFileName);
    }

    public /* synthetic */ VectorUSearchWrapper(Context context, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str, String str2, int i17, kotlin.jvm.internal.i iVar) {
        this(context, i10, (i17 & 4) != 0 ? 0 : i11, (i17 & 8) != 0 ? 24 : i12, (i17 & 16) != 0 ? 100 : i13, (i17 & 32) != 0 ? 64 : i14, (i17 & 64) != 0 ? -1 : i15, (i17 & 128) != 0 ? -1 : i16, (i17 & 256) != 0 ? "usearch_index.bin" : str, (i17 & 512) != 0 ? "usearch_metadata.bin" : str2);
    }
}
