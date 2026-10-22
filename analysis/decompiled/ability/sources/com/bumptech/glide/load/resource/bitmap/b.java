package com.bumptech.glide.load.resource.bitmap;

import G6.c;
import android.content.Context;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory;
import com.bumptech.glide.util.GlideSuppliers;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.material.textfield.x;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.networknt.schema.keyword.KeywordType;
import com.stepos.ability.report.ReportManager;
import com.stepos.ability.voicewakeup.service.WakeupEngine;
import com.stepos.ability.voicewakeup.service.WakeupEngineFactory;
import com.stepos.agentcache.sdk.api.AgentCacheResultListener;
import com.stepos.agentcache.sdk.api.AgentCacheSendResult;
import u3.i;
import u3.j;
import z3.AbstractC2156a;
import z3.C2155A;
import z3.C2157b;
import z3.C2158c;
import z3.C2163h;
import z3.C2168m;
import z3.L;
import z3.w;
import z3.z;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements GlideSuppliers.GlideSupplier, x, ObjectConstructor, WakeupEngineFactory, AgentCacheResultListener, L {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2209a;

    public /* synthetic */ b(int i) {
        this.f2209a = i;
    }

    @Override // z3.L
    public AbstractC2156a a(j jVar, JsonNode jsonNode, i iVar, c cVar) {
        switch (this.f2209a) {
            case 13:
                return new C2157b(jVar, jsonNode, iVar, cVar, 0);
            case 14:
                return new C2163h(jVar, jsonNode, iVar, cVar, 1);
            case 15:
                return new C2158c(jVar, jsonNode, iVar, cVar, 0);
            case 16:
                return new w(jVar, jsonNode, iVar, cVar, 0);
            case 17:
                return new w(jVar, jsonNode, iVar, cVar, 1);
            case 18:
                return new w(jVar, jsonNode, iVar, cVar, 2);
            case 19:
                return new z3.x(jVar, jsonNode, iVar, cVar, 0);
            case 20:
                w wVar = new w(KeywordType.E, jsonNode, jVar, iVar, cVar, 3);
                wVar.g = 0;
                if (jsonNode.canConvertToExactIntegral()) {
                    wVar.g = jsonNode.intValue();
                }
                return wVar;
            case 21:
                w wVar2 = new w(KeywordType.f3021F, jsonNode, jVar, iVar, cVar, 4);
                wVar2.g = Integer.MIN_VALUE;
                if (jsonNode != null && jsonNode.canConvertToExactIntegral()) {
                    wVar2.g = jsonNode.intValue();
                }
                return wVar2;
            case 22:
                return new w(jVar, jsonNode, iVar, cVar, 5);
            case 23:
                return new z3.x(jVar, jsonNode, iVar, cVar, 1);
            case 24:
                return new C2168m(jVar, jsonNode, iVar, cVar);
            case 25:
                return new C2163h(jVar, jsonNode, iVar, cVar, 2);
            case 26:
                return new C2158c(jVar, jsonNode, iVar, cVar, 1);
            case 27:
                return new z(jVar, jsonNode, iVar, cVar, 0);
            case 28:
                return new C2155A(jVar, jsonNode, iVar, cVar, 0);
            default:
                return new C2158c(jVar, jsonNode, iVar, cVar, 2);
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f2209a) {
            case 2:
                return ConstructorConstructor.lambda$newMapConstructor$14();
            case 3:
                return ConstructorConstructor.lambda$newMapConstructor$15();
            case 4:
                return ConstructorConstructor.lambda$newMapConstructor$16();
            case 5:
                return ConstructorConstructor.lambda$newMapConstructor$17();
            case 6:
                return ConstructorConstructor.lambda$newMapConstructor$18();
            case 7:
                return ConstructorConstructor.lambda$newCollectionConstructor$10();
            case 8:
                return ConstructorConstructor.lambda$newCollectionConstructor$11();
            case 9:
                return ConstructorConstructor.lambda$newCollectionConstructor$12();
            default:
                return ConstructorConstructor.lambda$newCollectionConstructor$13();
        }
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEngineFactory
    public WakeupEngine create(Context context) {
        if (context != null) {
            return new com.stepos.ability.voicewakeup.service.c(context);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
    public Object get() {
        return GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.lambda$static$0();
    }

    @Override // com.stepos.agentcache.sdk.api.AgentCacheResultListener
    public void onResult(AgentCacheSendResult agentCacheSendResult) {
        ReportManager.init$lambda$0(agentCacheSendResult);
    }
}
