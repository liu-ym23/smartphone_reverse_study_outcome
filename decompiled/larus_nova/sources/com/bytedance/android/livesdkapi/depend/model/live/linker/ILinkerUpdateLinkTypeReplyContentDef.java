package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContentDef;", "", "prompts", "", "getPrompts$annotations", "()V", "getPrompts", "()Ljava/lang/String;", "replyType", "", "getReplyType$annotations", "getReplyType", "()I", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerUpdateLinkTypeReplyContentDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "reply_prompts")
        public static /* synthetic */ void getPrompts$annotations() {
        }

        @FieldName(name = "reply_type")
        public static /* synthetic */ void getReplyType$annotations() {
        }
    }

    String getPrompts();

    int getReplyType();
}
