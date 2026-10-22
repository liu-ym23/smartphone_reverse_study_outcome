package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class HybridSettingManagerImplV2$settingsThreadExecutor$2 extends Lambda implements Function0<ScheduledExecutorService> {
    public static final HybridSettingManagerImplV2$settingsThreadExecutor$2 INSTANCE = null;

    static {
        INSTANCE = new HybridSettingManagerImplV2$settingsThreadExecutor$2();
    }

    public HybridSettingManagerImplV2$settingsThreadExecutor$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ScheduledExecutorService invoke2() {
        return PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("HybridSettingManagerImplV2$settingsThreadExecutor$2"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ScheduledExecutorService invoke() {
        return invoke2();
    }
}
