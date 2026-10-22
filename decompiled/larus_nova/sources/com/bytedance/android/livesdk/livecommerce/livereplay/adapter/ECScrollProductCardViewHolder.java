package com.bytedance.android.livesdk.livecommerce.livereplay.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/adapter/ECScrollProductCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f149275c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f149276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f149277b;

    public static final class a {
        public static ECScrollProductCardViewHolder a(Context r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "params");
            QUIManager r102 = new QUIManager();
            int r103 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
            if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(r101.f519248h) == false) goto L5;
            r102.l(new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a(r101), r100, true);
        L7:
            return new ECScrollProductCardViewHolder(r102, r101);
        L5:
            r102.l(new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a(r101), r100, false);
            goto L7
        }
    }

    static {
    }

    public ECScrollProductCardViewHolder(QUIManager r100, b r101) {
        super(r100.p());
        this.f149276a = r100;
        this.f149277b = r101;
    }
}
