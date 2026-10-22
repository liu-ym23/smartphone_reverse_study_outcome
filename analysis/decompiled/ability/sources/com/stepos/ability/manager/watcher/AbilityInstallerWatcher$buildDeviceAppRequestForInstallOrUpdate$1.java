package com.stepos.ability.manager.watcher;

import J7.c;
import com.stepos.ability.commoninternal.AppInfoUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.watcher.AbilityInstallerWatcher", f = "AbilityInstallerWatcher.kt", l = {280}, m = "buildDeviceAppRequestForInstallOrUpdate", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityInstallerWatcher$buildDeviceAppRequestForInstallOrUpdate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3164a;
    public List b;
    public List c;
    public String d;
    public ArrayList e;
    public AppInfoUtils.AppInfo f;
    public /* synthetic */ Object g;
    public final /* synthetic */ b h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityInstallerWatcher$buildDeviceAppRequestForInstallOrUpdate$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return b.a(this.h, null, null, null, null, null, null, null, null, this);
    }
}
