package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewPromotion;", "Lvh7/c;", "", "Lpy/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAvatarIcons", "()Ljava/util/List;", "getAvatarIcons$annotations", "()V", "avatarIcons", "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "getComments", "getComments$annotations", "comments", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewPromotion extends c<IPreviewPromotion> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "avatar_icons")
        public static /* synthetic */ void getAvatarIcons$annotations() {
        }

        @FieldName(name = "fast_comments")
        public static /* synthetic */ void getComments$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getText$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "avatar_icons")
    List<k> getAvatarIcons();

    @FieldName(name = "fast_comments")
    List<String> getComments();

    @FieldName(name = "text")
    String getText();
}
