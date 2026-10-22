package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorTopTips;", "Lvh7/c;", "", "getTopContent", "()Ljava/lang/String;", "getTopContent$annotations", "()V", "topContent", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTopImg", "()Lpy/k;", "getTopImg$annotations", "topImg", "", "getTopTipsType", "()I", "getTopTipsType$annotations", "topTipsType", "getSchemeUrl", "getSchemeUrl$annotations", "schemeUrl", "TopTipType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnchorTopTips extends vh7.c<IAnchorTopTips> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorTopTips$TopTipType;", "", "TopTipUndefined", "TopTipTeamTask", "TopTipPunish", "TopTipsPeakGuide", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TopTipType extends Enum<TopTipType> {
        public static final TopTipType TopTipPunish = null;
        public static final TopTipType TopTipTeamTask = null;
        public static final TopTipType TopTipUndefined = null;
        public static final TopTipType TopTipsPeakGuide = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopTipType[] f147022a = null;

        static {
            TopTipType r100 = new TopTipType("TopTipUndefined", 0);
            TopTipUndefined = r100;
            TopTipType r101 = new TopTipType("TopTipTeamTask", 1);
            TopTipTeamTask = r101;
            TopTipType r102 = new TopTipType("TopTipPunish", 2);
            TopTipPunish = r102;
            TopTipType r103 = new TopTipType("TopTipsPeakGuide", 3);
            TopTipsPeakGuide = r103;
            f147022a = new TopTipType[]{r100, r101, r102, r103};
        }

        public static TopTipType valueOf(String r100) {
            return (TopTipType) r27.a.a(TopTipType.class, r100);
        }

        public static TopTipType[] values() {
            return (TopTipType[]) f147022a.clone();
        }

        public TopTipType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "scheme_url")
    String getSchemeUrl();

    @FieldName(name = "content")
    String getTopContent();

    @FieldName(name = "img")
    py.k getTopImg();

    @FieldName(name = "top_tips_type")
    int getTopTipsType();
}
