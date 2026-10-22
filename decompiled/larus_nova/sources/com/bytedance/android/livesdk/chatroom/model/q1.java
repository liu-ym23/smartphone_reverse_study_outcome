package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface q1 extends vh7.c<q1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "app_id")
    String getAppId();

    @FieldName(name = "interact_type")
    int getInteractType();

    @FieldName(name = "interactive_screen_cast")
    boolean isInteractiveScreenCast();

    @FieldName(name = "app_id")
    void setAppId(String r100);

    @FieldName(name = "interact_type")
    void setInteractType(int r100);

    @FieldName(name = "interactive_screen_cast")
    void setInteractiveScreenCast(boolean r100);
}
