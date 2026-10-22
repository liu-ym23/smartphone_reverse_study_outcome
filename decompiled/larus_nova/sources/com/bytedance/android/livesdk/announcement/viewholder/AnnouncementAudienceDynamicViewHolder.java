package com.bytedance.android.livesdk.announcement.viewholder;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/viewholder/AnnouncementAudienceDynamicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementAudienceDynamicViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f103604a;

    public final Context getContext() {
        return this.f103604a;
    }

    public AnnouncementAudienceDynamicViewHolder(Context r100, String r101, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "secUid");
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        Intrinsics.checkNotNullParameter(r112, "anchorId");
        super(new AudienceDynamicCardView(r100, r110, r101, r111, r112));
        this.f103604a = r100;
    }
}
