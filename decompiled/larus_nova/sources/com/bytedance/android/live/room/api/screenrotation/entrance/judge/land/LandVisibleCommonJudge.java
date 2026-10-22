package com.bytedance.android.live.room.api.screenrotation.entrance.judge.land;

import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.judge.a;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/entrance/judge/land/LandVisibleCommonJudge;", "Lcom/bytedance/android/live/room/api/screenrotation/entrance/judge/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandVisibleCommonJudge extends a implements Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f99130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f99131e;

    public LandVisibleCommonJudge() {
        this.f99130d = "LandVisibleCommonJudge";
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.judge.a, com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final void onUnload() {
        super.onUnload();
        d r100 = this.f99127a;
        if (r100 == null) goto L8;
        DataCenter r101 = r100.b();
        if (r101 == null) goto L9;
        r101.removeObserver(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final String getTag() {
        return this.f99130d;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final boolean c(IRotateEntrance r100) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return !this.f99131e;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.judge.a
    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        DataCenter r101 = r100.b();
        if (r101 == null) goto L6;
        r101.observe("data_keyboard_status", this);
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Boolean r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.hashCode() == 1060055221) goto L12;
        return;
    L12:
        if (r103.equals("data_keyboard_status") == false) goto L17;
        if (r101 == null) goto L15;
        r102 = (Boolean) r101.getData();
    L15:
        this.f99131e = Intrinsics.areEqual(r102, Boolean.TRUE);
        this.f99128b.b();
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
