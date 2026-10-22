package com.bytedance.android.live.profit.vip.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001'R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/a;", "Lvh7/c;", "", "getId", "()J", "getId$annotations", "()V", "id", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "getImg$annotations", "img", "getEmojiScaleType", "getEmojiScaleType$annotations", "emojiScaleType", "Lcom/bytedance/android/live/profit/vip/model/c;", "getLabel", "()Lcom/bytedance/android/live/profit/vip/model/c;", "getLabel$annotations", "label", "getType", "getType$annotations", "type", "", "getStatus", "()I", "getStatus$annotations", "status", "getCanDelTime", "getCanDelTime$annotations", "canDelTime", "", "getRejectReason", "()Ljava/lang/String;", "getRejectReason$annotations", "rejectReason", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {
    public static final C1367a Companion = null;
    public static final int STATUS_OFFLINE = 4;
    public static final int STATUS_PASS = 3;
    public static final int STATUS_REJECT = 2;
    public static final int STATUS_REVIEW = 1;
    public static final int STATUS_UNKNOWN = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vip.model.a$a, reason: collision with other inner class name */
    public static final class C1367a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1367a f89164a = null;

        public C1367a() {
        }

        static {
            f89164a = new C1367a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = C1367a.f89164a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "can_del_time")
    long getCanDelTime();

    @FieldName(name = "emoji_scale")
    long getEmojiScaleType();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "img")
    k getImg();

    @FieldName(name = "label")
    c getLabel();

    @FieldName(name = "reject_reason")
    String getRejectReason();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "type")
    long getType();
}
