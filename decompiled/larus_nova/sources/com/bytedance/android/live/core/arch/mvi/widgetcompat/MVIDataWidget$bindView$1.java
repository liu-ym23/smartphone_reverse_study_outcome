package com.bytedance.android.live.core.arch.mvi.widgetcompat;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\r\u001a\n \n*\u0004\u0018\u00018\u00008\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004\"\u0014\b\u0003\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0004\u0010\t*\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/utils/g2;", "STATE", "", "INTENT", "Lcom/bytedance/android/livesdk/utils/b2;", "M", "Lcom/bytedance/live/datacontext/DataContext;", "DATA", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()Landroid/view/View;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class MVIDataWidget$bindView$1 extends Lambda implements Function0<View> {
    final /* synthetic */ int $res;
    final /* synthetic */ MVIDataWidget this$0;

    public MVIDataWidget$bindView$1(MVIDataWidget r100, int r101) {
        this.this$0 = r100;
        this.$res = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        return this.this$0.contentView.findViewById(this.$res);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }
}
