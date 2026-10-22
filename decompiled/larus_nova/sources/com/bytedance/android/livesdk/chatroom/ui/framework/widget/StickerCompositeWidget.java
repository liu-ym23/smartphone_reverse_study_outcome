package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/StickerCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f113259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f113260b;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerCompositeWidget f113261a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            int r101 = r100.what;
            StickerCompositeWidget r102 = this.f113261a;
            if (r101 != r102.f113260b) goto L8;
            DataCenter r103 = r102.dataCenter;
            if (r103 == null) goto L9;
            r103.put("data_has_sticker_effective", Boolean.TRUE);
            return;
        L9:
            return;
        }

        public a(StickerCompositeWidget r100, Looper r101) {
            this.f113261a = r100;
            super(r101);
        }
    }

    public StickerCompositeWidget() {
        this.f113260b = 100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.observe("cmd_sticker_is_selected", this);
    L5:
        this.f113259a = new a(this, Looper.getMainLooper());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        a r101 = this.f113259a;
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);
    L8:
        this.f113259a = null;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L28;
        Object r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getKey();
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L29;
        if (r101 == null) goto L12;
        r102 = r101.getData();
    L12:
        if (r102 == null) goto L33;
        String r104 = r101.getKey();
        if (r104.hashCode() == 2002249609) goto L18;
        return;
    L18:
        if (r104.equals("cmd_sticker_is_selected") == true) goto L20;
        return;
    L20:
        if (((com.bytedance.android.live.broadcast.api.model.r0) r101.getData()) != null) goto L22;
        return;
    L22:
        if (isViewValid() == false) goto L35;
        a r105 = this.f113259a;
        if (r105 == null) goto L32;
        r105.removeMessages(this.f113260b);
        return;
    L32:
        return;
    L35:
        return;
    L33:
        return;
    L29:
        return;
    L7:
        r103 = null;
        goto L9
    }
}
