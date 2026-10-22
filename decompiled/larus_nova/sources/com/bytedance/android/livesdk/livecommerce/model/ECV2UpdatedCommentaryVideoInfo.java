package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.UpdatedCommentaryVideoInfo")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCommentaryVideoInfo;", "", "", "action", "I", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2UpdatedCommentaryVideoInfo {
    public static final int ADD_COMMENTARY_VIDEO = 2;
    public static final a Companion = null;
    public static final int REMOVE_COMMENTARY_VIDEO = 1;

    @SerializedName("action")
    public int action;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECV2UpdatedCommentaryVideoInfo() {
    }
}
