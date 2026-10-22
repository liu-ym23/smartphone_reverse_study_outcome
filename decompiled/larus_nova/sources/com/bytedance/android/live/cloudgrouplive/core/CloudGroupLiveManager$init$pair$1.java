package com.bytedance.android.live.cloudgrouplive.core;

import com.bytedance.android.live.cloudgrouplive.datacontext.CloudGroupContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/cloudgrouplive/datacontext/CloudGroupContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class CloudGroupLiveManager$init$pair$1 extends FunctionReferenceImpl implements Function0<CloudGroupContext> {
    public static final CloudGroupLiveManager$init$pair$1 INSTANCE = null;

    static {
        INSTANCE = new CloudGroupLiveManager$init$pair$1();
    }

    public CloudGroupLiveManager$init$pair$1() {
        super(0, CloudGroupContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CloudGroupContext invoke() {
        return new CloudGroupContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CloudGroupContext invoke() {
        return invoke();
    }
}
