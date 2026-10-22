package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.abscontainer.arch.platform.container.PlatformFullscreenContainer;
import com.bytedance.android.shopping.abscontainer.arch.platform.container.PlatformPanelContainer;
import com.bytedance.android.shopping.abscontainer.arch.platform.container.PlatformSplitScreenContainer;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class Starter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l33.a<?, ?> f164152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f164153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final QueryFetcher f164154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f164155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n33.e f164156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f164157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f164158g;

    public final void a() {
        final Function0<Unit> r100 = new Starter$fetchData$recordEnd$1(this);
        Function1<n33.f, Unit> r101 = new Starter$fetchData$successCallback$1(this, r100);
        Function1<n33.c, Unit> r102 = new Starter$fetchData$failureCallback$1(this, r100);
        d r103 = this.f164153b.f164172a;
        r103.f164164b = Long.valueOf(System.currentTimeMillis());
        this.f164154c.a(r101, r102, null);
    }

    public final void b() {
        this.f164153b.f164172a.f164166d = Long.valueOf(System.currentTimeMillis());
        e.f164171a.put(this.f164157f.f164160a.getSessionID(), this);
        if (PlatformFullscreenContainer.class.isAssignableFrom(this.f164157f.f164162c) == false) goto L5;
        int r100 = PlatformFullscreenContainer.f164178l;
        Context r101 = this.f164158g;
        c r102 = this.f164157f;
        Class<?> r103 = r102.f164162c;
        PageInfo r104 = r102.f164160a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "containerClass");
        Intrinsics.checkNotNullParameter(r104, "pageInfo");
        Intent r105 = new Intent(r101, r103);
        r105.putExtra("pageInfo", r104);
        r101.startActivity(r105);
        return;
    L5:
        Object r106 = null;
        FragmentManager r107 = null;
        if (PlatformPanelContainer.class.isAssignableFrom(this.f164157f.f164162c) == false) goto L27;
        int r108 = PlatformPanelContainer.f164181g;
        Context r109 = this.f164158g;
        c r110 = this.f164157f;
        Class<?> r111 = r110.f164162c;
        PageInfo r112 = r110.f164160a;
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "containerClass");
        Intrinsics.checkNotNullParameter(r112, "pageInfo");
        Object r113 = r111.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((r113 instanceof DialogFragment) == true) goto L10;
        r113 = null;
    L10:
        DialogFragment r114 = (DialogFragment) r113;
        if (r114 == null) goto L46;
        Bundle r115 = new Bundle();
        r115.putParcelable("pageInfo", r112);
        Unit r116 = Unit.INSTANCE;
        r114.setArguments(r115);
        if ((r109 instanceof FragmentActivity) == true) goto L16;
        r109 = null;
    L16:
        FragmentActivity r117 = (FragmentActivity) r109;
        if (r117 == null) goto L19;
        r107 = r117.getSupportFragmentManager();
    L19:
        if (r107 == null) goto L47;
        String r118 = r111.getName();
        LandscapeRestrictionOperation r119 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r114, r118, r119);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r114, r119) == true) goto L48;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L25:
        r114.show(r107, r118);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L27:
        if (PlatformSplitScreenContainer.class.isAssignableFrom(this.f164157f.f164162c) == false) goto L44;
        int r120 = PlatformSplitScreenContainer.f164186g;
        Context r121 = this.f164158g;
        c r122 = this.f164157f;
        Class<?> r123 = r122.f164162c;
        PageInfo r124 = r122.f164160a;
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r123, "containerClass");
        Intrinsics.checkNotNullParameter(r124, "pageInfo");
        Object r125 = r123.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((r125 instanceof PlatformSplitScreenContainer) == false) goto L32;
        r106 = r125;
    L32:
        PlatformSplitScreenContainer r126 = (PlatformSplitScreenContainer) r106;
        if (r126 == null) goto L49;
        Bundle r127 = new Bundle();
        r127.putParcelable("pageInfo", r124);
        Unit r128 = Unit.INSTANCE;
        r126.setArguments(r127);
        int r129 = h43.a.f483774a;
        ECHybridExtensionsKt.a(r121);
        Intrinsics.checkNotNullParameter(r126.S90(), "type");
        nj.d r130 = h43.a.b();
        if (r130 == null) goto L45;
        r130.k();
        return;
    L45:
        return;
    L49:
        return;
    }

    public Starter(c r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "starterConfig");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f164157f = r100;
        this.f164158g = r101;
        f r102 = new f(0);
        this.f164153b = r102;
        this.f164154c = new QueryFetcher(r100.f164161b, r102);
    }
}
