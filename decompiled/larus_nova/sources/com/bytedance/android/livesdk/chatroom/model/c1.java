package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface c1 extends vh7.c<c1> {
    public static final String TAG_AGE = "age";
    public static final String TAG_CHALLENGE = "challenge";
    public static final String TAG_GENDER = "gender";
    public static final String TAG_LOCATION = "location";

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "tag_name")
    String getTagName();

    @FieldName(name = "value")
    String getValue();
}
