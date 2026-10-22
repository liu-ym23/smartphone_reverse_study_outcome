package com.bytedance.android.livesdk.gift.model;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\b\bg\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u001c\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u0014\u0010!\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0012R\u001c\u0010$\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\u001bR\u0014\u0010&\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012R\u0014\u0010(\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\bR$\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010)8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/b1;", "Lvh7/c;", "", "getId", "()J", "id", "", "getTitle", "()Ljava/lang/String;", "title", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "", "getHeight", "()I", "setHeight", "(I)V", "height", "getWidth", "setWidth", "width", "getSchemaUrl", "setSchemaUrl", "(Ljava/lang/String;)V", "schemaUrl", "getActionType", "setActionType", ReportConstant.COMMON_ACTION_TYPE, "getPriority", "priority", "getText", "setText", "text", "getFrameType", "frameType", "getExtra", "extra", "", "getTrackingTypes", "()Ljava/util/List;", "setTrackingTypes", "(Ljava/util/List;)V", "trackingTypes", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b1 extends vh7.c<b1> {
    public static final a Companion = null;
    public static final int TYPE_ACTION_FULL_WEB = 3;
    public static final int TYPE_ACTION_HALF_WEB = 2;
    public static final int TYPE_ACTION_SCHEMA = 1;
    public static final int TYPE_ACTIVITY = 6;
    public static final int TYPE_TASK_GIFT = 30;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126380a = null;

        public a() {
        }

        static {
            f126380a = new a();
        }
    }

    static {
        Companion = a.f126380a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    int getActionType();

    String getExtra();

    int getFrameType();

    int getHeight();

    long getId();

    py.k getImage();

    int getPriority();

    String getSchemaUrl();

    String getText();

    String getTitle();

    List<String> getTrackingTypes();

    int getWidth();

    void setActionType(int r100);

    void setHeight(int r100);

    void setImage(py.k r100);

    void setSchemaUrl(String r100);

    void setText(String r100);

    void setTrackingTypes(List<String> r100);

    void setWidth(int r100);
}
