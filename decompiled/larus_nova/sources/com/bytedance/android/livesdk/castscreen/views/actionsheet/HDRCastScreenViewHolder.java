package com.bytedance.android.livesdk.castscreen.views.actionsheet;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/HDRCastScreenViewHolder;", "Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet$ActionSheetItemViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HDRCastScreenViewHolder extends CastScreenActionSheet.ActionSheetItemViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f104771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f104772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f104773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f104774e;

    public HDRCastScreenViewHolder(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f104774e = r101;
        this.f104773d = r100.findViewById(R.id.primary_hint);
        this.f104772c = r100.findViewById(R.id.limited_time_icon);
        this.f104771b = (TextView) r100.findViewById(R.id.secondary_hint);
    }
}
