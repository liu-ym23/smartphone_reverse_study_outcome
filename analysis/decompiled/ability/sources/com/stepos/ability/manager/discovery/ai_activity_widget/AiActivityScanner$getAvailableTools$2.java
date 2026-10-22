package com.stepos.ability.manager.discovery.ai_activity_widget;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import b4.C0825a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.discovery.ai_activity_widget.AiActivityScanner$getAvailableTools$2", f = "AiActivityScanner.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lm9/z;", "", "", "", "Lb4/a;", "<anonymous>", "(Lm9/z;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AiActivityScanner$getAvailableTools$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3143a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiActivityScanner$getAvailableTools$2(Context context, H7.c cVar) {
        super(2, cVar);
        this.f3143a = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AiActivityScanner$getAvailableTools$2(this.f3143a, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AiActivityScanner$getAvailableTools$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        C0825a c0825aB;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        Log.i("AiActivityScanner", "getAvailableTools start");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            PackageManager packageManager = this.f3143a.getApplicationContext().getPackageManager();
            k.e(packageManager, "getPackageManager(...)");
            for (ResolveInfo resolveInfo : a.a(packageManager)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    if (linkedHashSet.add(activityInfo.packageName + "/" + activityInfo.name) && (c0825aB = a.b(resolveInfo)) != null) {
                        String str = activityInfo.packageName;
                        Object arrayList = linkedHashMap.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            linkedHashMap.put(str, arrayList);
                        }
                        ((List) arrayList).add(c0825aB);
                    }
                }
            }
            return linkedHashMap;
        } catch (Exception e) {
            Log.e("AiActivityScanner", "getAvailableTools failed", e);
            return linkedHashMap;
        }
    }
}
