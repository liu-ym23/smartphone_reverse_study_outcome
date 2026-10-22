package com.stepos.core;

import C7.r;
import H7.f;
import H7.h;
import S7.n;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.GlassTextParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import kotlin.jvm.internal.k;
import m9.s0;
import s9.v;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3823a;

    public /* synthetic */ a(int i) {
        this.f3823a = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3823a) {
            case 0:
                k.f((String) obj, "<unused var>");
                k.f((String) obj2, "<unused var>");
                return r.f317a;
            case 1:
                return GlassEffect.TEXT$lambda$8((BlurParams) obj, ((Float) obj2).floatValue());
            case 2:
                return GlassEffect.TEXT$lambda$9((StrokeParams) obj, ((Float) obj2).floatValue());
            case 3:
                return GlassEffect.TEXT$lambda$10((InnerShadowParams) obj, ((Float) obj2).floatValue());
            case 4:
                return GlassEffect.TEXT$lambda$11((RefractionParams) obj, ((Float) obj2).floatValue());
            case 5:
                return GlassEffect.TEXT$lambda$12((BlendParams) obj, ((Float) obj2).floatValue());
            case 6:
                return GlassEffect.TEXT$lambda$13((GlassTextParams) obj, ((Float) obj2).floatValue());
            case 7:
                return GlassEffect._init_$lambda$0((BlendParams) obj, ((Float) obj2).floatValue());
            case 8:
                return GlassEffect._init_$lambda$1((GlassTextParams) obj, ((Float) obj2).floatValue());
            case 9:
                return GlassEffect.Companion.tier$lambda$3((RefractionParams) obj, ((Float) obj2).floatValue());
            case 10:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 11:
                return ((h) obj).plus((f) obj2);
            case 12:
                return ((h) obj).plus((f) obj2);
            case 13:
                return Boolean.valueOf(k.b(obj, obj2));
            case 14:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 15:
                f fVar = (f) obj2;
                if (!(fVar instanceof s0)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar : Integer.valueOf(iIntValue + 1);
            case 16:
                s0 s0Var = (s0) obj;
                f fVar2 = (f) obj2;
                if (s0Var != null) {
                    return s0Var;
                }
                if (fVar2 instanceof s0) {
                    return (s0) fVar2;
                }
                return null;
            default:
                v vVar = (v) obj;
                f fVar3 = (f) obj2;
                if (fVar3 instanceof s0) {
                    s0 s0Var2 = (s0) fVar3;
                    Object objUpdateThreadContext = s0Var2.updateThreadContext(vVar.f6011a);
                    Object[] objArr = vVar.b;
                    int i = vVar.d;
                    objArr[i] = objUpdateThreadContext;
                    s0[] s0VarArr = vVar.c;
                    vVar.d = i + 1;
                    s0VarArr[i] = s0Var2;
                }
                return vVar;
        }
    }
}
