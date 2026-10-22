package com.uxsense.parse;

import C7.r;
import C9.g;
import D7.K;
import D7.q;
import D7.v;
import R5.d;
import S7.k;
import android.content.pm.Signature;
import android.util.Log;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import com.stepos.core.data.ContentParams;
import com.stepos.deepbinder.core.cache.TypeCache;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Callback;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.rule.ApexRuleEditor;
import com.uxsense.ruleTrigger.TriggerRuleParse;
import com.uxsense.ruleTrigger.model.ViewPatternSerializer;
import com.uxsense.search.ApexSearchIndexManager;
import com.uxsense.search.FuzzyMatcher;
import com.zyql.ability.service.IAbilityService;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.model.UpdateCheckRequest;
import h7.C1491a;
import i9.i;
import j9.AbstractC1607a;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.t;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4206a;

    public /* synthetic */ b(int i) {
        this.f4206a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        List listG0;
        switch (this.f4206a) {
            case 0:
                return Long.valueOf(ParseHandler.parseComments$lambda$4((PatternMatchResult) obj));
            case 1:
                return ApexRuleEditor.json$lambda$0((g) obj);
            case 2:
                return TriggerRuleParse.json$lambda$0((g) obj);
            case 3:
                return TriggerRuleParse.getCache$lambda$1((String) obj);
            case 4:
                return ViewPatternSerializer.json$lambda$0((g) obj);
            case 5:
                return ApexSearchIndexManager.json$lambda$0((g) obj);
            case 6:
                return FuzzyMatcher.extractKeywords$lambda$1((InterfaceC1616j) obj);
            case 7:
                if (((Boolean) obj).booleanValue()) {
                    d dVar = com.zyql.ability.sdk.client.a.c;
                    if (dVar == null) {
                        kotlin.jvm.internal.k.n("connector");
                        throw null;
                    }
                    IAbilityService iAbilityService = (IAbilityService) dVar.c;
                    if (iAbilityService != null) {
                        com.zyql.ability.sdk.client.b bVar = com.zyql.ability.sdk.client.a.e;
                        if (bVar == null) {
                            kotlin.jvm.internal.k.n("invoker");
                            throw null;
                        }
                        try {
                            String deviceId = iAbilityService.getDeviceId();
                            if (deviceId != null && deviceId.length() > 0) {
                                U7.a.a0(bVar.b, deviceId);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            String msg = "Failed to fetch deviceId from service: " + e.getMessage();
                            kotlin.jvm.internal.k.f(msg, "msg");
                            Log.e("AbilityInvoker", msg, e);
                        }
                        C1491a.a("AbilityClient", "AbilityService pre-bound and DeviceId fetched.");
                    }
                } else {
                    C1491a.b("AbilityClient", "Pre-binding failed. Subsequent calls will bind on demand.");
                }
                return r.f317a;
            case 8:
                return UpdateManager.jsonParser$lambda$0((g) obj);
            case 9:
                return UpdateManager.downloadApk$lambda$7((Throwable) obj);
            case 10:
                return UpdateManager.checkAndDownloadUpdate$lambda$15((Throwable) obj);
            case 11:
                return UpdateManager.checkUpdate$lambda$1((Throwable) obj);
            case 12:
                return UpdateManager.checkAndDownloadUpdate$lambda$16((UpdateCheckRequest) obj);
            case 13:
                SyncCacheMetaEntity meta = (SyncCacheMetaEntity) obj;
                kotlin.jvm.internal.k.f(meta, "meta");
                return SyncCacheMetaEntity.a(meta, 0L, 0L, 0L, 0L, System.currentTimeMillis(), null, 95);
            case 14:
                return SyncCacheMetaEntity.a((SyncCacheMetaEntity) obj, 0L, 0L, 0L, 0L, 0L, null, 107);
            case 15:
                return SyncCacheMetaEntity.a((SyncCacheMetaEntity) obj, 0L, 0L, 0L, 0L, System.currentTimeMillis(), null, 95);
            case 16:
                return SyncCacheMetaEntity.a((SyncCacheMetaEntity) obj, 0L, 0L, 0L, 0L, 0L, null, 75);
            case 17:
                return ContentParams.toString$lambda$2((Map.Entry) obj);
            case 18:
                Map.Entry it = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return it.getKey() + "=" + it.getValue();
            case 19:
                i it2 = (i) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                return it2.iterator();
            case 20:
                return obj;
            case 21:
                return Boolean.valueOf(obj == null);
            case 22:
                Signature it3 = (Signature) obj;
                kotlin.jvm.internal.k.f(it3, "it");
                byte[] byteArray = it3.toByteArray();
                kotlin.jvm.internal.k.e(byteArray, "toByteArray(...)");
                char[] charArray = "0123456789ABCDEF".toCharArray();
                kotlin.jvm.internal.k.e(charArray, "toCharArray(...)");
                char[] cArr = new char[byteArray.length * 2];
                int length = byteArray.length;
                for (int i = 0; i < length; i++) {
                    byte b = byteArray[i];
                    int i6 = i * 2;
                    cArr[i6] = charArray[(b & 255) >>> 4];
                    cArr[i6 + 1] = charArray[b & 15];
                }
                return new String(cArr);
            case 23:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(entry, "<destruct>");
                String str = (String) entry.getKey();
                String strConcat = (String) entry.getValue();
                if (t.X(str, "Authorization")) {
                    strConcat = "<redacted>";
                } else if (t.X(str, "zy-sign") && strConcat.length() > 8) {
                    strConcat = m.N0(8, strConcat).concat("...");
                }
                return androidx.appfunctions.metadata.a.m("-H '", str, ": ", strConcat, "'");
            case 24:
                InterfaceC1616j m = (InterfaceC1616j) obj;
                kotlin.jvm.internal.k.f(m, "m");
                l lVar = (l) m;
                Object obj2 = ((K) lVar.a()).get(1);
                String str2 = (String) ((K) lVar.a()).get(2);
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] bytes = str2.getBytes(AbstractC1607a.f4778a);
                kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                kotlin.jvm.internal.k.e(bArrDigest, "digest(...)");
                if (4 >= bArrDigest.length) {
                    listG0 = q.G0(bArrDigest);
                } else {
                    ArrayList arrayList = new ArrayList(4);
                    int i10 = 0;
                    for (byte b5 : bArrDigest) {
                        arrayList.add(Byte.valueOf(b5));
                        i10++;
                        if (i10 == 4) {
                            listG0 = arrayList;
                        }
                    }
                    listG0 = arrayList;
                }
                return obj2 + v.I0(listG0, "", null, null, new b(25), 30);
            case 25:
                Byte b10 = (Byte) obj;
                b10.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b10}, 1));
            case 26:
                return TypeCache.getConstructor$lambda$3((Class) obj);
            case 27:
                return TypeCache.getConstructor$lambda$5((Class) obj);
            case 28:
                return Call.pool$lambda$10((Call) obj);
            default:
                return Callback.pool$lambda$9((Callback) obj);
        }
    }
}
