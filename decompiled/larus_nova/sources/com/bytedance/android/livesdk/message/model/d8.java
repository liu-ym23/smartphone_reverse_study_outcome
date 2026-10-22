package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface d8 extends vh7.c<d8> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "body_text")
    String getBodyText();

    @FieldName(name = "conversation_id")
    String getConversationID();

    @FieldName(name = "group_id")
    Long getConversationShortID();

    @FieldName(name = "group_type")
    int getGroup_type();

    @FieldName(name = "guide_source")
    int getGuide_source();

    @FieldName(name = "header_text")
    String getHeaderText();

    @FieldName(name = "icons")
    List<py.k> getIconsList();
}
