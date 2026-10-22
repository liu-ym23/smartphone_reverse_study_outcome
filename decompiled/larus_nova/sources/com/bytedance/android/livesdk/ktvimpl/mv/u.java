package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f146203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f146204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f146205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f146206d;

    public u(String r100, String r101, Long r102) {
        int r103 = t.f146199d;
        Intrinsics.checkNotNullParameter(r100, "vId");
        int r104 = com.bytedance.android.live.ktv.common.music.download.v.f70112a;
        StringBuilder r105 = new StringBuilder(KtvCommonConfigParams.a());
        String r106 = File.separator;
        r105.append(r106);
        r105.append("musicPack");
        r105.append(r106);
        r105.append(r106);
        r105.append(r100);
        r105.append(r106);
        String r107 = r105.toString();
        Intrinsics.checkNotNullParameter(r100, "vId");
        Intrinsics.checkNotNullParameter(r107, DBDefinition.SAVE_PATH);
        this.f146203a = r100;
        this.f146204b = r101;
        this.f146205c = r102;
        this.f146206d = null;
    }
}
