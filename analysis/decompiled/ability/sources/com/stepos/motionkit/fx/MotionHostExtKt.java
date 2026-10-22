package com.stepos.motionkit.fx;

import C7.r;
import D7.v;
import H4.o;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.FxModule;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.MotionModule;
import io.modelcontextprotocol.spec.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m5.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b\u001a1\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0015\u001a\u00020\t*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/motionkit/MotionHost$Companion;", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/MotionHost;", "create", "(Lcom/stepos/motionkit/MotionHost$Companion;Landroid/view/View;)Lcom/stepos/motionkit/MotionHost;", "Landroid/app/Activity;", "activity", "(Lcom/stepos/motionkit/MotionHost$Companion;Landroid/app/Activity;)Lcom/stepos/motionkit/MotionHost;", "Lcom/stepos/motionkit/FxModule;", "Lcom/stepos/motionkit/EffectDefinition;", "effect", "Lkotlin/Function1;", "Lcom/stepos/motionkit/FxConfig;", "LC7/r;", "config", "Lcom/stepos/motionkit/FxInstance;", "play", "(Lcom/stepos/motionkit/FxModule;Lcom/stepos/motionkit/EffectDefinition;LS7/k;)Lcom/stepos/motionkit/FxInstance;", "getFx", "(Lcom/stepos/motionkit/MotionHost;)Lcom/stepos/motionkit/FxModule;", "fx", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MotionHostExtKt {
    public static final MotionHost create(MotionHost.Companion companion, View view) {
        k.f(companion, "<this>");
        k.f(view, "view");
        MotionHost motionHostAttach = companion.attach(view);
        motionHostAttach.register(new FxModuleImpl(motionHostAttach));
        view.post(new c(motionHostAttach, 6));
        return motionHostAttach;
    }

    public static final FxModule getFx(MotionHost motionHost) {
        k.f(motionHost, "<this>");
        List<MotionModule> modules = motionHost.getModules();
        ArrayList arrayList = new ArrayList();
        for (Object obj : modules) {
            if (obj instanceof FxModule) {
                arrayList.add(obj);
            }
        }
        FxModule fxModule = (FxModule) v.C0(arrayList);
        if (fxModule != null) {
            return fxModule;
        }
        throw new IllegalStateException("FxModule 未注册，请通过 motionkit-fx 的 MotionHost.create() 创建宿主");
    }

    public static final FxInstance play(FxModule fxModule, EffectDefinition effect, S7.k config) {
        k.f(fxModule, "<this>");
        k.f(effect, "effect");
        k.f(config, "config");
        return fxModule.play(o.M(effect), config);
    }

    public static /* synthetic */ FxInstance play$default(FxModule fxModule, EffectDefinition effectDefinition, S7.k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar = new a(12);
        }
        return play(fxModule, effectDefinition, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r play$lambda$1(FxConfig fxConfig) {
        k.f(fxConfig, "<this>");
        return r.f317a;
    }

    public static final MotionHost create(MotionHost.Companion companion, Activity activity) {
        k.f(companion, "<this>");
        k.f(activity, "activity");
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        k.c(viewGroup);
        return create(companion, viewGroup);
    }
}
