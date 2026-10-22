package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0015\bg\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R\"\u0010\u001c\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "Lvh7/c;", "", "getSubtitleStyle", "()I", "setSubtitleStyle", "(I)V", "getSubtitleStyle$annotations", "()V", "subtitleStyle", "", "getX", "()D", "setX", "(D)V", "getX$annotations", "x", "getY", "setY", "getY$annotations", "y", "getSubtitleType", "setSubtitleType", "getSubtitleType$annotations", "subtitleType", "getActivateStatus", "setActivateStatus", "getActivateStatus$annotations", "activateStatus", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q2 extends vh7.c<q2> {
    public static final int ActivateStatusOpen = 1;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106954a = null;

        public a() {
        }

        static {
            f106954a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106954a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activate_status")
    int getActivateStatus();

    @FieldName(name = "subtitle_style")
    int getSubtitleStyle();

    @FieldName(name = "subtitle_type")
    int getSubtitleType();

    @FieldName(name = "x")
    double getX();

    @FieldName(name = "y")
    double getY();

    @FieldName(name = "activate_status#setter")
    void setActivateStatus(int r100);

    @FieldName(name = "subtitle_style#setter")
    void setSubtitleStyle(int r100);

    @FieldName(name = "subtitle_type#setter")
    void setSubtitleType(int r100);

    @FieldName(name = "x#setter")
    void setX(double r100);

    @FieldName(name = "y#setter")
    void setY(double r100);
}
