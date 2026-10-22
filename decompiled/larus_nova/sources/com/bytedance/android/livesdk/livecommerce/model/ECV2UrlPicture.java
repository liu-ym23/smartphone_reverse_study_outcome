package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.URLPicture")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UrlPicture;", "", "", "", "urlList", "Ljava/util/List;", "", "width", "I", "height", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2UrlPicture {
    public static final a Companion = null;

    @SerializedName("height")
    public int height;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> urlList;

    @SerializedName("width")
    public int width;

    public static final class a {
        public a() {
        }

        public static ECUrlModel a(ECV2UrlPicture r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$toECUrlModel");
            ECUrlModel r101 = new ECUrlModel();
            r101.setUrlList(r100.urlList);
            r101.setWidth(r100.width);
            r101.setHeight(r100.height);
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public ECV2UrlPicture() {
    }
}
