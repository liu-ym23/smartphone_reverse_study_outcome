package com.stepos.stepclaw.memory.lightmem;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingProvider;
import com.stepos.stepclaw.memory.lightmem.remote.AutoRecallResponse;
import com.stepos.stepclaw.memory.search.QueryRewriteStage;
import com.stepos.stepclaw.memory.search.VectorRetriever;
import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import k4.h0;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.internal.JsonNamesMapKt;
import okhttp3.internal.platform.Platform;
import org.bouncycastle.asn1.BERTags;
import u6.m;
import u6.v;
import u6.z;
import x5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1660c;

    public /* synthetic */ f(Object obj, int i8, Object obj2) {
        this.f1658a = i8;
        this.f1659b = obj;
        this.f1660c = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        int iQ1;
        long jA;
        v[] vVarArr;
        switch (this.f1658a) {
            case 0:
                return LightMemClient.logLongToDebug$lambda$0((String) this.f1659b, (String) this.f1660c);
            case 1:
                return QueryRewriteStage.tryRemote$lambda$1((ArrayList) this.f1659b, (AutoRecallResponse) this.f1660c);
            case 2:
                return VectorRetriever.retrieve$lambda$0((EmbeddingProvider) this.f1660c, (String) this.f1659b);
            case 3:
                ArrayList arrayList = (ArrayList) this.f1659b;
                h0 h0Var = (h0) this.f1660c;
                String str = h0Var.f3616e;
                if (arrayList.isEmpty() || (iQ1 = n.q1(str, '/', h0Var.f3618g.f3606a.length() + 3, 4)) == -1) {
                    return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                int iS1 = n.s1(str, new char[]{'?', '#'}, iQ1, false);
                if (iS1 == -1) {
                    String strSubstring = str.substring(iQ1);
                    p.d(strSubstring, "substring(...)");
                    return strSubstring;
                }
                String strSubstring2 = str.substring(iQ1, iS1);
                p.d(strSubstring2, "substring(...)");
                return strSubstring2;
            case 4:
                return SealedClassSerializer.descriptor_delegate$lambda$0((String) this.f1659b, (SealedClassSerializer) this.f1660c);
            case 5:
                return EnumSerializer.descriptor_delegate$lambda$0((EnumSerializer) this.f1660c, (String) this.f1659b);
            case 6:
                return ObjectSerializer.descriptor_delegate$lambda$0((String) this.f1659b, (ObjectSerializer) this.f1660c);
            case 7:
                return JsonNamesMapKt.buildDeserializationNamesMap((SerialDescriptor) this.f1659b, (Json) this.f1660c);
            case 8:
                return JsonNamesMapKt.serializationNamesIndices$lambda$0((SerialDescriptor) this.f1659b, (JsonNamingStrategy) this.f1660c);
            case 9:
                return IndexPersistence.migratePermanentAccessStats$lambda$0((String) this.f1659b, (Map) this.f1660c);
            case 10:
                return IndexPersistence.persistIndex$lambda$3((File) this.f1659b, (LinkedHashMap) this.f1660c);
            case BERTags.EMBEDDED_PDV /* 11 */:
                u6.n nVar = (u6.n) this.f1659b;
                v vVar = (v) this.f1660c;
                try {
                    nVar.f5714a.c(vVar);
                } catch (IOException e9) {
                    Platform.INSTANCE.get().log("Http2Connection.Listener failure for " + nVar.f5716c, 4, e9);
                    try {
                        vVar.e(u6.b.d, e9);
                    } catch (IOException unused) {
                    }
                }
                return a0.f883a;
            case 12:
                m mVar = (m) this.f1659b;
                z zVar = (z) this.f1660c;
                y yVar = new y();
                u6.n nVar2 = mVar.f5713b;
                synchronized (nVar2.y) {
                    synchronized (nVar2) {
                        try {
                            z zVar2 = nVar2.f5731t;
                            z zVar3 = new z();
                            zVar3.b(zVar2);
                            zVar3.b(zVar);
                            yVar.f3686a = zVar3;
                            jA = zVar3.a() - zVar2.a();
                            vVarArr = (jA == 0 || nVar2.f5715b.isEmpty()) ? null : (v[]) nVar2.f5715b.values().toArray(new v[0]);
                            z zVar4 = (z) yVar.f3686a;
                            p.e(zVar4, "<set-?>");
                            nVar2.f5731t = zVar4;
                            q6.c.b(nVar2.f5722k, nVar2.f5716c + " onSettings", 0L, new f(nVar2, 13, yVar), 6);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        nVar2.y.a((z) yVar.f3686a);
                    } catch (IOException e10) {
                        u6.b bVar = u6.b.d;
                        nVar2.a(bVar, bVar, e10);
                    }
                }
                if (vVarArr != null) {
                    for (v vVar2 : vVarArr) {
                        synchronized (vVar2) {
                            vVar2.f5763e += jA;
                            if (jA > 0) {
                                vVar2.notifyAll();
                            }
                        }
                    }
                }
                return a0.f883a;
            case BERTags.RELATIVE_OID /* 13 */:
                u6.n nVar3 = (u6.n) this.f1659b;
                nVar3.f5714a.a(nVar3, (z) ((y) this.f1660c).f3686a);
                return a0.f883a;
            default:
                l lVar = (l) this.f1660c;
                String str2 = (String) this.f1659b;
                Matcher matcher = lVar.f6301a.matcher(str2);
                p.d(matcher, "matcher(...)");
                return x.e.a(matcher, 0, str2);
        }
    }

    public /* synthetic */ f(String str, int i8, Object obj) {
        this.f1658a = i8;
        this.f1660c = obj;
        this.f1659b = str;
    }
}
