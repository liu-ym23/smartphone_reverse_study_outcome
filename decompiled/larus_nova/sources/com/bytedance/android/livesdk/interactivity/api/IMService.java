package com.bytedance.android.livesdk.interactivity.api;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.interactivity.im.IMServiceWidget;
import com.bytedance.android.livesdk.interactivity.im.IMToolbarBehavior;
import com.bytedance.android.livesdk.interactivity.im.IMToolbarMoreBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IMService;", "Lcom/bytedance/android/livesdk/interactivity/api/IIMService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getIMServiceWidget", "", "initServiceProxy", "Landroid/graphics/drawable/BitmapDrawable;", "drawable", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "getImBehavior", "getImBehaviorInMore", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMService implements IIMService {
    public IMService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IIMService
    public void initServiceProxy() {
        c82.c r100 = c82.c.f22708c;
        IHostBusiness r101 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r101 == null) goto L6;
        r101.onUpdateHostIMProxy(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IIMService
    public Class<? extends LiveRecyclableWidget> getIMServiceWidget() {
        return IMServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IIMService
    public c0.b getImBehavior(BitmapDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        return new IMToolbarBehavior(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IIMService
    public c0.b getImBehaviorInMore(BitmapDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        return new IMToolbarMoreBehavior(new BitmapDrawable(r100.getBitmap().copy(Bitmap.Config.ARGB_8888, true)));
    }
}
