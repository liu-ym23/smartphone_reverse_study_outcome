package com.bytedance.android.live.revlink.impl.multianchor.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/model/TitleBgDef;", "", EffectConstants.NORMAL, "ttlive_bg_multi_anchor_link_title_pad", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TitleBgDef extends Enum<TitleBgDef> {
    public static final TitleBgDef NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBgDef[] f94429a = null;
    public static final TitleBgDef ttlive_bg_multi_anchor_link_title_pad = null;

    static {
        TitleBgDef r100 = new TitleBgDef(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        TitleBgDef r101 = new TitleBgDef("ttlive_bg_multi_anchor_link_title_pad", 1);
        ttlive_bg_multi_anchor_link_title_pad = r101;
        f94429a = new TitleBgDef[]{r100, r101};
    }

    public static TitleBgDef valueOf(String r100) {
        return (TitleBgDef) a.a(TitleBgDef.class, r100);
    }

    public static TitleBgDef[] values() {
        return (TitleBgDef[]) f94429a.clone();
    }

    public TitleBgDef(String r100, int r101) {
        super(r100, r101);
    }
}
