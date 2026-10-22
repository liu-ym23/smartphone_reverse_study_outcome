package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntityKt;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.MyAppViewModel$getMyAppsList$1$entityList$1", f = "MyAppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMyAppViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAppViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/MyAppViewModel$getMyAppsList$1$entityList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1559#2:121\n1590#2,4:122\n*S KotlinDebug\n*F\n+ 1 MyAppViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/MyAppViewModel$getMyAppsList$1$entityList$1\n*L\n73#1:121\n73#1:122,4\n*E\n"})
public final class MyAppViewModel$getMyAppsList$1$entityList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    int label;
    final /* synthetic */ MyAppViewModel this$0;

    public MyAppViewModel$getMyAppsList$1$entityList$1(MyAppViewModel r10, Continuation<? super MyAppViewModel$getMyAppsList$1$entityList$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new MyAppViewModel$getMyAppsList$1$entityList$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends Object>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L35;
        kotlin.c.b(r10);
        Ref$IntRef r11 = new Ref$IntRef();
        r11.element = -1;
        Ref$IntRef r12 = new Ref$IntRef();
        r12.element = -1;
        List<AppInfo> r13 = MyAppViewModel.f(this.this$0).buildMyAppList4Display();
        q.f(r13, "buildMyAppList4Display(...)");
        ArrayList r14 = new ArrayList(u.r(r13, 10));
        Iterator<T> r15 = r13.iterator();
        int r16 = 0;
    L6:
        if (r15.hasNext() == false) goto L19;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L10;
        t.q();
    L10:
        AppInfo r19 = (AppInfo) r17;
        if (q.b(r19.appCategoryName, "section_header") == false) goto L18;
        if (q.b(r19.getName(), "section_header_local_app") == false) goto L16;
        r12.element = r16;
        goto L18
    L16:
        if (q.b(r19.getName(), "section_header_download_queue") == false) goto L18;
        r11.element = r16;
    L18:
        q.d(r19);
        r14.add(CommonAppEntityKt.convertCommonAppEntity(r19));
        r16 = r18;
        goto L6
    L19:
        List r20 = b0.z0(r14);
        int r21 = r11.element;
        if (r21 == (-1)) goto L25;
        if (r20 == null) goto L23;
        r20.remove(r21);
    L23:
        if (r20 == null) goto L25;
        int r22 = r11.element;
        String r23 = BaseApplication.c().getString(R.string.downloading);
        q.f(r23, "getString(...)");
        r20.add(r22, r23);
    L25:
        int r24 = r12.element;
        if (r24 == (-1)) goto L31;
        if (r20 == null) goto L29;
        r20.remove(r24);
    L29:
        if (r20 == null) goto L31;
        int r25 = r12.element;
        String r26 = BaseApplication.c().getString(R.string.myapp_installed_apps);
        q.f(r26, "getString(...)");
        r20.add(r25, r26);
    L31:
        if (r20 == null) goto L33;
        return r20;
    L33:
        return t.i();
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends Object>> r11) {
        return ((MyAppViewModel$getMyAppsList$1$entityList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
