package com.stepos.ability.manager.discovery.ai_activity_widget;

import C7.r;
import D7.v;
import J7.c;
import S7.n;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import b4.C0825a;
import i9.C1570e;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.discovery.ai_activity_widget.AiActivityScanner$getAvailableTools$4", f = "AiActivityScanner.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lb4/a;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AiActivityScanner$getAvailableTools$4 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3144a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiActivityScanner$getAvailableTools$4(String str, Context context, H7.c cVar) {
        super(2, cVar);
        this.f3144a = str;
        this.b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AiActivityScanner$getAvailableTools$4(this.f3144a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AiActivityScanner$getAvailableTools$4) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        C0825a c0825aB;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        String str2 = this.f3144a;
        Log.i("AiActivityScanner", "getAvailableTools start pkg: ".concat(str2));
        ArrayList arrayList = new ArrayList();
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            PackageManager packageManager = this.b.getApplicationContext().getPackageManager();
            k.e(packageManager, "getPackageManager(...)");
            C1570e c1570e = new C1570e(kotlin.sequences.a.f0(v.s0(a.a(packageManager)), new R3.c(str2, 6)));
            while (c1570e.hasNext()) {
                ResolveInfo resolveInfo = (ResolveInfo) c1570e.next();
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && (str = activityInfo.name) != null && linkedHashSet.add(str) && (c0825aB = a.b(resolveInfo)) != null) {
                    arrayList.add(c0825aB);
                }
            }
            return arrayList;
        } catch (Exception e) {
            Log.e("AiActivityScanner", "getAvailableTools failed pkg: ".concat(str2), e);
            return arrayList;
        }
    }
}
