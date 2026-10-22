package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "Lvh7/c;", "", "getScene", "()I", "getScene$annotations", "()V", "scene", "", "", "getPlayModes", "()Ljava/util/List;", "getPlayModes$annotations", "playModes", "getUiLayout", "getUiLayout$annotations", "uiLayout", "getMaxMemberCount", "getMaxMemberCount$annotations", "maxMemberCount", "", "getFunctionType2", "()Ljava/lang/String;", "getFunctionType2$annotations", "functionType2", "getAnchorManualOpenUiLayout", "getAnchorManualOpenUiLayout$annotations", "anchorManualOpenUiLayout", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_manual_open_ui_layout")
    int getAnchorManualOpenUiLayout();

    @FieldName(name = "function_type")
    String getFunctionType2();

    @FieldName(name = "MaxMemberCount")
    int getMaxMemberCount();

    @FieldName(name = "play_modes")
    List<Long> getPlayModes();

    @FieldName(name = "scene")
    int getScene();

    @FieldName(name = "ui_layout")
    int getUiLayout();
}
