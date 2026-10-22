package com.bytedance.android.live.broadcastgame.opengame.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "Lcom/bytedance/live/datacontext/DataContext;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/live/datacontext/DataContext;"}, k = 3, mv = {1, 4, 3})
final class PluginContext$getModel$2 extends Lambda implements Function0<DataContext> {
    final /* synthetic */ Class $cls;

    public PluginContext$getModel$2(Class r100) {
        this.$cls = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DataContext invoke() {
        return (DataContext) this.$cls.newInstance();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DataContext invoke() {
        return invoke();
    }
}
