package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u00042\u00020\u0005:\u00011R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\bR\u0014\u0010\u001f\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0014\u0010#\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\"\u0010,\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)\u0018\u00010(8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/i6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lgm2/d;", "", "", "getAssetId", "()J", "setAssetId", "(J)V", "assetId", "getPriority", "priority", "", "Lcom/bytedance/android/livesdk/gift/model/f1;", "getImageList", "()Ljava/util/List;", "imageList", "Lcom/bytedance/android/livesdk/gift/model/g1;", "getTextList", "textList", "getPrice", "price", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "text", "getTextWidth", "textWidth", "getTextHeight", "textHeight", "", "getTracking", "()Ljava/lang/String;", "tracking", "getDressId", "dressId", "getFinishSelfSchema", "finishSelfSchema", "", "Lcom/bytedance/android/live/base/model/message/c5;", "getTextPieceOverrides", "()Ljava/util/Map;", "textPieceOverrides", "", "isLocalExt", "()Z", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i6 extends vh7.c<i6>, yh6.c, gm2.d {
    public static final String ASSET_EFFECT_SOURCE = "effect_source";
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153655a = null;

        public a() {
        }

        static {
            f153655a = new a();
        }
    }

    static {
        Companion = a.f153655a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getAssetId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    String getDressId();

    String getFinishSelfSchema();

    /* synthetic */ IBaseUser getFromUser();

    /* synthetic */ long getGiftTimeStamp();

    List<com.bytedance.android.livesdk.gift.model.f1> getImageList();

    @Override // gm2.d, com.bytedance.android.livesdk.message.model.k6
    /* synthetic */ String getLogId();

    /* synthetic */ Map<Integer, Long> getMaps();

    long getPrice();

    long getPriority();

    /* synthetic */ boolean getRtcRoomMessageIsExpire();

    com.bytedance.android.live.base.model.message.a5 getText();

    long getTextHeight();

    List<com.bytedance.android.livesdk.gift.model.g1> getTextList();

    Map<String, com.bytedance.android.live.base.model.message.c5> getTextPieceOverrides();

    long getTextWidth();

    /* synthetic */ IBaseUser getToUser();

    String getTracking();

    boolean isLocalExt();

    /* synthetic */ boolean isRtcRoomMessage();

    void setAssetId(long r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setFromUser(IBaseUser r100);

    /* synthetic */ void setGiftTimeStamp(long r100);

    /* synthetic */ void setLogId(String r100);

    /* synthetic */ void setMaps(Map<Integer, Long> r100);

    /* synthetic */ void setRtcRoomMessage(boolean r100);

    /* synthetic */ void setRtcRoomMessageIsExpire(boolean r100);

    /* synthetic */ void setTimeStampMap(int r100, long r101);

    /* synthetic */ void setToUser(IBaseUser r100);
}
